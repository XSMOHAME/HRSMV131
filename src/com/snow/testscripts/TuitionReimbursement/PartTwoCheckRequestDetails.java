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

public class PartTwoCheckRequestDetails extends ReusableLibrary {
	ReadData rd = new ReadData();
	public String casenum;

	public String getClassName() {
		return this.getClass().getSimpleName();
	}

	@Test(dataProvider = "data", priority = 3, groups = "CheckRequestDetails", dependsOnGroups = "TuitionReimbursement")
	public void checkRequestDetails(Map<Object, Object> data) throws Throwable, IOException {
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Test for Tuition Reimbursement Request**", ExtentColor.ORANGE));
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		SubmitTuitionReimbursementRequest strr = PageFactory.initElements(driver,
				SubmitTuitionReimbursementRequest.class);
		CourseApprovalWithDeptPt1 approvalWithDeptPt1 = new CourseApprovalWithDeptPt1();

		// Login to the application and validate the login
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		knowledgeCreation.loginValidate();

		// Impersonate the HRSM Learing group User
		String GrpMember = (String) data.get("HRSMGroupMember");
		String suite = getSuiteName();
		String identifierVariable = approvalWithDeptPt1.getClassName().trim() + "-" + getTemperoryExecuteOn() + "-"
				+ getTemperoryOS() + "-" + getTemperorybrowser();
		String caseID = getFromDataLib(rd, suite, identifierVariable);
		strr.changeToHRSMLearningGrpUser(GrpMember, caseID);
		// strr.changeToHRSMLearningGrpUser(GrpMember, "HRC0043647");

		// entering the check request details
		String amount = (String) data.get("CheckAmount");
		String comments = (String) data.get("Comments");
		strr.enterCheckRequestDetails(amount, comments, GrpMember, caseID);
		// strr.enterCheckRequestDetails(amount, comments, GrpMember, "HRC0043647");
	}

	@Test(dataProvider = "data", priority = 3, groups = "CheckRequestDetails", dependsOnMethods = "checkRequestDetails")
	public void approveRequestDetails(Map<Object, Object> data) throws Throwable, IOException {
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Approving Tuition Reimbursement Request**", ExtentColor.ORANGE));
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		SubmitTuitionReimbursementRequest strr = PageFactory.initElements(driver,
				SubmitTuitionReimbursementRequest.class);
		CourseApprovalWithDeptPt1 approvalWithDeptPt1 = new CourseApprovalWithDeptPt1();

		// Login to the application and validate the login
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		knowledgeCreation.loginValidate();

		String GrpMember = (String) data.get("HRSMGroupMember");
		strr.impersonateAs(GrpMember);

		String suite = getSuiteName();
		String identifierVariable = approvalWithDeptPt1.getClassName().trim() + "-" + getTemperoryExecuteOn() + "-"
				+ getTemperoryOS() + "-" + getTemperorybrowser();
		String caseID = getFromDataLib(rd, suite, identifierVariable);
		casenum = strr.approveTuitionRequest(caseID.trim());
		// casenum = strr.approveTuitionRequest("HRC0043647");

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