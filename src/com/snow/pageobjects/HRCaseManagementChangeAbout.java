package com.snow.pageobjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.snow.base.ReusableLibrary;

public class HRCaseManagementChangeAbout extends ReusableLibrary {
	public WebDriver driver;

	public HRCaseManagementChangeAbout(WebDriver driver) {
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

	@FindBy(xpath = "//*[@class = 'select2-drop select2-display-none select2-with-searchbox select2-drop-active']/ul/li")
	public List<WebElement> uniqueRequester1;

	@FindBy(xpath = "//*[@id='s2id_autogen1_search']")
	public WebElement enterSearchRequester;

	@FindBy(xpath = "//ul[@class = 'select2-results']/li")
	public WebElement requesterListElement;

	@FindBy(xpath = "//*[@class = 'select2-drop select2-display-none select2-with-searchbox select2-drop-active']/ul")
	public WebElement uniqueRequester;

	@FindBy(xpath = "//div[text()='Case Creation']")
	public WebElement caseCreation;

	@FindBy(xpath = "//div[@class='search-display ev-option row']/div[2]")
	public WebElement requesterSearchBar;

	// --------------------Requester information---------------
	@FindBy(xpath = "//input[contains(@id, 'ev_field') and contains(@id, '_name_disabled')]")
	public WebElement name;

	@FindBy(xpath = "//*[@id = 'ev_field_u_legal_full_name_disabled']")
	public WebElement legalFullName;

	@FindBy(xpath = "//*[@id = 'ev_field_u_business_title_disabled']")
	public WebElement BusinessTitle;

	@FindBy(xpath = "//div[@id='s2id_ev_field_u_pay_group_disabled']/a")
	public WebElement payGroup;

	@FindBy(xpath = "//div[@id='s2id_ev_field_u_hr_representative_disabled']/a")
	public WebElement hrRepresentative;

	@FindBy(xpath = "//input[contains(@id, 'ev_field') and contains(@id, 'email_disabled')]")
	public WebElement email;

	@FindBy(xpath = "//input[@id = 'ev_field_work_phone_disabled']")
	public WebElement workPhone;

	@FindBy(xpath = "//div[@id='s2id_ev_field_u_company_code_disabled']/a")
	public WebElement companyName;

	@FindBy(xpath = "//input[contains(@id, 'ev_field') and contains(@id, 'active_disabled')]")
	public WebElement activeCheckbox;

	@FindBy(xpath = "//input[@id='ev_field_u_job_exempt_disabled']")
	public WebElement jobExemptCheckbox;

	@FindBy(xpath = "//input[@id='ev_field_u_union_code_disabled']")
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

	// ----------------validate case-----------------
	@FindBy(id = "sys_readonly.sn_hr_core_case_total_rewards.number")
	public WebElement caseNumber;

	@FindBy(id = "sys_display.sn_hr_core_case_total_rewards.opened_for")
	public WebElement requestedBy;

	@FindBy(id = "sys_readonly.sn_hr_core_case_total_rewards.hr_profile.work_phone")
	public WebElement workphone;

	@FindBy(id = "sys_readonly.sn_hr_core_case_total_rewards.opened_for.email")
	public WebElement caseEmail;

	@FindBy(id = "sn_hr_core_case_total_rewards.u_preferred_method_of_contact")
	public WebElement caseMethodOfContact;

	@FindBy(id = "sn_hr_core_case_total_rewards.u_details")
	public WebElement casePhoneOrEmail;

	@FindBy(id = "sys_readonly.sn_hr_core_case_total_rewards.hr_profile.u_home_postal_code")
	public WebElement casePostalCode;

	@FindBy(id = "sys_readonly.sn_hr_core_case_total_rewards.hr_profile.ssn")
	public WebElement casePinNumber;

	@FindBy(id = "sn_hr_core_case_total_rewards.state")
	public WebElement caseState;

	@FindBy(xpath = "//button[@id = 'sysverb_update']")
	public WebElement updateButton;

	@FindBy(id = "sn_hr_core_case_total_rewards.priority")
	public WebElement casePriority;

	@FindBy(id = "sn_hr_core_case_total_rewards.contact_type")
	public WebElement caseSource;

	@FindBy(id = "sys_readonly.sn_hr_core_case_total_rewards.opened_at")
	public WebElement caseOpened;

	@FindBy(id = "sn_hr_core_case_total_rewards.opened_by_label")
	public WebElement caseOpenedBy;

	@FindBy(id = "sys_display.sn_hr_core_case_total_rewards.hr_service")
	public WebElement caseHrService;

	@FindBy(id = "sys_display.sn_hr_core_case_total_rewards.assignment_group")
	public WebElement caseAssignmentGroup;

	@FindBy(xpath = "//*[contains(@id, 'lookup.') and contains(@id, '.assigned_to')]")
	public WebElement caseAssignedToSearch;

	@FindBy(xpath = "//select[contains(@id,'_select')]")
	public WebElement searchCriteria;

	@FindBy(xpath = "//input[contains(@id,'_text')]")
	public WebElement searchTextBox;

	@FindBy(xpath = "(//*[@id='sys_user_table_header_search_control'])[1]")
	public WebElement nameSearchTextBox;

	@FindBy(xpath = "//*[@id='user_info_dropdown']/div/span[1]")
	public WebElement loggedUser;

	@FindBy(id = "sys_display.sn_hr_core_case_total_rewards.assigned_to")
	public WebElement assignToText;

	@FindBy(id = "sys_display.sn_hr_core_case_total_rewards.subject_person")
	public WebElement caseAbout;

	@FindBy(id = "status.sn_hr_core_case_payroll.subject_person")
	public WebElement aboutMandatory;

	@FindBy(id = "sys_readonly.sn_hr_core_case_total_rewards.subject_person.employee_number")
	public WebElement employeeNum;

	@FindBy(id = "sys_readonly.sn_hr_core_case_total_rewards.subject_person_hr_profile.u_business_title")
	public WebElement businessTitle;

	@FindBy(id = "sn_hr_core_case_total_rewards.subject_person_hr_profile.u_company_code_label")
	public WebElement caseCompanyName;

	@FindBy(id = "sys_readonly.sn_hr_core_case_total_rewards.subject_person_hr_profile.u_pay_group")
	public WebElement casePayGroup;

	@FindBy(id = "sys_readonly.sn_hr_core_case_total_rewards.subject_person_hr_profile.u_union_code")
	public WebElement caseUnionOccCode;

	@FindBy(id = "sys_readonly.sn_hr_core_case_total_rewards.subject_person_hr_profile.employment_type")
	public WebElement caseEmploymentType;

	@FindBy(id = "sn_hr_core_case_total_rewards.subject_person_hr_profile.u_hr_representative_label")
	public WebElement caseHrRepresentative;

	@FindBy(id = "ni.sn_hr_core_case_total_rewards.subject_person.active")
	public WebElement caseActiveCheckbox;

	@FindBy(id = "ni.sn_hr_core_case_total_rewards.subject_person_hr_profile.u_job_exempt")
	public WebElement caseJobExempt;

	@FindBy(id = "lookup.sn_hr_core_case_total_rewards.subject_person")
	public WebElement aboutSearchBt;

	@FindBy(id = "sn_hr_core_case_total_rewards.short_description")
	public WebElement shortDescription;

	@FindBy(xpath = "//*[contains(@id,'header') and contains(@class,'section_header_div_no_scroll form_title')]")
	public WebElement header;

	@FindBy(xpath = "//*[@role='menuitem' and @title = 'Save record and remain here']")
	public WebElement saveOption;

	@FindBy(xpath = "//textarea[@id='activity-stream-textarea']")
	public WebElement worknotes;

	@FindBy(xpath = "//textarea[@id='activity-stream-work_notes-textarea']")
	public WebElement caseWorknotes;

	@FindBy(xpath = "//button[text()='Post']")
	public WebElement postBt;

	@FindBy(xpath = "//h2[text()='Related Links']")
	public WebElement relatedLinksTxt;

	@FindBy(xpath = "//span[contains(@class,'tab_caption_text') and contains(text(), 'SLA')]")
	public WebElement taskSla;

	@FindBy(xpath = "//span[@aria-controls='sn_hr_core_case_total_rewards.task_sla.task_list']")
	public WebElement taskSlaOpen;

	/*
	 * @FindBy(xpath = "//tr[contains(@id,'task_sla.task')]/td[10]") public
	 * WebElement stage;
	 */

	@FindBy(xpath = "//*[@id='sys_readonly.task_sla.sla.target']")
	public WebElement target;

	@FindBy(xpath = "//tr[contains(@id,'task_sla.task')]/td[2]/a")
	public WebElement xpIicon;

	@FindBy(xpath = "//tr[contains(@id,'task_sla.task')]/td[8]")
	public WebElement businessElapsedTime;

	@FindBy(xpath = "//*[@id='s2id_autogen7_search']")
	public WebElement sourceEnter;

	@FindBy(xpath = "//*[@id='s2id_autogen6_search']")
	public WebElement AltEnter;

	@FindBy(xpath = "//th[contains(@glide_field,'task_sla')]/descendant::a[@role = 'button']")
	public List<WebElement> taskSlaHeading;

	// descendant::a[text() = 'Stage']

	String altText;
	String hrservice;

	// navigating to the create case page
	public void navigateCaseManagement() throws Exception {
		PageFactory.initElements(driver, HRCaseManagementChangeAbout.class);
		driver.switchTo().defaultContent();
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.sendKeys("HR CASE");
		waitForAction(driver);
		waitForElementToBeClickable(driver, createCase);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", createCase);

		waitForAction(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, searchForHeader);
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

	// searching for the active user
	public void createCase(String user) throws Exception {
		checkForPageLoad(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");

		waitForElementToBeClickable(driver, searchForRequester);
		searchForRequester.click();
		checkForPageLoad(driver);

		try {
			waitForElementToBeClickable(driver, enterSearchRequester);
			enterSearchRequester.sendKeys(user);
			checkForPageLoad(driver);
		} catch (Exception e) {
			waitForAction(driver);
			waitForElementToBeClickable(driver, searchForRequester);
			searchForRequester.click();
			checkForPageLoad(driver);
			waitForElementToBeClickable(driver, enterSearchRequester);
			enterSearchRequester.sendKeys(user);
			checkForPageLoad(driver);
		}

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully clicking the Search for requester dropdown", ExtentColor.CYAN));
		waitForElementToBeClickable(driver, requesterListElement);

		if (user.contains("_")) {
			user = user.replace("_", " ");
		}

		checkForPageLoad(driver);
		WebElement requestor = driver.findElement(
				By.xpath("//ul[@class = 'select2-results']/li/descendant::div[contains(text(), '" + user + "')]"));
		waitForElementToBeClickable(driver, requestor);
		System.out.println("Requester Info - " + requestor.getText());
		requestor.click();

		try {
			new Actions(driver).click(requestor).build().perform();
		} catch (Exception e) {
			System.out.println("Requestor may have selected already");
		}

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully pass the Active User employeename==" + user, ExtentColor.CYAN));
		checkForPageLoad(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, caseCreation);
		int count = 0;
		checkForPageLoad(driver);
		if (caseCreation.isDisplayed()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Successfully Navigate to Case Creation Page", ExtentColor.CYAN));
			logSuccessScreenshot(driver);
		} else {
			count++;
			logFailure("Navigation to Case Creation Page failed.");
			logFailureScreenshot(driver);
		}

		waitForElement(driver, name);
		if (!name.getAttribute("value").isEmpty() && name.getAttribute("disabled").equals("true")) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel(
							"the Name Field is populated with value" + name.getAttribute("value") + "and not Editable",
							ExtentColor.CYAN));
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("the Name Field is not populated or editable", ExtentColor.RED));
		}

		if (isElementPresent(driver, legalFullName)) {
			if (!legalFullName.getAttribute("value").isEmpty()
					&& legalFullName.getAttribute("disabled").equals("true")) {
				test.get()
						.log(Status.INFO,
								MarkupHelper.createLabel(
										"the legal full name  Field is populated with value"
												+ legalFullName.getAttribute("value") + "and not Editable",
										ExtentColor.CYAN));
				System.out.println(legalFullName.getAttribute("value"));
			} else {
				count++;
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("the legal full name is not populated or editable", ExtentColor.RED));
			}
		} else {
			test.get().log(Status.WARNING,
					MarkupHelper.createLabel("the legal full name is not populated or editable", ExtentColor.AMBER));
		}

