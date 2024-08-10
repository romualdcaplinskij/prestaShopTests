package prestashop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

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
