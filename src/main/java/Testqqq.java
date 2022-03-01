import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;

public class Testqqq {
    public static WebDriver driver;

    @Test
    public void Test1Method() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/buttons");

        while (true) {
            WebElement btn = new WebDriverWait(driver, 50).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Click Me']")));
            btn.click();
            driver.navigate().refresh();
            Thread.sleep(5000);
        }
    }
}