package com.snow.testscripts.SystemSupportRequest;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.snow.base.ReadData;
import com.snow.base.ReusableLibrary;
import com.snow.pageobjects.CategoryPage;
import com.snow.pageobjects.HRPortalPage;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;
import com.snow.pageobjects.SystemSupportRequestPage;

public class SubmittingSystemSupportRequest extends ReusableLibrary {

	/*
	 * public SubmittingSystemSupportRequest() { StackTraceElement[]
	 * stackTraceElement = Thread.currentThread().getStackTrace(); StackTraceElement
	 * traceElement = stackTraceElement[1]; String[] className =
	 * traceElement.getClassName().split("\\."); testUnderExecution =
	 * className[className.length - 1]; System.out.println(testUnderExecution);
	 * setClassUnderExecution(testUnderExecution); }
	 */
	ReadData rd = new ReadData();
	String caseID = null;

	@Test(dataProvider = "data")
	public void createSystemSupportRequestForm(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		HRPortalPage hrPortalPage = new HRPortalPage(driver);
		SystemSupportRequestPage systemSupportRequestPage = new SystemSupportRequestPage(driver);
		CategoryPage categoryPage = new CategoryPage(driver);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Test for Submitting System Support Request**", ExtentColor.ORANGE));

		// Login to the application and validate the login
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		knowledgeCreation.loginValidate();

		// Navigation to HR Portal and Validation
		driver.navigate().to(hrPortalURL);
		hrPortalPage.hrPortalNavigateValidate();

		// Reading Data from Input excel
		String descRequest = (String) data.get("DescribeRequest");
		String hrSystem = (String) data.get("HRSystem");

		/*
		 * Searching for Required form, submitting the Request and validating form
		 * submission
		 */
		hrPortalPage.searchForForm("System Support Request");
		systemSupportRequestPage.create_systemsupportrequest(descRequest, hrSystem);
		caseID = categoryPage.displaycaseID();
		hrPortalPage.caseFormValidation();

		/*
		 * String environment = this.getClass().getSimpleName() + "-" +
		 * getTemperoryExecuteOn() + "-" + getTemperoryOS() + "-" +
		 * getTemperorybrowser();
		 * 
		 * System.out.println(getSuiteName());
		 * 
		 * rd.updateDataLibrary(getSuiteName(), environment, caseID);
		 * 
		 * String identifierVariable = this.getClass().getSimpleName() + "-" +
		 * getTemperoryExecuteOn() + "-" + getTemperoryOS() + "-" +
		 * getTemperorybrowser(); System.out.println("Identifier is  - " +
		 * identifierVariable); Map<Object, Object> datamap =
		 * rd.readFromDataLibrary(getSuiteName()); for (int i = 0; i < datamap.size();
		 * i++) { String caseid = (String) datamap.get(identifierVariable);
		 * System.out.println(caseid); }
		 */

		/*
		 * driver.navigate().to(homePageURL);
		 * systemSupportRequestPage.validateSystemSupportRequestITIL("HR Case", caseID);
		 * casePage.updateCaseWorkflow();
		 */

	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("System Support Request");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("SystemSupportRequest")) {
				testCaseData[0][0] = excelData[i][0];
			}

		}
		return testCaseData;
	}
}