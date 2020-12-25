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
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;

/*The Class is to Test Knowledge Article Suggestion*/

public class KB_TestingArticleSuggestion extends ReusableLibrary {

	String kbID;
	ReadData rd = new ReadData();
	public double minorVersionCreate = 0.02;
	public double minorVersionApprove = 1.0;

	@Test(dataProvider = "data", priority = 7, groups = "KB_TestingArticleSuggestion")
	public void createKnowledgeArticleForSuggestion(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);

		System.out.println("TEST KNOWLEDGE ARTICLE SUGGESTION");
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("Test for validating Knowledge Article Suggestion", ExtentColor.ORANGE));
		String smeUser = null;

		// Login to the application and validate the login
		loginPage.snowLogin(kbSmeUser, kbSmePassword);
		checkForPageLoad(driver);
		smeUser = knowledgeCreation.loginValidate();

		// Reading data From the Excel
		String shortDesc = (String) data.get("ShortDescription");
		String readPermission = (String) data.get("CanRead");
		String articleBody = (String) data.get("ArticleBody");
		String category = (String) data.get("Category");
		// String validTo = (String) data.get("ValidTo");

		// Creating New Knowledge Article kbID =
		kbID = knowledgeCreation.createNewArticle("Create New Article", category, readPermission, shortDesc,
				articleBody, smeUser);
		knowledgeCreation.sendForApproval(kbID, minorVersionCreate);
		System.out.println("TEST KNOWLEDGE ARTICLE SUGGESTION");
	}

	// This Test is to Approve Knowledge Article
	@Test(dataProvider = "data", priority = 7, dependsOnMethods = "createKnowledgeArticleForSuggestion", groups = "KB_TestingArticleSuggestion")
	public void approveArticleForSuggestion(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		System.out.println("APPROVE CREATED KNOWLEDGE ARTICLE");
		test.get().log(Status.INFO, MarkupHelper.createLabel("Approving Knowledge Article", ExtentColor.ORANGE));
		String govUser = null;
		// Login to the application and validate the login
		loginPage.snowLogin(kbGovernanceUser, kbGovernancePassword);
		checkForPageLoad(driver);
		govUser = knowledgeCreation.loginValidate();

		// Approving Knowledge Article
		knowledgeCreation.approveKnowledgeArticle(kbID, govUser, minorVersionApprove);
		System.out.println("APPROVE CREATED KNOWLEDGE ARTICLE");
	}

	@Test(dataProvider = "data", priority = 7, groups = "KB_TestingArticleSuggestion", dependsOnMethods = "approveArticleForSuggestion")
	public void articleForSuggestionViewAsSME(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		System.out.println("View Feedback added to the Knowledge Article as SME USER");
		test.get().log(Status.INFO, MarkupHelper.createLabel("View Feedback added to the Knowledge Article as SME USER",
				ExtentColor.ORANGE));
		// Login to the application and validate the login
		loginPage.snowLogin(kbSmeUser, kbSmePassword);
		checkForPageLoad(driver);
		knowledgeCreation.loginValidate();

		// View Feedback added to KNOWLEDGE ARTICLE
		knowledgeCreation.viewPublishedArticleKB(kbID);
		// knowledgeCreation.viewPublishedArticleKB("KB0010414");

		System.out.println("View Feedback added to the Knowledge Article as SME USER");
		knowledgeCreation.enterArticleSuggestion();
		driver.get(homePageURL);
		knowledgeCreation.verifySuggestionSME(kbID);
		// knowledgeCreation.verifySuggestionSME("KB0010414");
	}

	@Test(dataProvider = "data", priority = 7, dependsOnMethods = "articleForSuggestionViewAsSME", groups = "KB_TestingArticleSuggestion")
	public void articleForSuggestionViewAsGOV(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		test.get().log(Status.INFO, MarkupHelper
				.createLabel("View Feedback added to the Knowledge Article as GOVERNENCE USER", ExtentColor.ORANGE));
		// String govUser = null;
		// Login to the application and validate the login
		loginPage.snowLogin(kbGovernanceUser, kbGovernancePassword);
		checkForPageLoad(driver);
		knowledgeCreation.loginValidate();

		knowledgeCreation.verifySuggestionGov(kbID);
		// knowledgeCreation.verifySuggestionGov("KB0010276");

	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("HR Knowledge Base");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("Testing Article Suggestion")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}
}