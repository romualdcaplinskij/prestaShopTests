package prestashop;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = "[for='field-id_gender-1'] [type]")
    WebElement radioButtonMr;

    @FindBy (css = "[for='field-id_gender-2'] [type]")
    WebElement radioButtonMrs;

    @FindBy (css = "#field-firstname")
    WebElement firstNameField;

    @FindBy (css = "#field-lastname")
    WebElement lastNameField;

    @FindBy (css = "#field-email")
    WebElement emailField;

    @FindBy (css = ".input-group-btn [type]")
    WebElement showPasswordButton;

    @FindBy (css = "#field-password")
    WebElement passwordField;

    @FindBy (css = "#field-birthday")
    WebElement birthDateField;

    @FindBy (css = "input[name='optin']")
    WebElement receiveOffersCheckbox;

    @FindBy (css = "input[name='psgdpr']")
    WebElement termsAndCondCheckbox;

    @FindBy (css = "input[name='newsletter']")
    WebElement signForNewsletterCheckbox;

    @FindBy (css = "input[name='customer_privacy']")
    WebElement dataPrivacyAgreementCheckbox;

    @FindBy (css = ".btn.btn-primary.float-xs-right.form-control-submit")
    WebElement saveFormButton;


    public void chooseSocialTitleMr(){
        radioButtonMr.click();
    }

    public void chooseSocialTitleMrs(){
        radioButtonMrs.click();
    }

    public void enterFirstName(String firstname){
        firstNameField.sendKeys(firstname);
    }

    public void enterLastName(String lastname){
        lastNameField.sendKeys(lastname);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword (String password){
        passwordField.sendKeys(password);
    }

    public void pressShowPassword(){
        showPasswordButton.click();
    }

    public void enterBirthDate(String birthdate){
        //birthday format mm/dd/yyyy
        birthDateField.sendKeys(birthdate);
    }

    public void checkReceiveOffers() {
        receiveOffersCheckbox.click();
    }

    public void checkTermsAndCond(){
        termsAndCondCheckbox.click();
    }

    public void checkSignForNewsletter(){
        signForNewsletterCheckbox.click();
    }

    public void checkPrivacyAgreement(){
        dataPrivacyAgreementCheckbox.click();
    }

    public void clickSaveForm(){
        saveFormButton.click();
    }



}
