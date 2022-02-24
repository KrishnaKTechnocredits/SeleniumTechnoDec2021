/*Assignment - 1: 14th Feb 2022  
•	Java Script Confirmation Alert
1.	Navigate to automation by Krishna
2.	Click on the Basic Elements tab
3.	Click on the "JavaScriptript Confirmation” tab under “DIFFERENT EXAMPLES OF ALERTS”
4.	Verify Alert has “Are you are doing your homework regularly, Press Okay else Cancel!!” Text as a message.
5.	Press “OK” or “Cancel” and based on that verify the appropriate message on UI.
	- For OK button -> “You pressed OK!”
	- For the cancel button -> “You pressed Cancel!”

*/

package vaibhav.Assignment_1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import vaibhav.base.PredefinedActions;

public class JavaScriptConfirmationAlert {

	public static void main(String[] args) throws InterruptedException {
		String expectedAlertTextMessage = "Are you are doing your homework regularly, Press Okay else Cancel!!";

		System.out.println("1. Navigate to automation by Krishna");
		WebDriver driver = PredefinedActions.launchBrowser();
		System.out.println("PASS");
		System.out.println();

		System.out.println("2. Click on the Basic Elements tab");
		driver.findElement(By.id("basicelements")).click();
		System.out.println("PASS");
		System.out.println();
		Thread.sleep(3000);

		System.out.println(
				"3. Click on the \"JavaScriptript Confirmation\" tab under \"DIFFERENT EXAMPLES OF ALERTS\"");
		System.out.println("Scroll with 250 pixcel");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		WebElement javaScriptConfirmationbutton = driver.findElement(By.xpath("//button[@class='btn btn-warning']"));
		javaScriptConfirmationbutton.click();
		System.out.println("PASS");
		System.out.println();

		System.out.println(
				"4. Verify Alert has “Are you are doing your homework regularly, Press Okay else Cancel!!” Text as a message.");
		
		Alert alert1 = driver.switchTo().alert();
		String alertTextMessgae = alert1.getText();
		Thread.sleep(4000);
		if (expectedAlertTextMessage.equals(alertTextMessgae)) {
			System.out.println("Alert message is correct and verified with the expected one");
			System.out.println("PASS");
		} else {
			System.out.println("Alert message is differt than the expected one");
			System.out.println("Expected alert message	: " + expectedAlertTextMessage);
			System.out.println("Actual alert message	: " + alertTextMessgae);
			System.out.println("FAIL");
		}
		System.out.println();

		System.out.println("5. Press “OK” or “Cancel” and based on that verify the appropriate message on UI.");
		String expectedOKMessage = "You pressed OK!";
		String expectedCancleMessage = "You pressed Cancel!";
		alert1.accept();
		String actualOKMessage = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();

		if (expectedOKMessage.equals(actualOKMessage)) {
			System.out.println("OK message is correct and verified with the expected one");
			System.out.println("PASS");
		} else {
			System.out.println("OK message is differt than the expected one");
			System.out.println("Expected OK message	: " + expectedOKMessage);
			System.out.println("Actual OK message	: " + actualOKMessage);
			System.out.println("FAIL");
		}
		System.out.println();
		
		//Thread.sleep(2000);
		javaScriptConfirmationbutton.click();
		Alert alert2 = driver.switchTo().alert();
		alert2.dismiss();
		//Thread.sleep(2000);
		String actualCancleMessage = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();

		if (expectedCancleMessage.equals(actualCancleMessage)) {
			System.out.println("Cancle message is correct and verified with the expected one");
			System.out.println("PASS");
		} else {
			System.out.println("Cancle message is differt than the expected one");
			System.out.println("Expected OK message	: " + expectedCancleMessage);
			System.out.println("Actual OK message	: " + actualCancleMessage);
			System.out.println("FAIL");
		}
		System.out.println();
		
		driver.quit();
		System.out.println("Browser closed");
	}
}