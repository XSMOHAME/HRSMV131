package com.snow.pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;
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

public class GenericCatalogItemCasePage extends ReusableLibrary {
	public WebDriver driver;

	public GenericCatalogItemCasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// ----------------------- Generic Case Fields---------------------------

	@FindBy(xpath = "	//input[@id='filter']")
	public WebElement leftsearch;

	@FindBy(xpath = "//a[@id='3f0370019f22120047a2d126c42e7076']//div[@class='sn-widget-list-title'][contains(text(),'All')]")
	public WebElement allcase;

	@FindBy(xpath = ".//table[@id='sn_hr_core_case_table']//input[@id='sn_hr_core_case_table_header_search_control']")
	public WebElement casenumber;

	@FindBy(xpath = "//a[@class='linked formlink']")
	public WebElement itil_caseID;

	@FindBy(xpath = "//span[@class='navbar_ui_actions']//button[@id='sysverb_update']")
	public WebElement update;

	@FindBy(xpath = "//input[@id='suspend_comments']")
	public WebElement popup_pending_comment;

	@FindBy(xpath = "//button[@id='ok_button']")
	public WebElement popup_pending_ok;

	@FindBy(xpath = "//span[@class='navbar_ui_actions']//button[@id='cancel']")
	public WebElement btn_cancel;

	@FindBy(xpath = "//input[@id='hr_comment']")
	public WebElement cancel_comment;

	@FindBy(xpath = "//button[@id='ok_button']")
	public WebElement cancel_ok;

	// ----------------------- Employee Services Case
	// ---------------------------

	@FindBy(xpath = "//select[@id='sn_hr_core_hr_employee_services.state']")
	public WebElement employee_services_state;

	@FindBy(xpath = "//input[@id='sys_display.sn_hr_core_hr_employee_services.assignment_group']")
	public WebElement employee_services_assignment_group;

	@FindBy(xpath = "//input[@id='sys_display.sn_hr_core_hr_employee_services.assigned_to']")
	public WebElement employee_services_assign_to;

	@FindBy(xpath = "//select[@id='sn_hr_core_hr_employee_services.priority']")
	public WebElement employee_services_priority;

	@FindBy(xpath = ".//*[@id='sys_display.sn_hr_core_hr_employee_services.hr_service']")
	public WebElement employee_services_hr_service;

	@FindBy(xpath = ".//*[@id='sys_display.sn_hr_core_hr_employee_services.opened_for']")
	public WebElement employee_services_opened_for;

	@FindBy(xpath = "//input[@id='sys_readonly.sn_hr_core_hr_employee_services.number']")
	public WebElement employee_services_caseid;

	@FindBy(xpath = "//select[@id='sn_hr_core_hr_employee_services.contact_type']")
	public WebElement employee_services_source;
	// ----------------------- Payroll Case ---------------------------

	@FindBy(xpath = "//input[@id='sys_display.sn_hr_core_case_payroll.assignment_group']")
	public WebElement payroll_assignment_group;

	@FindBy(xpath = "//input[@id='sys_display.sn_hr_core_case_payroll.assigned_to']")
	public WebElement payroll_assign_to;

	@FindBy(xpath = ".//*[@id='sn_hr_core_case_payroll.priority']")
	public WebElement payroll_priority;

	@FindBy(xpath = "//select[@id='sn_hr_core_case_payroll.contact_type']")
	public WebElement payroll_source;

	@FindBy(xpath = "//select[@id='sn_hr_core_case_payroll.state']")
	public WebElement payroll_state;

	@FindBy(xpath = ".//*[@id='sys_display.sn_hr_core_case_payroll.hr_service']")
	public WebElement payroll_hr_service;

	@FindBy(xpath = ".//*[@id='sys_display.sn_hr_core_case_payroll.opened_for']")
	public WebElement payroll_opened_for;

	@FindBy(xpath = "//input[@id='sn_hr_core_case_payroll.opened_by_label']")
	public WebElement payroll_opened_by;

