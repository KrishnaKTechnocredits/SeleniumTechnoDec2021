/*Assignment - 1: 14th Feb 2022  
•	JavaScript Prompt 
1. Navigate to automation by Krishna
2. Click on the Basic Elements tab
3. Click on the “Java Script prompt” tab under “DIFFERENT EXAMPLES OF ALERTS”
4. Set text “Your Name” and verify that your name should get displayed on UI in the below format
“Hello harsh! How are you today?"

*/

package vaibhav.Assignment_1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import vaibhav.base.PredefinedActions;

public class JavaScriptPrompt {
	public static void main(String[] args) throws InterruptedException {
		String name = "Vaibhav";
		String expectedDisplayMessage = "Hello " + name + "! How are you today?";

		System.out.println("1. Navigate to automation by Krishna");
		WebDriver driver = PredefinedActions.launchBrowser();
		System.out.println("PASS");
		System.out.println();

		System.out.println("2. Click on the Basic Elements tab");
		driver.findElement(By.id("basicelements")).click();
		System.out.println("PASS");
		System.out.println();
		Thread.sleep(3000);

		System.out.println("3. Click on the \"Java Script prompt\" tab under \"DIFFERENT EXAMPLES OF ALERTS\"");
		System.out.println("Scroll with 250 pixcel");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		WebElement javaScriptPrompt = driver.findElement(By.xpath("//button[@id='javascriptPromp']"));
		javaScriptPrompt.click();
		System.out.println("PASS");
		System.out.println();

		System.out.println(
				"4. Set text “Your Name” and verify that your name should get displayed on UI in the correct format");
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(name);
		alert.accept();

		String actualDisplayMessage = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();

		if (actualDisplayMessage.equals(expectedDisplayMessage)) {
			System.out.println("Display message is correct and verified with the expected correct format");
			System.out.println("PASS");
		} else {
			System.out.println("Display message is differt than the expected one");
			System.out.println("Expected display message	: " + expectedDisplayMessage);
			System.out.println("Actual display message	: " + actualDisplayMessage);
			System.out.println("FAIL");
		}
		System.out.println();

		driver.quit();
		System.out.println("Browser closed");
	}
}