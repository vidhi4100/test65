import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadDataFromExcelFile {

    public static WebDriver driver;


    @Test
    public void readData() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/text-box");

        String s ="";

        List<String> list = new ArrayList<String>();

        XSSFWorkbook workbook = new XSSFWorkbook(System.getProperty("user.dir")+"\\Book1.xlsx");
        XSSFSheet sheet =workbook.getSheetAt(0);
        Iterator<Row> iterator =sheet.iterator();
        while (iterator.hasNext()){
            Row row = iterator.next();
            s += list.add(row.getCell(0).getStringCellValue());
        }

        System.out.println(s);
        for(String s1 : list){
            WebElement user = new WebDriverWait(driver,50).
                    until(ExpectedConditions.presenceOfElementLocated(By.id("userName")));
            user.sendKeys(s1);
        }


    }


}
