package com.snow.testscripts.CaseManagement;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.snow.base.ReadData;
import com.snow.base.ReusableLibrary;
import com.snow.pageobjects.HRCaseDashboardListView;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;

public class DecendingSLAOrder extends ReusableLibrary {
	
	ReadData rd = new ReadData();
	@Test(dataProvider = "data")
	public void decendingSla(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.snowLogin(HrAnalystUser2, HrAnalystUser2Password);
		System.out.println("HR Portal " + hrPortalURL);
		checkForPageLoad(driver);
		// Login Validation
		knowledgeCreation.loginValidate();
		HRCaseDashboardListView hrdashboard = PageFactory.initElements(driver, HRCaseDashboardListView.class);
		// navigating to the HR Case DashBoard
		hrdashboard.navigateToHRDashboard();
		// checking the SLA order is Descending
		hrdashboard.checkSLAOrder();

	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("hrCaseManagement");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("hrcasechangeabout")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}

}
