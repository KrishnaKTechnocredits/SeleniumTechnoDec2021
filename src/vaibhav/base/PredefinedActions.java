package vaibhav.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {

	public static WebDriver launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Chrome browser launched and maximized");
		driver.get("http://automationbykrishna.com/#");
		System.out.println("URL successfully launched : http://automationbykrishna.com/#");
		System.out.println();
		return driver;
	}

	public static WebDriver launchBrowser(String browserURL) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Chrome browser launched and maximized");
		driver.get(browserURL);
		System.out.println("URL successfully lauched : " + browserURL);
		System.out.println();
		return driver;
	}

}
