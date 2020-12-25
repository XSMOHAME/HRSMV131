package com.snow.testscripts.KnowledgeBase;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.snow.base.ReadData;
import com.snow.base.ReusableLibrary;
import com.snow.pageobjects.HRPortalPage;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;

/* The Class is to Retire Knowledge Article */
public class KB_RetireKnowledgeArticle extends ReusableLibrary {
	ReadData rd = new ReadData();
	String kbID;

	/* The Test is to Retire Knowledge Article */
	@Test(dataProvider = "data", dependsOnGroups = "ApproveEditedArticle", groups = "RetireKnowledgeArticle", priority = 6)
	public void retireKnowledgeArticle(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		HRPortalPage hrPortal = new HRPortalPage(driver);
		KB_CreatingKnowledgeArticleAndSubmittingForApproval kbArticle = new KB_CreatingKnowledgeArticleAndSubmittingForApproval();

		System.out.println("**********RETIRE KNOWLEDGE ARTICLE**********");
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Test for Retiring Knowledge Article**", ExtentColor.ORANGE));

		// Login to the application and validate the login
		loginPage.snowLogin(kbGovernanceUser, kbGovernancePassword);
		checkForPageLoad(driver);
		knowledgeCreation.loginValidate();

		// Retiring the Knowledge Article
		String suite = getSuiteName();
		String identifierVariable = kbArticle.getClassName().trim() + "-" + getTemperoryExecuteOn() + "-"
				+ getTemperoryOS() + "-" + getTemperorybrowser();
		kbID = getFromDataLib(rd, suite, identifierVariable);
		knowledgeCreation.retireKnowledgeArticle(kbID);
		// knowledgeCreation.retireKnowledgeArticle("KB0010457");

		// Validating Knowledge Article is Retired or Not
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Validating Retired Knowledge Article**", ExtentColor.ORANGE));
		driver.get(homePageURL);
		knowledgeCreation.validateRetireKnowledgeArticle(kbID);
		// knowledgeCreation.validateRetireKnowledgeArticle("KB0010457");

		// View Published Knowledge Article in HR Fulfiller View
		test.get().log(Status.INFO, MarkupHelper
				.createLabel("**Test for View Published Knowledge Article in HR Fulfiller View**", ExtentColor.ORANGE));
		driver.get(homePageURL);
		knowledgeCreation.viewRetiredArticleKB(kbID);
		// knowledgeCreation.viewRetiredArticleKB("KB0010457");

		// View Published Knowledge Article in HR Portal
		test.get().log(Status.INFO, MarkupHelper
				.createLabel("**Test for View Published Knowledge Article in HR Portal**", ExtentColor.ORANGE));
		driver.navigate().to(hrPortalURL);
		checkForPageLoad(driver);
		hrPortal.hrPortalNavigateValidate();
		hrPortal.searchForRetiredArticle(kbID);
		// hrPortal.searchForRetiredArticle("KB0010457");

		System.out.println("**********RETIRE KNOWLEDGE ARTICLE**********");
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("HR Knowledge Base");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("Knowledge Article Retire")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}
}