package prestashop;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class RegisterTest extends TestSetup{

    @Test
    public void registerValidUser(){
        FakerUserDataGenerator generator = new FakerUserDataGenerator();
        String firstName = generator.generateFirstName();
        String lastName = generator.generateLastName();
        String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@email.com";
        String user = firstName + " " + lastName;

        homePage.clickSignIn();
        signInPage.clickCreateAccount();

        registerPage.chooseSocialTitleMr();

        registerPage.enterFirstName(firstName);
        System.out.println(firstName);

        registerPage.enterLastName(lastName);
        System.out.println(lastName);

        registerPage.enterEmail(email);
        System.out.println(email);

        registerPage.enterPassword(generator.generatePassword());
        System.out.println(generator.generatePassword());

        registerPage.enterBirthDate(generator.generateBirthdate());
        System.out.println(generator.generateBirthdate());

        registerPage.checkTermsAndCond();
        registerPage.checkPrivacyAgreement();
        registerPage.clickSaveForm();

        //checks after successfully registration checks if Homepage displays same name and last name used to register.
        Assert.assertEquals(user, homePage.getLoggedUserNameAndLastname(), "Registered user name doesn't match");
    }

    @Test
    @Parameters
    public void someTest(){

    }
}