	@FindBy(xpath = "//input[@id='sys_display.sn_hr_core_case_payroll.subject_person']")
	public WebElement payroll_subject_person;

	@FindBy(xpath = "//input[@id='sys_readonly.sn_hr_core_case_payroll.number']")
	public WebElement payroll_caseid;

	// ----------------------- HR Core Case ---------------------------

	@FindBy(xpath = "//input[@id='sys_display.sn_hr_core_case.assignment_group']")
	public WebElement core_assignment_group;

	@FindBy(xpath = "//input[@id='sys_display.sn_hr_core_case.assigned_to']")
	public WebElement core_assign_to;

	@FindBy(xpath = ".//*[@id='sn_hr_core_case.priority']")
	public WebElement core_priority;

	@FindBy(xpath = ".//*[@id='sys_display.sn_hr_core_case.hr_service']")
	public WebElement core_hr_service;

	@FindBy(xpath = ".//*[@id='sys_display.sn_hr_core_case.opened_for']")
	public WebElement core_opened_for;

	@FindBy(xpath = "//select[@id='sn_hr_core_case.state']")
	public WebElement core_state;

	@FindBy(xpath = "//input[@id='sys_readonly.sn_hr_core_case.number']")
	public WebElement caseid;

	@FindBy(xpath = "//select[@id='sn_hr_core_case.contact_type']")
	public WebElement core_source;

	// ----------------------- Work Force Admin Case ---------------------------

	@FindBy(xpath = "//input[@id='sys_display.sn_hr_core_case_workforce_admin.assignment_group']")
	public WebElement workforce_admin_assignment_group;

	@FindBy(xpath = "//input[@id='sys_display.sn_hr_core_case_workforce_admin.assigned_to']")
	public WebElement workforce_admin_assign_to;

	@FindBy(xpath = "//select[@id='sn_hr_core_case_workforce_admin.priority']")
	public WebElement workforce_admin_priority;

	@FindBy(xpath = ".//*[@id='sys_display.sn_hr_core_case_workforce_admin.hr_service']")
	public WebElement workforce_admin_hr_service;

	@FindBy(xpath = ".//*[@id='sys_display.sn_hr_core_case_workforce_admin.opened_for']")
	public WebElement workforce_admin_opened_for;

	@FindBy(xpath = "//select[@id='sn_hr_core_case_workforce_admin.state']")
	public WebElement workforce_admin_state;

	@FindBy(xpath = "//input[@id='sys_readonly.sn_hr_core_case_workforce_admin.number']")
	public WebElement workforce_admin_caseid;

	@FindBy(xpath = "//select[@id='sn_hr_core_case_workforce_admin.contact_type']")
	public WebElement workforce_admin_source;

	// ----------------------- Operations Case ---------------------------

	@FindBy(xpath = "//input[@id='sys_display.sn_hr_core_case_operations.assignment_group']")
	public WebElement operations_assignment_group;

	// @FindBy(xpath =
	// "//input[@id='sys_display.sn_hr_core_case_operations.assigned_to']")
	@FindBy(xpath = "//*[contains(@id,'sys_display.sn_hr_core_case_') and contains(@id,'.assigned_to')]")
	public WebElement operations_assign_to;

	@FindBy(xpath = ".//*[@id='sn_hr_core_case_operations.priority']")
	public WebElement operations_priority;

	@FindBy(xpath = ".//*[@id='sys_display.sn_hr_core_case_operations.hr_service']")
	public WebElement operations_hr_service;

	@FindBy(xpath = ".//*[@id='sys_display.sn_hr_core_case_operations.opened_for']")
	public WebElement operations_opened_for;

	// @FindBy(xpath = "//select[@id='sn_hr_core_case_operations.state']")
	@FindBy(xpath = "//select[contains(@id,'sn_hr_core_case_') and contains(@id,'.state')]")
	public WebElement states;

	@FindBy(xpath = "//input[@id='sys_readonly.sn_hr_core_case_operations.number']")
	public WebElement operations_caseid;

