package tests;


import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import pageobjects.*;
import tests.groups.Shallow;

import static org.junit.Assert.assertTrue;

/**
 * Created by dnewman on 12/10/16.
 */
public class TestAdminNavBar extends Base {
   private Login login;
   private AdminNavBar adminNavBar;
   private AdminGeneralSettings adminGeneralSettings;
   private AdminNavigationSettings adminNavigationSettings;
   private AdminTagsSettings adminTagsSettings;
   private AdminCodeInjectionSettings adminCodeInjectionSettings;
   private AdminAppsSettings adminAppsSettings;
   private AdminLabsSettings adminLabsSettings;

   @Before
   public void setUp() {
       login = new Login(driver);
       adminNavBar = new AdminNavBar(driver);
       adminGeneralSettings = new AdminGeneralSettings(driver);
       adminNavigationSettings = new AdminNavigationSettings(driver);
       adminTagsSettings = new AdminTagsSettings(driver);
       adminCodeInjectionSettings = new AdminCodeInjectionSettings(driver);
       adminAppsSettings = new AdminAppsSettings(driver);
       adminLabsSettings = new AdminLabsSettings(driver);

       login.with("dwnewman78@gmail.com", "newp6397");
   }

   @Category(Shallow.class)
   @Test
   public void navigateGeneralSettings() {
       adminNavBar.visitGeneralSettings();
       assertTrue("Unable to navigate to general settings",
               adminGeneralSettings.generalSettingsPagePresent());

   }


}
