package swati;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitializeDriver {

	public static WebDriver initialize(String url) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		return driver;
	}

}
