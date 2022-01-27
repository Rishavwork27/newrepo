import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.facebook.com/");
    driver.manage().window().maximize();
    driver.findElement(By.linkText("Create New Account")).click();
    Thread.sleep(5000);
    driver.findElement(By.xpath("//button[@class='_6j mvm _6wk _6wl _58mi _3ma _6o _6v']/parent::div[@class='_1lch']"
            + "/preceding-sibling::div[@id='fullname_field']//child::input[@name='firstname']")).sendKeys("Rishav");//Question 2
    Thread.sleep(5000);
    driver.findElement(By.xpath("//input[@id='password_step_input']//preceding::input[@id='u_3_g_xA']")).sendKeys("7018374731");//question 4
    Thread.sleep(5000);
    driver.findElement(By.xpath("//input[@name='reg_email__']//following::input[@name='reg_passwd__']")).sendKeys("7018374731");//question 3
    Thread.sleep(5000);
    driver.findElement(By.xpath("//div[@class='_6ltg']//child::button"));//question 1

}
}

