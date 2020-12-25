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
import com.snow.pageobjects.HRPortalPage;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;

public class HRPortalResidualFormsVisibility extends ReusableLibrary {
	ReadData rd = new ReadData();

	@Test(dataProvider = "data", priority = 1)
	public void hrPortalResidualFormsValidation(Map<Object, Object> data)
			throws InterruptedException, IOException, InvalidCredentialException {
		LoginPage loginPage = new LoginPage(driver);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		HRPortalPage hrPortalPage = new HRPortalPage(driver);

		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		knowledgeCreation.loginValidate();

		String form = (String) data.get("Form");
		System.out.println("HR Portal " + hrPortalURL);
		driver.navigate().to(hrPortalURL);

		test.get().log(Status.PASS, MarkupHelper.createLabel("Successfully Navigated to HR Portal", ExtentColor.GREEN));
		System.out.println("Successfully Navigated to HR Portal");
		hrPortalPage.residualsSearch_form(form);
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("HR Portal");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("TestCaseFor=HRPortalResidualFormsVisibility")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}
}

/*
 * @DataProvider(name = "data") public Object[][] getData() throws IOException {
 * Object[][] excelData = rd.readDataForHRServiceCatalog(); Object[][]
 * testCaseData = new Object[1][1]; for (int i = 0; i < excelData.length; i++) {
 * if (excelData[i][0].toString().contains("Knowledge Article Creation")) {
 * testCaseData[0][0] = excelData[i][0]; } } return testCaseData;
 */
