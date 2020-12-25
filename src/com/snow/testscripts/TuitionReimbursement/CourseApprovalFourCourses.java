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

public class CourseApprovalFourCourses extends ReusableLibrary {
	ReadData rd = new ReadData();
	public String user;
	public String caseID;
	public String caseUrl;

	public String getClassName() {
		return this.getClass().getSimpleName();
	}

	@Test(dataProvider = "data", priority = 4, groups = "TuitionReimbursement4Courses")
	public void tuitionReimbursmentForm(Map<Object, Object> data) throws Throwable, IOException {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		HRPortalPage hrPortalPage = new HRPortalPage(driver);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Test for Tuition Reimbursement Request**", ExtentColor.ORANGE));

		// Login to the application and validate the login
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		checkForPageLoad(driver);
		knowledgeCreation.loginValidate();

		// Navigation to HR Portal and Validation
		driver.navigate().to(hrPortalURL);
		checkForPageLoad(driver);
		hrPortalPage.hrPortalNavigateValidate();
		hrPortalPage.searchForForm("Tuition Reimbursement Request");
		SubmitTuitionReimbursementRequest strr = PageFactory.initElements(driver,
				SubmitTuitionReimbursementRequest.class);

		// verifying the applicant info
		String firstname = (String) data.get("UserFirstname");
		String lastname = (String) data.get("UserLastname");
		String twidname = (String) data.get("UserTwid");
		String position = (String) data.get("UserPosition");
		String costcenter = (String) data.get("UserCostCenter");
		String businessunit = (String) data.get("UserBusinessUnit");
		strr.verifyApplicantInformation(firstname, lastname, twidname, position, costcenter, businessunit);

		// validating the approver workflow
		String supervisorname = (String) data.get("Supervisor");
		String hrrepresentative = (String) data.get("HR Representative");
		String departmenthelpText = (String) data.get("DepartmentInfo");
		strr.validateApproverWorkflow(supervisorname, hrrepresentative, departmenthelpText);

		// validating the department head approval
		String activeEmail = (String) data.get("ActiveUserEmail");
		String inValidEmail = (String) data.get("InvalidUserEmail");
		String activeNoHRProfile = (String) data.get("ActiveUserNoHRProfile");
		String departmentHeadEmail = (String) data.get("DepartmentHeadEmail");
		strr.validateDepartmentHeadApproval(activeEmail, activeNoHRProfile, inValidEmail, departmentHeadEmail);

		// validating the course information
		String eduInstitutionname = (String) data.get("EduInstName");
		String degreeName = (String) data.get("Degreename");
		String courseHelptxt = (String) data.get("CourseHelptxt");
		strr.validateCourseInfo(eduInstitutionname, degreeName, courseHelptxt);

		// entering the course 1 details
		String title = (String) data.get("CourseTitle");
		String tuitionFee = (String) data.get("TuitionFee");
		String startdate = (String) data.get("StartDate");
		String enddate = (String) data.get("EndDate");
		String courserelevance = (String) data.get("CourseRelevance");
		String coursetopic = (String) data.get("CourseTopic");
		String description = (String) data.get("CourseDescription");
		user = strr.populateCourse1Details(title, tuitionFee, startdate, enddate, description, courserelevance,
				coursetopic);
		System.out.println("User is - " + user);

		// entering the course 2 details
		String title2 = (String) data.get("Course2Title");
		String tuitionFee2 = (String) data.get("TuitionFee2");
		String startdate2 = (String) data.get("StartDate2");
		String enddate2 = (String) data.get("EndDate2");
		String description2 = (String) data.get("CourseDescription2");
		String courserelevance2 = (String) data.get("CourseRelevance2");
		String coursetopic2 = (String) data.get("CourseTopic2");
		strr.populateCourse2Details(title2, tuitionFee2, startdate2, enddate2, description2, courserelevance2,
				coursetopic2);

		// entering the course 3 details
		String title3 = (String) data.get("Course3Title");
		String tuitionFee3 = (String) data.get("TuitionFee3");
		String startdate3 = (String) data.get("StartDate3");
		String enddate3 = (String) data.get("EndDate3");
		String description3 = (String) data.get("CourseDescription3");
		String courserelevance3 = (String) data.get("CourseRelevance3");
		String coursetopic3 = (String) data.get("CourseTopic3");
		strr.populateCourse3Details(title3, tuitionFee3, startdate3, enddate3, description3, courserelevance3,
				coursetopic3);

		// entering the course 4 details
		String title4 = (String) data.get("Course4Title");
		String tuitionFee4 = (String) data.get("TuitionFee4");
		String startdate4 = (String) data.get("StartDate4");
		String enddate4 = (String) data.get("EndDate4");
		String description4 = (String) data.get("CourseDescription4");
		String courserelevance4 = (String) data.get("CourseRelevance4");
		String coursetopic4 = (String) data.get("CourseTopic4");
		strr.populateCourse4Details(title4, tuitionFee4, startdate4, enddate4, description4, courserelevance4,
				coursetopic4);

		// submit the Tuition reimbursement form
		caseID = strr.submitCourse();

		String identifierVariable = this.getClass().getSimpleName() + "-" + getTemperoryExecuteOn() + "-"
				+ getTemperoryOS() + "-" + getTemperorybrowser();
		rd.updateDataLibrary(getSuiteName(), identifierVariable, caseID.trim());
		identifierVariable = this.getClass().getSimpleName() + "-" + getTemperoryExecuteOn() + "-" + getTemperoryOS()
				+ "-" + getTemperorybrowser() + "-" + "User";
		rd.updateDataLibrary(getSuiteName(), identifierVariable, user.trim());

		System.out.println("Case ID is - " + caseID);
		caseUrl = driver.getCurrentUrl();
		System.out.println("Case ID is - " + caseID);
		strr.validateCase(caseID, user);

		strr.navigateToCaseUrlForCourseRefund(caseUrl);

		// validating the course refund page
		strr.courseRefund(title, tuitionFee, title2, tuitionFee2);
		strr.courseRefundFourCourses(title3, tuitionFee3, title4, tuitionFee4);

		// adding the attachments via Auto IT
		if (getTemperoryExecuteOn().contains("System Browsers")) {
			strr.addAttachmentAutoIT(strr.attachmentButton, strr.xpAttachReceiptAutoIT, getTemperorybrowser());
			strr.addAttachmentAutoIT(strr.attachmentButton, strr.xpAttachCourseGradeAutoIT, getTemperorybrowser());
		} else if (getTemperoryExecuteOn().contains("Browserstack")) {
			strr.addAttachment(strr.attachmentButton, strr.xpAttachReceipt);
			strr.addAttachment(strr.attachmentButton2, strr.xpAttachCourseGrade);
		}

		// adding attachment via input tag
		// strr.addAttachment(strr.attachmentButton, strr.xpAttachReceipt);
		// strr.addAttachment(strr.attachmentButton2, strr.xpAttachCourseGrade);

		// submit the hr task
		strr.submitTask();
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

		waitForPageLoad(driver);
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