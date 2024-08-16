package prestashop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    int iterator;

    @FindBy(css = ".user-info .hidden-sm-down")
    WebElement signInButton;

    @FindBy (linkText = "CLOTHES")
    WebElement clothesPageLink;

    @FindBy (linkText = "ACCESSORIES")
    WebElement accessoriesPageLink;

    @FindBy (linkText = "ART")
    WebElement artPageLink;

    @FindBy (css = "[title] .hidden-sm-down")
    WebElement registeredUserNameAndLastname;

    @FindBy (css = ".hidden-sm-down.logout")
    WebElement logoutButton;


    @FindBy (css = ".products.row [class='js-product product col-xs-12 col-sm-6 col-lg-4 col-xl-3'] " +
            ".wishlist-button-add")
    List<WebElement> wishlistAddButton;


    public void clickUserProfile(){
        registeredUserNameAndLastname.click();
    }


    public void iterateAndClickProductCard(int iterator){
        String cssSelector = ".products.row [data-id-product='"+ iterator + "']";
        WebElement productCard = driver.findElement(By.cssSelector(cssSelector));
        productCard.click();
    }


    public void clickLogout(){
        logoutButton.click();
    }

    public String getLoggedUserNameAndLastname() {
        wait.until(ExpectedConditions.visibilityOf(registeredUserNameAndLastname));
     return registeredUserNameAndLastname.getText();
    }
    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }

    public void clickClothesLink(){
        wait.until(ExpectedConditions.elementToBeClickable(clothesPageLink));
        clothesPageLink.click();
    }

    public void clickAccessoriesLink() {
        wait.until(ExpectedConditions.elementToBeClickable(accessoriesPageLink));
        accessoriesPageLink.click();
    }

    public void clickArtLink() {
        wait.until(ExpectedConditions.elementToBeClickable(artPageLink));
        artPageLink.click();
    }


}
