package com.snow.pageobjects;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.snow.base.ReusableLibrary;

public class WBSFFormRejectionandBypass extends ReusableLibrary {
	public WebDriver driver;

	public WBSFFormRejectionandBypass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='q']")
	public WebElement wbsf_searchbar;

	@FindBy(xpath = "//i[@class='fa fa-search']")
	public WebElement wbsf_searchbar_click;

	@FindBy(xpath = "//span[contains(text(),'Temp Request Form')] ")
	public WebElement wbsf_temp_form;

	@FindBy(xpath = "//h1[contains(text(),'WBSF Temp Request Form')]")
	public WebElement wbsf_request_form;

	@FindBy(xpath = "//div[@id='s2id_sp_formfield_select_employee']/a")
	public WebElement wbsf_select_employee;

	// @FindBy(xpath = "//div[@id='select2-drop']//input[@class='select2-input']")
	@FindBy(xpath = "//label[contains(text(),'Select Employee')]//following-sibling::input")
	public WebElement wbsf_select_employee_search;

	@FindBy(xpath = "//*[@class ='select2-no-results']")
	public WebElement wbsf_select_employee_error_message;

	@FindBy(xpath = "//button[@class='btn btn-default bg-white lookup']")
	public WebElement wbsf_select_employee_button;

	@FindBy(xpath = "(//span[@class='select2-chosen'])[14]")
	public WebElement wbsf_select_employee_costcenter;

	@FindBy(xpath = "//input[@id='sp_formfield_department']")
	public WebElement wbsf_department_information;

	@FindBy(xpath = "//i[@class='fa fa-close text-base sp-form-modal-close-button']")
	public WebElement wbsf_select_employee_close_button;

	@FindBy(xpath = "//input[@id='sp_formfield_email'] ")
	public WebElement wbsf_employee_email;

	@FindBy(xpath = "//*[@id='sp_formfield_department']")
	public WebElement wbsf_employee_department;

	@FindBy(xpath = "//*[@id='sp_formfield_phone']")
	public WebElement wbsf_employee_phone;

	@FindBy(xpath = "//label[@class='field-label ng-binding ng-scope'][contains(text(),'Department (Cost Center) in need of temp worker')]")
	public WebElement wbsf_text_under_assignment_information;

	@FindBy(xpath = "//div[@id='s2id_sp_formfield_cost_center']/a")
	public WebElement wbsf_assignment_information;

	@FindBy(xpath = "//input[@id='s2id_autogen1_search']")
	public WebElement wbsf_assignment_information_search;

	@FindBy(xpath = "//*[@id='s2id_sp_formfield_cost_center']")
	public WebElement costcenter_field;

	@FindBy(xpath = "//span[@id='select2-chosen-2']")
	public WebElement wbsf_alternate_cost_center;

	@FindBy(xpath = "//input[@id='s2id_autogen2_search']")
	public WebElement wbsf_alternate_cost_center_search;

	@FindBy(xpath = "//*[@id='select2-chosen-3']")
	public WebElement wbsf_field;

	@FindBy(xpath = "//input[@id='s2id_autogen3_search']")
	public WebElement wbsf_field_searchh;

	@FindBy(xpath = "//span[@id='select2-chosen-4']")
	public WebElement wbsf_request_type;

	@FindBy(xpath = "//input[@id='s2id_autogen4_search']")
	public WebElement wbsf_request_type_search;

	@FindBy(xpath = "//*[@id='sp_formfield_name_of_person_being_replaced']")
	public WebElement wbsf_person_name_replaced;

	@FindBy(xpath = "//span[@id='select2-chosen-5']")
	public WebElement wbsf_replacement;

	@FindBy(xpath = "//input[@id='s2id_autogen5_search']")
	public WebElement wbsf_replacement_search;

	@FindBy(xpath = "//*[@id='sp_formfield_title_of_person_being_replaced']")
	public WebElement wbsf_person_title;

	@FindBy(xpath = "//input[@id='sp_formfield_other_replacement_reason']")
	public WebElement wbsf_other_replacement_reason;
	
	@FindBy(xpath = "//label[@class='field-label ng-binding ng-scope'][contains(text(),'Reason for replacement')]")
	public WebElement label_reason_for_replacement_reason;

	@FindBy(xpath = "//input[@id='sp_formfield_start_date']")
	public WebElement wbsf_start_date;

	@FindBy(xpath = "//input[@id='sp_formfield_end_date']")
	public WebElement wbsf_end_date;
	
	@FindBy(xpath = "//label[@class='field-label ng-binding ng-scope'][contains(text(),'End Date')]")
	public WebElement label_wbsf_end_date;

	@FindBy(xpath = "//*[@id='sp_formfield_hours']")
	public WebElement wbsf_hours;

	@FindBy(xpath = "//*[@id='sp_formfield_name_of_preferred_temp']")
	public WebElement wbsf_name_of_preffered_temp;

	@FindBy(xpath = "//*[@id='sp_formfield_building_and_room_no']")
	public WebElement wbsf_building_roomno;

	@FindBy(xpath = "(//*[@class='text-muted'])[1]")
	public WebElement wbsf_Requirements_with_profeciency_text;

	@FindBy(xpath = "//*[@class='btn']")
	public WebElement wbsf_table_button;

	@FindBy(xpath = "//*[@id='tester']/table/tr")
	public List<WebElement> wbsf_table_rows;

	@FindBy(xpath = "(//*[@class='text-muted'])[2]")
	public WebElement wbsf_additional_requirements_text;

	@FindBy(xpath = "//*[@id='sp_formfield_daily_job_duties']")
	public WebElement wbsf_describe_job_duites;

	@FindBy(xpath = "(//span[@class='glyphicon glyphicon-calendar'])[2]")
	public WebElement wbsf_enddate_button;

	@FindBy(xpath = "(//div[@class='datepicker'])[2]/div[1]/table/thead/tr[1]/th[2]")
	public WebElement wbsf_enddate_table;

	@FindBy(xpath = "(//div[@class='datepicker'])[2]/div[1]/table/thead/tr[1]/th[3]")
	public WebElement wbsf_enddate_table_arrow;

	@FindBy(xpath = "(//div[@class='datepicker'])[2]/div[1]/table/tbody/tr/td/div[contains(text(),'17')]")
	public WebElement wbsf_enddate_day;

	@FindBy(xpath = "//a[contains(text(),'HR Ticket Page')]")
	public WebElement wbsf_hrticket_page;

	// @FindBy(xpath = "//h4[@class='panel-title']")
	@FindBy(xpath = "//h4[contains(text(),'Case Description')]")
	public WebElement wbsf_casediscription;

	@FindBy(xpath = "(//button[@name='submit'])[1]")
	public WebElement wbsf_submit;

	@FindBy(xpath = "//div[@class='title-info ng-binding']")
	public WebElement caseid;

	@FindBy(xpath = "//input[@id='filter']")
	public WebElement leftSearch;

	@FindBy(xpath = "(//*[text()='All HR Cases']/following::div[text()='Open'])[1]")
	public WebElement xpOpen;

	@FindBy(xpath = "//h2[text()='HR Cases']")
	public WebElement xpCasesPage;

	@FindBy(xpath = "(//input[@id='sn_hr_core_case_table_header_search_control'])[1]")
	public WebElement xpNumberSearch;

	@FindBy(xpath = "(//tr[@id='hdr_sn_hr_core_case'])[1]/th[2]")
	public WebElement xpSearchIcon;

