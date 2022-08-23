package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import constants.Urls;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class.getName());

    private SelenideElement EMAIL_INPUT = $(By.xpath("//input[@type='text']"));
    private SelenideElement PASSWORD_INPUT = $(By.xpath("//input[@type='password']"));
    private SelenideElement LOGIN_BUTTON = $(By.xpath("//span[text()='Login']"));


    public MainPage login(String email, String password) {
        LOGGER.debug(String.format("Attempt to open URL of account page: %s", Urls.LOGIN_URL));
        open(Urls.LOGIN_URL);
        LOGGER.debug("Attempt to send username");
        EMAIL_INPUT.sendKeys(email);
        LOGGER.debug("Attempt to send password");
        PASSWORD_INPUT.sendKeys(password);
        LOGGER.debug("Check if login button is visible");
        LOGIN_BUTTON.shouldBe(Condition.visible, Duration.ofSeconds(5));
        LOGGER.debug("Check if login button is enabled");
        LOGIN_BUTTON.shouldBe(Condition.enabled, Duration.ofSeconds(5));
        LOGGER.debug(String.format("Attempt to click element: %s", LOGIN_BUTTON));
        LOGIN_BUTTON.click();
        return new MainPage();
    }
}
