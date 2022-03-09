package yogeshNagar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class A13_DataProvider {
	
	@Test(dataProvider="testData")
	public void testNGDataProvider(String UserName, String PassWord,String Message) {
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
	public Object[][] getData(){
		Object[][] data = new Object[2][3];
		data[0][0]="Test";
		data[0][1]="Test";
		data[0][2]="Failed! please enter strong password";
		
		data[1][0]="test1234";
		data[1][1]="test12345";
		data[1][2]="Success!";
		
		return data;
	}

}
