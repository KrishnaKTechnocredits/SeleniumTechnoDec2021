package yogeshNagar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/* Assignment - 1: 14th Feb’2022
1. Simple Alert
    1. Navigate to automation by Krishna
    2. Click on the Basic Elements tab
    3. Click on the “Alert” tab under “DIFFERENT EXAMPLES OF ALERTS”
    4. Verify Alert has “You must be TechnoCredits student!!” Text as a message.
*/


public class A1_BasicAlerts {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("javascriptAlert")).click();
		Thread.sleep(1000);
		Alert al = driver.switchTo().alert();
		if(al.getText().equals("You must be TechnoCredits student!!"))
			System.out.println("Alert Have text message as "+ "\"You must be TechnoCredits student!!\"");
		else
			System.out.println(false);
		al.accept();
		driver.quit();
		System.out.println("Browser Closed");
		
	}

}
