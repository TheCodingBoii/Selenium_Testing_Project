import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class Windows_Tabs_Test {

    WebDriver driver;

    @BeforeMethod
    public void testButtonPage() {
        driver = new ChromeDriver();
        Dimension newSize = new Dimension(800, 600);
        driver.manage().window().setSize(newSize);
        driver.get("https://leafground.com/window.xhtml");
    }

    @Test
    public void windowTests(){

        String oldWindow= driver.getWindowHandle();
        System.out.println("parent window: "+oldWindow);

        //click and confirm new window open
        WebElement oprnButton= driver.findElement(By.xpath("//button[@id='j_idt88:new']"));
        oprnButton.click();

        Set<String> handles= driver.getWindowHandles();
        System.out.println("handle size: "+handles.size());


        //First method using foreach loop

        for (String newWindow:handles){
            System.out.println(newWindow);
            driver.switchTo().window(newWindow);
            System.out.println("page title is: "+ driver.getTitle());
        }
        driver.close();
        driver.switchTo().window(oldWindow);

        WebElement mainWinElement= driver.findElement(By.xpath("//button[@id='j_idt88:new']"));
        boolean openButtonVisibility= mainWinElement.isDisplayed();
        System.out.println("Open button Visibility "+openButtonVisibility);

        //second method using list
        /*List<String> list =new ArrayList<String>(handles); //converting set to list
        if(list.size()>1){
            driver.switchTo().window(list.get(1));
            System.out.println("Child tab title is: "+driver.getTitle());
            driver.close();
            driver.switchTo().window(oldWindow);


        }*/

        //find the number of open tabs
        WebElement multyWindowButton=driver.findElement(By.xpath("//*[@id='j_idt88:j_idt91']"));
        multyWindowButton.click();
        Set<String> multiWindows=driver.getWindowHandles();
        int howManyWindows=multiWindows.size();
        System.out.println("Number of open windows: "+howManyWindows);

        //close all the windows except primary
        WebElement dontCloseMeButton=driver.findElement(By.xpath("//*[@id='j_idt88:j_idt93']"));
        dontCloseMeButton.click();

        Set<String> newWindowsHandle=driver.getWindowHandles();

        for(String allWindows:newWindowsHandle){
            if(!allWindows.equals(oldWindow)){
                driver.switchTo().window(allWindows);
                driver.close();
            }
        }
        /*driver.switchTo().window(oldWindow);
        driver.close();*/
        driver.quit();



    }
}
