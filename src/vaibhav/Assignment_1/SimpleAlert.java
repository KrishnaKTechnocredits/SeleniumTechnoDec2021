/*Assignment - 1: 14th Feb 2022  
•	Simple Alert
1.	Navigate to automation by Krishna
2.	Click on the Basic Elements tab
3.	Click on the “Alert” tab under “DIFFERENT EXAMPLES OF ALERTS”
4.	Verify Alert has “You must be TechnoCredits student!!” Text as a message. 

*/
package vaibhav.Assignment_1;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import vaibhav.base.PredefinedActions;

public class SimpleAlert {

	public static void main(String[] args) throws InterruptedException {

		String expectedAlertMessage = "You must be TechnoCredits student!!";

		System.out.println("1. Navigate to automation by Krishna");
		WebDriver driver = PredefinedActions.launchBrowser();
		System.out.println("PASS");
		System.out.println();

		System.out.println("2. Click on the Basic Elements tab");
		driver.findElement(By.id("basicelements")).click();
		System.out.println("PASS");
		System.out.println();
		Thread.sleep(3000);

		System.out.println("3. Click on the “Alert” tab under “DIFFERENT EXAMPLES OF ALERTS”");
		System.out.println("Scroll with 250 pixcel");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		System.out.println("PASS");
		System.out.println();

		System.out.println("4. Verify Alert has “You must be TechnoCredits student!!” Text as a message.");
		System.out.println("Switch to alert and read the text and accept");
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		alert.accept();

		if (alertMessage.equals(expectedAlertMessage)) {
			System.out.println("Alert message is correct and verified with the expected one");
			System.out.println("PASS");
		} else {
			System.out.println("Alert message is differt than the expected one");
			System.out.println("Expected alert message	: " + expectedAlertMessage);
			System.out.println("Actual alert message	: " + alertMessage);
			System.out.println("FAIL");
		}
		System.out.println();

		driver.quit();
		System.out.println("Browser closed");
	}
}