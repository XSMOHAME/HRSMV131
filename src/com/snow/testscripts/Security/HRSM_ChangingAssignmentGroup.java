package com.snow.testscripts.Security;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.snow.base.ReadData;
import com.snow.base.ReusableLibrary;
import com.snow.pageobjects.ChangingAssignmentGroupPage;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;

public class HRSM_ChangingAssignmentGroup extends ReusableLibrary {

	ReadData rd = new ReadData();
	String casenumber;
	/*
	 * @Test(dataProvider = "data") public void
	 * security_Form_validation_assignmentgroup(Map<Object, Object> data) throws
	 * Exception {
	 * 
	 * // reading data from excel start here
	 * 
	 * String userId = (String) data.get("UserId"); String password = (String)
	 * data.get("Password");
	 * 
	 * // Reading data from excel end here
	 * 
	 * LoginPage loginPage = new LoginPage(driver); loginPage.snowLogin(userId,
	 * password); checkForPageLoad(driver); knowledgeCreation.loginValidate();
	 * 
	 * ChangingAssignmentGroupPage hr = PageFactory.initElements(driver,
	 * ChangingAssignmentGroupPage.class); hr.navigateToHRDashboard(); }
	 */

	@Test(dataProvider = "data")
	public void security_Form_validation_assignmentgroup1(Map<Object, Object> data) throws Exception {
		// Reading data from excel start here
		String userId1 = (String) data.get("UserId1");
		String password1 = (String) data.get("password1");
		String username = (String) data.get("username");
		String source = (String) data.get("source");
		String coe = (String) data.get("coe");
		String hrservice = (String) data.get("hrservice");
		String description = (String) data.get("description");
		// Reading data from excel end here
		
		LoginPage loginPage = new LoginPage(driver);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		ChangingAssignmentGroupPage hr = PageFactory.initElements(driver, ChangingAssignmentGroupPage.class);
		
		loginPage.snowLogin(userId1, password1);
		knowledgeCreation.loginValidate();

		hr.navigateToHRDashboard1();
		hr.validate_createcasepage(username);
		casenumber = hr.casecreation(source, coe, hrservice, description);
	}

	@Test(dataProvider = "data", dependsOnMethods = "security_Form_validation_assignmentgroup1")
	public void security_Form_validation_assignmentgroup2(Map<Object, Object> data) throws Exception {
		// Reading data from excel start here
		String userId = (String) data.get("UserId");
		String password = (String) data.get("Password");
		// Reading data from excel end here

		LoginPage loginPage = new LoginPage(driver);
		loginPage.snowLogin(userId, password);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		knowledgeCreation.loginValidate();

		ChangingAssignmentGroupPage hr = PageFactory.initElements(driver, ChangingAssignmentGroupPage.class);
		hr.navigateToHRDashboard2(casenumber);
	}

	@Test(dataProvider = "data", dependsOnMethods = "security_Form_validation_assignmentgroup2")
	public void security_Form_validation_assignmentgroup3(Map<Object, Object> data) throws Exception {
		// Reading data from excel start here
		String userId1 = (String) data.get("UserId1");
		String password1 = (String) data.get("password1");
		// Reading data from excel end here

		LoginPage loginPage = new LoginPage(driver);
		loginPage.snowLogin(userId1, password1);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		knowledgeCreation.loginValidate();

		ChangingAssignmentGroupPage hr = PageFactory.initElements(driver, ChangingAssignmentGroupPage.class);
		hr.updating_assignmentgroup(casenumber);

	}

	@Test(dataProvider = "data", dependsOnMethods = "security_Form_validation_assignmentgroup3")
	public void security_Form_validation_assignmentgroup4(Map<Object, Object> data) throws Exception {
		// Reading data from excel start here
		String userId = (String) data.get("UserId");
		String password = (String) data.get("Password");
		// Reading data from excel end here

		LoginPage loginPage = new LoginPage(driver);
		loginPage.snowLogin(userId, password);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		knowledgeCreation.loginValidate();

		ChangingAssignmentGroupPage hr = PageFactory.initElements(driver, ChangingAssignmentGroupPage.class);
		hr.navigateToHRDashboard4(casenumber);
		hr.updating_assignmentgroup_to_default(casenumber);
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("Security");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("HRSM_ChangingAssignmentGroup")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}
}