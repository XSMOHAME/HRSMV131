package com.snow.pageobjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.snow.base.ReusableLibrary;

public class ValidateCMSDetailedReport extends ReusableLibrary {

	public WebDriver driver;

	public ValidateCMSDetailedReport(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='filter']")
	public WebElement leftSearch;
	@FindBy(xpath = "//*[text()='View / Run']")
	public WebElement xpViewORRun;
	@FindBy(xpath = "//*[text()='Create your first report']")
	public WebElement xpReportPageHeader;
	@FindBy(xpath = "//*[@id='li_group_reports_tab']")
	public WebElement xpReportsTab;
	@FindBy(xpath = "//input[@id='indicatortag_complete']")
	public WebElement xpSearch;
	@FindBy(xpath = "(//*[text()='HRSM Monthly SNOW HR Case Report'])[1]")
	public WebElement xpHRSMMonthlyReport;
	@FindBy(xpath = "//*[text()='Created on Last week']")
	public WebElement xpLastWeekFilter;
	@FindBy(xpath = "//tr[starts-with(@id,'hdr_')]/th/span")
	public List<WebElement> xpColumnHeaderList;
	@FindBy(xpath = "//div[text()='Excel (.xlsx)']")
	public WebElement xpExcel;
	@FindBy(xpath = "//div[text()='Export']")
	public WebElement xpExport;
	@FindBy(xpath = "//*[@name='number']/span/a")
	public WebElement xpNumberHeader;
	@FindBy(xpath = "//button[@id='download_button']")
	public WebElement xpDownload;
	@FindBy(xpath = "//*[@id='open-filters-button']")
	public WebElement xpFunnel;
	@FindBy(xpath = "//*[@template='sn_filter_field_list_popover.xml']")
	public WebElement xpCondition1;
	@FindBy(xpath = "//select[@id='cond_operator_0']")
	public WebElement xpCondition2;
	@FindBy(xpath = "//*[@template='sn_date_choice_popover.xml']")
	public WebElement xpCondition3;
	@FindBy(xpath = "//div[@id='filter-field-container-sn_hr_core_case']/ul/li/a")
	public List<WebElement> xpCondition1Dropdown;
	@FindBy(xpath = "//*[text()='Months']")
	public WebElement xpMonthsTab;
	@FindBy(xpath = "//*[text()='Last month']")
	public WebElement xpLastMonthTab;
	@FindBy(xpath = "//*[text()='Weeks']")
	public WebElement xpWeeksTab;
	@FindBy(xpath = "//*[text()='Last week']")
	public WebElement xpLastWeekTab;
	@FindBy(xpath = "//*[text()='Run']")
	public WebElement xpRun;
	@FindBy(xpath = "(//*[text()='and'])[2]")
	public WebElement xpAndBtn;
	@FindBy(xpath = "//*[text()='Clear All']")
	public WebElement xpClearAll;
	@FindBy(xpath = "//*[text()='-- choose field --']")
	public WebElement xpChooseField;
	@FindBy(xpath = "//*[contains(@id,'select2-chosen-9')]/ancestor::a")
	public WebElement xpConditionTwo;
	@FindBy(xpath = "//*[contains(@id,'s2id_autogen9_search')]")
	public WebElement xpConditionTwoDropdown;
	@FindBy(xpath = "//*[@class=' list_row_number_input ']/span[2]")
	public WebElement xpTotalRows;
	@FindBy(xpath = "//*[contains(text(),'No records to display')]")
	public WebElement xpNoRecords;

	String fileName;
	String browserstackFilename;
	List<String> actualColumns;
	List<String> expectedColumns;
	int records;
	String finalcount = "";

