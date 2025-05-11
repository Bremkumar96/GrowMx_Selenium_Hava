package org.pojo;

import org.base.Base_Class;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pojo extends Base_Class {
	public Pojo() {
		driver.navigate().refresh();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "email")
	private WebElement username;
	
	@FindBy (id = "password")
	private WebElement password;
	
	@FindBy (xpath = "//button[@type='submit']")
	private WebElement submit;
	
	@FindBy (xpath = "//p[text()='Forgot password?']")
	private WebElement forgotPassword;
	
	@FindBy (xpath = "//button[@aria-label='toggle password visibility']")
	private WebElement eyeToggle;
	
	@FindBy (xpath = "//button[text()=\"Reset Password\"]")
	private WebElement resetPassword;
	
	@FindBy (xpath = "//div[text()='AI Assistant']")
	private WebElement homePage;

	public WebElement getHomePage() {
		return homePage;
	}

	@FindBy (xpath = "//button[@aria-label=\"Account\"]")
	private WebElement account;
	
	@FindBy (xpath = "//span[text()='Logout']")
	private WebElement logout;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getForgotPassword() {
		return forgotPassword;
	}

	public WebElement getEyeToggle() {
		return eyeToggle;
	}
	public WebElement getResetPassword() {
		return resetPassword;
	}
	public WebElement getAccount() {
		return account;
	}

	public WebElement getLogout() {
		return logout;
	}

	
	

	
}

