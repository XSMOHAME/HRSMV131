package com.snow.testscripts.CaseManagement;

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
import com.snow.pageobjects.HR_Case_Management;
import com.snow.pageobjects.KnowledgeCreationPage;
import com.snow.pageobjects.LoginPage;

public class UploadHRCases extends ReusableLibrary {

	ReadData rd = new ReadData();

	@Test(dataProvider = "data")
	public void uploadBulkCases(Map<Object, Object> data) throws Throwable, IOException {
		KnowledgeCreationPage knowledgeCreation = new KnowledgeCreationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		// HRPortalPage hrPortalPage = new HRPortalPage(driver);
		test.get().log(Status.INFO, MarkupHelper.createLabel("**Test for Upload cases**", ExtentColor.ORANGE));
		// Login to the application and validate the login
		loginPage.snowLogin(HrAnalystUser1, HrAnalystUser1Password);
		checkForPageLoad(driver);
		knowledgeCreation.loginValidate();

		// Navigation to HR Portal and Validation
		String user = (String) data.get("ActiveUser");
		String hrServicedropdown = (String) data.get("HRSERVICE");
		String descriptionText = (String) data.get("CaseDescription");
		String filename = (String) data.get("FileName");

		checkForPageLoad(driver);
		// hrPortalPage.hrPortalNavigateValidate();
		HR_Case_Management hrc = PageFactory.initElements(driver, HR_Case_Management.class);
		hrc.navigateCaseManagement();
		hrc.createNewCase(user, hrServicedropdown, descriptionText);

		driver.navigate().to(hrPortalURL);
		Thread.sleep(3000);
		String filePath = (String) data.get("DownloadFilepath");
		hrc.searchUploadCasePage("Upload HR Cases", filePath, filename);
		// reading the date from input excel
		String COE = (String) data.get("COE");
		String topicCategory = (String) data.get("Topic Category");
		String topicDetail = (String) data.get("Topic Detail");
		String HR_Service = (String) data.get("ExcelHR Service");
		String state = (String) data.get("State");
		String priority = (String) data.get("Priority");
		String sourcedetail = (String) data.get("Source");
		String createdOn = (String) data.get("Created On");
		String assignGroup = (String) data.get("Assignment Group");
		String OpenedBy = (String) data.get("Opened By");
		String OpenedFor = (String) data.get("Opened For");
		String SubjectPerson = (String) data.get("Subject Person");
		String descriptiontxt = (String) data.get("Short Description");
		String dateAndTime = (String) data.get("dateAndTimeCheck");
		// writing the Excel for Updating and creating the case purpose
		hrc.updateExcel(COE, topicCategory, topicDetail, HR_Service, state, priority, sourcedetail, createdOn,
				assignGroup, OpenedBy, OpenedFor, SubjectPerson, descriptiontxt, dateAndTime);
		// uploading the Excel sheet
		hrc.addAttachment(hrc.xpAddAttachment);
		// validating the upload cases created or not
		hrc.validateCases(priority, HR_Service, assignGroup);
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {
		Object[][] excelData = rd.readDataFromSheet("UploadHRCases");
		Object[][] testCaseData = new Object[1][1];
		for (int i = 0; i < excelData.length; i++) {
			if (excelData[i][0].toString().contains("UploadHRCases")) {
				testCaseData[0][0] = excelData[i][0];
			}
		}
		return testCaseData;
	}
}
