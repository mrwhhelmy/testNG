package SessionOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
//@Test(enabled = false)
public class Assertions {
    private WebDriver driver;
    private SoftAssert softAssert;
    @BeforeClass (alwaysRun = true)
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ashraaf7.github.io/AA-Practice-Test-Automation/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test(priority=1, groups={"regression"})
    public void validLoginTestCase(String admin, String password){
        driver.findElement(By.id("inputUsername")).sendKeys(admin);
        driver.findElement(By.id("inputPassword")).sendKeys(password);
        driver.findElement(By.id("loginButton")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html","True");
    }
    @Test(priority=2, groups={"regression","broken"})
    public void inValidLoginTestCase(){
        driver.findElement(By.id("inputUsername")).sendKeys("admin");
        driver.findElement(By.id("inputPassword")).sendKeys("adin");
        driver.findElement(By.id("loginButton")).click();
        driver.switchTo().alert().accept();
        boolean expected = driver.getCurrentUrl().equals("https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
        Assert.assertFalse(expected,"Assert False"); //Message is displayed if assert fails
        Assert.assertTrue(expected,"Assert True");
    }
    @Test(priority=3, enabled = true,groups={"smoke","broken"})
    public void softAssertInValidLoginTestCase(){
        driver.findElement(By.id("inputUsername")).sendKeys("admin");
        driver.findElement(By.id("inputPassword")).sendKeys("adin");
        driver.findElement(By.id("loginButton")).click();
        driver.switchTo().alert().accept();
        softAssert = new SoftAssert();
        boolean expected = driver.getCurrentUrl().equals("https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
        softAssert.assertFalse(expected,"Assert False"); //Message is displayed if assert fails
        softAssert.assertTrue(expected,"Assert True");
        softAssert.assertAll();
    }
    @AfterClass(alwaysRun = true)
    public void quit(){
        driver.quit();
    }
}
