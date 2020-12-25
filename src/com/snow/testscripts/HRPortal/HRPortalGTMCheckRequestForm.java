package com.snow.testscripts.HRPortal;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.snow.base.ReadData;
import com.snow.base.ReusableLibrary;
import com.snow.exceptions.InvalidCredentialException;
import com.snow.pageobjects.CategoryPage;
import com.snow.pageobjects.Check_Request_Page;
import com.snow.pageobjects.HRPortalPage;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;

public class HRPortalGTMCheckRequestForm extends ReusableLibrary {
	ReadData rd = new ReadData();

	@Test(dataProvider = "data", priority = 1)
	public void hrPortalCheckRequestFormValidations(Map<Object, Object> data)
			throws InterruptedException, IOException, InvalidCredentialException {
		LoginPage loginPage = new LoginPage(driver);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		HRPortalPage hrPortalPage = new HRPortalPage(driver);
		Check_Request_Page cr = new Check_Request_Page(driver);
		CategoryPage cp = new CategoryPage(driver);

		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		knowledgeCreation.loginValidate();

		System.out.println("HR Portal " + hrPortalURL);
		driver.navigate().to(hrPortalURL);
		test.get().log(Status.PASS, MarkupHelper.createLabel("Successfully Navigated to HR Portal", ExtentColor.GREEN));
		System.out.println("Successfully Navigated to HR Portal");

		String form = (String) data.get("Form");
		System.out.println(form);
		hrPortalPage.searchForm(form);
		hrPortalPage.navigate_form(form);
		cr.create_checkrequest();
		cp.displaycaseID();
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("HR Portal");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("TestCaseFor=HRPortalGTMCheckRequestForm")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}
}