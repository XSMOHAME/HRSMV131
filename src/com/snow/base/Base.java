package com.snow.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.UnexpectedException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.browserstack.local.Local;

public class Base {

	ReadData rd = new ReadData();
	public WebDriver driver;
	public String suiteName;
	public static Properties properties;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extentReports;
	public ExtentTest extentTest;
	protected static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();// static
	public static FileInputStream inputStream;
	public String screenshotPath;// static
	public static FileWriter fw;
	public String classUnderExecution;

	public static final int MAX_WAIT = 25;// 60
	public static final int MEDIUM_WAIT = 20;// 30
	public static final int MIN_WAIT = 10;// 10

	private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	/**
	 * ThreadLocal variable which contains the Sauce Job Id.
	 */
	private ThreadLocal<String> sessionId = new ThreadLocal<String>();

	public static String application = null;
	public static String environment = null;
	public String executeOn = null;
	public String os = null;
	public String osVersion = null;
	public String browser = null;
	public static String tempbrowser = null;
	public static String tempExecuteOn = null;
	public static String tempOS = null;

	public String temperorybrowser = null;
	public String temperoryExecuteOn = null;
	public String temperoryOS = null;

	public String browserVersion = null;
	public static String screenResolution = null;// static
	protected DesiredCapabilities caps;
	public static String username;
	public static String accesskey;

	public static String kbSmeUser = null;
	public static String kbSmePassword = null;
	public static String kbGovernanceUser = null;
	public static String kbGovernancePassword = null;
	public static String HrAnalystUser1 = null;
	public static String HrAnalystUser1Password = null;
	public static String HrAnalystUser2 = null;
	public static String HrAnalystUser2Password = null;

	public static String automationUser1Username = null;
	public static String automationUser1Password = null;
	public static String automationUser2Username = null;
	public static String automationUser2Password = null;

	public static String loginURL = null;
	public static String logoutURL = null;
	public static String homePageURL = null;
	public static String hrPortalURL = null;

	public static String sspURL = null;
	public static String spURL = null;
	public static String itilURL = null;
	public String id;
	public Map<Object, Object> datamap = null;
	public Map<String, String> userDetails = null;
	Local bsLocal;
	HashMap<String, String> bsLocalArgs = null;

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getTemperorybrowser() {
		return temperorybrowser;
	}

	public void setTemperorybrowser(String temperorybrowser) {
		this.temperorybrowser = temperorybrowser;
	}

	public String getTemperoryExecuteOn() {
		return temperoryExecuteOn;
	}

	public void setTemperoryExecuteOn(String temperoryExecuteOn) {
		this.temperoryExecuteOn = temperoryExecuteOn;
	}

	public String getTemperoryOS() {
		return temperoryOS;
	}

	public void setTemperoryOS(String temperoryOS) {
		this.temperoryOS = temperoryOS;
	}

	public String getSuiteName() {
		return suiteName;
	}

	public void setSuiteName(String suiteName) {
		this.suiteName = suiteName;
	}

