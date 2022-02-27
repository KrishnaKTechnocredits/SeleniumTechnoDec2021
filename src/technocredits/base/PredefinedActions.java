package technocredits.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PredefinedActions {

	public static WebDriver driver;

	public static WebDriver openBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
//		WebDriver driver = new ChromeDriver();// child
//		TakesScreenshot ts = (TakesScreenshot) driver;// parent

		// Inheritance & polymorphism
//		ChromeDriver driver = new ChromeDriver();// child
//		TakesScreenshot ts =  driver;// parent

//		RemoteWebDriver driver = new ChromeDriver();// child
//		TakesScreenshot ts = driver;// parent

		return driver;
	}

	public static WebElement waitForElementToVisible(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return ele;
	}

	public static WebElement waitForElementToBeClick(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(by));
		return ele;
	}

}
