package com.snow.pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.snow.base.ReusableLibrary;

public class SystemSupportRequestPage extends ReusableLibrary {
	public WebDriver driver;

	public SystemSupportRequestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[@title='System Support Request']")
	public WebElement systemsupportrequest;

	@FindBy(xpath = "//div[@id='select2-drop']/ul/li[3]/div")
	public WebElement ssr_op3;

	@FindBy(xpath = "//textarea[@id='sp_formfield_describe_req']")
	public WebElement ssr_reqdesc;

	@FindBy(xpath = "//*[@id='s2id_sp_formfield_hrit_system']/a")
	public WebElement ssr_hrsystem;

	@FindBy(xpath = "//div[contains(@class,'text-right ng-scope')]//button[contains(@name,'submit')][contains(text(),'Submit')]")
	public WebElement submit;

//-----------------------Case ITIL Virew ---------------------------

	@FindBy(xpath = "//*[@id='xf9fbccf3c3603200b599b4ad81d3ae80']/div[1]/div[1]/div[1]/div[2]")
	public WebElement caseid;

	@FindBy(xpath = "//input[@id='filter']")
	public WebElement navigator;

	// @FindBy(xpath="//*[@id='7a5330019f22120047a2d126c42e70e0']/div")

	@FindBy(xpath = "//a[@id='3f0370019f22120047a2d126c42e7076']//div[@class='sn-widget-list-title'][contains(text(),'All')]")
	public WebElement allcase;

	@FindBy(xpath = ".//table[@id='sn_hr_core_case_table']//input[@id='sn_hr_core_case_table_header_search_control']")
	public WebElement casenumber;

	@FindBy(xpath = "//a[@class='linked formlink']")
	public WebElement itil_caseID;

	// @FindBy(xpath =
	// "//input[@id='sys_display.sn_hr_core_case_operations.assignment_group']")
	@FindBy(xpath = "")
	public WebElement assignment_group;

	// @FindBy(xpath = ".//*[@id='sn_hr_core_case_operations.priority']")
	@FindBy(xpath = "")
	public WebElement operations_priority;

	// @FindBy(xpath =
	// ".//*[@id='sys_display.sn_hr_core_case_operations.hr_service']")
	@FindBy(xpath = "")
	public WebElement operations_hr_service;

	// @FindBy(xpath =
	// ".//*[@id='sys_display.sn_hr_core_case_operations.opened_for']")
	@FindBy(xpath = "")
	public WebElement operations_opened_for;

	@FindBy(xpath = "//button[text() = 'Submit' and contains(@class, 'btn btn-primary ng-binding ng-scope')]")
	public WebElement submitButton;

	@FindBy(xpath = "//*[contains(@id,'sys_readonly.sn_hr_core_case_') and contains(@id,'.number')]")
	public WebElement caseNumber;

	@FindBy(xpath = "//*[@id='sysverb_update']")
	public WebElement updateButton;

	String expectedag = "HRSM - Contact Center";
	String expectedpr = "2 - Moderate";
	String expectedhrservice = "System Support Request";

	public void create_systemsupportrequest(String desc, String hrSystem) throws InterruptedException, IOException {
		PageFactory.initElements(driver, SystemSupportRequestPage.class);
		waitForElementToBeClickable(driver, ssr_reqdesc);
		Actions actions = new Actions(driver);
		waitForElement(driver, ssr_reqdesc);
		ssr_reqdesc.sendKeys(desc);
		checkForPageLoad(driver);
		actions.sendKeys(ssr_hrsystem, hrSystem).build().perform();
		checkForPageLoad(driver);

		WebElement element = driver
				.findElement(By.xpath("//ul[@role = 'listbox']/li/div[contains(text(), '" + hrSystem + "')]"));
		waitForElementToBeClickable(driver, element);
		element.click();
		waitForAction(driver);
		waitForElementToBeClickable(driver, submitButton);
		// actions.click(submitButton).build().perform();
		submitButton.click();
		waitForPageLoad(driver);
	}

	public void validateSystemSupportRequestITIL(String filter, String caseID) throws IOException {
		PageFactory.initElements(driver, SystemSupportRequestPage.class);
		waitForElementToBeClickable(driver, navigator);
		navigator.sendKeys(filter);

		waitForElementToBeClickable(driver, allcase);
		allcase.click();
		driver.switchTo().frame(0);
		waitForPageLoad(driver);
		waitForElementToBeClickable(driver, casenumber);
		casenumber.sendKeys(caseID);
		waitForAction(driver);
		casenumber.sendKeys(Keys.ENTER);
		waitForElementToBeClickable(driver, itil_caseID);
		itil_caseID.click();
		waitForPageLoad(driver);

		if (updateButton.isDisplayed()) {
			System.out.println("Navigated successfully to ITIL view for - " + caseID);
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Navigated successfully to ITIL view for - " + caseID, ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}
}