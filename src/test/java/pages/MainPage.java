package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private static final Logger LOGGER = LogManager.getLogger(MainPage.class.getName());

    private SelenideElement POST_UPDATE_BUTTON = $(new ByText("Post update"));

    private SelenideElement HUG_BUTTON = $(By.xpath("//div[@class='card is-warning']//footer//a[contains(text(), 'Hug')]"));

    private SelenideElement HUG = $(By.xpath("//div[@class=\"container column is-8\"]//a[@href = '/user/7687297']"));

    private SelenideElement DASHDOARD = $ (new ByText("Your dashboard"));
    public boolean isPostUpdateDisplayed(){
        LOGGER.debug("Check if post update button is displayed");
        POST_UPDATE_BUTTON.shouldBe(Condition.visible, Duration.ofSeconds(5));
        return POST_UPDATE_BUTTON.isDisplayed();
    }

    public void hugButtonClick(){
        LOGGER.debug(String.format("Attempt to click element: %s", HUG_BUTTON));
        HUG_BUTTON.click();
    }

    public String isHugDisplayed(){
        LOGGER.debug(String.format("Attempt to get text of element: %s", HUG));
        return HUG.getText();

    }

    public DashboardPage openDashboard(){
        LOGGER.debug(String.format("Attempt to click element: %s", DASHDOARD));
        DASHDOARD.click();
        return new DashboardPage();
    }
}
