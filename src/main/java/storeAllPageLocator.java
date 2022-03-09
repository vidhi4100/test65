import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class storeAllPageLocator {

    public WebDriver driver;

    public storeAllPageLocator() {
    }

    /**
     * @author Vidhi Bakaraniya
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        this.driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/selenium-tutorials/scrolling-web-page-with-selenium-webdriver-using-java");

       File file = new File("test.txt");
       file.createNewFile();

        List<WebElement> list = new WebDriverWait(driver,90)
               .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("input")));
       int i =1;
       String xpath = "";
       for (WebElement ty : list) {
           if (!ty.getAttribute("id").equals("")) {
                //System.out.println(i++ + " :" + ty.getAttribute("id"));
                xpath += (i++)+" : "+  "//input[@id="+ "'" +ty.getAttribute("id")+ "'" + "]" +"\n";
            }
        }

        FileWriter fw = new FileWriter("test.txt");
        fw.write(xpath);
        fw.close();
       driver.quit();




    }


}