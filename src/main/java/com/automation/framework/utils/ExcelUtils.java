package com.automation.framework.utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static List<String> readTestDataFromExcel(String filePath, String sheetName) {
		List<String> testData = new ArrayList<>();
		try {
			FileInputStream fileInputStream = new FileInputStream(filePath); // Adjust the path to your
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					testData.add(cell.getStringCellValue());
				}
			}
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return testData;
	}

}
