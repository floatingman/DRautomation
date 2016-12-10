package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by dnewman on 12/9/16.
 */
public class AdminContent extends Base {

    By newPostButton = By.className("btn-green");
    By newEntry = By.id("entry-title");

    public AdminContent(WebDriver driver) {
        super(driver);
    }

    public void startNewPost() {
            click(newPostButton, 5);
    }

    public Boolean newPostPagePresent() {
        return isDisplayed(newEntry, 10);
    }

}
