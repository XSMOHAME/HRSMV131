package com.snow.testscripts.Security;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.snow.base.ReadData;
import com.snow.base.ReusableLibrary;
import com.snow.pageobjects.HR_PROFILE_ENCRYPTION_ACCESS_HRAGENT;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;

public class HRSM_HRProfileEncryptionAccessHRAgent extends ReusableLibrary {
	
	ReadData rd = new ReadData();
	/** Positive(+ve) testing **/

	@Test(dataProvider = "data", priority = 0)
	public void security_Form_validation(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		String userId = (String) data.get("User with Profile Encryption");
		String password = (String) data.get("User with Profile Encryption Password");
		String hrprofileuser = (String) data.get("User for HR Profile Validation");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.snowLogin(userId, password);
		checkForPageLoad(driver);
		knowledgeCreation.loginValidate();

		HR_PROFILE_ENCRYPTION_ACCESS_HRAGENT hr = PageFactory.initElements(driver,
				HR_PROFILE_ENCRYPTION_ACCESS_HRAGENT.class);

		hr.navigateToHRDashboard(hrprofileuser);
		hr.validate_user_profile();

	}

	/** Negative(-ve) testing **/

	@Test(dataProvider = "data", priority = 1)
	public void security_Form_validation1(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		String userId = (String) data.get("User without Profile Encryption");
		String password = (String) data.get("User without Profile Encryption Password");
		String hrprofileuser = (String) data.get("User for HR Profile Validation");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.snowLogin(userId, password);
		checkForPageLoad(driver);
		knowledgeCreation.loginValidate();

		HR_PROFILE_ENCRYPTION_ACCESS_HRAGENT hr = PageFactory.initElements(driver,
				HR_PROFILE_ENCRYPTION_ACCESS_HRAGENT.class);

		hr.navigateToHRDashboard(hrprofileuser);
		hr.validating_fields_available_or_not();

	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("Security");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("HRSM_HRProfileEncryptionAccessHRAgent")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}
}
