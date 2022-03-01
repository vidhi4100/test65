import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class ShadowRoot {

    public static WebDriver driver;

    @Test
    public void Test1Method() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("chrome://settings/appearance");

        /**
         * Advanced menu
         */
        Thread.sleep(5000);
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
