package com.snow.testscripts.TuitionReimbursement;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.snow.base.ReadData;
import com.snow.base.ReusableLibrary;
import com.snow.pageobjects.HRPortalPage;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;
import com.snow.pageobjects.SubmitTuitionReimbursementRequest;

public class CourseApprovalWithDeptPt1 extends ReusableLibrary {
	ReadData rd = new ReadData();
	public String user;
	public String caseID;
	public String caseUrl;

	public String getClassName() {
		return this.getClass().getSimpleName();
	}

	@Test(dataProvider = "data", priority = 3, groups = "TuitionReimbursement")
	public void tuitionReimbursmentForm(Map<Object, Object> data) throws Throwable, IOException {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		HRPortalPage hrPortalPage = new HRPortalPage(driver);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Test for Tuition Reimbursement Request**", ExtentColor.ORANGE));

		// Login to the application and validate the login
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		knowledgeCreation.loginValidate();

		// Navigation to HR Portal and Validation
		driver.get(hrPortalURL);
		hrPortalPage.hrPortalNavigateValidate();

		hrPortalPage.searchForForm("Tuition Reimbursement Request");
		SubmitTuitionReimbursementRequest strr = PageFactory.initElements(driver,
				SubmitTuitionReimbursementRequest.class);
		strr.confirmDescription();

		// verifying the links
		// strr.linkValidations();

		String firstname = (String) data.get("UserFirstname");
		String lastname = (String) data.get("UserLastname");
		String twidname = (String) data.get("UserTwid");
		String position = (String) data.get("UserPosition");
		String costcenter = (String) data.get("UserCostCenter");
		String businessunit = (String) data.get("UserBusinessUnit");
		// verifying the applicant info
		strr.verifyApplicantInformation(firstname, lastname, twidname, position, costcenter, businessunit);

		String supervisorname = (String) data.get("Supervisor");
		String hrrepresentative = (String) data.get("HR Representative");
		String departmenthelpText = (String) data.get("DepartmentInfo");
		// verifying the approver workflow
		strr.validateApproverWorkflow(supervisorname, hrrepresentative, departmenthelpText);

		String activeEmail = (String) data.get("ActiveUserEmail");
		String inValidEmail = (String) data.get("InvalidUserEmail");
		String activeNoHRProfile = (String) data.get("ActiveUserNoHRProfile");
		String departmentHeadEmail = (String) data.get("DepartmentHeadEmail");
		// validate the department head approval
		strr.validateDepartmentHeadApproval(activeEmail, activeNoHRProfile, inValidEmail, departmentHeadEmail);

		String eduInstitutionname = (String) data.get("EduInstName");
		String degreeName = (String) data.get("Degreename");
		String courseHelptxt = (String) data.get("CourseHelptxt");
		// validating the course information
		strr.validateCourseInfo(eduInstitutionname, degreeName, courseHelptxt);

		String title = (String) data.get("CourseTitle");
		String tuitionFee = (String) data.get("TuitionFee");
		String startdate = (String) data.get("StartDate");
		String enddate = (String) data.get("EndDate");
		String courserelevance = (String) data.get("CourseRelevance");
		String coursetopic = (String) data.get("CourseTopic");
		String description = (String) data.get("CourseDescription");
		// entering the course1 details
		user = strr.populateCourse1Details(title, tuitionFee, startdate, enddate, description, courserelevance,
				coursetopic);
		System.out.println("User is - " + user);

		String title2 = (String) data.get("Course2Title");
		String tuitionFee2 = (String) data.get("TuitionFee2");
		String startdate2 = (String) data.get("StartDate2");
		String enddate2 = (String) data.get("EndDate2");
		String description2 = (String) data.get("CourseDescription2");
		String courserelevance2 = (String) data.get("CourseRelevance2");
		String coursetopic2 = (String) data.get("CourseTopic");
		// entering the course 2 details
		strr.populateCourse2Details(title2, tuitionFee2, startdate2, enddate2, description2, courserelevance2,
				coursetopic2);

		// submit the tuition reimbursement form
		caseID = strr.submitCourse();

		String identifierVariable = this.getClass().getSimpleName() + "-" + getTemperoryExecuteOn() + "-"
				+ getTemperoryOS() + "-" + getTemperorybrowser();
		rd.updateDataLibrary(getSuiteName(), identifierVariable, caseID.trim());
		identifierVariable = this.getClass().getSimpleName() + "-" + getTemperoryExecuteOn() + "-" + getTemperoryOS()
				+ "-" + getTemperorybrowser() + "-" + "User";
		rd.updateDataLibrary(getSuiteName(), identifierVariable, user.trim());

		caseUrl = driver.getCurrentUrl();
		System.out.println("Case ID is - " + caseID);
		logSuccess("Case Id is - " + caseID);
		logSuccess("Case URL is - " + caseUrl);
		logSuccessScreenshot(driver);
	}

