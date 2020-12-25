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

public class HRCreateCaseGuest extends ReusableLibrary {
	public WebDriver driver;

	public HRCreateCaseGuest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='filter']")
	public WebElement leftSearch;

	@FindBy(xpath = "//*[text() = 'All']/ancestor::a[contains(@href, 'sn_hr_core_case_list')]")
	public WebElement allHRCases;

	@FindBy(xpath = "//span[text()='Search for requester or case number']")
	public WebElement searchForRequester;

	@FindBy(xpath = "//*[@id='s2id_autogen1_search']")
	public WebElement enterSearchRequester;

	// @FindBy(xpath = "//*[@class = 'select2-drop select2-display-none
	// select2-with-searchbox select2-drop-active']/ul/li")
	@FindBy(xpath = "//*[@class = 'select2-drop select2-display-none select2-with-searchbox select2-drop-active']/ul/li")
	public List<WebElement> uniqueRequester;

	@FindBy(xpath = "//div[text()='Case Details']")
	public WebElement caseCreation;
	// --------create case------------------------

	@FindBy(xpath = "//div[@id='s2id_coe_input']/a")
	public WebElement coe;

	@FindBy(xpath = "//div[@id='s2id_service_input']/a")
	public WebElement hrService;

	@FindBy(id = "ev_field_u_open_for_guest_full_name")
	public WebElement guestFullName;

	@FindBy(id = "ev_field_u_open_for_guest_organization")
	public WebElement guestOrganization;

	@FindBy(id = "ev_field_u_open_for_guest_contact")
	public WebElement guestContact;

	@FindBy(xpath = "//div[@id='s2id_ev_field_contact_type']/a")
	public WebElement source;

	@FindBy(xpath = "//*[@id='s2id_autogen7_search']")
	public WebElement sourceEnter;

	@FindBy(xpath = "//select[@id='ev_field_contact_type']")
	public WebElement sourceDropDown;

	@FindBy(xpath = "//label[text() ='HR service']/following-sibling::input[@id='s2id_autogen2_search']")
	public WebElement hrServiceTextBox;

	@FindBy(xpath = "//*[@id='select2-drop']/ul/li/ul/li")
	public WebElement hrServiceOption;

	@FindBy(id = "ev_field_u_subject_person_guest_full_name")
	public WebElement subjectPersonGuestFName;

	@FindBy(id = "ev_field_u_subject_person_guest_organization")
	public WebElement subjectPersonGuestOrganization;

	@FindBy(id = "ev_field_u_subject_person_guest_contact")
	public WebElement subjectPersonGuestContact;

	@FindBy(xpath = "//textarea[@id='ev_field_description']")
	public WebElement description;

	@FindBy(xpath = "(//button[text()='Create Case'])[2]")
	public WebElement createCaseBt;

	// ----------------Validate case--------------------
	@FindBy(xpath = "//*[contains(@id, 'sys_display.sn_hr_core') and contains(@id, 'opened_for')]")
	public WebElement requestedBy;

	@FindBy(xpath = "//input[contains(@id, 'sn_hr_core') and contains(@id, 'u_open_for_guest_full_name') and @type = 'text']")
	public WebElement openGuestFullname;

	@FindBy(xpath = "//input[contains(@id, 'u_open_for_guest_organization') and @type = 'text']")
	public WebElement openGuestOrg;

	@FindBy(xpath = "//input[contains(@id, 'u_open_for_guest_contact') and @type = 'text']")
	public WebElement openGuestContact;

	@FindBy(xpath = "//input[contains(@id, 'subject_person') and @type = 'search']")
	public WebElement about;

	@FindBy(xpath = "//input[contains(@id, 'u_subject_person_guest_full_name') and @type = 'text']")
	public WebElement subjectPersonFullname;

	@FindBy(xpath = "//input[contains(@id, 'u_subject_person_guest_organization') and @type = 'text']")
	public WebElement subjectPersonGuestOrg;

	@FindBy(xpath = "//input[contains(@id, 'u_subject_person_guest_contact') and @type = 'text']")
	public WebElement subPersonGuestContact;

	@FindBy(xpath = "//select[contains(@id, 'sn_hr_core_') and contains(@id, '.state')]")
	public WebElement caseState;

	@FindBy(xpath = "//select[contains(@id, 'sn_hr_core_') and contains(@id, '.priority')]")
	public WebElement casePriority;

	@FindBy(xpath = "//select[contains(@id, 'sn_hr_core_') and contains(@id, '.contact_type')]")
	public WebElement caseSource;

	@FindBy(xpath = "//input[contains(@id, 'sn_hr_core_') and contains(@id, '.opened_at') and @readonly]")
	public WebElement caseOpened;

	@FindBy(xpath = "//input[contains(@id, 'sn_hr_core_') and contains(@id, '.opened_by_label') and @readonly]")
	public WebElement caseOpenedBy;

	@FindBy(xpath = "//input[contains(@id, 'sn_hr_core_') and contains(@id, '.hr_service') and @type = 'search']")
	public WebElement caseHrService;

	@FindBy(xpath = "//input[contains(@id, 'sn_hr_core_') and contains(@id, '.assignment_group') and @type = 'search']")
	public WebElement caseAssignmentGroup;

	@FindBy(xpath = "//*[contains(@id, 'lookup') and contains(@id, '.assigned_to')]/parent::span")
	public WebElement caseAssignedToSearch;

	@FindBy(xpath = "//select[contains(@id,'_select')]")
	public WebElement searchCriteria;

	@FindBy(xpath = "//select[contains(@id,'_select') and contains(@class, 'focus')]")
	public WebElement searchHRCase;

	@FindBy(xpath = "//input[contains(@id,'_text')]")
	public WebElement searchTextBox;

	@FindBy(xpath = "(//*[@id='sys_user_table_header_search_control'])[1]")
	public WebElement nameSearchTextBox;

	@FindBy(xpath = "//*[@id='user_info_dropdown']/div/span[1]")
	public WebElement loggedUser;

	@FindBy(id = "sys_display.sn_hr_core_case_total_rewards.assigned_to")
	public WebElement assignToText;

	@FindBy(xpath = "//*[contains(@id,'header') and contains(@class,'section_header_div_no_scroll form_title')]")
	public WebElement header;

	@FindBy(xpath = "//*[@role='menuitem' and @title = 'Save record and remain here']")
	public WebElement saveOption;

	@FindBy(xpath = "//textarea[@id='activity-stream-work_notes-textarea']")
	// @FindBy(xpath =
	// "//textarea[@id='sn_hr_core_hr_employee_services.work_notes']")
	public WebElement caseWorknotes;

	@FindBy(xpath = "//button[text()='Post']")
	public WebElement postBt;
	// ---------------after changing about-----------------

	@FindBy(xpath = "//*[contains(@id, 'sys_display') and contains(@id, 'subject_person')]")
	public WebElement caseAbout;

	@FindBy(xpath = "//*[contains(@id, 'status') and contains(@id, 'subject_person')]")
	public WebElement aboutMandatory;

	// @FindBy(id =
	// "sys_readonly.sn_hr_core_hr_employee_services.subject_person.employee_number")
	// updated
	@FindBy(xpath = "//*[contains(@id, 'sys_readonly') and contains(@id, 'subject_person.employee_number')]")
	public WebElement employeeNum;

	// @FindBy(id =
	// "sn_hr_core_hr_employee_services.subject_person_hr_profile.u_business_title")updated
	@FindBy(xpath = "//*[contains(@id, 'sys_readonly') and contains(@id, 'subject_person_hr_profile.u_business_title')]")
	public WebElement businessTitle;

	// @FindBy(id =
	// "sys_display.sn_hr_core_hr_employee_services.subject_person_hr_profile.u_company_code")
	@FindBy(xpath = "//*[contains(@id, 'sn_hr_core') and contains(@id, 'subject_person_hr_profile.u_company_code_label')]")
	public WebElement caseCompanyName;

	// @FindBy(id =
	// "sn_hr_core_hr_employee_services.subject_person_hr_profile.u_pay_group")
	@FindBy(xpath = "//*[contains(@id, 'sys_readonly') and contains(@id, 'subject_person_hr_profile.u_pay_group')]")
	public WebElement casePayGroup;

	// @FindBy(id =
	// "sn_hr_core_hr_employee_services.subject_person_hr_profile.u_union_code")
	@FindBy(xpath = "//*[contains(@id, 'sys_readonly') and contains(@id, 'subject_person_hr_profile.u_union_code')]")
	public WebElement caseUnionOccCode;

	// @FindBy(id =
	// "sn_hr_core_hr_employee_services.subject_person_hr_profile.employment_type")
	@FindBy(xpath = "//*[contains(@id, 'sys_readonly') and contains(@id, 'subject_person_hr_profile.employment_type')]")
	public WebElement caseEmploymentType;

	// @FindBy(id =
	// "sys_display.sn_hr_core_hr_employee_services.subject_person_hr_profile.u_hr_representative")
	@FindBy(xpath = "//*[contains(@id, 'sn_hr_core_') and contains(@id, 'subject_person_hr_profile.u_hr_representative_label')]")
	public WebElement caseHrRepresentative;

	// @FindBy(id = "ni.sn_hr_core_hr_employee_services.subject_person.active")
	@FindBy(xpath = "//*[contains(@id, 'ni.sn_hr_core') and contains(@id, 'subject_person.active')]")
	public WebElement caseActiveCheckbox;

	@FindBy(xpath = "//*[contains(@id, 'ni.sn_hr_core') and contains(@id, 'subject_person_hr_profile.u_job_exempt')]")
	public WebElement caseJobExempt;

	@FindBy(xpath = "//*[contains(@id, 'lookup.') and contains(@id, '.subject_person')]")
	public WebElement aboutSearchBt;

	@FindBy(xpath = "//button[@id = 'sysverb_update']")
	public WebElement updateButton;

	@FindBy(xpath = "//input[contains(@id, 'sys_readonly') and contains(@id, '.number')]")
	public WebElement hrCaseNumber;

	String fullname;
	String organization;
	String guestcontact;
	String subPersonName;
	String subOrg;
	String subCOntact;

	// searching the Guest in the requester search bar
	public void searchGuest(String user) throws Exception {
		driver.navigate().refresh();
		waitForFrameToBeAvailable(driver, "gsft_main");
		checkForPageLoad(driver);

		waitForElementToBeClickable(driver, searchForRequester);
		searchForRequester.click();
		// new Actions(driver).click(searchForRequester).build().perform();
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully clicking the Search for requester dropdown", ExtentColor.CYAN));

		while (!waitForElementToBeClickable(driver, enterSearchRequester)) {
			searchForRequester.click();
			checkForPageLoad(driver);
		}

		waitForElementToBeClickable(driver, enterSearchRequester);
		enterSearchRequester.sendKeys(user);

		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, driver.findElement(By.xpath("//ul[@class = 'select2-results']/li")));

		if (user.contains("_")) {
			user = user.replace("_", " ");
		}

		checkForPageLoad(driver);
		waitForElement(driver, driver.findElement(
				By.xpath("//ul[@class = 'select2-results']/li/descendant::div[contains(text(), '" + user + "')]")));
		WebElement requestor = driver.findElement(
				By.xpath("//ul[@class = 'select2-results']/li/descendant::div[contains(text(), '" + user + "')]"));
		waitForElementToBeClickable(driver, requestor);
		System.out.println("Requester Info - " + requestor.getText());
		// requestor.click();
		new Actions(driver).click(requestor).build().perform();

		waitForElement(driver, caseCreation);
		if (caseCreation.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Successdully Navigate to Guest Case Creation Page", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Navigation failed to Guest Case Creation Page", ExtentColor.RED));
		}
	}

	/**
	 * Entering the create case Guest details
	 * 
	 * @param service
	 * @param gFullName
	 * @param org
	 * @param contact
	 * @throws Exception
	 */
	public void createCaseGuest(String service, String gFullName, String org, String contact) throws Exception {
		checkForPageLoad(driver);
		waitForElement(driver, hrService);
		if (hrService.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("HR Service Field is displayed", ExtentColor.GREEN));
			waitForElementToBeClickable(driver, hrService);
			hrService.click();
			waitForElementToBeClickable(driver, hrServiceTextBox);
			hrServiceTextBox.sendKeys(service);
			waitForAction(driver);
			waitForElementToBeClickable(driver, hrServiceOption);
			hrServiceOption.click();
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Successfully pass the Hr Service==" + service, ExtentColor.CYAN));

		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("HR Service Field is Not displayed", ExtentColor.RED));

		}
		if (coe.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("Coe Field is dispalyed with value==" + coe.getAttribute("value"), ExtentColor.GREEN));

		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Coe Field is Not displayed", ExtentColor.RED));

		}
		if (guestFullName.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Guest Full Name Field is displayed", ExtentColor.GREEN));
			waitForElementToBeClickable(driver, guestFullName);
			guestFullName.sendKeys(gFullName);
			fullname = gFullName;

			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Successdully pass the guest full name==" + gFullName, ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Guest Full Name Field is Not displayed", ExtentColor.RED));

		}
		if (guestOrganization.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Guest Organization Field is dispalyed", ExtentColor.GREEN));
			waitForElementToBeClickable(driver, guestOrganization);
			guestOrganization.sendKeys(org);
			organization = org;
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Successdully pass the Guest Organization==" + org, ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Guest Organiztion Field is Not displayed", ExtentColor.RED));

		}
		if (guestContact.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Guest Contact Field is dispalyed", ExtentColor.GREEN));
			waitForElementToBeClickable(driver, guestContact);
			guestContact.sendKeys(contact);
			guestcontact = contact;
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Successdully pass the Guest Contact==" + contact, ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Guest Contact Field is Not displayed", ExtentColor.RED));
		}

		waitForElement(driver, source);
		scrollToElement(driver, source);
		source.click();
		if (waitForElementToBeClickable(driver, sourceEnter)) {
			sourceEnter.sendKeys("Phone", Keys.ENTER);
		} else {
			source.click();
			waitForElementToBeClickable(driver, sourceEnter);
			sourceEnter.sendKeys("Phone", Keys.ENTER);
		}

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully select the source dropdown value==Phone", ExtentColor.CYAN));
	}

	/**
	 * Entering the subject person guest details
	 * 
	 * @param sGuestfullName
	 * @param sGuestOrg
	 * @param sGuestContact
	 * @param desc
	 * @throws Exception
	 */
	public void createCaseGuestSubjectPerson(String sGuestfullName, String sGuestOrg, String sGuestContact, String desc)
			throws Exception {
		// fields are removed from the application
		/*
		 * if (subjectPersonGuestFName.isDisplayed()) { test.get().log(Status.PASS,
		 * MarkupHelper.createLabel("Subject person guest full name is displayed",
		 * ExtentColor.GREEN)); subjectPersonGuestFName.sendKeys(sGuestfullName);
		 * subPersonName = sGuestfullName; test.get().log(Status.INFO,
		 * MarkupHelper.createLabel(
		 * "Successdully pass Subject person guest full name==" + sGuestfullName,
		 * ExtentColor.CYAN)); screenshotPath = getScreenshot(driver,
		 * this.getClass().getName()); test.get().info("Details",
		 * MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); }
		 * else { test.get().log(Status.FAIL, MarkupHelper.
		 * createLabel("Subject person guest full name Field is Not displayed",
		 * ExtentColor.RED)); } if (subjectPersonGuestOrganization.isDisplayed()) {
		 * test.get().log(Status.PASS,
		 * MarkupHelper.createLabel("Subject person guest organization is displayed",
		 * ExtentColor.GREEN)); subjectPersonGuestOrganization.sendKeys(sGuestOrg);
		 * subOrg = sGuestOrg; test.get().log(Status.INFO, MarkupHelper.createLabel(
		 * "Successdully pass Subject person guest Organization==" + sGuestOrg,
		 * ExtentColor.CYAN)); screenshotPath = getScreenshot(driver,
		 * this.getClass().getName()); test.get().info("Details",
		 * MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); }
		 * else { test.get().log(Status.FAIL, MarkupHelper
		 * .createLabel("Subject person guest organization Field is Not displayed",
		 * ExtentColor.RED)); } if (subjectPersonGuestContact.isDisplayed()) {
		 * test.get().log(Status.PASS,
		 * MarkupHelper.createLabel("Subject person guest Contact is displayed",
		 * ExtentColor.GREEN)); subjectPersonGuestContact.sendKeys(sGuestContact);
		 * subCOntact = sGuestContact; test.get().log(Status.INFO, MarkupHelper
		 * .createLabel("Successdully pass Subject person guest Contact==" +
		 * sGuestContact, ExtentColor.CYAN)); screenshotPath = getScreenshot(driver,
		 * this.getClass().getName()); test.get().info("Details",
		 * MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); }
		 * else { test.get().log(Status.FAIL, MarkupHelper.
		 * createLabel("Subject person guest Contact Field is Not displayed",
		 * ExtentColor.RED)); }
		 */
		if (description.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Discription Field is displayed", ExtentColor.GREEN));
			waitForElementToBeClickable(driver, description);
			description.sendKeys(desc);
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Successfully pass the Desception==" + desc, ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Discription Field is Not displayed", ExtentColor.RED));
		}

		waitForElementToBeClickable(driver, createCaseBt);
		createCaseBt.click();
		checkForPageLoad(driver);
	}

	/**
	 * This method validate the create case Guest
	 * 
	 * @param assignto
	 * @throws Exception
	 */
	public String validateCaseGuest(String assignto) throws Exception {
		checkForPageLoad(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, requestedBy);
		if (requestedBy.getAttribute("value").trim().equals("Guest")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"RequestedBy field is Populated with Expected value==" + requestedBy.getAttribute("value"),
							ExtentColor.GREEN));
			logSuccess("Expected Values - " + "Guest");
			logSuccess("Actual Value - " + requestedBy.getAttribute("value").trim());
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("RequestedBy field is Not populated with Expected value", ExtentColor.RED));
			logFailure("Expected Values - " + "Guest ");
			logFailure("Actual Value - " + requestedBy.getAttribute("value"));
		}
		if (openGuestFullname.getAttribute("value").equals(fullname)) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Open Guest full name  field is Populated with Expected value=="
							+ openGuestFullname.getAttribute("value"), ExtentColor.GREEN));
			logSuccess("Expected Values - " + fullname);
			logSuccess("Actual Value - " + openGuestFullname.getAttribute("value"));
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Open Guest full name field is Not populated with Expected value", ExtentColor.RED));
			logFailure("Expected Values - " + fullname);
			logFailure("Actual Value - " + openGuestFullname.getAttribute("value"));
		}
		if (openGuestOrg.getAttribute("value").equals(organization)) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Open Guest Organization field is Populated with Expected value=="
							+ openGuestOrg.getAttribute("value"), ExtentColor.GREEN));
			logSuccess("Expected Values - " + organization);
			logSuccess("Actual Value - " + openGuestOrg.getAttribute("value"));
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Open Guest organization field is Not populated with Expected value", ExtentColor.RED));
			logFailure("Expected Values - " + organization);
			logFailure("Actual Value - " + openGuestOrg.getAttribute("value"));
		}
		if (openGuestContact.getAttribute("value").equals(guestcontact)) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Open Guest Cotest.get()ntact field is Populated with Expected value=="
							+ openGuestContact.getAttribute("value"), ExtentColor.GREEN));
			logSuccess("Expected Values - " + guestcontact);
			logSuccess("Actual Value - " + openGuestContact.getAttribute("value"));
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Open Guest Contact field is Not populated with Expected value", ExtentColor.RED));
			logFailure("Expected Values - " + guestcontact);
			logFailure("Actual Value - " + openGuestContact.getAttribute("value"));
		}
		if (about.getAttribute("value").equals("Guest ")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"About  field is Populated with Expected value==" + about.getAttribute("value"),
							ExtentColor.GREEN));
			logSuccess("Expected Values - " + "Guest ");
			logSuccess("Actual Value - " + about.getAttribute("value"));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("About field is Not populated with Expected value", ExtentColor.RED));
			logFailure("Expected Values - " + "Guest ");
			logFailure("Actual Value - " + about.getAttribute("value"));
		}

		// fields are removed from the application
		/*
		 * if (subjectPersonFullname.getAttribute("value").equals(subPersonName)) {
		 * test.get().log(Status.PASS, MarkupHelper.
		 * createLabel("Subject person guest full name field is Populated with Expected value=="
		 * + subjectPersonFullname.getAttribute("value"), ExtentColor.GREEN)); } else {
		 * test.get().log(Status.FAIL, MarkupHelper.createLabel(
		 * "Subject person guest full name field is Not populated with Expected value",
		 * ExtentColor.RED)); } if
		 * (subjectPersonGuestOrg.getAttribute("value").equals(subOrg)) {
		 * test.get().log(Status.PASS, MarkupHelper
		 * .createLabel("Subject person guest Organization field is Populated with Expected value=="
		 * + subjectPersonGuestOrg.getAttribute("value"), ExtentColor.GREEN)); } else {
		 * test.get().log(Status.FAIL, MarkupHelper.createLabel(
		 * "Subject person guest Organization field is Not populated with Expected value"
		 * , ExtentColor.RED)); } if
		 * (subPersonGuestContact.getAttribute("value").equals(subCOntact)) {
		 * test.get().log(Status.PASS, MarkupHelper.
		 * createLabel("Subject person guest Contact field is Populated with Expected value=="
		 * + subPersonGuestContact.getAttribute("value"), ExtentColor.GREEN)); } else {
		 * test.get().log(Status.FAIL, MarkupHelper.createLabel(
		 * "Subject person guest Contact field is Not populated with Expected value",
		 * ExtentColor.RED)); }
		 */

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

		// entering the AssignTo
		String hrPageWindowHandle = driver.getWindowHandle();
		// Perform the click operation that opens new window
		scrollToElement(driver, caseAssignedToSearch);
		if (waitForElementToBeClickable(driver, caseAssignedToSearch)) {
			clickUsingJavaScript(driver, caseAssignedToSearch);
			// clickUsingJavaScript(driver, caseAssignedToSearch);
			checkForPageLoad(driver);
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Assign To field is not displayed", ExtentColor.RED));
		}

		waitForExpectedNumberOfWindows(driver, 2);
		// Switch to new window opened
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> windowIterator = handles.iterator();
		// iterate through your windows
		while (windowIterator.hasNext()) {
			String windowName = windowIterator.next();
			if (!windowName.equals(hrPageWindowHandle)) {
				driver.switchTo().window(windowName);
				System.out.println(windowName);
				checkForPageLoad(driver);
				driver.manage().window().maximize();

				waitForElementToBeClickable(driver, searchCriteria);
				Select dropdown = new Select(searchCriteria);
				dropdown.selectByVisibleText("Name");
				waitForElementToBeClickable(driver, searchTextBox);
				searchTextBox.clear();
				searchTextBox.sendKeys(assignto);
				waitForAction(driver);
				searchTextBox.sendKeys(Keys.ENTER);
				checkForPageLoad(driver);
				if (nameSearchTextBox.isDisplayed()) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel(
									"Entering the value for Assign to field is same as logged in user - " + assignto,
									ExtentColor.GREEN));
					waitForElementToBeClickable(driver, nameSearchTextBox);
					nameSearchTextBox.clear();
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
		driver.switchTo().window(hrPageWindowHandle);
		waitForFrameToBeAvailable(driver, "gsft_main");
		String caseNumber = hrCaseNumber.getAttribute("value");
		test.get().log(Status.INFO, MarkupHelper.createLabel("Updating the HR Case", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		waitForElementToBeClickable(driver, updateButton);
		updateButton.click();
		waitForAction(driver);

		return caseNumber;
	}

	/**
	 * This Method validate the change about field
	 * 
	 * @param aboutName
	 * @throws Exception
	 */
	public void changeAbout(String aboutName) throws Exception {
		checkForPageLoad(driver);
		System.out.println("About to in Change About Method - " + aboutName);
		String hrPageWindowHandle = driver.getWindowHandle();
		waitForAction(driver);
		
		waitForElementToBeClickable(driver, aboutSearchBt);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, aboutSearchBt);
		aboutSearchBt.click();
		checkForPageLoad(driver);
		
		// Perform the click operation that opens new window
		if (isAlertPresent(driver)) {
			driver.switchTo().alert().accept();
			waitForElementToBeClickable(driver, aboutSearchBt);
			aboutSearchBt.click();
		}
		
		waitForExpectedNumberOfWindows(driver, 2);
		// Switch to new window opened
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> windowIterator = handles.iterator();
		// iterate through your windows
		while (windowIterator.hasNext()) {
			String windowName = windowIterator.next();
			if (!windowName.equals(hrPageWindowHandle)) {
				driver.switchTo().window(windowName);
				System.out.println("Window Name - " + windowName);
				checkForPageLoad(driver);
				driver.manage().window().maximize();
				driver.navigate().refresh();
				checkForPageLoad(driver);

				waitForElementToBeClickable(driver, searchCriteria);
				Select dropdown = new Select(searchCriteria);
				dropdown.selectByVisibleText("Name");
				waitForElementToBeClickable(driver, searchTextBox);
				searchTextBox.clear();
				searchTextBox.sendKeys(aboutName);
				waitForAction(driver);
				searchTextBox.sendKeys(Keys.ENTER);
				checkForPageLoad(driver);
				if (nameSearchTextBox.isDisplayed()) {
					test.get().log(Status.INFO, MarkupHelper
							.createLabel("Entering the value for About to field - " + aboutName, ExtentColor.CYAN));
					waitForElementToBeClickable(driver, nameSearchTextBox);
					// nameSearchTextBox.clear();
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
		// driver.switchTo().defaultContent();
		// driver.switchTo().frame(0);
		checkForPageLoad(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, caseAbout);
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

		if (!businessTitle.getAttribute("value").isEmpty()) {
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

		if (!casePayGroup.getAttribute("value").isEmpty()) {
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

		if (!caseUnionOccCode.getAttribute("value").isEmpty()) {
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

		if (!caseEmploymentType.getAttribute("value").isEmpty()) {
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
	}

	// saving the case details
	public void saveResults() throws Exception {
		checkForPageLoad(driver);
		Select selectstate = new Select(caseState);
		selectstate.selectByVisibleText("Resolved");
		test.get().log(Status.PASS,
				MarkupHelper.createLabel("Successfully selecting state dropdown == Resolved", ExtentColor.GREEN));
		// WebDriverWait wait = new WebDriverWait(driver, 20);
		// wait.until(ExpectedConditions.visibilityOf(caseWorknotes));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		scrollToElement(driver, caseWorknotes);
		/* caseWorknotes.sendKeys("case resolved"); */
		caseWorknotes.clear();
		waitForAction(driver);
		Actions actions = new Actions(driver);
		waitForElementToBeClickable(driver, caseWorknotes);
		actions.sendKeys(caseWorknotes, "Case Resolved").build().perform();
		js.executeScript("arguments[0].textContent='" + "Case Resolved" + "';", caseWorknotes);
		System.out.println("Worknotes Entered as - " + "Case Resolved");
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		// postBt.click();
		/*
		 * Actions action = new Actions(driver); action.contextClick(header).perform();
		 * screenshotPath = getScreenshot(driver, this.getClass().getName());
		 * test.get().info("Details",
		 * MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		 * action.click(saveOption).perform(); // saveOption.click();
		 * test.get().log(Status.INFO,
		 * MarkupHelper.createLabel("Updating The Hr case and Click save button",
		 * ExtentColor.CYAN));
		 */
		test.get().log(Status.INFO, MarkupHelper.createLabel("Updating the HR Case", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		waitForElementToBeClickable(driver, updateButton);
		updateButton.click();
		waitForAction(driver);
	}

	public void navigateToCase(String hrCaseNumber) throws Exception {
		driver.switchTo().defaultContent();
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.sendKeys("HR CASES");
		waitForAction(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		waitForElementToBeClickable(driver, allHRCases);
		js.executeScript("arguments[0].click();", allHRCases);
		checkForPageLoad(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, searchHRCase);
		Select select = new Select(searchHRCase);
		select.selectByVisibleText("Number");
		waitForElementToBeClickable(driver, searchTextBox);
		searchTextBox.clear();
		waitForAction(driver);
		searchTextBox.sendKeys(hrCaseNumber);
		waitForAction(driver);
		searchTextBox.sendKeys(Keys.ENTER);
		checkForPageLoad(driver);

		try {
			WebElement element = driver.findElement(By.xpath("//a[contains(text(), '" + hrCaseNumber + "')]"));
			element.click();
		} catch (Exception e) {
			try {
				Actions actions = new Actions(driver);
				searchTextBox.clear();
				waitForAction(driver);
				actions.sendKeys(searchTextBox, hrCaseNumber).build().perform();
				waitForAction(driver);
				actions.sendKeys(searchTextBox, Keys.ENTER).build().perform();
				checkForPageLoad(driver);

				WebElement element = driver.findElement(By.xpath("//a[contains(text(), '" + hrCaseNumber + "')]"));
				element.click();
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("Not able to click HR Case Number");
			}
		}

	}
}