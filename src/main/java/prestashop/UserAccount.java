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

    public void clickWishlist(){
        wishlistButton.click();
    }
}
