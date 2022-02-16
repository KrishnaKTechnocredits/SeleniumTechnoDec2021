package pradeep.A2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UnhandledAlertException {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		// Click on Basic Elements
		driver.findElement(By.xpath("//*[@id=\"basicelements\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"javascriptAlert\"]")).click();
		Alert alert = driver.switchTo().alert();
		// If alert.accept(); is commented then UnhandledAlertException because
		// as we click on alert then it will block UI then anyhow we have to handle this alert
		alert.accept();

		// Click on Basic Elements again
		driver.findElement(By.xpath("//*[@id=\"basicelements\"]")).click();
	}
}
