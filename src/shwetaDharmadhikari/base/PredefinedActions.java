package shwetaDharmadhikari.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {

	public static WebDriver start() {
		return start("http://automationbykrishna.com/");
	}

	public static WebDriver start(String url) {
		System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
}
