package prestashop;

import org.testng.annotations.Test;

public class HomePageTests extends TestSetup{

    @Test
    public void clickSignIn(){
        homePage.clickSignIn();
        System.out.println(homePage.pageLoadTimeout());
    }

}
