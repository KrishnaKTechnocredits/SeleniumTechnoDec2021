/*Assignment - 1: 14th Feb’2022

1. Simple Alert
    1. Navigate to automation by Krishna
    2. Click on the Basic Elements tab
    3. Click on the “Alert” tab under “DIFFERENT EXAMPLES OF ALERTS”
    4. Verify Alert has “You must be TechnoCredits student!!” Text as a message.
*/
package shivangi.Assignment1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1_SimpleAlert {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.id("javascriptAlert")).click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		if(alertMsg.equals("You must be TechnoCredits student!!")) {
			System.out.println("Alert says that: " + alertMsg);
		}else {
			System.out.println("message does not exist");
		}
		alert.accept();
		driver.quit();
		System.out.println("Browser Closed");
	}
}
