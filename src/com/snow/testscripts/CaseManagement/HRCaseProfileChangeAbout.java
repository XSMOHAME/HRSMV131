package com.snow.testscripts.CaseManagement;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.snow.base.ReadData;
import com.snow.base.ReusableLibrary;
import com.snow.pageobjects.HRCaseManagementChangeAbout;
import com.snow.pageobjects.HRCreateCaseGuest;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;

public class HRCaseProfileChangeAbout extends ReusableLibrary {
	ReadData rd = new ReadData();
	String caseNumber = null;
	@Test(dataProvider = "data")
	public void createCase(Map<Object, Object> data) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		HRCaseManagementChangeAbout hrc = PageFactory.initElements(driver, HRCaseManagementChangeAbout.class);
		
		loginPage.snowLogin(HrAnalystUser2, HrAnalystUser2Password);
		knowledgeCreation.loginValidate();
		
		hrc.navigateCaseManagement();
		
		// create the case
		String activerUsr = (String) data.get("ActiveUser");
		hrc.createCase(activerUsr);

		// entering the source and alternate contact details
		String hrservicevalue = (String) data.get("HRSERVICE");
		String alternateContact = (String) data.get("AltNumber");
		String description = (String) data.get("Description");
		hrc.selectSourceAndAltContact(hrservicevalue, alternateContact, description);

		// validating the case
		String assignName = (String) data.get("AssignTo");
		caseNumber = hrc.validateCase(assignName);
	}

	@Test(dataProvider = "data", dependsOnMethods = "createCase")
	public void changeAboutTo(Map<Object, Object> data) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		HRCreateCaseGuest hrCreateCaseGuest = PageFactory.initElements(driver, HRCreateCaseGuest.class);
		HRCaseManagementChangeAbout hrc = PageFactory.initElements(driver, HRCaseManagementChangeAbout.class);
		
		loginPage.snowLogin(HrAnalystUser2, HrAnalystUser2Password);
		knowledgeCreation.loginValidate();

		// validating the change about field
		hrCreateCaseGuest.navigateToCase(caseNumber);

		String aboutPerson = (String) data.get("About");
		// validating the change about field
		hrc.changeAbout(aboutPerson);
		hrc.saveCase();
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
