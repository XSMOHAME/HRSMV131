
package com.snow.pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.snow.base.ReusableLibrary;

public class FileRequestPage extends ReusableLibrary {
	public WebDriver driver;

	public FileRequestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='s2id_sp_formfield_Select_Employee']/a")
	public WebElement selectWorker;

	@FindBy(xpath = "//label[contains(text(), 'Select Employee')]/following-sibling::input[contains(@class,'select2-input')]")
	public WebElement searchWorker;

	@FindBy(id = "sp_formfield_TWID")
	public WebElement twid;
	
	@FindBy(xpath = "//*[text()='File Request About']")
	public WebElement subHeader;

	@FindBy(id = "sp_formfield_First_Name")
	public WebElement firstName;

	@FindBy(id = "sp_formfield_Last_Name")
	public WebElement lastName;

	@FindBy(xpath = "//*[@id='s2id_sp_formfield_Select_Employee']/a")
	public WebElement selectWorker2;

	@FindBy(xpath = "//*[@id='select2-drop']/div/input")
	public WebElement inputWorker2;

	@FindBy(xpath = "//*[@id='select2-results-4']/li")
	public WebElement noMatch;

	@FindBy(xpath = "//*[@class='text-muted sc-cat-item-short-description ng-binding ng-scope']")
	public WebElement formShortDesc;

	@FindBy(xpath = "//*[@class='h2 m-t-none m-b-sm font-thin ng-binding ng-scope']")
	public WebElement formLabel;

	public void validateSelectWorker2(String worker) throws IOException, InterruptedException {
		PageFactory.initElements(driver, FileRequestPage.class);
		waitForElementToBeClickable(driver, selectWorker2);
		selectWorker2.click();
		waitForElementToBeClickable(driver, inputWorker2);
		inputWorker2.clear();
		inputWorker2.sendKeys(worker);
		waitForAction(driver);

		String actualValue = noMatch.getText();
		String expectedValue = "No matches found";

		if (actualValue.equals(expectedValue)) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"selectWorker2 Field is Autopopulated with value:  " + actualValue, ExtentColor.GREEN));
			logSuccess("Expected Value - " + expectedValue);
			logSuccess("Actual Value - " + actualValue);
			System.out.println("selectWorker2 Field is Autopopulated with value:  " + actualValue);
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("selectWorker2 Field value is not autopopulated" + expectedValue, ExtentColor.RED));
			logFailure("Expected Value - " + expectedValue);
			logFailure("Actual Value - " + actualValue);
		}
		inputWorker2.clear();
		inputWorker2.sendKeys(Keys.TAB);
	}

	/* Validation for Worker Information Section */
	public void validateSelectWorker(String worker) throws IOException, InterruptedException {
		PageFactory.initElements(driver, ResidualsFormPage.class);
		WebElement workerClick = null;
		scrollToElement(driver, subHeader);
		waitForElementToBeClickable(driver, selectWorker);
		selectWorker.click();
		waitForElementToBeClickable(driver, searchWorker);
		searchWorker.clear();
		waitForAction(driver);
		searchWorker.sendKeys(worker);
		waitForAction(driver);
		try {
			workerClick = driver.findElement(
					By.xpath("//*[contains(@class, 'select2-result-') and contains(text(), '" + worker + "')]"));
			workerClick.click();
		} catch (Exception e) {
			// TODO: handle exception
			if (isElementPresent(noMatch)) {
				System.out.println("Element not present for worker - " + worker);
				logFailure("Inactive Worker not found.");
				logFailure("Expected Worker - " + worker);
				logFailure("Actual Worker - " + noMatch.getText());
				searchWorker.sendKeys(Keys.TAB);
			}
		}

		waitForAction(driver);
		waitForElement(driver, twid);
		if (!twid.getAttribute("value").trim().isEmpty()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"TWID Field is Autopopulated with value:  " + twid.getAttribute("value").trim(),
							ExtentColor.GREEN));
			System.out.println("TWID Field is Autopopulated with value:  " + twid.getAttribute("value").trim());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"TWID Field value is not autopopulated" + twid.getAttribute("value").trim(), ExtentColor.RED));
		}

		if (!firstName.getAttribute("value").trim().isEmpty()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"First Name Field is Autopopulated with value:  " + firstName.getAttribute("value").trim(),
							ExtentColor.GREEN));
			System.out.println(
					"First Name Field is Autopopulated with value:  " + firstName.getAttribute("value").trim());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"First Name Field value is not autopopulated" + firstName.getAttribute("value").trim(),
							ExtentColor.RED));
		}

		if (!lastName.getAttribute("value").trim().isEmpty()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"Last Name Field is Autopopulated with value:  " + lastName.getAttribute("value").trim(),
							ExtentColor.GREEN));
			System.out
					.println("Last Name Field is Autopopulated with value:  " + lastName.getAttribute("value").trim());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"Last Name Field value is not autopopulated" + lastName.getAttribute("value").trim(),
							ExtentColor.RED));
		}

		test.get().log(Status.INFO, MarkupHelper
				.createLabel("Actual Autopopulation of field can be seen in belwo screenshot:", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	}

	public void verifyFormLableAndShortDesc(String expectedFormLabel, String expectedShortDesc) throws IOException {
		PageFactory.initElements(driver, FileRequestPage.class);
		String actualFormLabel = null;
		String actualFormShortDesc = null;
		if (formLabel.isDisplayed()) {
			actualFormLabel = formLabel.getText();

			if (actualFormLabel.contains(expectedFormLabel)) {
				test.get().log(Status.PASS,
						MarkupHelper.createLabel(
								"Displayed Form Label matches with expected Form Label: " + actualFormLabel,
								ExtentColor.GREEN));
				logSuccess("Expected Value - " + expectedFormLabel);
				logSuccess("Actual Value - " + actualFormLabel);
			} else {
				test.get().log(Status.FAIL, MarkupHelper
						.createLabel("Displayed Form Label does not match with expected Form Label", ExtentColor.RED));
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("Actual Label - " + actualFormLabel, ExtentColor.RED));
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("Actual Label - " + expectedFormLabel, ExtentColor.RED));
				logFailure("Expected Value - " + expectedFormLabel);
				logFailure("Actual Value - " + actualFormLabel);
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}

			if (formShortDesc.isDisplayed()) {
				actualFormShortDesc = formShortDesc.getText();
				if (actualFormShortDesc.contains(expectedShortDesc)) {
					test.get().log(Status.PASS,
							MarkupHelper.createLabel(
									"Displayed Form Label matches with expected Form Label: " + actualFormShortDesc,
									ExtentColor.GREEN));
					logSuccess("Expected Value - " + expectedShortDesc);
					logSuccess("Actual Value - " + actualFormShortDesc);
				} else {
					test.get().log(Status.FAIL, MarkupHelper.createLabel(
							"Displayed Form Label does not match with expected Form Label: " + actualFormShortDesc,
							ExtentColor.RED));
					logFailure("Expected Value - " + expectedShortDesc);
					logFailure("Actual Value - " + actualFormShortDesc);
					screenshotPath = getScreenshot(driver, this.getClass().getName());
					test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				}
			}
		}
	}
}