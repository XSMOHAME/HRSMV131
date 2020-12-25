package com.snow.pageobjects;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
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

public class AccessingandSubmittingtheForm3 extends ReusableLibrary {
	public WebDriver driver;

	public AccessingandSubmittingtheForm3(WebDriver driver) {
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

	@FindBy(xpath = "//label[contains(text(),'Select Employee')]//following-sibling::input")
	public WebElement wbsf_select_employee_search;

	@FindBy(xpath = "//ul[@id='select2-results-7']/li")
	public List<WebElement> wbsf_select_employee_names;

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

	@FindBy(xpath = "//div[@id='s2id_sp_formfield_cost_center']/a")
	public WebElement wbsf_assignment_information;

	@FindBy(xpath = "//input[@id='s2id_autogen1_search']")
	public WebElement wbsf_assignment_information_search;

	@FindBy(xpath = "//input[@id='sp_formfield_department']")
	public WebElement wbsf_department_information;

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

	@FindBy(xpath = "//textarea[@id='sp_formfield_business_justification']")
	public WebElement wbsf_business_justification;

	@FindBy(xpath = "//div[@id='s2id_sp_formfield_number_of_temps_needed']/a")
	public WebElement wbsf_temps_needed;

	@FindBy(xpath = "//input[@id='sp_formfield_start_date']")
	public WebElement wbsf_start_date;

	@FindBy(xpath = "//input[@id='sp_formfield_end_date']")
	public WebElement wbsf_end_date;

	@FindBy(xpath = "//div[contains(@class,'wrapper-xs r m-t-xs ng-binding ng-scope bg-danger')]")
	public WebElement wbsf_enddate_error_message;

	@FindBy(xpath = "//div[@class='wrapper-xs r m-t-xs ng-binding ng-scope bg-danger']")
	public WebElement wbsf_EndDate_prior_to_the_startdate_error_message;

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

	@FindBy(xpath = "//select[@id='ratedSkill7']")
	public WebElement wbsf_table_skills7;

	@FindBy(xpath = "//select[@id='skillRating7']")
	public WebElement wbsf_table_proficiency7;

	@FindBy(xpath = "//*[@id='sp_formfield_other_software']")
	public WebElement wbsf_other_software;

	@FindBy(xpath = "//select[@id='ratedSkill8']")
	public WebElement wbsf_table_skills8;

	@FindBy(xpath = "//select[@id='skillRating8']")
	public WebElement wbsf_table_proficiency8;

	@FindBy(xpath = "//select[@id='ratedSkill9']")
	public WebElement wbsf_table_skills9;

	@FindBy(xpath = "//select[@id='skillRating9']")
	public WebElement wbsf_table_proficiency9;

	@FindBy(xpath = "//select[@id='ratedSkill10']")
	public WebElement wbsf_table_skills10;

	@FindBy(xpath = "//select[@id='skillRating10']")
	public WebElement wbsf_table_proficiency10;

	@FindBy(xpath = "//select[@id='ratedSkill11']")
	public WebElement wbsf_table_skills11;

	@FindBy(xpath = "//select[@id='skillRating11']")
	public WebElement wbsf_table_proficiency11;

	@FindBy(xpath = "(//*[@class='text-muted'])[2]")
	public WebElement wbsf_additional_requirements_text;

	@FindBy(xpath = "//select[@id='availableSkills']")
	public WebElement wbsf_available_skills_dropdown;

	@FindBy(xpath = "//select[@id='selectedSkills']")
	public WebElement wbsf_selected_skills_dropdown;

	@FindBy(xpath = "//button[@class='btn fa fa-angle-double-right fa-lg'] ")
	public WebElement wbsf_double_right_arrow;

	@FindBy(xpath = "//*[@class='btn fa fa-angle-right fa-lg']")
	public WebElement wbsf_single_right_arrow;

	@FindBy(xpath = "//*[@class='btn fa fa-angle-double-left fa-lg']")
	public WebElement wbsf_double_left_arrow;

	@FindBy(xpath = "//*[@class='btn fa fa-angle-left fa-lg']")
	public WebElement wbsf_single_left_arrow;

	@FindBy(xpath = "//*[@id='sp_formfield_other_o_s']")
	public WebElement wbsf_otheros;

	@FindBy(xpath = "//label[@for='sp_formfield_other_software']/span")
	public WebElement os_mandatory;

	@FindBy(xpath = "//*[@id='sp_formfield_other_skill_requirements']")
	public WebElement wbsf_other_skill_requirements;

	@FindBy(xpath = "//*[@class='alert alert-info ng-scope']/label[1]")
	public WebElement wbsf_required_information;

	@FindBy(xpath = "//*[@id='sp_formfield_daily_job_duties']")
	public WebElement wbsf_describe_job_duites;

	@FindBy(xpath = "(//span[@class='ng-binding'])[1]")
	public WebElement wbsf_describe_job_duites_error_message;

	@FindBy(xpath = "(//span[@class='glyphicon glyphicon-calendar'])[2]")
	public WebElement wbsf_enddate_button;

	@FindBy(xpath = "(//div[@class='datepicker'])[2]/div[1]/table/thead/tr[1]/th[2]")
	public WebElement wbsf_enddate_table;

	@FindBy(xpath = "(//div[@class='datepicker'])[2]/div[1]/table/thead/tr[1]/th[3]")
	public WebElement wbsf_enddate_table_arrow;

	@FindBy(xpath = "(//div[@class='datepicker'])[2]/div[1]/table/tbody/tr/td/div[contains(text(),'17')]")
	public WebElement wbsf_enddate_day;

	// @FindBy(xpath = "//h4[@class='panel-title']")
	@FindBy(xpath = "//h4[contains(text(),'Case Description')]")
	public WebElement wbsf_casediscription;

	@FindBy(xpath = "//div[@class='panel-body ng-binding']")
	public WebElement wbsf_casediscription_text;

	@FindBy(xpath = "//input[@id='sp_formfield_level_1_approver_name']")
	public WebElement wbsf_approver_name;

	@FindBy(xpath = "//input[@id='sp_formfield_level_1_approver_email']")
	public WebElement wbsf_approver_email;

	@FindBy(xpath = "//input[@id='sp_formfield_hr_approver_name']")
	public WebElement wbsf_approver_group;

	@FindBy(xpath = "//*[text()='Additional Requirements']")
	public WebElement additionalRequirementsLable;

	@FindBy(xpath = "(//button[@name='submit'])[1]")
	public WebElement wbsf_submit;
	@FindBy(xpath = "//div[@class='title-info ng-binding']")
	public WebElement ch_caseID;

	public void search_wbsf() throws Exception {
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, wbsf_searchbar);
		wbsf_searchbar.sendKeys("WBSF");
		if (wbsf_searchbar.getAttribute("value").equalsIgnoreCase("WBSF")) {
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
		waitForElementToBeClickable(driver, wbsf_searchbar_click);
		wbsf_searchbar_click.click();
		// wbsf_temp_form.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		waitForElementToBeClickable(driver, wbsf_temp_form);
		executor.executeScript("arguments[0].click();", wbsf_temp_form);

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

	public void validate_inactive_users(String str) throws Exception {
		waitForElementToBeClickable(driver, wbsf_select_employee);
		wbsf_select_employee.click();
		waitForElementToBeClickable(driver, wbsf_select_employee_search);
		wbsf_select_employee_search.sendKeys(str);
		String str1 = wbsf_select_employee_error_message.getText();
		waitForElementToBeClickable(driver, wbsf_select_employee_search);
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
		}

		else {
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
		waitForElementToBeClickable(driver, wbsf_select_employee);
		wbsf_select_employee.click();
		waitForElementToBeClickable(driver, wbsf_select_employee_search);
		wbsf_select_employee_search.sendKeys(str);
		String str1 = wbsf_select_employee_error_message.getText();
		waitForElementToBeClickable(driver, wbsf_select_employee_search);
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
		}

		else {
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
		waitForElementToBeClickable(driver, wbsf_select_employee);
		wbsf_select_employee.click();
		waitForElementToBeClickable(driver, wbsf_select_employee_search);
		wbsf_select_employee_search.sendKeys(str);
		String str1 = wbsf_select_employee_error_message.getText();
		waitForElementToBeClickable(driver, wbsf_select_employee_search);
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
		}

		else {
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
		waitForElementToBeClickable(driver, wbsf_select_employee);
		wbsf_select_employee.click();
		waitForElementToBeClickable(driver, wbsf_select_employee_search);
		wbsf_select_employee_search.sendKeys(wbsfemployee);
		wbsf_select_employee_search.sendKeys(Keys.TAB);
		waitForAction(driver);
		String str1 = wbsf_select_employee.getText();
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

		scrollPageToElement(driver, wbsf_select_employee_costcenter);
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
		waitForAction(driver);

		waitForElementToBeClickable(driver, wbsf_alternate_cost_center);
		wbsf_alternate_cost_center.click();
		waitForElementToBeClickable(driver, wbsf_alternate_cost_center);
		wbsf_alternate_cost_center_search.sendKeys(costcenter);
		waitForAction(driver);
		wbsf_alternate_cost_center_search.sendKeys(Keys.TAB);
		waitForAction(driver);
		String str = wbsf_alternate_cost_center.getText();
		if (str.contains(costcenter)) {
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
		wbsf_field_searchh.sendKeys("Union");
		waitForAction(driver);
		wbsf_field_searchh.sendKeys(Keys.TAB);
		waitForAction(driver);
		String str1 = wbsf_field.getText();
		if (str1.contains("Union")) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"**the selected value from the Union/Non-Union dropdown is:  **" + str1, ExtentColor.GREEN));
			logSuccess("Expected Value - " + "Union");
			logSuccess("Actual Value - " + str1);
			System.out.println("the selected value from the Union/Non-Union dropdown is:   " + str1);
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("** value is not selectrd from the Union/Non-Union  dropdown **", ExtentColor.RED));
			logFailure("Expected Value - " + "Union");
			logFailure("Actual Value - " + str1);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("value is not selected from the Union/Non-Union dropdown");
		}
	}

	public void validate_request_type() throws Exception {
		if (wbsf_request_type.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**Request Type dropdown is Populated**", ExtentColor.GREEN));
			System.out.println("Request Type dropdown is Populated");
			waitForElementToBeClickable(driver, wbsf_request_type);
			wbsf_request_type.click();
			waitForElementToBeClickable(driver, wbsf_request_type_search);
			wbsf_request_type_search.sendKeys("Addition");
			waitForAction(driver);
			wbsf_request_type_search.sendKeys(Keys.TAB);
			waitForAction(driver);
			String str = wbsf_request_type.getText();

			if (str.contains("Addition")) {
				test.get().log(Status.INFO, MarkupHelper.createLabel(
						"**the selected value from the request type dropdown is:**  " + str, ExtentColor.CYAN));
				logSuccess("Expected Value - " + "Addition");
				logSuccess("Actual Value - " + str);
				System.out.println("the selected value from the request type dropdown is:   " + str);
			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("**request type dropdown is not populated.**", ExtentColor.RED));
				logFailure("Expected Value - " + "Addition");
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
			System.out.println("Request Type dropdown is   not Populated");
		}

	}

	public void validate_business_justification(String str) throws Exception {
		if (wbsf_business_justification.isDisplayed() == true) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**Business Justification field is populated** ", ExtentColor.GREEN));
			System.out.println("Business Justification field is populated");
			waitForElementToBeClickable(driver, wbsf_business_justification);
			wbsf_business_justification.sendKeys(str);
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("**text entered in the Business Justification field is:**  " + str, ExtentColor.CYAN));
			logSuccess("Expected Value - " + str);
			logSuccess("Actual Value - " + wbsf_business_justification.getAttribute("value"));
			System.out.println("text entered in the Business Justification field is:   " + str);
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**Business Justification field is not populated.**", ExtentColor.RED));
			logFailure("Expected Value - " + str);
			logFailure("Actual Value - " + wbsf_business_justification.getAttribute("value"));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Business Justification field is not populated");
		}
	}

	public void validate_number_of_temps_needed_field() throws Exception {
		if (wbsf_temps_needed.isDisplayed() == true) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("** number of temps needed dropdown is populated**  ", ExtentColor.GREEN));
			String str = wbsf_temps_needed.getText();
			System.out.println("the number is:" + str);
			test.get().log(Status.INFO, MarkupHelper.createLabel(
					"** default text in the number of temps needed dropdown is:**  " + str, ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println(" default text in the number of temps needed dropdown is:   " + str);
		} else {
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("**number of temps needed dropdown is not populated.**", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("number of temps needed dropdown is not populated");
		}

	}

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

	public void validate_enddate() throws Exception {
		if (wbsf_end_date.isDisplayed() == true) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**  enddate field is populated**", ExtentColor.GREEN));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sdf.setTimeZone(TimeZone.getTimeZone("PST"));
			Date d = new Date();
			String date = sdf.format(d);
			System.out.println("todays date is" + date);
			waitForElementToBeClickable(driver, wbsf_end_date);
			wbsf_end_date.sendKeys(date);
			waitForAction(driver);
			wbsf_end_date.sendKeys(Keys.TAB);
			waitForAction(driver);
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("**date entered in the enddate filed is**" + date, ExtentColor.CYAN));
			System.out.println("date entered in the enddate filed is**" + date);
			wbsf_start_date.click();

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
//	java.time.LocalDateTime LocalDateTime = 	java.time.LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = simpleDateFormat.format(new Date());
		LocalDate date1 = LocalDate.parse(currentDate, dateTimeFormatter);
		LocalDate date2 = date1.minusDays(2);
		System.out.println("Current Date Minus 2Days WebElement--> " + date2);
		String fourth_day = date2.toString();
		waitForElementToBeClickable(driver, wbsf_end_date);
		wbsf_end_date.clear();
		waitForAction(driver);
		wbsf_end_date.sendKeys(fourth_day);
		wbsf_end_date.sendKeys(Keys.TAB);
		waitForAction(driver);
		wbsf_start_date.click();

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

		waitForElementToBeClickable(driver, wbsf_start_date);
		wbsf_start_date.clear();
		waitForAction(driver);
		waitForElementToBeClickable(driver, wbsf_end_date);
		wbsf_end_date.clear();
		waitForAction(driver);

		waitForElementToBeClickable(driver, wbsf_start_date);
		wbsf_start_date.sendKeys(datefour);
		String datethree = date3.toString();
		waitForElementToBeClickable(driver, wbsf_end_date);
		wbsf_end_date.sendKeys(datethree);
		wbsf_end_date.sendKeys(Keys.TAB);
		waitForAction(driver);
		wbsf_start_date.click();

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

	public void validate_enddate1() throws Exception {
		waitForElementToBeClickable(driver, wbsf_end_date);
		wbsf_end_date.clear();
		waitForAction(driver);
		waitForElementToBeClickable(driver, wbsf_enddate_button);
		wbsf_enddate_button.click();
		waitForElementToBeClickable(driver, wbsf_enddate_table_arrow);
		wbsf_enddate_table_arrow.click();
		waitForElementToBeClickable(driver, wbsf_enddate_day);
		wbsf_enddate_day.click();
		// wbsf_enddate_day.sendKeys(Keys.ENTER);
		test.get().log(Status.PASS, MarkupHelper.createLabel("**enddate field  is populated**", ExtentColor.GREEN));
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

	public void validate_Requirements_with_Proficiency_text() throws Exception {

		String actualtext = wbsf_Requirements_with_profeciency_text.getText();
		String expectedtext = "Select the skill or type of work required in the left dropdown. Select the desired proficiency "
				+ "level or the level of effort required in the right dropdown.";
		if (actualtext.equalsIgnoreCase(expectedtext)) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("**Text under requirement proficiency section  is**"
					+ wbsf_Requirements_with_profeciency_text.getText(), ExtentColor.GREEN));
			logSuccess("Expected Value - " + expectedtext);
			logSuccess("Actual Value - " + actualtext);
			System.out.println("Text under requirement proficiency section  is:   "
					+ wbsf_Requirements_with_profeciency_text.getText());
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("**text is not displayed under requirement proficiency section**", ExtentColor.RED));
			logFailure("Expected Value - " + expectedtext);
			logFailure("Actual Value - " + actualtext);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("text is not displayed under requirement proficiency section");
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

			if (s.equalsIgnoreCase(s)) {
				test.get().log(Status.INFO, MarkupHelper
						.createLabel("**the default skill in the  skill dropdown is**" + s, ExtentColor.CYAN));
				System.out.println("the default skill in the  skill dropdown is:    " + s);
			} else {
				test.get().log(Status.FAIL, MarkupHelper
						.createLabel("** default skill is  not displayed from  skill dropdown**", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println(" default skill is  not displayed from  skill dropdown");
			}
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
				if (s.get(j).getText().equalsIgnoreCase(s.get(j).getText())) {
					new Select(driver.findElement(By.xpath(finalpart1))).selectByVisibleText(s.get(j).getText());

					test.get().log(Status.INFO, MarkupHelper.createLabel(
							"**the populated profeciency rating is**" + s.get(j).getText(), ExtentColor.CYAN));

					System.out.println("the populated profeciency rating is:    " + s.get(j).getText());
				} else {
					test.get().log(Status.FAIL,
							MarkupHelper.createLabel("** profeciency rating is not populated**", ExtentColor.RED));
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					System.out.println(" profeciency rating is not populated");
				}
			}
		}
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	}

	public void validating_table_rows() throws Exception {
		int ele = wbsf_table_rows.size();
		System.out.println("number of rows in a table are:   " + ele);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		waitForElementToBeClickable(driver, wbsf_table_button);
		js.executeScript("arguments[0].click();", wbsf_table_button);
		int ele1 = wbsf_table_rows.size();
		System.out.println("number of rows in a table are:   " + ele1);
		if (!(ele == ele1)) {

			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**number of rows in the table are:  " + ele1, ExtentColor.GREEN));
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**New Row is added to the table**", ExtentColor.GREEN));
			System.out.println("New Row is added to the table");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**new row is not added to the table.**", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("new row is not added to the table");
		}

	}

	public void validate_newly_added_row(String text) throws Exception {
		// new Select(wbsf_table_skills7).selectByVisibleText(text);

		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("confirm = function(message){document.title = message;return true;};");
			js.executeScript("alert = function(message){document.title = message;return true;};");

			waitForElementToBeClickable(driver, wbsf_table_skills7);
			new Select(wbsf_table_skills7).selectByVisibleText(text);

			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**alert message is displayed::" + driver.getTitle(), ExtentColor.GREEN));
		} catch (UnhandledAlertException e) {
			logInfo("No alert Present while adding the new skill");
		}
	}

	public void validate_table_row(String text) throws Exception {
		new Select(wbsf_table_skills7).selectByVisibleText(text);

		String str = new Select(wbsf_table_skills7).getFirstSelectedOption().getText();
		test.get().log(Status.PASS,
				MarkupHelper.createLabel("** populated text on the dropdown is**" + str, ExtentColor.GREEN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		System.out.println(" populated text on dropdown is:   " + str);
		List<WebElement> s = new Select(wbsf_table_proficiency7).getOptions();
		System.out.println("size of the dropdown is :    " + s.size());
		for (int i = 0; i < s.size(); i++) {
			new Select(wbsf_table_proficiency7).selectByVisibleText(s.get(i).getText());

			String str1 = new Select(wbsf_table_proficiency7).getFirstSelectedOption().getText();
			test.get().log(Status.PASS, MarkupHelper.createLabel("**text on dropdown is**" + str1, ExtentColor.GREEN));
			System.out.println(" populated text on dropdown is:   " + str1);
		}
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	}

	public void validating_rows_in_table() throws Exception {
		int ele = wbsf_table_rows.size();
		System.out.println("number of rows in table are:  " + ele);
		for (int i = 1; i <= 4; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			waitForElementToBeClickable(driver, wbsf_table_button);
			js.executeScript("arguments[0].click();", wbsf_table_button);

		}
		int ele1 = wbsf_table_rows.size();
		if (!(ele == ele1)) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**number of rows in table are**" + ele1, ExtentColor.GREEN));
			System.out.println("number of rows in table are:   " + ele1);
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**new rows are not added to the table**", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("new rows are not added to the table");

		}
	}

	public void validate_other_software_section_in_table(String str) throws Exception {
		new Select(wbsf_table_skills8).selectByVisibleText(str);

		String ele = new Select(wbsf_table_skills8).getFirstSelectedOption().getText();
		if (ele.equalsIgnoreCase(str)) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**selected value from skill dropdown  is **" + ele, ExtentColor.GREEN));
			logSuccess("Expected Value - " + str);
			logSuccess("Actual Value - " + ele);
			System.out.println("selected value from skill dropdown  is:   " + ele);
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("** other software text from dropdown is not populated**", ExtentColor.RED));
			logFailure("Expected Value - " + str);
			logFailure("Actual Value - " + ele);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("other software text from dropdown is not populated");
		}
		List<WebElement> s = new Select(wbsf_table_proficiency8).getOptions();
		System.out.println(s.size());
		for (int i = 0; i < s.size(); i++) {
			new Select(wbsf_table_proficiency8).selectByVisibleText(s.get(i).getText());

			String str1 = new Select(wbsf_table_proficiency8).getFirstSelectedOption().getText();
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("**selected value from proficiency  dropdown  is **" + str1, ExtentColor.CYAN));
			System.out.println("selected value from proficiency  dropdown  is : " + str1);
		}
	}

	public void validate_other_software_field(String str) throws Exception {
		if (os_mandatory.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**other software field is displayed and  marked as mandatory **"
							+ wbsf_other_software.getAttribute("value"), ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			System.out.println("other software field is displayed and  marked as mandatory **");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**other software field is not marked as mandatory**", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("other software field is not marked as mandatory");
		}
		if (wbsf_other_software.isDisplayed() == true) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**other software field is populated **", ExtentColor.GREEN));
			waitForElementToBeClickable(driver, wbsf_other_software);
			wbsf_other_software.sendKeys(str);

			test.get().log(Status.INFO, MarkupHelper.createLabel(
					"** text enterd in the other software field is **" + wbsf_other_software.getAttribute("value"),
					ExtentColor.CYAN));
			logSuccess("Expected Value - " + str);
			logSuccess("Actual Value - " + wbsf_other_software.getAttribute("value"));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("other software field is populated and text enterd in the field is **"
					+ wbsf_other_software.getAttribute("value"));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**other software field is not populated**", ExtentColor.RED));
			logFailure("Expected Value - " + str);
			logFailure("Actual Value - " + wbsf_other_software.getAttribute("value"));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("other software field is not populated");
		}

	}

	public void validate_office_section_in_table(String str) throws Exception {
		new Select(wbsf_table_skills9).selectByVisibleText(str);

		String ele = new Select(wbsf_table_skills9).getFirstSelectedOption().getText();
		if (ele.equalsIgnoreCase(str)) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**selected value from skill dropdown  is **" + ele, ExtentColor.GREEN));
			logSuccess("Expected Value - " + str);
			logSuccess("Actual Value - " + ele);
			System.out.println("selected value from skill dropdown  is:" + ele);
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("** other software text from dropdown is not populated**", ExtentColor.RED));
			logFailure("Expected Value - " + str);
			logFailure("Actual Value - " + ele);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("other software text from dropdown is not populated");
		}
		List<WebElement> s = new Select(wbsf_table_proficiency9).getOptions();
		System.out.println(s.size());
		for (int i = 0; i < s.size(); i++) {
			new Select(wbsf_table_proficiency9).selectByVisibleText(s.get(i).getText());

			String str1 = new Select(wbsf_table_proficiency9).getFirstSelectedOption().getText();
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("**selected value from proficiency  dropdown  is **" + str1, ExtentColor.CYAN));
			System.out.println("selected value from proficiency  dropdown  is :   " + str1);
		}
	}

	public void validate_finance_accounting_section_in_table(String str) throws Exception {

		new Select(wbsf_table_skills10).selectByVisibleText(str);

		String ele = new Select(wbsf_table_skills10).getFirstSelectedOption().getText();
		if (ele.equalsIgnoreCase(str)) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**selected value from skill dropdown  is **" + ele, ExtentColor.GREEN));
			logSuccess("Expected Value - " + str);
			logSuccess("Actual Value - " + ele);
			System.out.println("selected value from skill dropdown  is:" + ele);
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("** other software text from dropdown is not populated**", ExtentColor.RED));
			logFailure("Expected Value - " + str);
			logFailure("Actual Value - " + ele);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("other software text from dropdown is not populated");
		}
		List<WebElement> s = new Select(wbsf_table_proficiency10).getOptions();
		System.out.println(s.size());
		for (int i = 0; i < s.size(); i++) {
			new Select(wbsf_table_proficiency10).selectByVisibleText(s.get(i).getText());

			String str1 = new Select(wbsf_table_proficiency10).getFirstSelectedOption().getText();
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("**selected value from proficiency  dropdown  is **" + str1, ExtentColor.CYAN));

			System.out.println("selected value from proficiency  dropdown  is :   " + str1);
		}
	}

	public void validate_system_section_in_table(String str) throws Exception {

		new Select(wbsf_table_skills11).selectByVisibleText(str);

		String ele = new Select(wbsf_table_skills11).getFirstSelectedOption().getText();
		if (ele.equalsIgnoreCase(str)) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**selected value from skill dropdown  is **" + ele, ExtentColor.GREEN));
			logSuccess("Expected Value - " + str);
			logSuccess("Actual Value - " + ele);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("selected value from skill dropdown  is:" + ele);
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("** other software text from dropdown is not populated**", ExtentColor.RED));
			logFailure("Expected Value - " + str);
			logFailure("Actual Value - " + ele);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("other software text from dropdown is not populated");
		}
		List<WebElement> s = new Select(wbsf_table_proficiency11).getOptions();
		System.out.println(s.size());
		for (int i = 0; i < s.size(); i++) {
			new Select(wbsf_table_proficiency11).selectByVisibleText(s.get(i).getText());

			String str1 = new Select(wbsf_table_proficiency11).getFirstSelectedOption().getText();
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("**selected value from proficiency  dropdown  is **" + str1, ExtentColor.CYAN));
			System.out.println("selected value from proficiency  dropdown  is :   " + str1);
		}
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	}

	public void validate_text_under_additional_requirements_section() throws Exception {

		String str = wbsf_additional_requirements_text.getText();
		String str1 = "Use the arrows to select and remove all additional requirements for the position.";
		if (str.equalsIgnoreCase(str1)) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("**text under additional requirements section  is **" + str, ExtentColor.GREEN));
			logSuccess("Expected Value - " + str);
			logSuccess("Actual Value - " + str1);
			System.out.println("text under additional requirements section  is :    " + str);
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("** text under additional requirements section is not populated**", ExtentColor.RED));
			logFailure("Expected Value - " + str);
			logFailure("Actual Value - " + str1);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("text under additional requirements section is not populated");
		}
	}

	public void validate_information_in_selectedskills_dropdown() throws Exception {

		scrollToElement(driver, additionalRequirementsLable);
		waitForElementToBeClickable(driver, wbsf_double_right_arrow);
		wbsf_double_right_arrow.click();

		List<WebElement> li = new Select(wbsf_selected_skills_dropdown).getOptions();
		for (int i = 0; i < li.size(); i++) {
			System.out.println(li.get(i).getText());
		}
		test.get().log(Status.PASS,
				MarkupHelper.createLabel("**all skills populated in selected skills dropdown **", ExtentColor.GREEN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		System.out.println("all skills populated in selected skills dropdown");

	}

	public void validate_information_in_availableskills_dropdown() throws Exception {
		waitForElementToBeClickable(driver, wbsf_double_left_arrow);
		wbsf_double_left_arrow.click();

		List<WebElement> li = new Select(wbsf_available_skills_dropdown).getOptions();
		for (int i = 0; i <= li.size() - 1; i++) {
			System.out.println(li.get(i).getText());
		}
		test.get().log(Status.PASS,
				MarkupHelper.createLabel("**all skills populated in available skills dropdown **", ExtentColor.GREEN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		System.out.println("all skills populated in available skills dropdown");

	}

	public void validate_multiple_individual_Skills_from_the_Availabe_Skills_List() throws Exception {
		Actions a = new Actions(driver);
		a.keyDown(Keys.CONTROL);
		new Select(wbsf_available_skills_dropdown).selectByVisibleText("Other O/S");
		new Select(wbsf_available_skills_dropdown).selectByVisibleText("Other skills not listed");
		a.keyUp(Keys.CONTROL);
		waitForElementToBeClickable(driver, wbsf_single_right_arrow);
		wbsf_single_right_arrow.click();

		List<WebElement> li = new Select(wbsf_selected_skills_dropdown).getOptions();
		for (int i = 0; i < li.size(); i++) {
			System.out.println(li.get(i).getText());
		}
		test.get().log(Status.PASS, MarkupHelper
				.createLabel("**selected skills populated in selected skills dropdown **", ExtentColor.GREEN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		System.out.println("selected skills populated in selected skills dropdown");
	}

	public void validate_others_field(String str) throws Exception {
		if (wbsf_otheros.isDisplayed() == true) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("* other operating system field is populated **", ExtentColor.GREEN));
			waitForElementToBeClickable(driver, wbsf_otheros);
			wbsf_otheros.sendKeys(str);
			test.get().log(Status.INFO,
					MarkupHelper.createLabel(
							"**text entered in the other o/s field is **" + wbsf_otheros.getAttribute("value"),
							ExtentColor.CYAN));
			logSuccess("Expected Value - " + str);
			logSuccess("Actual Value - " + wbsf_otheros.getAttribute("value"));
			System.out.println("text entered in the other o/s field is:    " + wbsf_otheros.getAttribute("value"));

		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("**other operating software field is not autopopulated**", ExtentColor.RED));
			logFailure("Expected Value - " + str);
			logFailure("Actual Value - " + wbsf_otheros.getAttribute("value"));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("other operating software field is not autopopulated");
		}
	}

	public void validate_additional_requirements_field(String str) throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		if (wbsf_other_skill_requirements.isDisplayed() == true) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**other skills requirement field is populated**", ExtentColor.GREEN));
			waitForElementToBeClickable(driver, wbsf_other_skill_requirements);
			wbsf_other_skill_requirements.sendKeys(str);
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("**text entered in the other skills requirement field is **"
							+ wbsf_other_skill_requirements.getAttribute("value"), ExtentColor.CYAN));
			logSuccess("Expected Value - " + str);
			logSuccess("Actual Value - " + wbsf_other_skill_requirements.getAttribute("value"));
			System.out.println("text entered in the other skills requirement field is:   "
					+ wbsf_other_skill_requirements.getAttribute("value"));
			checkForPageLoad(driver);
			wbsf_describe_job_duites.click();
			executor.executeScript("arguments[0].textContent='" + str + "';", wbsf_other_skill_requirements);
			System.out.println(wbsf_other_skill_requirements.getAttribute("value"));
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("**other skills requirement field is not autopopulated**", ExtentColor.RED));
			logFailure("Expected Value - " + str);
			logFailure("Actual Value - " + wbsf_other_skill_requirements.getAttribute("value"));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("other skills requirement field is not autopopulated");
		}
	}

	public void validate_error_message_by_leaving_field_blank() throws Exception {
		scrollToElement(driver, wbsf_submit);
		checkForPageLoad(driver);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		waitForElementToBeClickable(driver, wbsf_submit);
		executor.executeScript("arguments[0].click();", wbsf_submit);
		waitForElement(driver, wbsf_describe_job_duites_error_message);
		String str = wbsf_describe_job_duites_error_message.getText();
		System.out.println(str);
		if (str.contains(
				"Some fields are incomplete: Department (Cost Center) in need of temp worker, Describe daily job duties")) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("**error message is **" + str, ExtentColor.GREEN));
			logSuccess("Expected value - "
					+ "Some fields are incomplete: Department (Cost Center) in need of temp worker, Describe daily job duties");
			logSuccess("Actual Value - " + str);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("error message is:  " + str);
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**error message is not displayed as expected**", ExtentColor.RED));
			logFailure("Expected value - "
					+ "Some fields are incomplete: Department (Cost Center) in need of temp worker, Describe daily job duties");
			logFailure("Actual Value - " + str);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("error message is not displayed");
		}
	}

	public void validate_describe_job_duites(String str) throws Exception {
		checkForPageLoad(driver);
		scrollToElement(driver, wbsf_describe_job_duites);
		waitForAction(driver);
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

	public void validate_approver_information1(String str1, String str2) throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Actions actions = new Actions(driver);
		// actions.moveToElement(wbsf_select_employee).perform();;
		// actions.perform();
		js.executeScript("arguments[0].scrollIntoView();", wbsf_select_employee);
		waitForAction(driver);
		waitForElementToBeClickable(driver, wbsf_assignment_information);
		wbsf_assignment_information.click();
		waitForElementToBeClickable(driver, wbsf_assignment_information_search);
		wbsf_assignment_information_search.sendKeys(str1);
		wbsf_assignment_information_search.sendKeys(Keys.TAB);
		waitForAction(driver);
		js.executeScript("arguments[0].scrollIntoView();", wbsf_submit);
		waitForAction(driver);

		String[] ele = str2.split(",");
		List<WebElement> element = driver.findElements(By.xpath(
				"//*[contains(@ng-repeat,'column in container.columns')]/div[contains(@id,'approver_name')]/div/span/span/input[contains(@class,'ng-not-empty') and contains(@id,'level')]"));
		int ele1 = element.size();
		System.out.println("Approvers present in application - " + ele1);

		List<String> inputdata = new ArrayList<>();
		List<String> applicationdata = new ArrayList<>();
		Set<String> matcheddata = new HashSet<>();
		Set<String> unmatcheddata = new HashSet<>();
		Set<String> remove = new HashSet<>();

		for (String s : ele) {
			inputdata.add(s.trim());
		}

		for (int i = 0; i < ele1; i++) {
			applicationdata.add(element.get(i).getAttribute("value").trim());
		}

		for (int j = 0; j < inputdata.size(); j++) {
			for (int k = 0; k < applicationdata.size(); k++) {
				if (inputdata.contains(applicationdata.get(k))) {
					matcheddata.add(applicationdata.get(k));
					System.out.println("Adding to matched data - " + applicationdata.get(k));
				}
				if (!inputdata.contains(applicationdata.get(k))/* || !applicationdata.contains(inputdata.get(j)) */) {
					// unmatcheddata.add(inputdata.get(j));
					unmatcheddata.add(applicationdata.get(k));
					System.out.println(
							"Adding to unmatched data - " + applicationdata.get(k) + " and " + inputdata.get(j));
				}
			}
		}

		for (String string : unmatcheddata) {
			for (String string2 : matcheddata) {
				if (string.equals(string2)) {
					remove.add(string);
				}
			}
		}

		for (String string : remove) {
			if (unmatcheddata.contains(string)) {
				unmatcheddata.remove(string);

			}
		}

		if (matcheddata.size() > 0) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("** approver names  matched with expected approver names **", ExtentColor.GREEN));
			System.out.println("Matched Data");
			for (String string : matcheddata) {
				System.out.println("---" + string);
				test.get().log(Status.PASS, MarkupHelper.createLabel("- " + string, ExtentColor.GREEN));
			}
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		if (unmatcheddata.size() > 0 && matcheddata.size() < applicationdata.size()) {
			System.out.println("Unmatched Data");
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("** approver names  not matched with expected approver names  **", ExtentColor.RED));
			for (String string : unmatcheddata) {
				System.out.println("---" + string);
				test.get().log(Status.FAIL, MarkupHelper.createLabel("- " + string, ExtentColor.RED));
			}
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

	}

	public void validate_submit_button() throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", wbsf_submit);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, wbsf_submit);
		executor.executeScript("arguments[0].click();", wbsf_submit);

		waitForElement(driver, wbsf_casediscription);
		String casenum = ch_caseID.getText();
		if (wbsf_casediscription.getText().contains("Case Description")) {

			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"**Ticket Conformation page is displayed with the Case Description and Approvers List** =="
									+ casenum,
							ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Ticket Conformation page is displayed with the Case Description and Approvers List**");
		} else

		{
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**ticket information page is not displayed**", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("ticket information page is not displayed");
		}
		// String str = wbsf_casediscription_text.getText();
		// System.out.println("text under case description is: " + str);
	}

}
