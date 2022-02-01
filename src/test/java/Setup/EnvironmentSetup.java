package Setup;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class EnvironmentSetup {
    public WebDriver driver;

    @BeforeTest(groups = "purchase") // (groups = "SalePurchase")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--headed");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterMethod  //AfterMethod annotation - This method executes after every test execution
    public void screenShot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                Utils util = new Utils(driver);
                util.takeScreenShot();
            } catch (Exception exception) {
                System.out.println(exception);
            }
        }
    }

    @AfterTest(groups = "purchase") // (groups = "SalePurchase")
    public void logout() {
//        driver.close();
    }

}