//	@FindBy(xpath = "//tr[contains(@id,'row_sn_hr_core_case')]/td[3]")
	@FindBy(xpath = "(//a[@class='linked formlink'])[1]")
	public WebElement xpUniqueCaseId;

	@FindBy(xpath = "(//span[contains(text(),'Approvers')])[1]")
	public WebElement xpApproverTab;

	@FindBy(xpath = "//tr[contains(@id,'row_sn_hr_core_case_workforce_admin.sysapproval_approver')]/td[3]/a")
	public List<WebElement> xpState;

	@FindBy(xpath = "//*[@id='user_info_dropdown']/div/span[4]")
	public WebElement userMenu;

	@FindBy(xpath = "//div[contains(@id,'approver.form_header')]")
	public WebElement xpHeader;

	@FindBy(xpath = "//*[contains(@role,'presentation')]/a[text()='Impersonate User']")
	public WebElement impUser;

	@FindBy(xpath = "//*[@id='select2-chosen-2']")
	public WebElement impUserDropDwn;

	@FindBy(xpath = "//*[@id='s2id_autogen2_search']")
	public WebElement impUserSendkys;

	@FindBy(xpath = "//ul[@role = 'listbox']/li")
	public WebElement impersonateApprover;

	@FindBy(xpath = "//ul[@role = 'listbox']/li/div/div[1]")
	public WebElement impersonateApproverName;

	@FindBy(xpath = "//li[text() = 'No matches found']")
	public WebElement noMatchesFoundImpersonate;

	@FindBy(xpath = "(//div[contains(text(),'My Approvals')])[1]")
	public WebElement xpMyApprovals;

	@FindBy(xpath = "(//td[@name='sysapproval'])[1]//input")
	public WebElement xpApprovalFor;

	@FindBy(xpath = "(//input[@id='sysapproval_approver_table_header_search_control'])[1]")
	public WebElement xpEnterState;

	@FindBy(xpath = "(//tr[@id='hdr_sysapproval_approver'])[1]/th[2]//button")
	public WebElement xpApprovalSearchIcon;

	@FindBy(xpath = "(//tr[contains(@id,'row_sysapproval_approver')]/td[3]/a)[1]")
	public WebElement xpImpState;

	@FindBy(xpath = "//textarea[contains(@id,'activity-stream-comments-textarea')]")
	public WebElement xpRejectComments;

	@FindBy(xpath = "//textarea[contains(@id,'activity-stream-textarea')]")
	public WebElement xpRejectComment2;

	@FindBy(xpath = "//input[@id='comments']")
	public WebElement xpRejectComment3;

	@FindBy(xpath = "//*[@id='output_messages']/div/div[1]")
	public WebElement rejectCommentError;

	@FindBy(xpath = "//button[text()='Post']")
	public WebElement postBt;

	@FindBy(xpath = "(//button[@id ='reject'])[1]")
	public WebElement xpRejectbtn;

	@FindBy(xpath = "(//button[@id ='sysverb_update'])[1]")
	public WebElement xpUpdatebtn;

	@FindBy(xpath = "(//button[@value='reject'])[1]")
	public WebElement rejectbutton;

	@FindBy(xpath = "//button[@name='submit'][contains(text(),'Reject')]")
	public WebElement rejectbutton2;

	@FindBy(xpath = "//span[contains(text(),'rejected')]")
	public WebElement rejectedtext;

	@FindBy(xpath = "//div[contains(text(),'Rejected approval for HR Workforce Administration Case')]")
	public WebElement xpConfirmReject;

	@FindBy(xpath = "//*[@title = 'Admin Portal']")
	public WebElement adminPortalGear;

	@FindBy(xpath = "//select[@id='sysapproval_approver.state']")
	public WebElement approverState;

	@FindBy(xpath = "//tr[contains(@id,'row_sn_hr_core_case_workforce_admin.sysapproval_approver')]/td/a[contains(text(), 'Requested')]/parent::td/following-sibling::td/a[@class = 'linked' and @aria-label]")
	public List<WebElement> approvers;
	@FindBy(xpath = "//select[@class='form-control default-focus-outline']")
	public WebElement searchNumberDropDown;

	public void search_wbsf() throws Exception {
		waitForElementToBeClickable(driver, wbsf_searchbar);
		wbsf_searchbar.sendKeys("WBSF");

		if (wbsf_searchbar.getAttribute("value").equalsIgnoreCase("WBSF")) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("**WBSF Temp Request form appeared on the dropdown**", ExtentColor.CYAN));
			logSuccess("Expected Value - " + "WBSF");
			logSuccess("Actual Value - " + wbsf_searchbar.getAttribute("value"));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("WBSF Temp Request form appeared on the dropdown");
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("**WBSf Temp Request form  not appeared on the dropdown**", ExtentColor.RED));
			logFailure("Expected Value - " + "WBSF");
			logFailure("Actual Value - " + wbsf_searchbar.getAttribute("value"));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("WBSf Temp Request form  not appeared on the dropdown");
		}
		waitForElementToBeClickable(driver, wbsf_searchbar_click);
		wbsf_searchbar_click.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		waitForElementToBeClickable(driver, wbsf_temp_form);
		js.executeScript("arguments[0].click();", wbsf_temp_form);
	}

	public void open_wbsf_request_form() throws Exception {
		String actualvalue = wbsf_request_form.getText();
		String expectedvalue = "WBSF Temp Request Form";
		if (actualvalue.contains(expectedvalue)) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**WBSf Temp Request form opens**", ExtentColor.GREEN));
			logSuccess("Expected Value - " + expectedvalue);
			logSuccess("Actual Value - " + actualvalue);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("WBSF Temp Request form opens");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**WBSf Temp Request form  not opened**", ExtentColor.RED));
			logFailure("Expected Value - " + expectedvalue);
			logFailure("Actual Value - " + actualvalue);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("WBSF Temp Request form  not opened");
		}
	}

	public void validate_employee_information(String str) throws Exception {
		waitForElementToBeClickable(driver, wbsf_select_employee);
		wbsf_select_employee.click();
		waitForElementToBeClickable(driver, wbsf_select_employee_search);
		wbsf_select_employee_search.sendKeys(str);
		waitForAction(driver);
		wbsf_select_employee_search.sendKeys(Keys.TAB);
		waitForAction(driver);

		String str1 = wbsf_select_employee.getText();
		String email = wbsf_employee_email.getAttribute("value");
		String department = wbsf_employee_department.getAttribute("value");
		String phone = wbsf_employee_phone.getAttribute("value");
		String name = wbsf_select_employee.getText();
		if (str1.equalsIgnoreCase(str)) {
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("**Requested employee Information was displayed below ** ", ExtentColor.CYAN));
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("**employee mail id is **   " + email, ExtentColor.CYAN));
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("**employee phone no is **   " + phone, ExtentColor.CYAN));
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("**employee department is    **" + department, ExtentColor.CYAN));
			test.get().log(Status.INFO, MarkupHelper.createLabel("**employee name is    **" + name, ExtentColor.CYAN));
			logSuccess("Expected Value - " + str);
			logSuccess("Actual Value - " + str1);

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Requested employee Information was displayed below");
			System.out.println("employee mail id is:   " + email);
			System.out.println("employee phone number is:   " + phone);
			System.out.println("employee department is:    " + department);
			System.out.println("employee name  is:    " + name);
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("**Requested employee Information was not displayed  ** ", ExtentColor.RED));
			logFailure("Expected Value - " + str);
			logFailure("Actual Value - " + str1);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("**Requested employee Information was not displayed  ** ");
		}

	}

	public void validate_Assignment_Information_section(String str) throws Exception {
		waitForElementToBeClickable(driver, wbsf_select_employee);
		wbsf_select_employee.click();
		waitForElementToBeClickable(driver, wbsf_select_employee_search);
		wbsf_select_employee_search.sendKeys(str);
		waitForAction(driver);
		wbsf_select_employee_search.sendKeys(Keys.TAB);
		waitForAction(driver);
		waitForElementToBeClickable(driver, wbsf_select_employee_button);
		wbsf_select_employee_button.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", wbsf_select_employee_costcenter);
		waitForAction(driver);

		test.get().log(Status.INFO, MarkupHelper.createLabel("**HR profile page open**", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		System.out.println("HR profile page open");

		scrollToElement(driver, wbsf_select_employee_costcenter);
		waitForAction(driver);

		String text = wbsf_select_employee_costcenter.getText().trim();
		waitForElementToBeClickable(driver, wbsf_select_employee_close_button);
		wbsf_select_employee_close_button.click();
		waitForElement(driver, wbsf_department_information);
		String str1 = wbsf_department_information.getAttribute("value").trim();
		if (str1.contains(text)) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"** text from both assignment information dropdown and costcenter dropdown  matched and text defaults in cost center dropdown  is**"
							+ text,
					ExtentColor.GREEN));
			logSuccess("Expected Value - " + str1);
			logSuccess("Actual value - " + text);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println(
					" text from both assignment information dropdown and costcenter dropdown  matched and text defaults in cost center dropdown  is**    "
							+ text);
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"**text from both assignment information dropdown and costcenter dropdown doestn't  matched **",
					ExtentColor.RED));
			logFailure("Expected Value - " + str1);
			logFailure("Actual value - " + text);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println(
					"**text from both assignment information dropdown and costcenter dropdown doestn't  matched **");
			System.out.println("Expected Value - " + str1);
			System.out.println("Actual value - " + text);
		}

		if (costcenter_field.isEnabled()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"**the cost center dropdown which was in the hr profile page is editable **", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("**the cost center dropdown  which was in the hr profile page is editable **");
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"**the cost center dropdown which was in the hr profile page is not editable**", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("the cost center dropdown which was in the hr profile page is not editable");
		}

	}

	public void validate_alternate_cost_center_dropdown(String costcenter) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", wbsf_select_employee);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, wbsf_alternate_cost_center);
		wbsf_alternate_cost_center.click();
		scrollToElement(driver, wbsf_alternate_cost_center_search);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, wbsf_alternate_cost_center_search);
		wbsf_alternate_cost_center_search.sendKeys(costcenter);
		waitForAction(driver);
		wbsf_alternate_cost_center_search.sendKeys(Keys.TAB);
		waitForAction(driver);
		String str = wbsf_alternate_cost_center.getText();
		if (str.contains("Business Continuity Planning")) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"**alternate cost center dropdown  is populated and selected value from the dropdown is **" + str,
					ExtentColor.GREEN));
			logSuccess("Expected Value - " + costcenter);
			logSuccess("Actual Value - " + str);

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println(
					"alternate cost center dropdown  is populated and selected value from the dropdown is**    " + str);
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**alternate cost center dropdown is  not populated**", ExtentColor.RED));
			logFailure("Expected Value - " + costcenter);
			logFailure("Actual Value - " + str);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("**alternate cost center dropdown  is  not populated**");
		}
	}

	public void validate_field() throws Exception {
		waitForElementToBeClickable(driver, wbsf_field);
		wbsf_field.click();
		waitForElementToBeClickable(driver, wbsf_field_searchh);
		wbsf_field_searchh.sendKeys("Non-Union");
		waitForAction(driver);
		wbsf_field_searchh.sendKeys(Keys.TAB);
		waitForAction(driver);
		String str1 = wbsf_field.getText();
		if (str1.contains("Non-Union")) {
			test.get().log(Status.INFO, MarkupHelper.createLabel(
					"**the selected value from the Union/Non-Union dropdown is:  **" + str1, ExtentColor.CYAN));
			logSuccess("Expected Value - " + "Non-Union");
			logSuccess("Actual Value - " + str1);
			System.out.println("the selected value from the Union/Non-Union dropdown is:   " + str1);
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("** value is not selectrd from the Union/Non-Union dropdown **", ExtentColor.RED));
			logFailure("Expected Value - " + "Non-Union");
			logFailure("Actual Value - " + str1);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("value is not selected from the Union/Non-Union  dropdown");
		}
	}

	public void validate_request_type() throws Exception {
		waitForElement(driver, wbsf_request_type);
		if (wbsf_request_type.isDisplayed() == true) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**Request Type dropdown is Populated**", ExtentColor.GREEN));
			System.out.println("Request Type dropdown is  Populated");
			waitForElementToBeClickable(driver, wbsf_request_type);
			wbsf_request_type.click();
			waitForElementToBeClickable(driver, wbsf_request_type_search);
			wbsf_request_type_search.sendKeys("Replacement");
			waitForAction(driver);
			wbsf_request_type_search.sendKeys(Keys.TAB);
			waitForAction(driver);
			String str = wbsf_request_type.getText();

			if (str.contains("Replacement")) {
				test.get().log(Status.INFO, MarkupHelper.createLabel(
						"** selected value from the request type dropdown is:**  " + str, ExtentColor.CYAN));
				logSuccess("Expected Value - " + "Replacement");
				logSuccess("Actual Value - " + str);
				System.out.println(" selected value from the request type dropdown is:   " + str);
			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("**request type dropdown is not populated.**", ExtentColor.RED));
				logFailure("Expected Value - " + "Replacement");
				logFailure("Actual Value - " + str);
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("request type dropdown is not populated");
			}
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**request type dropdown is not populated.**", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("request type dropdown is not populated");
		}
	}

	public void validate_person_name_replaced_field(String str) throws Exception {
		if (wbsf_person_name_replaced.isDisplayed() == true) {
			System.out.println("Name of person being replaced field is populated");
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("**Name of person being replaced field is populated**   ", ExtentColor.GREEN));
			waitForElementToBeClickable(driver, wbsf_person_name_replaced);
			wbsf_person_name_replaced.sendKeys(str);
			String str1 = wbsf_person_name_replaced.getAttribute("value");
			if (str1.contains(str)) {
				test.get().log(Status.INFO, MarkupHelper.createLabel(
						"**text entered in the Name of person being replaced field is:**   " + str1, ExtentColor.CYAN));
				logSuccess("Expected Value - " + str);
				logSuccess("Actual Value - " + str1);
				System.out.println("text entered in the Name of person being replaced field is:   **" + str1);
			} else {

				test.get().log(Status.FAIL, MarkupHelper
						.createLabel("**Name of person being replaced field is not populated.**", ExtentColor.RED));
				logFailure("Expected Value - " + str);
				logFailure("Actual Value - " + str1);
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("Name of person being replaced field is not populated");
			}
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("**Name of person being replaced field is not displayed.**", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Name of person being replaced field is not displayed");
		}

	}

	public void validate_reason_for_replacement_dropdown1() throws Exception {
		waitForElementToBeClickable(driver, wbsf_replacement);
		wbsf_replacement.click();
		waitForElementToBeClickable(driver, wbsf_replacement_search);
		wbsf_replacement_search.sendKeys("Leave of Absence (Until Return from Leave)");
		waitForAction(driver);
		wbsf_replacement_search.sendKeys(Keys.TAB);
		waitForAction(driver);

		String str = wbsf_replacement.getText();

		if (str.contains("Leave of Absence (Until Return from Leave)")) {
			test.get().log(Status.INFO, MarkupHelper.createLabel(
					"** selected value from the reason for replacement dropdown is:**" + str, ExtentColor.CYAN));
			logSuccess("Expected Value - " + "Leave of Absence (Until Return from Leave)");
			logSuccess("Actual value - " + str);
			System.out.println("** selected value from the reason for replacement dropdown is:**   " + str);
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**reason for replacement dropdown is not populated.**", ExtentColor.RED));
			logFailure("Expected Value - " + "Leave of Absence (Until Return from Leave)");
			logFailure("Actual value - " + str);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("reason for replacement dropdown is not populated");
		}

		if (wbsf_end_date.getAttribute("readonly").equals("true")) {
			logSuccess("End Date field is disable (or) grayed out");
		} else {

			logFailure("End Date field is  not disable (or) grayed out");
			logFailureScreenshot(driver);
		}
	}

	public void validate_reason_for_replacement_dropdown2() throws Exception {
		waitForElementToBeClickable(driver, wbsf_replacement);
		wbsf_replacement.click();
		waitForElementToBeClickable(driver, wbsf_replacement_search);
		wbsf_replacement_search.sendKeys("Vacancy (Until Regular Hire)");
		waitForAction(driver);
		wbsf_replacement_search.sendKeys(Keys.TAB);
		waitForAction(driver);
		String str = wbsf_replacement.getText();
		if (str.contains("Vacancy (Until Regular Hire)")) {
			test.get().log(Status.INFO, MarkupHelper.createLabel(
					"** selected value from the reason for replacement dropdown is:**" + str, ExtentColor.CYAN));
			logSuccess("Expected Value - " + "Vacancy (Until Regular Hire)");
			logSuccess("Actual value - " + str);
			System.out.println(" selected value from the reason for replacement dropdown is:    " + str);
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**reason for replacement dropdown is not populated.**", ExtentColor.RED));
			logFailure("Expected Value - " + "Vacancy (Until Regular Hire)");
			logFailure("Actual value - " + str);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("reason for replacement dropdown is not populated");
		}
		if (wbsf_end_date.getAttribute("readonly").equals("true")) {
			logSuccess("End Date field is disable (or) grayed out");
		} else {

			logFailure("End Date field is  not disable (or) grayed out");
			logFailureScreenshot(driver);
		}
	}

	public void validate_reason_for_replacement_dropdown3() throws Exception {
		waitForElementToBeClickable(driver, wbsf_replacement);
		wbsf_replacement.click();
		waitForElementToBeClickable(driver, wbsf_replacement_search);
		wbsf_replacement_search.sendKeys("Other");
		waitForAction(driver);
		wbsf_replacement_search.sendKeys(Keys.TAB);
		waitForAction(driver);
		String str = wbsf_replacement.getText();
		if (str.contains("Other")) {
			test.get().log(Status.INFO, MarkupHelper.createLabel(
					"** selected value from the reason for replacement dropdown is:**" + str, ExtentColor.CYAN));
			logSuccess("Expected Value - " + "Other");
			logSuccess("Actual value - " + str);
			System.out.println("** selected value from the reason for replacement dropdown is:**" + str);
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**reason for replacement dropdown is not populated.**", ExtentColor.RED));
			logFailure("Expected Value - " + "Other");
			logFailure("Actual value - " + str);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("reason for replacement dropdown is not populated");
		}
	}

	public void validate_other_reason_for_replacement_field(String str) throws Exception {
		if (wbsf_other_replacement_reason.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**other replacement reason  field is populated**", ExtentColor.GREEN));
			waitForElementToBeClickable(driver, wbsf_other_replacement_reason);
			wbsf_other_replacement_reason.sendKeys(str);
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("** text entered on the other replacement reason  field  is**"
							+ wbsf_other_replacement_reason.getAttribute("value"), ExtentColor.GREEN));
			logSuccess("Expected Value - " + str);
			logSuccess("Actual Value - " + wbsf_other_replacement_reason.getAttribute("value"));
			System.out.println("**text entered on the other replacement reason  field  is**"
					+ wbsf_other_replacement_reason.getAttribute("value"));

		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**other replacement reason  field is not populated.**", ExtentColor.RED));
			logFailure("Expected Value - " + str);
			logFailure("Actual Value - " + wbsf_other_replacement_reason.getAttribute("value"));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("other replacement reason  field is not populated");
		}
	}

	public void validate_title_of_the_person_field(String str1) throws Exception {
		if (wbsf_person_title.isDisplayed() == true) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("**Title of Person being replaced field is populated **", ExtentColor.GREEN));
			waitForElementToBeClickable(driver, wbsf_person_title);
			wbsf_person_title.sendKeys(str1);
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("**text entered on the Title of Person being replaced field is**"
							+ wbsf_person_title.getAttribute("value"), ExtentColor.CYAN));
			logSuccess("Expected Value" + str1);
			logSuccess("Actual Value" + wbsf_person_title.getAttribute("value"));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("text entered on the Title of Person being replaced field is**"
					+ wbsf_person_title.getAttribute("value"));

		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("**Title of Person being replaced field is not populated**", ExtentColor.RED));
			logFailure("Expected Value" + str1);
			logFailure("Actual Value" + wbsf_person_title.getAttribute("value"));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Title of Person being replaced field is not populated");
		}
	}

