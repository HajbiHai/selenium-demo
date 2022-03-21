package Lession02_WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class homeworkExecrcise extends BaseDriver {

    @BeforeClass
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void homeWorkTest(){
        driver.get("http://google.com");
        driver.get("http://bing.com");
        driver.navigate().back();
        System.out.println("Google title is: " + driver.getTitle());
        if (driver.getPageSource().contains("bubble"))
            System.out.println("Exists");
        else
            System.out.println("Not Exists");
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
        driver.close();
    }








}
