package rohini;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*1. Simple Alert
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
        “Hello harsh! How are you today?*/

public class Rohini_Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		
		driver.findElement(By.linkText("Basic Elements")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		Thread.sleep(2000);
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		Thread.sleep(2000);
		Alert alert1=driver.switchTo().alert();
		alert1.accept();
		System.out.println(driver.findElement(By.xpath("//*[@id='pgraphdemo']")).getText());
		
		Thread.sleep(2000);
		
       driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
       Thread.sleep(2000);
	   Alert alert2=driver.switchTo().alert();
	   alert2.sendKeys("Rohini");
	   Thread.sleep(2000);
	   alert2.accept();
	   System.out.println(driver.findElement(By.xpath("//*[@id='pgraphdemo']")).getText());
	  
		
		
	}

}
