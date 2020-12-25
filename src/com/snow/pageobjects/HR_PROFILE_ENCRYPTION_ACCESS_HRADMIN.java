package com.snow.pageobjects;

import org.openqa.selenium.By;
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

public class HR_PROFILE_ENCRYPTION_ACCESS_HRADMIN extends ReusableLibrary {
	public WebDriver driver;

	public HR_PROFILE_ENCRYPTION_ACCESS_HRADMIN(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='filter']")
	public WebElement leftSearch;

	@FindBy(xpath = "//div[text()='HR Profiles']")
	public WebElement hrDashboard;

	@FindBy(xpath = "//iframe[@id='gsft_main']")
	public WebElement frame;

	@FindBy(xpath = "//h2[text()='HR Profiles']")
	public WebElement homeTitle;

	@FindBy(xpath = "//table[@id='sn_hr_core_profile_table']//td[@name='user']//input[@type='search']")
	public WebElement search_field;

	@FindBy(xpath = "(//a[@class='linked'])[1]")
	public WebElement user_name;

	@FindBy(xpath = "//a[@class='linked formlink']")
	public WebElement hr_profile_number;

	@FindBy(xpath = "//h1[contains(@class,'form_header navbar-title navbar-title-twoline')]//span[@class='form_display_value']")
	public WebElement user_home_title;

	@FindBy(xpath = "//input[@id='sys_readonly.sn_hr_core_profile.ssn']")
	public WebElement user_pin;

	@FindBy(xpath = "//input[@id='sys_readonly.sn_hr_core_profile.u_home_postal_code']")
	public WebElement user_postalcode;

	@FindBy(xpath = "//input[@id='sys_readonly.sn_hr_core_profile.u_job_family.u_job_family_group_name']")
	public WebElement user_familygroup;

	@FindBy(xpath = "//input[@id='sn_hr_core_profile.u_job_family_label']")
	public WebElement user_familyname;

	@FindBy(xpath = "//input[@id='sys_readonly.sn_hr_core_profile.u_union_code']")
	public WebElement user_occcode;

	@FindBy(xpath = "//input[@class='form-control'][@placeholder='Search']")
	public WebElement search_dropdown_field;

	@FindBy(xpath = "//select[@class='form-control default-focus-outline']")
	public WebElement search_dropDown;

	@FindBy(xpath = "//a[text() = 'Open Record']")
	public WebElement openRecord;

	public void navigateToHRDashboard(String hrProfileUser) throws Exception {
		leftSearch.sendKeys("HR PROFILE");
		checkForPageLoad(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", hrDashboard);
		checkForPageLoad(driver);
		// driver.switchTo().frame(0);
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, homeTitle);
		if (homeTitle.getText().equalsIgnoreCase("HR Profiles")) {
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("Successfully Navigate to HR Profile list view Home Page", ExtentColor.CYAN));

			logSuccess("Expected Value - " + "HR Profiles");
			logSuccess("Actual Value - " + homeTitle.getText());

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Navigation Failed to to reach the HR Profile list view Home Page", ExtentColor.RED));

			logFailure("Expected Value - " + "HR Profiles");
			logFailure("Actual Value - " + homeTitle.getText());

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		Select select = new Select(search_dropDown);
		select.selectByVisibleText("User");
		search_dropdown_field.sendKeys(hrProfileUser);
		search_dropdown_field.sendKeys(Keys.ENTER);
		waitForFrameToBeAvailable(driver, "gsft_main");
		search_field.sendKeys(hrProfileUser);
		search_field.sendKeys(Keys.ENTER);
		waitForFrameToBeAvailable(driver, "gsft_main");
		if (user_name.getText().equalsIgnoreCase(hrProfileUser)) {
			test.get().log(Status.INFO, MarkupHelper
					.createLabel("Required user is displayed on the hr profile list view page", ExtentColor.CYAN));

			logSuccess("Expected Value - " + hrProfileUser);
			logSuccess("Actual Value - " + user_name.getText());

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(
							"Navigation Failed to to reach the required user on the hr profile list view page ",
							ExtentColor.RED));

			logFailure("Expected Value - " + hrProfileUser);
			logFailure("Actual Value - " + user_name.getText());

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		// hr_profile_number.click();
		waitForElement(driver, driver.findElement(By.xpath("//*[text() ='" + hrProfileUser
				+ "' and @class='linked']/parent::td/preceding-sibling::td/a[contains(@class, 'icon-info')]")));
		WebElement iIcon = driver.findElement(By.xpath("//*[text() ='" + hrProfileUser
				+ "' and @class='linked']/parent::td/preceding-sibling::td/a[contains(@class, 'icon-info')]"));
		iIcon.click();
		waitForFrameToBeAvailable(driver, "gsft_main");
		waitForElement(driver, openRecord);
		openRecord.click();
		waitForFrameToBeAvailable(driver, "gsft_main");
		if (user_home_title.getText().equalsIgnoreCase(hrProfileUser)) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel(
							"Required user  profle information is displayed on the hr profile list view page",
							ExtentColor.CYAN));

			logSuccess("Expected Value - " + hrProfileUser);
			logSuccess("Actual Value - " + user_home_title.getText());

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Navigation Failed to to reach the required user  profile information on the hr profile list view page ",
					ExtentColor.RED));

			logFailure("Expected Value - " + hrProfileUser);
			logFailure("Actual Value - " + user_home_title.getText());

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

	}

	public void validate_user_profile() throws Exception {
		String pin = user_pin.getAttribute("value");
		String postalcode = user_postalcode.getAttribute("value");
		String familygroup = user_familygroup.getAttribute("value");
		String familyname = user_familyname.getAttribute("value");
		String occcode = user_occcode.getAttribute("value");
		if (user_pin.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"** four digit PIN numbe is visible in the PIN field and pin number is**:  " + pin,
							ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("four digit PIN numbe is not visible in the PIN field", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		if (user_postalcode.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"**Home Postal Code is visible in the Home Postal Code field and postal code is**:   " + postalcode,
					ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Home postal code is not visible in the Home postal field", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		if (user_familygroup.isDisplayed()) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(
							"** Family Group Name is visible in the Job Family Group Name field and group name is**:  "
									+ familygroup,
							ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(
					"Family group name is not visible in the Job Family Group Name field", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		if (user_familyname.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"** Family Name is visible in the Job Family name  field and family name is**:  " + familyname,
					ExtentColor.GREEN));
		} else {
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Family  name is not visible in the Job Family  Name field", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		if (user_occcode.isDisplayed()) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(
					"**Union Occ Code is visible in the Union Occ Code field and Union occ code  is**:   " + occcode,
					ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Union Occ Code is not visible in the Union occ field", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	public void validating_fields_available_or_not() throws Exception {
		try {
			if (user_pin.isDisplayed()) {
				test.get().log(Status.FAIL, MarkupHelper.createLabel("Pin field is visible", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}

		} catch (Exception e) {
			test.get().log(Status.PASS, MarkupHelper.createLabel("** Pin field is not visible**", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		try {
			if (user_postalcode.isDisplayed()) {
				test.get().log(Status.FAIL,
						MarkupHelper.createLabel("Home Postal Code field is  visible", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}
		} catch (Exception e)

		{
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**Home Postal Code field is not visible**", ExtentColor.GREEN));

		}
		try {
			if (user_occcode.isDisplayed()) {
				test.get().log(Status.FAIL, MarkupHelper
						.createLabel("Union Occ Code is not visible in the Union occ field", ExtentColor.RED));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

			}
		} catch (Exception e)

		{
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("**Union Occ Code  field  is not visible**", ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}
}
