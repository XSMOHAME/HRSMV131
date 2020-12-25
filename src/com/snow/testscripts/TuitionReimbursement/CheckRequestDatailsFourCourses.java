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

public class CheckRequestDatailsFourCourses extends ReusableLibrary {
	ReadData rd = new ReadData();

	@Test(dataProvider = "data", priority = 4, dependsOnGroups = "CheckRequestDetailsFourCourses")
	public void checkRequestDetails4Courses(Map<Object, Object> data) throws Throwable, IOException {
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Test for Tuition Reimbursement Check Request**", ExtentColor.ORANGE));

		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		SubmitTuitionReimbursementRequest strr = PageFactory.initElements(driver,
				SubmitTuitionReimbursementRequest.class);
		CourseApprovalFourCourses approvalFourCourses = new CourseApprovalFourCourses();
		PartTwoCheckRequestDetailsFourCourses detailsFourCourses = new PartTwoCheckRequestDetailsFourCourses();

		// Login to the application and validate the login
		loginPage.snowLogin(HrAnalystUser2, HrAnalystUser2Password);
		knowledgeCreation.loginValidate();

		HRCaseDashboardListView listview = PageFactory.initElements(driver, HRCaseDashboardListView.class);
		// navigating to HR Case Dash board
		listview.navigateToHRDashboard();

		// Resolving check request
		String suite = getSuiteName();
		String identifierVariable = detailsFourCourses.getClassName().trim() + "-" + getTemperoryExecuteOn() + "-"
				+ getTemperoryOS() + "-" + getTemperorybrowser();
		String casenum = getFromDataLib(rd, suite, identifierVariable);
		strr.ResolveCheckRequest(casenum);
		// strr.ResolveCheckRequest("HRC0041684");

		identifierVariable = approvalFourCourses.getClassName().trim() + "-" + getTemperoryExecuteOn() + "-"
				+ getTemperoryOS() + "-" + getTemperorybrowser() + "-" + "User";
		// Validating check request details
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