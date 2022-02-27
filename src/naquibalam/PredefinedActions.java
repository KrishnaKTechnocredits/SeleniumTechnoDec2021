package naquibalam;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {

	static WebDriver openBrowser(String pathToDriver, String url) {
		System.setProperty("webdriver.chrome.driver", pathToDriver);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	static void closeDriver(WebDriver driver) {
		Set<String> driverList = driver.getWindowHandles();
		for (String allWebdriverOpen : driverList) {
			if (!(allWebdriverOpen.equals(null))) {
				driver.close();
			}
		}
	}
}
