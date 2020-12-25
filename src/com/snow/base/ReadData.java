package com.snow.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {

	public Object[][] readDataFromSheet(String sheetName) throws IOException {
		String inputExcel = "input.xlsx";
		File file = new File(System.getProperty("user.dir") + File.separatorChar + inputExcel);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet(sheetName);

		int lastRowNum = sheet.getLastRowNum();
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		Object[][] objects = new Object[lastRowNum][1];

		for (int i = 0; i < lastRowNum; i++) {
			Map<Object, Object> datamap = new HashMap<Object, Object>();
			for (int j = 0; j < lastCellNum; j++) {
				if (sheet.getRow(0).getCell(j).toString() != null) {
					datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i + 1).getCell(j).toString());
					// System.out.println(sheet.getRow(i + 1).getCell(j).toString());
					objects[i][0] = datamap;
				}
			}
			// System.out.println(objects[i][0].toString());
		}
		workbook.close();
		return objects;
	}

	public Map<Object, Object> readEnvironmentFromSheet(String sheetName) throws IOException {
		Map<Object, Object> datamap = null;
		String inputExcel = "input.xlsx";
		File file = new File(System.getProperty("user.dir") + File.separatorChar + inputExcel);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet(sheetName);

		int lastRowNum = sheet.getLastRowNum();
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		Object[][] objects = new Object[lastRowNum][1];

		for (int i = 0; i < lastRowNum; i++) {
			datamap = new HashMap<Object, Object>();
			for (int j = 0; j < lastCellNum; j++) {
				if (sheet.getRow(0).getCell(j).toString() != null) {
					datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i + 1).getCell(j).toString());
					// System.out.println(sheet.getRow(i + 1).getCell(j).toString());
					objects[i][0] = datamap;
				}
			}
			// System.out.println(objects[i][0].toString());
		}
		workbook.close();
		return datamap;
	}

	public Map<String, String> readUserDetailsFromSheet(String sheetName) throws IOException {
		Map<String, String> data = new HashMap<String, String>();
		String inputExcel = "input.xlsx";
		File file = new File(System.getProperty("user.dir") + File.separatorChar + inputExcel);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet(sheetName);

		int lastRowNum = sheet.getLastRowNum();
		Object[][] objects = new Object[lastRowNum][1];
		for (int i = 1; i <= lastRowNum; i++) {
			if (sheet.getRow(i).getCell(1).toString() != null) {
				data.put(sheet.getRow(i).getCell(1).toString(), sheet.getRow(i).getCell(2).toString());
				/*
				 * System.out.println("Key - " + sheet.getRow(i).getCell(1).toString());
				 * System.out.println("Value - " + sheet.getRow(i).getCell(2).toString());
				 * System.out.println(data);
				 */
				objects[i - 1][0] = data;
			}
		}
		workbook.close();
		return data;
	}

	public Map<Object, Object> readFromDataLibrary(String sheetName) throws IOException {
		Map<Object, Object> datamap = null;
		System.out.println("Sheet Name is  - " + sheetName);
		if (sheetName.length() > 30) {
			sheetName = sheetName.substring(0, 30).trim();
		}
		System.out.println("Sheet Name is  - " + sheetName);

		String dataLibrary = "DataLibrary.xlsx";
		File file = new File(System.getProperty("user.dir") + File.separatorChar + dataLibrary);

		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet(sheetName);

		int lastRowNum = sheet.getLastRowNum();
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		/* Object[][] objects = new Object[lastRowNum][1]; */

		System.out.println("Total Row count - " + lastRowNum);
		datamap = new HashMap<Object, Object>();
		for (int i = 0; i <= lastRowNum; i++) {
			for (int j = 0; j <= lastCellNum; j++) {
				if (sheet.getRow(i).getCell(j).toString() != null) {
					System.out.println("Key - " + sheet.getRow(i).getCell(j).toString());
					System.out.println("Value  - " + sheet.getRow(i).getCell(j + 1).toString());
					datamap.put(sheet.getRow(i).getCell(j).toString().trim(),
							sheet.getRow(i).getCell(j + 1).toString().trim());
					break;
					/* objects[i][0] = datamap; */
				}
			}
		}

		workbook.close();
		return datamap;
	}

	public boolean updateDataLibrary(String sheetName, String environment, String uniqueId)
			throws EncryptedDocumentException, IOException {
		System.out.println("Sheet Name is  - " + sheetName);
		if (sheetName.length() > 30) {
			sheetName = sheetName.substring(0, 30).trim();
		}
		System.out.println("Sheet Name is  - " + sheetName);

		String dataLibrary = "DataLibrary.xlsx";
		File file = new File(System.getProperty("user.dir") + File.separatorChar + dataLibrary);

		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet(sheetName);

		int lastRowNum = sheet.getLastRowNum() + 1;
		Row row = sheet.createRow(lastRowNum);
		Cell cell2Update = row.createCell(0);
		cell2Update.setCellValue(environment);
		cell2Update = row.createCell(1);
		cell2Update.setCellValue(uniqueId);

		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
		outputStream.close();
		workbook.close();
		return true;
	}

	public boolean clearDataLibrary(String sheetName) throws Exception {
		if (sheetName.length() > 30) {
			sheetName = sheetName.substring(0, 30).trim();
		}

		String dataLibrary = "DataLibrary.xlsx";
		File file = new File(System.getProperty("user.dir") + File.separatorChar + dataLibrary);

		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = null;

		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			if (sheetName.trim().contains(workbook.getSheetName(i).trim())) {
				int index = workbook.getSheetIndex(sheetName);
				workbook.removeSheetAt(index);
				break;
			}
		}

		sheet = workbook.createSheet(sheetName);

		Row row = sheet.createRow(0);
		Cell cell2Update = row.createCell(0);
		cell2Update.setCellValue("Identifier Variables");
		cell2Update = row.createCell(1);
		cell2Update.setCellValue("Unique ID");

		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
		outputStream.close();
		workbook.close();
		return true;
	}

	public void updateExcel(String sheetName, String jobName) throws IOException {
		String updateExcel = "RIManager.xls";
		File file = new File(System.getProperty("user.dir") + File.separatorChar + updateExcel);

		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Cell cell2Update = sheet.getRow(1).getCell(0);
		cell2Update.setCellValue(jobName);

		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();

		String jobTextFile = "JobName.txt";
		File txtfile = new File(System.getProperty("user.dir") + File.separatorChar + jobTextFile);
		PrintWriter writer = new PrintWriter(txtfile);
		writer.print("");
		writer.close();
		writer = new PrintWriter(txtfile);
		writer.print(jobName);
		writer.close();

	}
}