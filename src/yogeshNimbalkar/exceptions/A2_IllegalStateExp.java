package yogeshNimbalkar.exceptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A2_IllegalStateExp {

	public static void main(String[] args) {
		//if driver not found or the driver path is incorrect then it raise the exception
		System.setProperty("webdriver.chrome.driver", "chromedriver123.exe");
		System.out.println("Below line raise exception");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
}
