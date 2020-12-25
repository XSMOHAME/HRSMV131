package com.snow.pageobjects;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
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

public class SubmitTuitionReimbursementRequest extends ReusableLibrary {
	public WebDriver driver;

	public SubmitTuitionReimbursementRequest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='text-muted sc-cat-item-short-description ng-binding ng-scope']")
	public WebElement subHeadertxt;

	@FindBy(xpath = "(//div[contains(@id,'a1ef3897376e57002fc0c')])[1]")
	public WebElement descriptiontxt;

	@FindBy(xpath = "(//a[text()='Tuition Reimbursement'])[1]")
	public WebElement tuitionReimbursementLink;

	@FindBy(xpath = "(//a[text()='Education Support'])[1]")
	public WebElement educationSupportLink;

	@FindBy(xpath = "//h1[text()='Tuition Reimbursement']")
	public WebElement nextTabTuitionReimbursementTxt;

	@FindBy(xpath = "//h1[text()='Education Support']")
	public WebElement nextTabEducationSupportTxt;

	// --------------Part-1 Course Approval----------------------------

	@FindBy(xpath = "//input[@id='sp_formfield_First_Name2']")
	public WebElement firstname;

	@FindBy(xpath = "//input[@id='sp_formfield_Last_Name2']")
	public WebElement lastname;

	@FindBy(xpath = "//input[@id='sp_formfield_TWID2']")
	public WebElement xptwid;

	@FindBy(xpath = "//input[@id='sp_formfield_Position2']")
	public WebElement xpposition;

	@FindBy(xpath = "//input[@id='sp_formfield_Cost_Center2']")
	public WebElement xpcostcenter;

	@FindBy(xpath = "//input[@id='sp_formfield_Business_Unit2']")
	public WebElement xpbusinessunit;

	@FindBy(xpath = "//input[@id='sp_formfield_Manager_Review']")
	public WebElement xpsupervisorApproval;

	@FindBy(xpath = "//input[@id='sp_formfield_Department_Head_Approval']")
	public WebElement xpDepartmentHeadApproval;

	@FindBy(xpath = "//input[@id='sp_formfield_HR_Representative_Approval']")
	public WebElement xpHRRepresentativeApproval;

	@FindBy(xpath = "//input[@id='sp_formfield_WBLN_Review']")
	public WebElement xpWbLearningApproval;

	@FindBy(xpath = "//input[@id='sp_formfield_Org_Development_Approval']")
	public WebElement xpDevelopmentApproval;

	@FindBy(xpath = "//span[contains(text(),'managing your department')]")
	public WebElement xpDepartmentHelpTxt;

	@FindBy(xpath = "//div[starts-with(text(),'Department Head Information not found!')]")
	public WebElement xpDepartmentErrorText;

	// ----------------Course Information-----------------------------------------

	@FindBy(xpath = "//input[@id='sp_formfield_Name_of_Educational_Institution']")
	public WebElement xpEduactionInstitutionname;

	@FindBy(xpath = "//input[@value='Yes']")
	public WebElement xpYesRadio;

	@FindBy(xpath = "//input[@value='No']")
	public WebElement xpNoRadio;

	@FindBy(xpath = "//input[@id='sp_formfield_Degree_Name']")
	public WebElement xpDegreeName;

	@FindBy(xpath = "(//span[starts-with(text(),'Please provide your course details.')])[1]")
	public WebElement xpCourseHelpTxt;

	@FindBy(xpath = "//input[@id='sp_formfield_Course_Title']")
	public WebElement xpCourseTitle;

	@FindBy(xpath = "//input[@id='sp_formfield_Estimated_Tuition_Fee']")
	public WebElement xpEstimateTuitionFee;

	@FindBy(xpath = "//input[@id='sp_formfield_Course_Start_Date1']")
	public WebElement xpStartDate;

	@FindBy(xpath = "//input[@id='sp_formfield_Course_End_Date1']")
	public WebElement xpEndDate;

	@FindBy(xpath = "//textarea[@id='sp_formfield_Course_Description']")
	public WebElement xpCourseDescription;

	@FindBy(xpath = "//textarea[@id='sp_formfield_Course_Relevance']")
	public WebElement xpCourseRelevance;

	@FindBy(xpath = "//ul[@id='s2id_autogen1_results']/li")
	public List<WebElement> xpCourseTopicList;

	@FindBy(xpath = "//input[@id='s2id_autogen1']")
	public WebElement xpCourseTopic;

	@FindBy(xpath = "//input[@id='sp_formfield_Specify_Other_Topic']")
	public WebElement xpSpecifyOther;

	@FindBy(xpath = "//span[contains(@class,'visible-lg-inline')]")
	public WebElement xpRequestedBy;

	// ------------Course2 Details--------------------------------------
	@FindBy(xpath = "//button[@name='+']")
	public WebElement xpAddCourseBtn;

	@FindBy(xpath = "//*[text()='Course 2 Details:']")
	public WebElement xpCourse2Header;

	@FindBy(xpath = "//input[@id='sp_formfield_Course_Title2']")
	public WebElement xpCourse2Title;

	@FindBy(xpath = "//input[@id='sp_formfield_Estimated_Tuition_Fee2']")
	public WebElement xpCourse2EstimateTuitionFee;

	@FindBy(xpath = "//input[@id='sp_formfield_Course_Start_Date2']")
	public WebElement xpCourse2StartDate;

	@FindBy(xpath = "//input[@id='sp_formfield_Course_End_Date2']")
	public WebElement xpCourse2EndDate;

	@FindBy(xpath = "//textarea[@id='sp_formfield_Course_Description2']")
	public WebElement xpCourse2Description;

	@FindBy(xpath = "//textarea[@id='sp_formfield_Course_Relevance2']")
	public WebElement xpCourse2Relevance;

	@FindBy(xpath = "//ul[@id='s2id_autogen2_results']/li")
	public List<WebElement> xpCourse2TopicList;

	@FindBy(xpath = "//ul[@id='s2id_autogen1_results']/li/div[@role = 'option']")
	public List<WebElement> xpCourse1TopicList;

	@FindBy(xpath = "//input[@id='s2id_autogen2']")
	public WebElement xpCourse2Topic;

	@FindBy(xpath = "//input[@id='sp_formfield_Specify_Other_Topic2']")
	public WebElement xpCourse2SpecifyOther;

	@FindBy(xpath = "//*[text()='Course 3 Details:']")
	public WebElement xpCourse3Header;

	@FindBy(xpath = "//input[@id='sp_formfield_Course_Title3']")
	public WebElement xpCourse3Title;

	@FindBy(xpath = "//input[@id='sp_formfield_Estimated_Tuition_Fee3']")
	public WebElement xpCourse3EstimateTuitionFee;

	@FindBy(xpath = "//input[@id='sp_formfield_Course_Start_Date3']")
	public WebElement xpCourse3StartDate;

	@FindBy(xpath = "//input[@id='sp_formfield_Course_End_Date3']")
	public WebElement xpCourse3EndDate;

	@FindBy(xpath = "//textarea[@id='sp_formfield_Course_Description3']")
	public WebElement xpCourse3Description;

	@FindBy(xpath = "//textarea[@id='sp_formfield_Course_Relevance3']")
	public WebElement xpCourse3Relevance;

	@FindBy(xpath = "//ul[@id='s2id_autogen3_results']/li")
	public List<WebElement> xpCourse3TopicList;

	@FindBy(xpath = "//input[@id='s2id_autogen3']")
	public WebElement xpCourse3Topic;

	@FindBy(xpath = "//input[@id='sp_formfield_Specify_Other_Topic3']")
	public WebElement xpCourse3SpecifyOther;

	@FindBy(xpath = "//*[text()='Course 4 Details:']")
	public WebElement xpCourse4Header;

	@FindBy(xpath = "//input[@id='sp_formfield_Course_Title4']")
	public WebElement xpCourse4Title;

	@FindBy(xpath = "//input[@id='sp_formfield_Estimated_Tuition_Fee4']")
	public WebElement xpCourse4EstimateTuitionFee;

	@FindBy(xpath = "//input[@id='sp_formfield_Course_Start_Date4']")
	public WebElement xpCourse4StartDate;

	@FindBy(xpath = "//input[@id='sp_formfield_Course_End_Date4']")
	public WebElement xpCourse4EndDate;

	@FindBy(xpath = "//textarea[@id='sp_formfield_Course_Description4']")
	public WebElement xpCourse4Description;

	@FindBy(xpath = "//textarea[@id='sp_formfield_Course_Relevance4']")
	public WebElement xpCourse4Relevance;

	@FindBy(xpath = "//ul[@id='s2id_autogen4_results']/li")
	public List<WebElement> xpCourse4TopicList;

	@FindBy(xpath = "//input[@id='s2id_autogen4']")
	public WebElement xpCourse4Topic;

	@FindBy(xpath = "//input[@id='sp_formfield_Specify_Other_Topic4']")
	public WebElement xpCourse4SpecifyOther;

	@FindBy(xpath = "(//*[@name='submit'])[1]")
	public WebElement xpSubmitBtn;

	@FindBy(xpath = "//div[contains(@class,'case-title')]")
	public WebElement xpsubHeader;

	@FindBy(xpath = "//div[contains(@class,'title-info')]")
	public WebElement xpTicketID;

	@FindBy(xpath = "//div[contains(@class,'approver-name')]")
	public List<WebElement> xpApproverList;

	@FindBy(xpath = "(//*[text()='All HR Cases']/following::div[text()='Open'])[1]")
	public WebElement xpOpen;

	@FindBy(xpath = "//div[contains(@data-id,'7a5330019f2212004')]")
	public WebElement xpCaseOpen;

	@FindBy(xpath = "//input[@id='filter']")
	public WebElement leftSearch;

	@FindBy(xpath = "//h2[text()='HR Cases']")
	public WebElement xpCasesPage;

	@FindBy(xpath = "(//input[@id='sn_hr_core_case_table_header_search_control'])[1]")
	public WebElement xpNumberSearch;

	@FindBy(xpath = "(//a[text()='Number'])[1]")
	public WebElement xpNumberTxt;

	@FindBy(xpath = "//tr[contains(@id,'row_sn_hr_core_case')]/td[3]/a")
	public WebElement xpUniqueCaseId;

	@FindBy(xpath = "(//span[contains(text(),'Approvers')])[1]")
	public WebElement xpApproverTab;

	@FindBy(xpath = "//tr[contains(@id,'row_sn_hr_core_case_total_rewards.sysapproval_approver')]/td[3]/a")
	public List<WebElement> xpState;

	@FindBy(xpath = "//tr[contains(@id,'row_sn_hr_core_case_total_rewards.sysapproval_approver')]/td[4]/a")
	public WebElement xpApprover;

	@FindBy(xpath = "//*[@id='user_info_dropdown']/div/span[4]")
	public WebElement xpUsernameHeader;

	@FindBy(xpath = "//*[contains(@role,'presentation')]/a[text()='Impersonate User']")
	public WebElement xpImperonateUser;

	@FindBy(xpath = "//span[text()='Search for user']")
	public WebElement xpSearchBar;

	@FindBy(xpath = "//ul[@id='select2-results-2']/li")
	public WebElement xpUniqueApprover;

	@FindBy(xpath = "//input[@id='s2id_autogen2_search']")
	public WebElement xpEnterApprover;

	@FindBy(xpath = "//select[@class='form-control default-focus-outline']")
	public WebElement searchNumberDropDown;

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

	@FindBy(xpath = "(//div[contains(text(),'My Approvals')])[1]")
	public WebElement xpMyApprovals;

	@FindBy(xpath = "(//td[@name='sysapproval'])[1]//input")
	public WebElement xpApprovalFor;

	@FindBy(xpath = "(//tr[contains(@id,'row_sysapproval_approver')]/td[3]/a)[1]")
	public WebElement xpImpState;

	@FindBy(xpath = "//button[@id='approve']")
	public WebElement xpApprove;

	@FindBy(xpath = "//td[contains(text(), 'No records to display')]")
	public WebElement xpNoRecords;

	@FindBy(xpath = "(//input[@id='sysapproval_approver_table_header_search_control'])[1]")
	public WebElement xpEnterState;

	@FindBy(xpath = "(//input[contains(@aria-label, 'approval for')])[1]")
	public WebElement approvalForTextBox;

	@FindBy(xpath = "(//button[@id ='sysverb_update'])[1]")
	public WebElement xpUpdatebtn;

	@FindBy(xpath = "(//button[@value='reject'])[1]")
	public WebElement rejectbutton;

	// ---------------Course Refund--------------------------

	@FindBy(xpath = "//a[text()=' Part 2: Course Refund - CLICK HERE TO SUBMIT ']")
	public WebElement xpCourseRefund;

	@FindBy(xpath = "//input[@id='sp_formfield_Course_Title_p2']")
	public WebElement xpCrsTitle;

	@FindBy(xpath = "//input[@id='sp_formfield_Estimated_Tuition_Fee_p2']")
	public WebElement xpCrsTuitionfee;

	@FindBy(xpath = "//div[contains(@id,'s2id_sp_formfield_Reimbursement_Required_p2')]/a")
	public WebElement xpRbsRequired;

	@FindBy(xpath = "//input[contains(@id,'s2id_autogen3_search')]")
	public WebElement xpRbsRequiredOptions;

	@FindBy(xpath = "//input[@id='sp_formfield_Course_Grade_p2']")
	public WebElement xpCourseGrade;

	@FindBy(xpath = "//input[@id='sp_formfield_Comment_p2']")
	public WebElement xpComments;

	@FindBy(xpath = "//input[@id='sp_formfield_Tuition_Cost_p2']")
	public WebElement xpTuitionCost;

	@FindBy(xpath = "//input[@id='sp_formfield_Books_p2']")
	public WebElement xpBooks;

	@FindBy(xpath = "//input[@id='sp_formfield_Lab_Fees_p2']")
	public WebElement xpLabFees;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Technology_Fees_p2')]")
	public WebElement xpTechFees;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Course_1_Total_p2')]")
	public WebElement xpCourse1TotalCost;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Course_Title2_p2')]")
	public WebElement xpCrs2Title;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Estimated_Tuition_Fee2_p2')]")
	public WebElement xpCrs2Tuitionfee;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Course_Grade2_p2')]")
	public WebElement xpCourse2Grade;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Comment2_p2')]")
	public WebElement xpCourse2Comments;

	@FindBy(xpath = "//div[contains(@id,'s2id_sp_formfield_Reimbursement_Required2_p2')]/a")
	public WebElement xpRbsRequired2;

	@FindBy(xpath = "//input[contains(@id,'s2id_autogen4_search')]")
	public WebElement xpSendRbsRequired2;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Tuition_Cost2_p2')]")
	public WebElement xpCourse2TuitionCost;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Books2_p2')]")
	public WebElement xpCourse2Books;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Lab_Fees2_p2')]")
	public WebElement xpCourse2LabFees;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Technology_Fees2_p2')]")
	public WebElement xpCourse2TechFees;
	
	@FindBy(xpath = "//legend[contains(text(),'Total Reimbursement Requested')]")
	public WebElement label_total_reimbursement_requested;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Course_2_Total2_p2')]")
	public WebElement xpCourse2TotalCost;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Course_Title3_p2')]")
	public WebElement xpCrs3Title;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Estimated_Tuition_Fee3_p2')]")
	public WebElement xpCrs3Tuitionfee;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Course_Grade3_p2')]")
	public WebElement xpCourse3Grade;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Comment3_p2')]")
	public WebElement xpCourse3Comments;

	@FindBy(xpath = "//div[contains(@id,'s2id_sp_formfield_Reimbursement_Required3_p2')]/a")
	public WebElement xpRbsRequired3;

	@FindBy(xpath = "//input[contains(@id,'s2id_autogen5_search')]")
	public WebElement xpSendRbsRequired3;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Tuition_Cost3_p2')]")
	public WebElement xpCourse3TuitionCost;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Books3_p2')]")
	public WebElement xpCourse3Books;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Lab_Fees3_p2')]")
	public WebElement xpCourse3LabFees;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Technology_Fees3_p2')]")
	public WebElement xpCourse3TechFees;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Course_3_Total_p2')]")
	public WebElement xpCourse3TotalCost;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Course_Title4_p2')]")
	public WebElement xpCrs4Title;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Estimated_Tuition_Fee4_p2')]")
	public WebElement xpCrs4Tuitionfee;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Course_Grade4_p2')]")
	public WebElement xpCourse4Grade;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Comment4_p2')]")
	public WebElement xpCourse4Comments;

	@FindBy(xpath = "//div[contains(@id,'s2id_sp_formfield_Reimbursement_Required4_p2')]/a")
	public WebElement xpRbsRequired4;

	@FindBy(xpath = "//input[contains(@id,'s2id_autogen6_search')]")
	public WebElement xpSendRbsRequired4;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Tuition_Cost4_p2')]")
	public WebElement xpCourse4TuitionCost;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Books4_p2')]")
	public WebElement xpCourse4Books;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Lab_Fees4_p2')]")
	public WebElement xpCourse4LabFees;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Technology_Fees4_p2')]")
	public WebElement xpCourse4TechFees;

	@FindBy(xpath = "//input[contains(@id,'sp_formfield_Course_4_Total_p2')]")
	public WebElement xpCourse4TotalCost;

	@FindBy(xpath = "(//tr[@id='hdr_sn_hr_core_case'])[1]/th[2]")
	public WebElement xpSearchIcon;

	@FindBy(xpath = "(//tr[@id='hdr_sysapproval_approver'])[1]/th[2]")
	public WebElement xpApprovalSearchIcon;

	@FindBy(xpath = "//input[@id='sp_formfield_Course_Total_p2']")
	public WebElement xpCourseTotal;

	@FindBy(xpath = "//span[text()='Direct Deposit']")
	public WebElement xpPaymentDelivery;

	@FindBy(xpath = "//input[@type = 'file' and @id ='attachment_add']")
	public WebElement xpAttachReceipt;

	@FindBy(xpath = "//a[@id= 'attachment_add']")
	public WebElement xpAttachReceiptAutoIT;

	@FindBy(xpath = "//input[@type = 'file' and @id='attachment_add02']")
	public WebElement xpAttachCourseGrade;

	@FindBy(xpath = "//a[@id= 'attachment_add02']")
	public WebElement xpAttachCourseGradeAutoIT;

	@FindBy(xpath = "(//button[text()='Submit'])[1]")
	public WebElement xpSubmit;

	@FindBy(xpath = "//span[text()='Awaiting Approval']")
	public WebElement xpRequestTxt;

	@FindBy(xpath = "//div[text()='Request created']")
	public WebElement xpConfirmRequest;

	@FindBy(xpath = "//span[text()='Open']")
	public WebElement xpOpenState;

	@FindBy(xpath = "//*[@class='attachment_list_items']")
	public List<WebElement> xpAttachments;

	@FindBy(xpath = "//*[contains(@class,'list_row list_')]//td[5][contains(text(), 'e')]")
	public List<WebElement> xpTaskLists;

	@FindBy(xpath = "//*[contains(@class,'list_row list_')]/td[3]/a[contains(text(), 'HRT')]")
	public List<WebElement> xpTaskLinkLists;

	@FindBy(xpath = "//*[@id='cxs_maximize_results']")
	public WebElement xpKnowledgeResults;

	@FindBy(xpath = "//*[@id='sn_hr_core_task.description']")
	public WebElement xpDescriptionBody;

	@FindBy(xpath = "(//input[contains(@id,'cost_center_if_different_from_employee_s')])[2]")
	public WebElement xpGLCostObject;

	@FindBy(xpath = "(//input[contains(@id,'check_request_amount')])[2]")
	public WebElement xpCheckAmount;

	@FindBy(xpath = "//textarea[contains(@id,'additional_comments')]")
	public WebElement xpAdditionalComments;

	@FindBy(xpath = "(//*[text()='Check Request Details'])[2]")
	public WebElement xpCheckRequestDetailsTxt;

	@FindBy(xpath = "(//button[contains(@id,'task.assigned_to')])[1]")
	public WebElement xpAssignToSearch;

	@FindBy(xpath = "//select[contains(@id,'_select')]")
	public WebElement searchCriteria;

	@FindBy(xpath = "//select[contains(@id, '_select') and contains(@class, 'focus')]")
	public WebElement searchApprovalFor;

	@FindBy(xpath = "//input[contains(@id,'_text')]")
	public WebElement searchTextBox;

	@FindBy(xpath = "(//*[@id='sys_user_table_header_search_control'])[1]")
	public WebElement nameSearchTextBox;

	@FindBy(xpath = "//select[contains(@id,'task.state')]")
	public WebElement xpCaseState;

	@FindBy(xpath = "//textarea[contains(@id, 'activity-stream-work_notes-textarea')]")
	public WebElement caseWorknotes;

	@FindBy(xpath = "//button[text()='Post']")
	public WebElement postBt;

	@FindBy(xpath = "//input[@id='sys_display.sn_hr_core_task.assigned_to']")
	public WebElement assignToClick;

	@FindBy(xpath = "//*[contains(@id,'header') and contains(@class,'section_header_div_no_scroll form_title')]")
	public WebElement header;

	@FindBy(xpath = "//button[@id = 'toggleMoreOptions' ]")
	public WebElement moreOptions;

	@FindBy(xpath = "//button[@id='sysverb_update']")
	public WebElement updateButton;

	@FindBy(xpath = "//*[@role='menuitem' and @title = 'Save record and remain here']")
	public WebElement saveOption;

	@FindBy(xpath = "//span[contains(text(),'has been created for this Tuition Reimbursement Request')]")
	public WebElement xpCheckRequestTxt;

	@FindBy(xpath = "//td[@id='dropzone2']/div[2]//div[2]//a")
	public WebElement totalOpenCasesMyGroups;

	@FindBy(xpath = "//span[contains(text(),'input to submit the search.')]//following-sibling::input")
	public WebElement xpSearch;

	@FindBy(xpath = "//tbody[@class='list2_body']//tr//td[3]/a")
	public WebElement xpCaseNum;

	@FindBy(xpath = "//input[contains(@id,'sys_display.sn_hr') and contains(@id,'.opened_for')]")
	public WebElement xpRequesterName;

	@FindBy(xpath = "//input[contains(@id,'.opened_by_label')]")
	public WebElement xpOpenedBy;

	@FindBy(xpath = "//input[contains(@id, 'sys_display.sn_hr_') and contains(@id, 'subject_person')]")
	public WebElement xpabout;

	@FindBy(xpath = "//span[contains(text(),'This Check Request  was created from Tuition Reimbursement')]")
	public WebElement xpCheckRequestComment;

	@FindBy(xpath = "(//button[contains(@id,'.assigned_to')])[1]")
	public WebElement xpAssignTo;

	@FindBy(xpath = "(//*[@id='user_info_dropdown']//span)[3]")
	public WebElement xpUser;

	@FindBy(xpath = "//select[contains(@id,'.state')]")
	public WebElement xpCheckRequestState;

	@FindBy(xpath = "//select[contains(@id,'.priority')]")
	public WebElement xpPriority;

	@FindBy(xpath = "(//input[contains(@id,'.short_description')])[4]")
	public WebElement xpShortDescription;

	@FindBy(xpath = "(//input[contains(@id,'.hr_service')])[4]")
	public WebElement xpHRService;

	@FindBy(xpath = "(//input[contains(@id,'.assignment_group')])[4]")
	public WebElement xpAssignmentGrp;

	@FindBy(xpath = "(//input[contains(@id,'.u_date_and_time_the_check_is_needed')])[2]")
	public WebElement xpDateAndTimeCheck;

	@FindBy(xpath = "//a[contains(text(),' Cancel case ')]")
	public WebElement xpCancelCase;

	@FindBy(xpath = "//button[text()='OK']")
	public WebElement xpCancelOKBtn;

	@FindBy(xpath = "//span[contains(text(),'Cancelled')]")
	public WebElement xpCancelled;

	@FindBy(xpath = "(//button[text()='Reject'])[1]")
	public WebElement xpRejectbtn;

	@FindBy(xpath = "//textarea[contains(@id,'activity-stream-comments-textarea')]")
	public WebElement xpRejectComments;

	@FindBy(xpath = "//textarea[contains(@id,'activity-stream-textarea')]")
	public WebElement xpRejectComment2;

	@FindBy(xpath = "//*[starts-with(text(),'Rejected approval for HR Total Rewards Case')]")
	public WebElement xpConfirmReject;

	@FindBy(xpath = "//ul[contains(@id, 's2id_autogen') and contains(@id, '_results']/li")
	public WebElement xpCourseTopicData;

	@FindBy(xpath = "(//*[@class='file-upload-input'])[1]")
	public WebElement addAttachmentBtn;

	@FindBy(xpath = "(//input[@type = 'file'])[3]")
	public WebElement addAttachment;

	@FindBy(xpath = "(//input[@type = 'file'])[4]")
	public WebElement addAttachment1;

	@FindBy(xpath = "//*[@aria-label='Download attachment']")
	public WebElement attachmentAvailable;

	@FindBy(xpath = "//*[contains(text(), 'Add attachments')]")
	public WebElement lowerAddAttachment;

	@FindBy(xpath = "//li[@ng-repeat = 'attachment in attachments']")
	public List<WebElement> addedAttachmentsList;

	@FindBy(xpath = "//a[@id ='attachment_add']")
	public WebElement attachmentButton;

	@FindBy(xpath = "//a[@id ='attachment_add02']")
	public WebElement attachmentButton2;

	// verifing the description
	public void confirmDescription() throws Exception {
		waitForElement(driver, subHeadertxt);
		if (subHeadertxt.getText().trim().equals("Submit a course approval request.")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("sub header is matched with expected value", ExtentColor.GREEN));

			logSuccess("Expected value - " + "Submit a course approval request.");
			logSuccess("Actual value - " + subHeadertxt.getText().trim());

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Description matched");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("sub header is Not matched with expected value", ExtentColor.RED));

			logFailure("Expected value - " + "Submit a course approval request.");
			logFailure("Actual value - " + subHeadertxt.getText().trim());

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("description not matched");
		}
		System.out.println(descriptiontxt.getText());
	}

	// verifing the links
	public void linkValidations() throws Exception {
		Set<String> handles;
		Iterator<String> windowIterator;
		String windowName;

		String hrPageWindowHandle = driver.getWindowHandle();
		waitForElementToBeClickable(driver, tuitionReimbursementLink);
		tuitionReimbursementLink.click();
		waitForAction(driver);
		// Switch to new window opened
		handles = driver.getWindowHandles();
		windowIterator = handles.iterator();
		// iterate through your windows
		while (windowIterator.hasNext()) {
			windowName = windowIterator.next();
			if (!windowName.equals(hrPageWindowHandle)) {
				driver.switchTo().window(windowName);
				System.out.println(windowName);
				driver.switchTo().window(windowName);
				driver.manage().window().maximize();
				if (nextTabTuitionReimbursementTxt.isDisplayed()) {
					test.get().log(Status.PASS, MarkupHelper.createLabel(
							"Successfully navigate to opens a new tab/page to the WB Learning Tuition Reimbursement page",
							ExtentColor.GREEN));
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					System.out.println("opens a new tab/page to the WB Learning Tuition Reimbursement page");

				} else {
					test.get().log(Status.FAIL, MarkupHelper.createLabel(
							"Navigation Failed to opens a new tab/page to the WB Learning Tuition Reimbursement page",
							ExtentColor.RED));
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					System.out.println(
							"Navigation Failed to opens a new tab/page to the WB Learning Tuition Reimbursement page");
				}
			}
		}

		waitForAction(driver);
		driver.close();
		driver.switchTo().window(hrPageWindowHandle);

		waitForElementToBeClickable(driver, educationSupportLink);
		educationSupportLink.click();
		// Switch to new window opened
		handles = driver.getWindowHandles();
		windowIterator = handles.iterator();
		// iterate through your windows
		while (windowIterator.hasNext()) {
			windowName = windowIterator.next();
			if (!windowName.equals(hrPageWindowHandle)) {
				driver.switchTo().window(windowName);
				System.out.println(windowName);
				driver.manage().window().maximize();
				if (nextTabEducationSupportTxt.isDisplayed()) {
					test.get().log(Status.PASS, MarkupHelper.createLabel(
							"Successfully navigate to opens a new tab/page to the WB Learning Education Support page",
							ExtentColor.GREEN));
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					System.out.println("opens a new tab/page to the WB Learning Education Support page");

				} else {
					test.get().log(Status.FAIL, MarkupHelper.createLabel(
							"Navigation Failed to opens a new tab/page to the WB Learning Education Support page",
							ExtentColor.RED));
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					System.out.println(
							"Navigation Failed to opens a new tab/page to the WB Learning Education Support page");
				}
				driver.close();
			}
		}
		driver.switchTo().window(hrPageWindowHandle);
	}

	// validating the applicant information
	public void verifyApplicantInformation(String fstname, String lstname, String twid, String position,
			String costcenter, String businessunit) throws InterruptedException {
		waitForElementToBeClickable(driver, firstname);
		scrollToElement(driver, lastname);
		waitForAction(driver);

		if (firstname.isDisplayed() && firstname.getAttribute("readonly").equals("true")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("First Name  field is displayed and readonly", ExtentColor.GREEN));

			logSuccess("expected Value - " + "true");
			logSuccess("Actual Value - " + firstname.getAttribute("readonly"));

			if (firstname.getAttribute("value").equals(fstname)) {
				test.get().log(Status.PASS, MarkupHelper.createLabel(
						"First Name field is populated with expected value == " + firstname.getAttribute("value"),
						ExtentColor.GREEN));

				logSuccess("expected Value - " + fstname);
				logSuccess("Actual Value - " + firstname.getAttribute("value"));
			} else {
				test.get().log(Status.FAIL, MarkupHelper
						.createLabel("First Name field is not populated with expected value", ExtentColor.RED));
				logFailure("expected Value - " + fstname);
				logFailure("Actual Value - " + firstname.getAttribute("value"));
			}
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("First Name field is not displayed or it is not readonly", ExtentColor.RED));
			logFailure("expected Value - " + "true");
			logFailure("Actual Value - " + firstname.getAttribute("readonly"));
		}
		if (lastname.isDisplayed() && lastname.getAttribute("readonly").equals("true")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Last Name  field is displayed and readonly", ExtentColor.GREEN));

			logSuccess("expected Value - " + "true");
			logSuccess("Actual Value - " + lastname.getAttribute("readonly"));

			System.out.println(lastname.getAttribute("value"));
			if (lastname.getAttribute("value").equals(lstname)) {
				test.get().log(Status.PASS,
						MarkupHelper.createLabel(
								"Last Name field is populated with expected value == " + lastname.getAttribute("value"),
								ExtentColor.GREEN));
				logSuccess("expected Value - " + lstname);
				logSuccess("Actual Value - " + lastname.getAttribute("value"));
			} else {
				test.get().log(Status.FAIL, MarkupHelper
						.createLabel("Last Name field is not populated with expected value", ExtentColor.RED));
				logFailure("expected Value - " + lstname);
				logFailure("Actual Value - " + lastname.getAttribute("value"));
			}
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Last Name field is not displayed or it is not readonly", ExtentColor.RED));

			logFailure("expected Value - " + "true");
			logFailure("Actual Value - " + lastname.getAttribute("readonly"));

		}
		if (xptwid.isDisplayed() && xptwid.getAttribute("readonly").equals("true")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Twid field is displayed and readonly", ExtentColor.GREEN));

			logSuccess("expected Value - " + "true");
			logSuccess("Actual Value - " + xptwid.getAttribute("readonly"));

			System.out.println(xptwid.getAttribute("value"));
			if (xptwid.getAttribute("value").equals(twid)) {
				test.get().log(Status.PASS,
						MarkupHelper.createLabel(
								"Twid field is populated with expected value == " + xptwid.getAttribute("value"),
								ExtentColor.GREEN));
				logSuccess("expected Value - " + twid);
				logSuccess("Actual Value - " + xptwid.getAttribute("value"));
			} else {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("Twid field is not populated with expected value", ExtentColor.RED));
				logFailure("expected Value - " + twid);
				logFailure("Actual Value - " + xptwid.getAttribute("value"));
			}
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Twid field is not displayed or it is not readonly", ExtentColor.RED));
			logFailure("expected Value - " + "true");
			logFailure("Actual Value - " + xptwid.getAttribute("readonly"));
		}
		if (xpposition.isDisplayed() && xpposition.getAttribute("readonly").equals("true")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Position field is displayed and readonly", ExtentColor.GREEN));

			logSuccess("expected Value - " + "true");
			logSuccess("Actual Value - " + xpposition.getAttribute("readonly"));

			System.out.println(xpposition.getAttribute("value"));
			if (xpposition.getAttribute("value").equals(position)) {
				test.get().log(Status.PASS, MarkupHelper.createLabel(
						"Position field is populated with expected value == " + xpposition.getAttribute("value"),
						ExtentColor.GREEN));
				logSuccess("expected Value - " + position);
				logSuccess("Actual Value - " + xpposition.getAttribute("value"));
			} else {
				test.get().log(Status.FAIL, MarkupHelper
						.createLabel("Position field is not populated with expected value", ExtentColor.RED));
				logFailure("expected Value - " + position);
				logFailure("Actual Value - " + xpposition.getAttribute("value"));
			}
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Position field is not displayed or it is not readonly", ExtentColor.RED));

			logFailure("expected Value - " + "true");
			logFailure("Actual Value - " + xpposition.getAttribute("readonly"));
		}
		if (xpcostcenter.isDisplayed() && xpcostcenter.getAttribute("readonly").equals("true")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Cost Center field is displayed and readonly", ExtentColor.GREEN));

			logSuccess("expected Value - " + "true");
			logSuccess("Actual Value - " + xpcostcenter.getAttribute("readonly"));

			System.out.println(xpcostcenter.getAttribute("value"));
			if (xpcostcenter.getAttribute("value").equals(costcenter)) {
				test.get().log(Status.PASS, MarkupHelper.createLabel(
						"Cost Center field is populated with expected value == " + xpcostcenter.getAttribute("value"),
						ExtentColor.GREEN));

				logSuccess("expected Value - " + costcenter);
				logSuccess("Actual Value - " + xpcostcenter.getAttribute("value"));

			} else {
				test.get().log(Status.FAIL, MarkupHelper
						.createLabel("Cost Center field is not populated with expected value", ExtentColor.RED));
				logFailure("expected Value - " + costcenter);
				logFailure("Actual Value - " + xpcostcenter.getAttribute("value"));
			}
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Cost Center field is not displayed or it is not readonly", ExtentColor.RED));
			logFailure("expected Value - " + "true");
			logFailure("Actual Value - " + xpcostcenter.getAttribute("readonly"));
		}

		if (xpbusinessunit.isDisplayed() && xpbusinessunit.getAttribute("readonly").equals("true")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Business Unit field is displayed and readonly", ExtentColor.GREEN));

			logSuccess("expected Value - " + "true");
			logSuccess("Actual Value - " + xpbusinessunit.getAttribute("readonly"));

			System.out.println(xpbusinessunit.getAttribute("value"));
			if (xpbusinessunit.getAttribute("value").equals(businessunit)) {
				test.get().log(Status.PASS,
						MarkupHelper.createLabel("Business Unit field is populated with expected value == "
								+ xpbusinessunit.getAttribute("value"), ExtentColor.GREEN));
				logSuccess("expected Value - " + businessunit);
				logSuccess("Actual Value - " + xpbusinessunit.getAttribute("value"));
			} else {
				test.get().log(Status.FAIL, MarkupHelper
						.createLabel("Business Unit field is not populated with expected value", ExtentColor.RED));
				logFailure("expected Value - " + businessunit);
				logFailure("Actual Value - " + xpbusinessunit.getAttribute("value"));
			}
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Business Unit field is not displayed or it is not readonly", ExtentColor.RED));
			logFailure("expected Value - " + "true");
			logFailure("Actual Value - " + xpbusinessunit.getAttribute("readonly"));
		}

	}

	// validating the approver work flow
	public void validateApproverWorkflow(String supervisor, String hrRepresentative, String departmentMoreInfo)
			throws IOException {
		waitForElement(driver, xpsupervisorApproval);
		if (xpsupervisorApproval.isDisplayed() && xpsupervisorApproval.getAttribute("readonly").equals("true")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Supervisor Approver field is displayed and readonly", ExtentColor.GREEN));

			logSuccess("expected Value - " + "true");
			logSuccess("Actual Value - " + xpsupervisorApproval.getAttribute("readonly"));
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Supervisor Approver field is not displayed or it is not readonly", ExtentColor.RED));
			logFailure("expected Value - " + "true");
			logFailure("Actual Value - " + xpsupervisorApproval.getAttribute("readonly"));
		}
		if (xpDepartmentHeadApproval.isDisplayed() && xpDepartmentHeadApproval.getAttribute("value").isEmpty()) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("Department Head Approver field is displayed and empty", ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Department Head Approver field is not displayed", ExtentColor.RED));
		}
		if (xpHRRepresentativeApproval.isDisplayed()
				&& xpHRRepresentativeApproval.getAttribute("readonly").equals("true")) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("HR Representative Approver field is displayed and readonly", ExtentColor.GREEN));

			logSuccess("expected Value - " + "true");
			logSuccess("Actual Value - " + xpHRRepresentativeApproval.getAttribute("readonly"));

			if (xpHRRepresentativeApproval.getAttribute("value").equals(hrRepresentative)) {
				test.get().log(Status.PASS,
						MarkupHelper.createLabel("HR Representative Approver field is populated with expected value == "
								+ xpHRRepresentativeApproval.getAttribute("value"), ExtentColor.GREEN));
				logSuccess("expected Value - " + hrRepresentative);
				logSuccess("Actual Value - " + xpHRRepresentativeApproval.getAttribute("value"));
			} else {
				test.get().log(Status.FAIL, MarkupHelper.createLabel(
						"HR Representative Approver field is not populated with expected value", ExtentColor.RED));

				logFailure("expected Value - " + hrRepresentative);
				logFailure("Actual Value - " + xpHRRepresentativeApproval.getAttribute("value"));

			}
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"HR Representative Approver field is not displayed or it is not readonly", ExtentColor.RED));

			logFailure("expected Value - " + "true");
			logFailure("Actual Value - " + xpHRRepresentativeApproval.getAttribute("readonly"));

		}
		if (xpWbLearningApproval.isDisplayed() && xpWbLearningApproval.getAttribute("readonly").equals("true")) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("WB Learning Approver field is displayed and readonly",
					ExtentColor.GREEN));

			logSuccess("expected Value - " + "true");
			logSuccess("Actual Value - " + xpWbLearningApproval.getAttribute("readonly"));

			if (xpWbLearningApproval.getAttribute("value").equals("WB Learning Approval")) {
				test.get().log(Status.PASS,
						MarkupHelper.createLabel("Wb Learning Approver field is populated with expected value == "
								+ xpWbLearningApproval.getAttribute("value"), ExtentColor.GREEN));

				logSuccess("expected Value - " + "WB Learning Approval");
				logSuccess("Actual Value - " + xpWbLearningApproval.getAttribute("value"));

			} else {
				test.get().log(Status.FAIL, MarkupHelper.createLabel(
						"Wb Learning Approver field is not populated with expected value", ExtentColor.RED));
				logFailure("expected Value - " + "WB Learning Approval");
				logFailure("Actual Value - " + xpWbLearningApproval.getAttribute("value"));
			}
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Wb Learning Approver field is not displayed or it is not readonly", ExtentColor.RED));

			logFailure("expected Value - " + "true");
			logFailure("Actual Value - " + xpWbLearningApproval.getAttribute("readonly"));

		}
		if (xpDevelopmentApproval.isDisplayed() && xpDevelopmentApproval.getAttribute("readonly").equals("true")) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("Development Approver field is displayed and readonly",
					ExtentColor.GREEN));

			logSuccess("expected Value - " + "true");
			logSuccess("Actual Value - " + xpDevelopmentApproval.getAttribute("readonly"));

			if (xpDevelopmentApproval.getAttribute("value").equals("Org. Development Approval")) {
				test.get().log(Status.PASS,
						MarkupHelper.createLabel("Development Approver field is populated with expected value == "
								+ xpDevelopmentApproval.getAttribute("value"), ExtentColor.GREEN));

				logSuccess("expected Value - " + "Org. Development Approval");
				logSuccess("Actual Value - " + xpDevelopmentApproval.getAttribute("value"));
			} else {
				test.get().log(Status.FAIL, MarkupHelper.createLabel(
						"Development Approver field is not populated with expected value", ExtentColor.RED));
				logFailure("expected Value - " + "Org. Development Approval");
				logFailure("Actual Value - " + xpDevelopmentApproval.getAttribute("value"));
			}
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Development Approver field is not displayed or it is not readonly", ExtentColor.RED));
			logFailure("expected Value - " + "true");
			logFailure("Actual Value - " + xpDevelopmentApproval.getAttribute("readonly"));
		}

		if (xpDepartmentHelpTxt.getText().equalsIgnoreCase(departmentMoreInfo)) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("Department Head Help text matched with expected value", ExtentColor.GREEN));

			logSuccess("expected Value - " + departmentMoreInfo);
			logSuccess("Actual Value - " + xpDepartmentHelpTxt.getText());

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Department Head Help text matched with expected value");

		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Department Head Help text Not matched with expected value", ExtentColor.RED));

			logFailure("expected Value - " + departmentMoreInfo);
			logFailure("Actual Value - " + xpDepartmentHelpTxt.getText());

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Department Head Help text Not matched with expected value");
		}
	}

	// validating the department head approval
	public void validateDepartmentHeadApproval(String activeEmail, String activeNoHRProfile, String inValidEmail,
			String departmentHeadEmail) throws Exception {
		waitForElementToBeClickable(driver, xpDepartmentHeadApproval);
		xpDepartmentHeadApproval.sendKeys(activeEmail, Keys.TAB);
		waitForAction(driver);

		waitForElementToBeClickable(driver, xpHRRepresentativeApproval);
		xpHRRepresentativeApproval.click();
		waitForAction(driver);
		if (!driver.getPageSource().contains("Department Head Information not found!")) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Active User  Accepted for department head info", ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Active User is not Accepted for department head info", ExtentColor.RED));
		}

		waitForElementToBeClickable(driver, xpDepartmentHeadApproval);
		xpDepartmentHeadApproval.clear();
		waitForAction(driver);
		xpDepartmentHeadApproval.sendKeys(activeNoHRProfile, Keys.TAB);
		waitForAction(driver);

		waitForElementToBeClickable(driver, xpHRRepresentativeApproval);
		xpHRRepresentativeApproval.click();
		waitForAction(driver);
		if (isElementPresent(xpDepartmentErrorText) == true) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Active User That does not have HR Profile Email is Not Accepted and Error message displayed",
					ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Active User That does not have HR Profile Email is Accepted and Error message Not displayed",
					ExtentColor.RED));
		}

		waitForElementToBeClickable(driver, xpDepartmentHeadApproval);
		xpDepartmentHeadApproval.clear();
		waitForAction(driver);
		xpDepartmentHeadApproval.sendKeys(inValidEmail, Keys.TAB);
		waitForAction(driver);

		waitForElementToBeClickable(driver, xpHRRepresentativeApproval);
		xpHRRepresentativeApproval.click();
		waitForAction(driver);
		if (isElementPresent(xpDepartmentErrorText) == true) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Invalid Email Address is Not Accepted and Error message displayed", ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Invalid Email Address is Accepted and Error message Not displayed", ExtentColor.RED));
		}

		waitForElementToBeClickable(driver, xpDepartmentHeadApproval);
		xpDepartmentHeadApproval.clear();
		waitForAction(driver);
		xpDepartmentHeadApproval.sendKeys(departmentHeadEmail, Keys.TAB);
		waitForAction(driver);

		waitForElementToBeClickable(driver, xpHRRepresentativeApproval);
		xpHRRepresentativeApproval.click();
		checkForPageLoad(driver);
		System.out.println("Page Source - " + driver.getPageSource());
		if (!driver.getPageSource().contains("Department Head Information not found!")) {
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("Department head email is Accepted for department head info", ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Department head email is not Accepted for department head info", ExtentColor.RED));
		}
	}

	// validating the course info
	public void validateCourseInfo(String eduInstitutionname, String degreeName, String courseHelptxt)
			throws Exception {
		scrollToElement(driver, xpEduactionInstitutionname);
		waitForAction(driver);
		waitForElementToBeClickable(driver, xpEduactionInstitutionname);
		xpEduactionInstitutionname.sendKeys(eduInstitutionname);
		test.get().log(Status.INFO, MarkupHelper.createLabel(
				"Successfully pass the Education Institution Name == " + eduInstitutionname, ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		System.out.println("Successfully pass the Education Institution Name == " + eduInstitutionname);

		waitForElementToBeClickable(driver, xpYesRadio);
		xpYesRadio.click();
		waitForElementToBeClickable(driver, xpDegreeName);
		xpDegreeName.sendKeys(degreeName);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Successfully pass the Degree Name == " + degreeName, ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		System.out.println("Successfully pass the Education Institution Name == " + degreeName);

		waitForAction(driver);
		if (xpCourseHelpTxt.getText().equals(courseHelptxt)) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"Course Help text matched with expected text == " + xpCourseHelpTxt.getText(), ExtentColor.GREEN));
			logSuccess("Expected Value - " + courseHelptxt);
			logSuccess("Actual Value - " + xpCourseHelpTxt.getText());
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Course Help text matched with expected text");
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Course Help text Not matched with expected text", ExtentColor.RED));
			logFailure("Expected Value - " + courseHelptxt);
			logFailure("Actual Value - " + xpCourseHelpTxt.getText());
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			System.out.println("Course Help text Not matched with expected text");
		}
	}

	// validating the course info
	public void validateCourseInfo2(String eduInstitutionname) throws Exception {
		scrollToElement(driver, xpEduactionInstitutionname);
		waitForAction(driver);
		xpEduactionInstitutionname.sendKeys(eduInstitutionname);
		logInfo("Successfully pass the Education Institution Name == " + eduInstitutionname);
		waitForElementToBeClickable(driver, xpNoRadio);
		xpNoRadio.click();
		logInfo("clicking the enrolled degree program::No ");
		logInfoScreenshot(driver);
	}

	// enter the course 1 details
	public String populateCourse1Details(String title, String tuitionFee, String startdate, String enddate,
			String description, String courserelevance, String coursetopic) throws Exception {
		test.get().log(Status.INFO, MarkupHelper.createLabel("Course 1 Details are below", ExtentColor.ORANGE));
		waitForElementToBeClickable(driver, xpCourseTitle);
		xpCourseTitle.sendKeys(title);
		waitForElement(driver, xpCourseTitle);
		/* String actualTitle = xpCourseTitle.getAttribute("value").trim(); */
		test.get().log(Status.INFO, MarkupHelper.createLabel("enter the course Title == " + title, ExtentColor.CYAN));

		waitForElementToBeClickable(driver, xpEstimateTuitionFee);
		xpEstimateTuitionFee.sendKeys(tuitionFee);
		waitForElement(driver, xpEstimateTuitionFee);
		String actualTuitionFee = xpEstimateTuitionFee.getAttribute("value").trim();
		System.out.println(actualTuitionFee);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("enter the EstimateTuition fee == " + tuitionFee, ExtentColor.CYAN));

		waitForElementToBeClickable(driver, xpStartDate);
		xpStartDate.sendKeys(startdate);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("enter the course start date == " + startdate, ExtentColor.CYAN));

		waitForElementToBeClickable(driver, xpEndDate);
		xpEndDate.sendKeys(enddate);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("enter the course end date == " + enddate, ExtentColor.CYAN));

		waitForElementToBeClickable(driver, xpCourseDescription);
		xpCourseDescription.sendKeys(description);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("enter Course Description == " + description, ExtentColor.CYAN));

		waitForElementToBeClickable(driver, xpCourseRelevance);
		xpCourseRelevance.sendKeys(courserelevance);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("enter the course relevance == " + courserelevance, ExtentColor.CYAN));

		scrollToElement(driver, xpCourseTopic);
		waitForAction(driver);
		waitForElementToBeClickable(driver, xpCourseTopic);
		xpCourseTopic.click();
		System.out.println(coursetopic);
		waitForAction(driver);
		xpCourseTopic.sendKeys(coursetopic);
		checkForPageLoad(driver);

		for (WebElement element : xpCourse1TopicList) {
			if (element.getText().contains(coursetopic)) {
				try {
					waitForElementToBeClickable(driver, xpCourse1TopicList.get(0));
					xpCourse1TopicList.get(0).click();
				} catch (Exception e) {
					try {
						waitForElementToBeClickable(driver, element);
						element.click();
					} catch (Exception e2) {
						System.out.println("Error while selecting Course Topic");
					}
				}
				test.get().log(Status.PASS, MarkupHelper.createLabel(
						"Course1 topic List matched with expected text == " + coursetopic, ExtentColor.GREEN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				break;
			}
		}

		waitForElementToBeClickable(driver, xpCourseTopic);
		waitForAction(driver);
		xpCourseTopic.click();
		waitForAction(driver);
		xpCourseTopic.sendKeys("Other");
		checkForPageLoad(driver);

		for (WebElement element : xpCourse1TopicList) {
			if (element.getText().contains("Other")) {
				try {
					waitForElementToBeClickable(driver, xpCourse1TopicList.get(0));
					xpCourse1TopicList.get(0).click();
				} catch (Exception e) {
					try {
						waitForElementToBeClickable(driver, element);
						element.click();
					} catch (Exception e2) {
						System.out.println("Error while selecting Course Topic");
					}
				}

				test.get().log(Status.PASS, MarkupHelper
						.createLabel("Course1 topic List matched with expected text == " + "Other", ExtentColor.GREEN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				break;
			}
		}
		waitForElementToBeClickable(driver, xpSpecifyOther);
		xpSpecifyOther.sendKeys("Design Thinking");
		test.get().log(Status.PASS,
				MarkupHelper.createLabel("entering the Specify other topic==Design Thinking", ExtentColor.GREEN));

		waitForElementToBeClickable(driver, xpRequestedBy);
		String requestedUser = xpRequestedBy.getText().trim();
		return requestedUser;
	}

	// enter the course 2 details
	public void populateCourse2Details(String title2, String tuitionFee2, String startdate2, String enddate2,
			String description2, String courserelevance2, String coursetopic2) throws Exception {
		scrollToElement(driver, xpAddCourseBtn);
		waitForAction(driver);
		waitForElementToBeClickable(driver, xpAddCourseBtn);
		xpAddCourseBtn.click();
		waitForAction(driver);
		if (isElementPresent(xpCourse2Header)) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Course 2 Details Fields are visible", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Course 2 Details Fields are Not visible", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		test.get().log(Status.INFO, MarkupHelper.createLabel("Course 2 Details are below", ExtentColor.ORANGE));

		waitForElementToBeClickable(driver, xpCourse2Title);
		xpCourse2Title.sendKeys(title2);
		waitForAction(driver);
		waitForElement(driver, xpCourse2Title);
		String actualTitleCrs2 = xpCourse2Title.getAttribute("value").trim();
		System.out.println(actualTitleCrs2);
		test.get().log(Status.INFO, MarkupHelper.createLabel("enter the course2 Title == " + title2, ExtentColor.CYAN));

		waitForElementToBeClickable(driver, xpCourse2EstimateTuitionFee);
		xpCourse2EstimateTuitionFee.sendKeys(tuitionFee2);
		waitForElement(driver, xpCourse2EstimateTuitionFee);
		String actualTuitionFeeCrs2 = xpCourse2EstimateTuitionFee.getAttribute("value").trim();
		System.out.println(actualTuitionFeeCrs2);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("enter the course2 EstimateTuition fee == " + tuitionFee2, ExtentColor.CYAN));

		waitForElementToBeClickable(driver, xpCourse2StartDate);
		xpCourse2StartDate.sendKeys(startdate2);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("enter the course2 start date == " + startdate2, ExtentColor.CYAN));

		waitForElementToBeClickable(driver, xpCourse2EndDate);
		xpCourse2EndDate.sendKeys(enddate2);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("enter the course2 end date == " + enddate2, ExtentColor.CYAN));

		waitForElementToBeClickable(driver, xpCourse2Description);
		xpCourse2Description.sendKeys(description2);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("enter Course2 Description == " + description2, ExtentColor.CYAN));

		waitForElementToBeClickable(driver, xpCourse2Relevance);
		xpCourse2Relevance.sendKeys(courserelevance2);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("enter the course2 relevance == " + courserelevance2, ExtentColor.CYAN));

		scrollToElement(driver, xpCourse2Topic);
		waitForAction(driver);
		waitForElementToBeClickable(driver, xpCourse2Topic);
		xpCourse2Topic.click();
		waitForAction(driver);
		xpCourse2Topic.sendKeys(coursetopic2);
		checkForPageLoad(driver);

		for (WebElement element : xpCourse2TopicList) {
			if (element.getText().contains(coursetopic2)) {
				try {
					waitForElementToBeClickable(driver, xpCourse2TopicList.get(0));
					xpCourse2TopicList.get(0).click();
				} catch (Exception e) {
					try {
						waitForElementToBeClickable(driver, element);
						element.click();
					} catch (Exception e2) {
						System.out.println("Error while selecting Course Topic");
					}
				}
				test.get().log(Status.PASS, MarkupHelper.createLabel(
						"Course2 topic List matched with expected text == " + coursetopic2, ExtentColor.GREEN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				break;
			}
		}

		waitForElementToBeClickable(driver, xpCourse2Topic);
		xpCourse2Topic.click();
		waitForAction(driver);
		xpCourse2Topic.sendKeys("Other");
		checkForPageLoad(driver);
		for (WebElement element : xpCourse2TopicList) {
			if (element.getText().contains("Other")) {
				try {
					waitForElementToBeClickable(driver, xpCourse2TopicList.get(0));
					xpCourse2TopicList.get(0).click();
				} catch (Exception e) {
					try {
						waitForElementToBeClickable(driver, element);
						element.click();
					} catch (Exception e2) {
						System.out.println("Error while selecting Course Topic");
					}
				}
				test.get().log(Status.PASS,
						MarkupHelper.createLabel("Clicked on Other in course2 topic list ", ExtentColor.GREEN));
				break;
			}
		}

		waitForElementToBeClickable(driver, xpCourse2SpecifyOther);
		xpCourse2SpecifyOther.sendKeys("Design Thinking");
		test.get().log(Status.PASS,
				MarkupHelper.createLabel("entering the Specify other topic==Design Thinking", ExtentColor.GREEN));
	}

	// enter the course 3 details
	public void populateCourse3Details(String title3, String tuitionFee3, String startdate3, String endDate3,
			String description3, String courserelevance3, String coursetopic3) throws Exception {
		waitForElementToBeClickable(driver, xpAddCourseBtn);
		xpAddCourseBtn.click();
		waitForAction(driver);
		if (isElementPresent(xpCourse3Header)) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Course 3 Details Fields are visible", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Course 3 Details Fields are Not visible", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		test.get().log(Status.INFO, MarkupHelper.createLabel("Course 3 Details are below", ExtentColor.ORANGE));
		waitForElementToBeClickable(driver, xpCourse3Title);
		xpCourse3Title.sendKeys(title3);
		waitForAction(driver);
		/* String actualTitleCrs3 = xpCourse3Title.getAttribute("value").trim() */;
		test.get().log(Status.INFO, MarkupHelper.createLabel("enter the course3 Title == " + title3, ExtentColor.CYAN));
		waitForElementToBeClickable(driver, xpCourse3EstimateTuitionFee);
		xpCourse3EstimateTuitionFee.sendKeys(tuitionFee3);
		waitForAction(driver);
		/*
		 * String actualTuitionFeeCrs3 =
		 * xpCourse3EstimateTuitionFee.getAttribute("value").trim();
		 */

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("enter the course3 EstimateTuition fee == " + tuitionFee3, ExtentColor.CYAN));
		waitForElementToBeClickable(driver, xpCourse3StartDate);
		xpCourse3StartDate.sendKeys(startdate3);
		System.out.println(startdate3);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("enter the course3 start date == " + startdate3, ExtentColor.CYAN));
		waitForElementToBeClickable(driver, xpCourse3EndDate);
		xpCourse3EndDate.sendKeys(endDate3, Keys.TAB);
		waitForAction(driver);

		System.out.println(endDate3);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("enter the course3 end date == " + endDate3, ExtentColor.CYAN));
		waitForElementToBeClickable(driver, xpCourse3Description);
		xpCourse3Description.sendKeys(description3);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("enter Course3 Description == " + description3, ExtentColor.CYAN));
		waitForElementToBeClickable(driver, xpCourse3Relevance);
		xpCourse3Relevance.sendKeys(courserelevance3);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("enter the course3 relevance == " + courserelevance3, ExtentColor.CYAN));

		scrollToElement(driver, xpCourse3Topic);
		waitForAction(driver);
		waitForElementToBeClickable(driver, xpCourse3Topic);
		xpCourse3Topic.click();
		waitForAction(driver);
		xpCourse3Topic.sendKeys(coursetopic3);
		checkForPageLoad(driver);
		for (WebElement element : xpCourse3TopicList) {
			if (element.getText().contains(coursetopic3)) {
				try {
					waitForElementToBeClickable(driver, xpCourse3TopicList.get(0));
					xpCourse3TopicList.get(0).click();
				} catch (Exception e) {
					try {
						waitForElementToBeClickable(driver, element);
						element.click();
					} catch (Exception e2) {
						System.out.println("Error while selecting Course Topic");
					}
				}
				test.get().log(Status.PASS, MarkupHelper.createLabel(
						"Course3 topic List matched with expected text == " + coursetopic3, ExtentColor.GREEN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				break;
			}
		}

		waitForElementToBeClickable(driver, xpCourse3Topic);
		xpCourse3Topic.click();
		waitForAction(driver);
		xpCourse3Topic.sendKeys("Other");
		checkForPageLoad(driver);

		for (WebElement element : xpCourse3TopicList) {
			if (element.getText().contains("Other")) {
				try {
					waitForElementToBeClickable(driver, xpCourse3TopicList.get(0));
					xpCourse3TopicList.get(0).click();
				} catch (Exception e) {
					try {
						waitForElementToBeClickable(driver, element);
						element.click();
					} catch (Exception e2) {
						System.out.println("Error while selecting Course Topic");
					}
				}
				test.get().log(Status.PASS,
						MarkupHelper.createLabel("Clicked on Other in course3 topic list ", ExtentColor.GREEN));
				break;
			}
		}
		waitForElementToBeClickable(driver, xpCourse3SpecifyOther);
		xpCourse3SpecifyOther.sendKeys("Design Thinking");
		test.get().log(Status.PASS,
				MarkupHelper.createLabel("entering the Specify other topic==Design Thinking", ExtentColor.GREEN));
	}

	// enteing the course 4 details
	public void populateCourse4Details(String title4, String tuitionFee4, String startdate4, String enddate4,
			String description4, String courserelevance4, String coursetopic4) throws Exception {
		scrollToElement(driver, xpAddCourseBtn);
		waitForAction(driver);
		waitForElementToBeClickable(driver, xpAddCourseBtn);
		xpAddCourseBtn.click();
		waitForAction(driver);
		if (isElementPresent(xpCourse4Header)) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Course 4 Details Fields are visible", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Course 4 Details Fields are Not visible", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		test.get().log(Status.INFO, MarkupHelper.createLabel("Course 4 Details are below", ExtentColor.ORANGE));
		waitForElementToBeClickable(driver, xpCourse4Title);
		xpCourse4Title.sendKeys(title4);
		waitForAction(driver);
		/* actualTitleCrs4 = xpCourse4Title.getAttribute("value").trim(); */
		test.get().log(Status.INFO, MarkupHelper.createLabel("enter the course4 Title == " + title4, ExtentColor.CYAN));
		waitForElementToBeClickable(driver, xpCourse4EstimateTuitionFee);
		xpCourse4EstimateTuitionFee.sendKeys(tuitionFee4);
		waitForAction(driver);
		/*
		 * actualTuitionFeeCrs4 =
		 * xpCourse4EstimateTuitionFee.getAttribute("value").trim();
		 */

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("enter the course4 EstimateTuition fee == " + tuitionFee4, ExtentColor.CYAN));
		waitForElementToBeClickable(driver, xpCourse4StartDate);
		xpCourse4StartDate.sendKeys(startdate4);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("enter the course4 start date == " + startdate4, ExtentColor.CYAN));
		waitForElementToBeClickable(driver, xpCourse4EndDate);
		xpCourse4EndDate.sendKeys(enddate4);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("enter the course4 end date == " + enddate4, ExtentColor.CYAN));
		waitForElementToBeClickable(driver, xpCourse4Description);
		xpCourse4Description.sendKeys(description4);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("enter Course4 Description == " + description4, ExtentColor.CYAN));
		waitForElementToBeClickable(driver, xpCourse4Relevance);
		xpCourse4Relevance.sendKeys(courserelevance4);
		waitForAction(driver);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("enter the course4 relevance == " + courserelevance4, ExtentColor.CYAN));

		scrollToElement(driver, xpCourse4Topic);
		waitForAction(driver);
		waitForElementToBeClickable(driver, xpCourse4Topic);
		xpCourse4Topic.click();
		waitForAction(driver);
		xpCourse4Topic.sendKeys(coursetopic4);
		checkForPageLoad(driver);

		for (WebElement element : xpCourse4TopicList) {
			if (element.getText().contains(coursetopic4)) {
				try {
					waitForElementToBeClickable(driver, xpCourse4TopicList.get(0));
					xpCourse4TopicList.get(0).click();
				} catch (Exception e) {
					try {
						waitForElementToBeClickable(driver, element);
						element.click();
					} catch (Exception e2) {
						System.out.println("Error while selecting Course Topic");
					}
				}
				waitForAction(driver);
				test.get().log(Status.PASS, MarkupHelper.createLabel(
						"Course4 topic List matched with expected text == " + coursetopic4, ExtentColor.GREEN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				break;
			}
		}

		waitForElementToBeClickable(driver, xpCourse4Topic);
		xpCourse4Topic.click();
		waitForAction(driver);
		xpCourse4Topic.sendKeys("Other");
		checkForPageLoad(driver);

		for (WebElement element : xpCourse4TopicList) {
			if (element.getText().contains("Other")) {
				try {
					waitForElementToBeClickable(driver, xpCourse4TopicList.get(0));
					xpCourse4TopicList.get(0).click();
				} catch (Exception e) {
					try {
						waitForElementToBeClickable(driver, element);
						element.click();
					} catch (Exception e2) {
						System.out.println("Error while selecting Course Topic");
					}
				}
				waitForAction(driver);
				test.get().log(Status.PASS,
						MarkupHelper.createLabel("Clicked on Other in course4 topic list ", ExtentColor.GREEN));
				break;
			}
		}
		waitForElementToBeClickable(driver, xpCourse4SpecifyOther);
		xpCourse4SpecifyOther.sendKeys("Design Thinking");
		test.get().log(Status.PASS,
				MarkupHelper.createLabel("entering the Specify other topic==Design Thinking", ExtentColor.GREEN));
	}

	// submit the course details
	public String submitCourse() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", xpSubmitBtn);
		waitForAction(driver);
		scrollPageDown(driver);
		waitForElementToBeClickable(driver, xpSubmitBtn);
		/*
		 * Actions actions = new Actions(driver);
		 * actions.click(xpSubmitBtn).build().perform();
		 */
		js.executeScript("arguments[0].click();", xpSubmitBtn);

		try {
			checkForPageLoad(driver);
			xpSubmitBtn.click();
		} catch (Exception e) {
			System.out.println("Element may have clicked already.");
		}
		test.get().log(Status.INFO, MarkupHelper.createLabel("clicking the submit button", ExtentColor.CYAN));

		String caseId = null;
		waitForElementToBeClickable(driver, xpsubHeader);
		driver.get(driver.getCurrentUrl());
		checkForPageLoad(driver);
		waitForElement(driver, xpsubHeader);
		if (isElementPresent(xpsubHeader)) {
			waitForElementToBeClickable(driver, xpTicketID);
			caseId = xpTicketID.getText().trim();
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"Successfully submit the request and Ticket Submission page is displayed with ticketId == "
									+ xpTicketID.getText().trim(),
							ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Failed to submit the request and Ticket submission Page not displayed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		for (WebElement element : xpApproverList) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Approver names are == " + element.getText().trim(), ExtentColor.CYAN));
			System.out.println("Approver info:" + element.getText().trim());

		}
		String caseIdUrl = driver.getCurrentUrl();
		System.out.println("HR Ticket URL - " + caseIdUrl);
		return caseId;
	}

	// https://wbpreview.service-now.com/hr_portal?id=hrj_ticket_page&is_new_order=true&table=sn_hr_core_case_total_rewards&sys_id=4c7845431b1b04503e8e7592cd4bcbb5
	// validating the and approving the requests
	public void validateCase(String caseID, String user) throws Exception {
		System.out.println("Navigating to Home Page");
		driver.get(homePageURL);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, leftSearch);

		while (!isElementPresent(leftSearch)) {
			System.out.println("Refreshing Page");
			driver.get(homePageURL);
			System.out.println("Refreshing Page");
			waitForElementToBeClickable(driver, leftSearch);
		}

		leftSearch.sendKeys("CASE");
		checkForPageLoad(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		waitForElementToBeClickable(driver, xpOpen);
		js.executeScript("arguments[0].click();", xpOpen);
		checkForPageLoad(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, xpCasesPage);
		if (xpCasesPage.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Successfully Navigate to HR Cases Page", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Navigation Failed to reach the HR Cases Page", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, searchNumberDropDown);
		Select select = new Select(searchNumberDropDown);
		select.selectByVisibleText("Number");
		waitForElementToBeClickable(driver, searchTextBox);
		searchTextBox.sendKeys(caseID);
		waitForAction(driver);
		searchTextBox.sendKeys(Keys.ENTER);
		waitForAction(driver);

		waitForElementToBeClickable(driver, xpNumberSearch);
		/*
		 * xpNumberSearch.clear(); xpNumberSearch.sendKeys(caseID);
		 * waitForAction(driver); xpNumberSearch.sendKeys(Keys.ENTER);
		 */
		logInfo("Search for the case id == " + caseID);
		waitForElementToBeClickable(driver, xpUniqueCaseId);
		xpUniqueCaseId.click();
		System.out.println("Clicked on the case id - " + caseID);

		waitForElement(driver, xpApproverTab);
		if (!isElementPresent(xpApproverTab)) {
			driver.get(driver.getCurrentUrl());
			waitForFrameToBeAvailable(driver, "gsft_main");
			System.out.println("Refreshed.");
		}

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, xpApproverTab);
		js.executeScript("arguments[0].scrollIntoView();", xpApproverTab);
		waitForAction(driver);
		waitForElementToBeClickable(driver, xpApproverTab);
		xpApproverTab.click();
		System.out.println("Clicking the approvers tab");
		logInfo("Clicking the approvers tab");
		waitForAction(driver);

		String approver = null;
		for (int i = 0; i < xpState.size(); i++) {
			int count = 0;
			// for loop
			for (int j = 0; j < xpState.size(); j++) {
				if (xpState.get(j).getText().trim().equals("Requested")) {
					scrollToElement(driver, xpState.get(j));
					waitForAction(driver);
					System.out.println("Searching for the Requested Approver");
					test.get().log(Status.PASS,
							MarkupHelper.createLabel("Searching for the Requested Approver", ExtentColor.GREEN));
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					approver = driver.findElement(By.xpath(
							"(//tr[contains(@id,'row_sn_hr_core_case_total_rewards.sysapproval_approver')]/td[4]//a)["
									+ (j + 1) + "]"))
							.getText();
					waitForAction(driver);
					count++;
				}
			}

			if (count == 0) {
				break;
			}
			driver.switchTo().defaultContent();
			waitForElementToBeClickable(driver, userMenu);
			userMenu.click();
			System.out.println("Clicked on User Menu.");
			waitForElementToBeClickable(driver, impUser);
			js.executeScript("arguments[0].click();", impUser);
			waitForElementToBeClickable(driver, impUserDropDwn);
			impUserDropDwn.click();
			waitForAction(driver);
			waitForElementToBeClickable(driver, impUserSendkys);
			impUserSendkys.sendKeys(approver);
			System.out.println("Selected Approver - " + approver);
			checkForPageLoad(driver);

			if (approver.equalsIgnoreCase("nicole yonan")) {
				impUserSendkys.sendKeys(Keys.DOWN);
				waitForAction(driver);
			}
			impUserSendkys.sendKeys(Keys.ENTER);
			checkForPageLoad(driver);

			logInfo("Impersonate the User and username=" + approver);
			System.out.println("Impersonating as - " + approver);
			driver.get(homePageURL);

			if (!isElementPresent(leftSearch)) {
				driver.get(homePageURL);
				waitForElementToBeClickable(driver, leftSearch);
			}
			checkForPageLoad(driver);
			waitForElementToBeClickable(driver, leftSearch);
			leftSearch.sendKeys("My Approvals");
			System.out.println("Searching My Approvals.");
			checkForPageLoad(driver);
			waitForElementToBeClickable(driver, xpMyApprovals);
			js.executeScript("arguments[0].click();", xpMyApprovals);
			checkForPageLoad(driver);

			waitForFrameToBeAvailable(driver, "gsft_main");
			waitForElementToBeClickable(driver, searchApprovalFor);
			Select select2 = new Select(searchApprovalFor);
			select2.selectByVisibleText("Approval for");
			waitForElementToBeClickable(driver, searchTextBox);
			searchTextBox.sendKeys(caseID.trim());
			waitForAction(driver);
			searchTextBox.sendKeys(Keys.ENTER);
			waitForAction(driver);

			waitForElementToBeClickable(driver, xpEnterState);
			xpEnterState.sendKeys("Request");
			waitForElementToBeClickable(driver, approvalForTextBox);
			approvalForTextBox.clear();
			waitForAction(driver);
			approvalForTextBox.sendKeys(caseID.trim());
			waitForElementToBeClickable(driver, xpEnterState);
			xpEnterState.sendKeys(Keys.ENTER);
			waitForAction(driver);

			waitForFrameToBeAvailable(driver, "gsft_main");
			int k = 0;
			while (k == 0) {
				k = 0;
				// waitForElementToBeClickable(driver, xpImpState);
				checkForPageLoad(driver);
				System.out.println("Selecting Record with state as Requested.");
				if (isElementPresent(xpImpState)) {
					if (xpImpState.getText().equals("Requested")) {
						waitForElementToBeClickable(driver, xpImpState);
						xpImpState.click();
						System.out.println("Clicking the Case ID based on State.");
						waitForFrameToBeAvailable(driver, "gsft_main");
						waitForElementToBeClickable(driver, xpApprove);
						xpApprove.click();
						System.out.println("Case ID Approved");
						waitForFrameToBeAvailable(driver, "gsft_main");
						logSuccess("successfully approve the request and approver name=" + approver);
						System.out.println("successfully approve the request and approver name=" + approver);

						if (isElementPresent(xpNoRecords)) {
							k++;
							System.out.println("No records to display as Case is Approved.");
						}
					} else {
						k++;
					}
				} else {
					k++;
				}
			}

			waitForFrameToBeAvailable(driver, "gsft_main");
			waitForAction(driver);
			driver.switchTo().defaultContent();
			waitForElementToBeClickable(driver, userMenu);
			userMenu.click();
			waitForElementToBeClickable(driver, impUser);
			js.executeScript("arguments[0].click();", impUser);
			waitForElementToBeClickable(driver, impUserDropDwn);
			impUserDropDwn.click();
			waitForElementToBeClickable(driver, impUserSendkys);
			impUserSendkys.sendKeys(user);
			checkForPageLoad(driver);
			impUserSendkys.sendKeys(Keys.ENTER);
			checkForPageLoad(driver);

			logInfo("Switch to user and username = " + user);
			System.out.println("Switch to user and username = " + user);
			waitForElementToBeClickable(driver, leftSearch);
			
			while (!(isElementPresent(leftSearch) || isElementEnabled(leftSearch))) {
				driver.get(homePageURL);
				System.out.println("Home Page");
				waitForElementToBeClickable(driver, leftSearch);
			}
			
			checkForPageLoad(driver);
			waitForElementToBeClickable(driver, leftSearch);
			leftSearch.sendKeys("CASE");
			System.out.println("Filtering with Value - CASE");

			checkForPageLoad(driver);
			waitForElementToBeClickable(driver, xpOpen);
			js.executeScript("arguments[0].click();", xpOpen);
			checkForPageLoad(driver);

			waitForFrameToBeAvailable(driver, "gsft_main");
			checkForPageLoad(driver);
			waitForElementToBeClickable(driver, searchNumberDropDown);
			select.selectByVisibleText("Number");
			waitForElementToBeClickable(driver, searchTextBox);
			searchTextBox.sendKeys(caseID.trim());
			waitForAction(driver);
			searchTextBox.sendKeys(Keys.ENTER);
			waitForAction(driver);
			/*
			 * waitForElementToBeClickable(driver, xpNumberSearch); xpNumberSearch.clear();
			 * xpNumberSearch.sendKeys(caseID.trim()); waitForAction(driver);
			 * xpNumberSearch.sendKeys(Keys.ENTER);
			 */
			System.out.println("Selecting required Case ID - " + caseID);
			waitForElementToBeClickable(driver, xpUniqueCaseId);
			xpUniqueCaseId.click();

			waitForFrameToBeAvailable(driver, "gsft_main");
			System.out.println("Selected required Case ID - " + caseID);
			waitForElement(driver, xpApproverTab);
			scrollToElement(driver, xpApproverTab);
			waitForElementToBeClickable(driver, xpApproverTab);
			waitForAction(driver);
			js.executeScript("arguments[0].click();", xpApproverTab);
		}
	}

	public void navigateToCaseUrlForCourseRefund(String caseUrl) {
		checkForPageLoad(driver);
		driver.get(caseUrl);
		waitForElement(driver, xpTicketID);
		logInfo("navigating to the Ticket created page - " + caseUrl);
		System.out.println("navigating to the Ticket created page - " + caseUrl);
		logInfoScreenshot(driver);
		waitForAction(driver);
	}

	// validating the reject supervisor request
	public void rejectCase(String supervisor, String caseID, String caseUrl) throws Exception {
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.sendKeys("CASE");
		checkForPageLoad(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		waitForElementToBeClickable(driver, xpOpen);
		js.executeScript("arguments[0].click();", xpOpen);
		checkForPageLoad(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForAction(driver);
		waitForElement(driver, xpCasesPage);
		if (xpCasesPage.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Successfully Navigate to HR Cases Page", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Navigation Failed to reach the HR Cases Page", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		waitForElementToBeClickable(driver, searchNumberDropDown);
		Select select = new Select(searchNumberDropDown);
		select.selectByVisibleText("Number");
		waitForElementToBeClickable(driver, searchTextBox);
		searchTextBox.sendKeys(caseID.trim());
		waitForAction(driver);
		searchTextBox.sendKeys(Keys.ENTER);
		waitForAction(driver);

		logInfo("Search for the case id == " + caseID);
		waitForElementToBeClickable(driver, xpUniqueCaseId);
		xpUniqueCaseId.click();
		waitForAction(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, xpApproverTab);
		js.executeScript("arguments[0].scrollIntoView();", xpApproverTab);
		waitForAction(driver);
		waitForElementToBeClickable(driver, xpApproverTab);
		xpApproverTab.click();

		waitForFrameToBeAvailable(driver, "gsft_main");
		logInfo("Clicking the approvers tab");
		String approver = null;
		for (int i = 0; i < xpState.size(); i++) {
			int count = 0;
			// for loop
			for (int j = 0; j < xpState.size(); j++) {
				if (xpState.get(j).getText().equals("Requested")) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel("Searching for the Requested Approver", ExtentColor.GREEN));
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					approver = driver.findElement(By.xpath(
							"(//tr[contains(@id,'row_sn_hr_core_case_total_rewards.sysapproval_approver')]/td[4]//a)["
									+ (j + 1) + "]"))
							.getText();
					count++;
				}
			}

			if (count == 0) {
				break;
			}

			driver.switchTo().defaultContent();
			waitForElementToBeClickable(driver, userMenu);
			userMenu.click();
			waitForElementToBeClickable(driver, impUser);
			js.executeScript("arguments[0].click();", impUser);
			waitForElementToBeClickable(driver, impUserDropDwn);
			impUserDropDwn.click();
			waitForElementToBeClickable(driver, impUserSendkys);
			impUserSendkys.sendKeys(approver);
			waitForAction(driver);
			impUserSendkys.sendKeys(Keys.ENTER);
			checkForPageLoad(driver);

			logInfo("Impersonate the User and username=" + approver);
			waitForElementToBeClickable(driver, leftSearch);
			leftSearch.sendKeys("My Approvals");
			waitForAction(driver);
			waitForElementToBeClickable(driver, xpMyApprovals);
			// xpMyApprovals.click();
			js.executeScript("arguments[0].click();", xpMyApprovals);
			checkForPageLoad(driver);

			waitForFrameToBeAvailable(driver, "gsft_main");
			checkForPageLoad(driver);

			if (!isElementPresent(xpApprovalFor)) {
				System.out.println("Cliking on My Approvals again");
				driver.switchTo().defaultContent();
				waitForElementToBeClickable(driver, xpMyApprovals);
				xpMyApprovals.click();
				checkForPageLoad(driver);
				waitForFrameToBeAvailable(driver, "gsft_main");
				checkForPageLoad(driver);
			}

			try {
				waitForElementToBeClickable(driver, xpApprovalFor);
				xpApprovalFor.sendKeys(caseID);
				waitForElementToBeClickable(driver, xpEnterState);
				xpEnterState.sendKeys("Requested");
				waitForElementToBeClickable(driver, xpApprovalFor);
				xpApprovalFor.sendKeys(Keys.ENTER);
				waitForAction(driver);
				waitForFrameToBeAvailable(driver, "gsft_main");
			} catch (Exception e) {
				checkForPageLoad(driver);
				waitForElementToBeClickable(driver, xpApprovalSearchIcon);
				xpApprovalSearchIcon.click();
				waitForFrameToBeAvailable(driver, "gsft_main");
				waitForElementToBeClickable(driver, xpApprovalFor);
				xpApprovalFor.sendKeys(caseID);
				waitForElementToBeClickable(driver, xpEnterState);
				xpEnterState.sendKeys("Requested");
				waitForElementToBeClickable(driver, xpApprovalFor);
				xpApprovalFor.sendKeys(Keys.ENTER);
				waitForAction(driver);
				waitForFrameToBeAvailable(driver, "gsft_main");
			}
			waitForElementToBeClickable(driver, xpImpState);
			xpImpState.click();
			waitForFrameToBeAvailable(driver, "gsft_main");
			if (isElementPresent(xpRejectComment2)) {
				waitForElementToBeClickable(driver, xpRejectComment2);
				xpRejectComment2.sendKeys("Automation Rejection");
			} else if (isElementPresent(xpRejectComment2)) {
				waitForElementToBeClickable(driver, xpRejectComment2);
				xpRejectComment2.sendKeys("Automation Rejection");
			} else {
				logFailure("Comment Box to enter Rejection Comment is not displayed or check for approval state.");
				logFailureScreenshot(driver);
			}
			logInfo("clicking the reject button");
			waitForElementToBeClickable(driver, rejectbutton);
			rejectbutton.click();
			waitForFrameToBeAvailable(driver, "gsft_main");
			// xpUpdatebtn.click();
			// waitForElementToBeClickable(driver, element);

			/*
			 * if (isElementPresent(rejectCommentError)) {
			 * logInfo("Error Message is displayed to enter Reject Comment - " +
			 * rejectCommentError.getText()); logInfoScreenshot(driver); } else {
			 * logFailure("Error Message is not displayed to enter Reject Comment");
			 * logFailureScreenshot(driver); } waitForElementToBeClickable(driver, element);
			 */

			// waitForElementToBeClickable(driver, xpRejectbtn);
			// xpRejectbtn.click();
			// xpUpdatebtn.click();

			// waitForElementToBeClickable(driver, element);
			waitForElement(driver, xpConfirmReject);
			if (isElementPresent(xpConfirmReject) && xpConfirmReject.getText().contains(caseID)) {
				logSuccess("Successfully Reject the case number:" + caseID + " and reject approver name= " + approver);
				logSuccessScreenshot(driver);

			} else {
				logFailure("Failed to Reject the case number:" + caseID);
				logSuccessScreenshot(driver);
			}

			if (approver.contains(supervisor)) {
				break;
			}

		}
		driver.switchTo().defaultContent();
		driver.get(caseUrl);
		waitForElement(driver, xpTicketID);
		logInfo("navigating to the Ticket created page - " + caseUrl);
		logInfoScreenshot(driver);

	}

	// validating the Course refund page
	public void courseRefund(String actualTitle, String actualTuitionFee, String actualTitleCrs2,
			String actualTuitionFeeCrs2) throws Exception {
		driver.get(driver.getCurrentUrl());
		waitForElement(driver, xpCourseRefund);
		if (!isElementPresent(xpCourseRefund)) {
			driver.navigate().refresh();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", xpCourseRefund);
		waitForAction(driver);
		// scrollToElement(driver, xpCourseRefund);
		if (isElementPresent(xpCourseRefund)) {
			logSuccess("Successfully approving the all approvals requests");
			logSuccess("Successfully navigating to Course Refund Submission page");
			logSuccessScreenshot(driver);
		} else {
			logFailure("Navigation Failed to Course Refund Submission page");
			logFailureScreenshot(driver);
		}
		waitForElementToBeClickable(driver, xpCourseRefund);
		Actions actions = new Actions(driver);
		actions.click(xpCourseRefund).build().perform();
		// xpCourseRefund.click();
		System.out.println("Clicked on Refund");
		waitForAction(driver);
		waitForElement(driver, xpCrsTitle);
		scrollToElement(driver, xpCrsTitle);
		waitForAction(driver);
		if (isElementPresent(xpCrsTitle) && xpCrsTitle.getAttribute("readonly").equals("true")) {
			logSuccess("Course1 title field is Displayed and Not Editable");
			logSuccess("Expected Value - " + "true");
			logSuccess("Actual Value - " + xpCrsTitle.getAttribute("readonly"));
			logSuccessScreenshot(driver);
			if (xpCrsTitle.getAttribute("value").trim().contains(actualTitle.trim())) {
				logSuccess(
						"Course1 title field is populated with expected value == " + xpCrsTitle.getAttribute("value"));
				logSuccess("Expected Value - " + actualTitle);
				logSuccess("Actual Value - " + xpCrsTitle.getAttribute("value"));
			} else {
				logFailure("Course1 title field is Not populated with Expected value");
				logFailure("Expected Value - " + actualTitle);
				logFailure("Actual Value - " + xpCrsTitle.getAttribute("value"));
			}
		} else {
			logFailure("Course1 title field is not displayed or editable");
			logFailure("Expected Value - " + "true");
			logFailure("Actual Value - " + xpCrsTitle.getAttribute("readonly"));
			logFailureScreenshot(driver);
		}

		scrollToElement(driver, xpCrsTuitionfee);
		waitForAction(driver);
		if (isElementPresent(xpCrsTuitionfee) && xpCrsTuitionfee.getAttribute("readonly").equals("true")) {
			logSuccess("Course 1 Tuition fee field is Displayed and Not Editable");
			logSuccess("Expected Value - " + "true");
			logSuccess("Actual Value - " + xpCrsTuitionfee.getAttribute("readonly"));
			logSuccessScreenshot(driver);
			if (xpCrsTuitionfee.getAttribute("value").trim().contains(actualTuitionFee)) {
				logSuccess("Course 1 Tuition fee field is populated with expected value == "
						+ xpCrsTuitionfee.getAttribute("value"));
				logSuccess("Expected Value - " + actualTuitionFee);
				logSuccess("Actual Value - " + xpCrsTuitionfee.getAttribute("value").trim());
			} else {
				logFailure("Course 1 Tuition fee field is Not populated with Expected value");
				logFailure("Expected Value - " + actualTuitionFee);
				logFailure("Actual Value - " + xpCrsTuitionfee.getAttribute("value").trim());
			}
		} else {
			logFailure("Course 1 Tuition fee field is not displayed or editable");
			logFailure("Expected Value - " + "true");
			logFailure("Actual Value - " + xpCrsTuitionfee.getAttribute("readonly"));
			logFailureScreenshot(driver);
		}
		waitForElementToBeClickable(driver, xpRbsRequired);
		xpRbsRequired.click();
		waitForElementToBeClickable(driver, xpRbsRequiredOptions);
		xpRbsRequiredOptions.sendKeys("Yes", Keys.TAB);
		waitForAction(driver);
		logInfo("Course 1 Total Cost per Category field are displayed below");
		waitForAction(driver);
		if (isElementPresent(xpTuitionCost)) {
			logSuccess("Tuition Cost field is displayed");
		} else {
			logFailure("Tuition Cost field is Not Displayed");
		}
		if (isElementPresent(xpBooks)) {
			logSuccess("Books field is displayed");
		} else {
			logFailure("Books field is Not Displayed");
		}
		if (isElementPresent(xpLabFees)) {
			logSuccess("Lab Fees field is displayed");
		} else {
			logFailure("Lab Fees field is Not Displayed");
		}
		if (isElementPresent(xpTechFees)) {
			logSuccess("Technology fees field is displayed");
		} else {
			logFailure("Technology fees field is Not Displayed");
		}
		if (isElementPresent(xpCourse1TotalCost)) {
			logSuccess("course 1 total cost field is displayed");
		} else {
			logFailure("course 1 total cost field is Not Displayed");
		}
		waitForElementToBeClickable(driver, xpCourseGrade);
		xpCourseGrade.sendKeys("Pass");
		waitForElementToBeClickable(driver, xpComments);
		xpComments.sendKeys("Certification Received");
		waitForElementToBeClickable(driver, xpTuitionCost);
		xpTuitionCost.sendKeys("500");
		waitForElementToBeClickable(driver, xpBooks);
		xpBooks.sendKeys("100");
		waitForElementToBeClickable(driver, xpLabFees);
		xpLabFees.sendKeys("100");
		waitForElementToBeClickable(driver, xpTechFees);
		xpTechFees.sendKeys("100");
		scrollToElement(driver, xpCourse1TotalCost);
		waitForAction(driver);
		waitForElementToBeClickable(driver, xpCourse1TotalCost);
		xpCourse1TotalCost.click();
		waitForAction(driver);
		if (!xpCourse1TotalCost.getAttribute("value").isEmpty()) {
			logSuccess("Course 1 total cost field is populated with cost=" + xpCourse1TotalCost.getAttribute("value"));
			logSuccessScreenshot(driver);
		} else {
			logFailure("Course 1 total cost field is Not populated");
			logFailureScreenshot(driver);
		}

		System.out.println("course 1 total cost = " + xpCourse1TotalCost.getAttribute("value"));
		int course1cost = Integer.parseInt(StringUtils.remove(xpCourse1TotalCost.getAttribute("value"), ".00"));
		System.out.println("Total Cost for Course 1 in int - " + course1cost);
		if (xpCrs2Title.getAttribute("value").trim().contains(actualTitleCrs2.trim())) {
			logSuccess("Course 2 Title is matched with expected value" + xpCrs2Title.getAttribute("value"));
			logSuccess("Expected Value - " + actualTitleCrs2);
			logSuccess("Actual Value - " + xpCrs2Title.getAttribute("value").trim());
			logSuccessScreenshot(driver);
		} else {
			logFailure("Course 2 Title is not matched with expected value");
			logFailure("Expected Value - " + actualTitleCrs2);
			logFailure("Actual Value - " + xpCrs2Title.getAttribute("value").trim());
			logFailureScreenshot(driver);
		}

		if (xpCrs2Tuitionfee.getAttribute("value").trim().contains(actualTuitionFeeCrs2)) {
			logSuccess("Course 2 Estimated Tuition fee is matched with expected value"
					+ xpCrsTuitionfee.getAttribute("value"));
			logSuccess("Expected Value - " + actualTuitionFeeCrs2);
			logSuccess("Actual Value - " + xpCrs2Tuitionfee.getAttribute("value").trim());
			logSuccessScreenshot(driver);
		} else {
			logFailure("Course 2 Estimated Tuition fee is not matched with expected value");
			logFailure("Expected Value - " + actualTuitionFeeCrs2);
			logFailure("Actual Value - " + xpCrs2Tuitionfee.getAttribute("value").trim());
			logFailureScreenshot(driver);
		}
		scrollToElement(driver, xpRbsRequired2);
		waitForAction(driver);
		waitForElementToBeClickable(driver, xpRbsRequired2);
		xpRbsRequired2.click();
		waitForElementToBeClickable(driver, xpSendRbsRequired2);
		xpSendRbsRequired2.sendKeys("Yes", Keys.TAB);
		waitForAction(driver);
		if (isElementPresent(xpCourse2TuitionCost)) {
			logSuccess("Course 2 Tuition Cost field is displayed");
		} else {
			logFailure("Course 2 Tuition Cost field is Not Displayed");
		}
		if (isElementPresent(xpCourse2Books)) {
			logSuccess("Course 2 Books field is displayed");
		} else {
			logFailure("Course 2 Books field is Not Displayed");
		}
		if (isElementPresent(xpCourse2LabFees)) {
			logSuccess("Course 2 Lab Fees field is displayed");
		} else {
			logFailure("Course 2 Lab Fees field is Not Displayed");
		}
		if (isElementPresent(xpCourse2TechFees)) {
			logSuccess("Course 2 Technology fees field is displayed");
		} else {
			logFailure("Course 2 Technology fees field is Not Displayed");
		}
		if (isElementPresent(xpCourse2TotalCost)) {
			logSuccess("Course 2 total cost field is displayed");
		} else {
			logFailure("course 2 total cost field is Not Displayed");
		}
		waitForElementToBeClickable(driver, xpCourse2Grade);
		xpCourse2Grade.sendKeys("Pass");
		waitForElementToBeClickable(driver, xpCourse2Comments);
		xpCourse2Comments.sendKeys("Certification Received");
		waitForElementToBeClickable(driver, xpCourse2TuitionCost);
		xpCourse2TuitionCost.sendKeys("300");
		waitForElementToBeClickable(driver, xpCourse2Books);
		xpCourse2Books.sendKeys("100");
		waitForElementToBeClickable(driver, xpCourse2LabFees);
		xpCourse2LabFees.sendKeys("100");
		waitForElementToBeClickable(driver, xpCourse2TechFees);
		xpCourse2TechFees.sendKeys("100");
		scrollPageToElement(driver, label_total_reimbursement_requested);
		waitForElementToBeClickable(driver, xpCourse2TotalCost);
		xpCourse2TotalCost.click();
		waitForAction(driver);
		if (!xpCourse2TotalCost.getAttribute("value").isEmpty()) {
			logSuccess(
					"Course 2 total cost field is populated with cost = " + xpCourse2TotalCost.getAttribute("value"));
			logSuccessScreenshot(driver);
		} else {
			logFailure("Course 2 total cost field is Not populated");
			logFailureScreenshot(driver);
		}
		System.out.println("Course 2 total cost populated == " + xpCourse2TotalCost.getAttribute("value"));
		int course2cost = Integer.parseInt(StringUtils.remove(xpCourse2TotalCost.getAttribute("value"), ".00"));
		System.out.println("Total Cost for Course 1 in int - " + course2cost);
		int expectedcost = course1cost + course2cost;
		System.out.println("course1cost = " + course1cost + "course2cost = " + course2cost);
		String actualcostStr = StringUtils.remove(xpCourseTotal.getAttribute("value"), ".00");
		int actualcost = Integer.parseInt(StringUtils.remove(actualcostStr, ","));
		System.out.println("actualcost = " + actualcost + "expectedcost = " + expectedcost);
		if (actualcost == expectedcost) {
			logSuccess("actual total cost is matched with expected course1 + course 2 cost == " + actualcost);
			logSuccess("Expected Value - " + expectedcost);
			logSuccess("Actual Value - " + actualcost);
			logSuccessScreenshot(driver);
		} else {
			logFailure("actual total cost is not matched with expected cost");
			logFailure("Expected Value - " + expectedcost);
			logFailure("Actual Value - " + actualcost);
			logFailureScreenshot(driver);
		}
		if (xpPaymentDelivery.getText().equals("Direct Deposit")) {
			logSuccess("selecting the payment delivery method == " + xpPaymentDelivery.getText());
			logSuccess("Expected Value - " + "Direct Deposit");
			logSuccess("Actual Value - " + xpPaymentDelivery.getText());
			logSuccessScreenshot(driver);
		} else {
			logFailure("it selecting the different payment delivery method other than Direct deposit ");
			logFailure("Expected Value - " + "Direct Deposit");
			logFailure("Actual Value - " + xpPaymentDelivery.getText());
			logFailureScreenshot(driver);
		}
	}

	// validating the course refund four courses page
	public void courseRefundFourCourses(String actualTitleCrs3, String actualTuitionFeeCrs3, String actualTitleCrs4,
			String actualTuitionFeeCrs4) throws IOException, Exception {
		scrollToElement(driver, xpCrs3Title);
		waitForAction(driver);
		if (isElementPresent(xpCrs3Title) && xpCrs3Title.getAttribute("readonly").equals("true")) {
			logSuccess("Course3 title field is Displayed and Not Editable");

			logSuccess("Expected Value - " + "true");
			logSuccess("Actual Value - " + xpCrs3Title.getAttribute("readonly"));

			logSuccessScreenshot(driver);
			if (xpCrs3Title.getAttribute("value").trim().equals(actualTitleCrs3)) {
				logSuccess(
						"Course3 title field is populated with expected value == " + xpCrs3Title.getAttribute("value"));

				logSuccess("Expected Value - " + actualTitleCrs3);
				logSuccess("Actual Value - " + xpCrs3Title.getAttribute("value"));

			} else {
				logFailure("Course3 title field is Not populated with Expected value");

				logFailure("Expected Value - " + actualTitleCrs3);
				logFailure("Actual Value - " + xpCrs3Title.getAttribute("value"));

			}
		} else {
			logFailure("Course3 title field is not displayed or editable");

			logFailure("Expected Value - " + "true");
			logFailure("Actual Value - " + xpCrs3Title.getAttribute("readonly"));

			logFailureScreenshot(driver);
		}
		if (isElementPresent(xpCrs3Tuitionfee) && xpCrs3Tuitionfee.getAttribute("readonly").equals("true")) {
			logSuccess("Course 3 Tuition fee field is Displayed and Not Editable");

			logSuccess("Expected Value - " + "true");
			logSuccess("Actual Value - " + xpCrs3Tuitionfee.getAttribute("readonly"));

			logSuccessScreenshot(driver);
			if (xpCrs3Tuitionfee.getAttribute("value").trim().contains(actualTuitionFeeCrs3)) {
				logSuccess("Course 3 Tuition fee field is populated with expected value == "
						+ xpCrs3Tuitionfee.getAttribute("value"));

				logSuccess("Expected Value - " + actualTuitionFeeCrs3);
				logSuccess("Actual Value - " + xpCrs3Tuitionfee.getAttribute("value"));
			} else {
				logFailure("Course 3 Tuition fee field is Not populated with Expected value");

				logFailure("Expected Value - " + actualTuitionFeeCrs3);
				logFailure("Actual Value - " + xpCrs3Tuitionfee.getAttribute("value"));
			}
		} else {
			logFailure("Course 3 Tuition fee field is not displayed or editable");

			logFailure("Expected Value - " + "true");
			logFailure("Actual Value - " + xpCrs3Tuitionfee.getAttribute("readonly"));

			logFailureScreenshot(driver);
		}

		waitForElementToBeClickable(driver, xpRbsRequired3);
		xpRbsRequired3.click();
		waitForElementToBeClickable(driver, xpSendRbsRequired3);
		xpSendRbsRequired3.sendKeys("Yes", Keys.TAB);
		waitForAction(driver);

		logInfo("Course 3 Total Cost per Category fields are displayed below");
		if (isElementPresent(xpCourse3TuitionCost)) {
			logSuccess("Course 3 Tuition Cost field is displayed");
		} else {
			logFailure("Course 3 Tuition Cost field is Not Displayed");
		}
		if (isElementPresent(xpCourse3Books)) {
			logSuccess("Course 3 Books field is displayed");
		} else {
			logFailure("Course 3 Books field is Not Displayed");
		}
		if (isElementPresent(xpCourse3LabFees)) {
			logSuccess("Course 3 Lab Fees field is displayed");
		} else {
			logFailure("Course 3 Lab Fees field is Not Displayed");
		}
		if (isElementPresent(xpCourse3TechFees)) {
			logSuccess("Course 3 Technology fees field is displayed");
		} else {
			logFailure("Course 3 Technology fees field is Not Displayed");
		}
		if (isElementPresent(xpCourse3TotalCost)) {
			logSuccess("course 3 total cost field is displayed");
		} else {
			logFailure("course 3 total cost field is Not Displayed");
		}

		waitForElementToBeClickable(driver, xpCourse3Grade);
		xpCourse3Grade.sendKeys("Pass");
		waitForElementToBeClickable(driver, xpCourse3Comments);
		xpCourse3Comments.sendKeys("Certification Received");
		waitForElementToBeClickable(driver, xpCourse3TuitionCost);
		xpCourse3TuitionCost.sendKeys("400");
		waitForElementToBeClickable(driver, xpCourse3Books);
		xpCourse3Books.sendKeys("0");
		waitForElementToBeClickable(driver, xpCourse3LabFees);
		xpCourse3LabFees.sendKeys("0");
		waitForElementToBeClickable(driver, xpCourse3TechFees);
		xpCourse3TechFees.sendKeys("0", Keys.TAB);
		waitForAction(driver);
		if (!xpCourse3TotalCost.getAttribute("value").isEmpty()) {
			logSuccess("Course 3 total cost field is populated with cost=" + xpCourse3TotalCost.getAttribute("value"));
			logSuccessScreenshot(driver);
		} else {
			logFailure("Course 3 total cost field is Not populated");
			logFailureScreenshot(driver);
		}

		System.out.println("course 3 total cost=" + xpCourse3TotalCost.getAttribute("value"));
		// int course3cost =
		// Integer.parseInt(StringUtils.remove(xpCourse3TotalCost.getAttribute("value"),
		// ".00"));
		if (xpCrs4Title.getAttribute("value").trim().equals(actualTitleCrs4)) {
			logSuccess("Course 4 Title is matched with expected value" + xpCrs4Title.getAttribute("value"));

			logSuccess("Expected Value - " + actualTitleCrs4);
			logSuccess("Actual Value - " + xpCrs4Title.getAttribute("value").trim());

			logSuccessScreenshot(driver);
		} else {
			logFailure("Course 4 Title is not matched with expected value");

			logFailure("Expected Value - " + actualTitleCrs4);
			logFailure("Actual Value - " + xpCrs4Title.getAttribute("value").trim());

			logFailureScreenshot(driver);
		}

		if (xpCrs4Tuitionfee.getAttribute("value").trim().contains(actualTuitionFeeCrs4)) {
			logSuccess("Course 2 Estimated Tuition fee is matched with expected value"
					+ xpCrs4Tuitionfee.getAttribute("value"));

			logSuccess("Expected Value - " + actualTuitionFeeCrs4);
			logSuccess("Actual Value - " + xpCrs4Tuitionfee.getAttribute("value").trim());
			logSuccessScreenshot(driver);
		} else {
			logFailure("Course 2 Estimated Tuition fee is not matched with expected value");

			logFailure("Expected Value - " + actualTuitionFeeCrs4);
			logFailure("Actual Value - " + xpCrs4Tuitionfee.getAttribute("value").trim());

			logFailureScreenshot(driver);
		}

		scrollToElement(driver, xpRbsRequired4);
		waitForAction(driver);
		waitForElementToBeClickable(driver, xpRbsRequired4);
		xpRbsRequired4.click();
		waitForElementToBeClickable(driver, xpSendRbsRequired4);
		xpSendRbsRequired4.sendKeys("Yes", Keys.TAB);
		waitForAction(driver);

		if (isElementPresent(xpCourse4TuitionCost)) {
			logSuccess("Course 4 Tuition Cost field is displayed");
		} else {
			logFailure("Course 4 Tuition Cost field is Not Displayed");
		}
		if (isElementPresent(xpCourse4Books)) {
			logSuccess("Course 4 Books field is displayed");
		} else {
			logFailure("Course 4 Books field is Not Displayed");
		}
		if (isElementPresent(xpCourse4LabFees)) {
			logSuccess("Course 4 Lab Fees field is displayed");
		} else {
			logFailure("Course 4 Lab Fees field is Not Displayed");
		}
		if (isElementPresent(xpCourse4TechFees)) {
			logSuccess("Course 4 Technology fees field is displayed");
		} else {
			logFailure("Course 4 Technology fees field is Not Displayed");
		}
		if (isElementPresent(xpCourse4TotalCost)) {
			logSuccess("Course 4 total cost field is displayed");
		} else {
			logFailure("course 4 total cost field is Not Displayed");
		}

		waitForElementToBeClickable(driver, xpCourse4Grade);
		xpCourse4Grade.sendKeys("Pass");
		waitForElementToBeClickable(driver, xpCourse4Comments);
		xpCourse4Comments.sendKeys("Certification Received");
		waitForElementToBeClickable(driver, xpCourse4TuitionCost);
		xpCourse4TuitionCost.sendKeys("500");
		waitForElementToBeClickable(driver, xpCourse4Books);
		xpCourse4Books.sendKeys("0");
		waitForElementToBeClickable(driver, xpCourse4LabFees);
		xpCourse4LabFees.sendKeys("0");
		waitForElementToBeClickable(driver, xpCourse4TechFees);
		xpCourse4TechFees.sendKeys("0", Keys.TAB);
		waitForAction(driver);

		if (!xpCourse4TotalCost.getAttribute("value").isEmpty()) {
			logSuccess("Course 4 total cost field is populated with cost=" + xpCourse4TotalCost.getAttribute("value"));
			logSuccessScreenshot(driver);
		} else {
			logFailure("Course 4 total cost field is Not populated");
			logFailureScreenshot(driver);
		}
		System.out.println("Course 4 total cost populated == " + xpCourse4TotalCost.getAttribute("value"));
		// int course2cost =
		// Integer.parseInt(StringUtils.remove(xpCourse4TotalCost.getAttribute("value"),
		// ".00"));

		if (xpPaymentDelivery.getText().equals("Direct Deposit")) {
			logSuccess("selecting the payment delivery method == " + xpPaymentDelivery.getText());
			logSuccess("Expected Value - " + "Direct Deposit");
			logSuccess("Actual Value - " + xpPaymentDelivery.getText());
			logSuccessScreenshot(driver);
		} else {
			logFailure("it selecting the different payment delivery method other than Direct deposit ");
			logFailure("Expected Value - " + "Direct Deposit");
			logFailure("Actual Value - " + xpPaymentDelivery.getText());
			logFailureScreenshot(driver);
		}
	}

	/* This method is to Add Attachment. */
	int i = 0;

	public void addAttachment(WebElement scrollToAttachment, WebElement element) throws IOException, Exception {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		String fileName = System.getProperty("user.dir") + File.separatorChar + "AutomationTest.txt";
		System.out.println("File Path - " + fileName);
		System.out.println("Is Add Attachment Input enabled? - " + element.isEnabled());

		if (addedAttachmentsList.isEmpty()) {
			i = 0;
		}

		scrollToElement(driver, scrollToAttachment);
		checkForPageLoad(driver);
		try {
			waitForElementToBeClickable(driver, element);
			element.sendKeys(fileName);
			checkForPageLoad(driver);
			logInfoScreenshot(driver);
		} catch (Exception e) {
			logFailure("Failed to add attachment: " + e.getMessage());
			logFailureScreenshot(driver);
		}

		scrollPageDown(driver);
		waitForElement(driver, addedAttachmentsList.get(i));
		if (isElementPresent(addedAttachmentsList.get(i))) {
			scrollPageToElement(driver, addedAttachmentsList.get(i));
			waitForAction(driver);
		}

		if (isElementPresent(addedAttachmentsList.get(i))) {
			logSuccess("Attachment is added Successfully");
			logSuccessScreenshot(driver);
			System.out.println("Attachment is added Successfully");
		} else {
			logFailure("Attachment is not added");
			logFailureScreenshot(driver);
			System.out.println("Attachment is not added");
		}
		i++;
	}

	public void addAttachmentAutoIT(WebElement scrollToAttachment, WebElement element, String browser)
			throws IOException, Exception {
		// String fname = "AutomationTest.txt";
		/*
		 * String fileName = "\"" + System.getProperty("user.dir") + "\"" +
		 * File.separatorChar + "\"" + fname + "\"";
		 */
		String fileName = System.getProperty("user.dir") + File.separatorChar + "AutomationTest.txt";
		// String fileName = System.getProperty("user.dir") + File.separatorChar + //
		// "AutomationTest.txt";
		System.out.println("File Path - " + fileName);
		String autoITExecutable = null;

		System.out.println("Get Browser by normal - " + browser);
		if (browser.equalsIgnoreCase("chrome")) {
			autoITExecutable = System.getProperty("user.dir") + File.separatorChar + "FileUploadChromeEdge " + fileName;
		} else if (browser.equalsIgnoreCase("firefox")) {
			autoITExecutable = System.getProperty("user.dir") + File.separatorChar + "FileUploadFirefox " + fileName;
		} else if (browser.equalsIgnoreCase("IE")) {
			autoITExecutable = System.getProperty("user.dir") + File.separatorChar + "FileUploadIE " + fileName;
		}

		try {
			scrollToElement(driver, scrollToAttachment);
			waitForAction(driver);
			waitForElementToBeClickable(driver, element);
			element.click(); // element.sendKeys(fileName);
			Thread.sleep(2000);
			Runtime.getRuntime().exec(autoITExecutable);
			Thread.sleep(5000);
			logInfo("Uploading Attachment - " + fileName);
			logInfoScreenshot(driver);
		} catch (Exception e) {
			logFailure("Failed to add attachment: " + e.getMessage());
			System.out.println(e.getMessage());
			logFailureScreenshot(driver);
		}
	}

	public void deleteAttach() throws Exception {
		WebElement ele = driver.findElement(By.xpath("(//*[@title='Delete'])[1]"));
		waitForElementToBeClickable(driver, ele);
		ele.click();
		logInfoScreenshot(driver);
		waitForElementToBeClickable(driver, driver.findElement(By.xpath("//*[text()='OK']")));
		driver.findElement(By.xpath("//*[text()='OK']")).click();

	}

	// Submit the task
	public void submitTask() throws Exception {
		waitForElementToBeClickable(driver, xpSubmit);
		xpSubmit.click();
		if (isAlertPresent(driver)) {
			driver.switchTo().alert().accept();
		} else {
			System.out.println("Alert is not displayed");
		}

		checkForPageLoad(driver);
		waitForElement(driver, xpRequestTxt);
		try {
			if (isElementPresent(xpRequestTxt)) {
				logSuccess("Successfully submited the Course Refund form");
				logSuccessScreenshot(driver);
			}
		} catch (Exception e) {
			if (isElementPresent(xpConfirmRequest)) {
				logSuccess("Successfully submited the Course Refund form");
				logSuccessScreenshot(driver);
			} else {
				logFailure("Failed to submit the Course Refund form");
				logFailureScreenshot(driver);
			}
		}

		logInfo("Waiting for the Depart head ReApproval");

	}

	// navigating to thr hr case number
	public void navigateToCase(String caseNum) throws InterruptedException, Exception {
		driver.switchTo().defaultContent();
		waitForElementToBeClickable(driver, leftSearch);
		checkForPageLoad(driver);
		leftSearch.sendKeys("CASE");
		waitForAction(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		waitForElementToBeClickable(driver, xpOpen);
		js.executeScript("arguments[0].click();", xpOpen);
		checkForPageLoad(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		if (xpCasesPage.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Successfully Navigate to HR Cases Page", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Navigation Failed to reach the HR Cases Page", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		waitForElementToBeClickable(driver, searchNumberDropDown);
		Select select = new Select(searchNumberDropDown);
		select.selectByVisibleText("Number");
		waitForElementToBeClickable(driver, searchTextBox);
		searchTextBox.sendKeys(caseNum.trim());
		waitForAction(driver);
		searchTextBox.sendKeys(Keys.ENTER);
		waitForAction(driver);
		/*
		 * waitForElementToBeClickable(driver, xpNumberSearch); xpNumberSearch.clear();
		 * xpNumberSearch.sendKeys(caseNum.trim()); waitForAction(driver);
		 * xpNumberSearch.sendKeys(Keys.ENTER);
		 *//*
			 * try { xpNumberSearch.sendKeys(caseNum, Keys.ENTER); } catch (Exception e) {
			 * xpSearchIcon.click(); waitForElementToBeClickable(driver, xpNumberSearch);
			 * xpNumberSearch.sendKeys(caseNum, Keys.ENTER); }
			 */
		logInfo("Search for the case id == " + caseNum);

		waitForElementToBeClickable(driver, xpUniqueCaseId);
		xpUniqueCaseId.click();
		waitForAction(driver);

		if (xpAttachments.size() == 2) {
			logSuccess("The Attachments are visible and view");
			logSuccessScreenshot(driver);
		} else {
			logFailure("The attachments are not visible ");
			logFailureScreenshot(driver);
		}
		scrollToElement(driver, xpKnowledgeResults);
		waitForAction(driver);
		for (int i = 0; i < xpTaskLists.size(); i++) {
			if (xpTaskLists.get(i).getText().equals("Open")) {
				logInfo("Task got created for check request");
				waitForAction(driver);
				xpTaskLinkLists.get(i).click();
				logInfo("clicking the HR task number for open the Part2:Check Request details");
				break;
			}
		}
	}

	public void impersonateAs(String GrpMember) {
		waitForAction(driver);

		// switch to HR User Group Member
		driver.switchTo().defaultContent();
		waitForElementToBeClickable(driver, userMenu);
		userMenu.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		waitForElementToBeClickable(driver, impUser);
		executor.executeScript("arguments[0].click();", impUser);
		checkForPageLoad(driver);

		waitForElementToBeClickable(driver, impUserDropDwn);
		impUserDropDwn.click();
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, impUserSendkys);
		impUserSendkys.sendKeys(GrpMember);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, impUserSendkys);
		impUserSendkys.sendKeys(Keys.ENTER);
		waitForAction(driver);

		logInfo("Impersonate the User and username=" + GrpMember);
		waitForAction(driver);
		System.out.println("Impersonate the User and username=" + GrpMember);

		waitForElementToBeClickable(driver, leftSearch);
		checkForPageLoad(driver);
	}

	// impersonating to the HRSM learning group user
	public void changeToHRSMLearningGrpUser(String GrpMember, String caseNum) throws Exception {
		// switch to HR User Group Member
		driver.switchTo().defaultContent();
		waitForAction(driver);
		waitForElementToBeClickable(driver, userMenu);
		userMenu.click();
		waitForAction(driver);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		waitForElementToBeClickable(driver, impUser);
		executor.executeScript("arguments[0].click();", impUser);
		// impUser.click();
		checkForPageLoad(driver);

		waitForElementToBeClickable(driver, impUserDropDwn);
		impUserDropDwn.click();
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, impUserSendkys);
		impUserSendkys.sendKeys(GrpMember);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, impUserSendkys);
		impUserSendkys.sendKeys(Keys.ENTER);
		checkForPageLoad(driver);
		logInfo("Impersonate the User and username=" + GrpMember);
		System.out.println("Impersonate the User and username=" + GrpMember);

		driver.navigate().refresh();
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.sendKeys("CASE");
		checkForPageLoad(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		waitForElementToBeClickable(driver, xpCaseOpen);
		js.executeScript("arguments[0].click();", xpCaseOpen);
		checkForPageLoad(driver);

		driver.switchTo().frame("gsft_main");
		waitForElement(driver, xpCasesPage);
		if (xpCasesPage.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Successfully Navigate to HR Cases Page", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Navigation Failed to reach the HR Cases Page", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		waitForElementToBeClickable(driver, searchNumberDropDown);
		Select select = new Select(searchNumberDropDown);
		select.selectByVisibleText("Number");
		waitForElementToBeClickable(driver, searchTextBox);
		searchTextBox.sendKeys(caseNum.trim());
		waitForAction(driver);
		searchTextBox.sendKeys(Keys.ENTER);
		waitForAction(driver);
		logInfo("Search for the case id == " + caseNum);

		waitForElementToBeClickable(driver, xpUniqueCaseId);
		xpUniqueCaseId.click();
		waitForAction(driver);

		if (xpAttachments.size() == 2) {
			logSuccess("The Attachments are visible and view");
			logSuccessScreenshot(driver);
		} else {
			logFailure("The attachments are not visible ");
			logFailureScreenshot(driver);
		}

		scrollToElement(driver, xpKnowledgeResults);
		checkForPageLoad(driver);
		for (int i = 0; i < xpTaskLists.size(); i++) {
			if (xpTaskLists.get(i).getText().trim().equals("Open")) {
				logInfo("Task got created for check request");
				waitForAction(driver);
				// driver.findElement(By.xpath("//*[contains(@class,'list_row
				// list_')]/td[3]/a[contains(text(), 'HRT')]")).click();
				xpTaskLinkLists.get(i).click();
				logInfo("clicking the HR task number for open the Part2:Check Request details");
				break;
			}
		}
	}

	// entering the check request details and return the check request id
	public void enterCheckRequestDetails(String amount, String comments, String assignTo, String caseNum)
			throws Exception {
		waitForElement(driver, xpCheckRequestDetailsTxt);
		scrollToElement(driver, xpCheckRequestDetailsTxt);
		waitForAction(driver);
		waitForElementToBeClickable(driver, xpCheckAmount);
		xpCheckAmount.sendKeys(amount);
		logSuccess("Successfully enter the check amout == " + amount);

		waitForElementToBeClickable(driver, xpAdditionalComments);
		xpAdditionalComments.sendKeys(comments);
		logSuccess("Successfully passing the additional comments: " + comments);

		String hrPageWindowHandle = driver.getWindowHandle();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		// Perform the click operation that opens new window
		if (isElementPresent(driver, xpAssignToSearch)) {
			scrollToElement(driver, xpAssignToSearch);
			waitForElementToBeClickable(driver, xpAssignToSearch);
			executor.executeScript("arguments[0].click();", xpAssignToSearch);
			// xpAssignToSearch.click();
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
//				driver.switchTo().window(windowName);
				System.out.println(windowName);
				driver.switchTo().window(windowName);
				driver.manage().window().maximize();

				waitForElementToBeClickable(driver, searchCriteria);
				Select dropdown = new Select(searchCriteria);
				dropdown.selectByVisibleText("Name");
				waitForElementToBeClickable(driver, searchTextBox);
				searchTextBox.clear();
				waitForAction(driver);
				searchTextBox.sendKeys(assignTo);
				searchTextBox.sendKeys(Keys.ENTER);
				checkForPageLoad(driver);
				System.out.println("Entering user for Assign to");
				waitForElementToBeClickable(driver, nameSearchTextBox);
				if (nameSearchTextBox.isDisplayed()) {
					test.get().log(Status.INFO, MarkupHelper
							.createLabel("Entering the value for Assign to field - " + assignTo, ExtentColor.CYAN));
					waitForElementToBeClickable(driver, nameSearchTextBox);
					System.out.println("Assign To - " + assignTo);
					waitForElementToBeClickable(driver, nameSearchTextBox);
					nameSearchTextBox.clear();
					waitForAction(driver);
					nameSearchTextBox.sendKeys(assignTo);
					nameSearchTextBox.sendKeys(Keys.ENTER);
					checkForPageLoad(driver);
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
		driver.switchTo().defaultContent();
		waitForFrameToBeAvailable(driver, "gsft_main");

		waitForElementToBeClickable(driver, xpCaseState);
		Select selectstate = new Select(xpCaseState);
		selectstate.selectByVisibleText("Resolved");
		System.out.println("Selected State as Resolved.");
		waitForAction(driver);
		waitForElementToBeClickable(driver, assignToClick);
		assignToClick.click();
		// postBt.click();

		scrollPageDown(driver);
		waitForAction(driver);
		WebElement element = driver.findElement(By.xpath("//textarea[@id='activity-stream-work_notes-textarea']"));
		waitForElementToBeClickable(driver, element);
		System.out.println("Entering Work Notes.");
		element.sendKeys("Case resolved by sendKeys");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].textContent='" + "Case resolved by Javascript" + "';", element);

		test.get().log(Status.INFO, MarkupHelper.createLabel("Updating The HR Case", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		waitForElementToBeClickable(driver, element);
		assignToClick.click();
		waitForElementToBeClickable(driver, updateButton);
		updateButton.click();
		waitForAction(driver);
	}

	public String approveTuitionRequest(String caseNum) throws Exception {
		String checkRequestId = null;
		driver.switchTo().defaultContent();
		waitForElementToBeClickable(driver, leftSearch);
		checkForPageLoad(driver);

		if (!(isElementPresent(leftSearch) || leftSearch.isEnabled())) {
			driver.get(homePageURL);
			System.out.println("Getting Home Page URL as Search button is not Enabled.");
		}

		leftSearch.clear();
		waitForAction(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].textContent='" + "My Approvals" + "';", leftSearch);
		waitForElementToBeClickable(driver, xpMyApprovals);
		xpMyApprovals.click();
		checkForPageLoad(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		try {
			driver.navigate().refresh();
			waitForFrameToBeAvailable(driver, "gsft_main");
			System.out.println("Refreshing.");
			waitForElementToBeClickable(driver, xpApprovalFor);
			System.out.println("Entering Number try block - " + caseNum);
			xpApprovalFor.sendKeys(caseNum);
			// action.sendKeys(xpApprovalFor, caseNum).build().perform();
			// js.executeScript("arguments[0].textContent='" + caseNum + "';",
			// xpApprovalFor);
			System.out.println("Entering State try block - Requested");
			waitForAction(driver);
			waitForElementToBeClickable(driver, xpEnterState);
			xpEnterState.sendKeys("Requested");
			xpEnterState.sendKeys(Keys.ENTER);
			waitForAction(driver);
			// js.executeScript("arguments[0].textContent='" + "Requested" + "';",
			// xpEnterState);
			// action.sendKeys(xpEnterState, "Requested").build().perform();
			// action.sendKeys(xpEnterState, Keys.ENTER).build().perform();
			waitForAction(driver);
		} catch (Exception e) {
			driver.navigate().refresh();
			waitForFrameToBeAvailable(driver, "gsft_main");
			waitForElementToBeClickable(driver, xpApprovalSearchIcon);
			xpApprovalSearchIcon.click();
			waitForElementToBeClickable(driver, xpApprovalFor);
			System.out.println("Entering Number - " + caseNum);
			xpApprovalFor.sendKeys(caseNum);
			waitForAction(driver);
			waitForElementToBeClickable(driver, xpEnterState);
			xpEnterState.sendKeys("Requested");
			xpEnterState.sendKeys(Keys.ENTER);
			waitForAction(driver);
		}

		// if Requested then Approve
		if (!(isElementPresent(xpImpState) || xpImpState.isEnabled())) {
			driver.navigate().refresh();
			waitForFrameToBeAvailable(driver, "gsft_main");
			System.out.println("Refreshing.");
		}

		while (true) {
			int k = 0;
			if (isElementPresent(xpImpState)) {
				if (xpImpState.getText().trim().equals("Requested")) {
					waitForElementToBeClickable(driver, xpImpState);
					xpImpState.click();
					waitForElementToBeClickable(driver, xpApprove);
					xpApprove.click();
					logSuccess("Successfully approve the request and approver name=");// + approver);
					logSuccessScreenshot(driver);
				} else {
					logFailure("Case ID is not available with required State - " + xpImpState.getText().trim());
					logFailureScreenshot(driver);
					break;
				}
			} else {
				k++;
			}
			if (k != 0) {
				break;
			}
		}

		waitForAction(driver);
		driver.switchTo().defaultContent();
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.clear();
		waitForAction(driver);
		leftSearch.sendKeys("CASE");
		checkForPageLoad(driver);

		js = (JavascriptExecutor) driver;
		waitForElementToBeClickable(driver, xpCaseOpen);
		js.executeScript("arguments[0].click();", xpCaseOpen);
		checkForPageLoad(driver);

		driver.switchTo().frame("gsft_main");
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, searchCriteria);
		Select select = new Select(searchCriteria);
		select.selectByVisibleText("Number");
		waitForElementToBeClickable(driver, searchTextBox);
		searchTextBox.sendKeys(caseNum.trim());
		waitForAction(driver);
		searchTextBox.sendKeys(Keys.ENTER);
		checkForPageLoad(driver);

		logInfo("Search for the case id == " + caseNum);
		waitForElementToBeClickable(driver, xpUniqueCaseId);
		xpUniqueCaseId.click();
		checkForPageLoad(driver);

		waitForElementToBeClickable(driver, xpCheckRequestTxt);
		if (isElementPresent(xpCheckRequestTxt)) {
			scrollToElement(driver, xpCheckRequestTxt);
			waitForAction(driver);
			logSuccess("check request case id create successully. case id info == " + xpCheckRequestTxt.getText());
			logSuccessScreenshot(driver);
			checkRequestId = xpCheckRequestTxt.getText().substring(14, 25);

		} else {
			logFailure("creation of check request case is failed");
			logFailureScreenshot(driver);
		}
		return checkRequestId;
	}

	// Searching for the check request case
	public void ResolveCheckRequest(String caseNum) throws Exception {
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, totalOpenCasesMyGroups);
		totalOpenCasesMyGroups.click();
		logSuccess("successfully clicking the total open cases my groups");
		logSuccessScreenshot(driver);
		checkForPageLoad(driver);

		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForAction(driver);
		waitForElementToBeClickable(driver, searchNumberDropDown);
		Select select = new Select(searchNumberDropDown);
		select.selectByVisibleText("Number");
		waitForElementToBeClickable(driver, searchTextBox);
		searchTextBox.sendKeys(caseNum.trim());
		waitForAction(driver);
		searchTextBox.sendKeys(Keys.ENTER);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, xpCaseNum);

		logInfo("Click the HR Case Number " + xpCaseNum.getText() + " to open up the case & review the details");
		logInfoScreenshot(driver);
		waitForElementToBeClickable(driver, xpCaseNum);
		xpCaseNum.click();
		checkForPageLoad(driver);
	}

	// validating the check request details
	public void validateCheckRequestDetails(String requestername) throws Exception {
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, xpRequesterName);
		if (isElementPresent(xpRequesterName) && xpRequesterName.getAttribute("value").trim().equals(requestername)) {
			logSuccess("RequestedBy name is populated and Requested By == " + xpRequesterName.getAttribute("value"));
			logSuccess("Expected Value - " + requestername);
			logSuccess("Actual Value - " + xpRequesterName.getAttribute("value"));
			logSuccessScreenshot(driver);
		} else {
			logFailure("Requested by name is not populated with expected name");
			logFailure("Expected Value - " + requestername);
			logFailure("Actual Value - " + xpRequesterName.getAttribute("value"));
			logFailureScreenshot(driver);
		}

		waitForElementToBeClickable(driver, xpOpenedBy);
		if (isElementPresent(xpOpenedBy) && !xpOpenedBy.getAttribute("value").isEmpty()) {
			logSuccess("Opened by name is populated and the populated name == " + xpOpenedBy.getAttribute("value"));
		} else {
			logFailure("Opened by name is not populated");
		}

		String about = null;
		waitForElementToBeClickable(driver, xpabout);
		if (isElementPresent(xpabout) && xpabout.getAttribute("value").equals(requestername)) {
			about = xpabout.getAttribute("value");
			logSuccess("about field is populated and matching with expected value == " + xpabout.getAttribute("value"));
			logSuccess("Expected Value - " + requestername);
			logSuccess("Actual Value - " + xpabout.getAttribute("value"));
			logSuccessScreenshot(driver);
		} else {
			logFailure("about field is not populated with expected value");
			logFailure("Expected Value - " + requestername);
			logFailure("Actual Value - " + xpabout.getAttribute("value"));
		}

		waitForElementToBeClickable(driver, xpCheckRequestComment);
		if (isElementPresent(xpCheckRequestComment)) {
			scrollToElement(driver, xpCheckRequestComment);
			waitForAction(driver);
			logSuccess("Comments are visible and comments are::" + xpCheckRequestComment.getText());
			logSuccessScreenshot(driver);
		} else {
			logFailure("This Check Request was created from Tuition Reimbursement comment is not visible");
			logFailureScreenshot(driver);
		}

		waitForElementToBeClickable(driver, xpCheckRequestState);
		Select selectstate = new Select(xpCheckRequestState);
		String state = selectstate.getFirstSelectedOption().getText();
		if (state.equals("Open")) {
			logSuccess("CheckRequest case State is matched with expected state == " + state);
			logSuccess("Expected Value - " + "Open");
			logSuccess("Actual Value - " + state);
		} else {
			logFailure("CheckRequest case State is Not matched with expected state");
			logFailure("Expected Value - " + "Open");
			logFailure("Actual Value - " + state);
		}

		waitForElementToBeClickable(driver, xpPriority);
		Select selectprority = new Select(xpPriority);
		String priority = selectprority.getFirstSelectedOption().getText();

		if (priority.equals("1 - High")) {
			logSuccess("CheckRequest case priority is matched with expected priority=" + priority);
			logSuccess("Expected Value - " + "1 - High");
			logSuccess("Actual Value - " + priority);
		} else {
			logFailure("CheckRequest case priority is Not matched with expected priority");
			logFailure("Expected Value - " + "1 - High");
			logFailure("Actual VAlue - " + priority);
		}

		if (xpHRService.getAttribute("value").equals("Payment Request")) {
			logSuccess("HR Service is populated with expected values is == " + xpHRService.getAttribute("value"));
			logSuccess("Expected Value - " + "Payment Request");
			logSuccess("Actual Value - " + xpHRService.getAttribute("value"));
		} else {
			logFailure("HR Service is Not populated with expected value");
			logFailure("Expected Value - " + "Payment Request");
			logFailure("Actual Value - " + xpHRService.getAttribute("value"));
		}

		if (xpAssignmentGrp.getAttribute("value").equals("HRSM - Payroll")) {
			logSuccess(
					"Assignment group field is populated with expected vlaue=" + xpAssignmentGrp.getAttribute("value"));
			logSuccess("Expected Value - " + "HRSM - Payroll");
			logSuccess("Actual Value - " + xpAssignmentGrp.getAttribute("value"));
		} else {
			logFailure("Assignment group field is Not populated with expected vlaue");
			logFailure("Expected Value - " + "HRSM - Payroll");
			logFailure("Actual Value - " + xpAssignmentGrp.getAttribute("value"));
		}

		if (!xpDateAndTimeCheck.getAttribute("value").isEmpty()) {
			logSuccess("Date and Time check is needed is populated with date == "
					+ xpDateAndTimeCheck.getAttribute("value"));
			logSuccessScreenshot(driver);
		} else {
			logFailure("Date and Time check is needed field is Not populated with date");
			logFailureScreenshot(driver);
		}

		if (xpShortDescription.getAttribute("value").equals("Check Request case for " + about)) {
			logSuccess("Short description is matched with Expected Description == "
					+ xpShortDescription.getAttribute("value"));
			logSuccess("Expected Value - " + "Check Request case for " + about);
			logSuccess("Actual Value - " + xpShortDescription.getAttribute("value"));
		} else {
			logFailure("Short description is Not matched with Expected Description");
			logFailure("Expected Value - " + "Check Request case for " + about);
			logFailure("Actual Value - " + xpShortDescription.getAttribute("value"));
		}

		driver.switchTo().defaultContent();
		String usename = xpUser.getText();
		waitForFrameToBeAvailable(driver, "gsft_main");
		String hrPageWindowHandle = driver.getWindowHandle();

		// Perform the click operation that opens new window
		if (xpAssignTo.isDisplayed()) {
			waitForElementToBeClickable(driver, xpAssignTo);
			xpAssignTo.click();
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("AssignTo search field is not displayed", ExtentColor.RED));
		}

		// Switch to new window opened
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

				waitForElementToBeClickable(driver, searchCriteria);
				Select dropdown = new Select(searchCriteria);
				dropdown.selectByVisibleText("Name");
				waitForElementToBeClickable(driver, searchTextBox);
				searchTextBox.clear();
				waitForAction(driver);
				searchTextBox.sendKeys(usename);
				waitForAction(driver);
				searchTextBox.sendKeys(Keys.ENTER);
				checkForPageLoad(driver);
				waitForElementToBeClickable(driver, nameSearchTextBox);
				if (nameSearchTextBox.isDisplayed()) {
					test.get().log(Status.INFO, MarkupHelper
							.createLabel("Searching the Assign to value for - " + usename, ExtentColor.CYAN));
					waitForElementToBeClickable(driver, nameSearchTextBox);
					waitForElementToBeClickable(driver, nameSearchTextBox);
					nameSearchTextBox.clear();
					nameSearchTextBox.sendKeys(usename);
					waitForAction(driver);
					nameSearchTextBox.sendKeys(Keys.ENTER);
					checkForPageLoad(driver);
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					WebElement searchResult = driver.findElement(
							By.xpath("//*[contains(@class, 'glide_ref_item_link') and contains(@role, 'button')]"));
					searchResult.click();
					logSuccess("Successfully assign to == " + usename);
				}
			}
		}

		driver.switchTo().window(hrPageWindowHandle);
		driver.switchTo().defaultContent();
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, xpCheckRequestState);
		selectstate.selectByVisibleText("Resolved");
		test.get().log(Status.PASS,
				MarkupHelper.createLabel("Successfully selecting state dropdown == Resolved", ExtentColor.GREEN));

		waitForElementToBeClickable(driver, caseWorknotes);
		caseWorknotes.sendKeys("Case resolved by sendKeys");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].textContent='" + "Case resolved by javascript" + "';", caseWorknotes);
		// postBt.click();

		/*
		 * Actions action = new Actions(driver); action.contextClick(header).perform();
		 * screenshotPath = getScreenshot(driver, this.getClass().getName());
		 * test.get().info("Details",
		 * MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		 * saveOption.click();
		 */
		test.get().log(Status.PASS, MarkupHelper.createLabel("Updating The HR Case", ExtentColor.GREEN));
		logSuccessScreenshot(driver);
		waitForElementToBeClickable(driver, updateButton);
		updateButton.click();
		waitForAction(driver);
	}

	// cancel the case
	public void cancelCase() throws IOException, Exception {
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, xpCancelCase);
		xpCancelCase.click();
		logInfo("clicking the case cancel button");
		waitForElementToBeClickable(driver, xpCancelOKBtn);
		checkForPageLoad(driver);
		xpCancelOKBtn.click();
		logInfo("Are you sure you want to cancel this case? popup is displayed and clicking OK");
		waitForElement(driver, xpCancelled);
		if (isElementPresent(xpCancelled)) {
			logSuccess("Successfully Cancelled the Tuition Reimbursement case");
			logSuccessScreenshot(driver);
		} else {
			logFailure("Cancelation of Tuition Reimbursement case is failed");
			logFailureScreenshot(driver);
		}
	}
}