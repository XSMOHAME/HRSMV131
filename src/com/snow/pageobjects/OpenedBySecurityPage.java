package com.snow.pageobjects;

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

public class OpenedBySecurityPage extends ReusableLibrary {
	public WebDriver driver;

	public OpenedBySecurityPage(WebDriver driver) {
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

	// @FindBy(xpath = "//div[@id='s2id_search_input']")
	@FindBy(xpath = "//span[text()='Search for requester or case number']/..")
	public WebElement search_dropdown;

	@FindBy(xpath = "//input[@id='s2id_autogen1_search']")
	public WebElement search_bar;

	@FindBy(xpath = "//input[@id='s2id_autogen1_search']/parent::div/following-sibling::ul")
	public WebElement search_result;

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

	@FindBy(id = "sys_readonly.sn_hr_core_case_total_rewards.number")
	public WebElement hrcase_number;

	@FindBy(xpath = "//input[@id='sys_readonly.sn_hr_core_hr_employee_services.number']")
	public WebElement hrcase_number1;

	@FindBy(xpath = "//input[@id='sn_hr_core_case_total_rewards.opened_by_label']")
	public WebElement hrcase_openedby;

	@FindBy(xpath = "//input[@id='sn_hr_core_hr_employee_services.opened_by_label']")
	public WebElement hrcase_openedby1;

	@FindBy(xpath = "//span[@class='user-name hidden-xs hidden-sm hidden-md']")
	public WebElement specified_user;

	@FindBy(xpath = "//table[@id='sn_hr_core_case_table']//input[@id='sn_hr_core_case_table_header_search_control']")
	public WebElement number;

	@FindBy(xpath = "//td[contains(text(),'No records to display')]")
	public WebElement hometitle;

	@FindBy(xpath = "//*[contains(@id, 'row_sn_hr_core_case')]")
	public WebElement case_information;

	@FindBy(xpath = "//select[@class='form-control default-focus-outline']")
	public WebElement search_dropDown;

	@FindBy(xpath = "//input[@class='form-control'][@placeholder='Search']")
	public WebElement search_field;

	// String casenumber;
	// String casenumber1;
	// String casenumber2;
	// String casenumber3;

	public void navigateToHRDashboard() throws Exception {
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.sendKeys("Create New Case");
		waitForAction(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", hrDashboard);
		// driver.switchTo().frame(0);
	}

	public void validate_createcasepage(String user) throws Exception {
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, search_dropdown);
		search_dropdown.click();
		search_bar.sendKeys(user);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, search_result);
		search_bar.sendKeys(Keys.TAB);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, create_case);
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

