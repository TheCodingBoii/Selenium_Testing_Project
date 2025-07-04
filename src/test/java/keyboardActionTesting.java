import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class keyboardActionTesting {


    WebDriver driver;

    @BeforeMethod
    public void testAction() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();


    }

    @Test
    public void keyBordActionTest1(){
        driver.get("https://www.google.com/");
        WebElement googleSearchTextBox= driver.findElement(By.name("q"));
        googleSearchTextBox.sendKeys("welcome");

        Actions action = new Actions(driver);
        //Select the text
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

        action.keyDown(Keys.SHIFT)
                .sendKeys("Writing capital sentence")
                .keyUp(Keys.SHIFT)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .keyDown(Keys.CONTROL)
                .sendKeys("x")
                .build().perform();
    }

    @Test
    public void keyBordActionTest2() throws InterruptedException {
        driver.get("https://leafground.com/list.xhtml");
        Actions actions = new Actions(driver);
        Thread.sleep(4000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        List<WebElement> selectable= driver.findElements(By.xpath("//ul[@aria-label='From']/li"));
        int size = selectable.size();
        System.out.println("Li count is :" +size);
        Thread.sleep(4000);



        actions.keyDown(Keys.CONTROL)
                .click(selectable.get(0))
                .click(selectable.get(1))
                .click(selectable.get(2))
                .perform();




    }
}
