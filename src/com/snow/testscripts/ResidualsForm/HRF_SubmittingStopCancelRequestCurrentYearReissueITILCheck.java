package com.snow.testscripts.ResidualsForm;

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
import com.snow.pageobjects.ResidualFormITILCheck;

public class HRF_SubmittingStopCancelRequestCurrentYearReissueITILCheck extends ReusableLibrary {
	ReadData rd = new ReadData();

	@Test(priority = 8, dataProvider = "data", dependsOnGroups = "CreateStopCancelRequestCurrentYearReissue")
	public void checkStopCancelRequestCurrentYearReissue(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		HRF_SubmittingStopCancelRequestCurrentYearReissue requestForm = new HRF_SubmittingStopCancelRequestCurrentYearReissue();
		ResidualFormITILCheck residualFormITIL = new ResidualFormITILCheck(driver);

		test.get().log(Status.INFO, MarkupHelper
				.createLabel("**Test for Checking Submitted Stop Cancel Request in ITIL View**", ExtentColor.ORANGE));

		// Login to the application and validate the login
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		checkForPageLoad(driver);
		knowledgeCreation.loginValidate();

		// Reading Data from Input excel
		String aboutTo = (String) data.get("ActiveWorker");
		String updatedSSN = (String) data.get("ValidSSNFEIN");
		String assignTo = (String) data.get("AssignedTo");
		String workNotes = (String) data.get("WorkNotes");
		String form = (String) data.get("Form");
		String priority = (String) data.get("Priority");
		String hrService = (String) data.get("HRService");
		String assignmentGroup = (String) data.get("AssignmentGroup");

		residualFormITIL.navigateToSearchAllHRCase("HR Cases");
		String suite = getSuiteName();
		String identifierVariable = requestForm.getClassName().trim() + "-" + getTemperoryExecuteOn() + "-"
				+ getTemperoryOS() + "-" + getTemperorybrowser();
		String caseID = getFromDataLib(rd, suite, identifierVariable);
		residualFormITIL.searchHRCaseinITIL(caseID);
		// residualFormITIL.searchHRCaseinITIL("HRC0004469");
		residualFormITIL.validateHRCaseinITIL(aboutTo, updatedSSN, form, priority, hrService, assignmentGroup);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Marking the HR Case as Resolved**", ExtentColor.ORANGE));
		residualFormITIL.resolveHRCaseinITIL(assignTo, workNotes, form);

	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("HR Residuals Forms");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString()
					.contains("TestCaseFor=ITIL Check: Stop/Cancel Request: Current Year Reissue")) {
				testCaseData[0][0] = excelData[i][0];
			}

		}
		return testCaseData;
	}
}