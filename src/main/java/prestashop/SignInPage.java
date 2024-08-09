package prestashop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = "#field-email")
    WebElement emailField;

    @FindBy (css = "#field-password")
    WebElement passwordField;

    @FindBy (css = ".input-group-btn [type]")
    WebElement showPasswordButton;

    @FindBy (css = "#submit-login")
    WebElement signInButton;

    @FindBy (linkText = "No account? Create one here")
    WebElement createAccountButton;

    public void enterEmail (String email){
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSigIn(){
        signInButton.click();
    }

    public void clickCreateAccount() {
        createAccountButton.click();
    }

}
