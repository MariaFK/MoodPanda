package tests;

import constants.Credentials;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

public class SendHugTest extends BaseTest{

    private static final Logger LOGGER = LogManager.getLogger(SendHugTest.class.getName());

    @Test
    public void hugTest(){
        LoginPage loginPage = new LoginPage();
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.info("Attempt to send username and password");
        loginPage.login(Credentials.USERNAME, Credentials.PASSWORD);
        LOGGER.info(String.format("Page %s initialized", MainPage.class.getName()));
        MainPage mainPage= new MainPage();
        LOGGER.info("Click hug button");
        mainPage.hugButtonClick();
        LOGGER.info("Checked if post is hugged");
        Assert.assertEquals(mainPage.isHugDisplayed(), "Maria K", "The message isn't hugged");
    }
}
