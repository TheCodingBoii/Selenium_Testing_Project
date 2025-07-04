import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTesting {
    WebDriver driver;

    @BeforeMethod
    public void testButtonPage() {
        driver = new ChromeDriver();
        Dimension newSize = new Dimension(800, 600);
        driver.manage().window().setSize(newSize);
        driver.get("https://leafground.com/alert.xhtml");

    }
    @Test
    public void alertTest(){

        //Alert simple dialog
        WebElement alertFirst= driver.findElement(By.id("j_idt88:j_idt91"));
        alertFirst.click();
        Alert alert= driver.switchTo().alert();
        alert.accept();

        //Alert confirm button
        WebElement alertSecond = driver.findElement(By.id("j_idt88:j_idt93"));
        alertSecond.click();
        Alert alert2= driver.switchTo().alert();
        alert2.dismiss();

        //Alert prompt Dialog
        WebElement alertThird = driver.findElement(By.id("j_idt88:j_idt104"));
        alertThird.click();
        Alert alert3= driver.switchTo().alert();
        String alertText= alert3.getText();
        System.out.println("Alert text is : "+alertText);
        alert3.sendKeys("Shan");
        alert3.accept();



    }
}
