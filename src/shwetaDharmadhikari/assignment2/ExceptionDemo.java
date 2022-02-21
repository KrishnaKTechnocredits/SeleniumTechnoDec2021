/*Assignment - 2: 15th Feb'2022

To perform below exception when it occurs

NoSuchWindowException 
NoSuchSessionException 
ElementNotInteractableException  
ElementClickInterceptedException
IllegalStateException 
AlertNotPresentException 
NoSuchElementException 
UnHandledAlertException 
InvalidArgumentException
 */
package shwetaDharmadhikari.assignment2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import base.*;
public class ExceptionDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");// IllegalStateException
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.get("automationbykrishna.com/");// InvalidArgumentException-Passing
		// URL without http/https.
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("basicelements")).click();
		// Thread.sleep(2000);
		// driver.findElement(By.xpath("//button[@id='javascriptAlert']"));//NoSuchElementException

		// Alert alert = driver.switchTo().alert();// NoAlertPresentException

		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//*[@id='javascriptAlert']"));
		je.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(2000);
		element.click();// ElementClickInterceptedException
		Alert alert = driver.switchTo().alert();
		String actualAlertMsg = alert.getText();// UnHandledAlertException
		alert.accept();
		driver.close();
		// element.click();//NoSuchSessionException-After closing driver when we perform some action
	}
}
