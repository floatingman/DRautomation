package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by dnewman on 12/10/16.
 */
public class AdminTagsSettings extends Base {
    By onPage = By.className("settings-tags");

    public AdminTagsSettings(WebDriver driver) {
        super(driver);
    }

    public boolean tagsSettingsPagePresent() {
        return isDisplayed(onPage, 10);
    }
}
