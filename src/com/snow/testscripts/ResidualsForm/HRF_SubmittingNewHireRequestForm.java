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

public class HRF_SubmittingNewHireRequestForm extends ReusableLibrary {
	ReadData rd = new ReadData();
	public String caseID = null;

	public String getClassName() {
		return this.getClass().getSimpleName();
	}

	@Test(priority = 3, dataProvider = "data", groups = "CreateNewHireRequestForm")
	public void createNewHireRequestForm(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		HRPortalPage hrPortalPage = new HRPortalPage(driver);
		ResidualsFormPage residualsFormPage = new ResidualsFormPage(driver);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Test for Submitting New Hire Request**", ExtentColor.ORANGE));

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
		String activeWorker = (String) data.get("ActiveWorker");
		String details = (String) data.get("HireRequestDetails");
		String batchDesc = (String) data.get("HireBatchDescription");
		String noOfHires = (String) data.get("#Hire");
		// String downloadPath = (String) data.get("DownloadPath");

		/*
		 * Searching for Required form, submitting the Request and validating form
		 * submission
		 */
		hrPortalPage.searchForForm("Residuals: New Hire Request");
		residualsFormPage.verifyFormLableAndShortDesc(form, formShortDesc);

		/* Validating Description displayed for New Hire Request */
		test.get().log(Status.INFO, MarkupHelper
				.createLabel("**Validating Description displayed for New Hire Request**", ExtentColor.ORANGE));
		residualsFormPage.validateNewHireDesc(details);

		/* Validation for Mandatory Fields */
		test.get().log(Status.INFO,
				MarkupHelper.createLabel(
						"**Identifying Mandatory Fields for the Form by selecting Submit button directly.**",
						ExtentColor.ORANGE));
		residualsFormPage.validateMandatoryFields();

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Verify successful Template Download.**", ExtentColor.ORANGE));
		// residualsFormPage.validateHireTemplateDownload(downloadPath);

		/* Validation for Attach Hire Template Section */
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Validating Attach Hire Template Section**", ExtentColor.ORANGE));
		residualsFormPage.validateAttachHireTemplateSection(batchDesc, noOfHires);

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

		System.out.println("**********Submitting New Hire Request Form**********");

		String identifierVariable = this.getClass().getSimpleName() + "-" + getTemperoryExecuteOn() + "-"
				+ getTemperoryOS() + "-" + getTemperorybrowser();
		rd.updateDataLibrary(getSuiteName(), identifierVariable, caseID);
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("HR Residuals Forms");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("TestCaseFor=Residuals: New Hire Request")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}
}