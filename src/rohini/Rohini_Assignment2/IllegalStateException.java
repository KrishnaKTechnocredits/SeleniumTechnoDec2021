package rohini.Rohini_Assignment2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IllegalStateException {

	public static void main(String[] args) {
		//Wrong exe path
		System.setProperty("webdriver.chrome.driver", "chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("http://automationbykrishna.com/");
		
		System.out.println("Browser launched");
		driver.close();
		System.out.println("Browser Closed");

	}

}
