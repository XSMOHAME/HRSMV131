package com.snow.pageobjects;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.snow.base.ReusableLibrary;

public class AccessingandSubmittingtheForm1 extends ReusableLibrary {
	public WebDriver driver;

	public AccessingandSubmittingtheForm1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='q']")
	public WebElement wbsf_searchbar;

	@FindBy(xpath = "//i[@class='fa fa-search']")
	public WebElement wbsf_searchbar_click;

	@FindBy(xpath = "//span[contains(text(),'WBSF Temp Request Form')] ")
	public WebElement wbsf_temp_form;

	@FindBy(xpath = "//h1[contains(text(),'WBSF Temp Request Form')]")
	public WebElement wbsf_request_form;

	@FindBy(xpath = "//div[@id='s2id_sp_formfield_select_employee']/a")
	public WebElement wbsf_select_employee;

	@FindBy(xpath = "//label[contains(text(),'Select Employee')]//following-sibling::input")
	public WebElement wbsf_select_employee_search;

	@FindBy(xpath = "//*[@class ='select2-no-results']")
	public WebElement wbsf_select_employee_error_message;

	@FindBy(xpath = "//button[@class='btn btn-default bg-white lookup']")
	public WebElement wbsf_select_employee_button;

	@FindBy(xpath = "(//span[@class='select2-chosen'])[14]")
	public WebElement wbsf_select_employee_costcenter;

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

	@FindBy(xpath = "//input[@id='sp_formfield_department']")
	public WebElement wbsf_department_information;

	@FindBy(xpath = "//input[@id='s2id_autogen1_search']")
	public WebElement wbsf_assignment_information_search;

	@FindBy(xpath = "//*[@id='s2id_sp_formfield_cost_center']")
	//// *[contains(@class,'disabled') and @id='s2id_sp_formfield_user.cost_center']
	public WebElement costcenter_field;

	@FindBy(xpath = "//*[@id='select2-results-1']//li")
	public WebElement wbsf_assignment_information_list;

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

	@FindBy(xpath = "//input[@id='sp_formfield_start_date']")
	public WebElement wbsf_start_date;

	@FindBy(xpath = "//label[@class='field-label ng-binding ng-scope'][contains(text(),'End Date')]")
	public WebElement label_wbsf_end_date;
	
	@FindBy(xpath = "//input[@id='sp_formfield_end_date']")
	public WebElement wbsf_end_date;

	@FindBy(xpath = "//div[contains(@class,'wrapper-xs r m-t-xs ng-binding ng-scope bg-danger')]")
	public WebElement wbsf_enddate_error_message;

	@FindBy(xpath = "//div[@class='wrapper-xs r m-t-xs ng-binding ng-scope bg-danger']")
	public WebElement wbsf_EndDate_prior_to_the_startdate_error_message;

	public void search_wbsf() throws Exception {
		waitForElementToBeClickable(driver, wbsf_searchbar);
		wbsf_searchbar.sendKeys("WBSF Temp Request Form");
		waitForAction(driver);
		if (wbsf_searchbar.getAttribute("value").equalsIgnoreCase("WBSF Temp Request Form")) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("**WBSF Temp Request form appeared on the dropdown**", ExtentColor.CYAN));
			logInfo("Expected Value - " + "WBSF");
			logInfo("Actual Value - " + wbsf_searchbar.getAttribute("value"));
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
		wbsf_searchbar.sendKeys(Keys.DOWN, Keys.ENTER);
	}

	public void open_wbsf_request_form() throws Exception {
		waitForElement(driver, wbsf_request_form);
		checkForPageLoad(driver);
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

	public void validate_inactive_users(String str) throws Exception {
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, wbsf_select_employee);
		wbsf_select_employee.click();

		waitForElementToBeClickable(driver, wbsf_select_employee_search);
		wbsf_select_employee_search.sendKeys(str);
		waitForAction(driver);

		waitForElementToBeClickable(driver, wbsf_select_employee_error_message);
		String str1 = wbsf_select_employee_error_message.getText();
		wbsf_select_employee_search.sendKeys(Keys.TAB);
		waitForAction(driver);

		if (str1.equalsIgnoreCase("No matches found")) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("**Inactive users are not available  in the dropdown**", ExtentColor.GREEN));
			logSuccess("Expected Value - " + "No matches found");
			logSuccess("Actual Value - " + str1);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Inactive users are  not available in the dropdown");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**Inactive users are  available in the dropdown**", ExtentColor.RED));
			logFailure("Expected Value - " + "No matches found");
			logFailure("Actual Value - " + str1);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Inactive users are  available in the dropdown");
		}
	}

	public void validate_nonwbsf_users(String str) throws Exception {
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, wbsf_select_employee);
		wbsf_select_employee.click();

		waitForElementToBeClickable(driver, wbsf_select_employee_search);
		wbsf_select_employee_search.sendKeys(str);
		waitForAction(driver);

		waitForElement(driver, wbsf_select_employee_error_message);
		String str1 = wbsf_select_employee_error_message.getText();
		wbsf_select_employee_search.sendKeys(Keys.TAB);
		waitForAction(driver);

		if (str1.equalsIgnoreCase("No matches found")) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("**nonwbsf users are not available  in the dropdown**",
					ExtentColor.GREEN));
			logSuccess("Expected Value - " + "No matches found");
			logSuccess("Actual Value - " + str1);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("nonwbsf users are  not available in the dropdown");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**nonwbsf users are  available in the dropdown**", ExtentColor.RED));
			logFailure("Expected Value - " + "No matches found");
			logFailure("Actual Value - " + str1);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("nonwbsf users are  available in the dropdown");
		}
	}

	public void validate_nonsupervisors_users(String str) throws Exception {
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, wbsf_select_employee);
		wbsf_select_employee.click();

		waitForElementToBeClickable(driver, wbsf_select_employee_search);
		wbsf_select_employee_search.sendKeys(str);
		waitForAction(driver);

		waitForElement(driver, wbsf_select_employee_error_message);
		String str1 = wbsf_select_employee_error_message.getText();
		wbsf_select_employee_search.sendKeys(Keys.TAB);
		waitForAction(driver);

		if (str1.equalsIgnoreCase("No matches found")) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("**non supervisor users are not available  in the dropdown**", ExtentColor.GREEN));
			logSuccess("Expected Value - " + "No matches found");
			logSuccess("Actual Value - " + str1);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("non supervisor user are not available in the dropdown");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**non supervisor users  available in the dropdown**", ExtentColor.RED));
			logFailure("Expected Value - " + "No matches found");
			logFailure("Actual Value - " + str1);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("non supervisor users  available in the dropdown");
		}
	}

	public void validate_Supervisors_and_above_WBSF_employees_are_in_the_dropdown_or_not(String wbsfemployee)
			throws Exception {
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, wbsf_select_employee);
		wbsf_select_employee.click();

		waitForElementToBeClickable(driver, wbsf_select_employee_search);
		wbsf_select_employee_search.sendKeys(wbsfemployee);
		waitForAction(driver);
		wbsf_select_employee_search.sendKeys(Keys.TAB);
		waitForElement(driver, wbsf_select_employee);
		String str1 = wbsf_select_employee.getText().trim();
		waitForAction(driver);
		if (str1.contains(wbsfemployee)) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"**Supervisors and above WBSF employees are available in the dropdown**", ExtentColor.GREEN));
			logSuccess("Expected Value - " + wbsfemployee);
			logSuccess("Actual Value - " + str1);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Supervisors and above WBSF employees are available in the dropdown");
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"**Supervisors and above WBSF employees are not available in the dropdown**", ExtentColor.RED));
			logFailure("Expected Value - " + wbsfemployee);
			logFailure("Actual Value - " + str1);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Supervisors and above WBSF employees are not available in the dropdown");
		}
	}

	public void validate_employee_information(String str) throws Exception {
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, wbsf_select_employee);
		wbsf_select_employee.click();
		waitForElementToBeClickable(driver, wbsf_select_employee_search);
		wbsf_select_employee_search.sendKeys(str);
		waitForAction(driver);
		wbsf_select_employee_search.sendKeys(Keys.TAB);
		checkForPageLoad(driver);
		waitForElement(driver, wbsf_select_employee);
		String str1 = wbsf_select_employee.getText().trim();
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
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, wbsf_select_employee);
		wbsf_select_employee.click();

		waitForElementToBeClickable(driver, wbsf_select_employee_search);
		wbsf_select_employee_search.sendKeys(str);
		waitForAction(driver);
		wbsf_select_employee_search.sendKeys(Keys.TAB);
		waitForAction(driver);
		wbsf_select_employee_button.click();
		waitForAction(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", wbsf_select_employee_costcenter);
		waitForAction(driver);
		test.get().log(Status.INFO, MarkupHelper.createLabel("**HR profile page open**", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		System.out.println("HR profile page open");

		scrollPageToElement(driver, wbsf_select_employee_costcenter);
		waitForElementToBeClickable(driver, wbsf_select_employee_costcenter);
		String text = wbsf_select_employee_costcenter.getText().trim();

		waitForElementToBeClickable(driver, wbsf_select_employee_close_button);
		wbsf_select_employee_close_button.click();
		waitForElement(driver, wbsf_department_information);
		String str1 = wbsf_department_information.getAttribute("value").trim();
		waitForAction(driver);
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
		waitForAction(driver);
		waitForElementToBeClickable(driver, wbsf_alternate_cost_center);
		wbsf_alternate_cost_center.click();

		waitForElementToBeClickable(driver, wbsf_alternate_cost_center_search);
		wbsf_alternate_cost_center_search.sendKeys(costcenter);
		wbsf_alternate_cost_center_search.sendKeys(Keys.TAB);
		waitForAction(driver);

		waitForElement(driver, wbsf_alternate_cost_center);
		String str = wbsf_alternate_cost_center.getText();
		waitForAction(driver);
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
		wbsf_field_searchh.sendKeys(Keys.TAB);
		waitForAction(driver);

		waitForElement(driver, wbsf_field);
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
		checkForPageLoad(driver);
		if (wbsf_request_type.isDisplayed() == true) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**Request Type dropdown is Populated**", ExtentColor.GREEN));

			System.out.println("Request Type dropdown is  Populated");
			waitForElementToBeClickable(driver, wbsf_request_type);
			wbsf_request_type.click();

			waitForElementToBeClickable(driver, wbsf_request_type_search);
			wbsf_request_type_search.sendKeys("Replacement");
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
		checkForPageLoad(driver);
		if (wbsf_person_name_replaced.isDisplayed() == true) {
			System.out.println("Name of person being replaced field is populated");
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("**Name of person being replaced field is populated**   ", ExtentColor.GREEN));
			wbsf_person_name_replaced.sendKeys(str);
			waitForAction(driver);

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
		wbsf_replacement_search.sendKeys(Keys.TAB);
		waitForElement(driver, wbsf_replacement);
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

		waitForAction(driver);
		if (wbsf_end_date.getAttribute("readonly").equals("true")) {
			logSuccess("End Date field is disable (or) grayed out");
		} else {
			logFailure("End Date field is  not disable (or) grayed out");
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	public void validate_reason_for_replacement_dropdown2() throws Exception {
		waitForElementToBeClickable(driver, wbsf_replacement);
		wbsf_replacement.click();
		waitForElementToBeClickable(driver, wbsf_replacement_search);
		wbsf_replacement_search.sendKeys("Vacancy (Until Regular Hire)");
		wbsf_replacement_search.sendKeys(Keys.TAB);
		waitForElement(driver, wbsf_replacement);
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
		waitForAction(driver);
		if (wbsf_end_date.getAttribute("readonly").equals("true")) {
			logSuccess("End Date field is disable (or) grayed out");
		} else {
			logFailure("End Date field is  not disable (or) grayed out");
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	public void validate_reason_for_replacement_dropdown3() throws Exception {
		waitForElementToBeClickable(driver, wbsf_replacement);
		wbsf_replacement.click();
		waitForElementToBeClickable(driver, wbsf_replacement_search);
		wbsf_replacement_search.sendKeys("Other");
		wbsf_replacement_search.sendKeys(Keys.TAB);
		waitForElement(driver, wbsf_replacement);
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
		waitForElementToBeClickable(driver, wbsf_other_replacement_reason);
		if (wbsf_other_replacement_reason.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**other replacement reason  field is populated**", ExtentColor.GREEN));
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
		waitForElementToBeClickable(driver, wbsf_person_title);
		if (wbsf_person_title.isDisplayed() == true) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("**Title of Person being replaced field is populated **", ExtentColor.GREEN));
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

	public void validate_startdate() throws Exception {
		waitForElementToBeClickable(driver, wbsf_start_date);
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
			wbsf_start_date.sendKeys(second_day);
			wbsf_start_date.sendKeys(Keys.TAB);
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

	public void validate_enddate() throws Exception {
		scrollToElement(driver, label_wbsf_end_date);
		if (wbsf_end_date.isDisplayed() == true) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("**enddate field is populated**", ExtentColor.GREEN));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sdf.setTimeZone(TimeZone.getTimeZone("PST"));
			Date d = new Date();
			String date = sdf.format(d);
			System.out.println("todays date is" + date);
			wbsf_end_date.sendKeys(date);
			wbsf_end_date.sendKeys(Keys.TAB);
			waitForAction(driver);
			wbsf_start_date.click();
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("**date entered in the enddate filed is**" + date, ExtentColor.CYAN));
			System.out.println("date entered in the enddate filed is**" + date);
			waitForElement(driver, wbsf_enddate_error_message);
			String str1 = wbsf_enddate_error_message.getText();
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("**error message appered below the enddate field is**" + str1, ExtentColor.GREEN));
			System.out.println("error message appered below the enddate field is**" + str1);
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**end date field is is not populated**", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("end date field is is not populated");
		}
	}

	public void validate_EndDate_prior_to_the_startdate() throws Exception {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = simpleDateFormat.format(new Date());
		LocalDate date1 = LocalDate.parse(currentDate, dateTimeFormatter);
		LocalDate date2 = date1.minusDays(2);
		System.out.println("Current Date Minus 2Days WebElement--> " + date2);
		String fourth_day = date2.toString();
		wbsf_end_date.clear();
		wbsf_end_date.sendKeys(fourth_day);
		wbsf_end_date.sendKeys(Keys.TAB);
		waitForAction(driver);
		wbsf_start_date.click();
		
		waitForElement(driver, wbsf_EndDate_prior_to_the_startdate_error_message);
		String message = wbsf_EndDate_prior_to_the_startdate_error_message.getText();
		System.out.println(message);
		if (message.contains("\"End Date\" must be greater than the current date.")) {
			System.out.println("**  date entered in the end date  field is**" + fourth_day);
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("**  date entered in the end date  field is**" + fourth_day, ExtentColor.CYAN));
			logSuccess("**error message appered below the enddate field is**" + message);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			logSuccess("Expected Value - " + "\"End Date\" must be greater than the current date.");
			logSuccess("Actual Value - " + message);
			System.out.println("error message appered below the enddate field is**" + message);
		} else {
			logFailure("**error message should not appered below the enddate field **");
			logFailure("Expected Value - " + "\"End Date\" must be greater than the current date.");
			logFailure("Actual Value - " + message);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("error message should not appered below the enddate field");
		}

		LocalDate date3 = date1.plusDays(3);
		LocalDate date4 = date1.plusDays(5);
		String datefour = date4.toString();
		wbsf_start_date.clear();
		wbsf_end_date.clear();
		wbsf_start_date.sendKeys(datefour);
		String datethree = date3.toString();
		wbsf_end_date.sendKeys(datethree);
		wbsf_end_date.sendKeys(Keys.TAB);
		waitForAction(driver);
		wbsf_start_date.click();
		
		waitForElement(driver, wbsf_EndDate_prior_to_the_startdate_error_message);
		String message1 = wbsf_EndDate_prior_to_the_startdate_error_message.getText();
		if (message1.contains("\"End Date\" must be greater than the \"Start Date\" provided.")) {
			System.out.println("**  date entered in the end date  field is**" + datethree);
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("**  date entered in the end date  field is**" + datethree, ExtentColor.CYAN));
			logSuccess("Expected Value - " + "\"End Date\" must be greater than the \"Start Date\" provided.");
			logSuccess("Actual Value - " + message1);

			test.get().log(Status.PASS, MarkupHelper
					.createLabel("**error message appered below the enddate field is**" + message1, ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("error message appered below the enddate field is**" + message1);
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("**error message should not appered below the enddate field **", ExtentColor.RED));
			logFailure("Expected Value - " + "\"End Date\" must be greater than the \"Start Date\" provided.");
			logFailure("Actual Value - " + message1);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("error message should not appered below the enddate field");
		}
	}
}