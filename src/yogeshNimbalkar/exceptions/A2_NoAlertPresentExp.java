package yogeshNimbalkar.exceptions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A2_NoAlertPresentExp {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Browser maximized");
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.partialLinkText("Basic ")).click();
		System.out.println("Browser Launched");
		
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		driver.close();
	}
}
