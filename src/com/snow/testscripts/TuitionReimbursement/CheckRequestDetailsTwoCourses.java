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
import com.snow.pageobjects.HRCaseDashboardListView;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;
import com.snow.pageobjects.SubmitTuitionReimbursementRequest;

public class CheckRequestDetailsTwoCourses extends ReusableLibrary {
	ReadData rd = new ReadData();

	@Test(dataProvider = "data", priority = 3, dependsOnGroups = "CheckRequestDetails")
	public void checkRequestDetails2Courses(Map<Object, Object> data) throws Throwable, IOException {
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Test for Tuition Reimbursement Check Request**", ExtentColor.ORANGE));
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		SubmitTuitionReimbursementRequest strr = PageFactory.initElements(driver,
				SubmitTuitionReimbursementRequest.class);
		HRCaseDashboardListView listview = PageFactory.initElements(driver, HRCaseDashboardListView.class);
		CourseApprovalWithDeptPt1 approvalWithDeptPt1 = new CourseApprovalWithDeptPt1();
		PartTwoCheckRequestDetails detailsTwoCourses = new PartTwoCheckRequestDetails();

		// Login to the application and validate the login
		loginPage.snowLogin(HrAnalystUser2, HrAnalystUser2Password);
		knowledgeCreation.loginValidate();

		// navigating to the HR Case dash board
		listview.navigateToHRDashboard();

		// resolving the check request details for two courses
		String suite = getSuiteName();
		String identifierVariable = detailsTwoCourses.getClassName().trim() + "-" + getTemperoryExecuteOn() + "-"
				+ getTemperoryOS() + "-" + getTemperorybrowser();
		String casenum = getFromDataLib(rd, suite, identifierVariable);
		strr.ResolveCheckRequest(casenum);
		// strr.ResolveCheckRequest("HRC0043647");

		// validating the check request details for four courses
		identifierVariable = approvalWithDeptPt1.getClassName().trim() + "-" + getTemperoryExecuteOn() + "-"
				+ getTemperoryOS() + "-" + getTemperorybrowser() + "-" + "User";
		String user = getFromDataLib(rd, suite, identifierVariable);
		strr.validateCheckRequestDetails(user);
		// strr.validateCheckRequestDetails("HR User QA");
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