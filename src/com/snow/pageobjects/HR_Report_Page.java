package com.snow.pageobjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.snow.base.ReusableLibrary;

public class HR_Report_Page extends ReusableLibrary {
	public WebDriver driver;

	public HR_Report_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id='b9169d55873212001ac119fa84e3ece3']//div[@class='sn-widget-list-title'][contains(text(),'Dashboards')]")
	public WebElement Dashboard;

	@FindBy(xpath = "//input[@id='filter']")
	public WebElement leftsearch;

	@FindBy(xpath = "//a[@id='bb1956344fb1230069afe5201310c703']")
	public WebElement kbr_hr_kb_dashboard_sme;

	@FindBy(xpath = "//*[@id='0fc956744fb1230069afe5201310c705']/div[1]/div[3]/span")
	public WebElement kbr_PublishedArticles_sme;

	@FindBy(xpath = "//*[@id='e69069d94f39630069afe5201310c739']/div[1]/div[3]/span")
	public WebElement kbr_My_Articles_to_Action_sme;

	@FindBy(xpath = "//*[@id='87f9d6744fb1230069afe5201310c7a0']/div[1]/div[3]/span")
	public WebElement kbr_My_Articles_near_Expiration_sme;

	@FindBy(xpath = "//*[@id='7411611d4f39630069afe5201310c7fc']/div[1]/div[3]/span")
	public WebElement kbr_My_PublishedArticles_sme;

	@FindBy(xpath = "//a[@id='e0616de837b163002fc0c7d1b3990ef9']")
	public WebElement kbr_hr_kb_dashboard_gov;

	@FindBy(xpath = "//a[@id='5e8d92784fb1230069afe5201310c78e']")
	public WebElement kbr_hr_kb_dashboard_agent;

	@FindBy(xpath = "//div[@class='grid-widget-header-title left']")
	public WebElement kbr_PublishedArticles_agent;

	@FindBy(xpath = "//div[@id='f4c4296037f163002fc0c7d1b3990e6b']//div[@class='grid-widget-header-title left']")
	public WebElement kbr_PublishedArticles;

	@FindBy(xpath = "//div[@id='78c4296037f163002fc0c7d1b3990e67']//div[@class='grid-widget-header-title left']")
	public WebElement kbr_My_Articles_to_Action;

	@FindBy(xpath = "//div[@id='3cc4296037f163002fc0c7d1b3990e61']//div[@class='grid-widget-header-title left']")
	public WebElement kbr_My_Articles_near_Expiration;

	@FindBy(xpath = "//div[@id='f8c4296037f163002fc0c7d1b3990e63']//div[@class='grid-widget-header-title left']")
	public WebElement kbr_My_PublishedArticles;

	@FindBy(xpath = "//div[@id='38c4296037f163002fc0c7d1b3990e69']//div[@class='grid-widget-header-title left']")
	public WebElement kbr_Articles_in_draft;

	@FindBy(xpath = "//div[@id='b8c4296037f163002fc0c7d1b3990e65']//div[@class='grid-widget-header-title left']")
	public WebElement kbr_Articles_Pending_Review_Approval;

	@FindBy(xpath = "//div[@id='74c4296037f163002fc0c7d1b3990e6f']//div[@class='grid-widget-header-title left']")
	public WebElement kbr_Articles_near_expiration;

	@FindBy(xpath = "//div[@id='530cd70d37b163002fc0c7d1b3990ec3']//div[@class='grid-widget-header-title left']")
	public WebElement kbr_rejection_count;

	@FindBy(xpath = "//div[@id='b4c4296037f163002fc0c7d1b3990e6d']//div[@class='grid-widget-header-title left']")
	public WebElement kbr_article_suggestions;

	@FindBy(xpath = "//div[@id='346f5ac937fd23002fc0c7d1b3990ef2']//div[@class='grid-widget-header-title left']")
	public WebElement kbr_most_viewed_articles;

	@FindBy(xpath = "//div[@id='f59f9e0d37fd23002fc0c7d1b3990ee7']//div[@class='grid-widget-header-title left']")
	public WebElement kbr_least_viewed_articles;

	String actual_PA = "Published Articles";
	String actual_My_AA = "My Articles to Action";
	String actual_My_ANE = "My Articles Near Expiration";
	String actual_My_PA = "My Published Articles";
	String actual_AD = "Articles in Draft";
	String actual_APRA = "Articles Pending Review & Approval";
	String actual_ANE = "Articles Nearing Expiration";
	String actual_RC = "Rejection Count";
	String actual_AS = "Article Suggestions";
	String actual_MVA = "Most Viewed Articles";
	String actual_LVA = "Least Viewed Articles";

	public void Validate_hr_sme_report() throws IOException {
		PageFactory.initElements(driver, HR_Report_Page.class);

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		// (On 17th June)ConfigFileReader cf = new ConfigFileReader();
		driver.get(homePageURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get(cf.getUrl());
//		checkForPageLoad(driver);

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		// WebElement leftsearch =
		// driver.findElement(By.xpath("//input[@id='filter']"));
		// String CaseID = caseid.getText();
		leftsearch.sendKeys("dashboard");

		// WebElement allcase =
		// driver.findElement(By.xpath("//*[@id='7a5330019f22120047a2d126c42e70e0']/div"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		checkForPageLoad(driver);
		executor.executeScript("arguments[0].click();", Dashboard);

		System.out.printf("\nClicked on Dashboard");

		driver.switchTo().frame(0);
		System.out.printf("\nSwitched to Mainframe\n");
		checkForPageLoad(driver);
		kbr_hr_kb_dashboard_sme.click();

		if (kbr_PublishedArticles_sme.isDisplayed()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Navigated successfully to Dashboard", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Navigation to Dashboard Failed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		String expected_PA_sme = kbr_PublishedArticles_sme.getText();
		System.out.print(expected_PA_sme);
		Assert.assertEquals(actual_PA, expected_PA_sme);

		logSuccess("Expected Value - " + expected_PA_sme);
		logSuccess("Actual Value - " + actual_PA);

		System.out.print(" : available\n");

		String expected_My_AA_sme = kbr_My_Articles_to_Action_sme.getText();
		System.out.print(expected_My_AA_sme);
		Assert.assertEquals(actual_My_AA, expected_My_AA_sme);

		logSuccess("Expected Value - " + expected_My_AA_sme);
		logSuccess("Actual Value - " + actual_My_AA);

		System.out.print(" : available\n");

		String expected_My_ANE_sme = kbr_My_Articles_near_Expiration_sme.getText();
		System.out.print(expected_My_ANE_sme);
		Assert.assertEquals(actual_My_ANE, expected_My_ANE_sme);

		logSuccess("Expected Value - " + expected_My_ANE_sme);
		logSuccess("Actual Value - " + actual_My_ANE);

		System.out.print(" : available\n");

		String expected_My_PA_sme = kbr_My_PublishedArticles_sme.getText();
		System.out.print(expected_My_PA_sme);
		Assert.assertEquals(actual_My_PA, expected_My_PA_sme);

		logSuccess("Expected Value - " + expected_My_PA_sme);
		logSuccess("Actual Value - " + actual_My_PA);

		System.out.print(" : available\n");

		test.get().log(Status.PASS, MarkupHelper.createLabel("Dashboard validated Successfully", ExtentColor.GREEN));

	}

	public void Validate_hr_governance_report() throws IOException {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		// (On 17th June) ConfigFileReader cf = new ConfigFileReader();
		driver.get(homePageURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//	driver.get(cf.getUrl());
//	checkForPageLoad(driver);

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		// WebElement leftsearch =
		// driver.findElement(By.xpath("//input[@id='filter']"));
		// String CaseID = caseid.getText();
		leftsearch.sendKeys("dashboard");

		// WebElement allcase =
		// driver.findElement(By.xpath("//*[@id='7a5330019f22120047a2d126c42e70e0']/div"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		checkForPageLoad(driver);
		executor.executeScript("arguments[0].click();", Dashboard);

		System.out.printf("\nClicked on Dashboard");

		driver.switchTo().frame(0);
		System.out.printf("\nSwitched to Mainframe\n");
		checkForPageLoad(driver);
		kbr_hr_kb_dashboard_gov.click();

		if (kbr_PublishedArticles.isDisplayed()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Navigated successfully to Dashboard", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Navigation to Dashboard Failed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		String expected_PA = kbr_PublishedArticles.getText();
		System.out.print(expected_PA);
		Assert.assertEquals(actual_PA, expected_PA);

		logSuccess("Expected Value - " + expected_PA);
		logSuccess("Actual Value - " + actual_PA);

		System.out.print(" : available\n");

		String expected_My_AA = kbr_My_Articles_to_Action.getText();
		System.out.print(expected_My_AA);
		Assert.assertEquals(actual_My_AA, expected_My_AA);

		logSuccess("Expected Value - " + expected_My_AA);
		logSuccess("Actual Value - " + actual_My_AA);

		System.out.print(" : available\n");

		String expected_My_ANE = kbr_My_Articles_near_Expiration.getText();
		System.out.print(expected_My_ANE);
		Assert.assertEquals(actual_My_ANE, expected_My_ANE);

		logSuccess("Expected Value - " + expected_My_ANE);
		logSuccess("Actual Value - " + actual_My_ANE);

		System.out.print(" : available\n");

		String expected_My_PA = kbr_My_PublishedArticles.getText();
		System.out.print(expected_My_PA);
		Assert.assertEquals(actual_My_PA, expected_My_PA);

		logSuccess("Expected Value - " + expected_My_PA);
		logSuccess("Actual Value - " + actual_My_PA);

		System.out.print(" : available\n");

		String expected_AD = kbr_Articles_in_draft.getText();
		System.out.print(expected_AD);
		Assert.assertEquals(actual_AD, expected_AD);

		logSuccess("Expected Value - " + expected_AD);
		logSuccess("Actual Value - " + actual_AD);

		System.out.print(" : available\n");

		String expected_APRA = kbr_Articles_Pending_Review_Approval.getText();
		System.out.print(expected_APRA);
		Assert.assertEquals(actual_APRA, expected_APRA);

		logSuccess("Expected Value - " + expected_APRA);
		logSuccess("Actual Value - " + actual_APRA);

		System.out.print(" : available\n");

		String expected_ANE = kbr_Articles_near_expiration.getText();
		System.out.print(expected_ANE);
		Assert.assertEquals(actual_ANE, expected_ANE);

		logSuccess("Expected Value - " + expected_ANE);
		logSuccess("Actual Value - " + actual_ANE);

		System.out.print(" : available\n");

		String expected_RC = kbr_rejection_count.getText();
		System.out.print(expected_RC);
		Assert.assertEquals(actual_RC, expected_RC);

		logSuccess("Expected Value - " + expected_RC);
		logSuccess("Actual Value - " + actual_RC);

		System.out.print(" : available\n");

		String expected_AS = kbr_article_suggestions.getText();
		System.out.print(expected_AS);
		Assert.assertEquals(actual_AS, expected_AS);

		logSuccess("Expected Value - " + expected_AS);
		logSuccess("Actual Value - " + actual_AS);

		System.out.print(" : available\n");

		String expected_MVA = kbr_most_viewed_articles.getText();
		System.out.print(expected_MVA);
		Assert.assertEquals(actual_MVA, expected_MVA);

		logSuccess("Expected Value - " + expected_MVA);
		logSuccess("Actual Value - " + actual_MVA);

		System.out.print(" : available\n");

		String expected_LVA = kbr_least_viewed_articles.getText();
		System.out.print(expected_LVA);
		Assert.assertEquals(actual_LVA, expected_LVA);

		logSuccess("Expected Value - " + expected_LVA);
		logSuccess("Actual Value - " + actual_LVA);

		System.out.print(" : available\n");

		test.get().log(Status.PASS, MarkupHelper.createLabel("Dashboard validated Successfully", ExtentColor.GREEN));

	}

	public void Validate_hr_agent_report() throws IOException {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		// (On 17th June)ConfigFileReader cf = new ConfigFileReader();
		driver.get(homePageURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.get(cf.getUrl());
//	checkForPageLoad(driver);

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		// WebElement leftsearch =
		// driver.findElement(By.xpath("//input[@id='filter']"));
		// String CaseID = caseid.getText();
		leftsearch.sendKeys("dashboard");

		// WebElement allcase =
		// driver.findElement(By.xpath("//*[@id='7a5330019f22120047a2d126c42e70e0']/div"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		checkForPageLoad(driver);
		executor.executeScript("arguments[0].click();", Dashboard);

		System.out.printf("\nClicked on Dashboard");

		driver.switchTo().frame(0);
		System.out.printf("\nSwitched to Mainframe\n");
		checkForPageLoad(driver);
		kbr_hr_kb_dashboard_agent.click();

		if (kbr_PublishedArticles_agent.isDisplayed()) {
			test.get().log(Status.INFO,
					MarkupHelper.createLabel("Navigated successfully to Dashboard", ExtentColor.CYAN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		} else {
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Navigation to Dashboard Failed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		String expected_PA = kbr_PublishedArticles_agent.getText();
		System.out.print(expected_PA);
		Assert.assertEquals(actual_PA, expected_PA);
		System.out.print(" : available\n");

		test.get().log(Status.PASS, MarkupHelper.createLabel("Dashboard validated Successfully", ExtentColor.GREEN));
	}

}