	@BeforeSuite
	@Parameters({ "browser1", "browserVersion1", "executeOn1", "os1", "osVersion1", "username1", "accesskey1" })
	public void setBase(@Optional("") String browser1, @Optional("") String browserVersion1,
			@Optional("") String executeOn1, @Optional("") String os1, @Optional("") String osVersion1,
			@Optional("") String username1, @Optional("") String accesskey1, ITestContext ctx) throws IOException {

		datamap = rd.readEnvironmentFromSheet("Environment");
		application = (String) datamap.get("Application");
		environment = (String) datamap.get("Environment");

		if (!(executeOn1.equalsIgnoreCase(""))) {
			executeOn = executeOn1;
			tempExecuteOn = executeOn1;
			temperoryExecuteOn = executeOn1;
		} else {
			executeOn = (String) datamap.get("Execute On");
			tempExecuteOn = (String) datamap.get("Execute On");
			temperoryExecuteOn = (String) datamap.get("Execute On");
		}

		if (!(os1.equalsIgnoreCase(""))) {
			os = os1;
			tempOS = os1;
			temperoryOS = os1;
		} else {
			os = (String) datamap.get("OS");
			tempOS = (String) datamap.get("OS");
			temperoryOS = (String) datamap.get("OS");
		}

		if (!(osVersion1.equalsIgnoreCase(""))) {
			osVersion = osVersion1;
		} else {
			osVersion = (String) datamap.get("OS Version");
		}
		if (!(browser1.equalsIgnoreCase(""))) {
			browser = browser1;
			setBrowser(browser1);
			temperorybrowser = browser1;
		} else {
			browser = (String) datamap.get("Browser");
			setBrowser((String) datamap.get("Browser"));
			temperorybrowser = (String) datamap.get("Browser");
		}
		if (!(browserVersion1.equalsIgnoreCase(""))) {
			browserVersion = browserVersion1;
			tempbrowser = browserVersion1;
		} else {
			browserVersion = (String) datamap.get("Browser Version");
			tempbrowser = (String) datamap.get("Browser Version");
		}
		if (!(username1.equalsIgnoreCase(""))) {
			username = username1;
		} else {
			username = (String) datamap.get("BroserStackUsername");
		}
		if (!(accesskey1.equalsIgnoreCase(""))) {
			accesskey = accesskey1;
		} else {
			accesskey = (String) datamap.get("BroserStackPassword");
		}

		screenResolution = (String) datamap.get("ScreenResolution");

		// Reading data for user details
		userDetails = rd.readUserDetailsFromSheet("UserDetails");
		kbSmeUser = userDetails.get("KB_SME_Username");
		kbSmePassword = userDetails.get("KB_SME_Passowrd");
		kbGovernanceUser = userDetails.get("KB_Governance_Username");
		kbGovernancePassword = userDetails.get("KB_Governance_Password");
		HrAnalystUser1 = userDetails.get("HR_Analyst_Username1");
		HrAnalystUser1Password = userDetails.get("HR_Analyst_Password1");
		HrAnalystUser2 = userDetails.get("HR_Analyst_Username2");
		HrAnalystUser2Password = userDetails.get("HR_Analyst_Password2");

		// Logic to use links based on environment under execution.
		if (environment.contains("Dev")) {
			loginURL = "https://wbdev.service-now.com/login.do";
			logoutURL = "https://wbdev.service-now.com/logout.do";
			homePageURL = "https://wbdev.service-now.com";
			hrPortalURL = "https://wbdev.service-now.com/EC";
			sspURL = "https://wbdev.service-now.com/ssp";
			spURL = "https://wbdev.service-now.com/sp";
		} else if (environment.contains("Preview")) {
			loginURL = "https://wbpreview.service-now.com/login.do";
			logoutURL = "https://wbpreview.service-now.com/logout.do";
			homePageURL = "https://wbpreview.service-now.com";
			hrPortalURL = "https://wbpreview.service-now.com/EC";
			sspURL = "https://wbpreview.service-now.com/ssp";
			spURL = "https://wbpreview.service-now.com/sp";
		} else if (environment.contains("Sandbox")) {
			loginURL = "https://wbsandbox.service-now.com/login.do";
			logoutURL = "https://wbsandbox.service-now.com/logout.do";
			homePageURL = "https://wbsandbox.service-now.com";
			hrPortalURL = "https://wbsandbox.service-now.com/EC";
			sspURL = "https://wbsandbox.service-now.com/ssp";
			spURL = "https://wbsandbox.service-now.com/sp";
		}

		// Reading data for user details
		Map<String, String> userDetails = null;
		userDetails = rd.readUserDetailsFromSheet("UserDetails");
		automationUser1Username = userDetails.get("Username1");
		automationUser1Password = userDetails.get("Password1");
		automationUser2Username = userDetails.get("Username2");
		automationUser2Password = userDetails.get("Password2");
	}

