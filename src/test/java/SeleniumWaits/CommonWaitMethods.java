package SeleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CommonWaitMethods {

    WebDriver driver;

    @BeforeMethod
    public void CommonWaitTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://leafground.com/waits.xhtml");
    }

    @Test
    public void CommonWaitTesting(){
        driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']")).click();
        String newBtnText = driver.findElement(By.xpath("//button[@id='j_idt87:j_idt90']/span")).getText();
        System.out.println("New btn Text is : " + newBtnText);
    }

    @AfterMethod
    public  void closeBrowser(){
        driver.quit();
    }
}
