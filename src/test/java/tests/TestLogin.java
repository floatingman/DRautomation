package tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import pageobjects.Login;
import tests.groups.Shallow;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by dnewman on 12/8/16.
 */
public class TestLogin extends Base {

    private Login login;

    @Before
    public void setUp() {
        login = new Login(driver);
    }

    @Test
    @Category(Shallow.class)
    public void succeeded() {
        login.with("dwnewman78@gmail.com", "newp6397");
        assertTrue("success message not present", login.successMessagePresent());
    }

    @Test
    @Category(Shallow.class)
    public void failed() {
        login.with("dwnewman78@gmail.com", "badpassword");
        assertFalse("failure message wasn't present after providing bogus credentials", login.successMessagePresent());
    }
}
