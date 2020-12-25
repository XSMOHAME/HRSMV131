package com.snow.pageobjects;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.snow.base.ReusableLibrary;
import com.snow.exceptions.InvalidCredentialException;

public class HR_EC_Portal_Page extends ReusableLibrary {
	public WebDriver driver;

	public HR_EC_Portal_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'To-dos')]")
	public WebElement portal_to_do;

	@FindBy(xpath = "//span[contains(text(),'Case Activity')]")
	public WebElement portal_case_activity;

	@FindBy(xpath = "//span[contains(text(),'Make a Request')]")
	public WebElement portal_make_a_request;
	//Comment 
	@FindBy(xpath = "//input[@name='q']")
	public WebElement portal_ask_a_question_search;

	@FindBy(xpath = "//*[text()=', how can we help? ']")
	public WebElement xpheader;

	@FindBy(xpath = "//a[contains(text(),'Quick Links')]")
	public WebElement portal_quick_links;

	@FindBy(xpath = "//a[contains(text(),'Announcements')]")
	public WebElement portal_announcements;

	@FindBy(xpath = "//*[contains(text(),'Contact Us')]")
	public WebElement portal_contact_us;

	@FindBy(xpath = "//a[contains(text(),'FAQs')]")
	public WebElement portal_faq;

	@FindBy(xpath = "//img[@ng-src='b75ac0d737aa57002fc0c7d1b3990e67.iix']")
	public WebElement logo_employee_connection;

	@FindBy(xpath = "//dt[contains(text(),'Opened for')]")
	public WebElement portal_opened_for;

	@FindBy(xpath = "//dl[contains(@class,'row caseDescriptor')]//div[1]//div[1]//div[2]//dd[1]//a[1]")
	public WebElement portal_opened_for_user;

	@FindBy(xpath = "//dt[contains(text(),'Subject person')]")
	public WebElement portal_subject_person;

	@FindBy(xpath = "//dl[contains(@class,'row caseDescriptor')]//div[2]//div[1]//div[2]//dd[1]//a[1]")
	public WebElement portal_subject_person_user;

	@FindBy(xpath = "//dt[contains(text(),'Watch list')]")
	public WebElement watch_list_person;

	@FindBy(xpath = "//dt[contains(@class,'header-label ng-binding formatLabels')]")
	public WebElement portal_short_description;

	@FindBy(xpath = "//dd[contains(@class,'formatDesc ng-binding text-a formatText ng-scope formatLabels')]")
	public WebElement portal_short_description_content;

	@FindBy(xpath = "//div[contains(@class,'description panel b')]//h4[contains(@class,'panel-title')]")
	public WebElement portal_description;

	@FindBy(xpath = "//div[@class='case-title ng-binding']")
	public WebElement portal_title;

	@FindBy(css = ".col-sm-2 > div:nth-child(3) > a:nth-child(1)")
	public WebElement portal_cancel_case;

	@FindBy(xpath = "//a[contains(text(),'Create new')]")
	public WebElement portal_create_new;

	@FindBy(xpath = "//div[contains(@class,'description panel b')]//h4[contains(@class,'panel-title')]")
	public WebElement portal_description_title;

	@FindBy(xpath = ".//*[@id='xf9fbccf3c3603200b599b4ad81d3ae80']/div[4]/div[1]/div/div[1]/h4")
	public WebElement portal_history_title;

	@FindBy(xpath = "//h2[contains(@class,'h4 sp-attachments-header panel-title pull-left')]")
	public WebElement portal_attachments_title;

	@FindBy(xpath = "//*[@id='sp-nav-bar']/ul[3]/li[1]/a/span[2]")
	public WebElement hrlogin;

	@FindBy(xpath = "//*[contains(@name,'q') and contains(@placeholder,'Ask a Question')]")
	public WebElement searchBox;

	@FindBy(xpath = "//ul[contains(@class,  'dropdown-menu')]/descendant::a[contains(@href, 'kb_article')]")
	public WebElement searchedArticlePortal;

	@FindBy(xpath = "//button[@title = 'Ask a Question']")
	public WebElement searchButton;

	@FindBy(xpath = "//*[@role='list']/div")
	public List<WebElement> searchedResults;

	@FindBy(xpath = "//*[contains(text(), 'Request')]/ancestor::a")
	public WebElement form;

	@FindBy(xpath = "//*[@id='typeahead-1244-8905-option-0']/a")
	public WebElement searchedForm;

	@FindBy(xpath = "//*[@id='catItemTop']/div/div[1]/h1")
	public WebElement verifyFormHeading;

	@FindBy(xpath = "//*[@id='x4a37470b37025b002fc0c7d1b3990e60']")
	public WebElement contactUs;

	@FindBy(xpath = "//*[@id='sp-nav-bar']/ul[3]/li[1]")
	public WebElement userLogin;

	@FindBy(xpath = "/html/body/div/section/header/div/div/nav/div[1]")
	public WebElement logo;

	@FindBy(xpath = "//*[contains(@class,'h4 panel-title ng-binding') and contains(text(),'Search results for')]")
	public WebElement searchHeader;

	@FindBy(xpath = "//*[contains(@class,'h4 panel-title') and contains(text(),'No Results')]")
	public WebElement noResult;

	@FindBy(xpath = "//*[contains(@role,'listitem')][1]")
	public WebElement searchResult;

	@FindBy(xpath = ".//*[@class='highlight mark']")
	public WebElement form_link;

	String expectedContactUs = "Contact Us";

	@FindBy(xpath = "//h1[text()='Check Request ']")
	public WebElement Ch_header;

	@FindBy(xpath = "//span[text()='Check Request']")
	public WebElement checkrequest;

	public void check_Request_HeaderValidation() throws IOException {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		waitForPageLoad(driver);
		executor.executeScript("arguments[0].click();", checkrequest);
		String HeaderText = Ch_header.getText();
		if (HeaderText.trim().equalsIgnoreCase("Check Request")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**Successfully navigating to Check Request page.**", ExtentColor.GREEN));

			logSuccess("Expected Value - " + "Check Request");
			logSuccess("Actual Value - " + HeaderText);

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("**Unable to navigating Check Request page.**", ExtentColor.RED));

			logFailure("Expected Value - " + "Check Request");
			logFailure("Actual Value - " + HeaderText);

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

	}

	public void hrPortalValidation() {
		PageFactory.initElements(driver, HRPortalPage.class);

		if (contactUs.isDisplayed()) {
			if (contactUs.getText().equals(expectedContactUs)) {
				test.get().log(Status.INFO,
						MarkupHelper.createLabel("Contact Us is disaplyed and text matched", ExtentColor.CYAN));

				logSuccess("Expected Value - " + expectedContactUs);
				logSuccess("Actual Value - " + contactUs.getText());

			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("Contact Us is disaplyed but text mismatched", ExtentColor.RED));

				logFailure("Expected Value - " + expectedContactUs);
				logFailure("Actual Value - " + contactUs.getText());
			}
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Contact Us is not disaplyed", ExtentColor.RED));
		}

		if (searchBox.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Search Box is disaplyed", ExtentColor.GREEN));

		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Search Box is not disaplyed", ExtentColor.RED));
		}

		if (userLogin.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("User Login is disaplyed", ExtentColor.GREEN));

		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("User Login is not disaplyed", ExtentColor.RED));
		}

		if (logo.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Logo is disaplyed", ExtentColor.GREEN));

		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Logo is not disaplyed", ExtentColor.RED));
		}

	}

	public void hrPortalNavigateValidate() throws IOException, InvalidCredentialException {
		PageFactory.initElements(driver, HRPortalPage.class);
		checkForPageLoad(driver);
		waitForElement(driver, hrlogin);
		if (hrlogin.isDisplayed()) {
			try {
				System.out.println("Navigated successfully to HR Portal as " + hrlogin.getText());
				test.get().log(Status.INFO, MarkupHelper
						.createLabel("Navigated successfully to HR Portal as " + hrlogin.getText(), ExtentColor.CYAN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} catch (Exception e) {
				throw new InvalidCredentialException(
						"Login Failed. Please verify, your credentials or privileges to the user");
			}
		}
	}

	public void searchForArticle(String kbID) throws InterruptedException, IOException {
		PageFactory.initElements(driver, HRPortalPage.class);
		waitForPageLoad(driver);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[contains(@name,'q') and contains(@placeholder,'Ask a Question')]")));
		waitForElement(driver, searchBox);
		searchBox.sendKeys(kbID);
		waitForPageLoad(driver);
		waitForElementToBeClickable(driver, searchButton);
		searchButton.click();
		waitForPageLoad(driver);
		waitForElement(driver, searchHeader);
		if (isElementPresent(searchHeader) && isElementPresent(searchResult)) {
			System.out.println("Seached the Article Successfully in HR PORTAL VIEW");
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("Knowledge Article Viewed Successfully in HR PORTAL VIEW", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			System.out.println("Failed to locate required Knowledge Article in HR PORTAL VIEW");
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Failed to locate required Knowledge Article in HR PORTAL VIEW", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	public void searchForRetiredArticle(String kbID) throws InterruptedException, IOException {
		PageFactory.initElements(driver, HRPortalPage.class);
		waitForPageLoad(driver);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[contains(@name,'q') and contains(@placeholder,'Ask a Question')]")));
		waitForElementToBeClickable(driver, searchBox);
		searchBox.sendKeys(kbID);
		waitForAction(driver);
		waitForElementToBeClickable(driver, searchButton);
		searchButton.click();
		waitForPageLoad(driver);

		if (noResult.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("Retired Knowledge Article Not avaiable in HR PORTAL VIEW", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Retired Knowledge Article Not avaiable in HR PORTAL VIEW");
		} else if (searchHeader.isDisplayed() && searchResult.isDisplayed()) {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Retired Knowledge Article displayed in HR PORTAL VIEW", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Retired Knowledge Article displayed in HR PORTAL VIEW");
		}

	}

	public void searchForForm(String searchForForm) throws InterruptedException, IOException {
		PageFactory.initElements(driver, HRPortalPage.class);
		waitForElementToBeClickable(driver, searchBox);
		searchBox.clear();
		waitForAction(driver);
		searchBox.sendKeys(searchForForm);
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		waitForElementToBeClickable(driver, searchButton);
		execute.executeScript("arguments[0].click();", searchButton);
		checkForPageLoad(driver);

		waitForElementToBeClickable(driver,
				driver.findElement(By.xpath("//*[@sn-atf-area = 'Search Nav']/div/a/span")));
		List<WebElement> resultCategories = driver
				.findElements(By.xpath("//*[@sn-atf-area = 'Search Nav']/div/a/span"));
		System.out.println("Result Categories size - " + resultCategories.size());

		if (resultCategories.size() > 0) {
			boolean formFound = false;
			int count = 0;
			while (count < resultCategories.size() && !formFound) {
				waitForElementToBeClickable(driver, resultCategories.get(count));
				System.out.println("Result Category Value - " + resultCategories.get(count).getText());
				String form = resultCategories.get(count).getText();
				System.out.println("Result Category Value - " + form);
				if (form.contains("Forms")) {
					System.out.println("Form Category is displayed.");
					logSuccess("Expected Valiue - " + "Forms");
					logSuccess("Actual Value - " + form);
					resultCategories.get(count).click();
					checkForPageLoad(driver);
					formFound = true;
				}
				count++;
			}
		}

		/* for (int i = 0; i < resultCategories.size(); i++) { } */

		/*
		 * waitForElementToBeClickable(driver, driver.findElement(By.xpath(
		 * "//*[@id='xc87518ce0f90e30016dfabf8b1050e65']/div/div/div[2]/div")));
		 */
		waitForElementToBeClickable(driver, driver.findElement(By.xpath("//*[@role='list']/div")));
		/*
		 * List<WebElement> searchedResults = driver .findElements(By.xpath(
		 * "//*[@id='xc87518ce0f90e30016dfabf8b1050e65']/div/div/div[2]/div"));
		 */
		System.out.println("Available searched Results - " + searchedResults.size());
		checkForPageLoad(driver);
		if (searchedResults.size() > 0) {
			int count = 0;
			for (int j = 0; j < searchedResults.size(); j++) {
				checkForPageLoad(driver);
				String searchedResult = searchedResults.get(j).getText().trim();
				System.out.println("Searched Results - " + searchedResult);
				if (searchedResult.contains(searchForForm)) {
					logSuccess("Expected Values - " + searchForForm);
					logSuccess("Actual Value - " + searchedResult);
					System.out
							.println("is Form " + searchForForm + " Enabled? - " + searchedResults.get(j).isEnabled());
					waitForElement(driver, form);
					checkForPageLoad(driver);
					WebElement formLink = driver
							.findElement(By.xpath("//*[contains(text(), '" + searchForForm.trim() + "')]/ancestor::a"));
					System.out.println("Text of Form Link - " + formLink.getText().trim());
					waitForElementToBeClickable(driver, formLink);
					formLink.click();
					waitForPageLoad(driver);
					System.out.println("Searched result is clicked.");
					count++;
					break;
				}
				if (count > 0) {
					break;
				}
			}
		}

		waitForAction(driver);
		waitForElement(driver, verifyFormHeading);
		String formHeader = verifyFormHeading.getText().trim();
		if (formHeader.equalsIgnoreCase(searchForForm.trim())) {
			System.out.println("Navigated successfully to Form  - " + searchForForm);
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Navigated successfully to Form  - " + searchForForm, ExtentColor.CYAN));
			logSuccess("Expected Value - " + searchForForm);
			logSuccess("Actual Value - " + formHeader);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			System.out.println("Navigation Failed to Form  - " + searchForForm);
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Navigation Failed to Form  - " + searchForForm, ExtentColor.RED));
			logFailure("Expected Value - " + searchForForm);
			logFailure("Actual Value - " + formHeader);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

// ----------------------------Portal Links----------------------	
	String expected_hr_portal_todos = "To-dos";
	String expected_hr_portal_caseactivity = "Case Activity";
	String expected_hr_portal_makearequest = "Make a Request";
	String expected_hr_portal_quicklinks = "Quick Links";
	String expected_hr_portal_announcements = "Announcements";
	String expected_hr_portal_contactus = "Contact Us";
	String expected_hr_portal_faqs = "FAQs";
	Boolean expected_image = true;

//------------------------------------Case Form-------------------		

	String expected_cancel_link = "Cancel case";
	String expected_create_new = "Create new";
	String expected_opened_for = "Opened for";
	String expected_subject_person = "Subject person";
	String expected_watch_list = "Watch list";
	String expected_short_description = "Short description";
	String expected_description_title = "Case Description";
	String expected_history_title = "History";
	String expected_attachments_title = "Attachments";

	public void caseFormValidation() {
		PageFactory.initElements(driver, HRPortalPage.class);

		String actual_cancel_link = portal_cancel_case.getText().trim();
		String actual_create_link = portal_create_new.getText().trim();
		String actual_short_description = portal_short_description.getText().trim();
		String actual_description_title = portal_description_title.getText().trim();
		// String actual_opened_for = portal_opened_for.getText();
		// String actual_subject_person = portal_subject_person.getText();
		// String actual_watch_list = watch_list_person.getText();

		Assert.assertEquals(actual_create_link, expected_create_new);
		Assert.assertEquals(actual_cancel_link, expected_cancel_link);
		Assert.assertEquals(actual_short_description, expected_short_description);
		Assert.assertEquals(actual_description_title, expected_description_title);
		// Assert.assertEquals(actual_opened_for, expected_opened_for);
		// Assert.assertEquals(actual_subject_person, expected_subject_person);
		// Assert.assertEquals(actual_watch_list, expected_watch_list);

		// portal_cancel_case.click();

		System.out.println("Portal successfully Validated");
	}

	public void HR_Portal_validation() {
		PageFactory.initElements(driver, HRPortalPage.class);

		String actual_hr_portal_todos = portal_to_do.getText();
		String actual_hr_portal_caseactivity = portal_case_activity.getText();
		String actual_hr_portal_makearequest = portal_make_a_request.getText();
		String actual_hr_portal_quicklinks = portal_quick_links.getText();
		String actual_hr_portal_announcements = portal_announcements.getText();
		String actual_hr_portal_contactus = portal_contact_us.getText();
		String actual_hr_portal_faqs = portal_faq.getText();

		Assert.assertEquals(actual_hr_portal_todos, expected_hr_portal_todos);
		Assert.assertEquals(actual_hr_portal_caseactivity, expected_hr_portal_caseactivity);
		Assert.assertEquals(actual_hr_portal_makearequest, expected_hr_portal_makearequest);
		Assert.assertEquals(actual_hr_portal_quicklinks, expected_hr_portal_quicklinks);
		Assert.assertEquals(actual_hr_portal_announcements, expected_hr_portal_announcements);
		Assert.assertEquals(actual_hr_portal_contactus, expected_hr_portal_contactus);
		Assert.assertEquals(actual_hr_portal_faqs, expected_hr_portal_faqs);

		Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				logo_employee_connection);
		if (!ImagePresent) {
			System.out.println("Image not displayed.");
		} else {
			System.out.println("Image displayed.");
		}
		Assert.assertEquals(ImagePresent, expected_image);

		System.out.println("\nHR Portal Page Successfully Validated\n");
	}

	public void searchForm(String form) throws InterruptedException, IOException {
		test.get().log(Status.INFO, MarkupHelper.createLabel("**Searching for a Form.**", ExtentColor.ORANGE));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, portal_ask_a_question_search);
		portal_ask_a_question_search.sendKeys(form);
		test.get().log(Status.INFO, MarkupHelper.createLabel("Searching for the form in searchbox.", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		/*
		 * Thread.sleep(3000); portal_ask_a_question_search.sendKeys(Keys.ARROW_DOWN);
		 */

		waitForPageLoad(driver);
		// portal_ask_a_question_search.sendKeys(Keys.ENTER);
		waitForElementToBeClickable(driver, searchButton);
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		execute.executeScript("arguments[0].click();", searchButton);

		test.get().log(Status.PASS, MarkupHelper.createLabel("Search for " + form + " is complete", ExtentColor.GREEN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	}

	public void navigate_form(String form) throws InterruptedException, IOException {
		test.get().log(Status.INFO, MarkupHelper.createLabel("**Navigate to the searched form.**", ExtentColor.ORANGE));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		waitForPageLoad(driver);
		waitForElement(driver, form_link);
		if (form_link.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Form link is displayed.", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			form_link.click();
			test.get().log(Status.PASS, MarkupHelper.createLabel("Form navigation is successful.", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Form link is NOT FOUND.", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	@FindBy(xpath = "//*[@id='sp-nav-bar']//span[contains(text(),'HUQ')]")
	public WebElement usernameIcon;

	@FindBy(xpath = ".//*[@class='dropdown-menu']//*[@href='/logout.do?sysparm_goto_url=/hr_portal']")
	public WebElement portal_logout;

	@FindBy(xpath = ".//*[@class='headerText'][contains(text(),'Contact Us')]")
	public WebElement contact_us_page_text;

	@FindBy(xpath = ".//*[@class='navbar-header']//*[@href='?id=hr_index']")
	public WebElement portal_employee_connection_logo;

	public void portal_Simplification() throws InterruptedException, IOException {
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Navigation into portal is done successfully.", ExtentColor.GREEN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		waitForPageLoad(driver);
		waitForElement(driver, usernameIcon);
		if (usernameIcon.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Username Icon is successfully displayed.", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			usernameIcon.click();
			waitForElement(driver, portal_logout);
			if (portal_logout.isDisplayed()) {
				test.get().log(Status.PASS,
						MarkupHelper.createLabel("LOGOUT button is displayed under the dropdown.", ExtentColor.GREEN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("LOGOUT button is NOT visible under the dropdown.", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}
		} else {
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Username Icon is not displayed.", ExtentColor.RED));
		}
		waitForElement(driver, portal_contact_us);
		if (portal_contact_us.isDisplayed()) {
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("CONTACT US is Visible on top right corner of the page.", ExtentColor.GREEN));
			portal_contact_us.click();
			waitForPageLoad(driver);
			waitForElement(driver, contact_us_page_text);
			if (contact_us_page_text.isDisplayed()) {
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				test.get().log(Status.PASS,
						MarkupHelper.createLabel("Successfully navigated to CONTACT US page.", ExtentColor.GREEN));
				portal_employee_connection_logo.click();
				waitForPageLoad(driver);
				waitForAction(driver);
				if (driver.getTitle().contains("HRSM Homepage")) {
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					test.get().log(Status.PASS, MarkupHelper.createLabel(
							"Successfully navigated to PORTAL home page when clicked on 'Employee Connection' icon.",
							ExtentColor.GREEN));
					logSuccess("Expected Valiue - " + "HRSM Homepage");
					logSuccess("Actual Value - " + driver.getTitle());
				} else {
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					test.get().log(Status.FAIL,
							MarkupHelper.createLabel("Couldn't navigate to Portal Home page.", ExtentColor.RED));
					logFailure("Expected Valiue - " + "HRSM Homepage");
					logFailure("Actual Value - " + driver.getTitle());
				}
			} else {
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("Couldn't navigate to CONTACT US page", ExtentColor.RED));
			}
		} else {
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("CONTACT US is not visible in the webpage.", ExtentColor.RED));
		}
	}

	public void search_form(String form) throws InterruptedException, IOException {
		test.get().log(Status.INFO, MarkupHelper.createLabel("**Searching for a Form.**", ExtentColor.ORANGE));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		JavascriptExecutor execute = (JavascriptExecutor) driver;
		driver.navigate().to(hrPortalURL);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, portal_ask_a_question_search);

		/*
		 * if (!driver.getPageSource().contains(", how can we help? ")) {
		 * 
		 * }
		 */

		scrollToElement(driver, portal_ask_a_question_search);
		portal_ask_a_question_search.click();
		// execute.executeScript("arguments[0].click();", portal_ask_a_question_search);
		/*
		 * execute.executeScript("arguments[0].click();", portal_ask_a_question_search);
		 * execute.executeScript("arguments[0].textContent='" + form + "';",
		 * portal_ask_a_question_search);
		 * execute.executeScript("arguments[1].value = arguments[0]; ", form,
		 * portal_ask_a_question_search);
		 */
		// execute.executeScript("arguments[0].value='" + form + "';",
		// portal_ask_a_question_search);
		portal_ask_a_question_search.sendKeys(form);

		test.get().log(Status.INFO, MarkupHelper.createLabel("Searching for the form in searchbox.", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		scrollToElement(driver, searchButton);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, searchButton);
		execute.executeScript("arguments[0].click();", searchButton);
		// searchButton.click();

		test.get().log(Status.PASS, MarkupHelper.createLabel("Search for " + form + " is complete", ExtentColor.GREEN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	}

	/*********************************************************************
	 * Navigation to portal home page and validating the following 1)Enter the
	 * following options to ensure that the relevant forms are being returned in the
	 * results. a)File Request b)Check Request c)Tuition Reimbursement Request
	 * d)General Inquiry. e)Residuals 2) Additionally confirm that next to forms,
	 * the Shopping Cart Icon as been replaced with a Paper Icon:
	 **********************************************************************/
	@FindBy(xpath = "(.//*[@class='fa m-r-sm fa-file-text-o'])[1]")
	public WebElement paperIcon;

	public void formValidations(String form) throws InterruptedException, IOException {
		test.get().log(Status.INFO, MarkupHelper.createLabel("Relavent Form Validations", ExtentColor.ORANGE));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		search_form(form);

		test.get().log(Status.INFO, MarkupHelper.createLabel("**Navigate to the searched form.**", ExtentColor.ORANGE));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		waitForPageLoad(driver);

		if (form_link.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Form link is displayed.", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

			if (form.trim().equalsIgnoreCase(form_link.getText().trim())) {
				test.get().log(Status.PASS, MarkupHelper
						.createLabel("Relevant form is displayed in the search results.", ExtentColor.GREEN));

				logSuccess("Expected Value - " + form_link.getText().trim());
				logSuccess("Actual Value - " + form.trim());

				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				waitForPageLoad(driver);
				if (paperIcon.isDisplayed()) {
					test.get().log(Status.PASS, MarkupHelper
							.createLabel("All form Results with PAPER icon are getting displayed.", ExtentColor.GREEN));
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				} else {
					test.get().log(Status.FAIL, MarkupHelper.createLabel("PAPER icon is NOT FOUND", ExtentColor.RED));
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				}
			} else {
				test.get().log(Status.FAIL, MarkupHelper
						.createLabel("Relevant form is NOT displayed in the search results.", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Form link is NOT FOUND.", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	/*********************************************************************
	 * Navigation to portal and validating the following 1)"Knowledge Base" widget
	 * validation in the search page. 2)Validation "DIDN'T FIND WHAT YOU'RE LOOKING
	 * FOR?" text in KNOWLEDGE BASE page. 3)"KNOWLEDGE BASE" breadcrumb validation.
	 * 4)"Didn't find what you're looking for? Submit a General Inquiry or Contact
	 * Us" text validation in Knowledge Article page. 5)"GENERAL INQUIRY" hyperlink
	 * and page validation. 6)"CONTACT US" hyperlink and page validation.
	 * 
	 **********************************************************************/

	@FindBy(xpath = ".//*[@href='/hr_portal?id=hr_contact_us']")
	public WebElement portal_contactUs_link;

	@FindBy(xpath = ".//*[@class='m-l-sm ng-binding'][contains(text(),'Knowledge')]")
	public WebElement portal_widget_knowledgeBase;

	@FindBy(xpath = ".//*[@href='?id=hr_kb_category&kb_category=9dbfd1ae37c6d7002fc0c7d1b3990eca']")
	public WebElement portal_knowledgeBaseCategory_timeAndAttendance;

	@FindBy(xpath = ".//*[@href='?id=hrsm_kb_view2']")
	public WebElement portal_knowledgeBase_breadcrumb;

	@FindBy(xpath = "(.//*[@class='highlight mark'])[1]")
	public WebElement portal_firstKnowledgeArticle;

	@FindBy(xpath = "	//*[@id='xddbab997db983b00cf68132968961952'][contains(.,'find what you')]")
	public WebElement portal_footerText;

	@FindBy(xpath = ".//*[contains(text(),'Knowledge Base Categories')]")
	public WebElement portal_knowledgeBaseCategory_widget;

	@FindBy(xpath = ".//*[@class='m-l-sm ng-binding'][contains(text(),'Forms')]")
	public WebElement portal_widget_forms;

	@FindBy(xpath = ".//*[@widget='widget']//h2[contains(., 'find what')]")
	public WebElement portal_didntFindtext;

	@FindBy(xpath = ".//*[@href='/hr_portal?id=hrj_sc_cat_item&sys_id=27c78de49f331200d9011977677fcfb3']")
	public WebElement portal_submitGeneralInquiry;

	@FindBy(xpath = "//*[@class='a-disabled ng-binding ng-scope'][contains(text(),'General Inquiry')]")
	public WebElement portal_GeneralInquiry_breadcrumb;

	@FindBy(xpath = ".//*[@role='listbox']/li[contains(@id,'typeahead')]")
	public List<WebElement> portal_search_dropdownList;

	@FindBy(xpath = ".//*[@name='q']")
	public WebElement portal_searchBox;

	@FindBy(xpath = ".//*[@name='search']")
	public WebElement portal_search;

	public void portal_knowledgeBasePage_validation(String form) throws IOException {
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**KNOWLEDGE BASE widget validations**", ExtentColor.ORANGE));
		String KnowledgeArticle = "Travel and Expenses";
		waitForPageLoad(driver);

		if (portal_knowledgeBaseCategory_timeAndAttendance.isDisplayed()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("KNOWLEDGE BASE widget is visible in the search page", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			portal_knowledgeBaseCategory_timeAndAttendance.click();
			checkForPageLoad(driver);

			waitForElement(driver, portal_didntFindtext);
			if (portal_didntFindtext.isDisplayed()) {
				test.get().log(Status.PASS,
						MarkupHelper.createLabel(
								"DIDN'T FIND WHAT YOU'RE LOOKING FOR? text is present in the KNOWLEDGE BASE page",
								ExtentColor.GREEN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel(
								"DIDN'T FIND WHAT YOU'RE LOOKING FOR? text couldn't be found in KNOWLEDGE BASE page",
								ExtentColor.GREEN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}

			test.get().log(Status.INFO,
					MarkupHelper.createLabel("KNOWLEDGE BASE breadcrumb validation", ExtentColor.CYAN));
			waitForElementToBeClickable(driver, portal_knowledgeBase_breadcrumb);
			portal_knowledgeBase_breadcrumb.click();
			checkForPageLoad(driver);

			scrollToElement(driver, portal_knowledgeBaseCategory_widget);
			waitForAction(driver);
			waitForElement(driver, portal_knowledgeBaseCategory_widget);
			if (isElementPresent(portal_knowledgeBaseCategory_widget) && isElementPresent(portal_didntFindtext)) {
				test.get().log(Status.PASS, MarkupHelper.createLabel(
						"DIDN'T FIND WHAT YOU'RE LOOKING FOR? and KNOWLEDGE BASE CATEGORIES widgets are the only two available widgets in the KNOWLEDGE BASE page.",
						ExtentColor.GREEN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} else {
				test.get().log(Status.FAIL, MarkupHelper.createLabel(
						"DIDN'T FIND WHAT YOU'RE LOOKING FOR? and KNOWLEDGE BASE CATEGORIES widgets are not present in KNOWLEDGE BASE page.",
						ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}

			waitForPageLoad(driver);
			waitForElement(driver, portal_searchBox);
			waitForPageLoad(driver);
			waitForElementToBeClickable(driver, portal_searchBox);
			portal_searchBox.click();
			waitForAction(driver);
			portal_searchBox.sendKeys(KnowledgeArticle);
			waitForAction(driver);
			portal_search.click();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			waitForElementToBeClickable(driver, portal_firstKnowledgeArticle);
			checkForPageLoad(driver);
			js.executeScript("arguments[0].click();", portal_firstKnowledgeArticle);
			waitForPageLoad(driver);

			waitForElement(driver, portal_footerText);
			if (portal_footerText.isDisplayed()) {
				test.get().log(Status.PASS, MarkupHelper.createLabel(
						"**Didn't find what you're looking for? Submit a General Inquiry or Contact Us** text is displayed",
						ExtentColor.GREEN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

				waitForElement(driver, portal_submitGeneralInquiry);
				if (portal_submitGeneralInquiry.isDisplayed()) {
					scrollToElement(driver, portal_submitGeneralInquiry);
					portal_submitGeneralInquiry.click();

					waitForElement(driver, portal_GeneralInquiry_breadcrumb);
					if (portal_GeneralInquiry_breadcrumb.isDisplayed()) {
						test.get().log(Status.PASS, MarkupHelper
								.createLabel("Navigation to GENERAL INQUIRY page is successful", ExtentColor.GREEN));
						screenshotPath = getScreenshot(driver, this.getClass().getName());
						test.get().info("Details",
								MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
						driver.navigate().back();
					} else {
						test.get().log(Status.FAIL, MarkupHelper
								.createLabel("Navigation to GENERAL INQUIRY page is NOT successful", ExtentColor.RED));
						screenshotPath = getScreenshot(driver, this.getClass().getName());
						test.get().info("Details",
								MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					}

					waitForElement(driver, portal_contactUs_link);
					if (portal_contactUs_link.isDisplayed()) {
						scrollToElement(driver, portal_contactUs_link);
						portal_contactUs_link.click();

						waitForElement(driver, contact_us_page_text);
						if (contact_us_page_text.isDisplayed()) {
							test.get().log(Status.PASS, MarkupHelper
									.createLabel("Navigation to CONTACT US page is successful", ExtentColor.GREEN));
							screenshotPath = getScreenshot(driver, this.getClass().getName());
							test.get().info("Details",
									MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
							driver.navigate().back();
						} else {
							test.get().log(Status.FAIL, MarkupHelper
									.createLabel("Navigation to CONTACT US page is NOT successful", ExtentColor.RED));
							screenshotPath = getScreenshot(driver, this.getClass().getName());
							test.get().info("Details",
									MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
						}
					}
				}
			} else {
				test.get().log(Status.FAIL, MarkupHelper.createLabel(
						"**Didn't find what you're looking for? Submit a General Inquiry or Contact Us** text is NOT displayed",
						ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}

		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("KNOWLEDGE BASE widget is NOT visible in the search page", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	@FindBy(xpath = "//*[contains(@id,'typeahead') and @role='option']//*[@class='ng-binding']")
	public List<WebElement> residualForms;

	public void residualsSearch_form(String form) throws InterruptedException, IOException {
		String ResidualForms = "Residuals: New Hire Request,Residuals: SSN Correction Request,Residuals: Beneficiary Request,Residuals: Update a Corporation Name/FEIN Request,Residuals: Name Change Request,Residuals: Dissolve a Corporation,Residuals: Stop/Cancel Payment Request";
		int NumberOfForms = 7;

		test.get().log(Status.INFO, MarkupHelper.createLabel("**Searching for a Residual Form.**", ExtentColor.ORANGE));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, portal_ask_a_question_search);
		portal_ask_a_question_search.sendKeys(form);
		checkForPageLoad(driver);
		test.get().log(Status.INFO, MarkupHelper.createLabel("Searching for the form in searchbox.", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		List<String> List = Arrays.asList(ResidualForms.split(","));
		System.out.println("List Size - " + residualForms.size());
		int matchedCount = 0;

		checkForPageLoad(driver);
		if (residualForms.size() >= NumberOfForms) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Searching for the form in searchbox.", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			checkForPageLoad(driver);
			for (int i = 0; i < residualForms.size(); i++) {
				int count = 0;
				for (int j = 0; j < List.size(); j++) {
					waitForAction(driver);
					waitForElement(driver, residualForms.get(i));
					if (residualForms.get(i).getText().trim().equalsIgnoreCase(List.get(j).trim())) {
						test.get().log(Status.PASS,
								MarkupHelper.createLabel(
										residualForms.get(i).getText() + " is present under the list of forms",
										ExtentColor.GREEN));
						logSuccess("Expected Value - " + List.get(j).trim());
						logSuccess("Actual Value - " + residualForms.get(i).getText());
						System.out.println(residualForms.get(i).getText() + " is present under the list of forms");
						System.out.println("Expected Value - " + List.get(j).trim());
						System.out.println("Actual Value - " + residualForms.get(i).getText());
						screenshotPath = getScreenshot(driver, this.getClass().getName());
						test.get().info("Details",
								MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
						count++;
						matchedCount++;
					}
				}
				if (count == 0 && matchedCount != NumberOfForms) {
					test.get().log(Status.FAIL,
							MarkupHelper.createLabel(
									residualForms.get(i).getText() + " is NOT present under the list of forms",
									ExtentColor.RED));
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				}
			}
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Search results doesn't return required forms.", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		xpheader.click();
		portal_ask_a_question_search.sendKeys(Keys.ENTER);
		test.get().log(Status.PASS, MarkupHelper.createLabel("Search for " + form + " is complete", ExtentColor.GREEN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	}

	public void portal_responsiveness(String form) throws InterruptedException, AWTException, IOException {
		checkForPageLoad(driver);
		pageZoomIn();
		checkForPageLoad(driver);
		search_form(form);
		checkForPageLoad(driver);
		pageZoomOut();
		checkForPageLoad(driver);
		navigate_form(form);
		checkForPageLoad(driver);
		pageZoomIn();
		checkForPageLoad(driver);
		driver.navigate().back();
		driver.navigate().back();
		pageZoomOut();
	}

	public void pageZoomIn() throws AWTException, IOException {
		waitForPageLoad(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='200%'");
		test.get().log(Status.INFO, MarkupHelper.createLabel("PAGE Zoom IN.", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	}

	public void pageZoomOut() throws AWTException, IOException {
		checkForPageLoad(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='100%'");
		test.get().log(Status.INFO, MarkupHelper.createLabel("PAGE Zoom OUT.", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	}

}