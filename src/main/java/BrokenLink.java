import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class BrokenLink {
    public static WebDriver driver;

    @Test
    public void authMethod() throws IOException, InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        int respCode = 200;
        List<WebElement> links = driver.findElements(By.tagName("a"));

        Iterator<WebElement> it = links.iterator();

        while(it.hasNext()){

            String url = it.next().getAttribute("href");

            System.out.println(url);

            try {
                HttpURLConnection HttpURLConnection = (HttpURLConnection)(new URL(url).openConnection());

                HttpURLConnection.setRequestMethod("HEAD");

                HttpURLConnection.connect();

                respCode = HttpURLConnection.getResponseCode();

                if(respCode >= 400){
                    System.out.println(url+" is a broken link");
                }

            }catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        driver.quit();

    }
}


