package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by dnewman on 12/9/16.
 */
public class AdminNavBar extends Base {

    By newPostButton = By.className("gh-nav-main-editor");
    By contentButton = By.className("gh-nav-main-content");
    By teamButton = By.className("gh-nav-main-users");
    By generalButton = By.className("gh-nav-settings-general");
    By navigationButton = By.className("gh-nav-settings-navigation");
    By tagsButton = By.className("gh-nav-settings-tags");
    By codeInjectionButton = By.className("gh-nav-settings-code-injection");
    By appsButton = By.className("gh-nav-settings-apps");
    By labsButton = By.className("gh-nav-settings-labs");

    public AdminNavBar(WebDriver driver) {
        super(driver);
    }

    public void startNewPost() { click(newPostButton, 10); }

    public void viewContent() { click(contentButton, 10); }

    public void visitTeamPage() { click(teamButton, 10); }

    public void visitGeneralSettings() {
        click(generalButton, 10);
    }

    public void visitNavigationSettings() {
        click(navigationButton, 10);
    }

    public void visitTagsSettings() {
        click(tagsButton, 10);
    }

    public void visitCodeInjectionSettings() {
        click(codeInjectionButton, 10);
    }

    public void visitAppsSettings(){
        click(appsButton, 10);
    }

    public void visitLabsSettings(){
        click(labsButton, 10);
    }
}
