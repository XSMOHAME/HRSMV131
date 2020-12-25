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

public class HRF_SubmittingStopCancelRequestReissue extends ReusableLibrary {
	ReadData rd = new ReadData();
	public String caseID = null;

	public String getClassName() {
		return this.getClass().getSimpleName();
	}

	@Test(priority = 9, dataProvider = "data", groups = "CreateStopCancelRequestReissue")
	public void createStopCancelRequestReissue(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		HRPortalPage hrPortalPage = new HRPortalPage(driver);
		ResidualsFormPage residualsFormPage = new ResidualsFormPage(driver);

		test.get().log(Status.INFO, MarkupHelper.createLabel("**Test for Submitting a STOP/CANCEL REQUEST : Reissue**",
				ExtentColor.ORANGE));

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
		String inactivePayee = (String) data.get("InactiveWorker");
		String activePayee = (String) data.get("ActiveWorker");
		String requestTypes = (String) data.get("RequestTypesDropDown");
		String requestType = (String) data.get("RequestType");
		String reasonDropDown = (String) data.get("ReasonDropDown");
		String reason = (String) data.get("Reason");
		String sapCompanyDropDown = (String) data.get("SAPCompanyDropDown");
		String sapCompany = (String) data.get("SAPCompany");
		String checkNumber = (String) data.get("CheckNumber");
		String netAmount = (String) data.get("NetAmount");
		String sapGlNumber = (String) data.get("SAPGLNumber");
		String additionalComment = (String) data.get("AdditionalComment");

		/*
		 * Searching for Required form, submitting the Request and validating form
		 * submission
		 */
		hrPortalPage.searchForForm("Residuals: Stop/Cancel Payment Request");
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
		residualsFormPage.validateSelectPayee(inactivePayee);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Validating Active employees are searchable**", ExtentColor.ORANGE));
		residualsFormPage.validateSelectPayee(activePayee);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Validating HR Profile is displayed on (i) icon**", ExtentColor.ORANGE));
		residualsFormPage.validateHRProfile();

		/* Validation for Check Information Section */
		String[] requestTypesArray = requestTypes.split(",");
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Validating Check Information Section**", ExtentColor.ORANGE));
		residualsFormPage.validateCheckInfoSection(requestTypesArray, requestType);

		String[] reasonArray = reasonDropDown.split(",");
		residualsFormPage.validateReasonDropDown(reasonArray, reason);

		String[] sapCompanyArray = sapCompanyDropDown.split(",");
		residualsFormPage.validateSAPCompanyDropDown(sapCompanyArray, sapCompany);

		residualsFormPage.verifyCheckInfoFields(requestType, checkNumber, netAmount, sapGlNumber, additionalComment);

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
		caseID = residualsFormPage.validateCaseCreation(activePayee);

		test.get().log(Status.INFO, MarkupHelper
				.createLabel("**Validating Case Description for expected fields and values**", ExtentColor.ORANGE));
		residualsFormPage.validateCaseDescription(form);

		System.out.println("**********Submitting Residuals: Stop/Cancel Request**********");

		String identifierVariable = this.getClass().getSimpleName() + "-" + getTemperoryExecuteOn() + "-"
				+ getTemperoryOS() + "-" + getTemperorybrowser();
		rd.updateDataLibrary(getSuiteName(), identifierVariable, caseID);
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("HR Residuals Forms");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("TestCaseFor=Residuals: Stop/Cancel Request: Reissue")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}
}