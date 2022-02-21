package krishna.Assignment_02_Exceptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_02_06_NoSuchSessionException {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		Thread.sleep(2000);
		//driver.quit();
		/*
		 *  If this line is uncomment then NoSuchSessionException will
		 * occur because this line executed first, and then all session will
		 * closed-->Now we don't have any session available for closing.
		 */
		driver.close();
	}
}
