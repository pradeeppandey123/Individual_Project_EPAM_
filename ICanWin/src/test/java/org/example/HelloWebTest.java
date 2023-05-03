package org.example;

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

public class HelloWebTest
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
    @Test (priority = 1)
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
        Thread.sleep(2000);  //10:38pm🥲

        /*Select select = new Select(pasteExpiration);
        //select.selectByVisibleText("10 Minutes");
        select.selectByIndex(3);
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//span[@id='select2-postform-expiration-container']"))

        /*WebElement pasteExpiration = driver.findElement(By.xpath("//*[@id=\"bt-bait-element\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(pasteExpiration).click().build().perform();*/

        //driver.findElement(By.xpath("//li[@id='select2-postform-expiration-result-j0xn-10M' and @role='option']")).click();

        //driver.findElement(By.xpath("//span[@id='select2-postform-expiration-container']")).click();
        //Thread.sleep(2000);
        /*Select select = new Select(driver.findElement(By.xpath("//span[@id='select2-postform-expiration-container']")));
        select.selectByIndex(3);
        Thread.sleep(2000);*/


        //WebElement expirationDropdown = driver.findElement(By.name("paste_expire_date"));
        //expirationDropdown.sendKeys("10 Minutes");


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
        /*JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
        jsexecutor.executeScript("window.scrollBy(0,360)", "");
        Thread.sleep(2000);*/

        driver.findElement(By.xpath("//button[normalize-space()='Create New Paste']")).click();
        Thread.sleep(2000);
    }
    @AfterClass
    void closeDriver()
    {
        driver.close();
    }
}