		if (isElementPresent(driver, BusinessTitle)) {
			if (!BusinessTitle.getAttribute("value").isEmpty()
					&& BusinessTitle.getAttribute("disabled").equals("true")) {
				test.get()
						.log(Status.INFO,
								MarkupHelper.createLabel(
										"The Business title  Field is populated with value"
												+ BusinessTitle.getAttribute("value") + "and not Editable",
										ExtentColor.CYAN));
			} else {
				count++;
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("the business title is not populated or editable", ExtentColor.RED));
			}
		} else {
			test.get().log(Status.WARNING,
					MarkupHelper.createLabel("the business title is not populated or editable", ExtentColor.AMBER));
		}

		if (isElementPresent(driver, hrRepresentative)) {
			if (!hrRepresentative.getText().isEmpty()) {
				test.get().log(Status.INFO, MarkupHelper.createLabel("HR Representative Field is populated with value=="
						+ hrRepresentative.getText() + "and not Editable", ExtentColor.CYAN));
			} else {
				count++;
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("HR Representative is not populated or editable", ExtentColor.RED));
			}
		} else {
			test.get().log(Status.WARNING,
					MarkupHelper.createLabel("HR Representative is not populated or editable", ExtentColor.AMBER));
		}

		if (!email.getAttribute("value").isEmpty() && email.getAttribute("disabled").equals("true")) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel(
							"Email Field is populated with value==" + email.getAttribute("value") + "and not Editable",
							ExtentColor.CYAN));
			System.out.println(email.getAttribute("value"));
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Email  is not populated or editable", ExtentColor.RED));
		}

		if (isElementPresent(driver, workPhone)) {
			if (!workPhone.getAttribute("value").isEmpty() && workPhone.getAttribute("disabled").contains("true")) {
				test.get().log(Status.INFO, MarkupHelper.createLabel("Work Phone Field is populated with value=="
						+ workPhone.getAttribute("value") + "and not Editable", ExtentColor.CYAN));
			} else {
				count++;
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("Work Phone is not populated or editable", ExtentColor.RED));
			}
		} else {
			test.get().log(Status.WARNING,
					MarkupHelper.createLabel("Work Phone is not populated or editable", ExtentColor.AMBER));
		}

		if (isElementPresent(driver, companyName)) {
			if (!companyName.getText().isEmpty()) {
				test.get().log(Status.INFO, MarkupHelper.createLabel(
						"the Company name Field is populated with value==" + companyName.getText() + "and not Editable",
						ExtentColor.CYAN));
			} else {
				count++;
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("Company name is not populated or editable", ExtentColor.RED));
			}
		} else {
			test.get().log(Status.WARNING,
					MarkupHelper.createLabel("Company Name is not populated or editable", ExtentColor.AMBER));
		}

		if (activeCheckbox.isDisplayed() && activeCheckbox.isEnabled() == false) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Active Checkbox is displayed and not Editable", ExtentColor.CYAN));
			if (activeCheckbox.isSelected()) {
				test.get().log(Status.INFO,
						MarkupHelper.createLabel("Active Checkbox is selected by default", ExtentColor.CYAN));
			} else {
				count++;
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("Active Checkbox is Not selected by default", ExtentColor.RED));
			}
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Active Checkbox is Not displayed or Editable", ExtentColor.RED));
		}

		if (jobExemptCheckbox.isDisplayed() && jobExemptCheckbox.isEnabled() == false) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("job exempt Checkbox is displayed and not Editable", ExtentColor.CYAN));
			if (jobExemptCheckbox.isSelected()) {
				test.get().log(Status.INFO,
						MarkupHelper.createLabel("job exempt Checkbox is selected by default", ExtentColor.CYAN));
			} else {
				count++;
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("job exempt Checkbox is Not selected by default", ExtentColor.RED));
			}
		} else {
			test.get().log(Status.WARNING,
					MarkupHelper.createLabel("Job Exempt is not populated or editable", ExtentColor.AMBER));
		}

		if (isElementPresent(driver, unionOCCCode)) {
			if (!unionOCCCode.getAttribute("value").isEmpty() && unionOCCCode.getAttribute("disabled").equals("true")) {
				test.get()
						.log(Status.INFO,
								MarkupHelper.createLabel(
										"Union OCC Code Field is populated with value=="
												+ unionOCCCode.getAttribute("value") + "and not Editable",
										ExtentColor.CYAN));
				System.out.println(unionOCCCode.getAttribute("value"));
			} else {
				count++;
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("Union OCC Code Field is not populated or editable", ExtentColor.RED));
			}
		} else {
			test.get().log(Status.WARNING,
					MarkupHelper.createLabel("Union OCC Code is not populated or editable", ExtentColor.AMBER));
		}

		if (coe.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("COE field is displayed", ExtentColor.GREEN));
			System.out.println("COE Field is displayed");
		} else {
			count++;
			test.get().log(Status.FAIL, MarkupHelper.createLabel("COE Field is Not Displayed", ExtentColor.RED));
			System.out.println("COE Field is Not Displayed");
		}

		if (hrService.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("HR Service field is displayed", ExtentColor.GREEN));
			System.out.println("HR Service Field is displayed");
		} else {
			count++;
			test.get().log(Status.FAIL, MarkupHelper.createLabel("HR Service Field is Not Displayed", ExtentColor.RED));
			System.out.println("HR Service Field is Not Displayed");
		}

		if (source.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Source field is displayed", ExtentColor.GREEN));
			System.out.println("Source Field is displayed");
		} else {
			count++;
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Source Field is Not Displayed", ExtentColor.RED));
			System.out.println("Source Field is Not Displayed");
		}

		if (description.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Description field is displayed", ExtentColor.GREEN));
			System.out.println("Description Field is displayed");
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Description Field is Not Displayed", ExtentColor.RED));
			System.out.println("Description Field is Not Displayed");
		}

		if (workNotes.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Work Notes field is displayed", ExtentColor.GREEN));
			System.out.println("Work Notes Field is displayed");
		} else {
			count++;
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Work Notes Field is Not Displayed", ExtentColor.RED));
			System.out.println("Work Notes Field is Not Displayed");
		}

		if (methodOfContact.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Prefered method of contact field is displayed", ExtentColor.GREEN));
			System.out.println("Prefered method of contact Field is displayed");
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Preferred method ofcontact field is Not displayed", ExtentColor.RED));
			System.out.println("Preferred method of contact Field  is Not displayed");
		}

		if (phoneOrEmail.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Phone or email field is displayed", ExtentColor.GREEN));
			System.out.println("phone or email Field is displayed");
		} else {
			count++;
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Phone or Email is Not displayed", ExtentColor.RED));
			System.out.println("Phone or Email is Not displayed");
		}

		if (count == 0) {
			logSuccessScreenshot(driver);
		} else {
			logFailureScreenshot(driver);
			count = 0;
		}
	}

	public void enterRequester(String user) {
		waitForFrameToBeAvailable(driver, "gsft_main");
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
		WebElement requestor = driver.findElement(
				By.xpath("//ul[@class = 'select2-results']/li/descendant::div[contains(text(), '" + user + "')]"));
		waitForElementToBeClickable(driver, requestor);
		System.out.println("Requester Info - " + requestor.getText());
		requestor.click();

		// checkForPageLoad(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, caseCreation);
		if (caseCreation.isDisplayed()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Successdully Navigate to Case Creation Page", ExtentColor.CYAN));
			logInfoScreenshot(driver);
		}
	}

	public void updateHrCaseDashboardIncrease(String user, String hrServicedropdown, String altNumber,
			String descriptionText) {
		waitForFrameToBeAvailable(driver, "gsft_main");
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
		WebElement requestor = driver.findElement(
				By.xpath("//ul[@class = 'select2-results']/li/descendant::div[contains(text(), '" + user + "')]"));
		waitForElementToBeClickable(driver, requestor);
		System.out.println("Requester Info - " + requestor.getText());
		requestor.click();

		// checkForPageLoad(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		if (caseCreation.isDisplayed()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Successdully Navigate to Case Creation Page", ExtentColor.CYAN));
			logInfoScreenshot(driver);
		}

		scrollToElement(driver, source);
		waitForAction(driver);
		waitForElementToBeClickable(driver, source);
		source.click();
		waitForElementToBeClickable(driver, sourceEnter);
		sourceEnter.sendKeys("Phone", Keys.ENTER);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully select the source dropdown value==Phone", ExtentColor.CYAN));

		waitForElementToBeClickable(driver, methodOfContactTxt);
		methodOfContactTxt.click();
		waitForElementToBeClickable(driver, AltEnter);
		AltEnter.sendKeys("Alternate Contact", Keys.ENTER);

		waitForElementToBeClickable(driver, methodOfContactTxt);
		altText = methodOfContactTxt.getText();
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully select the method of contact dropdown value", ExtentColor.CYAN));

		waitForElementToBeClickable(driver, phoneOrEmail);
		phoneOrEmail.sendKeys(altNumber);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully pass the alternate phone number", ExtentColor.CYAN));

		waitForElementToBeClickable(driver, hrService);
		hrService.click();
		waitForElementToBeClickable(driver, hrServiceDropdown);
		hrServiceDropdown.sendKeys(hrServicedropdown);
		waitForElementToBeClickable(driver, hrServiceOption);
		hrServiceOption.click();

		waitForElementToBeClickable(driver, description);
		description.sendKeys(descriptionText);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully pass the description text", ExtentColor.CYAN));
		waitForElementToBeClickable(driver, createCaseBt);
		createCaseBt.click();
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully clicking the create case button", ExtentColor.CYAN));

	}

	// verify the source and alternative contact
	public void selectSourceAndAltContact(String hrServicedropdown, String altNumber, String descriptionText)
			throws Exception {
		waitForFrameToBeAvailable(driver, "gsft_main");
		scrollToElement(driver, source);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, source);
		source.click();
		waitForElementToBeClickable(driver, sourceEnter);
		try {
			sourceEnter.sendKeys("Phone", Keys.ENTER);
		} catch (Exception e) {
			waitForElementToBeClickable(driver, source);
			source.click();
			waitForElementToBeClickable(driver, sourceEnter);
			sourceEnter.sendKeys("Phone", Keys.ENTER);
		}
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully select the source dropdown value==Phone", ExtentColor.CYAN));

		waitForElementToBeClickable(driver, methodOfContactTxt);
		methodOfContactTxt.click();
		waitForElementToBeClickable(driver, AltEnter);
		AltEnter.sendKeys("Alternate Contact", Keys.ENTER);

		waitForElementToBeClickable(driver, methodOfContactTxt);
		altText = methodOfContactTxt.getText();
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully select the method of contact dropdown value", ExtentColor.CYAN));

		waitForElementToBeClickable(driver, phoneOrEmail);
		phoneOrEmail.sendKeys(altNumber);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully pass the alternate phone number", ExtentColor.CYAN));

		waitForElementToBeClickable(driver, hrService);
		hrService.click();
		waitForElementToBeClickable(driver, hrServiceDropdown);
		hrServiceDropdown.sendKeys(hrServicedropdown);
		waitForAction(driver);
		waitForElementToBeClickable(driver, hrServiceOption);
		hrServiceOption.click();

		waitForElementToBeClickable(driver, description);
		description.sendKeys(descriptionText);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully pass the description text", ExtentColor.CYAN));
		waitForElementToBeClickable(driver, createCaseBt);
		createCaseBt.click();
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully clicking the create case button", ExtentColor.CYAN));
		checkForPageLoad(driver);
	}

	// validating the case and verifying the fields
	public String validateCase(String assignTo) throws Exception {
		checkForPageLoad(driver);
		String casenumber = null;
		waitForFrameToBeAvailable(driver, "gsft_main");

		waitForElementToBeClickable(driver, caseNumber);
		if (!caseNumber.getAttribute("value").isEmpty() && caseNumber.getAttribute("readonly").equals("true")) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Number Field is Populated with value==" + caseNumber.getAttribute("value"), ExtentColor.GREEN));
			casenumber = caseNumber.getAttribute("value").trim();
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
			System.out.println("Work phone field is not populated or Editable");
		}

		if (!caseEmail.getAttribute("value").isEmpty()) {
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

			logSuccess("Expected Values - " + "Alternate Contact");
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
				logSuccess("Expected Values - " + "Open");
				logSuccess("Actual Value - " + actualState);
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("State  Field  is Populated with Expected value==" + actualState);
			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("State Field  is Not Populated with Expected value", ExtentColor.RED));
				logFailure("Expected Values - " + "Open");
				logFailure("Actual Value - " + actualState);
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

		String hrPageWindowHandle = driver.getWindowHandle();
		// Perform the click operation that opens new window
		scrollToElement(driver, caseAssignedToSearch);
		waitForElementToBeClickable(driver, caseAssignedToSearch);
		checkForPageLoad(driver);

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		if (waitForElementToBeClickable(driver, caseAssignedToSearch)) {
			// clickUsingJavaScript(driver, caseAssignedToSearch);
			executor.executeScript("arguments[0].click();", caseAssignedToSearch);
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Assign To field is not displayed", ExtentColor.RED));
		}

		// Switch to new window opened
		waitForExpectedNumberOfWindows(driver, 2);
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

				waitForElementToBeClickable(driver, searchCriteria);
				waitForAction(driver);
				Select dropdown = new Select(searchCriteria);
				dropdown.selectByVisibleText("Name");
				waitForElementToBeClickable(driver, searchTextBox);
				searchTextBox.clear();
				waitForAction(driver);
				searchTextBox.sendKeys(assignTo);
				waitForAction(driver);
				searchTextBox.sendKeys(Keys.ENTER);
				waitForAction(driver);
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
		checkForPageLoad(driver);
		driver.switchTo().defaultContent();
		String user = loggedUser.getText();
		// driver.switchTo().frame(0);
		waitForFrameToBeAvailable(driver, "gsft_main");
		checkForPageLoad(driver);

		waitForElement(driver, assignToText);
		if (assignToText.getAttribute("value").equals(user)) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"AssignTo person name and Logged in username both are same==" + assignToText.getAttribute("value"),
					ExtentColor.GREEN));
			logSuccess("Expected Values - " + user);
			logSuccess("Actual Value - " + assignToText.getAttribute("value"));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println(
					"AssignTo person name and Logged in username both are same==" + assignToText.getAttribute("value"));
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"AssignTo person name and Logged in username both Different==" + assignToText.getAttribute("value"),
					ExtentColor.RED));
			logFailure("Expected Values - " + user);
			logFailure("Actual Value - " + assignToText.getAttribute("value"));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("AssignTo person name and Logged in username both Different=="
					+ assignToText.getAttribute("value"));
		}

		waitForAction(driver);
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

		waitForAction(driver);
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

		waitForAction(driver);
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

		waitForAction(driver);
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

		waitForAction(driver);
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

		waitForFrameToBeAvailable(driver, "gsft_main");
		test.get().log(Status.INFO, MarkupHelper.createLabel("Updating the HR Case", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		waitForElementToBeClickable(driver, updateButton);
		updateButton.click();
		waitForAction(driver);

		return casenumber;
	}

	// validating the change about field
	public void changeAbout(String aboutName) throws Exception {
		checkForPageLoad(driver);
		String hrPageWindowHandle = driver.getWindowHandle();
		
		waitForFrameToBeAvailable(driver, "gsft_main");
		scrollToElement(driver, aboutSearchBt);
		// Perform the click operation that opens new window
		waitForElementToBeClickable(driver, aboutSearchBt);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		checkForPageLoad(driver);
		
		if (aboutSearchBt.isDisplayed()) {
			// new Actions(driver).click(aboutSearchBt).build().perform();
			executor.executeScript("arguments[0].click();", aboutSearchBt);
			waitForAction(driver);
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Assign To field is not displayed", ExtentColor.RED));
		}
		if (isAlertPresent(driver)) {
			driver.switchTo().alert().accept();
			waitForAction(driver);
			aboutSearchBt.click();
		}

		// Switch to new window opened
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> windowIterator = handles.iterator();
		// iterate through your windows
		while (windowIterator.hasNext()) {
			String windowName = windowIterator.next();
			if (!windowName.equals(hrPageWindowHandle)) {
				// driver.switchTo().window(windowName);
				System.out.println(windowName);
				driver.switchTo().window(windowName);
				driver.manage().window().maximize();

				driver.navigate().refresh();
				checkForPageLoad(driver);
				waitForElementToBeClickable(driver, searchCriteria);
				Select dropdown = new Select(searchCriteria);
				dropdown.selectByVisibleText("Name");
				waitForElementToBeClickable(driver, searchTextBox);
				searchTextBox.clear();
				waitForAction(driver);
				searchTextBox.sendKeys(aboutName);
				waitForAction(driver);
				searchTextBox.sendKeys(Keys.ENTER);
				waitForAction(driver);
				waitForElementToBeClickable(driver, nameSearchTextBox);
				if (nameSearchTextBox.isDisplayed()) {
					test.get().log(Status.INFO, MarkupHelper
							.createLabel("Entering the value for About to field - " + aboutName, ExtentColor.CYAN));
					waitForElementToBeClickable(driver, nameSearchTextBox);
					nameSearchTextBox.sendKeys(aboutName);
					waitForAction(driver);
					nameSearchTextBox.sendKeys(Keys.ENTER);
					waitForAction(driver);
					test.get().log(Status.PASS, MarkupHelper
							.createLabel("Successfully change the About Name- " + aboutName, ExtentColor.CYAN));
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
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
		checkForPageLoad(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		checkForPageLoad(driver);
		scrollToElement(driver, caseAbout);

		waitForElementToBeClickable(driver, caseAbout);
		if (!caseAbout.getAttribute("value").isEmpty() && caseAbout.isEnabled()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("About Field  is Populated After Changing workername with value=="
							+ caseAbout.getAttribute("value") + " and Editable", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("About Field  is Populated After Changing workername with value=="
					+ caseAbout.getAttribute("value") + " and Editable");
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"About field is not Populated or Not Editable After Changing workername", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("About field is not Populated or Not Editable After Changing workername");
		}

		waitForAction(driver);
		if (!employeeNum.getAttribute("value").isEmpty() && employeeNum.getAttribute("readonly").equals("true")) {
			test.get()
					.log(Status.PASS,
							MarkupHelper.createLabel(
									"Employee Number Field  is Populated After Changing workername with value=="
											+ employeeNum.getAttribute("value") + " and Not Editable",
									ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Employee Number Field is Populated After Changing workername with value=="
					+ employeeNum.getAttribute("value") + " and Not Editable");
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Employee Number field is not Populated or Editable After Changing workername", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Employee Number field is not Populated or Editable After Changing workername");
		}

		waitForAction(driver);
		if (!businessTitle.getAttribute("value").isEmpty() && businessTitle.getAttribute("readonly").equals("true")) {
			test.get()
					.log(Status.PASS,
							MarkupHelper.createLabel(
									"Business Title Field  is Populated After Changing workername with value=="
											+ businessTitle.getAttribute("value") + " and Not Editable",
									ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Business Title Field is Populated After Changing workername with value=="
					+ businessTitle.getAttribute("value") + " and Not Editable");
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Business Title field is not Populated or Editable After Changing workername", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Business Title field is not Populated or Editable After Changing workername");
		}

		waitForAction(driver);
		if (!caseCompanyName.getAttribute("value").isEmpty()
				&& caseCompanyName.getAttribute("readonly").equals("true")) {
			test.get()
					.log(Status.PASS,
							MarkupHelper.createLabel(
									"Company Name Field is Populated After Changing workername with value=="
											+ caseCompanyName.getAttribute("value") + " and Not Editable",
									ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Company Name Field is Populated After Changing workername with value=="
					+ caseCompanyName.getAttribute("value") + " and Not Editable");
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Company name field is not Populated or Editable After Changing workername", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Company name field is not Populated or Editable After Changing workername");
		}

		waitForAction(driver);
		if (!casePayGroup.getAttribute("value").isEmpty() && casePayGroup.getAttribute("readonly").equals("true")) {
			test.get()
					.log(Status.PASS,
							MarkupHelper.createLabel(
									"Pay Group Field is Populated After Changing workername with value=="
											+ casePayGroup.getAttribute("value") + " and Not Editable",
									ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Pay Group Field is Populated After Changing workername with value=="
					+ casePayGroup.getAttribute("value") + " and Not Editable");
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Pay Group field is not Populated or Editable After Changing workername", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Pay Group field is not Populated or Editable After Changing workername");
		}

		waitForAction(driver);
		if (!caseUnionOccCode.getAttribute("value").isEmpty()
				&& caseUnionOccCode.getAttribute("readonly").equals("true")) {
			test.get()
					.log(Status.PASS,
							MarkupHelper.createLabel(
									"Union Occ Code Field is Populated After Changing workername with value=="
											+ caseUnionOccCode.getAttribute("value") + " and Not Editable",
									ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Union Occ Code Field is Populated After Changing workername with value=="
					+ caseUnionOccCode.getAttribute("value") + " and Not Editable");

		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Union Occ Code field is not Populated or Editable After Changing workername", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Union Occ Code field is not Populated or Editable After Changing workername");
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
			System.out.println("Employment Type Field is Populated After Changing workername with value=="
					+ caseEmploymentType.getAttribute("value") + " and Not Editable");
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Employment Type field is not Populated or Editable After Changing workername", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Employment Type field is not Populated or Editable After Changing workername");
		}
		if (!caseHrRepresentative.getAttribute("value").isEmpty()
				&& caseHrRepresentative.getAttribute("readonly").equals("true")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"HR Representative Field is Populated After Changing workername with value=="
									+ caseHrRepresentative.getAttribute("value") + " and Not Editable",
							ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("HR Representative Field is Populated After Changing workername with value=="
					+ caseHrRepresentative.getAttribute("value") + " and Not Editable");
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"HR Representative field is not Populated or Editable After Changing workername", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("HR Representative field is not Populated or Editable After Changing workername");
		}
		if (caseActiveCheckbox.isSelected() && caseActiveCheckbox.getAttribute("aria-readonly").equals("true")) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Active CheckBox is selected and Not Editable After Changing workername", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Active Checkbox is selected and Not Editable After Changing workername");
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Active CheckBox is Not selected or Editable After Changing workername", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Active Checkbox is Not selected and or Editable After Changing workername");
		}
		if (caseJobExempt.isSelected() && caseJobExempt.getAttribute("aria-readonly").equals("true")) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"JobExempt CheckBox is selected and Not Editable After Changing workername", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Job Exempt Checkbox is selected and Not Editable After Changing workername");
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"job Exempt CheckBox is Not selected or Editable After Changing workername", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("job Exempt Checkbox is Not selected and or Editable After Changing workername");
		}

		if (shortDescription.getAttribute("value").contains(caseAbout.getAttribute("value"))) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"short description is updated accordingly after changing about name", ExtentColor.GREEN));

			logSuccess("Expected Values - " + caseAbout.getAttribute("value"));
			logSuccess("Actual Value - " + shortDescription.getAttribute("value"));

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("short description is updated accordingly after changing about name");
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"short description is Not updated accordingly after changing about name", ExtentColor.RED));

			logFailure("Expected Values - " + caseAbout.getAttribute("value"));
			logFailure("Actual Value - " + shortDescription.getAttribute("value"));

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("short description is Not updated accordingly after changing about name");
		}
	}

	// case save

	public void saveCase() throws Exception {
		waitForFrameToBeAvailable(driver, "gsft_main");
		test.get().log(Status.INFO, MarkupHelper.createLabel("Updating the HR Case", ExtentColor.CYAN));
		scrollToElement(driver, updateButton);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, caseNumber);
		caseNumber.click();
		waitForElementToBeClickable(driver, updateButton);
		updateButton.click();
		waitForAction(driver);
		driver.navigate().back();

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForAction(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", worknotes);
		js.executeScript("arguments[0].textContent='" + "Case Resolved" + "';", worknotes);
		System.out.println("Worknotes Entered as - " + "Case Resolved");
		waitForElementToBeClickable(driver, postBt);
		postBt.click();
		waitForAction(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, caseState);
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[text()='PIN']")));
		Select selectstate = new Select(caseState);
		selectstate.selectByVisibleText("Resolved");
		test.get().log(Status.PASS,
				MarkupHelper.createLabel("Successfully selecting state dropdown == Resolved", ExtentColor.GREEN));
		waitForElementToBeClickable(driver, caseWorknotes);
		caseWorknotes.sendKeys("case resolved");
		// postBt.click();js.executeScript("arguments[0].scrollIntoView();",
		// caseWorknotes);
		js.executeScript("arguments[0].textContent='" + "Case Resolved" + "';", caseWorknotes);
		System.out.println("Worknotes Entered as - " + "Case Resolved");

		waitForFrameToBeAvailable(driver, "gsft_main");
		test.get().log(Status.INFO, MarkupHelper.createLabel("Updating the HR Case", ExtentColor.CYAN));
		logInfoScreenshot(driver);
		waitForElementToBeClickable(driver, updateButton);
		updateButton.click();
		checkForPageLoad(driver);
	}

	// validating the SLA after creating the case
	public void checkSLA(String assignto) throws Exception {
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, taskSla);
		checkForPageLoad(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", taskSla);
		test.get().log(Status.PASS,
				MarkupHelper.createLabel("successfully Navigate to the TaskSLA(1) Tab", ExtentColor.GREEN));
		checkForPageLoad(driver);
		scrollToElement(driver, taskSla);
		waitForElementToBeClickable(driver, taskSla);
		checkForPageLoad(driver);
		taskSla.click();
		scrollToElement(driver, xpIicon);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, xpIicon);
		xpIicon.click();
		// new Actions(driver).click(xpIicon).build().perform();

		scrollToElement(driver, target);
		waitForElementToBeClickable(driver, target);
		if (target.getAttribute("value").equals("Resolution")) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Only Resolution SLA is Visible", ExtentColor.GREEN));
			test.get().log(Status.INFO, MarkupHelper.createLabel(
					"Business Elapsed Time is showing==" + businessElapsedTime.getText(), ExtentColor.CYAN));

			logSuccess("Expected Values - " + "Resolution");
			logSuccess("Actual Value - " + target.getAttribute("value"));

		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Resolution SLA is Not Visible", ExtentColor.RED));

			logFailure("Expected Values - " + "Resolution");
			logFailure("Actual Value - " + target.getAttribute("value"));

		}

		scrollToElement(driver, xpIicon);
		waitForElementToBeClickable(driver, xpIicon);
		xpIicon.click();
		waitForAction(driver);
		js.executeScript("arguments[0].scrollIntoView();", caseState);
		Select selectstate = new Select(caseState);
		selectstate.selectByVisibleText("Pending");
		test.get().log(Status.PASS,
				MarkupHelper.createLabel("Successfully selecting state dropdown ==Pending", ExtentColor.GREEN));
		waitForElementToBeClickable(driver, caseWorknotes);
		caseWorknotes.sendKeys("case pending");
		// postBt.click();
		test.get().log(Status.INFO, MarkupHelper.createLabel("Entering the worknotes case pending", ExtentColor.CYAN));

		String hrPageWindowHandle = driver.getWindowHandle();
		// Perform the click operation that opens new window
		waitForElement(driver, caseAssignedToSearch);
		scrollToElement(driver, caseAssignedToSearch);
		if (caseAssignedToSearch.isDisplayed()) {
			waitForElementToBeClickable(driver, caseAssignedToSearch);
			clickUsingJavaScript(driver, caseAssignedToSearch);
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
				// driver.switchTo().window(windowName);
				System.out.println(windowName);
				driver.switchTo().window(windowName);
				driver.manage().window().maximize();
				waitForElementToBeClickable(driver, searchCriteria);
				Select dropdown = new Select(searchCriteria);
				dropdown.selectByVisibleText("Name");
				searchTextBox.clear();
				waitForElementToBeClickable(driver, searchTextBox);
				searchTextBox.sendKeys(assignto);
				waitForAction(driver);
				searchTextBox.sendKeys(Keys.ENTER);
				checkForPageLoad(driver);
				waitForElementToBeClickable(driver, nameSearchTextBox);
				if (nameSearchTextBox.isDisplayed()) {
					test.get().log(Status.INFO, MarkupHelper
							.createLabel("Entering the value for Assign to field - " + assignto, ExtentColor.CYAN));
					waitForElementToBeClickable(driver, nameSearchTextBox);
					// nameSearchTextBox.clear();
					nameSearchTextBox.sendKeys(assignto);
					waitForAction(driver);
					nameSearchTextBox.sendKeys(Keys.ENTER);
					waitForAction(driver);
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					WebElement searchResult = driver.findElement(
							By.xpath("//*[contains(@class, 'glide_ref_item_link') and contains(@role, 'button')]"));
					try {
						searchResult.click();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		waitForExpectedNumberOfWindows(driver, 1);
		driver.switchTo().window(hrPageWindowHandle);
		// driver.switchTo().defaultContent();
		// driver.switchTo().frame(0);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, updateButton);
		checkForPageLoad(driver);
		updateButton.click();
		checkForPageLoad(driver);

		driver.navigate().back();

		waitForFrameToBeAvailable(driver, "gsft_main");
		checkForPageLoad(driver);

		waitForElement(driver, taskSlaOpen);
		test.get().log(Status.PASS,
				MarkupHelper.createLabel("successfully Update the case and saved", ExtentColor.GREEN));
		scrollToElement(driver, taskSla);
		scrollPageDown(driver);
		waitForElementToBeClickable(driver, taskSla);
		taskSla.click();
		test.get().log(Status.PASS, MarkupHelper.createLabel("navigating to the taskSLA tab", ExtentColor.GREEN));
		checkForPageLoad(driver);

		WebElement stage = null;
		int index = 0;
		for (int i = 0; i < taskSlaHeading.size(); i++) {
			if (taskSlaHeading.get(i).getText().trim().contains("Stage")) {
				index = i + 3;
			}
		}
		stage = driver.findElement(By.xpath("//tr[contains(@id,'task_sla.task')]/td[" + index + "]"));
		if (stage.getText().equalsIgnoreCase("Paused")) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("SLA State Has Been Pending", ExtentColor.GREEN));
			logSuccess("Expected Values - " + "Paused");
			logSuccess("Actual Value - " + stage.getText());
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("SLA State Not in Pending state", ExtentColor.RED));
			logFailure("Expected Values - " + "Paused");
			logFailure("Actual Value - " + stage.getText());
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		WebElement ele = driver.findElement(By.id("sys_readonly.sn_hr_core_case_total_rewards.hr_profile.ssn"));
		try {
			js.executeScript("arguments[0].scrollIntoView(true);", ele);
		} catch (Exception e) {
			e.printStackTrace();

		}
		// js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		selectstate.selectByVisibleText("Open");
		test.get().log(Status.PASS,
				MarkupHelper.createLabel("Successfully selecting state dropdown ==Open", ExtentColor.GREEN));

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("successfully Update the case and saved", ExtentColor.CYAN));
		logInfoScreenshot(driver);
		waitForElementToBeClickable(driver, updateButton);
		updateButton.click();
		waitForAction(driver);
		driver.navigate().back();
		waitForAction(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		js.executeScript("arguments[0].scrollIntoView();", taskSlaOpen);
		waitForElementToBeClickable(driver, taskSlaOpen);
		taskSlaOpen.click();

		index = 0;
		for (int i = 0; i < taskSlaHeading.size(); i++) {
			if (taskSlaHeading.get(i).getText().trim().contains("Stage")) {
				index = i + 3;
			}
		}
		stage = driver.findElement(By.xpath("//tr[contains(@id,'task_sla.task')]/td[" + index + "]"));
		if (stage.getText().equalsIgnoreCase("In Progress")) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("SLA State Has Been Open", ExtentColor.GREEN));

			logSuccess("Expected Values - " + "In Progress");
			logSuccess("Actual Value - " + stage.getText());

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("SLA State Not in Open state", ExtentColor.RED));
			logFailure("Expected Values - " + "In Progress");
			logFailure("Actual Value - " + stage.getText());
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}
}
