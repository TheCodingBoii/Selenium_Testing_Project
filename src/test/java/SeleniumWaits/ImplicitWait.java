package SeleniumWaits;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ImplicitWait {

    WebDriver driver;

    @BeforeMethod
    public void ImplicitWaitTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/waits.xhtml");
    }
    @Test
    public void implicitWaitTesting(){

    }
}
