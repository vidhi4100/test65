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



        /**
         * Advanced menu
         */
        /*driver.get("chrome://settings/appearance");
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
        clearData.click();*/


        driver.get("file:///C:/Users/Bacancy/Downloads/HCT_Automation_JD.pdf");
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement clearData =
                (WebElement) js.
                        executeScript
                                (
                                   "return document.querySelector('pdf-viewer')." +
                                           "shadowRoot.querySelector('viewer-toolbar')." +
                                           "shadowRoot.querySelector('viewer-download-controls')."+
                                           "shadowRoot.querySelector('cr-icon-button')."+
                                           "shadowRoot.querySelector('iron-icon')"


                                );
        clearData.click();
    }
}
