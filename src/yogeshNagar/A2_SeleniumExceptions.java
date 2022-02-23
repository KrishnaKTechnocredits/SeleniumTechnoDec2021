package yogeshNagar;

/*To perform belwo exception when it occurs

NoSuchWindowException 
NoSuchSessionException 
ElementNotInteractableException  
IllegalStateException 
AlertNotPresent 
ElementClickInterceptedException
NoSuchElementException
UnHandledAlertException
*/

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A2_SeleniumExceptions {

	static void noSuchSessionException() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		try {
			driver.get("http://automationbykrishna.com/");
			driver.quit();
			driver.findElement(By.id("javascriptAlert")).click();
		} catch (NoSuchSessionException ne) {
			System.out.println(ne);
		}
	}

	static void unhandledAlertException() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		try {
			driver.findElement(By.id("basicelements")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("javascriptAlert")).click();
			Thread.sleep(1000);
			driver.close();
		} catch (UnhandledAlertException | InterruptedException ue) {
			System.out.println(ue);
			driver.quit();
		}
	}

	static void illegalStateException() {
		try {
			WebDriver driver = new ChromeDriver();
			driver.get("file:///C:/Users/yoges/Documents/Java_Class/SessionNotes/htmlForms/automationForm.html");
			driver.manage().window().maximize();
			WebElement webEle = driver.findElement(By.id("firstname"));
			webEle.sendKeys("Yogesh Nagar");
			driver.quit();
		} catch (IllegalStateException ie) {
			System.out.println(ie);
		}
	}

	static void elementNotInteractableException() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/yoges/Documents/Java_Class/SessionNotes/htmlForms/Harsh_Enable_&_Disable.html");
		driver.manage().window().maximize();
		try {
			WebElement webEle = driver.findElement(By.id("myText"));
			webEle.sendKeys("Yogesh Nagar");
		} catch (ElementNotInteractableException ei) {
			System.out.println(ei);
			driver.quit();
		}
	}

	static void noAlertPresentException() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		try {
			Alert al = driver.switchTo().alert();
			al.accept();
			driver.close();
		} catch (NoAlertPresentException na) {
			System.out.println(na);
			driver.quit();
		}
	}

	static void noSuchElementException() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		try {
			WebElement webEle = driver.findElement(By.id("lastname"));
			webEle.sendKeys("Yogesh Nagar");
			driver.close();
		} catch (NoSuchElementException ne) {
			System.out.println(ne);
			driver.quit();
		}
	}

	static void elementClickInterceptedException() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		try {
			driver.findElement(By.id("basicelements")).click();
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", "");
			driver.findElement(By.id("javascriptAlert")).click();
			Alert al = driver.switchTo().alert();
			al.accept();
			al.getText();

		} catch (ElementClickInterceptedException | InterruptedException ei) {
			System.out.println(ei);
			driver.quit();
		}
	}

	static void noSuchWindowException() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		try {
			driver.findElement(By.id("basicelements")).click();
			driver.switchTo().window("abc");
		} catch (NoSuchWindowException nw) {
			System.out.println(nw);
			driver.quit();
		}
	}

	public static void main(String[] args) {
		noSuchSessionException();
		unhandledAlertException();
		illegalStateException();
		elementNotInteractableException();
		noAlertPresentException();
		noSuchElementException();
		elementClickInterceptedException();
		noSuchWindowException();

	}

}
