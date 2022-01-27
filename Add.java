import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Add {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee");
        driver.findElement(By.name("txtUsername")).sendKeys("Admin");
        driver.findElement(By.name("txtPassword")).sendKeys("admin123");
        driver.findElement(By.name("Submit")).click();
        driver.findElement(By.name("firstName")).sendKeys("Modi");
        driver.findElement(By.name("lastName")).sendKeys("singh");
        driver.findElement(By.xpath("//*[@id=\"photofile\"]")).sendKeys("C:\\Users\\RishavKaundal\\" +
                "Desktop\\New folder\\download.png");
        driver.findElement(By.id("btnSave")).click();
    }
}
