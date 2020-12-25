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
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;
import com.snow.pageobjects.SubmitTuitionReimbursementRequest;

public class PartTwoCheckRequestDetailsFourCourses extends ReusableLibrary {
	ReadData rd = new ReadData();
	public String casenum;

	public String getClassName() {
		return this.getClass().getSimpleName();
	}

	@Test(dataProvider = "data", priority = 4, groups = "CheckRequestDetailsFourCourses", dependsOnGroups = "TuitionReimbursement4Courses")
	public void checkRequestDetailsFourCourses(Map<Object, Object> data) throws Throwable, IOException {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		SubmitTuitionReimbursementRequest strr = PageFactory.initElements(driver,
				SubmitTuitionReimbursementRequest.class);
		CourseApprovalFourCourses approvalFourCourses = new CourseApprovalFourCourses();

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Test for Tuition Reimbursement Request**", ExtentColor.ORANGE));

		// Login to the application and validate the login
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		knowledgeCreation.loginValidate();

		// Impersonate the HRSm learning group user
		String GrpMember = (String) data.get("HRSMGroupMember");
		String suite = getSuiteName();
		String identifierVariable = approvalFourCourses.getClassName().trim() + "-" + getTemperoryExecuteOn() + "-"
				+ getTemperoryOS() + "-" + getTemperorybrowser();
		String caseID = getFromDataLib(rd, suite, identifierVariable);
		strr.changeToHRSMLearningGrpUser(GrpMember, caseID);

		// Entering the check request details
		String amount = (String) data.get("CheckAmount");
		String comments = (String) data.get("Comments");
		strr.enterCheckRequestDetails(amount, comments, GrpMember, caseID);
	}

	@Test(dataProvider = "data", priority = 4, groups = "CheckRequestDetailsFourCourses", dependsOnMethods = "checkRequestDetailsFourCourses")
	public void approveRequestDetails(Map<Object, Object> data) throws Throwable, IOException {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		SubmitTuitionReimbursementRequest strr = PageFactory.initElements(driver,
				SubmitTuitionReimbursementRequest.class);
		CourseApprovalFourCourses approvalFourCourses = new CourseApprovalFourCourses();

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Approving Tuition Reimbursement Request**", ExtentColor.ORANGE));

		// Login to the application and validate the login
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		knowledgeCreation.loginValidate();

		String GrpMember = (String) data.get("HRSMGroupMember");
		strr.impersonateAs(GrpMember);

		String suite = getSuiteName();
		String identifierVariable = approvalFourCourses.getClassName().trim() + "-" + getTemperoryExecuteOn() + "-"
				+ getTemperoryOS() + "-" + getTemperorybrowser();
		String caseID = getFromDataLib(rd, suite, identifierVariable);
		casenum = strr.approveTuitionRequest(caseID);
		// casenum = strr.approveTuitionRequest("HRC0041684");

		identifierVariable = this.getClass().getSimpleName() + "-" + getTemperoryExecuteOn() + "-" + getTemperoryOS()
				+ "-" + getTemperorybrowser();
		rd.updateDataLibrary(getSuiteName(), identifierVariable, casenum.trim());
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