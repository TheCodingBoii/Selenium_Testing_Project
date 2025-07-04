import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonTesting {

    WebDriver driver;

    @BeforeMethod
    public void openTestLinkPage(){
        driver = new ChromeDriver();
        Dimension newSize = new Dimension(800,600);
        driver.manage().window().setSize(newSize);
        driver.get("https://leafground.com/button.xhtml");
    }

    @Test
    public void buttonTests(){
        //Click and confirm title.
        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();
        String expectedTitle= "Dashboard";
        String actualTitle= driver.getTitle();

        if(expectedTitle.equals(actualTitle)){

            System.out.println("actual title is same as expected");
        }else{
            System.out.println("actual title is not same as expected");
        }
        //find the position of the submit button

        driver.navigate().back();
        WebElement getPosition=driver.findElement(By.id("j_idt88:j_idt94"));
        Point xyPoint= getPosition.getLocation();
        int x=xyPoint.getX();
        int y=  xyPoint.getY();

        System.out.println("X position is "+x +" Y position is "+ y);
        //find the save button color

        WebElement buttonColor= driver.findElement(By.id("j_idt88:j_idt96"));
        String color= buttonColor.getCssValue("background-color");
        System.out.println("The button color is "+ color);

        //Find the height and width of the button
        WebElement size= driver.findElement(By.id("j_idt88:j_idt98"));
        int height= size.getSize().getHeight();
        int width =size.getSize().getWidth();

        System.out.println("Height is "+ height+ " Width is "+width);
    }
}
