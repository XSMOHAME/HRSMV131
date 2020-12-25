package com.snow.pageobjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.snow.base.ReusableLibrary;

public class HR_Case_Management extends ReusableLibrary {
	public WebDriver driver;

	public HR_Case_Management(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='filter']")
	public WebElement leftSearch;
	@FindBy(xpath = "//div[text()='Create New Case']")
	public WebElement createCase;
	@FindBy(xpath = "//div[text()='Search for Requester']")
	public WebElement searchForHeader;
	@FindBy(xpath = "//*[contains(text(), 'Search for requester')]/parent::a")
	public WebElement searchForRequester;
	@FindBy(xpath = "//*[@class = 'select2-drop select2-display-none select2-with-searchbox select2-drop-active']/ul/li")
	public List<WebElement> uniqueRequester1;
	@FindBy(xpath = "//*[@id='s2id_autogen1_search']")
	public WebElement enterSearchRequester;
	@FindBy(xpath = "//*[@class = 'select2-drop select2-display-none select2-with-searchbox select2-drop-active']/ul")
	public WebElement uniqueRequester;
	@FindBy(xpath = "//div[text()='Case Creation']")
	public WebElement caseCreation;
	@FindBy(xpath = "//div[@class='search-display ev-option row']/div[2]")
	public WebElement requesterSearchBar;

	// --------------------Requester information---------------
	@FindBy(id = "ev_field_user_name_disabled")
	public WebElement name;
	@FindBy(id = "ev_field_u_legal_full_name_disabled")
	public WebElement legalFullName;
	@FindBy(id = "ev_field_u_business_title_disabled")
	public WebElement BusinessTitle;
	@FindBy(xpath = "//div[@id='s2id_ev_field_u_pay_group_disabled']/a")
	public WebElement payGroup;
	@FindBy(xpath = "//div[@id='s2id_ev_field_u_hr_representative_disabled']/a")
	public WebElement hrRepresentative;
	@FindBy(id = "ev_field_user_email_disabled")
	public WebElement email;
	@FindBy(id = "ev_field_work_phone_disabled")
	public WebElement workPhone;
	@FindBy(xpath = "//div[@id='s2id_ev_field_u_company_code_disabled']/a")
	public WebElement companyName;
	@FindBy(xpath = "//input[@id='ev_field_user_active_disabled']")
	public WebElement activeCheckbox;
	@FindBy(xpath = "//input[@id='ev_field_u_job_exempt_disabled']")
	public WebElement jobExemptCheckbox;
	@FindBy(id = "ev_field_u_union_code_disabled")
	public WebElement unionOCCCode;

	// --------------case details--------------------------------
	@FindBy(xpath = "//div[@id='s2id_coe_input']/a")
	public WebElement coe;
	@FindBy(xpath = "//div[@id='s2id_service_input']/a/span")
	public WebElement hrService;
	@FindBy(xpath = "//div[@id='s2id_ev_field_contact_type']/a")
	public WebElement source;
	@FindBy(xpath = "//textarea[@id='ev_field_description']")
	public WebElement description;
	@FindBy(xpath = "//textarea[@id='ev_field_work_notes']")
	public WebElement workNotes;
	@FindBy(xpath = "//div[@id='s2id_ev_field_u_preferred_method_of_contact']")
	public WebElement methodOfContact;
	@FindBy(xpath = "//div[@id='s2id_ev_field_u_preferred_method_of_contact']/a")
	public WebElement methodOfContactTxt;
	@FindBy(xpath = "//input[@id='ev_field_u_details']")
	public WebElement phoneOrEmail;
	@FindBy(xpath = "//select[@id='ev_field_u_preferred_method_of_contact']")
	public WebElement methodOfContactDropdown;
	@FindBy(xpath = "//select[@id='ev_field_contact_type']")
	public WebElement sourceDropDown;
	@FindBy(xpath = "(//button[text()='Create Case'])[2]")
	public WebElement createCaseBt;
	@FindBy(xpath = "//*[@id='s2id_autogen2_search']")
	public WebElement hrServiceDropdown;

	@FindBy(xpath = "//*[@id='select2-drop']/ul/li/ul/li")
	public WebElement hrServiceOption;
	// -----------validate case page---------------------------
	@FindBy(id = "sys_readonly.sn_hr_core_case_payroll.number")
	public WebElement caseNumber;
	@FindBy(id = "sys_display.sn_hr_core_case_payroll.opened_for")
	public WebElement requestedBy;

	// @FindBy(id ='disp_sn_hr_core_case_payroll.hr_profile.work_phone']")
	// @FindBy(xpath =
	// "//input[@id='sys_readonly.sn_hr_core_case_payroll.hr_profile.work_phone']")
	@FindBy(xpath = "//*[@id='sn_hr_core_case_payroll.hr_profile.work_phone']")
	public WebElement workphone;

//	@FindBy(id = "sn_hr_core_case_payroll.opened_for.email")
	@FindBy(id = "sys_readonly.sn_hr_core_case_payroll.opened_for.email")
//	@FindBy(xpath ="//input[@id='sn_hr_core_case_payroll.opened_for.email']")
	public WebElement caseEmail;
	@FindBy(id = "sn_hr_core_case_payroll.u_preferred_method_of_contact")
	public WebElement caseMethodOfContact;
	@FindBy(id = "sn_hr_core_case_payroll.u_details")
	public WebElement casePhoneOrEmail;

