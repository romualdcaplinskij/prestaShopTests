package prestashop;

import org.openqa.selenium.JavascriptExecutor;
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
        createAccountButton.click();
    }

    public String getEmptyValidationMessageEmail(){
        // Use JavaScript to get the content of the ::after pseudo-element
        WebElement errorDiv = emailField;
        if (errorDiv == null) {
            return "Error element not found";
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String content =  (String) js.executeScript(
                "return window.getComputedStyle(arguments[0], '::after').getPropertyValue('content');", errorDiv);
        if (content == null || content.isEmpty() || "none".equals(content)) {
            return "No validation message found";
        }
        return "No validation message found";
    }

    public String getEmptyValidationMessagePassword(){
        // Use JavaScript to get the content of the ::after pseudo-element
        WebElement errorDiv = passwordField;
        if (errorDiv == null) {
            return "Error element not found";
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String content =  (String) js.executeScript(
                "return window.getComputedStyle(arguments[0], '::after').getPropertyValue('content');", errorDiv);
        if (content == null || content.isEmpty() || "none".equals(content)) {
            return "No validation message found";
        }
        return "No validation message found";
    }

}
