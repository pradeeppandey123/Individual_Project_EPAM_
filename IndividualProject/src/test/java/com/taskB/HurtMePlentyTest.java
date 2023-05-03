package com.taskB;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HurtMePlentyTest
{
    /*@Test
    public void verifyHurtMePlentyTest() throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.openHomePage();
        homePage.searchFor("Google Cloud Platform Pricing Calculator");

        SearchResultsPage searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
        searchResultsPage.clickOnSearchResult();

        PricingCalculatorPage pricingCalculatorPage = PageFactory.initElements(driver, PricingCalculatorPage.class);
        pricingCalculatorPage.setNoOfInstances();
        pricingCalculatorPage.setSeries();
        pricingCalculatorPage.setMachineTypes();
        pricingCalculatorPage.setSustainedUseDiscounts();
        pricingCalculatorPage.setAddGPUs();
        pricingCalculatorPage.setGpuType();
        pricingCalculatorPage.setNoOfGPUs();
        pricingCalculatorPage.setLocalSSD();
        pricingCalculatorPage.setCommittedUsage();
        pricingCalculatorPage.setAddToEstimate();

        homePage.quit();
    }*/

    WebDriver driver;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    PricingCalculatorPage pricingCalculatorPage;
    @Test(groups = {"functional","smoke"}, priority = 1) //(priority = 1)
    //@BeforeClass
    public void environmentTest()
    {
        driver = FactoryBrowser.setupBrowser("chrome","https://cloud.google.com/");
        homePage = PageFactory.initElements(driver, HomePage.class);
        searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
        pricingCalculatorPage = PageFactory.initElements(driver, PricingCalculatorPage.class);
    }

    @Test(groups = {"functional","smoke"}, priority = 2) //(priority = 2)
    public void homePageTest() throws InterruptedException
    {
        homePage.searchFor("Google Cloud Platform Pricing Calculator");
    }
    @Test(groups = {"functional","smoke"}, priority = 3) //(priority = 3)
    void clickOnSearchResult() throws InterruptedException
    {
        searchResultsPage.clickOnSearchResult();
        Thread.sleep(5000);
    }
    @Test(groups = {"smoke"}, priority = 4) //(priority = 4)
    void noOfInstance() throws InterruptedException
    {
        pricingCalculatorPage.setNoOfInstances();
    }
    @Test(groups = {"smoke"}, priority = 5) //(priority = 5)
    void setSeries() throws InterruptedException
    {
        pricingCalculatorPage.setSeries();
    }
    @Test(groups = {"smoke"}, priority = 6)//(priority = 6)
    void setMachineTypes() throws InterruptedException
    {
        pricingCalculatorPage.setMachineTypes();
    }
    @Test(groups = {"smoke"}, priority = 7)//(priority = 7)
    void setSustainedUseDiscounts() throws InterruptedException
    {
        pricingCalculatorPage.setSustainedUseDiscounts();
    }
    @Test(groups = {"smoke"}, priority = 8)//(priority = 8)
    void setAddGPUs() throws InterruptedException
    {
        pricingCalculatorPage.setAddGPUs();
    }
    @Test(groups = {"smoke"}, priority = 9)//(priority = 9)
    void setGpuType() throws InterruptedException
    {
        pricingCalculatorPage.setGpuType();
    }
    @Test(groups = {"smoke"}, priority = 10)//(priority = 9)
    void setNoOfGPUs() throws InterruptedException
    {
        pricingCalculatorPage.setNoOfGPUs();
    }
    @Test(groups = {"smoke"}, priority = 11)//(priority = 10)
    void setLocalSSD() throws InterruptedException
    {
        pricingCalculatorPage.setLocalSSD();
    }
    @Test(groups = {"smoke"}, priority = 12)//(priority = 11)
    void setCommittedUsage() throws InterruptedException
    {
        pricingCalculatorPage.setCommittedUsage();
    }
    @Test(groups = {"smoke"}, priority = 13)//(priority = 12)
    void setAddToEstimate() throws InterruptedException
    {
        pricingCalculatorPage.setAddToEstimate();
    }
    //@AfterClass
    @Test(groups = {"smoke"}, priority = 14)
    void closeDriver()
    {
        homePage.closeDrive();
    }
    /*@AfterMethod
    void takeScreenshot() throws IOException
    {
        pricingCalculatorPage.takeScreenshot(driver);
    }*/
    @AfterMethod(groups = {"smoke"})
    void takeScreenshotOnFailure(ITestResult result)
    {
        if (result.getStatus() == ITestResult.FAILURE)
        {
            // Convert driver to TakesScreenshot interface
            /*TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            // Get the screenshot as a file
            File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);*/

            // Create the screenshot object
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            // Take the screenshot as a file
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            try
            {
                // Define the screenshot directory
                //String screenshotDir = System.getProperty("user.dir") + "/screenshots/"; ///Users/smitabose/Desktop
                /*String screenshotDir = System.getProperty("/Users/smitabose/Desktop") + "/screenshot/";
                // Create the directory if it doesn't exist
                //new File(screenshotDir).mkdirs();
                // Define the screenshot file name with the current date and time
                String screenshotName = result.getMethod().getMethodName() + "_" + new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()) + ".png";
                // Copy the screenshot file to the screenshot directory
                FileUtils.copyFile(screenshot, new File(screenshotDir + screenshotName));
                System.out.println("Screenshot taken and saved to: " + screenshotDir + " ---> " + screenshotName);*/

                // Create a destination file with the current date and time as the filename
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
                String fileName = "screenshot" + dateFormat.format(new Date()) + ".png";
                File destination = new File("/Users/smitabose/Desktop/sceenshot" + fileName);
                // Copy the source file to the destination file
                FileUtils.copyFile(source, destination);
                System.out.println("Screenshot taken and saved to: " + source + "  --->  "+ destination);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
