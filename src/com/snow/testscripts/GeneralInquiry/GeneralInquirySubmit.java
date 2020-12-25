package com.snow.testscripts.GeneralInquiry;

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
import com.snow.pageobjects.GeneralInquiryPage;
import com.snow.pageobjects.HRPortalPage;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;

public class GeneralInquirySubmit extends ReusableLibrary {
	ReadData rd = new ReadData();
	String caseID = null;

	/*
	 * public GeneralInquirySubmit() { StackTraceElement[] stackTraceElement =
	 * Thread.currentThread().getStackTrace(); StackTraceElement traceElement =
	 * stackTraceElement[1]; String[] className =
	 * traceElement.getClassName().split("\\."); String testUnderExecution =
	 * className[className.length - 1]; System.out.println(testUnderExecution);
	 * setClassUnderExecution(testUnderExecution); }
	 */

	@Test(dataProvider = "data")
	public void submit_General_Inquiry(Map<Object, Object> data) throws Throwable, IOException {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		HRPortalPage hrPortalPage = new HRPortalPage(driver);
		GeneralInquiryPage generalInquiryPage = new GeneralInquiryPage(driver);
		CategoryPage categoryPage = new CategoryPage(driver);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Test for Submitting General Inquiry Request**", ExtentColor.ORANGE));
		// Login to the application and validate the login
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		knowledgeCreation.loginValidate();

		// Navigation to HR Portal and Validation
		driver.navigate().to(hrPortalURL);
		hrPortalPage.hrPortalNavigateValidate();

		// Reading Data from Input excel
		String question = (String) data.get("Question");

		hrPortalPage.searchForForm("General Inquiry");
		test.get().log(Status.INFO,
				MarkupHelper.createLabel(
						"**Identifying Mandatory Fields for the Form by selecting Submit button directly.**",
						ExtentColor.ORANGE));
		generalInquiryPage.validateMandatoryFields();
		generalInquiryPage.createGeneralInquiry(question);
		categoryPage.displaycaseID();
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("General Inquiry");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("TestCaseFor=Submitting General Inquiry")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}
}