package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by dnewman on 12/9/16.
 */
public class AdminNavBar extends Base {

    By generalButton = By.className("gh-nav-settings-general");
    By navigationButton = By.className("gh-nav-settings-navigation");
    By tagsButton = By.className("gh-nav-settings-tags");
    By codeInjectionButton = By.className("gh-nav-settings-code-injection");
    By appsButton = By.className("gh-nav-settings-apps");
    By labsButton = By.className("gh-nav-settings-labs");

    public AdminNavBar(WebDriver driver) {
        super(driver);
    }

    public void visitGeneralSettings() {
        click(generalButton, 5);
    }

    public void visitNavigationSettings() {
        click(navigationButton, 5);
    }

    public void visitTagsSettings() {
        click(tagsButton, 5);
    }

    public void visitCodeInjectionSettings() {
        click(codeInjectionButton, 5);
    }

    public void visitAppsSettings(){
        click(appsButton, 5);
    }

    public void visitLabsSettings(){
        click(labsButton, 5);
    }
}
