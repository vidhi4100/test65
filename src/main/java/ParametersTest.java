import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;

public class ParametersTest {

    public static WebDriver driver;

    /**
     * @Parameters and @Optional
     * @param name
     * @param email
     * @throws IOException
     * @throws InterruptedException
     * @throws AWTException
     */
    @Test
    @Parameters({"name","email"})
    public void parameterTest(@Optional("Abc")String name, String email) throws IOException, InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/text-box");

        WebElement user = new WebDriverWait(driver,50).
                until(ExpectedConditions.presenceOfElementLocated(By.id("userName")));
        user.sendKeys(name);
        WebElement emailtest = new WebDriverWait(driver,50).
                until(ExpectedConditions.presenceOfElementLocated(By.id("userEmail")));
        emailtest.sendKeys(email);

    }


    /**
     * @DataProvider
     * @throws IOException
     * @throws InterruptedException
     * @throws AWTException
     */

    @DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataprovider() {
        return new Object[][]
                {
                        {"Vidhi G. Bakaraniya",
                         "Vidhi.bakaraniya@bacancy.com",
                         "Ahmedabad",
                         "Ahmedabad"}
                };

    }


    @Test(dataProvider="SearchProvider")
    public void dataProviderTest(String name, String email,String ca,String pa) throws IOException, InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/text-box");

        WebElement user = new WebDriverWait(driver,50).
                until(ExpectedConditions.presenceOfElementLocated(By.id("userName")));
        user.sendKeys(name);
        WebElement emailtest = new WebDriverWait(driver,50).
                until(ExpectedConditions.presenceOfElementLocated(By.id("userEmail")));
        emailtest.sendKeys(email);
        WebElement currentAddress = new WebDriverWait(driver,50).
                until(ExpectedConditions.presenceOfElementLocated(By.id("currentAddress")));
        currentAddress.sendKeys(ca);
        WebElement permanentAddress = new WebDriverWait(driver,50).
                until(ExpectedConditions.presenceOfElementLocated(By.id("permanentAddress")));
        permanentAddress.sendKeys(pa);

    }

}
