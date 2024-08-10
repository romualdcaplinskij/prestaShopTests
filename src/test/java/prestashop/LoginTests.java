package prestashop;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import prestashop.CsvDataProvider;

public class LoginTests extends TestSetup{

    @Test(dataProvider = "randomLoginData", dataProviderClass = CsvDataProvider.class)
    public void loginValidUser(String firstName, String lastName, String email, String password) {
        System.out.println("Testing login with: " + email + " / " + password);

        // Simulate the login process
        homePage.clickSignIn();

        signInPage.enterEmail(email);
        signInPage.enterPassword(password);
        signInPage.clickSigIn();

        String expectedUserName = firstName + " " + lastName;
        // Assertion to verify the logged-in user's name
        Assert.assertEquals(homePage.getLoggedUserNameAndLastname(), expectedUserName, "The logged-in user's name should match the expected name.");
    }

    @Test(dataProvider = "randomLoginData", dataProviderClass = CsvDataProvider.class)
    public void loginIfEmailIsEmpty(String firstName, String lastName, String email, String password) {
        System.out.println("Testing login with: " + email + " / " + password);

        // Simulate the login process
        homePage.clickSignIn();

        signInPage.enterEmail("");
        signInPage.enterPassword(password);
        signInPage.clickSigIn();

        try {
            alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertMessage = alert.getText();
            alert.dismiss();
            //check if alert is present if field is empty
            softAssert.assertEquals(alertMessage,"Please fill out this field.", "\n Alerts doesn't match");
            softAssert.assertAll();
        } catch (TimeoutException e) {
            System.out.println("\n Expected alert not found");
        }

        String expectedUserName = firstName + " " + lastName;
        // Assertion to verify the logged-in user's name
        Assert.assertEquals(homePage.getLoggedUserNameAndLastname(), expectedUserName, "The logged-in user's name should match the expected name.");
    }



}