	@BeforeSuite(dependsOnMethods = "setBase")
	public void createSuiteReport(ITestContext ctx) throws Exception {

		suiteName = ctx.getCurrentXmlTest().getSuite().getName();

		String timeStamp = new SimpleDateFormat("dd-MM-YY-HH-mm-ss").format(Calendar.getInstance().getTime());

		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + File.separatorChar + "Results" + File.separatorChar + "ExtentReport"
						+ File.separatorChar + suiteName + "-" + "REPORT - " + timeStamp + ".html");

		fw = new FileWriter(System.getProperty("user.dir") + File.separatorChar + "Results" + File.separatorChar
				+ "TextReport" + File.separatorChar + suiteName + ".txt");

		System.out.println(suiteName);
		rd.clearDataLibrary(suiteName);

		extentReports = new ExtentReports();
		extentReports.setSystemInfo("Host Name", "WarnerBros");
		extentReports.setSystemInfo("Application Name", application);
		extentReports.setSystemInfo("Environment", environment);
		extentReports.setSystemInfo("Platform", executeOn);
		extentReports.setSystemInfo("OS", os);
		extentReports.setSystemInfo("Browser", browser);
		extentReports.setSystemInfo("Report", suiteName);
		extentReports.attachReporter(htmlReporter);

		htmlReporter.setAppendExisting(true);
		htmlReporter.config().setDocumentTitle("SNOW Automation");
		htmlReporter.config().setReportName("SNOW Automation Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
	}

	/**
	 * @return the {@link WebDriver} for the current thread
	 */
	public WebDriver getWebDriver() {
		return webDriver.get();
	}

	/**
	 *
	 * @return the Sauce Job id for the current thread
	 */
	public String getSessionId() {
		return sessionId.get();
	}

	protected void createDriver(String browser, String version, String os, String osVersion, String username,
			String accesskey) throws MalformedURLException, UnexpectedException {
		// caps.setCapability(CapabilityType.BROWSER_NAME, browser);
		System.out.println("Operating System is - " + os);
		System.out.println("Operating System Version is - " + osVersion);
		System.out.println("Browser - " + browser);
		System.out.println("Browser version - " + version);
		System.out.println("Screen Resolution - " + screenResolution);

		caps.setCapability("os", os);
		caps.setCapability("os_version", osVersion);
		caps.setCapability("browser", browser);
		caps.setCapability("browser_version", "latest");
		caps.setCapability("resolution", screenResolution);
		System.out.println("Browser version Latest - " + caps.getCapability("browser_version"));

		// caps.setCapability("name", methodName);
		caps.setCapability("browserstack.local", "true");
		caps.setCapability("acceptSslCerts", "true");
		caps.setCapability("acceptInsecureCerts", "true");
		caps.setCapability("browserstack.debug", "true");

		caps.setCapability("browserstack.networkLogs", "false");

		caps.setCapability("build", "HRSM AUTOMATION");
		caps.setCapability("name", "Bstack-[TestNG] Parallel Test");

		caps.setCapability("browserstack.idleTimeout", "3000");
		caps.setCapability("EnableNativeEvents", "true");
		caps.setCapability("ignoreZoomSetting", "true");

		/*
		 * if (buildTag != null) { caps.setCapability("build", buildTag); }
		 */

		// Launch remote browser and set it as the current thread
		webDriver.set(new RemoteWebDriver(
				new URL("https://" + username + ":" + accesskey + "@hub-cloud.browserstack.com/wd/hub"), caps));

		// set current sessionId
		id = ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
		sessionId.set(id);
	}

	protected void annotate(String text) {
		((JavascriptExecutor) webDriver.get()).executeScript("browserstack:context=" + text);
	}

