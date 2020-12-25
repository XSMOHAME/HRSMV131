package com.snow.testscripts.FileRequest;

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
import com.snow.pageobjects.ResidualsFormPage;

public class ReviewingTasks extends ReusableLibrary {
	ReadData rd = new ReadData();

	@Test(dataProvider = "data", dependsOnGroups = "fileRequestInITILView")
	public void reviewTask(Map<Object, Object> data) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		ResidualsFormPage residualsFormPage = PageFactory.initElements(driver, ResidualsFormPage.class);
		CompletingFileRequestForm fileRequestForm = new CompletingFileRequestForm();

		test.get().log(Status.INFO, MarkupHelper.createLabel("**Test for Reviewing Tasks**", ExtentColor.ORANGE));

		// Login to the application and validate the login
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		knowledgeCreation.loginValidate();

		// Reading Data from Input excel
		String workNotes = (String) data.get("WorkNotes");
		String hrAgent = (String) data.get("HRAgent");

		String suite = getSuiteName();
		String identifierVariable = fileRequestForm.getClassName().trim() + "-" + getTemperoryExecuteOn() + "-"
				+ getTemperoryOS() + "-" + getTemperorybrowser();
		String fileRequestCaseId = getFromDataLib(rd, suite, identifierVariable);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Validating Select Worker from File Request Page**", ExtentColor.ORANGE));
		residualsFormPage.viewSubmittedFileRequest1(fileRequestCaseId);
		residualsFormPage.reviewingTasks(fileRequestCaseId, hrAgent, workNotes);

		/*
		 * residualsFormPage.viewSubmittedFileRequest1("HRC0054181");
		 * residualsFormPage.reviewingTasks("HRC0054181", hrAgent, workNotes);
		 */
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