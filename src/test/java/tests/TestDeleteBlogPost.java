package tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebElement;
import pageobjects.*;
import tests.groups.Deep;

import java.util.List;

import static org.junit.Assert.assertFalse;

/**
 * Created by dnewman on 12/11/16.
 */
@Category(Deep.class)
public class TestDeleteBlogPost extends Base {

    private AdminNavBar navbar;
    private PostEdit blogpost;
    private AdminContent contentpage;
    private Login login;
    private HomePage homepage;
    private List<WebElement> posts;
    private String topposttitle;

    @Before
    public void setUp() {
        homepage = new HomePage(driver);
        topposttitle = homepage.GetPosts().get(0).getText();
        login = new Login(driver);
        navbar = new AdminNavBar(driver);
        blogpost = new PostEdit(driver);
        contentpage = new AdminContent(driver);
        login.with("dwnewman78@gmail.com", "newp6397");
        navbar.viewContent();
    }

    @Test
    public void deleteTopPost() {
        List<WebElement> blogposts = contentpage.getPostList();

        if (!blogposts.isEmpty()) {
            blogposts.get(0).click();
            contentpage.editPost();
            blogpost.DeletePost();

            homepage = new HomePage(driver);
            String actualtopposttitle = homepage.GetPosts().get(0).getText();

            assertFalse("post is still visible", topposttitle.equals(actualtopposttitle));
        }
    }

}
