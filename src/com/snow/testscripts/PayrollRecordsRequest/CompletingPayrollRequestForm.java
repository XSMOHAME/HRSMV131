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

public class CompletingPayrollRequestForm extends ReusableLibrary {

	ReadData rd = new ReadData();
		public static String caseID = null;
	public String getClassName() {
			return this.getClass().getSimpleName();
		}

	@Test(dataProvider = "data", groups = "completingPayrollRequestForm")
	public void completingPayrollRequestForm(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		HRPortalPage hrPortalPage = new HRPortalPage(driver);
		PayrollRecordsRequestPage payrollRecordsRequestPage = new PayrollRecordsRequestPage(driver);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Test for COMPLETING THE PAYROLL REQUEST FORM**", ExtentColor.ORANGE));

		// Login to the application and validate the login
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		knowledgeCreation.loginValidate();

		// Navigation to HR Portal and Validation
		driver.navigate().to(hrPortalURL);
		checkForPageLoad(driver);
		hrPortalPage.hrPortalNavigateValidate();

		// Reading Data from Input excel
		String form = (String) data.get("Form");
		String formShortDesc = (String) data.get("FormShortDesc");
		String activeWorker = (String) data.get("ActiveWorker");
		String payrollRecordsGroup = (String) data.get("PayrollRecordsGroup");
		String requestType = (String) data.get("RequestType");
		String deliveryMethod = (String) data.get("DeliveryMethod");
		String alternateContact = (String) data.get("AlternateContact");
		/*
		 * Searching for Required form, submitting the Request and validating form
		 * submission
		 */
		hrPortalPage.searchForForm(form);
		payrollRecordsRequestPage.verifyFormLableAndShortDesc(form, formShortDesc);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Validating Select Worker from Payroll Request Page**", ExtentColor.ORANGE));

		payrollRecordsRequestPage.submitButtonInputs(activeWorker, payrollRecordsGroup);
		payrollRecordsRequestPage.requestTypeElectronicCopy(requestType, deliveryMethod);
		
		payrollRecordsRequestPage.fileDeliveryInformation(requestType, deliveryMethod);
		caseID = payrollRecordsRequestPage.pointofContactRequest(alternateContact);

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