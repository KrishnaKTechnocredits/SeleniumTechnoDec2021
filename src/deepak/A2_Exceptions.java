package deepak;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A2_Exceptions {

	static void testIllegalStateException() {
		System.setProperty("webdriver.chrome.driver", "");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
	}

	static void testElementNotInteractableException() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//a[@id = 'basicelements']")).click();

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id = 'disabledInput']")).sendKeys("TestDeepak");

	}

	static void testNoSuchElementException() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//a[@id = 'basicelementsTESTforEXCEPTION']")).click();
	}

	static void testAlertNotPresent() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//a[@id = 'basicelements']")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000);

		// driver.findElement(By.xpath("//button[@id = 'javascriptAlert']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	static void testElementClickInterceptedException() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//a[@id = 'basicelements']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@id = 'javascriptAlert']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("window.scrollBy(0,250)", ""); Thread.sleep(2000);
		 */

	}

	static void testNoSuchSessionException() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.quit();
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		// testIllegalStateException();
		// testElementNotInteractableException();
		// testNoSuchElementException();
		// testAlertNotPresent();
		// testElementClickInterceptedException();
		// testNoSuchSessionException();
	}

}
