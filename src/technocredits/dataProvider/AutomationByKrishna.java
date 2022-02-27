package technocredits.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

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

import technocredits.base.PredefinedActions;

public class AutomationByKrishna {
	
	@Test(dataProvider = "excelData")
	public void login(String name, String pwd, String message) {
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/#");

		driver.findElement(By.id("registration2")).click();
		PredefinedActions.waitForElementToVisible(By.id("unameSignin")).sendKeys(name);
		driver.findElement(By.id("pwdSignin")).sendKeys(pwd);
		driver.findElement(By.id("btnsubmitdetails")).click();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String actualText = alert.getText();
		if (actualText.equals(message)) {
			System.out.println("Test Case Pass");
		} else {
			System.out.println("Fail");
		}
		alert.accept();
	}

	@Test(dataProvider = "loginData", enabled = false)
	public void m1(String name, String pwd, String message) {
		System.out.println(name + " : " + pwd + " : " + message);
	}

	@DataProvider(name = "loginData")
	public Object[][] getData() {
		// [row][colum]
		Object[][] data = new Object[3][3];
		data[0][0] = "harsh";
		data[0][1] = "123456";
		data[0][2] = "Failed! please enter strong password";

		data[1][0] = "maulik";
		data[1][1] = "123456789";
		data[1][2] = "Success!";

		data[2][0] = "krishna";
		data[2][1] = "123456789";
		data[2][2] = "Success!";

		return data;
	}

	@DataProvider(name="excelData")
	public Object[][] getDataFromExcel() throws Exception {
		File file = new File("./externalFiles/login.xlsx");
		FileInputStream input = new FileInputStream(file);

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
		return data;
	}
}
