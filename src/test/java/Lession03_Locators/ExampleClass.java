package Lession03_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class ExampleClass {

    WebDriver driver;

    @BeforeClass
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://selenium.dev");
    }

    @Test
    public void classTest(){
        System.out.println(driver.findElement(By.linkText("Blog")));
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("The number of links on the page is: " + links.size());
        List<WebElement> SeleniumLinks = driver.findElements(By.partialLinkText("Selenium"));
        System.out.println("The number of Selenium links on the page is: " + SeleniumLinks.size());
        List<WebElement> seleniumLinks = driver.findElements(By.partialLinkText("selenium"));
        System.out.println("The number of selenium links on the page is: "+ seleniumLinks.size());
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }











}
