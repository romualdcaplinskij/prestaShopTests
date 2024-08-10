package prestashop;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestSetup {

    WebDriver driver = new ChromeDriver();
    HomePage homePage = new HomePage(driver);
    SignInPage signInPage = new SignInPage(driver);
    RegisterPage registerPage = new RegisterPage(driver);
    SoftAssert softAssert;
    WebDriverWait wait;
    Alert alert;

    @BeforeClass
    public void setDriver(){
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        driver.manage().window().maximize();
        driver.get("http://192.168.1.126");
        wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        softAssert = new SoftAssert();
    }

    @AfterClass
    public void quit(){
        //driver.quit();
    }
}
