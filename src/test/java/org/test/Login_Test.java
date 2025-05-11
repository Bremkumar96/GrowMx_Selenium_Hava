package org.test;

import java.awt.AWTException;
import java.time.Duration;

import org.base.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v119.layertree.model.SnapshotId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pojo.Pojo;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login_Test extends Base_Class {
	static Pojo p;
	static String a = "";
	
	WebDriverWait w;
	@BeforeClass
	private void startBrowser() {
		launchChromeBrowser();
		maxWindow();
		p = new Pojo();
		w = new WebDriverWait(driver , Duration.ofSeconds(3));
	}
	@AfterClass
	private void quitBrowser() {
		endBrowser();
	}
	@BeforeMethod
	private void loadUrl() {
		loadUrl("https://agents.gromaxx.ai/login");
	}
	@AfterMethod
	private static void takeSnap() {
		snap(a);
	//	a++;	
	}
	// Login with valid credentials
	@Test (dataProvider = "validCredentials")
	private void tc1(String text1 , String text2) {
		text(p.getUsername(), text1);
		text(p.getPassword(), text2);
		click(p.getSubmit());
		WebElement not = w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h5[text()='Welcome to GroMaxx AI Assistant']")));
		Assert.assertTrue(not.isDisplayed(), "Account Button not displayed, Invalid Cred");
		a="tc1";
	}
	// Login with Invalid credentials
//	@Test (dataProvider = "invalidCred")
	private void tc2(String text1 , String text2) {
		text(p.getUsername(), text1);
		text(p.getPassword(), text2);
		click(p.getSubmit());
		a = "Invalid Cred";
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='AI Assistant']")));
		Assert.assertTrue(p.getHomePage().isDisplayed(), "Account Button not displayed, Invalid Cred");
		
	}
	// Password visiblity
//	@Test
	public void tc3() {
		text(p.getPassword(), "String@123");
		click(p.getEyeToggle());
		a = "Eye_Toggle";
	}
	//Reset Password
//	@Test
	public void tc4() {
		click(p.getForgotPassword());
		w.until(ExpectedConditions.elementToBeClickable(p.getResetPassword()));
		Assert.assertTrue(p.getResetPassword().isDisplayed(), "Reset page not re-directed");
		a = "Reset_Password";
	}
	
	//Logout
	@Test (dataProvider = "validCred")
	private void tc5(String text1 , String text2) {
		text(p.getUsername(), text1);
		text(p.getPassword(), text2);
		click(p.getSubmit());
		click(w.until(ExpectedConditions.elementToBeClickable(p.getAccount())));
		click(w.until(ExpectedConditions.elementToBeClickable(p.getLogout())));
		a = "LLogged_Out_Login_Page";
	}
	
	@DataProvider(name = "validCred")
	private Object[][] getValidData(){
		return new Object[][] {
			{"vishnu.v.t@gmail.com"	,"String@123"},
		};
	}
	
	@DataProvider (name = "invalidCred")
	private Object[][] getInvalidData(){
		return new Object[][] {
			{"vishnu.v.t@gmail.com"	,"string@123"},	
			{"abc@gmail.com" , "String@123"},
			{"" , ""},
		};
	}
	

	
	
}
