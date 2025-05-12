package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {
    public static WebDriver driver;
    private JavascriptExecutor js;
    private Actions a;
    public static Robot r;
    public Alert al;
    // Method to launch Chrome browser
    public static void launchChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    // Method to launch Edge browser
    public static void launchEdgeBrower() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }

    // Method to close the current window
    public static void close() {
        driver.close();
    }

    // Method to quit the browser
    public static void endBrowser() {
        driver.quit();
    }

    // Method to load the URL
    public static void loadUrl(String url) {
        driver.navigate().to(url);
    }

    // Method to maximize the browser window
    public static void maxWindow() {
        driver.manage().window().maximize();
    }

    // Method to send text to an element
    public static void text(WebElement ele, String text) {
        ele.sendKeys(text);
    }

    // Method to click an element
    public static void click(WebElement ele) {
        ele.click();
    }

    // Method to move the cursor to an element
    public static void cursor(WebElement ele) {
        // Initialize Actions object here
        Actions a = new Actions(driver);
        a.moveToElement(ele).perform();
    }

    // Method for implicit wait
    public static void impWait(int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    // Method to take a screenshot
    public static String snap(String snapName) {
        TakesScreenshot tk = (TakesScreenshot) driver;
        File s = tk.getScreenshotAs(OutputType.FILE);
        File d = new File("C:\\Users\\user\\eclipse-workspace\\New_2025\\Snaps\\" + snapName + ".jpeg");
        try {
            FileUtils.copyFile(s, d);
        } catch (IOException e) {
            System.out.println("Exception Occured while taking Screenshot");
            e.printStackTrace();
        }
		return snapName;
    }

    // Method to scroll to an element
    public static void scroll(WebElement ele) {
        // Initialize JavascriptExecutor here
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", ele);
    }

    // Method to open a new window
    public static void newWindow() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open();");
    }

    public static void alertDismiss() {
    	try {
    	Alert al = driver.switchTo().alert();
    	al.dismiss();
    	}catch(NoAlertPresentException e) {
    		System.out.println("No Alert Present Exception Occured : " + e.getMessage());
    	}catch(Exception e) {
    		System.out.println("Error Occured : " + e.getMessage());
    	}
    }
    public static void flipkartAlert() {
    	try {
    		WebDriverWait w = new WebDriverWait(driver , Duration.ofSeconds(10));
    		WebElement close = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='_30XB9F']")));
    		close.click();
    		System.out.println("---Flip Popup---");
    	}catch(Exception e) {
    		System.out.println("Flipkart Login Pop-up not showed up : " + e.getMessage());
    	}
    }
    
    public static void enterKey() throws AWTException {
    	r = new Robot();
    	r.keyPress(KeyEvent.VK_ENTER);
    	r.keyRelease(KeyEvent.VK_ENTER);
    }
    public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
}