	// Navigating to the Reports Page
	public void navigateReport() throws Exception {
		waitForElementToBeClickable(driver, leftSearch);
		leftSearch.sendKeys("View / Run");
		checkForPageLoad(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		waitForElementToBeClickable(driver, xpViewORRun);
		js.executeScript("arguments[0].click();", xpViewORRun);
		checkForPageLoad(driver);

		driver.switchTo().frame(0);
		waitForElement(driver, xpReportPageHeader);
		if (isElementPresent(xpReportPageHeader)) {
			logSuccess("Successfully navigate to Reports Dasgboard page");
			logSuccessScreenshot(driver);
		} else {
			logFailure("Navigation Failed to Reports Page");
			logFailureScreenshot(driver);
		}
	}

	// Opening the Monthly Report and validating the Created on last month report
	public void OpenMonthlyReport(String report, String filename, String browserstackfile) throws Exception {
		waitForElementToBeClickable(driver, xpReportsTab);
		xpReportsTab.click();
		waitForElementToBeClickable(driver, xpSearch);
		xpSearch.sendKeys(report, Keys.ENTER);
		waitForElement(driver, xpHRSMMonthlyReport);
		if (isElementPresent(xpHRSMMonthlyReport)) {
			logSuccess("HRSM Monthly Snow Report is Displayed");
			logSuccessScreenshot(driver);
		} else {
			logFailure("HRSM Monthly snow Report is Not Displayed");
			logFailureScreenshot(driver);
		}
		// opening the snow HRSM monthly report
		waitForElementToBeClickable(driver, xpHRSMMonthlyReport);
		xpHRSMMonthlyReport.click();
		checkForPageLoad(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		// checking the created on last month or not
		waitForElement(driver, xpLastWeekFilter);
		if (isElementPresent(xpLastWeekFilter)) {
			logSuccess("Report is Filtered by Created on Last Week default");
			logSuccessScreenshot(driver);
		} else {
			waitForElementToBeClickable(driver, xpFunnel);
			xpFunnel.click();
			waitForFrameToBeAvailable(driver, "gsft_main");
			waitForElementToBeClickable(driver, xpCondition1);
			xpCondition1.click();
			for (int i = 0; i < xpCondition1Dropdown.size(); i++) {
				if (xpCondition1Dropdown.get(i).getText().equals("Created")) {

					logSuccess("Expected Value - " + "Created");
					logSuccess("Actual Value - " + xpCondition1Dropdown.get(i).getText());
					waitForElementToBeClickable(driver, xpCondition1Dropdown.get(i));
					xpCondition1Dropdown.get(i).click();
					break;
				}

			}
			checkForPageLoad(driver);
			waitForElementToBeClickable(driver, xpCondition3);
			xpCondition3.click();
			waitForElementToBeClickable(driver, xpWeeksTab);
			xpWeeksTab.click();
			waitForElementToBeClickable(driver, xpLastWeekTab);
			xpLastWeekTab.click();
			waitForElementToBeClickable(driver, xpRun);
			xpRun.click();

			waitForFrameToBeAvailable(driver, "gsft_main");
			waitForElementToBeClickable(driver, xpLastWeekFilter);
			if (isElementPresent(xpLastWeekFilter)) {
				logSuccess("Report is Filtered by Created on Last Week ");
				logSuccessScreenshot(driver);
			} else {
				logFailure("Report is not Filtered Created on last Week ");
				logFailureScreenshot(driver);
			}

		}
		expectedColumns = new ArrayList<String>();
		System.out.println("size=" + xpColumnHeaderList.size());
		for (int i = 1; i < xpColumnHeaderList.size(); i++) {
			String[] ar = xpColumnHeaderList.get(i).getText().split("\\r?\\n");
			if (tempbrowser.equalsIgnoreCase("IE") || tempbrowser.equalsIgnoreCase("safari")) {
				expectedColumns.add(ar[0].split("Sort")[0]);
			} else {
				expectedColumns.add(ar[0]);
			}

			System.out.println(ar[0]);
		}
		// String file="sn_hr_core_case.xlsx";
		// fileName = "C:" + File.separatorChar + "Users" + File.separatorChar +
		// "XASINGAR-Adm" + File.separatorChar + "Downloads" + File.separatorChar +
		// filename;

		if (isElementPresent(xpNoRecords) == true) {
			logInfo("zero records found");
			logInfoScreenshot(driver);
			records = 0;
			System.out.println("the number of records+===0");
		} else {

			String[] countText = xpTotalRows.getText().split(",");
			for (int i = 0; i < countText.length; i++) {
				finalcount = finalcount + countText[i];
			}
			records = Integer.parseInt(finalcount);
		}

		fileName = filename;
		browserstackFilename = browserstackfile;
		File file1 = new File(fileName);
		if (file1.exists()) {
			file1.delete();
		}
		Actions action = new Actions(driver);
		action.contextClick(xpNumberHeader).perform();
		action.moveToElement(xpExport).perform();
		waitForElementToBeClickable(driver, xpExcel);
		action.moveToElement(xpExcel).click().build().perform();
		// (2000);
		// waitForElement(driver, xpDownload);
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(xpDownload));
		if (isElementPresent(xpDownload)) {

			logSuccess("Successfully Export to Excel and Download button available");
			waitForElementToBeClickable(driver, xpDownload);
			xpDownload.click();
		} else {
			logFailure("Download button is not available");
			logFailureScreenshot(driver);
		}
		Thread.sleep(15000);
		if (tempExecuteOn.equalsIgnoreCase("System Browsers")) {
			if (file1.exists()) {
				logSuccess("Successfully download the Report Sheet");
			} else {
				logFailure("failed to download the Report Sheet");
			}
		} else if (tempExecuteOn.equalsIgnoreCase("Browserstack")) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			// check if file exists
			Object b = jse.executeScript(
					"browserstack_executor: {\"action\": \"fileExists\", \"arguments\": {\"fileName\": \""
							+ browserstackFilename + "\"}}");
			String s = String.valueOf(b);
			System.out.println(jse.executeScript(
					"browserstack_executor: {\"action\": \"fileExists\", \"arguments\": {\"fileName\": \""
							+ browserstackFilename + "\"}}"));
			if (s.equalsIgnoreCase("true")) {
				logSuccess("Successfully download the Report Sheet");
			} else {
				logFailure("failed to download the Report Sheet");
			}
			String base64EncodedFile = (String) jse.executeScript(
					"browserstack_executor: {\"action\": \"getFileContent\", \"arguments\": {\"fileName\": \""
							+ browserstackFilename + "\"}}");

			// decode the content to Base64
			byte[] data = Base64.getDecoder().decode(base64EncodedFile);
			OutputStream stream = new FileOutputStream(browserstackFilename);
			stream.write(data);
			stream.close();
		}

	}

