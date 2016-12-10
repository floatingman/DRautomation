package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by dnewman on 12/10/16.
 */
public class AdminCodeInjectionSettings extends Base {
    public AdminCodeInjectionSettings(WebDriver driver) {
        super(driver);
    }

    By onPage = By.id("settings-code");

    public boolean codeinjectionSettingsPagePresent() {
        return isDisplayed(onPage, 10);
    }
}
