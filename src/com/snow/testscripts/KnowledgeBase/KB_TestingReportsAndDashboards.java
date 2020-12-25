package com.snow.testscripts.KnowledgeBase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.snow.base.ReadData;
import com.snow.base.ReusableLibrary;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;

public class KB_TestingReportsAndDashboards extends ReusableLibrary {

	ReadData rd = new ReadData();

	@Test(dataProvider = "data", priority = 8, dependsOnGroups = "KB_TestingArticleSuggestion")
	public void testingReportsAndDashboards(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		System.out.println("**********Test for validating Reports And Dashboards**********");
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Test for validating Reports And Dashboards**", ExtentColor.ORANGE));

		// Login to the application and validate the login
		loginPage.snowLogin(kbSmeUser, kbSmePassword);
		checkForPageLoad(driver);
		knowledgeCreation.loginValidate();

		String widget = (String) data.get("Widgets");
		List<String> expectedWidgets = new ArrayList<String>();
		String[] strings = widget.split(",");
		for (int i = 0; i < strings.length; i++) {
			expectedWidgets.add(strings[i]);
		}
		knowledgeCreation.navigateToHrDashboard();
		knowledgeCreation.validateHRKnowledgeDashbord(expectedWidgets);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Validating My Article Near Expiration Widget**", ExtentColor.ORANGE));
		int articleNearExpiration = knowledgeCreation.validationForNearExpirationArticle();
		knowledgeCreation.validateExpirationDate(articleNearExpiration);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Changing the Column Order in the List View**", ExtentColor.ORANGE));
		List<String> list = knowledgeCreation.changeColumnOrder();

		driver.get(homePageURL);
		checkForPageLoad(driver);
		knowledgeCreation.navigateToHrDashboard();
		test.get().log(Status.INFO, MarkupHelper
				.createLabel("**Verify the Column Order in the List View for other Widget**", ExtentColor.ORANGE));
		knowledgeCreation.validationForMyPublishedArticle(list);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Reseting the Column Order in the List View**", ExtentColor.ORANGE));
		knowledgeCreation.changeColumnOrder();

		System.out.println("**********Test for validating Reports And Dashboards**********");
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("HR Knowledge Base");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("Testing of Dashboards")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}
}