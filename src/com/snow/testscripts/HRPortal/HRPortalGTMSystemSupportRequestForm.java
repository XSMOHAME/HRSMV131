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
import com.snow.pageobjects.HRPortalPage;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;
import com.snow.pageobjects.SystemSupportRequestPage;

public class HRPortalGTMSystemSupportRequestForm extends ReusableLibrary {
	ReadData rd = new ReadData();

	@Test(dataProvider = "data", priority = 1)
	public void hrPortalSupportRequestFormValidations(Map<Object, Object> data)
			throws InterruptedException, IOException, InvalidCredentialException {
		LoginPage loginPage = new LoginPage(driver);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		HRPortalPage hrPortalPage = new HRPortalPage(driver);
		SystemSupportRequestPage ssrp = new SystemSupportRequestPage(driver);
		CategoryPage cp = new CategoryPage(driver);

		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		knowledgeCreation.loginValidate();

		System.out.println("HR Portal " + hrPortalURL);
		driver.navigate().to(hrPortalURL);
		test.get().log(Status.PASS, MarkupHelper.createLabel("Successfully Navigated to HR Portal", ExtentColor.GREEN));
		System.out.println("Successfully Navigated to HR Portal");

		String form = (String) data.get("Form");
		String descRequest = (String) data.get("DescribeRequest");
		String hrSystem = (String) data.get("HRSystem");

		hrPortalPage.searchForForm(form);
		ssrp.create_systemsupportrequest(descRequest, hrSystem);
		cp.displaycaseID();
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("HR Portal");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("TestCaseFor=HRPortalGTMSystemSupportRequestForm")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}
}