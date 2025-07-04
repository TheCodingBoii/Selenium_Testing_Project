import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseActionTesting {

    WebDriver driver;

    @BeforeMethod
    public void testButtonPage() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();


    }

    @Test
    public void mouseOperationsTest1(){
        driver.get("https://leafground.com/drag.xhtml");
        System.out.println("1)  <<<<<<<<<<<<<<<<<<Move to an element operation>>>>>>>>>>>>>>>>>");

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt37")))

                .moveToElement(driver.findElement(By.id("menuform:j_idt38")))

                .moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();


        System.out.println("2)  <<<<<<<<<<<<<<<<<<Drag and Drop operation>>>>>>>>>>>>>>>>>");

        WebElement from= driver.findElement(By.id("form:drag"));
        WebElement to = driver.findElement(By.id("form:drop"));

        //actions.clickAndHold(from).moveToElement(to).release(to).perform(); //first way

        actions.dragAndDrop(from,to).perform(); //2nd way

        System.out.println("3)  <<<<<<<<<<<<<<<<<<Slider operation>>>>>>>>>>>>>>>>>");

        WebElement sliderPoint1 =driver.findElement(By.xpath("//div[@id='form:j_idt125']/span[1]"));

        System.out.println("Location of sliderpoint 1 before moving :"+ sliderPoint1.getLocation());

        actions.dragAndDropBy(sliderPoint1,50,0).perform();

        System.out.println("Location of sliderpoint 1 before moving :"+ sliderPoint1.getLocation());
    }

    @Test()
    public  void mouseOperationsTest2(){
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        WebElement rightClickButton= driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

        Actions actions = new Actions(driver);

        actions.contextClick(rightClickButton).perform();

        driver.findElement(By.xpath("//span[normalize-space()='Edit']")).click();

        Alert alertPop = driver.switchTo().alert();

        System.out.println("Alert sowa the text as: "+alertPop.getText());
        alertPop.accept();


    }
}
