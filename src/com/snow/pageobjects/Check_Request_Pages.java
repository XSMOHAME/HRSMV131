package com.snow.pageobjects;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
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

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.snow.base.ReusableLibrary;

public class Check_Request_Pages extends ReusableLibrary {
	public WebDriver driver;
	String checkRequestCaseId = null;

	public Check_Request_Pages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// -------------------SelectEmployeeName Validation----------------
	@FindBy(xpath = "//*[@id='s2id_sp_formfield_Select_Employee1']/a")
	public WebElement ch_selectemployee;
	@FindBy(xpath = "//*[@id='select2-drop']/div/input")
	public WebElement ch_employeeName;
	@FindBy(id = "sp_formfield_TWID1")
	public WebElement ch_TWID;
	@FindBy(id = "sp_formfield_HR_Representative")
	public WebElement ch_HRRepresentative;
	@FindBy(id = "sp_formfield_Business_Unit_Name")
	public WebElement ch_BusinessUnitName;
	@FindBy(id = "sp_formfield_Cost_Center_Code")
	public WebElement ch_CostCenterCode;
	@FindBy(id = "sp_formfield_Cost_Center_Name")
	public WebElement ch_CostCenterName;

	// --------------Payment Type--------------------------------------
	@FindBy(xpath = "//input[@id='s2id_autogen5_search']")
	public WebElement ch_enterPaymentType;
	@FindBy(xpath = "//div[@id='select2-drop']/div/following::ul/li[6]/div")
	public WebElement ch_employeeoption;

	@FindBy(xpath = "//input[@id='sp_formfield_GL_Number']")
	public WebElement ch_glnumber;

	// @FindBy(css = "#s2id_sp_formfield_Payment_Type > a")
	// public WebElement ch_paymenttype;
	// --------------------Final Pay----------------------------------
	@FindBy(xpath = "//*[@id='s2id_sp_formfield_Payment_Type']/a")
	public WebElement ch_paymenttype;
	@FindBy(xpath = "//input[@id='sp_formfield_Final_Pay_End_Date']")
	public WebElement ch_final_pay_endDate;
	@FindBy(xpath = "//span[contains(text(),'Please attach a timesheet, if applicable.')]")
	public WebElement ch_final_pay_helpText;
	@FindBy(xpath = "//label[@for='sp_formfield_Final_Pay_End_Date']/span")
	public WebElement ch_final_pay_endDate_mandatory;
	@FindBy(xpath = "//input[@id='sp_formfield_Check_Amount']")
	public WebElement ch_checkamount;
	@FindBy(xpath = "//label[@for='sp_formfield_Check_Amount']/span")
	public WebElement ch_mandatory_checkamount;
	@FindBy(xpath = "//div[@id='s2id_sp_formfield_Termination_Type']/a")
	public WebElement ch_final_pay_TerminationType;
	@FindBy(xpath = "//input[@id='s2id_autogen6_search']")
	public WebElement ch_enter_TerminationType;
	@FindBy(xpath = "//label[@for='sp_formfield_Termination_Type']/span")
	public WebElement ch_final_pay_TerminationType_mandatory;
	@FindBy(xpath = "//input[@id='sp_formfield_Unused_Floating_Holiday']")
	public WebElement ch_Unused_Floating_Holiday;

	@FindBy(xpath = "(//div[@class = 'datepicker-days']//thead/tr/th[@class = 'prev'])[1]")
	public WebElement calendarPrev;

	@FindBy(xpath = "//input[@id = 'sp_formfield_Check_Needed']/parent::div/span/button")
	public WebElement calendarIcon;

	@FindBy(xpath = "//td[contains(@class, 'today')]/div/parent::td/parent::tr/following-sibling::tr[1]/td[2]")
	public WebElement ifFridayOrSaturday;

	@FindBy(xpath = "(//td[contains(@class, 'today')]/div/ancestor::td/following-sibling::td[1])[1]")
	public WebElement nextDay;

	@FindBy(xpath = "//li[@class='picker-switch accordion-toggle']//a[@data-action = 'toggleDateTimePicker']")
	public WebElement clockCalendarToggleIcon;

	@FindBy(xpath = "//a[@data-action = 'decrementHours']")
	public WebElement decreaseHours;

	@FindBy(xpath = "//a[@data-action = 'incrementHours']")
	public WebElement increaseHours;

	@FindBy(xpath = "//a[@data-action = 'incrementMinutes']")
	public WebElement increaseMinutes;

	@FindBy(xpath = "//span[@data-action = 'showHours']")
	public WebElement getHours;

	@FindBy(xpath = "//input[@id = 'sp_formfield_Check_Needed']")
	public WebElement calendarInput;

	@FindBy(xpath = "(//td[@class = 'day old'])[1]")
	public WebElement pastDay;

	@FindBy(xpath = "(//td[contains(@class, 'today')])[1]")
	public WebElement toDay;

	@FindBy(xpath = "(//td[contains(@class, 'today')]/descendant::div)[1]")
	public WebElement toDayText;

	@FindBy(xpath = "//input[@id='sp_formfield_Unused_Vacation']")
	public WebElement ch_Unused_VacationPTO;
	@FindBy(xpath = "//ul[@id='select2-results-6']/li")
	public List<WebElement> ch_finalPay_TerminationDropDown;
	@FindBy(xpath = "//span[@id='select2-chosen-10']")
	public WebElement ch_Currency_Type;
	
	@FindBy(xpath = "//label[@class='field-label ng-binding ng-scope'][contains(text(),'Payment Delivery Method')]")
	public WebElement label_PaymentDelivery_Method;
	
	@FindBy(xpath = "//div[@id='s2id_sp_formfield_Payment_Delivery_Method']/a")
	public WebElement ch_PaymentDelivery_Method;
	
	
	@FindBy(xpath = "//input[@id='s2id_autogen3_search']")
	public WebElement ch_PaymentDelivery_Dropdown;
	@FindBy(xpath = "//ul[@id='select2-results-3']/li")
	public List<WebElement> ch_PaymentDelivery_List;
	@FindBy(xpath = "(//*[@for='sp_formfield_Termination_Type'])[1]")
	public WebElement xpTermination;

	@FindBy(xpath = "//*[@id='sp_formfield_Additional_Information']")
	public WebElement additionalInfoBox;

	@FindBy(xpath = "//legend[contains(text(),'Point of Contact for Request')]")
	public WebElement label_pointofcontact;
	
	@FindBy(xpath = "//label[contains(text(),'Additional Information')]")
	public WebElement label_additional_info;
	
	// ---------------------------InLieu Pay-------------------------------
	@FindBy(xpath = "//input[@id='sp_formfield_Lieu_Notice_Duration']")
	public WebElement ch_Lieu_Duration;
	@FindBy(xpath = "//label[@for='sp_formfield_Lieu_Notice_Duration']/span")
	public WebElement ch_Lieu_Duration_Mandatory;
	@FindBy(xpath = "//div[@id='s2id_sp_formfield_Lieu_Notice_Duration_Type']/a")
	public WebElement ch_Lieu_DurationUnit;
	@FindBy(xpath = "//label[@for='sp_formfield_Lieu_Notice_Duration_Type']/span")
	public WebElement ch_Lieu_DurationUnit_Mandatory;
	@FindBy(xpath = "//ul[@id='select2-results-7']/li")
	public List<WebElement> ch_inLieuPayUnitDropdown;

	// ----------------------Retro
	// Payment-----------------------------------------
	@FindBy(xpath = "//input[@id='sp_formfield_Retro_Payment_Effective_Date']")
	public WebElement ch_RetroPayment_EffectiveDate;

	@FindBy(xpath = "//*[@id = 's2id_sp_formfield_Timezone']")
	public WebElement timeZoneBox;

	@FindBy(xpath = "//label[@for='sp_formfield_Retro_Payment_Effective_Date']/span")
	public WebElement ch_RetroPay_EDate_Mandatory;
	@FindBy(xpath = "//div[contains(text(),'Date selected must be in the past.')]")
	public WebElement date_Error_Message;

