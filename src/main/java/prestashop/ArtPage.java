package prestashop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.Inet4Address;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArtPage extends BasePage{
    public ArtPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = ".btn-unstyle.select-title")
    private WebElement sortDropDownList;

    @FindBy (css = ".dropdown-menu > a:nth-of-type(3)")
    private WebElement sortByNameAToZ;

    @FindBy (css = ".dropdown-menu > a:nth-of-type(4)")
    private WebElement sortByNameZToA;

    @FindBy (css = ".dropdown-menu > a:nth-of-type(5)")
    private WebElement sortByPriceLowToHigh;

    @FindBy (css = ".dropdown-menu > a:nth-of-type(6)")
    private WebElement sortByPriceHighToLow;

    @FindBy (css = "section:nth-of-type(1) > .collapse ._gray-darker.js-search-link.search-link")
    private WebElement filterByAvailability;

    @FindBy (css = "section:nth-of-type(1) > .collapse .magnitude")
    private WebElement itemsAvailable;

    @FindBy (css = ".product-miniature")
    protected List<WebElement> listOfProductsDisplayed;

    @FindBy (css = ".js-product-miniature.product-miniature .price")
    protected List<WebElement> listOfPricesDisplayed;

    @FindBy (css = ".js-product-miniature.product-miniature h2 > a")
    protected List<WebElement> listOfProductNames;

    @FindBy (css = "section:nth-of-type(2) > .collapse .custom-checkbox")
    private WebElement filterBySelection;

    @FindBy (css = "section:nth-of-type(4) > .collapse .custom-checkbox")
    private WebElement filterByCompositionMattPaper;

    @FindBy (css = "section:nth-of-type(5) > .collapse .custom-checkbox")
    private WebElement filterByBrandGraphicCorner;

    @FindBy (css = "section:nth-of-type(5) > .collapse .magnitude")
    private WebElement itemsAvailableGraphicCorner;

    @FindBy (css = "section:nth-of-type(4) > .collapse .magnitude")
    private WebElement itemsInCompositionSelection;

    @FindBy (css = "section:nth-of-type(2) > .collapse .magnitude")
    private WebElement itemsInSelection;

    @FindBy (css = ".ui-corner-all.ui-slider.ui-slider-horizontal.ui-widget.ui-widget-content > .ui-corner-all.ui-slider-range.ui-widget-header")
    protected WebElement priceSlider;

    @FindBy (css = ".ui-corner-all.ui-slider.ui-slider-horizontal.ui-widget.ui-widget-content > a:nth-of-type(1)")
    protected WebElement leftSliderHandle;

    @FindBy (css = ".ui-corner-all.ui-slider.ui-slider-horizontal.ui-widget.ui-widget-content > a:nth-of-type(2)")
    protected WebElement rightSliderHandle;

    @FindBy (css = "[data-slider-min] p")
    private WebElement priceSliderValues;

    @FindBy (css = "section:nth-of-type(6) > .collapse > li:nth-of-type(1) ")
    private WebElement filterDimensions40x60;

    @FindBy (css = "section:nth-of-type(3) > .collapse > li:nth-of-type(1) .magnitude")
    private WebElement itemsInDimensions40x60;

    @FindBy (css = "section:nth-of-type(6) > .collapse > li:nth-of-type(2)")
    private WebElement filterDimensions60x90;

    @FindBy (css = "section:nth-of-type(3) > .collapse > li:nth-of-type(2) .magnitude")
    private WebElement itemsInDimensions60x90;

    @FindBy (css = "section:nth-of-type(6) > .collapse > li:nth-of-type(3)")
    private WebElement filterDimensions80x120;

    @FindBy (css = "section:nth-of-type(3) > .collapse > li:nth-of-type(3) .magnitude")
    private WebElement itemsInDimensions80x120;

    @FindBy (css = ".js-search-filters-clear-all")
    protected WebElement clearFilters;

    public void clickSortByPriceHighToLow(){
        sortByPriceHighToLow.click();
    }


    public void clickSortByPriceLowToHigh(){
        sortByPriceLowToHigh.click();
    }

    public List<Double> getPricesOfSortedDisplayedProductsLowToHigh(){
        return getListOfPricesDisplayed()
                .stream()
                .sorted()
                .toList();
    }

    public List<Double> getPricesOfSortedDisplayedProductsHighToLow(){
        return getListOfPricesDisplayed()
                .stream()
                .sorted(Comparator.reverseOrder())     //sort doubles from high to low
                .toList();
    }

    public List<Double> getListOfPricesDisplayed(){
        return listOfPricesDisplayed.stream()
                .map(WebElement::getText)                           //gets test from webelement
                .map(price ->price.replace("$",""))//removes $
                .map(Double::parseDouble)                           //parses do Double
                .toList();                                          //back to list
    }


    public List<String> getNamesOfDisplayedProducts(){
        return listOfProductNames.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getSortedAtoZProductList(){
        return listOfProductNames.stream().map(WebElement::getText).sorted().collect(Collectors.toList());
    }

    public List<String> getSortedZtoAProductList(){
        return listOfProductNames.stream().map(WebElement::getText).sorted(Comparator.reverseOrder()).toList();
    }

    public void clickSortDropdownList() {
        sortDropDownList.click();
    }

    public void clickSortByNameAToZ(){
        sortByNameAToZ.click();
    }

    public void clickSortByNameZtoA(){
        sortByNameZToA.click();
    }

    public void clickClearAllFilters(){
        clearFilters.click();
    }

    public void clickFilterDimensions80x120(){
        filterDimensions80x120.click();
    }

    public int getAmountOfProductDimension80x120() {
        return Integer.parseInt(itemsInDimensions80x120.getText().replaceAll("[\\[\\]()]",""));
    }

    public void clickFilterDimensions60x90(){
        filterDimensions60x90.click();
    }

    public int getAmountOfProductDimension60x90() {
        return Integer.parseInt(itemsInDimensions60x90.getText().replaceAll("[\\[\\]()]",""));
    }

    public void clickFilterDimensions40x60(){
        filterDimensions40x60.click();
    }

    public int getAmountOfProductDimension40x60() {
        return Integer.parseInt(itemsInDimensions40x60.getText().replaceAll("[\\[\\]()]",""));
    }

    public int priceSliderWidth (){
        return priceSlider.getSize().getWidth();
    }

    public int getInitialLeftHandleX(){
        return leftSliderHandle.getLocation().getX();
    }

    public int getSliderStartX() {
        return priceSlider.getLocation().getX();
    }

    public String getPriceSliderValues(){
        return priceSliderValues.getText().replaceAll("[\\[\\]$ ]","");
    }

    public double getMinPriceSliderValue(){
        return Double.parseDouble(getPriceSliderValues().split("-")[0]);
    }

    public double getMaxPriceSliderValue(){
        return Double.parseDouble(getPriceSliderValues().split("-")[1]);
    }

    public int moveLeftSliderToRandomPriceInRange(){
        double sliderWidth = priceSliderWidth();
        double minPriceValue = getMinPriceSliderValue();
        double maxPriceValue = getMaxPriceSliderValue();
        double priceRange = maxPriceValue - minPriceValue;
        double randomPriceInRange = Math.floor(minPriceValue + (maxPriceValue - minPriceValue) * Math.random());
        double priceRangePercentage = (randomPriceInRange - minPriceValue) / priceRange;
        double sliderPosition = priceRangePercentage * sliderWidth;
        int currentOffset = getInitialLeftHandleX() - getSliderStartX();
        int targetOffset = (int) sliderPosition;
        System.out.println("Random price in range: " + randomPriceInRange);
        System.out.println("Slider position: " + (int)sliderPosition);
        System.out.println("Initial handle offset: " + currentOffset);
        System.out.println("Target offset: " + targetOffset);
        System.out.println("Distance to move: " + (targetOffset-currentOffset));
        return targetOffset - currentOffset;
    }

    public void clickSelection(){
        filterBySelection.click();
    }

    public void clickCompositionMattPaper(){
        filterByCompositionMattPaper.click();
    }

    public void clickBrandGraphicCorner(){
        filterByBrandGraphicCorner.click();
    }

    public int getNumberOfAvailableProductGraphicCorner(){
        return Integer.parseInt(itemsAvailableGraphicCorner.getText().replaceAll("[\\[\\]()]",""));

    }

    public int getNumberOfAvailableMattPaperProducts(){
        return Integer.parseInt(itemsInCompositionSelection.getText().replaceAll("[\\[\\]()]",""));
    }

    public int getAmountFromSelection(){
        return Integer.parseInt(itemsInSelection.getText().replaceAll("[\\[\\]()]",""));
    }

    public void clickAvailabilityFilter(){
        filterByAvailability.click();
    }

    public int getAmountAvailableItems(){
        return Integer.parseInt(itemsAvailable.getText().replaceAll("[\\[\\](){}]",""));
    }

    public int getAmountOfItemsDisplayed(){
        return listOfProductsDisplayed.size();
    }
}
