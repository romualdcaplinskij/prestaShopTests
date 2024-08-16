package prestashop;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressesPage extends BasePage{
    public AddressesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (css = "article[role='alert']  li")
    WebElement successAlert;

    @FindBy (css = ".address-footer > a:nth-of-type(1)")
    WebElement updateAddressButton;

    @FindBy (css = ".address-footer > a:nth-of-type(2)")
    WebElement deleteAddressButton;

    @FindBy (css = "[data-link-action='add-address']")
    WebElement createNewAddressButton;

    @FindBy (css = ".hidden-sm-down.logout")
    WebElement signOutButton;

    public void clickLogout(){
        signOutButton.click();
    }

    public void deleteAddress(){
        deleteAddressButton.click();
    }

    public String getSuccessAlert(){
        return successAlert.getText();
    }


}
