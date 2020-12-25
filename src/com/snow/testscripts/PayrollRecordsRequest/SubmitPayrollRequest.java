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
import com.snow.pageobjects.HRPortalPage;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;
import com.snow.pageobjects.PayrollRecordsRequestPage;

public class SubmitPayrollRequest extends ReusableLibrary {
	ReadData rd = new ReadData();
	
//	public static String caseID = null;

	@Test(dataProvider = "data", groups = "CreatePayrollRequestForm")
	public void createPayrollRequestForm(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		HRPortalPage hrPortalPage = new HRPortalPage(driver);
		PayrollRecordsRequestPage payrollRecordsRequest = new PayrollRecordsRequestPage(driver);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Test for Submitting Payroll Record Request**", ExtentColor.ORANGE));

		// Login to the application and validate the login
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		knowledgeCreation.loginValidate();

		// Navigation to HR Portal and Validation
		driver.navigate().to(hrPortalURL);
	//	checkForPageLoad(driver);
		hrPortalPage.hrPortalNavigateValidate();

		// Reading Data from Input excel
		String form = (String) data.get("Form");
		String formShortDesc = (String) data.get("FormShortDesc");
		String residualEmployee = (String) data.get("Residuals/Participations employee");
		String inactiveWorker = (String) data.get("InactiveWorker");
		String activeWorker = (String) data.get("ActiveWorker");

		/*
		 * Searching for Required form, submitting the Request and validating form
		 * submission
		 */
		hrPortalPage.searchForForm(form);
		payrollRecordsRequest.verifyFormLableAndShortDesc1(form, formShortDesc);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel(
						"**Validating Select Worker from Payroll Request Page for Residual/Participation Emplyee**",
						ExtentColor.ORANGE));
		payrollRecordsRequest.validateSelectWorker(residualEmployee);

		test.get().log(Status.INFO, MarkupHelper.createLabel(
				"**Validating Select Worker from Payroll Request Page for Inactive User**", ExtentColor.ORANGE));
		payrollRecordsRequest.validateSelectWorker(inactiveWorker);

		test.get().log(Status.INFO, MarkupHelper.createLabel(
				"**Validating Select Worker from Payroll Request Page for Active User**", ExtentColor.ORANGE));
		payrollRecordsRequest.validateSelectWorker(activeWorker);

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