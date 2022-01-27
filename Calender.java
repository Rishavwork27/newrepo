import com.sun.jna.Structure;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

public class Calender {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        driver.findElement(By.name("txtUsername")).sendKeys("Admin");
        driver.findElement(By.name("txtPassword")).sendKeys("admin123");
        driver.findElement(By.name("Submit")).click();
        WebElement Recruitment = driver.findElement(By.id("menu_recruitment_viewRecruitmentModule"));
        Recruitment.click();
        WebElement candidateSearch = driver.findElement(By.id("candidateSearch_jobTitle"));
        Select select = new Select(candidateSearch );
        select.selectByValue("3");
        WebElement vacancy = driver.findElement(By.id("candidateSearch_jobVacancy"));
        Select select1 = new Select(vacancy );
        select.selectByIndex(1);
        WebElement Manager = driver.findElement(By.id("candidateSearch_hiringManager"));
        Select select2 = new Select(Manager  );
        select.selectByIndex(1);
        WebElement status = driver.findElement(By.id("candidateSearch_jobTitle"));
        Select select3 = new Select(status );
        select.selectByValue("3");
        driver.findElement(By.id("candidateSearch_candidateName")).sendKeys("Peter Smith");
        driver.findElement(By.id("candidateSearch_keywords")).sendKeys("infostride");
        driver.findElement(By.name("candidateSearch[dateApplication][from]")).click();
        driver.findElement(By.name("candidateSearch[dateApplication][from]")).sendKeys("2022-01-18");
        driver.findElement(By.xpath("//*[@id=\"candidateSearch_toDate\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"candidateSearch_toDate\"]")).sendKeys("2023-02-13");
        driver.findElement(By.xpath("//*[@id=\"candidateSearch_toDate\"]")).sendKeys(Keys.ENTER);
        WebElement MethodofApplication = driver.findElement(By.name("candidateSearch[modeOfApplication]"));
        driver.findElement(By.xpath("//*[@id=\"btnSrch\"]")).click();
        ((JavascriptExecutor)driver).executeScript("scroll(0,800)");
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.name("addCandidate[firstName]")).sendKeys("Laden");
        driver.findElement(By.name("addCandidate[lastName]")).sendKeys("kumar");
        driver.findElement(By.name("addCandidate[email]")).sendKeys("laden123@gmail.com");
        driver.findElement(By.name("addCandidate[contactNo]")).sendKeys("9876543210");
        driver.findElement(By.xpath("//*[@id=\"addCandidate_vacancy\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"addCandidate_vacancy\"]/option[5]")).click();
        driver.findElement(By.xpath("//*[@id=\"addCandidate_vacancy\"]/option[5]")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"addCandidate_resume\"]")).sendKeys("");


    }

}
