package sagarShrikhande;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A2_Exceptions {

	void methodNoSuchWindowException(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");
		driver.switchTo().window("http://google.com").getTitle();
	}

	void methodNoSuchSessionException(WebDriver driver, String url) {
		driver.get(url);
		driver.quit();
		driver.close();
	}

	void methodElementNotInteractableException(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)", "");
		driver.findElement(By.id("disabledInput")).sendKeys("SGR");
	}

	void methodIllegalStateException(String url) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sagarshr\\eclipse-workspace\\Introduction\\driver\\wrong\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	void methodAlertNotPresent(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");
		driver.switchTo().alert().accept();
		driver.findElement(By.id("javascriptAlert")).click();

	}

	void methodElementClickInterceptedException(WebDriver driver, String url) {
		driver.get(url);
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		driver.findElement(By.id("javascriptAlert")).click();
	}

	void methodNoSuchElementException(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='basicelementsXZ']")).click();
	}

	void methodUnHandledAlertException(WebDriver driver, String url) {
		System.out.println("This method will give UnHandledAlertException");
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");
		driver.findElement(By.id("javascriptAlert")).click();
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		A2_Exceptions a2 = new A2_Exceptions();
		System.setProperty("webdriver.chrome.driver",
				 "I:\\Learning\\Eclipse\\Selenium\\SeleniumTechnoDec2021\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "http://automationbykrishna.com";
		//a2.methodNoSuchWindowException(driver, url);
		//a2.methodNoSuchSessionException(driver, url);
		//a2.methodElementNotInteractableException(driver, url);
		//a2.methodIllegalStateException(url);
		//a2.methodAlertNotPresent(driver, url);
		//a2.methodNoSuchElementException(driver, url);
		a2.methodUnHandledAlertException(driver, url);
	}
}
