package com.snow.testscripts.Security;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.snow.base.ReadData;
import com.snow.base.ReusableLibrary;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;
import com.snow.pageobjects.OpenedBySecurityPage;

public class HRSM_OpenedBySecurity extends ReusableLibrary {

	ReadData rd = new ReadData();
	String casenumber;
	String casenumber1;
	String casenumber2;
	String casenumber3;

	@Test(dataProvider = "data")
	public void security_Form_validation_security(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		// Reading data from excel start here
		String userId = (String) data.get("UserId");
		String password = (String) data.get("Password");
		String username = (String) data.get("username");
		String source = (String) data.get("source");
		String coe = (String) data.get("coe");
		String hrservice = (String) data.get("hrservice");
		String description = (String) data.get("description");

		// Reading data from excel end here
		LoginPage loginPage = new LoginPage(driver);
		loginPage.snowLogin(userId, password);
		checkForPageLoad(driver);
		knowledgeCreation.loginValidate();
		OpenedBySecurityPage hr = PageFactory.initElements(driver, OpenedBySecurityPage.class);
		hr.navigateToHRDashboard();
		hr.validate_createcasepage(username);
		casenumber = hr.casecreation(source, coe, hrservice, description);
	}

	@Test(dataProvider = "data", dependsOnMethods = "security_Form_validation_security")
	public void security_Form_validation_security1(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		// Reading data from excel start here
		String userId = (String) data.get("UserId1");
		String password = (String) data.get("password1");
		String username = (String) data.get("username");
		String source = (String) data.get("source");
		String coe = (String) data.get("coe");
		String hrservice = (String) data.get("hrservice");
		String description = (String) data.get("description");

		// Reading data from excel end here
		LoginPage loginPage = new LoginPage(driver);
		loginPage.snowLogin(userId, password);
		checkForPageLoad(driver);
		knowledgeCreation.loginValidate();
		OpenedBySecurityPage hr = PageFactory.initElements(driver, OpenedBySecurityPage.class);
		hr.navigateToHRDashboard1(casenumber);
		hr.validate_createcasepage(username);
		casenumber1 = hr.casecreation1(source, coe, hrservice, description);
		hr.navigateToHRDashboard2(casenumber1);
	}

	@Test(dataProvider = "data", dependsOnMethods = "security_Form_validation_security1")
	public void security_Form_validation_security2(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		// Reading data from excel start here
		String userId = (String) data.get("UserId");
		String password = (String) data.get("Password");
		String username = (String) data.get("username");
		String source = (String) data.get("source");
		String coe = (String) data.get("coe1");
		String hrservice = (String) data.get("hrservice1");
		String description = (String) data.get("description");

		// Reading data from excel end here
		LoginPage loginPage = new LoginPage(driver);
		loginPage.snowLogin(userId, password);
		checkForPageLoad(driver);
		knowledgeCreation.loginValidate();
		OpenedBySecurityPage hr = PageFactory.initElements(driver, OpenedBySecurityPage.class);
		hr.navigateToHRDashboard();
		hr.validate_createcasepage(username);
		casenumber2 = hr.casecreation2(source, coe, hrservice, description);
	}

	@Test(dataProvider = "data", dependsOnMethods = "security_Form_validation_security2")
	public void security_Form_validation_security3(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		// Reading data from excel start here
		String userId = (String) data.get("userid2");
		String password = (String) data.get("password2");
		String username = (String) data.get("username");
		String source = (String) data.get("source");
		String coe = (String) data.get("coe1");
		String hrservice = (String) data.get("hrservice1");
		String description = (String) data.get("description");

		// Reading data from excel start here
		LoginPage loginPage = new LoginPage(driver);
		loginPage.snowLogin(userId, password);
		checkForPageLoad(driver);
		knowledgeCreation.loginValidate();
		OpenedBySecurityPage hr = PageFactory.initElements(driver, OpenedBySecurityPage.class);
		hr.navigateToHRDashboard3(casenumber2);
		hr.validate_createcasepage(username);
		casenumber3 = hr.casecreation3(source, coe, hrservice, description);
		hr.navigateToHRDashboard4(casenumber3);
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("Security");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("HRSM_OpenedBySecurity")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}
}