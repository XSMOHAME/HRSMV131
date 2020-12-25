package com.snow.pageobjects;

import java.io.IOException;
import java.util.Iterator;
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

public class HRCaseManagementChangeRequestedBy extends ReusableLibrary {
	public WebDriver driver;

	public HRCaseManagementChangeRequestedBy(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// -------------After creating case-------------------------
	@FindBy(xpath = "//input[@id='filter']")
	public WebElement leftSearch;

	@FindBy(xpath = "//*[@id = '3f0370019f22120047a2d126c42e7076']")
	public WebElement openHrCase;

	@FindBy(xpath = "//*[contains(@id, 'sys_readonly.') and contains(@id, '.number')]")
	public WebElement caseNumber;

	@FindBy(xpath = "//*[contains(@id, 'sys_display.sn_hr_core') and contains(@id, 'opened_for')]")
	public WebElement requestedBy;

	@FindBy(xpath = "//input[contains(@id, 'sn_hr_core') and contains(@id, 'hr_profile.work_phone') and @readonly]")
	public WebElement workphone;

	@FindBy(xpath = "//input[contains(@id, 'sn_hr_core') and contains(@id, 'opened_for.email') and @readonly]")
	public WebElement caseEmail;

	@FindBy(xpath = "//select[contains(@id, 'sn_hr_core') and contains(@id, 'u_preferred_method_of_contact')]")
	public WebElement caseMethodOfContact;

	@FindBy(xpath = "//input[contains(@id, 'sn_hr_core') and contains(@id, 'u_details') and @type = 'text']")
	public WebElement casePhoneOrEmail;

	@FindBy(xpath = "//*[contains(@id, 'sys_readonly.sn_hr_core') and contains(@id, 'hr_profile.u_home_postal_code')]")
	public WebElement casePostalCode;

	@FindBy(xpath = "//*[contains(@id, 'sys_readonly.sn_hr_core') and contains(@id, 'hr_profile.ssn') and not(contains(@id, 'subject'))]")
	public WebElement casePinNumber;

	@FindBy(xpath = "//select[contains(@id, 'sn_hr_core') and contains(@id, 'state')]")
	public WebElement caseState;

	@FindBy(xpath = "//select[contains(@id, 'sn_hr_core') and contains(@id, 'priority')]")
	public WebElement casePriority;

	@FindBy(xpath = "//select[contains(@id, 'sn_hr_core') and contains(@id, 'contact_type')]")
	public WebElement caseSource;

	@FindBy(xpath = "//*[contains(@id, 'sys_readonly.sn_hr_core') and contains(@id, 'opened_at')]")
	public WebElement caseOpened;

	@FindBy(xpath = "//*[contains(@id, 'sn_hr_core') and contains(@id, 'opened_by_label')]")
	public WebElement caseOpenedBy;

	@FindBy(xpath = "//*[contains(@id, 'sys_display.sn_hr_core') and contains(@id, 'hr_service')]")
	public WebElement caseHrService;

	@FindBy(xpath = "//*[contains(@id, 'sys_display.sn_hr_core') and contains(@id, 'assignment_group')]")
	public WebElement caseAssignmentGroup;

	@FindBy(xpath = "//*[contains(@id, 'lookup.sn_hr_core') and contains(@id, 'assigned_to')]")
	public WebElement caseAssignedToSearch;

	@FindBy(xpath = "//select[contains(@id,'_select')]")
	public WebElement searchCriteria;

	@FindBy(xpath = "//select[contains(@id,'_select') and @class= 'form-control default-focus-outline']")
	public WebElement searchCriteriaDropdown;

	@FindBy(xpath = "//input[contains(@id,'_text')]")
	public WebElement searchTextBox;

	@FindBy(xpath = "(//input[contains(@aria-label,'number')])[1]")
	public WebElement searchNumber;

	@FindBy(xpath = "(//*[@id='sys_user_table_header_search_control'])[1]")
	public WebElement nameSearchTextBox;

	@FindBy(xpath = "//*[@id='user_info_dropdown']/div/span[1]")
	public WebElement loggedUser;

	@FindBy(xpath = "//*[contains(@id, 'sys_display.sn_hr_core') and contains(@id, 'assigned_to')]")
	public WebElement assignToText;

	@FindBy(xpath = "//*[contains(@id, 'sys_display.sn_hr_core') and contains(@id, 'subject_person')]")
	public WebElement caseAbout;

	@FindBy(xpath = "//input[contains(@id, 'sn_hr_core') and contains(@id, 'subject_person.employee_number') and @readonly]")
	public WebElement employeeNum;

	@FindBy(xpath = "//input[contains(@id, 'sn_hr_core') and contains(@id, 'subject_person_hr_profile.u_business_title') and @readonly]")
	public WebElement businessTitle;

	@FindBy(xpath = "//input[contains(@id, 'sn_hr_core') and contains(@id, 'subject_person_hr_profile.u_company_code_label') and @readonly]")
	public WebElement caseCompanyName;

	@FindBy(xpath = "//*[contains(@id, 'sys_readonly.sn_hr_core') and contains(@id, 'subject_person_hr_profile.u_pay_group') and @readonly]")
	public WebElement casePayGroup;

	@FindBy(xpath = "//*[contains(@id, 'sys_readonly.sn_hr_core') and contains(@id, 'subject_person_hr_profile.u_union_code') and @readonly]")
	public WebElement caseUnionOccCode;

	@FindBy(xpath = "//*[contains(@id, 'sys_readonly.sn_hr_core') and contains(@id, 'subject_person_hr_profile.employment_type') and @readonly]")
	public WebElement caseEmploymentType;

	@FindBy(xpath = "//*[contains(@id, 'sn_hr_core') and contains(@id, 'subject_person_hr_profile.u_hr_representative_label') and @readonly]")
	public WebElement caseHrRepresentative;

	@FindBy(xpath = "//input[contains(@id, 'ni.sn_hr_core') and contains(@id, 'subject_person.active')]")
	public WebElement caseActiveCheckbox;

	@FindBy(xpath = "//input[contains(@id, 'ni.sn_hr_core') and contains(@id, 'subject_person_hr_profile.u_job_exempt')]")
	public WebElement caseJobExempt;

	@FindBy(xpath = "//*[contains(@id, 'lookup.sn_hr_core') and contains(@id, 'subject_person') and not(contains(@id, 'user'))]")
	public WebElement aboutSearchBt;

	@FindBy(xpath = "//*[contains(@id, 'lookup.') and contains(@id, '.opened_for')]")
	public WebElement requestedBySearchBt;

	@FindBy(xpath = "//input[contains(@id, 'u_open_for_guest_full_name') and @type = 'text']")
	public WebElement guestFullName;

	@FindBy(xpath = "//input[contains(@id, 'sn_hr_core') and contains(@id, 'u_open_for_guest_organization') and @type ='text']")
	public WebElement guestOrganization;

	@FindBy(xpath = "//input[contains(@id, 'sn_hr_core') and contains(@id, 'u_open_for_guest_contact') and @type = 'text']")
	public WebElement guestContact;

	@FindBy(xpath = "//*[contains(@id,'header') and contains(@class,'section_header_div_no_scroll form_title')]")
	public WebElement header;

	@FindBy(xpath = "//*[@role='menuitem' and @title = 'Save record and remain here']")
	public WebElement saveOption;

	@FindBy(xpath = "//textarea[@id='activity-stream-textarea']")
	public WebElement worknotes;

	@FindBy(xpath = "//textarea[@id='activity-stream-work_notes-textarea']")
	public WebElement caseWorknotes;

	@FindBy(xpath = "//button[@id = 'sysverb_update_bottom']")
	public WebElement updateButton;

	@FindBy(xpath = "//button[text()='Post']")
	public WebElement postBt;

	@FindBy(xpath = "//*[@id = 'show_hr_profile:sn_hr_core_hr_employee_services.opened_for']")
	public WebElement iIcon;

	String hrservice;
	String aboutName;

	// this method validates the fields after creating case

	public String[] validateCase() throws Exception {
		int count = 0;
		String[] caseDetails = new String[2];
		String caseNo = null;
		
		checkForPageLoad(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		
		waitForElement(driver, caseNumber);
		if (!caseNumber.getAttribute("value").isEmpty() && caseNumber.getAttribute("readonly").equals("true")) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Number Field is Populated with value==" + caseNumber.getAttribute("value"), ExtentColor.GREEN));
			System.out.println("Number Field is Auto Populated with value==" + caseNumber.getAttribute("value"));
			caseNo = caseNumber.getAttribute("value").trim();
			caseDetails[0] = caseNo;
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Number Field is Not Populated with value", ExtentColor.RED));
			System.out.println("Number Field is Not Auto Populated with value");
		}

		waitForElementToBeClickable(driver, requestedBy);
		if (!requestedBy.getAttribute("value").isEmpty() && requestedBy.isEnabled()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("RequestedBy Field  is Populated with value=="
					+ requestedBy.getAttribute("value") + " and Editable", ExtentColor.GREEN));
			System.out.println("RequestedBy Field  is Populated with value==" + requestedBy.getAttribute("value")
					+ " and Editable");
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("RequestedBy field is not populated or not Editable", ExtentColor.RED));
			System.out.println("RequestedBy field is not populated or not Editable");
		}

