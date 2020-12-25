package com.snow.pageobjects;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

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
import com.snow.exceptions.InvalidCredentialException;

public class KnowledgeCreationPage extends ReusableLibrary {
	public WebDriver driver;

	public KnowledgeCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "filter")
	public WebElement navigationfilter;

	@FindBy(xpath = ".//*[@id='0878652cc0a801640001ff83e2bfbfe7']/div/div")
	public WebElement link_Knowledge;

	@FindBy(xpath = "//div[contains(text(),'Create New Article')]")
	public WebElement create_new_article;

	@FindBy(xpath = "//div[contains(text(),'Retired Articles')]")
	public WebElement retiredArticle;

	@FindBy(xpath = "//button[contains(.,'Create an Article')]")
	public WebElement btn_create_article;

	@FindBy(xpath = "//div[contains(text(),'All Articles')]")
	public WebElement all_article;

	@FindBy(xpath = "(//*[@id='hdr_kb_knowledge']/th[2]/div/button)[1]")
	public WebElement kbKnowledgeSearch;

	@FindBy(xpath = "//table[@id='kb_knowledge_table']//input[@id='kb_knowledge_table_header_search_control']")
	public WebElement kb_list_view_search;

	@FindBy(xpath = "(//*[@id='kb_feedback_table_header_search_control'])[1]")
	public WebElement suggestionArticleSearch;

	@FindBy(xpath = "(//button[contains(@class, 'list_header_search_toggle icon-search btn btn-icon table-btn-lg')])[1]")
	public WebElement suggestionArticleSearchIcon;

	@FindBy(xpath = "//table[@id='kb_knowledge_table']//*[contains(@aria-label, 'created by')]")
	public WebElement createdBy;

	@FindBy(xpath = "(//a[@class='linked formlink'])[1]")
	public WebElement kb_link_number;

	@FindBy(xpath = "(//a[@class='linked'])[1]")
	public WebElement kb_link_number_suggestion;

	@FindBy(xpath = "//*[@class='list2_no_records']")
	public WebElement noRecords;

	@FindBy(xpath = "//input[@id='sys_readonly.kb_knowledge.number']")
	public WebElement form_kb_number;

	@FindBy(xpath = "//nav[contains(@class,'ng-scope')]//div[@class='container-fluid']")
	public WebElement header_context_menu;

	@FindBy(xpath = "//div[contains(text(),'Save')]")
	public WebElement context_option_save;

	@FindBy(xpath = ".//*[@id='kb_knowledge.short_description']")
	public WebElement txt_shortdesc;

	@FindBy(xpath = ".//*[@id='sys_display.kb_knowledge.kb_knowledge_base']")
	public WebElement ref_Know_base;

	@FindBy(xpath = ".//*[@id='ac_option_bb0370019f22120047a2d126c42e7073']/span")
	public WebElement select_know_base;

	@FindBy(xpath = ".//*[@id='sys_display.kb_knowledge.kb_category']")
	public WebElement ref_category;

	@FindBy(xpath = ".//*[@id='ac_option_939e48ea3706d7002fc0c7d1b3990efe']/td[2]")
	public WebElement select_category;

	@FindBy(xpath = ".//*[@id='kb_knowledge.can_read_user_criteria_unlock']")
	public WebElement click_can_read;

	@FindBy(xpath = ".//*[@id='sys_display.kb_knowledge.can_read_user_criteria']")
	public WebElement txt_canread;

	@FindBy(xpath = ".//*[@id='kb_knowledge.can_read_user_criteria_lock']")
	public WebElement select_canread;

	@FindBy(xpath = "//iframe[@id='kb_knowledge.text_ifr' and contains(title, 'Text')]")
	public WebElement txt_iframe;

	@FindBy(xpath = "//button[@id='sysverb_insert']")
	public WebElement btn_submit;

	@FindBy(xpath = ".//*[@id='c09f1ed2ff4131009b20ffffffffff56']/div/div")
	public WebElement myKnowlede_lnk;

	@FindBy(xpath = "//table/tbody/tr/td/div/table/tbody/tr/td[3]/a")
	public WebElement click_KB_number;

	@FindBy(xpath = ".//*[@id='kb_knowledge_table']/thead/tr[2]/td[4]/div/div/div/input")
	public WebElement get_KB_Sd;

	// @FindBy(xpath = "//button[contains(.,'Request for Approval')]")
	@FindBy(xpath = "//*[@id='request_for_approval']")
	public WebElement btn_Request_for_Approval;

	@FindBy(xpath = "//*[@id = 'window.glide_confirm_standard']")
	public WebElement confirmDialogueBox;

	@FindBy(xpath = "//*[@id = 'ok_button']")
	public WebElement btn_Ok;

	// @FindBy(xpath = "//button[contains(.,'Checkout')]")
	@FindBy(xpath = "//*[@id='hrsm_knowledge']")
	public WebElement btn_checkout;

	@FindBy(xpath = "//button[contains(.,'Retire')]")
	public WebElement btn_Retire;

	@FindBy(xpath = ".//*[@id='tabs2_list']/span[4]/span/span[2]")
	public WebElement approvals_tab;

	@FindBy(xpath = "//table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a")
	public WebElement link_Approval;

	@FindBy(xpath = ".//*[@id='kb_knowledge.description']")
	public WebElement txt_Desc;

	@FindBy(xpath = ".//*[@id='hr_comment']")
	public WebElement retire_comment;

	@FindBy(xpath = ".//*[@id='approve']")
	public WebElement btn_Approve;

	@FindBy(xpath = ".//*[@id='reject']")
	public WebElement btn_reject;

	@FindBy(xpath = ".//*[@id='ok_button']")
	public WebElement btn_OK;

	@FindBy(xpath = ".//*[@id='label.ni.kb_knowledge.direct']")
	public WebElement chk_Attachments;

	@FindBy(xpath = ".//*[@id='activity-stream-textarea']")
	public WebElement txt_Comments;

	@FindBy(xpath = "//span[contains(text(),'Active')]")
	public WebElement active;

	@FindBy(xpath = "//*[@id='element.kb_knowledge.active']")
	public WebElement activeField;

	@FindBy(xpath = "//label[@id='label.ni.kb_knowledge.active']")
	public WebElement ckb_Active;

	@FindBy(xpath = "//div[@class='outputmsg outputmsg_error notification notification-error']")
	public WebElement err_msg;

	@FindBy(xpath = "//span[@class='navbar_ui_actions']//button[@id='sysverb_delete']")
	public WebElement btn_delete;

	@FindBy(xpath = "//button[@id='ok_button']")
	public WebElement btn_accept_delete;

	@FindBy(xpath = "//*[@id='cancel_button']")
	public WebElement btn_reject_delete;

	@FindBy(xpath = "//*[@id='knowledge_delete_confirm_form_closemodal']")
	public WebElement btn_x_close;

	@FindBy(xpath = "//a[@id='cb1ad7720a0a3c1901fdabc99f970748']")
	public WebElement link_viewarticle;

	@FindBy(xpath = "//*[@id='flagArticle']")
	public WebElement btn_flagarticle;

	@FindBy(xpath = "//*[@id='suggestText']")
	public WebElement text_suggesttext;

	@FindBy(xpath = "//*[@id='suggestChange' and @class = 'button']")
	public WebElement btn_suggest_submit;

	@FindBy(xpath = "//div[@id='articleNumberReadonly']")
	public WebElement kb_id;

	@FindBy(xpath = "//*[@id='tabs2_list']/span[2]/span")
	public WebElement tab_kb_feedback;

	@FindBy(xpath = "(//a[@class='linked formlink'])[1]")
	public WebElement tab_kb_comment;

	@FindBy(xpath = "//*[@id='user_info_dropdown']")
	public WebElement userInfoDropdown;

	@FindBy(xpath = "//select[contains(@id,'_select') and contains(@class, 'form-control d')]")
	public WebElement searchDropDown;

	@FindBy(xpath = "//input[contains(@id,'_text') and @class = 'form-control']")
	public WebElement searchBox;

	@FindBy(xpath = "//div[text()='All Articles']")
	public WebElement allArticles;

	@FindBy(xpath = "//button[contains(.,'Publish')]")
	public WebElement publish;

	@FindBy(xpath = "//*[@id='backButton']")
	public WebElement backButton;

	@FindBy(xpath = "//*[@id='articleText']")
	public WebElement flaggedText;

	@FindBy(xpath = "//*[@id='user_info_dropdown']/div/span[1]")
	public WebElement userMenu;

	@FindBy(xpath = "//*[@id='status.kb_knowledge.kb_knowledge_base']")
	public WebElement mandatoryIndicatorKB;

	@FindBy(xpath = "//*[@id='sys_display.kb_knowledge.kb_knowledge_base']")
	public WebElement mandatoryKBDesc;

	@FindBy(xpath = "//*[@id='status.kb_knowledge.kb_category']")
	public WebElement mandatoryIndicatorCategory;

	@FindBy(xpath = "//*[@id='status.kb_knowledge.can_read_user_criteria']")
	public WebElement mandatoryIndicatorCanRead;

	@FindBy(xpath = "//*[@id='status.kb_knowledge.short_description']")
	public WebElement mandatoryIndicatorShortDesc;

	@FindBy(xpath = "//*[@id='status.kb_knowledge.text']")
	public WebElement mandatoryIndicatorArticleBody;

	@FindBy(xpath = "//*[@id='status.kb_knowledge.valid_to']")
	public WebElement mandatoryIndicatorValidTo;

	@FindBy(xpath = "//*[@id='kb_knowledge.valid_to']")
	public WebElement validTo;

	@FindBy(xpath = "//*[@id='kb_knowledge.valid_to.ui_policy_sensitive']")
	public WebElement validToCalendar;

	@FindBy(xpath = "//*[@role = 'button' and contains(@aria-label, 'Today')]")
	public WebElement goToToday;

	@FindBy(xpath = "//*[contains(@id, '_month_next')]")
	public WebElement nextMonthButton;

	@FindBy(xpath = "//*[contains(@id, 'DateTimePicker_day17')]")
	public WebElement pickAnyDate;

	@FindBy(xpath = "//*[contains(@id,'sys_read') and contains(@id,'valid_to')]")
	public WebElement validToExp;

	@FindBy(xpath = "//*[@id='sys_display.kb_knowledge.author']")
	public WebElement author;

	@FindBy(id = "tinymce")
	public WebElement articleBody;

	@FindBy(xpath = "//*[@id='close-messages-btn']")
	public WebElement closeError;

	@FindBy(xpath = "//*[@class='label-text' and contains(text(), 'Knowledge')]")
	public WebElement knowlwdgeBaseField;

	@FindBy(xpath = "//*[@id='section-1f1a5586c0a8016b00a4b78b75cbd3f2.header']/nav/div/div[1]/h1/span/span")
	public WebElement version;

	@FindBy(xpath = "//*[@id='kb_knowledge_table']/tbody/tr/td/a[@aria-label = 'Open record: 1.0']")
	public WebElement versionlink;

	@FindBy(xpath = "//*[@id='ad4d5bfb37be53402fc0c7d1b3990e87']")
	public WebElement requestApprovalLink;

	@FindBy(xpath = "//*[starts-with(@id,'b9169d55873212001ac119fa')]")
	public WebElement dashboard;

	@FindBy(xpath = "//button[@ng-click='switchToAllTab()']")
	public WebElement allTab;

	@FindBy(xpath = "//a[contains(@aria-label, 'HR Knowledge Dashboard')]")
	public WebElement hrDashboard;

	@FindBy(xpath = "//*[@id='5bcebf474f61230069afe5201310c788']")
	public WebElement widgetPendingArticle;

	@FindBy(xpath = "//*[@id='3bdb68a74fed230069afe5201310c767']")
	public WebElement widgetPublishedArticle;

	@FindBy(xpath = "//*[@id='cfdc24e74fed230069afe5201310c72e']")
	public WebElement widgetArticleToAction;

	@FindBy(xpath = "//*[@id='450130ab4fed230069afe5201310c7a8']")
	public WebElement widgetArticleNearExpiration;

	@FindBy(xpath = "//*[@id='tabs2_list']/span[4]/span")
	public WebElement approvalTab;

	@FindBy(xpath = "//*[contains(@id, 'kb_knowledge.REL:8e1ddaa3c30321000096dfdc64d3aebd_hide_search')]/descendant::select[contains(@id, 'select') and contains(@class, 'form-control')]")
	public WebElement approvalStateDropDown;

	@FindBy(xpath = "//*[contains(@id, 'kb_knowledge.REL:8e1ddaa3c30321000096dfdc64d3aebd_hide_search')]/descendant::input[contains(@id, '_text') and contains(@class, 'form-control')]")
	public WebElement approvalTextBox;

	@FindBy(xpath = "//*[contains(@type,'search') and contains(@aria-label,'approver')]")
	public WebElement approverSearch;

	@FindBy(xpath = "//*[contains(@class,'list_header_search_toggle icon-search btn btn-icon table-btn-lg')and contains(@aria-controls,'kb_knowledge.REL:8e1ddaa3c30321000096dfdc64d3aebd_table_header_search_control')]")
	public WebElement approvalSearch;

	@FindBy(xpath = "//*[contains(@class,'linked formlink') and contains(@href,'approver') and contains(text(),'Requested')]")
	public WebElement requestedLink;

	@FindBy(xpath = "//*[contains(@class,'linked formlink') and contains(@href,'approver') and contains(text(),'Rejected')]")
	public WebElement rejectedLink;

	@FindBy(xpath = "//*[@id='activity-stream-textarea']")
	public WebElement rejectComment;

	@FindBy(xpath = "//*[@id='output_messages']")
	public WebElement rejectSuccess;

	@FindBy(xpath = "//*[@id='output_messages']/div/div[1]")
	public WebElement rejectErrorMessage;

	@FindBy(xpath = "//*[@id='sys_readonly.sysapproval_approver.state']")
	public WebElement approverState;

	@FindBy(xpath = "//*[contains(@class, 'btn btn-default icon-chevron-left navbar-btn')]")
	public WebElement backToKA;

	@FindBy(xpath = "//*[@id='sys_readonly.kb_knowledge.workflow_state']")
	public WebElement workFlow;

	@FindBy(xpath = "//*[@id='fa5330019f22120047a2d126c42e70df']")
	public WebElement hrKnowledgeBase;

	@FindBy(xpath = "//*[@id='kb_keywords']")
	public WebElement hrKnowledgeBaseSearch;

	@FindBy(id = "impBtn")
	public WebElement importArticleButton;

	@FindBy(xpath = "//*[@id='modal_import_pane']/div/div[@class='modal-content']")
	public WebElement importDialogueBox;

	@FindBy(xpath = "(//*[@id='s2id_knowledgebase']/a/span)[1]")
	public WebElement knowledgeBase;

	@FindBy(xpath = "(//*[@id='s2id_category']/a/span)[1]")
	public WebElement category;

	@FindBy(xpath = "//*[contains(text(),'Search Results')]")
	public WebElement searchResults;

	@FindBy(xpath = "//*[@class='kb_link ng-binding ng-scope'][1]")
	public WebElement hrKBSearchResults;

	@FindBy(xpath = "//*[@id='articleNumberReadonly']")
	public WebElement verifyKBID;

	@FindBy(xpath = "//*[@id='3de232209f22120047a2d126c42e70bb']")
	public WebElement hrServicePortal;

	@FindBy(xpath = "//*[@id='5ba2d8234fad230069afe5201310c74f']")
	public WebElement widgetMyPublishedArticle;

	@FindBy(xpath = "//span[contains(text(), 'HRSM Article Suggestions')]")
	public WebElement widgetArticleSuggestionHeading;

	@FindBy(xpath = "//*[@id='4312b8ab4fed230069afe5201310c725']")
	public WebElement widgetArticleSuggestion;

	@FindBy(xpath = "//*[@id='kb_knowledge.author_label']")
	public WebElement validateAuthor;

	@FindBy(xpath = "(//*[contains(@name,'sys_created_on') and contains(@glide_label,'Created')])[1]")
	public WebElement createdOn;

	@FindBy(xpath = "(//*[contains(@class, 'sort-icon-padding list-column-icon icon-vcr-up')])[1]")
	public WebElement ascOrder;

	@FindBy(xpath = "(//*[contains(@id, 'filterimg')])[1]")
	public WebElement expand;

	@FindBy(xpath = "(//ol)[1]")
	public WebElement workFlowList;

	@FindBy(xpath = "//*[contains(@id, 'row_kb_knowledge.kb_feedback.article')]")
	public WebElement knowledgeFeedback;

	@FindBy(xpath = "(//*[contains(@class,'icon-cog') and contains(@class, ' btn btn-icon table-btn-lg')])[1]")
	public WebElement gearIcon;

	@FindBy(xpath = "//*[@id='list_mechanic_title']")
	public WebElement columnOrderHeader;

	@FindBy(xpath = "//*[@id='slush_right']/option")
	public WebElement columnOrderList;

	@FindBy(xpath = "//*[@onclick='slush.moveUp();']")
	public WebElement moveUp;

	@FindBy(xpath = "//*[@onclick='slush.moveDown();']")
	public WebElement moveDown;

	public String user = null;
	public String approverUser = null;
	public String[] versionName = null;
	public String versionNameString = null;
	public double versionNumber;
	public double expectedVersionNumber = 0.01;
	public double expectedWholeVersionNumber = 0.0;

	/*
	 * This method is for validating the successful login to the SNOW by verifying
	 * existence of User Menu
	 */
	public String loginValidate() throws IOException, InvalidCredentialException {
		PageFactory.initElements(driver, KnowledgeCreationPage.class);
		checkForPageLoad(driver);
		driver.get(homePageURL);
		waitForAction(driver);
		waitForElementToBeClickable(driver, userMenu);
		try {
			System.out.println("Successfully Logged In to the application as " + userMenu.getText().trim());
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Successfully Logged In to the application as " + userMenu.getText().trim(), ExtentColor.GREEN));
			user = userMenu.getText().trim();
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} catch (Exception e) {
			throw new InvalidCredentialException(
					"Login Failed. Please verify, your credentials or privileges to the user");
		}
		return user;
	}

	/*
	 * This is method is to navigate to Create Knowledge Article Page and validates
	 * the navigation for the same
	 */
	public void navigateToCreateArticle(String navigationFilter) throws IOException, InterruptedException {
		PageFactory.initElements(driver, KnowledgeCreationPage.class);
		driver.navigate().refresh();
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, navigationfilter);
		navigationfilter.click();
		navigationfilter.sendKeys(navigationFilter);

		waitForElementToBeClickable(driver, create_new_article);
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		execute.executeScript("arguments[0].click();", create_new_article);

		/*
		 * JavascriptExecutor jsExecutor = (JavascriptExecutor) driver; String
		 * currentFrame = (String) jsExecutor.executeScript("return self.name");
		 * System.out.println("Current Frame - " + currentFrame);
		 * 
		 * waitForFrameToBeAvailable(driver, currentFrame);
		 */
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, knowlwdgeBaseField);

		if (isElementPresent(knowlwdgeBaseField)) {
			System.out.println("Navigated to Create Article Page");
			test.get().log(Status.INFO, MarkupHelper.createLabel("Navigated to Create Article Page", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			System.out.println("Navigation to Create Article Page Failed");
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Navigation to Create Article Page Failed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	/*
	 * This method is for validating the Mandatory Fields on the Create New Article
	 * Page
	 */
	public String kbArticleFieldValidation(String navigationFilter, String category, String readPermission,
			String shortDesc, String articleDesc) throws AWTException, IOException, InterruptedException {
		PageFactory.initElements(driver, KnowledgeCreationPage.class);
		navigateToCreateArticle(navigationFilter);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, mandatoryIndicatorKB);

		// Mandatory, Knowledge Base Field is validated here.
		if (isElementPresent(mandatoryIndicatorKB)) {
			System.out.println(
					"Knowledge Base is Mandatory and displayed value is: " + mandatoryKBDesc.getAttribute("value"));
			if (mandatoryKBDesc.getAttribute("value").equals("Human Resources General Knowledge")) {
				test.get().log(Status.PASS, MarkupHelper.createLabel(
						"Knowledge Base is Mandatory and displayed value is: " + mandatoryKBDesc.getAttribute("value"),
						ExtentColor.GREEN));
				logSuccess("Expected Value - " + "Human Resources General Knowledge");
				logSuccess("Actual Value - " + mandatoryKBDesc.getAttribute("value"));
			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("Knowledge Base is Mandatory but displayed with value : "
								+ mandatoryKBDesc.getAttribute("value"), ExtentColor.RED));
				logFailure("Expected Value - " + "Human Resources General Knowledge");
				logFailure("Actual Value - " + mandatoryKBDesc.getAttribute("value"));
			}
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Knowledge Base is not displayed as Mandatory", ExtentColor.RED));
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"Knowledge Base is displayed with value : " + mandatoryKBDesc.getAttribute("value"),
							ExtentColor.RED));
		}

		/* Active Field validation. Active Field is displayed for Gov user only */
		System.out.println("User name displayed in System " + user);
		System.out.println("User name from Configuration file after split " + kbGovernanceUser.split(" ")[0]);
		if (kbGovernanceUser.contains(user.split(" ")[0]) && activeField.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Active Field is displayed for user: " + user, ExtentColor.GREEN));
		} else if (kbSmeUser.contains(user.split(" ")[0]) && !activeField.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Active Field is not displayed for user: " + user, ExtentColor.GREEN));
		} else if (!kbGovernanceUser.contains(user.split(" ")[0]) && activeField.isDisplayed()) {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Active Field is displayed for user: " + user, ExtentColor.RED));
		}

		/*
		 * Mandatory, Valid To date Field is validated here. Valid to Date Field is
		 * defaulted to two years from Current Date.
		 */
		if (mandatoryIndicatorValidTo.isDisplayed()) {
			System.out.println("Valid To is Mandatory and displayed value is: " + validTo.getAttribute("value"));
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String currentDate = simpleDateFormat.format(new Date());

			LocalDate date1 = LocalDate.parse(currentDate, dateTimeFormatter);
			LocalDate date2 = LocalDate.parse(validTo.getAttribute("value"), dateTimeFormatter);

			long years = ChronoUnit.YEARS.between(date1, date2);
			System.out.println("Difference in Years: " + years);

			if (years == 2) {
				test.get().log(Status.PASS, MarkupHelper.createLabel(
						"Valid To Date Field is defaulted to two years from today: " + validTo.getAttribute("value"),
						ExtentColor.GREEN));
			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("Valid To Date Field is not defaulted to two years from today: "
								+ validTo.getAttribute("value"), ExtentColor.RED));
			}
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Valid To Date Field is not displayed as Mandatory", ExtentColor.RED));
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Valid To Date Field is displayed with date : " + validTo.getAttribute("value"), ExtentColor.RED));
		}

		/*
		 * Validating below is correct: Category field is Mandatory, Author is defaulted
		 * to the logged in user, Can Read field is Mandatory, Short Description field
		 * is Mandatory, Article Body field is Mandatory, Check the "Attachment Link" to
		 * confirm that "Article Body" field is no longer mandatory (Uncheck after
		 * validation)
		 */

		// Category
		if (mandatoryIndicatorCategory.isDisplayed()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Category Field is displayed as Mandatory", ExtentColor.CYAN));
			ref_category.sendKeys(category);
			System.out.println("Category set with value: " + category);
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Category Field value id set to: " + category, ExtentColor.CYAN));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Category Field is NOT displayed as Mandatory", ExtentColor.RED));
		}

		// Author
		if (author.isDisplayed()) {
			test.get().log(Status.INFO, MarkupHelper.createLabel("Author Field is displayed", ExtentColor.CYAN));
			if (author.getAttribute("value").equals(user)) {
				test.get().log(Status.PASS,
						MarkupHelper.createLabel(
								"Author is defaulted to the logged in user: " + author.getAttribute("value"),
								ExtentColor.GREEN));
				logSuccess("Expected Value - " + user);
				logSuccess("Actual Value - " + author.getAttribute("value"));
			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel(
								"Author does not match to the logged in user: " + author.getAttribute("value"),
								ExtentColor.RED));
				logFailure("Expected Value - " + user);
				logFailure("Actual Value - " + author.getAttribute("value"));
			}
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Author Field is NOT displayed", ExtentColor.RED));
		}

		// Can Read
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		if (mandatoryIndicatorCanRead.isDisplayed()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Can Read Field is displayed as Mandatory", ExtentColor.CYAN));
			execute.executeScript("arguments[0].click();", click_can_read);
			txt_canread.sendKeys(readPermission);
			System.out.println("Can Read set with value: " + readPermission);
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Can Read Field value id set to: " + readPermission, ExtentColor.CYAN));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Can Read Field is NOT displayed as Mandatory", ExtentColor.RED));
		}

		// Short Description
		if (mandatoryIndicatorShortDesc.isDisplayed()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Short Description Field is displayed as Mandatory", ExtentColor.CYAN));
			txt_shortdesc.sendKeys(shortDesc);
			System.out.println("Short Description set with value: " + shortDesc);
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("Short Description Field value id set to: " + shortDesc, ExtentColor.CYAN));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Short Description Field is NOT displayed as Mandatory", ExtentColor.RED));
		}

		// Article Body
		if (!chk_Attachments.isSelected()) {
			if (isElementPresent(mandatoryIndicatorArticleBody)) {
				test.get().log(Status.INFO,
						MarkupHelper.createLabel("Article Body Field is displayed as Mandatory", ExtentColor.CYAN));

//				scrollPageDown(driver);
//				driver.switchTo().frame("kb_knowledge.text_ifr");
//				waitForFrameToBeAvailable(driver, "kb_knowledge.text_ifr");
//				
//				waitForElementToBeClickable(driver, articleBody);
//				articleBody.sendKeys(articleDesc);

				scrollPageDown(driver);
				driver.switchTo().frame("kb_knowledge.text_ifr");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].textContent='" + articleDesc + "';", articleBody);
				System.out.println("Article Body set with value: " + articleDesc);
				test.get().log(Status.INFO, MarkupHelper
						.createLabel("Article Body Field value id set to: " + articleDesc, ExtentColor.CYAN));
			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("Article Body Field is NOT displayed as Mandatory", ExtentColor.RED));
			}
		}

		/*
		 * Validating that "Article Body" field is no longer mandatory after the
		 * "Attachment Link" is checked
		 */
		driver.switchTo().defaultContent();
		String actualErr = "";
		waitForFrameToBeAvailable(driver, "gsft_main");

		if (isElementPresent(btn_submit)) {
			waitForElementToBeClickable(driver, btn_submit);
			btn_submit.click();
			actualErr = err_msg.getText().trim();
			System.out.println("Actual Error - " + actualErr);
		} else {
			driver.switchTo().defaultContent();
			waitForFrameToBeAvailable(driver, "gsft_main");
			waitForElementToBeClickable(driver, btn_submit);
			btn_submit.click();
		}
		/*
		 * if (!chk_Attachments.isSelected()) { chk_Attachments.click(); if
		 * (!mandatoryIndicatorArticleBody.isDisplayed()) { test.get().log(Status.INFO,
		 * MarkupHelper.createLabel(
		 * "Article Body Field is no longer Mandatory after Attachment Link Chechbox is checked"
		 * , ExtentColor.CYAN));
		 * System.out.println("Article Body Field is no longer Mandatory");
		 * screenshotPath = getScreenshot(driver, this.getClass().getName());
		 * test.get().info("Details",
		 * MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); }
		 * else { test.get().log(Status.FAIL,
		 * MarkupHelper.createLabel("Article Body Field is NOT displayed as Mandatory",
		 * ExtentColor.RED)); } }
		 * 
		 * chk_Attachments.click();
		 */
		try {
			actualErr = err_msg.getText().trim();
			System.out.println("Actual Error - " + actualErr);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (isElementPresent(closeError) || isElementPresent(err_msg) && !actualErr.isEmpty()) {
			// actualErr = err_msg.getText().trim();
			System.out.println("Actual Error - " + actualErr);
			waitForAction(driver);

			int i = 0;
			while (actualErr.isEmpty()) {
				i++;
				btn_submit.click();
				waitForAction(driver);
				actualErr = err_msg.getText().trim();
				System.out.println("Actual Error in attempt " + i + " - " + actualErr);
			}

			test.get().log(Status.INFO,
					MarkupHelper.createLabel(
							"Error is received when clicked on Submit button without entering Mandatory Values",
							ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			// actualErr = err_msg.getText().trim();
			System.out.println(actualErr);
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"Error is NOT received when clicked on Submit button without entering Mandatory Values",
							ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		waitForElementToBeClickable(driver, closeError);
		if (isElementPresent(closeError)) {
			try {
				closeError.click();
			} catch (Exception e) {
				System.out.println(
						e.getMessage().getClass() + "Exception received while clicking on Close Error button.");
			}

		}

		return actualErr;
	}

	/* This method is to Create a New Knowledge Article */
	public String createNewArticle(String navigationFilter, String category, String readPermission, String shortDesc,
			String articleDesc, String smeUser) throws Exception {
		String kbID;
		PageFactory.initElements(driver, KnowledgeCreationPage.class);
		navigateToCreateArticle(navigationFilter);

		// Entering data in Valid To field
		/*
		 * if (!(validToDate.isEmpty())) { validTo.clear();
		 * validTo.sendKeys(validToDate); }
		 */
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, validToCalendar);
		if (isElementPresent(validToCalendar)) {
			waitForElementToBeClickable(driver, validToCalendar);
			validToCalendar.click();
			waitForElementToBeClickable(driver, goToToday);
			if (isElementPresent(goToToday)) {
				goToToday.click();
			} else {
				validToCalendar.click();
				waitForElementToBeClickable(driver, goToToday);
				goToToday.click();
			}
			waitForElementToBeClickable(driver, validToCalendar);
			validToCalendar.click();
			waitForElementToBeClickable(driver, nextMonthButton);
			if (isElementPresent(nextMonthButton)) {
				nextMonthButton.click();
			} else {
				validToCalendar.click();
				waitForElementToBeClickable(driver, nextMonthButton);
				nextMonthButton.click();
			}
			waitForElementToBeClickable(driver, pickAnyDate);
			pickAnyDate.click();
			waitForAction(driver);
			logInfo("Valid To field is set with valid Date");
			System.out.println("Valid To Date is - " + validTo.getText().trim());
		} else {
			logFailure("Calendar Icon is not displayed for Valid To Date field");
			logFailureScreenshot(driver);
		}

		// Entering the data for all the Mandatory Fields.
		// Actions actions = new Actions(driver);
		waitForElementToBeClickable(driver, ref_category);
		ref_category.click();
		waitForAction(driver);
		// actions.sendKeys(ref_category, category);
		ref_category.sendKeys(category);
		System.out.println("Category set with value: " + category);
		test.get().log(Status.INFO, MarkupHelper.createLabel("Category set with value: " + category, ExtentColor.CYAN));

		waitForElementToBeClickable(driver, click_can_read);
		waitForAction(driver);
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		execute.executeScript("arguments[0].click();", click_can_read);
		waitForAction(driver);
		if (click_can_read.isDisplayed() && click_can_read.isEnabled()) {
			click_can_read.click();
		}
		waitForElementToBeClickable(driver, txt_canread);
		txt_canread.click();
		waitForAction(driver);
		// actions.sendKeys(txt_canread, readPermission);
		txt_canread.sendKeys(readPermission);
		waitForAction(driver);
		System.out.println("Read Permission granted to: " + readPermission);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Read Permission granted to: " + readPermission, ExtentColor.CYAN));

		waitForElementToBeClickable(driver, txt_shortdesc);
		waitForAction(driver);
		txt_shortdesc.click();
		waitForAction(driver);
		// actions.sendKeys(txt_shortdesc, shortDesc);
		txt_shortdesc.sendKeys(shortDesc);

		waitForAction(driver);
		txt_shortdesc.sendKeys(Keys.TAB);
		System.out.println("Short Description Set to: " + shortDesc);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Short Description Set to: " + shortDesc, ExtentColor.CYAN));

		/*
		 * If Article Body is null in input excel, click on Attachment Link checkbox,
		 * else fill the Article Body description in field.
		 */

		if (articleBody == null) {
			if (!chk_Attachments.isSelected()) {
				chk_Attachments.click();

				test.get().log(Status.INFO,
						MarkupHelper.createLabel("Attachment Link Checkbox checked", ExtentColor.CYAN));
				System.out.println("Attachment Link Checkbox checked");
			}
		} else {

			driver.switchTo().frame("kb_knowledge.text_ifr");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].textContent='HR KB Automation Execution';", articleBody);
//			articleBody.sendKeys(articleDesc);
			System.out.println("Article Body set with value: " + articleDesc);
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Article Body Field value id set to: " + articleDesc, ExtentColor.CYAN));
			driver.switchTo().defaultContent();
			waitForFrameToBeAvailable(driver, "gsft_main");
		}

		System.out.println("Data is entered for all the Mandatory Fields");
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Data is entered for all the Mandatory Fields", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		/*
		 * waitForElementToBeClickable(driver, form_kb_number); kbID =
		 * form_kb_number.getAttribute("value").trim();
		 * System.out.println("Knowledge Article is created with ID: " + kbID);
		 * test.get().log(Status.INFO,
		 * MarkupHelper.createLabel("Knowledge Article Number: " + kbID,
		 * ExtentColor.CYAN));
		 */
		System.out.println("Article Created Submitted");
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Knowledge Article Submitted Successfully for approval", ExtentColor.CYAN));
		// btn_submit.click();
		Actions action = new Actions(driver).contextClick(header_context_menu);
		action.build().perform();
		execute.executeScript("arguments[0].click();", context_option_save);

//		execute.executeScript("arguments[0].click();", btn_submit);
		checkForPageLoad(driver);

		waitForElementToBeClickable(driver, form_kb_number);
		kbID = form_kb_number.getAttribute("value");

		System.out.println("Knowledge Article is created with ID: " + kbID);
		test.get().log(Status.INFO, MarkupHelper.createLabel("Knowledge Article Number: " + kbID, ExtentColor.CYAN));

		driver.switchTo().defaultContent();
		waitForElementToBeClickable(driver, navigationfilter);
		navigationfilter.click();
		navigationfilter.clear();
		navigationfilter.sendKeys("all article");

		waitForElementToBeClickable(driver, all_article);
		// JavascriptExecutor execute = (JavascriptExecutor) driver;
		execute.executeScript("arguments[0].click();", all_article);

		// Navigate to submitted Knowledge Article
		/*
		 * if (!isElementPresent(kb_list_view_search)) { kbKnowledgeSearch.click(); }
		 */
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForAction(driver);
		waitForElementToBeClickable(driver, searchDropDown);
		Select select = new Select(searchDropDown);
		select.selectByVisibleText("Number");
		searchBox.sendKeys(kbID);
		searchBox.sendKeys(Keys.ENTER);
		waitForAction(driver);

		/*
		 * kb_list_view_search.clear(); kb_list_view_search.sendKeys(kbID);
		 */
		waitForFrameToBeAvailable(driver, "gsft_main");
		scrollToElement(driver, createdBy);
		waitForElementToBeClickable(driver, createdBy);
		createdBy.clear();
		createdBy.sendKeys(smeUser.split(" User")[0]);
		createdBy.sendKeys(Keys.ENTER);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, kb_link_number);
		if (isElementPresent(kb_link_number) && kb_link_number.getText().trim().equals(kbID)) {
			logSuccess("Expected Value - " + kbID);
			logSuccess("Actual Value - " + kb_link_number.getText().trim());
			waitForElementToBeClickable(driver, kb_link_number);
			kb_link_number.click();
		}
		return kbID;
	}

	/* This is method is to Submit the Knowledge Article for Approval */
	public void sendForApproval(String kbID, double minorVersion) throws Exception {
		PageFactory.initElements(driver, KnowledgeCreationPage.class);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, btn_Request_for_Approval);
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		execute.executeScript("arguments[0].click();", btn_Request_for_Approval);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, confirmDialogueBox);

		if (isElementPresent(confirmDialogueBox)) {
			logInfo("Confirm Dialogue Box is displayed to Confirm Valid To Date before 40 Businss Days.");
			logInfoScreenshot(driver);

			waitForElementToBeClickable(driver, btn_OK);
			btn_OK.click();
			Thread.sleep(2000);
			waitForFrameToBeAvailable(driver, "gsft_main");
		}

		// Confirmation for Valid To Date less than 40 days data in Valid To field
		/*
		 * if (!(validToDate.isEmpty())) { btn_OK.click(); }
		 */

		/* Regular expression in Java to check if number is in "0.00" pattern or not */
		Thread.sleep(3000);
		waitForFrameToBeAvailable(driver, "gsft_main");
		Pattern pattern = Pattern.compile("^-?\\d*\\.\\d{2}$");
		versionName = version.getText().trim().split(" v");
		versionNameString = versionName[1];
		versionNumber = Double.parseDouble(versionName[1]);

		System.out.println("Version Number: - " + versionNumber);
		System.out.println("Expected Version Number: - " + expectedVersionNumber);
		System.out.println("Result of Pattern Matcher - " + pattern.matcher(versionNameString).matches());
		System.out.println("Version Text - " + versionName[0].toString());
		System.out.println("KBID Text - " + kbID);

		if (version.getText().trim().contains(kbID) && pattern.matcher(versionNameString).matches()
				&& versionNumber == minorVersion) {
			test.get().log(Status.PASS,
					MarkupHelper
							.createLabel("Article is submitted for Approval successfully and version is displayed as: "
									+ version.getText().trim(), ExtentColor.GREEN));

			logSuccess("Expected Value - " + kbID);
			logSuccess("Actual Value - " + versionName[0]);

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Article submission for Approval Failed and version is displayed as: " + version.getText().trim(),
					ExtentColor.RED));

			logFailure("Expected Value - " + minorVersion);
			logFailure("Actual Value - " + versionNumber);

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	/* This is method is to Reject the Knowledge Article */
	public void rejectArticle(String kbID, String user) throws Exception {
		PageFactory.initElements(driver, KnowledgeCreationPage.class);
		navigateToHrDashboard();
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, widgetPendingArticle);

		if (isElementPresent(widgetPendingArticle)) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Navigated to HR Knowledge Dashboard", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			waitForElementToBeClickable(driver, widgetPendingArticle);
			waitForAction(driver);
			JavascriptExecutor execute = (JavascriptExecutor) driver;
			execute.executeScript("arguments[0].click();", widgetPendingArticle);
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Navigation to HR Knowledge Dashboard Failed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		navigateToArticle(kbID, kbSmeUser);
		waitForFrameToBeAvailable(driver, "gsft_main");
		scrollToElement(driver, approvalTab);
		waitForElementToBeClickable(driver, approvalTab);
		approvalTab.click();

		Select select = new Select(approvalStateDropDown);
		select.selectByVisibleText("Approver");

		approvalTextBox.sendKeys(user);
		approvalTextBox.sendKeys(Keys.ENTER);

		/*
		 * if (!isElementPresent(approverSearch)) { approvalSearch.click(); }
		 */
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, approverSearch);
		approverSearch.sendKeys(user);
		approverSearch.sendKeys(Keys.ENTER);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, requestedLink);
		requestedLink.click();
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, btn_reject);
		if (isElementPresent(btn_reject)) {
			btn_reject.click();
			waitForFrameToBeAvailable(driver, "gsft_main");
			waitForElementToBeClickable(driver, closeError);
			if (closeError.isDisplayed()) {
				test.get().log(Status.INFO,
						MarkupHelper.createLabel(
								"Error Message is displayed when Reject Button is clicked without any comments: "
										+ rejectErrorMessage.getText().trim(),
								ExtentColor.CYAN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel(
								"Error Message is not displayed when Reject Button is clicked without any comments",
								ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}
			closeError.click();
			waitForFrameToBeAvailable(driver, "gsft_main");
			waitForElement(driver, rejectComment);
			rejectComment.sendKeys("Automation Test Reject");
			test.get().log(Status.INFO, MarkupHelper.createLabel(
					"Entered the Comment to Reject the Article: Automation Test Reject", ExtentColor.CYAN));
			btn_reject.click();
			waitForFrameToBeAvailable(driver, "gsft_main");
			waitForElement(driver, version);
			versionName = version.getText().trim().split(" v");
			versionNumber = Double.parseDouble(versionName[1]);
			expectedVersionNumber = expectedVersionNumber + 0.01;
			System.out.println("Version Number: - " + versionNumber);
			System.out.println("Expected Version Number: - " + expectedVersionNumber);

			if (rejectSuccess.isDisplayed() /* && versionNumber == expectedVersionNumber */) {
				test.get().log(Status.PASS, MarkupHelper.createLabel(
						"Knowledge Article " + kbID + " is Rejected Successfully: " + rejectSuccess.getText().trim(),
						ExtentColor.GREEN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println(
						"Knowledge Article " + kbID + " is Rejected Successfully: " + rejectSuccess.getText().trim());
			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("Failed to Reject Knowledge Article", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("Failed to Reject Knowledge Article");
			}
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Reject Button is not dislayed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Reject Button is not dislayed");
		}
	}

	/* This is method is to Review the Knowledge Article */
	public void reviewKnowledgeArticle(String kbID, String govUser) throws Exception {
		PageFactory.initElements(driver, KnowledgeCreationPage.class);
		navigateToHrDashboard();
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, widgetArticleToAction);

		if (isElementPresent(widgetArticleToAction)) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Navigated to HR Knowledge Dashboard", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

			JavascriptExecutor execute = (JavascriptExecutor) driver;
			waitForElementToBeClickable(driver, widgetArticleToAction);
			execute.executeScript("arguments[0].click();", widgetArticleToAction);
			checkForPageLoad(driver);

			if (isElementPresent(widgetArticleToAction)) {
				widgetArticleToAction.click();
			}
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Navigation to HR Knowledge Dashboard Failed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		navigateToArticle(kbID, kbSmeUser);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, approvalTab);
		approvalTab.click();
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, approvalStateDropDown);
		Select select = new Select(approvalStateDropDown);
		select.selectByVisibleText("Approver");
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, approvalTextBox);
		approvalTextBox.sendKeys(govUser);
		approvalTextBox.sendKeys(Keys.ENTER);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, approverSearch);

		/*
		 * if (!approverSearch.isDisplayed()) { approvalSearch.click(); }
		 */

		approverSearch.sendKeys(govUser);
		approverSearch.sendKeys(Keys.ENTER);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, rejectedLink);
		rejectedLink.click();
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, approverState);
		if (approverState.isDisplayed()) {
			if (approverState.getAttribute("value").equals("rejected")) {
				test.get().log(Status.INFO,
						MarkupHelper.createLabel("Current State of the Knowledge Article is displayed as : "
								+ approverState.getAttribute("value"), ExtentColor.CYAN));

				logSuccess("Expected Value - " + "rejected");
				logSuccess("Actual Value - " + approverState.getAttribute("value"));

				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("Current State of the Knowledge Article is displayed as : "
								+ approverState.getAttribute("value"), ExtentColor.RED));

				logFailure("Expected Value - " + "rejected");
				logFailure("Actual Value - " + approverState.getAttribute("value"));

				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}
			backToKA.click();
			waitForFrameToBeAvailable(driver, "gsft_main");
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Submiting the Knowledge Article for Approval", ExtentColor.CYAN));
			waitForElementToBeClickable(driver, btn_Request_for_Approval);
			btn_Request_for_Approval.click();
			waitForFrameToBeAvailable(driver, "gsft_main");
			waitForElement(driver, confirmDialogueBox);
			if (isElementPresent(confirmDialogueBox)) {
				logInfo("Confirm Dialogue Box is displayed to Confirm Valid To Date before 40 Businss Days.");
				logInfoScreenshot(driver);
				btn_OK.click();
			}
			Thread.sleep(2000);
			waitForFrameToBeAvailable(driver, "gsft_main");
			waitForElement(driver, version);
			versionName = version.getText().trim().split(" v");
			versionNumber = Double.parseDouble(versionName[1]);
			expectedVersionNumber = expectedVersionNumber + 0.01;
			System.out.println("Version Number: - " + versionNumber);
			System.out.println("Expected Version Number: - " + expectedVersionNumber);

			if (workFlow.getAttribute("value").equals("review")) {
				test.get().log(Status.PASS, MarkupHelper.createLabel(
						"Knowledge Article " + kbID + " is sent for Approval Successfully", ExtentColor.GREEN));

				logSuccess("Expected Value - " + "review");
				logSuccess("Actual Value - " + workFlow.getAttribute("value"));

				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("Knowledge Article " + kbID + " is sent for Approval Successfully");
			} else {
				test.get().log(Status.FAIL, MarkupHelper
						.createLabel("Knowledge Article " + kbID + " failed to sent for Approval", ExtentColor.RED));

				logFailure("Expected Value - " + "review");
				logFailure("Actual Value - " + workFlow.getAttribute("value"));

				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println("Knowledge Article " + kbID + " failed to sent for Approval");
			}
		}
	}

	/* This is method is to Approve the Knowledge Article */
	public void approveKnowledgeArticle(String kbID, String govUser, double minorVersion) throws Exception {
		PageFactory.initElements(driver, KnowledgeCreationPage.class);
		expectedWholeVersionNumber++;
		navigateToHrDashboard();
		waitForAction(driver);
		// driver.navigate().refresh();
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, widgetPendingArticle);
		waitForFrameToBeAvailable(driver, "gsft_main");
		if (isElementPresent(widgetPendingArticle)) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Navigated to HR Knowledge Dashboard", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			waitForElementToBeClickable(driver, widgetPendingArticle);
			JavascriptExecutor execute = (JavascriptExecutor) driver;
			execute.executeScript("arguments[0].click();", widgetPendingArticle);
			// widgetPendingArticle.click();
			waitForFrameToBeAvailable(driver, "gsft_main");

		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Navigation to HR Knowledge Dashboard Failed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		navigateToArticle(kbID, kbSmeUser);
		waitForFrameToBeAvailable(driver, "gsft_main");
		scrollToElement(driver, approvalTab);
		waitForElementToBeClickable(driver, approvalTab);
		approvalTab.click();
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, approvalStateDropDown);
		Select select = new Select(approvalStateDropDown);
		select.selectByVisibleText("Approver");
		waitForElement(driver, approvalTextBox);
		approvalTextBox.sendKeys(govUser);
		approvalTextBox.sendKeys(Keys.ENTER);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, approverSearch);

		/*
		 * if (!approverSearch.isDisplayed()) { approvalSearch.click(); }
		 */
		approverSearch.sendKeys(govUser);
		approverSearch.sendKeys(Keys.ENTER);
		waitForFrameToBeAvailable(driver, "gsft_main");

		waitForElementToBeClickable(driver, requestedLink);
		requestedLink.click();
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, btn_Approve);

		if (isElementPresent(btn_Approve)) {
			test.get().log(Status.INFO, MarkupHelper.createLabel("Approving the Knowledge Article", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Approving the Knowledge Article");
			waitForElementToBeClickable(driver, btn_Approve);
			JavascriptExecutor execute = (JavascriptExecutor) driver;
			execute.executeScript("arguments[0].click();", btn_Approve);
			Thread.sleep(2000);
			waitForAction(driver);

			waitForFrameToBeAvailable(driver, "gsft_main");
			waitForElement(driver, confirmDialogueBox);
			if (isElementPresent(confirmDialogueBox)) {
				logInfo("Confirm Dialogue Box is displayed to Confirm Valid To Date before 40 Businss Days.");
				logInfoScreenshot(driver);
				waitForElementToBeClickable(driver, btn_OK);
				btn_OK.click();
				Thread.sleep(2000);
			}
		}
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, version);
		Pattern pattern = Pattern.compile("^-?\\d*\\.\\d{1}$");
		versionName = version.getText().trim().split(" v");
		versionNumber = Double.parseDouble(versionName[1]);
		versionNameString = versionName[1];
		System.out.println("Version Number: - " + versionNumber);

		if (pattern.matcher(versionNameString).matches() && workFlow.getAttribute("value").equals("published")
				&& versionNumber == minorVersion) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Knowledge Article Approved Successfully: " + kbID, ExtentColor.GREEN));

			logSuccess("Expected Value - " + "published");
			logSuccess("Actual Value - " + workFlow.getAttribute("value"));

			logSuccess("Expected Value - " + minorVersion);
			logSuccess("Actual Value - " + versionNumber);

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Knowledge Article Approved Successfully: " + kbID);
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Failed to Approve the Knowledge Article: " + kbID, ExtentColor.RED));

			logFailure("Expected Value - " + "published");
			logFailure("Actual Value - " + workFlow.getAttribute("value"));

			logFailure("Expected Value - " + minorVersion);
			logFailure("Actual Value - " + versionNumber);

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Failed to Approve the Knowledge Article: " + kbID);
		}
	}

	/*
	 * This is method is to View Published Knowledge Article IN THE HR FULFILLER
	 * VIEW
	 */
	public void viewPublishedArticleKB(String kbID) throws Exception {
		PageFactory.initElements(driver, KnowledgeCreationPage.class);
		driver.navigate().refresh();
		waitForAction(driver);
		waitForElementToBeClickable(driver, navigationfilter);
		navigationfilter.click();
		waitForAction(driver);
		navigationfilter.sendKeys("HR Knowledge Base");
		waitForElement(driver, hrKnowledgeBase);
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		waitForElementToBeClickable(driver, hrKnowledgeBase);
		execute.executeScript("arguments[0].click();", hrKnowledgeBase);
		// hrKnowledgeBase.click();

		waitForFrameToBeAvailable(driver, "gsft_main");
		System.out.println("Navigated to HR Knowledge Base Page");
		waitForElementToBeClickable(driver, hrKnowledgeBaseSearch);
		hrKnowledgeBaseSearch.sendKeys(kbID);
		hrKnowledgeBaseSearch.sendKeys(Keys.ENTER);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, searchResults);
		if (isElementPresent(searchResults)) {
			if (isElementPresent(driver
					.findElement(By.xpath("//*[contains(text(),'" + kbID.toUpperCase() + " Search Results')]")))) {
				waitForElementToBeClickable(driver, hrKBSearchResults);
				hrKBSearchResults.click();
				waitForFrameToBeAvailable(driver, "gsft_main");
				if (verifyKBID.getText().trim().equals(kbID)) {
					test.get().log(Status.PASS, MarkupHelper.createLabel(
							"Knowledge Article Viewed Successfully in HR FULFILLER VIEW", ExtentColor.GREEN));

					logSuccess("Expected Value - " + kbID);
					logSuccess("Actual Value - " + verifyKBID.getText().trim());

					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					System.out.println("Knowledge Article Viewed Successfully in HR FULFILLER VIEW");
				} else {
					test.get().log(Status.FAIL, MarkupHelper.createLabel(
							"Failed to locate required Knowledge Article in HR FULFILLER VIEW", ExtentColor.RED));

					logFailure("Expected Value - " + kbID);
					logFailure("Actual Value - " + verifyKBID.getText().trim());

					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					System.out.println("Failed to locate required Knowledge Article in HR FULFILLER VIEW");
				}
			}
		} else {
			logFailure("Search results for Knowledge Article are unavailable");
			logFailureScreenshot(driver);
		}
	}

	/*
	 * This is method is to View Retired Knowledge Article IN THE HR FULFILLER VIEW
	 */
	public void viewRetiredArticleKB(String kbID) throws Exception {
		PageFactory.initElements(driver, KnowledgeCreationPage.class);
		navigationfilter.sendKeys("HR Knowledge Base");
		waitForElementToBeClickable(driver, hrKnowledgeBase);
		checkForPageLoad(driver);
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		execute.executeScript("arguments[0].click();", hrKnowledgeBase);
	//hrKnowledgeBase.click();

		waitForFrameToBeAvailable(driver, "gsft_main");
		System.out.println("Navigated to HR Knowledge Base Page");
		waitForElementToBeClickable(driver, hrKnowledgeBaseSearch);
		hrKnowledgeBaseSearch.sendKeys(kbID);
		hrKnowledgeBaseSearch.sendKeys(Keys.ENTER);

		if (driver.findElement(By.xpath(
				"//*[contains(@ng-bind-html, 'getNoSearchResultsErrorMessage()') and contains(@aria-hidden, 'true')]"))
				.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("Retired Knowledge Article Not avaiable in HR FULFILLER VIEW", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Retired Knowledge Article Not avaiable in HR FULFILLER VIEW");
		} else if (driver.findElement(By.xpath("//*[contains(text(),'" + kbID + " Search Results')]")).isDisplayed()) {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Retired Knowledge Article displayed in HR FULFILLER VIEW", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Retired Knowledge Article displayed in HR FULFILLER VIEW");
		}
	}

	/* This method is to update Published Knowledge Article */
	public void updateKnowledgeArticle(String kbID, double minorVersion) throws Exception {
		PageFactory.initElements(driver, KnowledgeCreationPage.class);
		navigateToHrDashboard();
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, widgetMyPublishedArticle);

		int articlesPublished = 0;
		int validateArticlePublished = 0;

		if (isElementPresent(widgetMyPublishedArticle)) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Navigated to HR Knowledge Dashboard", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			articlesPublished = Integer.parseInt(widgetMyPublishedArticle.getText().trim());
			System.out.println("Number displayed on widget My Article Published - " + articlesPublished);
			test.get().log(Status.INFO,
					MarkupHelper.createLabel(
							"Number of Articles displayed on My Article Published widget - " + articlesPublished,
							ExtentColor.CYAN));
			waitForElementToBeClickable(driver, widgetMyPublishedArticle);
			// widgetMyPublishedArticle.click();

			JavascriptExecutor execute = (JavascriptExecutor) driver;
			execute.executeScript("arguments[0].click();", widgetMyPublishedArticle);

		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Navigation to HR Knowledge Dashboard Failed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		waitForFrameToBeAvailable(driver, "gsft_main");
		scrollPageToElement(driver,
				driver.findElement(By.xpath("(//*[contains(@id,'listv2_') and contains(@id,'total_rows')])[1]")));
		waitForElementToBeClickable(driver,
				driver.findElement(By.xpath("(//*[contains(@id,'listv2_') and contains(@id,'total_rows')])[1]")));
		validateArticlePublished = Integer.parseInt(
				driver.findElement(By.xpath("(//*[contains(@id,'listv2_') and contains(@id,'total_rows')])[1]"))
						.getText().trim());
		System.out.println("Number of Articles displayed in My Article Published List - " + validateArticlePublished);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel(
						"Number of Articles displayed in My Article Published List - " + validateArticlePublished,
						ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		if (articlesPublished == validateArticlePublished) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Number of Articles displayed on My Article Published widget matches with Number of Articles displayed in My Article Published List",
					ExtentColor.GREEN));

			logSuccess("Expected Value - " + validateArticlePublished);
			logSuccess("Actual Value - " + articlesPublished);

		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Number of Articles displayed on My Article Published widget does not with Number of Articles displayed in My Article Published List",
					ExtentColor.RED));

			logFailure("Expected Value - " + validateArticlePublished);
			logFailure("Actual Value - " + articlesPublished);

		}

		navigateToArticle(kbID, kbSmeUser);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, validateAuthor);
		if (validateAuthor.getAttribute("value").equals(user)) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Author - " + user, ExtentColor.GREEN));
			logSuccess("Expected Value - " + user);
			logSuccess("Actual Value - " + validateAuthor.getAttribute("value"));

		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Author - " + user, ExtentColor.RED));
			logFailure("Expected Value - " + user);
			logFailure("Actual Value - " + validateAuthor.getAttribute("value"));

		}

		if (workFlow.getAttribute("value").equals("published")) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("Workflow - " + workFlow.getAttribute("value").toUpperCase(), ExtentColor.GREEN));
			logSuccess("Expected Value - " + "published");
			logSuccess("Actual Value - " + workFlow.getAttribute("value"));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Workflow - " + workFlow.getAttribute("value"), ExtentColor.RED));
			logFailure("Expected Value - " + "published");
			logFailure("Actual Value - " + workFlow.getAttribute("value"));
		}
		waitForElementToBeClickable(driver, btn_checkout);
		btn_checkout.click();
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, btn_delete);
		btn_delete.click();
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, btn_accept_delete);
		btn_accept_delete.click();
		waitForFrameToBeAvailable(driver, "gsft_main");
		Pattern pattern = Pattern.compile("^-?\\d*\\.\\d{1}$");
		// versionName = version.getText().trim().split(" v");
		// versionNumber = Double.parseDouble(versionName[1]);
		waitForElement(driver, versionlink);

		versionNumber = Double.parseDouble(versionlink.getText().trim());
		versionNameString = versionlink.getText().trim();
		System.out.println("Version Number: - " + versionNumber);

		if (pattern.matcher(versionNameString).matches() && versionNumber == minorVersion) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Knowledge Article Version: " + versionNumber, ExtentColor.GREEN));

			logSuccess("Expected Value - " + minorVersion);
			logSuccess("Actual Value - " + versionNumber);

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Actual Knowledge Article Version: " + versionNumber, ExtentColor.RED));
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Expected Knowledge Article Version: " + minorVersion, ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		navigateToArticle(kbID, kbSmeUser);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, btn_checkout);
		btn_checkout.click();

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, txt_Desc);

		if (txt_Desc.isDisplayed()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Description Field Set to: HR KB Automation Execution", ExtentColor.CYAN));
			txt_Desc.sendKeys("HR KB Automation Execution");

			waitForElement(driver, btn_Request_for_Approval);
			btn_Request_for_Approval.click();
			waitForFrameToBeAvailable(driver, "gsft_main");

			waitForElement(driver, confirmDialogueBox);
			if (isElementPresent(confirmDialogueBox)) {
				logInfo("Confirm Dialogue Box is displayed to Confirm Valid To Date before 40 Businss Days.");
				logInfoScreenshot(driver);
				btn_OK.click();
				waitForFrameToBeAvailable(driver, "gsft_main");

			}

		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Description Field is not displayed or may be disabled.", ExtentColor.RED));
		}

		String description = driver.findElement(By.xpath(".//*[@id='kb_knowledge.description']")).getAttribute("value");
		if (description.equalsIgnoreCase("HR KB Automation Execution")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Published Article is Edited Successfully", ExtentColor.GREEN));

			logSuccess("Expected Value - " + "HR KB Automation Execution");
			logSuccess("Actual Value - " + description);

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Knowledge Article updated successfully by inserting commenst on Description field");
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Article Update Failed", ExtentColor.RED));

			logFailure("Expected Value - " + "HR KB Automation Execution");
			logFailure("Actual Value - " + description);

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Failed to Edit Published Article Failed");
		}
	}

	/* This method is to Retire Published Knowledge Article */
	public void retireKnowledgeArticle(String kbID) throws Exception {
		PageFactory.initElements(driver, KnowledgeCreationPage.class);
		navigateToHrDashboard();
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, widgetPublishedArticle);
		waitForElementToBeClickable(driver, widgetPublishedArticle);

		if (isElementPresent(widgetPublishedArticle)) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Navigated to HR Knowledge Dashboard", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			waitForElementToBeClickable(driver, widgetPublishedArticle);
			JavascriptExecutor execute = (JavascriptExecutor) driver;
			execute.executeScript("arguments[0].click();", widgetPublishedArticle);
			waitForAction(driver);

			if (isElementPresent(widgetPublishedArticle)) {
				try {
					widgetPublishedArticle.click();
				} catch (Exception e) {
					System.out.println("Element is not available may be already clicked.");
				}
			}
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Navigation to HR Knowledge Dashboard Failed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		waitForFrameToBeAvailable(driver, "gsft_main");
		navigateToArticle(kbID, kbSmeUser);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, btn_Retire);
		btn_Retire.click();
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, btn_OK);

		int count = 0;
		if (btn_OK.isDisplayed()) {
			count++;
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("Clicked on OK button without providing a reason for Retiring ", ExtentColor.CYAN));
			btn_OK.click();

		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Ok button is not displayed ", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		waitForFrameToBeAvailable(driver, "gsft_main");
		if (retire_comment.isDisplayed()) {
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("Unable Submit without providing a reason for Retiring ", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else if (count > 0) {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Submitted without providing a reason for Retiring", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		waitForElementToBeClickable(driver, retire_comment);
		retire_comment.click();
		waitForAction(driver);
		retire_comment.sendKeys("HR KB Automation Execution - Retire Comments");
		waitForAction(driver);
		// waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, btn_OK);
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		execute.executeScript("arguments[0].click();", btn_OK);
		checkForPageLoad(driver);

		if (isElementPresent(btn_OK)) {
			btn_OK.click();
			waitForAction(driver);
			checkForPageLoad(driver);
		}

		waitForFrameToBeAvailable(driver, "gsft_main");
		String workflow = driver.findElement(By.xpath(".//*[@id='sys_readonly.kb_knowledge.workflow_state']"))
				.getAttribute("value");
		System.out.println("After Retiring value present for Workflow Field: " + workflow);
		if (workflow.equalsIgnoreCase("Retired")) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Article Retired Successfully", ExtentColor.GREEN));

			logSuccess("Expected Value - " + "Retired");
			logSuccess("Actual Value - " + workflow);

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Article Retired Successfully");

		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Article Retire Failed", ExtentColor.RED));

			logFailure("Expected Value - " + "Retired");
			logFailure("Actual Value - " + workflow);

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Article Retire Failed");
		}
	}

	/* This method is to Retire Published Knowledge Article */
	public void validateRetireKnowledgeArticle(String kbID) throws Exception {
		PageFactory.initElements(driver, KnowledgeCreationPage.class);
		waitForElementToBeClickable(driver, navigationfilter);
		navigationfilter.sendKeys("Retired Articles");
		waitForAction(driver);
		waitForElementToBeClickable(driver, retiredArticle);
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		execute.executeScript("arguments[0].click();", retiredArticle);
		waitForAction(driver);
		retiredArticle.click();
		waitForAction(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, driver.findElement(By.xpath(
				"//*[contains(@filter,'workflow_state=retired') and contains(@aria-label,'Workflow = Retired')]")));

		if (driver.findElement(By.xpath(
				"//*[contains(@filter,'workflow_state=retired') and contains(@aria-label,'Workflow = Retired')]"))
				.isDisplayed()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Navigated to Retired Articles List Page", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Navigation to Retired Articles List Page Failed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		if (!kb_list_view_search.isDisplayed()) {
			kbKnowledgeSearch.click();
		}
		waitForFrameToBeAvailable(driver, "gsft_main");
		kb_list_view_search.clear();
		kb_list_view_search.sendKeys(kbID);

		createdBy.clear();
		createdBy.sendKeys(kbSmeUser);
		createdBy.sendKeys(Keys.ENTER);
		waitForFrameToBeAvailable(driver, "gsft_main");

//		if (createdOn.isDisplayed()) {
//			createdOn.click();
//			
//			if (ascOrder.isDisplayed()) {
//				createdOn.click();
//				
//			} else {
//				System.out.println("List is in Desired Order");
//			}
//		}

		waitForElementToBeClickable(driver, expand);
		expand.click();
		waitForFrameToBeAvailable(driver, "gsft_main");
		System.out.println("ROW ID - " + expand.getAttribute("id"));
		String rowID = (expand.getAttribute("id").split("filterimg.")[1]).split("_workflow_state")[0];
		System.out.println("ROW ID AFTER SPLIT - " + rowID);
		waitForElement(driver, workFlowList);
		workFlowList.click();
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, workFlowList);
		List<WebElement> workFlowListNew = driver.findElements(By.xpath("//ol/span[contains(@id, '" + rowID + "')]"));
		String[] list = workFlowList.getText().trim().split("\\r?\\n");
		System.out.println("WorkFlow List Size - " + workFlowListNew.size());
		if (workFlowListNew.size() == 6) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("Number of Workflow Icons displayed are - " + list.length, ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Number of Workflow Icons displayed does not match required number", ExtentColor.RED));
			logFailure("Number of Actual Workflow Icon displayed - " + list.length);
			logFailure("Number of Expected Workflow Icon to be displayed - 6");
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Number of Workflow Icons displayed does not match required number" + list.length);
			for (int i = 0; i < list.length; i++) {
				test.get().log(Status.INFO,
						MarkupHelper.createLabel("Workflow Icons are displayed for - " + list[i], ExtentColor.CYAN));
				System.out.println(list[i]);
			}
		}
		WebElement draftIcon = driver
				.findElement(By.xpath("//*[contains(@id, '" + rowID + "_workflow_state.draft.image')]"));
		WebElement reviewIcon = driver
				.findElement(By.xpath("//*[contains(@id, '" + rowID + "_workflow_state.review.image')]"));
		WebElement publishedIcon = driver
				.findElement(By.xpath("//*[contains(@id, '" + rowID + "_workflow_state.published.image')]"));
		WebElement retiredIcon = driver
				.findElement(By.xpath("//*[contains(@id, '" + rowID + "_workflow_state.retired.image')]"));
		WebElement outdatedIcon = driver
				.findElement(By.xpath("//*[contains(@id, '" + rowID + "_workflow_state.outdated.image')]"));
		WebElement pendingPublishedIcon = driver
				.findElement(By.xpath("//*[contains(@id, '" + rowID + "_workflow_state.pending_publishing.image')]"));

		if (draftIcon.getAttribute("src").contains("images/heisenberg_icons/stage_icons/icon-check-circle.png")) {
			System.out.println("Workflow Draft is displayed with Check icon");
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Workflow Draft is displayed with Check icon", ExtentColor.GREEN));
		} else {
			System.out.println("Workflow Draft is displayed with unexpected icon");
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Workflow Draft is displayed with unexpected icon", ExtentColor.RED));
		}

		if (reviewIcon.getAttribute("src").contains("images/heisenberg_icons/stage_icons/icon-check-circle.png")) {
			System.out.println("Workflow Review is displayed with Check icon");
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Workflow Review is displayed with Check icon", ExtentColor.GREEN));
		} else {
			System.out.println("Workflow Review is displayed with unexpected icon");
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Workflow Review is displayed with unexpected icon", ExtentColor.RED));
		}

		if (pendingPublishedIcon.getAttribute("src")
				.contains("images/heisenberg_icons/stage_icons/icon-step-over.png")) {
			System.out.println("Workflow Pending Published is displayed with Step Over (Skipped) icon");
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Workflow Pending Published is displayed with Step Over (Skipped) icon", ExtentColor.GREEN));

		} else {
			System.out.println("Workflow Pending Published is displayed with unexpected icon");
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Workflow Pending Published is displayed with unexpected icon", ExtentColor.RED));
		}

		if (publishedIcon.getAttribute("src").contains("images/heisenberg_icons/stage_icons/icon-check-circle.png")) {
			System.out.println("Workflow Published is displayed with Check icon");
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Workflow Published is displayed with Check icon", ExtentColor.GREEN));
		} else {
			System.out.println("Workflow Published is displayed with unexpected icon");
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Workflow Published is displayed with unexpected icon", ExtentColor.RED));
		}

		if (retiredIcon.getAttribute("src").contains("images/heisenberg_icons/stage_icons/icon-arrow-right.png")) {
			System.out.println("Workflow Retired is displayed with Check icon");
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Workflow Retired is displayed with Right Arrow icon", ExtentColor.GREEN));
		} else {
			System.out.println("Workflow Retired is displayed with unexpected icon");
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Workflow Retired is displayed with unexpected icon", ExtentColor.RED));
		}

		if (outdatedIcon.getAttribute("src").contains("images/heisenberg_icons/stage_icons/icon-empty-circle.png")) {
			System.out.println("Workflow Outdated is displayed with Check icon");
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("Workflow Outdated is displayed with Empty Circle icon", ExtentColor.GREEN));
		} else {
			System.out.println("Workflow Outdated is displayed with unexpected icon");
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Workflow Outdated is displayed with unexpected icon", ExtentColor.RED));
		}
	}

	/* This method is to Delete UnPublished Knowledge Article */
	public void deleteUnpublishedArticle(String kbID) throws IOException {
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, btn_delete);
		if (isElementPresent(btn_delete)) {
			waitForElementToBeClickable(driver, btn_delete);
			btn_delete.click();
			waitForFrameToBeAvailable(driver, "gsft_main");
			test.get().log(Status.INFO, MarkupHelper.createLabel("Deleting the Unpublished Article", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

			waitForElementToBeClickable(driver, btn_accept_delete);
			btn_accept_delete.click();
			waitForFrameToBeAvailable(driver, "gsft_main");

		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Delete button is not available", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	/* This method is to validate unpublished Knowledge Article Deletion */
	public void validateArticleDelete(String kbID) throws Exception {
		PageFactory.initElements(driver, KnowledgeCreationPage.class);
		waitForElement(driver, navigationfilter);
		waitForElementToBeClickable(driver, navigationfilter);
		navigationfilter.sendKeys("All Articles");
		waitForAction(driver);
		waitForElementToBeClickable(driver, allArticles);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", allArticles);
		waitForAction(driver);
		allArticles.click();

		waitForFrameToBeAvailable(driver, "gsft_main");

		waitForElementToBeClickable(driver, searchDropDown);
		Select select = new Select(searchDropDown);
		select.selectByVisibleText("Number");
		searchBox.sendKeys(kbID);
		searchBox.sendKeys(Keys.ENTER);
		waitForFrameToBeAvailable(driver, "gsft_main");

		/*
		 * if (!kb_list_view_search.isDisplayed()) { kbKnowledgeSearch.click(); }
		 */

		/*
		 * kb_list_view_search.clear(); kb_list_view_search.sendKeys(kbID);
		 * 
		 */

		waitForElementToBeClickable(driver, createdBy);
		createdBy.clear();
		createdBy.sendKeys(kbSmeUser);
		createdBy.sendKeys(Keys.ENTER);
		waitForFrameToBeAvailable(driver, "gsft_main");
		if (noRecords.isDisplayed()) {
			System.out.println("Deleted Article Not Found");
			test.get().log(Status.PASS, MarkupHelper.createLabel("Deleted Article Not Found", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			System.out.println("Article Found!!!");
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Deleted Knowledge Article " + kbID + " found", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	/* This method is to Enter Suggestion the Knowledge Article */
	public void enterArticleSuggestion() throws Exception {
		PageFactory.initElements(driver, KnowledgeCreationPage.class);

		if (isElementPresent(btn_flagarticle)) {
			btn_flagarticle.click();
		} else {
			logFailure("Flag Article Button is not displayed");
			logFailureScreenshot(driver);
		}

		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@class,'gb_iframe')]")));
		Thread.sleep(5000);
		if (isElementPresent(text_suggesttext)) {
			waitForElementToBeClickable(driver, text_suggesttext);
			text_suggesttext.sendKeys("Automation Test For Article Suggestion");
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Adding suggestion to the Knowledge Article", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Flag this article Reason Text Box is not displayed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		waitForElement(driver, btn_suggest_submit);
		if (isElementPresent(btn_suggest_submit)) {
			waitForElementToBeClickable(driver, btn_suggest_submit);
			JavascriptExecutor execute = (JavascriptExecutor) driver;
			execute.executeScript("arguments[0].click();", btn_suggest_submit);
		}

		// btn_suggest_submit.click();
		else {
			logFailure("Submit button is not displayed to submit the suggestion");
			logFailureScreenshot(driver);
		}
		driver.navigate().refresh();
		waitForFrameToBeAvailable(driver, "gsft_main");
		if (isElementPresent(flaggedText)) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("Suggestion is added successfully to Knowledge Article", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Adding Suggestion to Knowledge Article is Failed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	/* This method is to Verify Knowledge Article Suggestion as SME USER */
	public void verifySuggestionSME(String kbID) throws Exception {
		PageFactory.initElements(driver, KnowledgeCreationPage.class);

		navigateToHrDashboard();
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, widgetMyPublishedArticle);

		if (isElementPresent(widgetMyPublishedArticle)) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Navigated to HR Knowledge Dashboard", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			waitForElementToBeClickable(driver, widgetMyPublishedArticle);
			JavascriptExecutor execute = (JavascriptExecutor) driver;
			execute.executeScript("arguments[0].click();", widgetMyPublishedArticle);
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Navigation to HR Knowledge Dashboard Failed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		navigateToArticle(kbID, kbSmeUser);
		waitForFrameToBeAvailable(driver, "gsft_main");
		if (isElementPresent(tab_kb_feedback)) {
			waitForElementToBeClickable(driver, tab_kb_feedback);
			tab_kb_feedback.click();
			waitForFrameToBeAvailable(driver, "gsft_main");
			waitForElement(driver, knowledgeFeedback);
			if (isElementPresent(knowledgeFeedback)) {
				test.get().log(Status.INFO,
						MarkupHelper.createLabel("Feedback is present for Knowledge Article", ExtentColor.CYAN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("Feedback is not present for Knowledge Article", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Feedback tab is not displayed for Knowledge Article", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	/* This method is to Verify Knowledge Article Suggestion as GOVERNANCE USER */
	public void verifySuggestionGov(String kbID) throws Exception {
		PageFactory.initElements(driver, KnowledgeCreationPage.class);
		int articlesForSuggestion = 0;
		int validateArticlesForSuggestion = 0;
		// String kbID = "KB0010276";

		navigateToHrDashboard();
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, widgetMyPublishedArticle);
		System.out.println("Scrolling Page Down");
		scrollPageToElement(driver, widgetArticleSuggestionHeading);
		waitForAction(driver);
		waitForElement(driver, widgetArticleSuggestion);
		waitForElementToBeClickable(driver, widgetArticleSuggestion);
		if (isElementPresent(widgetArticleSuggestion)) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Navigated to HR Knowledge Dashboard", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			articlesForSuggestion = Integer.parseInt(widgetArticleSuggestion.getText().trim());
			System.out.println("Number displayed on widget Article Suggestion - " + articlesForSuggestion);
			test.get().log(Status.INFO,
					MarkupHelper.createLabel(
							"Number of Articles displayed on Article Suggestion widget - " + articlesForSuggestion,
							ExtentColor.CYAN));

			checkForPageLoad(driver);
			waitForElement(driver, widgetArticleSuggestion);
			waitForElementToBeClickable(driver, widgetArticleSuggestion);
			JavascriptExecutor execute = (JavascriptExecutor) driver;
			execute.executeScript("arguments[0].click();", widgetArticleSuggestion);
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Navigation to HR Knowledge Dashboard Failed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		waitForAction(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver,
				driver.findElement(By.xpath("(//*[contains(@id,'listv2_') and contains(@id,'total_rows')])[1]")));
		validateArticlesForSuggestion = Integer.parseInt(
				driver.findElement(By.xpath("(//*[contains(@id,'listv2_') and contains(@id,'total_rows')])[1]"))
						.getText().trim());
		System.out
				.println("Number of Articles displayed in Article Suggestion List - " + validateArticlesForSuggestion);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel(
						"Number of Articles displayed in Article Suggestion List - " + validateArticlesForSuggestion,
						ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		if (articlesForSuggestion == validateArticlesForSuggestion) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Number of Articles displayed on Article Suggestion widget matches with Number of Articles displayed in Article Suggestion List",
					ExtentColor.GREEN));

			logSuccess("Expected Value - " + validateArticlesForSuggestion);
			logSuccess("Actual Value - " + articlesForSuggestion);

		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Number of Articles displayed on My Article Published widget does not with Number of Articles displayed in My Article Published List",
					ExtentColor.RED));

			logFailure("Expected Value - " + validateArticlesForSuggestion);
			logFailure("Actual Value - " + articlesForSuggestion);

		}

		if (!isElementPresent(suggestionArticleSearch)) {
			suggestionArticleSearchIcon.click();
		}
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, suggestionArticleSearch);
		suggestionArticleSearch.clear();
		suggestionArticleSearch.sendKeys(kbID);
		suggestionArticleSearch.sendKeys(Keys.ENTER);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, kb_link_number_suggestion);

		if (isElementPresent(kb_link_number_suggestion)) {
			if (kb_link_number_suggestion.getText().trim().contains(kbID)) {
				waitForElementToBeClickable(driver, kb_link_number_suggestion);
				kb_link_number_suggestion.click();

				waitForFrameToBeAvailable(driver, "gsft_main");
				System.out.println("Article searched successfully with ID " + kbID);
				test.get().log(Status.INFO,
						MarkupHelper.createLabel("Searched the Knowledge Article " + kbID, ExtentColor.CYAN));
				logSuccess("Expected Value - " + kbID);
				logSuccess("Actual Value - " + kb_link_number_suggestion.getText().trim());
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}
		} else {
			System.out.println("Article not Found!!!");
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Knowledge Article " + kbID + " not found", ExtentColor.RED));
			logFailure("Expected Value - " + kbID);
			logFailure("Actual Value - " + kb_link_number_suggestion.getText().trim());

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		waitForFrameToBeAvailable(driver, "gsft_main");
		if (isElementPresent(tab_kb_feedback)) {
			tab_kb_feedback.click();
			scrollPageDown(driver);
			waitForFrameToBeAvailable(driver, "gsft_main");
			if (isElementPresent(knowledgeFeedback)) {
				if (driver
						.findElement(By.xpath("//*[contains(@class,'linked formlink') and contains(text(), '"
								+ "Automation Test For Article Suggestion" + "')]"))
						.getText().trim().equals("Automation Test For Article Suggestion")) {
					test.get().log(Status.INFO, MarkupHelper
							.createLabel("Suggestion is validated for Knowledge Article", ExtentColor.CYAN));
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				}
			} else {
				test.get().log(Status.FAIL, MarkupHelper
						.createLabel("Suggestion validation Failed for Knowledge Article", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Feedback tab is not displayed for Knowledge Article", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	public void navigateToHrDashboard() throws InterruptedException, IOException {
		PageFactory.initElements(driver, KnowledgeCreationPage.class);
		driver.navigate().refresh();
		waitForElement(driver, navigationfilter);
		waitForElementToBeClickable(driver, navigationfilter);
		navigationfilter.click();
		waitForAction(driver);
		navigationfilter.sendKeys("Dashboard");
		navigationfilter.sendKeys(Keys.ENTER);
		waitForElementToBeClickable(driver, dashboard);
		checkForPageLoad(driver);
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		execute.executeScript("arguments[0].click();", dashboard);
		waitForAction(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, allTab);
		waitForElementToBeClickable(driver, allTab);
		if (isElementPresent(allTab)) {
			// allTab.click();
			execute.executeScript("arguments[0].click();", allTab);
		} else {
			// allTab.click();
			System.out.println("ALl Tab is not available");
		}

		waitForElement(driver, hrDashboard);
		waitForElementToBeClickable(driver, hrDashboard);
		hrDashboard.click();
		System.out.println("Clicked on Dashboard");
	}

	public void navigateToArticle(String kbID, String smeUser) throws Exception {
		PageFactory.initElements(driver, KnowledgeCreationPage.class);
		waitForAction(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, searchDropDown);
		Select select = new Select(searchDropDown);
		select.selectByVisibleText("Number");
		searchBox.sendKeys(kbID);
		searchBox.sendKeys(Keys.ENTER);
		waitForFrameToBeAvailable(driver, "gsft_main");

		/*
		 * if (!isElementPresent(kb_list_view_search)) { kbKnowledgeSearch.click(); }
		 */
		waitForElementToBeClickable(driver, kb_list_view_search);
		waitForAction(driver);
		kb_list_view_search.clear();
		waitForAction(driver);
		kb_list_view_search.sendKeys(kbID);
		waitForElementToBeClickable(driver, createdBy);
		createdBy.clear();
		createdBy.sendKeys(smeUser);
		waitForAction(driver);
		createdBy.sendKeys(Keys.ENTER);
		waitForAction(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, kb_link_number);
		if (isElementPresent(kb_link_number)) {
			if (kb_link_number.isDisplayed() && kb_link_number.getText().trim().equals(kbID)) {
				kb_link_number.click();

				System.out.println("Article searched successfully with ID " + kbID);
				test.get().log(Status.INFO,
						MarkupHelper.createLabel("Searched the Knowledge Article " + kbID, ExtentColor.CYAN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}
		} else {
			System.out.println("Article not Found!!!");
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Knowledge Article " + kbID + " not found", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	// This method is to validate HR Dash board when logged in as SME User.
	public void validateHRKnowledgeDashbord(List<String> expectedWidgets) throws IOException {
		PageFactory.initElements(driver, KnowledgeCreationPage.class);
		waitForFrameToBeAvailable(driver, "gsft_main");
		List<WebElement> widgets = driver.findElements(By.xpath(
				"//*[contains(@class, 'grid-stack-item ui-draggable ui-resizable ui-resizable-autohide ui-draggable-disabled ui-resizable-disabled')]"));
		System.out.println("Number of Widgets present on the HR Knowledge Dashboard - " + widgets.size());

		if (!widgets.isEmpty()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Navigated To HR Knowledge Dashboard", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Navigation To expected HR Knowledge Dashboard Failed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		List<String> actualWidgets = new ArrayList<String>();
		List<String> notMatchedWidgetList = new ArrayList<String>();
		int count;

		for (int i = 0; i < widgets.size(); i++) {
			String widget = widgets.get(i).getText().trim();
			actualWidgets.add(widget.split("\\r?\\n")[0]);
			System.out.println("Widget Text - " + widget.split("\\r?\\n")[0]);
		}

		if (actualWidgets.size() == expectedWidgets.size()) {
			System.out.println("Expected Widget Size - " + expectedWidgets.size());
			System.out.println("Actual Widget Size - " + actualWidgets.size());
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("Actual Widget Count matches with the expected Widget count", ExtentColor.GREEN));

			logSuccess("Expected Value - " + expectedWidgets.size());
			logSuccess("Actual Value - " + actualWidgets.size());

		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Actual Widget Count does not match with the expected Widget count", ExtentColor.RED));

			logFailure("Expected Value - " + expectedWidgets.size());
			logFailure("Actual Value - " + actualWidgets.size());

		}

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Matched Widgets in HR Knowledge Dashboard are:", ExtentColor.CYAN));

		for (int i = 0; i < expectedWidgets.size(); i++) {
			count = 0;
			for (int j = 0; j < actualWidgets.size(); j++) {
				if (actualWidgets.get(j).contains(expectedWidgets.get(i))) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel(" - " + expectedWidgets.get(i), ExtentColor.GREEN));
					System.out.println("Widget - " + expectedWidgets.get(i));
					count++;
				}
			}
			if (count == 0) {
				System.out.println("Not Matched String - " + expectedWidgets.get(i));
				notMatchedWidgetList.add(expectedWidgets.get(i));
			}
		}

		if (notMatchedWidgetList.size() > 0) {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Not Matched Widgets in HR Knowledge Dashboard are:", ExtentColor.RED));
			for (int j = 0; j < notMatchedWidgetList.size(); j++) {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel(" - " + notMatchedWidgetList.get(j), ExtentColor.RED));
			}
		}

	}

	public int validationForNearExpirationArticle() throws IOException {
		PageFactory.initElements(driver, KnowledgeCreationPage.class);
		waitForFrameToBeAvailable(driver, "gsft_main");
		int articleNearExpiration = 0;
		int articleNearExpirationList = 0;
		waitForElementToBeClickable(driver, widgetArticleNearExpiration);

		if (widgetArticleNearExpiration.isDisplayed()) {
			articleNearExpiration = Integer.parseInt(widgetArticleNearExpiration.getText().trim());
			System.out.println("Articles Near Expiration Displayed -  " + articleNearExpiration);
			test.get().log(Status.INFO, MarkupHelper.createLabel(
					"Number of Articles Near Expiration Displayed are -  " + articleNearExpiration, ExtentColor.CYAN));
			waitForElementToBeClickable(driver, widgetArticleNearExpiration);
			JavascriptExecutor execute = (JavascriptExecutor) driver;
			execute.executeScript("arguments[0].click();", widgetArticleNearExpiration);
			waitForAction(driver);
			if (isElementPresent(widgetArticleNearExpiration)) {
				try {
					widgetArticleNearExpiration.click();
				} catch (Exception e) {
					System.out.println("Element may be got clicked in earlier attempt.");
				}
			}
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Widget My Article Near Expiration is not displayed.", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		waitForFrameToBeAvailable(driver, "gsft_main");
		scrollPageToElement(driver,
				driver.findElement(By.xpath("(//*[contains(@id,'listv2_') and contains(@id,'total_rows')])[1]")));
		waitForElement(driver,
				driver.findElement(By.xpath("(//*[contains(@id,'listv2_') and contains(@id,'total_rows')])[1]")));
		articleNearExpirationList = Integer.parseInt(
				driver.findElement(By.xpath("(//*[contains(@id,'listv2_') and contains(@id,'total_rows')])[1]"))
						.getText().trim());
		System.out.println(
				"Number of Articles displayed in My Article Near Expiration List - " + articleNearExpirationList);
		test.get().log(Status.INFO, MarkupHelper.createLabel(
				"Number of Articles displayed in My Article Near Expiration List - " + articleNearExpirationList,
				ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		if (articleNearExpiration == articleNearExpirationList) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Number of Articles displayed on My Article Near Expiration widget matches with Number of Articles displayed in My Article Near Expiration List",
					ExtentColor.GREEN));

			logSuccess("Expected Value - " + articleNearExpirationList);
			logSuccess("Actual Value - " + articleNearExpiration);

		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Number of Articles displayed on My Article Near Expiration widget does not with Number of Articles displayed in My Article Near Expiration List",
					ExtentColor.RED));

			logFailure("Expected Value - " + articleNearExpirationList);
			logFailure("Actual Value - " + articleNearExpiration);

		}
		return articleNearExpirationList;
	}

	public void validateExpirationDate(int articleNearExpiration) throws IOException, ParseException {
		waitForFrameToBeAvailable(driver, "gsft_main");
		int count = 1;
		String rowXpath = null;
		String knowledgeArticle = null;
		do {
			rowXpath = "//*[contains(@class,'list2_body')]/tr[" + count + "]/td[3]/a";
			waitForElementToBeClickable(driver, driver.findElement(By.xpath(rowXpath)));
			knowledgeArticle = driver.findElement(By.xpath(rowXpath)).getText().trim();
			System.out.println("Knowledge Article  - " + knowledgeArticle);
			driver.findElement(By.xpath(rowXpath)).click();
			waitForFrameToBeAvailable(driver, "gsft_main");
			if (validToExp.isDisplayed()) {
				test.get().log(Status.INFO, MarkupHelper
						.createLabel("Verifying the Valid To Date for Article: " + knowledgeArticle, ExtentColor.CYAN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

				DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String currentDate = simpleDateFormat.format(new Date());
				LocalDate date1 = LocalDate.parse(currentDate, dateTimeFormatter);
				LocalDate date2 = LocalDate.parse(validToExp.getAttribute("value"), dateTimeFormatter);
				long days = ChronoUnit.DAYS.between(date1, date2);
				System.out.println("Difference in Days: " + days);

				Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(currentDate);
				Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(validToExp.getAttribute("value"));
				int workingDays = getWorkingDaysBetweenTwoDates(startDate, endDate);
				System.out.println("Difference in Working Days: " + workingDays);

				if (workingDays <= 40) {
					test.get().log(Status.PASS, MarkupHelper.createLabel(
							"Difference between Valid To Date and current date is: " + workingDays, ExtentColor.GREEN));
				} else {
					test.get().log(Status.FAIL, MarkupHelper.createLabel(
							"Difference between Valid To Date and current date is: " + workingDays, ExtentColor.RED));
				}
			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("Valid To Date for Article is not displayed", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}
			backToKA.click();
			waitForAction(driver);
			waitForFrameToBeAvailable(driver, "gsft_main");
			count++;
		} while (count <= 2 && count <= articleNearExpiration);
	}

	public int getWorkingDaysBetweenTwoDates(Date startDate, Date endDate) {
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);

		int workDays = 0;

		// Return 0 if start and end are the same
		if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
			return 0;
		}

		if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
			startCal.setTime(endDate);
			endCal.setTime(startDate);
		}

		do {
			// excluding start date
			startCal.add(Calendar.DAY_OF_MONTH, 1);
			if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
					&& startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				++workDays;
			}
		} while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); // excluding end date

		return workDays;
	}

	public void validationForMyPublishedArticle(List<String> columnString) throws IOException {
		PageFactory.initElements(driver, KnowledgeCreationPage.class);
		List<String> notMatchedColumnString = new ArrayList<String>();
		int mismatchCount = 0;

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, widgetMyPublishedArticle);
		if (widgetMyPublishedArticle.isDisplayed()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Navigated to HR Knowledge Dashboard", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			JavascriptExecutor execute = (JavascriptExecutor) driver;
			execute.executeScript("arguments[0].click();", widgetMyPublishedArticle);
			waitForAction(driver);

			if (isElementPresent(widgetMyPublishedArticle)) {
				try {
					widgetMyPublishedArticle.click();
				} catch (Exception e) {
					System.out.println("Element may have clicked earlier");
				}

			}

		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Navigation to HR Knowledge Dashboard Failed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		waitForFrameToBeAvailable(driver, "gsft_main");
		for (int i = 0; i < columnString.size(); i++) {
			String columnName = driver
					.findElement(By.xpath("(//*[@id='hdr_kb_knowledge']/th[" + (3 + i) + "]/span/a)[1]")).getText()
					.trim().split("\\r?\\n")[0];
			System.out.println("Actual Column Name - " + columnName);
			System.out.println("Expected Column Name - " + columnString.get(i));
			// if (columnString.get(i).trim().contains(columnName.trim())) {
			if (columnName.trim().contains(columnString.get(i).trim())) {
				System.out.println("Column order matched for - " + columnName);
			} else {
				mismatchCount++;
				notMatchedColumnString.add(columnName);
				System.out.println("Column order mismatched for - " + columnName);
			}
		}

		if (mismatchCount == 0) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Column Order is updated Successfully", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Column Order is not as expected", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	public List<String> changeColumnOrder() throws IOException, InterruptedException {
		PageFactory.initElements(driver, KnowledgeCreationPage.class);
		waitForFrameToBeAvailable(driver, "gsft_main");
		List<String> columnString = new ArrayList<String>();
		List<String> notMatchedColumnString = new ArrayList<String>();
		List<WebElement> columnList = null;
		int mismatchCount = 0;
		waitForElementToBeClickable(driver, gearIcon);
		if (gearIcon.isDisplayed()) {
			scrollPageToElement(driver, gearIcon);
			JavascriptExecutor execute = (JavascriptExecutor) driver;
			execute.executeScript("arguments[0].click();", gearIcon);
			// gearIcon.click();
			waitForFrameToBeAvailable(driver, "gsft_main");
			if (columnOrderHeader.isDisplayed()) {
				test.get().log(Status.INFO, MarkupHelper
						.createLabel("Present Column Order is shown in below screenshot -", ExtentColor.CYAN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				waitForElementToBeClickable(driver, driver.findElement(By.xpath("//*[@id='slush_right']/option")));
				checkForPageLoad(driver);
				columnList = driver.findElements(By.xpath("//*[@id='slush_right']/option"));
				test.get().log(Status.INFO, MarkupHelper
						.createLabel("Number of Columns displayed - " + columnList.size(), ExtentColor.CYAN));
				System.out.println("Number of Columns displayed - " + columnList.size());
				waitForAction(driver);
				columnList.get(columnList.size() - 1).click();
				moveUp.click();
				test.get().log(Status.INFO, MarkupHelper
						.createLabel("Updated Column Order is shown in below screenshot -", ExtentColor.CYAN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

				List<WebElement> updatedColumnList = driver.findElements(By.xpath("//*[@id='slush_right']/option"));
				List<WebElement> updatedColumnsListFinal = new ArrayList<WebElement>();

				for (int i = 0; i < updatedColumnList.size(); i++) {
					updatedColumnsListFinal
							.add(driver.findElement(By.xpath("(//*[@id='slush_right']/option)[" + (i + 1) + "]")));
				}
				for (WebElement webElement : updatedColumnsListFinal) {
					String string = webElement.getText().split("\\(")[0].trim();
					columnString.add(string);
					System.out.println(webElement.getText().trim());
				}
				btn_OK.click();
				test.get().log(Status.INFO, MarkupHelper.createLabel(
						"Updated Column Order for List view is shown in below screenshot -", ExtentColor.CYAN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				WebElement element = null;
				driver.navigate().refresh();
				waitForFrameToBeAvailable(driver, "gsft_main");
				scrollPageUp(driver);
				waitForAction(driver);
				waitForElement(driver, driver.findElement(By.xpath("(//*[@id='hdr_kb_knowledge']/th[3]/span/a)[1]")));

				for (int i = 0; i < columnString.size(); i++) {
					element = driver
							.findElement(By.xpath("(//*[@id='hdr_kb_knowledge']/th[" + (3 + i) + "]/span/a)[1]"));
					waitForAction(driver);
					waitForElementToBeClickable(driver, element);
					scrollPageToElement(driver, element);
					String columnName = element.getText().trim().split("\\r?\\n")[0];

					System.out.println("Actual Column Name - " + columnName);
					System.out.println("Expected Column Name - " + columnString.get(i));

					// if (columnString.get(i).trim().contains(columnName.trim())) {
					if (columnName.trim().contains(columnString.get(i).trim())) {
						System.out.println("Column order matched for - " + columnName);
					} else {
						mismatchCount++;
						notMatchedColumnString.add(columnName);
						System.out.println("Column order mismatched for - " + columnName);
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
			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("Navigation change Column Order is Failed.", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Gear Icon to change Column Order is no displayed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		return columnString;
	}

	public String kbArticleSubmission(String suggestion) throws InterruptedException, IOException {
		PageFactory.initElements(driver, KnowledgeCreationPage.class);
		test.get().log(Status.INFO, MarkupHelper.createLabel(
				"Submitting Knowledge Article when Attachment Link Checkbox is checked", ExtentColor.CYAN));

		if (!chk_Attachments.isSelected()) {
			chk_Attachments.click();

			test.get().log(Status.INFO, MarkupHelper.createLabel("Attachment Link is Selected", ExtentColor.CYAN));
		}

		String kbID = form_kb_number.getAttribute("value");

		System.out.println("Knowledge Article ID " + kbID);
		test.get().log(Status.INFO, MarkupHelper.createLabel("Knowledge Article Number: " + kbID, ExtentColor.CYAN));
		btn_submit.click();

		System.out.println("Successfully Submitted");

		Thread.sleep(2000);
		if (!kb_list_view_search.isDisplayed()) {
			kbKnowledgeSearch.click();
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Knowledge Article Submitted Successfully", ExtentColor.CYAN));

		}

		kb_list_view_search.sendKeys(kbID);
		kb_list_view_search.sendKeys(Keys.ENTER);

		if (driver.findElements(By.xpath("//a[@class='linked formlink']")).size() >= 1) {
			kb_link_number.click();

		}

		if (driver.findElements(By.xpath("//span[@class='navbar_ui_actions']//button[@id='sysverb_delete']"))
				.size() != 0) {
			System.out.println("Delete Button is Available");
		} else {
			System.out.println("Delete Button is Not Available");
		}

		link_viewarticle.click();

		btn_flagarticle.click();

		waitForFrameToBeAvailable(driver, "gsft_main");
		text_suggesttext.sendKeys(suggestion);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Adding suggestion to the Knowledge Article", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		btn_suggest_submit.click();

		waitForFrameToBeAvailable(driver, "gsft_main");

		if (flaggedText.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("Suggestion is added successfully to Knowledge Article", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Adding Suggestion to Knowledge Article is Failed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		backButton.click();

		btn_Request_for_Approval.click();

		if (isElementPresent(confirmDialogueBox)) {
			logInfo("Confirm Dialogue Box is displayed to Confirm Valid To Date before 40 Businss Days.");
			logInfoScreenshot(driver);
			btn_OK.click();

		}
		return kbID;

	}

	public void navigateToKnowledgeArticle(String navigationFilter, String kbID) throws Exception {
		navigationfilter.sendKeys(navigationFilter);

		System.out.println("Navigate to Search Article Page");
		allArticles.click();

		waitForFrameToBeAvailable(driver, "gsft_main");
		if (!kb_list_view_search.isDisplayed()) {
			kbKnowledgeSearch.click();
			waitForFrameToBeAvailable(driver, "gsft_main");
		}
		kb_list_view_search.sendKeys(kbID);
		kb_list_view_search.sendKeys(Keys.ENTER);
		waitForFrameToBeAvailable(driver, "gsft_main");

		if (kb_link_number.isDisplayed()) {
			kb_link_number.click();
			waitForFrameToBeAvailable(driver, "gsft_main");
			System.out.println("Article searched successfully with ID " + kbID);
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Searched the Knowledge Article " + kbID, ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			System.out.println("Article not Found!!!");
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Knowledge Article " + kbID + " not found", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	public void importKnowldegeArticles() throws IOException {
		PageFactory.initElements(driver, KnowledgeCreationPage.class);
		navigationfilter.sendKeys("HR Knowledge Base");

		waitForElement(driver, hrKnowledgeBase);
		hrKnowledgeBase.click();

		waitForFrameToBeAvailable(driver, "gsft_main");
		System.out.println("Navigated to HR Knowledge Base Page");

		if (isElementPresent(importArticleButton)) {
			logInfo("Navigated to HR Knowledge Base Page");
			logInfoScreenshot(driver);

		}

	}

	/* This method is to Add Attachment. */
	public void addAttachment() throws IOException {
		PageFactory.initElements(driver, KnowledgeCreationPage.class);

		// String fileName = System.getProperty("user.dir") + File.separatorChar +
		// "AutomationTest.txt";
		String fileName;
		String file = "\"Residuals - New Hire Template.xlsx\"";
		if (executeOn.equals("System Browsers")) {
			fileName = "C:" + File.separatorChar + "Users" + File.separatorChar + "xajaunja" + File.separatorChar
					+ "Downloads" + File.separatorChar + file;

		} else {
			fileName = "C:" + File.separatorChar + "Users" + File.separatorChar + "Administrator" + File.separatorChar
					+ "Downloads" + File.separatorChar + file;
		}

		System.out.println("File Path - " + fileName);
		// String fileName = "C:\\Users\\Administrator\\final_output_ts.txt";
		String autoITExecutable = System.getProperty("user.dir") + File.separatorChar + "FileUploadChromeEdge "
				+ fileName;
		try {
			importArticleButton.click();

			Thread.sleep(5000);
			Runtime.getRuntime().exec(autoITExecutable);
			logInfo("Uploading Attachment - " + fileName);
			logInfoScreenshot(driver);
		} catch (Exception e) {
			logFailure("Failed to add attachment: " + e.getMessage());
			logFailureScreenshot(driver);
		}
	}
}