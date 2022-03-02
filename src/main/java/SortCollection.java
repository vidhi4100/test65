import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class SortCollection {

    public static WebDriver driver;

    @Test
    public void sorting() throws IOException, InterruptedException {
        ArrayList<String> al=new ArrayList<String>();
        al.add("A");
        al.add("V");
        al.add("Z");
        al.add("P");

        Collections.sort(al);
        Iterator<String> iterator = al.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        /**
         * REVERES ORDER
         */
        Collections.sort(al,Collections.reverseOrder());
        Iterator i=al.iterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }
    }
}
