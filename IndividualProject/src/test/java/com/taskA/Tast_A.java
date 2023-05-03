package com.taskA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Tast_A
{
    WebDriver driver;
    @BeforeClass
    void setupDriver()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://pastebin.com/");
        driver.manage().window().maximize(); //Full screen.
    }
    @Test(priority = 1)
    void newPaste() throws InterruptedException
    {
        driver.findElement(By.xpath("//*[@id=\"postform-text\"]")).sendKeys("Hello from WebDriver");
        Thread.sleep(2000);
    }
    @Test (priority = 2)
    void pasteExpiration() throws InterruptedException
    {
        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
        jsexecutor.executeScript("window.scrollBy(0,300)", "");
        Thread.sleep(2000);

        //WebElement pasteExpiration = driver.findElement(By.xpath("//li[@class='select2-results__option']"));
        WebElement pasteExpiration = driver.findElement(By.xpath("//span[@id='select2-postform-expiration-container']"));
        pasteExpiration.click();
        Thread.sleep(2000);
        List<WebElement> options = pasteExpiration.findElements(By.xpath("//li[@class='select2-results__option']"));
        options.get(1).click();
        Thread.sleep(2000);
    }
    @Test (priority = 3)
    void pasteName() throws InterruptedException
    {
        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
        jsexecutor.executeScript("window.scrollBy(0,500)", "");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='postform-name']")).sendKeys("helloweb");
        Thread.sleep(2000);
    }
    @Test (priority = 4)
    void createNewPaste() throws InterruptedException
    {
        driver.findElement(By.xpath("//button[normalize-space()='Create New Paste']")).click();
        Thread.sleep(2000);
    }
    @AfterClass
    void closeDriver()
    {
        driver.close();
    }
}