		waitForElementToBeClickable(driver, workphone);
		if (!workphone.getAttribute("value").isEmpty()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Work Phone  Field  is Populated with value=="
					+ workphone.getAttribute("value") + " and Not Editable", ExtentColor.GREEN));
			System.out.println("WorkPhone Field  is Populated with value==" + workphone.getAttribute("value")
					+ " and Not Editable");
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Work Phone field is not populated or Editable", ExtentColor.RED));
			System.out.println("Work phone field is not populated or Editable");
		}

		if (!caseEmail.getAttribute("value").isEmpty()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Email  Field  is Populated with value==" + caseEmail.getAttribute("value") + " and Not Editable",
					ExtentColor.GREEN));
			System.out.println(
					"Email Field  is Populated with value==" + caseEmail.getAttribute("value") + " and Not Editable");
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Email field is not populated or Editable", ExtentColor.RED));
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
			count++;
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Preferred method of contact  field is not displayed or not Editable", ExtentColor.RED));
			System.out.println("preferred method of contact field is not displayed or not Editable");
		}

		if (!casePhoneOrEmail.getAttribute("value").isEmpty() && casePhoneOrEmail.isEnabled()) {
			test.get()
					.log(Status.PASS,
							MarkupHelper.createLabel(
									"Phone or email Field  is Populated with value=="
											+ casePhoneOrEmail.getAttribute("value") + " and  Editable",
									ExtentColor.GREEN));
			System.out.println("Phone or Email Field  is Populated with value=="
					+ casePhoneOrEmail.getAttribute("value") + " and Editable");
		} else {
			count++;
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Phone or Email  field is not Populated or not Editable", ExtentColor.RED));
			System.out.println("Phone or Email field is not Populated or not Editable");
		}

		if (!casePostalCode.getAttribute("value").isEmpty()) {
			test.get()
					.log(Status.PASS,
							MarkupHelper.createLabel(
									"Home Postal code Field  is Populated with value=="
											+ casePostalCode.getAttribute("value") + " and Not  Editable",
									ExtentColor.GREEN));
			System.out.println("Home Postal Code Field  is Populated with value=="
					+ casePostalCode.getAttribute("value") + " and Not Editable");
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Home Postal code field is not Populated or Editable", ExtentColor.RED));
			System.out.println("Home Postal code field is not Populated or  Editable");
		}

		if (!casePinNumber.getAttribute("value").isEmpty()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Pin Number Field  is Populated with value=="
					+ casePinNumber.getAttribute("value") + " and Not  Editable", ExtentColor.GREEN));
			System.out.println("Pin Number Field  is Populated with value==" + casePinNumber.getAttribute("value")
					+ " and Not Editable");
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Pin Number field is not Populated or Editable", ExtentColor.RED));
			System.out.println("Pin Number field is not Populated or  Editable");
		}

		if (caseState.isDisplayed()) {
			Select selectState = new Select(caseState);
			String actualState = selectState.getFirstSelectedOption().getText();
			if (actualState.equals("Open")) {
				test.get().log(Status.PASS, MarkupHelper.createLabel(
						"State Field  is Populated with Expected value==" + actualState, ExtentColor.GREEN));
				logSuccess("Expected Values - " + caseAbout.getAttribute("Open"));
				logSuccess("Actual Value - " + actualState);
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("State  Field  is Populated with Expected value==" + actualState);
			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("State Field  is Not Populated with Expected value", ExtentColor.RED));
				logFailure("Expected Values - " + caseAbout.getAttribute("Open"));
				logFailure("Actual Value - " + actualState);
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("Pin Number Field  is Populated with Expected value");
			}
		} else {
			count++;
			test.get().log(Status.FAIL, MarkupHelper.createLabel("State Field  is Not Displayed", ExtentColor.RED));
			System.out.println("Pin Number Field  is Not Displayed");
		}

		if (casePriority.isDisplayed()) {
			Select selectPriority = new Select(casePriority);
			String actualPriority = selectPriority.getFirstSelectedOption().getText();
			if (actualPriority.equals("2 - Moderate")) {
				test.get().log(Status.PASS, MarkupHelper.createLabel(
						"Priority Field  is Populated with Expected value==" + actualPriority, ExtentColor.GREEN));
				logSuccess("Expected Values - " + caseAbout.getAttribute("2 - Moderate"));
				logSuccess("Actual Value - " + actualPriority);
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("Priority Field  is Populated with value==" + actualPriority);
			} else {
				test.get().log(Status.FAIL, MarkupHelper
						.createLabel("Priority Field  is Not Populated with Expected value", ExtentColor.RED));
				logFailure("Expected Values - " + caseAbout.getAttribute("2 - Moderate"));
				logFailure("Actual Value - " + actualPriority);
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("Priority Field  is Not Populated with Expected value");
			}
		} else {
			count++;
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Priority Field  is Not Displayed", ExtentColor.RED));
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
			count++;
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Source Field  is Not displayed", ExtentColor.RED));
		}

		if (count == 0) {
			logInfoScreenshot(driver);
		} else {
			logFailureScreenshot(driver);
			count = 0;
		}

		if (!caseOpened.getAttribute("value").isEmpty()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Opened Field  is Populated with value==" + caseOpened.getAttribute("value") + " and Not  Editable",
					ExtentColor.GREEN));
			System.out.println(
					"Opened Field  is Populated with value==" + caseOpened.getAttribute("value") + " and Not Editable");
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Opened field is not Populated or Editable", ExtentColor.RED));
			System.out.println("Opened field is not Populated or  Editable");
		}

		if (!caseOpenedBy.getAttribute("value").isEmpty() && caseOpenedBy.getAttribute("readonly").equals("true")) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Opened By Field  is Populated with value=="
					+ caseOpenedBy.getAttribute("value") + " and Not  Editable", ExtentColor.GREEN));
			System.out.println("Opened By Field  is Populated with value==" + caseOpenedBy.getAttribute("value")
					+ " and Not Editable");
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Opened By field is not Populated or Editable", ExtentColor.RED));
			System.out.println("Opened By field is not Populated or  Editable");
		}

		if (!caseHrService.getAttribute("value").isEmpty() && caseHrService.getAttribute("readonly").equals("true")) {
			hrservice = caseHrService.getAttribute("value");
			test.get().log(Status.PASS, MarkupHelper.createLabel("Hr Service Field  is Populated with value=="
					+ caseHrService.getAttribute("value") + " and Not  Editable", ExtentColor.GREEN));
			System.out.println("Hr Service Field  is Populated with value==" + caseHrService.getAttribute("value")
					+ " and Not Editable");
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("HR Service field is not Populated or Editable", ExtentColor.RED));
			System.out.println("HR Service field is not Populated or  Editable");
		}

		if (!caseAssignmentGroup.getAttribute("value").isEmpty() && caseAssignmentGroup.isEnabled()) {
			test.get()
					.log(Status.PASS,
							MarkupHelper.createLabel(
									"Assignment Group Field  is Populated with value=="
											+ caseAssignmentGroup.getAttribute("value") + " and Editable",
									ExtentColor.GREEN));
			System.out.println("Assignment GroupField  is Populated with value=="
					+ caseAssignmentGroup.getAttribute("value") + " and Editable");
		} else {
			count++;
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Assignment Group field is not Populated or Not Editable", ExtentColor.RED));
			System.out.println("Assignment Group field is not Populated or Not Editable");
		}
		scrollToElement(driver, caseAssignmentGroup);

		if (count == 0) {
			logInfoScreenshot(driver);
		} else {
			logFailureScreenshot(driver);
			count = 0;
		}

		driver.switchTo().defaultContent();
		String userLogged = loggedUser.getText();
		waitForFrameToBeAvailable(driver, "gsft_main");
		String hrPageWindowHandle = driver.getWindowHandle();

		// Perform the click operation that opens new window
		waitForElement(driver, caseAssignedToSearch);
		scrollToElement(driver, caseAssignedToSearch);
		if (waitForElementToBeClickable(driver, caseAssignedToSearch)) {			
			clickUsingJavaScript(driver, caseAssignedToSearch);
			checkForPageLoad(driver);
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Assign To field is not displayed", ExtentColor.RED));
			logFailureScreenshot(driver);
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
				driver.manage().window().maximize();
				waitForElementToBeClickable(driver, searchCriteria);
				Select dropdown = new Select(searchCriteria);
				dropdown.selectByVisibleText("Name");
				waitForElementToBeClickable(driver, searchTextBox);
				searchTextBox.clear();
				searchTextBox.sendKeys(userLogged);
				waitForAction(driver);
				searchTextBox.sendKeys(Keys.ENTER);
				waitForAction(driver);
				waitForElement(driver, nameSearchTextBox);
				if (isElementPresent(nameSearchTextBox)) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel(
									"Entering the value for Assign to field is same as logged in user - " + userLogged,
									ExtentColor.GREEN));
					waitForElementToBeClickable(driver, nameSearchTextBox);
					nameSearchTextBox.sendKeys(userLogged);
					waitForAction(driver);
					nameSearchTextBox.sendKeys(Keys.ENTER);
					waitForAction(driver);
					WebElement element = driver.findElement(By.xpath(
							"//*[contains(@class, 'glide_ref_item_link') and contains(@role, 'button') and contains(text(), '"
									+ userLogged + "')]"));
					System.out.println("Logged in User - " + element.getText());
					waitForElementToBeClickable(driver, element);
					element.click();
				}
			}
		}

		driver.switchTo().window(hrPageWindowHandle);
		waitForFrameToBeAvailable(driver, "gsft_main");
		scrollPageToElement(driver, caseAbout);
		checkForPageLoad(driver);
		waitForElement(driver, caseAbout);

		if (!caseAbout.getAttribute("value").isEmpty() && caseAbout.isEnabled()) {
			aboutName = caseAbout.getAttribute("value");
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"About Field  is Populated with value==" + caseAbout.getAttribute("value") + " and Editable",
					ExtentColor.GREEN));
			System.out.println(
					"About Field  is Populated with value==" + caseAbout.getAttribute("value") + " and Editable");
			caseDetails[1] = aboutName;
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("About field is not Populated or Not Editable", ExtentColor.RED));
			System.out.println("About field is not Populated or Not Editable");
		}

		if (!employeeNum.getAttribute("value").isEmpty() && employeeNum.getAttribute("readonly").equals("true")) {
			test.get()
					.log(Status.PASS,
							MarkupHelper.createLabel(
									"Employee Number Field  is Populated with value=="
											+ employeeNum.getAttribute("value") + " and Not Editable",
									ExtentColor.GREEN));
			System.out.println("Employee Number Field is Populated with value==" + employeeNum.getAttribute("value")
					+ " and Not Editable");
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Employee Number field is not Populated or Editable", ExtentColor.RED));
			System.out.println("Employee Number field is not Populated or Editable");
		}

		if (!businessTitle.getAttribute("value").isEmpty() && businessTitle.getAttribute("readonly").equals("true")) {
			test.get()
					.log(Status.PASS,
							MarkupHelper.createLabel(
									"Business Title Field  is Populated with value=="
											+ businessTitle.getAttribute("value") + " and Not Editable",
									ExtentColor.GREEN));
			System.out.println("Business Title Field is Populated with value==" + businessTitle.getAttribute("value")
					+ " and Not Editable");
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Business Title field is not Populated or Editable", ExtentColor.RED));
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
			System.out.println("Company Name Field is Populated with value==" + caseCompanyName.getAttribute("value")
					+ " and Not Editable");
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Company name field is not Populated or Editable", ExtentColor.RED));
			System.out.println("Company name field is not Populated or Editable");
		}

		if (!casePayGroup.getAttribute("value").isEmpty() && casePayGroup.getAttribute("readonly").equals("true")) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Pay Group Field is Populated with value=="
					+ casePayGroup.getAttribute("value") + " and Not Editable", ExtentColor.GREEN));
			System.out.println("Pay Group Field is Populated with value==" + casePayGroup.getAttribute("value")
					+ " and Not Editable");
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Pay Group field is not Populated or Editable", ExtentColor.RED));
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
			System.out.println("Union Occ Code Field is Populated with value==" + caseUnionOccCode.getAttribute("value")
					+ " and Not Editable");
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Union Occ Code field is not Populated or Editable", ExtentColor.RED));
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
			System.out.println("Employment Type Field is Populated with value=="
					+ caseEmploymentType.getAttribute("value") + " and Not Editable");
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Employment Type field is not Populated or Editable", ExtentColor.RED));
			System.out.println("Employment Type field is not Populated or Editable");
		}

		if (!caseHrRepresentative.getAttribute("value").isEmpty()
				&& caseHrRepresentative.getAttribute("readonly").equals("true")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"HR Representative Field is Populated with value=="
									+ caseHrRepresentative.getAttribute("value") + " and Not Editable",
							ExtentColor.GREEN));
			System.out.println("HR Representative Field is Populated with value=="
					+ caseHrRepresentative.getAttribute("value") + " and Not Editable");
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("HR Representative field is not Populated or Editable", ExtentColor.RED));
			System.out.println("HR Representative field is not Populated or Editable");
		}

		if (caseActiveCheckbox.isSelected() && caseActiveCheckbox.getAttribute("aria-readonly").equals("true")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Active CheckBox is selected and Not Editable", ExtentColor.GREEN));
			System.out.println("Active Checkbox is selected and Not Editable");
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Active CheckBox is Not selected or Editable", ExtentColor.GREEN));
			System.out.println("Active Checkbox is Not selected and or Editable");
		}

		if (caseJobExempt.isSelected() && caseJobExempt.getAttribute("aria-readonly").equals("true")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("JobExempt CheckBox is selected and Not Editable", ExtentColor.GREEN));
			System.out.println("Job Exempt Checkbox is selected and Not Editable");
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("job Exempt CheckBox is Not selected or Editable", ExtentColor.RED));
			System.out.println("job Exempt Checkbox is Not selected and or Editable");
		}
		if (count == 0) {
			logInfoScreenshot(driver);
		} else {
			logFailureScreenshot(driver);
		}
		waitForElementToBeClickable(driver, updateButton);
		updateButton.click();
		waitForAction(driver);
		driver.navigate().back();
		waitForAction(driver);
		return caseDetails;
	}

	public void navigateToHRCase(String caseNo) {
		/*
		 * driver.get(homePageURL); checkForPageLoad(driver);
		 */
		driver.switchTo().defaultContent();
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.clear();
		waitForAction(driver);
		leftSearch.sendKeys("HR CASES");
		waitForAction(driver);
		waitForElementToBeClickable(driver, openHrCase);
		checkForPageLoad(driver);
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", openHrCase);
			checkForPageLoad(driver);
			// new Actions(driver).click(openHrCase).build().perform();
		} catch (Exception e) {
			openHrCase.click();
			checkForPageLoad(driver);
		}

		checkForPageLoad(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, searchCriteriaDropdown);
		Select select = new Select(searchCriteriaDropdown);
		select.selectByVisibleText("Number");
		waitForElementToBeClickable(driver, searchTextBox);
		/*
		 * executor.executeScript("arguments[1].value = arguments[0]; ", caseNo,
		 * searchTextBox); waitForAction(driver);
		 * executor.executeScript("arguments[0].textContent='" + Keys.ENTER + "';",
		 * searchTextBox);
		 */
		searchTextBox.sendKeys(caseNo);
		waitForAction(driver);
		searchTextBox.sendKeys(Keys.ENTER);

		waitForElementToBeClickable(driver, searchNumber);
		// searchNumber.clear();
		/*
		 * executor.executeScript("arguments[1].value = arguments[0]; ", caseNo,
		 * searchNumber); waitForAction(driver);
		 * executor.executeScript("arguments[0].textContent='" + Keys.ENTER + "';",
		 * searchNumber);
		 */
