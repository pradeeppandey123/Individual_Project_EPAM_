package com.taskB;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class FactoryBrowser
{
    static WebDriver driver;
    public static WebDriver setupBrowser(String browser, String url)
    {
        if (browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("safari"))
        {
            WebDriverManager.safaridriver().setup();
            driver=new SafariDriver();
        }
        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }
}
