package SessionOne;
import org.testng.annotations.*;

@Test
public class TestNG {
    // Suites for Smoke & another for Regression (Before & afterSuites)
    // Tests for Chrome & another for Edge (Before & afterClass)

    @BeforeClass
    public void beforeClass()
    {
        System.out.println("before class");
    }
    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("before method");
    }

    //@Test
    public void testcase1()
    {
        System.out.println("test case 1");
    }
    //@Test
    public void testcase2()
    {
        System.out.println("test case 2");
    }
    @AfterMethod
    public void afterMethod()
    {
        System.out.println("after method");
    }
    @AfterClass
    public void afterClass()
    {
        System.out.println("after class");
    }
}
