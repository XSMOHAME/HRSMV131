package com.snow.testscripts.CheckRequest;

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
import com.snow.pageobjects.Check_Request_Pages;
import com.snow.pageobjects.HRPortalPage;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;

public class CheckRequestForm extends ReusableLibrary {
	String name_change_request_form = "Check Request";
	ReadData rd = new ReadData();

	/*
	 * public CheckRequestForm() { StackTraceElement[] stackTraceElement =
	 * Thread.currentThread().getStackTrace(); StackTraceElement traceElement =
	 * stackTraceElement[1]; String[] className =
	 * traceElement.getClassName().split("\\."); String testUnderExecution =
	 * className[className.length - 1]; System.out.println(testUnderExecution);
	 * setClassUnderExecution(testUnderExecution); }
	 */

	@Test(dataProvider = "data", priority = 1)
	public void checkRequest_Form_validation(Map<Object, Object> data) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		HRPortalPage hpp = PageFactory.initElements(driver, HRPortalPage.class);
		Check_Request_Pages cr = PageFactory.initElements(driver, Check_Request_Pages.class);

		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		System.out.println("HR Portal " + hrPortalURL);
		knowledgeCreation.loginValidate();
		driver.navigate().to(hrPortalURL);
		checkForPageLoad(driver);
		test.get().log(Status.PASS, MarkupHelper.createLabel("Successfully Navigated to HR Portal", ExtentColor.GREEN));

		// seaching the check request
		hpp.search_form(name_change_request_form);

		// check request page landing validation
		hpp.check_Request_HeaderValidation();

		// Read data from excel sheet
		String activerWorker = (String) data.get("ActiveWorker");
		String inActiverWorker = (String) data.get("InActiveWorker");

		cr.validateSelectEmployeeInActiveWorker(inActiverWorker);
		cr.validateSelectEmployeeActiveWorker(activerWorker);
		/*
		 * cp.displaycaseID(); hpp.Portal_case_form_validation();
		 */
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("Check Request");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("CheckRequest")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}

}