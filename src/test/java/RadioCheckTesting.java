import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RadioCheckTesting {

    WebDriver driver;

    @BeforeMethod
    public void testButtonPage() {
        driver = new ChromeDriver();
        Dimension newSize = new Dimension(800, 600);
        driver.manage().window().setSize(newSize);


    }

    @Test
    public void radioTest(){

        driver.get("https://leafground.com/radio.xhtml");

        //Find the default select radio button
        boolean chromeRadioOption=driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean fireFoxRadioOption=driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean safariRadioOption=driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edgeRadioOption=driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        if(chromeRadioOption){
            String chromeText= driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            System.out.println("default select radio button is : "+chromeText);
        } else if (fireFoxRadioOption) {
            String firefoxText= driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
            System.out.println("default select radio button is : "+firefoxText);
            
        } else if (safariRadioOption) {
            String safariText= driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            System.out.println("default select radio button is : "+safariText);
            
        } else if (edgeRadioOption) {
            String edgeText= driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
            System.out.println("default select radio button is : "+edgeText);
        }

        //select the age group only if not selected
        WebElement myageGroup= driver.findElement(By.id("j_idt87:age:0"));
        boolean isChecks= myageGroup.isSelected();

        if(!isChecks){
            //myageGroup.click();
            driver.findElement(By.xpath("//label[@for='j_idt87:age:0']")).click();
        }


    }


    @Test
    public void CheckBoxTest(){
        driver.get("https://leafground.com/checkbox.xhtml");

        //Select wanted checkbox and verifying those checkboxes selected status

        List<WebElement> boxSelectList= driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));

        for(WebElement element:boxSelectList){
            if(!(element.getText().equals("Others"))){
                element.click();
            }
        }

        for(int i=1; i<=boxSelectList.size(); i++){
            boolean checkBoxStatus=driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)["+i+"]")).isSelected();
            System.out.println("Checkbox " + i + " selected status is : " +checkBoxStatus);
        }

    }
}
