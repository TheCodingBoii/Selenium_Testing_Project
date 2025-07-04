import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class BrokenImagesCalenderTesting {
    WebDriver driver;

    @BeforeMethod
    public void testBrokenImages() {
        ChromeOptions chromeOptions = new ChromeOptions();
        File file = new File("C:\\Users\\Admin\\Downloads\\SelectorsHub-Chrome-Web-Store.crx");
        chromeOptions.addExtensions(file);

        driver = new ChromeDriver();

        driver.manage().window().maximize();


    }

    @Test
    public void findBrokenImageTest(){
        driver.get();

        List<WebElement> images= driver.findElements(By.xpath("//div[@class='example']/img"));
        int i=1;
        for(WebElement image:images){
            if(image.getAttribute("naturalWidth").equals("0")){
                System.out.println("Image " +i+ " is broken");
            }else {
                System.out.println("Image " +i+ " is not broken");
            }
            i++;
        }
    }
    @Test
    public void findBrokenImageTestTwo(){
        driver.get();
        WebElement brokenImage =driver.findElement(By.xpath(""));
        if(brokenImage.getAttribute("naturalWidth").equals("0")){
            System.out.println("Image is broken");
        }else {
            System.out.println("Image is not broken");
        }
    }

    @Test
    public void calenderTests(){
        driver.get();

        //1st method
//        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@class='demo-frame']")));
//
//        WebElement datePicker= driver.findElement(By.xpath("//input[@id='datepicker']"));
//        datePicker.sendKeys("07/02/2024");

        //2nd method
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@class='demo-frame']")));
        WebElement datePicker= driver.findElement(By.xpath("//input[@id='datepicker']"));
        datePicker.click();

        selectFutureDate("2024","October","3");
        selectPastDate("2023","January","5");



    }

    public void selectFutureDate(String year,String month,String date){
        while (true){
            String actualMonth= driver.findElement(By.xpath()).getText();
            String actualYear= driver.findElement(By.xpath()).getText();
            if (actualYear.equals(year) && actualMonth.equals(month)){
                break;
            }
            else {
                driver.findElement(By.xpath()).click();
            }
        }
        List<WebElement> allDates= driver.findElements(By.xpath());

        for(WebElement dateElement:allDates){
            if(dateElement.getText().equals(date)){
                dateElement.click();
                break;
            }
        }
    }

    public void selectPastDate(String year,String month,String date){
        while (true){
            String actualMonth= driver.findElement(By.xpath()).getText();
            String actualYear= driver.findElement(By.xpath()).getText();
            if (actualYear.equals(year) && actualMonth.equals(month)){
                break;
            }
            else {
                driver.findElement(By.xpath()).click();
            }
        }
        List<WebElement> allDates= driver.findElements(By.xpath());

        for(WebElement dateElement:allDates){
            if(dateElement.getText().equals(date)){
                dateElement.click();
                break;
            }
        }
    }
}
