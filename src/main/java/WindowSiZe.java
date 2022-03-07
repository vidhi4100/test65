import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowSiZe {
    public static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
        driver = new ChromeDriver();

        Dimension dimension = new Dimension(400,600);
        driver.manage().window().setSize(dimension);
    }
}
