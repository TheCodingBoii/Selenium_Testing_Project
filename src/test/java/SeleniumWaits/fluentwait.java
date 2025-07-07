package SeleniumWaits;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class fluentwait {

    WebDriver driver;

    @BeforeMethod
    public void FluentWaitTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/waits.xhtml");
    }

    @Test
    public void FluentWaitTesting(){

        //declaration (Define Fluent Wait)
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))     // Maximum time to wait
                .pollingEvery(Duration.ofSeconds(5))     // Frequency to check the condition
                .ignoring(NoSuchElementException.class); // Ignore specific exceptions


        driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']")).click();

        WebElement fluentwaitElement = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//button[@id='j_idt87:j_idt90']/span"));
            }
        });


        String newBtnText = fluentwaitElement.getText();
        System.out.println("New btn Text is : " + newBtnText);
    }
    @AfterMethod
    public  void closeBrowser(){
        driver.quit();
    }
}
