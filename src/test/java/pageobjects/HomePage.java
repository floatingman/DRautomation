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
    By postTitle = By.className("post-title");

    public HomePage(WebDriver driver) {
        super(driver);
        visit("/");
    }

    public List<WebElement> GetPosts() {
        return findAll(postTitle); }

}