	@FindBy(xpath = "//select[@id='sn_hr_core_case_operations.contact_type']")
	public WebElement operations_source;

	// ----------------------- Total Rewards Case ---------------------------

	@FindBy(xpath = "//input[@id='sys_display.sn_hr_core_case_total_rewards.assignment_group']")
	public WebElement total_rewards_assignment_group;

	@FindBy(xpath = "//input[@id='sys_display.sn_hr_core_case_total_rewards.assigned_to']")
	public WebElement total_rewards_assign_to;

	@FindBy(xpath = ".//*[@id='sn_hr_core_case_total_rewards.priority']")
	public WebElement total_rewards_priority;

	@FindBy(xpath = ".//*[@id='sys_display.sn_hr_core_case_total_rewards.hr_service']")
	public WebElement total_rewards_hr_service;

	@FindBy(xpath = ".//*[@id='sys_display.sn_hr_core_case_total_rewards.opened_for']")
	public WebElement total_rewards_opened_for;

	@FindBy(xpath = "//select[@id='sn_hr_core_case_total_rewards.state']")
	public WebElement total_rewards_state;

	@FindBy(xpath = "//input[@id='sys_readonly.sn_hr_core_case_total_rewards.number']")
	public WebElement total_rewards_caseid;

	@FindBy(xpath = "//select[@id='sn_hr_core_case_total_rewards.contact_type']")
	public WebElement total_rewards_source;

	@FindBy(xpath = "//*[@id='activity-stream-work_notes-textarea']")
	public WebElement workFlowNotes;

	// @FindBy(xpath =
	// "//*[@id='section-464d207953131200eb7c0a1806dc34b5.header']/nav/div")
	@FindBy(xpath = "//*[contains(@id,'section-') and contains(@id,'.header')]")
	public WebElement header;

	@FindBy(xpath = "//*[@id='context_1']")
	public WebElement save;

	String expected_closednotcomplete = "Closed Not Complete";
	String expected_resolved = "Resolved";
	String expected_pending = "Pending";
	String expected_cancelled = "Cancelled";
	String expected_source = "Self Service";

	// ----------------------- Generic Workflow ------------------//

	public void default_sourcevalue_validation(WebElement case_source) {
		Select selectsr = new Select(case_source);
		WebElement options = selectsr.getFirstSelectedOption();
		String actual_srource = options.getText();
		Assert.assertEquals(actual_srource, expected_source);

		logSuccess("Expected Value - " + expected_source);
		logSuccess("Actual Value - " + actual_srource);

		System.out.print("\nDefault Source : \n");
		System.out.println(actual_srource);
	}