	// *[@id='sn_hr_core_case_payroll.hr_profile.u_home_postal_code']
//	@FindBy(id = "sn_hr_core_case_payroll.hr_profile.u_home_postal_code")
	@FindBy(xpath = "//input[@id='sys_readonly.sn_hr_core_case_payroll.hr_profile.u_home_postal_code']")
	public WebElement casePostalCode;
	@FindBy(id = "sys_readonly.sn_hr_core_case_payroll.hr_profile.ssn")
	public WebElement casePinNumber;
	@FindBy(id = "sn_hr_core_case_payroll.state")
	public WebElement caseState;
	@FindBy(id = "sn_hr_core_case_payroll.priority")
	public WebElement casePriority;
	@FindBy(id = "sn_hr_core_case_payroll.contact_type")
	public WebElement caseSource;
	@FindBy(id = "sys_readonly.sn_hr_core_case_payroll.opened_at")
	public WebElement caseOpened;
	@FindBy(id = "sn_hr_core_case_payroll.opened_by_label")
	public WebElement caseOpenedBy;
	@FindBy(id = "sys_display.sn_hr_core_case_payroll.hr_service")
	public WebElement caseHrService;
	@FindBy(id = "sys_display.sn_hr_core_case_payroll.assignment_group")
	public WebElement caseAssignmentGroup;
	@FindBy(id = "sys_display.sn_hr_core_case_payroll.subject_person")
	public WebElement caseAbout;
	@FindBy(id = "status.sn_hr_core_case_payroll.subject_person")
	public WebElement aboutMandatory;
	@FindBy(id = "sys_readonly.sn_hr_core_case_payroll.subject_person.employee_number")
	public WebElement employeeNum;
	@FindBy(id = "sys_readonly.sn_hr_core_case_payroll.subject_person_hr_profile.u_business_title")
	public WebElement businessTitle;
	@FindBy(id = "sn_hr_core_case_payroll.subject_person_hr_profile.u_company_code_label")
	public WebElement caseCompanyName;
	@FindBy(id = "sys_readonly.sn_hr_core_case_payroll.subject_person_hr_profile.u_pay_group")
	public WebElement casePayGroup;
	@FindBy(id = "sys_readonly.sn_hr_core_case_payroll.subject_person_hr_profile.u_union_code")
	public WebElement caseUnionOccCode;
	@FindBy(id = "sys_readonly.sn_hr_core_case_payroll.subject_person_hr_profile.employment_type")
	public WebElement caseEmploymentType;
	@FindBy(id = "sn_hr_core_case_payroll.subject_person_hr_profile.u_hr_representative_label")
	public WebElement caseHrRepresentative;
	@FindBy(id = "ni.sn_hr_core_case_payroll.subject_person.active")
	public WebElement caseActiveCheckbox;
	@FindBy(id = "ni.sn_hr_core_case_payroll.subject_person_hr_profile.u_job_exempt")
	public WebElement caseJobExempt;
	@FindBy(id = "lookup.sn_hr_core_case_payroll.assigned_to")
	public WebElement caseAssignedToSearch;
	@FindBy(xpath = "//select[contains(@id,'_select')]")
	public WebElement searchCriteria;
	@FindBy(xpath = "//input[contains(@id,'_text')]")
	public WebElement searchTextBox;
	@FindBy(xpath = "(//*[@id='sys_user_table_header_search_control'])[1]")
	public WebElement nameSearchTextBox;
	@FindBy(id = "sn_hr_core_case_payroll.short_description")
	public WebElement caseShortDescription;
	@FindBy(id = "sn_hr_core_case_payroll.description")
	public WebElement caseDescription;
	@FindBy(xpath = "//*[contains(@id,'header') and contains(@class,'section_header_div_no_scroll form_title')]")
	public WebElement header;
	@FindBy(xpath = "//*[@role='menuitem' and @title = 'Save record and remain here']")
	public WebElement saveOption;
	@FindBy(xpath = "//div[text()='Save']")
	public WebElement saveBt;
	@FindBy(xpath = "(//label[contains(text(),'Additional comments')])[1]")
	public WebElement addCommentsCheckbox;
	@FindBy(xpath = "//textarea[@id='activity-stream-textarea']")
	public WebElement addComments;
	@FindBy(xpath = "//button[text()='Post']")
	public WebElement postBt;
	@FindBy(xpath = "//textarea[@id='activity-stream-textarea']")
	public WebElement worknotes;
	@FindBy(xpath = "//textarea[@id='activity-stream-work_notes-textarea']")
	public WebElement caseWorknotes;
	@FindBy(id = "sn_hr_core_case_payroll.u_date_and_time_the_check_is_needed")
	public WebElement checkrequestdateTime;
	@FindBy(id = "sys_display.sn_hr_core_case_operations.hr_system")
	public WebElement HRSystem;
	@FindBy(id = "sn_hr_core_hr_employee_services.u_date_and_time_needed")
	public WebElement filerequestDateTime;
	@FindBy(xpath = "//*[@id='user_info_dropdown']/div/span[1]")
	public WebElement loggedUser;
	@FindBy(id = "sys_display.sn_hr_core_case_total_rewards.assigned_to")
	public WebElement assignToText;
	@FindBy(xpath = "//*[contains(@name,'q') and contains(@placeholder,'Ask a Question')]")
	public WebElement searchBox;
	@FindBy(xpath = "(//span[text()='Upload HR Cases'])[1]")
	public WebElement xpUploadcases;
	@FindBy(xpath = "//h1[text()='Upload HR Cases']")
	public WebElement xpUploadCasesHeader;
	@FindBy(xpath = "(//a[text()='here.'])[1]")
	public WebElement xpExcelDownloadLink;
//	@FindBy(xpath = "//*[text()='Add attachments']")
	@FindBy(xpath = "//*[@class='file-upload-input']/input")
	public WebElement xpAddAttachment;
	@FindBy(xpath = "(//button[text()='Submit'])[1]")
	public WebElement xpSubmitBtn;
	@FindBy(xpath = "//a[contains(text(),'Upload HR Cases - ')]")
	public WebElement xpConfirmUpload;
	@FindBy(xpath = "//input[contains(@id,'sys_readonly.sn_hr_core_hr_employee_services.number')]")
	public WebElement xpNumber;
	@FindBy(xpath = "//input[contains(@id,'sys_readonly.sn_hr_core_case_payroll.number')]")
	public WebElement xpNumber2;
	@FindBy(xpath = "//input[contains(@id,'sys_readonly.sn_hr_core_case_total_rewards.number')]")
	public WebElement xpNumber3;
	@FindBy(xpath = "(//*[text()='All HR Cases']/following::div[text()='Open'])[1]")
	public WebElement xpOpen;
	@FindBy(xpath = "(//input[@id='sn_hr_core_case_table_header_search_control'])[1]")
	public WebElement xpNumberSearch;
	@FindBy(xpath = "(//tr[@id='hdr_sn_hr_core_case'])[1]/th[2]")
	public WebElement xpSearchIcon;
	@FindBy(xpath = "//tr[contains(@id,'row_sn_hr_core_case')]/td[4]")
	public WebElement xpPriority;
	@FindBy(xpath = "//tr[contains(@id,'row_sn_hr_core_case')]/td[6]/a")
	public WebElement xpHrService;
	@FindBy(xpath = "//tr[contains(@id,'row_sn_hr_core_case')]/td[11]/a")
	public WebElement xpAssignGroup;
	@FindBy(xpath = "(//i[@data-original-title='Personalize List'])[1]")
	public WebElement gearIcon;
	@FindBy(xpath = "//*[@id='slush_left']/option")
	public List<WebElement> slushLeft;
	@FindBy(xpath = "//*[@id='slush_right']/option")
	public List<WebElement> slushRight;
	@FindBy(xpath = "//span[text()='Add']//parent::a")
	public WebElement addArrow;
	@FindBy(xpath = "//button[@id='ok_button']")
	public WebElement okBtn;
	@FindBy(xpath = "(//th[@glide_label='Approval'])[1]")
	public WebElement addListColumn;
	@FindBy(xpath = "(//i[@data-original-title='Update Personalized List'])[1]")
	public WebElement updatedGearIcon;

	@FindBy(xpath = "//button[@id='sysverb_update']")
	public WebElement updateButton;

	@FindBy(xpath = "//button[@id='reset_column_defaults']")
	public WebElement resetColumns;
	@FindBy(xpath = "(//input[@aria-label=\"Search column: short description\"])[1]")
	public WebElement xpShortDescription;
	@FindBy(xpath = "//div[@class='input-group']//select")
	public WebElement xpSearchDropdown;
	@FindBy(xpath = "//tr[contains(@id,'row_sn_hr_core_case')]/td[3]/a")
	public WebElement xpUniqueCaseid;
	@FindBy(xpath = "//b[text()='All']")
	public WebElement xpRemoveFilter;
	@FindBy(xpath = "//*[@id='s2id_autogen7_search']")
	public WebElement sourceEnter;
	@FindBy(xpath = "//*[@id='s2id_autogen6_search']")
	public WebElement AltEnter;

	String about;
	String hrservice;
	String altText;
	String fileName;
	String caseId;
	String updateCaseTimestamp;
	String updateCaseDescTimestamp;
	String descriptiontimeStamp;
	String browserstackfilename;

