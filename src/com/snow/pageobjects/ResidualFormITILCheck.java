package com.snow.pageobjects;

import java.awt.AWTException;
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

public class ResidualFormITILCheck extends ReusableLibrary {
	public WebDriver driver;

	public ResidualFormITILCheck(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "filter")
	public WebElement navigationfilter;

	@FindBy(xpath = "//div[contains(text(),'Workforce Administration')]")
	public WebElement workforceAdministration;

	@FindBy(xpath = "//*[@class = 'form-control' and contains(@placeholder, 'Search')]")
	public WebElement searchHRCase;

	@FindBy(xpath = "//select[@class='form-control default-focus-outline']")
	public WebElement searchDropDown;

	@FindBy(xpath = "//*[contains(@class, 'modified') and contains(@placeholder, 'Search')]")
	public WebElement searchHRCaseNumber;

	@FindBy(xpath = "//a[@class='linked formlink']")
	public WebElement hr_link_number;

	@FindBy(xpath = "//tr[contains(@record_class,'sn_hr_core_case_workforce_admin')]")
	public WebElement hrRow;

	@FindBy(id = "sys_display.sn_hr_core_case_workforce_admin.subject_person")
	public WebElement about;

	@FindBy(id = "sys_display.sn_hr_core_case_payroll.subject_person")
	public WebElement aboutPayee;

	@FindBy(xpath = "//*[contains(@id, 'show_hr_profile') and contains(@id, 'subject_person')]")
	public WebElement aboutIcon;

	@FindBy(xpath = "//*[contains(@id, 'u_preferred_full_name') and @readonly]")
	public WebElement preferedFullName;

	@FindBy(xpath = "//*[@id='sn_hr_core_case_workforce_admin.u_fein']")
	public WebElement updatedSSNorFEIN;

	@FindBy(xpath = "//*[@id = 'sn_hr_core_case_workforce_admin.u_beneficiary_s_ssn']")
	public WebElement beneficiarySSN;

	@FindBy(id = "sys_display.sn_hr_core_case_workforce_admin.hr_service")
	public WebElement hrService;

	@FindBy(id = "sys_display.sn_hr_core_case_payroll.hr_service")
	public WebElement hrServicePayee;

	@FindBy(id = "sys_display.sn_hr_core_case_workforce_admin.assignment_group")
	public WebElement assignmentGroup;

	@FindBy(id = "sys_display.sn_hr_core_case_payroll.assignment_group")
	public WebElement assignmentGroupPayee;

	@FindBy(id = "sys_readonly.sn_hr_core_case_payroll.subject_person.employee_number")
	public WebElement employeeNumber;

	@FindBy(id = "sn_hr_core_case_payroll.u_request_type")
	public WebElement requestTypeITIL;

	@FindBy(id = "sn_hr_core_case_payroll.u_sap_company_code")
	public WebElement sapCompanyCodeITIL;

	@FindBy(id = "sn_hr_core_case_payroll.u_check_no")
	public WebElement checkNoITIL;

	@FindBy(id = "sn_hr_core_case_payroll.u_check_date_1")
	public WebElement checkDateITIL;

	@FindBy(id = "sn_hr_core_case_payroll.u_net_amount")
	public WebElement netAmountITIL;

	@FindBy(xpath = "//*[contains(@id, 'sys_readonly.sn_hr_core_case') and contains(@id, 'number')]")
	public WebElement caseNumber;

	@FindBy(id = "sn_hr_core_case_workforce_admin.priority")
	public WebElement priority;

	@FindBy(id = "sn_hr_core_case_payroll.priority")
	public WebElement priorityPayee;

	@FindBy(xpath = "//*[contains(@id, 'lookup.sn_hr_core_case') and contains(@id,'assigned_to')]")
	public WebElement assignedTo;

	@FindBy(xpath = "//select[contains(@id,'_select')]")
	public WebElement searchCriteria;

	@FindBy(xpath = "//input[contains(@id,'_text')]")
	public WebElement searchTextBox;

	@FindBy(xpath = "(//*[@id='sys_user_table_header_search_control'])[1]")
	public WebElement nameSearchTextBox;

