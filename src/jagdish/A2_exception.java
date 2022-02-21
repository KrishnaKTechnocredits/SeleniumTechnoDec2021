package jagdish;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A2_exception {

	static void NoSuchWindowException() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.get("http://automationbykrishna.com/");
		System.out.println("Browser launched");
		webdriver.findElement(By.id("basicelements123")); /// no such window
		webdriver.quit();
	}

	static void NoSuchSessionException() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.get("http://automationbykrishna.com/");
		System.out.println("Browser launched");
		Thread.sleep(3000);
		webdriver.quit();
		webdriver.close();
	}

	static void ElementNotInteractableException() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		System.out.println("Browser Maximized");
		webdriver.get("file://C://Java//Dec21//Selenium Learning//HtmlForm/Harsh_Enable_&_Disable.html");
		System.out.println("Browser launched");
		webdriver.findElement(By.id("myText")).sendKeys("Jagdish");
		Thread.sleep(3000);
		webdriver.quit();
		System.out.println("Browser CLosed");
	}

	static void IllegalStateException() {
		System.setProperty("webdriver.chrome.driver", "./drivers./p/chromedriver_98Version.exe"); // Path change
		WebDriver webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		System.out.println("Browser Maximized");
		webdriver.get("file://C://Java//Dec21//Selenium Learning//HtmlForm/Hidden_&_Visible.html");
		System.out.println("Browser launched");
	}

	static void AlertNotPresent() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.get("http://automationbykrishna.com/");
		webdriver.switchTo().alert().accept();

	}

	static void ElementClickInterceptedException() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.get("http://automationbykrishna.com/");
		webdriver.findElement(By.xpath("//a[@id='basicelements']")).click();
		webdriver.findElement(By.id("javascriptAlert")).click();
	}

	static void NoSuchElementException() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.get("http://automationbykrishna.com/");
		webdriver.findElement(By.xpath("//a[@id='basicelementsXZ']")).click();
	}

	static void UnHandledAlertException() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.get("http://automationbykrishna.com/");
		webdriver.findElement(By.xpath("//a[@id='basicelements']")).click();
		webdriver.findElement(By.id("javascriptAlert")).click();
		webdriver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		// NoSuchWindowException();
		// NoSuchSessionException();
		// ElementNotInteractableException();
		// IllegalStateException();
		AlertNotPresent();
		// ElementClickInterceptedException();
		// NoSuchElementException();
		// UnHandledAlertException();
	}

}
