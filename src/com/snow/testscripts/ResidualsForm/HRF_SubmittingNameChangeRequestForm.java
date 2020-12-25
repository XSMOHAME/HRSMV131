package com.snow.testscripts.ResidualsForm;

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
import com.snow.pageobjects.ResidualsFormPage;

public class HRF_SubmittingNameChangeRequestForm extends ReusableLibrary {
	ReadData rd = new ReadData();
	public String caseID = null;

	public String getClassName() {
		return this.getClass().getSimpleName();
	}

	@Test(priority = 2, dataProvider = "data", groups = "CreateNameChangeRequestForm")
	public void createNameChangeRequestForm(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		HRPortalPage hrPortalPage = new HRPortalPage(driver);
		ResidualsFormPage residualsFormPage = new ResidualsFormPage(driver);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Test for Submitting Name Change Request**", ExtentColor.ORANGE));

		// Login to the application and validate the login
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		checkForPageLoad(driver);
		knowledgeCreation.loginValidate();

		// Navigation to HR Portal and Validation
		driver.navigate().to(hrPortalURL);
		checkForPageLoad(driver);
		hrPortalPage.hrPortalNavigateValidate();

		// Reading Data from Input excel
		String form = (String) data.get("Form");
		String formShortDesc = (String) data.get("FormShortDesc");
		String testWorker = (String) data.get("TestWorker");
		String inactiveWorker = (String) data.get("InactiveWorker");
		String activeWorker = (String) data.get("ActiveWorker");
		String firstName = (String) data.get("FirstName");
		String lastName = (String) data.get("LastName");

		System.out.println("Form Name from Input Excel - " + form);
		System.out.println("Form Short Description from Input Excel - " + formShortDesc);
		System.out.println("Inactive Worker from Input Excel - " + inactiveWorker);
		System.out.println("Active Worker from Input Excel - " + activeWorker);
		System.out.println("First Name from Input Excel - " + firstName);
		System.out.println("Last Name from Input Excel - " + lastName);

		/*
		 * Searching for Required form, submitting the Request and validating form
		 * submission
		 */
		hrPortalPage.searchForForm("Residuals: Name Change Request");
		residualsFormPage.verifyFormLableAndShortDesc(form, formShortDesc);

		/* Validation for Mandatory Fields */
		test.get().log(Status.INFO,
				MarkupHelper.createLabel(
						"**Identifying Mandatory Fields for the Form by selecting Submit button directly.**",
						ExtentColor.ORANGE));
		residualsFormPage.validateMandatoryFields();

		/* Validation for Worker/Payee Information Section */
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Validating Test employees are searchable**", ExtentColor.ORANGE));
		residualsFormPage.validateTestWorker(testWorker);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Validating Inactive employees are searchable**", ExtentColor.ORANGE));
		residualsFormPage.validateSelectWorker(inactiveWorker);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Validating Active employees are searchable**", ExtentColor.ORANGE));
		residualsFormPage.validateSelectWorker(activeWorker);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Validating HR Profile is displayed on (i) icon**", ExtentColor.ORANGE));
		residualsFormPage.validateHRProfile();

		/* Validation for Name Change Section */
		test.get().log(Status.INFO, MarkupHelper.createLabel("**Validating Name Change Section**", ExtentColor.ORANGE));
		residualsFormPage.validateNameChangeSection(firstName, lastName);

		residualsFormPage.addAttachment();

		/*
		 * Storing the Field Labels and Values in HashMap to Validate Case Details after
		 * Case Creation
		 */
		residualsFormPage.storeFieldValues(form);

		/* Validation for Point of Contact for Request Section */
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Validating Point of Contact for Request Section**", ExtentColor.ORANGE));
		residualsFormPage.validatePOCforRequest();

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Validating Submission of Form and Ticket Page**", ExtentColor.ORANGE));
		caseID = residualsFormPage.validateCaseCreation(activeWorker);

		test.get().log(Status.INFO, MarkupHelper
				.createLabel("**Validating Case Description for expected fields and values**", ExtentColor.ORANGE));
		residualsFormPage.validateCaseDescription(form);

		System.out.println("**********Submitting Name Change Request Form**********");

		String identifierVariable = this.getClass().getSimpleName() + "-" + getTemperoryExecuteOn() + "-"
				+ getTemperoryOS() + "-" + getTemperorybrowser();
		rd.updateDataLibrary(getSuiteName(), identifierVariable, caseID);
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("HR Residuals Forms");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("TestCaseFor=Residuals: Name Change Request")) {
				testCaseData[0][0] = excelData[i][0];
			}

		}
		return testCaseData;
	}
}