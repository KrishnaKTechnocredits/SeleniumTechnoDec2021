package sagarShrikhande.testngPractice;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.PredefinedActions;

public class A13_DataProvider {

	@Test(dataProvider = "excelData")
	public void login(String name, String pwd, String message) {
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/#");

		driver.findElement(By.id("registration2")).click();
		PredefinedActions.waitForElementToVisible(By.id("unameSignin")).sendKeys(name);
		driver.findElement(By.id("pwdSignin")).sendKeys(pwd);
		driver.findElement(By.id("btnsubmitdetails")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String actualText = alert.getText();
		if (actualText.equals(message)) {
			System.out.println("Test Case Pass");
		} else {
			System.out.println("Fail");
		}
		alert.accept();
	}

	@Test(dataProvider = "loginData")
	public void m1(String name, String pwd, String message) {
		System.out.println(name + " : " + pwd + " : " + message);
	}

	@DataProvider(name = "loginData")
	public Object[][] getData() {
		// [row][column]
		Object[][] data = new Object[3][3];
		data[0][0] = "sagar";
		data[0][1] = "627@fs";
		data[0][2] = "Failed! please enter strong password";

		data[1][0] = "Kaustuki";
		data[1][1] = "abcd.shsj67";
		data[1][2] = "Success!";

		data[2][0] = "rakhi";
		data[2][1] = "37388egsdgs";
		data[2][2] = "Success!";
		return data;
	}

	@DataProvider(name = "excelData")
	public Object[][] getDataFromExcel() throws Exception {
		File file = new File("./externalFiles/login.xlsx");
		FileInputStream input = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(input);
		Sheet sheet = workbook.getSheet("Sheet1");

		int totalRowCount = sheet.getLastRowNum() + 1;
		int totalColCount = sheet.getRow(0).getLastCellNum();

		System.out.println("Row : " + totalRowCount);
		System.out.println("Col : " + totalColCount);

		Object[][] data = new Object[totalRowCount][totalColCount];

		for (int rowCount = 0; rowCount < totalRowCount; rowCount++) {
			for (int colCount = 0; colCount < totalColCount; colCount++) {
				String cellValue = sheet.getRow(rowCount).getCell(colCount).getStringCellValue();
				data[rowCount][colCount] = cellValue;
			}
		}
		workbook.close();
		return data;
	}
}

/*
 * 1. To Automate automation by krishna login functionality from Data-driven a.
 * using a double dimensional array b. using an excel file
 */
