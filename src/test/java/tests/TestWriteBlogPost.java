package tests;

import de.svenjacobs.loremipsum.LoremIpsum;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebElement;
import pageobjects.AdminNavBar;
import pageobjects.Login;
import pageobjects.PostEdit;
import tests.groups.Deep;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;

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
        String postTitle = String.format("Test Post %d",
                new Random().ints(1, 10000).findFirst().getAsInt());
        String postText = loremIpsum.getParagraphs(5);
        List<WebElement> searchResults;

        navbar.startNewPost();
        blogpost.WritePostTitle(postTitle);
        blogpost.WritePost(postText);
        blogpost.PublishPost();
        searchResults = navbar.searchForPost(postTitle);
        assertTrue("post title not in search results",
                navbar.searchContainsPostTitle(postTitle, searchResults));
    }

}
