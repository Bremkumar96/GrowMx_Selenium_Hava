package org.test;

import java.time.Duration;
import java.util.List;

import org.base.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Calender extends Base_Class {
	@Test
	private void tc001() throws InterruptedException {
	launchChromeBrowser();
	loadUrl("https://www.busindia.com/");
	maxWindow();
	WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
	String year = "2026";
	String month = "April";
	String date = "15";
	
	try{
		WebElement pop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='close']")));
		pop.click();
	}catch(Exception e){System.out.println(e.getMessage());
	}
	driver.findElement(By.xpath("//input[@id='txtdeptDateRtrip']")).click();
	
	

	while(true) {
		WebElement yearEle = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
		WebElement monthEle = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
		String yearString = yearEle.getText();
		String monthString = monthEle.getText();
		
		if (yearString.equals(year) &&  monthString.equals(month)) {
			break;
		}
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		Thread.sleep(300);
	}
	
	List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td//a"));
	for (WebElement webElement : allDates) {
		String d = webElement.getText();
		if (d.equals(date)) {
			webElement.click();
			break;
		}
	}
	
	
	// endBrowser();

	}
}


