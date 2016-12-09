package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

/**
 * Created by dnewman on 12/8/16.
 */
public class Login extends Base {


    By loginFormLocator = By.id("login");
    By usernameLocator = By.className("email");
    By passwordLocator = By.className("password");
    By submitButton = By.className("login");
    By successMessageLocator = By.className("gh-view");
    By failureMessageLocator = By.className("main-error");


    public Login(WebDriver driver) {
        super(driver);
        visit("http://interview25.dev.digitalreasoning.com/ghost/signin/");
        assertTrue("The login form is not present", isDisplayed(loginFormLocator));
    }

    public void with(String email, String password) {
        type(email, usernameLocator);
        type(password, passwordLocator);
        click(submitButton);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Boolean successMessagePresent() {
        return isDisplayed(successMessageLocator);
    }

    public Boolean failureMessagePresent() {
        return isDisplayed(failureMessageLocator);
    }
}
