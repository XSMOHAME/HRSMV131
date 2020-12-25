package com.snow.testscripts.CaseManagement;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.snow.base.ReadData;
import com.snow.base.ReusableLibrary;
import com.snow.pageobjects.HR_Case_Management;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;

public class HRCaseProfile extends ReusableLibrary {
	
	ReadData rd = new ReadData();
	@Test(dataProvider = "data")
	public void createCase(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		System.out.println("HR Portal " + hrPortalURL);
		knowledgeCreation.loginValidate();
		
		HR_Case_Management hrc = PageFactory.initElements(driver, HR_Case_Management.class);
		// navigating to the create new case
		hrc.navigateCaseManagement();
		String activerUsr = (String) data.get("ActiveUser");
		String inValidUsr = (String) data.get("InValidUser");
		// confirming the active user
		hrc.confirmActiveUser(activerUsr);
		// confirming the inactive user
		hrc.confirmInValidUser(inValidUsr);
		// creating the case for active user
		hrc.createCase(activerUsr);
		String sourcedropdown = (String) data.get("SourceDropdown");
		String contactropdown = (String) data.get("MethodOfContactDropdown");
		// validating the source dropdown options
		hrc.validateSourceDropdown(sourcedropdown);
		String hrservicevalue = (String) data.get("HRSERVICE");
		String alternateContact = (String) data.get("AltNumber");
		String description = (String) data.get("Description");
		// validating the method of contact dropdown options
		hrc.validateMethodOfContactDropdown(contactropdown, hrservicevalue, alternateContact, description);
		String assignName = (String) data.get("AssignTo");
		// validating case details
		hrc.ValidateCase(assignName, description);
		String comments = (String) data.get("AddComment");
		hrc.validateComments(comments);
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {

		Object[][] excelData = rd.readDataFromSheet("hrCaseManagement");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("hrCaseManage")) {
				testCaseData[0][0] = excelData[i][0];
			}

		}
		return testCaseData;
	}

}
