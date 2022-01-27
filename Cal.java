import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Scanner;

class Parent{

    WebDriver driver = new ChromeDriver();
    String firstName = RandomStringUtils.randomAlphabetic(8);
    String lastName = RandomStringUtils.randomAlphabetic(8);
    String employeeID = RandomStringUtils.randomNumeric(4);
    String fullName = firstName + lastName;
    Select drag;

    void login()
    {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.name("Submit")).click();
    }
    void recruit(String da,String dat) throws InterruptedException {
        driver.findElement(By.linkText("Recruitment")).click();
        driver.findElement(By.linkText("Candidates")).click();
        drag= new Select(driver.findElement(By.id("candidateSearch_jobTitle")));
        drag.selectByValue("25");
        Thread.sleep(4000);
        drag = new Select(driver.findElement(By.id("candidateSearch_jobVacancy")));
        drag.selectByVisibleText("Payroll Administrator");
        Thread.sleep(4000);
        drag = new Select(driver.findElement(By.id("candidateSearch_hiringManager")));
        drag.selectByValue("7");
        Thread.sleep(3000);
        driver.findElement(By.id("candidateSearch_fromDate")).clear();
        driver.findElement(By.id("candidateSearch_fromDate")).sendKeys(da);
        driver.findElement(By.id("candidateSearch_toDate")).clear();
        driver.findElement(By.id("candidateSearch_toDate")).sendKeys(dat);
        driver.findElement(By.id("btnSrch")).click();
    }


}
class Cal extends Parent{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        System.out.println("Enter search from date as YYYY-MM-DD");
        Scanner obj=new Scanner(System.in);
        String date=obj.nextLine();
        System.out.println("Enter search to date as YYYY-MM-DD");
        String dat=obj.nextLine();
        WebDriverManager.chromedriver().setup();
        Parent abc = new Parent();
        abc.login();
        abc.recruit(date,dat);
    }
}