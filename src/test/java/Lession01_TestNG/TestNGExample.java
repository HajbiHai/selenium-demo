package Lession01_TestNG;

import org.testng.annotations.*;

public class TestNGExample {
    @AfterMethod
    public void finishMethod(){
        System.out.println("After method");
    }

    @BeforeMethod
    public void startMethod(){
        System.out.println("Before method");
    }
    @AfterClass
    public void closeSession(){
        System.out.println("After class");
    }

    @BeforeClass
    public void startSession(){
        System.out.println("Before class");
    }

    @Test
    public void test01(){
        System.out.println("test1");
    }

    @Test
    public void test02(){
        System.out.println("test2");
    }


}
