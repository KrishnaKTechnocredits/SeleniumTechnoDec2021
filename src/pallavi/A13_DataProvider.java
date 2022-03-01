/*Assignment - 13: 28th Feb'2022
1. To automate automation by Krishna login functionality from Data-driven
    a. using a double dimensional array
    b. using an excel file*/

package pallavi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import technocredits.base.PredefinedActions;

public class A13_DataProvider {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass()
	public void openBrowser() {
		driver = PredefinedActions.openBrowser("http://automationbykrishna.com/");
		driver.findElement(By.id("registration2")).click();
	}

	@Test(dataProvider = "LoginDataExcel")
	public void registration(String user, String pwd, String message) {
		WebElement uName = PredefinedActions.waitForElementToVisible(By.id("unameSignin"));
		WebElement password = driver.findElement(By.id("pwdSignin"));
		WebElement btnSubmit = driver.findElement(By.xpath("//button[@id='btnsubmitdetails']"));

		uName.clear();
		uName.sendKeys(user);
		password.clear();
		password.sendKeys(pwd);
		btnSubmit.click();
		Alert alert = driver.switchTo().alert();

		System.out.println("UserName--->" + user + "   Password--->" + pwd + "  Message--->" + message);
		System.out.println("Actual Message--->" + alert.getText());
		if (alert.getText().equals(message))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
		alert.accept();
	}

	@DataProvider(name = "LoginDataStatic")
	public Object[][] dataProvider() {

		Object[][] inputs = new Object[3][3];

		inputs[0][0] = "User1";
		inputs[0][1] = "pwd1";
		inputs[0][2] = "Failed! please enter strong password";

		inputs[1][0] = "User2";
		inputs[1][1] = "pwd1234567";
		inputs[1][2] = "Success!";

		inputs[2][0] = "User3";
		inputs[2][1] = "pwd456789";
		inputs[2][2] = "Success!";

		return inputs;
	}

	@DataProvider(name = "LoginDataExcel")
	public Object[][] excelDataProvider() throws IOException {
		File file = new File(".\\externalFiles\\login.xlsx");
		FileInputStream inputStream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet1 = workbook.getSheet("Sheet1");

		int totalRows = sheet1.getLastRowNum() + 1;
		int totalCol = sheet1.getRow(0).getLastCellNum();
		Object[][] input = new Object[totalRows][totalCol];

		for (int row = 0; row < totalRows; row++)
			for (int col = 0; col < totalCol; col++) {
				input[row][col] = sheet1.getRow(row).getCell(col).getStringCellValue();
			}
		return input;
	}

	@AfterClass()
	public void tearDown() {
		driver.close();
	}
}
