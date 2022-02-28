package yogeshNimbalkar;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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


public class A13_RegistractionFromExcelData {

	@Test(dataProvider="excelData")
	public void login(String name, String pwd, String msg) {
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registration2"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='unameSignin']"))).sendKeys(name);
//		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("yogesh");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		
		Alert alert = driver.switchTo().alert();
		String actualResult = alert.getText();
		System.out.println(actualResult);
		if(actualResult.equals(msg)) {
			System.out.println("Test case pass");
		}else {
			System.out.println("Test case failed");
		}
		alert.accept();
		driver.close();
	}
	
	
	@DataProvider(name="loginData")
	public Object[][] getData(){
		Object[][] data = new Object[2][3];
		
		data[0][0] = "yogesh";
		data[0][1] = "Test1234";
		data[0][2] = "Failed! please enter strong password";
		
		data[1][0] = "Swarup";
		data[1][1] = "Test12345";
		data[1][2] = "Success!";
		
		return data;
	}
	
	
	@DataProvider(name="excelData")
	public Object[][] getDataFromExcel() throws IOException{
		File file = new File("./externalFiles/login.xlsx");
		FileInputStream input = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(input);
		Sheet sheet = workbook.getSheet("Sheet1");
		int totalRow = sheet.getLastRowNum() + 1; //apachi poi return row count -1 because consider first line as header .: we have add 1 to match the count
		int totalCol = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[totalRow][totalCol];
		for(int rowCount=0; rowCount<totalRow; rowCount++) {
			for(int colCount=0; colCount<totalCol; colCount++) {
				String cellValue = sheet.getRow(rowCount).getCell(colCount).getStringCellValue();
				data[rowCount][colCount] = cellValue;
			}
		}
		workbook.close();
		return data;
	}
}
