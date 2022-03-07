import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class StatickBlock {
    public static WebDriver driver;

    static {
        System.out.println("execute before method at the time of class loading");
    }

    public StatickBlock(){}

    public static void main(String[] args) throws IOException, InterruptedException {

        ActionTest.Test1Method();
    }
}
