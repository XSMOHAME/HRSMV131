package com.snow.pageobjects;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class ResidualsFormPage extends ReusableLibrary {
	public WebDriver driver;

	public ResidualsFormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@class = 'form-control']")
	public WebElement searchHRCaseDropDown;

	@FindBy(xpath = "//input[@class = 'form-control' and @placeholder = 'Search']")
	public WebElement searchHRCaseTextBox;

	@FindBy(id = "sp_formfield_First_Name")
	public WebElement empfirstName;

	@FindBy(xpath = "//*[@id='s2id_autogen5']")
	public WebElement documentType2;

	@FindBy(xpath = "//*[contains(@id,'s2id_sp_formfield_Document_Type')]/ul/li/input")
	public WebElement documentType;

	@FindBy(xpath = "//*[text()='TWID']")
	public WebElement twidLabel;

	@FindBy(xpath = "//*[@id='sp_formfield_Other_document_type']")
	public WebElement specifyOtherDocumentType;

	@FindBy(xpath = "//*[contains(@id, 's2id_autogen5_choice_')]/a")
	public WebElement documentTypeRemove;

	@FindBy(xpath = "//*[@id = 'select2-chosen-1']/parent::a")
	public WebElement requestType;

	@FindBy(xpath = "//input[@id='s2id_autogen1_search']")
	public WebElement requestTypeInput;

	@FindBy(xpath = "//*[contains(@id,'select2-chosen-3')]//parent::a//parent::div[contains(@class, 'disabled')]")
	public WebElement fileShare;

	@FindBy(xpath = "//*[@id='s2id_sp_formfield_Delivery_Method']/a")
	public WebElement fileShareText;

	@FindBy(id = "sp_formfield_Date_Needed")
	public WebElement dateTime;

	@FindBy(xpath = "//*[@id='Delivery_Method']/div/label/span/span")
	public WebElement deliverymethodastrix;

	@FindBy(xpath = "//*[@id='select2-chosen-3']")
	public WebElement deliverymethod;

	@FindBy(xpath = "//*[@id='s2id_sp_formfield_Delivery_Method']/a")
	public WebElement deliverymethodDropDown;

	@FindBy(xpath = "//*[@id='sp_formfield_Delivery_Method']/option")
	public WebElement deliverymethodoptions;

	@FindBy(xpath = "//*[@id='s2id_autogen3_search']")
	public WebElement deliverymethodoptionsselect;

	@FindBy(id = "sp_formfield_return_date")
	public WebElement expDocumentReturnDate;

	@FindBy(xpath = "//*[@id='sp_formfield_bill_to_my_courier_account']")
	public WebElement billInMyCourier;

	@FindBy(xpath = "//*[@id='bill_to_my_courier_account']/div/div/div")
	public WebElement billInMyCourierError;

	@FindBy(xpath = "//*[@id='sp_formfield_Delivery_Address']")
	public WebElement deliveryAddressInput;

	@FindBy(xpath = "//*[@id='Date_Needed']/div/span/div[2]/span/button")
	public WebElement calenderButton;

	@FindBy(xpath = "//*[contains(@id,'select2-chosen-2') and contains(text(),'US/Pacific')]")
	public WebElement timeZone;

	@FindBy(xpath = "//*[contains(@id,'s2id_sp_formfield_Timezone')and contains(@class,'disabled')]")
	public WebElement timeZoneDisabled;

	@FindBy(xpath = "//*[@id='sp_formfield_alternate_contact']")
	public WebElement alternateContact;

	@FindBy(xpath = "//*[@name='submit']")
	public WebElement submitButton;

	@FindBy(xpath = "//*[contains(@class,'title-info ng-binding')]")
	public WebElement caseID;

	@FindBy(xpath = "//input[@id='filter']")
	public WebElement filterNavigator;

	@FindBy(xpath = "//ul[contains(@aria-label, 'All HR Cases')]/descendant::a/div/div[text() = 'Open']")
	public WebElement openHRCase;

	@FindBy(xpath = "//a[@class='linked formlink']")
	public WebElement hrcNo;

	@FindBy(xpath = "//*[@class='list_row list_odd embedded list_row_compact']/td[3]/a")
	public WebElement hrtNo;

	@FindBy(xpath = "//h2[text() = 'Tasks']")
	public WebElement taskHeading;

	@FindBy(xpath = "//*[@id='sn_hr_core_hr_employee_services.u_return_date_needed']")
	public WebElement expDocRetDate;

	@FindBy(xpath = "//*[@id='sys_display.sn_hr_core_hr_employee_services.assignment_group']")
	public WebElement assgnGroup;

	@FindBy(xpath = "//*[@id='lookup.sn_hr_core_hr_employee_services.assigned_to']/span")
	public WebElement assgnTo;

	@FindBy(xpath = "//*[@class='glide_ref_item_link']")
	public WebElement worker;

	@FindBy(xpath = "//*[@id='sn_hr_core_hr_employee_services.state']")
	public WebElement state;

	@FindBy(xpath = "//nav[@class='navbar navbar-default section_zero  ng-scope']/div[@class='container-fluid']")
	public WebElement header;

	@FindBy(id = "sys_readonly.sn_hr_core_task.number")
	public WebElement caseNumber;

	@FindBy(xpath = "//*[@id='context_1']/div[2]")
	public WebElement headerSave;

	@FindBy(xpath = "//*[@class='h2 m-t-none m-b-sm font-thin ng-binding ng-scope']")
	public WebElement formLabel;

	@FindBy(xpath = "//a[contains(@class, 'logo')]")
	public WebElement homeLogo;

	@FindBy(xpath = "//*[@class='text-muted sc-cat-item-short-description ng-binding ng-scope']")
	public WebElement formShortDesc;

	@FindBy(xpath = "//*[@id='s2id_sp_formfield_ssn_sw']/a")
	public WebElement selectWorker;

	@FindBy(xpath = "//*[@id='s2id_sp_formfield_payee']/a")
	public WebElement selectPayee;

	@FindBy(xpath = "//*[contains(@id,'s2id_sp_formfield_Select_Employee')]/a")
	public WebElement selectWorker2;

	@FindBy(xpath = "//*[@id='select2-drop']/div/input")
	public WebElement inputWorker2;

	@FindBy(xpath = "//*[contains(@class,'select2-input')]")
	public WebElement searchWorker;

	@FindBy(xpath = "//label[contains(text(),'Select Payee')]/following-sibling::input")
	public WebElement searchPayee;

	@FindBy(id = "sp_formfield_ssn_twid")
	public WebElement twid;

	@FindBy(id = "sp_formfield_twid")
	public WebElement payeeTwid;

	@FindBy(id = "sp_formfield_ssn_Wfn")
	public WebElement firstName;

	@FindBy(id = "sp_formfield_payee_first_name")
	public WebElement payeeFirstName;

	@FindBy(id = "sp_formfield_ssn_wln")
	public WebElement lastName;

	@FindBy(id = "sp_formfield_payee_last_name")
	public WebElement payeeLastName;

	@FindBy(id = "sp_formfield_ssn_wcn")
	public WebElement corporationName;

	@FindBy(id = "sp_formfield_payee_company_name")
	public WebElement payeeCorporationName;

	@FindBy(xpath = "//button[contains(@title,'Preview')]")
	public WebElement iIcon;

	@FindBy(xpath = "//*[contains(@class,'h4 ng-binding') and contains(text(),'HR Profile')]")
	public WebElement hrProfile;

	@FindBy(xpath = "//*[contains(@class,'fa fa-close text-base sp-form-modal-close-button')]")
	public WebElement closeHRProfile;

	@FindBy(xpath = "//*[@for='sp_formfield_bene_ssnorfein']/child::span/span[@ng-show ='field.mandatory']")
	public WebElement mandatIndicatorSSNorFEIN;

	@FindBy(xpath = "//*[@for='sp_formfield_ssn_updated']/child::span/span[@ng-show ='field.mandatory']")
	public WebElement mandatIndicatorUpdatedSSN;

	@FindBy(xpath = "//*[@for='sp_formfield_fein_updated']/child::span/span[@ng-show ='field.mandatory' and @class = 'fa fa-asterisk mandatory']")
	public WebElement mandatIndicatorUpdatedFein;

	@FindBy(xpath = "//*[@for='sp_formfield_name_corpo']/child::span/span[@ng-show ='field.mandatory' and @class = 'fa fa-asterisk mandatory']")
	public WebElement mandatIndicatorUpdatedCorp;

	@FindBy(xpath = "//*[@for='sp_formfield_end_date']/child::span/span[@ng-show ='field.mandatory']")
	public WebElement mandatIndicatorExpirationDate;

	@FindBy(xpath = "//*[@id='sp_formfield_bene_ssnorfein']")
	public WebElement fieldSSNorFEIN;

	@FindBy(xpath = "//*[@id='sp_formfield_ssn_updated']")
	public WebElement updatedSSN;

	@FindBy(id = "sp_formfield_fein_updated")
	public WebElement updatedFEIN;

	@FindBy(id = "sp_formfield_name_corpo")
	public WebElement updatedCorp;

	@FindBy(xpath = "//*[@title='show/hide this value']")
	public WebElement showButton;

	@FindBy(xpath = "//*[@for='sp_formfield_dateof_worker_death']/child::span/span[@ng-show ='field.mandatory']")
	public WebElement mandatIndicatorWorkerDeathDate;

	@FindBy(id = "sp_formfield_dateof_worker_death")
	public WebElement workerDeathDate;

	@FindBy(xpath = "//*[@id='sp_formfield_end_date']")
	public WebElement expirationDate;

	@FindBy(xpath = "//*[contains(text(), 'Date selected should be a past date.')]")
	public WebElement futureDateErrorMessage;

	@FindBy(xpath = "//*[@for='sp_formfield_BN_Corp']/child::span/span[@ng-show ='field.mandatory']")
	public WebElement mandatIndicatorBeneficiaryDetail;

	@FindBy(xpath = "//*[@id='sp_formfield_BN_Corp']")
	public WebElement beneficiaryDetail;

	@FindBy(id = "sp_formfield_ssn_EDC")
	public WebElement effectiveDateOfChange;

	@FindBy(xpath = "//*[contains(@id,'sp_formfield') and contains(@id,'_comments')]")
	public WebElement comments;

	@FindBy(id = "sp_formfield_u_name")
	public WebElement pocName;

	@FindBy(id = "sp_formfield_u_workemail")
	public WebElement pocEmail;

	@FindBy(id = "sp_formfield_phone_number")
	public WebElement pocPhoneNumber;

	@FindBy(xpath = "//*[@for='sp_formfield_u_name']/child::span/span[@ng-show ='field.mandatory']")
	public WebElement mandatIndicatorPOCName;

	@FindBy(xpath = "//*[contains(@id,'sp_formfield_u_workemail') and contains(@readonly, 'readonly')]")
	public WebElement pocEmailReadOnly;

	@FindBy(xpath = "//*[contains(@id,'sp_formfield_phone_number') and contains(@readonly, 'readonly')]")
	public WebElement pocPhoneNumberReadOnly;

	@FindBy(xpath = "//*[contains(@id,'case_info')]")
	public WebElement caseInfo;

	@FindBy(xpath = "//*[contains(@class,'case-title ng-binding')]")
	public WebElement caseTitle;

	@FindBy(xpath = "//*[contains(@ng-if,'field.fieldDisplayValue')]")
	public WebElement shortDesc;

	@FindBy(xpath = "//*[contains(text(), 'Requested by')]")
	public WebElement requestedBy;

	@FindBy(xpath = "//*[contains(text(), 'About')]")
	public WebElement about;

	@FindBy(xpath = "//*[contains(@class, 'description panel b')]")
	public WebElement caseDesc;

	@FindBy(xpath = "//*[@class='col-sm-6 attachment']")
	public WebElement attachmentSection;

	@FindBy(xpath = "(//*[@class='file-upload-input'])[1]")
	public WebElement addAttachmentBtn;

	@FindBy(xpath = ".//input[@type = 'file']")
	public WebElement addAttachment;

	
