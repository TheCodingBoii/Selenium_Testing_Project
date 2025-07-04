import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class textboxTesting {

    WebDriver driver;

    @BeforeMethod
    public void openTestLinkPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/input.xhtml");
    }

    @Test
    public void textBoxTests(){

        //Type name in the textbox
        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Shan Gunarathne");

        //Append Country to this City
        WebElement appendText =driver.findElement(By.id("j_idt88:j_idt91"));
        appendText.sendKeys("India");

        //verify if text box is disabled
        boolean enable= driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is The Text Box Enabled" + enable);

        //clear the textbox
        WebElement clearText=driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        clearText.clear();

        //retrived the typed text
        WebElement textElement =driver.findElement(By.id("j_idt88:j_idt97"));
        String Value=textElement.getAttribute("value");
        System.out.println(Value);

        //Type email and tab. Confirm control moved to next element
        WebElement type=driver.findElement(By.id("j_idt88:j_idt99"));
        type.sendKeys("shangunarathne@gmail.com" + Keys.TAB + "Confirmed control moved to next element");



    }
}