	@Test(dataProvider = "data", priority = 3, groups = "TuitionReimbursement", dependsOnMethods = "tuitionReimbursmentForm")
	public void tuitionReimbursmentValidateCase(Map<Object, Object> data) throws Throwable, IOException {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		SubmitTuitionReimbursementRequest strr = PageFactory.initElements(driver,
				SubmitTuitionReimbursementRequest.class);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Validate Tuition Reimbursement Request Case**", ExtentColor.ORANGE));

		// Login to the application and validate the login
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		knowledgeCreation.loginValidate();

		// validating the submitted case
		strr.validateCase(caseID, user);
	}

	@Test(dataProvider = "data", priority = 3, groups = "TuitionReimbursement", dependsOnMethods = "tuitionReimbursmentValidateCase")
	public void createTaskCourseRefund(Map<Object, Object> data) throws Throwable, IOException {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		SubmitTuitionReimbursementRequest strr = PageFactory.initElements(driver,
				SubmitTuitionReimbursementRequest.class);

		test.get().log(Status.INFO, MarkupHelper.createLabel("**Create Course Refund Task**", ExtentColor.ORANGE));

		// Login to the application and validate the login
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		knowledgeCreation.loginValidate();

		strr.navigateToCaseUrlForCourseRefund(caseUrl);

		// validating the course refund page
		String title = (String) data.get("CourseTitle");
		String tuitionFee = (String) data.get("TuitionFee");
		String title2 = (String) data.get("Course2Title");
		String tuitionFee2 = (String) data.get("TuitionFee2");
		strr.courseRefund(title, tuitionFee, title2, tuitionFee2);

		System.out.println("Browser is  - " + getTemperorybrowser());
		// adding the attachments via Auto IT
		if (getTemperoryExecuteOn().contains("System Browser")) {
			strr.addAttachmentAutoIT(strr.attachmentButton, strr.xpAttachReceiptAutoIT, getTemperorybrowser());
			strr.addAttachmentAutoIT(strr.attachmentButton2, strr.xpAttachCourseGradeAutoIT, getTemperorybrowser());
		} else if (getTemperoryExecuteOn().contains("Browserstack")) {
			strr.addAttachment(strr.attachmentButton, strr.xpAttachReceipt);
			strr.addAttachment(strr.attachmentButton2, strr.xpAttachCourseGrade);
		}

		// adding attachment via input tag with ID
		// strr.addAttachment(strr.attachmentButton, strr.xpAttachReceipt);
		// strr.addAttachment(strr.attachmentButton2, strr.xpAttachCourseGrade);

		// submit the hr task
		strr.submitTask();
	}

	@Test(dataProvider = "data", priority = 3, groups = "TuitionReimbursement", dependsOnMethods = "tuitionReimbursmentValidateCase")
	public void validateCaseAfterCourseRefund(Map<Object, Object> data) throws Throwable, IOException {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		SubmitTuitionReimbursementRequest strr = PageFactory.initElements(driver,
				SubmitTuitionReimbursementRequest.class);
		test.get().log(Status.INFO, MarkupHelper.createLabel(
				"**Validate Tuition Reimbursement Request Case after Course Refund**", ExtentColor.ORANGE));

		// Login to the application and validate the login
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		knowledgeCreation.loginValidate();

		strr.validateCase(caseID, user);
		strr.navigateToCaseUrlForCourseRefund(caseUrl);

		if (!isElementPresent(strr.xpOpenState)) {
			driver.navigate().to(driver.getCurrentUrl());
			waitForAction(driver);
			waitForElement(driver, strr.xpOpenState);
		}

		if (isElementPresent(strr.xpOpenState)) {
			logSuccess("Successfully done the Course Refund Process");
			logSuccessScreenshot(driver);
			System.out.println("Successfully done the Course Refund Process");
		} else {
			logFailure("Course Refund Process Failed");
			logFailureScreenshot(driver);
		}

		driver.get(homePageURL);
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("TuitionReimbursement");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("submitTuitionReimbursement")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}
}