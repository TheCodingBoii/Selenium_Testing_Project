import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavascripExecuter {
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeMethod
    public void javaScriptExe() {
        driver = new ChromeDriver();
        Dimension newSize = new Dimension(800, 600);
        driver.manage().window().setSize(newSize);
        driver.get("https://testautomationpractice.blogspot.com/");


    }

    @Test
    public void jsExecutorTests(){

        //Get  a Alert Box in to we page using javaScript

        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("alert('Welcome to the page Shan....');");
        
        //Set a input value in a text box using javascripExecuter
        WebElement inputNameTextBox = driver.findElement(By.xpath("//*[@id='name']"));
        jsExecutor.executeScript("arguments[0].value='This is Shan';",inputNameTextBox);

        //Highlight element
        jsExecutor.executeScript("arguments[0].style.border='3px solid red';",inputNameTextBox);
        jsExecutor.executeScript("arguments[0].style.background='yellow';",inputNameTextBox);

        //click element using javascriptExecutor
        WebElement selectCheckBox =driver.findElement(By.xpath("//*[@id='male']"));
        jsExecutor.executeScript("arguments[0].click()",selectCheckBox);

        //Scrolling the page
        scrollPage();

        //Get all attributes from wanted element
        getAllAttributes(inputNameTextBox);



    }
    public void scrollPage(){
        //scroll to some position
        jsExecutor.executeScript("window.scrollTo(0, 1000);");
        jsExecutor.executeScript("window.scrollTo(0, -1000);");

        //scroll to the bottom of the page by pixel number
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        //scroll to top of the page
        jsExecutor.executeScript("window.scrollTo(0, 0);");
        //scroll the page till element is visible
        WebElement scrollThePageElement =driver.findElement(By.xpath("//label[text()='Gender:']"));
        jsExecutor.executeScript("aegument[0].scrollIntoView(true);",scrollThePageElement);
    }
    public String getAllAttributes(WebElement webElement) {
        Object elementAttributes = jsExecutor.executeScript(
                "var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;",
                webElement);
        System.out.println("All Attribute value are : " + elementAttributes.toString());
        return elementAttributes.toString();
    }
}