	// --------------Severance Pay-----------------------------------------
	@FindBy(xpath = "//div[@id='s2id_sp_formfield_Severance_Type']/a")
	public WebElement ch_Severance_Type;
	@FindBy(xpath = "//label[@for='sp_formfield_Severance_Type']/span")
	public WebElement ch_Severance_Type_Mandatory;
	@FindBy(xpath = "//ul[@id='select2-results-8']/li")
	public List<WebElement> ch_Severance_Type_Dropdown;

	// -------------Point Of Contact--------------------

	@FindBy(id = "sp_formfield_u_name")
	public WebElement ch_Name;
	@FindBy(id = "sp_formfield_u_workemail")
	public WebElement ch_Work_Email;
	@FindBy(id = "sp_formfield_phone_number")
	public WebElement ch_Phonenumber;
	@FindBy(id = "sp_formfield_alternate_contact")
	public WebElement ch_AltPhoneNumber;
	@FindBy(xpath = "//div[@class='text-right ng-scope']/button")
	public WebElement ch_SubmitBt;

	@FindBy(css = "#select2-drop")
	public List<WebElement> ch_li_paymenttype;
	@FindBy(xpath = "//input[@id='sp_formfield_Check_Needed']")
	public WebElement ch_date_Time;
	@FindBy(xpath = "//div[@class='title-info ng-binding']")
	public WebElement ch_caseID;

	@FindBy(css = "#Currency_Type > div:nth-child(1) > span:nth-child(2) > div:nth-child(2)")
	public WebElement ch_currencytype;
	@FindBy(css = "#Payment_Delivery_Method > div:nth-child(1) > span:nth-child(2) > div:nth-child(2) > a:nth-child(1)")
	public WebElement ch_deliverymethod;

	// -----------------------Case ITIL Virew ---------------------------

	@FindBy(xpath = "//input[@id='filter']")
	public WebElement leftsearch;
	@FindBy(xpath = "//ul[contains(@aria-label, 'All HR Cases')]/li/div/a/div/div[text() = 'Open']")
	public WebElement open;

	@FindBy(xpath = "//input[contains(@id, 'sys_readonly.sn_hr_core_case_payroll.subject_person_hr_profile.ssn')]")
	public WebElement pinBox;

	@FindBy(xpath = "//a[@data-original-title='HR Cases Context Menu']/h2")
	public WebElement hr_Cases;
	@FindBy(xpath = "//*[@class = 'form-control' and contains(@placeholder, 'Search')]")
	public WebElement searchHRCase;
	@FindBy(xpath = "(//input[@id='sn_hr_core_case_table_header_search_control'])[1]")
	public WebElement xpNumberSearch;

	@FindBy(xpath = "//input[contains(@id, '_text')]")
	public WebElement numberSearchTextbox;

	@FindBy(xpath = "(//tr[@id='hdr_sn_hr_core_case'])[1]/th[2]")
	public WebElement xpSearchIcon;
	@FindBy(xpath = "(//a[@class='linked formlink'])[1]")
	public WebElement hr_link_number;
	@FindBy(xpath = "//select[@id='sn_hr_core_case_payroll.state']")
	public WebElement hr_state;
	@FindBy(xpath = ".//*[@id='sn_hr_core_case_payroll.priority']")
	public WebElement hr_priority;
	@FindBy(xpath = ".//*[@id='sys_display.sn_hr_core_case_payroll.hr_service']")
	public WebElement hr_service;
	@FindBy(xpath = "//input[@id='sys_display.sn_hr_core_case_payroll.assignment_group']")
	public WebElement assignment_group;
	@FindBy(xpath = "//input[@id='sys_display.sn_hr_core_case_payroll.assigned_to']")
	public WebElement assign_to;
	@FindBy(xpath = "//input[@id='sn_hr_core_case_payroll.u_date_and_time_the_check_is_needed']")
	public WebElement dateAndTimeCheck;
	@FindBy(xpath = "//button[@id='lookup.sn_hr_core_case_payroll.assigned_to']")
	public WebElement assignTo_search;
	@FindBy(xpath = "//select[contains(@id,'_select')]")
	public WebElement searchCriteria;
	@FindBy(xpath = "//select[@class='form-control default-focus-outline']")
	public WebElement searchNumberDropDown;

	@FindBy(xpath = "//input[contains(@id,'_text')]")
	public WebElement searchTextBox;

	@FindBy(xpath = "(//*[@id='sys_user_table_header_search_control'])[1]")
	public WebElement nameSearchTextBox;
	@FindBy(xpath = "//*[@id='activity-stream-work_notes-textarea']")
	public WebElement workNotes;

	@FindBy(xpath = "//*[@id='fieldmsg-singleinput-7']/li")
	public WebElement workNotesError;

	@FindBy(xpath = "//*[contains(@id,'header') and contains(@class,'section_header_div_no_scroll form_title')]")
	public WebElement header;

	@FindBy(xpath = "//*[@role='menuitem' and @title = 'Save record and remain here']")
	public WebElement saveOption;
	@FindBy(xpath = "//span[text()='Resolved State']")
	public WebElement confirmWorkNotes;

	@FindBy(xpath = "//select[@id='sn_hr_core_case_payroll.contact_type']")
	public WebElement payroll_source;

	@FindBy(xpath = ".//*[@id='sys_display.sn_hr_core_case_payroll.opened_for']")
	public WebElement payroll_opened_for;

	@FindBy(xpath = "//input[@id='sn_hr_core_case_payroll.opened_by_label']")
	public WebElement payroll_opened_by;

	@FindBy(xpath = "//input[@id='sys_display.sn_hr_core_case_payroll.subject_person']")
	public WebElement payroll_subject_person;

	@FindBy(xpath = "//span[@class='navbar_ui_actions']//button[@id='sysverb_update']")
	public WebElement update;
	@FindBy(id = "sp_formfield_Check_Needed")
	public WebElement dateTime;
	@FindBy(xpath = "//div[contains(text(),'Please select a time 2 hrs after current date')]")
	public WebElement dateError;

	/**
	 * This Method Validate the Active Worker Employee
	 * 
	 * @param
	 * @throws Exception
	 */

	public void validateSelectEmployeeActiveWorker(String Name) throws Exception {
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, ch_selectemployee);
		ch_selectemployee.click();
		ch_employeeName.clear();
		ch_employeeName.sendKeys(Name);
		waitForAction(driver);
		checkForPageLoad(driver);
		ch_employeeName.sendKeys(Keys.TAB);
		waitForAction(driver);
		/*
		 * Robot r=new Robot(); r.keyPress(KeyEvent.VK_ENTER);
		 * r.keyRelease(KeyEvent.VK_ENTER);
		 */
		logInfo("---------------------Active User Info--------------");
		test.get().log(Status.PASS, MarkupHelper
				.createLabel("**Successfully Enter Active Worker The Employee Name is**" + Name, ExtentColor.GREEN));
		if (!ch_TWID.getAttribute("value").isEmpty()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"**TWID is AutoPopulated for Active worker And Values is**" + ch_TWID.getAttribute("value"),
							ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("TWID is AutoPopulated for Active worker and value is" + ch_TWID.getAttribute("value"));

		} else {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("**TWID is Not AutoPopulated for Active worker.**", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("The TWID value is not autopopulated for Active worker");
		}
		if (!ch_HRRepresentative.getAttribute("value").isEmpty()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**HR Representative is Autopopulated for Active worker and value is**"
							+ ch_HRRepresentative.getAttribute("value"), ExtentColor.GREEN));

