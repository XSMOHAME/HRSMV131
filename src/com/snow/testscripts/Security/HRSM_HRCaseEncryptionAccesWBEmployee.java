package com.snow.testscripts.Security;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.snow.base.ReadData;
import com.snow.base.ReusableLibrary;
import com.snow.pageobjects.HRCASE_ENCRYPTION_ACCESS_WBEMPLOYEE;
import com.snow.pageobjects.LoginPage;

public class HRSM_HRCaseEncryptionAccesWBEmployee extends ReusableLibrary {

	ReadData rd = new ReadData();

	@Test(dataProvider = "data", priority = 0)
	public void security_Form_validation(Map<Object, Object> data) throws Exception {
		// KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		// readind data from excel
		String userId = (String) data.get("UserId");
		String password = (String) data.get("Password");

		// reading data from excel end here
		LoginPage loginPage = new LoginPage(driver);
		loginPage.snowLogin(userId, password);
		checkForPageLoad(driver);

		HRCASE_ENCRYPTION_ACCESS_WBEMPLOYEE hr = PageFactory.initElements(driver,
				HRCASE_ENCRYPTION_ACCESS_WBEMPLOYEE.class);
		hr.validating_itilview();
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("Security");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("HRSM_HRCaseEncryptionAccesWBEmployee")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}

}