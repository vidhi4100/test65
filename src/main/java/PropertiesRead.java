import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesRead {

    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader(System.getProperty("user.dir")+"\\src\\main\\resources\\test.properties");
        Properties properties = new Properties();
        properties.load(fileReader);

        System.out.println(properties.getProperty("password"));
    }
}
