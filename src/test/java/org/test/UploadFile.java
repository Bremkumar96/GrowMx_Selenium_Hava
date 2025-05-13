package org.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.base.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class UploadFile extends Base_Class {
	
	@Test
	private void tc1() throws InterruptedException, AWTException {
		launchEdgeBrower();
		loadUrl("https://www.ilovepdf.com/edit-pdf");
		Thread.sleep(3000);
		WebElement upload = driver.findElement(By.xpath("//span[text()='Select PDF file']"));
		upload.click();
		
		StringSelection filePath = new StringSelection("C:\\Users\\user\\Downloads\\Brem-Kumar-S-Resume.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
		System.out.println(filePath);
		Robot r = new Robot();
		r.delay(300);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		r.delay(300);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		snap("uploadnew");
//		Thread.sleep(3000);
		
//		WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
//		fileInput.sendKeys("C:\\Users\\user\\Downloads\\Brem-Kumar-S-Resume.pdf");
//		Thread.sleep(3000);
//		snap("upload2");
		endBrowser();

	}
}
