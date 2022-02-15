package yogeshNagar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/* Assignment - 1: 14th Feb’2022
2. Java Script Confirmation Alert
    1. Navigate to automation by Krishna
    2. Click on the Basic Elements tab
    3. Click on the "JavaScriptript Confirmation” tab under “DIFFERENT EXAMPLES OF ALERTS”
    4. Verify Alert has “Are you are doing your homework regularly, Press Okay else Cancel!!” Text as a message.
        1. Press “OK” or “Cancel” and based on that verify the appropriate message on UI.
            1. For OK button -> “You pressed OK!”
            2. For the cancel button -> “You pressed Cancel!”
*/


public class A1_JavaScriptConfirmationAlert {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("javascriptConfirmBox")).click();
		Thread.sleep(1000);
		Alert al = driver.switchTo().alert();
		if(al.getText().equals("Are you are doing your homework regularly, Press Okay else Cancel!!"))
			System.out.println("Alert Have text message as "+ "\"Are you are doing your homework regularly, Press Okay else Cancel!!\"");
		al.accept();
		WebElement ele = driver.findElement(By.xpath("//p[contains(text(),'You pressed OK!')]"));
		if(ele.getText().equals("You pressed OK!"))
			System.out.println("You pressed OK!");
		driver.quit();
		System.out.println("Browser Closed");
		
	}

}
