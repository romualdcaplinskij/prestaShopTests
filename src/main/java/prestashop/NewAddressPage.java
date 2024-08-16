package prestashop;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class NewAddressPage extends BasePage{
    public NewAddressPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = "#field-alias")
    WebElement aliasField;

    @FindBy (css = "#field-firstname")
    WebElement firstNameField;

    @FindBy (css = "#field-lastname")
    WebElement lastNameField;

    @FindBy (css = "#field-company")
    WebElement companyField;

    @FindBy (css = "input[name='address1']")
    WebElement addressField;

    @FindBy (css = "input[name='address2']")
    WebElement secondAddressField; //optional

    @FindBy (css = "#field-city")
    WebElement cityField;

    @FindBy (css = "#field-id_state")
    WebElement stateDropdown;

    @FindBy (css = "#field-id_state")
    List<WebElement> allStatesList;

    @FindBy (css = "#field-postcode")
    WebElement zipCodeField;

    @FindBy (css = "#field-phone")
    WebElement phoneField;

    @FindBy (css = ".form-control-submit")
    WebElement submitButton;

    @FindBy (css = "#field-id_country")
    WebElement countryDropdown;

    public void clickStateDropDown(){
        stateDropdown.click();
    }

    public List<String> getListOfStates(){
        return allStatesList.stream().map(WebElement::getText).toList();
    }

    public void clickState(String state){
        Select select = new Select(stateDropdown);
        select.selectByVisibleText(state);
    }

    public void clickCountry(String country){
        Select select = new Select(countryDropdown);
        select.selectByVisibleText(country);
    }

    public void clickSaveButton(){
        submitButton.click();
    }

    public void fillPhoneField(String phone){
        phoneField.sendKeys(phone);
    }

    public void fillZipCode(String zipCode){
        zipCodeField.sendKeys(zipCode);
    }


    public void fillCity(String city){
        cityField.sendKeys(city);
    }

    public void fillAddressField(String address){
        addressField.sendKeys(address);
    }

    public void fillCompanyField(String companyName){
        companyField.sendKeys(companyName);
    }

    public void fillAliasField(String alias){ //field is optional
        aliasField.sendKeys(alias);
    }


}
