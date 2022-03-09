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

        driver.get("https://www.applicoinc.com/");

        List<WebElement> links=driver.findElements(By.tagName("a"));

        System.out.println("Total links are "+links.size());

        for(int i=0;i<links.size();i++)
        {

            WebElement ele= links.get(i);

            String url=ele.getAttribute("href");

            verifyLinkActive(url);

        }

    }

    public static void verifyLinkActive(String linkUrl)
    {
        try
        {
            URL url = new URL(linkUrl);

            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();

            httpURLConnect.setConnectTimeout(3000);

            httpURLConnect.connect();

            if(httpURLConnect.getResponseCode()>=400)
            {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ httpURLConnect.getResponseCode());
            }
        } catch (Exception e) {

        }
    }
}




