package prestashop;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserFunctionalityTest extends TestSetup{

    FakerUserDataGenerator fakerUserDataGenerator = new FakerUserDataGenerator();

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
        //Assert checks if product names equals product names in wishlist.
        Assert.assertEquals(productsAddedToWishlist, wishlistPage.getProductNamesInWishlist(), "Products list names does not match");
        if (!wishlistPage.getProductNamesInWishlist().isEmpty()){ //clears wishlist for future tests
            wishlistPage.removeAllItemsFromWishlist();
        }
        wishlistPage.clickLogout();
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

    @Test (dataProvider = "validEmailPasswordData", dataProviderClass = CsvDataProvider.class)
    public void testAddAddressForUS(String email, String password){
        Map<String, String> addressData = fakerUserDataGenerator.generateAddressData();
        homePage.clickSignIn();
        signInPage.enterEmail(email);
        signInPage.enterPassword(password);
        signInPage.clickSigIn();
        homePage.clickUserProfile();
        userAccount.clickAddFirstAdress();
        //newAddressPage.fillAliasField(addressData.get("alias"));
        newAddressPage.fillCompanyField(addressData.get("company"));
        newAddressPage.fillAddressField(addressData.get("address"));
        newAddressPage.fillCity(addressData.get("city"));
        System.out.println(fakerUserDataGenerator.generateState());
        newAddressPage.clickState(fakerUserDataGenerator.generateState());
        newAddressPage.fillZipCode(addressData.get("postalCode"));
        //newAddressPage.clickCountry("United States");
        newAddressPage.fillPhoneField(addressData.get("mobileNumber"));
        newAddressPage.clickSaveButton();
        softAssert.assertEquals("Address successfully added.", addressesPage.getSuccessAlert(),
                "Message not found");
        addressesPage.deleteAddress();
        softAssert.assertEquals("Address successfully deleted.", addressesPage.getSuccessAlert());
        softAssert.assertAll();
        addressesPage.clickLogout();
    }
}
