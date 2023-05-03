package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class HelloWebPageTest
{
    WebDriver driver;
    HelloWebPage helloWebPage;

    @BeforeClass
    void setupDriver()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://pastebin.com/");
        driver.manage().window().maximize(); //Full screen.
        helloWebPage = new HelloWebPage(driver);
    }

    @Test (priority = 1)
    void newPaste() throws InterruptedException
    {
        helloWebPage.enterPasteText("Hello from WebDriver");
        Thread.sleep(2000);
    }

    @Test (priority = 2)
    void pasteExpiration() throws InterruptedException
    {
        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
        jsexecutor.executeScript("window.scrollBy(0,300)", "");
        Thread.sleep(2000);

        helloWebPage.clickPasteExpiration();
        helloWebPage.selectTenMinutesExpiration();
        Thread.sleep(2000);
    }

    @Test (priority = 3)
    void pasteName() throws InterruptedException
    {
        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
        jsexecutor.executeScript("window.scrollBy(0,500)", "");
        Thread.sleep(2000);

        helloWebPage.enterPasteName("helloweb");
        Thread.sleep(2000);
    }

    /*@Test (priority = 4)
    void createNewPaste() throws InterruptedException
    {
        helloWebPage.clickCreateNewPaste();
        Thread.sleep(2000);
    }*/

    @AfterClass
    void closeDriver()
    {
        driver.close();
    }
}

