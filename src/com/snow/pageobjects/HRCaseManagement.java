package com.snow.pageobjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

public class HRCaseManagement extends ReusableLibrary {
	public WebDriver driver;

	public HRCaseManagement(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='filter']")
	public WebElement leftSearch;
	@FindBy(xpath = "//div[text()='Create New Case']")
	public WebElement createCase;
	@FindBy(xpath = "//div[text()='Search for Requester']")
	public WebElement searchForHeader;
	@FindBy(xpath = "//span[text()='Search for requester or case number']")
	public WebElement searchForRequester;
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
	@FindBy(xpath = "//div[@id='s2id_service_input']/a")
	public WebElement hrService;
	@FindBy(xpath = "//div[@id='s2id_ev_field_contact_type']/a")
	public WebElement source;
	@FindBy(xpath = "//textarea[@id='ev_field_description']")
	public WebElement description;
	@FindBy(xpath = "//textarea[@id='ev_field_work_notes']")
	public WebElement workNotes;
	@FindBy(xpath = "//div[@id='s2id_ev_field_u_preferred_method_of_contact']")
	public WebElement methodOfContact;
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
	@FindBy(id = "sys_readonly.sn_hr_core_case_payroll.hr_profile.work_phone")
	public WebElement workphone;
	@FindBy(id = "sys_readonly.sn_hr_core_case_payroll.opened_for.email")
	public WebElement caseEmail;
	@FindBy(id = "sn_hr_core_case_payroll.u_preferred_method_of_contact")
	public WebElement caseMethodOfContact;
	@FindBy(id = "sn_hr_core_case_payroll.u_details")
	public WebElement casePhoneOrEmail;
	@FindBy(id = "sys_readonly.sn_hr_core_case_payroll.hr_profile.u_home_postal_code")
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
	@FindBy(xpath = "//label[@for='comments-59-journal-checkbox']")
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
	String about;
	String hrservice;
	String altText;

