import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FrameTesting {

    WebDriver driver;

    @BeforeMethod
    public void testButtonPage() {
        driver = new ChromeDriver();
        Dimension newSize = new Dimension(800, 600);
        driver.manage().window().setSize(newSize);
        driver.get("https://leafground.com/frame.xhtml");

    }

    @Test
    public void frameTests(){
        driver.switchTo().frame(0);
        //click me inside frame
        WebElement buttonOne= driver.findElement(By.xpath("//*[@id='Click']"));
        buttonOne.click();

        String afterClickButtonText=  buttonOne.getText();
        System.out.println("After  click inside frame Text: "+ afterClickButtonText);

        //Click me (inside nested frame)
        driver.switchTo().defaultContent();

        driver.switchTo().frame(2);


        driver.switchTo().frame("frame2");

        WebElement button3= driver.findElement(By.id("Click"));
        button3.click();

        String afterClickNestedButtonText=  button3.getText();
        System.out.println("After  click inside frame Text: "+ afterClickNestedButtonText);

        //how many frames in this page
        driver.switchTo().defaultContent();

        List<WebElement> getiframeTagElements= driver.findElements(By.tagName("iframe"));
        int size=getiframeTagElements.size();
        System.out.println("Frame counts: "+getiframeTagElements);

        for(WebElement iframeElement:getiframeTagElements){
            String frameSRCattributrValue=iframeElement.getAttribute("src");
            System.out.println("frame arc attribute value: "+frameSRCattributrValue);
        }

        
    }
}