//	@FindBy(xpath = "//*[@aria-label='Download attachment']")
	@FindBy(xpath = "//*[@aria-label='Download attachment AutomationTest.txt']")
	public WebElement attachmentAvailable;

	@FindBy(xpath = "//*[contains(text(), 'Add attachments')]")
	public WebElement lowerAddAttachment;

	@FindBy(xpath = "//*[@class='col-sm-6 history']")
	public WebElement historySection;

	@FindBy(xpath = "(//button[@name='submit' and text()='Submit'])[1]")
	public WebElement submit;

	@FindBy(xpath = "//*[@class='ng-binding' and @ng-bind-html = '::m.message']")
	public WebElement errorMandatoryFields;

	@FindBy(xpath = "//*[@aria-label='Close Notification']")
	public WebElement closeError;

	@FindBy(xpath = "//*[@class='outputmsg_container']//*[@id='close-messages-btn' and @aria-label = 'Close Messages']")
	public WebElement closeError1;

	@FindBy(xpath = "//*[@class='ng-binding']/div/span")
	public WebElement attachHireDesc;

	@FindBy(xpath = "//*[@sn-atf-area='Name Change Mandatory']")
	public WebElement nameChangeDesc;

	@FindBy(xpath = "//*[@for = 'sp_formfield_NC_fn']//following-sibling::span//child::i")
	public WebElement firstNameDropIcon;

	@FindBy(xpath = "//*[@for = 'sp_formfield_NC_fn']//following-sibling::span//child::div[contains(@class,'text-muted well')]")
	public WebElement firstNameMoreInfo;

	@FindBy(xpath = "//*[@for = 'sp_formfield_NC_ln']//following-sibling::span//child::i")
	public WebElement lastNameDropIcon;

	@FindBy(xpath = "//*[@for = 'sp_formfield_NC_ln']//following-sibling::span//child::div[contains(@class,'text-muted well')]")
	public WebElement lastNameMoreInfo;

	@FindBy(xpath = "//*[@for='sp_formfield_NC_fn']/child::span/span[@ng-show ='field.mandatory']")
	public WebElement mandatIndicatorFirstName;

	@FindBy(xpath = "//*[@for='sp_formfield_NC_ln']/child::span/span[@ng-show ='field.mandatory']")
	public WebElement mandatIndicatorLastName;

	@FindBy(xpath = "//*[@for='sp_formfield_ssn_EDC']/child::span/span[@ng-show ='field.mandatory']")
	public WebElement mandatIndicatorEffectiveDateofChange;

	@FindBy(xpath = "//*[@id='sp_formfield_NC_comments']")
	public WebElement nameChangeComments;

	@FindBy(xpath = "//*[@id='sp_formfield_ssn_comments']")
	public WebElement updateSSNComments;

	@FindBy(xpath = "//*[@id='sp_formfield_fein_comments']")
	public WebElement updateFEINComments;

	@FindBy(xpath = "//*[@id='sp_formfield_NC_fn']")
	public WebElement nameChangeFirstName;

	@FindBy(xpath = "//*[@id='sp_formfield_NC_ln']")
	public WebElement nameChangeLastName;

	@FindBy(xpath = "//*[@id='s2id_sp_formfield_rsd_request_type']/a")
	public WebElement requestTypeDropDown;

	@FindBy(xpath = "//*[contains(@id,'select2-drop') and contains(@class, 'select2-with-searchbox')]/child::div/input")
	public WebElement dropDowSearchBox;

	@FindBy(xpath = "//*[@class='panel-body ng-binding']")
	public WebElement caseDescDetails;

	@FindBy(xpath = "//*[contains(text(), 'Cash Pro Status')]")
	public WebElement cashProText;

	@FindBy(xpath = "//*[@id='sp_formfield_rsd_issue_cancelled']")
	public WebElement issueCancelledCheckbox;

	@FindBy(xpath = "//*[@id='s2id_sp_formfield_rsd_reason']/a")
	public WebElement reasonDropDown;

	@FindBy(xpath = "//*[@id='s2id_sp_formfield_sap_company_code']/a")
	public WebElement sapCompanyCodeDropDown;

	@FindBy(id = "attachment_add")
	public WebElement addAttachmentFile;

	@FindBy(id = "sp_formfield_sap_gl_number")
	public WebElement sapGlNumber;

	@FindBy(id = "sp_formfield_check_date")
	public WebElement checkDate;

	// Labels
	@FindBy(xpath = "//label[contains(@aria-label, 'Select Worker')]")
	public WebElement labelSelectWorker;

	@FindBy(xpath = "//label[contains(@aria-label, 'Select Payee')]")
	public WebElement labelSelectPayee;

	@FindBy(xpath = "//label[contains(@for, 'sp_formfield_ssn_twid')]")
	public WebElement labelTwid;

	@FindBy(xpath = "//label[contains(@for, 'sp_formfield_twid')]")
	public WebElement labelTwidPaymentReq;

	@FindBy(xpath = "//label[contains(@for, 'sp_formfield_ssn_Wfn')]")
	public WebElement labelWorkerFirstName;

	@FindBy(xpath = "//label[contains(@for, 'sp_formfield_payee_first_name')]")
	public WebElement labelPayeeFirstName;

	@FindBy(xpath = "//label[contains(@for, 'sp_formfield_ssn_wln')]")
	public WebElement labelWorkerLastName;

	@FindBy(xpath = "//label[contains(@for, 'sp_formfield_payee_last_name')]")
	public WebElement labelPayeeLastName;

	@FindBy(xpath = "//label[contains(@for, 'sp_formfield_ssn_wcn')]")
	public WebElement labelCorp;

	@FindBy(xpath = "//label[contains(@for, 'sp_formfield_payee_company_name')]")
	public WebElement labelPayeeCorp;

	@FindBy(xpath = "//label[contains(@for, 'sp_formfield_bene_ssnorfein')]")
	public WebElement labelSSN;

	@FindBy(xpath = "//label[contains(@for, 'sp_formfield_BN_Corp')]")
	public WebElement labelBeneficiaryName;

	@FindBy(xpath = "//label[contains(@for, 'sp_formfield_dateof_worker_death')]")
	public WebElement labelWorkerDeath;

	@FindBy(xpath = "//label[contains(@for, 'sp_formfield_ssn_EDC')]")
	public WebElement labelEffectiveDateOfChange;

	@FindBy(xpath = "//label[contains(@for, 'sp_formfield_u_name')]")
	public WebElement labelPocName;

	@FindBy(xpath = "//label[contains(@for, 'sp_formfield_u_workemail')]")
	public WebElement labelWorkEmail;

	@FindBy(xpath = "//label[contains(@for, 'sp_formfield_phone_number')]")
	public WebElement labelPhoneNumber;

	@FindBy(xpath = "(//label[contains(@for, 'sp_formfield_ssn_updated')])[1]")
	public WebElement labelUpdatedSSN;

	@FindBy(xpath = "(//label[contains(@for, 'sp_formfield_NC_fn')])[1]")
	public WebElement labelNameChangeFirstName;

	@FindBy(xpath = "(//label[contains(@for, 'sp_formfield_NC_ln')])[1]")
	public WebElement labelNameChangeLastName;

	@FindBy(xpath = "(//label[contains(@for, 'sp_formfield_end_date')])[1]")
	public WebElement labelExpirationDate;

	@FindBy(xpath = "(//label[contains(@for, 'sp_formfield_fein_updated')])[1]")
	public WebElement labelUpdatedFEIN;

	@FindBy(xpath = "(//label[contains(@for, 'sp_formfield_name_corpo')])[1]")
	public WebElement labelUpdatedCorp;

	@FindBy(xpath = "(//label[contains(@for, 'sp_formfield_rsd_request_type')])[1]")
	public WebElement labelRequestType;

	@FindBy(xpath = "(//label[contains(@for, 'sp_formfield_sap_company_code')])[1]")
	public WebElement labelSapCompanyCode;

	@FindBy(xpath = "(//label[contains(@for, 'sp_formfield_check_number')])[1]")
	public WebElement labelCheckNumber;

	@FindBy(xpath = "(//label[contains(@for, 'sp_formfield_check_date')])[1]")
	public WebElement labelCheckDate;

	@FindBy(xpath = "(//label[contains(@for, 'sp_formfield_net_amount')])[1]")
	public WebElement labelNetAmount;

	@FindBy(xpath = "(//label[contains(@for, 'sp_formfield_additional_comments')])[1]")
	public WebElement labelAdditionalComments;

	@FindBy(xpath = "(//label[contains(@for, 'sp_formfield_rsd_reason')])[1]")
	public WebElement labelReasonType;

	@FindBy(xpath = "(//label[contains(@for, 'sp_formfield_sap_gl_number')])[1]")
	public WebElement labelSapGlNumber;

	@FindBy(xpath = "(//label[contains(@for, 'sp_formfield_hire_batch_desc')])[1]")
	public WebElement labelHireBatchDesc;

	@FindBy(xpath = "(//label[contains(@for, 'sp_formfield_number_of_hires')])[1]")
	public WebElement labelNoOfHires;

	@FindBy(xpath = "//select[contains(@class, 'form-control default-focus-outline')]")
	public WebElement searchDropDown;

	@FindBy(xpath = "//div[@class='input-group']/input")
	public WebElement searchHRCase;

	@FindBy(xpath = "//td[contains(@class,'vt') and text()='Send File to Requester']")
	public WebElement sendFiletoReq;

	@FindBy(id = "sys_display.sn_hr_core_task.assigned_to")
	public WebElement assignedTo;

	@FindBy(xpath = "//*[@id='lookup.sn_hr_core_task.assigned_to']")
	public WebElement assignedToMglass;

	@FindBy(xpath = "//input[@id='sys_user_table_header_search_control']")
	public WebElement assignedToMsearch;

	@FindBy(xpath = "//*[@id='row_sys_user_b8f3ccffdb07634082e3751c8c961994']/td[3]/a")
	public WebElement assignedToMsearchUser;

	@FindBy(xpath = "//select[contains(@id, 'sn_hr_core_') and contains(@id, 'state')]")
	public WebElement HRState;

	@FindBy(id = "activity-stream-work_notes-textarea")
	public WebElement workNotes;

	@FindBy(xpath = "//*[@id='fieldmsg-singleinput-7']/li")
	public WebElement workNotesError;

	@FindBy(xpath = "//*[@id='close-messages-btn']")
	public WebElement closeWorkNotesError;

	@FindBy(xpath = "//button[@class='btn btn-default pull-right activity-submit']")
	public WebElement postButton;

	@FindBy(xpath = "//*[contains(@id, 'section-') and contains(@id, 'header')]/nav/div")
	public WebElement header2;

	@FindBy(xpath = "//*[@id='viewr.sn_hr_core_task.parent']")
	public WebElement icon;

	@FindBy(xpath = "//*[@class='popover-title']")
	public WebElement iconServiceCase;

	@FindBy(xpath = "//*[contains(@class,'popover-header')]/a")
	public WebElement openRecord;

	@FindBy(xpath = "//*[@class='list_row list_odd embedded list_row_compact']/td[5]")
	public WebElement taskState;

	@FindBy(id = "sp_formfield_check_number")
	public WebElement checkNumber;

	@FindBy(xpath = "//*[@id='check_date']/div/span/div/span/button")
	public WebElement calendarIcon;

	@FindBy(xpath = "//table[@class ='table-condensed']/tbody/tr/td[contains(@class, 'active today')]/div[contains(@aria-label,'Date picker is opened')]")
	public WebElement today;

	@FindBy(xpath = "(//table[@class ='table-condensed']/thead/tr/th[@class='next'])[1]")
	public WebElement nextMonth;

	@FindBy(xpath = "(//table[@class ='table-condensed']/thead/tr/th[@class='prev'])[1]")
	public WebElement previousMonth;

	@FindBy(xpath = "(//table[@class ='table-condensed']/tbody/tr[2]/td[1]/div[@role = 'button'])[1]")
	public WebElement anyDay;

	@FindBy(xpath = "//*[contains(@ng-repeat,'message in field.messages ') and contains(text(), 'Future dates SHOULD NOT be selectable.')]")
	public WebElement futureDateWarning;

	@FindBy(xpath = "//*[contains(@ng-repeat,'message in field.messages ') and contains(text(), 'Please provide the CS Volume ID from CashPro Search Image in the additional comments below.')]")
	public WebElement checkCopyText;

	@FindBy(id = "sp_formfield_net_amount")
	public WebElement netAmount;

	@FindBy(id = "sp_formfield_additional_comments")
	public WebElement additionalComments;

	@FindBy(id = "sp_formfield_Additional_Notes")
	public WebElement additionalInformation;

	@FindBy(xpath = "(//a[@title='Download Template.'])[1]")
	public WebElement downloadLink;

	@FindBy(xpath = "//*[@id = 'sp_formfield_number_of_hires']")
	public WebElement noOfHires;

	@FindBy(xpath = "(//a[@class='linked formlink'])[1]")
	public WebElement hr_link_number;

	@FindBy(xpath = "//select[contains(@id,'_select')]")
	public WebElement searchCriteria;

	@FindBy(xpath = "//input[contains(@id,'_text')]")
	public WebElement searchTextBox;

	@FindBy(xpath = "(//*[@id='sys_user_table_header_search_control'])[1]")
	public WebElement nameSearchTextBox;

	@FindBy(xpath = "//*[@role='menuitem' and @title = 'Save record and remain here']")
	public WebElement saveOption;

	@FindBy(xpath = "//*[@id = 'sp_formfield_hire_batch_desc']")
	public WebElement hireBatchDesc;

	@FindBy(xpath = "//button[text()= 'Save' and @role = 'button']")
	public WebElement saveButton;

	@FindBy(id = "sysverb_update_bottom")
	public WebElement updateButton;

	LinkedHashMap<String, String> fieldValueMap = new LinkedHashMap<String, String>();

	/* This method is to Validate Form Navigation */
	public void validateNavigationToForm(String expectedFormLabel) throws IOException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		if (formLabel.isDisplayed()) {
			String actualFormLabel = formLabel.getText().trim();

			if (actualFormLabel.contains(expectedFormLabel)) {
				test.get().log(Status.PASS, MarkupHelper
						.createLabel("Navigation to form " + expectedFormLabel + "is successful", ExtentColor.GREEN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} else {
				test.get().log(Status.FAIL, MarkupHelper
						.createLabel("Navigation to form " + expectedFormLabel + "is failed", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}
		}
	}

	/* This method is to Validate Form Label and Form Short Description */
	public void verifyFormLableAndShortDesc(String expectedFormLabel, String expectedShortDesc) throws IOException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		fieldValueMap.clear();
		String actualFormLabel = null;
		String actualFormShortDesc = null;

		waitForElement(driver, formLabel);
		if (formLabel.isDisplayed()) {
			actualFormLabel = formLabel.getText().trim();
			if (actualFormLabel.contains(expectedFormLabel) || actualFormLabel.equalsIgnoreCase(expectedFormLabel)) {
				test.get().log(Status.PASS,
						MarkupHelper.createLabel(
								"Displayed Form Label matches with expected Form Label: " + actualFormLabel,
								ExtentColor.GREEN));
			} else {
				test.get().log(Status.FAIL, MarkupHelper
						.createLabel("Displayed Form Label does not match with expected Form Label", ExtentColor.RED));
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("Actual Label - " + actualFormLabel, ExtentColor.RED));
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("Expected Label - " + expectedFormLabel, ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}

			if (formShortDesc.isDisplayed()) {
				actualFormShortDesc = formShortDesc.getText().trim();
				if (actualFormShortDesc.contains(expectedShortDesc)) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel(
									"Displayed Form Label matches with expected Form Label: " + actualFormShortDesc,
									ExtentColor.GREEN));
				} else {
					test.get().log(Status.FAIL, MarkupHelper.createLabel(
							"Displayed Form Label does not match with expected Form Label: " + actualFormShortDesc,
							ExtentColor.RED));
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				}
			}
		}
	}

	/* This method is to Add Attachment. */
	public void addAttachment() throws IOException, Exception {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		String fileName = System.getProperty("user.dir") + File.separatorChar + "AutomationTest.txt";
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		System.out.println("File Path - " + fileName);
		System.out.println("Is Add Attachment Input enabled? - " + addAttachment.isEnabled());
		scrollToElement(driver, lowerAddAttachment);
		waitForAction(driver);

		try {
			waitForElement(driver, lowerAddAttachment);
			System.out.println("Sleeping - 2000");
			Thread.sleep(2000);
			System.out.println("Sending filename");
			waitForElementToBeClickable(driver, addAttachment);
			addAttachment.sendKeys(fileName);
			Thread.sleep(5000);
			System.out.println("Sleeping - 10000");
			System.out.println("Add Attachment Completed without any Exception");
		} catch (Exception e) {
			logFailure("Failed to add attachment: " + e.getMessage());
			logFailureScreenshot(driver);
			System.out.println("Failed to add attachment: " + e.getMessage());
		}
		
		waitForElement(driver, attachmentAvailable);
		if (isElementPresent(attachmentAvailable)) {
			logSuccess("Attachment is added Successfully");
			logSuccessScreenshot(driver);
			System.out.println("Attachment is added Successfully");
		} else {
			logFailure("Attachment is not added");
			logFailureScreenshot(driver);
			System.out.println("Attachment is not added");
		}
	}

	public void addAttachmentOld() throws IOException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		// String fname = "AutomationTest.txt";
		// String fileName = "\"" + System.getProperty("user.dir") + File.separatorChar
		// + fname + "\"";
		String fileName = "url.txt";
		// String fileName = "\"" + "C:/Users/hello/Desktop/documents/text-sample1.txt"
		// + "\"";

		// String file = "\"Residuals - New Hire Template.xlsx\"";
		/*
		 * if (executeOn.equals("System Browsers")) { fileName = "C:" +
		 * File.separatorChar + "Users" + File.separatorChar + "xajaunja" +
		 * File.separatorChar + "Downloads" + File.separatorChar + file; } else {
		 * fileName = "C:" + File.separatorChar + "Users" + File.separatorChar +
		 * "Administrator" + File.separatorChar + "Downloads" + File.separatorChar +
		 * file; }
		 */
		System.out.println("File Path - " + fileName);
		// String fileName = "C:\\Users\\Administrator\\final_output_ts.txt";
		String autoITExecutable = System.getProperty("user.dir") + File.separatorChar + "FileUploadChromeEdge "
				+ fileName;

		checkForPageLoad(driver);

		try {
			addAttachment.click();
			Thread.sleep(5000);
			Runtime.getRuntime().exec(autoITExecutable);
			logInfo("Uploading Attachment - " + fileName); // Commented by Sadam
			logInfoScreenshot(driver);
		} catch (Exception e) {
			logFailure("Failed to add attachment: " + e.getMessage());
			logFailureScreenshot(driver);
		}
		scrollToElement(driver, attachmentAvailable);
		checkForPageLoad(driver);
		if (isElementPresent(attachmentAvailable)) {
			logSuccess("Attachment is added Successfully");
			logSuccessScreenshot(driver);
		} else {
			logFailure("Attachment is not added");
			logFailureScreenshot(driver);
		}
	}

	/* Validation for Worker Information Section */
	public void validateTestWorker(String worker) throws IOException, InterruptedException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		WebElement workerClick = null;
		WebElement workerTwid = null;
		scrollToElement(driver, homeLogo);
		checkForPageLoad(driver);

		if (isElementPresent(selectWorker)) {
			selectWorker.click();
			checkForPageLoad(driver);
			waitForElementToBeClickable(driver, searchWorker);
			searchWorker.clear();
			searchWorker.sendKeys(worker);
			checkForPageLoad(driver);
			Thread.sleep(2000);

		} else if (isElementPresent(selectPayee)) {
			selectPayee.click();
			checkForPageLoad(driver);
			searchPayee.clear();
			searchPayee.sendKeys(worker);
			checkForPageLoad(driver);
			Thread.sleep(2000);

		}

		try {
			workerClick = driver
					.findElement(By.xpath("//*[contains(@class, 'select2-result-') and text() = '" + worker + "']"));

			logInfo("Worker Name is displayed in the search drop down field - " + workerClick.getText().trim());

		} catch (Exception e) {
			logFailure("Worker Name is displayed in the search drop down field - " + workerClick.getText().trim());
		}
		try {
			workerTwid = driver.findElement(By.xpath(
					"//*[contains(@class, 'select2-result-') and text() = '" + worker + "']/following-sibling::div"));
			logInfo("Worker Twid is displayed in the search drop down field - " + workerTwid.getText().trim());
		} catch (Exception e) {
			System.out.println("Element not present for worker - " + worker);
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("Worker Twid is not displayed in the search drop down field ", ExtentColor.AMBER));
		}

		if (isElementPresent(workerClick)) {
			workerClick.click();
		}
		checkForPageLoad(driver);
	}

	/* Validation for Worker Information Section */
	public void validateSelectWorker(String worker) throws IOException, InterruptedException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		WebElement workerClick = null;
		WebElement workerTwid = null;
		scrollToElement(driver, homeLogo);
		checkForPageLoad(driver);
		selectWorker.click();
		checkForPageLoad(driver);
		searchWorker.clear();
		searchWorker.sendKeys(worker);
		checkForPageLoad(driver);
		Thread.sleep(2000);

		try {
			workerClick = driver
					.findElement(By.xpath("//*[contains(@class, 'select2-result-') and text() = '" + worker + "']"));

			logInfo("Worker Name is displayed in the search drop down field - " + workerClick.getText().trim());

		} catch (Exception e) {

			logFailure("Worker Name is displayed in the search drop down field - " + workerClick.getText().trim());
		}
		try {
			workerTwid = driver.findElement(By.xpath(
					"//*[contains(@class, 'select2-result-') and text() = '" + worker + "']/following-sibling::div"));
			logInfo("Worker Twid is displayed in the search drop down field - " + workerTwid.getText().trim());
		} catch (Exception e) {

			System.out.println("Element not present for worker - " + worker);
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("Worker Twid is not displayed in the search drop down field ", ExtentColor.AMBER));
		}

		if (isElementPresent(workerClick)) {
			workerClick.click();
		}
		checkForPageLoad(driver);

		if (!twid.getAttribute("value").trim().isEmpty()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"TWID Field is Autopopulated with value:  " + twid.getAttribute("value").trim(),
							ExtentColor.GREEN));
			System.out.println("TWID Field is Autopopulated with value:  " + twid.getAttribute("value").trim());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"TWID Field value is not autopopulated" + twid.getAttribute("value").trim(), ExtentColor.RED));
		}

		if (!firstName.getAttribute("value").trim().isEmpty()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"First Name Field is Autopopulated with value:  " + firstName.getAttribute("value").trim(),
							ExtentColor.GREEN));
			System.out.println(
					"First Name Field is Autopopulated with value:  " + firstName.getAttribute("value").trim());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"First Name Field value is not autopopulated" + firstName.getAttribute("value").trim(),
							ExtentColor.RED));
		}

		if (!lastName.getAttribute("value").trim().isEmpty()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"Last Name Field is Autopopulated with value:  " + lastName.getAttribute("value").trim(),
							ExtentColor.GREEN));
			System.out
					.println("Last Name Field is Autopopulated with value:  " + lastName.getAttribute("value").trim());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"Last Name Field value is not autopopulated" + lastName.getAttribute("value").trim(),
							ExtentColor.RED));
		}

		if (!corporationName.getAttribute("value").trim().isEmpty()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Corporation Name Field is Autopopulated with value:  "
					+ corporationName.getAttribute("value").trim(), ExtentColor.GREEN));
			System.out.println("Corporation Name Field is Autopopulated with value:  "
					+ corporationName.getAttribute("value").trim());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Corporation Name Field value is not autopopulated" + corporationName.getAttribute("value").trim(),
					ExtentColor.RED));
		}

		test.get().log(Status.INFO, MarkupHelper
				.createLabel("Actual Autopopulation of field can be seen in belwo screenshot:", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

	}

	/* Validation for Payee Information Section */
	public void validateTestPayee(String payee) throws IOException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		checkForPageLoad(driver);
		scrollToElement(driver, homeLogo);
		checkForPageLoad(driver);
		selectPayee.click();
		checkForPageLoad(driver);
		waitForElement(driver, searchPayee);
		searchPayee.clear();
		searchPayee.sendKeys(payee);
		checkForPageLoad(driver);

		WebElement workerClick = null;
		WebElement workerTwid = null;

		try {
			workerClick = driver
					.findElement(By.xpath("//*[contains(@class, 'select2-result-') and text() = '" + payee + "']"));

			logInfo("Payee Name is displayed in the search drop down field - " + workerClick.getText().trim());

		} catch (Exception e) {

			logFailure("Worker Name is displayed in the search drop down field - " + workerClick.getText().trim());
		}
		try {
			workerTwid = driver.findElement(By.xpath(
					"//*[contains(@class, 'select2-result-') and text() = '" + payee + "']/following-sibling::div"));
			logInfo("Payee Twid is displayed in the search drop down field - " + workerTwid.getText().trim());
		} catch (Exception e) {

			System.out.println("Element not present for worker - " + payee);
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("Worker Twid is not displayed in the search drop down field ", ExtentColor.AMBER));
		}

		if (isElementPresent(workerClick)) {
			workerClick.click();
		}
		checkForPageLoad(driver);

	}

	/* Validation for Payee Information Section */
	public void validateSelectPayee(String payee) throws IOException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		checkForPageLoad(driver);
		scrollToElement(driver, homeLogo);
		checkForPageLoad(driver);
		selectPayee.click();
		checkForPageLoad(driver);
		waitForElement(driver, searchPayee);
		searchPayee.clear();
		searchPayee.sendKeys(payee);
		checkForPageLoad(driver);
		waitForPageLoad(driver);
		WebElement workerClick = driver
				.findElement(By.xpath("//*[contains(@class, 'select2-result') and contains(text(), '" + payee + "')]"));
		workerClick.click();
		checkForPageLoad(driver);

		if (!payeeTwid.getAttribute("value").trim().isEmpty()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"TWID Field is Autopopulated with value:  " + payeeTwid.getAttribute("value").trim(),
							ExtentColor.GREEN));
			System.out.println("TWID Field is Autopopulated with value:  " + payeeTwid.getAttribute("value").trim());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"TWID Field value is not autopopulated" + payeeTwid.getAttribute("value").trim(), ExtentColor.RED));
		}

		if (!payeeFirstName.getAttribute("value").trim().isEmpty()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"First Name Field is Autopopulated with value:  " + payeeFirstName.getAttribute("value").trim(),
					ExtentColor.GREEN));
			System.out.println(
					"First Name Field is Autopopulated with value:  " + payeeFirstName.getAttribute("value").trim());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"First Name Field value is not autopopulated" + payeeFirstName.getAttribute("value").trim(),
							ExtentColor.RED));
		}

		if (!payeeLastName.getAttribute("value").trim().isEmpty()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Last Name Field is Autopopulated with value:  " + payeeLastName.getAttribute("value").trim(),
					ExtentColor.GREEN));
			System.out.println(
					"Last Name Field is Autopopulated with value:  " + payeeLastName.getAttribute("value").trim());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"Last Name Field value is not autopopulated" + payeeLastName.getAttribute("value").trim(),
							ExtentColor.RED));
		}

		if (!payeeCorporationName.getAttribute("value").trim().isEmpty()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Corporation Name Field is Autopopulated with value:  "
					+ payeeCorporationName.getAttribute("value").trim(), ExtentColor.GREEN));
			System.out.println("Corporation Name Field is Autopopulated with value:  "
					+ payeeCorporationName.getAttribute("value").trim());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Corporation Name Field value is not autopopulated"
					+ payeeCorporationName.getAttribute("value").trim(), ExtentColor.RED));
		}

		test.get().log(Status.INFO, MarkupHelper
				.createLabel("Actual Autopopulation of field can be seen in belwo screenshot:", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

	}

	/*
	 * This method is to validate HR Profile of Payee/Worker when clicked on i Icon
	 */
	public void validateHRProfile() throws IOException {
		PageFactory.initElements(driver, ResidualsFormPage.class);

		if (iIcon.isDisplayed()) {
			iIcon.click();
			checkForPageLoad(driver);
			waitForElement(driver, hrProfile);
			if (hrProfile.isDisplayed()) {
				test.get().log(Status.PASS, MarkupHelper.createLabel("HR Profile is displayed when clicked on (i) icon",
						ExtentColor.GREEN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				closeHRProfile.click();
				checkForPageLoad(driver);
			} else {
				test.get().log(Status.FAIL, MarkupHelper
						.createLabel("HR Profile is not displayed when clicked on (i) icon", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Icon (i) is not displayed on the form", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	/* Validation for Setup Section */
	public void validateSetupSection(String ssnFEIN, String workerDeathDateString, String beneficiary)
			throws IOException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		long days = 0;
		int count = 0;
		scrollToElement(driver, corporationName);
		waitForAction(driver);
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("PST"));
		String currentDate = simpleDateFormat.format(new Date());
		LocalDate date1 = LocalDate.parse(currentDate, dateTimeFormatter);

		if (mandatIndicatorSSNorFEIN.isDisplayed()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("SSN or FEIN field is displayed as mandatory", ExtentColor.CYAN));
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("SSN or FEIN field is not displayed as mandatory", ExtentColor.RED));
		}

		if (mandatIndicatorWorkerDeathDate.isDisplayed()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Worker Death Date field is displayed as mandatory", ExtentColor.CYAN));
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Worker Death Date field is not displayed as mandatory", ExtentColor.RED));
		}

		if (mandatIndicatorBeneficiaryDetail.isDisplayed()) {
			test.get().log(Status.INFO, MarkupHelper.createLabel(
					"Beneficiary Name, Corporation, or Trust field is displayed as mandatory", ExtentColor.CYAN));
		} else {
			count++;
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Beneficiary Name, Corporation, or Trust field is not displayed as mandatory", ExtentColor.RED));
		}

		if (effectiveDateOfChange.isDisplayed()) {
			System.out.println("Effective Date of Change value is displayed as: "
					+ effectiveDateOfChange.getAttribute("value").trim());
			LocalDate date2 = LocalDate.parse(effectiveDateOfChange.getAttribute("value").trim(), dateTimeFormatter);
			days = ChronoUnit.DAYS.between(date1, date2);
			ChronoUnit.DAYS.between(date1, date2);
			System.out.println("Difference in Days: " + days);

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			df.setTimeZone(TimeZone.getTimeZone("PST"));

			if (days == 0) {
				logSuccess("Effective Date of Change value is displayed as today's date: "
						+ effectiveDateOfChange.getAttribute("value").trim());
			} else if (days == 1 && Integer.parseInt(df.format(new Date()).split(" ")[1].split(":")[0]) >= 18) {
				logSuccess(
						"Effective Date of Change value is displayed as different date as current time crossed Working Hours : "
								+ effectiveDateOfChange.getAttribute("value").trim());
			} else {
				count++;
				test.get().log(Status.FAIL, MarkupHelper.createLabel(
						"Effective Date of Change value is not displayed as today's date", ExtentColor.RED));
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel(
								"Effective Date of Change : " + effectiveDateOfChange.getAttribute("value").trim(),
								ExtentColor.RED));
				test.get().log(Status.FAIL, MarkupHelper.createLabel("Today's Date" + currentDate, ExtentColor.RED));

			}
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Effective Date of Change Field is not displayed", ExtentColor.RED));
		}

		if (count > 0) {
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		if (fieldSSNorFEIN.isDisplayed()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Entering Data in SSN or FEIN field: " + ssnFEIN, ExtentColor.CYAN));
			waitForElementToBeClickable(driver, fieldSSNorFEIN);
			fieldSSNorFEIN.click();
			waitForAction(driver);
			fieldSSNorFEIN.sendKeys(ssnFEIN);
			checkForPageLoad(driver);

			if (tempbrowser.equalsIgnoreCase("Safari")) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.alert = function(){ return true;}");
				showButton.click();
				checkForPageLoad(driver);
			} else {
				waitForElementToBeClickable(driver, showButton);
				showButton.click();
			}

			if (!StringUtils.isNumeric(ssnFEIN) || StringUtils.length(ssnFEIN) != 9) {
				if (isAlertPresent(driver)) {
					String alertText = driver.switchTo().alert().getText().trim();
					driver.switchTo().alert().accept();
					test.get().log(Status.PASS, MarkupHelper.createLabel(
							"Alert for invalid SSN or FEIN field accepted: " + alertText, ExtentColor.GREEN));
				}
			}
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("SSN or FEIN field is not displayed", ExtentColor.RED));
		}

		if (workerDeathDate.isDisplayed()) {
			LocalDate date2 = LocalDate.parse(workerDeathDateString, dateTimeFormatter);
			days = ChronoUnit.DAYS.between(date2, date1);
			System.out.println("Difference in Days: " + days);
			test.get().log(Status.INFO, MarkupHelper.createLabel(
					"Entering Data in Worker Death Date field: " + workerDeathDateString, ExtentColor.CYAN));
			workerDeathDate.sendKeys(workerDeathDateString);
			waitForAction(driver);
			workerDeathDate.sendKeys(Keys.ENTER);
			waitForAction(driver);

			if (days <= 0) {
				if (futureDateErrorMessage.isDisplayed()) {
					test.get().log(Status.PASS, MarkupHelper.createLabel(
							"Error Message for Death Date is displayed: " + futureDateErrorMessage.getText().trim(),
							ExtentColor.GREEN));
				} else {
					test.get().log(Status.FAIL,
							MarkupHelper.createLabel("Error Message for Death Date is not displayed", ExtentColor.RED));
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				}
			}
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Worker Death Date field is not displayed", ExtentColor.RED));
		}

		if (beneficiaryDetail.isDisplayed()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel(
							"Entering Data in Beneficiary Name, Corporation, or Trust field: " + beneficiary,
							ExtentColor.CYAN));
			beneficiaryDetail.clear();
			beneficiaryDetail.sendKeys(beneficiary);
			checkForPageLoad(driver);
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Beneficiary Name, Corporation, or Trust field is not displayed", ExtentColor.RED));
		}
	}

	public void validateDate(String expirationDateString) throws IOException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		long days = 0;
		int count = 0;
		scrollToElement(driver, corporationName);
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("PST"));
		String currentDate = simpleDateFormat.format(new Date());
		LocalDate date1 = LocalDate.parse(currentDate, dateTimeFormatter);

		if (mandatIndicatorExpirationDate.isDisplayed()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Expiration Date field is displayed as mandatory", ExtentColor.CYAN));
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Expiration Date field is not displayed as mandatory", ExtentColor.RED));
		}

		if (expirationDate.isDisplayed()) {
			LocalDate date2 = LocalDate.parse(expirationDateString, dateTimeFormatter);
			days = ChronoUnit.DAYS.between(date2, date1);
			System.out.println("Difference in Days: " + days);
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("Entering Data in Expiration Date field: " + expirationDateString, ExtentColor.CYAN));
			expirationDate.sendKeys(expirationDateString);
			waitForAction(driver);
			expirationDate.sendKeys(Keys.ENTER);
			waitForAction(driver);

			if (days <= 0) {
				if (futureDateErrorMessage.isDisplayed()) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel("Error Message for Expiration Date is displayed: "
									+ futureDateErrorMessage.getText().trim(), ExtentColor.GREEN));
				} else {
					test.get().log(Status.FAIL, MarkupHelper
							.createLabel("Error Message for Expiration Date is not displayed", ExtentColor.RED));
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				}
			}
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Expiration Date field is not displayed", ExtentColor.RED));
		}

		if (comments.isDisplayed() && comments.isEnabled()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Comments Field is displayed", ExtentColor.GREEN));
			System.out.println("Comments Field is displayed");
		} else {
			count++;
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Comments Field is not displayed", ExtentColor.RED));
		}

		if (addAttachmentBtn.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Attachment Field is displayed", ExtentColor.GREEN));
			System.out.println("Attachment Field is displayed");
		} else {
			count++;
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Attachment Field is not displayed", ExtentColor.RED));
		}

		if (count == 0) {
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	/* This method is to Validate Name Change Section */
	public void validateNameChangeSection(String firstName, String lastName) throws IOException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		int count = 0;
		long days = 0;
		scrollToElement(driver, corporationName);
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("PST"));
		String currentDate = simpleDateFormat.format(new Date());
		LocalDate date1 = LocalDate.parse(currentDate, dateTimeFormatter);

		if (nameChangeDesc.isDisplayed()) {
			if (nameChangeDesc.getText().trim().equals(
					"Please enter the full name as it should appear in the system. Complete both First Name and Last name fields.")) {
				logInfo("Under Name Change section following label instructions are displayed : "
						+ nameChangeDesc.getText().trim());
			} else {
				count++;
				logFailure(
						"Under Name Change section displayed label instruction does not match with expected instruction");
				logFailure("Actual instruction label displayed - " + nameChangeDesc.getText().trim());
				logFailure(
						"Expectd instruction label - Please enter the full name as it should appear in the system. Complete both First Name and Last name fields.");
			}
		} else {
			count++;
			logFailure("Under Name Change section instruction label is not displayed");
		}

		scrollPageDown(driver);

		if (firstNameDropIcon.isDisplayed()) {
			firstNameDropIcon.click();
			checkForPageLoad(driver);
			waitForElement(driver, firstNameMoreInfo);
			if (firstNameMoreInfo.getText().trim()
					.equals("Please enter the first name as it should appear in the system.")) {
				logInfo("Under First Name field following label instructions are displayed : "
						+ firstNameMoreInfo.getText().trim());
			} else {
				count++;
				logFailure(
						"Under First Name field displayed label instruction does not match with expected instruction");
				logFailure("Actual instruction label displayed - " + firstNameMoreInfo.getText().trim());
				logFailure(
						"Expectd instruction label - Please enter the first name as it should appear in the system.");
			}
		} else {
			count++;
			logFailure("Under First Name field More Information instruction label is not displayed");
		}

		if (lastNameDropIcon.isDisplayed()) {
			lastNameDropIcon.click();
			checkForPageLoad(driver);
			waitForElement(driver, lastNameMoreInfo);
			if (lastNameMoreInfo.getText().trim()
					.equals("Please enter the last name as it should appear in the system.")) {
				logInfo("Under Last Name field following label instructions are displayed : "
						+ lastNameMoreInfo.getText().trim());
			} else {
				count++;
				logFailure(
						"Under Last Name field displayed label instruction does not match with expected instruction");
				logFailure("Actual instruction label displayed - " + lastNameMoreInfo.getText().trim());
				logFailure("Expectd instruction label - Please enter the last name as it should appear in the system.");
			}
		} else {
			count++;
			logFailure("Under Last Name field More Information instruction label is not displayed");
		}

		if (mandatIndicatorFirstName.isDisplayed()) {
			logInfo("First Name field is displayed as Mandatory");
			String readonly = nameChangeFirstName.getAttribute("readonly");
			System.out.println("************************************ ReadOnly - " + readonly);
			if (readonly == null) {
				nameChangeFirstName.sendKeys(firstName);
				checkForPageLoad(driver);
				logInfo("First Name field is editable and is set to value: " + firstName);
			} else {
				count++;
				logFailure("First Name field is not editable");
			}
		} else {
			count++;
			logFailure("First Name field is not displayed as Mandatory");
		}

		if (mandatIndicatorLastName.isDisplayed()) {
			logInfo("Last Name field is displayed as Mandatory");
			String readonly = nameChangeLastName.getAttribute("readonly");
			if (readonly == null) {
				nameChangeLastName.sendKeys(lastName);
				checkForPageLoad(driver);
				logInfo("Last Name field is editable and is set to value: " + lastName);
			} else {
				count++;
				logFailure("Last Name field is not editable");
			}
		} else {
			count++;
			logFailure("Last Name field is not displayed as Mandatory");
		}

		if (mandatIndicatorEffectiveDateofChange.isDisplayed()) {
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("Effective Date  of change field is displayed as mandatory", ExtentColor.CYAN));
		} else {
			count++;
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Effective Date  of change field is not displayed as mandatory", ExtentColor.RED));
		}

		if (effectiveDateOfChange.isDisplayed()) {
			String effectiveDOC = effectiveDateOfChange.getAttribute("value").trim();
			LocalDate date2 = LocalDate.parse(effectiveDOC, dateTimeFormatter);
			days = ChronoUnit.DAYS.between(date1, date2);
			System.out.println("Difference in Days: " + days);

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			df.setTimeZone(TimeZone.getTimeZone("PST"));

			System.out.println("*********************************************Days Difference is :" + days);

			if (days == 0) {
				logSuccess("Effective Date of Change value is displayed as today's date: "
						+ effectiveDateOfChange.getAttribute("value").trim());
			} else if (days == 1 && Integer.parseInt(df.format(new Date()).split(" ")[1].split(":")[0]) >= 18) {
				logSuccess(
						"Effective Date of Change value is displayed as tomorrow's date as current time crossed Working Hours : "
								+ effectiveDateOfChange.getAttribute("value").trim());
			} else {
				count++;
				test.get().log(Status.FAIL, MarkupHelper.createLabel(
						"Effective Date of Change value is not displayed as today's date", ExtentColor.RED));
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel(
								"Effective Date of Change : " + effectiveDateOfChange.getAttribute("value").trim(),
								ExtentColor.RED));
				test.get().log(Status.FAIL, MarkupHelper.createLabel("Today's Date" + currentDate, ExtentColor.RED));

			}
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Effective Date of Change Field is not displayed", ExtentColor.RED));
		}

		if (nameChangeComments.isDisplayed() && nameChangeComments.getAttribute("readonly") == null) {
			logInfo("Comment field is displayed and editable");
		} else {
			count++;
			logFailure("Comment field either not displayed or not editable");
		}

		if (count == 0) {
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

	}

	/* This method is to Validate Request Detail Section */
	public void validateRequestDetailsSection(String updatedSSNString) throws IOException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		long days = 0;
		int count = 0;
		scrollToElement(driver, corporationName);
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("PST"));
		String currentDate = simpleDateFormat.format(new Date());
		LocalDate date1 = LocalDate.parse(currentDate, dateTimeFormatter);

		if (mandatIndicatorUpdatedSSN.isDisplayed()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Updated SSN field is displayed as mandatory", ExtentColor.CYAN));
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Updated SSN field is not displayed as mandatory", ExtentColor.RED));
		}

		if (updatedSSN.isDisplayed()) {
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("Entering Data in Updated SSN field: " + updatedSSNString, ExtentColor.CYAN));
			updatedSSN.clear();
			updatedSSN.sendKeys(updatedSSNString);
			checkForPageLoad(driver);
			showButton.click();
			if (!StringUtils.isNumeric(updatedSSNString) || StringUtils.length(updatedSSNString) > 9) {
				String alertText = driver.switchTo().alert().getText().trim();
				driver.switchTo().alert().accept();
				test.get().log(Status.PASS, MarkupHelper
						.createLabel("Alert for invalid Updated SSN field accepted: " + alertText, ExtentColor.GREEN));
			} else if (StringUtils.isNumeric(updatedSSNString) && StringUtils.length(updatedSSNString) <= 9) {
				if (isAlertPresent(driver)) {
					String alertText = driver.switchTo().alert().getText().trim();
					driver.switchTo().alert().accept();
					logFailure("Alert - " + alertText + " is displayed when entered valid data - " + updatedSSNString);

				} else {
					logInfo("Alert is not displayed when valid data is entered - " + updatedSSNString);
				}

			}
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Updated SSN field is not displayed", ExtentColor.RED));
		}

		System.out.println("Read Only " + effectiveDateOfChange.getAttribute("readonly"));

		if (effectiveDateOfChange.isDisplayed() && effectiveDateOfChange.getAttribute("readonly").equals("true")) {
			System.out.println("Effective Date of Change value is displayed as: "
					+ effectiveDateOfChange.getAttribute("value").trim());
			LocalDate date2 = LocalDate.parse(effectiveDateOfChange.getAttribute("value").trim(), dateTimeFormatter);
			days = ChronoUnit.DAYS.between(date1, date2);
			System.out.println("Difference in Days: " + days);

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			df.setTimeZone(TimeZone.getTimeZone("PST"));

			if (days == 0) {
				logSuccess("Effective Date of Change value is displayed as today's date: "
						+ effectiveDateOfChange.getAttribute("value").trim());
			} else if (days == 1 && Integer.parseInt(df.format(new Date()).split(" ")[1].split(":")[0]) >= 18) {
				logSuccess(
						"Effective Date of Change value is displayed as tomorrow's date as current time crossed Working Hours : "
								+ effectiveDateOfChange.getAttribute("value").trim());
			} else {
				count++;
				test.get().log(Status.FAIL, MarkupHelper.createLabel(
						"Effective Date of Change value is not displayed as today's date", ExtentColor.RED));
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel(
								"Effective Date of Change : " + effectiveDateOfChange.getAttribute("value").trim(),
								ExtentColor.RED));
				test.get().log(Status.FAIL, MarkupHelper.createLabel("Today's Date" + currentDate, ExtentColor.RED));

			}
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Effective Date of Change Field is not displayed", ExtentColor.RED));
		}

		if (updateSSNComments.isDisplayed() && updateSSNComments.getAttribute("readonly") == null) {
			logInfo("Comment field is displayed and editable");
		} else {
			count++;
			logFailure("Comment field either not displayed or not editable");
		}

		if (count == 0) {
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	/* This method is to Validate Request Detail Section */
	public void validateRequestDetailsSection(String updatedFEINString, String corporation) throws IOException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		scrollToElement(driver, corporationName);
		waitForElementToBeClickable(driver, updatedFEIN);
		updatedFEIN.clear();
		updatedCorp.clear();
		updatedCorp.sendKeys(Keys.TAB);
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		execute.executeScript("arguments[0].click();", effectiveDateOfChange);
		effectiveDateOfChange.click();
		checkForPageLoad(driver);

		long days = 0;
		int count = 0;
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("PST"));
		String currentDate = simpleDateFormat.format(new Date());
		LocalDate date1 = LocalDate.parse(currentDate, dateTimeFormatter);

		waitForElement(driver, mandatIndicatorUpdatedFein);
		if (isElementPresent(driver, mandatIndicatorUpdatedFein)) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Updated FEIN field is displayed as mandatory", ExtentColor.CYAN));
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Updated FEIN field is not displayed as mandatory", ExtentColor.RED));
			logFailureScreenshot(driver);
		}

		waitForElement(driver, mandatIndicatorUpdatedCorp);
		if (isElementPresent(driver, mandatIndicatorUpdatedCorp)) {
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("Updated Name of Corporation field is displayed as mandatory", ExtentColor.CYAN));
		} else {
			count++;
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Updated Name of Corporation field is not displayed as mandatory", ExtentColor.RED));
		}

		if (updatedFEIN.isDisplayed() && !updatedFEINString.isEmpty()) {
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("Entering Data in Updated FEIN field: " + updatedFEINString, ExtentColor.CYAN));
			updatedFEIN.sendKeys(updatedFEINString);
			checkForPageLoad(driver);
			showButton.click();
			if (!StringUtils.isNumeric(updatedFEINString) || StringUtils.length(updatedFEINString) > 9) {
				String alertText = driver.switchTo().alert().getText().trim();
				driver.switchTo().alert().accept();
				test.get().log(Status.PASS, MarkupHelper
						.createLabel("Alert for invalid Updated SSN field accepted: " + alertText, ExtentColor.GREEN));

				if (isElementPresent(mandatIndicatorUpdatedCorp)) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel(
									"Updated FEIN field is displayed as mandatory, after entering Invalid Updated SSN",
									ExtentColor.GREEN));
				} else {
					count++;
					test.get().log(Status.FAIL, MarkupHelper.createLabel(
							"Updated FEIN field is not displayed as mandatory, after entering Invalid Updated SSN",
							ExtentColor.RED));
				}
			} else if (StringUtils.isNumeric(updatedFEINString) && StringUtils.length(updatedFEINString) <= 9) {
				if (isAlertPresent(driver)) {
					String alertText = driver.switchTo().alert().getText().trim();
					driver.switchTo().alert().accept();
					logFailure("Alert - " + alertText + " is displayed when entered valid data - " + updatedFEINString);

				} else {
					logInfo("Alert is not displayed when valid data is entered - " + updatedFEINString);
				}

				if (isElementPresent(mandatIndicatorUpdatedFein)) {
					count++;
					test.get().log(Status.FAIL,
							MarkupHelper.createLabel(
									"Updated FEIN field is displayed as mandatory, after entering Valid Updated SSN",
									ExtentColor.RED));
				} else {
					test.get().log(Status.INFO, MarkupHelper.createLabel(
							"Updated FEIN field is not displayed as mandatory, after entering Valid Updated SSN",
							ExtentColor.CYAN));
				}
			}
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Updated SSN field is not displayed", ExtentColor.RED));
		}

		if (updatedCorp.isDisplayed() && !corporation.isEmpty()) {
			test.get().log(Status.INFO, MarkupHelper.createLabel(
					"Entering Data in Updated Name of Corporation field: " + corporation, ExtentColor.CYAN));
			updatedCorp.sendKeys(corporation);
			updatedCorp.sendKeys(Keys.TAB);
			checkForPageLoad(driver);

			if (isElementPresent(mandatIndicatorUpdatedCorp)) {
				count++;
				test.get().log(Status.FAIL, MarkupHelper.createLabel(
						"Updated Name of Corporation field is displayed as mandatory, after entering Updated SSN",
						ExtentColor.RED));
			} else {
				test.get().log(Status.INFO, MarkupHelper.createLabel(
						"Updated Name of Corporation field is not displayed as mandatory, after entering Updated SSN",
						ExtentColor.CYAN));
			}

		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Updated Name of Corporation field is not displayed", ExtentColor.RED));
		}

		System.out.println("Read Only " + effectiveDateOfChange.getAttribute("readonly"));

		if (effectiveDateOfChange.isDisplayed() && effectiveDateOfChange.getAttribute("readonly").equals("true")) {
			System.out.println("Effective Date of Change value is displayed as: "
					+ effectiveDateOfChange.getAttribute("value").trim());
			LocalDate date2 = LocalDate.parse(effectiveDateOfChange.getAttribute("value").trim(), dateTimeFormatter);
			days = ChronoUnit.DAYS.between(date1, date2);
			System.out.println("Difference in Days: " + days);

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			df.setTimeZone(TimeZone.getTimeZone("PST"));

			if (days == 0) {
				logSuccess("Effective Date of Change value is displayed as today's date: "
						+ effectiveDateOfChange.getAttribute("value").trim());
			} else if (days == 1 && Integer.parseInt(df.format(new Date()).split(" ")[1].split(":")[0]) >= 18) {
				logSuccess(
						"Effective Date of Change value is displayed as tomorrow's date as current time crossed Working Hours : "
								+ effectiveDateOfChange.getAttribute("value").trim());
			} else {
				count++;
				test.get().log(Status.FAIL, MarkupHelper.createLabel(
						"Effective Date of Change value is not displayed as today's date", ExtentColor.RED));
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel(
								"Effective Date of Change : " + effectiveDateOfChange.getAttribute("value").trim(),
								ExtentColor.RED));
				test.get().log(Status.FAIL, MarkupHelper.createLabel("Today's Date" + currentDate, ExtentColor.RED));

			}
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Effective Date of Change Field is not displayed", ExtentColor.RED));
		}

		if (updateFEINComments.isDisplayed() && updateFEINComments.getAttribute("readonly") == null) {
			logInfo("Comment field is displayed and editable");
		} else {
			count++;
			logFailure("Comment field either not displayed or not editable");
		}

		if (count == 0) {
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

	}

	/* Validation for Mandatory Fields */
	public void validateMandatoryFields() throws IOException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		checkForPageLoad(driver);
		scrollToElement(driver, submit);
		waitForElement(driver, submit);
		/*
		 * scrollToElement(driver); scrollToElement(driver);
		 */
		submit.click();
		checkForPageLoad(driver);
		if (isElementPresent(errorMandatoryFields)) {
			submit.click();
			String errorString = errorMandatoryFields.getText().trim().split(": ")[1];
			String[] errorFields = errorString.split(",");
			logSuccess("Some Fields are incomplete Error Message is displayed.");
			logInfo("Mandatory Fields are:");
			for (int i = 0; i < errorFields.length; i++) {
				logInfo("- " + errorFields[i]);
			}
			waitForElementToBeClickable(driver, closeError);
			if (isElementPresent(closeError)) {
				try {
					closeError.click();
				} catch (Exception e) {
					// TODO: handle exception
				}

			}
			checkForPageLoad(driver);
			// logInfoScreenshot(driver);
			scrollToElement(driver, formLabel);
		} else {
			logFailure("Error Message for Mandatory Fields is not displayed.");
			logFailureScreenshot(driver);
		}

	}

	/* Validation for New Hire Request Form Description */
	public void validateNewHireDesc(String details) throws IOException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		List<WebElement> description = driver.findElements(By.xpath("//*[@class='ng-binding']/div/span"));
		String[] detailsDesc = details.split("\\r?\\n");
		int count = 0;
		int index = 0;
		for (WebElement element : description) {
			if (!element.getText().trim().contains(detailsDesc[index].trim())) {
				count++;
				System.out.println("Expected - " + detailsDesc[index]);
				System.out.println("Actual - " + element.getText().trim());
				logFailure("Expected - " + detailsDesc[index]);
				logFailure("Actual - " + element.getText().trim());
			} else {
				System.out.println("Expected and Actual description line matches - " + element.getText().trim());
			}
			index++;
		}

		if (count > 0) {
			logFailure("Displayed Information does not match with expected Information");
			logFailureScreenshot(driver);
		} else {
			logSuccess("Displayed Information matches with expected Information");

		}
	}

	/*
	 * Validation of Downloading and Verifying successful download of Hire Template
	 * for New Hire Request Form
	 */
	public void validateHireTemplateDownload(String downloadPath) throws IOException, InterruptedException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		File tempFile = null;
		String fileName = downloadPath;
		System.out.println("FileName - " + fileName);

		tempFile = new File(fileName);

		logInfo("Deleting the File if already available before download");
		if (tempFile.exists()) {
			tempFile.delete();
		}

		if (isElementPresent(downloadLink)) {
			scrollPageToElement(driver, homeLogo);
			Thread.sleep(2000);
			downloadLink.click();
			logInfo("Clicked on Download Template Link");
			Thread.sleep(20000);
//			tempFile = new File(fileName);
//
//			/*Residuals - New Hire Template
//			 * if (executeOn.equals("System Browsers")) { tempFile = new File(fileName); }
//			 */
//
//			if (tempFile.exists()) {
//				logSuccess("Template Downloaded Successfully");
//				logSuccessScreenshot(driver);
//
//			} else {
//				logFailure("Template Download Failed");
//				logFailureScreenshot(driver);
//			}
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			// check if file exists
			System.out.println(jse.executeScript(
					"browserstack_executor: {\"action\": \"fileExists\", \"arguments\": {\"fileName\": \"Residuals - New Hire Template.xlsx\"}}"));

			// get file content. The content is Base64 encoded
		}
	}

	/* Validation of Attach Hire Template for New Hire Request Form */
	public void validateAttachHireTemplateSection(String batchDesc, String noOfHire) throws Exception {
		PageFactory.initElements(driver, ResidualsFormPage.class);

		if (isElementPresent(noOfHires)) {
			logInfo("Entering the number of Hires - " + noOfHire);
			noOfHires.sendKeys(noOfHire);
			checkForPageLoad(driver);
		} else {
			logFailure("How many hires are there in this batch? - field is not displayed");
			logFailureScreenshot(driver);
		}

		if (isElementPresent(hireBatchDesc)) {
			logInfo("Entering the Hire Batch Description - " + batchDesc);
			hireBatchDesc.sendKeys(batchDesc);
			checkForPageLoad(driver);
		} else {
			logFailure("Hire Batch Description - field is not displayed");
			logFailureScreenshot(driver);
		}

		if (isElementPresent(addAttachmentBtn)) {
			addAttachment();
		} else {
			logFailure("Add Attachment field is not displayed.");
			logFailureScreenshot(driver);
		}

	}

	/* Validation for Point of Contact for Request Section */
	public void validatePOCforRequest() throws IOException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		int count = 0;

		/*
		 * if (mandatIndicatorPOCName.isDisplayed()) { test.get().log(Status.INFO,
		 * MarkupHelper.createLabel("Name Field field is displayed as mandatory",
		 * ExtentColor.CYAN)); } else { count++; test.get().log(Status.FAIL,
		 * MarkupHelper.createLabel("Name field is not displayed as mandatory",
		 * ExtentColor.RED)); }
		 */

		if (!pocName.getAttribute("value").trim().isEmpty() && pocName.isEnabled()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel(
							"Name Field is Autopopulated with value:  " + pocName.getAttribute("value").trim(),
							ExtentColor.CYAN));
			System.out.println("Name Field is Autopopulated with value:  " + pocName.getAttribute("value").trim());
		} else {
			count++;
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Name Field value is not autopopulated" + twid.getAttribute("value").trim(), ExtentColor.RED));
		}

		if (!pocEmail.getAttribute("value").trim().isEmpty() && pocEmailReadOnly.isDisplayed()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel(
							"Work Email Field is Autopopulated with value:  " + pocEmail.getAttribute("value").trim(),
							ExtentColor.CYAN));
			System.out
					.println("Work Email Field is Autopopulated with value:  " + pocEmail.getAttribute("value").trim());
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"Work Email Field value is not autopopulated" + pocEmail.getAttribute("value").trim(),
							ExtentColor.RED));
		}

		if (!pocPhoneNumber.getAttribute("value").trim().isEmpty() && pocPhoneNumberReadOnly.isDisplayed()) {
			test.get().log(Status.INFO, MarkupHelper.createLabel(
					"Phone Number Field is Autopopulated with value:  " + pocPhoneNumber.getAttribute("value").trim(),
					ExtentColor.CYAN));
			System.out.println(
					"Phone NumberField is Autopopulated with value:  " + pocPhoneNumber.getAttribute("value").trim());
		} else {
			count++;
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Phone Number Field value is not autopopulated" + pocPhoneNumber.getAttribute("value").trim(),
					ExtentColor.RED));
		}

		if (comments.isDisplayed() && comments.isEnabled()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Additional Comments Field is displayed", ExtentColor.CYAN));
			System.out.println("Additional Comments Field is displayed");
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Additional Comments Field is not displayed", ExtentColor.RED));
		}

		if (count == 0) {
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		scrollToElement(driver, submit);
		scrollPageDown(driver);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, submit);
		submit.click();
		checkForPageLoad(driver);

		try {
			JavascriptExecutor execute = (JavascriptExecutor) driver;
			execute.executeScript("arguments[0].click();", submit);
			checkForPageLoad(driver);
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Submit button may be already clicked");
		}

	}

	/* This method is to validate Case Creation */
	public String validateCaseCreation(String subjectPerson) throws IOException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		int count = 0;
		checkForPageLoad(driver);
		waitForElement(driver, caseID);

		waitForElementToBeClickable(driver, caseID);

		if (caseID.isDisplayed()) {
			System.out.println("Case created successfully with ID  - " + caseID.getText().trim());
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("Case created successfully with ID  - " + caseID.getText().trim(), ExtentColor.GREEN));
		} else {
			count++;
			System.out.println("Case creation Failed");
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Creation of HR Case Failed", ExtentColor.RED));
		}

		waitForElement(driver, caseTitle);
		if (caseTitle.isDisplayed() && caseTitle.getText().trim().contains(subjectPerson)) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"HR Case Title containing HR Service and Subject Person displayed: " + caseTitle.getText().trim(),
					ExtentColor.GREEN));
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper
							.createLabel("HR Case Title containing HR Service and Subject Person is not	 displayed: "
									+ caseTitle.getText().trim(), ExtentColor.RED));
		}

		waitForElement(driver, requestedBy);
		if (isElementPresent(requestedBy)) {
			System.out.println("Requested by field is displayed");
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Requested by field is displayed ", ExtentColor.GREEN));
		} else {
			count++;
			System.out.println("Requested by field is not displayed");
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Requested by field is not displayed", ExtentColor.RED));
		}

		waitForElement(driver, about);
		if (isElementPresent(about)) {
			System.out.println("About field is displayed");
			test.get().log(Status.PASS, MarkupHelper.createLabel("About field is displayed", ExtentColor.GREEN));
		} else {
			count++;
			System.out.println("About field is not displayed");
			test.get().log(Status.FAIL, MarkupHelper.createLabel("About field is not displayed", ExtentColor.RED));
		}

		waitForElement(driver, shortDesc);
		if (isElementPresent(shortDesc)) {
			System.out.println("Short Description field is displayed");
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Short Description field is displayed", ExtentColor.GREEN));
		} else {
			count++;
			System.out.println("Short Description field is not displayed");
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Short Description field is not displayed", ExtentColor.RED));
		}

		waitForElement(driver, caseDesc);
		if (caseDesc.isDisplayed()) {
			System.out.println("Case Description section is displayed");
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Case Description section is displayed", ExtentColor.GREEN));
		} else {
			count++;
			System.out.println("Case Description section is not displayed");
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Case Description section is not displayed", ExtentColor.RED));
		}

		waitForElement(driver, historySection);
		if (historySection.isDisplayed()) {
			System.out.println("History section is displayed");
			test.get().log(Status.PASS, MarkupHelper.createLabel("History section is displayed", ExtentColor.GREEN));
		} else {
			count++;
			System.out.println("History section is not displayed");
			test.get().log(Status.FAIL, MarkupHelper.createLabel("History section is not displayed", ExtentColor.RED));
		}

		waitForElement(driver, attachmentSection);
		if (attachmentSection.isDisplayed()) {
			System.out.println("Attachment section is displayed");
			test.get().log(Status.PASS, MarkupHelper.createLabel("Attachment section is displayed", ExtentColor.GREEN));
		} else {
			count++;
			System.out.println("Attachment section is not displayed");
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Attachment section is not displayed", ExtentColor.RED));
		}

		if (count == 0) {
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		return caseID.getText().trim();
	}

	List<WebElement> elements = new ArrayList<WebElement>();
	List<String> sections = new ArrayList<String>();

	/*
	 * Storing the Field Labels and Values in HashMap to Validate Case Details after
	 * Case Creation
	 */
	public void storeFieldValues(String form) throws IOException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		elements.clear();
		sections.clear();
		if (form.contains("Residuals: Stop/Cancel Payment Request")) {
			elements = driver.findElements(
					By.xpath("//legend[@class = 'h4 ng-binding' and not(contains(text(), 'Check Information '))]"));
		} else {
			elements = driver.findElements(By.xpath("//legend[@class = 'h4 ng-binding']"));
		}

		for (int i = 0; i < elements.size(); i++) {
			sections.add(elements.get(i).getText().trim());
		}

		if (form.contains("Residuals: Dissolve a Corporation")) {
			fieldValueMap.put("Worker", selectWorker.getText().trim());
		} else if (form.contains("Residuals: Stop/Cancel Payment Request")) {
			fieldValueMap.put("Payee", selectPayee.getText().trim());
			System.out.println("Payee - " + selectPayee.getText().trim());
		} else if (!form.contains("Residuals: New Hire Request")) {
			fieldValueMap.put(labelSelectWorker.getText().trim(), selectWorker.getText().trim());
		}
		if (form.contains("Residuals: Stop/Cancel Payment Request")) {
			fieldValueMap.put(labelTwidPaymentReq.getText().trim(), payeeTwid.getAttribute("value").trim());
			fieldValueMap.put(labelPayeeFirstName.getText().trim(), payeeFirstName.getAttribute("value").trim());
			fieldValueMap.put(labelPayeeLastName.getText().trim(), payeeLastName.getAttribute("value").trim());
			fieldValueMap.put(labelPayeeCorp.getText().trim(), payeeCorporationName.getAttribute("value").trim());
		} else if (!form.contains("Residuals: New Hire Request")) {
			fieldValueMap.put(labelTwid.getText().trim(), twid.getAttribute("value").trim().trim());
			fieldValueMap.put(labelWorkerFirstName.getText().trim(), firstName.getAttribute("value").trim());
			fieldValueMap.put(labelWorkerLastName.getText().trim(), lastName.getAttribute("value").trim());
			fieldValueMap.put(labelCorp.getText().trim(), corporationName.getAttribute("value").trim());
		}

		if (form.contains("Residuals: Beneficiary Request")) {
			fieldValueMap.put(labelBeneficiaryName.getText().trim(), beneficiaryDetail.getAttribute("value").trim());
			fieldValueMap.put("Date of Worker's Death", workerDeathDate.getAttribute("value").trim());
			fieldValueMap.put(labelEffectiveDateOfChange.getText().trim(),
					effectiveDateOfChange.getAttribute("value").trim());
		} else if (form.contains("Residuals: Dissolve a Corporation")) {
			fieldValueMap.put(labelExpirationDate.getText().trim(), expirationDate.getAttribute("value").trim());
		} else if (form.contains("Residuals: Name Change Request")) {
			fieldValueMap.put(labelNameChangeFirstName.getText().trim(),
					nameChangeFirstName.getAttribute("value").trim());
			fieldValueMap.put(labelNameChangeLastName.getText().trim(),
					nameChangeLastName.getAttribute("value").trim());
			fieldValueMap.put(labelEffectiveDateOfChange.getText().trim(),
					effectiveDateOfChange.getAttribute("value").trim());
		} else if (form.contains("Residuals: SSN Correction Request")) {
			String updatedfein = updatedSSN.getAttribute("value").trim();
			System.out.println(updatedfein.length());
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < updatedfein.length(); i++) {
				buffer.append("*");
			}
			System.out.println(buffer.toString());
			fieldValueMap.put(labelUpdatedSSN.getText().trim(), buffer.toString());
			fieldValueMap.put(labelEffectiveDateOfChange.getText().trim(),
					effectiveDateOfChange.getAttribute("value").trim());
		} else if (form.contains("Residuals: Update a Corporation Name/FEIN Request")
				|| form.equalsIgnoreCase("Residuals: Update a Corporation Name/FEIN Request")) {
			String updatedfein = updatedFEIN.getAttribute("value").trim();
			System.out.println(updatedfein.length());
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < updatedfein.length(); i++) {
				buffer.append("*");
			}
			System.out.println(buffer.toString());
			fieldValueMap.put(labelUpdatedFEIN.getText().trim(), buffer.toString());
			fieldValueMap.put(labelUpdatedCorp.getText().trim(), updatedCorp.getAttribute("value").trim());
			fieldValueMap.put(labelEffectiveDateOfChange.getText().trim(),
					effectiveDateOfChange.getAttribute("value").trim());
		} else if (form.contains("Residuals: Stop/Cancel Payment Request")) {
			fieldValueMap.put(labelRequestType.getText().trim(), requestTypeDropDown.getText().trim());
			System.out.println("Request Type Drop Down Value" + requestTypeDropDown.getText().trim());
			fieldValueMap.put(labelSapCompanyCode.getText().trim(), sapCompanyCodeDropDown.getText().trim());
			fieldValueMap.put(labelCheckNumber.getText().trim(), checkNumber.getAttribute("value").trim());
			fieldValueMap.put(labelCheckDate.getText().trim(), checkDate.getAttribute("value").trim());
			fieldValueMap.put(labelNetAmount.getText().trim(), netAmount.getAttribute("value").trim());
			fieldValueMap.put(labelAdditionalComments.getText().trim(),
					additionalComments.getAttribute("value").trim());
			if (!requestTypeDropDown.getText().trim().equalsIgnoreCase("Check Copy")) {
				fieldValueMap.put(labelReasonType.getText().trim(), reasonDropDown.getText().trim());
				fieldValueMap.put(labelSapGlNumber.getText().trim(), sapGlNumber.getAttribute("value").trim());
			}

		} else if (form.contains("Residuals: New Hire Request")) {
			// fieldValueMap.put(labelHireBatchDesc.getText().trim(),
			// hireBatchDesc.getText().trim());
			fieldValueMap.put("Hire Batch description", hireBatchDesc.getAttribute("value").trim().trim());
			fieldValueMap.put(labelNoOfHires.getText().trim(), noOfHires.getAttribute("value").trim().trim());
		}

		fieldValueMap.put(labelPocName.getText().trim(), pocName.getAttribute("value").trim());
		fieldValueMap.put(labelWorkEmail.getText().trim(), pocEmail.getAttribute("value").trim());
		fieldValueMap.put("Phone number", pocPhoneNumber.getAttribute("value").trim());

	}

	/* This method is to validate Case Description after Case is created */
	public void validateCaseDescription(String form) throws IOException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		int count = 0;

		List<String> keys = new ArrayList<String>(fieldValueMap.keySet());
		if (caseDescDetails.isDisplayed()) {
			String caseDescription = caseDescDetails.getText().trim();
			System.out.println("Case Details are displayed - " + caseDescDetails.getText().trim());

			if (caseDescription.contains(form)) {
				logInfo("Case Description contains Form Name: " + form);
			} else {
				count++;
				logFailure("Case Description does not contain Form Name: " + form);
			}

			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Section Names verification in the Case Description", ExtentColor.ORANGE));
			for (int i = 0; i < sections.size(); i++) {
				if (caseDescription.contains(sections.get(i).trim())) {
					logInfo("Section Name " + sections.get(i).trim() + " is displayed in Case Description");
				} else {
					count++;
					logFailure("Section Name " + sections.get(i) + " is not displayed in Case Description");
				}
			}
			System.out.println("Count after Section verification in Case Description : " + count);
			System.out.println("Available Key Size " + keys.size());
			for (int i = 0; i < keys.size(); i++) {
				System.out.println("Keys - " + keys.get(i).trim());
			}

			test.get().log(Status.INFO, MarkupHelper
					.createLabel("Field Names and value verification in the Case Description", ExtentColor.ORANGE));
			for (int i = 0; i < keys.size(); i++) {
				if (caseDescription.contains(keys.get(i).trim() + ": " + fieldValueMap.get(keys.get(i).trim()))
						|| caseDescription.contains(keys.get(i).trim() + ":" + fieldValueMap.get(keys.get(i).trim()))) {
					System.out.println(
							"Key - " + keys.get(i).trim() + " - Value - " + fieldValueMap.get(keys.get(i).trim()));
					logInfo("Field Name - " + keys.get(i).trim() + " is displayed with value - "
							+ fieldValueMap.get(keys.get(i).trim()));
				} else {
					logFailure("Field Name - " + keys.get(i).trim() + "  - " + fieldValueMap.get(keys.get(i).trim()));
					System.out.println("Failure ---------------- Field Name - " + keys.get(i).trim() + "  - "
							+ fieldValueMap.get(keys.get(i).trim()));

					count++;
				}
			}
			System.out.println("Count after field verification in Case Description : " + count);

			if (count == 0) {
				scrollPageDown(driver);
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} else {
				scrollPageDown(driver);
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}
		} else {
			logFailure("Case Description Section text is not displayed.");
		}
	}

	public void validateCheckInfoSection(String[] expectedReqType, String requestType) throws IOException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		scrollToElement(driver, payeeCorporationName);
		waitForElement(driver, requestTypeDropDown);
		requestTypeDropDown.click();
		checkForPageLoad(driver);
		List<WebElement> requestTypeElements = driver.findElements(By.xpath(
				"//*[contains(@id,'select2-drop') and contains(@class, 'select2-with-searchbox')]/child::ul/li"));
		List<String> requestTypeOptions = new ArrayList<String>();
		System.out.println("Options Available in Request Type Drop Down : " + requestTypeElements.size());
		test.get().log(Status.INFO, MarkupHelper.createLabel("Validating Request Type Drop Down", ExtentColor.ORANGE));
		logInfo("Option avaiable under Request Type drop down are :");
		for (int i = 0; i < requestTypeElements.size(); i++) {
			requestTypeOptions.add(requestTypeElements.get(i).getText().trim());
			logInfo(" - " + requestTypeOptions.get(i));
		}

		if (expectedReqType.length == requestTypeOptions.size()) {
			logInfo("Count of Expected Drop Down options and Actual Drop Down option is matched: "
					+ expectedReqType.length);
		} else {
			logFailure("Count of Expected Drop Down options and Actual Drop Down option is not matched");
			logFailure("Expected Count - " + expectedReqType.length);
			logFailure("Actual Count - " + requestTypeOptions.size());
			logFailure("Mismatched Options");
			int count = 0;

			for (int i = 0; i < expectedReqType.length; i++) {
				count = 0;
				for (int j = 0; j < requestTypeOptions.size(); j++) {
					if (requestTypeOptions.get(j).contains(expectedReqType[i])) {
						count++;
						break;
					}
				}
				if (count == 0) {
					logFailure(" - " + expectedReqType[i]);
				}
			}
		}
		logInfoScreenshot(driver);
		/*
		 * for (int i = 0; i < requestTypeOptions.size(); i++) { waitForElement(driver,
		 * dropDowSearchBox); dropDowSearchBox.clear();
		 * dropDowSearchBox.sendKeys(requestTypeOptions.get(i), Keys.TAB);
		 * requestTypeDropDown.click(); }
		 */

		waitForElement(driver, dropDowSearchBox);
		dropDowSearchBox.clear();
		dropDowSearchBox.sendKeys(requestType, Keys.TAB);
		checkForPageLoad(driver);

		/* To verify mandatory fields after selecting Request Type */
		validateMandatoryFields();
	}

	public void validateReasonDropDown(String[] expectedOptions, String reason) throws IOException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		scrollToElement(driver, selectPayee);

		waitForElement(driver, reasonDropDown);
		reasonDropDown.click();
		checkForPageLoad(driver);
		List<WebElement> reasonOption = driver.findElements(By.xpath(
				"//*[contains(@id,'select2-drop') and contains(@class, 'select2-with-searchbox')]/child::ul/li"));
		List<String> reasonOptionsList = new ArrayList<String>();
		System.out.println("Options Available in Reason Drop Down : " + reasonOption.size());
		test.get().log(Status.INFO, MarkupHelper.createLabel("Validating Reason Drop Down", ExtentColor.ORANGE));
		logInfo("Option avaiable under Reasone drop down are :");
		for (int i = 0; i < reasonOption.size(); i++) {
			reasonOptionsList.add(reasonOption.get(i).getText().trim());
			logInfo(" - " + reasonOptionsList.get(i));
		}

		if (expectedOptions.length == reasonOptionsList.size()) {
			logInfo("Count of Expected Drop Down options and Actual Drop Down option is matched: "
					+ expectedOptions.length);
		} else {
			logFailure("Count of Expected Drop Down options and Actual Drop Down option is not matched");
			logFailure("Expected Count - " + expectedOptions.length);
			logFailure("Actual Count - " + reasonOptionsList.size());
			logFailure("Mismatched Options");
			int count = 0;

			for (int i = 0; i < expectedOptions.length; i++) {
				count = 0;
				for (int j = 0; j < reasonOptionsList.size(); j++) {
					if (reasonOptionsList.get(j).contains(expectedOptions[i])) {
						count++;
						break;
					}
				}
				if (count == 0) {
					logFailure(" - " + expectedOptions[i]);
				}
			}
		}
		logInfoScreenshot(driver);
		waitForElement(driver, dropDowSearchBox);
		dropDowSearchBox.clear();
		dropDowSearchBox.sendKeys(reason, Keys.TAB);
		checkForPageLoad(driver);
	}

	public void validateSAPCompanyDropDown(String[] expectedOptions, String sapCompany) throws IOException {
		PageFactory.initElements(driver, ResidualsFormPage.class);

		scrollToElement(driver, selectPayee);
		waitForElement(driver, sapCompanyCodeDropDown);
		sapCompanyCodeDropDown.click();
		checkForPageLoad(driver);
		List<WebElement> sapCompanyOption = driver.findElements(By.xpath(
				"//*[contains(@id,'select2-drop') and contains(@class, 'select2-with-searchbox')]/child::ul/li"));
		List<String> sapCompanyOptionsList = new ArrayList<String>();
		System.out.println("Options Available in SAP Company Drop Down : " + sapCompanyOption.size());
		test.get().log(Status.INFO, MarkupHelper.createLabel("Validating SAP Company Drop Down", ExtentColor.ORANGE));
		logInfo("Option avaiable under SAP Company drop down are :");
		for (int i = 0; i < sapCompanyOption.size(); i++) {
			sapCompanyOptionsList.add(sapCompanyOption.get(i).getText().trim());
			logInfo(" - " + sapCompanyOptionsList.get(i));
		}

		if (expectedOptions.length == sapCompanyOptionsList.size()) {
			logInfo("Count of Expected Drop Down options and Actual Drop Down option is matched: "
					+ expectedOptions.length);
		} else {
			logFailure("Count of Expected Drop Down options and Actual Drop Down option is not matched");
			logFailure("Expected Count - " + expectedOptions.length);
			logFailure("Actual Count - " + sapCompanyOptionsList.size());
			logFailure("Mismatched Options");
			int count = 0;

			for (int i = 0; i < expectedOptions.length; i++) {
				count = 0;
				for (int j = 0; j < sapCompanyOptionsList.size(); j++) {
					if (sapCompanyOptionsList.get(j).contains(expectedOptions[i])) {
						count++;
						break;
					}
				}
				if (count == 0) {
					logFailure(" - " + expectedOptions[i]);
				}
			}
		}
		logInfoScreenshot(driver);
		waitForElement(driver, dropDowSearchBox);
		dropDowSearchBox.clear();
		dropDowSearchBox.sendKeys(sapCompany, Keys.TAB);
		checkForPageLoad(driver);
	}

	public void verifyCheckInfoFields(String requestType, String check, String netAmountInput, String sapGl,
			String additionalComment) throws IOException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		int count = 0;

		if (cashProText.isDisplayed() && !requestType.equalsIgnoreCase("Check Copy")) {
			logInfo("Cash Pro Status is displayed for " + requestType + "Request Type");
		} else if (cashProText.isDisplayed() && requestType.equalsIgnoreCase("Check Copy")) {
			count++;
			logFailure("Cash Pro Status is displayed for " + requestType + "Request Type");
		} else if (!cashProText.isDisplayed() && !requestType.equalsIgnoreCase("Check Copy")) {
			count++;
			logFailure("Cash Pro Status is not displayed for " + requestType + "Request Type");
		}

		if (issueCancelledCheckbox.isDisplayed() && !requestType.equalsIgnoreCase("Check Copy")
				&& !issueCancelledCheckbox.isSelected()) {
			logInfo("Issue Cancelled Check box is displayed and not checked by default for " + requestType
					+ "Request Type");
		} else if (issueCancelledCheckbox.isDisplayed() && requestType.equalsIgnoreCase("Check Copy")) {
			count++;
			logFailure("Issue Cancelled Check box is displayed for " + requestType + "Request Type");
		} else if (!issueCancelledCheckbox.isDisplayed() && !requestType.equalsIgnoreCase("Check Copy")) {
			count++;
			logFailure("Issue Cancelled Check box is not displayed for " + requestType + "Request Type");
		} else if (issueCancelledCheckbox.isDisplayed() && issueCancelledCheckbox.isSelected()) {
			count++;
			logFailure("Issue Cancelled Check box is selected by default for " + requestType + "Request Type");
		}

		boolean isCheckCopyTextPresent = isElementPresent(checkCopyText);

		if (isCheckCopyTextPresent && requestType.equalsIgnoreCase("Check Copy")) {
			logInfo("Instructional text is displayed for " + requestType + "Request Type");
		} else if (isCheckCopyTextPresent && !requestType.equalsIgnoreCase("Check Copy")) {
			count++;
			logFailure("Instructional text is displayed for " + requestType + "Request Type");
		} else if (!isCheckCopyTextPresent && requestType.equalsIgnoreCase("Check Copy")) {
			count++;
			logInfo("Instructional text is not displayed for " + requestType + "Request Type");
		}
		scrollToElement(driver, checkNumber);
		if (checkNumber.isDisplayed()) {
			checkNumber.sendKeys(check);
			checkForPageLoad(driver);
			logInfo("Check Number field is displayed and Value entered is: " + check);
		} else {
			count++;
			logFailure("Check Number Field is not displayed");
		}

		if (calendarIcon.isDisplayed()) {
			logInfo("Check Date field is displayed");
			calendarIcon.click();
			checkForPageLoad(driver);
			waitForElement(driver, today);
			nextMonth.click();
			checkForPageLoad(driver);
			anyDay.click();
			checkForPageLoad(driver);

			if (futureDateWarning.isDisplayed()) {
				logInfo("Future Date Error Message is displayed: " + futureDateWarning.getText().trim());
				logInfoScreenshot(driver);
			} else {
				logFailure("Future Date Error message is not displayed when Future Date is selected");
				logFailureScreenshot(driver);
			}

			calendarIcon.click();
			checkForPageLoad(driver);
			waitForElement(driver, today);
			today.click();
			checkForPageLoad(driver);
			if (isElementPresent(futureDateWarning)) {
				logFailure("Future Date Error Message is displayed for current Date : "
						+ futureDateWarning.getText().trim());
				logFailureScreenshot(driver);
			}

			calendarIcon.click();
			checkForPageLoad(driver);
			waitForElement(driver, today);
			previousMonth.click();
			checkForPageLoad(driver);
			anyDay.click();
			checkForPageLoad(driver);
			if (isElementPresent(futureDateWarning)) {
				logFailure("Future Date Error Message is displayed for current Date : "
						+ futureDateWarning.getText().trim());
				logFailureScreenshot(driver);
			}

		} else {
			count++;
			logFailure("Check Date Field is not displayed");
		}

		if (netAmount.isDisplayed()) {
			netAmount.sendKeys(netAmountInput);
			checkForPageLoad(driver);
			logInfo("Net Amount field is displayed and Value entered is: " + netAmountInput);
		} else {
			count++;
			logFailure("Net Amount Field is not displayed");
		}

		if (sapGlNumber.isDisplayed() && sapGlNumber.getText().trim().equals(sapGl)
				&& !requestType.equalsIgnoreCase("Check Copy")) {
			logInfo("SAP GL Number is displayed for " + requestType + "Request Type with value : "
					+ sapGlNumber.getText().trim());
		} else if (sapGlNumber.isDisplayed() && requestType.equalsIgnoreCase("Check Copy")) {
			count++;
			logFailure("SAP GL Number is displayed for " + requestType + "Request Type with value : "
					+ sapGlNumber.getText().trim());
		} else if (!sapGlNumber.isDisplayed() && !requestType.equalsIgnoreCase("Check Copy")) {
			count++;
			logFailure("SAP GL Number is not displayed for " + requestType + "Request Type");
		}

		if (additionalComments.isDisplayed()) {
			additionalComments.sendKeys(additionalComment);
			checkForPageLoad(driver);
			logInfo("Additional Comments field is displayed and Value entered is: " + additionalComment);
		} else {
			count++;
			logFailure("Additional Comments Field is not displayed");
		}

		if (count == 0) {
			logInfoScreenshot(driver);
		} else {
			logFailureScreenshot(driver);
		}

	}

	public void documentTypeNoOther(String documentTypeInput) throws IOException, InterruptedException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		scrollToElement(driver, twid);
		waitForElementToBeClickable(driver, documentType);

		new Actions(driver).click(documentType).build().perform();
		checkForPageLoad(driver);
		String[] splitdocumentTypeInput = documentTypeInput.split(",");
		for (int i = 0; i < splitdocumentTypeInput.length; i++) {
			if (!splitdocumentTypeInput[i].trim().equalsIgnoreCase("Other")) {
				documentType.sendKeys(splitdocumentTypeInput[i]);
				checkForPageLoad(driver);
				documentType.sendKeys(Keys.TAB);
				checkForPageLoad(driver);
			} else {
				break;
			}
		}
		if (specifyOtherDocumentType.isDisplayed()) {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"Specify Other Document Type Field is displayed when Document Type Other is not selected",
							ExtentColor.RED));
			logFailureScreenshot(driver);
		} else {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Specify Other Document Type Field is not displayed when Document Type Other is not selected",
					ExtentColor.GREEN));

		}
		Thread.sleep(2000);
		for (int i = 0; i < splitdocumentTypeInput.length; i++) {
			if (!splitdocumentTypeInput[i].trim().equalsIgnoreCase("Other")) {
				if (isElementPresent(documentTypeRemove)) {
					documentTypeRemove.click();
					checkForPageLoad(driver);

				}

			}
		}
		checkForPageLoad(driver);
		for (int i = 0; i < splitdocumentTypeInput.length; i++) {
			if (splitdocumentTypeInput[i].trim().equalsIgnoreCase("Other")) {
				Thread.sleep(2000);
				documentType.sendKeys(splitdocumentTypeInput[i]);
				checkForPageLoad(driver);
				documentType.sendKeys(Keys.TAB);
				checkForPageLoad(driver);
			}
		}
		if (specifyOtherDocumentType.isDisplayed()) {
			System.out.println(specifyOtherDocumentType.isDisplayed());
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"Specify Other Document Type Field is displayed when Document Type value is :  "
									+ documentTypeInput,
							ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"Specify Other Document Type Field is displayed when Document Type value is :  "
									+ documentTypeInput,
							ExtentColor.RED));
		}
	}

	String actualValues;
	String splitdeliveryMethodOptionsexeval;
	List<String> list = new ArrayList<String>();

	public void submitButtonInputs(String worker, String documentTypeInput) throws IOException, InterruptedException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		// String[] splitworker = worker.split(",");
		waitForElementToBeClickable(driver, selectWorker2);
		selectWorker2.click();
		waitForElementToBeClickable(driver, inputWorker2);
		inputWorker2.clear();
		inputWorker2.sendKeys(worker);
		waitForAction(driver);
		driver.findElement(By.xpath("//*[@role = 'listbox']/li/descendant::div[contains(text(), '" + worker + "')]"))
				.click();

		scrollToElement(driver, twidLabel);
		waitForElementToBeClickable(driver, documentType);
		documentType.click();
		String[] splitdocumentTypeInput = documentTypeInput.split(",");
		for (int i = 0; i < splitdocumentTypeInput.length; i++) {
			if (!splitdocumentTypeInput[i].equalsIgnoreCase("Other")) {
				documentType.sendKeys(splitdocumentTypeInput[i]);
				waitForAction(driver);
				documentType.sendKeys(Keys.TAB);
			} else {
				break;
			}
		}

		if (specifyOtherDocumentType.isDisplayed()) {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"Specify Other Document Type is displayed when Document Type Other is not selected",
							ExtentColor.RED));
		} else {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"Specify Other Document Type is not displayed when Document Type Other is not selected",
							ExtentColor.GREEN));
		}
	}

	public void requestTypeElectronicCopy(String requestTypeInputData, String deliveryMethodOptions)
			throws IOException, InterruptedException, ParseException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		List<String> inputdata = new ArrayList<>();
		List<String> applicationdata = new ArrayList<>();
		String[] splitrequestTypeInputData = requestTypeInputData.split(",");
		String[] splitdeliveryMethodOptions = deliveryMethodOptions.split(",");

		System.out.println("Expected Delivery Methods length - " + splitdeliveryMethodOptions.length);
		for (int i = 0; i < splitdeliveryMethodOptions.length; i++) {
			inputdata.add(splitdeliveryMethodOptions[i].trim());
		}

		for (int i = 0; i < splitrequestTypeInputData.length; i++) {
			if (splitrequestTypeInputData[i].equalsIgnoreCase("Electronic Copy")) {
				test.get().log(Status.INFO, MarkupHelper
						.createLabel("Request Type is - " + splitrequestTypeInputData[i], ExtentColor.ORANGE));
				scrollToElement(driver, additionalInformation);
				waitForElementToBeClickable(driver, requestType);
				requestType.click();
				waitForElementToBeClickable(driver, requestTypeInput);
				requestTypeInput.sendKeys(splitrequestTypeInputData[i]);
				waitForAction(driver);
				requestTypeInput.sendKeys(Keys.ENTER);
				waitForAction(driver);
				String actualFileShareText = "File Share";
				String expectedFileShareText = fileShareText.getText().trim();
				if (isElementPresent(fileShare)) {
					test.get().log(Status.PASS, MarkupHelper.createLabel(
							"Delivery Method is displayed as: " + expectedFileShareText, ExtentColor.GREEN));
					System.out.println("Delivery Method is displayed as: " + expectedFileShareText);
				} else {
					test.get().log(Status.FAIL,
							MarkupHelper.createLabel(
									"Instead of File Share Delivery Method is displayed as: " + expectedFileShareText,
									ExtentColor.RED));
				}
				if (actualFileShareText.equals(expectedFileShareText.split("\\r?\\n")[0])) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel(
									"Document Type Field is selected with value:  " + splitrequestTypeInputData[i],
									ExtentColor.GREEN));
					System.out.println("Document Type Field is Selected with value:  " + splitrequestTypeInputData[i]);
				} else {
					test.get().log(Status.FAIL,
							MarkupHelper.createLabel(
									"Document Type Field is not Selected with value:" + splitrequestTypeInputData[i],
									ExtentColor.RED));
				}

				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				simpleDateFormat.setTimeZone(TimeZone.getTimeZone("PST"));
				String currentDate = simpleDateFormat.format(new Date());
				String actualDateTime = dateTime.getAttribute("value").trim().split(" ")[0];
				Date startDate = simpleDateFormat.parse(currentDate);
				System.out.println("Current Date is  - " + currentDate);
				Date endDate = simpleDateFormat.parse(actualDateTime);
				int workingDaysDifference = getWorkingDaysBetweenTwoDates(startDate, endDate);

				// String expectedDateTime = compareTime(1);
				if (workingDaysDifference == 2) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel(
									"Date and Time needed field is displayed with value: " + actualDateTime,
									ExtentColor.GREEN));
					System.out.println("Date and Time needed field is with value:  " + actualDateTime);
				} else {
					test.get().log(Status.FAIL, MarkupHelper.createLabel(
							"Date and Time needed field is displayed with value:" + actualDateTime, ExtentColor.RED));
					logFailure("Difference in Working Days is  - " + workingDaysDifference);
				}
			}

			else if (splitrequestTypeInputData[i].equalsIgnoreCase("Original File")) {
				test.get().log(Status.INFO, MarkupHelper
						.createLabel("Request Type is - " + splitrequestTypeInputData[i], ExtentColor.ORANGE));
				scrollPageDown(driver);
				Thread.sleep(2000);
				requestType.click();
				requestTypeInput.sendKeys(splitrequestTypeInputData[i]);
				waitForAction(driver);
				requestTypeInput.sendKeys(Keys.ENTER);
				waitForAction(driver);

				if (deliverymethodastrix.isDisplayed()) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel("Delivery method is displayed as Mandatory for the selection: "
									+ splitrequestTypeInputData[i], ExtentColor.GREEN));
					System.out.println("Delivery method is displayed as Mandatory for the selection: "
							+ splitrequestTypeInputData[i]);
				} else {
					test.get().log(Status.FAIL,
							MarkupHelper.createLabel("Delivery method is not displayed as Mandatory for the selection: "
									+ splitrequestTypeInputData[i], ExtentColor.RED));
				}

				deliverymethodDropDown.click();
				checkForPageLoad(driver);

				List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@id, 'select2-results')]/li"));
				list.clear();
				for (int j = 0; j < options.size(); j++) {
					applicationdata.add(options.get(j).getText().trim());
				}

				if (isElementPresent(options.get(0))) {
					options.get(0).click();
					checkForPageLoad(driver);
				}

				if (options.size() == splitdeliveryMethodOptions.length) {
					logInfo("Actual Number of Delivery Methods matches with the expected number  - " + options.size());
					compareTwoList(inputdata, applicationdata);
				} else {
					logFailure("Actual Number of Delivery Methods does not matches with the expected number  - "
							+ options.size());
					compareTwoList(inputdata, applicationdata);
				}

				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				simpleDateFormat.setTimeZone(TimeZone.getTimeZone("PST"));
				String currentDate = simpleDateFormat.format(new Date());
				Date startDate = simpleDateFormat.parse(currentDate);

				String actualDateTime2 = dateTime.getAttribute("value").trim().split(" ")[0];
				Date endDate1 = simpleDateFormat.parse(actualDateTime2);
				int workingDaysDifference = getWorkingDaysBetweenTwoDates(startDate, endDate1);

				// String expectedDateTime2 = compareTime(1);
				if (workingDaysDifference == 2) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel(
									"Date and Time Needed field is displayed with value: " + actualDateTime2,
									ExtentColor.GREEN));
					System.out.println("Date and Time Needed field is with value:  " + actualDateTime2);
				} else {
					test.get().log(Status.FAIL, MarkupHelper.createLabel(
							"Date and Time Needed is displayed with value:" + actualDateTime2, ExtentColor.RED));
					logFailure("Difference in Working Days is  - " + workingDaysDifference);
				}

				String edrDateActual = expDocumentReturnDate.getAttribute("value").trim();
				Date endDate = simpleDateFormat.parse(edrDateActual);
				workingDaysDifference = getWorkingDaysBetweenTwoDates(endDate1, endDate);
				// String edrDateExpected = compareTime(8);
				if (workingDaysDifference == 5) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel(
									"Actual Document Return Date is displayed with the value: " + edrDateActual,
									ExtentColor.GREEN));
					System.out.println("Actual Document Return Date is displayed with the value: " + edrDateActual);
				} else {
					test.get().log(Status.FAIL,
							MarkupHelper.createLabel(
									"Actual Document Return Date is displayed with the value: " + edrDateActual,
									ExtentColor.RED));
					logFailure("Difference in Working Days is  - " + workingDaysDifference);
				}

			} else if (splitrequestTypeInputData[i].equalsIgnoreCase("Paper Copy"))

			{
				test.get().log(Status.INFO, MarkupHelper
						.createLabel("Request Type is - " + splitrequestTypeInputData[i], ExtentColor.ORANGE));
				checkForPageLoad(driver);
				requestType.click();
				checkForPageLoad(driver);
				requestTypeInput.sendKeys(splitrequestTypeInputData[i]);
				waitForAction(driver);
				requestTypeInput.sendKeys(Keys.ENTER);
				waitForAction(driver);
				if (deliverymethodastrix.isDisplayed()) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel("Delivery method is displayed as mandatory for the selection: "
									+ splitrequestTypeInputData[i], ExtentColor.GREEN));
					System.out.println("Astrix is displayed for Delivery method for the selection: "
							+ splitrequestTypeInputData[i]);
				} else {
					test.get().log(Status.FAIL,
							MarkupHelper.createLabel("Delivery method is displayed as mandatory for the selection: "
									+ splitrequestTypeInputData[i], ExtentColor.RED));
				}

				deliverymethodDropDown.click();
				checkForPageLoad(driver);
				List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@id, 'select2-results')]/li"));
				list.clear();

				for (int j = 0; j < options.size(); j++) {
					applicationdata.add(options.get(j).getText().trim());
				}
				if (isElementPresent(options.get(0))) {
					options.get(0).click();
					checkForPageLoad(driver);
				}

				if (options.size() == splitdeliveryMethodOptions.length) {
					logInfo("Actual Number of Delivery Methods matches with the expected number  - " + options.size());
					compareTwoList(inputdata, applicationdata);
				} else {
					logFailure("Actual Number of Delivery Methods does not matches with the expected number  - "
							+ options.size());
					compareTwoList(inputdata, applicationdata);
				}

				try {
					boolean edrDateActual = expDocumentReturnDate.isDisplayed();
					Assert.assertFalse(edrDateActual);
					test.get().log(Status.PASS, MarkupHelper.createLabel(
							"Expected Document Return Date is not displayed for: " + splitrequestTypeInputData[i],
							ExtentColor.GREEN));
					System.out.println(
							"Expected Document Return Date is not displayed for: " + splitrequestTypeInputData[i]);
				} catch (Exception e) {
					test.get().log(Status.FAIL,
							MarkupHelper.createLabel(
									"Expected Document Return Date is displayed for: " + splitrequestTypeInputData[i],
									ExtentColor.RED));
				}
				String actualDateTime2 = dateTime.getAttribute("value").trim().split(" ")[0];
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				simpleDateFormat.setTimeZone(TimeZone.getTimeZone("PST"));
				String currentDate = simpleDateFormat.format(new Date());

				// Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(currentDate);
				Date startDate = simpleDateFormat.parse(currentDate);
				// Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(actualDateTime2);
				Date endDate = simpleDateFormat.parse(actualDateTime2);
				int workingDaysDifference = getWorkingDaysBetweenTwoDates(startDate, endDate);
				// String edrDateExpected = compareTime(8);
				if (workingDaysDifference == 2) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel(
									"Date and Time needed field is displayed with value: " + actualDateTime2,
									ExtentColor.GREEN));
					System.out.println("Date and Type needed field is with value:  " + actualDateTime2);
				} else {
					test.get().log(Status.FAIL,
							MarkupHelper.createLabel(
									"Date and Type needed field is not displayed with value:" + actualDateTime2,
									ExtentColor.RED));
					logFailure("Difference in Working Days is  - " + workingDaysDifference);
				}
			}
		}

	}

	public void fileDeliveryInformation(String requestTypeInputData, String deliveryMethodOptions,
			String billToMyCourierAccount, String deliveryAddress) throws InterruptedException {
		String[] splitrequestTypeInputData = requestTypeInputData.split(",");
		String[] splitdeliveryMethodOptions = deliveryMethodOptions.split(",");
		String[] splitbillToMyCourierAccount = billToMyCourierAccount.split(",");
		scrollPageDown(driver);
		requestType.click();
		checkForPageLoad(driver);
		for (int i = 0; i < splitrequestTypeInputData.length; i++) {
			if (splitrequestTypeInputData[i].equals("Paper Copy")) {
				requestTypeInput.sendKeys(splitrequestTypeInputData[i]);
				waitForAction(driver);
				requestTypeInput.sendKeys(Keys.ENTER);
				waitForAction(driver);
			}
		}
		deliverymethod.click();
		checkForPageLoad(driver);
		deliverymethodoptionsselect.click();
		checkForPageLoad(driver);
		for (int j = 0; j < splitdeliveryMethodOptions.length; j++) {
			if (splitdeliveryMethodOptions[j].equals("Courier")) {
				deliverymethodoptionsselect.sendKeys(splitdeliveryMethodOptions[j]);
				waitForAction(driver);
				deliverymethodoptionsselect.sendKeys(Keys.ENTER);
				waitForAction(driver);
			}
		}
		for (int i = 0; i < splitbillToMyCourierAccount.length; i++) {
			waitForElementToBeClickable(driver, billInMyCourier);
			billInMyCourier.clear();
			waitForAction(driver);
			billInMyCourier.sendKeys(splitbillToMyCourierAccount[i]);
			System.out.println("Value to be entered in field - " + splitbillToMyCourierAccount[i]);
			waitForElementToBeClickable(driver, deliveryAddressInput);
			deliveryAddressInput.click();

			System.out.println("Clicked on Delivery Address");

			if (!StringUtils.isNumeric(splitbillToMyCourierAccount[i]) || splitbillToMyCourierAccount[i].length() < 5) {
				System.out.println(
						"Condition for alert satisfies? - " + (!StringUtils.isNumeric(splitbillToMyCourierAccount[i])
								|| splitbillToMyCourierAccount[i].length() < 5));
				// It will return the parent window name as a String
				String billtomycourieralert = "";
				Alert alert = null;

				if (isAlertPresent(driver)) {
					alert = driver.switchTo().alert();
					billtomycourieralert = alert.getText().trim();
					System.out.println("Alert Text - " + billtomycourieralert);
					System.out.println("Alert is Present");

					try {
						alert.accept();
					} catch (Exception e) {
						System.out.println("Exception in Accepting Alert");
						try {
							alert.dismiss();
						} catch (Exception e2) {
							System.out.println("Exception in Dismissing Alert");
						}
					}
				}

				if (billtomycourieralert.contains("please enter only digits and min length should be 5")) {
					logSuccess("Alert is displayed when invalid data is entered in Bill to My Costcenter field:"
							+ splitbillToMyCourierAccount[i]);
					System.out.println("Alert is displayed when invalid data is entered in Bill to My Costcenter field:"
							+ splitbillToMyCourierAccount[i]);

					if (billInMyCourierError.isDisplayed()) {
						billInMyCourierError.getText().trim()
								.equals("please enter only digits and min length should be 5");
						test.get().log(Status.PASS, MarkupHelper.createLabel(
								"Error is displayed when invalid data entered: " + splitbillToMyCourierAccount[i],
								ExtentColor.GREEN));
						System.out.println(
								"Error is displayed when invalid data entered:  " + splitbillToMyCourierAccount[i]);

					} else {
						test.get().log(Status.FAIL,
								MarkupHelper.createLabel(
										"Error is not displayed for a invalid data:" + splitbillToMyCourierAccount[i],
										ExtentColor.RED));
					}
				} else {
					logFailure("Alert is not available when invalid data is entered in Bill to My Costcenter field:");
					logFailure("Displayed message - " + billtomycourieralert);
					System.out.println("Alert is not available: " + splitbillToMyCourierAccount[i]);
				}
			} else {
				logSuccess("Valid data is provided:");
				System.out.println("Valid data is provided: " + splitbillToMyCourierAccount[i]);
			}
		}

		deliveryAddressInput.sendKeys(deliveryAddress);
		checkForPageLoad(driver);
		if (timeZone.isDisplayed() && timeZoneDisabled.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Time zone is displayed as US/Pacific and disabled when the delivery address is selected as: "
							+ deliveryAddress,
					ExtentColor.GREEN));
			System.out.println(
					"Time zone is displayed as US/Pacific and disabled  when the delivery address is selected as:  "
							+ deliveryAddress);

		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Time zone is not displayed as US/Pacific and not disabled  when the delivery address is selected as:"
							+ deliveryAddress,
					ExtentColor.RED));
		}
	}

	String caseIDNumber = null;

	public String pointofContactRequest(String alternateContactValue) throws IOException, InterruptedException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		int count = 0;

		/*
		 * if (mandatIndicatorPOCName.isDisplayed()) { test.get().log(Status.INFO,
		 * MarkupHelper.createLabel("Name Field field is displayed as mandatory",
		 * ExtentColor.CYAN)); } else { count++; test.get().log(Status.FAIL,
		 * MarkupHelper.createLabel("Name field is not displayed as mandatory",
		 * ExtentColor.RED)); }
		 */

		if (!pocName.getAttribute("value").trim().isEmpty() && pocName.isEnabled()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"Name Field is Autopopulated with value:  " + pocName.getAttribute("value").trim(),
							ExtentColor.GREEN));
			System.out.println("Name Field is Autopopulated with value:  " + pocName.getAttribute("value").trim());
		} else {
			count++;
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Name Field value is not autopopulated" + twid.getAttribute("value").trim(), ExtentColor.RED));
		}

		if (!pocEmail.getAttribute("value").trim().isEmpty() && pocEmailReadOnly.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"Work Email Field is Autopopulated with value:  " + pocEmail.getAttribute("value").trim(),
							ExtentColor.GREEN));
			System.out
					.println("Work Email Field is Autopopulated with value:  " + pocEmail.getAttribute("value").trim());
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"Work Email Field value is not autopopulated" + pocEmail.getAttribute("value").trim(),
							ExtentColor.RED));
		}

		if (!pocPhoneNumber.getAttribute("value").trim().isEmpty() && pocPhoneNumberReadOnly.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Phone Number Field is Autopopulated with value:  " + pocPhoneNumber.getAttribute("value").trim(),
					ExtentColor.GREEN));
			System.out.println(
					"Phone NumberField is Autopopulated with value:  " + pocPhoneNumber.getAttribute("value").trim());
		} else {
			count++;
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Phone Number Field value is not autopopulated" + pocPhoneNumber.getAttribute("value").trim(),
					ExtentColor.RED));
		}

		alternateContact.sendKeys(alternateContactValue);
		scrollToElement(driver, submitButton);
		waitForElementToBeClickable(driver, submitButton);
		submitButton.click();
		checkForPageLoad(driver);
		waitForElement(driver, caseID);
		caseIDNumber = caseID.getText().trim();
		if (caseID.isDisplayed()) {

			test.get().log(Status.PASS, MarkupHelper
					.createLabel("Case id is displayed and its value is:  " + caseIDNumber, ExtentColor.GREEN));
			System.out.println("Case id is displayed and its value is:  " + caseIDNumber);
		} else {
			count++;
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Case id is not displayed as:  " + caseIDNumber, ExtentColor.RED));
		}

		if (count == 0) {
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		return caseIDNumber;
	}

	public void viewSubmittedFileRequest(String caseId, String assignto) throws InterruptedException, IOException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		waitForElement(driver, filterNavigator);
		waitForElementToBeClickable(driver, filterNavigator);
		filterNavigator.sendKeys("HR Case Management");
		waitForAction(driver);
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		waitForElement(driver, openHRCase);
		waitForElementToBeClickable(driver, openHRCase);
		execute.executeScript("arguments[0].click();", openHRCase);
		// openHRCase.click();
		waitForAction(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, searchDropDown);
		Select select = new Select(searchDropDown);
		select.selectByVisibleText("Number");
		waitForElementToBeClickable(driver, searchHRCase);
		searchHRCase.sendKeys(caseId.trim());
		waitForAction(driver);
		searchHRCase.sendKeys(Keys.ENTER);
		waitForAction(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, hr_link_number);
		if (hr_link_number.isDisplayed() && hr_link_number.getText().trim().equals(caseId.trim())) {
			hr_link_number.click();
			System.out.println("Case clicked successfully with ID " + caseId);
			test.get().log(Status.INFO, MarkupHelper.createLabel("Searched the HR Case" + caseId, ExtentColor.CYAN));
			logInfoScreenshot(driver);
		} else {
			System.out.println("HR Case not Found!!!");
			test.get().log(Status.FAIL, MarkupHelper.createLabel("HR Case " + caseId + " not found", ExtentColor.RED));
			logFailureScreenshot(driver);
		}

		// hrcNo.click();
		checkForPageLoad(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		int count = 0;
		waitForElement(driver, expDocRetDate);
		if (expDocRetDate.getText().trim().isEmpty()) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("Expected Document Return Date is empty for:  " + caseId, ExtentColor.GREEN));
			System.out.println("Expected Document Return Date is empty for: " + caseId);
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Expected Document Return Date is not empty for: " + caseId, ExtentColor.RED));
			count++;
		}
		if (assgnGroup.getAttribute("value").trim().equals("HRSM - Administration")) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("Assignment Group is valid with: " + "HRSM - Administration", ExtentColor.GREEN));
			System.out.println("Assignment Group is valid with: " + "HRSM - Administration");
		} else {
			count++;
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Assignment Group is not valid with: " + "HRSM - Administration", ExtentColor.RED));
		}

		assgnTo.click();
		waitForExpectedNumberOfWindows(driver, 2);

		checkForPageLoad(driver);
		String hrPageWindowHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> windowIterator = handles.iterator();
		// iterate through your windows
		while (windowIterator.hasNext()) {
			String windowName = windowIterator.next();
			if (!windowName.equals(hrPageWindowHandle)) {
				driver.switchTo().window(windowName);
				System.out.println(windowName);
				driver.switchTo().window(windowName);
				driver.manage().window().maximize();

				Select dropdown = new Select(searchCriteria);
				dropdown.selectByVisibleText("Name");
				searchTextBox.clear();
				searchTextBox.sendKeys(assignto);
				waitForAction(driver);
				searchTextBox.sendKeys(Keys.ENTER);
				waitForAction(driver);
				if (nameSearchTextBox.isDisplayed()) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel(
									"Entering the value for Assign to field is same as logged in user - " + assignto,
									ExtentColor.GREEN));
					Thread.sleep(2000);
					// nameSearchTextBox.clear();
					nameSearchTextBox.sendKeys(assignto);
					waitForAction(driver);
					nameSearchTextBox.sendKeys(Keys.ENTER);
					waitForAction(driver);
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					WebElement searchResult = driver.findElement(
							By.xpath("//*[contains(@class, 'glide_ref_item_link') and contains(@role, 'button')]"));
					try {
						searchResult.click();
					} catch (Exception e) {
						// TODO: handle exception
					}

				}
			}
		}

		waitForExpectedNumberOfWindows(driver, 1);
		driver.switchTo().window(hrPageWindowHandle);
		checkForPageLoad(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");

		Select option = new Select(state);
		WebElement selectedOption = option.getFirstSelectedOption();
		if (selectedOption.getText().trim().equalsIgnoreCase("Pending")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("State is valid with status: " + "Pending", ExtentColor.GREEN));
			System.out.println("State is valid with status: " + "Open");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("State is not valid with status: " + "Pending", ExtentColor.RED));
			count++;
		}

		if (count == 0) {
			logSuccessScreenshot(driver);
		} else {
			logFailureScreenshot(driver);
		}
		/*
		 * Actions a = new Actions(driver); a.contextClick(header).perform();
		 * headerSave.click(); checkForPageLoad(driver);
		 */

		waitForElementToBeClickable(driver, updateButton);
		JavascriptExecutor executes = (JavascriptExecutor) driver;
		executes.executeScript("arguments[0].click();", updateButton);
		waitForAction(driver);
	}

	/**
	 * @throws Exception
	 **************************************************************************************************************/
	public void viewSubmittedFileRequest1(String caseID) throws InterruptedException, Exception {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		waitForElement(driver, filterNavigator);
		waitForElementToBeClickable(driver, filterNavigator);
		filterNavigator.click();
		filterNavigator.sendKeys("HR Case");
		checkForPageLoad(driver);
		waitForAction(driver);
		waitForElement(driver, openHRCase);
		waitForElementToBeClickable(driver, openHRCase);
		openHRCase.click();
		checkForPageLoad(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, searchDropDown);
		Select select = new Select(searchDropDown);
		select.selectByVisibleText("Number");
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, searchHRCase);
		searchHRCase.click();
		waitForAction(driver);
		searchHRCase.sendKeys(caseID.trim());
		waitForAction(driver);
		searchHRCase.sendKeys(Keys.ENTER);
		waitForAction(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, hr_link_number);
		System.out.println("Get Text - " + hr_link_number.getText().trim());
		if (hr_link_number.getText().trim().equalsIgnoreCase(caseID.trim())) {
			waitForAction(driver);
			hr_link_number.click();
			test.get().log(Status.INFO, MarkupHelper.createLabel("Searched the HR Case - " + caseID, ExtentColor.CYAN));
			logSuccessScreenshot(driver);
			System.out.println("Case clicked successfully with ID " + caseID);
		} else {
			System.out.println("HR Case not Found");
			test.get().log(Status.FAIL, MarkupHelper.createLabel("HR Case " + caseID + " not found", ExtentColor.RED));
			logFailureScreenshot(driver);
		}
	}

	/*
	 * public void viewSubmittedFileRequest2() throws InterruptedException {
	 * PageFactory.initElements(driver, ResidualsFormPage.class); if
	 * (expDocRetDate.getText().trim().equals(null)) { test.get().log(Status.PASS,
	 * MarkupHelper.createLabel( "Expected Document Return Date is empty for:  " +
	 * CompletingFileRequestForm.caseID, ExtentColor.GREEN));
	 * System.out.println("Expected Document Return Date is empty for: " +
	 * CompletingFileRequestForm.caseID); } else { test.get().log(Status.FAIL,
	 * MarkupHelper.createLabel( "Expected Document Return Date is not empty for: "
	 * + CompletingFileRequestForm.caseID, ExtentColor.RED)); } if
	 * (assgnGroup.getAttribute("value").trim().equals("HRSM - Administration")) {
	 * test.get().log(Status.PASS, MarkupHelper
	 * .createLabel("Assignment Group is valid with: " + "HRSM - Administration",
	 * ExtentColor.GREEN)); System.out.println("Assignment Group is valid with: " +
	 * "HRSM - Administration"); } else { test.get().log(Status.FAIL, MarkupHelper
	 * .createLabel("Assignment Group is not valid with: " +
	 * "HRSM - Administration", ExtentColor.RED)); } assgnTo.click();
	 * checkForPageLoad(driver); Set<String> windows = driver.getWindowHandles();
	 * Iterator<String> it = windows.iterator(); String parentwindow = it.next();
	 * String childwindow = it.next(); driver.switchTo().window(childwindow);
	 * worker.click(); checkForPageLoad(driver);
	 * driver.switchTo().window(parentwindow); driver.switchTo().frame(0); Select
	 * option = new Select(state); WebElement selectedOption =
	 * option.getFirstSelectedOption(); if
	 * (selectedOption.getText().trim().equalsIgnoreCase("Open")) {
	 * test.get().log(Status.PASS,
	 * MarkupHelper.createLabel("State is valid with status: " + "Open",
	 * ExtentColor.GREEN)); System.out.println("State is valid with status: " +
	 * "Open"); } else { test.get().log(Status.FAIL,
	 * MarkupHelper.createLabel("State is not valid with status: " + "Open",
	 * ExtentColor.RED)); } Actions a = new Actions(driver);
	 * a.contextClick(header).click(headerSave).build().perform(); }
	 */

	public void reviewingTasks(String caseid, String hrAgent, String workNotesInput)
			throws InterruptedException, IOException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		int count = 0;

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, sendFiletoReq);
		if (sendFiletoReq.isDisplayed()) {
			logInfoScreenshot(driver);
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Task is created to Send File to Requester with description: " + sendFiletoReq.getText().trim(),
					ExtentColor.GREEN));
			System.out.println(
					"Task is created to Send File to Requester with description: " + sendFiletoReq.getText().trim());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Task is not created to Send File to Requester with description: " + sendFiletoReq.getText().trim(),
					ExtentColor.RED));
			count++;
		}

		if (count == 0) {
			logSuccessScreenshot(driver);
		} else {
			logFailureScreenshot(driver);
		}

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hrtNo);
		waitForAction(driver);
		scrollPageUp(driver);
		waitForElementToBeClickable(driver, hrtNo);
		hrtNo.click();
		checkForPageLoad(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		String currentWindow = driver.getWindowHandle();
		System.out.println("Current Window - " + currentWindow);
		scrollToElement(driver, assignedToMglass);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, assignedToMglass);
		new Actions(driver).click(assignedToMglass).build().perform();

		waitForExpectedNumberOfWindows(driver, 2);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> windowIterator = windows.iterator();
		while (windowIterator.hasNext()) {
			String windowName = windowIterator.next();
			System.out.println("Current Window Name - " + windowName);
			if (!windowName.equals(currentWindow)) {
				driver.switchTo().window(windowName);
				System.out.println(windowName);
				driver.switchTo().window(windowName);
				driver.manage().window().maximize();

				waitForElementToBeClickable(driver, searchCriteria);
				Select dropdown = new Select(searchCriteria);
				dropdown.selectByVisibleText("Name");
				waitForElementToBeClickable(driver, searchTextBox);
				searchTextBox.clear();
				searchTextBox.sendKeys(hrAgent);
				waitForAction(driver);
				searchTextBox.sendKeys(Keys.ENTER);
				waitForAction(driver);

				waitForElementToBeClickable(driver, nameSearchTextBox);
				if (nameSearchTextBox.isDisplayed()) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel(
									"Entering the value for Assign to field is same as logged in user - " + hrAgent,
									ExtentColor.GREEN));
					nameSearchTextBox.clear();
					waitForElementToBeClickable(driver, nameSearchTextBox);
					nameSearchTextBox.sendKeys(hrAgent);
					waitForAction(driver);
					nameSearchTextBox.sendKeys(Keys.ENTER);
					checkForPageLoad(driver);
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					WebElement searchResult = driver.findElement(By.xpath(
							"//*[contains(@class, 'glide_ref_item_link') and contains(@role, 'button') and contains(text(), '"
									+ hrAgent + "')]"));
					try {
						searchResult.click();
					} catch (Exception e) {
						// TODO: handle exception
					}

				}
			}
		}

		waitForExpectedNumberOfWindows(driver, 1);
		driver.switchTo().window(currentWindow);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, assignedTo);
		if (assignedTo.getAttribute("value").trim().equalsIgnoreCase(hrAgent)) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("HR Agent is selected as: " + hrAgent, ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("HR Agent is not selected as: " + hrAgent, ExtentColor.RED));
			logFailureScreenshot(driver);
		}

		waitForFrameToBeAvailable(driver, "gsft_main");
		scrollToElement(driver, HRState);
		waitForElementToBeClickable(driver, HRState);
		Select s = new Select(HRState);
		s.selectByVisibleText("Resolved");

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, workNotesError);
		if (workNotesError.isDisplayed()) {
			logInfo("Work Notes are mandatory to change the State to Resolved : " + workNotesError.getText());

		} else {
			logFailure("Work Notes is not displayed as mandatory");
		}

		waitForAction(driver);
		if (isElementPresent(workNotes)) {
			test.get().log(Status.INFO, MarkupHelper.createLabel("Entering the Work Notes", ExtentColor.CYAN));
			waitForElementToBeClickable(driver, workNotes);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].textContent='" + workNotesInput + "';", workNotes);
			workNotes.sendKeys(workNotesInput);
			waitForAction(driver);
			workNotes.sendKeys(Keys.TAB);
			waitForPageLoad(driver);
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			/*
			 * scrollToElement(driver, closeError1); waitForElementToBeClickable(driver,
			 * closeError1); closeError1.click();
			 */
			scrollToElement(driver, caseNumber);
			waitForElementToBeClickable(driver, caseNumber);
			caseNumber.click();
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Work notes field is not displayed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		waitForElementToBeClickable(driver, updateButton);
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		execute.executeScript("arguments[0].click();", updateButton);
		waitForAction(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");

		scrollPageToElement(driver, workNotes);
		waitForAction(driver);
		if (!isElementPresent(hrtNo)) {
			waitForAction(driver);
			waitForFrameToBeAvailable(driver, "gsft_main");
			scrollToElement(driver, workNotes);
			workNotes.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			waitForElementToBeClickable(driver, workNotes);
			js.executeScript("arguments[0].textContent='" + workNotesInput + "';", workNotes);
			waitForAction(driver);
			workNotes.sendKeys(Keys.TAB);
			checkForPageLoad(driver);
			waitForElementToBeClickable(driver, caseNumber);
			caseNumber.click();
			waitForAction(driver);
			waitForFrameToBeAvailable(driver, "gsft_main");
			waitForElementToBeClickable(driver, updateButton);
			execute.executeScript("arguments[0].click();", updateButton);
		}

		// updateButton.click();
		/*
		 * waitForFrameToBeAvailable(driver, "gsft_main"); waitForElement(driver,
		 * searchHRCase); searchHRCase.clear(); waitForElementToBeClickable(driver,
		 * searchHRCase); searchHRCase.sendKeys(caseid);
		 * searchHRCase.sendKeys(Keys.ENTER); waitForFrameToBeAvailable(driver,
		 * "gsft_main"); waitForElementToBeClickable(driver, hr_link_number); if
		 * (hr_link_number.isDisplayed() &&
		 * hr_link_number.getText().trim().equals(caseid.trim())) {
		 * hr_link_number.click(); waitForFrameToBeAvailable(driver, "gsft_main");
		 * System.out.println("Article clicked successfully with ID " + caseID); } else
		 * { System.out.println("HR Case not Found!!!"); test.get().log(Status.FAIL,
		 * MarkupHelper.createLabel("HR Case " + caseID + " not found",
		 * ExtentColor.RED)); screenshotPath = getScreenshot(driver,
		 * this.getClass().getName()); test.get().fail("Details",
		 * MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		 * logFailure("Expected Value - " + caseid); logFailure("Actual Value - " +
		 * hr_link_number.getText().trim());
		 * 
		 * System.out.println("Expected Value - " + caseid);
		 * System.out.println("Actual Value - " + hr_link_number.getText()); }
		 */

		waitForAction(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		scrollToElement(driver, taskHeading);
		waitForElementToBeClickable(driver, hrtNo);
		hrtNo.click();

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, icon);
		icon.click();
		checkForPageLoad(driver);
		waitForElement(driver, iconServiceCase);
		if (iconServiceCase.isDisplayed()) {
			PageFactory.initElements(driver, ResidualsFormPage.class);
			System.out.println("CompletingFileRequestForm " + iconServiceCase.getText().trim());
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"HR Case is Opened with header as: " + iconServiceCase.getText().trim(), ExtentColor.GREEN));
			logSuccessScreenshot(driver);
			openRecord.click();
			checkForPageLoad(driver);
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"HR Case is not Opened with header as: " + iconServiceCase.getText().trim(), ExtentColor.RED));
			logFailureScreenshot(driver);
		}

		if (isAlertPresent(driver)) {
			driver.switchTo().alert().accept();
		} else if (isElementPresent(saveButton)) {
			saveButton.click();
		}

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, taskState);
		String state = taskState.getText().trim();
		System.out.println("................" + state);
		if (state.equals("Resolved")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Task State is displayed as: " + "Resolved", ExtentColor.GREEN));
			logSuccessScreenshot(driver);
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Task State is displayed as: " + state, ExtentColor.RED));
			logFailureScreenshot(driver);
		}
	}
}