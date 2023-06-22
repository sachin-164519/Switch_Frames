package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class frameSwitch {
    ChromeDriver driver;
    public frameSwitch()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        // Switch to frame top Using Locator "Name" ("frame-top")
        driver.switchTo().frame("frame-top");
        // Switch to frame left Using Locator "Name" ("frame-left")
        driver.switchTo().frame("frame-left");
        // Locate the text LEFT Using Locator "XPath" //body[contains(text(),'LEFT')]
        WebElement leftText = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        System.out.println(leftText.getText());
        // Switch to frame top Using Locator "Name" ("frame-top")
        driver.switchTo().parentFrame();
        // Switch to frame middle Using Locator "Name" ("frame-middle")
        driver.switchTo().frame("frame-middle");
        // Locate the text MIDDLE Using Locator "XPath" //div[contains(text(),'MIDDLE')]
        WebElement middleText = driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]"));
        System.out.println(middleText.getText());
        // Switch to frame top Using Locator "Name" ("frame-top")
        driver.switchTo().parentFrame();
        // Switch to frme right Using Locator "Name" ("frame-right")
        driver.switchTo().frame("frame-right");
        // Locate the text RIGHT Using Locator "XPath" //body[contains(text(),'RIGHT')]
        WebElement rightText = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println(rightText.getText());
        // Switch to parent   defaultContent()
        driver.switchTo().defaultContent();
        // Switch to frame bottom Using Locator "Name" ("frame-bottom")
        driver.switchTo().frame("frame-bottom");
        // Locate the text BOTTOM Using Locator "XPath" //body[contains(text(),'BOTTOM')]
        WebElement bottomText = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println(bottomText.getText());
    }

}
