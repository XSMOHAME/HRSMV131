package com.snow.testscripts.KnowledgeBase;

import java.awt.AWTException;
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
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;

/*
 * This class is to validate the Required Fields on the Create Knowledge Article
 * Page
 */
public class KB_ArticleFieldValidation extends ReusableLibrary {

	ReadData rd = new ReadData();

	@Test(dataProvider = "data", priority = 0)
	public void articleFieldValidation(Map<Object, Object> data)
			throws AWTException, InterruptedException, IOException, InvalidCredentialException {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		System.out.println("**********KNOWLEDGE ARTICLE FIELD VALIDATION**********");
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Test for Creating Knowledge Article**", ExtentColor.ORANGE));

		// Login to the application and validate the login
		loginPage.snowLogin(kbGovernanceUser, kbGovernancePassword);
		checkForPageLoad(driver);
		knowledgeCreation.loginValidate();

		// Reading data From the Excel
		String shortDesc = (String) data.get("ShortDescription");
		String readPermission = (String) data.get("CanRead");
		String articleBody = (String) data.get("ArticleBody");
		String category = (String) data.get("Category");
		String actualErr = knowledgeCreation.kbArticleFieldValidation("Create New Article", category, readPermission,
				shortDesc, articleBody);

		// Validating the Error if Mandatory values are kept blank.
		int emptyCount = 0;
		StringBuffer expectedErr = new StringBuffer("The following mandatory fields are not filled in: ");
		if (shortDesc.isEmpty()) {
			emptyCount++;
			expectedErr.append("Short description");
		}
		if (readPermission.isEmpty()) {
			if (emptyCount > 0) {
				expectedErr.append(", ");
			}
			emptyCount++;
			expectedErr.append("Can Read");
		}
		if (articleBody.isEmpty()) {
			if (emptyCount > 0) {
				expectedErr.append(", ");
			}
			emptyCount++;
			expectedErr.append("Article body");
		}
		if (category.isEmpty()) {
			if (emptyCount > 0) {
				expectedErr.append(", ");
			}
			emptyCount++;
			expectedErr.append("Category");
		}

		System.out.println("Actual Error - " + actualErr);
		System.out.println("Expected Error - " + expectedErr);

		// Assert.assertEquals(actualErr, expectedErr.toString());

		if (actualErr.trim().contains(expectedErr.toString().trim())) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Expected Error message is displayed", ExtentColor.GREEN));
			logSuccess("Actual Error Message - " + actualErr);
			logSuccess("Expected Error Message - " + expectedErr.toString());
			System.out.println("Expected Error message is displayed");
			System.out.println("Actual Error Message - " + actualErr.split("Error Message")[1]);
			System.out.println("Expected Error Message - " + expectedErr.toString());
			test.get().log(Status.INFO, MarkupHelper.createLabel("Article is not submitted", ExtentColor.CYAN));
			test.get().log(Status.PASS, MarkupHelper
					.createLabel("Mandatory Field Validation for Create Article Completed", ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Displayed Error message varies with the Expected", ExtentColor.RED));
			logFailure("Actual Error Message - " + actualErr.split("Error Message")[0]);
			logFailure("Expected Error Message - " + expectedErr.toString());
			System.out.println("Displayed Error message varies with the Expected****");
			System.out.println("Actual Error Message - " + actualErr.split("Error Message")[0]);
			System.out.println("Expected Error Message - " + expectedErr.toString());
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Mandatory Field Validation for Create Article Failed", ExtentColor.RED));
			logFailureScreenshot(driver);
		}

		System.out.println("**********KNOWLEDGE ARTICLE FIELD VALIDATION**********");

	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("HR Knowledge Base");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("Knowledge Article Field Validation")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}
}