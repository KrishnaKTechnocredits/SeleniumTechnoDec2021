package yogeshNimbalkar.exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A2_NoSuchSessionExp {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Browser maximized");
		
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.partialLinkText("Basic ")).click();
		System.out.println("Browser Launched");
		
		Thread.sleep(2000);
		driver.quit();
		driver.close();
		System.out.println("Browser closed");
//		or instead of quit if you uncomment below close(), it will raise same exception.		
//		driver.close();
		System.out.println("Try to close once again");
	}
}
