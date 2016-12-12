package tests;

import de.svenjacobs.loremipsum.LoremIpsum;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import pageobjects.AdminContent;
import pageobjects.AdminNavBar;
import pageobjects.Login;
import pageobjects.PostEdit;
import tests.groups.Deep;

import static org.junit.Assert.assertTrue;

/**
 * Created by dnewman on 12/11/16.
 */
@Category(Deep.class)
public class TestUpdateBlogPost extends Base {

    private AdminNavBar navbar;
    private PostEdit blogpost;
    private Login login;
    private AdminContent contentpage;
    private LoremIpsum loremIpsum;

    @Before
    public void setUp() {
        login = new Login(driver);
        navbar = new AdminNavBar(driver);
        blogpost = new PostEdit(driver);
        contentpage = new AdminContent(driver);
        loremIpsum = new LoremIpsum();
        login.with("dwnewman78@gmail.com", "newp6397");
        navbar.viewContent();
    }

    @Test
    public void UpdateTopBlogPost() {
        contentpage.EditPost();
        blogpost.WritePostTitle("Update");
        blogpost.ClearPostText();
        blogpost.WritePost(loremIpsum.getParagraphs(3));
        blogpost.UpdatePost();
        assertTrue("content update notification not present", contentpage.ContentUpdateNotificationPresent());
    }


}
