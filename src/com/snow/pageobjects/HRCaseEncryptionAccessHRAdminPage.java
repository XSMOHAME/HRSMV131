package com.snow.pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.snow.base.ReusableLibrary;

public class HRCaseEncryptionAccessHRAdminPage extends ReusableLibrary {
	public WebDriver driver;

	public HRCaseEncryptionAccessHRAdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='s2id_sp_formfield_ssn_sw']/a")
	public WebElement selectWorker;

	@FindBy(xpath = "//*[contains(@class,'select2-input')]")
	public WebElement searchWorker;

	@FindBy(xpath = "//ul/li[contains(@class, 'select2-results')]")
	public WebElement workerFromSearchResult;

	@FindBy(xpath = "//input[@id='sp_formfield_BN_Corp']")
	public WebElement benificiary_name;

	@FindBy(xpath = "//input[@id='sp_formfield_bene_ssnorfein']")
	public WebElement ssn_fien;

	@FindBy(xpath = "//input[@id='sp_formfield_dateof_worker_death']")
	public WebElement death_date;

	@FindBy(xpath = "(//button[@name='submit' and text()='Submit'])[1]")
	public WebElement submit_button;

	@FindBy(xpath = "//div[@class='title-info ng-binding']")
	public WebElement casenumber;

	@FindBy(xpath = "//input[@id='filter']")
	public WebElement leftSearch;

	@FindBy(xpath = "(//div[text()='All'])[2]")
	public WebElement hrDashboard;

	@FindBy(xpath = "//select[@class='form-control default-focus-outline']")
	public WebElement search_dropDown;

	@FindBy(xpath = "//input[@class='form-control'][@placeholder='Search']")
	public WebElement search_field;

	@FindBy(xpath = "//a[@class='linked formlink']")
	public WebElement number;

	@FindBy(xpath = "//input[contains(@id, 'sn_hr_core_case_workforce_admin.hr_profile.u_home_postal_code') and @readonly]")
	public WebElement postalcode;

	@FindBy(xpath = "//input[contains(@id, 'sn_hr_core_case_workforce_admin.hr_profile.u_home_postal_code') and @readonly]")
	public List<WebElement> postalcodeList;

	@FindBy(xpath = "//input[contains(@id, 'sn_hr_core_case_workforce_admin.hr_profile.ssn') and @readonly]")
	public WebElement pin;

	@FindBy(xpath = "//input[contains(@id, 'sn_hr_core_case_workforce_admin.hr_profile.ssn') and @readonly]")
	public List<WebElement> pinList;

	@FindBy(xpath = "//input[@id='sys_readonly.sn_hr_core_case_workforce_admin.subject_person_hr_profile.u_union_code']")
	public WebElement unionocc_field;

	@FindBy(xpath = "//input[@id='sys_readonly.sn_hr_core_case_workforce_admin.subject_person_hr_profile.u_union_code']")
	public List<WebElement> unionocc_fieldList;

	@FindBy(xpath = " //input[@id='sn_hr_core_case_workforce_admin.u_beneficiary_s_ssn']")
	public WebElement benificiery_field;

	@FindBy(xpath = " //input[@id='sn_hr_core_case_workforce_admin.u_beneficiary_s_ssn']")
	public List<WebElement> benificiery_fieldList;

	@FindBy(xpath = "//input[@name='q']")
	public WebElement residual_searchbar;

	@FindBy(xpath = "//i[@class='fa fa-search']")
	public WebElement residual_searchbar_click;

	@FindBy(xpath = "//span[contains(text(),'Residuals: Beneficiary Request')] ")
	public WebElement residual_form;

	@FindBy(xpath = "//a[@class='btn btn-icon table-btn-lg icon-info list_popup']")
	public WebElement Iicon;

	@FindBy(xpath = "//a[text() = 'Open Record']")
	public WebElement openRecord;

	// String hrcasenumber;

	public String filling_residualform(String workername, String beneficiaryname, String ssncode, String date)
			throws IOException, InterruptedException {
		waitForElementToBeClickable(driver, residual_searchbar);
		residual_searchbar.sendKeys("Residuals: Beneficiary Request");
		waitForElementToBeClickable(driver, residual_searchbar_click);
		residual_searchbar_click.click();

		waitForElementToBeClickable(driver, residual_form);
		residual_form.click();

		waitForElementToBeClickable(driver, selectWorker);
		selectWorker.click();
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, searchWorker);
		searchWorker.clear();
		searchWorker.sendKeys(workername);
		checkForPageLoad(driver);
		waitForElementToBeClickable(driver, workerFromSearchResult);
		workerFromSearchResult.click();

		waitForElementToBeClickable(driver, benificiary_name);
		benificiary_name.sendKeys(beneficiaryname);
		waitForElementToBeClickable(driver, ssn_fien);
		ssn_fien.sendKeys(ssncode);
		waitForElementToBeClickable(driver, death_date);
		death_date.sendKeys(date);
		waitForElementToBeClickable(driver, ssn_fien);
		ssn_fien.click();
		waitForAction(driver);

		test.get().log(Status.INFO,
				MarkupHelper.createLabel("** Residuals Beneficiary request form details filled **", ExtentColor.CYAN));
		screenshotPath = getScreenshot(driver, this.getClass().getName());
		test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		scrollToElement(driver, submit_button);
		waitForElementToBeClickable(driver, submit_button);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", submit_button);

		waitForElement(driver, casenumber);
		String hrcasenumber = casenumber.getText();
		System.out.println("HR CASE NUMBER IS - " + hrcasenumber);
		System.out.println("HR CASE URL IS - " + driver.getCurrentUrl());
		if (casenumber.isDisplayed()) {
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("** Residuals Beneficiary request form submitted sucessful sly **", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"** Residuals Beneficiary request form should not submitted sucessful sly **", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		return hrcasenumber;
	}

	public void navigateToHRDashboard(String hrcasenumber) throws Exception {
		leftSearch.sendKeys("All Hr Cases");
		waitForElementToBeClickable(driver, hrDashboard);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", hrDashboard);
		// driver.switchTo().frame(0);
		waitForFrameToBeAvailable(driver, "gsft_main");
		Select select = new Select(search_dropDown);
		select.selectByVisibleText("Number");
		search_field.sendKeys(hrcasenumber);
		search_field.sendKeys(Keys.ENTER);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, Iicon);
		Iicon.click();
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, openRecord);
		openRecord.click();
		waitForFrameToBeAvailable(driver, "gsft_main");
		// number.click();
	}

	public void validatingfields() throws Exception {
		String postal = postalcode.getAttribute("value");
		String pincode = pin.getAttribute("value");
		String unioncode = unionocc_field.getAttribute("value");
		String benificiaryname = benificiery_field.getAttribute("value");

		if (postalcode.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"**Home Postal Code is visible in the Home Postal Code field and postal code is**:  " + postal,
					ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(" Home Postal Code is not visible", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		if (pin.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"**pin Code is visible in the pin Code field and pin code is**:  " + pincode, ExtentColor.GREEN));
		} else {

			test.get().log(Status.FAIL, MarkupHelper.createLabel(" pin Code is not visible", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		if (unionocc_field.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"**unionocc Code is visible in the unionocc Code field and code is**:  " + unioncode,
							ExtentColor.GREEN));
		} else {

			test.get().log(Status.FAIL, MarkupHelper.createLabel("unionocc Code is not visible", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		if (benificiery_field.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"**benificiary Code is visible in the benificiary Code field and code is**:  " + benificiaryname,
					ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("benificiary Code is not visible", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	public void validatingfields_available_or_not() throws Exception {
		if (!isElementPresentList(postalcodeList)) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**Home Postal Code filed is not visible**", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Home Postal Code is visible", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		if (!isElementPresentList(pinList)) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**pin Code field is not visible**", ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(" pin Code field is visible", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		if (!isElementPresentList(unionocc_fieldList)) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**unionocc Code field is not visible **", ExtentColor.GREEN));
		} else {

			test.get().log(Status.FAIL, MarkupHelper.createLabel("unionocc Code field is visible", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		if (!isElementPresentList(benificiery_fieldList)) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**benificiary Code field is not visible **", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("benificiary Code field is visible", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}
}