package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    private static final Logger LOGGER = LogManager.getLogger(DashboardPage.class.getName());

    private SelenideElement DROPDOWN_RATING_OPTION_LIST = $(By.xpath("(//table[contains(@class,'is-hidden-mobile')]//div[@class='select']//select)[1]"));

    private SelenideElement RATING_OPTION6 = $(By.xpath("(//table[contains(@class,'is-hidden-mobile')]//div[@class='select']//select)[1]"));

    private SelenideElement POST_AREA = $(By.xpath("//td[@class='wrap']//textarea"));

    private SelenideElement ADD_POST_BUTTON = $(By.xpath("//table[contains(@class,'is-hidden-mobile')]//div[@class='buttons']//button"));

    private SelenideElement DELETE_POST_BUTTON = $(By.xpath("//table[contains(@class,'is-hidden-mobile')]//div[@class='buttons']//button[2]"));

    private SelenideElement EDIT_PROFILE_BUTTON = $(By.xpath("//aside[contains(@class,'is-hidden-touch')]//ul[@class='menu-list']//a[@href='/dashboard/editprofile']"));

    private SelenideElement FIRST_NAME_INPUT = $(By.xpath("//div[@class='field'][1]//div[@class='control']//input"));

    private SelenideElement LAST_NAME_INITIAL = $(By.xpath("//div[@class='field'][2]//div[@class='control']//input"));

    private SelenideElement SAVE_IDENTITY_BUTTON = $(By.xpath("//div[@class='bosx']//div[@class='field']//div[@class='control']//button"));

    private SelenideElement CURRE_MEMBER_NAME = $(By.xpath("//div[@class='field'][1]//div[@class='media-content']//p[1]"));

    public DashboardPage addPost(){
        LOGGER.debug(String.format("Attempt to click element: %s", DROPDOWN_RATING_OPTION_LIST));
        DROPDOWN_RATING_OPTION_LIST.click();
        LOGGER.debug(String.format("Attempt to select element: %s", RATING_OPTION6));
        RATING_OPTION6.selectOption("6");
        LOGGER.debug("Attempt to write post: %s");
        POST_AREA.sendKeys("Test post");
        LOGGER.debug(String.format("Attempt to click element: %s", ADD_POST_BUTTON));
        ADD_POST_BUTTON.click();
        return this;
    }

    public DashboardPage deletePost(){
        LOGGER.debug(String.format("Attempt to click element: %s", DELETE_POST_BUTTON));
        DELETE_POST_BUTTON.click();
        return this;
    }

    public boolean isPostDeleted(){
        LOGGER.debug("Check if delete post button is visible");
        DELETE_POST_BUTTON.shouldNotBe(Condition.visible, Duration.ofSeconds(5));
            return DELETE_POST_BUTTON.isDisplayed();
        }

    public DashboardPage updateFirstName(){
        LOGGER.debug(String.format("Attempt to click element: %s", EDIT_PROFILE_BUTTON));
        EDIT_PROFILE_BUTTON.click();
        LOGGER.debug(String.format("Attempt to clear element: %s", FIRST_NAME_INPUT));
        FIRST_NAME_INPUT.clear();
        LOGGER.debug(String.format("Attempt to sent keys: %s", "Masha"));
        FIRST_NAME_INPUT.sendKeys("Masha");
        LOGGER.debug(String.format("Attempt to clear element: %s", SAVE_IDENTITY_BUTTON));
        SAVE_IDENTITY_BUTTON.click();
        return this;
    }

    public String currentName(){
        LOGGER.debug(String.format("Attempt to get text of element: %s", CURRE_MEMBER_NAME));
        return CURRE_MEMBER_NAME.getText();
    }

    public DashboardPage updateLastNameInitial(){
        LOGGER.debug(String.format("Attempt to clear element: %s", EDIT_PROFILE_BUTTON));
        EDIT_PROFILE_BUTTON.click();
        LOGGER.debug(String.format("Attempt to clear element: %s", LAST_NAME_INITIAL));
        LAST_NAME_INITIAL.clear();
        LOGGER.debug(String.format("Attempt to sent keys: %s", "S"));
        LAST_NAME_INITIAL.sendKeys("S");
        LOGGER.debug(String.format("Attempt to clear element: %s", SAVE_IDENTITY_BUTTON));
        SAVE_IDENTITY_BUTTON.click();
        return this;
    }

}
