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

public class RejectTuitionReimbursement extends ReusableLibrary {
	ReadData rd = new ReadData();
	public String user;
	public String caseID;
	public String caseUrl;

	@Test(dataProvider = "data", priority = 2)
	public void createTuitionReimbursmentFormToReject(Map<Object, Object> data) throws Throwable, IOException {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		HRPortalPage hrPortalPage = new HRPortalPage(driver);
		SubmitTuitionReimbursementRequest strr = PageFactory.initElements(driver,
				SubmitTuitionReimbursementRequest.class);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Test for Tuition Reimbursement Request**", ExtentColor.ORANGE));
		// Login to the application and validate the login
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		knowledgeCreation.loginValidate();

		// Navigation to HR Portal and Validation
		driver.navigate().to(hrPortalURL);
		checkForPageLoad(driver);
		hrPortalPage.hrPortalNavigateValidate();

		// searching for the tuition reimbursement form
		hrPortalPage.searchForForm("Tuition Reimbursement Request");

		// verifying the applicant info
		String firstname = (String) data.get("UserFirstname");
		String lastname = (String) data.get("UserLastname");
		String twidname = (String) data.get("UserTwid");
		String position = (String) data.get("UserPosition");
		String costcenter = (String) data.get("UserCostCenter");
		String businessunit = (String) data.get("UserBusinessUnit");
		strr.verifyApplicantInformation(firstname, lastname, twidname, position, costcenter, businessunit);

		// validating the approver work flow
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

		String eduInstitutionname = (String) data.get("EduInstName");
		strr.validateCourseInfo2(eduInstitutionname);

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

		// Submit the Course details
		caseID = strr.submitCourse();
		caseUrl = driver.getCurrentUrl();

		// strr.ValidateCase(caseID, user, caseUrl);
	}

	@Test(dataProvider = "data", priority = 2, dependsOnMethods = "createTuitionReimbursmentFormToReject")
	public void rejectTuitionRequest(Map<Object, Object> data) throws Throwable, IOException {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		SubmitTuitionReimbursementRequest strr = PageFactory.initElements(driver,
				SubmitTuitionReimbursementRequest.class);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Test for Rejecting Tuition Reimbursement Request**", ExtentColor.ORANGE));
		// Login to the application and validate the login
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		knowledgeCreation.loginValidate();

		// Reject the Supervisor request
		String supervisorname = (String) data.get("Supervisor");
		strr.rejectCase(supervisorname, caseID, caseUrl);
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("TuitionReimbursement");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("RejectTuitionReimbursement")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}
}
