package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by dnewman on 12/10/16.
 */
public class AdminLabsSettings extends Base {

    By onPage = By.className("settings-debug");

    public AdminLabsSettings(WebDriver driver) {
        super(driver);
    }

    public boolean labsSettingsPagePresent() {
        return isDisplayed(onPage, 10);
    }
}
