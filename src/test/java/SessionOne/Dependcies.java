package SessionOne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Dependcies {
    private WebDriver driver;
    private SoftAssert softAssert;
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ashraaf7.github.io/AA-Practice-Test-Automation/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test
    public void registerTC(){
        System.out.println("register TC");
        Assert.fail();
    }
    //@Test(dependsOnMethods = "registerTC", alwaysRun = true)
    @Test(dependsOnMethods = "registerTC")
    public void loginTC(){
        System.out.println("login TC");
    }
    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
