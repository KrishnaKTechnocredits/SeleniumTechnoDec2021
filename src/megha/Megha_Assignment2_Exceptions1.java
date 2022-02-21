package megha;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Megha_Assignment2_Exceptions1 {

	// IllegalStateException
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("http://automationbykrishna.com/");
		System.out.println("Browser is launched");
		driver.close();
		System.out.println("Browser is Closed");

	}

}
