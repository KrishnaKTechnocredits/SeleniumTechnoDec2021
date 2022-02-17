package pradeep.A2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NoSuchSessionException {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		Thread.sleep(2000);
		// If we uncomment driver.quit(); line then NoSuchSessionException will come because if driver.quit(); executed first then all session closed
		// Now we don't have any session available for closing......
		//driver.quit();	
		driver.close();		
	}
}
