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
import com.snow.pageobjects.AccessingandSubmittingtheForm2;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;

public class AccessingandSubmittingForm2 extends ReusableLibrary {

	ReadData rd = new ReadData();

	@Test(dataProvider = "data")
	public void wbsf_Form_validation(Map<Object, Object> data) throws Exception {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		knowledgeCreation.loginValidate();
		driver.navigate().to(hrPortalURL);
		checkForPageLoad(driver);
		test.get().log(Status.INFO, MarkupHelper.createLabel("Successfully Navigated to HR Portal", ExtentColor.CYAN));
		System.out.printf("\nSuccessfully Navigated to HR Portal !!!");

		AccessingandSubmittingtheForm2 asf1 = PageFactory.initElements(driver, AccessingandSubmittingtheForm2.class);
		// read data from excel
		String inactiveusers = (String) data.get("Inactive users");
		String nonwbsfusers = (String) data.get("Non wbsf user");
		String nonsupervisors = (String) data.get("Non supervisors");
		String alternatecostcenter = (String) data.get("Alternate Cost Center");
		String name = (String) data.get("name");
		String reason = (String) data.get("reason");
		String title = (String) data.get("title");
		String wbsfemployee = (String) data.get("wbsf employee");
		String time = (String) data.get("Hours");
		String bldgno = (String) data.get("Building and room no");
		String skill = (String) data.get("Skill");
		String skill1 = (String) data.get("skill1");
		String software = (String) data.get("Software section");
		String officesection = (String) data.get("Office Section");
		String finance = (String) data.get("Finance section");
		String system = (String) data.get("System section");
		String software1 = (String) data.get("Software");
		String os = (String) data.get("Operating system");
		String otherskills = (String) data.get("Other skills");
		String duties = (String) data.get("Daily job duties");
		String employee = (String) data.get("employee");
		String costcenter = (String) data.get("costcenter");
		String approvers = (String) data.get("approvers");
		// Reading data from excel end here

		asf1.search_wbsf();
		asf1.open_wbsf_request_form();
		asf1.validate_inactive_users(inactiveusers);
		asf1.validate_nonwbsf_users(nonwbsfusers);
		asf1.validate_nonsupervisors_users(nonsupervisors);
		asf1.validate_employee_information(employee);
		asf1.validate_Supervisors_and_above_WBSF_employees_are_in_the_dropdown_or_not(wbsfemployee);
		asf1.validate_Assignment_Information_section(wbsfemployee);
		asf1.validate_alternate_cost_center_dropdown(alternatecostcenter);
		asf1.validate_field();
		asf1.validate_request_type();
		asf1.validate_person_name_replaced_field(name);
		asf1.validate_title_of_the_person_field(title);
		asf1.validate_reason_for_replacement_dropdown1();
		asf1.validate_reason_for_replacement_dropdown2();
		asf1.validate_reason_for_replacement_dropdown3();
		asf1.validate_other_reason_for_replacement_field(reason);
		asf1.validate_startdate();
		asf1.validate_enddate();
		asf1.validate_EndDate_prior_to_the_startdate();
		asf1.validate_enddate1();
		asf1.validate_name_temp(name);
		asf1.validate_hours(time);
		asf1.validate_building_roomno_field(bldgno);
		asf1.validate_Requirements_with_Proficiency_text();
		asf1.validating_default_skills();
		asf1.validating_profecency_rating();
		asf1.validating_table_rows();
		asf1.validate_newly_added_row(skill);
		asf1.validate_table_row(skill1);
		asf1.validating_rows_in_table();
		asf1.validate_other_software_section_in_table(software);
		asf1.validate_other_software_field(software1);
		asf1.validate_office_section_in_table(officesection);
		asf1.validate_finance_accounting_section_in_table(finance);
		asf1.validate_system_section_in_table(system);
		asf1.validate_text_under_additional_requirements_section();
		asf1.validate_information_in_selectedskills_dropdown();
		asf1.validate_information_in_availableskills_dropdown();
		asf1.validate_multiple_individual_Skills_from_the_Availabe_Skills_List();
		asf1.validate_others_field(os);
		asf1.validate_additional_requirements_field(otherskills);
		asf1.validate_describe_job_duites(duties);
		asf1.validate_approver_information1(costcenter, approvers);
		asf1.validate_submit_button();

	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("wbsftemprequestform");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("Accessing and submitting form2")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}

}
