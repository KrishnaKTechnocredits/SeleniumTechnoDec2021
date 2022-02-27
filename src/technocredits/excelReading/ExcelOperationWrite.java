package technocredits.excelReading;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelOperationWrite {

	@Test
	public void readExcel() throws IOException {

		// after 2007 -> xlsx -> XSSFWorkbook
		// before 2007 -> xls -> HSSFWorkbook

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("StudentDetails_1");

//		int totalRow = sheet.getLastRowNum() + 1;
//		int totalCol = sheet.getRow(0).getLastCellNum();

		for (int rowCount = 0; rowCount < 10; rowCount++) {
			Row row = sheet.createRow(rowCount);
			for (int colCnt = 0; colCnt < 3; colCnt++) {
				Cell cell = row.createCell(colCnt, CellType.STRING);
				cell.setCellValue(colCnt);
			}
			System.out.println();
		}
		File file = new File("./externalFiles/studentDetails1.xlsx");
		FileOutputStream output = new FileOutputStream(file); //FileNotFopund
		workbook.write(output);//IO Exception
	}
}
