package com.snow.pageobjects;

import java.util.ArrayList;
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

public class Dashboard_and_Reporting extends ReusableLibrary {
	public WebDriver driver;

	public Dashboard_and_Reporting(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='filter']")
	public WebElement leftSearch;

	@FindBy(xpath = "//div[text()='HR Case Dashboard']")
	public WebElement hrDashboard;

	@FindBy(xpath = "(//div[text()='HR Service Portal'])[2]")
	public WebElement hrDashboard1;

	@FindBy(xpath = "//div[text()='Workforce Administration Cases']")
	public WebElement WorkforceAdministrationCases;

	@FindBy(xpath = "//h2[@class='navbar-title list_title ']")
	public WebElement hrWorkforceAdministrationCases;

	@FindBy(xpath = "//iframe[@id='gsft_main']")
	public WebElement frame;

	@FindBy(xpath = "//input[@id='home_title']")
	public WebElement homeTitle;

	@FindBy(xpath = "//td[contains(text(),'Total Open Cases - Assigned to me')]")
	public WebElement openCasesAssignToMe;

	@FindBy(xpath = "//td[@id='dropzone1']/div[1]//div[2]//a")
	public WebElement totalOpenCasesAssignedToMe;

	@FindBy(xpath = "//td[contains(text(),'Breached Cases') and contains(text(),'Assigned to me')]")
	public WebElement breachedCasesAssignMe;

	@FindBy(xpath = "//td[@id='dropzone1']/div[2]//div[2]//a")
	public WebElement totalBreachedCasesAssignedToMe;

	@FindBy(xpath = "//td[contains(text(),'High Priority Cases (Below breach)') and contains(text(),'Assigned to Me')]")
	public WebElement highPriorityCasesAssignedMe;

	@FindBy(xpath = "//td[@id='dropzone1']/div[3]//div[2]//a")
	public WebElement totalHighPriorityCasesAssignedToMe;

	@FindBy(xpath = "//td[contains(text(),'Nearing Breach Cases - Assigned to Me')]")
	public WebElement nearingBreachCasesAssignMe;

	@FindBy(xpath = "//td[@id='dropzone1']/div[4]//div[2]//a")
	public WebElement totalnearingBreachCasesAssignedToMe;

	@FindBy(xpath = "//td[contains(text(),'Moderate/Low Cases (Below breach)') and contains(text(),'Assigned to me')]")
	public WebElement moderateCasesAssignMe;

	@FindBy(xpath = "//td[@id='dropzone1']/div[5]//div[2]//a")
	public WebElement totalModerateCasesAssignedToMe;

	@FindBy(xpath = "//td[contains(text(),'Breached Cases') and contains(text(),'My Group(s)')]")
	public WebElement breachedCasesMyGroups;

	@FindBy(xpath = "//td[@id='dropzone2']/div[1]//div[2]//a")
	public WebElement totalBreachedCasesMyGroups;

	@FindBy(xpath = "//td[contains(text(),'Total Open Cases') and contains(text(),'My Group(s)')]")
	public WebElement OpenCasesMyGroups;

	@FindBy(xpath = "//td[@id='dropzone2']/div[2]//div[2]//a")
	public WebElement totalOpenCasesMyGroups;

	@FindBy(xpath = "//td[contains(text(),'High Priority Cases (Below breach)') and contains(text(),'My Group(s)')]")
	public WebElement highPrioritycasesMyGroups;

	@FindBy(xpath = "//td[@id='dropzone2']/div[3]//div[2]//a")
	public WebElement totalHighPrioritycasesMyGroups;

	@FindBy(xpath = "//td[contains(text(),'Nearing Breach Cases') and contains(text(),'My Group(s)')]")
	public WebElement nearingBreachCasesMyGroups;

	@FindBy(xpath = "//td[@id='dropzone2']/div[4]//div[2]//a")
	public WebElement totalNearingBreachCasesMyGroups;

	@FindBy(xpath = "//td[contains(text(),'Moderate/Low Cases (Below breach)') and contains(text(),'My Group(s)')]")
	public WebElement moderateCasesMyGroups;

	@FindBy(xpath = "//td[@id='dropzone2']/div[5]//div[2]//a")
	public WebElement totalModerateCasesMyGroups;

