package tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import pageobjects.AdminContent;
import pageobjects.Login;
import tests.groups.Deep;

import static org.junit.Assert.assertTrue;

/**
 * Created by dnewman on 12/9/16.
 */
@Category(Deep.class)
public class TestAdminContent extends Base {

    private AdminContent adminContent;
    private Login login;

    @Before
    public void setUp() {
        login = new Login(driver);
        adminContent = new AdminContent(driver);
    }

    @Test
    public void startNewPost() {
        login.with("dwnewman78@gmail.com", "newp6397");
        adminContent.startNewPost();
        assertTrue("a new post was not started", adminContent.newPostPagePresent());
    }

}
