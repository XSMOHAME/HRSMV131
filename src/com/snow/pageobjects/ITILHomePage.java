package com.snow.pageobjects;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.snow.base.ReusableLibrary;
import com.snow.exceptions.InvalidCredentialException;

public class ITILHomePage extends ReusableLibrary {
	public WebDriver driver;
	public ITILHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "filter")
	public  WebElement navigationfilter;

	@FindBy(xpath = ".//*[@id='0878652cc0a801640001ff83e2bfbfe7']/div/div")
	public  WebElement link_Knowledge;

	@FindBy(xpath = "//div[contains(text(),'Create New Article')]")
	public  WebElement create_new_article;

	@FindBy(xpath = "//button[contains(.,'Create an Article')]")
	public  WebElement btn_create_article;

	@FindBy(xpath = "//div[contains(text(),'All Articles')]")
	public  WebElement all_article;

	@FindBy(xpath = "(//*[@id='hdr_kb_knowledge']/th[2]/div/button)[1]")
	public  WebElement kbKnowledgeSearch;

	@FindBy(xpath = "//table[@id='kb_knowledge_table']//input[@id='kb_knowledge_table_header_search_control']")
	public  WebElement kb_list_view_search;

	@FindBy(xpath = "(//a[@class='linked formlink'])[1]")
	public  WebElement kb_link_number;

	@FindBy(xpath = "//input[@id='sys_readonly.kb_knowledge.number']")
	public  WebElement form_kb_number;

	@FindBy(xpath = ".//*[@id='kb_knowledge.short_description']")
	public  WebElement txt_shortdesc;

	@FindBy(xpath = ".//*[@id='sys_display.kb_knowledge.kb_knowledge_base']")
	public  WebElement ref_Know_base;

	@FindBy(xpath = ".//*[@id='ac_option_bb0370019f22120047a2d126c42e7073']/span")
	public  WebElement select_know_base;

	@FindBy(xpath = ".//*[@id='sys_display.kb_knowledge.kb_category']")
	public  WebElement ref_category;

	@FindBy(xpath = ".//*[@id='ac_option_939e48ea3706d7002fc0c7d1b3990efe']/td[2]")
	public  WebElement select_category;

	@FindBy(xpath = ".//*[@id='kb_knowledge.can_read_user_criteria_unlock']")
	public  WebElement click_can_read;

	@FindBy(xpath = ".//*[@id='sys_display.kb_knowledge.can_read_user_criteria']")
	public  WebElement txt_canread;

	@FindBy(xpath = ".//*[@id='kb_knowledge.can_read_user_criteria_lock']")
	public  WebElement select_canread;

	@FindBy(xpath = "//iframe[@id='kb_knowledge.text_ifr' and contains(title, 'Text')]")
	public  WebElement txt_iframe;

	@FindBy(xpath = ".//*[@id='sysverb_insert']")
	public  WebElement btn_submit;

	@FindBy(xpath = ".//*[@id='c09f1ed2ff4131009b20ffffffffff56']/div/div")
	public  WebElement myKnowlede_lnk;

	@FindBy(xpath = "//table/tbody/tr/td/div/table/tbody/tr/td[3]/a")
	public  WebElement click_KB_number;

	@FindBy(xpath = ".//*[@id='kb_knowledge_table']/thead/tr[2]/td[4]/div/div/div/input")
	public  WebElement get_KB_Sd;

	// @FindBy(xpath = "//button[contains(.,'Request for Approval')]")
	@FindBy(xpath = "//*[@id='request_for_approval']")
	public  WebElement btn_Request_for_Approval;

	// @FindBy(xpath = "//button[contains(.,'Checkout')]")
	@FindBy(xpath = "//*[@id='hrsm_knowledge']")
	public  WebElement btn_checkout;

	@FindBy(xpath = "//button[contains(.,'Retire')]")
	public  WebElement btn_Retire;

	@FindBy(xpath = ".//*[@id='tabs2_list']/span[4]/span/span[2]")
	public  WebElement approvals_tab;

	@FindBy(xpath = "//table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a")
	public  WebElement link_Approval;

	@FindBy(xpath = ".//*[@id='kb_knowledge.description']")
	public  WebElement txt_Desc;

	@FindBy(xpath = ".//*[@id='hr_comment']")
	public  WebElement retire_comment;

	@FindBy(xpath = ".//*[@id='approve']")
	public  WebElement btn_Approve;

	@FindBy(xpath = ".//*[@id='reject']")
	public  WebElement btn_reject;

	@FindBy(xpath = ".//*[@id='ok_button']")
	public  WebElement btn_OK;

	@FindBy(xpath = ".//*[@id='label.ni.kb_knowledge.direct']")
	public  WebElement chk_Attachments;

	@FindBy(xpath = ".//*[@id='activity-stream-textarea']")
	public  WebElement txt_Comments;

	@FindBy(xpath = "//span[contains(text(),'Active')]")
	public  WebElement active;

	@FindBy(xpath = "//label[@id='label.ni.kb_knowledge.active']")
	public  WebElement ckb_Active;

	@FindBy(xpath = "//div[@class='outputmsg outputmsg_error notification notification-error']")
	public  WebElement err_msg;

	@FindBy(xpath = "//span[@class='navbar_ui_actions']//button[@id='sysverb_delete']")
	public  WebElement btn_delete;

	@FindBy(xpath = "//button[@id='ok_button']")
	public  WebElement btn_accept_delete;

	@FindBy(xpath = "//*[@id='cancel_button']")
	public  WebElement btn_reject_delete;

	@FindBy(xpath = "//*[@id='knowledge_delete_confirm_form_closemodal']")
	public  WebElement btn_x_close;

	@FindBy(xpath = "//a[@id='cb1ad7720a0a3c1901fdabc99f970748']")
	public  WebElement link_viewarticle;

	@FindBy(xpath = "//*[@id='flagArticle']")
	public  WebElement btn_flagarticle;

	@FindBy(xpath = "//*[@id='suggestText']")
	public  WebElement text_suggesttext;

	@FindBy(xpath = "//button[@id='suggestChange']")
	public  WebElement btn_suggest_submit;

	@FindBy(xpath = "//div[@id='articleNumberReadonly']")
	public  WebElement kb_id;

	@FindBy(xpath = "//*[@id='tabs2_list']//span[2]//span[2]")
	public  WebElement tab_kb_feedback;

	@FindBy(xpath = "(//a[@class='linked formlink'])[1]")
	public  WebElement tab_kb_comment;

	@FindBy(xpath = "//*[@id='user_info_dropdown']")
	public  WebElement userInfoDropdown;

	@FindBy(xpath = "//*[@id='f30370019f22120047a2d126c42e7076']/div/div")
	public  WebElement allArticles;

	@FindBy(xpath = "//button[contains(.,'Publish')]")
	public  WebElement publish;

	@FindBy(xpath = "//*[@id='backButton']")
	public  WebElement backButton;

	@FindBy(xpath = "//*[@id='articleText']")
	public  WebElement flaggedText;

	@FindBy(xpath = "//*[@id='user_info_dropdown']/div/span[1]")
	public  WebElement userMenu;

	@FindBy(xpath = "//a[@id='3f0370019f22120047a2d126c42e7076']//div[@class='sn-widget-list-title'][contains(text(),'All')]")
	public  WebElement allcase;

	public void loginValidate() throws IOException, InvalidCredentialException {
		PageFactory.initElements(driver, KnowledgeCreationPage.class);
		try {
			System.out.println("Successfully Logged In to the application as " + userMenu.getText());
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Successfully Logged In to the application as " + userMenu.getText(), ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} catch (Exception e) {
			throw new InvalidCredentialException(
					"Login Failed. Please verify, your credentials or privileges to the user");
		}
	}

	public void navigateToArticleOrCase(String navigationFilter, String id) throws Exception {
		navigationfilter.sendKeys(navigationFilter);
		checkForPageLoad(driver);
		System.out.println("Navigate to Search Article Page");

		if (navigationFilter.equalsIgnoreCase("All Articles")) {
			
			logSuccess("Expected Value - "+"All Articles");
			logSuccess("Actual Value - "+navigationFilter);
			
			allArticles.click();

			driver.switchTo().frame(0);
			if (!kb_list_view_search.isDisplayed()) {
				kbKnowledgeSearch.click();
			}
			kb_list_view_search.sendKeys(id);
			kb_list_view_search.sendKeys(Keys.ENTER);
			checkForPageLoad(driver);
			Assert.assertEquals(kb_link_number.isDisplayed(), true);

			if (kb_link_number.isDisplayed()) {
				kb_link_number.click();
				System.out.println("Article searched successfully with ID " + id);
				test.get().log(Status.PASS,
						MarkupHelper.createLabel("Searched the Knowledge Article " + id, ExtentColor.GREEN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} else {
				System.out.println("Article not Found!!!");
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("Knowledge Article " + id + " not found", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}
		} else if (navigationFilter.equalsIgnoreCase("HR Case")) {
			allcase.click();
			logSuccess("Expected Value - "+"HR Case");
			logSuccess("Actual Value - "+navigationFilter);
		}

	}

}
