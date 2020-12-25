package com.snow.pageobjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.snow.base.ReusableLibrary;

public class SecurityFormPage extends ReusableLibrary {

	public WebDriver driver;

	public SecurityFormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "filter")
	public WebElement navigationfilter;

	@FindBy(id = "sys_readonly.sn_hr_core_profile.ssn")
	public WebElement pinHrProfile;

	@FindBy(id = "sys_readonly.sn_hr_core_profile.ssn")
	public List<WebElement> pinHrProfileList;

	@FindBy(id = "sys_readonly.sn_hr_core_profile.u_home_postal_code")
	public WebElement homePostalCodeHrProfile;

	@FindBy(id = "sys_readonly.sn_hr_core_profile.u_home_postal_code")
	public List<WebElement> homePostalCodeHrProfileList;

	@FindBy(id = "sys_readonly.sn_hr_core_profile.u_job_family.u_job_family_group_name")
	public WebElement jobFamilyGroupNameHrProfile;

	@FindBy(id = "sys_readonly.sn_hr_core_profile.u_job_family.u_job_family_group_name")
	public List<WebElement> jobFamilyGroupNameHrProfileList;

	@FindBy(id = "sn_hr_core_profile.u_job_family_label")
	public WebElement jobFamilyHrProfile;

	@FindBy(id = "sn_hr_core_profile.u_job_family_label")
	public List<WebElement> jobFamilyHrProfileList;

	@FindBy(id = "sys_readonly.sn_hr_core_profile.u_union_code")
	public WebElement unionCodeHrProfile;

	@FindBy(id = "sys_readonly.sn_hr_core_profile.u_union_code")
	public List<WebElement> unionCodeHrProfileList;

	@FindBy(id = "sn_hr_core_profile.user_label")
	public WebElement userProfileName;

	@FindBy(xpath = "//*[text() = 'HR Profiles']/parent::div/parent::a[contains(@class, 'sn-widget-list-item sn-widget-list-item_hidden-action module-node')]")
	public WebElement hrProfiles;

	@FindBy(xpath = "//select[@class='form-control default-focus-outline']")
	public WebElement searchHRProfileDropDown;

	@FindBy(xpath = "//select[@class='form-control default-focus-outline']")
	public List<WebElement> searchHRProfileDropDownList;

	@FindBy(xpath = "//input[@class = 'form-control' and @placeholder = 'Search']")
	public WebElement searchHRProfile;

	@FindBy(xpath = "(//input[contains(@aria-label, 'Search column: user')])[1]")
	public WebElement searchHRProfileText;

	@FindBy(xpath = "//a[text() = 'Open Record']")
	public WebElement openRecord;

	@FindBy(xpath = "//*[@id='user_info_dropdown']/div/span[4]")
	public WebElement userMenu;

	@FindBy(xpath = "//*[contains(@role,'presentation')]/a[text()='Impersonate User']")
	public WebElement impUser;

	@FindBy(xpath = "//*[@id='select2-chosen-2']")
	public WebElement impUserDropDwn;

	@FindBy(xpath = "//*[@id='s2id_autogen2_search']")
	public WebElement impUserSendkys;

	@FindBy(xpath = "//*[@id='user_info_dropdown']/div/span[1]")
	public WebElement userName;

	@FindBy(xpath = "//*[@id='filter']")
	public WebElement filterNavi;

	// @FindBy(xpath = "//i[contains(@aria-label, 'Topic category column options')
	// and @tabindex = '0']")
	// @FindBy(xpath = "(//*[contains(@id,'hdr_sn_hr_core_')]/th[@name =
	// 'topic_category']/descendant::i)[1]")
	@FindBy(xpath = "(//i[contains(@aria-label, 'Topic category column options')])[1]")
	public List<WebElement> topicCategoryColumnOptions;

	@FindBy(xpath = "(//i[contains(@aria-label, 'Topic category column options')])[1]/following-sibling::a")
	public WebElement topicCategoryColumnLabel;

	@FindBy(xpath = "//*[contains(text(), 'Group By Topic category')]")
	public WebElement groupByTopicCategory;

	@FindBy(xpath = "//span[contains(@class, 'list_group')]")
	public List<WebElement> topicCategoryList;

	// @FindBy(xpath = "//select[contains(@id, '_select') and @class =
	// 'form-control']")
	@FindBy(xpath = "//select[contains(@id, '_select') and contains(@class ,'form-control default-focus-outline')]")
	public WebElement columnDropDown;

	@FindBy(xpath = "//input[contains(@id, '_text') and @class = 'form-control']")
	public WebElement searchInColumn;

	@FindBy(xpath = "(//input[@aria-label = 'Search column: requested by'])[1]")
	public WebElement requestedBySearchBox;

	@FindBy(xpath = "(//input[@aria-label = 'Search column: assigned to'])[1]")
	public WebElement assignedToSearchBox;

	@FindBy(xpath = "(//input[@aria-label = 'Search column: opened by'])[1]")
	public WebElement openedBySearchBox;

	@FindBy(xpath = "//td[contains(text(), 'No records to display')]")
	public WebElement noRecordsToDisplay;

	@FindBy(xpath = "//tr[contains(@id, 'row_sn_hr_core')]")
	public List<WebElement> rowList;

	@FindBy(xpath = "//div[text()='Employee Services Cases']")
	public WebElement empService;

	@FindBy(xpath = "//*[@id='sn_hr_core_hr_employee_services_table']/tbody/tr[16]/td")
	public WebElement hritText;

	@FindBy(id = "list_nav_sn_hr_core_case_total_rewards")
	public WebElement totalRewCases;

	@FindBy(xpath = "//*[contains(@id,'sn_hr_')]/tbody/tr/td")
	public WebElement NoRecords;

	@FindBy(xpath = "//*[contains(@name,'vcr_next') and contains(@class,'list_nav')]")
	public WebElement nextButton;

	@FindBy(xpath = "//*[contains(@name,'vcr_next') and contains(@class,'list_nav')and contains(@class,'disabled')]")
	public WebElement nextButtonDisabled;

	@FindBy(xpath = "(//*[contains(@id,'hdr_sn_hr_core_')]/th[1]/i)[1]")
	public WebElement personalizeButton;

	@FindBy(xpath = "//*[@id='slush_left']")
	public WebElement topicAvailable;

	@FindBy(xpath = "//label[contains(text(), 'Available')]")
	public WebElement anyWhere;

	@FindBy(xpath = "//*[@id='addRemoveButtons']/a[1]")
	public WebElement columnAdd;

	@FindBy(xpath = "//*[@id='addRemoveButtons']/a[2]")
	public WebElement columnRemove;

	@FindBy(xpath = "//select[@id='slush_right']")
	public WebElement topicSelect;

	@FindBy(xpath = "//*[@id='upDownButtons']/a[1]")
	public WebElement upButton;

	@FindBy(xpath = "//*[@id='upDownButtons']/a[2]")
	public WebElement downButton;

	@FindBy(xpath = "//*[@id='ok_button']")
	public WebElement personalizeOk;

	@FindBy(xpath = "//*[@id='reset_column_defaults']")
	public WebElement resetButton;

	@FindBy(xpath = "(//span[contains(@id,'total_rows')])[1]")
	public WebElement totalRows;

	@FindBy(xpath = "//*[contains(@id,'xd')]/li[2]/a/span")
	public WebElement adminPortalGear;

	@FindBy(xpath = "//*[contains(@id,'xd')]/li[2]/a/span")
	public List<WebElement> adminPortalGearList;

	public void adminPortalGear() {
		PageFactory.initElements(driver, SecurityFormPage.class);
		waitForElement(driver, adminPortalGear);
		if (isElementPresentList(adminPortalGearList)) {
			driver.get(homePageURL);
		} else {
			System.out.println("ITIL View is already available.");
		}
	}

	public void noRecordsDisplaymsg(String caseName) throws InterruptedException, IOException {
		PageFactory.initElements(driver, SecurityFormPage.class);
		try {
			filterNavi.sendKeys(caseName);
			waitForElementToBeClickable(driver, filterNavi);
			filterNavi.sendKeys(Keys.ENTER);
			waitForFrameToBeAvailableByIndex(driver, 0);
			// driver.switchTo().frame(0);
			if (NoRecords.getText().contains("Number of rows removed from this list by Security constraints:")
					|| NoRecords.getText().equals("No records to display")) {
				test.get().log(Status.PASS, MarkupHelper.createLabel(caseName
						+ " displays message as: Number of rows removed from this list by Security constraints (or) No Records to Display",
						ExtentColor.GREEN));
				logSuccess("Expected Value - "
						+ "No records to display  (OR)  Number of rows removed from this list by Security constraints:");
				logSuccess("Actual Value - " + NoRecords.getText());
				logSuccessScreenshot(driver);
			} else {
				System.out.println("FAIL");
				test.get().log(Status.FAIL, MarkupHelper.createLabel(
						caseName + " case doesnot appear with: No Records to Display message", ExtentColor.RED));
				logFailure("Expected Value - "
						+ "No records to display  (OR)  Number of rows removed from this list by Security constraints:");
				logFailure("Actual Value - " + NoRecords.getText());
				logFailureScreenshot(driver);
			}

		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("FAIL");
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					caseName + " case doesnot appear with: No Records to Display message", ExtentColor.RED));

			logFailure("Expected Value - "
					+ "No records to display  (OR)  Number of rows removed from this list by Security constraints:");
			logFailure("Actual Value - " + NoRecords.getText());

			logFailureScreenshot(driver);
		}
		driver.switchTo().defaultContent();

	}

	public void resetPersonilizeList() throws InterruptedException {
		PageFactory.initElements(driver, SecurityFormPage.class);
		waitForElementToBeClickable(driver, personalizeButton);
		personalizeButton.click();
		waitForElementToBeClickable(driver, resetButton);
		if (resetButton.isDisplayed()) {
			resetButton.click();
		}
	}

	public void personilizeList(String[] columnsForLeftToRight, String[] columnsToKeep) throws InterruptedException {
		PageFactory.initElements(driver, SecurityFormPage.class);
		waitForElementToBeClickable(driver, personalizeButton);
		personalizeButton.click();

		waitForElementToBeClickable(driver, topicSelect);
		Select select2 = new Select(topicSelect);
		waitForAction(driver);
		List<WebElement> selectedColumnList = select2.getOptions();
		System.out.println("Selected Column Size - " + selectedColumnList.size());
		System.out.println("To Be removed");
		for (int i = 0; i < selectedColumnList.size(); i++) {
			waitForElementToBeClickable(driver, selectedColumnList.get(i));
			System.out.println("Column - " + selectedColumnList.get(i).getAttribute("value"));
			waitForElementToBeClickable(driver, selectedColumnList.get(i));
			selectedColumnList.get(i).click();
			columnRemove.click();
		}
		waitForElement(driver, anyWhere);
		anyWhere.click();
		Select select = new Select(topicAvailable);
		List<WebElement> columnList = select.getOptions();
		for (int i = 0; i < columnList.size(); i++) {
			for (int j = 0; j < columnsForLeftToRight.length; j++) {
				if (columnList.get(i).getText().trim().equalsIgnoreCase(columnsForLeftToRight[j].trim())) {
					waitForElementToBeClickable(driver, columnList.get(i));
					columnList.get(i).click();
					System.out.println("Selecting - " + columnList.get(i).getText().trim());
				}
			}
		}
		columnAdd.click();

//		for (int i = 0; i < selectedColumnList.size(); i++) {
//			for (int j = 0; j < columnsToKeep.length; j++) {
//				if (!selectedColumnList.get(i).getText().equals(columnsToKeep[j])) {
//					selectedColumnList.get(i).click();
//				}
//			}
//			for (int j = 0; j < columnsForLeftToRight.length; j++) {
//				if (!selectedColumnList.get(i).getText().equals(columnsForLeftToRight[j])) {
//					selectedColumnList.get(i).click();
//				}
//			}
//		}

		waitForElementToBeClickable(driver, personalizeOk);
		personalizeOk.click();
	}

	public void UserGroupCasesTestAllCases(String Case, String CaseName, String InvalidCaseName)
			throws InterruptedException, IOException {
		PageFactory.initElements(driver, SecurityFormPage.class);
		adminPortalGear();
		int c;
		int nextCount = 0;
		boolean d = true;

		HashSet<String> expectedValues = new HashSet<String>();
		String[] CaseNameSplit = CaseName.split(",");
		String[] InvalidCaseNameSplit = InvalidCaseName.split(",");

		/*
		 * if (Case.equals("Total Rewards Cases")) {
		 * noRecordsDisplaymsg("Total Rewards Cases"); }
		 */

		if (Case.equals("Employee Services Cases") || Case.equals("HRIT Cases") || Case.equals("Payroll Cases")
				|| Case.equals("Total Rewards Cases") || Case.equals("Workforce Administration Cases")) {

			filterNavi.sendKeys(Case);
			waitForElementToBeClickable(driver, filterNavi);
			filterNavi.sendKeys(Keys.ENTER);
			waitForFrameToBeAvailableByIndex(driver, 0);
			// personilizeList();
			waitForElement(driver, nextButton);

			if (!nextButton.isEnabled()) {
				nextCount++;
			}

			while (nextButton.isEnabled() || nextCount == 1) {

				// below will search the Case
				for (int b = 0; b < CaseNameSplit.length; b++) {
					for (c = 0; c < InvalidCaseNameSplit.length; c++) {
						List<WebElement> topicCategoryVal = driver
								.findElements(By.xpath("//a[text()='" + CaseNameSplit[b] + "']"));
						if (topicCategoryVal.size() > 0
								&& (topicCategoryVal.get(0).getText().trim().equals(InvalidCaseNameSplit[c]))) {
							d = false;
						}
						if (!CaseNameSplit[b].equals(InvalidCaseNameSplit[c])) {
							expectedValues.add(CaseNameSplit[b]);
						}
					}
				}

				// above will search the Case
				if (nextCount == 0 || nextButton.isEnabled()) {
					waitForElement(driver, nextButton);
					nextButton.click();
				}
				if (!nextButton.isEnabled()) {
					nextCount++;
				}

			}
			driver.switchTo().defaultContent();
		}

		if (d == false) {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					Case + " is displayed with any of invalid values: " + InvalidCaseName, ExtentColor.RED));

			logFailureScreenshot(driver);
		} else {
			test.get().log(Status.PASS, MarkupHelper.createLabel(Case + " is displayed alone with: " + (expectedValues),
					ExtentColor.GREEN));

			;

			logSuccessScreenshot(driver);
		}

	}

	public void columnCategoryCompliance(String caseToBeSearched, String employeeServicesTopicCategories, String user)
			throws InterruptedException, IOException {
		PageFactory.initElements(driver, SecurityFormPage.class);

		String[] employeeServicesTopicCategoriesArray = employeeServicesTopicCategories.split(",");
		List<String> expectedTopicCategories = new ArrayList<String>();
		List<String> actualTopicCategories = new ArrayList<String>();
		// String topicCategory;
		// adminPortalGear();
		test.get().log(Status.INFO, MarkupHelper.createLabel("Searching for - " + caseToBeSearched, ExtentColor.AMBER));
		driver.switchTo().defaultContent();
		waitForAction(driver);
		waitForElementToBeClickable(driver, filterNavi);
		filterNavi.clear();
		filterNavi.sendKeys(caseToBeSearched);
		filterNavi.sendKeys(Keys.ENTER);
		WebElement topicCategoryFromFilter = driver
				.findElement(By.xpath("//div[text() = '" + caseToBeSearched + "']/ancestor::a"));
		waitForElementToBeClickable(driver, topicCategoryFromFilter);
		topicCategoryFromFilter.click();
		checkForPageLoad(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		logInfoScreenshot(driver);

		personilizeList(new String[] { "Number", "Topic category", "Opened by", "Requested by", "Assigned to" },
				new String[] { "Number", "Topic category", "Opened by", "Requested by", "Assigned to" });

		// scrollPageToElement(driver, topicCategoryColumnLabel);
		waitForAction(driver);
		driver.get(driver.getCurrentUrl());
		waitForFrameToBeAvailable(driver, "gsft_main");
		checkForPageLoad(driver);
		waitForElement(driver, topicCategoryColumnOptions.get(0));
		waitForElementToBeClickable(driver, topicCategoryColumnOptions.get(0));
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		for (WebElement element : topicCategoryColumnOptions) {
			waitForAction(driver);
			execute.executeScript("arguments[0].click();", element);
		}
		waitForAction(driver);
		if (!groupByTopicCategory.isDisplayed()) {
			waitForElementToBeClickable(driver, topicCategoryColumnOptions.get(0));
			Actions actions = new Actions(driver);
			actions.moveToElement(topicCategoryColumnOptions.get(0));
			actions.click(topicCategoryColumnOptions.get(0)).build().perform();
			waitForAction(driver);
			try {
				if (!groupByTopicCategory.isDisplayed()) {
					/*
					 * driver.findElement(By.
					 * xpath("(//i[contains(@aria-label, 'Topic category column options')])[1]"))
					 * .click();
					 */
					for (WebElement element : driver
							.findElements(By.xpath("(//i[contains(@aria-label, 'Topic category')])[1]"))) {
						waitForAction(driver);
						System.out.println("Element Property - " + element.getAttribute("data-original-title"));
						execute.executeScript("arguments[0].click();", element);
					}
				}
			} catch (Exception e) {
				System.out.println("CATCH");
			}
		}
		waitForElementToBeClickable(driver, groupByTopicCategory);
		groupByTopicCategory.click();
		checkForPageLoad(driver);
		waitForFrameToBeAvailable(driver, "gsft_main");
		// waitForElement(driver, );

		for (int i = 0; i < employeeServicesTopicCategoriesArray.length; i++) {
			expectedTopicCategories.add(employeeServicesTopicCategoriesArray[i].trim());
		}

		if (!isElementPresentList(topicCategoryList)) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Records are not displayed for " + caseToBeSearched, ExtentColor.ORANGE));
			logInfoScreenshot(driver);
		} else {
			for (int i = 0; i < topicCategoryList.size(); i++) {
				String tempCategory = topicCategoryList.get(i).getText().split(": ")[1];
				// topicCategory = temp.split("\\(")[0];
				// actualTopicCategories.add(topicCategory.trim());
				int count = 0;
				int splitIndex = 0;
				int var = 0;

				for (int j = 0; j < tempCategory.length(); j++) {
					if (String.valueOf(tempCategory.charAt(j)).equals("(")) {
						count++;
						System.out.println(count);
						var = j;
					}
					if (count == 1) {
						splitIndex = var;
					}
					if (count == 2) {
						splitIndex = var;
					}
				}
				String finalCategory = tempCategory.substring(0, splitIndex);
				actualTopicCategories.add(finalCategory.trim());
			}

			List<Set<String>> compareResult = compareTwoListSecurity(expectedTopicCategories, actualTopicCategories);

			if (!compareResult.get(0).isEmpty()) {
				logSuccess("Matched Topic Categoris are - ");
				logSuccess("-" + compareResult.get(0).toString());
				logSuccessScreenshot(driver);
			}

			if (!compareResult.get(1).isEmpty()) {
				test.get().log(Status.INFO,
						MarkupHelper.createLabel("Unmatched Topic Categoris are - ", ExtentColor.ORANGE));
				test.get().log(Status.INFO,
						MarkupHelper.createLabel("-" + compareResult.get(1).toString(), ExtentColor.ORANGE));
				logInfoScreenshot(driver);
			}

			if (!compareResult.get(1).isEmpty()) {
				Object[] unmatchedTopic = compareResult.get(1).toArray();
				System.out.println("Array Size for Unmatched Topic Category - " + unmatchedTopic.length);
				System.out.println("Topic Category List - " + topicCategoryList.size());
				System.out.println("Unmatched Topic Categories" + unmatchedTopic.toString());
				int innerIndex = 0;
				for (int j = 0; j < unmatchedTopic.length; j++) {
					String topicURL = driver.getCurrentUrl();
					for (int i = innerIndex; i < topicCategoryList.size(); i++) {
						System.out.println("Unmatched Category - " + unmatchedTopic[j].toString());
						if (topicCategoryList.get(i).getText().contains(unmatchedTopic[j].toString())) {
							topicCategoryList.get(i).click();
							checkForPageLoad(driver);
							waitForFrameToBeAvailable(driver, "gsft_main");
							waitForElementToBeClickable(driver, columnDropDown);
							Select select = new Select(columnDropDown);
							select.selectByVisibleText("Opened by");
							waitForElementToBeClickable(driver, searchInColumn);
							searchInColumn.sendKeys(user);
							checkForPageLoad(driver);
							searchInColumn.sendKeys(Keys.ENTER);
							checkForPageLoad(driver);
							waitForFrameToBeAvailable(driver, "gsft_main");
							waitForElementToBeClickable(driver, openedBySearchBox);
							checkForPageLoad(driver);
							openedBySearchBox.sendKeys(user);
							openedBySearchBox.sendKeys(Keys.ENTER);
							checkForPageLoad(driver);
							waitForFrameToBeAvailable(driver, "gsft_main");
							boolean openedByCount = false;
							if (driver.getPageSource().contains("No records to display")) {
								logInfo("No Records are Opened By User - " + user + " for Topic category "
										+ unmatchedTopic[j].toString());
								logInfoScreenshot(driver);
								openedByCount = true;
							} else if (rowList.size() > 0) {
								logSuccess("Records are Opened By User - " + user + " for Topic category "
										+ unmatchedTopic[j].toString());
								logSuccessScreenshot(driver);
							}

							select = new Select(columnDropDown);
							select.selectByVisibleText("Topic category");
							searchInColumn.sendKeys("*");
							searchInColumn.sendKeys(Keys.ENTER);
							driver.get(topicURL);
							waitForAction(driver);
							if (!(driver.getCurrentUrl().equals(topicURL))) {
								driver.get(topicURL);
							}
							waitForFrameToBeAvailable(driver, "gsft_main");
							checkForPageLoad(driver);
							// driver.switchTo().frame(0);
							waitForAction(driver);
							waitForElementToBeClickable(driver, topicCategoryList.get(i));
							topicCategoryList.get(i).click();
							waitForFrameToBeAvailable(driver, "gsft_main");
							checkForPageLoad(driver);
							waitForElementToBeClickable(driver, columnDropDown);
							select = new Select(columnDropDown);
							select.selectByVisibleText("Requested by");
							waitForElementToBeClickable(driver, searchInColumn);
							searchInColumn.sendKeys(user);
							searchInColumn.sendKeys(Keys.ENTER);
							checkForPageLoad(driver);
							waitForFrameToBeAvailable(driver, "gsft_main");
							waitForElementToBeClickable(driver, requestedBySearchBox);
							requestedBySearchBox.sendKeys(user);
							requestedBySearchBox.sendKeys(Keys.ENTER);
							waitForFrameToBeAvailable(driver, "gsft_main");
							boolean requestedByCount = false;
							// 'No records to display'isElementPresent(noRecordsToDisplay)
							if (driver.getPageSource().contains("No records to display")) {
								logInfo("No Records are Requested By User - " + user + " for Topic category "
										+ unmatchedTopic[j].toString());
								logInfoScreenshot(driver);
								requestedByCount = true;
							} else if (rowList.size() > 0) {
								logSuccess("Records are Requested By User - " + user + " for Topic category "
										+ unmatchedTopic[j].toString());
								logSuccessScreenshot(driver);

							}

							if (openedByCount && requestedByCount) {
								logFailure("Please check for User Group or the Security might be compromised.");
								logFailure("-" + unmatchedTopic[j].toString());
								logFailure("-" + user);
								logFailureScreenshot(driver);
							}

							waitForElementToBeClickable(driver, columnDropDown);
							select = new Select(columnDropDown);
							select.selectByVisibleText("Topic category");
							searchInColumn.sendKeys("*");
							searchInColumn.sendKeys(Keys.ENTER);
							waitForFrameToBeAvailable(driver, "gsft_main");
							driver.get(topicURL);
							waitForAction(driver);
							if (!(driver.getCurrentUrl().equals(topicURL))) {
								driver.get(topicURL);
							}
							// driver.switchTo().frame(0);
							waitForFrameToBeAvailable(driver, "gsft_main");
						}
					}
					innerIndex++;
				}
			}
		}
		waitForElement(driver, personalizeButton);
		resetPersonilizeList();
	}

	public void UserGroupCasesTestHRISWorkForceOperational(String Case, String CaseName, String InvalidCaseName)
			throws InterruptedException, IOException {
		PageFactory.initElements(driver, SecurityFormPage.class);
		adminPortalGear();
		int c;
		int nextCount = 0;
		boolean d = true;

		HashSet<String> expectedValues = new HashSet<String>();
		String[] CaseNameSplit = CaseName.split(",");
		String[] InvalidCaseNameSplit = InvalidCaseName.split(",");

		if (Case.equals("Employee Services Cases")) {
			noRecordsDisplaymsg("Employee Services Cases");

		}

		if (
		// Case.equals("Employee Services Cases")
		Case.equals("HRIT Cases") || Case.equals("Payroll Cases") || Case.equals("Total Rewards Cases")
				|| Case.equals("Workforce Administration Cases")) {

			filterNavi.sendKeys(Case);
			filterNavi.sendKeys(Keys.ENTER);
			waitForFrameToBeAvailableByIndex(driver, 0);
			// personilizeList();
			waitForElement(driver, nextButton);

			if (!nextButton.isEnabled()) {
				nextCount++;
			}

			while (nextButton.isEnabled() || nextCount == 1) {

				// below will search the Case
				for (int b = 0; b < CaseNameSplit.length; b++) {
					for (c = 0; c < InvalidCaseNameSplit.length; c++) {
						List<WebElement> topicCategoryVal = driver
								.findElements(By.xpath("//a[text()='" + CaseNameSplit[b] + "']"));
						if (topicCategoryVal.size() > 0
								&& (topicCategoryVal.get(0).getText().trim().equals(InvalidCaseNameSplit[c]))) {
							d = false;
						}
						if (!CaseNameSplit[b].equals(InvalidCaseNameSplit[c])) {
							expectedValues.add(CaseNameSplit[b]);
						}
					}
				}

				// above will search the Case
				if (nextCount == 0 || nextButton.isEnabled()) {
					waitForElementToBeClickable(driver, nextButton);
					nextButton.click();
				}
				if (!nextButton.isEnabled()) {
					nextCount++;
				}

			}
			driver.switchTo().defaultContent();
		}
		// Filter Extent Report Results with results having 'No Display' message
		if (Case.equals("HRIT Cases") || Case.equals("Payroll Cases") || Case.equals("Total Rewards Cases")
				|| Case.equals("Workforce Administration Cases")) {

			if (d == false) {
				test.get().log(Status.FAIL, MarkupHelper.createLabel(
						Case + " is displayed with any of invalid values: " + InvalidCaseName, ExtentColor.RED));
				logFailureScreenshot(driver);
			} else {
				test.get().log(Status.PASS, MarkupHelper
						.createLabel(Case + " is displayed alone with: " + (expectedValues), ExtentColor.GREEN));
				logSuccessScreenshot(driver);
			}
		}
	}

	/**
	 *  *****************************************************************************************************************************************************************************************/

	/****************************************
	 * TC5
	 ************************************************/
	public void UserGroupCasesTestHRISOperationalExcellence(String Case, String CaseName, String InvalidCaseName)
			throws InterruptedException, IOException {
		PageFactory.initElements(driver, SecurityFormPage.class);

		adminPortalGear();
		int c;
		int nextCount = 0;
		boolean d = true;

		HashSet<String> expectedValues = new HashSet<String>();
		String[] CaseNameSplit = CaseName.split(",");
		String[] InvalidCaseNameSplit = InvalidCaseName.split(",");

		if (Case.equals("Employee Services Cases")) {
			noRecordsDisplaymsg("Employee Services Cases");
		}

		if (
		// Case.equals("Employee Services Cases")
		Case.equals("HRIT Cases") || Case.equals("Payroll Cases") || Case.equals("Total Rewards Cases")
				|| Case.equals("Workforce Administration Cases")) {

			filterNavi.sendKeys(Case);
			filterNavi.sendKeys(Keys.ENTER);
			waitForFrameToBeAvailableByIndex(driver, 0);
			// personilizeList(columnsForLeftToRight, columnsToKeep);
			waitForElement(driver, nextButton);

			if (!nextButton.isEnabled()) {
				nextCount++;
			}

			while (nextButton.isEnabled() || nextCount == 1) {

				// below will search the Case
				for (int b = 0; b < CaseNameSplit.length; b++) {
					for (c = 0; c < InvalidCaseNameSplit.length; c++) {
						List<WebElement> topicCategoryVal = driver
								.findElements(By.xpath("//a[text()='" + CaseNameSplit[b] + "']"));
						if (topicCategoryVal.size() > 0
								&& (topicCategoryVal.get(0).getText().trim().equals(InvalidCaseNameSplit[c]))) {
							d = false;
						}
						if (!CaseNameSplit[b].equals(InvalidCaseNameSplit[c])) {
							expectedValues.add(CaseNameSplit[b]);
						}
					}
				}

				// above will search the Case
				if (nextCount == 0 || nextButton.isEnabled()) {
					waitForElement(driver, nextButton);
					nextButton.click();
				}
				if (!nextButton.isEnabled()) {
					nextCount++;
				}
			}
			driver.switchTo().defaultContent();
		}
		// Filter Extent Report Results with results having 'No Display' message
		if (Case.equals("HRIT Cases") || Case.equals("Payroll Cases") || Case.equals("Total Rewards Cases")
				|| Case.equals("Workforce Administration Cases")) {

			if (d == false) {
				test.get().log(Status.FAIL, MarkupHelper.createLabel(
						Case + " is displayed with any of invalid values: " + InvalidCaseName, ExtentColor.RED));
				logFailureScreenshot(driver);
			} else {
				test.get().log(Status.PASS, MarkupHelper
						.createLabel(Case + " is displayed alone with: " + (expectedValues), ExtentColor.GREEN));
				logSuccessScreenshot(driver);
			}
		}
	}

	/****************************************
	 * TC9
	 ************************************************/
	public void UserGroupCasesTestHRSM_Payroll(String Case, String CaseName, String InvalidCaseName)
			throws InterruptedException, IOException {
		PageFactory.initElements(driver, SecurityFormPage.class);
		adminPortalGear();
		int c;
		int nextCount = 0;
		boolean d = true;

		HashSet<String> expectedValues = new HashSet<String>();
		String[] CaseNameSplit = CaseName.split(",");
		String[] InvalidCaseNameSplit = InvalidCaseName.split(",");

		if (Case.equals("Employee Services Cases")) {
			noRecordsDisplaymsg("Employee Services Cases");
		}
		if (Case.equals("HRIT Cases")) {
			noRecordsDisplaymsg("HRIT Cases");
		}
		if (
		// Case.equals("Employee Services Cases")
		// Case.equals("HRIT Cases")
		Case.equals("Payroll Cases") || Case.equals("Total Rewards Cases")
				|| Case.equals("Workforce Administration Cases")) {

			filterNavi.sendKeys(Case);
			filterNavi.sendKeys(Keys.ENTER);
			waitForFrameToBeAvailableByIndex(driver, 0);
			// personilizeList(columnsForLeftToRight, columnsToKeep);
			waitForElement(driver, nextButton);

			if (!nextButton.isEnabled()) {
				nextCount++;
			}

			while (nextButton.isEnabled() || nextCount == 1) {

				// below will search the Case
				for (int b = 0; b < CaseNameSplit.length; b++) {
					for (c = 0; c < InvalidCaseNameSplit.length; c++) {
						List<WebElement> topicCategoryVal = driver
								.findElements(By.xpath("//a[text()='" + CaseNameSplit[b] + "']"));
						if (topicCategoryVal.size() > 0
								&& (topicCategoryVal.get(0).getText().trim().equals(InvalidCaseNameSplit[c]))) {
							d = false;
						}
						if (!CaseNameSplit[b].equals(InvalidCaseNameSplit[c])) {
							expectedValues.add(CaseNameSplit[b]);
						}
					}
				}

				// above will search the Case
				if (nextCount == 0 || nextButton.isEnabled()) {
					waitForElementToBeClickable(driver, nextButton);
					nextButton.click();
				}
				if (!nextButton.isEnabled()) {
					nextCount++;
				}

			}
			driver.switchTo().defaultContent();
		}
		// Filter Extent Report Results with results having 'No Display' message
		if (Case.equals("Payroll Cases") || Case.equals("Total Rewards Cases")
				|| Case.equals("Workforce Administration Cases")) {

			if (d == false) {
				test.get().log(Status.FAIL, MarkupHelper.createLabel(
						Case + " is displayed with any of invalid values: " + InvalidCaseName, ExtentColor.RED));
				logFailureScreenshot(driver);
			} else {
				test.get().log(Status.PASS, MarkupHelper
						.createLabel(Case + " is displayed alone with: " + (expectedValues), ExtentColor.GREEN));
				logSuccessScreenshot(driver);
			}
		}
	}

	/**
	 *  *****************************************************************************************************************************************************************************************/

	/****************************************
	 * TC9
	 ************************************************/
	public void UserGroupCasesTestHRSM_NoRecords(String Case, String CaseName, String InvalidCaseName)
			throws InterruptedException, IOException {
		PageFactory.initElements(driver, SecurityFormPage.class);
		adminPortalGear();
		if (Case.equals("Employee Services Cases")) {
			noRecordsDisplaymsg("Employee Services Cases");

			logSuccess("Expected Value - " + "Employee Services Cases");
			logSuccess("Actual Value - " + Case);
		}
		if (Case.equals("HRIT Cases")) {
			noRecordsDisplaymsg("HRIT Cases");

			logSuccess("Expected Value - " + "HRIT Cases");
			logSuccess("Actual Value - " + Case);
		}

		if (Case.equals("Payroll Cases")) {
			noRecordsDisplaymsg("Payroll Cases");

			logSuccess("Expected Value - " + "Payroll Cases");
			logSuccess("Actual Value - " + Case);
		}

		if (Case.equals("Total Rewards Cases")) {
			noRecordsDisplaymsg("Total Rewards Cases");

			logSuccess("Expected Value - " + "Total Rewards Cases");
			logSuccess("Actual Value - " + Case);

		}

		if (Case.equals("Workforce Administration Cases")) {
			noRecordsDisplaymsg("Workforce Administration Cases");

			logSuccess("Expected Value - " + "Workforce Administration Cases");
			logSuccess("Actual Value - " + Case);

		}

	}

	/**
	 *  *****************************************************************************************************************************************************************************************/

	/****************************************  ************************************************/
	public void UserGroupCasesTestShotaMatayoshi(String Case, String CaseName, String InvalidCaseName)
			throws InterruptedException, IOException {
		PageFactory.initElements(driver, SecurityFormPage.class);
		adminPortalGear();
		int c;
		int nextCount = 0;
		boolean d = true;

		HashSet<String> expectedValues = new HashSet<String>();
		String[] CaseNameSplit = CaseName.split(",");
		String[] InvalidCaseNameSplit = InvalidCaseName.split(",");

		if (Case.equals("HRIT Cases")) {
			noRecordsDisplaymsg("HRIT Cases");

			logSuccess("Expected Value - " + "HRIT Cases");
			logSuccess("Actual Value - " + Case);
		}

		if (Case.equals("Payroll Cases")) {
			noRecordsDisplaymsg("Payroll Cases");

			logSuccess("Expected Value - " + "Payroll Cases");
			logSuccess("Actual Value - " + Case);
		}
		if (Case.equals("Workforce Administration Cases")) {
			noRecordsDisplaymsg("Workforce Administration Cases");

			logSuccess("Expected Value - " + "Workforce Administration Cases");
			logSuccess("Actual Value - " + Case);
		}

		if (Case.equals("Employee Services Cases")
				// || Case.equals("HRIT Cases")
				// || Case.equals("Payroll Cases")
				|| Case.equals("Total Rewards Cases")
		// || Case.equals("Workforce Administration Cases")
		) {

			filterNavi.sendKeys(Case);
			filterNavi.sendKeys(Keys.ENTER);
			waitForFrameToBeAvailableByIndex(driver, 0);
			// personilizeList(columnsForLeftToRight, columnsToKeep);
			waitForElement(driver, nextButton);

			if (!nextButton.isEnabled()) {
				nextCount++;
			}

			while (nextButton.isEnabled() || nextCount == 1) {

				// below will search the Case
				for (int b = 0; b < CaseNameSplit.length; b++) {
					for (c = 0; c < InvalidCaseNameSplit.length; c++) {
						List<WebElement> topicCategoryVal = driver
								.findElements(By.xpath("//a[text()='" + CaseNameSplit[b] + "']"));
						if (topicCategoryVal.size() > 0
								&& (topicCategoryVal.get(0).getText().trim().equals(InvalidCaseNameSplit[c]))) {
							d = false;
						}
						if (!CaseNameSplit[b].equals(InvalidCaseNameSplit[c])) {
							expectedValues.add(CaseNameSplit[b]);
						}
					}
				}

				// above will search the Case
				if (nextCount == 0 || nextButton.isEnabled()) {
					waitForElementToBeClickable(driver, nextButton);
					nextButton.click();
				}
				if (!nextButton.isEnabled()) {
					nextCount++;
				}

			}
			driver.switchTo().defaultContent();
		}
		// Filter Extent Report Results with results having 'No Display' message
		if (Case.equals("Employee Services Cases")
				// || Case.equals("HRIT Cases")
				// || Case.equals("Payroll Cases")
				|| Case.equals("Total Rewards Cases")
		// || Case.equals("Workforce Administration Cases")
		) {

			if (d == false) {
				test.get().log(Status.FAIL, MarkupHelper.createLabel(
						Case + " is displayed with any of invalid values: " + InvalidCaseName, ExtentColor.RED));
				logFailureScreenshot(driver);
			} else {
				test.get().log(Status.PASS, MarkupHelper
						.createLabel(Case + " is displayed alone with: " + (expectedValues), ExtentColor.GREEN));
				logSuccessScreenshot(driver);
			}
		}
	}

	/**
	 *  *****************************************************************************************************************************************************************************************/

	/****************************************  ************************************************/
	public void UserGroupCasesTestFannieMoy(String Case, String CaseName, String InvalidCaseName)
			throws InterruptedException, IOException {
		PageFactory.initElements(driver, SecurityFormPage.class);
		adminPortalGear();
		int c;
		int nextCount = 0;
		boolean d = true;

		HashSet<String> expectedValues = new HashSet<String>();
		String[] CaseNameSplit = CaseName.split(",");
		String[] InvalidCaseNameSplit = InvalidCaseName.split(",");

		if (Case.equals("Employee Services Cases")) {
			noRecordsDisplaymsg("Employee Services Cases");

			logSuccess("Expected Value - " + "Employee Services Cases");
			logSuccess("Actual Value - " + Case);

		}
		if (Case.equals("HRIT Cases")) {
			noRecordsDisplaymsg("HRIT Cases");

			logSuccess("Expected Value - " + "HRIT Cases");
			logSuccess("Actual Value - " + Case);
		}

		if (Case.equals("Payroll Cases")) {
			noRecordsDisplaymsg("Payroll Cases");

			logSuccess("Expected Value - " + "Payroll Cases");
			logSuccess("Actual Value - " + Case);

		}
		if (Case.equals("Workforce Administration Cases")) {
			noRecordsDisplaymsg("Workforce Administration Cases");

			logSuccess("Expected Value - " + "Workforce Administration Cases");
			logSuccess("Actual Value - " + Case);

		}

		if (
		// Case.equals("Employee Services Cases")
		// || Case.equals("HRIT Cases")
		// || Case.equals("Payroll Cases")
		Case.equals("Total Rewards Cases")
		// || Case.equals("Workforce Administration Cases")
		) {
			filterNavi.sendKeys(Case);
			filterNavi.sendKeys(Keys.ENTER);
			waitForFrameToBeAvailableByIndex(driver, 0);
			// personilizeList(columnsForLeftToRight, columnsToKeep);
			waitForElement(driver, nextButton);

			if (!nextButton.isEnabled()) {
				nextCount++;
			}

			while (nextButton.isEnabled() || nextCount == 1) {

				// below will search the Case
				for (int b = 0; b < CaseNameSplit.length; b++) {
					for (c = 0; c < InvalidCaseNameSplit.length; c++) {
						List<WebElement> topicCategoryVal = driver
								.findElements(By.xpath("//a[text()='" + CaseNameSplit[b] + "']"));
						if (topicCategoryVal.size() > 0
								&& (topicCategoryVal.get(0).getText().trim().equals(InvalidCaseNameSplit[c]))) {
							d = false;
						}
						if (!CaseNameSplit[b].equals(InvalidCaseNameSplit[c])) {
							expectedValues.add(CaseNameSplit[b]);
						}
					}
				}

				// above will search the Case
				if (nextCount == 0 || nextButton.isEnabled()) {
					waitForElementToBeClickable(driver, nextButton);
					nextButton.click();
				}
				if (!nextButton.isEnabled()) {
					nextCount++;
				}

			}
			driver.switchTo().defaultContent();
		}
		// Filter Extent Report Results with results having 'No Display' message
		if (
		// Case.equals("Employee Services Cases")
		// || Case.equals("HRIT Cases")
		// || Case.equals("Payroll Cases")
		Case.equals("Total Rewards Cases")
		// || Case.equals("Workforce Administration Cases")
		) {

			if (d == false) {
				test.get().log(Status.FAIL, MarkupHelper.createLabel(
						Case + " is displayed with any of invalid values: " + InvalidCaseName, ExtentColor.RED));
				logFailureScreenshot(driver);
			} else {
				test.get().log(Status.PASS, MarkupHelper
						.createLabel(Case + " is displayed alone with: " + (expectedValues), ExtentColor.GREEN));
				logSuccessScreenshot(driver);
			}
		}
	}

	/**
	 *  *****************************************************************************************************************************************************************************************/

	public void UserGroupCasesTestWBSFGroup(String Case, String CaseName, String InvalidCaseName)
			throws InterruptedException, IOException {
		PageFactory.initElements(driver, SecurityFormPage.class);
		adminPortalGear();
		int c;
		int nextCount = 0;
		boolean d = true;

		HashSet<String> expectedValues = new HashSet<String>();
		String[] CaseNameSplit = CaseName.split(",");
		String[] InvalidCaseNameSplit = InvalidCaseName.split(",");

		if (Case.equals("Employee Services Cases")) {
			noRecordsDisplaymsg("Employee Services Cases");

			logSuccess("Expected Value - " + "Employee Services Cases");
			logSuccess("Actual Value - " + Case);
		}
		if (Case.equals("HRIT Cases")) {
			noRecordsDisplaymsg("HRIT Cases");

			logSuccess("Expected Value - " + "HRIT Cases");
			logSuccess("Actual Value - " + Case);

		}
		if (Case.equals("Payroll Cases")) {
			noRecordsDisplaymsg("Payroll Cases");

			logSuccess("Expected Value - " + "Payroll Cases");
			logSuccess("Actual Value - " + Case);
		}
		if (Case.equals("Total Rewards Cases")) {
			noRecordsDisplaymsg("Total Rewards Cases");

			logSuccess("Expected Value - " + "Total Rewards Cases");
			logSuccess("Actual Value - " + Case);
		}

		if (
		// Case.equals("Employee Services Cases")
		// || Case.equals("HRIT Cases")
		// || Case.equals("Payroll Cases")
		// || Case.equals("Total Rewards Cases")
		Case.equals("Workforce Administration Cases")) {
			filterNavi.sendKeys(Case);
			filterNavi.sendKeys(Keys.ENTER);
			waitForFrameToBeAvailableByIndex(driver, 0);
			// personilizeList(columnsForLeftToRight, columnsToKeep);
			waitForElement(driver, nextButton);

			if (!nextButton.isEnabled()) {
				nextCount++;
			}

			while (nextButton.isEnabled() || nextCount == 1) {

				// below will search the Case
				for (int b = 0; b < CaseNameSplit.length; b++) {
					for (c = 0; c < InvalidCaseNameSplit.length; c++) {
						List<WebElement> topicCategoryVal = driver
								.findElements(By.xpath("//a[text()='" + CaseNameSplit[b] + "']"));
						if (topicCategoryVal.size() > 0
								&& (topicCategoryVal.get(0).getText().trim().equals(InvalidCaseNameSplit[c]))) {
							d = false;
						}
						if (!CaseNameSplit[b].equals(InvalidCaseNameSplit[c])) {
							expectedValues.add(CaseNameSplit[b]);
						}
					}
				}

				// above will search the Case
				if (nextCount == 0 || nextButton.isEnabled()) {
					waitForElementToBeClickable(driver, nextButton);
					nextButton.click();
				}
				if (!nextButton.isEnabled()) {
					nextCount++;
				}

			}
			driver.switchTo().defaultContent();
		}
		// Filter Extent Report Results with results having 'No Display' message
		if (
		// Case.equals("Employee Services Cases")
		// || Case.equals("HRIT Cases")
		// || Case.equals("Payroll Cases")
		// || Case.equals("Total Rewards Cases")
		Case.equals("Workforce Administration Cases")) {

			if (d == false) {
				test.get().log(Status.FAIL, MarkupHelper.createLabel(
						Case + " is displayed with any of invalid values: " + InvalidCaseName, ExtentColor.RED));
				logFailureScreenshot(driver);
			} else {
				test.get().log(Status.PASS, MarkupHelper
						.createLabel(Case + " is displayed alone with: " + (expectedValues), ExtentColor.GREEN));
				logSuccessScreenshot(driver);
			}
		}
	}

	/**
	 *  *****************************************************************************************************************************************************************************************/

	public void UserGroupCasesTestLearnOrg(String Case, String CaseName, String InvalidCaseName)
			throws InterruptedException, IOException {
		PageFactory.initElements(driver, SecurityFormPage.class);
		adminPortalGear();
		int c;
		int nextCount = 0;
		boolean d = true;

		HashSet<String> expectedValues = new HashSet<String>();
		String[] CaseNameSplit = CaseName.split(",");
		String[] InvalidCaseNameSplit = InvalidCaseName.split(",");

		if (Case.equals("Employee Services Cases")) {
			noRecordsDisplaymsg("Employee Services Cases");

			logSuccess("Expected Value - " + "Employee Services Cases");
			logSuccess("Actual Value - " + Case);

		}
		if (Case.equals("HRIT Cases")) {
			noRecordsDisplaymsg("HRIT Cases");

			logSuccess("Expected Value - " + "HRIT Cases");
			logSuccess("Actual Value - " + Case);

		}
		if (Case.equals("Payroll Cases")) {
			noRecordsDisplaymsg("Payroll Cases");

			logSuccess("Expected Value - " + "Payroll Cases");
			logSuccess("Actual Value - " + Case);

		}
		if (Case.equals("Workforce Administration Cases")) {
			noRecordsDisplaymsg("Workforce Administration Cases");

			logSuccess("Expected Value - " + "Workforce Administration Cases");
			logSuccess("Actual Value - " + Case);

		}

		if (
		// Case.equals("Employee Services Cases")
		// || Case.equals("HRIT Cases")
		// || Case.equals("Payroll Cases")
		Case.equals("Total Rewards Cases"))
		// Case.equals("Workforce Administration Cases"))
		{

			filterNavi.sendKeys(Case);
			filterNavi.sendKeys(Keys.ENTER);
			waitForFrameToBeAvailableByIndex(driver, 0);
			// personilizeList(columnsForLeftToRight, columnsToKeep);
			waitForElement(driver, nextButton);

			if (!nextButton.isEnabled()) {
				nextCount++;
			}

			while (nextButton.isEnabled() || nextCount == 1) {

				// below will search the Case
				for (int b = 0; b < CaseNameSplit.length; b++) {
					for (c = 0; c < InvalidCaseNameSplit.length; c++) {
						List<WebElement> topicCategoryVal = driver
								.findElements(By.xpath("//a[text()='" + CaseNameSplit[b] + "']"));
						if (topicCategoryVal.size() > 0
								&& (topicCategoryVal.get(0).getText().trim().equals(InvalidCaseNameSplit[c]))) {
							d = false;
						}
						if (!CaseNameSplit[b].equals(InvalidCaseNameSplit[c])) {
							expectedValues.add(CaseNameSplit[b]);
						}
					}
				}

				// above will search the Case
				if (nextCount == 0 || nextButton.isEnabled()) {
					waitForElementToBeClickable(driver, nextButton);
					nextButton.click();
				}
				if (!nextButton.isEnabled()) {
					nextCount++;
				}
			}
			driver.switchTo().defaultContent();
		}
		// Filter Extent Report Results with results having 'No Display' message
		if (
		// Case.equals("Employee Services Cases")
		// || Case.equals("HRIT Cases")
		// || Case.equals("Payroll Cases")
		Case.equals("Total Rewards Cases")
		// Case.equals("Workforce Administration Cases")
		) {

			if (d == false) {
				test.get().log(Status.FAIL, MarkupHelper.createLabel(
						Case + " is displayed with any of invalid values: " + InvalidCaseName, ExtentColor.RED));
				logFailureScreenshot(driver);
			} else {
				test.get().log(Status.PASS, MarkupHelper
						.createLabel(Case + " is displayed alone with: " + (expectedValues), ExtentColor.GREEN));
				logSuccessScreenshot(driver);
			}
		}
	}

	public void navigateToHRProfile(String hrProfileUser, boolean encryption) throws IOException, Exception {
		PageFactory.initElements(driver, SecurityFormPage.class);
		waitForElementToBeClickable(driver, navigationfilter);
		navigationfilter.sendKeys("HR Profiles");
		waitForElement(driver, hrProfiles);
		hrProfiles.click();
		checkForPageLoad(driver);
		// driver.switchTo().frame(0);
		waitForFrameToBeAvailable(driver, "gsft_main");
		System.out.println("HR Profiles - " + driver.getTitle());
		if (driver.getTitle().contains("HR Profiles")) {
			logInfo("Navigated to HR Profiles Successfully.");

			logSuccess("Expected Value - " + "HR Profiles");
			logSuccess("Actual Value - " + driver.getTitle());

			logInfoScreenshot(driver);
		} else {
			logFailure("Navigation to HR Profiles Failed.");

			logFailure("Expected Value - " + "HR Profiles");
			logFailure("Actual Value - " + driver.getTitle());

			logFailureScreenshot(driver);
		}

		waitForElement(driver, searchHRProfileDropDown);
		if (isElementPresentList(searchHRProfileDropDownList)) {
			Select select = new Select(searchHRProfileDropDown);
			select.selectByVisibleText("User");
			searchHRProfile.sendKeys(hrProfileUser);
			searchHRProfile.sendKeys(Keys.ENTER);
			waitForFrameToBeAvailable(driver, "gsft_main");
			waitForElement(driver, searchHRProfileText);
			searchHRProfileText.sendKeys(hrProfileUser);
			searchHRProfileText.sendKeys(Keys.ENTER);
			waitForFrameToBeAvailable(driver, "gsft_main");

			logInfo("Searching User Profile for user  - " + hrProfileUser);
			logInfoScreenshot(driver);
			waitForElement(driver, driver.findElement(By.xpath("//*[text() ='" + hrProfileUser
					+ "' and @class='linked']/parent::td/preceding-sibling::td/a[contains(@class, 'icon-info')]")));
			WebElement iIcon = driver.findElement(By.xpath("//*[text() ='" + hrProfileUser
					+ "' and @class='linked']/parent::td/preceding-sibling::td/a[contains(@class, 'icon-info')]"));
			iIcon.click();
			waitForFrameToBeAvailable(driver, "gsft_main");
			waitForElement(driver, openRecord);
			openRecord.click();

			checkForPageLoad(driver);
			waitForFrameToBeAvailable(driver, "gsft_main");
			waitForElement(driver, userProfileName);
			if (userProfileName.getAttribute("value").trim().contains(hrProfileUser)) {
				logInfo("Navigated to HR Profile for User - " + hrProfileUser);

				logSuccess("Expected Value - " + hrProfileUser);
				logSuccess("Actual Value - " + userProfileName.getAttribute("value").trim());

				logInfoScreenshot(driver);
			} else {
				logFailure("Navigattion to HR Profilr for User  - " + hrProfileUser + "Failed.");

				logFailure("Expected Value - " + hrProfileUser);
				logFailure("Actual Value - " + userProfileName.getAttribute("value").trim());

				logFailureScreenshot(driver);
			}

			int count = 0;

			if (encryption) {

				if (isElementPresentList(pinHrProfileList)) {
					logSuccess("Pin field is available for user with encryption access with value "
							+ pinHrProfile.getAttribute("value"));
				} else {
					count++;
					logFailure("Pin field is not available for user with encryption access");
				}

				if (isElementPresentList(homePostalCodeHrProfileList)) {
					logSuccess("Home Postal Code field is available for user with encryption access with value "
							+ homePostalCodeHrProfile.getAttribute("value"));
				} else {
					count++;
					logFailure("Home Postal Code field is not available for user with encryption access");
				}

				if (isElementPresentList(unionCodeHrProfileList)) {
					logSuccess("Union Occ Code field is available for user with encryption access with value "
							+ unionCodeHrProfile.getAttribute("value"));
				} else {
					count++;
					logFailure("Union Occ Code field is not available for user with encryption access");
				}
			} else {
				if (!isElementPresentList(pinHrProfileList)) {
					logSuccess("Pin field is not available for user without encryption access with value ");
				} else {
					count++;
					logFailure("Pin field is available for user without encryption access - "
							+ pinHrProfile.getAttribute("value"));
				}

				if (!isElementPresentList(homePostalCodeHrProfileList)) {
					logSuccess(
							"Home Postal Code field is not available for user without encryption access with value ");
				} else {
					count++;
					logFailure("Home Postal Code field is available for user without encryption access - "
							+ homePostalCodeHrProfile.getAttribute("value"));
				}

				if (!isElementPresentList(unionCodeHrProfileList)) {
					logSuccess("Union Occ Code field is not available for user without encryption access with value ");
				} else {
					count++;
					logFailure("Union Occ Code field is available for user without encryption access - "
							+ unionCodeHrProfile.getAttribute("value"));
				}
			}

			if (count == 0) {
				logSuccessScreenshot(driver);
			} else {
				logFailureScreenshot(driver);
			}

		} else {
			logFailure("Search Drop Down is not displayed");
			logFailureScreenshot(driver);
		}
	}

	public void validateHRProfile(boolean encryption) throws IOException {
		PageFactory.initElements(driver, SecurityFormPage.class);
		int count = 0;

		if (encryption) {
			if (isElementPresentList(pinHrProfileList)) {
				logSuccess("Pin field is available for user with encryption access with value "
						+ pinHrProfile.getAttribute("value"));
			} else {
				count++;
				logFailure("Pin field is not available for user with encryption access");
			}

			if (isElementPresentList(homePostalCodeHrProfileList)) {
				logSuccess("Home Postal Code field is available for user with encryption access with value "
						+ homePostalCodeHrProfile.getAttribute("value"));
			} else {
				count++;
				logFailure("Home Postal Code field is not available for user with encryption access");
			}

			if (isElementPresentList(jobFamilyGroupNameHrProfileList)) {
				logSuccess("Job Family Group Name field is available for user with encryption access with value "
						+ jobFamilyGroupNameHrProfile.getAttribute("value"));
			} else {
				count++;
				logFailure("Job Family Group Name field is not available for user with encryption access");
			}

			if (isElementPresentList(jobFamilyHrProfileList)) {
				logSuccess("Job Family field is available for user with encryption access with value "
						+ jobFamilyHrProfile.getAttribute("value"));
			} else {
				count++;
				logFailure("Job Family field is not available for user with encryption access");
			}

			if (isElementPresentList(unionCodeHrProfileList)) {
				logSuccess("Union Occ Code field is available for user with encryption access with value "
						+ unionCodeHrProfile.getAttribute("value"));
			} else {
				count++;
				logFailure("Union Occ Code field is not available for user with encryption access");
			}
		} else {
			if (!isElementPresentList(pinHrProfileList)) {
				logSuccess("Pin field is not available for user without encryption access with value ");
			} else {
				count++;
				logFailure("Pin field is available for user without encryption access - "
						+ pinHrProfile.getAttribute("value"));
			}

			if (!isElementPresentList(homePostalCodeHrProfileList)) {
				logSuccess("Home Postal Code field is not available for user without encryption access with value ");
			} else {
				count++;
				logFailure("Home Postal Code field is available for user without encryption access - "
						+ homePostalCodeHrProfile.getAttribute("value"));
			}

			if (!isElementPresentList(jobFamilyGroupNameHrProfileList)) {
				logSuccess(
						"Job Family Group Name field is not available for user without encryption access with value ");
			} else {
				count++;
				logFailure("Job Family Group Name field is available for user without encryption access - "
						+ jobFamilyGroupNameHrProfile.getAttribute("value"));
			}

			if (!isElementPresentList(jobFamilyHrProfileList)) {
				logSuccess("Job Family field is not available for user without encryption access with value ");
			} else {
				count++;
				logFailure("Job Family field is available for user without encryption access - "
						+ jobFamilyHrProfile.getAttribute("value"));
			}

			if (!isElementPresentList(unionCodeHrProfileList)) {
				logSuccess("Union Occ Code field is not available for user without encryption access with value ");
			} else {
				count++;
				logFailure("Union Occ Code field is available for user without encryption access - "
						+ unionCodeHrProfile.getAttribute("value"));
			}
		}

		if (count == 0) {
			logSuccessScreenshot(driver);
		} else {
			logFailureScreenshot(driver);
		}
	}

	public static List<Set<String>> compareTwoListSecurity(List<String> inputdata, List<String> applicationdata) {
		Set<String> matcheddata = new HashSet<>();
		Set<String> unmatcheddata = new HashSet<>();
		Set<String> remove = new HashSet<>();

		for (int k = 0; k < applicationdata.size(); k++) {
			if (inputdata.contains(applicationdata.get(k))) {
				matcheddata.add(applicationdata.get(k));
				System.out.println("Adding to matched data - " + applicationdata.get(k));
			} else {
				System.out.println("Adding to unmatched data - " + applicationdata.get(k));
				unmatcheddata.add(applicationdata.get(k));
			}
		}

		for (String string : unmatcheddata) {
			for (String string2 : matcheddata) {
				if (string.equals(string2)) {
					remove.add(string);
				}
			}
		}

		for (String string : remove) {
			if (unmatcheddata.contains(string)) {
				unmatcheddata.remove(string);

			}
		}

		List<Set<String>> result = new ArrayList<Set<String>>();
		result.add(matcheddata);
		result.add(unmatcheddata);

		return result;
	}

	public void displayAllCases(String caseName) throws Exception {
		PageFactory.initElements(driver, SecurityFormPage.class);

		try {
			filterNavi.sendKeys(caseName);
			filterNavi.sendKeys(Keys.ENTER);
			waitForFrameToBeAvailableByIndex(driver, 0);
			logInfo("Searching for the cases: " + caseName);
			if (NoRecords.getText().equals("No records to display")) {
				logInfo("No Records to display");
				logInfoScreenshot(driver);
			} else {

				if (NoRecords.getText().contains("Number of rows removed from this list by Security constraints:")) {

					test.get().log(Status.FAIL, MarkupHelper.createLabel(caseName
							+ " displays message as: Number of rows removed from this list by Security constraints (or) No Records to Display",
							ExtentColor.RED));
					logFailureScreenshot(driver);
				} else {

					test.get().log(Status.PASS, MarkupHelper.createLabel(
							caseName + " Total number of cases  appear= " + totalRows.getText(), ExtentColor.GREEN));
					logSuccessScreenshot(driver);
				}

			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		driver.switchTo().defaultContent();
		filterNavi.clear();
	}
}