	// Fetching the Excel columns and validating to the Header columns and enter
	// Extra filter condition
	public void readColumns(String condition1, String condition3) throws Exception {
		File file = null;
		if (tempExecuteOn.equalsIgnoreCase("System Browsers")) {
			file = new File(fileName);
		} else if (tempExecuteOn.equalsIgnoreCase("Browserstack")) {
			file = new File(browserstackFilename);
		}
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);

		int lastRowNum = sheet.getLastRowNum();
		if (records == lastRowNum) {
			logSuccess(
					"the number of records are match for application records and downloaded excel records==" + records);
		} else {
			logFailure("the number of records are not match for application records and downloaded excel records");
		}
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		System.out.println(lastRowNum);
		actualColumns = new ArrayList<String>();
		for (int i = 0; i < lastCellNum; i++) {
			actualColumns.add(sheet.getRow(0).getCell(i).getStringCellValue());
			System.out.println(sheet.getRow(0).getCell(i).getStringCellValue());
		}

		int count = 0;
		for (int i = 0; i < actualColumns.size(); i++) {

			if (expectedColumns.get(i).equals(actualColumns.get(i))) {

			} else {
				count++;
			}
		}
		if (count == 0) {
			logSuccess("Apllication Header column names and Downloaded Excel Header column names are same");
		} else {
			logFailure("Apllication Header column names and Downloaded Excel Header column names are not same");
		}
		// this is checking the funnel icon opened or not
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElementToBeClickable(driver, xpClearAll);
		if (isElementPresent(xpClearAll)) {
			waitForElementToBeClickable(driver, xpAndBtn);
			xpAndBtn.click();
			waitForFrameToBeAvailable(driver, "gsft_main");
			logSuccess("clicked on the one more filter condition ");
			logSuccessScreenshot(driver);
		} else {
			waitForElementToBeClickable(driver, xpFunnel);
			xpFunnel.click();

			waitForFrameToBeAvailable(driver, "gsft_main");
			waitForElementToBeClickable(driver, xpAndBtn);
			xpAndBtn.click();
			logSuccess("clicked on the one more filter condition ");
			logSuccessScreenshot(driver);
		}
		// filter the second condition
		waitForElementToBeClickable(driver, xpChooseField);
		xpChooseField.click();
		checkForPageLoad(driver);
		for (int i = 0; i < xpCondition1Dropdown.size(); i++) {
			if (xpCondition1Dropdown.get(i).getText().equals(condition1)) {
				logSuccess("Expected Value  - " + condition1);
				logSuccess("Actual Value - " + xpCondition1Dropdown.get(i).getText());
				waitForElementToBeClickable(driver, xpCondition1Dropdown.get(i));
				xpCondition1Dropdown.get(i).click();
				break;
			}

		}
		waitForElementToBeClickable(driver, xpConditionTwo);
		xpConditionTwo.click();
		waitForElementToBeClickable(driver, xpConditionTwoDropdown);
		xpConditionTwoDropdown.sendKeys(condition3);
		checkForPageLoad(driver);
		xpConditionTwoDropdown.sendKeys(Keys.TAB);
		logSuccess("adding the another filter condition==" + condition1 + " is " + condition3);
		logInfoScreenshot(driver);
		waitForElementToBeClickable(driver, xpRun);
		xpRun.click();
		logInfo("Update the Filter condition successfully");
		workbook.close();
	}
}
