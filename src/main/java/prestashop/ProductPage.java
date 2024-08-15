package prestashop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = ".h1")
    WebElement productName;

    @FindBy (css = ".wishlist-button-product .material-icons")
    WebElement wishlistButton;

    @FindBy (css = ".wishlist-list  p")
    WebElement choseMyWishlist;

    public void clickChoseMyWishlist(){
        choseMyWishlist.click();
    }

    public void clickWishlistButton(){
        wishlistButton.click();
    }

    public String getProductName(){
        return productName.getText();
    }

    public void addItemToAWishlist(){
        clickWishlistButton();
        driver.switchTo().activeElement();
        clickChoseMyWishlist();
    }
}
