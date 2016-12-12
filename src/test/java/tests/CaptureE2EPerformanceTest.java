package tests;

import de.svenjacobs.loremipsum.LoremIpsum;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebElement;
import pageobjects.AdminContent;
import pageobjects.AdminNavBar;
import pageobjects.Login;
import pageobjects.PostEdit;
import tests.groups.Performance;

import java.util.List;
import java.util.Random;

/**
 * Created by dnewman on 12/11/16.
 */

@Category(Performance.class)
public class CaptureE2EPerformanceTest extends Base {

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
    }

    @Test
    public void E2EPerformanceTest() {
        for (int i = 0; i < 10; i++) {
            String postTitle = String.format("Test Post %d",
                    new Random().ints(1, 10000).findFirst().getAsInt());
            String postText = loremIpsum.getParagraphs(5);
            navbar.startNewPost();
            blogpost.WritePostTitle(postTitle);
            blogpost.WritePost(postText);
            blogpost.PublishPost();

            navbar.viewContent();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            List<WebElement> blogposts = contentpage.getPostList();
            blogposts.get(0).click();
            contentpage.EditPost();
            blogpost.DeletePost();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
