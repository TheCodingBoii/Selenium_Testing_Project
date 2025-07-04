import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownTesting {

    WebDriver driver;

    @BeforeMethod
    public void testButtonPage(){
        driver = new ChromeDriver();
        Dimension newSize = new Dimension(800,600);
        driver.manage().window().setSize(newSize);

    }
    @Test
    public void buttonTests(){

        driver.get("https://www.leafground.com/select.xhtml");

        //ways of select values from basic dropdown
        WebElement dropdown =driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        select.selectByVisibleText("Playwright");


        //get the number of dropdown option
        //generics
        List<WebElement> listOfOptions= select.getOptions();
        int size=listOfOptions.size();
        System.out.println("Number of elements in drop down: " + size);

        for(WebElement element:listOfOptions){
            System.out.println(element.getText());
        }

        //using sendkeys select dropdown value
        dropdown.sendKeys("Puppeteer");

        //select values in a bootstrap dropdown
        WebElement bootsTrapDrop= driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        bootsTrapDrop.click();
        List<WebElement> listOfDropdownValues= driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));


        for (WebElement element1:listOfDropdownValues){
            String dropDownValue=element1.getText();
            if(dropDownValue.equals("USA")){
                element1.click();
                break;
            }
        }

    }
    //Google Search - pick a value from suggestions

    @Test
    public void googleSearchDropDown() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("palitha");
        Thread.sleep(2000);
        List<WebElement> googleSearchList= driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@class='wM6W7d']"));
        System.out.println(googleSearchList.size());
        for(WebElement element:googleSearchList){
            System.out.println(element.getText());
        }

    }

    //handle hidden Auto suggestions drop down and search using dom debugger trick
}
