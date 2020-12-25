package com.snow.base;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ReusableLibrary extends Base {

	public void checkForPageLoad(WebDriver driver) {
		String pageLoad = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(3000);
				pageLoad = js.executeScript("return document.readyState").toString();
			} catch (Exception e) {
				// e.printStackTrace();
				// System.out.println("Page yet to Load");
			}

			// To check page ready state
			if (pageLoad.equals("complete")) {
				System.out.println("Page loaded complete");
				break;
			} else {
				System.out.println("Page yet to Load");
			}
		}
	}

	public boolean isElementPresent(WebDriver driver, WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Element not present " + e.getMessage());
			return false;
		}

	}

	public void waitForAction(WebDriver driver) {
		String pageLoad = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
				pageLoad = js.executeScript("return document.readyState").toString();
			} catch (Exception e) {

			}
			if (pageLoad.equals("complete")) {
				break;
			}
		}
	}

	public String compareTime(int addedDays) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YY");
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
		cal.add(Calendar.DAY_OF_MONTH, addedDays);
		String newDate = sdf.format(cal.getTime());
		return newDate;
	}

	public void switchToFrame(WebDriver driver, String frame) throws Exception {
		System.out.println("Switching to Frame - " + frame/* .getAttribute("name").trim() */);
		try {
			/*
			 * WebDriverWait wait = new WebDriverWait(driver, 15);
			 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
			 */
			driver.switchTo().frame(frame.trim());
			System.out.println("Frame Switched to " + frame);
		} catch (Exception e) {
			System.out.println("Exception while switchin frame - " + frame);
		}

	}

	public void waitForFrameToBeAvailable(WebDriver driver, String frameName) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String currentFrame = "";
		try {
			currentFrame = ((String) jsExecutor.executeScript("return self.name")).trim();
		} catch (Exception e) {
			System.out.println("Unable to get Current Frame - " + e.getClass().getSimpleName());
			driver.get(driver.getCurrentUrl());
			try {
				currentFrame = ((String) jsExecutor.executeScript("return self.name")).trim();
			} catch (Exception e2) {
				System.out.println(
						"Unable to get Current Frame after refresh as well - " + e2.getClass().getSimpleName());
			}
		}
		System.out.println("Current Frame is - " + currentFrame);
		System.out.println("Desired Frame to switch is - " + frameName.trim());

		if (!currentFrame.isEmpty()) {
			try {
				driver.switchTo().defaultContent();
				System.out.println("Switching to Default Content");
				Thread.sleep(2000);
			} catch (Exception e) {
				// e.printStackTrace();
			}
		} else {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// e.printStackTrace();
			}
			System.out.println("Already in Default Frame");
		}

		waitForElement(driver, driver.findElements(By.tagName("iframe")).get(0));
		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		System.out.println("Total Frames on the Page - " + iframes.size());

		int count = 0;
		for (WebElement webElement : iframes) {
			System.out.println("Frame at index " + count + " is " + webElement.getAttribute("name").trim());
			if (webElement.getAttribute("name").trim().equals(frameName.trim())) {
				try {
					switchToFrame(driver, frameName.trim());
					Thread.sleep(2000);
					break;
				} catch (Exception e) {
					// e.printStackTrace();
				}
			}
			count++;
		}

		try {
			System.out.println(
					"Frame Under Execution  - " + ((String) jsExecutor.executeScript("return self.name")).trim());
		} catch (Exception e) {
			System.out.println("Unable to get Current Frame - " + e.getClass().getSimpleName());
			waitForFrameToBeAvailable(driver, frameName);
		}
	}

	public void waitForFrameToBeAvailableByName(WebDriver driver, String Locator) {
		try {
			driver.switchTo().defaultContent();
			if (tempbrowser.toUpperCase().equals("SAFARI")) {
				Thread.sleep(5000);
			}
			WebDriverWait wait1 = new WebDriverWait(driver, 15);
			wait1.until(ExpectedConditions
					.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath("\"" + Locator + "\""))));
			if (tempbrowser.toUpperCase().equals("SAFARI")) {
				Thread.sleep(5000);
			}

			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			String currentFrame = (String) jsExecutor.executeScript("return self.name");
			System.out.println("Frame under execution - " + currentFrame);
		} catch (Exception e) {
			// Below Lines are commented to avoid confusion as these line will be displayed
			// in HTML Report.
			// test.get().log(Status.INFO,
			// MarkupHelper.createLabel("Frame may not be switched as expected - ",
			// ExtentColor.BLUE));
		}
	}

	public void waitForFrameToBeAvailableByIndex(WebDriver driver, int frameLocator) {
		try {
			driver.switchTo().defaultContent();
			if (tempbrowser.toUpperCase().equals("SAFARI")) {
				Thread.sleep(5000);
			}
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
			if (tempbrowser.toUpperCase().equals("SAFARI")) {
				Thread.sleep(5000);
			}

			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			String currentFrame = (String) jsExecutor.executeScript("return self.name");
			System.out.println("Frame under execution - " + currentFrame);
		} catch (Exception e) {
			// Below Lines are commented to avoid confusion as these line will be displayed
			// in HTML Report.
			// test.get().log(Status.INFO,
			// MarkupHelper.createLabel("Frame may not be switched as expected - ",
			// ExtentColor.BLUE));
		}
	}

	public void scrollToElement(WebDriver driver, WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			checkForPageLoad(driver);
		} catch (Exception e) {
			System.out.println("Error Message - " + e.getMessage());
		}
	}

	public String getScreenshot(WebDriver driver, String test) {
		String timeStamp = new SimpleDateFormat("dd-MM-YY-HH-mm-ss").format(Calendar.getInstance().getTime());
		String screenshotPath = System.getProperty("user.dir") + File.separatorChar + "Results" + File.separatorChar
				+ "Screenshots" + File.separatorChar + test + timeStamp + ".jpeg";

//		String screenshotPath = "\\\\wbmsburmislib" + File.separatorChar + "Backup" + File.separatorChar + "Akhilesh"
//				+ File.separatorChar + "HRSM_Results" + File.separatorChar + "Results" + File.separatorChar
//				+ "Screenshots" + File.separatorChar + test + timeStamp + ".jpeg";

		try {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
					destFile = new File(screenshotPath);
			FileUtils.copyFile(srcFile, destFile);
		} catch (Exception e) {
			System.out.println("Exception faced while taking screenshot: " + e.getMessage());
			return screenshotPath;
		}
		return screenshotPath;
	}

	public String getTimeStamp() throws InterruptedException {
		String timeStamp = new SimpleDateFormat("dd-MM-YY-HH-mm-ss").format(Calendar.getInstance().getTime());
		return timeStamp;
	}

	public void scrollPageDown(WebDriver driver) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,800)");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void scrollPageToElement(WebDriver driver, WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			checkForPageLoad(driver);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void scrollPageUp(WebDriver driver) {
		// Actions action = new Actions(driver);
		// action.sendKeys(Keys.PAGE_UP).build().perform();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-400)", "");
		checkForPageLoad(driver);
	}

	public void waitForPageLoad(WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(WebDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState")
					.equals("complete"));
		} catch (Exception e) {
			System.out.println("Exception Received For Waiting For Page Load- " + e.getLocalizedMessage().getClass());
		}
	}

	public void waitForElement(WebDriver driver, WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(element));
			System.out.println("Element displayed - " + element.isDisplayed());
		} catch (Exception e) {
			// e.printStackTrace();
			// Below Lines are commented to avoid confusion as these line will be displayed
			// in HTML Report.
			// test.get().log(Status.INFO,
			// MarkupHelper.createLabel("Warning, element may not be available on the page -
			// ", ExtentColor.BLUE));
		}
	}

	public void waitForExpectedNumberOfWindows(WebDriver driver, int expectedNumber) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumber));
			// System.out.println("Element displayed - " + element.isDisplayed());
		} catch (Exception e) {
			System.out.println("Exception Received For Number of Windows Present - " + e.getMessage().getClass());
			System.out.println("Expected Number of Open Windows  - 2");
		}
	}

	public boolean waitForElementToBeClickable(WebDriver driver, WebElement element) {
		boolean result = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			System.out.println("Element Enabled - " + element.isEnabled());
			result = true;
		} catch (Exception e) {
			result = false;
			System.out.println("Is Element Clickable - False");
		}
		return result;
	}

	public void logInfo(String info) {
		test.get().log(Status.INFO, MarkupHelper.createLabel(info, ExtentColor.CYAN));
	}

	public void logSuccess(String info) {
		test.get().log(Status.PASS, MarkupHelper.createLabel(info, ExtentColor.GREEN));
	}

	public void logFailure(String info) {
		test.get().log(Status.FAIL, MarkupHelper.createLabel(info, ExtentColor.RED));
	}

	public void logInfoScreenshot(WebDriver driver) {
		try {
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} catch (Exception e) {
			logFailure("Error in taking Failure screenshot - " + e.getMessage().getClass());
		}

	}

	public void logSuccessScreenshot(WebDriver driver) {
		try {
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} catch (Exception e) {
			logFailure("Error in taking Failure screenshot - " + e.getMessage().getClass());
		}
	}

	public void logFailureScreenshot(WebDriver driver) {
		try {
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} catch (IOException e) {
			logFailure("Error in taking Failure screenshot - " + e.getMessage().getClass());
		}
	}

	public boolean isElementPresent(WebElement element) {
		try {
			element.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isElementEnabled(WebElement element) {
		try {
			element.isEnabled();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isElementPresentList(List<WebElement> element) {
		try {
			if (element.size() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public int getWorkingDaysBetweenTwoDates(Date startDate, Date endDate, boolean startToday) {
		Calendar startCal = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
		startCal.setTime(startDate);

		Calendar endCal = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
		endCal.setTime(endDate);

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		df.setTimeZone(TimeZone.getTimeZone("PST"));

		int workDays = 0;
		// Integer.parseInt(LocalTime.now().toString().split(":")[0])
		int hour = Integer.parseInt(df.format(new Date()).split(" ")[1].split(":")[0]);
		if ((hour < 9 || hour > 16) && startToday) {
			workDays++;
		}

		// Return 0 if start and end are the same
		if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
			return 0;
		}

		if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
			startCal.setTime(endDate);
			endCal.setTime(startDate);
		}

		do {
			// excluding start date
			startCal.add(Calendar.DAY_OF_MONTH, 1);
			if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
					&& startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY
					&& startCal.getTimeInMillis() < endCal.getTimeInMillis()) {
				System.out.println("Calendar Start Time  - " + startCal.getTime());
				System.out.println("Calendar End Time  - " + endCal.getTime());
				workDays++;
				System.out.println(workDays);
			}
		} while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); // excluding end date

		return workDays;
	}

	public int getWorkingDaysBetweenTwoDates(Date startDate, Date endDate) throws ParseException {
		/*
		 * Calendar todayCal = Calendar.getInstance(); todayCal.setTime(new Date());
		 */

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("PST"));
		String start = simpleDateFormat.format(startDate);
		String end = simpleDateFormat.format(endDate);

		Calendar startCal = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
		startCal.setTime(simpleDateFormat.parse(start));

		Calendar endCal = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
		endCal.setTime(simpleDateFormat.parse(end));

		int workDays = 0;

		// Return 0 if start and end are the same
		if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
			return 0;
		}

		if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
			startCal.setTime(endDate);
			endCal.setTime(startDate);
		}

		String currentTimeStamp = simpleDateFormat.format(new Date());
		System.out.println("Current Timestamp - " + currentTimeStamp);

		// System.out.println("Today Timestamp - " + todayCal.getTime());
		System.out.println("Start Timestamp - " + startCal.getTime());
		System.out.println("End Timestamp - " + endCal.getTime());

		int hour = Integer.parseInt(currentTimeStamp.split(" ")[1].split(":")[0]);
		System.out.println("Current Timestamp Hour - " + hour);

		if (hour < 9 || hour >= 18) {
			workDays++;
			startCal.add(Calendar.DAY_OF_MONTH, 1);
			System.out.println("Adding Difference in working days as hours before 9 - " + workDays);
		}

		do {
			// excluding start date
			startCal.add(Calendar.DAY_OF_MONTH, 1);
			if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
					&& startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY
			/* && startCal.getTimeInMillis() < endCal.getTimeInMillis() */) {

				System.out.println("Calendar Start Time  - " + startCal.getTime());
				System.out.println("Calendar End Time  - " + endCal.getTime());
				workDays++;
				System.out.println(workDays);
			}
		} while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); // excluding end date

		return workDays;
	}

	public void compareTwoList(List<String> inputdata, List<String> applicationdata) {
		Set<String> matcheddata = new HashSet<>();
		Set<String> unmatcheddata = new HashSet<>();
		Set<String> remove = new HashSet<>();

		for (int j = 0; j < inputdata.size(); j++) {
			for (int k = 0; k < applicationdata.size(); k++) {
				if (inputdata.contains(applicationdata.get(k))) {
					matcheddata.add(applicationdata.get(k));
					System.out.println("Adding to matched data - " + applicationdata.get(k));
				}
				if (!inputdata.contains(applicationdata.get(k)) || !applicationdata.contains(inputdata.get(j))) {
					unmatcheddata.add(inputdata.get(j));
					unmatcheddata.add(applicationdata.get(k));
					System.out.println(
							"Adding to unmatched data - " + applicationdata.get(k) + " and " + inputdata.get(j));
				}
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

		if (matcheddata.size() > 0) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel("Below are matched, Actual and Expected values", ExtentColor.GREEN));
			System.out.println("Matched Data");
			for (String string : matcheddata) {
				System.out.println("---" + string);
				test.get().log(Status.PASS, MarkupHelper.createLabel("- " + string, ExtentColor.GREEN));
			}
		}

		if (unmatcheddata.size() > 0) {
			System.out.println("Unmatched Data");
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel("Below are unmatched, Actual and Expected values", ExtentColor.RED));
			for (String string : unmatcheddata) {
				System.out.println("---" + string);
				test.get().log(Status.FAIL, MarkupHelper.createLabel("- " + string, ExtentColor.RED));

			}
		}
	}

	public int getWorkingDaysBetweenTwoDate(Date startDate, Date endDate, boolean startToday) {
		Calendar startCal = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
		startCal.setTime(startDate);

		Calendar endCal = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
		endCal.setTime(endDate);

		int workDays = 0;

		if (Integer.parseInt(LocalTime.now().toString().split(":")[0]) <= 9 && startToday) {
			workDays++;
		}

		// Return 0 if start and end are the same
		if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
			return 0;
		}

		if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
			startCal.setTime(endDate);
			endCal.setTime(startDate);
		}

		startCal.add(Calendar.DAY_OF_MONTH, 1);
		while (startCal.getTimeInMillis() < endCal.getTimeInMillis()) {
			startCal.add(Calendar.DAY_OF_MONTH, 1);
			if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
					&& startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				System.out.println("Calendar Start Time  - " + startCal.getTime());
				System.out.println("Calendar End Time  - " + endCal.getTime());

				++workDays;
				System.out.println(workDays);
			}

		}

		System.out.println(workDays);

		return workDays;
	}

	public boolean retryingFindClick(WebElement element) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				element.click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public String getFromDataLib(ReadData rd, String suite, String identifierVariable) throws IOException {
		System.out.println("Suite is - " + suite);
		System.out.println("Identifier is - " + identifierVariable);
		Map<Object, Object> currentDatamap = rd.readFromDataLibrary(suite);

		System.out.println("Keys are - ");
		Set<Object> keys = currentDatamap.keySet();
		for (Object object : keys) {
			System.out.println((String) object);
		}
		String checkRequestCaseId = (String) currentDatamap.get(identifierVariable.trim());
		return checkRequestCaseId.trim();
	}

	public void clickUsingJavaScript(WebDriver driver, WebElement element) {
		waitForElementToBeClickable(driver, element);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

}