	// navigate to create case
	public void navigateCaseManagement() throws Exception {
		waitForElementToBeClickable(driver, leftSearch);
		checkForPageLoad(driver);
		leftSearch.sendKeys("HR CASE");
		checkForPageLoad(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		waitForElementToBeClickable(driver, createCase);
		js.executeScript("arguments[0].click();", createCase);
		checkForPageLoad(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, searchForHeader);
		if (searchForHeader.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Successfully Navigate to Search for Requester Page", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Navigation Failed to Search for requester page", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		checkForPageLoad(driver);
	}

// searching for the active user
	public void confirmActiveUser(String user) throws Exception {
		checkForPageLoad(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");

		waitForElementToBeClickable(driver, searchForRequester);
		searchForRequester.click();
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully clicking the Search for requester dropdown", ExtentColor.CYAN));
		waitForElementToBeClickable(driver, enterSearchRequester);
		enterSearchRequester.sendKeys(user);
		checkForPageLoad(driver);
		try {
			driver.findElement(By.xpath("//ul[@class = 'select2-results']/li"));
		} catch (Exception e) {
			searchForRequester.click();
			waitForElementToBeClickable(driver, enterSearchRequester);
			enterSearchRequester.sendKeys(user);
			checkForPageLoad(driver);
		}
		waitForElementToBeClickable(driver, driver.findElement(By.xpath("//ul[@class = 'select2-results']/li")));

		if (user.contains("_")) {
			user = user.replace("_", " ");
		}

		checkForPageLoad(driver);
		WebElement requestor = driver.findElement(
				By.xpath("//ul[@class = 'select2-results']/li/descendant::div[contains(text(), '" + user + "')]"));
		waitForElementToBeClickable(driver, requestor);

		if (requestor.getText().contains(user)) {
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("Successfully pass the Active User employeename==" + user, ExtentColor.CYAN));
			logInfoScreenshot(driver);
		} else {
			logFailure("Active User is not available in Search Requestor drop down.");
			logFailureScreenshot(driver);
		}
	}

	// searching for the invalid user
	public void confirmInValidUser(String user) {
		checkForPageLoad(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");

		try {
			waitForElementToBeClickable(driver, enterSearchRequester);
			enterSearchRequester.clear();
			enterSearchRequester.sendKeys(user);
		} catch (Exception e) {
			waitForElementToBeClickable(driver, searchForRequester);
			searchForRequester.click();
			waitForElementToBeClickable(driver, enterSearchRequester);
			enterSearchRequester.clear();
			enterSearchRequester.sendKeys(user);
		}

		checkForPageLoad(driver);
		WebElement requestor = driver
				.findElement(By.xpath("//ul[@class = 'select2-results']/li[contains(text(), 'No matches found')]"));
		if (requestor.getText().equals("No matches found")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Successfully validate the InValid Worker data ", ExtentColor.GREEN));
			logSuccess("Expected Value - " + "No matches found");
			logSuccess("Actual Value - " + requestor.getText());
		} else {
			logFailure("Invalid User name is displayed in Search Requestor dropdown");
			logFailureScreenshot(driver);
		}
	}

	// create case and verify fields
	public void createCase(String user) throws Exception {
		waitForElementToBeClickable(driver, enterSearchRequester);

		if (!isElementPresent(enterSearchRequester)) {
			waitForElementToBeClickable(driver, searchForRequester);
			new Actions(driver).click(searchForRequester).build().perform();
			waitForElementToBeClickable(driver, enterSearchRequester);
		}

		enterSearchRequester.clear();
		// searchForRequester.click();
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully clicking the Search for requester dropdown", ExtentColor.CYAN));
		waitForElementToBeClickable(driver, enterSearchRequester);
		enterSearchRequester.sendKeys(user);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, driver.findElement(By.xpath("//ul[@class = 'select2-results']/li")));

		if (user.contains("_")) {
			user = user.replace("_", " ");
		}

		checkForPageLoad(driver);
		WebElement requestor = driver.findElement(
				By.xpath("//ul[@class = 'select2-results']/li/descendant::div[contains(text(), '" + user + "')]"));
		waitForElementToBeClickable(driver, requestor);

		System.out.println("Requester Info - " + requestor.getText());
		requestor.click();
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully pass the Active User employeename==" + user, ExtentColor.CYAN));
		waitForAction(driver);
		if (caseCreation.isDisplayed()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Successdully Navigate to Case Creation Page", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		if (!name.getAttribute("value").isEmpty() && name.getAttribute("disabled").equals("true")) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel(
							"the Name Field is populated with value" + name.getAttribute("value") + "and not Editable",
							ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println(name.getAttribute("value"));
		} else {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("the Name Field is not populated or editable", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		if (!legalFullName.getAttribute("value").isEmpty() && legalFullName.getAttribute("disabled").equals("true")) {
			test.get()
					.log(Status.INFO,
							MarkupHelper.createLabel(
									"the legal full name  Field is populated with value"
											+ legalFullName.getAttribute("value") + "and not Editable",
									ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println(legalFullName.getAttribute("value"));
		} else {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("the legal full name is not populated or editable", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		}
		if (!BusinessTitle.getAttribute("value").isEmpty() && BusinessTitle.getAttribute("disabled").equals("true")) {
			test.get()
					.log(Status.INFO,
							MarkupHelper.createLabel(
									"the Business title  Field is populated with value"
											+ BusinessTitle.getAttribute("value") + "and not Editable",
									ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println(BusinessTitle.getAttribute("value"));
		} else {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("the business title is not populated or editable", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		// Pay Group Field is removed from the application
		/*
		 * if (!payGroup.getText().isEmpty()) { test.get().log(Status.INFO,
		 * MarkupHelper.createLabel( "the pay group Field is populated with value==" +
		 * payGroup.getText() + "and not Editable", ExtentColor.CYAN)); screenshotPath =
		 * getScreenshot(driver, this.getClass().getName()); test.get().info("Details",
		 * MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		 * System.out.println(payGroup.getText()); } else { test.get().log(Status.INFO,
		 * MarkupHelper.createLabel("pay group is not populated or editable",
		 * ExtentColor.CYAN)); screenshotPath = getScreenshot(driver,
		 * this.getClass().getName()); test.get().info("Details",
		 * MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); }
		 */
		if (!hrRepresentative.getText().isEmpty()) {
			test.get().log(Status.INFO, MarkupHelper.createLabel("HR Representative Field is populated with value=="
					+ hrRepresentative.getText() + "and not Editable", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println(hrRepresentative.getText());
		} else {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("HR Representative is not populated or editable", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		if (!email.getAttribute("value").isEmpty() && email.getAttribute("disabled").equals("true")) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel(
							"Email Field is populated with value==" + email.getAttribute("value") + "and not Editable",
							ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println(email.getAttribute("value"));
		} else {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Email  is not populated or editable", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		}
		if (!workPhone.getAttribute("value").isEmpty() && workPhone.getAttribute("disabled").contains("true")) {
			test.get().log(Status.INFO, MarkupHelper.createLabel(
					"Work Phone Field is populated with value==" + workPhone.getAttribute("value") + "and not Editable",
					ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println(workPhone.getAttribute("value"));
		} else {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Work Phone is not populated or editable", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		if (!companyName.getText().isEmpty()) {
			test.get().log(Status.INFO, MarkupHelper.createLabel(
					"the Company name Field is populated with value==" + companyName.getText() + "and not Editable",
					ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println(companyName.getText());
		} else {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Company name is not populated or editable", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		if (activeCheckbox.isDisplayed() && activeCheckbox.isEnabled() == false) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Active Checkbox is displayed and not Editable", ExtentColor.CYAN));
			if (activeCheckbox.isSelected()) {
				test.get().log(Status.INFO,
						MarkupHelper.createLabel("Active Checkbox is selected by default", ExtentColor.CYAN));
			} else {
				test.get().log(Status.INFO,
						MarkupHelper.createLabel("Active Checkbox is Not selected by default", ExtentColor.CYAN));
			}
		} else {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Active Checkbox is Not displayed or Editable", ExtentColor.CYAN));
		}
		if (jobExemptCheckbox.isDisplayed() && jobExemptCheckbox.isEnabled() == false) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("job exempt Checkbox is displayed and not Editable", ExtentColor.CYAN));
			if (activeCheckbox.isSelected()) {
				test.get().log(Status.INFO,
						MarkupHelper.createLabel("job exempt Checkbox is selected by default", ExtentColor.CYAN));
			} else {
				test.get().log(Status.INFO,
						MarkupHelper.createLabel("job exempt Checkbox is Not selected by default", ExtentColor.CYAN));
			}

		}

		else {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("job exempt Checkbox is Not displayed or Editable", ExtentColor.CYAN));
		}
		if (!unionOCCCode.getAttribute("value").isEmpty() && unionOCCCode.getAttribute("disabled").equals("true")) {
			test.get()
					.log(Status.INFO,
							MarkupHelper.createLabel(
									"Union OCC Code Field is populated with value=="
											+ unionOCCCode.getAttribute("value") + "and not Editable",
									ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println(unionOCCCode.getAttribute("value"));
		} else {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Union OCC Code Field is not populated or editable", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		if (coe.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("COE field is displayed", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("COE Field is displayed");

		} else {
			test.get().log(Status.INFO, MarkupHelper.createLabel("COE Field is Not Displayed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("COE Field is Not Displayed");

		}
		if (hrService.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("HR Service field is displayed", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("HR Service Field is displayed");
		} else {
			test.get().log(Status.INFO, MarkupHelper.createLabel("HR Service Field is Not Displayed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("HR Service Field is Not Displayed");

		}
		if (source.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Source field is displayed", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Source Field is displayed");
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Source Field is Not Displayed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Source Field is Not Displayed");
		}
		if (description.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Description field is displayed", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Description Field is displayed");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Description Field is Not Displayed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Description Field is Not Displayed");
		}
		if (workNotes.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Work Notes field is displayed", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Work Notes Field is displayed");
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Work Notes Field is Not Displayed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Work Notes Field is Not Displayed");
		}
		if (methodOfContact.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Prefered method of contact field is displayed", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Prefered method of contact Field is displayed");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Preferred method ofcontact field is Not displayed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Preferred method of contact Field  is Not displayed");
		}
		if (phoneOrEmail.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Phone or email field is displayed", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("phone or email Field is displayed");
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Phone or Email is Not displayed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Phone or Email is Not displayed");
		}

	}

	public void validateSourceDropdown(String dropdown) {
		String expectedDropdown[] = dropdown.split("\\,");
		scrollToElement(driver, source);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, source);
		source.click();
		waitForAction(driver);
		waitForElementToBeClickable(driver, sourceEnter);

		try {
			sourceEnter.sendKeys("Phone", Keys.ENTER);
		} catch (ElementNotInteractableException e) {
			new Actions(driver).click(source).build().perform();
			waitForAction(driver);
			waitForElementToBeClickable(driver, sourceEnter);
			sourceEnter.sendKeys("Phone", Keys.ENTER);
		} catch (Exception e1) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			waitForElementToBeClickable(driver, source);
			js.executeScript("arguments[0].click();", source);
			waitForAction(driver);
			waitForElementToBeClickable(driver, sourceEnter);
			sourceEnter.sendKeys("Phone", Keys.ENTER);
		}

		Select s = new Select(sourceDropDown);
		List<WebElement> options = s.getOptions();

		for (WebElement op : options) {
			for (int i = 0; i < expectedDropdown.length; i++) {
				if (op.getText().equals(expectedDropdown[i])) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel(
									"The Source field dropdown actual and expected values are same " + op.getText(),
									ExtentColor.GREEN));
					System.out.println("The Source field dropdown actual and expected values are same " + op.getText());
				}
			}
		}

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully select the source dropdown value==Phone", ExtentColor.CYAN));

	}

	// validate the method of contact drop down values
	public void validateMethodOfContactDropdown(String dropdown, String hrServicedropdown, String altNumber,
			String descriptionText) throws Exception {

		String expectedDropdown[] = dropdown.split("\\,");
		// Actions a=new Actions(driver);
		// a.moveToElement(methodOfContact).click().build().perform();
		waitForElementToBeClickable(driver, methodOfContact);
		methodOfContact.click();
		checkForPageLoad(driver);
		Select s = new Select(methodOfContactDropdown);
		List<WebElement> options = s.getOptions();
		for (WebElement actualoptions : options) {
			for (int i = 0; i < expectedDropdown.length; i++) {
				if (actualoptions.getText().equals(expectedDropdown[i])) {
					test.get().log(Status.PASS,
							MarkupHelper
									.createLabel("method of contact field dropdown actual and expected values are same "
											+ actualoptions.getText(), ExtentColor.GREEN));
					System.out.println("method of contact field dropdown actual and expected values are same "
							+ actualoptions.getText());
				}
			}
		}
		// s.selectByVisibleText("Alternate Contact");
		try {
			waitForElementToBeClickable(driver, AltEnter);
			AltEnter.sendKeys("Alternate Contact", Keys.ENTER);
		} catch (Exception e) {
			waitForElementToBeClickable(driver, methodOfContactTxt);
			methodOfContactTxt.click();
			waitForElementToBeClickable(driver, AltEnter);
			AltEnter.sendKeys("Alternate Contact", Keys.ENTER);
		}

		checkForPageLoad(driver);
		altText = methodOfContactTxt.getText();

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully select the method of contact dropdown value", ExtentColor.CYAN));
		waitForElementToBeClickable(driver, hrService);
		hrService.click();
		waitForElementToBeClickable(driver, hrServiceDropdown);
		hrServiceDropdown.sendKeys(hrServicedropdown);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, hrServiceOption);
		hrServiceOption.click();

//	Robot r=new Robot();
//	r.keyPress(KeyEvent.VK_DOWN);
//	r.keyRelease(KeyEvent.VK_DOWN);
//	r.keyPress(KeyEvent.VK_ENTER);
//	r.keyRelease(KeyEvent.VK_ENTER);

		waitForElementToBeClickable(driver, createCaseBt);
		createCaseBt.click();
		Alert alert = driver.switchTo().alert();
		String errorText = alert.getText();
		test.get().log(Status.INFO,
				MarkupHelper.createLabel(
						"After clicking the create case error message displayed and error text==" + errorText,
						ExtentColor.CYAN));
		System.out.println(errorText);
		alert.accept();

		waitForElementToBeClickable(driver, phoneOrEmail);
		phoneOrEmail.sendKeys(altNumber);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully pass the alternate phone number", ExtentColor.CYAN));
		waitForElementToBeClickable(driver, createCaseBt);
		createCaseBt.click();

		System.out.println(alert.getText());
		alert.accept();
		// descriptionText="resolved";
		waitForElementToBeClickable(driver, description);
		description.sendKeys(descriptionText);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully pass the description text", ExtentColor.CYAN));
		waitForElementToBeClickable(driver, createCaseBt);
		createCaseBt.click();
	}

	// validating the case and verify the fields
	public void ValidateCase(String assignTo, String descriptionText) throws Exception {
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, caseNumber);
		checkForPageLoad(driver);
		if (!caseNumber.getAttribute("value").isEmpty() && caseNumber.getAttribute("readonly").equals("true")) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Number Field is Populated with value==" + caseNumber.getAttribute("value"), ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Number Field is Auto Populated with value==" + caseNumber.getAttribute("value"));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Number Field is Not Populated with value", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Number Field is Not Auto Populated with value");
		}

		if (!requestedBy.getAttribute("value").isEmpty() && requestedBy.isEnabled()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("RequestedBy Field  is Populated with value=="
					+ requestedBy.getAttribute("value") + " and Editable", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("RequestedBy Field  is Populated with value==" + requestedBy.getAttribute("value")
					+ " and Editable");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("RequestedBy field is not populated or not Editable", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("RequestedBy field is not populated or not Editable");
		}

		if (!workphone.getAttribute("value").isEmpty()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Work Phone  Field  is Populated with value=="
					+ workphone.getAttribute("value") + " and Not Editable", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("WorkPhone Field  is Populated with value==" + workphone.getAttribute("value")
					+ " and Not Editable");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Work Phone field is not populated or Editable", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("RequestedBy field is not populated or Editable");
		}

		if (!caseEmail.getAttribute("value").isEmpty() && caseEmail.getAttribute("readonly").equals("true")) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Email  Field  is Populated with value==" + caseEmail.getAttribute("value") + " and Not Editable",
					ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println(
					"Email Field  is Populated with value==" + caseEmail.getAttribute("value") + " and Not Editable");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Email field is not populated or Editable", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Email field is not populated or Editable");
		}

		if (caseMethodOfContact.isDisplayed() && caseMethodOfContact.isEnabled()) {
			System.out.println("method of contact enabled");
			Select select = new Select(caseMethodOfContact);
			String selectedText = select.getFirstSelectedOption().getText();
			if (selectedText != null) {
				test.get().log(Status.PASS,
						MarkupHelper.createLabel("Preferred method of contact  Field  is Populated with value=="
								+ selectedText + " and  Editable", ExtentColor.GREEN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println(
						"Preferred method of contact field is Populated with value==" + selectedText + " and Editable");
			} else {
				test.get().log(Status.FAIL, MarkupHelper.createLabel(
						"Preferred method of contact  field is not populated or not Editable", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("Preferred method of contact field is not populated or not Editable");
			}
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Preferred method of contact  field is not displayed or not Editable", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("preferred method of contact field is not displayed or not Editable");
		}

		if (altText.equals("Alternate Contact")) {
			logSuccess("Expected Value - " + "Alternate Contact");
			logSuccess("Actual Value - " + altText);
			if (!casePhoneOrEmail.getAttribute("value").isEmpty() && casePhoneOrEmail.isEnabled()) {
				test.get().log(Status.PASS,
						MarkupHelper.createLabel(
								"Phone or email Field  is Populated with value=="
										+ casePhoneOrEmail.getAttribute("value") + " and  Editable",
								ExtentColor.GREEN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("Phone or Email Field  is Populated with value=="
						+ casePhoneOrEmail.getAttribute("value") + " and Editable");
			} else {
				test.get().log(Status.FAIL, MarkupHelper
						.createLabel("Phone or Email  field is not Populated or not Editable", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("Phone or Email field is not Populated or not Editable");
			}
		}

		if (!casePostalCode.getAttribute("value").isEmpty() && casePostalCode.getAttribute("readonly").equals("true")) {
			test.get()
					.log(Status.PASS,
							MarkupHelper.createLabel(
									"Home Postal code Field  is Populated with value=="
											+ casePostalCode.getAttribute("value") + " and Not  Editable",
									ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Home Postal Code Field  is Populated with value=="
					+ casePostalCode.getAttribute("value") + " and Not Editable");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Home Postal code field is not Populated or Editable", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Home Postal code field is not Populated or  Editable");
		}

		if (!casePinNumber.getAttribute("value").isEmpty() && casePinNumber.getAttribute("readonly").equals("true")) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Pin Number Field  is Populated with value=="
					+ casePinNumber.getAttribute("value") + " and Not  Editable", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Pin Number Field  is Populated with value==" + casePinNumber.getAttribute("value")
					+ " and Not Editable");

		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Pin Number field is not Populated or Editable", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Pin Number field is not Populated or  Editable");
		}

		if (caseState.isDisplayed()) {
			Select selectState = new Select(caseState);
			String actualState = selectState.getFirstSelectedOption().getText();
			if (actualState.equals("Open")) {
				test.get().log(Status.PASS, MarkupHelper.createLabel(
						"State Field  is Populated with Expected value==" + actualState, ExtentColor.GREEN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("State  Field  is Populated with Expected value==" + actualState);
			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("State Field  is Not Populated with Expected value", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("Pin Number Field  is Populated with Expected value");
			}
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("State Field  is Not Displayed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Pin Number Field  is Not Displayed");
		}

		if (casePriority.isDisplayed()) {
			Select selectPriority = new Select(casePriority);
			String actualPriority = selectPriority.getFirstSelectedOption().getText();
			if (actualPriority.equals("2 - Moderate")) {
				test.get().log(Status.PASS, MarkupHelper.createLabel(
						"Priority Field  is Populated with Expected value==" + actualPriority, ExtentColor.GREEN));
				logSuccess("Expected Value - " + "2 - Moderate");
				logSuccess("Actual Value - " + actualPriority);
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("Priority Field  is Populated with value==" + actualPriority);
			} else {
				test.get().log(Status.FAIL, MarkupHelper
						.createLabel("Priority Field  is Not Populated with Expected value", ExtentColor.RED));
				logFailure("Expected Value - " + "2 - Moderate");
				logFailure("Actual Value - " + actualPriority);
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("Priority Field  is Not Populated with Expected value");
			}
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Priority Field  is Not Displayed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Priority Field  is Not Displayed");
		}

		if (caseSource.isDisplayed() && caseSource.isEnabled()) {
			Select selectSource = new Select(caseSource);
			String actualSource = selectSource.getFirstSelectedOption().getText();
			if (actualSource != null) {
				test.get().log(Status.PASS, MarkupHelper.createLabel(
						"Source Field  is Populated with value==" + actualSource + "and Editable", ExtentColor.GREEN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("Source Field  is Populated with value==" + actualSource);
			} else {
				test.get().log(Status.FAIL, MarkupHelper
						.createLabel("Source Field  is Not Populated with Value or Not Editable", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("Source Field  is Not Populated with Value or Not Editable");
			}
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Source Field  is Not displayed", ExtentColor.RED));
		}

		if (!caseOpened.getAttribute("value").isEmpty() && caseOpened.getAttribute("readonly").equals("true")) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Opened Field  is Populated with value==" + caseOpened.getAttribute("value") + " and Not  Editable",
					ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println(
					"Opened Field  is Populated with value==" + caseOpened.getAttribute("value") + " and Not Editable");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Opened field is not Populated or Editable", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Opened field is not Populated or  Editable");
		}

		if (!caseOpenedBy.getAttribute("value").isEmpty() && caseOpenedBy.getAttribute("readonly").equals("true")) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Opened By Field  is Populated with value=="
					+ caseOpenedBy.getAttribute("value") + " and Not  Editable", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Opened By Field  is Populated with value==" + caseOpenedBy.getAttribute("value")
					+ " and Not Editable");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Opened By field is not Populated or Editable", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Opened By field is not Populated or  Editable");
		}

		if (!caseHrService.getAttribute("value").isEmpty() && caseHrService.getAttribute("readonly").equals("true")) {
			hrservice = caseHrService.getAttribute("value");
			test.get().log(Status.PASS, MarkupHelper.createLabel("Hr Service Field  is Populated with value=="
					+ caseHrService.getAttribute("value") + " and Not  Editable", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Hr Service Field  is Populated with value==" + caseHrService.getAttribute("value")
					+ " and Not Editable");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("HR Service field is not Populated or Editable", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("HR Service field is not Populated or  Editable");
		}

		if (!caseAssignmentGroup.getAttribute("value").isEmpty() && caseAssignmentGroup.isEnabled()) {
			test.get()
					.log(Status.PASS,
							MarkupHelper.createLabel(
									"Assignment Group Field  is Populated with value=="
											+ caseAssignmentGroup.getAttribute("value") + " and Editable",
									ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Assignment GroupField  is Populated with value=="
					+ caseAssignmentGroup.getAttribute("value") + " and Editable");
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Assignment Group field is not Populated or Not Editable", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Assignment Group field is not Populated or Not Editable");
		}

		if (caseAbout.isDisplayed() && aboutMandatory.isDisplayed()) {
			about = caseAbout.getAttribute("value");
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("about field is displayed and mandatory", ExtentColor.GREEN));
			if (!caseAbout.getAttribute("value").isEmpty() && caseAbout.isEnabled()) {
				test.get().log(Status.PASS, MarkupHelper.createLabel(
						"About Field  is Populated with value==" + caseAbout.getAttribute("value") + " and Editable",
						ExtentColor.GREEN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println(
						"About Field  is Populated with value==" + caseAbout.getAttribute("value") + " and Editable");
			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("About field is not Populated or Not Editable", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("About field is not Populated or Not Editable");
			}
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("about field is Not displayed or Not mandatory", ExtentColor.RED));
		}

		if (!employeeNum.getAttribute("value").isEmpty() && employeeNum.getAttribute("readonly").equals("true")) {
			test.get()
					.log(Status.PASS,
							MarkupHelper.createLabel(
									"Employee Number Field  is Populated with value=="
											+ employeeNum.getAttribute("value") + " and Not Editable",
									ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Employee Number Field is Populated with value==" + employeeNum.getAttribute("value")
					+ " and Not Editable");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Employee Number field is not Populated or Editable", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Employee Number field is not Populated or Editable");
		}

		if (!businessTitle.getAttribute("value").isEmpty() && businessTitle.getAttribute("readonly").equals("true")) {
			test.get()
					.log(Status.PASS,
							MarkupHelper.createLabel(
									"Business Title Field  is Populated with value=="
											+ businessTitle.getAttribute("value") + " and Not Editable",
									ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Business Title Field is Populated with value==" + businessTitle.getAttribute("value")
					+ " and Not Editable");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Business Title field is not Populated or Editable", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Business Title field is not Populated or Editable");
		}

		if (!caseCompanyName.getAttribute("value").isEmpty()
				&& caseCompanyName.getAttribute("readonly").equals("true")) {
			test.get()
					.log(Status.PASS,
							MarkupHelper.createLabel(
									"Company Name Field is Populated with value=="
											+ caseCompanyName.getAttribute("value") + " and Not Editable",
									ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Company Name Field is Populated with value==" + caseCompanyName.getAttribute("value")
					+ " and Not Editable");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Company name field is not Populated or Editable", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Company name field is not Populated or Editable");
		}

		if (!casePayGroup.getAttribute("value").isEmpty() && casePayGroup.getAttribute("readonly").equals("true")) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Pay Group Field is Populated with value=="
					+ casePayGroup.getAttribute("value") + " and Not Editable", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Pay Group Field is Populated with value==" + casePayGroup.getAttribute("value")
					+ " and Not Editable");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Pay Group field is not Populated or Editable", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Pay Group field is not Populated or Editable");
		}

		if (!caseUnionOccCode.getAttribute("value").isEmpty()
				&& caseUnionOccCode.getAttribute("readonly").equals("true")) {
			test.get()
					.log(Status.PASS,
							MarkupHelper.createLabel(
									"Union Occ Code Field is Populated with value=="
											+ caseUnionOccCode.getAttribute("value") + " and Not Editable",
									ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Union Occ Code Field is Populated with value==" + caseUnionOccCode.getAttribute("value")
					+ " and Not Editable");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Union Occ Code field is not Populated or Editable", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Union Occ Code field is not Populated or Editable");
		}

		if (!caseEmploymentType.getAttribute("value").isEmpty()
				&& caseEmploymentType.getAttribute("readonly").equals("true")) {
			test.get()
					.log(Status.PASS,
							MarkupHelper.createLabel(
									"Employment Type Field is Populated with value=="
											+ caseEmploymentType.getAttribute("value") + " and Not Editable",
									ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Employment Type Field is Populated with value=="
					+ caseEmploymentType.getAttribute("value") + " and Not Editable");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Employment Type field is not Populated or Editable", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Employment Type field is not Populated or Editable");
		}

		if (!caseHrRepresentative.getAttribute("value").isEmpty()
				&& caseHrRepresentative.getAttribute("readonly").equals("true")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"HR Representative Field is Populated with value=="
									+ caseHrRepresentative.getAttribute("value") + " and Not Editable",
							ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("HR Representative Field is Populated with value=="
					+ caseHrRepresentative.getAttribute("value") + " and Not Editable");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("HR Representative field is not Populated or Editable", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("HR Representative field is not Populated or Editable");
		}

		if (caseActiveCheckbox.isSelected() && caseActiveCheckbox.getAttribute("aria-readonly").equals("true")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Active CheckBox is selected and Not Editable", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Active Checkbox is selected and Not Editable");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Active CheckBox is Not selected or Editable", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Active Checkbox is Not selected and or Editable");
		}

		if (caseJobExempt.isSelected() && caseJobExempt.getAttribute("aria-readonly").equals("true")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("JobExempt CheckBox is selected and Not Editable", ExtentColor.GREEN));
			logSuccess("Expected Value - " + "true");
			logSuccess("Actual Value - " + caseJobExempt.getAttribute("aria-readonly"));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Job Exempt Checkbox is selected and Not Editable");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("job Exempt CheckBox is Not selected or Editable", ExtentColor.RED));
			logFailure("Expected Value - " + "true");
			logFailure("Actual Value - " + caseJobExempt.getAttribute("aria-readonly"));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("job Exempt Checkbox is Not selected and or Editable");
		}

		String hrPageWindowHandle = driver.getWindowHandle();

		// Perform the click operation that opens new window
		waitForElement(driver, caseAssignedToSearch);
		scrollToElement(driver, caseAssignedToSearch);
		if (caseAssignedToSearch.isDisplayed()) {
			waitForElementToBeClickable(driver, caseAssignedToSearch);
			caseAssignedToSearch.click();
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Assign To field is not displayed", ExtentColor.RED));
		}

		// Switch to new window opened
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> windowIterator = handles.iterator();
		// iterate through your windows
		while (windowIterator.hasNext()) {
			String windowName = windowIterator.next();
			if (!windowName.equals(hrPageWindowHandle)) {
				driver.switchTo().window(windowName);
				System.out.println(windowName);
				driver.switchTo().window(windowName);
				driver.manage().window().maximize();
				checkForPageLoad(driver);

				waitForElementToBeClickable(driver, searchCriteria);
				Select dropdown = new Select(searchCriteria);
				dropdown.selectByVisibleText("Name");
				waitForElementToBeClickable(driver, searchTextBox);
				searchTextBox.clear();
				searchTextBox.sendKeys(assignTo);
				waitForAction(driver);
				searchTextBox.sendKeys(Keys.ENTER);
				checkForPageLoad(driver);
				
				waitForElement(driver, nameSearchTextBox);
				if (nameSearchTextBox.isDisplayed()) {
					test.get().log(Status.INFO, MarkupHelper
							.createLabel("Entering the value for Assign to field - " + assignTo, ExtentColor.CYAN));
					waitForElementToBeClickable(driver, nameSearchTextBox);
					nameSearchTextBox.clear();
					waitForAction(driver);
					nameSearchTextBox.sendKeys(assignTo);
					waitForAction(driver);
					nameSearchTextBox.sendKeys(Keys.ENTER);
					checkForPageLoad(driver);
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					checkForPageLoad(driver);
					WebElement searchResult = driver.findElement(
							By.xpath("//*[contains(@class, 'glide_ref_item_link') and contains(@role, 'button')]"));
					try {
						searchResult.click();
					} catch (Exception e) {

					}
				}
			}
		}
		
		waitForExpectedNumberOfWindows(driver, 1);
		driver.switchTo().window(hrPageWindowHandle);
		waitForFrameToBeAvailable(driver, "gsft_main");
		checkForPageLoad(driver);
		waitForElement(driver, caseShortDescription);
		if (caseShortDescription.isDisplayed()) {
			if (caseShortDescription.getAttribute("value").equalsIgnoreCase(hrservice + " case for " + about)) {
				test.get().log(Status.PASS,
						MarkupHelper.createLabel("short description actual text match with expected text=="
								+ caseShortDescription.getAttribute("value"), ExtentColor.GREEN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("short description actual text match with expected text=="
						+ caseShortDescription.getAttribute("value"));
			} else {
				test.get().log(Status.FAIL, MarkupHelper
						.createLabel("short description actual text Not match with expected text", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("short description actual text Not match with expected text");
			}
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("short description Field is not Displayed", ExtentColor.RED));
		}

		if (caseDescription.getAttribute("value").equals(descriptionText)) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"description actual text match with expected text==" + caseDescription.getAttribute("value"),
					ExtentColor.GREEN));
			logSuccess("Expected Value - " + descriptionText);
			logSuccess("Actual Value - " + caseDescription.getAttribute("value"));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println(
					"description actual text match with expected text==" + caseDescription.getAttribute("value"));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("description actual text Not match with expected text", ExtentColor.RED));

			logFailure("Expected Value - " + descriptionText);
			logFailure("Actual Value - " + caseDescription.getAttribute("value"));

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("description actual text Not match with expected text");
		}

	}

	// validating the comments
	public void validateComments(String addtionalComments) throws Exception {
		test.get().log(Status.INFO, MarkupHelper.createLabel("Updating The Hr case and Click save", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		waitForAction(driver);
		waitForElementToBeClickable(driver, updateButton);
		updateButton.click();
		waitForAction(driver);
		driver.navigate().back();

		waitForFrameToBeAvailable(driver, "gsft_main");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", addCommentsCheckbox);
		waitForElement(driver, addCommentsCheckbox);
		if (addCommentsCheckbox.isSelected() == false) {
			waitForElementToBeClickable(driver, addCommentsCheckbox);
			addCommentsCheckbox.click();
			waitForElementToBeClickable(driver, addComments);
			addComments.sendKeys(addtionalComments);
			System.out.println("successfully enter the additional comments");
			test.get().log(Status.INFO, MarkupHelper.createLabel(
					"Successfully adding the additional comments==" + addtionalComments, ExtentColor.CYAN));
			waitForElementToBeClickable(driver, postBt);
			postBt.click();
		}

		waitForElement(driver, addCommentsCheckbox);
		if (addCommentsCheckbox.isSelected()) {
			waitForElementToBeClickable(driver, addCommentsCheckbox);
			addCommentsCheckbox.click();
		}
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully scroll to the Work Notes", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		waitForElementToBeClickable(driver, worknotes);
		worknotes.sendKeys("case opened");
		System.out.println("successfully enter the work notes");
		test.get().log(Status.INFO, MarkupHelper.createLabel("Successfully adding the work notes", ExtentColor.CYAN));
		waitForElementToBeClickable(driver, postBt);
		postBt.click();
		// checkForPageLoad(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(caseState));
		WebElement ele = driver.findElement(By.id("sys_readonly.sn_hr_core_case_payroll.hr_profile.ssn"));
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		Select selectstate = new Select(caseState);
		selectstate.selectByVisibleText("Resolved");
		test.get().log(Status.PASS,
				MarkupHelper.createLabel("Successfully selecting state dropdown == Resolved", ExtentColor.GREEN));
		wait.until(ExpectedConditions.visibilityOf(caseWorknotes));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[1].value = arguments[0]; ", "Marking Case as Resolved JS2", caseWorknotes);
		waitForAction(driver);
		executor.executeScript("arguments[0].textContent='" + "Marking Case as Resolved" + "';", caseWorknotes);
		caseWorknotes.sendKeys("Marking Case as Resolved");
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		// postBt.click();
		test.get().log(Status.INFO, MarkupHelper.createLabel("Updating The Hr case and Click save", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		waitForAction(driver);
		waitForElementToBeClickable(driver, updateButton);
		updateButton.click();
		checkForPageLoad(driver);

		try {
			if (isElementPresent(updateButton)) {
				scrollToElement(driver, updateButton);
				checkForPageLoad(driver);
				waitForElementToBeClickable(driver, updateButton);
				updateButton.click();
				checkForPageLoad(driver);
				if (isElementPresent(updateButton)) {
					scrollToElement(driver, updateButton);
					waitForAction(driver);
					new Actions(driver).click(updateButton).build().perform();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	// --------------Cancelled dropdown is removed-------------------------
	/*
	 * WebDriverWait wait = new WebDriverWait(driver, 20);
	 * wait.until(ExpectedConditions.visibilityOf(caseState));
	 * selectstate.selectByVisibleText("Cancelled"); test.get().log(Status.PASS,
	 * MarkupHelper.createLabel("Successfully selecting state dropdown ==Cancelled",
	 * ExtentColor.GREEN));
	 * 
	 * caseWorknotes.sendKeys("case cancelled"); postBt.click(); (2000);
	 * 
	 * test.get().log(Status.INFO,
	 * MarkupHelper.createLabel("Updating The Hr case and Click save",
	 * ExtentColor.CYAN)); action.contextClick(header).perform();
	 * action.click(saveOption).perform(); ; checkForPageLoad(driver);
	 */

	// creating the case
	public void createNewCase(String user, String hrServicedropdown, String descriptionText) throws Exception {
		waitForElementToBeClickable(driver, searchForRequester);
		searchForRequester.click();
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully clicking the Search for requester dropdown", ExtentColor.CYAN));
		// searching for the requester
		waitForElementToBeClickable(driver, enterSearchRequester);
		enterSearchRequester.sendKeys(user);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, driver.findElement(By.xpath("//ul[@class = 'select2-results']/li")));

		if (user.contains("_")) {
			user = user.replace("_", " ");
		}

		checkForPageLoad(driver);
		for (WebElement e : uniqueRequester1) {
			if (e.getText().contains(user)) {
				logSuccess("Expected Value - " + user);
				logSuccess("Actual Value - " + e.getText());
				waitForElementToBeClickable(driver, e);
				e.click();
				test.get().log(Status.PASS,
						MarkupHelper.createLabel("Successfully pass the Active User==" + user, ExtentColor.GREEN));
				break;
			}
		}
		waitForElement(driver, caseCreation);
		if (caseCreation.isDisplayed()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Successdully Navigate to Case Creation Page", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		scrollToElement(driver, source);
		waitForElementToBeClickable(driver, source);
		source.click();
		waitForElementToBeClickable(driver, sourceEnter);
		// Select s = new Select(sourceDropDown);
		// s.selectByVisibleText("Phone");
		sourceEnter.sendKeys("Phone", Keys.ENTER);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully select the source dropdown value==Phone", ExtentColor.CYAN));

		// selecting the hr service
		// JavascriptExecutor js=(JavascriptExecutor)driver;
		// js.executeScript("arguments[0].click();", hrService);
		waitForElementToBeClickable(driver, hrService);
		hrService.click();
		waitForElementToBeClickable(driver, hrServiceDropdown);
		hrServiceDropdown.sendKeys(hrServicedropdown);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, hrServiceOption);
		hrServiceOption.click();

		waitForElementToBeClickable(driver, description);
		description.sendKeys(descriptionText);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully pass the description text", ExtentColor.CYAN));
		waitForElementToBeClickable(driver, createCaseBt);
		createCaseBt.click();
		checkForPageLoad(driver);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully clicking the create case button", ExtentColor.CYAN));

		waitForFrameToBeAvailable(driver, "gsft_main");
		if (hrServicedropdown.equals("Employee File Request")) {

			logSuccess("Expected Value - " + "Employee File Request");
			logSuccess("Actual Value - " + hrServicedropdown);
			caseId = xpNumber.getAttribute("value");
			logInfo("The case is created with case id=" + caseId);
		} else if (hrServicedropdown.equals("Check Request")) {
			logSuccess("Expected Value - " + "Check Request");
			logSuccess("Actual Value - " + hrServicedropdown);

			caseId = xpNumber2.getAttribute("value");
			logInfo("The case is created with case id=" + caseId);
		} else if (hrServicedropdown.contains("Leave of Absence")) {

			logSuccess("Expected Value - " + "Leave of Absence");
			logSuccess("Actual Value - " + hrServicedropdown);

			caseId = xpNumber3.getAttribute("value");
			logInfo("The case is created with case id=" + caseId);
		}

	}

	// searching for the upload hr cases page and validate attachment available or
	// not

	public void searchUploadCasePage(String searchForForm, String file, String browserstackFile) throws Exception {
		waitForElementToBeClickable(driver, searchBox);
		searchBox.sendKeys(searchForForm, Keys.ENTER);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, xpUploadcases);
		xpUploadcases.click();
		waitForElement(driver, xpUploadCasesHeader);
		if (isElementPresent(xpUploadCasesHeader)) {
			logSuccess("Succesfully navigating to the Upload HR Cases Page");
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			logFailure("Navigation Failed to Upload HR Cases page");
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		// String file = "Upload HR Cases - All WB Fields (2) (9).xlsx";

		// fileName = "C:" + File.separatorChar + "Users" + File.separatorChar +
		// "XASINGAR-Adm" + File.separatorChar
		// + "Downloads" + File.separatorChar + file;

		fileName = file;
		browserstackfilename = browserstackFile;
		File file1 = new File(fileName);
		if (file1.exists()) {
			file1.delete();
		}
		waitForElementToBeClickable(driver, xpExcelDownloadLink);
		xpExcelDownloadLink.click();
		waitForAction(driver);

		if (tempbrowser.equalsIgnoreCase("IE")) {

		}
		// }
		if (tempExecuteOn.equalsIgnoreCase("System Browsers")) {
			if (file1.exists()) {
				logSuccess("Successfully download the Upload HR Cases Sheet");
			} else {
				logFailure("failed to download the Upload HR Cases Sheet");
			}
		}
		if (tempExecuteOn.equalsIgnoreCase("Browserstack")) {
			// check if file exists
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			Object b = jse.executeScript(
					"browserstack_executor: {\"action\": \"fileExists\", \"arguments\": {\"fileName\": \""
							+ browserstackfilename + "\"}}");
			String s = String.valueOf(b);
			System.out.println(jse.executeScript(
					"browserstack_executor: {\"action\": \"fileExists\", \"arguments\": {\"fileName\": \""
							+ browserstackfilename + "\"}}"));
			if (s.equalsIgnoreCase("true")) {
				logSuccess("Successfully download the Report Sheet");
			} else {
				logFailure("failed to download the Report Sheet");
			}
			String base64EncodedFile = (String) jse.executeScript(
					"browserstack_executor: {\"action\": \"getFileContent\", \"arguments\": {\"fileName\": \""
							+ browserstackfilename + "\"}}");

			// decode the content to Base64
			byte[] data = Base64.getDecoder().decode(base64EncodedFile);
			OutputStream stream = new FileOutputStream(browserstackfilename);
			stream.write(data);
			stream.close();
		}
	}

	// Updating and creating hr case through Excel sheet
	public void updateExcel(String COE, String topicCategory, String topicDetail, String HR_Service, String state,
			String priority, String sourcedetail, String createdOn, String assignGroup, String OpenedBy,
			String OpenedFor, String SubjectPerson, String descriptiontxt, String dateandTime) throws Exception {
		File file = null;
		if (tempExecuteOn.equalsIgnoreCase("System Browsers")) {
			file = new File(fileName);
		}
		if (tempExecuteOn.equalsIgnoreCase("Browserstack")) {
			file = new File(browserstackfilename);
		}
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("Import Template");

		int lastRowNum = sheet.getLastRowNum();
		System.out.println("no of rows::" + lastRowNum);
		sheet.removeRow(sheet.getRow(1));
		sheet.removeRow(sheet.getRow(2));

		// create case details
		Row row = sheet.createRow(1);
		row.createCell(1).setCellValue(COE);
		row.createCell(2).setCellValue(topicCategory);
		row.createCell(3).setCellValue(topicDetail);
		row.createCell(4).setCellValue(HR_Service);
		row.createCell(5).setCellValue(state);
		row.createCell(6).setCellValue(priority);
		row.createCell(7).setCellValue(sourcedetail);
		row.createCell(8).setCellValue(createdOn);
		row.createCell(9).setCellValue(assignGroup);
		row.createCell(11).setCellValue(OpenedBy);
		row.createCell(12).setCellValue(OpenedFor);
		row.createCell(18).setCellValue(SubjectPerson);
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		descriptiontimeStamp = descriptiontxt + timeStamp;
		row.createCell(22).setCellValue(descriptiontimeStamp);
		row.createCell(49).setCellValue(dateandTime);

		// update existing case details
		Row row2 = sheet.createRow(2);
		row2.createCell(0).setCellValue(caseId);
		row2.createCell(1).setCellValue(COE);
		row2.createCell(2).setCellValue(topicCategory);
		row2.createCell(3).setCellValue(topicDetail);
		row2.createCell(4).setCellValue(HR_Service);
		row2.createCell(5).setCellValue(state);
		row2.createCell(6).setCellValue(priority);
		row2.createCell(7).setCellValue(sourcedetail);
		row2.createCell(8).setCellValue(createdOn);
		row2.createCell(9).setCellValue(assignGroup);
		row2.createCell(11).setCellValue(OpenedBy);
		row2.createCell(12).setCellValue(OpenedFor);
		row2.createCell(18).setCellValue(SubjectPerson);
		updateCaseTimestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		updateCaseDescTimestamp = descriptiontxt + updateCaseTimestamp;
		row2.createCell(22).setCellValue(updateCaseDescTimestamp);
		row2.createCell(49).setCellValue(dateandTime);
		FileOutputStream outputStream = null;
		if (tempExecuteOn.equalsIgnoreCase("System Browsers")) {
			outputStream = new FileOutputStream(fileName);
		}
		if (tempExecuteOn.equalsIgnoreCase("Browserstack")) {
			outputStream = new FileOutputStream(browserstackfilename);
		}
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}

	// uploading the Excel sheet
	public void addAttachment(WebElement element) throws Exception {
		checkForPageLoad(driver);
		// String fileName = System.getProperty("user.dir") + File.separatorChar +
		// "AutomationTest.txt";
		// String file = "\"Upload HR Cases - All WB Fields (2) (9).xlsx\"";

		System.out.println(fileName);
		System.out.println("File Path - " + fileName);

		try {
			scrollPageToElement(driver, element);
			if (tempExecuteOn.equalsIgnoreCase("System Browsers")) {
				waitForElementToBeClickable(driver, element);
				element.sendKeys(fileName);
			}
			if (tempExecuteOn.equalsIgnoreCase("Browserstack")) {
				waitForElementToBeClickable(driver, element);
				element.sendKeys(browserstackfilename);
			}

			logInfo("Uploading Attachment - " + fileName);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		} catch (Exception e) {
			logFailure("Failed to add attachment: " + e.getMessage());
			System.out.println(e.getMessage());
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		waitForElement(driver, xpConfirmUpload);
		if (isElementPresent(xpConfirmUpload)) {
			logSuccess("successfully upload the HR Cases Attachment");
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			logFailure("Failed To Upload Attachment");
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		waitForElementToBeClickable(driver, xpSubmitBtn);
		xpSubmitBtn.click();
		logInfo("submitting the Upload Cases Form");
		String alertText = driver.switchTo().alert().getText();
		logInfo("After Submit the Form alert is Displayed and the alert text::" + alertText);
		driver.switchTo().alert().accept();
		checkForPageLoad(driver);
	}

	// validate Cases created or not
	public void validateCases(String priority, String HRService, String assignGroup) throws Exception {
		// navigating to Home page
		driver.get(homePageURL);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.sendKeys("CASE");
		checkForPageLoad(driver);
		// click on the open cases
		JavascriptExecutor js = (JavascriptExecutor) driver;
		waitForElementToBeClickable(driver, xpOpen);
		js.executeScript("arguments[0].click();", xpOpen);
		checkForPageLoad(driver);
		driver.switchTo().frame(0);

		if (isElementPresent(updatedGearIcon)) {
			waitForElementToBeClickable(driver, updatedGearIcon);
			updatedGearIcon.click();
			waitForElementToBeClickable(driver, resetColumns);
			resetColumns.click();
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Clicking the Reset Column Default View Btn", ExtentColor.CYAN));
			checkForPageLoad(driver);
		}
		waitForElementToBeClickable(driver, gearIcon);
		gearIcon.click();
		test.get().log(Status.PASS, MarkupHelper.createLabel("click on the gear icon", ExtentColor.GREEN));
		checkForPageLoad(driver);

		for (WebElement element : slushLeft) {
			if (element.getText().equals("Short description")) {
				waitForElementToBeClickable(driver, element);
				element.click();
				test.get().log(Status.INFO,
						MarkupHelper.createLabel("Selecting the Column name==Short description", ExtentColor.CYAN));

				logSuccess("Expected Value - " + "Short description");
				logSuccess("Actual Value - " + element.getText());

				break;
			}
		}

		waitForElementToBeClickable(driver, addArrow);
		addArrow.click();
		waitForElementToBeClickable(driver, okBtn);
		okBtn.click();
		waitForElementToBeClickable(driver, xpSearchDropdown);
		Select s = new Select(xpSearchDropdown);
		s.selectByVisibleText("Number");
		checkForPageLoad(driver);
		try {
			waitForElementToBeClickable(driver, xpNumberSearch);
			xpNumberSearch.sendKeys(caseId);
		} catch (Exception e) {
			// xpNumberTxt.click();
			waitForElementToBeClickable(driver, xpSearchIcon);
			xpSearchIcon.click();
			waitForElementToBeClickable(driver, xpNumberSearch);
			xpNumberSearch.sendKeys(caseId);
		}
		logInfo("Search for the case id==" + caseId + " and short description");
		waitForElementToBeClickable(driver, xpShortDescription);
		xpShortDescription.sendKeys(updateCaseDescTimestamp, Keys.ENTER);
		// checkForPageLoad(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		if (xpPriority.getText().equals(priority)) {
			logSuccess("successfully Update the Existing case with priority==" + xpPriority.getText());
			logSuccess("Expected Value - " + priority);
			logSuccess("Actual Value - " + xpPriority.getText());
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			logFailure("Updation of Existing case with priority failed");
			logFailure("Expected Value - " + priority);
			logFailure("Actual Value - " + xpPriority.getText());
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		if (xpHrService.getText().equals(HRService)) {
			logSuccess("successfully Update the Existing case with HR Service==" + xpHrService.getText());
			logSuccess("Expected Value - " + HRService);
			logSuccess("Actual Value - " + xpHrService.getText());
		} else {
			logFailure("Updation of Existing case with HR Service Failed");
			logFailure("Expected Value - " + HRService);
			logFailure("Actual Value - " + xpHrService.getText());
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		if (xpAssignGroup.getText().equals(assignGroup)) {
			logSuccess("Successfully Update the Existing case with Assignment-Group==" + xpAssignGroup.getText());
			logSuccess("Expected Value - " + assignGroup);
			logSuccess("Actual Value - " + xpAssignGroup.getText());
		} else {
			logFailure("Updation of Existing Case with Assignment-group failed");
			logFailure("Expected Value - " + assignGroup);
			logFailure("Actual Value - " + xpAssignGroup.getText());
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		s.selectByVisibleText("Number");
		driver.findElement(By.xpath("//b[text()='All']")).click();
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, xpRemoveFilter);
		xpRemoveFilter.click();

		waitForFrameToBeAvailable(driver, "gsft_main");
		// searching for the case is created or not through short description
		waitForElementToBeClickable(driver, xpShortDescription);
		xpShortDescription.sendKeys(descriptiontimeStamp, Keys.ENTER);
		// checkForPageLoad(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		if (isElementPresent(xpUniqueCaseid)) {
			logSuccess("Successfully create the HR Case with id==" + xpUniqueCaseid.getText());
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			logFailure("Failed to create the HR Case ID");
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		if (xpHrService.getText().equals(HRService)) {
			logSuccess("Successfully Create the case with HR Service==" + xpHrService.getText());

			logSuccess("Expected Value - " + HRService);
			logSuccess("Actual Value - " + xpHrService.getText());

		} else {
			logFailure("Creation of case with Expected hr service and actual hr service mismatch");

			logFailure("Expected Value - " + HRService);
			logFailure("Actual Value - " + xpHrService.getText());

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		if (xpAssignGroup.getText().equals(assignGroup)) {
			logSuccess("Successfully create  case with Assignment-Group==" + xpAssignGroup.getText());

			logSuccess("Expected Value - " + assignGroup);
			logSuccess("Actual Value - " + xpAssignGroup.getText());

		} else {
			logFailure("Creation of case with Expected Assignment-group and actual Assignment-group mismatch ");

			logFailure("Expected Value - " + assignGroup);
			logFailure("Actual Value - " + xpAssignGroup.getText());

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

	}

}
