/**
 * This class Contains The Check Request Page Landing The Payment Types
 * @author AshokReddy
 *
 */
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

public class CheckRequestPaymentTypeValidation extends ReusableLibrary {
	ReadData rd = new ReadData();
	@Test(dataProvider = "data", priority = 1)
	public void checkRequest_Form_validation(Map<Object, Object> data) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		String name_change_request_form = "Check Request";

		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		knowledgeCreation.loginValidate();
		driver.navigate().to(hrPortalURL);
		test.get().log(Status.PASS, MarkupHelper.createLabel("Successfully Navigated to HR Portal", ExtentColor.GREEN));
		System.out.println("Successfully Navigated to HR Portal");
		HRPortalPage hpp = PageFactory.initElements(driver, HRPortalPage.class);

		// searching the check request
		hpp.search_form(name_change_request_form);

		// check request page landing validation
		hpp.check_Request_HeaderValidation();

		// Category_Page cp = PageFactory.initElements(driver, Category_Page.class);
		Check_Request_Pages cr = PageFactory.initElements(driver, Check_Request_Pages.class);
		System.out.println("Successfully lanching the check Request page");

		// Read data from excel sheet
		String paymentTypes = (String) data.get("PaymentTypes");
		String terminationDropDown = (String) data.get("TerminationDropDown");
		String types[] = paymentTypes.split(",");
		String terminationTypes[] = terminationDropDown.split(",");
		String inLieuPayDurationDropdown = (String) data.get("In Lieu Pay Duration dropdown");
		String inLieuPayDropdown[] = inLieuPayDurationDropdown.split(",");
		String severanceTypedropdown = (String) data.get("Severance Type");
		String severanceTypeDropdown[] = severanceTypedropdown.split(",");
		String datePast = (String) data.get("DatePast");
		String dateFuture = (String) data.get("DateFuture");

		for (int i = 0; i < types.length; i++) {
			if (types[i].contains("Commission") || types[i].contains("Employee Referral")
					|| types[i].contains("Signing Bonus")) {
				cr.paymentType_Validation_Commission(types[i]);

			} else if (types[i].contains("Final Pay")) {
				cr.paymentType_Validation_Finalpay(types[i], terminationTypes);
			} else if (types[i].contains("In Lieu Notice")) {
				cr.paymentType_Validation_InLieuNotice(types[i], inLieuPayDropdown);
			} else if (types[i].contains("Retro Payment")) {
				cr.paymentType_Validation_RetroPayment(types[i], datePast, dateFuture);
			} else if (types[i].contains("Severance Pay")) {
				cr.paymentType_Validation_SeverancePay(types[i], severanceTypeDropdown);
			} else if (types[i].contains("Unused Time Off")) {
				cr.paymentType_Validation_UnusedTimeOff(types[i]);
			} else {
				System.out.println("Not Match Payment Types");
			}

		}

		// cp.displaycaseID();
		// hpp.Portal_case_form_validation();

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
