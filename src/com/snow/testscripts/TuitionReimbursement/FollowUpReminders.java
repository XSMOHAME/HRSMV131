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

public class FollowUpReminders extends ReusableLibrary {
	ReadData rd = new ReadData();

	public String user;
	public String caseID;
	public String caseUrl;

	@Test(dataProvider = "data", priority = 1)
	public void tuitionReimbursmentReminders(Map<Object, Object> data) throws Throwable, IOException {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		HRPortalPage hrPortalPage = new HRPortalPage(driver);
		SubmitTuitionReimbursementRequest strr = PageFactory.initElements(driver,
				SubmitTuitionReimbursementRequest.class);

		test.get().log(Status.INFO, MarkupHelper
				.createLabel("**Test for Tuition Reimbursement Request follow up Reminders**", ExtentColor.ORANGE));

		// Login to the application and validate the login
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		checkForPageLoad(driver);
		knowledgeCreation.loginValidate();

		// Navigation to HR Portal and Validation
		driver.navigate().to(hrPortalURL);
		checkForPageLoad(driver);
		hrPortalPage.hrPortalNavigateValidate();
		hrPortalPage.searchForForm("Tuition Reimbursement Request");

		// verifying the applicant info
		String firstname = (String) data.get("UserFirstname");
		String lastname = (String) data.get("UserLastname");
		String twidname = (String) data.get("UserTwid");
		String position = (String) data.get("UserPosition");
		String costcenter = (String) data.get("UserCostCenter");
		String businessunit = (String) data.get("UserBusinessUnit");
		strr.verifyApplicantInformation(firstname, lastname, twidname, position, costcenter, businessunit);

		// verifying the approver workflow
		String supervisorname = (String) data.get("Supervisor");
		String hrrepresentative = (String) data.get("HR Representative");
		String departmenthelpText = (String) data.get("DepartmentInfo");
		strr.validateApproverWorkflow(supervisorname, hrrepresentative, departmenthelpText);

		// validate the department head approval
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

		// entering the course1 details
		String title = (String) data.get("CourseTitle");
		String tuitionFee = (String) data.get("TuitionFee");
		String startdate = (String) data.get("StartDate");
		String enddate = (String) data.get("EndDate");
		String courserelevance = (String) data.get("CourseRelevance");
		String coursetopic = (String) data.get("CourseTopic");
		String description = (String) data.get("CourseDescription");
		user = strr.populateCourse1Details(title, tuitionFee, startdate, enddate, description, courserelevance,
				coursetopic);

		// entering the course 2 details
		String title2 = (String) data.get("Course2Title");
		String tuitionFee2 = (String) data.get("TuitionFee2");
		String startdate2 = (String) data.get("StartDate2");
		String enddate2 = (String) data.get("EndDate2");
		String description2 = (String) data.get("CourseDescription2");
		String courserelevance2 = (String) data.get("CourseRelevance2");
		String coursetopic2 = (String) data.get("CourseTopic");
		strr.populateCourse2Details(title2, tuitionFee2, startdate2, enddate2, description2, courserelevance2,
				coursetopic2);

		// submit the tuition reimbursement form
		caseID = strr.submitCourse();
		caseUrl = driver.getCurrentUrl();
		System.out.println("Case ID is - " + caseID);

		// validating the submitted case
		strr.validateCase(caseID, user);
		strr.navigateToCaseUrlForCourseRefund(caseUrl);
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