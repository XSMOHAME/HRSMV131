package com.snow.testscripts.WBSFTempRequestForm;

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
import com.snow.pageobjects.AccessingandSubmittingtheForm1;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;

public class AccessingandSubmittingForm1 extends ReusableLibrary {

	ReadData rd = new ReadData();

	@Test(dataProvider = "data")
	public void wbsf_Form_validation(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		System.out.println("HR Portal " + hrPortalURL);
		checkForPageLoad(driver);
		knowledgeCreation.loginValidate();
		driver.navigate().to(hrPortalURL);
		checkForPageLoad(driver);
		test.get().log(Status.INFO, MarkupHelper.createLabel("Successfully Navigated to HR Portal.", ExtentColor.CYAN));
		System.out.printf("\nSuccessfully Navigated to HR Portal !!!");

		AccessingandSubmittingtheForm1 asf1 = PageFactory.initElements(driver, AccessingandSubmittingtheForm1.class);
		// read data from excel
		String inactiveusers = (String) data.get("Inactive users");
		String nonwbsfusers = (String) data.get("Non wbsf user");
		String nonsupervisors = (String) data.get("Non supervisors");
		String costcenter = (String) data.get("Alternate Cost Center");
		String name = (String) data.get("name");
		String reason = (String) data.get("reason");
		String title = (String) data.get("title");
		String wbsfemployee = (String) data.get("wbsf employee");
		String wbsfemployee1 = (String) data.get("wbsf employee1");
		String employee = (String) data.get("employee");
		// Reading data from excel end here
		
		asf1.search_wbsf();
		asf1.open_wbsf_request_form();
		asf1.validate_inactive_users(inactiveusers);
		asf1.validate_nonwbsf_users(nonwbsfusers);
		asf1.validate_nonsupervisors_users(nonsupervisors);
		asf1.validate_employee_information(employee);
		asf1.validate_Supervisors_and_above_WBSF_employees_are_in_the_dropdown_or_not(wbsfemployee);
		asf1.validate_Assignment_Information_section(wbsfemployee1);
		asf1.validate_alternate_cost_center_dropdown(costcenter);
		asf1.validate_field();
		asf1.validate_request_type();
		asf1.validate_person_name_replaced_field(name);
		asf1.validate_reason_for_replacement_dropdown1();
		asf1.validate_reason_for_replacement_dropdown2();
		asf1.validate_reason_for_replacement_dropdown3();
		asf1.validate_other_reason_for_replacement_field(reason);
		asf1.validate_title_of_the_person_field(title);
		asf1.validate_startdate();
		asf1.validate_enddate();
		asf1.validate_EndDate_prior_to_the_startdate();
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("wbsftemprequestform");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("Accessing and submitting form1")) {
				testCaseData[0][0] = excelData[i][0];

			}
		}
		return testCaseData;
	}
}