	@FindBy(xpath = "//select[contains(@id,'sn_hr_core') and contains(@id,'state')]")
	public WebElement state;

	@FindBy(xpath = "//*[@id='sn_hr_core_case_payroll.state']")
	public WebElement statePayee;

	@FindBy(xpath = "//*[@id='activity-stream-work_notes-textarea']")
	public WebElement workNotes;

	@FindBy(xpath = "//*[@id='fieldmsg-singleinput-7']/li")
	public WebElement workNotesError;

	@FindBy(xpath = "//*[contains(@id,'header') and contains(@class,'section_header_div_no_scroll form_title')]")
	public WebElement header;

	@FindBy(id = "sysverb_update_bottom")
	public WebElement updateButton;

	@FindBy(xpath = "//*[@role='menuitem' and @title = 'Save record and remain here']")
	public WebElement saveOption;

	public void navigateToSearchHRCase(String navigationFilter) throws IOException, InterruptedException {
		PageFactory.initElements(driver, ResidualFormITILCheck.class);
		navigationfilter.sendKeys(navigationFilter);
		checkForPageLoad(driver);
		WebElement navFilter = driver.findElement(By.xpath("//div[contains(text(),'" + navigationFilter + "')]"));
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		execute.executeScript("arguments[0].click();", navFilter);

		waitForFrameToBeAvailable(driver, "gsft_main");

		WebElement searchHeader = driver.findElement(By.xpath(
				"//*[contains(@class, 'navbar-title list_title') and contains(text(),'" + navigationFilter + "')]"));
		waitForElement(driver, searchHeader);

		if (searchHeader.isDisplayed()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Navigation to HR Case Search page is successful", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Navigation to HR Case Search page Failed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	public void navigateToSearchAllHRCase(String navigationFilter) throws IOException, InterruptedException {
		PageFactory.initElements(driver, ResidualFormITILCheck.class);
		navigationfilter.sendKeys(navigationFilter);
		checkForPageLoad(driver);
		WebElement allHrCases = driver.findElement(By.xpath(
				"//*[contains(@aria-label, 'Submodules for Module: All HR Cases')]/li/div/a/div/div[contains(text(), 'All')]"));
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		execute.executeScript("arguments[0].click();", allHrCases);

		waitForFrameToBeAvailable(driver, "gsft_main");

		WebElement searchHeader = driver.findElement(By.xpath(
				"//*[contains(@class, 'navbar-title list_title ') and contains(text(),'" + navigationFilter + "')]"));
		waitForElement(driver, searchHeader);

		if (searchHeader.isDisplayed()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Navigation to HR Case Search page is successful", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Navigation to HR Case Search page Failed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	public void searchHRCaseinITIL(String caseID) throws IOException, InterruptedException {
		PageFactory.initElements(driver, ResidualFormITILCheck.class);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, searchDropDown);
		waitForElementToBeClickable(driver, searchDropDown);
		searchDropDown.click();
		Select select = new Select(searchDropDown);
		select.selectByVisibleText("Number");
		searchHRCase.clear();
		searchHRCase.sendKeys(caseID);
		searchHRCase.sendKeys(Keys.ENTER);

		waitForFrameToBeAvailable(driver, "gsft_main");

		waitForElement(driver, hr_link_number);
		waitForElementToBeClickable(driver, hr_link_number);
		if (isElementPresent(hr_link_number) && hr_link_number.getText().equals(caseID)) {
			hr_link_number.click();
			System.out.println("Article clicked successfully with ID " + caseID);
			test.get().log(Status.INFO, MarkupHelper.createLabel("Searched the HR Case" + caseID, ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			System.out.println("HR Case not Found!!!");
			test.get().log(Status.FAIL, MarkupHelper.createLabel("HR Case " + caseID + " not found", ExtentColor.RED));
			logFailure("Expected VAlue - " + caseID);
			logFailure("Actual Value - " + hr_link_number.getText());
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	public void validateHRCaseinITIL(String subjectPerson, String ssnFein, String form, String expectedPriority,
			String expectedHRService, String expectedAssignmentGroup) throws IOException, InterruptedException {
		PageFactory.initElements(driver, ResidualFormITILCheck.class);
		WebElement option = null;
		String priorityText = "";
		int count = 0;
		waitForFrameToBeAvailable(driver, "gsft_main");

		if (form.contains("Residuals: Stop/Cancel Payment Request")) {
			System.out.println("Form is " + form);
			waitForFrameToBeAvailable(driver, "gsft_main");
			waitForElement(driver, aboutPayee);
			if (aboutPayee.isDisplayed() && aboutPayee.getAttribute("value").equalsIgnoreCase(subjectPerson)) {
				System.out.println("About field is displayed with value - " + aboutPayee.getAttribute("value"));
				test.get().log(Status.INFO, MarkupHelper.createLabel(
						"About field is displayed with value - " + aboutPayee.getAttribute("value"), ExtentColor.CYAN));

				logSuccess("Expected Value - " + subjectPerson);
				logSuccess("Actual Value - " + aboutPayee.getAttribute("value"));

			} else {
				count++;
				System.out.println("About field is not displayed or does not match expected value - "
						+ aboutPayee.getAttribute("value"));
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("About field is not displayed or does not match expected value - "
								+ aboutPayee.getAttribute("value"), ExtentColor.RED));

				logFailure("Expected Value - " + subjectPerson);
				logFailure("Actual Value - " + aboutPayee.getAttribute("value"));

			}
		} else {
			waitForFrameToBeAvailable(driver, "gsft_main");
			waitForElementToBeClickable(driver, about);
			if (about.isDisplayed() && about.getAttribute("value").equalsIgnoreCase(subjectPerson)) {
				System.out.println("About field is displayed with value - " + about.getAttribute("value"));
				test.get().log(Status.INFO, MarkupHelper.createLabel(
						"About field is displayed with value - " + about.getAttribute("value"), ExtentColor.CYAN));

				logSuccess("Expected Value - " + subjectPerson);
				logSuccess("Actual Value - " + about.getAttribute("value"));

			} else {
				count++;
				System.out.println("About field is not displayed or does not match expected value - "
						+ about.getAttribute("value"));
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("About field is not displayed or does not match expected value - "
								+ about.getAttribute("value"), ExtentColor.RED));

				logFailure("Expected Value - " + subjectPerson);
				logFailure("Actual Value - " + about.getAttribute("value"));
			}
		}

		JavascriptExecutor execute = (JavascriptExecutor) driver;
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, aboutIcon);
		if (isElementPresent(aboutIcon)) {
			// aboutIcon.click();
			execute.executeScript("arguments[0].click();", aboutIcon);
			waitForFrameToBeAvailable(driver, "gsft_main");
			waitForElement(driver, preferedFullName);
			if (preferedFullName.getAttribute("value").equals(subjectPerson)) {
				logInfo("HR Profile is displayed for User: " + subjectPerson);

				logSuccess("Expected Value - " + subjectPerson);
				logSuccess("Actual Value - " + preferedFullName.getAttribute("value"));

				logInfoScreenshot(driver);
			} else {
				logFailure("HR Profile is displayed for unexpected User: " + subjectPerson);

				logFailure("Expected Value - " + subjectPerson);
				logFailure("Actual Value - " + preferedFullName.getAttribute("value"));

				logFailureScreenshot(driver);
			}
		} else {
			logFailure("i Icon is not displayed to check HR Profile of Subject Person");
			logFailureScreenshot(driver);
		}

		if (form.contains("Residuals: Beneficiary Request")) {
			if (beneficiarySSN.isDisplayed() && beneficiarySSN.getAttribute("value").equalsIgnoreCase(ssnFein)) {
				System.out
						.println("SSN or FEIN field is displayed with value - " + beneficiarySSN.getAttribute("value"));
				test.get().log(Status.INFO,
						MarkupHelper.createLabel(
								"SSN or FEIN field is displayed with value - " + beneficiarySSN.getAttribute("value"),
								ExtentColor.CYAN));

				logSuccess("Expected Value - " + ssnFein);
				logSuccess("Actual Value - " + beneficiarySSN.getAttribute("value"));

			} else {
				count++;
				System.out.println("SSN or FEIN field is not displayed or does not match expected value "
						+ beneficiarySSN.getAttribute("value"));
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("SSN or FEIN field is not displayed or does not match expected value"
								+ beneficiarySSN.getAttribute("value"), ExtentColor.RED));
				logFailure("Expected Value - " + ssnFein);
				logFailure("Actual Value - " + beneficiarySSN.getAttribute("value"));
			}
		}

		if (form.contains("Residuals: SSN Correction Request")) {
			if (updatedSSNorFEIN.isDisplayed() && updatedSSNorFEIN.getAttribute("value").equalsIgnoreCase(ssnFein)) {
				System.out.println(
						"SSN or FEIN field is displayed with value - " + updatedSSNorFEIN.getAttribute("value"));
				test.get().log(Status.INFO,
						MarkupHelper.createLabel(
								"SSN or FEIN field is displayed with value - " + updatedSSNorFEIN.getAttribute("value"),
								ExtentColor.CYAN));

				logSuccess("Expected Value - " + ssnFein);
				logSuccess("Actual Value - " + updatedSSNorFEIN.getAttribute("value"));

			} else {
				count++;
				System.out.println("SSN or FEIN field is not displayed or does not match expected value "
						+ updatedSSNorFEIN.getAttribute("value"));
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("SSN or FEIN field is not displayed or does not match expected value"
								+ updatedSSNorFEIN.getAttribute("value"), ExtentColor.RED));
				logFailure("Expected Value - " + ssnFein);
				logFailure("Actual Value - " + updatedSSNorFEIN.getAttribute("value"));
			}
		}

		if (form.contains("Residuals: Stop/Cancel Payment Request")) {
			if (hrServicePayee.isDisplayed() && hrServicePayee.getAttribute("value").contains(expectedHRService)) {
				System.out
						.println("HR Service field is displayed with value - " + hrServicePayee.getAttribute("value"));
				test.get().log(Status.INFO,
						MarkupHelper.createLabel(
								"HR Service field is displayed with value - " + hrServicePayee.getAttribute("value"),
								ExtentColor.CYAN));

				logSuccess("Expected Value - " + expectedHRService);
				logSuccess("Actual Value - " + hrServicePayee.getAttribute("value"));

			} else {
				count++;
				System.out.println("HR Service field is not displayed or does not match expected value - "
						+ hrServicePayee.getAttribute("value"));
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("HR Service field is not displayed or does not match expected value - "
								+ hrServicePayee.getAttribute("value"), ExtentColor.RED));

				logFailure("Expected Value - " + expectedHRService);
				logFailure("Actual Value - " + hrServicePayee.getAttribute("value"));

			}
		} else {
			if (hrService.isDisplayed() && hrService.getAttribute("value").contains(expectedHRService)) {
				System.out.println("HR Service field is displayed with value - " + hrService.getAttribute("value"));
				test.get().log(Status.INFO,
						MarkupHelper.createLabel(
								"HR Service field is displayed with value - " + hrService.getAttribute("value"),
								ExtentColor.CYAN));

				logSuccess("Expected Value - " + expectedHRService);
				logSuccess("Actual Value - " + hrService.getAttribute("value"));

			} else {
				count++;
				System.out.println("HR Service field is not displayed or does not match expected value - "
						+ hrService.getAttribute("value"));
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("HR Service field is not displayed or does not match expected value - "
								+ hrService.getAttribute("value"), ExtentColor.RED));

				logFailure("Expected Value - " + expectedHRService);
				logFailure("Actual Value - " + hrService.getAttribute("value"));
			}
		}

		if (form.contains("Residuals: Stop/Cancel Payment Request")) {
			if (assignmentGroupPayee.isDisplayed()
					&& assignmentGroupPayee.getAttribute("value").contains(expectedAssignmentGroup)) {
				System.out.println("Assignment Group field is displayed with value - "
						+ assignmentGroupPayee.getAttribute("value"));
				test.get().log(Status.INFO, MarkupHelper.createLabel("Assignment Group field is displayed with value - "
						+ assignmentGroupPayee.getAttribute("value"), ExtentColor.CYAN));

				logSuccess("Expected Value - " + expectedAssignmentGroup);
				logSuccess("Actual Value - " + assignmentGroupPayee.getAttribute("value"));

			} else {
				count++;
				System.out.println("Assignment Group field is not displayed or does not match expected value - "
						+ assignmentGroupPayee.getAttribute("value"));
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel(
								"Assignment Group field is not displayed or does not match expected value - "
										+ assignmentGroupPayee.getAttribute("value"),
								ExtentColor.RED));

				logFailure("Expected Value - " + expectedAssignmentGroup);
				logFailure("Actual Value - " + assignmentGroupPayee.getAttribute("value"));
			}
		} else {
			if (assignmentGroup.isDisplayed()
					&& assignmentGroup.getAttribute("value").contains(expectedAssignmentGroup)) {
				System.out.println(
						"Assignment Group field is displayed with value - " + assignmentGroup.getAttribute("value"));
				test.get().log(Status.INFO, MarkupHelper.createLabel(
						"Assignment Group field is displayed with value - " + assignmentGroup.getAttribute("value"),
						ExtentColor.CYAN));

				logSuccess("Expected Value - " + expectedAssignmentGroup);
				logSuccess("Actual Value - " + assignmentGroup.getAttribute("value"));

			} else {
				count++;
				System.out.println("Assignment Group field is not displayed or does not match expected value - "
						+ assignmentGroup.getAttribute("value"));
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel(
								"Assignment Group field is not displayed or does not match expected value - "
										+ assignmentGroup.getAttribute("value"),
								ExtentColor.RED));

				logFailure("Expected Value - " + expectedAssignmentGroup);
				logFailure("Actual Value - " + assignmentGroup.getAttribute("value"));

			}

		}
		if (form.contains("Residuals: Stop/Cancel Payment Request")) {
			if (priorityPayee.isDisplayed()) {
				Select select = new Select(priorityPayee);
				waitForAction(driver);
				option = select.getFirstSelectedOption();
				priorityText = option.getText();
			}
			System.out.println("Selected Drop down value - " + option.getText());
		} else {
			if (priority.isDisplayed()) {
				Select select = new Select(priority);
				waitForAction(driver);
				option = select.getFirstSelectedOption();
				priorityText = option.getText();
				System.out.println("Selected Drop down value - " + option.getText());
			}

			if (option.getText().contains(expectedPriority)) {
				System.out.println("Priority field is displayed with value - " + option.getText());
				test.get().log(Status.INFO, MarkupHelper
						.createLabel("Priority field is displayed with value - " + option.getText(), ExtentColor.CYAN));

				logSuccess("Expected Value - " + expectedPriority);
				logSuccess("Actual Value - " + option.getText());

			} else {
				count++;
				System.out
						.println("Priority field is not displayed or does not match expected value - " + priorityText);
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel(
								"Priority field is not displayed or does not match expected value - " + priorityText,
								ExtentColor.RED));

				logFailure("Expected Value - " + expectedPriority);
				logFailure("Actual Value - " + option.getText());

			}
		}

		if (count == 0) {
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	public void verifyCheckInfoITIL() throws IOException {
		PageFactory.initElements(driver, ResidualFormITILCheck.class);
		ResidualsFormPage residualsFormPage = new ResidualsFormPage(driver);
		int count = 0;

		if (employeeNumber.getAttribute("value").equals(residualsFormPage.fieldValueMap.get("TWID"))) {
			logInfo("Employee Number matches with TWID of subject person: " + employeeNumber.getAttribute("value"));

			logSuccess("Expected Value - " + residualsFormPage.fieldValueMap.get("TWID"));
			logSuccess("Actual Value - " + employeeNumber.getAttribute("value"));

		} else {
			count++;
			logFailure("Employee Number does not match with TWID of subject person: "
					+ employeeNumber.getAttribute("value"));

			logFailure("Expected Value - " + residualsFormPage.fieldValueMap.get("TWID"));
			logFailure("Actual Value - " + employeeNumber.getAttribute("value"));

		}

		if (requestTypeITIL.getAttribute("value").equals(residualsFormPage.fieldValueMap.get("Request Type"))) {
			logInfo("Displayed Request Type:" + requestTypeITIL.getAttribute("value"));

			logSuccess("Expected Value - " + residualsFormPage.fieldValueMap.get("Request Type"));
			logSuccess("Actual Value - " + requestTypeITIL.getAttribute("value"));

		} else {
			count++;
			logFailure("Displayed Request Type does not match with expected:" + requestTypeITIL.getAttribute("value"));

			logFailure("Expected Value - " + residualsFormPage.fieldValueMap.get("Request Type"));
			logFailure("Actual Value - " + requestTypeITIL.getAttribute("value"));

		}

		if (sapCompanyCodeITIL.getAttribute("value").equals(residualsFormPage.fieldValueMap.get("SAP Company Code"))) {
			logInfo("Displayed SAP Company Code:" + sapCompanyCodeITIL.getAttribute("value"));

			logSuccess("Expected Value - " + residualsFormPage.fieldValueMap.get("SAP Company Code"));
			logSuccess("Actual Value - " + sapCompanyCodeITIL.getAttribute("value"));

		} else {
			count++;
			logFailure("Displayed SAP Company Code does not match with expected:"
					+ sapCompanyCodeITIL.getAttribute("value"));

			logFailure("Expected Value - " + residualsFormPage.fieldValueMap.get("SAP Company Code"));
			logFailure("Actual Value - " + sapCompanyCodeITIL.getAttribute("value"));

		}

		if (checkNoITIL.getAttribute("value").equals(residualsFormPage.fieldValueMap.get("Check Number"))) {
			logInfo("Displayed Check Number:" + checkNoITIL.getAttribute("value"));

			logSuccess("Expected Value - " + residualsFormPage.fieldValueMap.get("Check Number"));
			logSuccess("Actual Value - " + checkNoITIL.getAttribute("value"));

		} else {
			count++;
			logFailure("Displayed Check Number does not match with expected:" + checkNoITIL.getAttribute("value"));

			logFailure("Expected Value - " + residualsFormPage.fieldValueMap.get("Check Number"));
			logFailure("Actual Value - " + checkNoITIL.getAttribute("value"));

		}

		if (checkDateITIL.getAttribute("value").equals(residualsFormPage.fieldValueMap.get("Check Date"))) {
			logInfo("Displayed Check Date:" + checkDateITIL.getAttribute("value"));

			logSuccess("Expected Value - " + residualsFormPage.fieldValueMap.get("Check Date"));
			logSuccess("Actual Value - " + checkDateITIL.getAttribute("value"));

		} else {
			count++;
			logFailure("Displayed Check Date does not match with expected:" + checkDateITIL.getAttribute("value"));

			logFailure("Expected Value - " + residualsFormPage.fieldValueMap.get("Check Date"));
			logFailure("Actual Value - " + checkDateITIL.getAttribute("value"));

		}

		if (netAmountITIL.getAttribute("value").equals(residualsFormPage.fieldValueMap.get("Net Amount"))) {
			logInfo("Displayed Net Amount:" + netAmountITIL.getAttribute("value"));

			logSuccess("Expected Value - " + residualsFormPage.fieldValueMap.get("Net Amount"));
			logSuccess("Actual Value - " + netAmountITIL.getAttribute("value"));

		} else {
			count++;
			logFailure("Displayed Net Amount does not match with expected:" + netAmountITIL.getAttribute("value"));

			logFailure("Expected Value - " + residualsFormPage.fieldValueMap.get("Net Amount"));
			logFailure("Actual Value - " + netAmountITIL.getAttribute("value"));

		}

		if (count == 0) {
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

	}

	public void resolveHRCaseinITIL(String assignTo, String workNote, String form)
			throws IOException, InterruptedException, AWTException {
		PageFactory.initElements(driver, ResidualFormITILCheck.class);
		// Actions actions = new Actions(driver);
		String hrPageWindowHandle = driver.getWindowHandle();
		WebElement option = null;
		waitForFrameToBeAvailable(driver, "gsft_main");
		System.out.println("Main Window - " + hrPageWindowHandle);

		// Perform the click operation that opens new window
		if (assignedTo.isDisplayed()) {
			assignedTo.click();
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Assign To field is not displayed", ExtentColor.RED));
		}

		// Switch to new window opened
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> windowIterator = handles.iterator();
		System.out.println("Total Hnadles - " + handles.size());
		// iterate through your windows
		while (windowIterator.hasNext()) {
			String windowName = windowIterator.next();
			System.out.println("Current Window Name - " + windowName);
			if (!windowName.equals(hrPageWindowHandle)) {
				driver.switchTo().window(windowName);
				System.out.println(windowName);
				driver.switchTo().window(windowName);
				driver.manage().window().maximize();
				waitForElementToBeClickable(driver, searchCriteria);
				Select dropdown = new Select(searchCriteria);
				dropdown.selectByVisibleText("Name");
				searchTextBox.clear();
				searchTextBox.sendKeys(assignTo);
				searchTextBox.sendKeys(Keys.ENTER);
				checkForPageLoad(driver);
				waitForElementToBeClickable(driver, nameSearchTextBox);
				if (nameSearchTextBox.isDisplayed()) {
					test.get().log(Status.INFO, MarkupHelper
							.createLabel("Entering the value for Assign to field - " + assignTo, ExtentColor.CYAN));
					waitForElement(driver, nameSearchTextBox);
					nameSearchTextBox.clear();
					nameSearchTextBox.sendKeys(assignTo);
					nameSearchTextBox.sendKeys(Keys.ENTER);
					checkForPageLoad(driver);
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					WebElement searchResult = driver.findElement(
							By.xpath("//*[contains(@class, 'glide_ref_item_link') and contains(@role, 'button')]"));
					System.out.println("Is Element present - " + searchResult.isDisplayed());
					waitForElementToBeClickable(driver, searchResult);
					checkForPageLoad(driver);
					try {
						searchResult.click();
					} catch (Exception e) {
						// TODO: handle exception
					}
					/*
					 * if (isElementPresent(searchResult)) { waitForElementToBeClickable(driver,
					 * searchResult); JavascriptExecutor execute = (JavascriptExecutor) driver;
					 * execute.executeScript("arguments[0].click();", searchResult);
					 * 
					 * }
					 */
				}
			}
		}

		waitForExpectedNumberOfWindows(driver, 1);
		System.out.println("Switching to - " + hrPageWindowHandle);
		driver.switchTo().window(hrPageWindowHandle);
		waitForFrameToBeAvailable(driver, "gsft_main");
		checkForPageLoad(driver);
		if (form.contains("Residuals: Stop/Cancel Payment Request")) {
			waitForElement(driver, statePayee);
			if (statePayee.isDisplayed()) {
				test.get().log(Status.INFO,
						MarkupHelper.createLabel("Selecting the state as Resolved", ExtentColor.CYAN));
				waitForElementToBeClickable(driver, statePayee);
				Select states = new Select(statePayee);
				states.selectByVisibleText("Resolved");
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("State dropdown field is not displayed", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}
		} else {
			waitForElement(driver, state);
			if (state.isDisplayed()) {
				test.get().log(Status.INFO,
						MarkupHelper.createLabel("Selecting the state as Resolved", ExtentColor.CYAN));
				waitForElementToBeClickable(driver, state);
				Select states = new Select(state);
				states.selectByVisibleText("Resolved");
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("State dropdown field is not displayed", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}
		}

		waitForElement(driver, workNotesError);
		if (isElementPresent(driver, workNotesError)) {
			logInfo("Work Notes are mandatory to change the State to Resolved : " + workNotesError.getText());
		} else {
			logFailure("Work Notes is not displayed as mandatory");
		}

		scrollPageToElement(driver, workNotes);
		if (workNotes.isDisplayed()) {
			test.get().log(Status.INFO, MarkupHelper.createLabel("Entering the Work Notes", ExtentColor.CYAN));
			waitForElementToBeClickable(driver, workNotes);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].textContent='" + workNote + " " + "';", workNotes);
			waitForAction(driver);
			workNotes.sendKeys(workNote);
			checkForPageLoad(driver);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Work notes field is not displayed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		if (header.isDisplayed()) {
			test.get().log(Status.INFO, MarkupHelper.createLabel("Saving the HR Case as Resolved", ExtentColor.CYAN));
			waitForFrameToBeAvailable(driver, "gsft_main");
			System.out.println("Is Case ID displayed - " + caseNumber.isDisplayed());
			String caseID = caseNumber.getAttribute("value").trim();
			System.out.println("Case ID - " + caseID);
			// scrollPageToElement(driver, updateButton);
			waitForElementToBeClickable(driver, updateButton);

			JavascriptExecutor execute = (JavascriptExecutor) driver;
			execute.executeScript("arguments[0].click();", updateButton);

			waitForElement(driver, workNotesError);
			if (isElementPresent(workNotesError)) {
				execute.executeScript("arguments[0].textContent='" + workNote + "';", workNotes);
				checkForPageLoad(driver);
				scrollToElement(driver, updateButton);
				waitForElementToBeClickable(driver, updateButton);
				// updateButton.submit();
				execute.executeScript("arguments[0].click();", updateButton);
				checkForPageLoad(driver);
				if (isElementPresent(updateButton)) {
					scrollPageToElement(driver, updateButton);
					Actions actions = new Actions(driver);
					actions.click(updateButton).build().perform();
				}
			}
			// updateButton.click();
			waitForFrameToBeAvailable(driver, "gsft_main");
			waitForElement(driver, searchHRCase);
			waitForElementToBeClickable(driver, searchCriteria);
			searchHRCase.clear();
			waitForElementToBeClickable(driver, searchHRCase);
			searchHRCase.sendKeys(caseID);
			searchHRCase.sendKeys(Keys.ENTER);
			waitForFrameToBeAvailable(driver, "gsft_main");
			waitForElementToBeClickable(driver, hr_link_number);
			if (hr_link_number.isDisplayed() && hr_link_number.getText().trim().equals(caseID.trim())) {
				hr_link_number.click();
				waitForFrameToBeAvailable(driver, "gsft_main");
				System.out.println("Article clicked successfully with ID " + caseID);
			} else {
				System.out.println("HR Case not Found");
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("HR Case " + caseID + " not found", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				logFailure("Expected Value - " + caseID);
				logFailure("Actual Value - " + hr_link_number.getText().trim());

				System.out.println("Expected Value - " + caseID);
				System.out.println("Actual Value - " + hr_link_number.getText());
			}

			/*
			 * } else { actions.contextClick(header).perform(); screenshotPath =
			 * getScreenshot(driver, this.getClass().getName()); test.get().info("Details",
			 * MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			 * saveOption.click();
			 * 
			 * waitForFrameToBeAvailable(driver, "gsft_main"); // }
			 */
		}

		if (form.contains("Residuals: Stop/Cancel Payment Request")) {
			waitForFrameToBeAvailable(driver, "gsft_main");
			waitForElement(driver, statePayee);
			if (statePayee.isDisplayed()) {
				Select select = new Select(statePayee);
				waitForAction(driver);
				option = select.getFirstSelectedOption();
				System.out.println("Selected Drop down value - " + option.getText());

				if (option.getText().contains("Resolved")) {
					System.out.println("State field is displayed with value - " + option.getText());
					test.get().log(Status.PASS, MarkupHelper.createLabel(
							"State field is displayed with value - " + option.getText(), ExtentColor.GREEN));

					logSuccess("Expected Value - " + "Resolved");
					logSuccess("Actual Value - " + option.getText());

					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				}
			} else {
				System.out.println("State field is not displayed or does not match expected value Resolved");
				test.get().log(Status.FAIL, MarkupHelper.createLabel(
						"Priority field is not displayed or does not match expected value Resolved", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}

		} else {
			waitForFrameToBeAvailable(driver, "gsft_main");
			waitForElement(driver, state);
			if (state.isDisplayed()) {
				Select select = new Select(state);
				waitForAction(driver);
				option = select.getFirstSelectedOption();
				System.out.println("Selected Drop down value - " + option.getText());

				if (option.getText().contains("Resolved")) {
					System.out.println("State field is displayed with value - " + option.getText());
					test.get().log(Status.PASS, MarkupHelper.createLabel(
							"State field is displayed with value - " + option.getText(), ExtentColor.GREEN));

					logSuccess("Expected Value - " + "Resolved");
					logSuccess("Actual Value - " + option.getText());

					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				}
			} else {
				System.out.println("State field is not displayed or does not match expected value Resolved");
				test.get().log(Status.FAIL, MarkupHelper.createLabel(
						"Priority field is not displayed or does not match expected value Resolved", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}
		}
	}
}