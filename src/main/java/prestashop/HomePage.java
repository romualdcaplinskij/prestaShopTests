package prestashop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".user-info .hidden-sm-down")
    private WebElement signInButton;

    @FindBy (linkText = "CLOTHES")
    private WebElement clothesPageLink;

    @FindBy (linkText = "ACCESSORIES")
    private WebElement accessoriesPageLink;

    @FindBy (linkText = "ART")
    private WebElement artPageLink;

    @FindBy (css = "[title] .hidden-sm-down")
    private WebElement registeredUserNameAndLastname;

    public String getLoggedUserNameAndLastname() {
     return registeredUserNameAndLastname.getText();
    }
    public void clickSignIn() {
        signInButton.click();
    }

    public void clickClothesLink(){
        clothesPageLink.click();
    }

    public void clickAccessoriesLink() {
        accessoriesPageLink.click();
    }

    public void clickArtLink() {
        artPageLink.click();
    }


}
