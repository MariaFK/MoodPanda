package tests;

import constants.Credentials;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MainPage;

public class UpdateLastNameInitialTest extends BaseTest{

    private static final Logger LOGGER = LogManager.getLogger(UpdateLastNameInitialTest.class.getName());

    @Test
    public void updateFirstNameTest() {
        LoginPage loginPage = new LoginPage();
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.info("Attempt to send username and password");
        loginPage.login(Credentials.USERNAME, Credentials.PASSWORD);
        LOGGER.info(String.format("Page %s initialized", MainPage.class.getName()));
        MainPage mainPage = new MainPage();
        LOGGER.info("Attempt to open dashboard and update last name initial");
        mainPage.openDashboard().updateLastNameInitial();
        LOGGER.info(String.format("Page %s initialized", DashboardPage.class.getName()));
        DashboardPage dashboardPage = new DashboardPage();
        LOGGER.info("Checked if last name initial is changed");
        Assert.assertEquals(dashboardPage.currentName(), "Masha S", "The last name initial isn't changed");
    }
}