	public void updateCaseWorkflow() throws IOException {
		PageFactory.initElements(driver, GenericCatalogItemCasePage.class);

		operations_assign_to.clear();
		operations_assign_to.sendKeys("d");
		checkForPageLoad(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		operations_assign_to.sendKeys(Keys.ARROW_DOWN);
		operations_assign_to.sendKeys(Keys.ENTER);

		Select state = new Select(states);
		checkForPageLoad(driver);

		String[] availableStates = states.getText().split("\\r?\\n");
		System.out.println("Available States Size - " + availableStates.length);
		System.out.println("Current State - " + state.getFirstSelectedOption().getText());

		for (int i = 0; i < availableStates.length; i++) {
			System.out.println("Saving the HR Case with State - " + availableStates[i]);
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("Saving the HR Case with State - " + availableStates[i], ExtentColor.CYAN));
			states.click();
			checkForPageLoad(driver);
			if (state.getFirstSelectedOption().getText().equalsIgnoreCase("Awaiting Approval")) {

				logSuccess("Expected Value - " + "Awaiting Approval");
				logSuccess("Actual Value - " + state.getFirstSelectedOption().getText());

				state.selectByVisibleText("Open");
				checkForPageLoad(driver);
				Actions actions = new Actions(driver);
				actions.contextClick(header).perform();
				checkForPageLoad(driver);
				actions.sendKeys(Keys.ENTER).perform();
			}
			state.selectByVisibleText(availableStates[i]);
			checkForPageLoad(driver);
			if (availableStates[i].equalsIgnoreCase("Pending") || availableStates[i].equalsIgnoreCase("Resolved")
					|| availableStates[i].equalsIgnoreCase("Cancelled")) {
				workFlowNotes.sendKeys("Automation Test Run");
			}
			Actions actions = new Actions(driver);
			actions.contextClick(header).perform();
			checkForPageLoad(driver);
			actions.sendKeys(Keys.ENTER).perform();
			checkForPageLoad(driver);

//			if (availableStates[i].equals(state.getFirstSelectedOption().getText())) {
//				System.out.println("HR Case State is updated successfully to - " + availableStates[i]);
//				test.get().log(Status.PASS, MarkupHelper.createLabel(
//						"HR Case State is updated successfully to - " + availableStates[i], ExtentColor.GREEN));
//				screenshotPath = getScreenshot(driver, this.getClass().getName());
//				test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//			} else {
//				System.out.println("HR Case State update Failed for - " + availableStates[i]);
//				test.get().log(Status.FAIL, MarkupHelper
//						.createLabel("HR Case State update Failed for - " + availableStates[i], ExtentColor.RED));
//				screenshotPath = getScreenshot(driver, this.getClass().getName());
//				test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//
//			}

			if (!(driver.findElement(By.xpath("//*[@id='output_messages']")).isDisplayed())) {
				System.out.println("HR Case State is updated successfully to - " + availableStates[i]);
				test.get().log(Status.PASS, MarkupHelper.createLabel(
						"HR Case State is updated successfully to - " + availableStates[i], ExtentColor.GREEN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} else {
				System.out.println("HR Case State update Failed for - " + availableStates[i]);
				test.get().log(Status.FAIL, MarkupHelper
						.createLabel("HR Case State update Failed for - " + availableStates[i], ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

			}
		}
		checkForPageLoad(driver);

//		try {
//			update.click();
//		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
//			update.click();
//		}
//		System.out.printf("\nSuccessfully Updated to WIP State!!!");
//
//		checkForPageLoad(driver);
//		itil_caseID.click();
//		checkForPageLoad(driver);
//		state.selectByValue("24");
//		checkForPageLoad(driver);
//		popup_pending_comment.sendKeys("Test Pending State");
//		popup_pending_ok.click();
//		checkForPageLoad(driver);
//		try {
//			checkForPageLoad(driver);
//			update.click();
//		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
//			checkForPageLoad(driver);
//			update.click();
//		}
//
//		checkForPageLoad(driver);
//		itil_caseID.click();
//		WebElement option_pending = state.getFirstSelectedOption();
//		String actual_pending = option_pending.getText();
//		checkForPageLoad(driver);
//		Assert.assertEquals(actual_pending, expected_pending);
//
//		checkForPageLoad(driver);
//		state.selectByValue("20");
//		try {
//			checkForPageLoad(driver);
//			update.click();
//		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
//			checkForPageLoad(driver);
//			update.click();
//		}
//		System.out.printf("\nSuccessfully Updated to Pending State!!!");
//
//		checkForPageLoad(driver);
//		itil_caseID.click();
//		WebElement option_resolved = state.getFirstSelectedOption();
//		String actual_resolved = option_resolved.getText();
//		checkForPageLoad(driver);
//		Assert.assertEquals(actual_resolved, expected_resolved);
//		checkForPageLoad(driver);
//		state.selectByValue("4");
//
//		try {
//			checkForPageLoad(driver);
//			update.click();
//		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
//			checkForPageLoad(driver);
//			update.click();
//		}
//		System.out.printf("\nSuccessfully Updated to Resolved State!!!");
//		checkForPageLoad(driver);
//		itil_caseID.click();
//		// String expected_closednotcomplete = state.getFirstSelectedOption();
//		WebElement option_closecomplete = state.getFirstSelectedOption();
//		checkForPageLoad(driver);
//		String actual_closednotcomplete = option_closecomplete.getText();
//
//		Assert.assertEquals(actual_closednotcomplete, expected_closednotcomplete);
//		System.out.printf("\nSuccessfully Updated to Closed Not Complete State!!!");

	}

	public void cancel_case(WebElement case_state) {
		checkForPageLoad(driver);
		Select state = new Select(case_state);
		checkForPageLoad(driver);
		// itil_caseID.click();
		// checkForPageLoad(driver);
		/*
		 * state.selectByValue("7"); checkForPageLoad(driver);
		 */
		checkForPageLoad(driver);
		btn_cancel.click();
		checkForPageLoad(driver);

		cancel_comment.sendKeys("Test Cancel Functionality");
		checkForPageLoad(driver);

		cancel_ok.click();
		checkForPageLoad(driver);

		/*
		 * try { checkForPageLoad(driver); update.click(); } catch
		 * (org.openqa.selenium.StaleElementReferenceException ex) {
		 * checkForPageLoad(driver); update.click(); }
		 */

		WebElement option_cancelled = state.getFirstSelectedOption();
		checkForPageLoad(driver);
		String actual_cancelled = option_cancelled.getText();

		Assert.assertEquals(actual_cancelled, expected_cancelled);

		System.out.printf("\nSuccessfully Cancelled a Case!!!");

	}
	// ----------------------- Payroll Workflow
	// --------------------------------------------------

	/*
	 * public void Open_case_form()
	 * 
	 * { String CaseID = payroll_caseid.getText();
	 * 
	 * JavascriptExecutor executor = (JavascriptExecutor)driver; ConfigFileReader cf
	 * = new ConfigFileReader(); //String HRCASEID = "HRC0001992"; //
	 * driver.get(cf.getUrl()); // driver.manage().timeouts().implicitlyWait(30,
	 * TimeUnit.SECONDS); driver.get(cf.getUrl()); checkForPageLoad(driver);
	 * 
	 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 * 
	 * leftsearch.sendKeys(" HR case");
	 * driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	 * checkForPageLoad(driver);
	 * 
	 * 
	 * driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	 * checkForPageLoad(driver);
	 * executor.executeScript("arguments[0].click();",allcase);
	 * System.out.printf("\nClicked on All Open Cases");
	 * driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	 * 
	 * driver.switchTo().frame(0); System.out.printf("\nSwitched to Mainframe");
	 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 * checkForPageLoad(driver); driver.manage().timeouts().implicitlyWait(30,
	 * TimeUnit.SECONDS);
	 * 
	 * 
	 * 
	 * try { casenumber.sendKeys(CaseID); casenumber.sendKeys(Keys.ENTER); }
	 * catch(org.openqa.selenium.StaleElementReferenceException ex) {
	 * casenumber.sendKeys(CaseID); casenumber.sendKeys(Keys.ENTER);
	 * 
	 * driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	 * 
	 * }
	 * 
	 * 
	 * itil_caseID.click();
	 * 
	 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 * 
	 * checkForPageLoad(driver);
	 * System.out.print("\nCase Successfully Opened !!! \n");
	 * 
	 * }
	 * 
	 * //----------------------- Payroll Workflow
	 * --------------------------------------------------
	 * 
	 * public void update_payroll_workflow()
	 * 
	 * { //String CaseID = payroll_caseid.getText();
	 * 
	 * 
	 * Select state = new Select(payroll_state); state.selectByValue("18");
	 * System.out.printf("\nState Validation "); checkForPageLoad(driver);
	 * 
	 * 
	 * checkForPageLoad(driver); driver.manage().timeouts().implicitlyWait(60,
	 * TimeUnit.SECONDS);
	 * 
	 * try { update.click(); }
	 * catch(org.openqa.selenium.StaleElementReferenceException ex) {
	 * update.click(); }
	 * System.out.printf("\nSuccessfully Updated to WIP State!!!");
	 * checkForPageLoad(driver); itil_caseID.click(); checkForPageLoad(driver);
	 * state.selectByValue("20"); try { checkForPageLoad(driver); update.click(); }
	 * catch(org.openqa.selenium.StaleElementReferenceException ex) {
	 * checkForPageLoad(driver); update.click(); }
	 * System.out.printf("\nSuccessfully Updated to Resolved State!!!");
	 * 
	 * checkForPageLoad(driver); itil_caseID.click(); checkForPageLoad(driver);
	 * state.selectByValue("24"); checkForPageLoad(driver);
	 * popup_pending_comment.sendKeys("Test Pending State");
	 * popup_pending_ok.click(); checkForPageLoad(driver); try {
	 * checkForPageLoad(driver); update.click(); }
	 * catch(org.openqa.selenium.StaleElementReferenceException ex) {
	 * checkForPageLoad(driver); update.click(); }
	 * System.out.printf("\nSuccessfully Updated to Pending State!!!");
	 * 
	 * checkForPageLoad(driver); itil_caseID.click(); checkForPageLoad(driver);
	 * state.selectByValue("4"); try { checkForPageLoad(driver); update.click(); }
	 * catch(org.openqa.selenium.StaleElementReferenceException ex) {
	 * checkForPageLoad(driver); update.click(); } System.out.
	 * printf("\nSuccessfully Updated to Closed Not Complete State!!!");
	 * 
	 * 
	 * }
	 * 
	 * 
	 * //----------------------- Core Case Workflow
	 * --------------------------------------------------
	 * 
	 * public void update_core_case_workflow()
	 * 
	 * { //String CaseID = payroll_caseid.getText();
	 * 
	 * 
	 * Select state = new Select(core_state); state.selectByValue("18");
	 * System.out.printf("\nState Validation "); checkForPageLoad(driver);
	 * 
	 * 
	 * checkForPageLoad(driver); driver.manage().timeouts().implicitlyWait(60,
	 * TimeUnit.SECONDS);
	 * 
	 * try { update.click(); }
	 * catch(org.openqa.selenium.StaleElementReferenceException ex) {
	 * update.click(); }
	 * System.out.printf("\nSuccessfully Updated to WIP State!!!");
	 * checkForPageLoad(driver); itil_caseID.click(); checkForPageLoad(driver);
	 * state.selectByValue("20"); try { checkForPageLoad(driver); update.click(); }
	 * catch(org.openqa.selenium.StaleElementReferenceException ex) {
	 * checkForPageLoad(driver); update.click(); }
	 * System.out.printf("\nSuccessfully Updated to Resolved State!!!");
	 * 
	 * checkForPageLoad(driver); itil_caseID.click(); checkForPageLoad(driver);
	 * state.selectByValue("24"); checkForPageLoad(driver);
	 * popup_pending_comment.sendKeys("Test Pending State");
	 * popup_pending_ok.click(); checkForPageLoad(driver); try {
	 * checkForPageLoad(driver); update.click(); }
	 * catch(org.openqa.selenium.StaleElementReferenceException ex) {
	 * checkForPageLoad(driver); update.click(); }
	 * System.out.printf("\nSuccessfully Updated to Pending State!!!");
	 * 
	 * checkForPageLoad(driver); itil_caseID.click(); checkForPageLoad(driver);
	 * state.selectByValue("4"); try { checkForPageLoad(driver); update.click(); }
	 * catch(org.openqa.selenium.StaleElementReferenceException ex) {
	 * checkForPageLoad(driver); update.click(); } System.out.
	 * printf("\nSuccessfully Updated to Closed Not Complete State!!!");
	 * 
	 * 
	 * }
	 * 
	 * //----------------------- Employee Services Case Workflow
	 * --------------------------------------------------
	 * 
	 * public void update_employee_services_workflow()
	 * 
	 * { //String CaseID = payroll_caseid.getText();
	 * 
	 * Select state = new Select(employee_services_state);
	 * state.selectByValue("18"); System.out.printf("\nState Validation ");
	 * checkForPageLoad(driver);
	 * 
	 * checkForPageLoad(driver); driver.manage().timeouts().implicitlyWait(60,
	 * TimeUnit.SECONDS);
	 * 
	 * try { update.click(); }
	 * catch(org.openqa.selenium.StaleElementReferenceException ex) {
	 * update.click(); }
	 * System.out.printf("\nSuccessfully Updated to WIP State!!!");
	 * 
	 * 
	 * checkForPageLoad(driver); itil_caseID.click(); checkForPageLoad(driver);
	 * state.selectByValue("24"); checkForPageLoad(driver);
	 * popup_pending_comment.sendKeys("Test Pending State");
	 * popup_pending_ok.click(); checkForPageLoad(driver); try {
	 * checkForPageLoad(driver); update.click(); }
	 * catch(org.openqa.selenium.StaleElementReferenceException ex) {
	 * checkForPageLoad(driver); update.click(); }
	 * System.out.printf("\nSuccessfully Updated to Pending State!!!");
	 * 
	 * 
	 * checkForPageLoad(driver); itil_caseID.click(); checkForPageLoad(driver);
	 * state.selectByValue("20"); try { checkForPageLoad(driver); update.click(); }
	 * catch(org.openqa.selenium.StaleElementReferenceException ex) {
	 * checkForPageLoad(driver); update.click(); }
	 * System.out.printf("\nSuccessfully Updated to Resolved State!!!");
	 * 
	 * 
	 * checkForPageLoad(driver); itil_caseID.click(); checkForPageLoad(driver);
	 * state.selectByValue("4"); try { checkForPageLoad(driver); update.click(); }
	 * catch(org.openqa.selenium.StaleElementReferenceException ex) {
	 * checkForPageLoad(driver); update.click(); } System.out.
	 * printf("\nSuccessfully Updated to Closed Not Complete State!!!");
	 * 
	 * 
	 * }
	 * 
	 * //----------------------- Work Force Admin Case Workflow
	 * -------------------------------------
	 * 
	 * public void update_total_rewards_workflow()
	 * 
	 * { //String CaseID = payroll_caseid.getText();
	 * 
	 * Select state = new Select(total_rewards_state); state.selectByValue("18");
	 * System.out.printf("\nState Validation "); checkForPageLoad(driver);
	 * 
	 * checkForPageLoad(driver); driver.manage().timeouts().implicitlyWait(60,
	 * TimeUnit.SECONDS);
	 * 
	 * try { update.click(); }
	 * catch(org.openqa.selenium.StaleElementReferenceException ex) {
	 * update.click(); }
	 * System.out.printf("\nSuccessfully Updated to WIP State!!!");
	 * 
	 * 
	 * checkForPageLoad(driver); itil_caseID.click(); checkForPageLoad(driver);
	 * state.selectByValue("24"); checkForPageLoad(driver);
	 * popup_pending_comment.sendKeys("Test Pending State");
	 * popup_pending_ok.click(); checkForPageLoad(driver); try {
	 * checkForPageLoad(driver); update.click(); }
	 * catch(org.openqa.selenium.StaleElementReferenceException ex) {
	 * checkForPageLoad(driver); update.click(); }
	 * System.out.printf("\nSuccessfully Updated to Pending State!!!");
	 * 
	 * 
	 * checkForPageLoad(driver); itil_caseID.click(); checkForPageLoad(driver);
	 * state.selectByValue("20"); try { checkForPageLoad(driver); update.click(); }
	 * catch(org.openqa.selenium.StaleElementReferenceException ex) {
	 * checkForPageLoad(driver); update.click(); }
	 * System.out.printf("\nSuccessfully Updated to Resolved State!!!");
	 * 
	 * 
	 * checkForPageLoad(driver); itil_caseID.click(); checkForPageLoad(driver);
	 * state.selectByValue("4"); try { checkForPageLoad(driver); update.click(); }
	 * catch(org.openqa.selenium.StaleElementReferenceException ex) {
	 * checkForPageLoad(driver); update.click(); } System.out.
	 * printf("\nSuccessfully Updated to Closed Not Complete State!!!");
	 * 
	 * 
	 * }
	 * 
	 * //----------------------- Total Rewards Case Workflow
	 * --------------------------------------------------
	 * 
	 * public void update_workforce_admin_workflow()
	 * 
	 * { //String CaseID = payroll_caseid.getText();
	 * 
	 * Select state = new Select(workforce_admin_state); state.selectByValue("18");
	 * System.out.printf("\nState Validation "); checkForPageLoad(driver);
	 * 
	 * checkForPageLoad(driver); driver.manage().timeouts().implicitlyWait(60,
	 * TimeUnit.SECONDS);
	 * 
	 * try { update.click(); }
	 * catch(org.openqa.selenium.StaleElementReferenceException ex) {
	 * update.click(); }
	 * System.out.printf("\nSuccessfully Updated to WIP State!!!");
	 * 
	 * 
	 * checkForPageLoad(driver); itil_caseID.click(); checkForPageLoad(driver);
	 * state.selectByValue("24"); checkForPageLoad(driver);
	 * popup_pending_comment.sendKeys("Test Pending State");
	 * popup_pending_ok.click(); checkForPageLoad(driver); try {
	 * checkForPageLoad(driver); update.click(); }
	 * catch(org.openqa.selenium.StaleElementReferenceException ex) {
	 * checkForPageLoad(driver); update.click(); }
	 * System.out.printf("\nSuccessfully Updated to Pending State!!!");
	 * 
	 * 
	 * checkForPageLoad(driver); itil_caseID.click(); checkForPageLoad(driver);
	 * state.selectByValue("20"); try { checkForPageLoad(driver); update.click(); }
	 * catch(org.openqa.selenium.StaleElementReferenceException ex) {
	 * checkForPageLoad(driver); update.click(); }
	 * System.out.printf("\nSuccessfully Updated to Resolved State!!!");
	 * 
	 * 
	 * checkForPageLoad(driver); itil_caseID.click(); checkForPageLoad(driver);
	 * state.selectByValue("4"); try { checkForPageLoad(driver); update.click(); }
	 * catch(org.openqa.selenium.StaleElementReferenceException ex) {
	 * checkForPageLoad(driver); update.click(); } System.out.
	 * printf("\nSuccessfully Updated to Closed Not Complete State!!!");
	 * 
	 * 
	 * }
	 * 
	 * /* public void update_payroll_itil_workinprogress() {
	 * 
	 * 
	 * 
	 * checkForPageLoad(driver); payroll_assign_to.clear();
	 * payroll_assign_to.sendKeys("David Shan");
	 * 
	 * 
	 * driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);
	 * payroll_assign_to.click(); driver.manage().timeouts().implicitlyWait(45,
	 * TimeUnit.SECONDS); JavascriptExecutor executor = (JavascriptExecutor)driver;
	 * executor.executeScript("arguments[0].click();",payroll_assign_to);
	 * driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	 * 
	 * Select priority = new Select(payroll_priority); priority.selectByValue("2");
	 * 
	 * List<WebElement> alloptions_priority = priority.getOptions(); for(WebElement
	 * e:alloptions_priority) System.out.println(e.getText());
	 * 
	 * driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS); Select state
	 * = new Select(payroll_state); state.selectByValue("18"); // WIP 18 || Resolved
	 * 20
	 * 
	 * List<WebElement> alloptions_state = state.getOptions(); for(WebElement
	 * e:alloptions_state) System.out.println(e.getText());
	 * 
	 * 
	 * driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	 * checkForPageLoad(driver); try { update.click(); }
	 * catch(org.openqa.selenium.StaleElementReferenceException ex) {
	 * update.click(); }
	 * 
	 * System.out.print("\nUpdated Successfully !!! \n"); checkForPageLoad(driver);
	 * driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	 * 
	 * }
	 * 
	 * public void update_payroll_itil_resolved() {
	 * 
	 * }
	 */
}