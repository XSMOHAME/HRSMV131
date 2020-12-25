package com.snow.testscripts.CheckRequest;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.snow.base.ReadData;
import com.snow.base.ReusableLibrary;
import com.snow.pageobjects.Check_Request_Pages;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;

public class SubmittedCheckRequestITIL extends ReusableLibrary {
	ReadData rd = new ReadData();

	@Test(dataProvider = "data", dependsOnGroups = "CompleteCheckRequest", priority = 2)
	public void checkRequestITILVIew(Map<Object, Object> data) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		CompleteCheckRequest checkRequest = new CompleteCheckRequest();
		Check_Request_Pages cr = PageFactory.initElements(driver, Check_Request_Pages.class);

		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		knowledgeCreation.loginValidate();
		cr.navigateToSearchHrCase();

		String suite = getSuiteName();
		String identifierVariable = checkRequest.getClassName().trim() + "-" + getTemperoryExecuteOn() + "-"
				+ getTemperoryOS() + "-" + getTemperorybrowser();
		String checkRequestCaseId = getFromDataLib(rd, suite, identifierVariable);
		cr.searchHRCaseinITIL(checkRequestCaseId.trim());

		// cr.searchHRCaseinITIL("HRC0054139");

		cr.validateHRCaseinITIL();

		String assignName = (String) data.get("AssignTo");
		String workNotes = (String) data.get("Work Notes");
		cr.resolveHRCaseinITIL(assignName, workNotes);
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