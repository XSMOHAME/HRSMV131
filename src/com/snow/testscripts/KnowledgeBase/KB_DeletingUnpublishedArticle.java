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

public class KB_DeletingUnpublishedArticle extends ReusableLibrary {
	
	ReadData rd = new ReadData();

	@Test(dataProvider = "data", priority = 5)
	public void deleteUnpublishedKnowledgeArticle(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		System.out.println("**********DELETING UNPUBLISHED KNOWLEDGE ARTICLE**********");
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Test for Deleting Unpublished Knowledge Article**", ExtentColor.ORANGE));
		String smeUser = null;
		String kbID = null;

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

		// Creating New Knowledge Article
		kbID = knowledgeCreation.createNewArticle("Create New Article", category, readPermission, shortDesc,
				articleBody, smeUser);
		knowledgeCreation.deleteUnpublishedArticle(kbID);

		// Validating Knowledge Article is Deleted or Not
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Validating Knowledge Article Delete**", ExtentColor.ORANGE));
		driver.get(homePageURL);
		knowledgeCreation.validateArticleDelete(kbID);

		System.out.println("**********DELETING UNPUBLISHED KNOWLEDGE ARTICLE**********");
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