	@FindBy(xpath = "//td[contains(text(),'Open Cases') and contains(text(),'My Group(s) & Unassigned')]")
	public WebElement totalOpenCasesMyGroupUnassigned;

	@FindBy(xpath = "//td[@id='dropzone2']/div[6]//div[2]//a")
	public WebElement totalCountOpenCasesMyGroupUnassigned;

	@FindBy(xpath = "//table[@id='sn_hr_core_case_workforce_admin_table']/tbody/tr/td[6]/a")
	public List<WebElement> wbsf_testcases;

	@FindBy(xpath = "(//button[contains(@class,'list_nav  btn btn-icon h_flip_content')][@name='vcr_next'])[1]")
	public WebElement nextButton;

	@FindBy(xpath = "(//i[@data-list_id='sn_hr_core_case_workforce_admin'])[1]")
	public WebElement gearicon;

	@FindBy(xpath = "//h1[@id='list_mechanic_title']")
	public WebElement columnheader;

	@FindBy(xpath = "//*[@id='slush_left']")
	public WebElement slush_left_dropdown;

	@FindBy(xpath = "//select[@id='slush_right']/option")
	public List<WebElement> slush_right_dropdown;

	@FindBy(xpath = "//a[@class='btn btn-default icon-chevron-right slush-bucket-add']")
	public WebElement slush_left_button;

	@FindBy(xpath = "//option[contains(text(),'No. of Temps Requested')]")
	public WebElement NoofTempsRequested_text;

	@FindBy(xpath = "//a[@class='btn btn-default icon-chevron-up']")
	public WebElement uparrow;

	@FindBy(xpath = "//button[@id='ok_button']")
	public WebElement btn_OK;

	@FindBy(xpath = "(//i[@data-original-title='Update Personalized List'])[1]")
	public WebElement modified_gear_icon;

	@FindBy(xpath = "//button[text()='Reset to column defaults']")
	public WebElement Resettocolumndefaults;

	@FindBy(xpath = "//input[@name='q']")
	public WebElement wbsf_searchbar;

	@FindBy(xpath = "//i[@class='fa fa-search']")
	public WebElement wbsf_searchbar_click;

	@FindBy(xpath = "//span[contains(text(),'Temp Request Form')] ")
	public WebElement wbsf_temp_form;

	@FindBy(xpath = "//h1[contains(text(),'WBSF Temp Request Form')]")
	public WebElement wbsf_request_form;

	@FindBy(xpath = "//label[@class='field-label ng-binding ng-scope'][contains(text(),'Department (Cost Center) in need of temp worker')]")
	public WebElement wbsf_text_under_assignment_information;

	@FindBy(xpath = "//div[@id='s2id_sp_formfield_cost_center']/a")
	public WebElement wbsf_assignment_information;

	@FindBy(xpath = "//label[contains(text(), 'Department (Cost Center)')]/following-sibling::input")
	public WebElement wbsf_assignment_information_search;

	@FindBy(xpath = "//span[@id='select2-chosen-2']")
	public WebElement wbsf_alternate_cost_center;

	@FindBy(xpath = "//input[@id='s2id_autogen2_search']")
	public WebElement wbsf_alternate_cost_center_search;

	@FindBy(xpath = "//div[@id='s2id_sp_formfield_union_non_union']/a")
	public WebElement wbsf_field;

	@FindBy(xpath = "//label[contains(text(),'Union / Non-Union undefined')]/following-sibling::input")
	public WebElement wbsf_field_searchh;

	@FindBy(xpath = "//div[@id='s2id_sp_formfield_request_type']/a")
	public WebElement wbsf_request_type;

	@FindBy(xpath = "//label[contains(text(),'Request Type')]/following-sibling::input")
	public WebElement wbsf_request_type_search;

	@FindBy(xpath = "//input[@id='sp_formfield_start_date']")
	public WebElement wbsf_start_date;

	@FindBy(xpath = "//input[@id='sp_formfield_end_date']")
	public WebElement wbsf_end_date;

	@FindBy(xpath = "//textarea[@id='sp_formfield_business_justification']")
	public WebElement wbsf_business_justification;

