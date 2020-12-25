package com.snow.pageobjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.snow.base.ReusableLibrary;

public class CategoryPage extends ReusableLibrary {
	public WebDriver driver;

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// WebElement makearequest =
	// driver.findElement(By.xpath("//span[contains(text(),'Make a Request')]"));
	// makearequest.click();

	@FindBy(xpath = "//span[contains(text(),'Make a Request')]")
	public WebElement makearequest;

	@FindBy(xpath = "//span[@id='8b942d9a6fb21f008da71e8f1e3ee40a']")
	public WebElement businesspartnerservices;

	@FindBy(xpath = "//span[@id='71914d8d37e213002fc0c7d1b3990e70']")
	public WebElement employeeservices;

	@FindBy(xpath = "//i[contains(@class,'fa fa-th active')]")
	public WebElement cardview;

	@FindBy(xpath = "//h2[@title='General Inquiry']")
	public WebElement generalinquiry;

	// Element of the CaseID created in portal
	@FindBy(xpath = "//*[@id='xf9fbccf3c3603200b599b4ad81d3ae80']/div[1]/div[1]/div[1]/div[2]")
	public WebElement caseid;

	public void categoryvalidation() {
		driver.findElement(By.xpath("//span[contains(text(),'Make a Request')]")).click();

		System.out.printf("\nMake a Request option Available");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// }

		// @Test(priority=1)
		// public void b_categoryvalidation()
		// {

		// WebElement bps =
		// driver.findElement(By.xpath("//span[@id='8b942d9a6fb21f008da71e8f1e3ee40a']"));
		String actualbps = businesspartnerservices.getAttribute("title");
		String expectedbps = "Business Partners Services";
		Assert.assertEquals(actualbps, expectedbps);
		System.out.printf("'\nBusiness Partners Services' Category is available. --> Pass");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// WebElement es =
		// driver.findElement(By.xpath("//span[@id='71914d8d37e213002fc0c7d1b3990e70']"));
		String actuales = employeeservices.getAttribute("title");
		String expectedes = "Employee Services";
		Assert.assertEquals(actuales, expectedes);
		System.out.printf("'\nEmployee Services Category' is available. --> Pass");

	}

	public void businesspartnerservice_navigation() {

		makearequest.click();
		System.out.printf("\nClicked on Make a Request");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		checkForPageLoad(driver);
		// JavascriptExecutor executor = (JavascriptExecutor)driver;
		checkForPageLoad(driver);
		// WebElement es =
		// driver.findElement(By.xpath("//span[@id='71914d8d37e213002fc0c7d1b3990e70']"));

		// es.click();
		businesspartnerservices.click();
		System.out.printf("\nBusiness Partners Services\n");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		cardview.click();
		System.out.printf("\nClicked on Card View\n");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		checkForPageLoad(driver);
	}

	public void employeeservice_navigation() {
		makearequest.click();
		Reporter.log("\nClicked on Make a Request");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		checkForPageLoad(driver);
		// JavascriptExecutor executor = (JavascriptExecutor)driver;
		checkForPageLoad(driver);
		// WebElement es =
		// driver.findElement(By.xpath("//span[@id='71914d8d37e213002fc0c7d1b3990e70']"));

		// es.click();
		employeeservices.click();
		Reporter.log("\nEmployee Services\n");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		cardview.click();
		Reporter.log("\nClicked on Card View\n");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		checkForPageLoad(driver);
	}

	public String displaycaseID() throws IOException {
		PageFactory.initElements(driver, CategoryPage.class);
		String caseID = null;
		waitForElement(driver, caseid);
		if (caseid.isDisplayed()) {
			caseID = caseid.getText();
			System.out.println("Case created successfully with ID  - " + caseID);
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Case created successfully with ID  - " + caseID, ExtentColor.GREEN));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			Reporter.log("\nHR Case Created Successfully :");
			Reporter.log(caseID);
		} else {
			System.out.println("Case creation Failed");
			test.get().log(Status.FAIL, MarkupHelper.createLabel("Case creation Failed", ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		return caseID;
	}
}