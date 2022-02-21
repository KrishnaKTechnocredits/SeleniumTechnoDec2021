package krishna.Assignment_02_Exceptions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_02_02_AlertNotPresent {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");

		driver.findElement(By.xpath("//*[@id=\"basicelements\"]")).click();
		Thread.sleep(3000);//If we comment this line then then the element will not found and alert will not handled.
		driver.findElement(By.xpath("//*[@id=\"javascriptAlert\"]")).click();
		// alert.accept(); Exception occur here as alert is not found in UI.
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert: " + alert.getText());
		alert.accept();
		driver.close();
	}
}