package prestashop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishlistPage extends BasePage{
    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = ".wishlist-list-item")
    WebElement myWishlist;

    @FindBy (css = ".wishlist-product > .wishlist-product-link  .wishlist-product-title")
    List<WebElement> listOfProductNamesInWishlist;

    @FindBy (css = "li:nth-of-type(1) > .wishlist-product > .wishlist-product-bottom > .wishlist-button-add > .material-icons")
    WebElement removeFirstItemFromWishlist;

    @FindBy (css = ".wishlist-delete > div[role='dialog'] > div[role='document'] .btn.btn-primary")
    WebElement modalRemovalConfirmation;

    @FindBy (css = ".hidden-sm-down.logout")
    WebElement logoutButton;

    public void clickLogout(){
        logoutButton.click();
    }

    public void clickModalRemovalConfirmation(){
        modalRemovalConfirmation.click();
    }

    public void clickRemoveFirstItemFromWishlist(){
        removeFirstItemFromWishlist.click();
    }

    public List<String> getProductNamesInWishlist(){
        return listOfProductNamesInWishlist.stream()
                .map(WebElement::getText)
                .map(String::toLowerCase)
                .sorted()
                .toList();
    }

    public void clickMyWishlist(){
        myWishlist.click();
    }

    public void removeAllItemsFromWishlist(){
        while(!getProductNamesInWishlist().isEmpty()){
            clickRemoveFirstItemFromWishlist();
            clickModalRemovalConfirmation();
            driver.navigate().refresh();
        }
    }
}