			System.out.println("HR Representative is Autopopulated for Active worker and value is**"
					+ ch_HRRepresentative.getAttribute("value"));
		} else {
			test.get().log(Status.INFO, MarkupHelper.createLabel(
					"**HR Representative field is Not AutoPopulated for Active worker.**", ExtentColor.CYAN));

			System.out.println("HR Representative field is Not AutoPopulated for Active worker");
		}
		if (!ch_BusinessUnitName.getAttribute("value").isEmpty()) {

			test.get().log(Status.PASS,
					MarkupHelper
							.createLabel("**Business Unit Name is Autopopulated for Active worker and the value is**"
									+ ch_BusinessUnitName.getAttribute("value"), ExtentColor.GREEN));

			System.out.println("Business Unit Name is Autopopulated for Active worker and the value is**"
					+ ch_BusinessUnitName.getAttribute("value"));
		} else {
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("**Business Unit Name is Not Autopopulated for Active worker**", ExtentColor.CYAN));

			System.out.println("Business Unit Name is Not Autopopulated for Active worker");
		}
		if (!ch_CostCenterCode.getAttribute("value").isEmpty()) {
			test.get().log(Status.PASS,
					MarkupHelper
							.createLabel("**The Cost Center Code is Autopopulated for Active worker And the value is**"
									+ ch_CostCenterCode.getAttribute("value"), ExtentColor.GREEN));

			System.out.println("The Cost Center Code is Autopopulated for Active worker And the value is**"
					+ ch_CostCenterCode.getAttribute("value"));
		} else {
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("**The Cost Center Code is Not Autopopulated for Active worker**", ExtentColor.CYAN));

			System.out.println("The Cost Center Code is Not Autopopulated for Active worker");
		}
		if (!ch_CostCenterName.getAttribute("value").isEmpty()) {
			test.get().log(Status.PASS,
					MarkupHelper
							.createLabel("**The Cost Center Name is Autopopulated for Active worker And the Value is**"
									+ ch_CostCenterName.getAttribute("value"), ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("The Cost Center Name is Autopopulated for Active workerAnd the Value is**"
					+ ch_CostCenterName.getAttribute("value"));
		} else {
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("**The Cost Center Name is Not Autopopulated for Active worker**", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("The Cost Center Name is Not Autopopulated for Active worker");
		}
	}

	/**
	 * This method Validate the In Active Worker Employee
	 * 
	 * @param Name
	 * @throws Exception
	 */
	public void validateSelectEmployeeInActiveWorker(String Name) throws Exception {
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, ch_selectemployee);
		ch_selectemployee.click();
		// ch_selectemployee.clear();
		ch_employeeName.sendKeys(Name);
		waitForAction(driver);
		checkForPageLoad(driver);
		ch_employeeName.sendKeys(Keys.TAB);
		checkForPageLoad(driver);
		logInfo("---------------------InActive User Info--------------");
		test.get().log(Status.PASS,
				MarkupHelper.createLabel("**Successfully Enter In Active Worker is**" + Name, ExtentColor.GREEN));
		if (!ch_TWID.getAttribute("value").isEmpty()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"**TWID is AutoPopulated for InActiveWorker And Values is**" + ch_TWID.getAttribute("value"),
					ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("TWID is AutoPopulated for InActiveWorker and value is" + ch_TWID.getAttribute("value"));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**TWID is Not AutoPopulated for InActiveWorker.**", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("The TWID value is not autopopulated for InActiveWorker");
		}
		if (ch_HRRepresentative.getAttribute("value").isEmpty()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"**HR Representative field is Not AutoPopulated for InActiveworker.**", ExtentColor.GREEN));

			System.out.println("HR Representative field is Not AutoPopulated InActiveworker");

		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**HR Representative is Autopopulated InActiveworker and value is**"
							+ ch_HRRepresentative.getAttribute("value"), ExtentColor.RED));

			System.out.println("HR Representative is Autopopulated InActiveworker and value is**"
					+ ch_HRRepresentative.getAttribute("value"));
		}
		if (!ch_BusinessUnitName.getAttribute("value").isEmpty()) {

			test.get().log(Status.PASS,
					MarkupHelper
							.createLabel("**Business Unit Name is Autopopulated for InActiveWorker and the value is**"
									+ ch_BusinessUnitName.getAttribute("value"), ExtentColor.GREEN));

			System.out.println("Business Unit Name is Autopopulated for InActiveWorker and the value is**"
					+ ch_BusinessUnitName.getAttribute("value"));
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("**Business Unit Name is Not Autopopulated for InActive Worker.**", ExtentColor.RED));

			System.out.println("Business Unit Name is Not Autopopulated for InActiveWorker");
		}
		if (ch_CostCenterCode.getAttribute("value").isEmpty()) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("**The Cost Center Code is Not Autopopulated InActiveworker.**", ExtentColor.GREEN));

			System.out.println("The Cost Center Code is Not Autopopulated InActiveworker");

		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**The Cost Center Code is Autopopulated InActiveworker And the value is**"
							+ ch_CostCenterCode.getAttribute("value"), ExtentColor.RED));

			System.out.println("The Cost Center Code is Autopopulated InActiveworker And the value is**"
					+ ch_CostCenterCode.getAttribute("value"));
		}
		if (ch_CostCenterName.getAttribute("value").isEmpty()) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("**The Cost Center Name is Not Autopopulated InActiveworker", ExtentColor.GREEN));

			System.out.println("The Cost Center Name is Not Autopopulated InActiveworker");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"**The Cost Center Name is Autopopulated for InActive Worker And the Value is**"
									+ ch_CostCenterName.getAttribute("value"),
							ExtentColor.RED));

			System.out.println("The Cost Center Name is Autopopulated InActive Worker And the Value is**"
					+ ch_CostCenterName.getAttribute("value"));
		}
	}

	/**
	 * This Method Validate the Payments Types:Commission,Employee Referral,Signing
	 * Bonus
	 * 
	 * @param paymentname
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void paymentType_Validation_Commission(String paymentname) throws IOException, InterruptedException {
		waitForElement(driver, ch_paymenttype);
		ch_paymenttype.click();

		// entering the payment type
		ch_enterPaymentType.sendKeys(paymentname);
		waitForAction(driver);
		ch_enterPaymentType.sendKeys(Keys.TAB);
		checkForPageLoad(driver);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Successfully Enter the PaymentType is**" + paymentname, ExtentColor.GREEN));
		if (ch_checkamount.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**Check Amount field is displayed**", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Check Amount Field is Displayed");
			if (ch_mandatory_checkamount.isDisplayed()) {
				test.get().log(Status.PASS,
						MarkupHelper.createLabel("**Check Amount field is Mandatory**", ExtentColor.GREEN));
				System.out.println("Check Amount Field is Mandatory");
			} else {
				test.get().log(Status.PASS,
						MarkupHelper.createLabel("**Check Amount field is not Mandatory**", ExtentColor.RED));
				System.out.println("Check Amount Field is not Mandatory");
			}
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**Check Amount Field is Not Displayed**", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Check Amount Field is Not Displayed");
		}

	}

	/**
	 * This Method Validates the Payment Type:Final Pay
	 * 
	 * @param paymentname
	 * @param terminationDropdowns
	 * @throws Exception
	 */
	public void paymentType_Validation_Finalpay(String paymentname, String[] terminationDropdowns) throws Exception {

		checkForPageLoad(driver);
//		Actions a = new Actions(driver);
//		a.moveToElement(ch_enterPaymentType).click().build().perform();

		waitForElement(driver, ch_paymenttype);
		ch_paymenttype.click();

		// entering the payment type
		ch_enterPaymentType.sendKeys(paymentname);
		ch_enterPaymentType.sendKeys(Keys.TAB);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Successfully Enter the PaymentType is**" + paymentname, ExtentColor.GREEN));
		checkForPageLoad(driver);
		if (ch_final_pay_endDate.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**Final Pay End Date is Displayed**", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Final Pay End Date is Displayed");
			if (ch_final_pay_endDate_mandatory.isDisplayed()) {
				test.get().log(Status.PASS,
						MarkupHelper.createLabel("**Final Pay End Date is Mandatory Field**", ExtentColor.GREEN));
				System.out.println("Final Pay End Date is Mandatory Field");
			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("**Final Pay End Date is Not Mandatory Field**", ExtentColor.RED));
				System.out.println("Final Pay End Date is Not Mandatory Field");
			}
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**Final Pay End Date is Not Displayed**", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Final Pay End Date is NOT Displayed");
		}
		checkForPageLoad(driver);
		if (ch_final_pay_helpText.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("**The Help Text is Displayed**", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("The Help Text is Displayed");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**The Help Text is Not Displayed**", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("The Help Text is NOT Displayed");
		}
		checkForPageLoad(driver);
		if (ch_final_pay_TerminationType.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**The Termination Type Field is Displayed**", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("The Termination Type Field is Displayed");
			if (ch_final_pay_TerminationType_mandatory.isDisplayed()) {
				test.get().log(Status.PASS,
						MarkupHelper.createLabel("**The Termination Type Field is Mandatory**", ExtentColor.GREEN));
				System.out.println("The Termination Type Field is Mandatory");
			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("**The Termination Type Field is NOT Mandatory**", ExtentColor.RED));
				System.out.println("The Termination Type Field is Not Mandatory");
			}
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**The Termination Type Field is Not Displayed**", ExtentColor.RED));
			System.out.println("The Termination Type Field is Not Displayed");
		}
		waitForElementToBeClickable(driver, ch_final_pay_TerminationType);
		ch_final_pay_TerminationType.click();

		for (int i = 0; i < ch_finalPay_TerminationDropDown.size(); i++) {
			if (ch_finalPay_TerminationDropDown.get(i).getText().equalsIgnoreCase(terminationDropdowns[i])) {
				test.get().log(Status.PASS, MarkupHelper.createLabel("**The Termination Type dropdown is Displayed**"
						+ ch_finalPay_TerminationDropDown.get(i).getText(), ExtentColor.GREEN));
				logSuccess("Actual value-" + ch_finalPay_TerminationDropDown.get(i).getText());
				logSuccess("Expected value-" + terminationDropdowns[i]);
				System.out.println("The Termination Type dropdown is displayed"
						+ ch_finalPay_TerminationDropDown.get(i).getText());
			} else {
				test.get().log(Status.FAIL, MarkupHelper
						.createLabel("**The Termination Type dropdown is Not Displayed**", ExtentColor.RED));
				logFailure("Actual value-" + ch_finalPay_TerminationDropDown.get(i).getText());
				logFailure("Expected value-" + terminationDropdowns[i]);
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("The Termination Type dropdown is Not Displayed"
						+ ch_finalPay_TerminationDropDown.get(i).getText());
			}
			if (ch_finalPay_TerminationDropDown.get(i).getText().equals("-- None --")) {
				ch_finalPay_TerminationDropDown.get(i).click();
			}
		}

		checkForPageLoad(driver);

		if (ch_Unused_Floating_Holiday.isSelected()) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("**The Unused Floating Holiday Check Box is Selected Default**", ExtentColor.GREEN));
			System.out.println("The Unused Floating Holiday Check Box is Selected Default");
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("**The Unused Floating Holiday Check Box is Not Selected Default**", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("The Unused Floating Holiday Check Box is Not Selected Default");
		}
		if (ch_Unused_VacationPTO.isSelected()) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("**The Unused VacationPTO Check Box is Selected Default**", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("The Unuse VacationPTO Check Box is Selected Default");
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("**The Unused VacationPTO Check Box is Not Selected Default**", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("The Unused VacationPTO Check Box is Not Selected Default");
		}

	}

	/**
	 * This Method Validates The Payment Type:InLieu Notice
	 * 
	 * @param paymentname
	 * @param inLieuPayUnitDropdowns
	 * @throws Exception
	 */

	public void paymentType_Validation_InLieuNotice(String paymentname, String[] inLieuPayUnitDropdowns)
			throws Exception {

		checkForPageLoad(driver);
		// scrollPage();
		/*
		 * Actions a = new Actions(driver);
		 * a.moveToElement(ch_enterPaymentType).click().build().perform();
		 */

		ch_paymenttype.click();
		// ch_paymenttype.clear();
		waitForElementToBeClickable(driver, ch_enterPaymentType);
		ch_enterPaymentType.sendKeys(paymentname);
		ch_enterPaymentType.sendKeys(Keys.TAB);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Successfully Enter the PaymentType is**" + paymentname, ExtentColor.CYAN));
		if (ch_Lieu_Duration.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**The Lieu Pay Duration is Displayed**", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("The Lieu Pay Duration is Displayed");
			if (ch_Lieu_Duration_Mandatory.isDisplayed()) {
				test.get().log(Status.PASS,
						MarkupHelper.createLabel("**The Lieu Pay Duration is Mandatory**", ExtentColor.GREEN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("The Lieu Pay Duration is Mandatory");
			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("**The Lieu Pay Duration is Not Mandatory**", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("The Lieu Pay Duration is Not Mandatory");
			}
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**The Lieu Pay Duration is Not Displayed**", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("The Lieu Pay Duration is Not Displayed");
		}
		if (ch_Lieu_DurationUnit.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**The Lieu Pay Duration Unit is Displayed**", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("The Lieu Pay Duration Unit is Displayed");
			if (ch_Lieu_DurationUnit_Mandatory.isDisplayed()) {
				test.get().log(Status.PASS,
						MarkupHelper.createLabel("**The Lieu Pay Duration Unit is Mandatory**", ExtentColor.GREEN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("The Lieu Pay Duration Unit is Mandatory");
			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("**The Lieu Pay Duration Unit is Not Mandatory**", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("The Lieu Pay Duration Unit is Not Mandatory");
			}
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**The Lieu Pay Duration is Not Displayed**", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("The Lieu Pay Duration is Not Displayed");
		}

		ch_Lieu_DurationUnit.click();
		checkForPageLoad(driver);
		for (int i = 0; i < ch_inLieuPayUnitDropdown.size(); i++) {
			if (ch_inLieuPayUnitDropdown.get(i).getText().equalsIgnoreCase(inLieuPayUnitDropdowns[i])) {
				test.get().log(Status.PASS,
						MarkupHelper.createLabel("**The inLieu Pay duration Unit dropdown displayed**"
								+ ch_inLieuPayUnitDropdown.get(i).getText(), ExtentColor.GREEN));
				logSuccess("Actual value-" + ch_inLieuPayUnitDropdown.get(i).getText());
				logSuccess("Expected value-" + inLieuPayUnitDropdowns[i]);
				System.out.println(
						"The inLieu Pay duration Unit dropdown displayed" + ch_inLieuPayUnitDropdown.get(i).getText());
			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel(
								"**The inLieu Pay duration Unit dropdown is Not displayed**" + ch_inLieuPayUnitDropdown,
								ExtentColor.RED));
				logFailure("Actual value-" + ch_inLieuPayUnitDropdown.get(i).getText());
				logFailure("Expected value-" + inLieuPayUnitDropdowns[i]);
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println(
						"The Termination Type dropdown is Not Displayed" + ch_inLieuPayUnitDropdown.get(i).getText());
			}
			if (ch_inLieuPayUnitDropdown.get(i).getText().equals("-- None --")) {
				ch_inLieuPayUnitDropdown.get(i).click();
			}
		}

	}

	/**
	 * This method Validates The Payment Type:Retro Payment
	 * 
	 * @param paymentname
	 * @param pastDate
	 * @param futureDate
	 * @throws Exception
	 */
	public void paymentType_Validation_RetroPayment(String paymentname, String pastDate, String futureDate)
			throws Exception {
		checkForPageLoad(driver);
		scrollPageToElement(driver, ch_CostCenterCode);
		ch_paymenttype.click();
		// ch_paymenttype.clear();
		ch_enterPaymentType.sendKeys(paymentname);
		ch_enterPaymentType.sendKeys(Keys.TAB);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Successfully Enter the PaymentType is**" + paymentname, ExtentColor.CYAN));

		if (ch_RetroPayment_EffectiveDate.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**The Retro Payment Effective Date is Displayed**", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("The Retro Payment Effective Date is Displayed");
			if (ch_RetroPay_EDate_Mandatory.isDisplayed()) {
				test.get().log(Status.PASS, MarkupHelper
						.createLabel("**The Retro Payment Effective Date is Mandatory**", ExtentColor.GREEN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("The Retro Payment Effective Date is Mandatory");
			} else {
				test.get().log(Status.FAIL, MarkupHelper
						.createLabel("**The Retro Payment Effective Date is Not Mandatory**", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("The Retro Payment Effective Date is Not Mandatory");
			}
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**The Retro Payment Effective Date is Not Displayed**", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("The Retro Payment Effective Date is Not Displayed");
		}
		ch_RetroPayment_EffectiveDate.click();
		ch_RetroPayment_EffectiveDate.sendKeys(futureDate, Keys.TAB);
		timeZoneBox.click();
		waitForAction(driver);
		waitForElement(driver, date_Error_Message);
		if (isElementPresent(date_Error_Message)) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"**The Retro Payment Effective Future Date is Not Taken and The date is**" + futureDate,
							ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("The Retro Payment Effective Future Date is Not Taken and The date is**" + futureDate);
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"**The Retro Payment Effective Future Date Taken and The date is**" + futureDate, ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("The Retro Payment Effective Future Date Taken and The date is**" + futureDate);
		}
		waitForElementToBeClickable(driver, ch_RetroPayment_EffectiveDate);
		ch_RetroPayment_EffectiveDate.click();
		ch_RetroPayment_EffectiveDate.clear();
		ch_RetroPayment_EffectiveDate.sendKeys(pastDate, Keys.TAB);
		checkForPageLoad(driver);

		/*
		 * if (isElementPresent(date_Error_Message) == false) {
		 * test.get().log(Status.PASS, MarkupHelper.createLabel(
		 * "**The Retro Payment Effective Past Date Taken and The date is**" + pastDate,
		 * ExtentColor.GREEN)); screenshotPath = getScreenshot(driver,
		 * this.getClass().getName()); test.get().info("Details",
		 * MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		 * System.out.
		 * println("The Retro Payment Effective past Date Taken and The date is**" +
		 * pastDate); } else { test.get().log(Status.FAIL, MarkupHelper.createLabel(
		 * "**The Retro Payment Effective Past Date Not Taken and The date is**" +
		 * pastDate, ExtentColor.RED)); screenshotPath = getScreenshot(driver,
		 * this.getClass().getName()); test.get().info("Details",
		 * MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		 * System.out.println("The Retro Payment Effective Date Taken and The date is**"
		 * + pastDate); }
		 */

		if (!driver.getPageSource().contains("Date selected must be in the past")) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"**The Retro Payment Effective Past Date Taken and The date is**" + pastDate, ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("The Retro Payment Effective past Date Taken and The date is**" + pastDate);
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"**The Retro Payment Effective Past Date Not Taken and The date is**" + pastDate, ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("The Retro Payment Effective Date Taken and The date is**" + pastDate);
		}
		waitForAction(driver);
	}

	/**
	 * This Method Validates The Payment Type:Severance Pay
	 * 
	 * @param paymentname
	 * @param severanceTypeDropdown
	 * @throws Exception
	 */
	public void paymentType_Validation_SeverancePay(String paymentname, String[] severanceTypeDropdown)
			throws Exception {
		scrollToElement(driver, ch_glnumber);
		waitForElementToBeClickable(driver, ch_paymenttype);
		ch_paymenttype.click();
		waitForElementToBeClickable(driver, ch_enterPaymentType);
		ch_enterPaymentType.sendKeys(paymentname);
		ch_enterPaymentType.sendKeys(Keys.TAB);
		checkForPageLoad(driver);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Successfully Enter the PaymentType is**" + paymentname, ExtentColor.CYAN));
		if (isElementPresent(ch_Severance_Type)) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**The Severance Type is Displayed**", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("The Severance Type is Displayed");

			if (ch_Severance_Type_Mandatory.isDisplayed()) {
				test.get().log(Status.PASS,
						MarkupHelper.createLabel("**The Severance Type is Mandatory**", ExtentColor.GREEN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("The Severance Type is Mandatory");
			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("**The Severance Type is Not Mandatory**", ExtentColor.GREEN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("The Severance Type is Not Mandatory");
			}
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**The Severance Type is Not Displayed**", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("The Severance Type is Not Displayed");
		}
		checkForPageLoad(driver);
		ch_Severance_Type.click();
		checkForPageLoad(driver);
		System.out.println(ch_Severance_Type_Dropdown.size());
		for (int i = 0; i < ch_Severance_Type_Dropdown.size(); i++) {
			if (ch_Severance_Type_Dropdown.get(i).getText().equalsIgnoreCase(severanceTypeDropdown[i])) {
				test.get().log(Status.PASS, MarkupHelper.createLabel(
						"**The Severance Type dropdown displayed**" + ch_Severance_Type_Dropdown.get(i).getText(),
						ExtentColor.GREEN));
				logSuccess("Actual value-" + ch_Severance_Type_Dropdown.get(i).getText());
				logSuccess("Expected value-" + severanceTypeDropdown[i]);
				System.out.println("The inLieu Pay duration Unit dropdown displayed"
						+ ch_Severance_Type_Dropdown.get(i).getText());

			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("**The Severance Type dropdown is Not displayed**" + "Actual Value"
								+ ch_Severance_Type_Dropdown.get(i).getText() + "Expected Value"
								+ severanceTypeDropdown[i], ExtentColor.RED));
				logFailure("Actual value-" + ch_Severance_Type_Dropdown.get(i).getText());
				logFailure("Expected value-" + severanceTypeDropdown[i]);
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println(
						"The Termination Type dropdown is Not Displayed" + ch_Severance_Type_Dropdown.get(i).getText());
			}
			if (ch_Severance_Type_Dropdown.get(i).getText().equals("Lump Sum")) {
				ch_Severance_Type_Dropdown.get(i).click();
			}
		}
		waitForAction(driver);
	}

	/**
	 * This method Validate the Payment Type:Unused Time Off
	 * 
	 * @param paymentname
	 * @throws Exception
	 */
	public void paymentType_Validation_UnusedTimeOff(String paymentname) throws Exception {
		waitForElementToBeClickable(driver, ch_paymenttype);
		// scrollPage();
		/*
		 * Actions a = new Actions(driver);
		 * a.moveToElement(ch_enterPaymentType).click().build().perform();
		 */

		ch_paymenttype.click();
		// ch_paymenttype.clear();
		ch_enterPaymentType.sendKeys(paymentname);
		ch_enterPaymentType.sendKeys(Keys.TAB);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Successfully Enter the PaymentType is**" + paymentname, ExtentColor.CYAN));
		checkForPageLoad(driver);
		if (ch_Unused_Floating_Holiday.isSelected()) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("**The Unused Floating Holiday Check Box is Selected Default**", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("The Unused Floating Holiday Check Box is Selected Default");
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("**The Unused Floating Holiday Check Box is Not Selected Default**", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("The Unused Floating Holiday Check Box is Not Selected Default");
		}
		if (ch_Unused_VacationPTO.isSelected()) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("**The Unused VacationPTO Check Box is Selected Default**", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("The Unuse VacationPTO Check Box is Selected Default");
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("**The Unused VacationPTO Check Box is Not Selected Default**", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("The Unused VacationPTO Check Box is Not Selected Default");
		}
	}

	// this method tells the Enter the Final pay Details

	public void enter_Final_Pay(String paymentType, String endDate, String terminationTypeDropdown) throws Exception {
		scrollToElement(driver, ch_glnumber);
		waitForElement(driver, ch_paymenttype);
		ch_paymenttype.click();

		// entering the payment type
		ch_enterPaymentType.sendKeys(paymentType);
		ch_enterPaymentType.sendKeys(Keys.TAB);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Successfully Enter the PaymentType is**" + paymentType, ExtentColor.CYAN));
		checkForPageLoad(driver);
		// checking the currency type is USD or not
		if (ch_Currency_Type.getText().equals("USD")) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("**The Currency Type By Default**" + ch_Currency_Type.getText(), ExtentColor.GREEN));
			logSuccess("Actual value-" + ch_Currency_Type.getText());
			logSuccess("Expected value-" + "USD");

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("The Currency Type By Default**" + ch_Currency_Type.getText());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"**The Currency Type Not Matched**" + ch_Currency_Type.getAttribute("value"), ExtentColor.RED));
			logFailure("Actual value-" + ch_Currency_Type.getText());
			logFailure("Expected value-" + "USD");
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("The Currency Type Not Matched**" + ch_Currency_Type.getAttribute("value"));
		}

		waitForElement(driver, ch_final_pay_endDate);
		scrollToElement(driver, ch_selectemployee);
		ch_final_pay_endDate.click();
		// enter the final pay end date
		ch_final_pay_endDate.sendKeys(endDate, Keys.TAB);
		test.get().log(Status.INFO, MarkupHelper
				.createLabel("**Successfully Enter the final pay enddate is**" + endDate, ExtentColor.CYAN));
		ch_final_pay_TerminationType.click();
		// enter the termination type
		ch_enter_TerminationType.sendKeys(terminationTypeDropdown, Keys.TAB);
		test.get().log(Status.INFO, MarkupHelper.createLabel(
				"**Successfully Enter the Termination Type**" + terminationTypeDropdown, ExtentColor.CYAN));
		// checking the two check boxes are selected or not
		if (ch_Unused_Floating_Holiday.isSelected() && ch_Unused_VacationPTO.isSelected()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Both Check Boxes are Selected By default", ExtentColor.CYAN));
		} else {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("One or More Check Boxes are Not Selected By default", ExtentColor.CYAN));
		}

		scrollToElement(driver, xpTermination);
		// unselecting the one check box
		ch_Unused_Floating_Holiday.click();
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully Untick the One of The check box", ExtentColor.CYAN));

		scrollToElement(driver, calendarIcon);

		SimpleDateFormat simpleDateFormats = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		simpleDateFormats.setTimeZone(TimeZone.getTimeZone("PST"));
		String currentDateString = simpleDateFormats.format(new Date());

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("PST"));
		String currentDate = simpleDateFormat.format(new Date());
		String actualDateTime = dateTime.getAttribute("value").trim();
		String actualDateTimeRepeat = dateTime.getAttribute("value").trim();
		Date startDate = simpleDateFormat.parse(currentDate);
		Date endDates = simpleDateFormat.parse(actualDateTime);

		System.out.println("Current Date is  - " + currentDate);
		System.out.println("Field Date is - " + endDates);
		int workingDaysDifference = getWorkingDaysBetweenTwoDates(startDate, endDates);

		// String expectedDateTime = compareTime(1);
		if (workingDaysDifference == 2) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"Date and Time needed field is displayed two business days from today with value: "
									+ actualDateTime,
							ExtentColor.GREEN));
			System.out.println("Date and Time needed field is with value:  " + actualDateTime);
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"Date and Time needed field is not displayed two business days from today with value: "
									+ actualDateTime,
							ExtentColor.RED));
			logFailure("Difference in Working Days is  - " + workingDaysDifference);
		}

		scrollToElement(driver, ch_paymenttype);
		waitForElementToBeClickable(driver, calendarIcon);
		calendarIcon.click();
		waitForElementToBeClickable(driver, calendarPrev);
		calendarPrev.click();
		waitForElementToBeClickable(driver, pastDay);
		pastDay.click();
		waitForElementToBeClickable(driver, calendarInput);
		calendarInput.click();
		waitForElementToBeClickable(driver, dateTime);
		actualDateTime = dateTime.getAttribute("value").trim();
		waitForAction(driver);
		checkForPageLoad(driver);
		if (isElementPresent(dateError)) {
			logSuccess("Error Message is displayed when Past Date is entered. " + actualDateTime);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			logFailure("Error Message is not displayed when Past Date is entered. " + actualDateTime);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		calendarInput.clear();
		waitForElementToBeClickable(driver, calendarIcon);
		calendarIcon.click();
		waitForElementToBeClickable(driver, clockCalendarToggleIcon);
		clockCalendarToggleIcon.click();
		waitForElementToBeClickable(driver, decreaseHours);
		decreaseHours.click();
		waitForElementToBeClickable(driver, calendarInput);
		calendarInput.click();
		waitForElementToBeClickable(driver, dateTime);
		actualDateTime = dateTime.getAttribute("value").trim();
		waitForAction(driver);
		if (isElementPresent(dateError)) {
			logSuccess("Error Message is displayed when Time One hour less than the current time is entered. "
					+ actualDateTime);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			logFailure("Error Message is not displayed when Time One hour less than the current time is entered. "
					+ actualDateTime);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		calendarInput.clear();
		waitForElementToBeClickable(driver, calendarIcon);
		calendarIcon.click();
		waitForElementToBeClickable(driver, clockCalendarToggleIcon);
		clockCalendarToggleIcon.click();
		waitForAction(driver);
		waitForElementToBeClickable(driver, toDay);
		String currentDates = toDayText.getText().trim();
		System.out.println("Today from Appliction - " + currentDates);
		SimpleDateFormat simpleDateFormatSaf = new SimpleDateFormat("dd EEEE");
		simpleDateFormatSaf.setTimeZone(TimeZone.getTimeZone("PST"));
		String todayDay = simpleDateFormatSaf.format(new Date());
		System.out.println("Today from Java - " + todayDay);

		toDay.click();
		currentDate = simpleDateFormat.format(new Date());
		System.out.println("Current Hour - " + Integer.parseInt(currentDateString.split(" ")[1].split(":")[0]));

		if (todayDay.trim().contains(currentDates)) {
			if ((todayDay.contains("Friday") && (Integer.parseInt(currentDateString.split(" ")[1].split(":")[0]) >= 16))
					|| todayDay.contains("Saturday")) {
				ifFridayOrSaturday.click();
			} else if (todayDay.contains("Sunday")) {
				nextDay.click();
			} else if ((todayDay.contains("Monday") || todayDay.contains("Tuesday") || todayDay.contains("Wednesday")
					|| todayDay.contains("Thursday"))
					&& (Integer.parseInt(currentDateString.split(" ")[1].split(":")[0]) >= 16)) {
				nextDay.click();
			} else if ((todayDay.contains("Monday") || todayDay.contains("Tuesday") || todayDay.contains("Wednesday")
					|| todayDay.contains("Thursday") || todayDay.contains("Friday"))
					&& (Integer.parseInt(currentDateString.split(" ")[1].split(":")[0]) < 16)
					&& (Integer.parseInt(currentDateString.split(" ")[1].split(":")[0]) > 9)) {
				clockCalendarToggleIcon.click();
				checkForPageLoad(driver);

				for (int i = 0; i < 2; i++) {
					increaseHours.click();
					increaseMinutes.click();
				}

				for (int i = 0; i < 2; i++) {
					increaseMinutes.click();
				}
			}
		} else {
			logFailure("Expected Date for Today and Actual Date does not match");
			logFailure("Expected - " + todayDay.split(" ")[0]);
			logFailure("Actual - " + currentDates);
		}

		String modifiedDate = null;
		calendarInput.click();
		actualDateTime = dateTime.getAttribute("value").trim();
		System.out.println("Actual Date and Time - " + actualDateTime);
		// System.out.println("Hours - " + Integer.parseInt(actualDateTime.split("
		// ")[1].split(":")[0]));

		if ((Integer.parseInt(actualDateTime.split(" ")[1].split(":")[0]) >= 16)
				&& (Integer.parseInt(actualDateTime.split(" ")[1].split(":")[0]) <= 17)) {
			System.out.println("Sending Keys to Calendar field - " + modifiedDate);
			calendarIcon.click();
			waitForElementToBeClickable(driver, clockCalendarToggleIcon);
			clockCalendarToggleIcon.click();
			waitForElementToBeClickable(driver, getHours);
			getHours.click();
			waitForElementToBeClickable(driver, driver.findElement(By.xpath("//td[@class = 'hour' and text() = 10]")));
			driver.findElement(By.xpath("//td[@class = 'hour' and text() = 10]")).click();
			waitForElementToBeClickable(driver, calendarInput);
			calendarInput.click();
			waitForAction(driver);
			additionalInfoBox.click();
			waitForAction(driver);
		} else if ((Integer.parseInt(actualDateTime.split(" ")[1].split(":")[0]) > 17)
				|| (Integer.parseInt(actualDateTime.split(" ")[1].split(":")[0]) < 9)) {
			modifiedDate = actualDateTime.split(" ")[0] + " " + "11:00:00";
			System.out.println("Sending Keys to Calendar field - " + modifiedDate);
			dateTime.clear();
			dateTime.sendKeys(modifiedDate);
			// dateTime.sendKeys("2020-02-19 11:00:00");
			calendarInput.click();
			waitForAction(driver);
			scrollPageToElement(driver, label_additional_info);
			additionalInfoBox.click();
			checkForPageLoad(driver);
		} else if ((Integer.parseInt(actualDateTime.split(" ")[1].split(":")[0]) >= 9)
				&& (Integer.parseInt(actualDateTime.split(" ")[1].split(":")[0]) < 16)) {
			System.out.println("Sending Keys to Calendar field - " + actualDateTimeRepeat);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("PST"));
			Date date = new Date();
			System.out.println(date.toString());
			System.out.println(date);
			calendar.setTime(date);
			calendar.add(Calendar.MINUTE, 2);
			calendar.add(Calendar.HOUR_OF_DAY, 2);
			System.out.println(dateFormat.format(calendar.getTime()));
			dateTime.clear();
			dateTime.sendKeys(dateFormat.format(calendar.getTime()));
			// dateTime.sendKeys("2020-02-19 11:00:00");
			calendarInput.click();
			scrollPageToElement(driver, label_additional_info);
			waitForAction(driver);
			additionalInfoBox.click();
			waitForAction(driver);
			additionalInfoBox.click();
		} else {
			System.out.println("Not in any else");
		}

		waitForAction(driver);
		if (!isElementPresent(dateError)) {
			logSuccess(
					"Error Message is not displayed when Time Two hours more Business Hours than the current time is entered.");
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			logFailure(
					"Error Message is displayed when Time Two hours more Business Hours than the current time is entered. "
							+ modifiedDate);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	// This method validate the Point of contact for request section

	public void pointOfContact(String AltPhoneNumber) throws Exception {
		if (!ch_Name.getAttribute("value").isEmpty()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"**Under Point Of Contact Name is Default and Displayed Name is**" + ch_Name.getAttribute("value"),
					ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println(
					"Under Point Of Contact Name is Default and Displayed Name is**" + ch_Name.getAttribute("value"));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**Under Point Of Contact Name is Not Default", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Under Point Of Contact Name is Not Default");
		}

		if (!ch_Work_Email.getAttribute("value").isEmpty()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**Under Point Of Contact Work Email is Default and Displayed Email is**"
							+ ch_Work_Email.getAttribute("value"), ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Under Point Of Contact Work Email is Default and Displayed Name is**"
					+ ch_Work_Email.getAttribute("value"));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**Under Point Of Contact Work Email is Not Default", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Under Point Of Contact Work Email is Not Default");
		}

		if (!ch_Phonenumber.getAttribute("value").isEmpty()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**Under Point Of Contact Phone Number is Default and Displayed Email is**"
							+ ch_Phonenumber.getAttribute("value"), ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Under Point Of Contact Phone Number is Default and Displayed Name is**"
					+ ch_Phonenumber.getAttribute("value"));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**Under Point Of Contact Phone Number is Not Default", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Under Point Of Contact Phone Number is Not Default");
		}

		scrollToElement(driver, ch_SubmitBt);
		scrollPageDown(driver);
		ch_AltPhoneNumber.sendKeys(AltPhoneNumber);
	}

	public String submitCheckRequest() throws InterruptedException {
		scrollToElement(driver, ch_SubmitBt);
		checkForPageLoad(driver);
		scrollPageDown(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ch_SubmitBt);
		checkForPageLoad(driver);

		if (!isElementPresent(ch_caseID) && isElementPresent(ch_SubmitBt)) {
			ch_SubmitBt.click();
		}

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Successfully submit the check request form**", ExtentColor.CYAN));
		waitForElement(driver, ch_caseID);
		checkRequestCaseId = ch_caseID.getText().trim();
		System.out.println("Check Request Url - " + driver.getCurrentUrl());
		logInfo("Check Request Url - " + driver.getCurrentUrl());
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**check request HR caseID is**" + checkRequestCaseId, ExtentColor.CYAN));
		System.out.println("HR caseId is" + checkRequestCaseId);
		return checkRequestCaseId;
	}

	// This method contains the Payment delivery Types
	public void paymentDeliveryMethods(String deliveryMethod) throws Exception {
		System.out.println("Inside Payment Delivery Method");
		scrollPageToElement(driver, label_PaymentDelivery_Method);
		waitForElementToBeClickable(driver, ch_PaymentDelivery_Method);
		checkForPageLoad(driver);
		Actions a = new Actions(driver);
		a.moveToElement(ch_PaymentDelivery_Method).click().build().perform();

		// ch_PaymentDelivery_Method.click();
		for (int i = 0; i < ch_PaymentDelivery_List.size(); i++) {
			if (ch_PaymentDelivery_List.get(i).getText().contains(deliveryMethod)) {
				logSuccess("Expected Value - " + ch_PaymentDelivery_List.get(i).getText());
				logSuccess("Actual Value - " + deliveryMethod);
				ch_PaymentDelivery_Dropdown.sendKeys(deliveryMethod, Keys.TAB);
				System.out.println("Entered Payment Delivery Method ");
				test.get().log(Status.PASS,
						MarkupHelper.createLabel(
								"**Successfully selecting the payment Delivery method is**" + deliveryMethod,
								ExtentColor.GREEN));
				System.out.println("Successfully selecting the payment Delivery method is**" + deliveryMethod);
			}
		}
	}

	public void dateAndTimeValidation() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = simpleDateFormat.format(new Date());
		LocalDate date1 = LocalDate.parse(currentDate, dateTimeFormatter);
		String subDate = ch_date_Time.getAttribute("value").substring(0, 10);
		System.out.println("substring===" + subDate);
		String subTime = ch_date_Time.getAttribute("value").substring(11,
				ch_date_Time.getAttribute("value").length() - 1);
		System.out.println("subtime===" + subTime);
		LocalDate date2 = LocalDate.parse(ch_date_Time.getAttribute("value"), dateTimeFormatter);
		long days = ChronoUnit.DAYS.between(date1, date2);
		System.out.println("Difference in Days: " + days);
		System.out.println(
				driver.findElement(By.xpath("//input[@id='sp_formfield_Check_Needed']")).getAttribute("value"));
	}

	// Navigating to the HR Case Page
	public void navigateToSearchHrCase() throws Exception {
		driver.get(homePageURL);
		waitForElement(driver, leftsearch);
		waitForElementToBeClickable(driver, leftsearch);
		leftsearch.sendKeys("HR CASE");
		checkForPageLoad(driver);
		scrollToElement(driver, open);
		waitForElementToBeClickable(driver, open);
		JavascriptExecutor ja = (JavascriptExecutor) driver;
		ja.executeScript("arguments[0].click();", open);
		open.click();

		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, leftsearch);
		waitForFrameToBeAvailable(driver, "gsft_main");

		if (searchHRCase.isDisplayed()) {
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

	/**
	 * Searching for the Case number
	 * 
	 * @param caseName
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void searchHRCaseinITIL(String caseName) throws IOException, InterruptedException {
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, searchNumberDropDown);
		Select select = new Select(searchNumberDropDown);
		select.selectByVisibleText("Number");
		waitForAction(driver);
		waitForElementToBeClickable(driver, numberSearchTextbox);
		numberSearchTextbox.sendKeys(caseName);
		waitForAction(driver);
		numberSearchTextbox.sendKeys(Keys.ENTER);
		waitForElement(driver, hr_link_number);

		waitForFrameToBeAvailable(driver, "gsft_main");
		System.out.println(hr_link_number.getText());
		if (hr_link_number.isDisplayed() && hr_link_number.getText().trim().equals(caseName.trim())) {
			logSuccess("Actual value-" + hr_link_number.getText());
			logSuccess("Expected value-" + caseName.trim());
			waitForElementToBeClickable(driver, hr_link_number);
			JavascriptExecutor ja = (JavascriptExecutor) driver;
			ja.executeScript("arguments[0].click();", hr_link_number);
			checkForPageLoad(driver);

			if (isElementPresent(hr_link_number)) {
				try {
					hr_link_number.click();
					waitForAction(driver);
				} catch (Exception e) {
					// TODO: handle exception
				}

			}
			//
			System.out.println("Case clicked successfully with ID " + caseName);
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Searched the HR Case - " + caseName, ExtentColor.CYAN));
			logInfoScreenshot(driver);
		} else {
			logFailure("Actual value-" + hr_link_number.getText());
			logFailure("Expected value- " + caseName.trim());
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("HR Case " + caseName + " not found", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		checkForPageLoad(driver);
	}

	/**
	 * Validating the Case
	 * 
	 * @throws Exception
	 */
	public void validateHRCaseinITIL() throws Exception {
		driver.navigate().refresh();
		waitForElement(driver, hr_state);
		waitForFrameToBeAvailable(driver, "gsft_main");
		checkForPageLoad(driver);

		waitForElement(driver, hr_state);
		Select select = new Select(hr_state);
		String stateOption = select.getFirstSelectedOption().getText();
		if (stateOption.equalsIgnoreCase("Open")) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("the state field is displayed with value" + stateOption, ExtentColor.GREEN));
			System.out.println("the state field is displayed with value" + stateOption);
			logSuccess("Actual value-" + stateOption);
			logSuccess("Expected value-" + "Open");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("the state field is not displayed with expected value", ExtentColor.RED));
			logFailure("Actual value-" + stateOption);
			logFailure("Expected value-" + "Open");
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			logFailure("Actual value-" + stateOption);
			logFailure("Expected value-" + "Open");
		}
		waitForElement(driver, hr_priority);
		Select select2 = new Select(hr_priority);
		String priorityOption = select2.getFirstSelectedOption().getText();
		if (priorityOption.equalsIgnoreCase("1 - High")) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("The priority field is dispalyed with value" + priorityOption, ExtentColor.GREEN));
			logSuccess("Actual value-" + priorityOption);
			logSuccess("Expected value-" + "1 - High");
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("The priority field is not displayed with expected value", ExtentColor.RED));
			logFailure("Actual value-" + priorityOption);
			logFailure("Expected value-" + "1 - High");
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		if (hr_service.getAttribute("value").equalsIgnoreCase("Payment Request")) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"HR Service field is displayed with value" + hr_service.getAttribute("value"), ExtentColor.GREEN));
			logSuccess("Actual value-" + hr_service.getAttribute("value"));
			logSuccess("Expected value-" + "Payment Request");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("HR Service field is Not displayed with Expected value", ExtentColor.RED));
			logFailure("Actual value-" + hr_service.getAttribute("value"));
			logFailure("Expected value-" + "Payment Request");
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		if (assignment_group.getAttribute("value").equalsIgnoreCase("HRSM - Payroll")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"Assignment group field is displayed with value" + assignment_group.getAttribute("value"),
							ExtentColor.GREEN));
			logSuccess("Actual value-" + assignment_group.getAttribute("value"));
			logSuccess("Expected value-" + "HRSM - Payroll");
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Assignment Group field is Not displayed with Expected value", ExtentColor.RED));
			logFailure("Actual value-" + assignment_group.getAttribute("value"));
			logFailure("Expected value-" + "HRSM - Payroll");
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		if (assign_to.getAttribute("value").isEmpty()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Assigned To field is empty", ExtentColor.GREEN));

		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Assigned To field is Not Empty", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		if (dateAndTimeCheck.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("date and Time Check field is Displayed with expected date"
							+ dateAndTimeCheck.getAttribute("value"), ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("date and time check field is not matched with expected date", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	/**
	 * Entering the assignTo field and validate the work notes
	 * 
	 * @param assignTo
	 * @param notes
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void resolveHRCaseinITIL(String assignTo, String notes) throws IOException, InterruptedException {
		// Actions actions = new Actions(driver);
		String hrPageWindowHandle = driver.getWindowHandle();
		scrollToElement(driver, assignTo_search);
		waitForAction(driver);
		// Perform the click operation that opens new window
		if (isElementPresent(assignTo_search)) {
			new Actions(driver).click(assignTo_search).build().perform();
			checkForPageLoad(driver);
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
				waitForAction(driver);
				System.out.println(windowName);
				driver.manage().window().maximize();
				waitForElementToBeClickable(driver, searchCriteria);
				Select dropdown = new Select(searchCriteria);
				waitForAction(driver);
				dropdown.selectByVisibleText("Name");
				searchTextBox.clear();
				searchTextBox.sendKeys(assignTo);
				searchTextBox.sendKeys(Keys.ENTER);
				waitForAction(driver);
				waitForElement(driver, nameSearchTextBox);

				if (isElementPresent(nameSearchTextBox)) {
					test.get().log(Status.INFO, MarkupHelper
							.createLabel("Entering the value for Assign to field - " + assignTo, ExtentColor.CYAN));
					// nameSearchTextBox.clear();
					nameSearchTextBox.sendKeys(assignTo);
					nameSearchTextBox.sendKeys(Keys.ENTER);
					checkForPageLoad(driver);
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					WebElement searchResult = driver.findElement(
							By.xpath("//*[contains(@class, 'glide_ref_item_link') and contains(@role, 'button')]"));
					try {
						searchResult.click();
					} catch (Exception e) {
						// e.printStackTrace();
					}
				}
			}
		}
		checkForPageLoad(driver);
		waitForExpectedNumberOfWindows(driver, 1);
		System.out.println("windowsize" + driver.getWindowHandles().size());
		driver.switchTo().window(hrPageWindowHandle);
		waitForFrameToBeAvailable(driver, "gsft_main");
		driver.findElement(By.tagName("body")).click();

		scrollToElement(driver, hr_state);
		waitForAction(driver);
		waitForElementToBeClickable(driver, hr_state);
		if (hr_state.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Selecting the state as Resolved", ExtentColor.GREEN));
			Select states = new Select(hr_state);
			states.selectByVisibleText("Resolved");
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("State dropdown field is not displayed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		checkForPageLoad(driver);
		if (isElementPresent(workNotesError)) {
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("WorkNotes Error Message is displayed" + workNotesError.getText(), ExtentColor.CYAN));
		} else {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("WorkNotes Error Message is Not Displayed", ExtentColor.CYAN));
		}

		scrollToElement(driver, workNotes);
		if (isElementPresent(workNotes)) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Entering the Work Notes", ExtentColor.GREEN));
			/* workNotes.clear(); */
			checkForPageLoad(driver);
			waitForElementToBeClickable(driver, workNotes);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[1].value = arguments[0]; ", "Marking Case as Resolved JS2", workNotes);
			checkForPageLoad(driver);
			js.executeScript("arguments[0].textContent='" + notes + "';", workNotes);
			waitForAction(driver);
			workNotes.sendKeys(notes);

			/*
			 * Actions actions = new Actions(driver); actions.sendKeys(workNotes,
			 * notes).build().perform();
			 */

			System.out.println("Worknotes Entered as - " + notes);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Work notes field is not displayed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		scrollPageToElement(driver, update);
		waitForElementToBeClickable(driver, update);
		update.click();

		waitForElement(driver, hr_link_number);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, hr_link_number);
		JavascriptExecutor ja = (JavascriptExecutor) driver;
		ja.executeScript("arguments[0].click();", hr_link_number);

		waitForFrameToBeAvailable(driver, "gsft_main");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(
				By.xpath("//span[contains(@class, 'sn-widget-textblock-body') and contains(text(), 'Resolved')]"));
		js.executeScript("arguments[0].scrollIntoView();", element);
		test.get().log(Status.INFO, MarkupHelper
				.createLabel("Work notes are visible and Successfully scroll to the Work notes", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	}
}
