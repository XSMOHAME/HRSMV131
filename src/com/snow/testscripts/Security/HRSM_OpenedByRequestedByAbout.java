package com.snow.testscripts.Security;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.snow.base.ReadData;
import com.snow.base.ReusableLibrary;
import com.snow.pageobjects.HRSM_OpenedByRequestedByAboutPage;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;

public class HRSM_OpenedByRequestedByAbout extends ReusableLibrary {

	ReadData rd = new ReadData();
	String casenumber;
	String casenumber1;

	@Test(dataProvider = "data")
	public void security_Form_validation_requestedby(Map<Object, Object> data) throws Exception {
		// Reading data from excel start here
		String userId = (String) data.get("UserId");
		String password = (String) data.get("Password");
		String username = (String) data.get("username");
		String source = (String) data.get("source");
		String coe = (String) data.get("coe");
		String hrservice = (String) data.get("hrservice");
		String description = (String) data.get("description");
		String replacementuser = (String) data.get("replacement user");
		// Reading data from excel end here

		LoginPage loginPage = new LoginPage(driver);
		loginPage.snowLogin(userId, password);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		knowledgeCreation.loginValidate();

		HRSM_OpenedByRequestedByAboutPage hr = PageFactory.initElements(driver,
				HRSM_OpenedByRequestedByAboutPage.class);

		hr.navigateToHRDashboard();
		hr.validate_createcasepage(username);
		System.out.println("Case Number - " + casenumber);
		casenumber = hr.casecreation(source, coe, hrservice, description, replacementuser);

	}

	@Test(dataProvider = "data", dependsOnMethods = "security_Form_validation_requestedby")
	public void security_Form_validation_requestedby1(Map<Object, Object> data) throws Exception {
		String userId = (String) data.get("UserId");
		String password = (String) data.get("Password");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.snowLogin(userId, password);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		knowledgeCreation.loginValidate();

		HRSM_OpenedByRequestedByAboutPage hr = PageFactory.initElements(driver,
				HRSM_OpenedByRequestedByAboutPage.class);

		hr.validating_user1(casenumber.trim());
		// hr.validating_user1("HRC0033575");
	}

	@Test(dataProvider = "data", dependsOnMethods = "security_Form_validation_requestedby1")
	public void security_Form_validation_requestedby2(Map<Object, Object> data) throws Exception {
		// Reading data from excel start here
		String userId = (String) data.get("UserId1");
		String password = (String) data.get("password1");
		// Reading data from excel end here

		LoginPage loginPage = new LoginPage(driver);
		loginPage.snowLogin(userId, password);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		knowledgeCreation.loginValidate();

		HRSM_OpenedByRequestedByAboutPage hr = PageFactory.initElements(driver,
				HRSM_OpenedByRequestedByAboutPage.class);
		hr.navigateToHRDashboard1(casenumber);
	}

	@Test(dataProvider = "data", dependsOnMethods = "security_Form_validation_requestedby2")
	public void security_Form_validation_requestedby3(Map<Object, Object> data) throws Exception {
		// Reading data from excel start here
		String userId = (String) data.get("userid2");
		String password = (String) data.get("password2");
		String username = (String) data.get("username");
		// Reading data from excel end here

		LoginPage loginPage = new LoginPage(driver);
		loginPage.snowLogin(userId, password);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		knowledgeCreation.loginValidate();

		HRSM_OpenedByRequestedByAboutPage hr = PageFactory.initElements(driver,
				HRSM_OpenedByRequestedByAboutPage.class);
		hr.navigateToHRDashboard2(username, casenumber);
	}

	@Test(dataProvider = "data", dependsOnMethods = "security_Form_validation_requestedby3")
	public void security_Form_validation_requestedby4(Map<Object, Object> data) throws Exception {
		// Reading data from excel start here
		String userId = (String) data.get("UserId");
		String password = (String) data.get("Password");
		String username = (String) data.get("username");
		String source = (String) data.get("source");
		String coe = (String) data.get("coe1");
		String hrservice = (String) data.get("hrservice1");
		String description = (String) data.get("description");
		String replacementuser = (String) data.get("replacement user");
		// Reading data from excel end here

		LoginPage loginPage = new LoginPage(driver);
		loginPage.snowLogin(userId, password);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		knowledgeCreation.loginValidate();

		HRSM_OpenedByRequestedByAboutPage hr = PageFactory.initElements(driver,
				HRSM_OpenedByRequestedByAboutPage.class);
		hr.navigateToHRDashboard();
		hr.validate_createcasepage(username);

		casenumber1 = hr.casecreation1(source, coe, hrservice, description, replacementuser);
	}

	@Test(dataProvider = "data", dependsOnMethods = "security_Form_validation_requestedby4")
	public void security_Form_validation_requestedby5(Map<Object, Object> data) throws Exception {
		String userId = (String) data.get("UserId");
		String password = (String) data.get("Password");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.snowLogin(userId, password);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		knowledgeCreation.loginValidate();

		HRSM_OpenedByRequestedByAboutPage hr = PageFactory.initElements(driver,
				HRSM_OpenedByRequestedByAboutPage.class);

		hr.validating_user2(casenumber1);
		// hr.validating_user2("HRC0033575");
	}

	@Test(dataProvider = "data", dependsOnMethods = "security_Form_validation_requestedby5")
	public void security_Form_validation_requestedby6(Map<Object, Object> data) throws Exception {
		// Reading data from excel start here
		String userId = (String) data.get("UserId1");
		String password = (String) data.get("password1");
		// Reading data from excel end here

		LoginPage loginPage = new LoginPage(driver);
		loginPage.snowLogin(userId, password);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		knowledgeCreation.loginValidate();

		HRSM_OpenedByRequestedByAboutPage hr = PageFactory.initElements(driver,
				HRSM_OpenedByRequestedByAboutPage.class);
		hr.navigateToHRDashboard3(casenumber1);
	}

	@Test(dataProvider = "data", dependsOnMethods = "security_Form_validation_requestedby6")
	public void security_Form_validation_requestedby7(Map<Object, Object> data) throws Exception {
		// Reading data from excel start here
		String userId = (String) data.get("userid2");
		String password = (String) data.get("password2");
		// Reading data from excel end here

		LoginPage loginPage = new LoginPage(driver);
		loginPage.snowLogin(userId, password);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		knowledgeCreation.loginValidate();

		HRSM_OpenedByRequestedByAboutPage hr = PageFactory.initElements(driver,
				HRSM_OpenedByRequestedByAboutPage.class);
		hr.navigateToHRDashboard4(casenumber1);

	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("Security");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("HRSM_OpenedByRequestedByAbout")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}
}
