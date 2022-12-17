package Utils;

import StepsDef.PageInitializer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.management.remote.rmi._RMIConnection_Stub;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageInitializer {
    public static WebDriver driver;
    public static void openBrowserAndLaunchApplication(){
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);

        switch (ConfigReader.getPropertyValue("browser")){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;

            default:
                throw new RuntimeException("Invalid browser name");
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        initializePageObjects();
        //to configure the file and pattern of it we need to call the file
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("My first test case is Login test");
        Log.info("My test is going on");
        Log.warning("My test case might be failed");
    }

    public static void closeBrowser(){
        Log.info("My test case is about to complete");
        Log.endTestCase("This is my login test again");

        driver.quit();

    }

    public static void sendText(WebElement element,String textToSend){
        element.clear();
        element.sendKeys(textToSend);
    }

    public static WebDriverWait getWait(){
        WebDriverWait wait=new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return wait;
    }

    public static void waitForClickabilty(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void click(WebElement element){
        waitForClickabilty(element);
        element.click();
    }

    public static JavascriptExecutor getJSE(){
        JavascriptExecutor js =(JavascriptExecutor) driver;
        return js;
    }
    public static void jsClick(WebElement element){
        getJSE().executeScript("arguments[0].click();",element);

    }

    public static void selectDropdown(WebElement element,String text){
        Select s=new Select(element);
        s.selectByVisibleText(text);
    }


public static byte[] takeScreenShot(String fileName){
    TakesScreenshot ts =(TakesScreenshot) driver;
    byte[] picBytes=ts.getScreenshotAs(OutputType.BYTES);

    File sourceFile=ts.getScreenshotAs(OutputType.FILE);
    try {
        FileUtils.copyFile(sourceFile,new File(Constants.SCREENSHOT_FILEPATH+fileName+" "+getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".png"));
    } catch (IOException e) {
        e.printStackTrace();
    }
    return picBytes;
}
public static String getTimeStamp(String patter){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat(patter);

        return sdf.format(date);

    }


}
