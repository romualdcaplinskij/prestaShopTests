package prestashop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public Duration pageLoadTimeout() {
        return driver.manage().timeouts().getPageLoadTimeout();
    }

}
