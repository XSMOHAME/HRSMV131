package com.snow.testscripts.FileRequest;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.snow.base.ReadData;
import com.snow.base.ReusableLibrary;
import com.snow.pageobjects.FileRequestPage;
import com.snow.pageobjects.HRPortalPage;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;

public class SubmitFileRequest extends ReusableLibrary {
	ReadData rd = new ReadData();

	@Test(dataProvider = "data", groups = "CreateFileRequestForm")
	public void createFileRequestForm(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		HRPortalPage hrPortalPage = new HRPortalPage(driver);
		FileRequestPage fileRequestPage = new FileRequestPage(driver);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Test for Submitting File Request**", ExtentColor.ORANGE));

		// Login to the application and validate the login
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		knowledgeCreation.loginValidate();

		// Navigation to HR Portal and Validation
		driver.navigate().to(hrPortalURL);
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
		fileRequestPage.verifyFormLableAndShortDesc(form, formShortDesc);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel(
						"**Validating Select Worker from File Request Page for Residual/Participation Emplyee**",
						ExtentColor.ORANGE));
		fileRequestPage.validateSelectWorker2(residualEmployee);

		test.get().log(Status.INFO, MarkupHelper.createLabel(
				"**Validating Select Worker from File Request Page for Inactive User**", ExtentColor.ORANGE));
		fileRequestPage.validateSelectWorker(inactiveWorker);

		test.get().log(Status.INFO, MarkupHelper.createLabel(
				"**Validating Select Worker from File Request Page for Active User**", ExtentColor.ORANGE));
		fileRequestPage.validateSelectWorker(activeWorker);

	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("File Request");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("Employee File Request")) {
				testCaseData[0][0] = excelData[i][0];
			}

		}
		return testCaseData;
	}

}