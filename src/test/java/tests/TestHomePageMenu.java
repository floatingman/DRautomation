package tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import pageobjects.HomePage;
import tests.groups.Shallow;

import static org.junit.Assert.assertTrue;

/**
 * Created by dnewman on 12/11/16.
 */
public class TestHomePageMenu extends Base {

    private HomePage homepage;

    @Before
    public void setUp() { homepage = new HomePage(driver); }

    @Test
    @Category(Shallow.class)
    public void gohome() {
        homepage.GoHome();
        assertTrue("not on the home page", homepage.OnPage() );
    }

}
