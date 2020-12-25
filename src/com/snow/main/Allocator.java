package com.snow.main;

import java.util.List;

import org.testng.TestNG;
import org.testng.collections.Lists;

/**
 * <h1>Allocator Class</h1> This class is used to trigger the test suite in
 * testng.xml file
 *
 */
public class Allocator {

	/**
	 * This main method is used to trigger the test suite in testng.xml file
	 * 
	 * @param args not used.
	 * @return Nothing.
	 * @exception Nothing.
	 * 
	 */
	public static void main(String[] args) throws Exception {
		TestNG testng = new TestNG();
		String path = "testng.xml";
		List<String> suites = Lists.newArrayList();

		suites.add(path);
		testng.setTestSuites(suites);
		testng.run();

	}

}
