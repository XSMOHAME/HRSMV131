package com.snow.base;

import java.io.IOException;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class ReportSetup extends Base {

	@Parameters({ "browser1", "executeOn1", "os1" })
	public ReportSetup(@Optional("") String browser1, @Optional("") String executeOn1, @Optional("") String os1,
			String classUnderExecution) throws IOException {
		String tempExecuteOn;
		String tempbrowser;
		String tempOS;

		datamap = rd.readEnvironmentFromSheet("Environment");
		if (!(executeOn1.equalsIgnoreCase(""))) {
			tempExecuteOn = executeOn1;
		} else {
			tempExecuteOn = (String) datamap.get("Execute On");
		}
		if (!(browser1.equalsIgnoreCase(""))) {
			tempbrowser = browser1;
		} else {
			tempbrowser = (String) datamap.get("Browser");
		}
		if (!(browser1.equalsIgnoreCase(""))) {
			tempOS = os1;
		} else {
			tempOS = (String) datamap.get("OS");
		}

		StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
		StackTraceElement traceElement = stackTraceElement[1];
		String[] className = traceElement.getClassName().split("\\.");
		String testUnderExecution = className[className.length - 1];
		System.out.println(testUnderExecution);
		extentTest = extentReports
				.createTest(this.getClass().getSimpleName() + "-" + tempExecuteOn + "-" + tempOS + "-" + tempbrowser);
		test.set(extentTest);
	}

}