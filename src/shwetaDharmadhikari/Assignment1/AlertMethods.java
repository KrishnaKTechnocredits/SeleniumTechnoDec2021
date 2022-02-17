/*Assignment - 1: 14th Feb’2022

1. Simple Alert
    1. Navigate to automation by Krishna
    2. Click on the Basic Elements tab
    3. Click on the “Alert” tab under “DIFFERENT EXAMPLES OF ALERTS”
    4. Verify Alert has “You must be TechnoCredits student!!” Text as a message.

2. Java Script Confirmation Alert
    1. Navigate to automation by Krishna
    2. Click on the Basic Elements tab
    3. Click on the "JavaScriptript Confirmation” tab under “DIFFERENT EXAMPLES OF ALERTS”
    4. Verify Alert has “Are you are doing your homework regularly, Press Okay else Cancel!!” Text as a message.
        1. Press “OK” or “Cancel” and based on that verify the appropriate message on UI.
            1. For OK button -> “You pressed OK!”
            2. For the cancel button -> “You pressed Cancel!”

3. JavaScript Prompt 
    1. Navigate to automation by Krishna
    2. Click on the Basic Elements tab
    3. Click on the “Java Script prompt” tab under “DIFFERENT EXAMPLES OF ALERTS”
    4. Set text “Your Name” and verify that your name should get displayed on UI in the below format
        “Hello harsh! How are you today?
 */
package shwetaDharmadhikari.Assignment1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import shwetaDharmadhikari.base.PredefinedActions;

public class AlertMethods {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start();

		String expectedAlertMsg = "You must be TechnoCredits student!!";
		String expectedSecondAlertMsg = "Are you are doing your homework regularly, Press Okay else Cancel!!";

		System.out.println("STEP- Click on Basic Elements");
		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(3000);
		System.out.println("Switch to alert");

		// Test Case1 for Alert

		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//*[@id=\"javascriptAlert\"]"));
		je.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(2000);
		System.out.println("Click on alert");
		element.click();
		Alert alert = driver.switchTo().alert(); // TestCase1
		String actualAlertMsg = alert.getText();
		alert.accept();
		if (actualAlertMsg.equals(expectedAlertMsg))
			System.out.println("TestCase #1 Pass for Alert");
		else
			System.out.println("TestCase #1 Fail for Alert");

		// Test Case2 - Java Script Confirmation Alert
		WebElement element1 = driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']"));
		Thread.sleep(2000);
		element1.click();

		driver.switchTo().alert();
		System.out.println("Click on JavaScript Confirmation Alert");
		String actualAlertMsg1 = alert.getText();
		if (actualAlertMsg1.equals(expectedSecondAlertMsg))
			System.out.println("TestCase #2 Pass for Alert- Received Correct Message");
		else
			System.out.println("TestCase #2 Fail for Alert- Received Incorrect Message");
		alert.accept();

		Thread.sleep(3000);
		String str = driver.findElement(By.id("pgraphdemo")).getText();
		if (str.equals("You pressed OK!"))
			System.out.println("TestCase #2 Pass for Alert- You pressed OK!");
		else
			System.out.println("TestCase #2 failed -- need to check OK dialog box");

		element1.click();
		driver.switchTo().alert();
		alert.dismiss();
		if (driver.findElement(By.xpath("//*[@id='pgraphdemo']")).getText().equals("You pressed Cancel!"))
			System.out.println("TestCase #2 Pass for Alert- You pressed Cancel!");
		else
			System.out.println("TestCase #2 failed -- need to check cancle dialog box");

		// Test Case 3 -JavaScript Prompt

		WebElement element2 = driver.findElement(By.xpath("//button[@id='javascriptPromp']"));
		Thread.sleep(2000);
		element2.click();
		driver.switchTo().alert();
		alert.sendKeys("Shweta");
		alert.accept();

		if (driver.findElement(By.id("pgraphdemo")).getText().contains("Shweta"))
			System.out.println("TestCase #3 Pass- User accepted promp and given name is present");
		else
			System.out.println("Need to check");

		element2.click();
		driver.switchTo().alert();
		alert.sendKeys("Shweta");
		alert.dismiss();
		if (driver.findElement(By.id("pgraphdemo")).getText().contains("User cancelled the prompt."))
			System.out.println("TestCase #3 Pass- User cancelled the prompt");
		else
			System.out.println("Need to check");

		driver.close();
	}

}
