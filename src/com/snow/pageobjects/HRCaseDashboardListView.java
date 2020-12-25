package com.snow.pageobjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

public class HRCaseDashboardListView extends ReusableLibrary {
	public WebDriver driver;

	public HRCaseDashboardListView(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='filter']")
	public WebElement leftSearch;
	@FindBy(xpath = "//div[text()='Create New Case']")
	public WebElement createCase;
	@FindBy(xpath = "//div[text()='HR Case Dashboard']")
	public WebElement hrDashboard;
	@FindBy(xpath = "//input[@id='home_title']")
	public WebElement homeTitle;
	@FindBy(xpath = "//td[contains(text(),'Total Open Cases - Assigned to me')]")
	public WebElement openCasesAssignToMe;
	@FindBy(xpath = "//td[@id='dropzone1']/div[1]//div[2]//a")
	public WebElement totalOpenCasesAssignedToMe;
	@FindBy(xpath = "//td[contains(text(),'Breached Cases') and contains(text(), 'Assigned to me')]")
	public WebElement breachedCasesAssignMe;
	@FindBy(xpath = "//td[@id='dropzone1']/div[2]//div[2]//a")
	public WebElement totalBreachedCasesAssignedToMe;
	@FindBy(xpath = "//td[contains(text(),'High Priority Cases (Below breach)') and contains(text(), 'Assigned to Me')]")
	public WebElement highPriorityCasesAssignedMe;
	@FindBy(xpath = "//td[@id='dropzone1']/div[3]//div[2]//a")
	public WebElement totalHighPriorityCasesAssignedToMe;
	@FindBy(xpath = "//td[contains(text(),'Nearing Breach Cases - Assigned to Me')]")
	public WebElement nearingBreachCasesAssignMe;
	@FindBy(xpath = "//td[@id='dropzone1']/div[4]//div[2]//a")
	public WebElement totalnearingBreachCasesAssignedToMe;
	@FindBy(xpath = "//td[contains(text(),'Moderate/Low Cases (Below breach)') and contains(text(), 'Assigned to me')]")
	public WebElement moderateCasesAssignMe;
	@FindBy(xpath = "//td[@id='dropzone1']/div[5]//div[2]//a")
	public WebElement totalModerateCasesAssignedToMe;
	@FindBy(xpath = "//td[contains(text(),'Breached Cases') and contains(text(), 'My Group(s)')]")
	public WebElement breachedCasesMyGroups;
	@FindBy(xpath = "//td[@id='dropzone2']/div[1]//div[2]//a")
	public WebElement totalBreachedCasesMyGroups;
	@FindBy(xpath = "//td[contains(text(),'Total Open Cases ') and contains(text(), 'My Group(s)')]")
	public WebElement OpenCasesMyGroups;
	@FindBy(xpath = "//td[@id='dropzone2']/div[2]//div[2]//a")
	public WebElement totalOpenCasesMyGroups;
	@FindBy(xpath = "//td[contains(text(),'High Priority Cases (Below breach)') and contains(text(), 'My Group(s)')]")
	public WebElement highPrioritycasesMyGroups;
	@FindBy(xpath = "//td[@id='dropzone2']/div[3]//div[2]//a")
	public WebElement totalHighPrioritycasesMyGroups;
	@FindBy(xpath = "//td[contains(text(),'Nearing Breach Cases') and contains(text(), 'My Group(s)')]")
	public WebElement nearingBreachCasesMyGroups;
	@FindBy(xpath = "//td[@id='dropzone2']/div[4]//div[2]//a")
	public WebElement totalNearingBreachCasesMyGroups;
	@FindBy(xpath = "//td[contains(text(),'Moderate/Low Cases (Below breach)') and contains(text(), 'My Group(s)')]")
	public WebElement moderateCasesMyGroups;
	@FindBy(xpath = "//td[@id='dropzone2']/div[5]//div[2]//a")
	public WebElement totalModerateCasesMyGroups;
	@FindBy(xpath = "//td[contains(text(),'Open Cases') and contains(text(), 'My Group(s) & Unassigned')]")
	public WebElement totalOpenCasesMyGroupUnassigned;
	@FindBy(xpath = "//td[@id='dropzone2']/div[6]//div[2]//a")
	public WebElement totalCountOpenCasesMyGroupUnassigned;
	@FindBy(xpath = "(//th[@name='sla'])[1]")
	public WebElement sla;
	@FindBy(xpath = "((//th[@name='sla'])[1]//i)[2]")
	public WebElement sla1;
	@FindBy(xpath = "//h2[text()='HR Cases']")
	public WebElement hrCases;
	@FindBy(xpath = "//span[@id='sn_hr_core_case_breadcrumb']")
	public WebElement openORPendingCases;
	@FindBy(xpath = "//*[@id='user_info_dropdown']/div/span[1]")
	public WebElement LoggedUser;
	@FindBy(xpath = "//tbody[@class='list2_body']//tr//td[3]")
	public List<WebElement> listOfCaseNums;
	@FindBy(xpath = "//select[contains(@id,'state')]")
	public WebElement caseState;
	@FindBy(xpath = "//*[contains(@id,'header') and contains(@class,'section_header_div_no_scroll form_title')]")
	public WebElement header;
	@FindBy(xpath = "//*[@role='menuitem' and @title = 'Save record and remain here']")
	public WebElement saveOption;
	@FindBy(xpath = "//textarea[@id='activity-stream-textarea']")
	public WebElement worknotes;
	@FindBy(xpath = "//textarea[@id='activity-stream-work_notes-textarea']")
	public WebElement caseWorknotes;
	@FindBy(xpath = "//button[text()='Post']")
	public WebElement postBt;
	@FindBy(xpath = "//button[contains(@id,'lookup') and contains(@id,'assigned_to')]")
	public WebElement assignToSearch;
	@FindBy(xpath = "//select[contains(@id,'_select')]")
	public WebElement searchCriteria;
	@FindBy(xpath = "//input[contains(@id,'_text')]")
	public WebElement searchTextBox;
	@FindBy(xpath = "(//*[@id='sys_user_table_header_search_control'])[1]")
	public WebElement nameSearchTextBox;
	@FindBy(xpath = "//button[text()='New']")
	public WebElement newBtn;
	@FindBy(xpath = "//span[text()='Search for requester or case number']/parent::a")
	public WebElement searchForRequester;
	@FindBy(xpath = "//*[@id='s2id_autogen1_search']")
	public WebElement enterSearchRequester;
	@FindBy(xpath = "//*[@class = 'select2-drop select2-display-none select2-with-searchbox select2-drop-active']/ul/li")
	public List<WebElement> uniqueRequesterList;
	@FindBy(xpath = "//*[@class = 'select2-drop select2-display-none select2-with-searchbox select2-drop-active']/ul/li")
	public WebElement uniqueRequester;
	@FindBy(xpath = "//div[text()='Case Details']")
	public WebElement caseCreation;
	@FindBy(xpath = "//select[contains(@id,'priority')]")
	public WebElement casePriority;
	@FindBy(xpath = "//span[@class='input-group-addon input-group-select']//select")
	public WebElement searchDropdown;
	@FindBy(xpath = "(//i[@data-original-title='Personalize List'])[1]")
	public WebElement gearIcon;
	@FindBy(xpath = "//*[@id='slush_left']/option")
	public List<WebElement> slushLeft;
	@FindBy(xpath = "//*[@id='slush_right']/option")
	public List<WebElement> slushRight;
	@FindBy(xpath = "//span[text()='Add']//parent::a")
	public WebElement addArrow;
	@FindBy(xpath = "//button[@id='ok_button']")
	public WebElement okBtn;
	@FindBy(xpath = "(//th[@glide_label='Approval'])[1]")
	public WebElement addListColumn;
	@FindBy(xpath = "(//i[@data-original-title='Update Personalized List'])[1]")
	public WebElement updatedGearIcon;
	@FindBy(xpath = "//button[@id = 'sysverb_update_bottom']")
	public WebElement updateButton;
	@FindBy(xpath = "//button[contains(@id, 'reset_column')]")
	public WebElement resetColumns;
	@FindBy(xpath = "//b[text()='All']")
	public WebElement allFilter;
	@FindBy(xpath = "(//span[@class=' list_row_number_input '])[1]//span[2]")
	public WebElement totalRows;
	@FindBy(xpath = "//*[@class = 'select2-drop select2-display-none select2-with-searchbox select2-drop-active']/ul/li")
	public List<WebElement> uniqueRequester1;
	@FindBy(xpath = "//div[@id='s2id_ev_field_contact_type']/a")
	public WebElement source;
	@FindBy(xpath = "//select[@id='ev_field_contact_type']")
	public WebElement sourceDropDown;
	@FindBy(xpath = "//select[@id='ev_field_u_preferred_method_of_contact']")
	public WebElement methodOfContactDropdown;
	@FindBy(xpath = "//div[@id='s2id_service_input']/a")
	public WebElement hrService;
	@FindBy(xpath = "//*[@id='s2id_autogen2_search']")
	public WebElement hrServiceDropdown;
	@FindBy(xpath = "//*[@id='select2-drop']/ul/li/ul/li")
	public WebElement hrServiceOption;
	@FindBy(xpath = "//textarea[@id='ev_field_description']")
	public WebElement description;
	@FindBy(xpath = "(//button[text()='Create Case'])[2]")
	public WebElement createCaseBt;
	@FindBy(xpath = "//input[@id='sys_readonly.sn_hr_core_case_total_rewards.number']")
	public WebElement xpCaseNumber;
	@FindBy(xpath = "//input[contains(@id,'_text')]")
	public WebElement xpSearch;
	@FindBy(xpath = "//tbody[@class='list2_body']//tr//td[3]/a")
	public WebElement xpCaseNum;
	@FindBy(xpath = "//select[contains(@id, '.state')]")
	public WebElement xpState;
	@FindBy(xpath = "//span[@class='percent_complete_text']")
	public List<WebElement> xpSlaList;
	@FindBy(xpath = "//select[@class='form-control default-focus-outline']")
	public WebElement searchDropDown;
	@FindBy(xpath = "//*[@id='s2id_autogen7_search']")
	public WebElement sourceEnter;

