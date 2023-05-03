package com.taskA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class PastebinPage
{

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"postform-text\"]")
    WebElement pasteInput;

    @FindBy(xpath = "//span[@id='select2-postform-expiration-container']")
    WebElement pasteExpirationDropdown;

    @FindBy(xpath = "//li[@class='select2-results__option']")
    List<WebElement> pasteExpirationOptions;

    @FindBy(xpath = "//input[@id='postform-name']")
    WebElement pasteNameInput;

    @FindBy(xpath = "//button[normalize-space()='Create New Paste']")
    WebElement createNewPasteButton;

    public PastebinPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterPasteText(String text)
    {
        pasteInput.sendKeys(text);
    }

    public void selectPasteExpiration()
    {
        pasteExpirationDropdown.click();
        pasteExpirationOptions.get(1).click(); // Select 10 Minutes option
    }

    public void enterPasteName(String name)
    {
        pasteNameInput.sendKeys(name);
    }

    public void clickCreateNewPasteButton()
    {
        createNewPasteButton.click();
    }
}