	public void WebWait(WebDriver driver, WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, MAX_WAIT);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {

		}
	}

	@BeforeClass
	@Parameters({ "browser1", "executeOn1", "os1" })
	public void createTest(@Optional("") String browser1, @Optional("") String executeOn1, @Optional("") String os1,
			ITestContext ctx) throws IOException {
		System.out.println("Before Class - " + this.getClass().getSimpleName());
		setSuiteName(ctx.getCurrentXmlTest().getSuite().getName());
		datamap = rd.readEnvironmentFromSheet("Environment");

		if (!(executeOn1.equalsIgnoreCase(""))) {
			executeOn = executeOn1;
			tempExecuteOn = executeOn1;
			setTemperoryExecuteOn(executeOn1);
		} else {
			executeOn = (String) datamap.get("Execute On");
			tempExecuteOn = (String) datamap.get("Execute On");
			setTemperoryExecuteOn((String) datamap.get("Execute On"));
		}

		if (!(browser1.equalsIgnoreCase(""))) {
			browser = browser1;
			tempbrowser = browser1;
			setTemperorybrowser(browser1);
		} else {
			browser = (String) datamap.get("Browser");
			tempbrowser = (String) datamap.get("Browser");
			setTemperorybrowser((String) datamap.get("Browser"));
		}

		if (!(browser1.equalsIgnoreCase(""))) {
			os = os1;
			tempOS = os1;
			setTemperoryOS(os1);
		} else {
			os = (String) datamap.get("OS");
			tempOS = (String) datamap.get("OS");
			setTemperoryOS((String) datamap.get("OS"));
		}

		extentTest = extentReports
				.createTest(this.getClass().getSimpleName() + "-" + tempExecuteOn + "-" + tempOS + "-" + tempbrowser);
		test.set(extentTest);
	}

