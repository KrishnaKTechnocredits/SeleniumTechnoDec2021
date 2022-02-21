package archana;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ass2_Exceptions {

	static void noSuchWindowException() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Archana\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		System.out.println("Maximized browser");

		driver.quit();
		driver.close();
	}

	static void noSuchSessionException() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Archana\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.close();
		WebElement basicElements = driver.findElement(By.xpath("//a[text() ='Basic Elements']"));
		Thread.sleep(3000);

	}

	static void illegalStateException() {

		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/TechnoCredits/Projects/Dec21/Notepad/automationForm.html");
		driver.manage().window().maximize();
		WebElement webEle = driver.findElement(By.id("firstname"));
		webEle.sendKeys("Archana Pawar");
		driver.close();
	}

	static void elementNotInteractableException() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Archana\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/TechnoCredits/Projects/Dec21/Notepad/automationForm.html");
		WebElement webEle = driver.findElement(By.id("firstname"));// textbox disabled
		webEle.sendKeys("Archana Pawar");
		driver.close();
	}

	static void noAlertPresentException() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Archana\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");//alert not present 
		driver.switchTo().alert();
		driver.close();
	}

	static void noSuchElementException() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Archana\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		WebElement webEle = driver.findElement(By.id("lastname"));
		webEle.sendKeys("Archana Pawar");
		driver.close();
	}

	public static void main(String[] args) {
		// noSuchWindowException();
		// noSuchSessionException();
		// illegalStateException();
		// elementNotInteractableException();
		// noAlertPresentException();
		 noSuchElementException();

	}

}
