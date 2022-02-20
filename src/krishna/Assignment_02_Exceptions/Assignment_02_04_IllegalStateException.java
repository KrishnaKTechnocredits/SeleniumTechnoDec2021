package krishna.Assignment_02_Exceptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_02_04_IllegalStateException {
	public static void main(String[] args) throws InterruptedException {
		// If we didn't give the correct path of chromedriver.exe then IllegalStateException occurs.
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("http://automationbykrishna.com/");
		
	}
}
