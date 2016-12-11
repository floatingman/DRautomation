package tests;

import de.svenjacobs.loremipsum.LoremIpsum;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import pageobjects.AdminNavBar;
import pageobjects.Login;
import pageobjects.PostEdit;
import tests.groups.Deep;

import java.util.Random;

/**
 * Created by dnewman on 12/10/16.
 */
@Category(Deep.class)
public class TestWriteBlogPost extends Base {

    private AdminNavBar navbar;
    private PostEdit blogpost;
    private Login login;
    private LoremIpsum loremIpsum;

    @Before
    public void setUp() {
        login = new Login(driver);
        navbar = new AdminNavBar(driver);
        blogpost = new PostEdit(driver);
        loremIpsum = new LoremIpsum();
        login.with("dwnewman78@gmail.com", "newp6397");
    }

    @Test
    public void CreateNewPostTest() {
        navbar.startNewPost();

        blogpost.WritePostTitle(String.format("Test Post %d", new Random().ints(1, 10000).findFirst().getAsInt()));
        blogpost.WritePost(loremIpsum.getParagraphs(5));
        blogpost.PublishPost();
    }

}
