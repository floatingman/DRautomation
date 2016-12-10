package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by dnewman on 12/10/16.
 */
public class AdminAppsSettings extends Base {

    By onPage = By.className("apps-grid");

    public AdminAppsSettings(WebDriver driver) {
        super(driver);
    }

    public boolean appsSettingsPagePresent() {
        return isDisplayed(onPage,10);
    }
}
