package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by dnewman on 12/10/16.
 */
public class AdminGeneralSettings extends Base {

    By onPage = By.id("settings-general");

    public AdminGeneralSettings(WebDriver driver) {
        super(driver);
    }

    public Boolean generalSettingsPagePresent() {
        return isDisplayed(onPage, 10);
    }
}
