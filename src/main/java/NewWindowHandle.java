import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class NewWindowHandle {

    public static WebDriver driver;

    @Test
    public void windowHandle() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/browser-windows");

        WebElement emailtest = new WebDriverWait(driver,50).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='New Window']")));
        emailtest.click();

        /**
         * new Window or MultipleWindow
         */
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindow = driver.getWindowHandles();
        Iterator<String> iterator = allWindow.iterator();
        while (iterator.hasNext()){
            String childwindow = iterator.next();
            if (!currentWindow.equalsIgnoreCase(childwindow)){
                driver.switchTo().window(childwindow);
                System.out.println("Child Window Tab................!");
                driver.close();
            }
        }
        driver.switchTo().window(currentWindow);


        /**
         * new Tab
         */

        WebElement r = new WebDriverWait(driver,50).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='New Tab']")));
        r.click();

        Thread.sleep(5000);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

}
