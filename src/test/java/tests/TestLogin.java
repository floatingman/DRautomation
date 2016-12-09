package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobjects.Login;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by dnewman on 12/8/16.
 */
public class TestLogin {

    private WebDriver driver;
    private Login login;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver",
                System.getProperty("user.dir") + "/vendor/geckodriver");
        driver = new FirefoxDriver();
        login = new Login(driver);
    }

    @Test
    public void succeeded() {
        login.with("dwnewman78@gmail.com", "newp6397");
        assertTrue("success message not present", login.successMessagePresent());
    }

    @Test
    public void failed() {
        login.with("dwnewman78@gmail.com", "badpassword");
        assertFalse("failure message wasn't present after providing bogus credentials", login.successMessagePresent());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
