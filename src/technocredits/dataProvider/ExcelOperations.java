package technocredits.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelOperations {

	
	public void readExcel() throws IOException {
		File file = new File("./externalFiles/login.xlsx");
		FileInputStream input = new FileInputStream(file);

		// after 2007 -> xlsx -> XSSFWorkbook
		// before 2007 -> xls -> HSSFWorkbook

		Workbook workbook = new XSSFWorkbook(input);
		Sheet sheet = workbook.getSheet("Sheet1");

		int totalRow = sheet.getLastRowNum() + 1;
		int totalCol = sheet.getRow(0).getLastCellNum();

		System.out.println("Row : " + totalRow);
		System.out.println("Col : " + totalCol);
		
		Object[][] data = new Object[totalRow][totalCol];

		for (int rowCount = 0; rowCount < totalRow; rowCount++) {
			for (int colCnt = 0; colCnt < totalCol; colCnt++) {
				String cellValue = sheet.getRow(rowCount).getCell(colCnt).getStringCellValue();
				data[rowCount][colCnt] = cellValue;
			}
		}
	}
}
