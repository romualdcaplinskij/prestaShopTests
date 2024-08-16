package prestashop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserAccount extends BasePage{

    public UserAccount(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = "#wishlist-link")
    WebElement wishlistButton;

    @FindBy (css = "#address-link")
    WebElement addFirstAddressButton;

    @FindBy (css = "#identity-link")
    WebElement userInformation;

    @FindBy (css = "#history-link")
    WebElement orderHistoryButton;

    @FindBy (css = "#order-slips-link")
    WebElement creditSlipsButton;

    @FindBy (css = "#psgdpr-link")
    WebElement personalDataButton;

    @FindBy (css = "#emailsalerts")
    WebElement userAlertsButton;

    public void clickMyAllerts(){
        userAlertsButton.click();
    }

    public void clickPersonalData(){
        personalDataButton.click();
    }

    public void clickCreditSlips(){
        creditSlipsButton.click();
    }

    public void clickOrderHistory(){
        orderHistoryButton.click();
    }

    public void clickUserInformation(){
        userInformation.click();
    }

    public void clickAddFirstAdress(){
        addFirstAddressButton.click();
    }

    public void clickWishlist(){
        wishlistButton.click();
    }
}
