package prestashop;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class ArtPageTests extends TestSetup{

    @Test
    public void filterByAvailability(){
        homePage.clickArtLink();
        artPage.clickAvailabilityFilter();

        //check if available items in filter matches the displayed items
        Assert.assertEquals(artPage.getAmountAvailableItems(), artPage.getAmountOfItemsDisplayed(),
                "Displayed amount of items does not match");
    }


    @Test
    public void filterBySelections(){
        homePage.clickArtLink();
        artPage.clickSelection();
        Assert.assertEquals(artPage.getAmountFromSelection(), artPage.getAmountOfItemsDisplayed(),
                "Displayed amount of items does not match");

    }

    @Test
    public void filterByPrice() throws InterruptedException {
        homePage.clickArtLink();
        actions.clickAndHold(artPage.leftSliderHandle)
                .moveByOffset(artPage.moveLeftSliderToRandomPriceInRange(), 0)
                .release()
                .perform();

//        List<WebElement> filteredItemsPrices = wait.until(ExpectedConditions
//                .visibilityOfAllElementsLocatedBy(By.cssSelector
//                        (".js-product-miniature.product-miniature .price")));
        Thread.sleep(1000); //Selenium wait does not work here
        double minFilteredPrice = artPage.getMinPriceSliderValue();
        double maxFilteredPrice = artPage.getMaxPriceSliderValue();
        System.out.println("Minimum filtered price: " + minFilteredPrice);
        System.out.println("Maximum filtered price: " + maxFilteredPrice);
        for (WebElement itemPrice : artPage.listOfPricesDisplayed){
            double price = Double.parseDouble(itemPrice.getText().replace("$","").trim());
            try {
                System.out.println(price);
                softAssert.assertTrue(price >= minFilteredPrice && price <= maxFilteredPrice, "Price " + price + " is out of range.");
            } catch (NumberFormatException e){
                Assert.fail("Invalid price format");
            }
            softAssert.assertAll();
        }
    }

    @Test
    public void filterByComposition() throws InterruptedException {
        homePage.clickArtLink();
        artPage.clickCompositionMattPaper();
        //filter selector disappears from DOM after selected
        int numberOfAvailableProducts = artPage.getNumberOfAvailableMattPaperProducts();
        Thread.sleep(200);
        int displayedNumberOfProducts = artPage.getAmountOfItemsDisplayed();
        System.out.println("Number of available products: " + numberOfAvailableProducts);
        System.out.println("Displayed number of products: " + displayedNumberOfProducts);
        Assert.assertEquals(numberOfAvailableProducts, artPage.getAmountOfItemsDisplayed(),
                "Displayed amount of items does not match");
    }

    @Test
    public void filterByBrand() throws InterruptedException {
        homePage.clickArtLink();
        artPage.clickBrandGraphicCorner();
        //filter selector disappears from DOM after selected
        int numberOfAvailableProducts = artPage.getNumberOfAvailableProductGraphicCorner();
        Thread.sleep(200);
        int displayedNumberOfProducts = artPage.getAmountOfItemsDisplayed();
        System.out.println("Number of available products: " + numberOfAvailableProducts);
        System.out.println("Displayed number of products: " + displayedNumberOfProducts);
        Assert.assertEquals(displayedNumberOfProducts, numberOfAvailableProducts,
                "Displayed amount of items does not match");
    }

    @Test
    public void filterByDimensions() throws InterruptedException {
        homePage.clickArtLink();
        artPage.clickFilterDimensions40x60();
        //Thread.sleep(200);
        softAssert.assertEquals(artPage.getAmountOfProductDimension40x60(), artPage.getAmountOfItemsDisplayed(),
                "Displayed amount of items does not match");
        //wait.until(ExpectedConditions.elementToBeClickable(artPage.clearFilters)).click();
        artPage.clickClearAllFilters();
        artPage.clickFilterDimensions60x90();
        //Thread.sleep(200);
        softAssert.assertEquals(artPage.getAmountOfProductDimension60x90(), artPage.getAmountOfItemsDisplayed(),
                "Displayed amount of items does not match");
        //wait.until(ExpectedConditions.elementToBeClickable(artPage.clearFilters)).click();
        artPage.clickClearAllFilters();
        artPage.clickFilterDimensions80x120();
        //Thread.sleep(200);
        softAssert.assertEquals(artPage.getAmountOfProductDimension80x120(), artPage.getAmountOfItemsDisplayed(),
                "Displayed amount of items does not match");
        softAssert.assertAll();
    }

    @Test
    public void sortByNameAToZ() throws InterruptedException {
        homePage.clickArtLink();
        System.out.println(artPage.getSortedProductList());
        artPage.clickSortDropdownList();
        artPage.clickSortByNameAToZ();
        Thread.sleep(200);
        System.out.println(artPage.getNamesOfDisplayedProducts());
        Assert.assertEquals(artPage.getSortedProductList(), artPage.getNamesOfDisplayedProducts(),
                "Names or amount of sorted doesn't match");
    }
//
//    @Test
//    public void sortByNameZToA(){
//
//    }
//
//    @Test
//    public void sortByPriceLowToHigh(){
//
//    }
//
//    @Test
//    public void sortByPriceHighToLow(){
    //}

}
