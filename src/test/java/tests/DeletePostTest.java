package tests;

import constants.Credentials;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MainPage;

public class DeletePostTest extends BaseTest{

    private static final Logger LOGGER = LogManager.getLogger(DeletePostTest.class.getName());

    @BeforeMethod
    public void CreatePost(){
        LoginPage loginPage = new LoginPage();
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.info("Attempt to send username and password");
        loginPage.login(Credentials.USERNAME, Credentials.PASSWORD);
        LOGGER.info(String.format("Page %s initialized", MainPage.class.getName()));
        MainPage mainPage = new MainPage();
        LOGGER.info("Attempt to add post");
        mainPage.openDashboard().addPost();
    }

    @Test
    public void deletePostTest(){
        DashboardPage dashboardPage = new DashboardPage();
        LOGGER.info(String.format("Page %s initialized", DashboardPage.class.getName()));
        LOGGER.info("Checked if post is deleted");
        boolean isPostDeleted = dashboardPage.deletePost().isPostDeleted();
        Assert.assertFalse(isPostDeleted, "Post isn't deleted");
    }



}
