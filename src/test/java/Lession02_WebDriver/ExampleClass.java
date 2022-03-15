package Lession02_WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExampleClass
{

    WebDriver driver;
    String titlExpectedResult = "IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows";
    String urlExpectedResult = "http://www.imdb.com/";

    @BeforeClass
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://imdb.com");
    }
    @Test
    public void test01() {
        driver.navigate().refresh();
        String imdbTitle = driver.getTitle();
        System.out.println("Title is: " + driver.getTitle());
        String imdbUrl = driver.getCurrentUrl();
        System.out.println("URL is: " + driver.getCurrentUrl());
        if (titlExpectedResult.equals(driver.getTitle()))
            System.out.println("Title test PASSED! :)");
        else System.out.println("Title test FAILED! :(");
        if(urlExpectedResult.equals(driver.getCurrentUrl()))
            System.out.println("URL test PASSED! :)");
        else System.out.println("URL test FAILED! :(");
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }

}