//	public void reportSetup(@Optional("chrome") String browser1,@Optional("75") String browserVersion1,@Optional("System Browsers") String executeOn1,@Optional("Windows")String os1,@Optional("10") String osVersion1) throws Exception
	@SuppressWarnings("deprecation")
	@BeforeMethod
	@Parameters({ "browser1", "browserVersion1", "executeOn1", "os1", "osVersion1" })
	public void reportSetup(@Optional("") String browser1, @Optional("") String browserVersion1,
			@Optional("") String executeOn1, @Optional("") String os1, @Optional("") String osVersion1)
			throws Exception {
		datamap = rd.readEnvironmentFromSheet("Environment");
		application = (String) datamap.get("Application");
		environment = (String) datamap.get("Environment");
		Thread.sleep(1000);
		if (!(executeOn1.equalsIgnoreCase(""))) {
			executeOn = executeOn1;
		} else {
			executeOn = (String) datamap.get("Execute On");
		}
		if (!(os1.equalsIgnoreCase(""))) {
			os = os1;
		} else {
			os = (String) datamap.get("OS");
		}
		if (!(osVersion1.equalsIgnoreCase(""))) {
			osVersion = osVersion1;
		} else {
			osVersion = (String) datamap.get("OS Version");
		}
		if (!(browser1.equalsIgnoreCase(""))) {
			browser = browser1;
		} else {
			browser = (String) datamap.get("Browser");
		}
		if (!(browserVersion1.equalsIgnoreCase(""))) {
			browserVersion = browserVersion1;
		} else {
			browserVersion = (String) datamap.get("Browser Version");
		}
		/*
		 * if (!(username1.equalsIgnoreCase(""))) { username = username1; } else {
		 * username = (String) datamap.get("BroserStackUsername"); } if
		 * (!(accesskey1.equalsIgnoreCase(""))) { accesskey = accesskey1; } else {
		 * accesskey = (String) datamap.get("BroserStackPassword"); }
		 */

		if (executeOn.equalsIgnoreCase("System Browsers")) {
			if (os.equalsIgnoreCase("Windows")) {
				System.out.println("Excecuting On: System Browsers");

				switch (browser.toUpperCase()) {
				case "CHROME":
					System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
					DesiredCapabilities caps1 = DesiredCapabilities.chrome();
					driver = new ChromeDriver(caps1);
					System.out.println("Browser Used: CHROME");
					break;

				case "FIREFOX":
					System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
					FirefoxOptions options = new FirefoxOptions();
					FirefoxProfile profile = new FirefoxProfile();
					profile.setPreference("browser.download.dir", "C:\\Users\\395749\\Downloads");
					profile.setPreference("browser.download.folderList", 1);
					profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
							"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;");
					profile.setPreference("browser.download.manager.showWhenStarting", false);
					profile.setPreference("pdfjs.disabled", true);
					profile.setPreference("browser.download.manager.showWhenStarting", false);
					profile.setPreference("pdfjs.disabled", true);
					options.setProfile(profile);
					driver = new FirefoxDriver(options);
					System.out.println("Browser Used: FIREFOX");
					break;

				case "IE":
					System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
					System.out.println("Browser Used: IE");
					InternetExplorerOptions optionsIE = new InternetExplorerOptions();
					/*
					 * optionsIE.disableNativeEvents();
					 * optionsIE.setCapability("unexpectedAlertBehaviour", "accept");
					 * optionsIE.setCapability("ignoreProtectedModeSettings", true);
					 * optionsIE.setCapability("disable-popup-blocking", true);
					 * optionsIE.setCapability("enablePersistentHover", true);
					 * optionsIE.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					 */
					optionsIE.setCapability("ignoreZoomSetting", "true");
					optionsIE.setCapability("ignoreProtectedModeSettings", "true");
					// optionsIE.setCapability("IntroduceInstabilityByIgnoringProtectedModeSettings",
					// "true");
					optionsIE.setCapability("disable-popup-blocking", "false");
					optionsIE.setCapability("unexpectedAlertBehaviour", "dismiss");
					optionsIE.disableNativeEvents();
					optionsIE.requireWindowFocus();
					optionsIE.enablePersistentHovering();
					driver = new InternetExplorerDriver(optionsIE);

					System.out.println("Zoom Setting Capability - " + optionsIE.getCapability("ignoreZoomSetting"));
					System.out.println(
							"Require Window Focus Capability - " + optionsIE.getCapability("requireWindowFocus"));
					System.out.println("Disable POP UP BLOCKER - " + optionsIE.getCapability("disable-popup-blocking"));
					break;
				}

			} else if (os.equalsIgnoreCase("OS X")) {
				System.out.println("Excecuting On: System Browsers");
				switch (browser.toUpperCase()) {
				case "CHROME":
					System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
					driver = new ChromeDriver();
					System.out.println("Browser Used: CHROME");
					break;

				case "FIREFOX":
					System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
					FirefoxOptions options = new FirefoxOptions().setProfile(new FirefoxProfile());
					driver = new FirefoxDriver(options);
					System.out.println("Browser Used: FIREFOX");
					break;
				}
			}
		} else if (executeOn.equalsIgnoreCase("Browserstack")) {
			bsLocal = new Local();
			bsLocalArgs = new HashMap<String, String>();
			bsLocalArgs.put("key", accesskey);
			bsLocalArgs.put("forcelocal", "true");
			bsLocal.start(bsLocalArgs);
			System.out.println("Is Browserstack Local Testing running - " + bsLocal.isRunning());

			System.out.println("Excecuting On: Browserstack");
			caps = new DesiredCapabilities();

			switch (browser.toUpperCase()) {
			case "CHROME":
				// caps = DesiredCapabilities.chrome();
				System.out.println("Browser Used: CHROME");
				break;

			case "FIREFOX":
				// caps = DesiredCapabilities.firefox();
				System.out.println("Browser Used: FIREFOX");
				break;

			case "IE":
				// caps = DesiredCapabilities.internetExplorer();
				System.out.println("Browser Used: INTERNET EXPLORER");
				caps.setCapability("browserstack.selenium_version", "3.141.59");
				caps.setCapability("browserstack.ie.arch", "x32");
				caps.setCapability("browserstack.ie.driver", "3.141.59");
				caps.setCapability("browserstack.ie.enablePopups", "true");
				break;

			case "EDGE":
				// caps = DesiredCapabilities.edge();
				System.out.println("Browser Used: EDGE");
				break;

			case "SAFARI":
				// caps = DesiredCapabilities.safari();
				System.out.println("Browser Used: SAFARI");
				caps.setCapability("browserstack.selenium_version", "3.14.0");
				caps.setCapability("browserstack.safari.driver", "2.48");
				break;
			}

			createDriver(browser, browserVersion, os, osVersion, username, accesskey);
			driver = getWebDriver();
			((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
			driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,
			// "0"));
		}
	}

	@BeforeMethod(dependsOnMethods = "reportSetup")
	public void launchURL() {
		try {
			// driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			System.out.println("Launching URL: " + loginURL);

			try {
				driver.get(loginURL);
			} catch (Exception e) {
				reportSetup(browser, browserVersion, executeOn, os, osVersion); // ,username,accesskey
			}

			SessionId id1 = ((RemoteWebDriver) driver).getSessionId();
			System.out.println("Session ID - " + id1);
			test.get().log(Status.INFO, MarkupHelper.createLabel("Launching URL: " + loginURL, ExtentColor.CYAN));
			test.get().log(Status.INFO, MarkupHelper.createLabel("Browser used: " + browser, ExtentColor.CYAN));
			test.get().log(Status.INFO, MarkupHelper.createLabel("OS used: " + os, ExtentColor.CYAN));
			test.get().log(Status.INFO, MarkupHelper.createLabel("Platform used: " + executeOn, ExtentColor.CYAN));
			test.get().log(Status.INFO, MarkupHelper.createLabel("Browser Session  ID: " + id1, ExtentColor.CYAN));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	@AfterMethod(alwaysRun = true)
	public void logout(ITestResult testResult) throws InterruptedException, IOException {
		if (testResult.getStatus() == ITestResult.SUCCESS) {
			driver.get(homePageURL);
			System.out.println("Calling Home Page URL");
			if (isAlertPresent(driver)) {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			}
			driver.get(logoutURL);
			System.out.println("Calling Logout URL");
			try {
				test.get().log(Status.INFO, MarkupHelper.createLabel("User Logged Out", ExtentColor.CYAN));
				screenshotPath = getScreenshot(driver, this.getClass().getName());
				test.get().info("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} catch (Exception e) {

			}
		}
	}

	@AfterMethod(alwaysRun = true, dependsOnMethods = "logStatus")
	public void finishRep() throws IOException {
		try {
			Thread.sleep(1000);
			// driver.close();
			driver.quit();
			// bsLocal.stop(bsLocalArgs);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured closing and quitting the driver" + e.getMessage());
		}
	}

	@AfterMethod(alwaysRun = true, dependsOnMethods = "logout")
	public void logStatus(ITestResult testResult) throws IOException {
		System.out.println("Listener Test Result - " + testResult.getStatus());
		System.out.println("Listener Test Result For Success - " + ITestResult.SUCCESS);
		System.out.println("Listener Test Result For Failure - " + ITestResult.FAILURE);
		System.out.println("Listener Test Result For Skip - " + ITestResult.SKIP);

		if (testResult.getStatus() == ITestResult.FAILURE) {
			StringWriter sw = new StringWriter();
			testResult.getThrowable().printStackTrace(new PrintWriter(sw));
			String stacktrace = sw.toString();
			test.get().log(Status.INFO,
					MarkupHelper.createLabel(testResult.getName() + "\n" + stacktrace, ExtentColor.RED));
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(testResult.getName() + " - Test Case Failed", ExtentColor.RED));
			test.get().log(Status.FAIL,
					MarkupHelper.createLabel(testResult.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel(testResult.getMethod() + " - Method in Test Case Failed", ExtentColor.RED));
			test.get().log(Status.FAIL, MarkupHelper
					.createLabel("Failure Message - " + testResult.getThrowable().getMessage(), ExtentColor.RED));
			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			testResult.getThrowable().printStackTrace();
			fw.write(classUnderExecution + " - Test Case Failed" + "\r\n");

		} else if (testResult.getStatus() == ITestResult.SKIP) {
			StringWriter sw = new StringWriter();
			testResult.getThrowable().printStackTrace(new PrintWriter(sw));
			String stacktrace = sw.toString();
			test.get().log(Status.SKIP,
					MarkupHelper.createLabel(testResult.getName() + "\n" + stacktrace, ExtentColor.ORANGE));
			test.get().log(Status.SKIP,
					MarkupHelper.createLabel(testResult.getName() + " - Test Case SKIPPED", ExtentColor.ORANGE));
			test.get().log(Status.SKIP,
					MarkupHelper.createLabel(testResult.getThrowable() + " - Test Case SKEPPED", ExtentColor.ORANGE));
			test.get().log(Status.SKIP, MarkupHelper
					.createLabel(testResult.getMethod() + " - Method in Test Case Skipped", ExtentColor.ORANGE));
			test.get().log(Status.SKIP, MarkupHelper
					.createLabel("SKIP Message - " + testResult.getThrowable().getMessage(), ExtentColor.ORANGE));

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().skip("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

			fw.write(classUnderExecution + " - Test Case Skipped" + "\r\n");
		} else if (testResult.getStatus() == ITestResult.SUCCESS) {
			test.get().log(Status.PASS,
					MarkupHelper.createLabel(testResult.getName() + " - Test Case Passed", ExtentColor.GREEN));

			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}

			screenshotPath = getScreenshot(driver, this.getClass().getName());
			test.get().pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			fw.write(classUnderExecution + " - Test Case Passed" + "\r\n");
		}
	}

	@AfterSuite(alwaysRun = true)
	public void quit() throws Exception {
		Runtime.getRuntime().exec("java -jar RI_Parser_New.jar");
		Thread.sleep(5000);
		try {
			if (executeOn.equalsIgnoreCase("Browserstack")) {
				// webDriver.get().close();
				// webDriver.get().quit();
			} else if (executeOn.equalsIgnoreCase("System Browsers")) {
				/*
				 * driver.close(); driver.quit();
				 */}
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("Exception occured closing and quitting the driver" + e1.getMessage());
		}
		try {
			extentReports.flush();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterSuite(alwaysRun = true)
	public void finishReport() throws IOException {
		try {
			extentReports.flush();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isAlertPresent(WebDriver driver) {
		boolean result = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver,5);
			wait.until(ExpectedConditions.alertIsPresent());
			System.out.println("Alert is Present");
			result = true;
		} catch (Exception Ex) {
			// Ex.printStackTrace();
			System.out.println("Alert is not Present Catch 1");
			result = false;
		}

		try {
			driver.switchTo().alert();
			System.out.println("Switched to Alert");
			result = true;
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Alert is not Present Catch 2");
			result = false;
		}

		return result;
	}

	public String getScreenshot(WebDriver driver, String test) {
		String timeStamp = new SimpleDateFormat("dd-MM-YY-HH-mm-ss").format(Calendar.getInstance().getTime());
		String screenshotPath = System.getProperty("user.dir") + File.separatorChar + "Results" + File.separatorChar
				+ "Screenshots" + File.separatorChar + test + timeStamp + ".jpeg";
		try {
			driver = new Augmenter().augment(driver);
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File destFile = new File(screenshotPath);
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			System.out.println("Exception faced while taking screenshot: " + e.getMessage());
			return null;
		}
		return screenshotPath;
	}

}