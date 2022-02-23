package yogeshNimbalkar.exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A2_UnHandledAlertExp {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Browser Maximized");
		
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.partialLinkText("Basic ")).click();
		System.out.println("Browser Launched");
		
		Thread.sleep(2000);
		driver.findElement(By.id("javascriptAlert")).click();
		
		Thread.sleep(3000);
		System.out.println("Below line raise exception");
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).click();
		driver.quit();
	}
}
