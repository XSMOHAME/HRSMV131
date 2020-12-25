package com.snow.testscripts.CaseManagement;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.snow.base.ReadData;
import com.snow.base.ReusableLibrary;
import com.snow.pageobjects.HRCaseDashboardListView;
import com.snow.pageobjects.HRCaseManagementChangeAbout;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;

public class UpdatingHRCaseDashBoard extends ReusableLibrary {
	ReadData rd = new ReadData();

	@Test(dataProvider = "data", priority = 0)
	public void updateHrCaseDashboardDecreaseByResolving(Map<Object, Object> data) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		HRCaseDashboardListView hrdashboard = PageFactory.initElements(driver, HRCaseDashboardListView.class);

		// Login and Validate Login
		loginPage.snowLogin(HrAnalystUser2, HrAnalystUser2Password);
		knowledgeCreation.loginValidate();

		// Navigating to the HR Case Dash board
		hrdashboard.navigateToHRDashboard();

		// checking the HR Case Widgets are available or not
		hrdashboard.confirmingHrcaseDashboard();

		// Reading Data from Input File
		String assignToName = (String) data.get("AssignTo");
		String worker = (String) data.get("ActiveUser");
		String hrservicevalue = (String) data.get("HRSERVICE");
		String description = (String) data.get("Description");

		// decrease the Hr case count By Breached cases are Resolved
		hrdashboard.decreaseHRCaseCount(worker, assignToName, hrservicevalue, description);
	}

	@Test(dataProvider = "data", priority = 1)
	public void updateHrCaseDashboardDecreaseByAssigning(Map<Object, Object> data) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		HRCaseDashboardListView hrdashboard = PageFactory.initElements(driver, HRCaseDashboardListView.class);

		// Login and Validate Login
		loginPage.snowLogin(HrAnalystUser2, HrAnalystUser2Password);
		knowledgeCreation.loginValidate();

		// Navigating to the HR Case Dash board
		hrdashboard.navigateToHRDashboard();

		// checking the HR Case Widgets are available or not
		hrdashboard.confirmingHrcaseDashboard();

		// Reading Data from Input File
		String assignToName = (String) data.get("AssignTo");
		String worker = (String) data.get("ActiveUser");
		String hrservicevalue = (String) data.get("HRSERVICE");
		String description = (String) data.get("Description");

		// decrease the Hr Cases count By assigning for Unassigned cases
		hrdashboard.decreaseOpenCasesMyGroupsUnassign(worker, assignToName, hrservicevalue, description);
	}

	@Test(dataProvider = "data", priority = 2)
	public void updateHrCaseDashboardIncrease(Map<Object, Object> data) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		HRCaseDashboardListView hrdashboard = PageFactory.initElements(driver, HRCaseDashboardListView.class);
		HRCaseManagementChangeAbout changeabt = PageFactory.initElements(driver, HRCaseManagementChangeAbout.class);

		// Login and Validate Login
		loginPage.snowLogin(HrAnalystUser2, HrAnalystUser2Password);
		knowledgeCreation.loginValidate();

		// Navigating to the HR Case Dash board
		hrdashboard.navigateToHRDashboard();

		// checking the HR Case Widgets are available or not
		hrdashboard.confirmingHrcaseDashboard();

		// Reading Data from Input File
		String hrservicevalue = (String) data.get("HRSERVICE");
		String alternateContact = (String) data.get("AltNumber");
		String description = (String) data.get("Description");
		String worker = (String) data.get("ActiveUser");
		// selecting the Particular HR service and alternate contact Number
		hrdashboard.createNewCase(worker);
		changeabt.selectSourceAndAltContact(hrservicevalue, alternateContact, description);

		// Increase HR Cases Count By creating the new Case
		hrdashboard.increaseCasesCount();
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("hrCaseManagement");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("updateHrCaseDashboard")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}
}