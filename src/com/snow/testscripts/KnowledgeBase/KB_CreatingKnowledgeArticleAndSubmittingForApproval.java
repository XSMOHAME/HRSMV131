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

/* The Class is to Create New Knowledge Article and Submitting for Approval */
public class KB_CreatingKnowledgeArticleAndSubmittingForApproval extends ReusableLibrary {
	ReadData rd = new ReadData();
	public String smeUser;
	public String kbID;
	public double minorVersion = 0.02;

	public String getClassName() {
		return this.getClass().getSimpleName();
	}

	@Test(dataProvider = "data", groups = "CreateKnowledgeArticle", priority = 1)
	public void createKnowledgeArticle(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		System.out.println("**********CREATE KNOWLEDGE ARTICLE**********");
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Test for Creating Knowledge Article**", ExtentColor.ORANGE));

		// Login to the application and validate the login
		loginPage.snowLogin(kbSmeUser, kbSmePassword);
		checkForPageLoad(driver);
		smeUser = knowledgeCreation.loginValidate().split(" User")[0];
		System.out.println("Logged in as user - " + smeUser);

		// Reading data From the Excel
		String shortDesc = (String) data.get("ShortDescription");
		String readPermission = (String) data.get("CanRead");
		String articleBody = (String) data.get("ArticleBody");
		String category = (String) data.get("Category");
		// String validTo = (String) data.get("ValidTo");
		System.out.println("Short Description - " + shortDesc);
		System.out.println("Can Read - " + readPermission);
		System.out.println("Article Body - " + articleBody);
		System.out.println("Category - " + category);

		// Creating New Knowledge Article
		kbID = knowledgeCreation.createNewArticle("Create New Article", category, readPermission, shortDesc,
				articleBody, smeUser);
		knowledgeCreation.sendForApproval(kbID, minorVersion);
		System.out.println("**********CREATE KNOWLEDGE ARTICLE**********");

		String identifierVariable = this.getClass().getSimpleName() + "-" + getTemperoryExecuteOn() + "-"
				+ getTemperoryOS() + "-" + getTemperorybrowser();
		rd.updateDataLibrary(getSuiteName(), identifierVariable, kbID.trim());
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