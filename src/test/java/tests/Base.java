package tests;

import com.saucelabs.saucerest.SauceREST;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static tests.Config.*;

/**
 * Created by dnewman on 12/9/16.
 */
public class Base {

    protected WebDriver driver;
    private String testName;
    private String sessionId;
    private SauceREST sauceClient;
    protected BrowserMobProxy proxy;

    @Rule
    public TestRule watcher = new TestWatcher() {
        @Override
        protected void starting(Description description) {
            testName = description.getDisplayName();
        }

        @Override
        protected void failed(Throwable throwable, Description description) {
            if (host.equals("saucelabs")) {
                sauceClient.jobFailed(sessionId);
                System.out.println(String.format("https://saucelabs.com/tests/%s", sessionId));
            }
        }

        @Override
        protected void succeeded(Description description) {
            if (host.equals("saucelabs")) {
                sauceClient.jobPassed(sessionId);
            }
        }
    };


    @Rule
    public ExternalResource resource = new ExternalResource() {

        @Override
        protected void before() throws Throwable {
            if (host.equals("saucelabs")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("browserName", browser);
                capabilities.setCapability("version", browserVersion);
                capabilities.setCapability("platform", platform);
                capabilities.setCapability("name", testName);
                String sauceUrl = String.format("http://%s:%s@ondemand.saucelabs.com:80/wd/hub", sauceUser, sauceKey);
                driver = new RemoteWebDriver(new URL(sauceUrl), capabilities);
                sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
                sauceClient = new SauceREST(sauceUser, sauceKey);
            } else if (host.equals("localhost")) {
                if (os.contains("linux")) {
                    if (browser.equals("firefox")) {
                        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/vendor/geckodriver_linux");
                        driver = new FirefoxDriver();
                    } else if (browser.equals("chrome")) {
                        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/vendor/chromedriver_linux");
                        driver = new ChromeDriver();
                    }
                } else if (os.contains("mac")) {
                    if (browser.equals("firefox")) {
                        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/vendor/geckodriver_mac");
                        driver = new FirefoxDriver();
                    } else if (browser.equals("chrome")) {
                        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/vendor/chromedriver_mac");
                        driver = new ChromeDriver();
                    }
                }
            } else if (host.equals("performance")) {
                proxy = new BrowserMobProxyServer();
                proxy.start(0);
                Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
                if (os.contains("linux")) {
                    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/vendor/geckodriver_linux");
                    driver = new FirefoxDriver(capabilities);

                } else if (os.contains("mac")) {
                    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/vendor/geckodriver_mac");
                    driver = new FirefoxDriver(capabilities);
                }
                proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
                proxy.newHar("ghostblog");

            }
        }

        @Override
        protected void after() {
            if (host.equals("performance")) {
                Har har = proxy.getHar();
                String harFileName = "./ghostperformancetest.har";
                File harFile = new File(harFileName);
                try {
                    har.writeTo(harFile);
                } catch (IOException ex) {
                    System.out.println(ex.toString());
                    System.out.println("Could not find file " + harFileName);
                }
                proxy.stop();
            }
            driver.quit();

        }
    };
}