	@FindBy(xpath = "(//span[@class='glyphicon glyphicon-calendar'])[2]")
	public WebElement wbsf_enddate_button;

	@FindBy(xpath = "(//div[@class='datepicker'])[2]/div[1]/table/thead/tr[1]/th[2]")
	public WebElement wbsf_enddate_table;

	@FindBy(xpath = "(//div[@class='datepicker'])[2]/div[1]/table/thead/tr[1]/th[3]")
	public WebElement wbsf_enddate_table_arrow;

	@FindBy(xpath = "(//div[@class='datepicker'])[2]/div[1]/table/tbody/tr/td/div[contains(text(),'17')]")
	public WebElement wbsf_enddate_day;

	@FindBy(xpath = "//*[@id='sp_formfield_hours']")
	public WebElement wbsf_hours;

	@FindBy(xpath = "//*[@id='sp_formfield_building_and_room_no']")
	public WebElement wbsf_building_roomno;

	@FindBy(xpath = "(//button[@name='submit'])[1]")
	public WebElement wbsf_submit;

	@FindBy(xpath = "//div[@class='title-info ng-binding']")
	public WebElement hrcase_number;

	@FindBy(xpath = "//span[@id='sn_hr_core_case_breadcrumb']")
	public WebElement breadcrumb;

	@FindBy(xpath = "//*[@id='sp_formfield_daily_job_duties']")
	public WebElement wbsf_describe_job_duites;

	@FindBy(xpath = "//input[@class='form-control'][@placeholder='Search']")
	public WebElement search_field;

	@FindBy(xpath = "//a[@class='linked formlink']")
	public WebElement hrcase;

	@FindBy(xpath = "//select[@class='form-control default-focus-outline']")
	public WebElement search_dropdown;

	// @FindBy(xpath =
	// "//table[@id='sn_hr_core_case_workforce_admin_table']//a[@class='column_head
	// list_hdrcell table-col-header'][contains(text(),'HR service')]")
	@FindBy(xpath = "(//i[@class='icon-menu col-menu list_header_context list-column-icon' and @aria-label='HR service column options' ])[1]")
	public WebElement hrservice_icon;

	@FindBy(xpath = "//div[text()='Group By HR service']")
	public WebElement groupby_hrservice_icon;

	@FindBy(xpath = "//tbody[@class ='list2_body']/tr[contains(@id, 'row_sn_hr_core_case_workforce_admin') and @group_row]")
	public List<WebElement> wbsftemp_requestcase;

	@FindBy(xpath = "//tbody[@class ='list2_body']/tr[contains(@id, 'row_sn_hr_core_case_workforce_admin') and @group_row]/td/a/span")
	public WebElement wbsftemp_requestcase_text;

