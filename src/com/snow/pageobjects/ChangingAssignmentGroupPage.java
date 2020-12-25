package com.snow.pageobjects;

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

public class ChangingAssignmentGroupPage extends ReusableLibrary {
	public WebDriver driver;

	public ChangingAssignmentGroupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='filter']")
	public WebElement leftSearch;

	@FindBy(xpath = "//div[text()='HRIT Cases']")
	public WebElement hritcase_text;

	@FindBy(xpath = "//div[contains(text(),'Create New Case')]")
	public WebElement createnewcase_text;

	@FindBy(xpath = "//iframe[@id='gsft_main']")
	public WebElement frame;

	@FindBy(xpath = "//td[contains(text(),'No records to display')]")
	public WebElement hometitle;

	@FindBy(xpath = "//div[@class='input-group']/input")
	public WebElement search_field;

	@FindBy(xpath = "//button[@id='lookup.sn_hr_core_case_operations.assignment_group']")
	public WebElement assignment_group_link;

	@FindBy(xpath = "//input[@id='sys_display.sn_hr_core_case_operations.assignment_group']")
	public WebElement assignment_group_field;

	@FindBy(xpath = "//button[@id='sysverb_update']")
	public WebElement update_button;

	@FindBy(xpath = "//a[@class='linked formlink']")
	public WebElement hrcase;

	@FindBy(xpath = "//a[contains(text(),'HRSM - Leave of Absence')]")
	public WebElement leave_of_absense;

	@FindBy(xpath = "//*[contains(@id, 'row_sn_hr_core_case_operations_')]")
	public WebElement case_information;
	@FindBy(xpath = "//*[text()='No records to display']")
	public WebElement noRecords;

	@FindBy(xpath = "//div[@id='s2id_search_input']/a")
	public WebElement search_dropdown;

	@FindBy(xpath = "//input[@id='s2id_autogen1_search']")
	public WebElement search_bar;

	@FindBy(xpath = "//ul[@id='select2-results-7']")
	public WebElement search_bar_text;

	@FindBy(xpath = "//div[@id='s2id_ev_field_contact_type']/a")
	public WebElement source_dropdown;

	@FindBy(xpath = "//input[@id='s2id_autogen7_search']")
	public WebElement source_searchbar;

	@FindBy(xpath = "//div[@id='s2id_coe_input']/a")
	public WebElement coe_dropdown;

	@FindBy(xpath = "//input[@id='s2id_autogen3_search']")
	public WebElement coe_searchbar;

	@FindBy(xpath = "//div[@id='s2id_service_input']/a")
	public WebElement hrservice_dropdown;

	@FindBy(xpath = "//input[@id='s2id_autogen2_search']")
	public WebElement hrservice_searchbar;

	@FindBy(xpath = "//textarea[@id='ev_field_description']")
	public WebElement description_field;

	@FindBy(xpath = "(//button[@class='btn btn-primary'][@ng-click='createCase()'])[2]")
	public WebElement button;

	@FindBy(xpath = "(//button[text()='Create Case'])[1]")
	public WebElement create_case;

	@FindBy(id = "sys_readonly.sn_hr_core_case_operations.number")
	public WebElement hrcase_number;

	@FindBy(xpath = "//select[@class='form-control default-focus-outline']")
	public WebElement search_dropDown;

	@FindBy(xpath = "//a[text() = 'Open Record']")
	public WebElement openRecord;

	@FindBy(xpath = "//a[@class='btn btn-icon table-btn-lg icon-info list_popup']")
	public WebElement Iicon;

	@FindBy(xpath = "//a[contains(text(),'HRSM - Leave of Absence')]")
	public WebElement leaveOfAbsence;
	@FindBy(xpath = "//a[contains(text(),'HRSM - Workforce Analytics')]")
	public WebElement WorkforceAnalytics;

	@FindBy(xpath = "//button[@id='lookup.sn_hr_core_case_operations.hr_system']")
	public WebElement hrsystem_link;

	@FindBy(xpath = "//a[contains(text(),'Concur')]")
	public WebElement concur_link;

	@FindBy(xpath = "//span[@class='user-name hidden-xs hidden-sm hidden-md']")
	public WebElement specified_user;
	@FindBy(xpath = "//*[@id='user_info_dropdown']/div/span[4]")
	public WebElement userMenu;

	@FindBy(xpath = "//div[contains(@id,'approver.form_header')]")
	public WebElement xpHeader;

	@FindBy(xpath = "//*[contains(@id,'list_nav_sysapproval_approver')]")
	public WebElement xpHeader2;

	@FindBy(xpath = "//*[contains(@role,'presentation')]/a[text()='Impersonate User']")
	public WebElement impUser;

	@FindBy(xpath = "//*[@id='select2-chosen-2']")
	public WebElement impUserDropDwn;

	@FindBy(xpath = "//*[@id='s2id_autogen2_search']")
	public WebElement impUserSendkys;

	// String casenumber;

	public void navigateToHRDashboard() throws Exception {
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.sendKeys("HRIT Cases");
		checkForPageLoad(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", hritcase_text);
		checkForPageLoad(driver);
		String specifieduser = specified_user.getText();
		driver.switchTo().frame(0);
		// Thread.sleep(200000);
		waitForElement(driver, hometitle);
		if (isElementPresent(hometitle)) {
			if (hometitle.getText().equalsIgnoreCase("No records to display")) {
				test.get().log(Status.PASS, MarkupHelper
						.createLabel(specifieduser + "  is unable to see   HRIT Operations cases", ExtentColor.GREEN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} else {
				test.get().log(Status.FAIL, MarkupHelper
						.createLabel(specifieduser + "  is able to see   HRIT Operations cases", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}
		}
	}

	public void navigateToHRDashboard1() throws Exception {
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.sendKeys("Create New Case");
		waitForElementToBeClickable(driver, createnewcase_text);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", createnewcase_text);
		waitForAction(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
	}

	public void validate_createcasepage(String str) throws Exception {
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, search_dropdown);
		search_dropdown.click();
		waitForElementToBeClickable(driver, search_bar);
		search_bar.sendKeys(str);

		waitForElementToBeClickable(driver, driver.findElement(By.xpath("//ul[@class = 'select2-results']/li")));

		if (str.contains("_")) {
			str = str.replace("_", " ");
		}

		checkForPageLoad(driver);
		waitForElement(driver, driver.findElement(
				By.xpath("//ul[@class = 'select2-results']/li/descendant::div[contains(text(), '" + str + "')]")));
		WebElement requestor = driver.findElement(
				By.xpath("//ul[@class = 'select2-results']/li/descendant::div[contains(text(), '" + str + "')]"));
		waitForElementToBeClickable(driver, requestor);

		System.out.println("Requester Info - " + requestor.getText());
		// requestor.click();
		new Actions(driver).click(requestor).build().perform();

		waitForFrameToBeAvailable(driver, "gsft_main");
		if (create_case.getText().contains("Create Case")) {
			test.get().log(Status.INFO, MarkupHelper.createLabel("case creation page was displayed", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("case creation page was not displayed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	public String casecreation(String source, String coe, String hrservice, String Description) throws Exception {
		scrollToElement(driver, source_dropdown);
		waitForElementToBeClickable(driver, source_dropdown);
		source_dropdown.click();
		waitForElementToBeClickable(driver, source_searchbar);
		source_searchbar.sendKeys(source);
		waitForAction(driver);
		source_searchbar.sendKeys(Keys.TAB);

		waitForElementToBeClickable(driver, coe_dropdown);
		coe_dropdown.click();
		waitForElementToBeClickable(driver, coe_searchbar);
		coe_searchbar.sendKeys(coe);
		waitForAction(driver);
		coe_searchbar.sendKeys(Keys.TAB);

		waitForElementToBeClickable(driver, hrservice_dropdown);
		hrservice_dropdown.click();
		waitForElementToBeClickable(driver, hrservice_searchbar);
		hrservice_searchbar.sendKeys(hrservice);
		waitForAction(driver);
		hrservice_searchbar.sendKeys(Keys.TAB);

		waitForElementToBeClickable(driver, description_field);
		description_field.sendKeys(Description);

		test.get().log(Status.INFO, MarkupHelper.createLabel("case details are filled", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		waitForElementToBeClickable(driver, button);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", button);
		waitForAction(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, hrcase_number);
		String casenumber = hrcase_number.getAttribute("value");
		System.out.println("case number=" + casenumber);
		/*
		 * assignment_group_link.click(); Thread.sleep(2000); String hrPageWindowHandle
		 * = driver.getWindowHandle(); Set<String> handles = driver.getWindowHandles();
		 * Iterator<String> windowIterator = handles.iterator(); while
		 * (windowIterator.hasNext()) { String windowName = windowIterator.next(); if
		 * (!windowName.equals(hrPageWindowHandle)) {
		 * driver.switchTo().window(windowName); System.out.println(windowName);
		 * driver.manage().window().maximize(); Thread.sleep(1000);
		 * leave_of_absense.click();
		 * 
		 * } } driver.switchTo().window(hrPageWindowHandle); driver.switchTo().frame(0);
		 */
		waitForElementToBeClickable(driver, hrsystem_link);
		hrsystem_link.click();
		waitForAction(driver);

		String hrPageWindowHandle1 = driver.getWindowHandle();
		Set<String> handles1 = driver.getWindowHandles();
		Iterator<String> windowIterator1 = handles1.iterator();
		while (windowIterator1.hasNext()) {
			String windowName = windowIterator1.next();
			if (!windowName.equals(hrPageWindowHandle1)) {
				driver.switchTo().window(windowName);
				System.out.println(windowName);
				driver.manage().window().maximize();
				waitForAction(driver);
				try {
					concur_link.click();
				} catch (Exception e) {

				}
			}
		}
		driver.switchTo().window(hrPageWindowHandle1);
		waitForFrameToBeAvailable(driver, "gsft_main");

		/*
		 * if (assignment_group_field.getAttribute("value").
		 * contains("HRSM - Leave of Absence")) { test.get().log(Status.PASS,
		 * MarkupHelper.
		 * createLabel("**Assignment Group Changed and text on the assignment group is**:   "
		 * + assignment_group_field.getAttribute("value"), ExtentColor.GREEN));
		 * screenshotPath = getScreenshot(driver, this.getClass().getName());
		 * test.get().info("Details",
		 * MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); }
		 * else { test.get().log(Status.FAIL,
		 * MarkupHelper.createLabel("Assignment Group not Changed", ExtentColor.RED));
		 * screenshotPath = getScreenshot(driver, this.getClass().getName());
		 * test.get().fail("Details",
		 * MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); }
		 */

		waitForElementToBeClickable(driver, update_button);
		update_button.click();
		waitForAction(driver);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("HRIT operations case is updated sucessfully", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		return casenumber;

	}

	public void navigateToHRDashboard2(String casenumber) throws Exception {
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.sendKeys("HRIT Cases");
		waitForElementToBeClickable(driver, hritcase_text);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", hritcase_text);
		waitForAction(driver);

		waitForElement(driver, specified_user);
		String specifieduser = specified_user.getText();
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, search_dropDown);
		Select select = new Select(search_dropDown);
		select.selectByVisibleText("Number");
		System.out.println(casenumber);
		waitForElementToBeClickable(driver, search_field);
		search_field.sendKeys(casenumber);
		search_field.sendKeys(Keys.ENTER);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForAction(driver);
		waitForElement(driver, noRecords);
		if (isElementPresent(noRecords)) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel(specifieduser + "  is unable to see   HRIT Operations cases", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel(specifieduser + "  is able to see   HRIT Operations cases", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	public void updating_assignmentgroup(String casenumber) throws Exception {
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.sendKeys("HRIT Cases");
		waitForElementToBeClickable(driver, hritcase_text);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", hritcase_text);
		waitForAction(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, search_dropDown);
		Select select = new Select(search_dropDown);
		select.selectByVisibleText("Number");
		waitForElementToBeClickable(driver, search_field);
		search_field.sendKeys(casenumber);
		search_field.sendKeys(Keys.ENTER);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, Iicon);
		Iicon.click();
		waitForElement(driver, openRecord);
		openRecord.click();
		waitForAction(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		js.executeScript("arguments[0].click();", assignment_group_link);
		waitForAction(driver);

		String hrPageWindowHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> windowIterator = handles.iterator();
		while (windowIterator.hasNext()) {
			String windowName = windowIterator.next();
			if (!windowName.equals(hrPageWindowHandle)) {
				driver.switchTo().window(windowName);
				System.out.println(windowName);
				driver.manage().window().maximize();
				waitForAction(driver);
				try {
					leaveOfAbsence.click();
				} catch (Exception e) {

				}
			}
		}
		driver.switchTo().window(hrPageWindowHandle);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, update_button);
		update_button.click();
		logSuccess("successfully the changed the Assignment group leave of absence");
	}

	public void navigateToHRDashboard4(String casenumber) throws Exception {
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.sendKeys("HRIT Cases");
		waitForElementToBeClickable(driver, hritcase_text);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", hritcase_text);

		waitForElementToBeClickable(driver, specified_user);
		String specifieduser = specified_user.getText();

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, search_dropDown);
		Select select = new Select(search_dropDown);
		select.selectByVisibleText("Number");
		System.out.println(casenumber);
		waitForElementToBeClickable(driver, search_field);
		search_field.sendKeys(casenumber);
		search_field.sendKeys(Keys.ENTER);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, Iicon);
		if (isElementPresent(Iicon)) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							specifieduser
									+ "  is able to see   HRIT Operations cases after changing the Assignment Group",
							ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							specifieduser
									+ "  is unable to see   HRIT Operations cases after changing the Assignment Group",
							ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	public void updating_assignmentgroup_to_default(String casenumber) throws Exception {
		driver.switchTo().defaultContent();
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.sendKeys("HRIT Cases");
		waitForElementToBeClickable(driver, hritcase_text);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", hritcase_text);

		// driver.switchTo().frame(0);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, search_dropDown);
		Select select = new Select(search_dropDown);
		select.selectByVisibleText("Number");
		waitForElementToBeClickable(driver, search_field);
		search_field.sendKeys(casenumber);
		search_field.sendKeys(Keys.ENTER);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, Iicon);
		Iicon.click();

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, openRecord);
		openRecord.click();

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, assignment_group_link);
		assignment_group_link.click();
		waitForAction(driver);

		String hrPageWindowHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> windowIterator = handles.iterator();
		while (windowIterator.hasNext()) {
			String windowName = windowIterator.next();
			if (!windowName.equals(hrPageWindowHandle)) {
				driver.switchTo().window(windowName);
				System.out.println(windowName);
				driver.manage().window().maximize();
				waitForAction(driver);
				try {
					WorkforceAnalytics.click();
				} catch (Exception e) {

				}
			}
		}
		driver.switchTo().window(hrPageWindowHandle);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, update_button);
		update_button.click();
		logSuccess("successfully updated the Assignment group to default");
	}

}