package naquibalam;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A2_ExceptionCheck {
	
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
	
	void get_NoSuchSessionException(WebDriver driver) {
			driver.quit();
			driver.close();
	}

	void get_NoSuchWindowException(WebDriver driver) {
		driver.switchTo().window("abc");
	}
	
	void get_IllegalStateException(WebDriver driver) {
		driver.get("http://automationbykrishna.com/");
	}

	void get_ElementNotInteractableException(WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("disabledInput")).sendKeys("Naquib");
		driver.close();
	}

	void get_UnhandledAlertException(WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.id("javascriptAlert")).click();
		driver.close();
	}

	void get_NoSuchElementException(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id='Naquib']")).click();
	}

	void get_AlertNotPresentException(WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.id("javascriptAlert")).click();;
		Thread.sleep(2000);
		Alert displayedAlert = driver.switchTo().alert();
		displayedAlert.accept();
		displayedAlert.accept();
	}
	
	void get_ElementClickInterceptedException(WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@class='form-control m-bot15']")).click();
	}

	public static void main(String[] args) throws InterruptedException {
		A2_ExceptionCheck a2_ExceptionCheck  = new A2_ExceptionCheck();
		String driverPath = "./drivers/chromedriver_98Version.exe";
		String driverPath2 = "D:\\TechnoCredits";
		String url = "http://automationbykrishna.com/";
		WebDriver driver = openBrowser(driverPath, url);
		//WebDriver driver = openBrowser(driverPath2, url);
		try {
			//a2_ExceptionCheck.get_NoSuchSessionException(driver);
			//a2_ExceptionCheck.get_NoSuchWindowException(driver);
			//a2_ExceptionCheck.get_IllegalStateException(driver); //do this with driverPath2 in openBrowser method
			//a2_ExceptionCheck.get_ElementNotInteractableException(driver);	
			//a2_ExceptionCheck.get_UnhandledAlertException(driver);
			//a2_ExceptionCheck.get_NoSuchElementException(driver);
			//a2_ExceptionCheck.get_AlertNotPresentException(driver);
			a2_ExceptionCheck.get_ElementClickInterceptedException(driver);
		}finally {
			closeDriver(driver);
		}
	}
}
