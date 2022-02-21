package pradeep.A2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IllegalStateException {
	public static void main(String[] args) throws InterruptedException {
		// If path of chromedriver.exe is not correct then IllegalStateException
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
	}
}