	public String fill_wbsftemp_request_form(String department, String uninonfield, String requesttype, String bjs,
			String date, String time, String bldgno, String duties) throws Exception {
		waitForElementToBeClickable(driver, wbsf_searchbar);
		wbsf_searchbar.sendKeys("WBSF");
		waitForElementToBeClickable(driver, wbsf_searchbar_click);
		wbsf_searchbar_click.click();

		waitForElement(driver, wbsf_temp_form);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		waitForElementToBeClickable(driver, wbsf_temp_form);
		js.executeScript("arguments[0].click();", wbsf_temp_form);

		waitForElementToBeClickable(driver, wbsf_assignment_information);
		wbsf_assignment_information.click();
		waitForElementToBeClickable(driver, wbsf_assignment_information_search);
		wbsf_assignment_information_search.sendKeys(department);
		waitForAction(driver);
		wbsf_assignment_information_search.sendKeys(Keys.TAB);
		waitForAction(driver);

		waitForElementToBeClickable(driver, wbsf_field);
		wbsf_field.click();
		waitForElementToBeClickable(driver, wbsf_field_searchh);
		wbsf_field_searchh.sendKeys(uninonfield);
		waitForAction(driver);
		wbsf_field_searchh.sendKeys(Keys.TAB);
		waitForAction(driver);

		waitForElementToBeClickable(driver, wbsf_request_type);
		wbsf_request_type.click();
		waitForElementToBeClickable(driver, wbsf_request_type_search);
		wbsf_request_type_search.sendKeys(requesttype);
		waitForAction(driver);
		wbsf_request_type_search.sendKeys(Keys.TAB);
		waitForAction(driver);

		waitForElementToBeClickable(driver, wbsf_business_justification);
		wbsf_business_justification.sendKeys(bjs);

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		waitForElementToBeClickable(driver, wbsf_start_date);
		wbsf_start_date.sendKeys(date);
		waitForElementToBeClickable(driver, wbsf_enddate_button);
		waitForAction(driver);
		executor.executeScript("arguments[0].click();", wbsf_enddate_button);
		// wbsf_enddate_button.click();
		waitForElementToBeClickable(driver, wbsf_enddate_table_arrow);
		wbsf_enddate_table_arrow.click();
		waitForElementToBeClickable(driver, wbsf_enddate_day);
		wbsf_enddate_day.click();
		waitForElementToBeClickable(driver, wbsf_hours);
		wbsf_hours.sendKeys(time);

		waitForElementToBeClickable(driver, wbsf_building_roomno);
		wbsf_building_roomno.sendKeys(bldgno);

		waitForElementToBeClickable(driver, wbsf_describe_job_duites);
		wbsf_describe_job_duites.sendKeys(duties);
		waitForAction(driver);
		js.executeScript("arguments[0].textContent='" + duties + "';", wbsf_describe_job_duites);
		wbsf_describe_job_duites.sendKeys(Keys.TAB);
		checkForPageLoad(driver);

		executor.executeScript("arguments[0].scrollIntoView();", wbsf_submit);
		waitForAction(driver);
		waitForElementToBeClickable(driver, wbsf_submit);
		executor.executeScript("arguments[0].click();", wbsf_submit);
		checkForPageLoad(driver);

		if (!isElementPresent(hrcase_number)) {
			waitForElementToBeClickable(driver, wbsf_submit);
			executor.executeScript("arguments[0].click();", wbsf_submit);
			checkForPageLoad(driver);
		}

		waitForElement(driver, hrcase_number);
		String hrcasenumber = hrcase_number.getText().trim();
		if (hrcase_number.isDisplayed()) {
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("wbsf temp request form submitted sucessfully - " + hrcasenumber, ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("wbsf temp request form not submitted sucessfully", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		return hrcasenumber;
	}

	public void navigateToHRDashboard() throws Exception {
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.sendKeys("HR CASE DASHBOARD");
		checkForPageLoad(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		waitForElementToBeClickable(driver, hrDashboard);
		js.executeScript("arguments[0].click();", hrDashboard);
		checkForPageLoad(driver);
		driver.switchTo().frame(0);
		if (homeTitle.getAttribute("value").equalsIgnoreCase("HR Case Dashboard")) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Successfully Navigate to HR Case Dashboard Home Page", ExtentColor.CYAN));

			logSuccess("Expected Value - " + "HR Case Dashboard");
			logSuccess("Actual Value - " + homeTitle.getAttribute("value"));

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Navigation Failed to to reach the HR Case Dashboard Home Page", ExtentColor.RED));
			logFailure("Expected Value - " + "HR Case Dashboard");
			logFailure("Actual Value - " + homeTitle.getAttribute("value"));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	/*
	 * check for the all Hr Cases Widgets are available
	 */
	public void confirmingHrcaseDashboard() throws Exception {
		if (openCasesAssignToMe.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Total open case AssignTo me widget is displayed with count="
							+ totalOpenCasesAssignedToMe.getText(), ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Total open case AssignTo me widget is Not displayed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		}
		if (breachedCasesAssignMe.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Breached cases AssignTo me widget is displayed with count="
							+ totalBreachedCasesAssignedToMe.getText(), ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Breached cases AssignTo me widget is Not displayed", ExtentColor.RED));
		}
		if (highPriorityCasesAssignedMe.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("High Priority cases AssignTo me widget is displayed with count="
							+ totalHighPriorityCasesAssignedToMe.getText(), ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("High Priority cases AssignTo me widgetis Not displayed", ExtentColor.RED));
		}
		if (nearingBreachCasesAssignMe.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Nearing Breach cases AssignTo me widget is displayed with count="
							+ totalnearingBreachCasesAssignedToMe.getText(), ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Nearing Breach cases AssignTo me widget is Not displayed", ExtentColor.RED));
		}
		if (moderateCasesAssignMe.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Moderate or Low cases AssignTo me widget is displayed with count="
							+ totalModerateCasesAssignedToMe.getText(), ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Moderate or Low cases AssignTo me widget is Not displayed", ExtentColor.RED));
		}
		if (breachedCasesMyGroups.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"breached cases My Groups widget is displayed with count=" + totalBreachedCasesMyGroups.getText(),
					ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("breached cases My Groups widget is Not displayed", ExtentColor.RED));
		}
		if (OpenCasesMyGroups.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Total Open cases My Groups widget is displayed with count=" + totalOpenCasesMyGroups.getText(),
					ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Total Open cases My Groups widget is Not displayed", ExtentColor.RED));
		}
		if (highPrioritycasesMyGroups.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("High Priority cases My Groups widget is displayed with count="
							+ totalHighPrioritycasesMyGroups.getText(), ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("High Priority cases My Groups widget is Not displayed", ExtentColor.RED));
		}
		if (nearingBreachCasesMyGroups.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Nearing Breach cases My Groups widget is displayed with count="
							+ totalNearingBreachCasesMyGroups.getText(), ExtentColor.GREEN));

		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Nearing Breach cases My Groups widget is Not displayed", ExtentColor.RED));
		}
		if (moderateCasesMyGroups.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Moderate or Low cases My Groups widget is displayed with count="
							+ totalModerateCasesMyGroups.getText(), ExtentColor.GREEN));

		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Moderate or Low cases My Groups widget is Not displayed", ExtentColor.RED));
		}
		if (totalOpenCasesMyGroupUnassigned.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Open cases My Groups Unassigned widget is displayed with count="
							+ totalCountOpenCasesMyGroupUnassigned.getText(), ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Open cases My Groups Unassigned widget is Not displayed", ExtentColor.RED));
		}

	}

