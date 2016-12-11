package tests;

import com.saucelabs.saucerest.SauceREST;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

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
            }
        }

        @Override
        protected void after() {
            driver.quit();
        }
    };
}
