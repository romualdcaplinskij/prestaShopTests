package prestashop;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestSetup {

    WebDriver driver;
    HomePage homePage;
    SignInPage signInPage;
    RegisterPage registerPage;
    ArtPage artPage;
    SoftAssert softAssert;
    WebDriverWait wait;
    Alert alert;
    Actions actions;

    @BeforeClass
    public void setDriver(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        driver.manage().window().maximize();
        driver.get("http://192.168.1.126");
        softAssert = new SoftAssert();
        actions = new Actions(driver);

        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
        registerPage = new RegisterPage(driver);
        artPage = new ArtPage(driver);
    }

    @AfterClass
    public void quit(){
        //driver.quit();
    }
}
