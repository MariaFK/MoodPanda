package tests;

import constants.Credentials;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(LoginTest.class.getName());

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.info("Checked if user logged in");
        boolean isMainPageDisplayed = loginPage
                .login(Credentials.USERNAME, Credentials.PASSWORD)
                .isPostUpdateDisplayed();
        Assert.assertTrue(isMainPageDisplayed, "User didn't log in");
    }


}
