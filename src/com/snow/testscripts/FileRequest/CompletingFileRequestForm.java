package com.snow.testscripts.FileRequest;

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

public class CompletingFileRequestForm extends ReusableLibrary {
	ReadData rd = new ReadData();
	public String fileRequesCaseId;

	public String getClassName() {
		return this.getClass().getSimpleName();
	}

	@Test(dataProvider = "data", groups = "completingFileRequestForm")
	
	public void completingFileRequestForm(Map<Object, Object> data) throws Exception {
		
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		HRPortalPage hrPortalPage = new HRPortalPage(driver);
		ResidualsFormPage residualsFormPage = new ResidualsFormPage(driver);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Test for COMPLETING THE FILE REQUEST FORM**", ExtentColor.ORANGE));

		// Login to the application and validate the login
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		knowledgeCreation.loginValidate();

		// Navigation to HR Portal and Validation
		driver.navigate().to(hrPortalURL);
		hrPortalPage.hrPortalNavigateValidate();

		// Reading Data from Input excel
		String form = (String) data.get("Form");
		String formShortDesc = (String) data.get("FormShortDesc");
		String activeWorker = (String) data.get("ActiveWorker");
		String documentType = (String) data.get("DocumentType");
		String requestType = (String) data.get("RequestType");
		String deliveryMethod = (String) data.get("DeliveryMethod");
		String billToMyCourierAccount = (String) data.get("BillToMyCourierAccount");
		String deliveryAddress = (String) data.get("DeliveryAddress");
		String alternateContact = (String) data.get("AlternateContact");

		/*
		 * Searching for Required form, submitting the Request and validating form
		 * submission
		 */
		hrPortalPage.searchForForm(form);
		residualsFormPage.verifyFormLableAndShortDesc(form, formShortDesc);
		test.get().log(Status.INFO,
				MarkupHelper.createLabel("**Validating Select Worker from File Request Page**", ExtentColor.ORANGE));
		residualsFormPage.submitButtonInputs(activeWorker, documentType);
		residualsFormPage.requestTypeElectronicCopy(requestType, deliveryMethod);
		residualsFormPage.fileDeliveryInformation(requestType, deliveryMethod, billToMyCourierAccount, deliveryAddress);
		fileRequesCaseId = residualsFormPage.pointofContactRequest(alternateContact);

		String identifierVariable = this.getClass().getSimpleName() + "-" + getTemperoryExecuteOn() + "-"
				+ getTemperoryOS() + "-" + getTemperorybrowser();
		rd.updateDataLibrary(getSuiteName(), identifierVariable, fileRequesCaseId);
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("File Request");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("Employee File Request")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}

}