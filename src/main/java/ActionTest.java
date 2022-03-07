import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;

public class ActionTest {

    public static WebDriver driver;

    @Test
    public static void Test1Method() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://pms.bacancy.com/");

        WebElement btn = new WebDriverWait(driver,50).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()='Login']")));

        Actions actions = new Actions(driver);

        /**
         * mouseHover
         */
        actions.moveToElement(btn).build().perform();
        Thread.sleep(2000);

        /**
         * rightClick
         */

        actions.contextClick(btn).build().perform();
        Thread.sleep(2000);



    }




}
