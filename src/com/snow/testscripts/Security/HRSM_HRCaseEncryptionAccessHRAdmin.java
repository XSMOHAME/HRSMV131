package com.snow.testscripts.Security;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.snow.base.ReadData;
import com.snow.base.ReusableLibrary;
import com.snow.pageobjects.HRCaseEncryptionAccessHRAdminPage;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;

public class HRSM_HRCaseEncryptionAccessHRAdmin extends ReusableLibrary {

	ReadData rd = new ReadData();
	String hrcasenumber;

	@Test(dataProvider = "data")
	public void security_Form_validationHRAdmin(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		/** Positive(+ve) testing **/
		// Reading data from excel start here
		String userId = (String) data.get("User with Case Encryption");
		String password = (String) data.get("User with Case Encryption Password");
		String worker = (String) data.get("active worker");
		String benificiaryname = (String) data.get("benificiary name");
		String ssn = (String) data.get("ssn");
		String date = (String) data.get("date");

		// Reading data from excel end here
		LoginPage loginPage = new LoginPage(driver);
		loginPage.snowLogin(userId, password);
		checkForPageLoad(driver);
		knowledgeCreation.loginValidate();
		driver.get(hrPortalURL);
		HRCaseEncryptionAccessHRAdminPage hr = PageFactory.initElements(driver,
				HRCaseEncryptionAccessHRAdminPage.class);
		hrcasenumber = hr.filling_residualform(worker, benificiaryname, ssn, date);
	}

	@Test(dataProvider = "data", dependsOnMethods = "security_Form_validationHRAdmin")
	public void security_Form_validationHRAdmin1(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		// Reading data from excel start here
		String userId = (String) data.get("User with Case Encryption");
		String password = (String) data.get("User with Case Encryption Password");

		// Reading data from excel end here
		LoginPage loginPage = new LoginPage(driver);
		loginPage.snowLogin(userId, password);
		checkForPageLoad(driver);
		knowledgeCreation.loginValidate();
		HRCaseEncryptionAccessHRAdminPage hr = PageFactory.initElements(driver,
				HRCaseEncryptionAccessHRAdminPage.class);
		hr.navigateToHRDashboard(hrcasenumber);
		hr.validatingfields();
	}

	@Test(dataProvider = "data", dependsOnMethods = "security_Form_validationHRAdmin1")
	public void security_Form_validationHRAdmin2(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		/** Negative(-ve) testing **/
		// Reading data from excel start here
		String userId = (String) data.get("User without Case Encryption");
		String password = (String) data.get("User without Case Encryption Password");
		String worker = (String) data.get("active worker");
		String benificiaryname = (String) data.get("benificiary name");
		String ssn = (String) data.get("ssn");
		String date = (String) data.get("date");

		// Reading data from excel end here
		LoginPage loginPage = new LoginPage(driver);
		loginPage.snowLogin(userId, password);
		checkForPageLoad(driver);
		knowledgeCreation.loginValidate();
		driver.get(hrPortalURL);
		HRCaseEncryptionAccessHRAdminPage hr = PageFactory.initElements(driver,
				HRCaseEncryptionAccessHRAdminPage.class);
		hrcasenumber = hr.filling_residualform(worker, benificiaryname, ssn, date);
	}

	@Test(dataProvider = "data", dependsOnMethods = "security_Form_validationHRAdmin2")
	public void security_Form_validationHRAdmin3(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		// Reading data from excel start here
		String userId = (String) data.get("User without Case Encryption");
		String password = (String) data.get("User without Case Encryption Password");

		// Reading data from excel end here
		LoginPage loginPage = new LoginPage(driver);
		loginPage.snowLogin(userId, password);
		checkForPageLoad(driver);
		knowledgeCreation.loginValidate();
		HRCaseEncryptionAccessHRAdminPage hr = PageFactory.initElements(driver,
				HRCaseEncryptionAccessHRAdminPage.class);
		hr.navigateToHRDashboard(hrcasenumber);
		hr.validatingfields_available_or_not();
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("security");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("HRSM_HrcaseEncryptionAccessHRAdmin")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}
}