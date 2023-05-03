package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HurtMePlenty
{
    WebDriver driver;
    @BeforeClass
    void setupDriver()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // Navigate to the Google Cloud website
        driver.get("https://cloud.google.com/");
        driver.manage().window().maximize(); //Full screen.
    }
    @Test(priority = 1)
        // Find the search box and enter the search query
    void search() throws InterruptedException
    {
        /*driver.findElement(By.cssSelector(".devsite-top-logo-row-middle")).click();
        // 4 | type | name=q | Google Cloud Platform Pricing Calculator
        driver.findElement(By.name("q")).sendKeys("Google Cloud Platform Pricing Calculator");
        Thread.sleep(5000);*/
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Google Cloud Platform Pricing Calculator", Keys.ENTER);
        Thread.sleep(5000);
    }
    @Test (priority = 2) //(dependsOnMethods = {"search"})
        // Find the search result for the Google Cloud Pricing Calculator and click on it
    void result() throws InterruptedException
    {
        //WebElement searchResult = driver.findElement(By.partialLinkText("Google Cloud Pricing"));
        WebElement searchResult = driver.findElement(By.xpath("//div[@class='gs-title']//b[contains(text(),'Google Cloud Pricing Calculator')]"));
        searchResult.click();
        Thread.sleep(5000);
    }

    @Test (priority = 3)
        // Fill out the form with the required data
    void fillData() throws InterruptedException
    {
        //driver.findElement(By.cssSelector(".gsc-webResult:nth-child(1) > .gs-webResult > .gsc-thumbnail-inside b")).click();
        // 7 | selectFrame | index=0 |
        driver.switchTo().frame(0);
        // 8 | selectFrame | index=0 |
        driver.switchTo().frame(0);
        // 9 | click | id=input_95 |
        driver.findElement(By.id("input_95")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("input_95")).sendKeys("4");
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#select_value_label_90 > span:nth-child(1)")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("select_option_211")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#select_value_label_91 > span:nth-child(1)")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("select_option_450")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".layout-row:nth-child(15) .md-container")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("select_486")).click();
        Thread.sleep(2000);

        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
        jsexecutor.executeScript("window.scrollBy(0,600)", "");
        Thread.sleep(2000);


        driver.findElement(By.cssSelector("#select_option_491 > .md-text")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#select_value_label_485 > span:nth-child(1)")).click();
        Thread.sleep(2000);

        JavascriptExecutor jsexecutor1 = (JavascriptExecutor) driver;
        jsexecutor1.executeScript("window.scrollBy(0,300)", "");
        Thread.sleep(2000);


        driver.findElement(By.id("select_option_496")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#select_value_label_444 > span:nth-child(1)")).click();
        Thread.sleep(2000);

        JavascriptExecutor jsexecutor2 = (JavascriptExecutor) driver;
        jsexecutor2.executeScript("window.scrollBy(0,300)", "");
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#select_option_471 > .md-text")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#select_value_label_93 > span:nth-child(1)")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("select_option_252")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#select_value_label_94 > span:nth-child(1)")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("select_option_133")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".layout-align-end-start:nth-child(22) > .md-raised")).click();
        Thread.sleep(2000);
    }
    @Test (priority = 4)
    void estimate() throws InterruptedException
    {
        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
        jsexecutor.executeScript("window.scrollBy(0,900)", "");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//form[@name='ComputeEngineForm']//button[@type='button'][normalize-space()='Add to Estimate']")).click();
        Thread.sleep(2000);
    }
    @AfterClass
    void closeDriver()
    {
        driver.close();
    }
}
