package com.snow.pageobjects;

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

public class HRSM_OpenedByRequestedByAboutPage extends ReusableLibrary {
	public WebDriver driver;

	public HRSM_OpenedByRequestedByAboutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='filter']")
	public WebElement leftSearch;

	@FindBy(xpath = "//div[text()='Create New Case']")
	public WebElement hrDashboard;

	@FindBy(xpath = "//div[text()='Open']")
	public WebElement hrDashboard1;

	@FindBy(xpath = "//iframe[@id='gsft_main']")
	public WebElement frame;

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

	@FindBy(id = "sys_readonly.sn_hr_core_hr_employee_services.number")
	public WebElement hrcase_number;

	@FindBy(id = "sys_readonly.sn_hr_core_case_payroll.number")
	public WebElement hrcase_number1;

	@FindBy(xpath = "//input[contains(@id, 'opened_by_label')]")
	public WebElement hrcase_openedby;

	@FindBy(xpath = "//input[@id='sn_hr_core_case_payroll.opened_by_label']")
	public WebElement hrcase_openedby1;

	@FindBy(xpath = "//span[@class='user-name hidden-xs hidden-sm hidden-md']")
	public WebElement specified_user;

	@FindBy(xpath = "//table[@id='sn_hr_core_case_table']//input[@id='sn_hr_core_case_table_header_search_control']")
	public WebElement number_field;

	@FindBy(xpath = "//a[@class='linked formlink']")
	public WebElement number;

	@FindBy(xpath = "//button[@id='lookup.sn_hr_core_hr_employee_services.opened_for']")
	public WebElement requestedby_button;

	@FindBy(xpath = "//button[@id='lookup.sn_hr_core_case_payroll.opened_for']")
	public WebElement requestedby_button1;

	@FindBy(xpath = "//button[@id='sysverb_update']")
	public WebElement update_button;

	@FindBy(xpath = "//input[@class='form-control'][@placeholder='Search']")
	public WebElement search_field;

	@FindBy(xpath = "(//*[@id='sys_user_table_header_search_control'])[1]")
	public WebElement search_name;

	@FindBy(xpath = "//*[@data-type = 'section_head' and @role =  'navigation']")
	public List<WebElement> header;

	@FindBy(xpath = "//*[@class = 'context_menu']/div[contains(text(), 'Save')]")
	public WebElement saveButton;

	@FindBy(xpath = "//select[@class='form-control default-focus-outline']")
	public WebElement search_dropDown;

	@FindBy(xpath = "//input[@id='sys_display.sn_hr_core_hr_employee_services.opened_for']")
	public WebElement requested_by;

	@FindBy(xpath = "//input[@id='sys_display.sn_hr_core_case_payroll.opened_for']")
	public WebElement requested_by1;

	@FindBy(xpath = "//td[contains(text(),'No records to display')]")
	public WebElement error_message;

	@FindBy(xpath = "//input[@id='sys_display.sn_hr_core_case_payroll.subject_person']")
	public WebElement about_by;

	@FindBy(xpath = "//input[@class='form-control'][@placeholder='Search']")
	public WebElement search_dropdown_field;

	@FindBy(xpath = "(//input[@id='sn_hr_core_case_table_header_search_control'])[1]")
	public WebElement searchBox;

	@FindBy(xpath = "//a[text() = 'Open Record']")
	public WebElement openRecord;

	@FindBy(xpath = "//a[@class='btn btn-icon table-btn-lg icon-info list_popup']")
	public WebElement Iicon;

	@FindBy(xpath = "(//tr[@id='hdr_sn_hr_core_case'])[1]/th[2]")
	public WebElement searchIcon;

	// String casenumber;
	// String casenumber1;

	public void navigateToHRDashboard() throws Exception {
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.sendKeys("Create New Case");
		waitForElementToBeClickable(driver, hrDashboard);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", hrDashboard);
		waitForAction(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
	}

	public void validate_createcasepage(String str) throws Exception {
		waitForAction(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, search_dropdown);
		search_dropdown.click();
		waitForElementToBeClickable(driver, search_bar);
		search_bar.sendKeys(str);
		checkForPageLoad(driver);
		search_bar.sendKeys(Keys.TAB);
		waitForAction(driver);

		if (create_case.getText().contains("Create Case")) {
			test.get().log(Status.INFO, MarkupHelper.createLabel("case creation page was displayed", ExtentColor.CYAN));
			logSuccess("Expected Value - " + "Create Case");
			logSuccess("Actual Value - " + create_case.getText());
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("case creation page was not displayed", ExtentColor.RED));
			logFailure("Expected Value - " + "Create Case");
			logFailure("Actual Value - " + create_case.getText());
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	public String casecreation(String source, String coe, String hrservice, String Description, String replacementuser)
			throws Exception {
		waitForElementToBeClickable(driver, source_dropdown);
		source_dropdown.click();
		waitForElementToBeClickable(driver, source_searchbar);
		source_searchbar.sendKeys(source);
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
		test.get().log(Status.INFO, MarkupHelper.createLabel("Case details are filled", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", button);
		waitForAction(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, hrcase_number);
		String casenumber = hrcase_number.getAttribute("value");
		System.out.println("Case Number - " + casenumber);

		waitForElement(driver, hrcase_openedby);
		String hrcaseopenedby = hrcase_openedby.getAttribute("value");
		System.out.println("String1: - " + hrcaseopenedby);

		driver.switchTo().defaultContent();
		waitForElement(driver, specified_user);
		String specifieduser = specified_user.getText();
		System.out.println("String2: - " + specifieduser);
		// driver.switchTo().frame(0);

		String hrPageWindowHandle = driver.getWindowHandle();
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, requestedby_button);
		requestedby_button.click();
		waitForAction(driver);

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> windowIterator = handles.iterator();
		while (windowIterator.hasNext()) {
			String windowName = windowIterator.next();
			if (!windowName.equals(hrPageWindowHandle)) {
				System.out.println(windowName);
				driver.switchTo().window(windowName);
				driver.manage().window().maximize();

				waitForElementToBeClickable(driver, search_dropDown);
				Select select = new Select(search_dropDown);
				select.selectByVisibleText("Name");
				waitForElementToBeClickable(driver, search_field);
				search_field.sendKeys(replacementuser);
				search_field.sendKeys(Keys.ENTER);
				waitForAction(driver);
				waitForElementToBeClickable(driver, search_name);
				search_name.sendKeys(replacementuser);
				search_name.sendKeys(Keys.ENTER);
				waitForAction(driver);

				try {
					driver.findElement(
							By.xpath("//*[@class='glide_ref_item_link' and text() = '" + replacementuser + "']"))
							.click();
				} catch (Exception e) {
					System.out.println("Error in finding element");
				}
			}
		}

		driver.switchTo().window(hrPageWindowHandle);
		// driver.switchTo().frame(0);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, update_button);
		logInfo("Updating the Case - " + casenumber);
		logInfoScreenshot(driver);
		System.out.println("Case ID URL - " + driver.getCurrentUrl());
		logInfo("Case ID URL - " + driver.getCurrentUrl());
		/*
		 * Actions actions = new Actions(driver);
		 * actions.click(header.get(0)).build().perform();
		 * actions.contextClick(header.get(0)).build().perform();
		 * waitForElementToBeClickable(driver, saveButton); saveButton.click();
		 */
		update_button.click();
		checkForPageLoad(driver);
		System.out.println("Clicked on Update button");
		return casenumber;
	}

	public void validating_user1(String casenumber) throws Exception {
		PageFactory.initElements(driver, HRSM_OpenedByRequestedByAboutPage.class);
		driver.switchTo().defaultContent();
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.sendKeys("");
		leftSearch.click();
		leftSearch.clear();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("Searching for ALL HR CASES");
		// leftSearch.sendKeys("All Hr Cases");
		js.executeScript("arguments[0].textContent='" + "ALL HR CASES" + "';", leftSearch);
		waitForElementToBeClickable(driver, hrDashboard1);
		js.executeScript("arguments[0].click();", hrDashboard1);
		checkForPageLoad(driver);

		driver.navigate().refresh();
		waitForFrameToBeAvailable(driver, "gsft_main");
		System.out.println("Case number:" + casenumber);
		waitForElementToBeClickable(driver, search_dropDown);
		Select select = new Select(search_dropDown);
		select.selectByVisibleText("Number");
		waitForAction(driver);
		waitForElementToBeClickable(driver, search_dropdown_field);
		search_dropdown_field.sendKeys(casenumber.trim());
		search_dropdown_field.sendKeys(Keys.ENTER);
		waitForAction(driver);

		waitForElementToBeClickable(driver, searchBox);
		try {
			waitForElementToBeClickable(driver, searchBox);
			searchBox.clear();
			searchBox.sendKeys(casenumber.trim(), Keys.ENTER);
		} catch (Exception e) {
			driver.navigate().refresh();
			waitForFrameToBeAvailable(driver, "gsft_main");
			searchIcon.click();
			waitForElementToBeClickable(driver, searchBox);
			searchBox.sendKeys(casenumber.trim(), Keys.ENTER);
		}
		waitForAction(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		Iicon.click();
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, openRecord);
		openRecord.click();
		waitForAction(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, hrcase_openedby);
		String hrcaseopenedby = hrcase_openedby.getAttribute("value");
		System.out.println("String1: - " + hrcaseopenedby);
		driver.switchTo().defaultContent();
		String specifieduser = specified_user.getText();
		System.out.println("String2: - " + specifieduser);

		if (hrcaseopenedby.equalsIgnoreCase(specifieduser)) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"**" + hrcaseopenedby + " can see the cases as the Opened By**:  ", ExtentColor.GREEN));
			logSuccess("Expected Value - " + specifieduser);
			logSuccess("Actual Value - " + hrcaseopenedby);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("**" + hrcaseopenedby + " cannot see the cases as the Opened By**", ExtentColor.RED));
			logFailure("Expected Value - " + specifieduser);
			logFailure("Actual Value - " + hrcaseopenedby);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	public void navigateToHRDashboard1(String casenumber) throws Exception {
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.sendKeys("All Hr Cases");
		waitForElementToBeClickable(driver, hrDashboard1);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", hrDashboard1);
		waitForAction(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, search_dropDown);
		Select select = new Select(search_dropDown);
		select.selectByVisibleText("Number");
		waitForElementToBeClickable(driver, search_dropdown_field);
		search_dropdown_field.sendKeys(casenumber);
		search_dropdown_field.sendKeys(Keys.ENTER);
		waitForAction(driver);

		waitForElementToBeClickable(driver, searchBox);
		try {
			waitForElementToBeClickable(driver, searchBox);
			searchBox.clear();
			searchBox.sendKeys(casenumber.trim(), Keys.ENTER);
		} catch (Exception e) {
			driver.navigate().refresh();
			waitForFrameToBeAvailable(driver, "gsft_main");
			searchIcon.click();
			waitForElementToBeClickable(driver, searchBox);
			searchBox.sendKeys(casenumber.trim(), Keys.ENTER);
		}

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, Iicon);
		Iicon.click();
		waitForAction(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, openRecord);
		openRecord.click();
		waitForAction(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, requested_by);
		String requesteduser = requested_by.getAttribute("value");
		driver.switchTo().defaultContent();
		waitForElement(driver, specified_user);
		String specifieduser = specified_user.getText();
		if (requesteduser.equalsIgnoreCase(specifieduser)) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"**" + requesteduser + " can see the cases as the Requested By**:  ", ExtentColor.GREEN));
			logSuccess("Expected Value - " + specifieduser);
			logSuccess("Actual Value - " + requesteduser);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("**" + requesteduser + "cannot see the cases as the Requested By**", ExtentColor.RED));
			logFailure("Expected Value - " + specifieduser);
			logFailure("Actual Value - " + requesteduser);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	public void navigateToHRDashboard2(String str, String casenumber) throws Exception {
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.sendKeys("All Hr Cases");
		waitForElementToBeClickable(driver, hrDashboard1);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", hrDashboard1);
		waitForAction(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, search_dropDown);
		Select select = new Select(search_dropDown);
		select.selectByVisibleText("Number");
		waitForElementToBeClickable(driver, search_dropdown_field);
		search_dropdown_field.sendKeys(casenumber);
		search_dropdown_field.sendKeys(Keys.ENTER);
		waitForAction(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, searchBox);
		try {
			waitForElementToBeClickable(driver, searchBox);
			searchBox.clear();
			searchBox.sendKeys(casenumber.trim(), Keys.ENTER);
		} catch (Exception e) {
			driver.navigate().refresh();
			waitForFrameToBeAvailable(driver, "gsft_main");
			searchIcon.click();
			waitForElementToBeClickable(driver, searchBox);
			searchBox.sendKeys(casenumber.trim(), Keys.ENTER);
		}

		waitForAction(driver);
		String errormessage = error_message.getText();
		if (errormessage.equalsIgnoreCase("No records to display")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"**" + str + "is unable to see the case as he/she does not have access to the COE**:  ",
							ExtentColor.GREEN));
			logSuccess("Expected Value - " + "No records to display");
			logSuccess("Actual Value - " + errormessage);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"**" + str + "is able to see the case as he/she have access to the COE**", ExtentColor.RED));
			logFailure("Expected Value - " + "No records to display");
			logFailure("Actual Value - " + errormessage);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	public String casecreation1(String source, String coe, String hrservice, String Description, String replacementuser)
			throws Exception {
		waitForElementToBeClickable(driver, source_dropdown);
		source_dropdown.click();
		waitForElementToBeClickable(driver, source_searchbar);
		source_searchbar.sendKeys(source);
		source_searchbar.sendKeys(Keys.TAB);
		waitForAction(driver);

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
		test.get().log(Status.INFO, MarkupHelper.createLabel("Case details are filled", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		waitForElementToBeClickable(driver, button);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", button);
		waitForAction(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, hrcase_number1);
		String casenumber1 = hrcase_number1.getAttribute("value");
		System.out.println(casenumber1);

		waitForElement(driver, hrcase_openedby1);
		String hrcaseopenedby = hrcase_openedby1.getAttribute("value");
		System.out.println("String1: - " + hrcaseopenedby);

		driver.switchTo().defaultContent();
		String specifieduser = specified_user.getText();
		System.out.println("String2: - " + specifieduser);
		// driver.switchTo().frame(0);

		String hrPageWindowHandle = driver.getWindowHandle();
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, requestedby_button1);
		requestedby_button1.click();
		waitForAction(driver);

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> windowIterator = handles.iterator();
		while (windowIterator.hasNext()) {
			String windowName = windowIterator.next();
			if (!windowName.equals(hrPageWindowHandle)) {
				driver.switchTo().window(windowName);
				System.out.println(windowName);
				driver.switchTo().window(windowName);
				driver.manage().window().maximize();

				waitForElementToBeClickable(driver, search_dropDown);
				Select select = new Select(search_dropDown);
				select.selectByVisibleText("Name");
				waitForElementToBeClickable(driver, search_field);
				search_field.sendKeys(replacementuser);
				search_field.sendKeys(Keys.ENTER);

				waitForAction(driver);
				waitForElementToBeClickable(driver, search_name);
				search_name.sendKeys(replacementuser);
				search_name.sendKeys(Keys.ENTER);
				waitForAction(driver);
				try {
					driver.findElement(
							By.xpath("//*[@class='glide_ref_item_link' and text() = '" + replacementuser + "']"))
							.click();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		driver.switchTo().window(hrPageWindowHandle);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, update_button);
		update_button.click();
		waitForAction(driver);
		checkForPageLoad(driver);
		return casenumber1;
	}

	public void validating_user2(String casenumber1) throws Exception {
		driver.switchTo().defaultContent();
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.sendKeys("All Hr Cases");
		waitForElementToBeClickable(driver, hrDashboard1);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", hrDashboard1);
		waitForAction(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		System.out.println("Case number:" + casenumber1);
		waitForElementToBeClickable(driver, search_dropDown);
		Select select = new Select(search_dropDown);
		select.selectByVisibleText("Number");
		waitForElementToBeClickable(driver, search_dropdown_field);
		search_dropdown_field.sendKeys(casenumber1);
		search_dropdown_field.sendKeys(Keys.ENTER);
		waitForAction(driver);

		waitForElementToBeClickable(driver, searchBox);
		try {
			waitForElementToBeClickable(driver, searchBox);
			searchBox.clear();
			searchBox.sendKeys(casenumber1.trim(), Keys.ENTER);
		} catch (Exception e) {
			driver.navigate().refresh();
			waitForFrameToBeAvailable(driver, "gsft_main");
			searchIcon.click();
			waitForElementToBeClickable(driver, searchBox);
			searchBox.sendKeys(casenumber1.trim(), Keys.ENTER);
		}

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, Iicon);
		Iicon.click();
		waitForAction(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, openRecord);
		openRecord.click();

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, hrcase_openedby1);
		String hrcaseopenedby = hrcase_openedby1.getAttribute("value");
		System.out.println("String1: - " + hrcaseopenedby);
		driver.switchTo().defaultContent();
		waitForElement(driver, specified_user);
		String specifieduser = specified_user.getText();
		System.out.println("String2: - " + specifieduser);

		if (hrcaseopenedby.equalsIgnoreCase(specifieduser)) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"**" + hrcaseopenedby + " can see the cases as the Opened By**:  ", ExtentColor.GREEN));
			logSuccess("Expected Value - " + specifieduser);
			logSuccess("Actual Value - " + hrcaseopenedby);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("**" + hrcaseopenedby + "cannot see the cases as the Opened By**", ExtentColor.RED));
			logFailure("Expected Value - " + specifieduser);
			logFailure("Actual Value - " + hrcaseopenedby);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	public void navigateToHRDashboard3(String casenumber1) throws Exception {
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.sendKeys("All Hr Cases");
		waitForElementToBeClickable(driver, hrDashboard1);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", hrDashboard1);
		waitForAction(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, search_dropDown);
		Select select = new Select(search_dropDown);
		select.selectByVisibleText("Number");
		waitForElementToBeClickable(driver, search_dropdown_field);
		search_dropdown_field.sendKeys(casenumber1);
		search_dropdown_field.sendKeys(Keys.ENTER);
		waitForAction(driver);

		waitForElementToBeClickable(driver, searchBox);
		try {
			waitForElementToBeClickable(driver, searchBox);
			searchBox.clear();
			searchBox.sendKeys(casenumber1.trim(), Keys.ENTER);
		} catch (Exception e) {
			driver.navigate().refresh();
			waitForFrameToBeAvailable(driver, "gsft_main");
			searchIcon.click();
			waitForElementToBeClickable(driver, searchBox);
			searchBox.sendKeys(casenumber1.trim(), Keys.ENTER);
		}

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, Iicon);
		Iicon.click();
		waitForAction(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, openRecord);
		openRecord.click();
		waitForAction(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, requested_by1);
		String requesteduser = requested_by1.getAttribute("value");
		driver.switchTo().defaultContent();
		waitForElement(driver, specified_user);
		String specifieduser = specified_user.getText();

		if (requesteduser.equalsIgnoreCase(specifieduser)) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"**" + requesteduser + " can see the cases as the Requested By**:  ", ExtentColor.GREEN));
			logSuccess("Expected Value - " + specifieduser);
			logSuccess("Actual Value - " + requesteduser);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("**" + requesteduser + "cannot see the cases as the Requested By**", ExtentColor.RED));
			logFailure("Expected Value - " + specifieduser);
			logFailure("Actual Value - " + requesteduser);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	public void navigateToHRDashboard4(String casenumber1) throws Exception {
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.sendKeys("All Hr Cases");
		waitForElementToBeClickable(driver, hrDashboard1);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", hrDashboard1);
		waitForAction(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, search_dropDown);
		Select select = new Select(search_dropDown);
		select.selectByVisibleText("Number");
		waitForElementToBeClickable(driver, search_dropdown_field);
		search_dropdown_field.sendKeys(casenumber1);
		search_dropdown_field.sendKeys(Keys.ENTER);
		waitForAction(driver);

		waitForElementToBeClickable(driver, searchBox);
		try {
			waitForElementToBeClickable(driver, searchBox);
			searchBox.clear();
			searchBox.sendKeys(casenumber1.trim(), Keys.ENTER);
		} catch (Exception e) {
			driver.navigate().refresh();
			waitForFrameToBeAvailable(driver, "gsft_main");
			searchIcon.click();
			waitForElementToBeClickable(driver, searchBox);
			searchBox.sendKeys(casenumber1.trim(), Keys.ENTER);
		}

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, Iicon);
		Iicon.click();
		waitForAction(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, openRecord);
		openRecord.click();
		waitForAction(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, about_by);
		String aboutby = about_by.getAttribute("value");
		driver.switchTo().defaultContent();
		waitForElement(driver, specified_user);
		String specifieduser = specified_user.getText();
		if (aboutby.equalsIgnoreCase(specifieduser)) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"**" + aboutby + " can see the cases as he/she has access to the COE**:  ", ExtentColor.GREEN));
			logSuccess("Expected Value - " + specifieduser);
			logSuccess("Actual Value - " + aboutby);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"**" + aboutby + " unable to see the cases as he/she doesn't has access to the COE**",
							ExtentColor.RED));
			logFailure("Expected Value - " + specifieduser);
			logFailure("Actual Value - " + aboutby);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}
}