	String order;
	String beforeTotalOpenCasesMyGrpUnAssign;
	String beforeTotalOpencases;
	String beforeBreachedCasesAssMe;
	String beforeHighPriorityCasesAssme;
	String beforeBreacheCasesMygroups;
	String beforeHighPriorityCasesMyGroups;
	String beforeModerateCasesMyGroup;
	String beforeTotalOpenCasesMygroups;
	String beforeNearingBreachCasesMyGroup;
	int afterTotalOpencases;
	int afterTotalOpenCasesMygroupCount;
	String totalWidgets;
	List<String> list;
	List<String> copy;

	/*
	 * Navigating to HR Case Dashboard
	 */
	public void navigateToHRDashboard() throws Exception {
		driver.get(homePageURL);
		waitForAction(driver);
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.sendKeys("HR CASE DASHBOARD");
		checkForPageLoad(driver);

		waitForElementToBeClickable(driver, hrDashboard);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", hrDashboard);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, hrDashboard);
		hrDashboard.click();

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, homeTitle);
		waitForElementToBeClickable(driver, homeTitle);
		if (homeTitle.getAttribute("value").equalsIgnoreCase("HR Case Dashboard")) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Successfully Navigate to HR Case Dashboard Home Page",
					ExtentColor.GREEN));
			logSuccess("Expected Value - " + "HR Case Dashboard");
			logSuccess("Actual Value - " + homeTitle.getAttribute("value"));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Navigation Failed to to reach the HR Case Dashboard Home Page", ExtentColor.RED));
			logFailure("Expected Value - " + "HR Case Dashboard");
			logFailure("Actual Value - " + homeTitle.getAttribute("value"));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	/*
	 * check for the all Hr Cases Widgets are available
	 */
	public void confirmingHrcaseDashboard() throws Exception {
		checkForPageLoad(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, openCasesAssignToMe);
		if (openCasesAssignToMe.isDisplayed()) {
			beforeTotalOpencases = totalOpenCasesAssignedToMe.getText();
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Total open case AssignTo me widget is displayed with count="
							+ totalOpenCasesAssignedToMe.getText(), ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Total open case AssignTo me widget is Not displayed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		if (breachedCasesAssignMe.isDisplayed()) {
			beforeBreachedCasesAssMe = totalBreachedCasesAssignedToMe.getText();
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Breached cases AssignTo me widget is displayed with count="
							+ totalBreachedCasesAssignedToMe.getText(), ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Breached cases AssignTo me widget is Not displayed", ExtentColor.RED));
		}

		if (highPriorityCasesAssignedMe.isDisplayed()) {
			beforeHighPriorityCasesAssme = totalHighPriorityCasesAssignedToMe.getText();
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
			beforeBreacheCasesMygroups = totalBreachedCasesMyGroups.getText();
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"breached cases My Groups widget is displayed with count=" + totalBreachedCasesMyGroups.getText(),
					ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("breached cases My Groups widget is Not displayed", ExtentColor.RED));
		}

		if (OpenCasesMyGroups.isDisplayed()) {
			beforeTotalOpenCasesMygroups = totalOpenCasesMyGroups.getText();
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Total Open cases My Groups widget is displayed with count=" + totalOpenCasesMyGroups.getText(),
					ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Total Open cases My Groups widget is Not displayed", ExtentColor.RED));
		}

		if (highPrioritycasesMyGroups.isDisplayed()) {
			beforeHighPriorityCasesMyGroups = totalHighPrioritycasesMyGroups.getText();
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("High Priority cases My Groups widget is displayed with count="
							+ totalHighPrioritycasesMyGroups.getText(), ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("High Priority cases My Groups widget is Not displayed", ExtentColor.RED));
		}

		if (nearingBreachCasesMyGroups.isDisplayed()) {
			beforeNearingBreachCasesMyGroup = totalNearingBreachCasesMyGroups.getText();
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Nearing Breach cases My Groups widget is displayed with count="
							+ totalNearingBreachCasesMyGroups.getText(), ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Nearing Breach cases My Groups widget is Not displayed", ExtentColor.RED));
		}

		if (moderateCasesMyGroups.isDisplayed()) {
			beforeModerateCasesMyGroup = totalModerateCasesMyGroups.getText();
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Moderate or Low cases My Groups widget is displayed with count="
							+ totalModerateCasesMyGroups.getText(), ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Moderate or Low cases My Groups widget is Not displayed", ExtentColor.RED));
		}

		if (totalOpenCasesMyGroupUnassigned.isDisplayed()) {
			beforeTotalOpenCasesMyGrpUnAssign = totalCountOpenCasesMyGroupUnassigned.getText();
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Open cases My Groups Unassigned widget is displayed with count="
							+ totalCountOpenCasesMyGroupUnassigned.getText(), ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Open cases My Groups Unassigned widget is Not displayed", ExtentColor.RED));
		}
	}

	/*
	 * check for the SLA order is Descending or Not
	 */

	public void checkSLAOrder() throws Exception {
		waitForElementToBeClickable(driver, totalOpenCasesAssignedToMe);
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		execute.executeScript("arguments[0].click();", totalOpenCasesAssignedToMe);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, hrCases);
		if (hrCases.isDisplayed()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Navigating to HR Cases Page is Displayed", ExtentColor.CYAN));

		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Navigation failed to HR Cases Page", ExtentColor.RED));

		}
		if (sla.getAttribute("sort_dir").equals("DESC")) {
			System.out.println("SLA Descending");
			logSuccess("SLA Order is Descending defaultly");
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		} else {

			if (isElementPresent(updatedGearIcon)) {
				waitForElementToBeClickable(driver, updatedGearIcon);
				updatedGearIcon.click();

				try {
					waitForElementToBeClickable(driver, resetColumns);
					checkForPageLoad(driver);
					resetColumns.click();
					test.get().log(Status.INFO,
							MarkupHelper.createLabel("Clicking the Reset Column Default View Btn", ExtentColor.CYAN));
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			waitForElementToBeClickable(driver, gearIcon);
			checkForPageLoad(driver);
			gearIcon.click();
			test.get().log(Status.PASS, MarkupHelper.createLabel("click on the gear icon", ExtentColor.GREEN));

			waitForElementToBeClickable(driver, slushLeft.get(0));
			for (WebElement element : slushLeft) {
				if (element.getText().equals("Active")) {
					waitForElementToBeClickable(driver, element);
					element.click();
					test.get().log(Status.INFO,
							MarkupHelper.createLabel("Selecting the Column name==Active", ExtentColor.CYAN));

					break;
				}
			}

			waitForElementToBeClickable(driver, addArrow);
			addArrow.click();
			waitForAction(driver);
			waitForElementToBeClickable(driver, okBtn);
			okBtn.click();
			waitForAction(driver);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			waitForElementToBeClickable(driver, updatedGearIcon);
			updatedGearIcon.click();
			waitForAction(driver);

			waitForElementToBeClickable(driver, resetColumns);
			resetColumns.click();
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Clicking the Reset Column Default View Btn", ExtentColor.GREEN));

			waitForElement(driver, sla);
			if (sla.getAttribute("sort_dir").equals("DESC")) {
				System.out.println("SLA order is descending");
				logSuccess("SLA Order is Descending defaultly");
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} else {
				logFailure("SLA order is not descending order");
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}

		}

	}

	// validating the HR Case Dash board widgets
	public void validateHRDashboard() throws Exception {
		waitForElementToBeClickable(driver, totalOpenCasesAssignedToMe);
		totalOpenCasesAssignedToMe.click();

		driver.switchTo().defaultContent();
		String username = LoggedUser.getText();
		System.out.println(username);
		// driver.switchTo().frame(0);
		waitForFrameToBeAvailable(driver, "gsft_main");
		String ExpectedResult = "All>State = Open .or. State = Pending .or. State = Awaiting Approval>Assigned to is "
				+ username;
		waitForElement(driver, openORPendingCases);
		if (openORPendingCases.getText().equals(ExpectedResult)) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Total open cases Assignto me is displays that are Open and Pending", ExtentColor.GREEN));

			logSuccess("Expected Value - " + ExpectedResult);
			logSuccess("Actual Value - " + openORPendingCases.getText());

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"Not displaying the Total open cases Assignto me is displays that are Open and Pending ",
							ExtentColor.RED));

			logFailure("Expected Value - " + ExpectedResult);
			logFailure("Actual Value - " + openORPendingCases.getText());

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		// checkForPageLoad(driver);
		driver.navigate().back();
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, totalBreachedCasesAssignedToMe);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", totalBreachedCasesAssignedToMe);

		waitForFrameToBeAvailable(driver, "gsft_main");

		String breachedcases = "All>State = Open .or. State = Pending .or. State = Awaiting Approval>Assigned to is "
				+ username + ">SLA >= 100";
		// System.out.println(openORPendingCases.getText());
		if (openORPendingCases.getText().equals(breachedcases)) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Breached cases Assignto me is displays that are Open and Pending and SLA>100", ExtentColor.GREEN));

			logSuccess("Expected Value - " + breachedcases);
			logSuccess("Actual Value - " + openORPendingCases.getText());

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"Not displaying the Breached cases Assignto me that are Open and Pending and SLA>100 ",
							ExtentColor.RED));

			logFailure("Expected Value - " + breachedcases);
			logFailure("Actual Value - " + openORPendingCases.getText());

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		driver.navigate().back();

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, totalBreachedCasesAssignedToMe);
		executor.executeScript("arguments[0].click();", totalnearingBreachCasesAssignedToMe);

		waitForFrameToBeAvailable(driver, "gsft_main");
		System.out.println(openORPendingCases.getText());
		String nearingBreach = "All>State = Open .or. State = Pending .or. State = Awaiting Approval>Assigned to is "
				+ username + ">SLA between 75 and 99.99";
		if (openORPendingCases.getText().equals(nearingBreach)) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Nearing Breach Cases-Assigned to Me displays Open and Pending cases where the HR Case(s) are nearing breaching (SLA is 75% - 99 %)",
					ExtentColor.GREEN));

			logSuccess("Expected Value - " + nearingBreach);
			logSuccess("Actual Value - " + openORPendingCases.getText());

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Not displaying the Nearing Breach cases Assignto me that are Open and Pending and SLA between 75 and 99 ",
					ExtentColor.RED));

			logFailure("Expected Value - " + nearingBreach);
			logFailure("Actual Value - " + openORPendingCases.getText());

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		driver.navigate().back();

		// driver.switchTo().defaultContent();
		// driver.switchTo().frame("gsft_main");
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, totalModerateCasesAssignedToMe);
		executor.executeScript("arguments[0].click();", totalModerateCasesAssignedToMe);

		waitForFrameToBeAvailable(driver, "gsft_main");

		System.out.println(openORPendingCases.getText());
		String moderateOrlowBreach = "All>State = Open .or. State = Pending .or. State = Awaiting Approval>Priority != 1 - High>Assigned to is "
				+ username + ">SLA < 75";
		if (openORPendingCases.getText().equals(moderateOrlowBreach)) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Moderate/Low Cases (Below Breach) - Assigned to me displays Open and Pending Cases where the HR Case Priority is Low / Moderate, and the SLA is not near or at breach (SLA is below 75%)",
					ExtentColor.GREEN));

			logSuccess("Expected Value - " + moderateOrlowBreach);
			logSuccess("Actual Value - " + openORPendingCases.getText());

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Not displaying Moderate/Low Cases (Below Breach) - Assigned to me displays Open and Pending Cases where the HR Case Priority is Low / Moderate, and the SLA is not near or at breach (SLA is below 75% ",
					ExtentColor.RED));

			logFailure("Expected Value - " + moderateOrlowBreach);
			logFailure("Actual Value - " + openORPendingCases.getText());

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		driver.navigate().back();

		// driver.switchTo().defaultContent();
		// driver.switchTo().frame("gsft_main");
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, totalHighPriorityCasesAssignedToMe);
		executor.executeScript("arguments[0].click();", totalHighPriorityCasesAssignedToMe);

		waitForFrameToBeAvailable(driver, "gsft_main");

		String highPriorityCases = "All>State = Open .or. State = Pending .or. State = Awaiting Approval>Assigned to is "
				+ username + ">Priority = 1 - High>SLA < 75";
		if (openORPendingCases.getText().equals(highPriorityCases)) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"High Priority Cases (Below Breach)  - Assigned to Me displays Open and Pending Cases where the HR Case Priority is High and the SLA is not near or at breach (SLA is below 75%)",
					ExtentColor.GREEN));

			logSuccess("Expected Value - " + highPriorityCases);
			logSuccess("Actual Value - " + openORPendingCases.getText());

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Not displaying High Priority Cases (Below Breach)  - Assigned to Me displays Open and Pending Cases where the HR Case Priority is High and the SLA is not near or at breach (SLA is below 75%) ",
					ExtentColor.RED));

			logFailure("Expected Value - " + highPriorityCases);
			logFailure("Actual Value - " + openORPendingCases.getText());

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		driver.navigate().back();

		// driver.switchTo().defaultContent();
		// driver.switchTo().frame("gsft_main");
		waitForFrameToBeAvailable(driver, "gsft_main");

		beforeTotalOpenCasesMygroups = "";
		String[] counter = totalOpenCasesMyGroups.getText().split(",");
		for (int i = 0; i < counter.length; i++) {
			beforeTotalOpenCasesMygroups = beforeTotalOpenCasesMygroups + counter[i];
		}
		int openCasesMyGroup = Integer.parseInt(beforeTotalOpenCasesMygroups);
		if (openCasesMyGroup >= 1) {
			waitForElementToBeClickable(driver, totalOpenCasesMyGroups);
			executor.executeScript("arguments[0].click();", totalOpenCasesMyGroups);

			waitForFrameToBeAvailable(driver, "gsft_main");
			// totalWidgets = totalRows.getText();

			totalWidgets = "";
			String[] counter2 = totalRows.getText().split(",");
			for (int i = 0; i < counter2.length; i++) {
				totalWidgets = totalWidgets + counter2[i];
			}
			if (beforeTotalOpenCasesMygroups.equals(totalWidgets)) {
				test.get().log(Status.PASS, MarkupHelper.createLabel(
						"Total Open Cases –My Group(s) displays ALL Open and Pending cases for assignment group(s)=="
								+ totalWidgets,
						ExtentColor.GREEN));

				logSuccess("Expected Value - " + totalWidgets);
				logSuccess("Actual Value - " + beforeTotalOpenCasesMygroups);

			} else {
				test.get().log(Status.FAIL, MarkupHelper.createLabel(
						"Total Open Cases –My Group(s) Not displays ALL Open and Pending cases for assignment group(s)",
						ExtentColor.RED));
				logFailure("Expected Value - " + totalWidgets);
				logFailure("Actual Value - " + beforeTotalOpenCasesMygroups);
			}
		} else {
			test.get().log(Status.INFO, MarkupHelper.createLabel(
					"No Record found for Total Open Cases –My Group(s) ALL Open and Pending cases for assignment group(s)",
					ExtentColor.ORANGE));

		}

		driver.navigate().back();

		// driver.switchTo().defaultContent();
		// driver.switchTo().frame("gsft_main");
		waitForFrameToBeAvailable(driver, "gsft_main");
		beforeBreacheCasesMygroups = "";
		String[] counter1 = totalBreachedCasesMyGroups.getText().split(",");
		for (int i = 0; i < counter1.length; i++) {
			beforeBreacheCasesMygroups = beforeBreacheCasesMygroups + counter1[i];
		}
		int totalBreachMyGroupCnt = Integer.parseInt(beforeBreacheCasesMygroups);
		if (totalBreachMyGroupCnt >= 1) {
			waitForElementToBeClickable(driver, totalBreachedCasesMyGroups);
			executor.executeScript("arguments[0].click();", totalBreachedCasesMyGroups);

			waitForFrameToBeAvailable(driver, "gsft_main");
			totalWidgets = "";
			String[] counter3 = totalRows.getText().split(",");
			for (int i = 0; i < counter3.length; i++) {
				totalWidgets = totalWidgets + counter3[i];
			}
			if (beforeBreacheCasesMygroups.equals(totalWidgets)) {
				test.get().log(Status.PASS, MarkupHelper.createLabel(
						" My Group(s) Breached Cases  displays Open and Pending cases for assignment group(s) where the HR Case(s) have breached (SLA is 100% or greater)=="
								+ totalWidgets,
						ExtentColor.GREEN));

				logSuccess("Expected Value - " + totalWidgets);
				logSuccess("Actual Value - " + beforeBreacheCasesMygroups);

			} else {
				test.get().log(Status.FAIL, MarkupHelper.createLabel(
						" My Group(s) Breached Cases Not displays Open and Pending cases for assignment group(s) where the HR Case(s) have breached (SLA is 100% or greater)",
						ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				logFailure("Expected Value - " + totalWidgets);
				logFailure("Actual Value - " + beforeBreacheCasesMygroups);

			}
		} else {
			test.get().log(Status.INFO, MarkupHelper.createLabel(
					"No Records Found for Breached Cases – My Group(s) Breached Cases Open and Pending cases for assignment group(s) where the HR Case(s) have breached (SLA is 100% or greater)",
					ExtentColor.ORANGE));

		}

		driver.navigate().back();

		// driver.switchTo().defaultContent();
		// driver.switchTo().frame("gsft_main");

		try {
			waitForFrameToBeAvailable(driver, "gsft_main");
			beforeHighPriorityCasesMyGroups = totalHighPrioritycasesMyGroups.getText();
		} catch (Exception e) {
			driver.switchTo().defaultContent();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", hrDashboard);
			// checkForPageLoad(driver);
			driver.switchTo().frame("gsft_main");
			beforeHighPriorityCasesMyGroups = totalHighPrioritycasesMyGroups.getText();
		}
		int totalHighPriorityMyGroupcnt = Integer.parseInt(beforeHighPriorityCasesMyGroups);
		if (totalHighPriorityMyGroupcnt >= 1) {
			waitForElementToBeClickable(driver, totalHighPrioritycasesMyGroups);
			executor.executeScript("arguments[0].click();", totalHighPrioritycasesMyGroups);

			waitForFrameToBeAvailable(driver, "gsft_main");

			totalWidgets = totalRows.getText();
			if (beforeHighPriorityCasesMyGroups.equals(totalWidgets)) {
				test.get().log(Status.PASS, MarkupHelper.createLabel(
						"High Priority Cases – My Group(s) displays Open and Pending Cases for assignment group(s) where the HR Case Priority is High and the SLA is not near or at breach  (SLA is below 75%)=="
								+ totalWidgets,
						ExtentColor.GREEN));

				logSuccess("Expected Value - " + totalWidgets);
				logSuccess("Actual Value - " + beforeHighPriorityCasesMyGroups);

			} else {
				test.get().log(Status.FAIL, MarkupHelper.createLabel(
						"High Priority Cases – My Group(s) Not displays Open and Pending Cases for assignment group(s) where the HR Case Priority is High and the SLA is not near or at breach  (SLA is below 75%)=="
								+ totalWidgets,
						ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				logFailure("Expected Value - " + totalWidgets);
				logFailure("Actual Value - " + beforeHighPriorityCasesMyGroups);

			}
		} else {
			test.get().log(Status.INFO, MarkupHelper.createLabel(
					"No Records Found for High Priority Cases – My Group(s) Open and Pending Cases for assignment group(s) where the HR Case Priority is High and the SLA is not near or at breach  (SLA is below 75%)",
					ExtentColor.ORANGE));

		}

		driver.navigate().back();

		// driver.switchTo().defaultContent();
		// driver.switchTo().frame("gsft_main");
		waitForFrameToBeAvailable(driver, "gsft_main");
		beforeModerateCasesMyGroup = totalModerateCasesMyGroups.getText();
		int BeforeModerateMyGroupcnt = Integer.parseInt(beforeModerateCasesMyGroup);
		if (BeforeModerateMyGroupcnt >= 1) {
			waitForElementToBeClickable(driver, totalModerateCasesMyGroups);
			executor.executeScript("arguments[0].click();", totalModerateCasesMyGroups);

			waitForFrameToBeAvailable(driver, "gsft_main");
			checkForPageLoad(driver);
			waitForElementToBeClickable(driver, totalRows);
			totalWidgets = totalRows.getText().trim();
			if (beforeModerateCasesMyGroup.equals(totalWidgets)) {
				test.get().log(Status.PASS, MarkupHelper.createLabel(
						" Moderate/Low Cases (Below Breach) - My Group(s) displays Open and Pending Cases for assignment group(s) where the HR Case Priority is Low / Moderate and the SLA is not near or at breach (SLA is below 75%)=="
								+ totalWidgets,
						ExtentColor.GREEN));

				logSuccess("Expected Value - " + totalWidgets);
				logSuccess("Actual Value - " + beforeModerateCasesMyGroup);

			} else {
				test.get().log(Status.FAIL, MarkupHelper.createLabel(
						" Moderate/Low Cases (Below Breach) - My Group(s) Not displays Open and Pending Cases for assignment group(s) where the HR Case Priority is Low / Moderate and the SLA is not near or at breach (SLA is below 75%)=="
								+ totalWidgets,
						ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				logFailure("Expected Value - " + totalWidgets);
				logFailure("Actual Value - " + beforeModerateCasesMyGroup);

			}
		} else {
			test.get().log(Status.INFO, MarkupHelper.createLabel(
					"No Records Found for  Moderate/Low Cases (Below Breach) - My Group(s) displays Open and Pending Cases for assignment group(s) where the HR Case Priority is Low / Moderate and the SLA is not near or at breach (SLA is below 75%)",
					ExtentColor.ORANGE));

		}

		driver.navigate().back();

		// driver.switchTo().defaultContent();
		// driver.switchTo().frame("gsft_main");
		waitForFrameToBeAvailable(driver, "gsft_main");
		beforeTotalOpenCasesMyGrpUnAssign = "";
		String[] counter2 = totalCountOpenCasesMyGroupUnassigned.getText().split(",");
		for (int i = 0; i < counter2.length; i++) {
			beforeTotalOpenCasesMyGrpUnAssign = beforeTotalOpenCasesMyGrpUnAssign + counter2[i];
		}
		int totalOpenCasesUnassignedCnt = Integer.parseInt(beforeTotalOpenCasesMyGrpUnAssign);
		if (totalOpenCasesUnassignedCnt >= 1) {
			waitForElementToBeClickable(driver, totalCountOpenCasesMyGroupUnassigned);
			executor.executeScript("arguments[0].click();", totalCountOpenCasesMyGroupUnassigned);
			waitForFrameToBeAvailable(driver, "gsft_main");

			totalWidgets = "";
			String[] counter3 = totalRows.getText().split(",");
			for (int i = 0; i < counter3.length; i++) {
				totalWidgets = totalWidgets + counter3[i];
			}
			if (beforeTotalOpenCasesMyGrpUnAssign.equals(totalWidgets)) {
				test.get().log(Status.PASS, MarkupHelper.createLabel(
						"Open Cases – My Group(s) &  Unassigned displays Open and Pending cases for assignment group(s) that I belong to and the case is Unassigned=="
								+ totalWidgets,
						ExtentColor.GREEN));
				logSuccess("Expected Value - " + totalWidgets);
				logSuccess("Actual Value - " + beforeTotalOpenCasesMyGrpUnAssign);
			} else {
				test.get().log(Status.FAIL, MarkupHelper.createLabel(
						"Open Cases – My Group(s) &  Unassigned Not displays Open and Pending cases for assignment group(s) that I belong to and the case is Unassigned=="
								+ totalWidgets,
						ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				logFailure("Expected Value - " + totalWidgets);
				logFailure("Actual Value - " + beforeTotalOpenCasesMyGrpUnAssign);
			}
		} else {
			test.get().log(Status.INFO, MarkupHelper.createLabel(
					"No Records Found for Open Cases – My Group(s) &  Unassigned Open and Pending cases for assignment group(s) that I belong to and the case is Unassigned",
					ExtentColor.ORANGE));
		}

		driver.navigate().back();
		waitForFrameToBeAvailable(driver, "gsft_main");
		// beforeNearingBreachCasesMyGroup=totalNearingBreachCasesMyGroups.getText();
		beforeNearingBreachCasesMyGroup = "";
		String[] counter4 = totalNearingBreachCasesMyGroups.getText().split(",");
		for (int i = 0; i < counter4.length; i++) {
			beforeNearingBreachCasesMyGroup = beforeNearingBreachCasesMyGroup + counter4[i];
		}
		int totalNearingBrechMyGroupcnt = Integer.parseInt(beforeNearingBreachCasesMyGroup);
		if (totalNearingBrechMyGroupcnt >= 1) {
			waitForElementToBeClickable(driver, totalNearingBreachCasesMyGroups);
			executor.executeScript("arguments[0].click();", totalNearingBreachCasesMyGroups);
			waitForFrameToBeAvailable(driver, "gsft_main");
			totalWidgets = "";
			String[] counter3 = totalRows.getText().split(",");
			for (int i = 0; i < counter3.length; i++) {
				totalWidgets = totalWidgets + counter3[i];
			}
			if (beforeNearingBreachCasesMyGroup.equals(totalWidgets)) {
				test.get().log(Status.PASS, MarkupHelper.createLabel(
						" Nearing Beach Cases My Group(s) displays Open and Pending cases where the HR Case(s) are nearing breaching (SLA is 75% - 99 %) for assignment group(s)=="
								+ totalWidgets,
						ExtentColor.GREEN));
				logSuccess("Expected Value - " + totalWidgets);
				logSuccess("Actual Value - " + beforeNearingBreachCasesMyGroup);
			} else {
				test.get().log(Status.FAIL, MarkupHelper.createLabel(
						" Nearing Beach Cases My Group(s) Not displays Open and Pending cases where the HR Case(s) are nearing breaching (SLA is 75% - 99 %) for assignment group(s)=="
								+ totalWidgets,
						ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				logFailure("Expected Value - " + totalWidgets);
				logFailure("Actual Value - " + beforeNearingBreachCasesMyGroup);
			}
		} else {
			test.get().log(Status.INFO, MarkupHelper.createLabel(
					"No Records Found for  Nearing Beach Cases – My Group(s) displays Open and Pending cases where the HR Case(s) are nearing breaching (SLA is 75% - 99 %) for assignment group(s)",
					ExtentColor.ORANGE));
		}
	}

	/*
	 * decreasing the Hr Case Count By clicking the Open Cases Assigned to me case
	 * are Resolved and confirming the HR Cases are Decreases
	 */
	public void decreaseHRCaseCount(String user, String assignto, String hrServicedropdown, String descriptionText)
			throws Exception {
		waitForElementToBeClickable(driver, totalOpenCasesAssignedToMe);
		totalOpenCasesAssignedToMe.click();

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, newBtn);
		newBtn.click();

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, searchForRequester);
		searchForRequester.click();
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully clicking the Search for requester dropdown", ExtentColor.CYAN));
		// searching for the requester
		waitForElementToBeClickable(driver, enterSearchRequester);
		enterSearchRequester.sendKeys(user);
		checkForPageLoad(driver);

		if (user.contains("_")) {
			user = user.replace("_", " ");
		}

		WebElement requestor = driver.findElement(
				By.xpath("//ul[@class = 'select2-results']/li/descendant::div[contains(text(), '" + user + "')]"));
		waitForElementToBeClickable(driver, requestor);
		System.out.println("Requester Info - " + requestor.getText());
		requestor.click();

		waitForFrameToBeAvailable(driver, "gsft_main");
		if (caseCreation.isDisplayed()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Successdully Navigate to Case Creation Page", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		scrollToElement(driver, source);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, source);
		source.click();
		waitForElementToBeClickable(driver, sourceEnter);
		sourceEnter.sendKeys("Phone", Keys.ENTER);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully select the source dropdown value==Phone", ExtentColor.CYAN));

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully pass the alternate phone number", ExtentColor.CYAN));
		// selecting the hr service
		
		waitForFrameToBeAvailable(driver, "gsft_main");
		scrollToElement(driver, hrService);
		waitForElementToBeClickable(driver, hrService);
		hrService.click();
		waitForElementToBeClickable(driver, hrServiceDropdown);
		hrServiceDropdown.sendKeys(hrServicedropdown);
		waitForElementToBeClickable(driver, hrServiceOption);
		hrServiceOption.click();

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, description);
		description.sendKeys(descriptionText);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully pass the description text", ExtentColor.CYAN));
		waitForElementToBeClickable(driver, createCaseBt);
		createCaseBt.click();
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully clicking the create case button", ExtentColor.CYAN));

		checkForPageLoad(driver);
		String hrPageWindowHandle = driver.getWindowHandle();
		
		waitForFrameToBeAvailable(driver, "gsft_main");
		scrollToElement(driver, assignToSearch);
		waitForElementToBeClickable(driver, assignToSearch);
	
		if (isElementPresent(assignToSearch)) {
			assignToSearch.click();
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Assign To field is not displayed", ExtentColor.RED));
		}
		waitForExpectedNumberOfWindows(driver, 2);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> windowIterator = handles.iterator();
		// iterate through your windows
		while (windowIterator.hasNext()) {
			String windowName = windowIterator.next();
			if (!windowName.equals(hrPageWindowHandle)) {
				// driver.switchTo().window(windowName);
				System.out.println(windowName);
				driver.switchTo().window(windowName);
				driver.manage().window().maximize();

				Select dropdown = new Select(searchCriteria);
				dropdown.selectByVisibleText("Name");
				waitForElementToBeClickable(driver, searchTextBox);
				searchTextBox.clear();
				waitForAction(driver);
				searchTextBox.sendKeys(assignto);
				waitForAction(driver);
				searchTextBox.sendKeys(Keys.ENTER);
				waitForAction(driver);
				waitForElementToBeClickable(driver, nameSearchTextBox);
				if (nameSearchTextBox.isDisplayed()) {
					test.get().log(Status.PASS, MarkupHelper
							.createLabel("Entering the value for Assign to field is " + assignto, ExtentColor.GREEN));
					nameSearchTextBox.clear();
					waitForAction(driver);
					nameSearchTextBox.sendKeys(assignto);
					waitForAction(driver);
					nameSearchTextBox.sendKeys(Keys.ENTER);
					waitForAction(driver);
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					WebElement searchResult = driver.findElement(
							By.xpath("//*[contains(@class, 'glide_ref_item_link') and contains(@role, 'button')]"));
					searchResult.click();
				}
			}
		}
		driver.switchTo().window(hrPageWindowHandle);
		// driver.switchTo().defaultContent();
		// driver.switchTo().frame(0);
		waitForFrameToBeAvailable(driver, "gsft_main");
		String caseNumber = xpCaseNumber.getAttribute("value");
		System.out.println("casebefor::" + caseNumber);
		// saving the case
		// saveOption.click();
		test.get().log(Status.INFO, MarkupHelper.createLabel("Updating the HR case", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		scrollToElement(driver, updateButton);
		waitForElementToBeClickable(driver, updateButton);
		updateButton.click();
		waitForAction(driver);

		driver.switchTo().defaultContent();
		// navigating to the hr case dashboard
		waitForElementToBeClickable(driver, hrDashboard);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", hrDashboard);

		// driver.switchTo().frame("gsft_main");
		waitForFrameToBeAvailable(driver, "gsft_main");
		logInfo("Navigated to HR Dashboards");
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		beforeTotalOpencases = totalOpenCasesAssignedToMe.getText();
		int beforeTotalOpencasesCount = Integer.parseInt(beforeTotalOpencases);
		beforeTotalOpenCasesMygroups = "";
		String[] counter = totalOpenCasesMyGroups.getText().split(",");
		for (int i = 0; i < counter.length; i++) {
			beforeTotalOpenCasesMygroups = beforeTotalOpenCasesMygroups + counter[i];
		}
		int beforeTotalOpenCasesMygroupCount = Integer.parseInt(beforeTotalOpenCasesMygroups);
		System.out.println("before total mygroup count==" + beforeTotalOpenCasesMygroupCount);
		waitForElementToBeClickable(driver, totalOpenCasesAssignedToMe);
		totalOpenCasesAssignedToMe.click();

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, searchDropDown);
		logInfo("Searching for case number: " + caseNumber);
		Select select = new Select(searchDropDown);
		select.selectByVisibleText("Number");
		waitForElementToBeClickable(driver, xpSearch);
		xpSearch.click();
		waitForAction(driver);
		xpSearch.sendKeys(caseNumber.trim());
		waitForAction(driver);
		xpSearch.sendKeys(Keys.ENTER);
		checkForPageLoad(driver);
		// js.executeScript("arguments[0].textContent='" + caseNumber.trim() + "';",
		// xpSearch);
		// js.executeScript("arguments[0].textContent='" + Keys.ENTER + "';", xpSearch);
		// waitForElement(driver, xpCaseNum);
		waitForFrameToBeAvailable(driver, "gsft_main");
		logInfo("Click the HR Case Number " + caseNumber + " to resolving the case");
		WebElement caseToBeSearched = null;
		checkForPageLoad(driver);
		try {
			driver.findElement(By.xpath("(//a[text()='Number'])[1]")).click();
			waitForAction(driver);
			caseToBeSearched = driver.findElement(
					By.xpath("//a[@class = 'linked formlink' and contains(text(), '" + caseNumber + "')]"));
		} catch (Exception e) {
			driver.findElement(By.xpath("(//a[text()='Number'])[1]")).click();
			waitForAction(driver);
			caseToBeSearched = driver.findElement(
					By.xpath("//a[@class = 'linked formlink' and contains(text(), '" + caseNumber + "')]"));
		}

		waitForElementToBeClickable(driver, caseToBeSearched);
		caseToBeSearched.click();

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, xpState);
		Select state = new Select(xpState);
		waitForAction(driver);
		state.selectByVisibleText("Resolved");

		js.executeScript("arguments[0].scrollIntoView();", caseWorknotes);
		js.executeScript("arguments[0].textContent='" + "Case Resolved" + "';", caseWorknotes);
		System.out.println("Worknotes Entered as - " + "Case Resolved");
		// checkForPageLoad(driver);

		logInfo("Updating HR Case after changing state to Resolved");
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		// postBt.click();
		scrollToElement(driver, updateButton);
		waitForElementToBeClickable(driver, updateButton);
		updateButton.click();
		if (isElementPresent(caseWorknotes)) {
			waitForElementToBeClickable(driver, caseWorknotes);
			caseWorknotes.sendKeys("Case Resolved");
			js.executeScript("arguments[0].textContent='" + "Case Resolved" + "';", caseWorknotes);
			// checkForPageLoad(driver);
			scrollToElement(driver, updateButton);
			waitForElementToBeClickable(driver, updateButton);
			updateButton.click();
		}
		waitForAction(driver);

		// checkForPageLoad(driver);
		driver.switchTo().defaultContent();
		// navigating to the hr case dashboard
		waitForElementToBeClickable(driver, hrDashboard);
		js.executeScript("arguments[0].click();", hrDashboard);

		// driver.switchTo().frame("gsft_main");s
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, totalOpenCasesAssignedToMe);
		logInfoScreenshot(driver);
		afterTotalOpencases = Integer.parseInt(totalOpenCasesAssignedToMe.getText());
		String totalOpenCasesMyGroupTxt = "";
		waitForElement(driver, totalOpenCasesMyGroups);
		String[] counter3 = totalOpenCasesMyGroups.getText().split(",");
		for (int i = 0; i < counter3.length; i++) {
			totalOpenCasesMyGroupTxt = totalOpenCasesMyGroupTxt + counter3[i];
		}

		afterTotalOpenCasesMygroupCount = Integer.parseInt(totalOpenCasesMyGroupTxt);

		System.out.println("after total mygroup count==" + afterTotalOpenCasesMygroupCount);
		if (beforeTotalOpencasesCount > afterTotalOpencases) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Total Open Case decrease Accordingly and the count==" + afterTotalOpencases, ExtentColor.GREEN));
			logSuccess("Count Before Update - " + beforeTotalOpencasesCount);
			logSuccess("Count After Update - " + afterTotalOpencases);
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Total Open Case Not decrease Accordingly", ExtentColor.RED));
			logFailure("Count Before Update - " + beforeTotalOpencasesCount);
			logFailure("Count After Update - " + afterTotalOpencases);
			logFailureScreenshot(driver);
		}

		if (beforeTotalOpenCasesMygroupCount > afterTotalOpenCasesMygroupCount) {
			test.get().log(Status.PASS,
					MarkupHelper
							.createLabel("Total Open Cases Assigned To My Group decrease Accordingly and the count=="
									+ afterTotalOpenCasesMygroupCount, ExtentColor.GREEN));
			logSuccess("Count Before Update - " + beforeTotalOpenCasesMygroupCount);
			logSuccess("Count After Update - " + beforeTotalOpenCasesMygroupCount);

		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Total Open Cases Assigned To My Group Not decrease Accordingly", ExtentColor.RED));
			logFailure("Count Before Update - " + beforeTotalOpenCasesMygroupCount);
			logFailure("Count After Update - " + beforeTotalOpenCasesMygroupCount);
			logFailureScreenshot(driver);
		}

	}

	/*
	 * decrease the Unassigned Open case My Group By assigning to some One
	 */
	public void decreaseOpenCasesMyGroupsUnassign(String user, String assignto, String hrServicedropdown,
			String descriptionText) throws Exception {
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForAction(driver);
		scrollToElement(driver, totalCountOpenCasesMyGroupUnassigned);
		waitForElementToBeClickable(driver, totalCountOpenCasesMyGroupUnassigned);
		totalCountOpenCasesMyGroupUnassigned.click();
		// checkForPageLoad(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, newBtn);
		newBtn.click();
		// checkForPageLoad(driver);

		// searching for the requester
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, searchForRequester);
		searchForRequester.click();
		waitForAction(driver);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully clicking the Search for requester dropdown", ExtentColor.CYAN));
		waitForElementToBeClickable(driver, enterSearchRequester);
		enterSearchRequester.sendKeys(user);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, driver.findElement(By.xpath("//ul[@class = 'select2-results']/li")));

		// enterSearchRequester.sendKeys(user);
		if (user.contains("_")) {
			user = user.replace("_", " ");
		}

		checkForPageLoad(driver);
		WebElement requestor = driver.findElement(
				By.xpath("//ul[@class = 'select2-results']/li/descendant::div[contains(text(), '" + user + "')]"));
		waitForElementToBeClickable(driver, requestor);
		System.out.println("Requester Info - " + requestor.getText());
		requestor.click();

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, caseCreation);
		if (caseCreation.isDisplayed()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Successdully Navigate to Case Creation Page", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		scrollToElement(driver, source);
		waitForElementToBeClickable(driver, source);
		source.click();
		waitForElementToBeClickable(driver, sourceEnter);
		sourceEnter.sendKeys("Phone", Keys.ENTER);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully select the source dropdown value==Phone", ExtentColor.CYAN));
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully pass the alternate phone number", ExtentColor.CYAN));

		waitForElementToBeClickable(driver, hrService);
		hrService.click();
		waitForElementToBeClickable(driver, hrServiceDropdown);
		hrServiceDropdown.sendKeys(hrServicedropdown);
		waitForElementToBeClickable(driver, hrServiceOption);
		hrServiceOption.click();

		waitForElementToBeClickable(driver, description);
		description.sendKeys(descriptionText);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully pass the description text", ExtentColor.CYAN));
		createCaseBt.click();
		waitForAction(driver);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully clicking the create case button", ExtentColor.CYAN));

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, xpCaseNumber);
		waitForFrameToBeAvailable(driver, "gsft_main");
		String caseNumber = xpCaseNumber.getAttribute("value");

		// saving the case
		test.get().log(Status.INFO, MarkupHelper.createLabel("Updating the HR case", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		scrollToElement(driver, updateButton);
		waitForElementToBeClickable(driver, updateButton);
		updateButton.click();

		// navigating to the HR Case Dash board
		waitForAction(driver);
		driver.switchTo().defaultContent();
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.clear();
		leftSearch.sendKeys("HR CASE DASHBOARD");
		executor.executeScript("arguments[0].click();", hrDashboard);
		waitForFrameToBeAvailable(driver, "gsft_main");
		logInfoScreenshot(driver);

		beforeTotalOpenCasesMyGrpUnAssign = "";
		String[] counter = totalCountOpenCasesMyGroupUnassigned.getText().split(",");
		for (int i = 0; i < counter.length; i++) {
			beforeTotalOpenCasesMyGrpUnAssign = beforeTotalOpenCasesMyGrpUnAssign + counter[i];
		}
		int beforeOpenCasesMyGroupUnassignCount = Integer.parseInt(beforeTotalOpenCasesMyGrpUnAssign);
		waitForElementToBeClickable(driver, totalCountOpenCasesMyGroupUnassigned);
		totalCountOpenCasesMyGroupUnassigned.click();

		waitForFrameToBeAvailable(driver, "gsft_main");
		// driver.findElement(By.xpath("(//a[text()='Number'])[1]")).click();
		logInfoScreenshot(driver);

		Select select = new Select(searchDropDown);
		select.selectByVisibleText("Number");
		// searching for the case number
		waitForElementToBeClickable(driver, xpSearch);
		xpSearch.sendKeys(caseNumber.trim(), Keys.ENTER);
		waitForFrameToBeAvailable(driver, "gsft_main");

		logInfo("Click the HR Case Number " + xpCaseNum.getText() + " to Assign the case");
		driver.findElement(By.xpath("//a[@class = 'linked formlink' and contains(text(), '" + caseNumber + "')]"))
				.click();
		// xpCaseNum.click();
		waitForFrameToBeAvailable(driver, "gsft_main");
		String hrPageWindowHandle = driver.getWindowHandle();
		waitForElementToBeClickable(driver, assignToSearch);
		// Perform the click operation that opens new window
		if (isElementPresent(assignToSearch)) {
			assignToSearch.click();
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
				// driver.switchTo().window(windowName);
				System.out.println(windowName);
				driver.switchTo().window(windowName);
				driver.manage().window().maximize();

				Select dropdown = new Select(searchCriteria);
				dropdown.selectByVisibleText("Name");
				waitForElementToBeClickable(driver, searchTextBox);
				searchTextBox.clear();
				waitForAction(driver);
				searchTextBox.sendKeys(assignto);
				waitForAction(driver);
				searchTextBox.sendKeys(Keys.ENTER);
				waitForAction(driver);
				// checkForPageLoad(driver);
				if (nameSearchTextBox.isDisplayed()) {
					test.get().log(Status.PASS, MarkupHelper
							.createLabel("Entering the value for Assign to field is " + assignto, ExtentColor.GREEN));
					waitForElementToBeClickable(driver, nameSearchTextBox);
					nameSearchTextBox.clear();
					waitForAction(driver);
					nameSearchTextBox.sendKeys(assignto);
					waitForAction(driver);
					nameSearchTextBox.sendKeys(Keys.ENTER);
					waitForAction(driver);
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					WebElement searchResult = driver.findElement(
							By.xpath("//*[contains(@class, 'glide_ref_item_link') and contains(@role, 'button')]"));
					searchResult.click();
				}
			}
		}

		driver.switchTo().window(hrPageWindowHandle);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, header);
		test.get().log(Status.INFO, MarkupHelper.createLabel("Updating the HR case", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		scrollToElement(driver, updateButton);
		waitForElementToBeClickable(driver, updateButton);
		updateButton.click();

		waitForAction(driver);
		driver.switchTo().defaultContent();
		waitForElementToBeClickable(driver, hrDashboard);
		executor.executeScript("arguments[0].click();", hrDashboard);
		waitForFrameToBeAvailable(driver, "gsft_main");
		logInfoScreenshot(driver);
		String totalOpencasesMyGRPUnassigned = "";
		String[] count6 = totalCountOpenCasesMyGroupUnassigned.getText().split(",");
		for (int i = 0; i < count6.length; i++) {
			totalOpencasesMyGRPUnassigned = totalOpencasesMyGRPUnassigned + count6[i];
		}

		int afterOpenCasesMyGroupUnassignCount = Integer.parseInt(totalOpencasesMyGRPUnassigned);
		if (beforeOpenCasesMyGroupUnassignCount > afterOpenCasesMyGroupUnassignCount) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"Open Cases - My Group(s) & Unassigned widget number decreases accoridngly and the count=="
									+ afterOpenCasesMyGroupUnassignCount,
							ExtentColor.GREEN));

		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Open Cases - My Group(s) & Unassigned widget number Not decreases accoridngly", ExtentColor.RED));
			logFailureScreenshot(driver);
		}
	}

	/*
	 * click on the High Priority cases and click on the new Button&search for the
	 * Requester
	 */
	public void createNewCase(String user) throws InterruptedException {
		afterTotalOpencases = Integer.parseInt(totalOpenCasesAssignedToMe.getText());
		beforeHighPriorityCasesAssme = totalHighPriorityCasesAssignedToMe.getText();
		beforeHighPriorityCasesMyGroups = totalHighPrioritycasesMyGroups.getText();
		String beforeTotalOpenCaseMyGrpCount = totalOpenCasesMyGroups.getText().replaceAll(",", "");
		afterTotalOpenCasesMygroupCount = Integer.parseInt(beforeTotalOpenCaseMyGrpCount);
		waitForElementToBeClickable(driver, totalHighPriorityCasesAssignedToMe);
		totalHighPriorityCasesAssignedToMe.click();

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, newBtn);
		newBtn.click();

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, searchForRequester);
		searchForRequester.click();
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully clicking the Search for requester dropdown", ExtentColor.CYAN));
		waitForElementToBeClickable(driver, enterSearchRequester);
		checkForPageLoad(driver);
		enterSearchRequester.sendKeys(user);
		checkForPageLoad(driver);

		if (user.contains("_")) {
			user = user.replace("_", " ");
		}

		WebElement requestor = driver.findElement(
				By.xpath("//ul[@class = 'select2-results']/li/descendant::div[contains(text(), '" + user + "')]"));
		waitForElementToBeClickable(driver, requestor);
		System.out.println("Requester Info - " + requestor.getText());
		requestor.click();

	}
	/*
	 * Validating the HighPriority Cases By adding New Case As High Priority and
	 * confirming the HR Cases are increased
	 */

	public void increaseCasesCount() throws Exception {
		driver.switchTo().defaultContent();
		String userLogged = LoggedUser.getText().trim();

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, assignToSearch);
		scrollToElement(driver, assignToSearch);
		checkForPageLoad(driver);
		String hrPageWindowHandle = driver.getWindowHandle();
		if (assignToSearch.isDisplayed()) {
			waitForElementToBeClickable(driver, assignToSearch);
			assignToSearch.click();
			// new Actions(driver).click(assignToSearch).build().perform();
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Assign To field is not displayed", ExtentColor.RED));
		}

		// Switch to new window opened
		waitForExpectedNumberOfWindows(driver, 2);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> windowIterator = handles.iterator();
		// iterate through your windows
		while (windowIterator.hasNext()) {
			String windowName = windowIterator.next();
			if (!windowName.equals(hrPageWindowHandle)) {
				// driver.switchTo().window(windowName);
				System.out.println(windowName);
				driver.switchTo().window(windowName);
				driver.manage().window().maximize();
				waitForElementToBeClickable(driver, searchCriteria);
				Select dropdown = new Select(searchCriteria);
				dropdown.selectByVisibleText("Name");
				waitForElementToBeClickable(driver, searchTextBox);
				searchTextBox.clear();
				waitForAction(driver);
				searchTextBox.sendKeys(userLogged);
				waitForAction(driver);
				searchTextBox.sendKeys(Keys.ENTER);
				waitForAction(driver);
				waitForElementToBeClickable(driver, nameSearchTextBox);
				if (nameSearchTextBox.isDisplayed()) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel(
									"Entering the value for Assign to field is same as logged in user - " + userLogged,
									ExtentColor.GREEN));
					waitForAction(driver);
					nameSearchTextBox.clear();
					waitForAction(driver);
					nameSearchTextBox.sendKeys(userLogged);
					waitForAction(driver);
					nameSearchTextBox.sendKeys(Keys.ENTER);
					checkForPageLoad(driver);
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					WebElement searchResult = driver.findElement(
							By.xpath("//*[contains(@class, 'glide_ref_item_link') and contains(@role, 'button')]"));
					searchResult.click();
				}
			}
		}

		driver.switchTo().window(hrPageWindowHandle);
		waitForFrameToBeAvailable(driver, "gsft_main");
		Select selectstate = new Select(casePriority);
		selectstate.selectByVisibleText("1 - High");
		test.get().log(Status.PASS,
				MarkupHelper.createLabel("Successfully selecting Case As High priority", ExtentColor.GREEN));
		// checkForPageLoad(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// saving the case
		test.get().log(Status.INFO, MarkupHelper.createLabel("Updating the HR case", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		scrollToElement(driver, updateButton);
		waitForElementToBeClickable(driver, updateButton);
		updateButton.click();
		// checkForPageLoad(driver);
		/*
		 * if (isElementPresent(caseWorknotes)) {
		 * caseWorknotes.sendKeys("Case Resolved");
		 * js.executeScript("arguments[0].textContent='" + "Case Resolved" + "';",
		 * caseWorknotes); // checkForPageLoad(driver); scrollToElement(driver,
		 * updateButton); waitForElementToBeClickable(driver, updateButton);
		 * updateButton.click(); }
		 */

		driver.switchTo().defaultContent();
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.clear();
		leftSearch.sendKeys("HR CASE DASHBOARD");
		waitForElementToBeClickable(driver, hrDashboard);
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", hrDashboard);
		waitForFrameToBeAvailable(driver, "gsft_main");
		// checkForPageLoad(driver);

		waitForElementToBeClickable(driver, totalOpenCasesAssignedToMe);
		int afterCreatedNewOpenCaseAssignMe = Integer.parseInt(totalOpenCasesAssignedToMe.getText());
		if (afterCreatedNewOpenCaseAssignMe > Integer.parseInt(beforeTotalOpencases)) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"after created new case with high priority total open cases assigned to me increased and count=="
							+ afterCreatedNewOpenCaseAssignMe,
					ExtentColor.GREEN));
			logSuccess("Count Before Update - " + afterTotalOpencases);
			logSuccess("Count After Update - " + afterCreatedNewOpenCaseAssignMe);
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"after created new case with high priority total open cases assigned to me Not increased",
							ExtentColor.RED));
			logFailure("Count Before Update - " + afterTotalOpencases);
			logFailure("Count After Update - " + afterCreatedNewOpenCaseAssignMe);
			logFailureScreenshot(driver);
		}

		String totalOpenCasesmygroupsCount = "";
		String[] counter = totalOpenCasesMyGroups.getText().split(",");
		for (int i = 0; i < counter.length; i++) {
			totalOpenCasesmygroupsCount = totalOpenCasesmygroupsCount + counter[i];
		}

		int afterCreatedNewOpenCasesMyGroup = Integer.parseInt(totalOpenCasesmygroupsCount);
		if (afterCreatedNewOpenCasesMyGroup > afterTotalOpenCasesMygroupCount) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"after created new case with high priority total open cases assigned to My Group increased and count=="
							+ afterCreatedNewOpenCasesMyGroup,
					ExtentColor.GREEN));
			logSuccess("Count Before Update - " + afterTotalOpenCasesMygroupCount);
			logSuccess("Count After Update - " + afterCreatedNewOpenCasesMyGroup);
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"after created new case with high priority total open cases assigned to My Group Not increased",
					ExtentColor.RED));
			logFailure("Count Before Update - " + afterTotalOpenCasesMygroupCount);
			logFailure("Count After Update - " + afterCreatedNewOpenCasesMyGroup);
			logFailureScreenshot(driver);
		}

		waitForElement(driver, totalHighPriorityCasesAssignedToMe);
		int afterCreatedNewHighPriorityAssignMe = Integer.parseInt(totalHighPriorityCasesAssignedToMe.getText());
		int beforeHighPriority = Integer.parseInt(beforeHighPriorityCasesAssme);
		if (afterCreatedNewHighPriorityAssignMe > beforeHighPriority) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"after created new case with high priority,High priority cases assigned to me increased and count=="
							+ afterCreatedNewHighPriorityAssignMe,
					ExtentColor.GREEN));
			logSuccess("Count Before Update - " + beforeHighPriority);
			logSuccess("Count After Update - " + afterCreatedNewHighPriorityAssignMe);
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"after created new case with high priority,High priority cases assigned to me Not increased",
					ExtentColor.RED));
			logFailure("Count Before Update - " + beforeHighPriority);
			logFailure("Count After Update - " + afterCreatedNewHighPriorityAssignMe);
			logFailureScreenshot(driver);
		}

		waitForElement(driver, totalHighPrioritycasesMyGroups);
		int afterCreatedNewHighPriorityMyGroup = Integer.parseInt(totalHighPrioritycasesMyGroups.getText());
		int beforeHighPriorityMygroup = Integer.parseInt(beforeHighPriorityCasesMyGroups);
		if (afterCreatedNewHighPriorityMyGroup > beforeHighPriorityMygroup) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"after created new case with high priority,High priority cases assigned to My Group increased and count=="
							+ afterCreatedNewHighPriorityMyGroup,
					ExtentColor.GREEN));
			logSuccess("Count Before Update - " + beforeHighPriorityMygroup);
			logSuccess("Count After Update - " + afterCreatedNewHighPriorityMyGroup);
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"after created new case with high priority,High priority cases assigned to My Group Not increased",
					ExtentColor.RED));
			logFailure("Count Before Update - " + beforeHighPriorityMygroup);
			logFailure("Count After Update - " + afterCreatedNewHighPriorityMyGroup);
			logFailureScreenshot(driver);
		}
	}
	/*
	 * This method validates the adding the new column header and removing the
	 * filter
	 */

	public void verifyDefaultListView(String addColumn) throws Exception {
		String filterText;
		String removeFilterText;
		JavascriptExecutor js;
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, totalOpenCasesAssignedToMe);
		totalOpenCasesAssignedToMe.click();

		// checkForPageLoad(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, hrCases);
		if (hrCases.isDisplayed()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Navigating to HR Cases List View Page", ExtentColor.CYAN));
		} else {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Navigation failed to HR Cases List View Page", ExtentColor.CYAN));
		}

		if (isElementPresent(updatedGearIcon)) {
			waitForElementToBeClickable(driver, updatedGearIcon);
			updatedGearIcon.click();
			// checkForPageLoad(driver);
			waitForElementToBeClickable(driver, resetColumns);
			resetColumns.click();
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Clicking the Reset Column Default View Btn", ExtentColor.CYAN));
			// checkForPageLoad(driver);
		}

		waitForElementToBeClickable(driver, gearIcon);
		gearIcon.click();
		test.get().log(Status.PASS, MarkupHelper.createLabel("click on the gear icon", ExtentColor.GREEN));

		// checkForPageLoad(driver);

		for (WebElement element : slushLeft) {
			if (element.getText().equals(addColumn)) {
				logSuccess("Expected Value - " + addColumn);
				logSuccess("Actual Value - " + element.getText());
				waitForElementToBeClickable(driver, element);
				element.click();
				test.get().log(Status.INFO,
						MarkupHelper.createLabel("Selecting the Column name==" + addColumn, ExtentColor.CYAN));
				break;
			}
		}
		waitForElementToBeClickable(driver, addArrow);
		addArrow.click();
		waitForAction(driver);
		List<String> columnString = new ArrayList<String>();
		for (WebElement webelement : slushRight) {
			columnString.add(webelement.getText());
		}

		waitForElementToBeClickable(driver, okBtn);
		okBtn.click();
		waitForAction(driver);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Updated Column List view is shown in below screenshot -", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		for (int i = 0; i < columnString.size(); i++) {
			waitForAction(driver);
			String columnName = driver
					.findElement(By.xpath("(//*[@id='hdr_sn_hr_core_case']/th[" + (3 + i) + "]/span/a)[1]")).getText()
					.split("\\r?\\n")[0];

			if (tempbrowser.equalsIgnoreCase("IE") || tempbrowser.equalsIgnoreCase("safari")) {
				columnName = columnName.split("Sort")[0];
			}
			if (columnString.get(i).contains(columnName)) {
				test.get().log(Status.PASS, MarkupHelper
						.createLabel("Column Header is updated as expected==" + columnName, ExtentColor.GREEN));
				logSuccess("Expected Value - " + columnName);
				logSuccess("Actual Value - " + columnString.get(i));
				System.out.println("Column Header is Matched matched for - " + columnName);
			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("Column Header is not updated as expected", ExtentColor.RED));
				logFailure("Expected Value - " + columnName);
				logFailure("Actual Value - " + columnString.get(i));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("Column Header is not updated as expected - " + columnName);
			}
		}

		waitForElementToBeClickable(driver, updatedGearIcon);
		updatedGearIcon.click();
		waitForElementToBeClickable(driver, resetColumns);
		// checkForPageLoad(driver);
		try {
			resetColumns.click();
		} catch (Exception e) {
			test.get().log(Status.INFO, MarkupHelper.createLabel("Reset Button was not available", ExtentColor.AMBER));
			logInfoScreenshot(driver);
			// TODO: handle exception
		}

		test.get().log(Status.PASS,
				MarkupHelper.createLabel("Clicking the Reset Column Default View Btn", ExtentColor.GREEN));
		// checkForPageLoad(driver);
		filterText = openORPendingCases.getText();

		scrollToElement(driver, newBtn);
		scrollPageUp(driver);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, allFilter);
		allFilter.click();

		waitForFrameToBeAvailable(driver, "gsft_main");
		removeFilterText = openORPendingCases.getText();
		if (!filterText.equals(removeFilterText)) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("successfully remove the filter and displaying all cases", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("successfully remove the filter and displaying all cases");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("filter not removed after clicking the all cases", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("filter not removed after clicking the all cases");
		}

		driver.switchTo().defaultContent();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", hrDashboard);
		// checkForPageLoad(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, totalOpenCasesAssignedToMe);
		totalOpenCasesAssignedToMe.click();
		// checkForPageLoad(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, openORPendingCases);
		if (filterText.equals(openORPendingCases.getText())) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Remove Filter Not Saving after reopen", ExtentColor.GREEN));

			logSuccess("Expected Value - " + openORPendingCases.getText());
			logSuccess("Actual Value - " + filterText);

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Remove Filter Not Saving after reopen");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Remove Filter is Saving after reopen", ExtentColor.RED));

			logFailure("Expected Value - " + openORPendingCases.getText());
			logFailure("Actual Value - " + filterText);

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Remove Filter is Saving after reopen");

		}
	}
}
