package vaibhav.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	public static WebElement waitUntilVisibilityOfElementLocatedBy(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
	}
	 
	public static List <WebElement> waitUntilVisibilityOfAllElementsLocatedBy(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		List <WebElement> elementList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		return elementList;
	}

}
