package prestashop;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Map;

public class RegisterTest extends TestSetup{

    private static final String CSV_FILE_PATH = "src/test/resources/validUserData.csv";
    private final FakerUserDataGenerator userDataGenerator = new FakerUserDataGenerator();
    private final Map<String, String> userData = userDataGenerator.generateUserDataToMap();

    @Test (priority = 1)
    public void registerValidUser() throws IOException, InterruptedException {
        /*takes user data from FakerUserDataGenerator class. Runs registration test and saves valid
        user credentials to CSV file, that can be used for login tests*/
        userDataGenerator.saveUserDataToCSV(userData, CSV_FILE_PATH);

        homePage.clickSignIn();
        signInPage.clickCreateAccount();
        registerPage.chooseSocialTitleMr();
        registerPage.enterFirstName(userData.get("firstname"));
        System.out.println(userData.get("firstname"));
        registerPage.enterLastName(userData.get("lastname"));
        System.out.println(userData.get("lastname"));
        registerPage.enterEmail(userData.get("email"));
        System.out.println(userData.get("email"));
        registerPage.enterPassword(userData.get("password"));
        System.out.println(userData.get("password"));
        registerPage.enterBirthDate(userData.get("birthdate"));
        System.out.println(userData.get("birthdate"));
        registerPage.checkTermsAndCond();
        registerPage.checkPrivacyAgreement();
        registerPage.clickSaveForm();
        //checks after successfully registration checks if Homepage displays same name and last name used to register.
        Assert.assertEquals(homePage.getLoggedUserNameAndLastname(),userData.get("firstname") + " " + userData.get("lastname"),
                 "Registered user name doesn't match");
    }

    @Test (priority = 2)
    public void failTestRegisterValidUser() throws InterruptedException {
        /*takes user data from FakerUserDataGenerator class. Runs registration test and intentionally fails.
          To test if all functionality is working*/

        homePage.clickSignIn();
        signInPage.clickCreateAccount();
        registerPage.chooseSocialTitleMr();
        registerPage.enterFirstName(userData.get("firstname"));
        System.out.println(userData.get("firstname"));
        registerPage.enterLastName(userData.get("lastname"));
        System.out.println(userData.get("lastname"));
        registerPage.enterEmail(userData.get("email"));
        System.out.println(userData.get("email"));
        registerPage.enterPassword(userData.get("password"));
        System.out.println(userData.get("password"));
        registerPage.enterBirthDate(userData.get("birthdate"));
        System.out.println(userData.get("birthdate"));
        registerPage.checkTermsAndCond();
        registerPage.checkPrivacyAgreement();
        registerPage.clickSaveForm();

        //checks after successfully registration checks if Homepage displays same name and last name used to register.
        Assert.assertEquals(userData.get("lastname") + " " + userData.get("firstname"),
                homePage.getLoggedUserNameAndLastname(), "Registered user name doesn't match");
    }




    @Test (priority = 3)
    public void checkAlertIfFirstNameIsEmpty() throws InterruptedException {
        homePage.clickSignIn();
        signInPage.clickCreateAccount();
        registerPage.chooseSocialTitleMr();
        registerPage.enterFirstName("");
        System.out.println(userData.get("Empty space"));
        registerPage.enterLastName(userData.get("lastname"));
        System.out.println(userData.get("lastname"));
        registerPage.enterEmail(userData.get("email"));
        System.out.println(userData.get("email"));
        registerPage.enterPassword(userData.get("password"));
        System.out.println(userData.get("password"));
        registerPage.enterBirthDate(userData.get("birthdate"));
        System.out.println(userData.get("birthdate"));
        registerPage.checkTermsAndCond();
        registerPage.checkPrivacyAgreement();
        registerPage.clickSaveForm();

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

        //check if user is not logged in.
        Assert.assertNotEquals(userData.get("firstname") + " " + userData.get("lastname"),
                homePage.getLoggedUserNameAndLastname(), "Registered user name doesn't match");
    }
}
