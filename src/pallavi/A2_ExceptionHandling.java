/*Assignment - 2: 15th Feb'2022

To perform below exception when it occurs

NoSuchWindowException 
NoSuchSessionException 
ElementNotInteractableException  
IllegalStateException 
AlertNotPresent 
ElementClickInterceptedException
NoSuchElementException
UnHandledAlertException
*/

package pallavi;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A2_ExceptionHandling {
	public static void main(String[] args) throws InterruptedException {

		// IllegalStateException ----// As driver path is wrong
		// System.setProperty("webdriver.chrome.driver","/drivers/chromedriver_98Version.exe");
		//
	
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(2000);

		/*
		 * //NoSuchSessionException ----//As quit has already closed all the windows opened in session , its giving exception
		 
		 * driver.findElement(By.id("javascriptMultiWindow")).click(); 
		 * driver.quit();
		 * driver.close(); 
		 * 
		 * 
		 * 
		 * //NoSuchWindowException ----//As the main window opened during session is closed so there is no main window available to close
		 *
		 * driver.findElement(By.id("javascriptMultiWindow")).click(); driver.close();
		 * driver.close(); 
		 * 
		
		 * //NoSuchElementException ----//As the xpath given below is wrong
		 * driver.findElement(By.id("javascript_MultiWindow")).click();
		 * 
		 * //ElementNotInteractableException----//Trying to input text in disabled field
		 * driver.findElement(By.id("disabledInput")).sendKeys("abc"); 
		 * 
		 * 
		 * //NoAlertPresentException ----//Trying to get text on alert after closing
		 * the alert
		 * driver.findElement(By.id("javascriptAlert")).click(); Alert simpleAlert =
		 * driver.switchTo().alert(); Thread.sleep(1000); simpleAlert.accept(); String
		 * message = simpleAlert.getText(); 
		 */
		
		// UnHandledAlertException ----// Trying to close window without closing Alert
		driver.findElement(By.id("javascriptAlert")).click();
		Alert simpleAlert = driver.switchTo().alert();
		Thread.sleep(1000);
		driver.close(); 
	}
}
