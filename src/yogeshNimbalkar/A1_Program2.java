package yogeshNimbalkar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A1_Program2 {

	static void CheckAlertOnOkCancelClick() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		
//		Open Basic Elements tab
		driver.findElement(By.linkText("Basic Elements")).click();
		
//		find and click javascriptconfirmation button
		driver.findElement(By.id("javascriptConfirmBox")).click();
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		String actual = "Are you are doing your homework regularly, Press Okay else Cancel!!" ;
		String expected = alert.getText();
		System.out.println("Is Alert Message Correct :" + expected.equals(actual));
//		Ok click
		Thread.sleep(2000);
		alert.accept();
		String message = driver.findElement(By.xpath("//*[@id='pgraphdemo']")).getText();
		System.out.println("On OK message : " + message);
		
//		On Cancel click
		driver.findElement(By.id("javascriptConfirmBox")).click();
		alert = driver.switchTo().alert();
		Thread.sleep(3000);
		alert.dismiss();
		message = driver.findElement(By.xpath("//*[@id='pgraphdemo']")).getText();
		System.out.println("On Cancel Message :" + message);
		Thread.sleep(2000);
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		CheckAlertOnOkCancelClick();
	}
}
