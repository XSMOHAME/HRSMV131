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
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;
import com.snow.pageobjects.ResidualsFormPage;

public class FileRequestInITILView extends ReusableLibrary {
	ReadData rd = new ReadData();

	@Test(dataProvider = "data", groups = "fileRequestInITILView", dependsOnGroups = "completingFileRequestForm")
	public void fileRequestInITILView(Map<Object, Object> data) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		ResidualsFormPage residualsFormPage = new ResidualsFormPage(driver);
		CompletingFileRequestForm fileRequestForm = new CompletingFileRequestForm();

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Test for validating File Request In ITIL View**", ExtentColor.ORANGE));

		// Login to the application and validate the login
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		knowledgeCreation.loginValidate();

		String activeWorker = (String) data.get("ActiveWorker");

		String suite = getSuiteName();
		String identifierVariable = fileRequestForm.getClassName().trim() + "-" + getTemperoryExecuteOn() + "-"
				+ getTemperoryOS() + "-" + getTemperorybrowser();
		String fileRequestCaseId = getFromDataLib(rd, suite, identifierVariable);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Validating Submitted File Request Page**", ExtentColor.ORANGE));
		residualsFormPage.viewSubmittedFileRequest(fileRequestCaseId, activeWorker.trim());
		// residualsFormPage.viewSubmittedFileRequest("HRC0041938",
		// activeWorker.trim());
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