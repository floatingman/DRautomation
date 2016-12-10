package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by dnewman on 12/10/16.
 */
public class AdminNavigationSettings extends Base {
    By onPage = By.id("settings-navigation");

    public AdminNavigationSettings(WebDriver driver) {
        super(driver);
    }

    public boolean navigationSettingsPagePresent() {
        return isDisplayed(onPage, 10);
    }
}
