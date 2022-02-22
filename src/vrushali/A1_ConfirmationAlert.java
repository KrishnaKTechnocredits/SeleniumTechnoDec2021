/*2. Java Script Confirmation Alert
    1. Navigate to automation by Krishna
    2. Click on the Basic Elements tab
    3. Click on the "JavaScriptript Confirmation” tab under “DIFFERENT EXAMPLES OF ALERTS”
    4. Verify Alert has “Are you are doing your homework regularly, Press Okay else Cancel!!” Text as a message.
        1. Press “OK” or “Cancel” and based on that verify the appropriate message on UI.
            1. For OK button -> “You pressed OK!”
            2. For the cancel button -> “You pressed Cancel!”*/

package vrushali;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A1_ConfirmationAlert {

	void alertAccept() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-warning']")).click();
		System.out.println("JavaScriptript Confirmation is opened");	
		String actualText = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		Alert alert = driver.switchTo().alert();
		String expectedText = alert.getText();

		if(actualText.equals(expectedText)) {
			System.out.println("Text on Alert match with - " + actualText);
			alert.accept();			
			driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText().equals("You pressed OK!");
			System.out.println("TC pass - You passed OK button!!");
		}
		else {
			System.out.println("Test case failed");
		}
		driver.close();
		System.out.println("Browser closed");
	}

	void alertDismiss() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Chrome browser launched");
		driver.manage().window().maximize();
		System.out.println("Window maximize");
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("basicelements")).click();
		System.out.println("site loaded and basic element tab is opened");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-warning']")).click();
		System.out.println("Clicked on javascript confirmation and alert get open");

		Alert alert = driver.switchTo().alert();

		String actualText = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		String expectedText = alert.getText();
		if(expectedText.equals(actualText)) {
			System.out.println("Switched to alert popup");

			alert.dismiss();
			if(driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText().equals("You pressed Cancel!"))
				System.out.println("TC pass - Alert dismiss and text match");


			else
				System.out.println("TC failed - Text after dismiss the alert did not match with the expected text");
		}

		else {
			System.out.println("Test case Failed - Failed to switch to alert");
		}


		driver.close();
		System.out.println("Browser closed");
	}

	public static void main(String[] args) throws InterruptedException {

		A1_ConfirmationAlert confirmAlert = new A1_ConfirmationAlert();
		confirmAlert.alertAccept();
		confirmAlert.alertDismiss();

	}
}
