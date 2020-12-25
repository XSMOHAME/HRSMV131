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

/* The Class is to Reject, Review and Approve Created Knowledge Article */
public class KB_RejectReviewApproveArticle extends ReusableLibrary {
	ReadData rd = new ReadData();
	public String govUser;
	public double minorVersion = 1.0;
	String kbID;

	/* This Test is to Reject Knowledge Article */
	@Test(dataProvider = "data", priority = 2, dependsOnGroups = "CreateKnowledgeArticle")
	public void rejectArticle(Map<Object, Object> data) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		KB_CreatingKnowledgeArticleAndSubmittingForApproval kbArticle = new KB_CreatingKnowledgeArticleAndSubmittingForApproval();

		// HRPortalPage hrPortal = new HRPortalPage(driver);
		System.out.println("**********REJECT KNOWLEDGE ARTICLE**********");
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Test for Rejecting Knowledge Article**", ExtentColor.ORANGE));

		// Login to the application and validate the login
		loginPage.snowLogin(kbGovernanceUser, kbGovernancePassword);
		checkForPageLoad(driver);
		govUser = knowledgeCreation.loginValidate();

		String suite = getSuiteName();
		String identifierVariable = kbArticle.getClassName().trim() + "-" + getTemperoryExecuteOn() + "-"
				+ getTemperoryOS() + "-" + getTemperorybrowser();
		kbID = getFromDataLib(rd, suite, identifierVariable);

		// Rejecting Knowledge Article
		knowledgeCreation.rejectArticle(kbID, govUser);
		// knowledgeCreation.rejectArticle("KB0010377", govUser);

		System.out.println("**********REJECT KNOWLEDGE ARTICLE**********");
	}

	/* This Test is to Review Knowledge Article */
	@Test(dataProvider = "data", priority = 2, dependsOnMethods = "rejectArticle")
	public void reviewArticle(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		KB_CreatingKnowledgeArticleAndSubmittingForApproval kbArticle = new KB_CreatingKnowledgeArticleAndSubmittingForApproval();

		// HRPortalPage hrPortal = new HRPortalPage(driver);
		System.out.println("**********REVIEW CREATED KNOWLEDGE ARTICLE**********");
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Test for Reviewing Knowledge Article**", ExtentColor.ORANGE));

		// Login to the application and validate the login
		loginPage.snowLogin(kbSmeUser, kbSmePassword);
		checkForPageLoad(driver);
		knowledgeCreation.loginValidate();

		String suite = getSuiteName();
		String identifierVariable = kbArticle.getClassName().trim() + "-" + getTemperoryExecuteOn() + "-"
				+ getTemperoryOS() + "-" + getTemperorybrowser();
		kbID = getFromDataLib(rd, suite, identifierVariable);

		// Reviewing Knowledge Article
		knowledgeCreation.reviewKnowledgeArticle(kbID, govUser);
		// knowledgeCreation.reviewKnowledgeArticle("KB0010377", "Approval_KB
		// GOVERNANCE_User");
		System.out.println("**********REVIEW CREATED KNOWLEDGE ARTICLE**********");
	}

	/* This Test is to Approve Knowledge Article */
	@Test(dataProvider = "data", priority = 2, dependsOnMethods = "reviewArticle", groups = "ApproveArticle")
	public void approveArticle(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		KB_CreatingKnowledgeArticleAndSubmittingForApproval kbArticle = new KB_CreatingKnowledgeArticleAndSubmittingForApproval();

		// HRPortalPage hrPortal = new HRPortalPage(driver);
		System.out.println("**********APPROVE CREATED KNOWLEDGE ARTICLE**********");
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Test for Approving Knowledge Article**", ExtentColor.ORANGE));

		// Login to the application and validate the login
		loginPage.snowLogin(kbGovernanceUser, kbGovernancePassword);
		checkForPageLoad(driver);
		govUser = knowledgeCreation.loginValidate();

		// Approving Knowledge Article
		String suite = getSuiteName();
		String identifierVariable = kbArticle.getClassName().trim() + "-" + getTemperoryExecuteOn() + "-"
				+ getTemperoryOS() + "-" + getTemperorybrowser();
		kbID = getFromDataLib(rd, suite, identifierVariable);
		knowledgeCreation.approveKnowledgeArticle(kbID, govUser, minorVersion);

		// knowledgeCreation.approveKnowledgeArticle("KB0010378", govUser,
		// minorVersion);
		System.out.println("**********APPROVE CREATED KNOWLEDGE ARTICLE**********");
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