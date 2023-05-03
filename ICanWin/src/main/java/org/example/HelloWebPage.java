package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HelloWebPage
{
    private final WebDriver driver;
    private final By pasteTextField = By.xpath("//*[@id=\"postform-text\"]");
    private final By pasteExpirationDropdown = By.xpath("//span[@id='select2-postform-expiration-container']");
    private final By tenMinutesExpirationOption = By.xpath("//li[@class='select2-results__option'][contains(text(),'10 Minutes')]");
    private final By pasteNameField = By.xpath("//input[@id='postform-name']");
    private final By createNewPasteButton = By.xpath("//button[normalize-space()='Create New Paste']");

    public HelloWebPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void enterPasteText(String text)
    {
        driver.findElement(pasteTextField).sendKeys(text);
    }

    public void clickPasteExpiration()
    {
        WebElement pasteExpiration = driver.findElement(pasteExpirationDropdown);
        pasteExpiration.click();
    }

    public void selectTenMinutesExpiration()
    {
        WebElement pasteExpiration = driver.findElement(pasteExpirationDropdown);
        pasteExpiration.click();
        List<WebElement> options = pasteExpiration.findElements(By.xpath("//li[@class='select2-results__option']"));
        options.get(1).click();
    }

    public void enterPasteName(String name)
    {
        driver.findElement(pasteNameField).sendKeys(name);
    }
}