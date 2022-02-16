package sandip.Assignment_02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NoSuchSessionException {

	public static void main(String[] args) {
		System.getProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		System.out.println("URL Opened");
		driver.quit();
		System.out.println("Window Closed");
		driver.close();
	}
}
