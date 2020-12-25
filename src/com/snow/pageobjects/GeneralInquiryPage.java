package com.snow.pageobjects;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.snow.base.ReusableLibrary;

public class GeneralInquiryPage extends ReusableLibrary {
	public WebDriver driver;

	public GeneralInquiryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[@title='General Inquiry']")
	public WebElement generalinquiry;

	@FindBy(xpath = "//h1[contains(@class,'h2 m-t-none m-b-sm font-thin ng-binding ng-scope')]")
	public WebElement ge_fieldname;

	@FindBy(xpath = "//textarea[@id='sp_formfield_what_is_your_question']")
	public WebElement questionTextbox;

	@FindBy(xpath = "//div[contains(@class,'text-right ng-scope')]//button[contains(@name,'submit')][contains(text(),'Submit')]")
	public WebElement submit;

	@FindBy(xpath = "//a[@id='71914d8d37e213002fc0c7d1b3990e70']")
	public WebElement employeeservices;

	@FindBy(xpath = "//*[@id='xf9fbccf3c3603200b599b4ad81d3ae80']/div[1]/div[1]/div[1]/div[2]")
	public WebElement caseid;

	// -----------------------Case ITIL Virew ---------------------------

	@FindBy(xpath = "	//input[@id='filter']")
	public WebElement leftsearch;

	// @FindBy(xpath="//*[@id='7a5330019f22120047a2d126c42e70e0']/div")

	@FindBy(xpath = "//a[@id='3f0370019f22120047a2d126c42e7076']//div[@class='sn-widget-list-title'][contains(text(),'All')]")
	public WebElement allcase;

	@FindBy(xpath = ".//table[@id='sn_hr_core_case_table']//input[@id='sn_hr_core_case_table_header_search_control']")
	public WebElement casenumber;

	@FindBy(xpath = "//a[@class='linked formlink']")
	public WebElement itil_caseID;

	@FindBy(xpath = "//input[@id='sys_display.sn_hr_core_case.assignment_group']")
	public WebElement assignment_group;

	@FindBy(xpath = ".//*[@id='sn_hr_core_case.priority']")
	public WebElement priority;

	@FindBy(xpath = ".//*[@id='sys_display.sn_hr_core_case.hr_service']")
	public WebElement hr_service;

	@FindBy(xpath = ".//*[@id='sys_display.sn_hr_core_case.opened_for']")
	public WebElement opened_for;

	@FindBy(xpath = "//*[@id='catItemTop']/div/div[1]/h1")
	public WebElement formHeading;

//	--------------------------------------------------Portal ----------------------------------------
	@FindBy(xpath = "//dt[contains(text(),'Opened for')]")
	public WebElement portal_opened_for;

	@FindBy(xpath = "//dl[contains(@class,'row caseDescriptor')]//div[1]//div[1]//div[2]//dd[1]//a[1]")
	public WebElement portal_opened_for_user;

	@FindBy(xpath = "//dt[contains(text(),'Subject person')]")
	public WebElement portal_subject_person;

	@FindBy(xpath = "//dl[contains(@class,'row caseDescriptor')]//div[2]//div[1]//div[2]//dd[1]//a[1]")
	public WebElement portal_subject_person_user;

	@FindBy(xpath = "//dt[contains(@class,'header-label ng-binding formatLabels')]")
	public WebElement portal_short_description;

	@FindBy(xpath = "//dd[contains(@class,'formatDesc ng-binding text-a formatText ng-scope formatLabels')]")
	public WebElement portal_short_description_content;

	@FindBy(xpath = "//div[contains(@class,'description panel b')]//h4[contains(@class,'panel-title')]")
	public WebElement portal_description;

	@FindBy(xpath = "//div[@class='case-title ng-binding']")
	public WebElement portal_title;

	@FindBy(css = ".col-sm-2 > div:nth-child(3) > a:nth-child(1)")
	public WebElement portal_cancel_case;

	@FindBy(xpath = "//*[@id='catItemTop']/div/div[3]/div/div[1]/button")
	public WebElement submitButton;

	@FindBy(xpath = "//*[@class='ng-binding' and @ng-bind-html = '::m.message']")
	public WebElement errorMandatoryFields;

	@FindBy(xpath = "//*[@aria-label='Close Notification']")
	public WebElement closeError;

	String expectedag = "HRSM - Contact Center";
	String expectedpr = "2 - Moderate";
	String expectedhrservice = "General Inquiry";
	String expectedOpenedFor = "HR_User_QA";

	public void createGeneralInquiry(String question) throws IOException, InterruptedException {
		PageFactory.initElements(driver, GeneralInquiryPage.class);
		driver.navigate().refresh();
		waitForElementToBeClickable(driver, questionTextbox);
		if (questionTextbox.isDisplayed()) {
			logInfo("Entering the question in What is your question? field");
			questionTextbox.sendKeys(question);
			waitForAction(driver);
			waitForElementToBeClickable(driver, questionTextbox);
			questionTextbox.sendKeys(Keys.TAB);
			System.out.println("Text entered in Question Text box.");
			formHeading.click();
			checkForPageLoad(driver);
		} else {
			logFailure("What is your question? field is not displayed");
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		logInfo("Submitting the General Inquiry after filling the mandatory fields");
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		waitForElementToBeClickable(driver, submitButton);
		submitButton.click();
		checkForPageLoad(driver);
	}

	public void validateMandatoryFields() throws IOException {
		PageFactory.initElements(driver, GeneralInquiryPage.class);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, submitButton);
		submitButton.click();
		
		if (errorMandatoryFields.isDisplayed()) {
			logInfo("Some Fields are incomplete Error Message is displayed.");
			String errorString = errorMandatoryFields.getText().split(": ")[1];
			String[] errorFields = errorString.split(",");
			logInfo("Mandatory Fields are:");
			for (int i = 0; i < errorFields.length; i++) {
				logInfo("- " + errorFields[i]);
			}
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			waitForElementToBeClickable(driver, closeError);
			closeError.click();
		} else {
			logFailure("Error Message for Mandatory Fields is not displayed.");
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}
}