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

package pallavi;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A1_AlertsHandling {

	static void checkMessage(String actualMessage, String expectedMessage, String action) {
		if (expectedMessage.equals(actualMessage))
			System.out.println("Message is correct on " + action);
		else
			System.out.println("Something went wrong for " + action);

	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		Thread.sleep(3000);

		// Simple Alert
		System.out.println("----------Checking Simple Alert----------");
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("javascriptAlert")).click();
		Alert simpleAlert = driver.switchTo().alert();
		Thread.sleep(1000);
		String expectedMessage = "You must be TechnoCredits student!!";
		String actualMessage = simpleAlert.getText();
		checkMessage(actualMessage, expectedMessage, "accept");
		simpleAlert.accept();

		// Java Script Confirmation Alert
		System.out.println("----------Checking confirm Alert----------");
		WebElement btnAlert = driver.findElement(By.xpath("//*[@id='javascriptConfirmBox']"));
		btnAlert.click();
		Alert confirmAlert1 = driver.switchTo().alert();
		Thread.sleep(1000);
		expectedMessage = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		actualMessage = confirmAlert1.getText();
		checkMessage(actualMessage, expectedMessage, "alert widow");
		confirmAlert1.accept();
		Thread.sleep(1000);
		WebElement message = driver.findElement(By.xpath("//*[@id='pgraphdemo']"));
		expectedMessage = "You pressed OK!";
		checkMessage(message.getText(), expectedMessage, "accept");

		btnAlert.click();
		Thread.sleep(1000);
		Alert confirmAlert2 = driver.switchTo().alert();
		confirmAlert2.dismiss();
		Thread.sleep(1000);
		expectedMessage = "You pressed Cancel!";
		checkMessage(message.getText(), expectedMessage, "dismiss");

		// JavaScript Prompt
		System.out.println("----------Checking prompt alert----------");
		btnAlert = driver.findElement(By.id("javascriptPromp"));
		btnAlert.click();
		Alert promptAlert1 = driver.switchTo().alert();
		promptAlert1.sendKeys("Pallavi");
		Thread.sleep(1000);
		promptAlert1.accept();
		expectedMessage = "Hello Pallavi! How are you today?";
		actualMessage = message.getText();
		checkMessage(actualMessage, expectedMessage, "accept");
		Thread.sleep(1000);

		btnAlert.click();
		Alert promptAlert2 = driver.switchTo().alert();
		promptAlert2.sendKeys("Pallavi");
		Thread.sleep(1000);
		promptAlert2.dismiss();
		Thread.sleep(1000);
		expectedMessage = "User cancelled the prompt.";
		actualMessage = message.getText();
		checkMessage(actualMessage, expectedMessage, "dismiss");
		driver.close();

	}

}
