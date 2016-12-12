package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by dnewman on 12/10/16.
 */
public class PostEdit extends Base {

    By postTitle = By.id("entry-title");
    By postText = By.className("ember-text-area");
    By saveDraftButton = By.className("post-save-draft");
    By toggleDropdownButton = By.className("dropdown-toggle");
    By publishButton = By.className("post-save-publish");
    By publishNowButton = By.className("js-publish-button");
    By deletePostButton = By.xpath("//*/li[contains(@class,'delete')][2]");
    By deleteConfirmationButton = By.className("btn-red");
    By postSettingsButton = By.className("post-settings");
    By postSettingsClose = By.className("close");
    By postSettingsAddImageButton = By.className("upload-form");
    By postSettingSlug = By.className("post-setting-slug");
    By postSettingPreviewSlug = By.className("post-view-link");
    By postSettingDate = By.className("post-setting-date");
    By postSettingTags = By.id("tag-input-selectized");
    By postSettingAuthor = By.id("author-list");
    By postSettingMetaData = By.className("nav-list-item");
    By postSettingStaticPage = By.id("static-page");
    By postSettingFeatured = By.id("featured");

    public PostEdit(WebDriver driver) {
        super(driver);
    }

    public void WritePostTitle(String title) {
        if (isDisplayed(postTitle, 10))
            type(title, postTitle);
    }

    public void WritePost(String post) {
        if (isDisplayed(postText, 10))
            type(post, postText);
    }

    public String GetPostTitle() {
        return find(postTitle).getText();
    }

    public void PublishPost() {
        click(toggleDropdownButton, 10);
        click(publishButton, 10);
        click(publishNowButton, 10);
    }

    public void DeletePost() {
        click(toggleDropdownButton, 10);
        click(deletePostButton, 10);
        click(deleteConfirmationButton, 10);
    }


    public void ClearPostText() {
        find(postText).clear();
    }

    public void UpdatePost() {
        click(publishNowButton, 10);
    }
}
