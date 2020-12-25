package com.snow.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import com.snow.base.ReusableLibrary;

public class LoginPage extends ReusableLibrary {
	WebDriver driver;
	@FindBy(xpath = "//input[@id='user_name']")
	public WebElement userName;

	@FindBy(xpath = "//input[@id='user_password']")
	public WebElement password;

	@FindBy(xpath = "//button[@id='sysverb_login']")
	public WebElement login;

	@FindBy(xpath = "//span[contains(text(),'Make a Request')]")
	public WebElement makearequest;

	@FindBy(xpath = "//*[@class='dropdown-menu']")
	public WebElement userMenu;

	@FindBy(xpath = "//*[@id='output_messages']/div/div/div")
	public WebElement errLogin;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}

	public void snowLogin(String username, String pwd) {
		PageFactory.initElements(driver, LoginPage.class);
		driver.get(loginURL);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, userName);

		if (!isElementPresent(userName)) {
			driver.get(loginURL);
			checkForPageLoad(driver);
		}
		
		waitForElementToBeClickable(driver, userName);
		userName.clear();
		waitForAction(driver);
		System.out.println("Entering username " + username);
		userName.sendKeys(username);

		waitForElementToBeClickable(driver, password);
		password.clear();
		waitForAction(driver);
		System.out.println("Entering password " + pwd);
		password.sendKeys(pwd);

		waitForElementToBeClickable(driver, login);
		login.click();
	}

	public void snowLoginSME() {
		PageFactory.initElements(driver, LoginPage.class);
		userName.clear();
		userName.sendKeys(kbSmeUser);
		password.clear();
		password.sendKeys(kbSmePassword);
		login.click();

	}

	public void logout() {
		PageFactory.initElements(driver, LoginPage.class);
		Select select = new Select(userMenu);
		select.selectByVisibleText("Logout");
	}
}