//	public void validate_startdate(String str) throws Exception {
//		if (wbsf_start_date.isDisplayed() == true) {
//			test.get().log(Status.PASS,
//					MarkupHelper.createLabel("**start date field is populated**", ExtentColor.GREEN));
//			wbsf_start_date.sendKeys(str);
//
//			test.get().log(Status.PASS,
//					MarkupHelper.createLabel("** date enter in the start date field is**" + str, ExtentColor.GREEN));
//			System.out.println(" date enter in the start date field is**" + str);
//		} else {
//			test.get().log(Status.FAIL,
//					MarkupHelper.createLabel("**start date field is is not populated**", ExtentColor.RED));
//			screenshotPath = getScreenshot(driver, this.getClass().getName());
//			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//			System.out.println("start date field is is not populated");
//		}
//
//	}
	public void validate_startdate() throws Exception {
		if (wbsf_start_date.isDisplayed() == true) {
			logSuccess("**start date field is populated**");

			// java.time.LocalDateTime LocalDateTime = java.time.LocalDateTime.now();
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String currentDate = simpleDateFormat.format(new Date());
			LocalDate date1 = LocalDate.parse(currentDate, dateTimeFormatter);
			LocalDate date2 = date1.minusDays(3);
			System.out.println("Current Date Minus 3Days WebElement--> " + date2);
			String second_day = date2.toString();
			wbsf_start_date.clear();
			waitForAction(driver);
			waitForElementToBeClickable(driver, wbsf_start_date);
			wbsf_start_date.sendKeys(second_day);
			waitForAction(driver);
			wbsf_start_date.sendKeys(Keys.TAB);
			waitForAction(driver);

			logSuccess("** date enter in the start date field is**" + second_day);
			screenshotPath = getScreenshot(driver, this.getClass().getName());

		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**start date field is is not populated**", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("start date field is is not populated");
		}

	}

	public void validate_enddate1() throws Exception {
		scrollPageToElement(driver, label_wbsf_end_date);
		waitForElementToBeClickable(driver, wbsf_end_date);
		wbsf_end_date.clear();
		waitForAction(driver);
		scrollPageToElement(driver, label_reason_for_replacement_reason);
		waitForElementToBeClickable(driver, wbsf_enddate_button);
		wbsf_enddate_button.click();
		waitForElementToBeClickable(driver, wbsf_enddate_table_arrow);
		wbsf_enddate_table_arrow.click();
		waitForElementToBeClickable(driver, wbsf_enddate_day);
		wbsf_enddate_day.click();

		test.get().log(Status.PASS, MarkupHelper.createLabel("**enddate is populated**", ExtentColor.GREEN));
		String enddate = wbsf_end_date.getAttribute("value");
		test.get().log(Status.PASS,
				MarkupHelper.createLabel("**date entered in the enddate filed is**" + enddate, ExtentColor.GREEN));
		System.out.println("enddate is populated**");
	}

	public void validate_hours(String hours) throws Exception {
		if (wbsf_hours.isDisplayed() == true) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("**hours field is populated**", ExtentColor.GREEN));
			System.out.println("hours field is populated");
			waitForElementToBeClickable(driver, wbsf_hours);
			wbsf_hours.sendKeys(hours);

			test.get().log(Status.INFO, MarkupHelper.createLabel(
					"**text entered in the hours field is:**" + wbsf_hours.getAttribute("value"), ExtentColor.CYAN));
			logSuccess("Expected Value - " + hours);
			logSuccess("Actual Value - " + wbsf_hours.getAttribute("value"));
			System.out.println("text entered in the hours field is:  " + wbsf_hours.getAttribute("value"));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**hours field is not  populated.**", ExtentColor.RED));
			logFailure("Expected Value - " + hours);
			logFailure("Actual Value - " + wbsf_hours.getAttribute("value"));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("hours field is not  populated");
		}
	}

	public void validate_name_temp(String name) throws Exception {
		if (wbsf_name_of_preffered_temp.isDisplayed() == true) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**name of the preffered temp field is populated**", ExtentColor.GREEN));
			System.out.println("name of the preffered temp field is populated");
			waitForElementToBeClickable(driver, wbsf_name_of_preffered_temp);
			wbsf_name_of_preffered_temp.sendKeys(name);

			test.get().log(Status.INFO,
					MarkupHelper.createLabel("**text entered in the name of the preffered temp field is**"
							+ wbsf_name_of_preffered_temp.getAttribute("value"), ExtentColor.CYAN));
			logSuccess("Expected Value - " + name);
			logSuccess("Actual Value - " + wbsf_name_of_preffered_temp.getAttribute("value"));
			System.out.println("text entered in the name of the preffered temp field is:  "
					+ wbsf_name_of_preffered_temp.getAttribute("value"));
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("**name of the preffered temp field is not populated.**", ExtentColor.RED));
			logFailure("Expected Value - " + name);
			logFailure("Actual Value - " + wbsf_name_of_preffered_temp.getAttribute("value"));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("name of the preffered temp field is not populated");
		}
	}

	public void validate_building_roomno_field(String roomno) throws Exception {
		if (wbsf_building_roomno.isDisplayed() == true) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**building and room number field is populated**", ExtentColor.GREEN));
			System.out.println("building and room number field is populated");
			waitForElementToBeClickable(driver, wbsf_building_roomno);
			wbsf_building_roomno.sendKeys(roomno);

			test.get().log(Status.INFO,
					MarkupHelper.createLabel("**text entered in the building and room number field field is**"
							+ wbsf_building_roomno.getAttribute("value"), ExtentColor.CYAN));
			logSuccess("Expected Value - " + roomno);
			logSuccess("Actual Value - " + wbsf_building_roomno.getAttribute("value"));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("text entered in the building and room number field field is:  "
					+ wbsf_building_roomno.getAttribute("value"));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**building and room number field is not populated.**", ExtentColor.RED));
			logFailure("Expected Value - " + roomno);
			logFailure("Actual Value - " + wbsf_building_roomno.getAttribute("value"));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("building and room number field is not populated");
		}
	}

	public void validating_default_skills() throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", wbsf_name_of_preffered_temp);
		waitForAction(driver);

		String firstpart = "//select[@id='ratedSkill";
		String secondpart = "']";
		for (int i = 1; i <= 6; i++) {
			String finalpart = firstpart + i + secondpart;
			String s = new Select(driver.findElement(By.xpath(finalpart))).getFirstSelectedOption().getText();
			checkForPageLoad(driver);
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("**the default skill in the  skill dropdown is**" + s, ExtentColor.CYAN));
			System.out.println("the default skill in the  skill dropdown is:    " + s);
		}
	}

	public void validating_profecency_rating() throws Exception {
		String firstpart = "//select[@id='skillRating";
		String secondpart = "']";
		List<WebElement> s = new Select(driver.findElement(By.xpath("//select[@id='skillRating1']"))).getOptions();
		System.out.println("size of the dropdown is:   " + s.size());
		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j < s.size(); j++) {
				String finalpart1 = firstpart + i + secondpart;
				new Select(driver.findElement(By.xpath(finalpart1))).selectByVisibleText(s.get(j).getText());
				checkForPageLoad(driver);
				test.get().log(Status.INFO, MarkupHelper
						.createLabel("**the populated profeciency rating is**" + s.get(j).getText(), ExtentColor.CYAN));
				System.out.println("the populated profeciency rating is:    " + s.get(j).getText());
			}
		}
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	}

	public void validate_describe_job_duites(String str) throws Exception {
		if (wbsf_describe_job_duites.isDisplayed() == true) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("** describe daily job duites field is populated **", ExtentColor.GREEN));
			waitForElementToBeClickable(driver, wbsf_describe_job_duites);
			wbsf_describe_job_duites.sendKeys(str);

			test.get().log(Status.INFO,
					MarkupHelper.createLabel("**  text entered in the describe daily job duites  field is **"
							+ wbsf_describe_job_duites.getAttribute("value"), ExtentColor.CYAN));
			logSuccess("Expected Value - " + str);
			logSuccess("Actual Value - " + wbsf_describe_job_duites.getAttribute("value"));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println(
					"describe daily job duites field is populated and text entered in the describe daily job duites  field is:    "
							+ wbsf_describe_job_duites.getAttribute("value"));
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("**describe daily job duites  field is not autopopulated**", ExtentColor.RED));
			logFailure("Expected Value - " + str);
			logFailure("Actual Value - " + wbsf_describe_job_duites.getAttribute("value"));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("describe daily job duites  field is not autopopulated");
		}
	}

	public String validate_submit_button() throws Exception {
		waitForElementToBeClickable(driver, wbsf_submit);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", wbsf_submit);
		checkForPageLoad(driver);
		scrollToElement(driver, wbsf_submit);
		waitForAction(driver);
		waitForElementToBeClickable(driver, wbsf_submit);
		wbsf_submit.click();
		waitForAction(driver);
		checkForPageLoad(driver);

		waitForElement(driver, caseid);
		waitForElementToBeClickable(driver, caseid);
		String casenumber = caseid.getText();
		System.out.println("hr case number is: " + casenumber);
		test.get().log(Status.INFO, MarkupHelper.createLabel("**HR Case Number is **" + casenumber, ExtentColor.CYAN));
		return casenumber;
	}

	public String verifyHRTikcetPage() throws IOException {
		checkForPageLoad(driver);
		if (wbsf_casediscription.getText().contains("Case Description")) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("**HR Ticket Page is visible**", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("HR Ticket Page is visible");
		} else

		{
			test.get().log(Status.FAIL, MarkupHelper.createLabel("**HR Ticket Page is not visible**", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("HR Ticket Page is  not visible");
		}
		String url = driver.getCurrentUrl();
		System.out.println("URL is - " + url);

		return url;
	}

	// validating the reject supervisor request
	public void rejectCase(String casenumber, String url) throws Exception {
		String approver = "";
		List<String> approverList = new ArrayList<String>();
		driver.navigate().to(homePageURL);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.sendKeys("CASE");
		checkForPageLoad(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		waitForElementToBeClickable(driver, xpOpen);
		js.executeScript("arguments[0].click();", xpOpen);
		checkForPageLoad(driver);
		checkForPageLoad(driver);
		driver.switchTo().frame(0);

		if (xpCasesPage.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Successfully Navigate to HR Cases Page", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Navigation Failed to reach the HR Cases Page", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		Select select = new Select(searchNumberDropDown);
		select.selectByVisibleText("Number");
		checkForPageLoad(driver);
		try {
			waitForElementToBeClickable(driver, xpNumberSearch);
			xpNumberSearch.sendKeys(casenumber.trim(), Keys.ENTER);
		} catch (Exception e) {
			waitForElementToBeClickable(driver, xpSearchIcon);
			xpSearchIcon.click();
			waitForElementToBeClickable(driver, xpNumberSearch);
			xpNumberSearch.sendKeys(casenumber.trim(), Keys.ENTER);
		}

		logInfo("Search for the case id= - " + casenumber);
		waitForFrameToBeAvailable(driver, "gsft_main");
		checkForPageLoad(driver);
		// xpUniqueCaseId.click();
		waitForElementToBeClickable(driver, xpUniqueCaseId);
		js.executeScript("arguments[0].click();", xpUniqueCaseId);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, xpApproverTab);
		js.executeScript("arguments[0].scrollIntoView(true);", xpApproverTab);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, xpApproverTab);
		xpApproverTab.click();
		waitForFrameToBeAvailable(driver, "gsft_main");
		logInfo("Clicking the approvers tab");

		for (int i = 0; i < xpState.size(); i++) {
			// int count = 0;
			// for loop
			for (int j = 0; j < xpState.size(); j++) {
				if (xpState.get(j).getText().equals("Requested")) {
					approverList.clear();
					waitForAction(driver);
					test.get().log(Status.PASS,
							MarkupHelper.createLabel("Searching for the Requested Approver", ExtentColor.GREEN));
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					logInfo("Approvers Present - " + approvers.size());
					for (int j2 = 0; j2 < approvers.size(); j2++) {
						approverList.add(approvers.get(j2).getText());
					}
					waitForElementToBeClickable(driver, xpState.get(j));
					xpState.get(j).click();
					waitForFrameToBeAvailable(driver, "gsft_main");
					// count++;
				}
			}

			driver.switchTo().defaultContent();
			waitForElementToBeClickable(driver, userMenu);
			userMenu.click();
			waitForFrameToBeAvailable(driver, "gsft_main");
			// driver.switchTo().frame(0);
			// xpHeader.click();
			// js.executeScript("arguments[0].click();", xpHeader);
			driver.switchTo().defaultContent();
			waitForElement(driver, impUser);
			waitForElementToBeClickable(driver, impUser);
			js.executeScript("arguments[0].click();", impUser);
			waitForElementToBeClickable(driver, impUserDropDwn);
			impUserDropDwn.click();

			for (int j = 0; j < approverList.size(); j++) {
				approver = approverList.get(j).trim();
				System.out.println("Approver is - " + approver);
				logInfo("Impersonating as approver - " + approver);
				System.out.println(" - " + approver);
				impUserSendkys.clear();
				waitForAction(driver);
				waitForElementToBeClickable(driver, impUserSendkys);
				impUserSendkys.sendKeys(approverList.get(j).trim());
				checkForPageLoad(driver);
				waitForAction(driver);
				waitForElementToBeClickable(driver, impersonateApproverName);
				if (isElementPresent(impersonateApproverName)
						&& impersonateApproverName.getText().trim().equalsIgnoreCase(approver)) {
					test.get().log(Status.INFO,
							MarkupHelper.createLabel("Impersonator Avaiable - " + approver, ExtentColor.AMBER));
				} else if (isElementPresent(noMatchesFoundImpersonate)) {
					test.get().log(Status.INFO,
							MarkupHelper.createLabel("Unable to Impersonate as - " + approver, ExtentColor.AMBER));
				}
			}
			impUserSendkys.sendKeys(Keys.ENTER);
			waitForAction(driver);
			logInfo("Impersonated as User - " + approver);
			checkForPageLoad(driver);

			/*
			 * if (isElementPresent(adminPortalGear)) { waitForElementToBeClickable(driver,
			 * adminPortalGear); adminPortalGear.click(); } else { driver.get(homePageURL);
			 * }
			 */

			if (isElementPresent(leftSearch)) {
				waitForElement(driver, leftSearch);
				leftSearch.clear();
				waitForAction(driver);
				waitForElementToBeClickable(driver, leftSearch);
				leftSearch.sendKeys("My Approvals");
				checkForPageLoad(driver);
				waitForElement(driver, xpMyApprovals);
				waitForElementToBeClickable(driver, xpMyApprovals);
				xpMyApprovals.click();

				waitForFrameToBeAvailable(driver, "gsft_main");
				waitForElement(driver, xpApprovalFor);
				try {
					waitForElementToBeClickable(driver, xpApprovalFor);
					xpApprovalFor.sendKeys(casenumber.trim());
					waitForElementToBeClickable(driver, xpEnterState);
					xpEnterState.sendKeys("Requested");
					waitForAction(driver);
					xpApprovalFor.sendKeys(Keys.ENTER);
					// checkForPageLoad(driver);
				} catch (Exception e) {
					waitForElementToBeClickable(driver, xpApprovalSearchIcon);
					xpApprovalSearchIcon.click();
					waitForElementToBeClickable(driver, xpApprovalFor);
					xpApprovalFor.sendKeys(casenumber.trim());
					waitForElementToBeClickable(driver, xpEnterState);
					xpEnterState.sendKeys("Requested");
					xpApprovalFor.sendKeys(Keys.ENTER);
				}
				waitForFrameToBeAvailable(driver, "gsft_main");
				waitForElementToBeClickable(driver, xpImpState);
				xpImpState.click();

				waitForFrameToBeAvailable(driver, "gsft_main");
				if (isElementPresent(xpRejectComments)) {
					waitForElementToBeClickable(driver, xpRejectComments);
					xpRejectComments.sendKeys("Automation Rejection");
				} else if (isElementPresent(xpRejectComment2)) {
					waitForElementToBeClickable(driver, xpRejectComment2);
					xpRejectComment2.sendKeys("Automation Rejection");
				} else {
					logFailure("Comment Box to enter Rejection Comment is not displayed or check for approval state.");
					logFailureScreenshot(driver);
				}
				logInfo("clicking the reject button");
				waitForElementToBeClickable(driver, rejectbutton);
				rejectbutton.click();

				waitForFrameToBeAvailable(driver, "gsft_main");
				waitForElementToBeClickable(driver, xpUpdatebtn);
				xpUpdatebtn.click();
				waitForFrameToBeAvailable(driver, "gsft_main");

				// checkForPageLoad(driver);
				if (isElementPresent(xpConfirmReject) && xpConfirmReject.getText().contains(casenumber)) {
					logSuccess("Successfully Reject the case number:" + casenumber + " and reject approver name= "
							+ approver);
					logSuccessScreenshot(driver);
					break;
				} else {
					logFailure("Failed to Reject the case number:" + casenumber);
					logSuccessScreenshot(driver);
				}
			} else {
				driver.get(hrPortalURL);
				checkForPageLoad(driver);
				driver.navigate().to(url);
				// driver.get(url);
				checkForPageLoad(driver);

				int count = 0;
				while (!waitForElementToBeClickable(driver, xpRejectbtn) && count < 2) {
					js.executeScript("document.location.reload();");
					System.out.println("Refreshing using JS");
					waitForElement(driver, xpRejectbtn);
					checkForPageLoad(driver);
					count++;
				}

				scrollToElement(driver, xpRejectbtn);
				logInfo("Clicking the Reject button");
				logSuccessScreenshot(driver);
				waitForElementToBeClickable(driver, xpRejectbtn);
				js.executeScript("arguments[0].click();", xpRejectbtn);
				// xpRejectbtn.click();
				if (isElementPresent(xpRejectComment3)) {
					waitForElementToBeClickable(driver, xpRejectComment3);
					xpRejectComment3.sendKeys("Automation Rejection");
					logInfo("Text entered on the comment box is :" + xpRejectComment3.getAttribute("value"));
					logSuccessScreenshot(driver);
				} else {
					logFailure("Comment Box to enter Rejection Comment is not displayed or check for approval state.");
					logFailureScreenshot(driver);
				}
				logInfo("clicking the reject button");
				waitForElementToBeClickable(driver, rejectbutton2);
				rejectbutton2.click();
				checkForPageLoad(driver);
				scrollPageToElement(driver, rejectedtext);
				if (isElementPresent(rejectedtext)) {
					logSuccess("Successfully Reject the case number:" + casenumber + " and reject approver name= "
							+ approver);
					logSuccessScreenshot(driver);
				} else {
					logFailure("Failed to Reject the case number:" + casenumber);
					logSuccessScreenshot(driver);
				}
			}
			driver.switchTo().defaultContent();
			logInfoScreenshot(driver);
		}

	}

	public void validate_approver_information1(String str1) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", wbsf_select_employee);
		waitForAction(driver);
		waitForElementToBeClickable(driver, wbsf_assignment_information);
		wbsf_assignment_information.click();

		waitForElementToBeClickable(driver, wbsf_assignment_information_search);
		wbsf_assignment_information_search.sendKeys(str1);
		waitForAction(driver);
		wbsf_assignment_information_search.sendKeys(Keys.TAB);
		waitForAction(driver);
	}
}