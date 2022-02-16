package pradeep.A2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertNotPresentException {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		// Click on Basic Elements
		driver.findElement(By.xpath("//*[@id=\"basicelements\"]")).click();
		// If this Thread.sleep(3000); is commented then AlertNotPresentException occurs because in UI Alert button is not visible due to slow loading....
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"javascriptAlert\"]")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert: " + alert.getText());
		// If alert.accept(); is put above line no 20 then AlertNotPresentException
		alert.accept();
	}
}
