package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by dnewman on 12/9/16.
 */
public class AdminContent extends Base {

    By newPostButton = By.className("btn-green");
    By newEntry = By.id("entry-title");
    By postList = By.xpath("//*/li[contains(@class,'ember-view')]");
    By postEdit = By.className("post-edit");
    By updateNotification = By.className("gh-notification-close");



    public AdminContent(WebDriver driver) {
        super(driver);
    }

    public void startNewPost() {
            click(newPostButton, 10);
    }

    public List<WebElement> getPostList() {
        return findAll(postList);
    }

    public void EditPost() {
        click(postEdit, 10);
    }

    public Boolean newPostPagePresent() {
        return isDisplayed(newEntry, 10);
    }

    public Boolean ContentUpdateNotificationPresent() {
        return isDisplayed(updateNotification, 10);
    }



}
