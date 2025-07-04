import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkTesting {

    WebDriver driver;

    @BeforeMethod
    public void openTestLinkPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/link.xhtml");
    }

    @Test
    public void linkTest(){

        //Take me to dashboard

        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back();

        //Find my desination

        WebElement whereToGo =driver.findElement(By.partialLinkText("Find the URL without clicking me."));
        String path = whereToGo.getAttribute("href");
        System.out.println("This Link is going to : " + path);

        //Am i a broken link

        WebElement brokenLink= driver.findElement(By.linkText("Broken?"));
        brokenLink.click();

        String title= driver.getTitle();
        if (title.contains("404")){
            System.out.println("The Link is broken");
        }else{
            System.out.println("Not broken");
        }
        driver.navigate().back();

        //duplicate Link
        WebElement homeLink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink1.click();
        driver.navigate().back();


        //Count page Links
        List<WebElement> countFullPageLinks=driver.findElements(By.tagName("a"));
        int pasgeLinkCount =countFullPageLinks.size();
        System.out.println("Count of full page links: "+pasgeLinkCount );

        //count layout links
        WebElement layoutElements =driver.findElement(By.className("layout-main-content"));
        List<WebElement> countLayoutLinks=layoutElements.findElements(By.tagName("a"));
        System.out.println("Count of layout links: "+countLayoutLinks.size());



    }
}
