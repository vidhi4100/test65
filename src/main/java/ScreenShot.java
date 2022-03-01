import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenShot {

    public static WebDriver driver;

    @Test
    public void Test1Method() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://pms.bacancy.com/");
        FileUtils.copyFile(
                ((TakesScreenshot)driver).
                        getScreenshotAs(OutputType.FILE),
                new File(System.getProperty("user.dir")+"\\png.png"));
    }

}
