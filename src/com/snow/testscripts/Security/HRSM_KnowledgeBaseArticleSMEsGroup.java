package com.snow.testscripts.Security;

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
import com.snow.pageobjects.SecurityFormPage;

public class HRSM_KnowledgeBaseArticleSMEsGroup extends ReusableLibrary {

	public static String caseID = null;
	public String user = null;
	ReadData rd = new ReadData();

	@Test(dataProvider = "data")
	public void securityProcessForm(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		// HRPortalPage hrPortalPage = new HRPortalPage(driver);
		SecurityFormPage securityFormPage = new SecurityFormPage(driver);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Test for Knowledge Base Article SMEs Group**", ExtentColor.ORANGE));

		// Reading Data from Input excel

		String userId = (String) data.get("UserId");
		String password = (String) data.get("Password");
		String employeeServicesCase = (String) data.get("EmployeeServicesCase");
		String employeeServicescaseName = (String) data.get("EmployeeServicesCaseName");
		String hRITCase = (String) data.get("HRITCase");
		String hRITcaseName = (String) data.get("HRITCaseName");
		String payrollCase = (String) data.get("PayrollCase");
		String payrollcaseName = (String) data.get("PayrollCaseName");
		String totalRewardsCase = (String) data.get("TotalRewardsCase");
		String totalRewardsCaseName = (String) data.get("TotalRewardsCaseName");
		String workforceAdministration = (String) data.get("WorkforceAdministrationCase");
		String workforceAdministrationCaseName = (String) data.get("WorkforceAdministrationCaseName");

		// Login to the application and validate the login
		loginPage.snowLogin(userId, password);
		checkForPageLoad(driver);
		user = knowledgeCreation.loginValidate();

		checkForPageLoad(driver);

		/*
		 * Searching for Required form, submitting the Request and validating form
		 * submission
		 */

		securityFormPage.columnCategoryCompliance(employeeServicesCase, employeeServicescaseName, user);
		securityFormPage.columnCategoryCompliance(hRITCase, hRITcaseName, user);
		securityFormPage.columnCategoryCompliance(payrollCase, payrollcaseName, user);
		securityFormPage.columnCategoryCompliance(totalRewardsCase, totalRewardsCaseName, user);
		securityFormPage.columnCategoryCompliance(workforceAdministration, workforceAdministrationCaseName, user);
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("Security");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("HRSM_KnowledgeBaseArticleSMEsGroup")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}
}