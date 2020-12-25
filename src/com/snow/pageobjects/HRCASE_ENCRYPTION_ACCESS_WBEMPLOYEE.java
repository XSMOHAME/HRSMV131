package com.snow.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.snow.base.ReusableLibrary;

public class HRCASE_ENCRYPTION_ACCESS_WBEMPLOYEE extends ReusableLibrary {
	public WebDriver driver;

	public HRCASE_ENCRYPTION_ACCESS_WBEMPLOYEE(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h4[contains(text(),'Cloud Hosting & Tools')]")

	public WebElement cloud_hosting;
	@FindBy(xpath = "//input[@id='filter']")
	public WebElement leftSearch;
	@FindBy(xpath = "//div[text()='Create New Case']")
	public WebElement createCase;

	public void validating_itilview() throws Exception {
		checkForPageLoad(driver);
//		if(driver.getTitle().equals("Service Portal - 4Help")) {
//			test.get().log(Status.PASS, MarkupHelper.createLabel(
//					" unable to access  HR Scope ITIL view so user  will not have access to HR Cases and therefore user will not have visibility into the PII data associated with HR Cases",
//					ExtentColor.GREEN));
//			screenshotPath = getScreenshot(driver, this.getClass().getName());
//			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//		}else {
//			test.get().log(Status.FAIL, MarkupHelper
//					.createLabel("ITIL view is visible so user is able to access HR cases", ExtentColor.RED));
//			screenshotPath = getScreenshot(driver, this.getClass().getName());
//			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//		}
		driver.get(homePageURL);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, leftSearch);
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		leftSearch.sendKeys("HR CASE");
		checkForPageLoad(driver);
		if (driver.getPageSource().contains("Create New Case")) {
			logFailure("Encryption user is able to see the HR cases");
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			logSuccess("Encryption user is not able to see the HR cases");
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}
}
