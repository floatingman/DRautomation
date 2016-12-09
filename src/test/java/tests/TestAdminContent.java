package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobjects.AdminContent;
import pageobjects.Login;

import static org.junit.Assert.assertTrue;

/**
 * Created by dnewman on 12/9/16.
 */
public class TestAdminContent {

    private WebDriver driver;
    private AdminContent adminContent;
    private Login login;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/vendor/geckodriver");
        driver = new FirefoxDriver();
        login = new Login(driver);
        adminContent = new AdminContent(driver);
    }

    @Test
    public void startNewPost() {
        login.with("dwnewman78@gmail.com", "newp6397");
        adminContent.startNewPost();
        assertTrue("a new post was not started", adminContent.newPostPagePresent());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
