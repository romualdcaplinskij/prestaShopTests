package prestashop;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class UserFunctionalityTest extends TestSetup{

    @Test (dataProvider = "validEmailPasswordData", dataProviderClass = CsvDataProvider.class)
    public void addProductsToUserWishlist(String  email, String password) {
        List<String> productNames = new ArrayList<>();
        homePage.clickSignIn();
        signInPage.enterEmail(email);
        signInPage.enterPassword(password);
        signInPage.clickSigIn();
        for (int i=1; i<= 8; i++ ) {
            homePage.iterateAndClickProductCard(i);
            productNames.add(productPage.getProductName().toLowerCase());
            productPage.addItemToAWishlist();
            driver.navigate().back(); //navigates back to homepage
        }
        //driver.navigate().refresh();
        homePage.clickUserProfile();
        userAccount.clickWishlist();
        wishlistPage.clickMyWishlist();
        wishlistPage.getProductNamesInWishlist();
        List<String> productsAddedToWishlist = productNames.stream().sorted().toList();
        Assert.assertEquals(productsAddedToWishlist, wishlistPage.getProductNamesInWishlist(), "Products list names does not match");
    }

    @Test (dataProvider = "validEmailPasswordData", dataProviderClass = CsvDataProvider.class)
    public void removeProductsFromUserWishlist(String  email, String password){
        homePage.clickSignIn();
        signInPage.enterEmail(email);
        signInPage.enterPassword(password);
        signInPage.clickSigIn();
        for (int i=1; i<= 8; i++ ) {
            homePage.iterateAndClickProductCard(i);
            productPage.addItemToAWishlist();
            driver.navigate().back(); //navigates back to homepage
        }
        homePage.clickUserProfile();
        userAccount.clickWishlist();
        wishlistPage.clickMyWishlist();
        System.out.println(wishlistPage.getProductNamesInWishlist().size());
        wishlistPage.removeAllItemsFromWishlist();
        Assert.assertTrue(wishlistPage.getProductNamesInWishlist().isEmpty(),
                "Not all items removed from wishlist");
        wishlistPage.clickLogout();
    }
}
