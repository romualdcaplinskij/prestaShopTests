package prestashop;

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


}
