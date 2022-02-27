/*
         IllegalStateException 
         NoSuchWindowException 
         NoSuchSessionException 
         NoSuchElementException
         ElementNotInteractableException  
         ElementClickInterceptedException
         AlertNotPresent
         UnHandledAlertException
*/

package anjali;

import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A2_All_Exceptions {
	
	

	// IllegalStateException
	/*
	if wrong path set=>ava.lang.IllegalStateException:
	 The driver executable does not exist
	 if system.setProerty line is absent then=>java.lang.IllegalStateException:
	 // The path to the driver executable must be set by the webdriver.chrome.driver system property
	 */
	static void illegalStateException() {
		try {
			// if driver not found or the driver path is incorrect then it raise the
			// exception
			System.setProperty("webdriver.chrome.driver", "chromedriver123.exe");
			System.out.println("Below line raise exception");
			WebDriver driver = new ChromeDriver(); 
			driver.manage().window().maximize();
		} catch (IllegalStateException ie) {
			System.out.println(ie);
		}	
	
	}
	

	
	
	
	
	
	
	
	/*
	 * NoSuchWindowException =>NoSuchWindowException WebDriver Exception occurs,
	 * when the driver in the Selenium Program code is unable to find the pop-up
	 * window on the web page to switch i.e. when the driver is switching to an
	 * invalid or non-existing pop-up window.
	 */
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

	
	
	
	
	
	
	
	
	
	
	// NoSuchSessionExpection occurs when we try to perform actions after quitting
	// the session.
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
		driver.close();
	}

	
	
	
	
	
	
	
	
	
	
	// NoSuchElementException
	/*
	 * NoSuchElementException : This Exception occurs if an element could not be
	 * found. 
	 * NoSuchFrameException : This Exception occurs if the frame target to be
	 * switched to does not exist. NoAlertPresentException
	 */
	static void noSuchElementException() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver=new ChromeDriver();
		try
		{
			driver.get("https://www.google.com");
			driver.manage().window().maximize();
			WebElement webEle = driver.findElement(By.id("lastname"));
			webEle.sendKeys("Anjali");
		}
		finally
		{
			driver.close();
		}
	
	}

	
	
	
	
	
	
	
	
	
	
	// org.openqa.selenium.ElementNotInteractableException://
	// it came when we trying to enter some value in disable text
	static void elementNotInteractableException() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		try
		{
		driver.get("file:///C:/Users/a.bidkar/Downloads/htmlForms/Harsh_Enable_&_Disable.html");
		driver.findElement(By.xpath("//*[@id='myText']")).sendKeys("HEY");
		}
		finally
		{
			driver.close();
		}
	}

	
	
	
	
	
	
	
	
	
	/*
	 * if issue is with resolution and element not coming on screen then
	 * ElementClickInterceptedException() came to resolve this
	 * ElementClickInterceptedException() add below 2 lines=> JavascriptExecutor js
	 * = (JavascriptExecutor) driver; js.executeScript("window.scrollBy(0,250)",
	 * "");
	 */
	static void ElementClickInterceptedException() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		try
		{
			driver.get("http://automationbykrishna.com/");
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.findElement(By.id("basicelements")).click();
			Thread.sleep(2000);
			// JavascriptExecutor js = (JavascriptExecutor) driver;
			// js.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
			Alert alert = driver.switchTo().alert();
			String ExpectedResult = alert.getText();
			String ActualResult = "You must be TechnoCredits student!!";
			if (ActualResult.equals(ExpectedResult))
			System.out.println("Test case passed");
			else
			System.out.println("Test case failed");
		}
		finally
		{
			driver.close();
		}
		
	}

	
	
	
	
	
	
	// if there is no alert box present at the time of switching, then Selenium
	// raises NoAlertPresentException
	static void NoAlertPresentException() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("http://automationbykrishna.com/");
		System.out.println("Browser is launched");
		try 
		{
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(1500);
		driver.switchTo().alert();
		}
		finally
		{
			System.out.println("Browser is closed");
			driver.close();
		}
		
	}

	
	
	
	
	
	
	
	/*
	 * Selenium Exception handling UnhandledAlertException: unexpected alert open:
	 * {Alert text }: This exception will get when your automation URL got alert and
	 * you are performing some action on the page. To handle this type of exception
	 * you should know where alerts are coming in your flow and write is an alert
	 * present method to check for alert and handle them
	 */
	static void UnHandledAlertException() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		try {
		driver.findElement(By.xpath("//*[@id='basicelements']")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(@id,'javascriptAlert')]")).click();
		WebElement Alert = driver.findElement(By.xpath("//button[contains(@id,'javascriptAlert')]"));// org.openqa.selenium.UnhandledAlertException:
		// System.out.println("Click On:-"+Alert.getText()); //here Alert need to be
		// handle before accepting
		Alert alert = driver.switchTo().alert();
		System.out.println("Click On:-" + alert.getText());
		alert.accept();
		}
		finally
		{
			System.out.println("Browser is closed");
			driver.close();
		}
	
	}

	
	
	
	public static void main(String[] args) throws InterruptedException {     //check one exception at a time to see proper result
		
		//illegalStateException();
        // noSuchWindowException();
    	//noSuchSessionException();
    	//noSuchElementException();
        //elementNotInteractableException();
        //ElementClickInterceptedException();
       //NoAlertPresentException();
		UnHandledAlertException();
	}

}
