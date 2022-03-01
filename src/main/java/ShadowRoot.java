import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ShadowRoot {

    public static WebDriver driver;

    @Test
    public void Test1Method() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("chrome://settings/");

        /**
         * Advanced menu
         */
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement clearData =
                (WebElement) js.
                        executeScript
                                (
                                  "return document.querySelector('settings-ui')." +
                                          "shadowRoot.querySelector('settings-menu')." +
                                          "shadowRoot.querySelector('cr-button')"
                                );
        clearData.click();

    }
}
