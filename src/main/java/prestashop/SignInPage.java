package prestashop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    @FindBy (css = "[data-link-action='display-register-form']")
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
        //wait.until(ExpectedConditions.visibilityOf(createAccountButton));
        createAccountButton.click();
    }

}
