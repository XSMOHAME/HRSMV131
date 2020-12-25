package com.snow.testscripts.PayrollRecordsRequest;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.snow.base.ReadData;
import com.snow.base.ReusableLibrary;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;
import com.snow.pageobjects.PayrollRecordsRequestPage;

public class ReviewingPayrollTasks extends ReusableLibrary {
	ReadData rd = new ReadData();

	public static String caseID = null;

	@Test(dataProvider = "data", dependsOnGroups = "payrollRequestInITILView")
	public void reviewPayrollTask(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		PayrollRecordsRequestPage payrollRecordsRequest = new PayrollRecordsRequestPage(driver);
		//ResidualsFormPage residualsFormPage = PageFactory.initElements(driver, ResidualsFormPage.class);
		test.get().log(Status.INFO, MarkupHelper.createLabel("**Test for Reviewing Payroll Tasks**", ExtentColor.ORANGE));

		// Login to the application and validate the login
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		checkForPageLoad(driver);
		knowledgeCreation.loginValidate();

		// Reading Data from Input excel
		String workNotes = (String) data.get("WorkNotes");
		String hrAgent = (String) data.get("HRAgent");

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Validating Select Worker from Payroll Request Page**", ExtentColor.ORANGE));
		payrollRecordsRequest.viewSubmittedPayrollRequest1(CompletingPayrollRequestForm.caseID);
		payrollRecordsRequest.reviewingPayrollTask1(hrAgent, workNotes);
		payrollRecordsRequest.reviewingPayrollTask2(hrAgent, workNotes);
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("Payroll Request");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("Payroll Records Request")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}

}