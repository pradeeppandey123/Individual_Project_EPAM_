package com.taskB;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
    WebDriver driver;

    @FindBy(name = "q")
    WebElement searchBox;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openHomePage()
    {
        driver.get("https://cloud.google.com/");
        driver.manage().window().maximize();
    }

    public void searchFor(String searchQuery) throws InterruptedException
    {
        searchBox.sendKeys(searchQuery, Keys.ENTER);
        Thread.sleep(5000);
    }

    public void closeDrive()
    {
        driver.close();
        driver.quit();
    }

}
