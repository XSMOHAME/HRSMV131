package com.snow.testscripts.CaseManagement;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.snow.base.ReadData;
import com.snow.base.ReusableLibrary;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;
import com.snow.pageobjects.ValidateCMSDetailedReport;

public class CMSDetailedReport extends ReusableLibrary {
	ReadData rd = new ReadData();


	@Test(dataProvider = "data")
	public void validateCmsReport(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.snowLogin(HrAnalystUser2, HrAnalystUser2Password);
		System.out.println("HR Portal " + hrPortalURL);
		checkForPageLoad(driver);
		// Login Validation
		knowledgeCreation.loginValidate();
		ValidateCMSDetailedReport reports = PageFactory.initElements(driver, ValidateCMSDetailedReport.class);
		// navigating to the HR Case DashBoard
		reports.navigateReport();
		String report = (String) data.get("ReportType");
		String filename = (String) data.get("DownloadFileName");
		String browserstackfile = (String) data.get("BrowserstackFilename");
		String condition1 = (String) data.get("Condition1");
		String condition3 = (String) data.get("Condition3");
		reports.OpenMonthlyReport(report, filename, browserstackfile);
		Thread.sleep(3000);
		reports.readColumns(condition1, condition3);

	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("hrCaseManagement");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("CMSDetaileReport")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}

}
