package com.snow.testscripts.WBSFTempRequestForm;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.snow.base.ReadData;
import com.snow.base.ReusableLibrary;
import com.snow.pageobjects.Dashboard_and_Reporting;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;

public class Dashboard_and_reporting extends ReusableLibrary {

	ReadData rd = new ReadData();
	String hrcasenumber;

	@Test(dataProvider = "data", priority = 0)
	public void wbsf_Form_validation(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		/** Reading data from excel **/

		String username = (String) data.get("userid");
		String password = (String) data.get("password");
		String bjs = (String) data.get("business justification");
		String Startdate = (String) data.get("startdate");
		String time = (String) data.get("Hours");
		String bldgno = (String) data.get("Building and room no");
		String duties = (String) data.get("Daily job duties");
		String department = (String) data.get("department");
		String union = (String) data.get("union or nonunion");
		String requesttype = (String) data.get("requesttype");

		/** Reading data from excel end here **/

		LoginPage loginPage = new LoginPage(driver);
		System.out.println("browser - " + browser);
		loginPage.snowLogin(username, password);
//		System.out.println("HR Portal " + properties.getProperty("hrportal"));
		checkForPageLoad(driver);
		knowledgeCreation.loginValidate();
		driver.navigate().to(hrPortalURL);
		checkForPageLoad(driver);
		test.get().log(Status.PASS, MarkupHelper.createLabel("Successfully Navigated to HR Portal", ExtentColor.GREEN));

		Dashboard_and_Reporting dr = new Dashboard_and_Reporting(driver);
		hrcasenumber = dr.fill_wbsftemp_request_form(department, union, requesttype, bjs, Startdate, time, bldgno,
				duties);
	}

	@Test(dataProvider = "data", priority = 1, dependsOnMethods = "wbsf_Form_validation")
	public void wbsf_Form_validation1(Map<Object, Object> data) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		Dashboard_and_Reporting dr = new Dashboard_and_Reporting(driver);

		String username = (String) data.get("userid");
		String password = (String) data.get("password");
		// hrcasenumber = "HRC0041582";

		loginPage.snowLogin(username, password);
		knowledgeCreation.loginValidate();
		checkForPageLoad(driver);

		test.get().log(Status.PASS, MarkupHelper.createLabel("Successfully Navigated to HR Portal", ExtentColor.GREEN));
		System.out.println("Successfully Navigated to HR Portal");

		dr.navigateToHRDashboard();
		dr.confirmingHrcaseDashboard();
		dr.validate_opencases_assignedto_wbstudio_facilities(hrcasenumber);
		dr.navigateTo_WorkforceAdministrationCases();
		dr.validate_gearicon();
		dr.validate_leftdropdown();
		dr.validate_rightdropdown();
		dr.validate_column_order();
		dr.validate_reset_to_default_view_or_not();
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("wbsftemprequestform");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("Dashboard and reporting")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}
}