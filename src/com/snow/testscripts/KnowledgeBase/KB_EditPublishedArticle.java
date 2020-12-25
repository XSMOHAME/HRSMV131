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

/* The Class is to Edit Published Knowledge Article and Submitting for Approval */
public class KB_EditPublishedArticle extends ReusableLibrary {
	ReadData rd = new ReadData();
	public double minorVersion = 1.0;
	String kbID;

	/*
	 * This test is to Edit Published Knowledge Article and submitting for Approval
	 */
	@Test(dataProvider = "data", priority = 4, dependsOnGroups = "ViewPublishedArticle")
	public void editPublishedArticle(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		KB_CreatingKnowledgeArticleAndSubmittingForApproval kbArticle = new KB_CreatingKnowledgeArticleAndSubmittingForApproval();

		System.out.println("**********EDIT PUBLISHED KNOWLEDGE ARTICLE**********");
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Test for Editing Published Knowledge Article**", ExtentColor.ORANGE));

		// Login to the application and validate the login
		loginPage.snowLogin(kbSmeUser, kbSmePassword);
		checkForPageLoad(driver);
		knowledgeCreation.loginValidate();

		// Editing the Published Knowledge Article
		String suite = getSuiteName();
		String identifierVariable = kbArticle.getClassName().trim() + "-" + getTemperoryExecuteOn() + "-"
				+ getTemperoryOS() + "-" + getTemperorybrowser();
		kbID = getFromDataLib(rd, suite, identifierVariable);
		knowledgeCreation.updateKnowledgeArticle(kbID, minorVersion);
		// knowledgeCreation.updateKnowledgeArticle("KB0010378", minorVersion);

		System.out.println("**********EDIT PUBLISHED KNOWLEDGE ARTICLE**********");
	}

	/* This test is to Approve Edited Published Knowledge Article */
	@Test(dataProvider = "data", priority = 4, dependsOnMethods = "editPublishedArticle", groups = "ApproveEditedArticle")
	public void approveEditedArticle(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		KB_CreatingKnowledgeArticleAndSubmittingForApproval kbArticle = new KB_CreatingKnowledgeArticleAndSubmittingForApproval();

		System.out.println("**********APPROVE EDITED KNOWLEDGE ARTICLE**********");
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Test for Approving Edited Knowledge Article**", ExtentColor.ORANGE));
		String govUser;

		// Login to the application and validate the login
		loginPage.snowLogin(kbGovernanceUser, kbGovernancePassword);
		checkForPageLoad(driver);
		govUser = knowledgeCreation.loginValidate();

		// Approving the edited Knowledge Article
		minorVersion = minorVersion + 1.0;
		String suite = getSuiteName();
		String identifierVariable = kbArticle.getClassName().trim() + "-" + getTemperoryExecuteOn() + "-"
				+ getTemperoryOS() + "-" + getTemperorybrowser();
		kbID = getFromDataLib(rd, suite, identifierVariable);
		knowledgeCreation.approveKnowledgeArticle(kbID, govUser, minorVersion);
		// knowledgeCreation.approveKnowledgeArticle("KB0010378", govUser,
		// minorVersion);
		System.out.println("**********APPROVE EDITED KNOWLEDGE ARTICLE**********");
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