	public void validate_opencases_assignedto_wbstudio_facilities(String hrcasenumber) throws Exception {
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, totalOpenCasesMyGroups);
		totalOpenCasesMyGroups.click();
		waitForAction(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		if (breadcrumb.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"**User able to see a list of Open Cases that are assigned to WB Studio Facilities**",
							ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"**User unable to see a list of Open Cases that are assigned to WB Studio Facilities**",
							ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		waitForElementToBeClickable(driver, search_dropdown);
		Select select = new Select(search_dropdown);
		select.selectByVisibleText("Number");
		waitForElementToBeClickable(driver, search_field);
		search_field.sendKeys(hrcasenumber);
		waitForAction(driver);
		search_field.sendKeys(Keys.ENTER);
		checkForPageLoad(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, hrcase);
		if (hrcase.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"**User able to see a specified hr Cases that are assigned to WB Studio Facilities**",
							ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"**User unable to see a specified hr Cases that are assigned to WB Studio Facilities**",
							ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	public void navigateTo_WorkforceAdministrationCases() throws Exception {
		driver.switchTo().defaultContent();
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.clear();
		waitForAction(driver);
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.sendKeys("Workforce Administration Cases");
		checkForPageLoad(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		waitForElementToBeClickable(driver, WorkforceAdministrationCases);
		js.executeScript("arguments[0].click();", WorkforceAdministrationCases);

		checkForPageLoad(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, hrWorkforceAdministrationCases);
		if (hrWorkforceAdministrationCases.getText().equalsIgnoreCase("HR Workforce Administration Cases")) {
			test.get().log(Status.INFO, MarkupHelper.createLabel(
					"Successfully Navigate to Workforce Administration Cases Home Page", ExtentColor.CYAN));
			logSuccess("Expected value - " + "HR Workforce Administration Cases");
			logSuccess("Actual Value - " + hrWorkforceAdministrationCases.getText());
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Navigation Failed to to reach the Workforce Administration Cases Home Page", ExtentColor.RED));
			logFailure("Expected value - " + "HR Workforce Administration Cases");
			logFailure("Actual Value - " + hrWorkforceAdministrationCases.getText());
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		waitForElementToBeClickable(driver, hrservice_icon);
		js.executeScript("arguments[0].click();", hrservice_icon);

		waitForElementToBeClickable(driver, groupby_hrservice_icon);
		js.executeScript("arguments[0].click();", groupby_hrservice_icon);

		waitForFrameToBeAvailable(driver, "gsft_main");
		checkForPageLoad(driver);

		int size = wbsftemp_requestcase.size();
		System.out.println("size of wbsf cases:   " + size);
		if (size == 1) {
			for (int i = 0; i < wbsftemp_requestcase.size(); i++) {
				System.out.println("List For Loop - " + wbsftemp_requestcase.get(i).getText());
				if (wbsftemp_requestcase.get(i).getText().contains("HR service: WBSF Temp Request")) {
					test.get().log(Status.PASS, MarkupHelper.createLabel(
							"User able to see only wbsf temp  request HR services only", ExtentColor.GREEN));
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				} else {
					test.get().log(Status.FAIL,
							MarkupHelper.createLabel("HR Service other than WBSF Temp Request is displayed - "
									+ wbsftemp_requestcase.get(i).getText(), ExtentColor.RED));
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				}
			}
		} else {
			for (int i = 0; i < wbsftemp_requestcase.size(); i++) {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("HR Service other than WBSF Temp Request is displayed - "
								+ wbsftemp_requestcase.get(i).getText(), ExtentColor.RED));
			}
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

	}

	public void validate_gearicon() throws Exception {
		if (gearicon.isDisplayed() == true) {
			test.get().log(Status.INFO, MarkupHelper.createLabel("gear icon is displayed", ExtentColor.CYAN));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			waitForElementToBeClickable(driver, gearicon);
			js.executeScript("arguments[0].click();", gearicon);
			// gearicon.click();
			System.out.println("str:" + columnheader.getText());
			if (columnheader.getText().contains("Personalize List Columns")) {
				test.get().log(Status.INFO, MarkupHelper.createLabel(
						"Successfully Navigate to Personalize List Columns Slush bucket", ExtentColor.CYAN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} else {
				test.get().log(Status.FAIL, MarkupHelper.createLabel(
						"Navigation Failed to to reach the Personalize List Columns Slush bucket", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}

		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Navigation Failed to to reach the gear icon", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		}
	}

	public void validate_leftdropdown() throws Exception {
		List<WebElement> s = new Select(slush_left_dropdown).getOptions();
		for (int i = 0; i < s.size(); i++) {
			if (s.get(i).getText().contains("No. of Temps Requested")) {
				waitForElementToBeClickable(driver, s.get(i));
				s.get(i).click();
				test.get().log(Status.INFO,
						MarkupHelper.createLabel("No. of Temps Requested text is selected", ExtentColor.CYAN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				JavascriptExecutor js = (JavascriptExecutor) driver;
				waitForElementToBeClickable(driver, slush_left_button);
				js.executeScript("arguments[0].click();", slush_left_button);
				// slush_left_button.click();

				test.get().log(Status.INFO, MarkupHelper.createLabel(
						"No. of Temps Requested text is moved to the left left dropdown", ExtentColor.CYAN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

			}
		}
	}

	public void validate_rightdropdown() throws Exception {

		int ele = slush_right_dropdown.size();
		System.out.println("size" + ele);
		for (int i = 1; i < ele - 1; i++) {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			waitForElementToBeClickable(driver, uparrow);
			js.executeScript("arguments[0].click();", uparrow);
			// uparrow.click();
		}
		test.get().log(Status.PASS,
				MarkupHelper.createLabel("No. of Temps Requested text is moved to second place", ExtentColor.GREEN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

	}

	public void validate_column_order() throws Exception {
		List<String> columnString = new ArrayList<String>();
		int mismatchCount = 0;
		List<String> notMatchedColumnString = new ArrayList<String>();
		checkForPageLoad(driver);
		List<WebElement> updatedColumnList = driver.findElements(By.xpath("//*[@id='slush_right']/option"));
		for (WebElement webElement : updatedColumnList) {
			columnString.add(webElement.getText());
			System.out.println(webElement.getText());
		}
		// btn_OK.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		waitForElementToBeClickable(driver, btn_OK);
		js.executeScript("arguments[0].click();", btn_OK);
		checkForPageLoad(driver);
		test.get().log(Status.INFO, MarkupHelper.createLabel(
				"Updated Column Order for List view is shown in below screenshot and  No of Temps Requested is displayed as the second column in the List View",
				ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		for (int i = 0; i < columnString.size(); i++) {
			waitForFrameToBeAvailable(driver, "gsft_main");
			String columnName = driver
					.findElement(By
							.xpath("//table[@id='sn_hr_core_case_workforce_admin_table']//th[" + (3 + i) + "]/span/a"))
					.getText().split("\\r?\\n")[0];
			if (tempbrowser.equalsIgnoreCase("IE") || tempbrowser.equalsIgnoreCase("safari")) {
				columnName = columnName.split("Sort")[0];
			}
			if (columnString.get(i).trim().contains(columnName.trim())) {

				System.out.println("Column order matched for - #" + columnName);
			} else {
				mismatchCount++;
				notMatchedColumnString.add(columnName);
				System.out.println("Column order mismatched for - ##" + columnName);
				System.out.println("Column order mismatched for - ##" + columnString.get(i).trim());
			}
		}

		if (mismatchCount == 0) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Column Order is updated Successfully", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Column Order is not updated as expected", ExtentColor.RED));
			for (int i = 0; i < notMatchedColumnString.size(); i++) {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("- " + notMatchedColumnString.get(i), ExtentColor.RED));
			}
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	public void validate_reset_to_default_view_or_not() throws Exception {
		waitForElementToBeClickable(driver, modified_gear_icon);
		modified_gear_icon.click();

		System.out.println("str:" + columnheader.getText());
		if (columnheader.getText().contains("Personalize List Columns")) {
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("Successfully Navigate to Personalize List Columns Slush bucket", ExtentColor.CYAN));
			logSuccess("Expected Value - " + "Personalize List Columns");
			logSuccess("Actual Value - " + columnheader.getText());
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Navigation Failed to to reach the Personalize List Columns Slush bucket", ExtentColor.RED));
			logFailure("Expected Value - " + "Personalize List Columns");
			logFailure("Actual Value - " + columnheader.getText());
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		waitForElementToBeClickable(driver, Resettocolumndefaults);
		Resettocolumndefaults.click();
		checkForPageLoad(driver);

		test.get().log(Status.INFO, MarkupHelper.createLabel(
				"Default Column Order for List view is shown in below screenshot and No of Temps Requested is removed from the List View and is reset back to the default view",
				ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		waitForElementToBeClickable(driver, gearicon);
		gearicon.click();

		List<String> columnString = new ArrayList<String>();
		int mismatchCount = 0;
		List<String> notMatchedColumnString = new ArrayList<String>();

		checkForPageLoad(driver);
		List<WebElement> updatedColumnList = driver.findElements(By.xpath("//*[@id='slush_right']/option"));
		for (WebElement webElement : updatedColumnList) {
			columnString.add(webElement.getText().trim());
			System.out.println("C - " + webElement.getText());
		}
		waitForElementToBeClickable(driver, btn_OK);
		btn_OK.click();
		checkForPageLoad(driver);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("default Column Order for List view is shown in below", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		for (int i = 0; i < columnString.size(); i++) {
			String columnName = driver
					.findElement(By
							.xpath("//table[@id='sn_hr_core_case_workforce_admin_table']//th[" + (3 + i) + "]/span/a"))
					.getText().split("\\r?\\n")[0];

			if (tempbrowser.equalsIgnoreCase("IE") || tempbrowser.equalsIgnoreCase("safari")) {
				columnName = columnName.split("Sort")[0];
			}

			if (columnString.get(i).trim().contains(columnName.trim())) {
				System.out.println("Column order matched for - *" + columnName);
			} else {
				mismatchCount++;
				notMatchedColumnString.add(columnName);
				System.out.println("Column order mismatched for - **" + columnName.trim());
				System.out.println("Column order mismatched for - **" + columnString.get(i).trim());
			}
		}

		if (mismatchCount == 0) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Column Order is updated Successfully", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Column Order is not updated as expected", ExtentColor.RED));
			for (int i = 0; i < notMatchedColumnString.size(); i++) {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("- " + notMatchedColumnString.get(i), ExtentColor.RED));
			}
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

}