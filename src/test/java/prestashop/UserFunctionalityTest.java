package prestashop;

import org.testng.annotations.Test;
import prestashop.CsvDataProvider;

public class UserFunctionalityTest extends TestSetup{

    @Test (dataProvider = "validEmailPasswordData", dataProviderClass = CsvDataProvider.class)
    public void wishList(String  email, String password){
        homePage.clickSignIn();
        signInPage.enterEmail(email);
        signInPage.enterPassword(password);
        signInPage.clickSigIn();

    }
}
