package com.snow.pageobjects;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.snow.base.ReusableLibrary;

public class PayrollRecordsRequestPage extends  ReusableLibrary {
	public WebDriver driver;
	
	public PayrollRecordsRequestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id='s2id_sp_formfield_Select_Employee']/a")
	public static WebElement selectWorker;

	@FindBy(xpath = "//label[contains(text(), 'Select Employee')]/following-sibling::input[contains(@class,'select2-input')]")
	public static WebElement searchWorker;

	@FindBy(id = "sp_formfield_TWID")
	public static WebElement twid;

	@FindBy(id = "sp_formfield_First_Name")
	public static WebElement firstName;

	@FindBy(id = "sp_formfield_Last_Name")
	public static WebElement lastName;
	
	@FindBy(xpath ="//*[text()='Payroll Request About'] ")
	public WebElement subHeader;

	// @FindBy(xpath = "//*[contains(@class,'reference')]/span") // Madrid value
	@FindBy(xpath = "//a[@class='select2-choice select2-default form-control']") // Updated in Newyork
																			
																				 
	public static WebElement selectWorker2;

	@FindBy(xpath = "//*[@id='select2-drop']/div/input")
	public static WebElement inputWorker2;

	@FindBy(xpath = "//*[@id='select2-results-4']/li")
	public static WebElement noMatch;

	@FindBy(xpath = "//*[@class='h2 m-t-none m-b-sm font-thin ng-binding ng-scope']")
	public static WebElement formLabel;

	@FindBy(xpath = "//*[@class='text-muted sc-cat-item-short-description ng-binding ng-scope']")
	public static WebElement formShortDesc;

	@FindBy(xpath = "//*[@id='sp_formfield_Other_payment_type']")
	public static WebElement specifyOther_payment_type;

	@FindBy(xpath = "//input[@id='s2id_autogen11']")
	public static WebElement payrollrecordsgroup2;

	@FindBy(xpath = "//*[contains(@id,'s2id_sp_formfield_payroll_records_group')]/ul/li/input")
	public static WebElement payrollrecordsgroup;
	
	@FindBy(xpath = "//label[@class='field-label ng-binding ng-scope'][contains(text(),'Payroll Records Group(s)')]")
	public static WebElement label_payrollrecordsgroup;
	
	@FindBy(xpath = "//label[contains(text(),'Additional Information (Payment Types and Amounts)')]")
	public static WebElement label_additional_info;

	@FindBy(xpath = "//*[contains(@id, 's2id_autogen11_choice_')]/a")
	public static WebElement payrollrecordsgroupRemove;

	@FindBy(xpath = "//label[@class='field-label ng-binding ng-scope'][contains(text(),'Request Type')]")
	public static WebElement requestType_label;

	// @FindBy(id = "select2-chosen-7")
	@FindBy(xpath = "//*[@id='s2id_sp_formfield_Request_Type']//a[@class='select2-choice form-control']")
	public static WebElement requestType;

	// @FindBy(xpath = "//input[@id='s2id_autogen7_search']")
	@FindBy(xpath = "//input[@id='s2id_autogen1_search']")
	public static WebElement requestTypeInput;

	@FindBy(xpath = "//div[@id='s2id_sp_formfield_Delivery_Method']//a[@class='select2-choice form-control']")
	public static WebElement fileShare;

	@FindBy(xpath = "//*[@id='s2id_sp_formfield_Delivery_Method']/a")
	public static WebElement fileShareText;

	@FindBy(id = "sp_formfield_Date_Needed")
	public static WebElement dateTime;

	@FindBy(xpath = "//*[@id='Delivery_Method']/div/label/span/span")
	public static WebElement deliverymethodastrix;

	@FindBy(xpath = "//*[@id='select2-chosen-3']")
	public static WebElement deliverymethod;

	@FindBy(xpath = "//*[@id='s2id_sp_formfield_Delivery_Method']/a")
	public static WebElement deliverymethodDropDown;

	@FindBy(xpath = "//*[@id='sp_formfield_Delivery_Method']/option")
	public static WebElement deliverymethodoptions;

	@FindBy(id = "sp_formfield_return_date")
	public static WebElement expDocumentReturnDate;

	// @FindBy(xpath = "//input[@id='s2id_autogen11']")
	// public static WebElement documentType2;

	@FindBy(xpath = "//*[@id='s2id_autogen3_search']")
	public static WebElement deliverymethodoptionsselect;

	@FindBy(xpath = "//*[contains(@id,'select2-chosen-2') and contains(text(),'US/Pacific')]")
	public static WebElement timeZone;

	@FindBy(xpath = "//*[contains(@id,'s2id_sp_formfield_Timezone')and contains(@class,'disabled')]")
	public static WebElement timeZoneDisabled;

	@FindBy(id = "sp_formfield_u_name")
	public static WebElement pocName;

	@FindBy(id = "sp_formfield_u_workemail")
	public static WebElement pocEmail;

	@FindBy(id = "sp_formfield_phone_number")
	public static WebElement pocPhoneNumber;

	@FindBy(xpath = "//*[@for='sp_formfield_u_name']/child::span/span[@ng-show ='field.mandatory']")
	public static WebElement mandatIndicatorPOCName;

	@FindBy(xpath = "//*[contains(@id,'sp_formfield_u_workemail') and contains(@readonly, 'readonly')]")
	public static WebElement pocEmailReadOnly;

	@FindBy(xpath = "//*[contains(@id,'sp_formfield_phone_number') and contains(@readonly, 'readonly')]")
	public static WebElement pocPhoneNumberReadOnly;

	@FindBy(xpath = "//*[@id='sp_formfield_alternate_contact']")
	public static WebElement alternateContact;

	@FindBy(xpath = "//*[@name='submit']")
	public static WebElement submitButton;

	@FindBy(xpath = "//*[contains(@class,'title-info ng-binding')]")
	public static WebElement caseID;

	@FindBy(xpath = "//input[@id='filter']")
	public static WebElement filterNavigator;

	@FindBy(xpath = "//*[@id='7a5330019f22120047a2d126c42e70e0']/div/div")
	public static WebElement openHRCase;

	// @FindBy(xpath = "//select[@class='form-control']")// X path used in
	// Madrid Version
	@FindBy(xpath = "//select[@class='form-control default-focus-outline']") // X
																				// path
																				// Updated
																				// after
																				// Newyork
																				// Upgrade
	public static WebElement searchDropDown;

	@FindBy(xpath = "//div[@class='input-group']/input")
	public static WebElement searchHRCase;

	@FindBy(xpath = "//a[@class='linked formlink']")
	public static WebElement hrcNo;

	@FindBy(xpath = "//*[@id='sn_hr_core_hr_employee_services.u_return_date_needed']")
	public static WebElement expDocRetDate;

	@FindBy(xpath = "//*[@id='sys_display.sn_hr_core_hr_employee_services.assignment_group']")
	public static WebElement assgnGroup;

	@FindBy(xpath = "//*[@id='lookup.sn_hr_core_hr_employee_services.assigned_to']/span")
	public static WebElement assgnTo;

	@FindBy(xpath = "//*[@class='glide_ref_item_link']")
	public static WebElement worker;

	@FindBy(xpath = "//*[@id='sn_hr_core_hr_employee_services.state']")
	public static WebElement state;

	@FindBy(xpath = "//nav[@class='navbar navbar-default section_zero  ng-scope']/div[@class='container-fluid']")
	public static WebElement header;

	@FindBy(xpath = "//*[@id='context_1']/div[2]")
	public static WebElement headerSave;

	@FindBy(xpath = "//input[@class = 'form-control' and @placeholder = 'Search']")
	public static WebElement searchHRCaseTextBox;

	// @FindBy(xpath = "//select[@class = 'form-control']") // X path used in
	// Madrid Version
	@FindBy(xpath = "//select[@class='form-control default-focus-outline']") // X
																				// path
																				// Updated
																				// after
																				// New
																				// york
																				// Upgrade
	public static WebElement searchHRCaseDropDown;

	// ------------------------------------ HR Task Page
	// --------------------------------------

	@FindBy(xpath = "//td[contains(@class,'vt') and text()='Send Original Document(s) to Requester']")
	public static WebElement sendOriginaldoctoReq;

	@FindBy(xpath = "//td[contains(text(),'Original Document(s) Returned')]")
	public static WebElement OriginaldocReturned;

	@FindBy(xpath = "//*[@class='list_row list_odd embedded list_row_compact']/td[3]/a")
	public static WebElement hrtNo;

	@FindBy(xpath = "//*[@class='list_row list_even embedded list_row_compact']/td[3]/a")
	public static WebElement hrt2No;

	@FindBy(xpath = "//*[@id='lookup.sn_hr_core_task.assigned_to']")
	public static WebElement assignedToMglass;

	@FindBy(xpath = "//input[@id='sys_user_table_header_search_control']")
	public static WebElement assignedToMsearch;

	@FindBy(xpath = "//*[@id='row_sys_user_b8f3ccffdb07634082e3751c8c961994']/td[3]/a")
	public static WebElement assignedToMsearchUser;

	@FindBy(id = "sn_hr_core_task.state")
	public static WebElement HRState;

	@FindBy(xpath = "//*[@id='activity-stream-work_notes-textarea']")
	public static WebElement workNotes;

	@FindBy(xpath = "//*[@id='fieldmsg-singleinput-7']/li")
	public static WebElement workNotesError;

	@FindBy(xpath = "//button[@class='btn btn-default pull-right activity-submit']")
	public static WebElement postButton;

	@FindBy(xpath = "//*[contains(@id, 'section-') and contains(@id, 'header')]/nav/div")
	public static WebElement header2;

	@FindBy(xpath = "//*[@id='viewr.sn_hr_core_task.parent']")
	public static WebElement icon;

	/*
	 * @FindBy(xpath =
	 * "//label[contains(@class,'col-xs-4 control-label')]//span[@class='label-text'][contains(text(),'State')]"
	 * ) public static WebElement task_icon_case_state_label;
	 * 
	 * 
	 * @FindBy(xpath =
	 * "//input[@id='sys_readonly.sn_hr_core_hr_employee_services.state']")
	 * public static WebElement task_icon_case_state_label_option;
	 */

	@FindBy(xpath = "//*[@class='popover-title']")
	public static WebElement iconServiceCase;

	@FindBy(xpath = "//*[contains(@class,'popover-header')]/a")
	public static WebElement openRecord;

	@FindBy(xpath = "//*[@class='list_row list_odd embedded list_row_compact']/td[5]")
	public static WebElement taskState;

	@FindBy(xpath = "//*[@class='list_row list_even embedded list_row_compact']/td[5]")
	public static WebElement task2State;

	@FindBy(xpath = "//*[@class='outputmsg_container']//*[@id='close-messages-btn' and @aria-label = 'Close Messages']")
	public static WebElement closeError1;

	LinkedHashMap<String, String> fieldValueMap = new LinkedHashMap<String, String>();

	public void verifyFormLableAndShortDesc(String expectedFormLabel, String expectedShortDesc)
			throws IOException, InterruptedException {
		PageFactory.initElements(driver, PayrollRecordsRequestPage.class);
//		fieldValueMap.clear();
		String actualFormLabel = null;
		String actualFormShortDesc = null;
		checkForPageLoad(driver);
		Thread.sleep(1000);
//		System.out.println("Inside Method  : verifyFormLableAndShortDesc");
	//	waitForElement(driver, formLabel);
		if (formLabel.isDisplayed()) {
			actualFormLabel = formLabel.getText();

			if (actualFormLabel.contains(expectedFormLabel)) {
				test.get().log(Status.PASS,
						MarkupHelper.createLabel(
								"Displayed Form Label matches with expected Form Label: " + actualFormLabel,
								ExtentColor.GREEN));

				logSuccess("Expected Value - " + expectedFormLabel);
				logSuccess("Actual Value - " + actualFormLabel);

			} else {
				test.get().log(Status.FAIL, MarkupHelper
						.createLabel("Displayed Form Label does not match with expected Form Label", ExtentColor.RED));

				logFailure("Expected Value - " + expectedFormLabel);
				logFailure("Actual Value - " + actualFormLabel);

				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}

			if (formShortDesc.isDisplayed()) {
				actualFormShortDesc = formShortDesc.getText().trim();
				if (actualFormShortDesc.contains(expectedShortDesc)) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel(
									"Displayed Form Label matches with expected Form Label: " + actualFormShortDesc,
									ExtentColor.GREEN));

					logSuccess("Expected Value - " + expectedShortDesc);
					logSuccess("Actual Value - " + actualFormShortDesc);

				} else {
					test.get().log(Status.FAIL, MarkupHelper.createLabel(
							"Displayed Form Label does not match with expected Form Label: " + actualFormShortDesc,
							ExtentColor.RED));

					logFailure("Expected Value - " + expectedShortDesc);
					logFailure("Actual Value - " + actualFormShortDesc);

					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				}
			}
		}
	}

	public void validateSelectWorker2(String worker) throws IOException, InterruptedException {
		PageFactory.initElements(driver, PayrollRecordsRequestPage.class);
		selectWorker2.click();
		inputWorker2.clear();
		inputWorker2.sendKeys(worker);
		checkForPageLoad(driver);
		inputWorker2.sendKeys(Keys.ENTER);

		waitForElement(driver, noMatch);
		String actualValue = noMatch.getText();
		String expectedValue = "No matches found";

		if (actualValue.equals(expectedValue)) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"selectWorker2 Field is Autopopulated with value:  " + actualValue, ExtentColor.GREEN));

			logSuccess("Expected Value - " + expectedValue);
			logSuccess("Actual Value - " + actualValue);
			System.out.println("selectWorker2 Field is Autopopulated with value:  " + actualValue);
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("selectWorker2 Field value is not autopopulated" + expectedValue, ExtentColor.RED));

			logFailure("Expected Value - " + expectedValue);
			logFailure("Actual Value - " + actualValue);
		}
		inputWorker2.clear();
		inputWorker2.sendKeys(Keys.TAB);
		checkForPageLoad(driver);
	}

	/* Validation for Worker Information Section */
	public void validateSelectWorker(String worker) throws IOException, InterruptedException {
		PageFactory.initElements(driver, PayrollRecordsRequestPage.class);
		WebElement workerClick = null;
		System.out.println("Inside Method  : validateSelectWorker0");
		scrollToElement(driver, subHeader);
		System.out.println("Inside Method  : validateSelectWorker1");
		waitForElementToBeClickable(driver, selectWorker);
		selectWorker.click();
		waitForElementToBeClickable(driver, searchWorker);
		searchWorker.clear();
		waitForAction(driver);
		searchWorker.sendKeys(worker);
		waitForAction(driver);
		System.out.println("Inside Method  : validateSelectWorker2");
		/*		WebElement workerClick = null;
		checkForPageLoad(driver);
		selectWorker.click();
		checkForPageLoad(driver);
		searchWorker.clear();
		searchWorker.sendKeys(worker);
		checkForPageLoad(driver);
		Thread.sleep(2000);*/
		try {
			workerClick = driver.findElement(
					By.xpath("//*[contains(@class, 'select2-result-') and contains(text(), '" + worker + "')]"));
			workerClick.click();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Element not present for worker - " + worker);
		}

		checkForPageLoad(driver);

		if (!twid.getAttribute("value").trim().isEmpty()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"TWID Field is Autopopulated with value:  " + twid.getAttribute("value").trim(),
							ExtentColor.GREEN));
			System.out.println("TWID Field is Autopopulated with value:  " + twid.getAttribute("value").trim());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"TWID Field value is not autopopulated" + twid.getAttribute("value").trim(), ExtentColor.RED));
		}

		if (!firstName.getAttribute("value").trim().isEmpty()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"First Name Field is Autopopulated with value:  " + firstName.getAttribute("value").trim(),
							ExtentColor.GREEN));
			System.out.println(
					"First Name Field is Autopopulated with value:  " + firstName.getAttribute("value").trim());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"First Name Field value is not autopopulated" + firstName.getAttribute("value").trim(),
							ExtentColor.RED));
		}

		if (!lastName.getAttribute("value").trim().isEmpty()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"Last Name Field is Autopopulated with value:  " + lastName.getAttribute("value").trim(),
							ExtentColor.GREEN));
			System.out
					.println("Last Name Field is Autopopulated with value:  " + lastName.getAttribute("value").trim());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"Last Name Field value is not autopopulated" + lastName.getAttribute("value").trim(),
							ExtentColor.RED));
		}

		test.get().log(Status.INFO, MarkupHelper
				.createLabel("Actual Autopopulation of field can be seen in belwo screenshot:", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

	}

	public void verifyFormLableAndShortDesc1(String expectedFormLabel, String expectedShortDesc)	throws IOException, InterruptedException {
		PageFactory.initElements(driver, PayrollRecordsRequestPage.class);
		String actualFormLabel = null;
		String actualFormShortDesc = null;

//		checkForPageLoad(driver);
//		Thread.sleep(1000);
//		System.out.println("driver=" + formLabel);
		// scrollPageDown(driver, formLabel);
		if (formLabel.isDisplayed()) {
			actualFormLabel = formLabel.getText();
			if (actualFormLabel.contains(expectedFormLabel)) {
				test.get().log(Status.PASS,
						MarkupHelper.createLabel(
								"Displayed Form Label matches with expected Form Label: " + actualFormLabel,
								ExtentColor.GREEN));
				logSuccess("Expected Value Form Label - " + expectedFormLabel);
				logSuccess("Actual Value Form Label- " + actualFormLabel);
			} else {
				test.get().log(Status.FAIL, MarkupHelper
						.createLabel("Displayed Form Label does not match with expected Form Label", ExtentColor.RED));
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("Actual Label - " + actualFormLabel, ExtentColor.RED));
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("Actual Label - " + expectedFormLabel, ExtentColor.RED));
				logFailure("Expected Value - " + expectedFormLabel);
				logFailure("Actual Value - " + actualFormLabel);
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}

			if (formShortDesc.isDisplayed()) {
				actualFormShortDesc = formShortDesc.getText();
				if (actualFormShortDesc.contains(expectedShortDesc)) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel(
									"Displayed Form Label matches with expected Form Label: " + actualFormShortDesc,
									ExtentColor.GREEN));
					logSuccess("Expected Value - " + expectedShortDesc);
					logSuccess("Actual Value - " + actualFormShortDesc);
				} else {
					test.get().log(Status.FAIL, MarkupHelper.createLabel(
							"Displayed Form Label does not match with expected Form Label: " + actualFormShortDesc,
							ExtentColor.RED));
					logFailure("Expected Value - " + expectedShortDesc);
					logFailure("Actual Value - " + actualFormShortDesc);
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				}
			}
		} else {

			logFailure("Following Expected Label Not available - " + expectedShortDesc);
		}
	}

	public void paymentTypeNoOther(String documentTypeInput) throws IOException, InterruptedException {
		PageFactory.initElements(driver, PayrollRecordsRequestPage.class);
		scrollPageToElement(driver, label_payrollrecordsgroup);
		payrollrecordsgroup.click();
		checkForPageLoad(driver);
		String[] splitdocumentTypeInput = documentTypeInput.split(",");
		for (int i = 0; i < splitdocumentTypeInput.length; i++) {
			if (!splitdocumentTypeInput[i].trim().equalsIgnoreCase("Other")) {
				payrollrecordsgroup.sendKeys(splitdocumentTypeInput[i]);
				Thread.sleep(2000);
				payrollrecordsgroup.sendKeys(Keys.TAB);
			} else {
				break;
			}
		}
		if (specifyOther_payment_type.isDisplayed()) {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"Specify Other Document Type Field is displayed when Document Type Other is not selected",
							ExtentColor.RED));
			logFailureScreenshot(driver);
		} else {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"Specify Other Document Type Field is not displayed when Document Type Other is not selected",
							ExtentColor.GREEN));

		}
		Thread.sleep(2000);
		for (int i = 0; i < splitdocumentTypeInput.length; i++) {
			if (!splitdocumentTypeInput[i].trim().equalsIgnoreCase("Other")) {
				if (isElementPresent(payrollrecordsgroupRemove)) {
					payrollrecordsgroupRemove.click();

				}

			}
		}
		Thread.sleep(2000);
		for (int i = 0; i < splitdocumentTypeInput.length; i++) {
			if (splitdocumentTypeInput[i].trim().equalsIgnoreCase("Other")) {
				Thread.sleep(2000);
				payrollrecordsgroup.sendKeys(splitdocumentTypeInput[i]);
				Thread.sleep(3000);
				payrollrecordsgroup.sendKeys(Keys.TAB);
				Thread.sleep(2000);
			}
		}
		if (specifyOther_payment_type.isDisplayed()) {
			System.out.println(specifyOther_payment_type.isDisplayed());
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"Specify Other Document Type Field is displayed when Document Type value is :  "
									+ documentTypeInput,
							ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"Specify Other Document Type Field is displayed when Document Type value is :  "
									+ documentTypeInput,
							ExtentColor.RED));
		}
	}

	List<String> list = new ArrayList<String>();

	public void submitButtonInputs(String worker, String documentTypeInput) throws IOException, InterruptedException {
		PageFactory.initElements(driver, PayrollRecordsRequestPage.class);
		// String[] splitworker = worker.split(",");
		selectWorker2.click();
		inputWorker2.clear();
		inputWorker2.sendKeys(worker);
		checkForPageLoad(driver);
		Thread.sleep(2000);
		inputWorker2.sendKeys(Keys.TAB);
		//label_additional_info
		scrollPageToElement(driver, label_payrollrecordsgroup);
		payrollrecordsgroup.click();
		Thread.sleep(2000);
		String[] splitdocumentTypeInput = documentTypeInput.split(",");
		for (int i = 0; i < splitdocumentTypeInput.length; i++) {
			if (!splitdocumentTypeInput[i].equalsIgnoreCase("Other")) {
				payrollrecordsgroup.sendKeys(splitdocumentTypeInput[i]);
				Thread.sleep(2000);
				payrollrecordsgroup.sendKeys(Keys.TAB);
			} else {
				break;
			}
		}
		if (specifyOther_payment_type.isDisplayed()) {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"Specify Other Document Type is displayed when Document Type Other is not selected",
							ExtentColor.RED));
		} else {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"Specify Other Document Type is not displayed when Document Type Other is not selected",
							ExtentColor.GREEN));
		}
	}

	public void requestTypeElectronicCopy(String requestTypeInputData, String deliveryMethodOptions)
			throws IOException, InterruptedException, ParseException {
		PageFactory.initElements(driver, PayrollRecordsRequestPage.class);
		List<String> inputdata = new ArrayList<>();
		List<String> applicationdata = new ArrayList<>();
		String[] splitrequestTypeInputData = requestTypeInputData.split(",");
		String[] splitdeliveryMethodOptions = deliveryMethodOptions.split(",");

		System.out.println("Expected Delivery Methods length - " + splitdeliveryMethodOptions.length);
		for (int i = 0; i < splitdeliveryMethodOptions.length; i++) {
			inputdata.add(splitdeliveryMethodOptions[i].trim());
		}

		for (int i = 0; i < splitrequestTypeInputData.length; i++) {
			if (splitrequestTypeInputData[i].equalsIgnoreCase("Electronic Copy")) {
				test.get().log(Status.INFO, MarkupHelper
						.createLabel("Request Type is - " + splitrequestTypeInputData[i], ExtentColor.ORANGE));
				checkForPageLoad(driver);
				scrollPageDown(driver);
				scrollPageToElement(driver, requestType_label);
				Thread.sleep(1000);
				requestType.click();
				checkForPageLoad(driver);
				requestTypeInput.sendKeys(splitrequestTypeInputData[i]);
				Thread.sleep(1000);
				requestTypeInput.sendKeys(Keys.ENTER);
				String actualFileShareText = "File Share";
				String expectedFileShareText = fileShareText.getText().trim();
				if (isElementPresent(fileShare)) {
					test.get().log(Status.PASS, MarkupHelper.createLabel(
							"Delivery Method is displayed as: " + expectedFileShareText, ExtentColor.GREEN));
					System.out.println("Delivery Method is displayed as: " + expectedFileShareText);
				} else {
					test.get().log(Status.FAIL,
							MarkupHelper.createLabel(
									"Instead of File Share Delivery Method is displayed as: " + expectedFileShareText,
									ExtentColor.RED));
				}
				if (actualFileShareText.equals(expectedFileShareText.split("\\r?\\n")[0])) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel(
									"Document Type Field is selected with value:  " + splitrequestTypeInputData[i],
									ExtentColor.GREEN));
					System.out.println("Document Type Field is Selected with value:  " + splitrequestTypeInputData[i]);
				} else {
					test.get().log(Status.FAIL,
							MarkupHelper.createLabel(
									"Document Type Field is not Selected with value:" + splitrequestTypeInputData[i],
									ExtentColor.RED));
				}

				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				simpleDateFormat.setTimeZone(TimeZone.getTimeZone("PST"));
				String currentDate = simpleDateFormat.format(new Date());
				String actualDateTime = dateTime.getAttribute("value").trim().split(" ")[0];
				Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(currentDate);
				System.out.println("Current Date is  - " + currentDate);
				Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(actualDateTime);
				int workingDaysDifference = getWorkingDaysBetweenTwoDates(startDate, endDate, true);

				// String expectedDateTime = compareTime(1);
				if (workingDaysDifference == 2) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel(
									"Date and Time needed field is displayed with value: " + actualDateTime,
									ExtentColor.GREEN));
					System.out.println("Date and Time needed field is with value:  " + actualDateTime);
				} else {
					test.get().log(Status.FAIL, MarkupHelper.createLabel(
							"Date and Time needed field is displayed with value:" + actualDateTime, ExtentColor.RED));
					logFailure("Difference in Working Days is  - " + workingDaysDifference);
				}
			}

			else if (splitrequestTypeInputData[i].equalsIgnoreCase("Original File")) {
				test.get().log(Status.INFO, MarkupHelper
						.createLabel("Request Type is - " + splitrequestTypeInputData[i], ExtentColor.ORANGE));
				scrollPageDown(driver);
				Thread.sleep(2000);
				requestType.click();
				requestTypeInput.sendKeys(splitrequestTypeInputData[i]);
				Thread.sleep(2000);
				requestTypeInput.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				if (deliverymethodastrix.isDisplayed()) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel("Delivery method is displayed as Mandatory for the selection: "
									+ splitrequestTypeInputData[i], ExtentColor.GREEN));
					System.out.println("Delivery method is displayed as Mandatory for the selection: "
							+ splitrequestTypeInputData[i]);
				} else {
					test.get().log(Status.FAIL,
							MarkupHelper.createLabel("Delivery method is not displayed as Mandatory for the selection: "
									+ splitrequestTypeInputData[i], ExtentColor.RED));
				}

				deliverymethodDropDown.click();

				List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@id, 'select2-results')]/li"));
				list.clear();
				for (int j = 0; j < options.size(); j++) {
					applicationdata.add(options.get(j).getText().trim());
				}

				if (isElementPresent(options.get(0))) {
					options.get(0).click();
				}

				if (options.size() == splitdeliveryMethodOptions.length) {
					logInfo("Actual Number of Delivery Methods matches with the expected number  - " + options.size());
					compareTwoList(inputdata, applicationdata);

					logSuccess("Expected Count - " + splitdeliveryMethodOptions.length);
					logSuccess("Actual Count - " + options.size());
				} else {
					logFailure("Actual Number of Delivery Methods does not matches with the expected number  - "
							+ options.size());
					compareTwoList(inputdata, applicationdata);

					logFailure("Expected Count - " + splitdeliveryMethodOptions.length);
					logFailure("Actual Count - " + options.size());

				}

				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				simpleDateFormat.setTimeZone(TimeZone.getTimeZone("PST"));
				String currentDate = simpleDateFormat.format(new Date());
				Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(currentDate);

				String actualDateTime2 = dateTime.getAttribute("value").trim().split(" ")[0];
				Date endDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(actualDateTime2);
				int workingDaysDifference = getWorkingDaysBetweenTwoDates(startDate, endDate1, true);

				// String expectedDateTime2 = compareTime(1);
				if (workingDaysDifference == 2) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel(
									"Date and Time Needed field is displayed with value: " + actualDateTime2,
									ExtentColor.GREEN));
					System.out.println("Date and Time Needed field is with value:  " + actualDateTime2);
				} else {
					test.get().log(Status.FAIL, MarkupHelper.createLabel(
							"Date and Time Needed is displayed with value:" + actualDateTime2, ExtentColor.RED));
					logFailure("Difference in Working Days is  - " + workingDaysDifference);
				}

				String edrDateActual = expDocumentReturnDate.getAttribute("value").trim();
				Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(edrDateActual);
				workingDaysDifference = getWorkingDaysBetweenTwoDates(endDate1, endDate, false);
				// String edrDateExpected = compareTime(8);
				if (workingDaysDifference == 5) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel(
									"Expected Document Return Date is displayed with the value: " + edrDateActual,
									ExtentColor.GREEN));
					System.out.println("Expected Document Return Date is displayed with the value: " + edrDateActual);
				} else {
					test.get().log(Status.FAIL,
							MarkupHelper.createLabel(
									"Expected Document Return Date is displayed with the value: " + edrDateActual,
									ExtentColor.RED));
					logFailure("Difference in Working Days is  - " + workingDaysDifference);
				}

			} else if (splitrequestTypeInputData[i].equalsIgnoreCase("Original Document"))

			{
				test.get().log(Status.INFO, MarkupHelper
						.createLabel("Request Type is - " + splitrequestTypeInputData[i], ExtentColor.ORANGE));
				Thread.sleep(2000);
				requestType.click();
				requestTypeInput.sendKeys(splitrequestTypeInputData[i]);
				Thread.sleep(2000);
				requestTypeInput.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				if (deliverymethodastrix.isDisplayed()) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel("Delivery method is displayed as mandatory for the selection: "
									+ splitrequestTypeInputData[i], ExtentColor.GREEN));
					System.out.println("Astrix is displayed for Delivery method for the selection: "
							+ splitrequestTypeInputData[i]);
				} else {
					test.get().log(Status.FAIL,
							MarkupHelper.createLabel("Delivery method is displayed as mandatory for the selection: "
									+ splitrequestTypeInputData[i], ExtentColor.RED));
				}

				deliverymethodDropDown.click();
				List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@id, 'select2-results')]/li"));
				list.clear();

				for (int j = 0; j < options.size(); j++) {
					applicationdata.add(options.get(j).getText().trim());
				}
				if (isElementPresent(options.get(0))) {
					options.get(0).click();
				}

				if (options.size() == splitdeliveryMethodOptions.length) {
					logInfo("Actual Number of Delivery Methods matches with the expected number  - " + options.size());
					compareTwoList(inputdata, applicationdata);

					logSuccess("Expected Count - " + splitdeliveryMethodOptions.length);
					logSuccess("Actual Count - " + options.size());

				} else {
					logFailure("Actual Number of Delivery Methods does not matches with the expected number  - "
							+ options.size());
					compareTwoList(inputdata, applicationdata);

					logFailure("Expected Count - " + splitdeliveryMethodOptions.length);
					logFailure("Actual Count - " + options.size());

				}

				try {
					boolean edrDateActual = expDocumentReturnDate.isDisplayed();
					Assert.assertTrue(edrDateActual);
					test.get().log(Status.PASS,
							MarkupHelper.createLabel(
									"Expected Document Return Date is displayed for: " + splitrequestTypeInputData[i],
									ExtentColor.GREEN));
					System.out
							.println("Expected Document Return Date is displayed for: " + splitrequestTypeInputData[i]);
				} catch (Exception e) {
					test.get().log(Status.FAIL, MarkupHelper.createLabel(
							"Expected Document Return Date is not displayed for: " + splitrequestTypeInputData[i],
							ExtentColor.RED));
				}
				String actualDateTime2 = dateTime.getAttribute("value").trim().split(" ")[0];
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				simpleDateFormat.setTimeZone(TimeZone.getTimeZone("PST"));
				String currentDate = simpleDateFormat.format(new Date());

				Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(currentDate);
				Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(actualDateTime2);
				int workingDaysDifference = getWorkingDaysBetweenTwoDates(startDate, endDate, true);
				// String edrDateExpected = compareTime(8);
				if (workingDaysDifference == 2) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel(
									"Date and Time needed field is displayed with value: " + actualDateTime2,
									ExtentColor.GREEN));
					System.out.println("Date and Type needed field is with value:  " + actualDateTime2);
				} else {
					test.get().log(Status.FAIL,
							MarkupHelper.createLabel(
									"Date and Type needed field is not displayed with value:" + actualDateTime2,
									ExtentColor.RED));
					logFailure("Difference in Working Days is  - " + workingDaysDifference);
				}
			}
		}

	}

	public void fileDeliveryInformation(String requestTypeInputData, String deliveryMethodOptions)
			throws InterruptedException, IOException {
		String[] splitrequestTypeInputData = requestTypeInputData.split(",");
		String[] splitdeliveryMethodOptions = deliveryMethodOptions.split(",");

		scrollPageDown(driver);
		requestType.click();
		Thread.sleep(2000);
		for (int i = 0; i < splitrequestTypeInputData.length; i++) {
			if (splitrequestTypeInputData[i].equals("Original Document")) {
				requestTypeInput.sendKeys(splitrequestTypeInputData[i]);
				Thread.sleep(2000);
				requestTypeInput.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
			}
		}
		deliverymethod.click();
		deliverymethodoptionsselect.click();
		for (int j = 0; j < splitdeliveryMethodOptions.length; j++) {
			if (splitdeliveryMethodOptions[j].equals("Deliver to Payroll")) {
				deliverymethodoptionsselect.sendKeys(splitdeliveryMethodOptions[j]);
				deliverymethodoptionsselect.sendKeys(Keys.ENTER);
			}
		}
		/*
		 * for (int i = 0; i < splitbillToMyCourierAccount.length; i++) {
		 * billInMyCourier.clear();
		 * billInMyCourier.sendKeys(splitbillToMyCourierAccount[i]);
		 * billInMyCourier.sendKeys(Keys.TAB);
		 * 
		 * if (!StringUtils.isNumeric(splitbillToMyCourierAccount[i]) ||
		 * splitbillToMyCourierAccount[i].length() < 5) {
		 * 
		 * Alert alert = driver.switchTo().alert(); String billtomycourieralert
		 * = alert.getText().trim(); alert.accept(); if (billtomycourieralert.
		 * contains("please enter only digits and min length should be 5" )) {
		 * logSuccess("Alert is displayed when invalid data is entered in Bill to My Costcenter field:"
		 * + splitbillToMyCourierAccount[i]); System.out.
		 * println("Alert is displayed when invalid data is entered in Bill to My Costcenter field:"
		 * + splitbillToMyCourierAccount[i]);
		 * 
		 * if (billInMyCourierError.isDisplayed()) {
		 * billInMyCourierError.getText().trim().
		 * equals("please enter only digits and min length should be 5");
		 * test.get().log(Status.PASS, MarkupHelper.createLabel(
		 * "Error is displayed when invalid data entered: " +
		 * splitbillToMyCourierAccount[i], ExtentColor.GREEN));
		 * System.out.println( "Error is displayed when invalid data entered:  "
		 * + splitbillToMyCourierAccount[i]);
		 * 
		 * } else { test.get().log(Status.FAIL, MarkupHelper.createLabel(
		 * "Error is not displayed for a invalid data:" +
		 * splitbillToMyCourierAccount[i], ExtentColor.RED)); } } else {
		 * logFailure("Alert is not available when invalid data is entered in Bill to My Costcenter field:"
		 * ); System.out.println("Alert is not available: " +
		 * splitbillToMyCourierAccount[i]); } }else {
		 * System.out.println("Valid data is provided: " +
		 * splitbillToMyCourierAccount[i]); } }
		 * deliveryAddressInput.sendKeys(deliveryAddress);
		 */
		if (timeZone.isDisplayed() && timeZoneDisabled.isDisplayed()) {

			logSuccess("Time zone is displayed as US/Pacific and disabled ");
			System.out.println("Time zone is displayed as US/Pacific and disabled ");

		} else {
			logFailure("Time zone is not displayed as US/Pacific and not disabled");
			logFailureScreenshot(driver);
		}
	}

	String caseIDNumber = null;

	public String pointofContactRequest(String alternateContactValue) throws IOException, InterruptedException {
		PageFactory.initElements(driver, PayrollRecordsRequestPage.class);
		int count = 0;

		/*
		 * if (mandatIndicatorPOCName.isDisplayed()) {
		 * test.get().log(Status.INFO,
		 * MarkupHelper.createLabel("Name Field field is displayed as mandatory"
		 * , ExtentColor.CYAN)); } else { count++; test.get().log(Status.FAIL,
		 * MarkupHelper.createLabel("Name field is not displayed as mandatory",
		 * ExtentColor.RED)); }
		 */

		if (!pocName.getAttribute("value").trim().isEmpty() && pocName.isEnabled()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"Name Field is Autopopulated with value:  " + pocName.getAttribute("value").trim(),
							ExtentColor.GREEN));
			System.out.println("Name Field is Autopopulated with value:  " + pocName.getAttribute("value").trim());
		} else {
			count++;
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Name Field value is not autopopulated" + twid.getAttribute("value").trim(), ExtentColor.RED));
		}

		if (!pocEmail.getAttribute("value").trim().isEmpty() && pocEmailReadOnly.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"Work Email Field is Autopopulated with value:  " + pocEmail.getAttribute("value").trim(),
							ExtentColor.GREEN));
			System.out
					.println("Work Email Field is Autopopulated with value:  " + pocEmail.getAttribute("value").trim());
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"Work Email Field value is not autopopulated" + pocEmail.getAttribute("value").trim(),
							ExtentColor.RED));
		}

		if (!pocPhoneNumber.getAttribute("value").trim().isEmpty() && pocPhoneNumberReadOnly.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Phone Number Field is Autopopulated with value:  " + pocPhoneNumber.getAttribute("value").trim(),
					ExtentColor.GREEN));
			System.out.println(
					"Phone NumberField is Autopopulated with value:  " + pocPhoneNumber.getAttribute("value").trim());
		} else {
			count++;
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Phone Number Field value is not autopopulated" + pocPhoneNumber.getAttribute("value").trim(),
					ExtentColor.RED));
		}

		alternateContact.sendKeys(alternateContactValue);
		scrollToElement(driver, submitButton);
		submitButton.click();
		checkForPageLoad(driver);
		waitForElement(driver, caseID);
		caseIDNumber = caseID.getText().trim();
		if (caseID.isDisplayed()) {

			test.get().log(Status.PASS, MarkupHelper
					.createLabel("Case id is displayed and its value is:  " + caseIDNumber, ExtentColor.GREEN));
			System.out.println("Case id is displayed and its value is:  " + caseIDNumber);
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Case id is not displayed as:  " + caseIDNumber, ExtentColor.RED));
		}

		if (count == 0) {
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		return caseIDNumber;
	}

	public void viewSubmittedPayrollRequest(String caseId) throws InterruptedException, IOException {
		PageFactory.initElements(driver, PayrollRecordsRequestPage.class);
		filterNavigator.sendKeys("HR Case Management");
		checkForPageLoad(driver);
		openHRCase.click();
		driver.switchTo().frame(0);
		waitForElement(driver, searchHRCase);

		waitForElement(driver, searchDropDown);
		searchDropDown.click();
		Select select = new Select(searchDropDown);
		select.selectByVisibleText("Number");

		searchHRCase.sendKeys(caseId);
		searchHRCase.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		hrcNo.click();

		int count = 0;
		waitForElement(driver, expDocRetDate);
		if (expDocRetDate.getText().isEmpty()) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("Expected Document Return Date is empty for:  " + caseId, ExtentColor.GREEN));
			System.out.println("Expected Document Return Date is empty for: " + caseId);
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Expected Document Return Date is not empty for: " + caseId, ExtentColor.RED));
			count++;
		}
		if (assgnGroup.getAttribute("value").trim().equals("HRSM - Data Administration")) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("Assignment Group is valid with: " + "HRSM - Data Administration", ExtentColor.GREEN));

			logSuccess("Expected Value - " + "HRSM - Data Administration");
			logSuccess("Actual Value - " + assgnGroup.getAttribute("value").trim());

			System.out.println("Assignment Group is valid with: " + "HRSM - Data Administration");
		} else {
			count++;
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Assignment Group is not valid with: " + "HRSM - Data Administration", ExtentColor.RED));

			logFailure("Expected Value - " + "HRSM - Data Administration");
			logFailure("Actual Value - " + assgnGroup.getAttribute("value").trim());

		}

		assgnTo.click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentwindow = it.next();
		String childwindow = it.next();
		driver.switchTo().window(childwindow);
		worker.click();
		driver.switchTo().window(parentwindow);
		driver.switchTo().frame(0);

		Select option = new Select(state);
		WebElement selectedOption = option.getFirstSelectedOption();
		if (selectedOption.getText().trim().equalsIgnoreCase("Open")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("State is valid with status: " + "Open", ExtentColor.GREEN));
			System.out.println("State is valid with status: " + "Open");
			logSuccess("Expected Value - " + "Open");
			logSuccess("Actual Value - " + selectedOption.getText().trim());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("State is not valid with status: " + "Open", ExtentColor.RED));
			logFailure("Expected Value - " + "Open");
			logFailure("Actual Value - " + selectedOption.getText().trim());
			count++;
		}

		if (count == 0) {
			logSuccessScreenshot(driver);
		} else {
			logFailureScreenshot(driver);
		}
		Actions a = new Actions(driver);
		// Thread.sleep(1000);
		a.contextClick(header).build().perform();
		a.click(headerSave).build().perform();
	}

	/****************************************************************************************************************/
	public void viewSubmittedPayrollRequest1(String caseID) throws InterruptedException {
		PageFactory.initElements(driver, PayrollRecordsRequestPage.class);
		filterNavigator.sendKeys("HR Case");
		checkForPageLoad(driver);
		openHRCase.click();
		driver.switchTo().frame(0);

		Select select = new Select(searchHRCaseDropDown);
		select.selectByVisibleText("Number");

		// searchHRCase.sendKeys(CompletingFileRequestForm.caseID);
		searchHRCaseTextBox.sendKeys(caseID);
		searchHRCaseTextBox.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		hrcNo.click();
	}

	/*
	 * public void viewSubmittedPayrollRequest2() throws InterruptedException {
	 * PageFactory.initElements(driver, PayrollRecordsRequestPage.class); if
	 * (expDocRetDate.getText().equals(null)) { test.get().log(Status.PASS,
	 * MarkupHelper.createLabel( "Expected Document Return Date is empty for:  "
	 * + CompletingFileRequestForm.caseID, ExtentColor.GREEN));
	 * 
	 * logSuccess("Expected Value - " + "null"); logSuccess("Actual Value - " +
	 * expDocRetDate.getText().trim());
	 * 
	 * System.out.println("Expected Document Return Date is empty for: " +
	 * CompletingFileRequestForm.caseID); } else { test.get().log(Status.FAIL,
	 * MarkupHelper.createLabel(
	 * "Expected Document Return Date is not empty for: " +
	 * CompletingFileRequestForm.caseID, ExtentColor.RED));
	 * 
	 * logFailure("Expected Value - " + "null"); logFailure("Actual Value - " +
	 * expDocRetDate.getText().trim());
	 * 
	 * } if
	 * (assgnGroup.getAttribute("value").trim().equals("HRSM - Administration"))
	 * { test.get().log(Status.PASS, MarkupHelper
	 * .createLabel("Assignment Group is valid with: " +
	 * "HRSM - Administration", ExtentColor.GREEN));
	 * 
	 * logSuccess("Expected Value - " + "HRSM - Administration");
	 * logSuccess("Actual Value - " + assgnGroup.getAttribute("value").trim());
	 * 
	 * System.out.println("Assignment Group is valid with: " +
	 * "HRSM - Administration"); } else { test.get().log(Status.FAIL,
	 * MarkupHelper .createLabel("Assignment Group is not valid with: " +
	 * "HRSM - Administration", ExtentColor.RED));
	 * 
	 * logFailure("Expected Value - " + "HRSM - Administration");
	 * logFailure("Actual Value - " + assgnGroup.getAttribute("value").trim());
	 * } assgnTo.click(); Set<String> windows = driver.getWindowHandles();
	 * Iterator<String> it = windows.iterator(); String parentwindow =
	 * it.next(); String childwindow = it.next();
	 * driver.switchTo().window(childwindow); worker.click();
	 * driver.switchTo().window(parentwindow); driver.switchTo().frame(0);
	 * Select option = new Select(state); WebElement selectedOption =
	 * option.getFirstSelectedOption(); if
	 * (selectedOption.getText().equalsIgnoreCase("Open")) {
	 * test.get().log(Status.PASS,
	 * MarkupHelper.createLabel("State is valid with status: " + "Open",
	 * ExtentColor.GREEN));
	 * 
	 * logSuccess("Expected Value - " + "Open"); logSuccess("Actual Value - " +
	 * selectedOption.getText());
	 * 
	 * System.out.println("State is valid with status: " + "Open"); } else {
	 * test.get().log(Status.FAIL,
	 * MarkupHelper.createLabel("State is not valid with status: " + "Open",
	 * ExtentColor.RED));
	 * 
	 * logFailure("Expected Value - " + "Open"); logFailure("Actual Value - " +
	 * selectedOption.getText()); } Actions a = new Actions(driver);
	 * a.contextClick(header).click(headerSave).build().perform(); }
	 */

	public void reviewingPayrollTask1(String hrAgent, String workNotesInput) throws InterruptedException, IOException {
		PageFactory.initElements(driver, PayrollRecordsRequestPage.class);
		Actions a = new Actions(driver);
		int count = 0;
		if (sendOriginaldoctoReq.isDisplayed()) {
			logInfoScreenshot(driver);
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Task is created to Send File to Requester with description: " + sendOriginaldoctoReq.getText(),
					ExtentColor.GREEN));
			System.out.println(
					"Task is created to Send File to Requester with description: " + sendOriginaldoctoReq.getText());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Task is not created to Send File to Requester with description: " + sendOriginaldoctoReq.getText(),
					ExtentColor.RED));
			count++;
		}

		if (count == 0) {
			logSuccessScreenshot(driver);
		} else {
			logFailureScreenshot(driver);
		}

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hrtNo);
		hrtNo.click();
		checkForPageLoad(driver);
		try {
			assignedToMglass.click();
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> it = windows.iterator();
			String parentWindow = it.next();
			String childWindow = it.next();
			driver.switchTo().window(childWindow);
			waitForElement(driver, assignedToMsearch);
			assignedToMsearch.sendKeys(hrAgent);
			assignedToMsearch.sendKeys(Keys.ENTER);
			checkForPageLoad(driver);
			assignedToMsearchUser.click();
			driver.switchTo().window(parentWindow);
			checkForPageLoad(driver);
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("HR Agent is selected as: " + hrAgent, ExtentColor.GREEN));
		} catch (Exception e) {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("HR Agent is not selected as: " + hrAgent, ExtentColor.RED));
			logFailureScreenshot(driver);
			count++;
		}

		driver.switchTo().frame(0);

		waitForElement(driver, HRState);
		Select s = new Select(HRState);
		s.selectByVisibleText("Resolved");

		try {
			a.contextClick(header).build().perform();
			a.click(headerSave).build().perform();

			if (isElementPresent(workNotesError)) {
				test.get().log(Status.PASS,
						MarkupHelper.createLabel(
								"Right click is done on the grey header bar at the top and then clicked: " + "Save",
								ExtentColor.GREEN));
				logInfo("Error is displayed to Enter the WorkNotes ");
				logInfoScreenshot(driver);
				closeError1.click();
				checkForPageLoad(driver);
			} else {

			}

		} catch (Exception e) {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"Right click is NOT done on the grey header bar at the top and then clicked: " + "Save",
							ExtentColor.RED));
			logFailureScreenshot(driver);
			count++;
		}

		try {
			scrollPageToElement(driver, workNotes);
			workNotes.sendKeys(workNotesInput);
			// Thread.sleep(1000);
			// postButton.click();
			checkForPageLoad(driver);
			// a.contextClick(header).click(headerSave).build().perform();
			a.contextClick(header).build().perform();
			a.click(headerSave).build().perform();
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("Saved successfully with work notes as: " + workNotesInput, ExtentColor.GREEN));
		} catch (Exception e) {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Save is not successful with work notes as: " + workNotesInput, ExtentColor.RED));
			logFailureScreenshot(driver);
		}
		if (isAlertPresent(driver)) {
			driver.switchTo().alert().accept();
		}
		waitForElementToBeClickable(driver, icon);
		scrollToElement(driver, icon);
		icon.click();
		Thread.sleep(1000);
		waitForElement(driver, iconServiceCase);
	//	Thread.sleep(3000);
		if (iconServiceCase.isDisplayed()) {
			PageFactory.initElements(driver, PayrollRecordsRequestPage.class);
			System.out.println("CompletingPayrollRequestForm " + iconServiceCase.getText());
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("HR Case is Opened with header as: " + iconServiceCase.getText(), ExtentColor.GREEN));
			logSuccessScreenshot(driver);
			openRecord.click();
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"HR Case is not Opened with header as: " + iconServiceCase.getText(), ExtentColor.RED));
			logFailureScreenshot(driver);
		}

		if (isAlertPresent(driver)) {
			driver.switchTo().alert().accept();
		}

		waitForElement(driver, taskState);
		scrollPageToElement(driver, taskState);
		String state = taskState.getText();
		System.out.println("................" + state);
		if (state.equals("Resolved")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Task State is displayed as: " + "Resolved", ExtentColor.GREEN));

			logSuccess("Expected Value - " + "Resolved");
			logSuccess("Actual Value - " + state);

			logSuccessScreenshot(driver);
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Task State is displayed as: " + state, ExtentColor.RED));

			logFailure("Expected Value - " + "Resolved");
			logFailure("Actual Value - " + state);

			logFailureScreenshot(driver);
		}
	}

	public void reviewingPayrollTask2(String hrAgent, String workNotesInput) throws InterruptedException, IOException {
		PageFactory.initElements(driver, PayrollRecordsRequestPage.class);
		Actions a = new Actions(driver);
		int count = 0;
		if (OriginaldocReturned.isDisplayed()) {
			logInfoScreenshot(driver);
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Task 2 is created with short description: " + OriginaldocReturned.getText(), ExtentColor.GREEN));
			System.out.println("Task 2 is created with short description: " + OriginaldocReturned.getText());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Task is not created with short description: " + OriginaldocReturned.getText(), ExtentColor.RED));
			count++;
		}

		if (count == 0) {
			logSuccessScreenshot(driver);
		} else {
			logFailureScreenshot(driver);
		}
		scrollPageToElement(driver, OriginaldocReturned);
		checkForPageLoad(driver);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hrt2No);
		hrt2No.click();
		checkForPageLoad(driver);
		try {
			assignedToMglass.click();
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> it = windows.iterator();
			String parentWindow = it.next();
			String childWindow = it.next();
			driver.switchTo().window(childWindow);
			waitForElement(driver, assignedToMsearch);
			assignedToMsearch.sendKeys(hrAgent);
			assignedToMsearch.sendKeys(Keys.ENTER);
			checkForPageLoad(driver);
			assignedToMsearchUser.click();
			driver.switchTo().window(parentWindow);
			checkForPageLoad(driver);
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("HR Agent is selected as: " + hrAgent, ExtentColor.GREEN));
		} catch (Exception e) {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("HR Agent is not selected as: " + hrAgent, ExtentColor.RED));
			logFailureScreenshot(driver);
			count++;
		}

		driver.switchTo().frame(0);

		waitForElement(driver, HRState);
		Select s = new Select(HRState);
		s.selectByVisibleText("Resolved");

		try {
			a.contextClick(header).build().perform();
			a.click(headerSave).build().perform();

			if (isElementPresent(workNotesError)) {
				test.get().log(Status.PASS,
						MarkupHelper.createLabel(
								"Right click is done on the grey header bar at the top and then clicked: " + "Save",
								ExtentColor.GREEN));
				logInfo("Error is displayed to Enter the WorkNotes ");
				logInfoScreenshot(driver);
				closeError1.click();
				checkForPageLoad(driver);
			} else {

			}

		} catch (Exception e) {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"Right click is NOT done on the grey header bar at the top and then clicked: " + "Save",
							ExtentColor.RED));
			logFailureScreenshot(driver);
			count++;
		}

		try {
			scrollPageToElement(driver, workNotes);
			workNotes.sendKeys(workNotesInput);
			// Thread.sleep(1000);
			// postButton.click();
			checkForPageLoad(driver);
			// a.contextClick(header).click(headerSave).build().perform();
			a.contextClick(header).build().perform();
			a.click(headerSave).build().perform();
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("Saved successfully with work notes as: " + workNotesInput, ExtentColor.GREEN));
		} catch (Exception e) {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Save is not successful with work notes as: " + workNotesInput, ExtentColor.RED));
			logFailureScreenshot(driver);
		}
		if (isAlertPresent(driver)) {
			driver.switchTo().alert().accept();
		}
		icon.click();
		Thread.sleep(1000);
		waitForElement(driver, iconServiceCase);
		if (iconServiceCase.isDisplayed()) {
			PageFactory.initElements(driver, PayrollRecordsRequestPage.class);
			System.out.println("CompletingPayrollRequestForm " + iconServiceCase.getText());
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("HR Case is Opened with header as: " + iconServiceCase.getText(), ExtentColor.GREEN));
			logSuccessScreenshot(driver);
			openRecord.click();
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"HR Case is not Opened with header as: " + iconServiceCase.getText(), ExtentColor.RED));
			logFailureScreenshot(driver);
		}

		if (isAlertPresent(driver)) {
			driver.switchTo().alert().accept();
		}

		waitForElement(driver, taskState);
		String state2 = task2State.getText();
		System.out.println("................" + state2);
		if (state2.equals("Resolved")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Task State is displayed as: " + "Resolved", ExtentColor.GREEN));

			logSuccess("Expected Value - " + "Resolved");
			logSuccess("Actual Value - " + state2);

			logSuccessScreenshot(driver);
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Task State is displayed as: " + state, ExtentColor.RED));

			logFailure("Expected Value - " + "Resolved");
			logFailure("Actual Value - " + state);

			logFailureScreenshot(driver);
		}
		scrollToElement(driver, state);
		Select option = new Select(state);
		WebElement selectedOption = option.getFirstSelectedOption();
		if (selectedOption.getText().trim().equalsIgnoreCase("Resolved")) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("HR Case State is: " + "Resolved", ExtentColor.GREEN));
			System.out.println("HR Case State is: " + "Resolved");
			logSuccess("Expected Value - " + "Resolved");
			logSuccess("Actual Value - " + selectedOption.getText().trim());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("HR Case State is not:  " + "Resolved", ExtentColor.RED));
			logFailure("Expected Value - " + "Resolved");
			logFailure("Actual Value - " + selectedOption.getText().trim());
			// count++;
		}
	}

}
