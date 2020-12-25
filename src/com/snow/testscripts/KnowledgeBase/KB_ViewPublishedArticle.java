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

public class KB_ViewPublishedArticle extends ReusableLibrary {
	ReadData rd = new ReadData();
	String kbID;

	/*
	 * The Class is to View Published Knowledge Article in HR Fulfiller View and HR
	 * Portal View
	 */
	@Test(dataProvider = "data", priority = 3,dependsOnGroups = "ApproveArticle", groups = "ViewPublishedArticle")
	public void viewPublishedArticle(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		HRPortalPage hrPortal = new HRPortalPage(driver);
		KB_CreatingKnowledgeArticleAndSubmittingForApproval kbArticle = new KB_CreatingKnowledgeArticleAndSubmittingForApproval();

		System.out.println("**********View Published KNOWLEDGE ARTICLE in HR Fulfiller View**********");
		test.get().log(Status.INFO, MarkupHelper
				.createLabel("**Test for View Published Knowledge Article in HR Fulfiller View**", ExtentColor.ORANGE));

		// Login to the application and validate the login
		loginPage.snowLogin(kbGovernanceUser, kbGovernancePassword);
		checkForPageLoad(driver);
		knowledgeCreation.loginValidate();

		// View Published KNOWLEDGE ARTICLE in HR Fulfiller View
		String suite = getSuiteName();
		String identifierVariable = kbArticle.getClassName().trim() + "-" + getTemperoryExecuteOn() + "-"
				+ getTemperoryOS() + "-" + getTemperorybrowser();
		kbID = getFromDataLib(rd, suite, identifierVariable);
		knowledgeCreation.viewPublishedArticleKB(kbID);
		// knowledgeCreation.viewPublishedArticleKB("KB0010279");
		System.out.println("**********View Published KNOWLEDGE ARTICLE in HR Fulfiller View**********");

		// View Published KNOWLEDGE ARTICLE in HR Portal View
		System.out.println("**********View Published KNOWLEDGE ARTICLE in HR Portal View**********");
		test.get().log(Status.INFO, MarkupHelper
				.createLabel("**Test for View Published Knowledge Article in HR Portal**", ExtentColor.ORANGE));
		System.out.println("HR Portal - " + hrPortalURL);
		driver.navigate().to(hrPortalURL);
		hrPortal.hrPortalNavigateValidate();
		hrPortal.searchForArticle(kbID);
		// hrPortal.searchForArticle("KB0010279");
		System.out.println("**********View Published KNOWLEDGE ARTICLE in HR Portal View**********");
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("HR Knowledge Base");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("Knowledge Article Creation")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}
}