//		searchNumber.sendKeys(caseNo);
		waitForAction(driver);
		// searchNumber.sendKeys(Keys.ENTER);

		waitForAction(driver);
		WebElement caseNumber = driver
				.findElement(By.xpath("//a[@class = 'linked formlink' and text() = '" + caseNo + "']"));
		caseNumber.click();
		waitForAction(driver);
	}

	// this method validates the RequestedBy field
	public void changeRequestedBy(String requester, String guestName, String org, String contact)
			throws InterruptedException, IOException {
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, caseNumber);
		scrollPageToElement(driver, caseNumber);

		String hrPageWindowHandle = driver.getWindowHandle();
		// Perform the click operation that opens new window
		if (isElementPresent(requestedBySearchBt)) {
			new Actions(driver).click(requestedBySearchBt).build().perform();
			checkForPageLoad(driver);
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("RequestedBy search field is not displayed", ExtentColor.RED));
		}

		// Switch to new window opened
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> windowIterator = handles.iterator();
		// iterate through your windows
		while (windowIterator.hasNext()) {
			String windowName = windowIterator.next();
			if (!windowName.equals(hrPageWindowHandle)) {
				System.out.println(windowName);
				driver.switchTo().window(windowName);
				System.out.println(windowName);
				driver.manage().window().maximize();
				waitForAction(driver);

				waitForElementToBeClickable(driver, searchCriteria);
				Select dropdown = new Select(searchCriteria);
				dropdown.selectByVisibleText("Name");
				waitForElementToBeClickable(driver, searchTextBox);
				searchTextBox.click();
				waitForAction(driver);
				searchTextBox.sendKeys(requester);
				searchTextBox.sendKeys(Keys.ENTER);
				waitForAction(driver);
				waitForElement(driver, nameSearchTextBox);

				if (nameSearchTextBox.isDisplayed()) {
					test.get().log(Status.PASS, MarkupHelper
							.createLabel("Entering the Requested By field Values - " + requester, ExtentColor.GREEN));
					waitForElementToBeClickable(driver, nameSearchTextBox);
					nameSearchTextBox.click();
					waitForAction(driver);
					nameSearchTextBox.sendKeys(requester);
					waitForAction(driver);
					nameSearchTextBox.sendKeys(Keys.ENTER);
					waitForAction(driver);
					WebElement searchResult = driver.findElement(By.xpath(
							"//*[contains(@class, 'glide_ref_item_link') and contains(@role, 'button') and contains(text(), '"
									+ requester + "')]"));
					waitForElementToBeClickable(driver, searchResult);
					checkForPageLoad(driver);
					searchResult.click();
				}
			}
		}

		waitForExpectedNumberOfWindows(driver, 1);
		driver.switchTo().window(hrPageWindowHandle);
		waitForFrameToBeAvailable(driver, "gsft_main");
		/*
		 * waitForElementToBeClickable(driver, iIcon); iIcon.click();
		 */
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		waitForElement(driver, guestFullName);
		if (isElementPresent(guestFullName)) {
			System.out.println("Attribute - " + guestFullName.getAttribute("id"));
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Guest Request full name field is displayed", ExtentColor.GREEN));
			waitForElementToBeClickable(driver, guestFullName);
			checkForPageLoad(driver);
			// guestFullName.sendKeys(guestName);
			executor.executeScript("arguments[1].value = arguments[0]; ", guestName, guestFullName);
			waitForAction(driver);
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Successfully pass the Guest full name", ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Guest Request full name field is Not displayed", ExtentColor.RED));
			logFailureScreenshot(driver);
		}

		waitForElement(driver, guestOrganization);
		if (guestOrganization.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Guest Organization Field is dispalyed", ExtentColor.GREEN));
			System.out.println("Attribute - " + guestOrganization.getAttribute("id"));
			executor.executeScript("arguments[1].value = arguments[0]; ", org, guestOrganization);
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Successdully pass the Guest Organization==" + org, ExtentColor.CYAN));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Guest Organiztion Field is Not displayed", ExtentColor.RED));
			logFailureScreenshot(driver);
		}
		waitForElement(driver, guestContact);
		if (guestContact.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Guest Contact Field is dispalyed", ExtentColor.GREEN));
			System.out.println("Attribute - " + guestContact.getAttribute("id"));
			executor.executeScript("arguments[1].value = arguments[0]; ", contact, guestContact);
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Successdully pass the Guest Contact==" + contact, ExtentColor.CYAN));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Guest Contact Field is Not displayed", ExtentColor.RED));
			logFailureScreenshot(driver);
		}

		scrollToElement(driver, updateButton);
		waitForElementToBeClickable(driver, updateButton);
		executor.executeScript("arguments[0].click();", updateButton);
		checkForPageLoad(driver);

		if (isElementPresent(updateButton)) {
			scrollToElement(driver, updateButton);
			waitForElementToBeClickable(driver, updateButton);
			updateButton.click();
			checkForPageLoad(driver);
			if (isElementPresent(updateButton)) {
				scrollToElement(driver, updateButton);
				waitForAction(driver);
				new Actions(driver).click(updateButton).build().perform();
			}
		}
	}

	// this method validate the about field after changing
	public void changeAbout(String about) throws Exception {
		waitForAction(driver);
		waitForElement(driver, caseAbout);
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		waitForElement(driver, aboutSearchBt);
		String hrPageWindowHandle = driver.getWindowHandle();
		// Perform the click operation that opens new window
		if (aboutSearchBt.isDisplayed()) {
			aboutSearchBt.click();
			waitForAction(driver);
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
				driver.switchTo().defaultContent();
				waitForElementToBeClickable(driver, searchCriteria);
				Select dropdown = new Select(searchCriteria);
				dropdown.selectByVisibleText("Name");
				waitForElementToBeClickable(driver, searchTextBox);
				searchTextBox.clear();
				searchTextBox.sendKeys(about);
				waitForAction(driver);
				searchTextBox.sendKeys(Keys.ENTER);
				checkForPageLoad(driver);

				waitForElementToBeClickable(driver, nameSearchTextBox);
				if (nameSearchTextBox.isDisplayed()) {
					nameSearchTextBox.clear();
					waitForAction(driver);
					nameSearchTextBox.sendKeys(about);
					waitForAction(driver);
					nameSearchTextBox.sendKeys(Keys.ENTER);
					waitForAction(driver);
					test.get().log(Status.INFO, MarkupHelper
							.createLabel("Entering the value for About to field - " + about, ExtentColor.CYAN));
					test.get().log(Status.PASS,
							MarkupHelper.createLabel("Successfully change the About Name- " + about, ExtentColor.CYAN));
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					WebElement searchResult = driver.findElement(By.xpath(
							"//*[contains(@class, 'glide_ref_item_link') and contains(@role, 'button') and contains(text(), '"
									+ about.split(" ")[0] + "')]"));
					searchResult.click();
				}
			}
		}
		waitForExpectedNumberOfWindows(driver, 1);
		driver.switchTo().window(hrPageWindowHandle);
		waitForFrameToBeAvailable(driver, "gsft_main");
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

		waitForElementToBeClickable(driver, caseState);
		Select selectstate = new Select(caseState);
		selectstate.selectByVisibleText("Resolved");
		test.get().log(Status.PASS,
				MarkupHelper.createLabel("Successfully selecting state dropdown == Resolved", ExtentColor.GREEN));
		executor.executeScript("arguments[0].scrollIntoView();", caseWorknotes);
		checkForPageLoad(driver);
		executor.executeScript("arguments[1].value = arguments[0]; ", "Marking Case as Resolved JS2", caseWorknotes);
		waitForAction(driver);
		executor.executeScript("arguments[0].textContent='" + "Marking Case as Resolved" + "';", caseWorknotes);
		waitForAction(driver);
		caseWorknotes.sendKeys("Marking Case as Resolved");
		/*
		 * waitForAction(driver); waitForElementToBeClickable(driver, caseWorknotes);
		 * new Actions(driver).sendKeys(caseWorknotes,
		 * "Marking Case as Resolved").build().perform();
		 */
		checkForPageLoad(driver);
		// postBt.click();

		waitForFrameToBeAvailable(driver, "gsft_main");
		test.get().log(Status.INFO, MarkupHelper.createLabel("Updating the HR Case", ExtentColor.CYAN));
		logInfoScreenshot(driver);
		checkForPageLoad(driver);

		scrollToElement(driver, updateButton);
		waitForElementToBeClickable(driver, updateButton);
		executor.executeScript("arguments[0].click();", updateButton);
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
}