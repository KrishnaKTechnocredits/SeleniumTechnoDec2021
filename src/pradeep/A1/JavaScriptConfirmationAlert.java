package pradeep.A1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptConfirmationAlert {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// 1. Navigate to automation by Krishna
		driver.get("http://automationbykrishna.com/");
		// 2. Click on the Basic Elements tab
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(3000);
		//Click on the "JavaScriptript Confirmation” tab under “DIFFERENT EXAMPLES OF ALERTS”
		driver.findElement(By.xpath("//*[@id=\"javascriptConfirmBox\"]")).click();
		
		Alert alert =driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.dismiss();
		System.out.println(driver.findElement(By.xpath("//*[@id=\"pgraphdemo\"]")).getText());		
	}
}
