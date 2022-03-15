package Lession04_Controllers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Controllers_Exercise {

    WebDriver driver;
    String firstName = "Mor";
    String lastName = "Shalom";
    @BeforeClass
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/ex_controllers.html#");
    }

    @Test
    public void test01(){
        driver.findElement(By.name("firstname")).sendKeys(firstName);
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.id("sex-1")).click();
        driver.findElement(By.id("exp-1")).click();
        driver.findElement(By.id("profession-0")).click();
        driver.findElement(By.id("profession-1")).click();
        driver.findElement(By.id("tool-1")).click();
        driver.findElement(By.id("tool-2")).click();


        driver.findElement(By.name("datepicker")).click();
        WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
        List<WebElement> days = dateWidget.findElements(By.tagName("td"));
        for(WebElement day : days){
            if (day.getText().equals("18")){
                day.click();
                break;
            }
        }

        Select myYabeshet = new Select(driver.findElement(By.id("continents")));
        myYabeshet.selectByValue("austria");
        Select seleniumCommands = new Select(driver.findElement(By.id("selenium_commands")));
        seleniumCommands.selectByVisibleText("Browser Commands");
        driver.findElement(By.id("submit")).click();
        String urlName = driver.getCurrentUrl();
        if (urlName.contains(firstName) && urlName.contains(lastName))
            System.out.println("Test PASSED!");
        else
            System.out.println("Test FAILED!");

    }

    @AfterClass
    public void closeSession(){
        driver.quit();
    }




}
