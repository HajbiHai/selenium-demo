package Lession03_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Locator_Exercise {

    WebDriver driver;

    @BeforeClass
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/ex_locators.html");
    }

    @Test
    public void test01(){
        System.out.println(driver.findElement(By.id("locator_id")));
        System.out.println(driver.findElement(By.name("locator_name")));
        System.out.println(driver.findElement(By.tagName("p")));
        System.out.println(driver.findElement(By.className("locator_class")));
        System.out.println(driver.findElement(By.linkText("myLocator(5)")));
        System.out.println(driver.findElement(By.partialLinkText("locator (6)")));
        System.out.println(driver.findElement(By.cssSelector("input[myname='selenium']")));
        System.out.println(driver.findElement(By.xpath("//div[@id=\"contact_info_left\"]/button")));


    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }



}
