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

public class HRCaseChangeAboutToResiduals extends ReusableLibrary {
	ReadData rd = new ReadData();
	String caseNumber = null;

	@Test(dataProvider = "data")
	public void createCase(Map<Object, Object> data) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		HRCaseManagementChangeAbout hrc = PageFactory.initElements(driver, HRCaseManagementChangeAbout.class);
		HRCreateCaseGuest createGuest = PageFactory.initElements(driver, HRCreateCaseGuest.class);

		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		System.out.println("HR Portal " + hrPortalURL);
		knowledgeCreation.loginValidate();

		// navigating to the new create case
		hrc.navigateCaseManagement();

		// search for the Guest user in the search requester bar
		String activerUsr = (String) data.get("ActiveUser");
		createGuest.searchGuest(activerUsr);

		// entering the Guest details
		String hrservice = (String) data.get("HRSERVICE");
		String guestFName = (String) data.get("GuestFullName");
		String guestOrg = (String) data.get("GuestOrganization");
		String guestContact = (String) data.get("GuestContact");
		createGuest.createCaseGuest(hrservice, guestFName, guestOrg, guestContact);

		// entering the Subject person Guest Details
		String subGuestFname = (String) data.get("SubGuestFullName");
		String subGuestOrg = (String) data.get("SubGuestOrganization");
		String subGuestContact = (String) data.get("SubGuestContact");
		String description = (String) data.get("Description");
		createGuest.createCaseGuestSubjectPerson(subGuestFname, subGuestOrg, subGuestContact, description);

		// validating the case details
		String assign = (String) data.get("AssignTo");
		caseNumber = createGuest.validateCaseGuest(assign);
	}

	@Test(dataProvider = "data", dependsOnMethods = "createCase")
	public void changeAboutTo(Map<Object, Object> data) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		HRCreateCaseGuest createGuest = PageFactory.initElements(driver, HRCreateCaseGuest.class);
		//caseNumber = "HRC0040458";
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		System.out.println("HR Portal " + hrPortalURL);
		knowledgeCreation.loginValidate();

		// validating the change about field
		String about = (String) data.get("Residuals");
		createGuest.navigateToCase(caseNumber);
		createGuest.changeAbout(about);

		// saving the case updated details
		createGuest.saveResults();
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("hrCaseManagement");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("hrcaseCreatingGuest")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}
}