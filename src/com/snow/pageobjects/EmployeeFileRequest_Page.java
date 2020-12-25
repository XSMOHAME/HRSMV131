package com.snow.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.snow.base.ReusableLibrary;

public class EmployeeFileRequest_Page extends ReusableLibrary {
	public WebDriver driver;

	public EmployeeFileRequest_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[@title='Employee File Request']")
	public WebElement efr_employeefilerequest;

	@FindBy(xpath = ".//*[@id='s2id_sp_formfield_Select_Employee']/a")
	public WebElement efr_selectemployee;

	@FindBy(xpath = "//div[@id='select2-drop']/div/following::ul/li[6]/div")
	public WebElement efr_op3;

	@FindBy(id = "s2id_autogen5")
	public WebElement efr_documenttype;

	@FindBy(xpath = "//*[@id='s2id_sp_formfield_Document_Type']/descendant::input")
	public WebElement efr_document_type;

	@FindBy(xpath = "//div[@id='Document_Type']//label[@class='field-label ng-binding ng-scope']")
	public WebElement efr_document_type_label;

	@FindBy(xpath = "//div[@id='select2-drop']/ul/li[2]/div")
	public WebElement efr_opt2;

	@FindBy(xpath = "//textarea[@id='sp_formfield_Additional_Notes']")
	public WebElement efr_additionalnotes;

	@FindBy(xpath = "//*[@id='s2id_sp_formfield_{{::field.name}}']")
	public WebElement efr_dhasearch;

	@FindBy(xpath = "//div[@id='select2-drop']/div/following::ul/li[2]/div")
	public WebElement efr_op1;

	@FindBy(xpath = "//div[@id='select2-drop']/div/following::ul/li[3]/div")
	public WebElement efr_op2;

	@FindBy(xpath = "//*[@id='s2id_sp_formfield_Request_Type']/a")
	public WebElement efr_requesttype;

	@FindBy(xpath = "//*[@id='s2id_sp_formfield_Delivery_Method']/a")
	public WebElement efr_deliverymethod;

	@FindBy(xpath = "//*[@id='xf9fbccf3c3603200b599b4ad81d3ae80']/div[1]/div[1]/div[1]/div[2]")
	public WebElement caseid;

	@FindBy(xpath = "//div[contains(@class,'text-right ng-scope')]//button[contains(@name,'submit')][contains(text(),'Submit')]")
	public WebElement submit;

	@FindBy(xpath = "	//input[@id='filter']")
	public WebElement leftsearch;

	@FindBy(xpath = "//a[@id='3f0370019f22120047a2d126c42e7076']//div[@class='sn-widget-list-title'][contains(text(),'All')]")
	public WebElement allcase;

	@FindBy(xpath = ".//table[@id='sn_hr_core_case_table']//input[@id='sn_hr_core_case_table_header_search_control']")
	public WebElement casenumber;

	@FindBy(xpath = "//a[@class='linked formlink']")
	public WebElement itil_caseID;

	@FindBy(xpath = "//select[@id='sn_hr_core_hr_employee_services.state']")
	public WebElement employee_services_state;

	@FindBy(xpath = "//input[@id='sys_display.sn_hr_core_hr_employee_services.assignment_group']")
	public WebElement assignment_group;

	@FindBy(xpath = "//input[@id='sys_display.sn_hr_core_hr_employee_services.assigned_to']")
	public WebElement assign_to;

	@FindBy(xpath = "//select[@id='sn_hr_core_hr_employee_services.priority']")
	public WebElement employee_services_priority;

	@FindBy(xpath = ".//*[@id='sys_display.sn_hr_core_hr_employee_services.hr_service']")
	public WebElement employee_services_hr_service;

	@FindBy(xpath = ".//*[@id='sys_display.sn_hr_core_hr_employee_services.opened_for']")
	public WebElement employee_services_opened_for;

	@FindBy(xpath = "//span[@class='navbar_ui_actions']//button[@id='sysverb_update']")
	public WebElement update;

	@FindBy(xpath = "//td[@class='list_decoration_cell col-small col-center embedded']//a[@class='btn btn-icon table-btn-lg icon-info list_popup']")
	public WebElement Task_info_1;

	@FindBy(xpath = "//a[contains(@class,'btn btn-icon table-btn-lg icon-info list_popup')]")
	public WebElement Task_info_2;

	@FindBy(xpath = "//a[@class='btn btn-sm btn-default pop-over-button pull-right']")
	public WebElement Task1_open_record;

	@FindBy(xpath = "//a[contains(@class,'btn btn-sm btn-default pop-over-button pull-right')]")
	public WebElement Task2_open_record;

	@FindBy(xpath = "//input[@id='sn_hr_core_task.parent_label']")
	public WebElement task_parent_caseid;

	@FindBy(xpath = "//input[@id='sys_display.sn_hr_core_task.assigned_to']")
	public WebElement Task_assign_to;

	@FindBy(xpath = "//select[@id='sn_hr_core_task.state']")
	public WebElement Task_state;

	@FindBy(xpath = "//option[@value='20']")
	public WebElement Task_resolved;

	@FindBy(xpath = "//span[@class='navbar_ui_actions']//button[@id='sysverb_update']")
	public WebElement Task_submit;

	@FindBy(xpath = "//textarea[@id='activity-stream-work_notes-textarea']")
	public WebElement Task_worknotes;

	@FindBy(xpath = "//span[contains(@class,'outputmsg_text')]")
	public WebElement Task_wn_err_msg;

	@FindBy(xpath = "//span[contains(text(),'Sibling Tasks (1)')]")
	public WebElement Task_sibling_rel;

	@FindBy(xpath = "//input[@id='sn_hr_core_task.short_description']")
	public WebElement Task_short_Desc;

	String expected_task1_sh_desc = "Send original file to Requestor";
	String expected_task2_sh_desc = "Original file returned";
	String expectedag = "HRSM - Administration";
	String expectedpr = "2 - Moderate";
	String expectedhrservice = "Employee File Request";

	public void create_employeefilerequest() throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		waitForElementToBeClickable(driver, efr_selectemployee);
		efr_selectemployee.click();
		waitForElementToBeClickable(driver, efr_op3);
		efr_op3.click();
		executor.executeScript("arguments[0].scrollIntoView();", efr_document_type_label);

		waitForElementToBeClickable(driver, efr_document_type);
		efr_document_type.click();
		waitForPageLoad(driver);
		efr_opt2.click();

		waitForElementToBeClickable(driver, efr_additionalnotes);
		efr_additionalnotes.sendKeys("Automation Test Execution ");

		waitForElementToBeClickable(driver, efr_requesttype);
		efr_requesttype.click();
		waitForAction(driver);
		waitForElementToBeClickable(driver, efr_op2);
		efr_op2.click();

		waitForElementToBeClickable(driver, efr_deliverymethod);
		efr_deliverymethod.click();
		waitForElementToBeClickable(driver, efr_op2);
		efr_op2.click();

		executor.executeScript("arguments[0].scrollIntoView();", submit);
		waitForAction(driver);
		waitForElementToBeClickable(driver, submit);
		submit.click();
		System.out.println("Submitted Successfully");
	}
}