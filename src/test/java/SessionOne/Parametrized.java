package SessionOne;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Parametrized {
    ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private SoftAssert softAssert;

    public Logger logger = LogManager.getLogger();
    @Parameters(value = "browser")
    @BeforeClass(alwaysRun = true)
    public void setup(@Optional("chrome") String browser){
        if (browser.equals("chrome"))
            driverThreadLocal.set(new ChromeDriver());
        else if (browser.equals("edge"))
            driverThreadLocal.set(new EdgeDriver());
        driverThreadLocal.get().manage().window().maximize();
        driverThreadLocal.get().get("https://ashraaf7.github.io/AA-Practice-Test-Automation/");
        driverThreadLocal.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Parameters(value = {"userName","password"})
    @Test
    public void validLoginTestCase(@Optional("admin") String userName,@Optional("admin") String password){
        //logger.info("Test case started");

        logger.info("test test");
        driverThreadLocal.get().findElement(By.id("inputUsername")).sendKeys(userName);
        //logger.info("userName: " + userName);
        driverThreadLocal.get().findElement(By.id("inputPassword")).sendKeys(password);
        driverThreadLocal.get().findElement(By.id("loginButton")).click();
        Assert.assertEquals(driverThreadLocal.get().getCurrentUrl(),"https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html","True");
    }

    @AfterClass(alwaysRun = true)
    public void quit(){

        driverThreadLocal.get().quit();
        driverThreadLocal.remove();
    }
}
