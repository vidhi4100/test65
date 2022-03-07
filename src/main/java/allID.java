import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class allID {
    public static WebDriver driver;
    @Test
    public void authMethod() throws IOException, InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        int respCode = 200;
        List<WebElement> links = driver.findElements(By.tagName("a"));

        if(links.size() != 0)
        {

            for(WebElement inputElement : links)
            {
                System.out.println("//a[@id='"+inputElement.getAttribute("href")+"']");
            }
        }

    }
}
