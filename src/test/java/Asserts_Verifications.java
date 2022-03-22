import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Asserts_Verifications {

    WebDriver driver;
    @BeforeClass()
        public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/bmi/");
    }

    @Test(enabled = false)
    public void test01_BMItest() {
        driver.findElement(By.id("weight")).sendKeys("120");
        driver.findElement(By.id("hight")).sendKeys("200");
        driver.findElement(By.id("calculate_data")).click();
        String yourBmi = driver.findElement(By.id("bmi_result")).getAttribute("value");
        assertEquals(yourBmi,"31","Not equals");
    }

    @Test()
    public void test02_buttonCalc(){
       WebElement calculateButton = driver.findElement(By.id("calculate_data"));
       System.out.println(calculateButton.getSize());
       System.out.println(calculateButton.getLocation());
        assertTrue(calculateButton.isEnabled(),"Not Enabled");
        assertTrue(calculateButton.isDisplayed(),"Not Displayed");
        assertFalse(calculateButton.isSelected(),"Is Selected");
       assertEquals(calculateButton.getTagName(),"input","Not an input");
       assertEquals(calculateButton.getAttribute("value"),"Calculate BMI","The name is not Equal");
       WebElement invisibleText =driver.findElement(By.id("new_input"));
       assertFalse(invisibleText.isDisplayed());

    }

    @AfterClass()
    public void closeBrowser(){
        driver.quit();
    }







}
