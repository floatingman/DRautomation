package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by dnewman on 12/11/16.
 */
public class HomePage extends Base {

    By menuButton = By.className("menu-button");
    By homeButton = By.className("nav-home");
    By postTitle = By.className("post-title");
    By onPage = By.className("home-template");

    public HomePage(WebDriver driver) {
        super(driver);
        visit("/");
    }

    public List<WebElement> GetPosts() {
        return findAll(postTitle); }

    public void GoHome() {
        click(menuButton, 10);
        click(homeButton,10);
    }

    public Boolean OnPage() { return isDisplayed(onPage, 10); }

}
