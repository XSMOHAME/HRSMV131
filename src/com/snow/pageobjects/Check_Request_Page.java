package com.snow.pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.snow.base.ReusableLibrary;

public class Check_Request_Page extends ReusableLibrary {
	public WebDriver driver;

	public Check_Request_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[@title='Check Request ']")
	public WebElement checkrequest;

	@FindBy(xpath = "//*[@id='s2id_sp_formfield_Select_Employee1']/a")
	public WebElement ch_selectemployee;

	@FindBy(xpath = "//div[@id='select2-drop']/div/following::ul/li[6]/div")
	public WebElement ch_employeeoption;

	@FindBy(xpath = "//input[@id='sp_formfield_GL_Number']")
	public WebElement ch_glnumber;

	@FindBy(xpath = "//*[contains(@id, 's2id_sp_formfield_Payment_Type')]/a")
	public WebElement ch_paymenttype;

	@FindBy(css = "#select2-drop")
	public List<WebElement> ch_li_paymenttype;

	@FindBy(xpath = "//div[@id='select2-drop']/ul/li[2]/div")
	public WebElement op1;

	@FindBy(xpath = "//input[@id='sp_formfield_Check_Amount']")
	public WebElement ch_checkamount;

	@FindBy(css = "#Currency_Type > div:nth-child(1) > span:nth-child(2) > div:nth-child(2)")
	public WebElement ch_currencytype;

	@FindBy(xpath = "//div[@id='select2-drop']/ul/li[3]/div")
	public WebElement op2;

	@FindBy(xpath = "//*[contains(@id, 's2id_sp_formfield_Payment_Delivery_Method')]/a")
	public WebElement ch_deliverymethod;

	@FindBy(xpath = "//div[@class='text-right ng-scope']//button[@name='submit'][contains(text(),'Submit')]")
	public WebElement submit;

	@FindBy(xpath = "//*[@id='xf9fbccf3c3603200b599b4ad81d3ae80']/div[1]/div[1]/div[1]/div[2]")
	public WebElement caseid;

	// -----------------------Case ITIL Virew ---------------------------

	@FindBy(xpath = "	//input[@id='filter']")
	public WebElement leftsearch;

	// @FindBy(xpath="//*[@id='7a5330019f22120047a2d126c42e70e0']/div")

	@FindBy(xpath = "//a[@id='3f0370019f22120047a2d126c42e7076']//div[@class='sn-widget-list-title'][contains(text(),'All')]")
	public WebElement allcase;

	@FindBy(xpath = ".//table[@id='sn_hr_core_case_table']//input[@id='sn_hr_core_case_table_header_search_control']")
	public WebElement casenumber;

	@FindBy(xpath = "//a[@class='linked formlink']")
	public WebElement itil_caseID;

	@FindBy(xpath = "//input[@id='sys_display.sn_hr_core_case_payroll.assignment_group']")
	public WebElement assignment_group;

	@FindBy(xpath = "//input[@id='sys_display.sn_hr_core_case_payroll.assigned_to']")
	public WebElement assign_to;

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

	@FindBy(xpath = "//span[@class='navbar_ui_actions']//button[@id='sysverb_update']")
	public WebElement update;

	public void create_checkrequest() throws IOException {
		PageFactory.initElements(driver, Check_Request_Page.class);
		String GLNumber = "12345";
		String CheckAmount = "123";
		test.get().log(Status.INFO, MarkupHelper.createLabel("**CREATION OF CHECK REQUEST FORM**", ExtentColor.ORANGE));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		waitForElementToBeClickable(driver, ch_selectemployee);
		ch_selectemployee.click();
		waitForElementToBeClickable(driver, ch_employeeoption);
		ch_employeeoption.click();

		executor.executeScript("arguments[0].scrollIntoView();", ch_glnumber);
		waitForElementToBeClickable(driver, ch_glnumber);
		ch_glnumber.sendKeys(GLNumber);
		waitForElementToBeClickable(driver, ch_paymenttype);
		ch_paymenttype.click();

		for (WebElement e : ch_li_paymenttype) {
			System.out.println(e.getText());
		}
		op1.click();
		ch_checkamount.sendKeys(CheckAmount);
		waitForElementToBeClickable(driver, ch_deliverymethod);
		ch_deliverymethod.click();
		waitForElementToBeClickable(driver, op2);
		op2.click();

		executor.executeScript("arguments[0].scrollIntoView();", submit);
		waitForElementToBeClickable(driver, submit);
		test.get().log(Status.INFO, MarkupHelper.createLabel("Scrolling down to SUBMIT button", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		submit.click();
		waitForPageLoad(driver);
	}
}