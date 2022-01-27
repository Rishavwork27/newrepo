import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import javax.xml.crypto.Data;


public class data {
    /**
     * @throws IOException
     */
    void call()   throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String username,password;
        String path = System.getProperty("user.dir") + "/exceldata/data.xls";
        FileInputStream fin=new FileInputStream(path);
        HSSFWorkbook WB = new HSSFWorkbook(fin);
        HSSFSheet sheet = WB.getSheetAt(0);
        System.out.println(sheet.getLastRowNum());
        driver.get("https://opensource-demo.orangehrmlive.com/");
        for(int i=1;i<=sheet.getLastRowNum();i++) {
            username=sheet.getRow(i).getCell(0).getStringCellValue();
            driver.findElement(By.name("txtUsername")).sendKeys(username);
            password=sheet.getRow(i).getCell(1).getStringCellValue();
            driver.findElement(By.id("txtPassword")).sendKeys(password);
            driver.findElement(By.id("btnLogin")).click();
        }

    }
    public static void main(String[] args) throws IOException {
        Object ob = new Object();
//        ob.call()


    }
}