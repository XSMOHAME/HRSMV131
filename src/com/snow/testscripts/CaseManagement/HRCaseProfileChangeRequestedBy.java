package com.snow.testscripts.CaseManagement;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.snow.base.ReadData;
import com.snow.base.ReusableLibrary;
import com.snow.pageobjects.HRCaseManagementChangeAbout;
import com.snow.pageobjects.HRCaseManagementChangeRequestedBy;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;

public class HRCaseProfileChangeRequestedBy extends ReusableLibrary {
	ReadData rd = new ReadData();
	String caseNo = null;
	String about = null;
	String[] caseDetails = null;

	@Test(dataProvider = "data")
	public void createCase(Map<Object, Object> data) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		HRCaseManagementChangeAbout hrc = PageFactory.initElements(driver, HRCaseManagementChangeAbout.class);
		HRCaseManagementChangeRequestedBy hrcr = PageFactory.initElements(driver,
				HRCaseManagementChangeRequestedBy.class);

		loginPage.snowLogin(HrAnalystUser2, HrAnalystUser2Password);
		knowledgeCreation.loginValidate();

		// navigating to the create new case
		hrc.navigateCaseManagement();

		// create case for active user
		String activerUsr = (String) data.get("ActiveUser");
		hrc.createCase(activerUsr);

		// selecting the source and alternate contact
		String hrservicevalue = (String) data.get("HRSERVICE");
		String alternateContact = (String) data.get("AltNumber");
		String description = (String) data.get("Description");
		hrc.selectSourceAndAltContact(hrservicevalue, alternateContact, description);

		// validating the case details
		caseDetails = hrcr.validateCase();

		System.out.println("Length of Case Details Array - " + caseDetails.length);
		caseNo = caseDetails[0];
		about = caseDetails[1];

		System.out.println("Case Number - " + caseNo);
		System.out.println("About Tr - " + about);
	}

	@Test(dataProvider = "data", dependsOnMethods = "createCase")
	public void changeRequestedBy(Map<Object, Object> data) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		HRCaseManagementChangeRequestedBy hrcr = PageFactory.initElements(driver,
				HRCaseManagementChangeRequestedBy.class);

		loginPage.snowLogin(HrAnalystUser2, HrAnalystUser2Password);
		knowledgeCreation.loginValidate();

		// caseNo = "HRC0038001";
		hrcr.navigateToHRCase(caseNo);

		// validating the change requestedBy
		String requesterName = (String) data.get("RequestedBy");
		String guestFname = (String) data.get("GuestFullName");
		String guestOrg = (String) data.get("GuestOrganization");
		String guestcontact = (String) data.get("GuestContact");
		hrcr.changeRequestedBy(requesterName, guestFname, guestOrg, guestcontact);
	}

	@Test(dataProvider = "data", dependsOnMethods = "changeRequestedBy")
	public void changeAbout(Map<Object, Object> data) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		HRCaseManagementChangeRequestedBy hrcr = PageFactory.initElements(driver,
				HRCaseManagementChangeRequestedBy.class);
		/*
		 * caseNo = "HRC0041176"; about = "HR USER QA";
		 */
		loginPage.snowLogin(HrAnalystUser2, HrAnalystUser2Password);
		knowledgeCreation.loginValidate();

		hrcr.navigateToHRCase(caseNo);

		// validating the change about
		hrcr.changeAbout(about.trim());
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("hrCaseManagement");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("hrcaseChangeRequestedBy")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}
}