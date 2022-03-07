import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Authentication {

    public static WebDriver driver;

    @Test
    public void authMethod() throws IOException, InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String testUsername = "admin";
        String testPassword = "admin";

        /**
         * 1. we can pass the username and password along with the web page’s URL.
         */

        //driver.get("https://" + testUsername + ":" + testPassword + "@the-internet.herokuapp.com/basic_auth");

        /**
         *  using AutoIT
         */

        driver.get("https://the-internet.herokuapp.com/basic_auth");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\test.exe");

        /**
         * Using Robot Class
         */
        Robot rb = new Robot();
        StringSelection username = new StringSelection(testUsername);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(username, null);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);

        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(2000);

        StringSelection pwd = new StringSelection(testPassword);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pwd, null);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);

        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(5000);





    }
}