package yogeshNagar;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class A13_DataProviderExcel {
	
	@Test(dataProvider="testData")
	public void readExcelData(String UserName, String PassWord, String Message) {
		WebDriver driver = BaseClass.launchBrowser("http://automationbykrishna.com/");
		driver.findElement(By.id("registration2")).click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unameSignin")));
		WebElement userName = driver.findElement(By.id("unameSignin"));
		WebElement passWord = driver.findElement(By.id("pwdSignin"));
		WebElement subBtn = driver.findElement(By.id("btnsubmitdetails"));
		userName.click();
		userName.sendKeys(UserName);
		passWord.click();
		passWord.sendKeys(PassWord);
		subBtn.click();
		Alert alert = driver.switchTo().alert();
		if(Message.equals(alert.getText()))
			System.out.println("Pass");
		else
			System.out.println("Fail");	
		
		alert.accept();
		driver.quit();
	}
	
	@DataProvider(name="testData")
	public Object[][] getData() throws IOException{
		File file = new File("./src/yogeshNagar/resource/testData.xlsx");
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
