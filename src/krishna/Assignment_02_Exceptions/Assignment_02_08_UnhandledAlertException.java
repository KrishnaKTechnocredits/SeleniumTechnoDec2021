package krishna.Assignment_02_Exceptions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_02_08_UnhandledAlertException {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//*[@id=\"basicelements\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"javascriptAlert\"]")).click();
		Alert alert = driver.switchTo().alert();

		alert.accept();
		/*
		 * If we comment alert.accept() then UnhandledAlertException occur because as we
		 * click on alert then it will block UI and we have to handle this alert
		 */
		// Click on Basic Elements again
		driver.findElement(By.xpath("//*[@id=\"basicelements\"]")).click();
	}

}
