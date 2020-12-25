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
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;
import com.snow.pageobjects.WBSFFormRejectionandBypass;

public class WBSFFormRejectionBypass extends ReusableLibrary {
	ReadData rd = new ReadData();

	@Test(dataProvider = "data")
	public void wbsf_Form_validation(Map<Object, Object> data) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		WBSFFormRejectionandBypass asf1 = PageFactory.initElements(driver, WBSFFormRejectionandBypass.class);

		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		knowledgeCreation.loginValidate();
		driver.navigate().to(hrPortalURL);
		checkForPageLoad(driver);
		test.get().log(Status.INFO, MarkupHelper.createLabel("Successfully Navigated to HR Portal", ExtentColor.CYAN));
		System.out.println("Successfully Navigated to HR Portal");

		// read data from excel start here
		// String Startdate = (String) data.get("startdate");
		String name = (String) data.get("name");
		String reason = (String) data.get("reason");
		String title = (String) data.get("title");
		String alternatecostcenter = (String) data.get("Alternate Cost Center");
		String wbsfemployee = (String) data.get("wbsf employee");
		String time = (String) data.get("Hours");
		String bldgno = (String) data.get("Building and room no");
		String duties = (String) data.get("Daily job duties");
		String employee = (String) data.get("employee");
		String costcenter = (String) data.get("costcenter");
		// String approvers = (String) data.get("approvers");
		// Reading data from excel end here

		String url = "";
		String casenumber = "";

		asf1.search_wbsf();
		asf1.open_wbsf_request_form();
		asf1.validate_employee_information(employee);
		asf1.validate_Assignment_Information_section(wbsfemployee);
		asf1.validate_alternate_cost_center_dropdown(alternatecostcenter);
		asf1.validate_field();
		asf1.validate_request_type();
		asf1.validate_person_name_replaced_field(name);
		asf1.validate_reason_for_replacement_dropdown1();
		asf1.validate_reason_for_replacement_dropdown2();
		asf1.validate_reason_for_replacement_dropdown3();
		asf1.validate_other_reason_for_replacement_field(reason);
		asf1.validate_title_of_the_person_field(title);
		asf1.validate_startdate();
		asf1.validate_enddate1();
		asf1.validate_hours(time);
		asf1.validate_building_roomno_field(bldgno);
		asf1.validating_default_skills();
		asf1.validating_profecency_rating();
		asf1.validate_describe_job_duites(duties);
		asf1.validate_approver_information1(costcenter);
		casenumber = asf1.validate_submit_button();
		url = asf1.verifyHRTikcetPage();

		// url =
		// "https://wbpreview.service-now.com/hr_portal?id=hrj_ticket_page&sys_id=a8aec798dbd71890ef1c138b4b9619df&table=sn_hr_core_case_workforce_admin";
		// casenumber = "HRC0054220";
		logInfo("Ticket URL: " + url);
		asf1.rejectCase(casenumber, url);

	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("wbsftemprequestform");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("wbsf form rejection bypass")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}

}
