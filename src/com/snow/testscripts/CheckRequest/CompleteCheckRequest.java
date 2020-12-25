package com.snow.testscripts.CheckRequest;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.snow.base.ReadData;
import com.snow.base.ReusableLibrary;
import com.snow.pageobjects.Check_Request_Pages;
import com.snow.pageobjects.HRPortalPage;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;

public class CompleteCheckRequest extends ReusableLibrary {
	ReadData rd = new ReadData();
	public String checkRequestCaseId;

	public String getClassName() {
		return this.getClass().getSimpleName();
	}

	@Test(dataProvider = "data", groups = "CompleteCheckRequest", priority = 2)
	public void checkRequest_Form_validation(Map<Object, Object> data) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);

		String name_change_request_form = "Check Request";
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		System.out.println("HR Portal " + hrPortalURL);
		knowledgeCreation.loginValidate();
		driver.get(hrPortalURL);
		test.get().log(Status.PASS, MarkupHelper.createLabel("Successfully Navigated to HR Portal", ExtentColor.GREEN));
		System.out.println("Successfully Navigated to HR Portal");

		HRPortalPage hpp = PageFactory.initElements(driver, HRPortalPage.class);
		// searching the check request
		hpp.search_form(name_change_request_form);
		// check request page landing validation
		hpp.check_Request_HeaderValidation();

		Check_Request_Pages cr = PageFactory.initElements(driver, Check_Request_Pages.class);
		System.out.println("Successfully lanching the check Request page");
		// read the employee name in excel sheet
		String employeeName = (String) data.get("ActiveWorker");
		cr.validateSelectEmployeeActiveWorker(employeeName);

		// read the Payment Type in excel sheet
		String paymentType = (String) data.get("Payment Type");
		String endDate = (String) data.get("Final Pay EndDate");
		String terminationTypedropdown = (String) data.get("TermDropdown");
		cr.enter_Final_Pay(paymentType, endDate, terminationTypedropdown);

		// read Payment Delivery methods in excel sheet
		String paymentDeliveryMethod = (String) data.get("Payment Delivery");
		cr.paymentDeliveryMethods(paymentDeliveryMethod);
		String altPhNumber = (String) data.get("AltNumber");
		cr.pointOfContact(altPhNumber);
		checkRequestCaseId = cr.submitCheckRequest();

		String identifierVariable = this.getClass().getSimpleName() + "-" + getTemperoryExecuteOn() + "-" + getTemperoryOS()
				+ "-" + getTemperorybrowser();
		rd.updateDataLibrary(getSuiteName(), identifierVariable, checkRequestCaseId);
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("Check Request");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("CheckRequest")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}
}