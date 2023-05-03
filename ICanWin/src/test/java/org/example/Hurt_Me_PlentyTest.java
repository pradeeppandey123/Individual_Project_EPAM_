package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Hurt_Me_PlentyTest
{
    WebDriver driver;
    @BeforeClass
    void setupDriver()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://cloud.google.com/");
        driver.manage().window().maximize(); //Full screen.
    }
    @Test(priority = 2)
    public void search() throws InterruptedException
    {
        driver.findElement(By.xpath("/html/body/section/devsite-header/div/div[1]/div/div/div[2]/devsite-search/form/div[1]/div/input")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/section/devsite-header/div/div[1]/div/div/div[2]/devsite-search/form/div[1]/div/input")).sendKeys("Google Cloud Platform Pricing Calculator");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/section/devsite-header/div/div[1]/div/div/div[2]/devsite-search/form/div[1]/div/input")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"___gcse_0\"]/div/div/div/div[5]/div[2]/div/div/div[1]/div[1]/div[1]/div[1]/div/a/b")).click();
        Thread.sleep(9000);

    }/*
    @Test(priority = 3)
    public void CookieConsent()
    {
        driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/span[2]/svg")).click();
    }
    */
    @Test(priority = 3)
    public void Estimate() throws InterruptedException
    {
        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
        jsexecutor.executeScript("window.scrollBy(0,300)", "");
        Thread.sleep(2000);

        //driver.findElement(By.cssSelector(".gsc-webResult:nth-child(1) > .gs-webResult > .gsc-thumbnail-inside b")).click();
        // 7 | selectFrame | index=0 |
        driver.switchTo().frame(0);
        // 8 | selectFrame | index=0 |
        driver.switchTo().frame(0);
        // 9 | click | id=input_95 |
        driver.findElement(By.id("input_95")).click();
        Thread.sleep(2000);
        // 10 | type | id=input_95 | 4
        driver.findElement(By.id("input_95")).sendKeys("4");
        Thread.sleep(2000);



        //Operating System

        //WebElement pasteExpiration = driver.findElement(By.xpath("//li[@class='select2-results__option']"));
        WebElement pasteExpiration = driver.findElement(By.xpath("//*[@id=\"select_value_label_87\"]/span[2]"));
        pasteExpiration.click();
        Thread.sleep(2000);
        List<WebElement> options = pasteExpiration.findElements(By.xpath("//*[@id=\"select_option_97\"]"));
        options.get(0).click();
        Thread.sleep(2000);

        WebElement pasteExpiration1 = driver.findElement(By.xpath("//*[@id=\"select_value_label_88\"]/span[2]"));
        pasteExpiration1.click();
        Thread.sleep(2000);
        List<WebElement> options1 = pasteExpiration1.findElements(By.xpath("//*[@id=\"select_option_110\"]"));
        options1.get(0).click();
        Thread.sleep(2000);

        WebElement pasteExpiration2 = driver.findElement(By.xpath("//*[@id=\"select_value_label_90\"]/span[2]"));
        pasteExpiration2.click();
        Thread.sleep(2000);
        List<WebElement> options2 = pasteExpiration2.findElements(By.xpath("//*[@id=\"select_option_211\"]"));
        options2.get(0).click();
        Thread.sleep(2000);


        WebElement pasteExpiration3 = driver.findElement(By.xpath("//*[@id=\"select_value_label_91\"]/span[1]/div"));
        pasteExpiration3.click();
        Thread.sleep(2000);
        List<WebElement> options3 = pasteExpiration3.findElements(By.xpath("//*[@id=\"select_option_450\"]/div[1]"));
        options3.get(0).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"mainForm\"]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[13]/div[1]/md-input-container/md-checkbox/div[2]")).click();

        WebElement pasteExpiration4 = driver.findElement(By.xpath("//*[@id=\"select_486\"]"));
        pasteExpiration4.click();
        Thread.sleep(2000);
        List<WebElement> options4 = pasteExpiration4.findElements(By.xpath("//*[@id=\"select_option_493\"]/div"));
        options4.get(0).click();
        Thread.sleep(2000);

        WebElement pasteExpiration5 = driver.findElement(By.xpath("//*[@id=\"select_488\"]"));
        pasteExpiration5.click();
        Thread.sleep(2000);
        List<WebElement> options5 = pasteExpiration5.findElements(By.xpath("//*[@id=\"select_option_496\"]/div"));
        options5.get(0).click();
        Thread.sleep(2000);

        WebElement pasteExpiration6 = driver.findElement(By.xpath("//*[@id=\"select_value_label_444\"]/span[1]"));
        pasteExpiration6.click();
        Thread.sleep(2000);
        List<WebElement> options6 = pasteExpiration6.findElements(By.xpath("//*[@id=\"select_option_471\"]/div"));
        options6.get(0).click();
        Thread.sleep(2000);

        WebElement pasteExpiration7 = driver.findElement(By.xpath("//*[@id=\"select_value_label_93\"]"));
        pasteExpiration7.click();
        Thread.sleep(2000);
        List<WebElement> options7 = pasteExpiration7.findElements(By.xpath("//*[@id=\"select_option_252\"]/div"));
        options7.get(0).click();
        Thread.sleep(2000);

        WebElement pasteExpiration8 = driver.findElement(By.xpath("//*[@id=\"select_value_label_94\"]"));
        pasteExpiration8.click();
        Thread.sleep(2000);
        List<WebElement> options8 = pasteExpiration8.findElements(By.xpath("//*[@id=\"select_option_133\"]/div"));
        options8.get(0).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"mainForm\"]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[20]/button")).click();


    }


}