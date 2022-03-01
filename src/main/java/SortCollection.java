import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortCollection {

    public static WebDriver driver;

    @Test
    public void sorting() throws IOException, InterruptedException {
        List < String > myList = Arrays.asList("Joy", "Alice", "Bob", "Max", "Charles", "Katty");
        System.out.println("Sorted List is: ");
        List < String > sortList = myList.stream().sorted().collect(Collectors.toList());
        sortList.forEach(System.out::println);


    }
}