	public void navigateCaseManagement() throws Exception {
		leftSearch.sendKeys("HR CASE");
		checkForPageLoad(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", createCase);
		checkForPageLoad(driver);
		driver.switchTo().frame(0);
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

	}

	public void confirmActiveUser(String user) throws Exception {

		searchForRequester.click();
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully clicking the Search for requester dropdown", ExtentColor.CYAN));
		enterSearchRequester.sendKeys(user);
		Thread.sleep(5000);
		System.out.println("Requester Info - " + uniqueRequester.getText());
		// uniqueRequester.click();

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully pass the Active User employeename==" + user, ExtentColor.CYAN));

	}

	public void confirmInValidUser(String user) {
		enterSearchRequester.clear();
		// searchForRequester.click();
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully clicking the Search for requester dropdown", ExtentColor.CYAN));
		enterSearchRequester.sendKeys(user);
		checkForPageLoad(driver);
		if (uniqueRequester.getText().equals("No matches found")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Successfully validate the InValid Worker data ", ExtentColor.GREEN));

			logSuccess("Expected Value - " + "No matches found");
			logSuccess("Actual Value - " + uniqueRequester.getText());
		}

	}

	public void createCase(String user) throws Exception {
		enterSearchRequester.clear();
		// searchForRequester.click();
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully clicking the Search for requester dropdown", ExtentColor.CYAN));
		enterSearchRequester.sendKeys(user);
		Thread.sleep(5000);
		System.out.println("Requester Info - " + uniqueRequester.getText());
		uniqueRequester.click();

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully pass the Active User employeename==" + user, ExtentColor.CYAN));
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
		if (!payGroup.getText().isEmpty()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel(
							"the pay group Field is populated with value==" + payGroup.getText() + "and not Editable",
							ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println(payGroup.getText());
		} else {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("pay group is not populated or editable", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
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
		source.click();
		checkForPageLoad(driver);
		Select s = new Select(sourceDropDown);
		List<WebElement> options = s.getOptions();
		for (WebElement op : options) {
			for (int i = 0; i < expectedDropdown.length; i++) {
				if (op.getText().equals(expectedDropdown[i])) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel(
									"The Source field dropdown actual and expected values are same " + op.getText(),
									ExtentColor.GREEN));

					logSuccess("Expected Value - " + expectedDropdown[i]);
					logSuccess("Actual Value - " + op.getText());

					System.out.println("The Source field dropdown actual and expected values are same " + op.getText());
				}
			}
		}
		s.selectByVisibleText("Phone");
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully select the source dropdown value==Phone", ExtentColor.CYAN));

	}

	public void validateMethodOfContactDropdown(String dropdown, String hrServicedropdown, String altNumber,
			String descriptionText) throws Exception {
		String expectedDropdown[] = dropdown.split("\\,");
		// Actions a=new Actions(driver);
		// a.moveToElement(methodOfContact).click().build().perform();
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
		s.selectByVisibleText("Alternate Contact");
		altText = s.getFirstSelectedOption().getText();
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully select the method of contact dropdown value", ExtentColor.CYAN));
		hrService.click();
		hrServiceDropdown.sendKeys(hrServicedropdown);
		checkForPageLoad(driver);
		hrServiceOption.click();

//	Robot r=new Robot();
//	r.keyPress(KeyEvent.VK_DOWN);
//	r.keyRelease(KeyEvent.VK_DOWN);
//	r.keyPress(KeyEvent.VK_ENTER);
//	r.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(6000);
		createCaseBt.click();
		Alert alert = driver.switchTo().alert();
		String errorText = alert.getText();
		test.get().log(Status.INFO,
				MarkupHelper.createLabel(
						"After clicking the create case error message displayed and error text==" + errorText,
						ExtentColor.CYAN));
		System.out.println(errorText);
		alert.accept();
		Thread.sleep(5000);
		phoneOrEmail.sendKeys(altNumber);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully pass the alternate phone number", ExtentColor.CYAN));
		createCaseBt.click();
		System.out.println(alert.getText());
		alert.accept();
		// descriptionText="resolved";
		description.sendKeys(descriptionText);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully pass the description text", ExtentColor.CYAN));
		createCaseBt.click();
	}

	public void ValidateCase(String assignTo, String descriptionText) throws Exception {

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
		if (!workphone.getAttribute("value").isEmpty() && workphone.getAttribute("readonly").equals("true")) {
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
		}

		else {
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

				logSuccess("Expected Values - " + "2 - Moderate");
				logSuccess("Actual Value - " + actualPriority);

				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("Priority Field  is Populated with value==" + actualPriority);
			} else {
				test.get().log(Status.FAIL, MarkupHelper
						.createLabel("Priority Field  is Not Populated with Expected value", ExtentColor.RED));

				logFailure("Expected Values - " + "2 - Moderate");
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
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Job Exempt Checkbox is selected and Not Editable");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("job Exempt CheckBox is Not selected or Editable", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("job Exempt Checkbox is Not selected and or Editable");
		}
		String hrPageWindowHandle = driver.getWindowHandle();

		// Perform the click operation that opens new window
		if (caseAssignedToSearch.isDisplayed()) {
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

				Select dropdown = new Select(searchCriteria);
				dropdown.selectByVisibleText("Name");
				searchTextBox.clear();
				searchTextBox.sendKeys(assignTo);
				searchTextBox.sendKeys(Keys.ENTER);

				if (nameSearchTextBox.isDisplayed()) {
					test.get().log(Status.INFO, MarkupHelper
							.createLabel("Entering the value for Assign to field - " + assignTo, ExtentColor.CYAN));
					Thread.sleep(5000);
					// nameSearchTextBox.clear();
					nameSearchTextBox.sendKeys(assignTo);
					nameSearchTextBox.sendKeys(Keys.ENTER);
					Thread.sleep(3000);
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					WebElement searchResult = driver.findElement(
							By.xpath("//*[contains(@class, 'glide_ref_item_link') and contains(@role, 'button')]"));
					searchResult.click();
				}
			}
		}
		driver.switchTo().window(hrPageWindowHandle);
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		if (caseShortDescription.isDisplayed()) {
			if (caseShortDescription.getAttribute("value").equalsIgnoreCase(hrservice + " case for " + about)) {
				test.get().log(Status.PASS,
						MarkupHelper.createLabel("short description actual text match with expected text=="
								+ caseShortDescription.getAttribute("value"), ExtentColor.GREEN));

				logSuccess("Expected Values - " + hrservice + " case for " + about);
				logSuccess("Actual Value - " + caseShortDescription.getAttribute("value"));

				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("short description actual text match with expected text=="
						+ caseShortDescription.getAttribute("value"));
			} else {
				test.get().log(Status.FAIL, MarkupHelper
						.createLabel("short description actual text Not match with expected text", ExtentColor.RED));

				logFailure("Expected Values - " + hrservice + " case for " + about);
				logFailure("Actual Value - " + caseShortDescription.getAttribute("value"));

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

			logSuccess("Expected Values - " + descriptionText);
			logSuccess("Actual Value - " + caseDescription.getAttribute("value"));

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println(
					"description actual text match with expected text==" + caseDescription.getAttribute("value"));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("description actual text Not match with expected text", ExtentColor.RED));

			logFailure("Expected Values - " + descriptionText);
			logFailure("Actual Value - " + caseDescription.getAttribute("value"));

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("description actual text Not match with expected text");
		}

	}

	public void validateComments(String addtionalComments) throws Exception {

		Actions action = new Actions(driver);
		action.contextClick(header).perform();
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		saveOption.click();
		test.get().log(Status.INFO, MarkupHelper.createLabel("Updating The Hr case and Click save", ExtentColor.CYAN));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", addCommentsCheckbox);
		Thread.sleep(1000);
		if (addCommentsCheckbox.isSelected() == false) {
			addCommentsCheckbox.click();
			addComments.sendKeys(addtionalComments);
			System.out.println("successfully enter the additional comments");
			test.get().log(Status.INFO, MarkupHelper.createLabel(
					"Successfully adding the additional comments==" + addtionalComments, ExtentColor.CYAN));
			postBt.click();

		}
		checkForPageLoad(driver);
		Thread.sleep(4000);
		if (addCommentsCheckbox.isSelected()) {
			addCommentsCheckbox.click();
		}
		checkForPageLoad(driver);
		// JavascriptExecutor js1 = (JavascriptExecutor) driver;
		// js1.executeScript("arguments[0].scrollIntoView();", worknotes);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully scroll to the Work Notes", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		worknotes.sendKeys("case opened");
		System.out.println("successfully enter the work notes");
		test.get().log(Status.INFO, MarkupHelper.createLabel("Successfully adding the work notes", ExtentColor.CYAN));
		postBt.click();
		checkForPageLoad(driver);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(caseState));
		Select selectstate = new Select(caseState);
		selectstate.selectByVisibleText("Resolved");
		test.get().log(Status.PASS,
				MarkupHelper.createLabel("Successfully selecting state dropdown == Resolved", ExtentColor.GREEN));
		wait.until(ExpectedConditions.visibilityOf(caseWorknotes));
		caseWorknotes.sendKeys("case resolved");
		postBt.click();

		action.contextClick(header).perform();
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		saveOption.click();
		test.get().log(Status.INFO, MarkupHelper.createLabel("Updating The Hr case and Click save", ExtentColor.CYAN));
		checkForPageLoad(driver);
		// WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(caseState));
		selectstate.selectByVisibleText("Cancelled");
		test.get().log(Status.PASS,
				MarkupHelper.createLabel("Successfully selecting state dropdown ==Cancelled", ExtentColor.GREEN));
		caseWorknotes.sendKeys("case cancelled");
		postBt.click();
		Thread.sleep(2000);
		action.contextClick(header).perform();
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		saveOption.click();
		test.get().log(Status.INFO, MarkupHelper.createLabel("Updating The Hr case and Click save", ExtentColor.CYAN));

	}
}
