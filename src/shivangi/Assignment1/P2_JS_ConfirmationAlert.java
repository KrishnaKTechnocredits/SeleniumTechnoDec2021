/*2. Java Script Confirmation Alert
    1. Navigate to automation by Krishna
    2. Click on the Basic Elements tab
    3. Click on the "JavaScriptript Confirmation” tab under “DIFFERENT EXAMPLES OF ALERTS”
    4. Verify Alert has “Are you are doing your homework regularly, Press Okay else Cancel!!” Text as a message.
        1. Press “OK” or “Cancel” and based on that verify the appropriate message on UI.
            1. For OK button -> “You pressed OK!”
            2. For the cancel button -> “You pressed Cancel!”
*/
package shivangi.Assignment1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_JS_ConfirmationAlert {
	
	void clickOkButtonAlert() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.partialLinkText("Basic")).click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 250)", "");
		Thread.sleep(2000);
		driver.findElement(By.id("javascriptConfirmBox")).click();
		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		if(alertMsg.equals("Are you are doing your homework regularly, Press Okay else Cancel!!")) {
			System.out.println("Alert msg is : " + alertMsg);
			alert.accept();
			WebElement ele = driver.findElement(By.id("pgraphdemo"));
			if(ele.getText().equals("You pressed OK!"))
				System.out.println(ele.getText());
		}
		driver.quit();
	}
	
	void clickCancelButtonAlert() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.partialLinkText("Basic")).click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 250)", "");
		Thread.sleep(2000);
		driver.findElement(By.id("javascriptConfirmBox")).click();
		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		if(alertMsg.equals("Are you are doing your homework regularly, Press Okay else Cancel!!")) {
			System.out.println("Alert msg is : " + alertMsg);
			alert.dismiss();
			WebElement ele = driver.findElement(By.id("pgraphdemo"));
			if(ele.getText().equals("You pressed Cancel!"))
				System.out.println(ele.getText());
		}
		driver.quit();
	}
	public static void main(String[] args) throws InterruptedException {	
		P2_JS_ConfirmationAlert p2 = new P2_JS_ConfirmationAlert();
		p2.clickOkButtonAlert();
		p2.clickCancelButtonAlert();		
	}	
}
