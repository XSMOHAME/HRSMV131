package com.snow.testscripts.HRPortal;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.snow.base.ReadData;
import com.snow.base.ReusableLibrary;
import com.snow.exceptions.InvalidCredentialException;
import com.snow.pageobjects.HRPortalPage;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;

public class HRPortalSearchResults extends ReusableLibrary {
	ReadData rd = new ReadData();

	@Test(dataProvider = "data", priority = 1)
	public void hrPortalSearchResultsValidation(Map<Object, Object> data)
			throws InterruptedException, IOException, InvalidCredentialException {
		LoginPage loginPage = new LoginPage(driver);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		HRPortalPage hrPortalPage = new HRPortalPage(driver);

		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		knowledgeCreation.loginValidate();

		System.out.println("HR Portal " + hrPortalURL);
		driver.navigate().to(hrPortalURL);

		String form = (String) data.get("Form");
		test.get().log(Status.PASS, MarkupHelper.createLabel("Successfully Navigated to HR Portal", ExtentColor.GREEN));
		System.out.println("Successfully Navigated to HR Portal");

		// hpp.portal_form_validations();
		List<String> List = Arrays.asList(form.split(","));
		for (int i = 0; i < List.size(); i++) {
			hrPortalPage.formValidations(List.get(i));
			driver.navigate().to(hrPortalURL);
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Successfully Navigated to HR Portal", ExtentColor.GREEN));
			System.out.println("Successfully Navigated to HR Portal");

			if (List.get(i).contains("Check Request")) {
				hrPortalPage.search_form(List.get(i));
				hrPortalPage.portal_knowledgeBasePage_validation(List.get(i));
				driver.navigate().to(hrPortalURL);
			}
		}

	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("HR Portal");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("TestCaseFor=HRPortalSearchResults")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}
}