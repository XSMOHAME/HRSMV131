package com.snow.testscripts.Security;

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
import com.snow.pageobjects.SecurityFormPage;

public class HRSM_HRProfileEncryptionAccessWBEmployee extends ReusableLibrary {

	public static String caseID = null;
	ReadData rd = new ReadData();

	@Test(dataProvider = "data")
	public void encryptionAccess(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		// HRPortalPage hrPortalPage = new HRPortalPage(driver);
		SecurityFormPage securityFormPage = new SecurityFormPage(driver);
		test.get().log(Status.INFO, MarkupHelper.createLabel(
				"**Test for validation of HR Profile by user with Encryption Access**", ExtentColor.ORANGE));

		// Reading Data from Input excel

		String userId = (String) data.get("User with Profile Encryption");
		String password = (String) data.get("User with Profile Encryption Password");
		String hrProfileUser = (String) data.get("User for HR Profile Validation");

		// Login to the application and validate the login
		loginPage.snowLogin(userId, password);
		checkForPageLoad(driver);
		knowledgeCreation.loginValidate();

		checkForPageLoad(driver);
		securityFormPage.navigateToHRProfile(hrProfileUser, true);
		securityFormPage.validateHRProfile(true);

	}

	@Test(dataProvider = "data")
	public void withoutEncryptionAccess(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		// HRPortalPage hrPortalPage = new HRPortalPage(driver);
		SecurityFormPage securityFormPage = new SecurityFormPage(driver);
		test.get().log(Status.INFO, MarkupHelper.createLabel(
				"**Test for validation of HR Profile by user without Encryption Access**", ExtentColor.ORANGE));

		// Reading Data from Input excel

		String userId = (String) data.get("User without Profile Encryption");
		String password = (String) data.get("User without Profile Encryption Password");
		String hrProfileUser = (String) data.get("User for HR Profile Validation");

		// Login to the application and validate the login
		loginPage.snowLogin(userId, password);
		checkForPageLoad(driver);
		knowledgeCreation.loginValidate();

		checkForPageLoad(driver);
		securityFormPage.navigateToHRProfile(hrProfileUser, false);
		securityFormPage.validateHRProfile(false);

	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("Security");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("HRSM_HRProfileEncryptionAccessWBEmployee")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}
}