	public String casecreation(String source, String coe, String hrservice, String Description) throws Exception {
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

		scrollPageToElement(driver, button);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", button);

		waitForAction(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, hrcase_number);
		String casenumber = hrcase_number.getAttribute("value");
		String hrcaseopenedby = hrcase_openedby.getAttribute("value");
		System.out.println("string1:" + hrcaseopenedby);
		driver.switchTo().defaultContent();

		String specifieduser = specified_user.getText();
		System.out.println("string2:" + specifieduser);
		if (hrcaseopenedby.equalsIgnoreCase(specifieduser)) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("**" + hrcaseopenedby + "can see the cases as the Opened By**:  ", ExtentColor.GREEN));
			logSuccess("Expected Value - " + specifieduser);
			logSuccess("Actual Value - " + hrcaseopenedby);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"**" + hrcaseopenedby + "cannot  see the cases as the Opened By**:  ", ExtentColor.RED));
			logFailure("Expected Value - " + specifieduser);
			logFailure("Actual Value - " + hrcaseopenedby);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		return casenumber;
	}

	public String casecreation1(String source, String coe, String hrservice, String Description) throws Exception {
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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", button);
		waitForAction(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, hrcase_number);
		String casenumber1 = hrcase_number.getAttribute("value");
		System.out.println(casenumber1);

		waitForElementToBeClickable(driver, hrcase_openedby);
		String hrcaseopenedby = hrcase_openedby.getAttribute("value");
		System.out.println("string1:" + hrcaseopenedby);
		driver.switchTo().defaultContent();
		waitForElementToBeClickable(driver, specified_user);
		String specifieduser = specified_user.getText();
		System.out.println("string2:" + specifieduser);
		if (hrcaseopenedby.equalsIgnoreCase(specifieduser)) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("**" + hrcaseopenedby + "can see the cases as the Opened By**:  ", ExtentColor.GREEN));
			logSuccess("Expected Value - " + specifieduser);
			logSuccess("Actual Value - " + hrcaseopenedby);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"**" + hrcaseopenedby + "cannot see the cases as the Opened By**:  ", ExtentColor.RED));
			logFailure("Expected Value - " + specifieduser);
			logFailure("Actual Value - " + hrcaseopenedby);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		return casenumber1;
	}

	public String casecreation2(String source, String coe, String hrservice, String Description) throws Exception {
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

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", button);
		checkForPageLoad(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");

		waitForElement(driver, hrcase_number1);
		String casenumber2 = hrcase_number1.getAttribute("value");
		System.out.println(casenumber2);

		waitForElement(driver, hrcase_openedby1);
		String hrcaseopenedby = hrcase_openedby1.getAttribute("value");
		System.out.println("string1:" + hrcaseopenedby);

		driver.switchTo().defaultContent();
		waitForElement(driver, specified_user);
		String specifieduser = specified_user.getText();
		System.out.println("string2:" + specifieduser);
		if (hrcaseopenedby.equalsIgnoreCase(specifieduser)) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("**" + hrcaseopenedby + "can see the cases as the Opened By**  ", ExtentColor.GREEN));
			logSuccess("Expected Value - " + specifieduser);
			logSuccess("Actual Value - " + hrcaseopenedby);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("**" + hrcaseopenedby + "cannot  see the cases as the Opened By** ", ExtentColor.RED));
			logFailure("Expected Value - " + specifieduser);
			logFailure("Actual Value - " + hrcaseopenedby);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		return casenumber2;
	}

	public String casecreation3(String source, String coe, String hrservice, String Description) throws Exception {
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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", button);

		checkForPageLoad(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, hrcase_number1);
		String casenumber3 = hrcase_number1.getAttribute("value");
		System.out.println(casenumber3);

		waitForElement(driver, hrcase_openedby1);
		String hrcaseopenedby = hrcase_openedby1.getAttribute("value");
		System.out.println("string1:" + hrcaseopenedby);

		driver.switchTo().defaultContent();
		waitForElement(driver, specified_user);
		String specifieduser = specified_user.getText();
		System.out.println("string2:" + specifieduser);
		if (hrcaseopenedby.equalsIgnoreCase(specifieduser)) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("**" + hrcaseopenedby + "can see the cases as the Opened By**", ExtentColor.GREEN));
			logSuccess("Expected Value - " + specifieduser);
			logSuccess("Actual Value - " + hrcaseopenedby);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"**" + hrcaseopenedby + "cannot see the cases as the Opened By**:  ", ExtentColor.RED));
			logFailure("Expected Value - " + specifieduser);
			logFailure("Actual Value - " + hrcaseopenedby);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		return casenumber3;
	}

	public void navigateToHRDashboard1(String casenumber) throws Exception {
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.sendKeys("All Hr Cases");
		waitForAction(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", hrDashboard1);

		waitForElementToBeClickable(driver, specified_user);
		String specifieduser = specified_user.getText();
		waitForFrameToBeAvailable(driver, "gsft_main");
		System.out.println("case number:" + casenumber);
		// number.sendKeys(casenumber);
		// number.sendKeys(Keys.ENTER);
		waitForElementToBeClickable(driver, search_dropDown);
		Select select = new Select(search_dropDown);
		select.selectByVisibleText("Number");
		search_field.sendKeys(casenumber);
		search_field.sendKeys(Keys.ENTER);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, hometitle);
		if (isElementPresent(hometitle) && hometitle.getText().equalsIgnoreCase("No records to display")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(specifieduser + "  is unable to see HR cases", ExtentColor.GREEN));
			logSuccess("Expected Value - " + "No records to display");
			logSuccess("Actual Value - " + hometitle.getText());
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					specifieduser + "  is able to see HR cases orExpected message is not displayed.", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			logFailure("Expected Value - " + "No records to display");
			logFailure("Actual Value - " + hometitle.getText());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		driver.switchTo().defaultContent();
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.clear();
		leftSearch.sendKeys("Create New Case");
		waitForAction(driver);
		js.executeScript("arguments[0].click();", hrDashboard);
		waitForAction(driver);
		// driver.switchTo().frame(0);
		waitForFrameToBeAvailable(driver, "gsft_main");
	}

	public void navigateToHRDashboard2(String casenumber1) throws Exception {
		driver.switchTo().defaultContent();
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.clear();
		leftSearch.sendKeys("All Hr Cases");
		waitForAction(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", hrDashboard1);
		waitForAction(driver);

		waitForElementToBeClickable(driver, specified_user);
		String specifieduser = specified_user.getText();
		waitForFrameToBeAvailable(driver, "gsft_main");
		System.out.println("case number:" + casenumber1);
		// number.sendKeys(casenumber1);
		// number.sendKeys(Keys.ENTER);
		Select select = new Select(search_dropDown);
		select.selectByVisibleText("Number");
		search_field.sendKeys(casenumber1);
		waitForAction(driver);
		search_field.sendKeys(Keys.ENTER);
		waitForAction(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");

		waitForElement(driver, case_information);
		if (case_information.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(specifieduser + "  is able to see HR cases", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(specifieduser + "  is unable to see HR cases", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	public void navigateToHRDashboard3(String casenumber2) throws Exception {
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.sendKeys("All Hr Cases");
		waitForAction(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", hrDashboard1);
		waitForAction(driver);

		waitForElement(driver, specified_user);
		String specifieduser = specified_user.getText();
		// driver.switchTo().frame(0);
		waitForFrameToBeAvailable(driver, "gsft_main");
		System.out.println("case number:" + casenumber2);
		// number.sendKeys(casenumber2);
		// number.sendKeys(Keys.ENTER);
		waitForElementToBeClickable(driver, search_dropDown);
		Select select = new Select(search_dropDown);
		select.selectByVisibleText("Number");
		search_field.sendKeys(casenumber2);
		waitForAction(driver);
		search_field.sendKeys(Keys.ENTER);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, hometitle);
		if (hometitle.getText().equalsIgnoreCase("No records to display")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(specifieduser + "  is unable to see HR cases", ExtentColor.GREEN));
			logSuccess("Expected Value - " + "No records to display");
			logSuccess("Actual Value - " + hometitle.getText());
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(specifieduser + "  is able to see HR cases", ExtentColor.RED));
			logFailure("Expected Value - " + "No records to display");
			logFailure("Actual Value - " + hometitle.getText());
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		driver.switchTo().defaultContent();
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.clear();
		leftSearch.sendKeys("Create New Case");
		waitForAction(driver);
		js.executeScript("arguments[0].click();", hrDashboard);
		waitForAction(driver);
		// driver.switchTo().frame(0);
		waitForFrameToBeAvailable(driver, "gsft_main");
	}

	public void navigateToHRDashboard4(String casenumber3) throws Exception {
		driver.switchTo().defaultContent();
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.clear();
		leftSearch.sendKeys("All Hr Cases");
		waitForAction(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", hrDashboard1);
		waitForAction(driver);

		waitForElement(driver, specified_user);
		String specifieduser = specified_user.getText();
		// driver.switchTo().frame(0);
		waitForFrameToBeAvailable(driver, "gsft_main");
		System.out.println("case number:" + casenumber3);
		// number.sendKeys(casenumber3);
		// number.sendKeys(Keys.ENTER);
		waitForElement(driver, search_dropDown);
		Select select = new Select(search_dropDown);
		select.selectByVisibleText("Number");
		search_field.sendKeys(casenumber3);
		waitForAction(driver);
		search_field.sendKeys(Keys.ENTER);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, case_information);
		if (case_information.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(specifieduser + "  is able to see HR cases", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(specifieduser + "  is unable to see HR cases", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}
}
