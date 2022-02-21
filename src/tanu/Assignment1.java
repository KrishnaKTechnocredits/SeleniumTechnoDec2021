package tanu;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class Assignment1 {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * 1. Simple Alert 1. Navigate to automation by Krishna 2. Click on the Basic
		 * Elements tab 3. Click on the “Alert” tab under “DIFFERENT EXAMPLES OF ALERTS”
		 * 4. Verify Alert has “You must be TechnoCredits student!!” Text as a message.
		 */

		System.setProperty("webdriver.chrome.driver", "C:\\java-selenium\\Eclipse\\SeleniumBasics\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		System.out.println("Browser Launched Succesfully");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='basicelements']")).click();
		WebElement basicelements = (driver.findElement(By.xpath("//*[@id='basicelements']")));
		System.out.println("Click On:-" + basicelements.getText());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(@id,'javascriptAlert')]")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		System.out.println("Click On:-" + alert.getText());
		alert.accept();

		/*
		 * 2. Java Script Confirmation Alert 1. Navigate to automation by Krishna 2.
		 * Click on the Basic Elements tab 3. Click on the "JavaScriptript Confirmation”
		 * tab under “DIFFERENT EXAMPLES OF ALERTS” 4. Verify Alert has “Are you are
		 * doing your homework regularly, Press Okay else Cancel!!” Text as a message.
		 * 1. Press “OK” or “Cancel” and based on that verify the appropriate message on
		 * UI. 1. For OK button -> “You pressed OK!” 2. For the cancel button -> “You
		 * pressed Cancel!”
		 */

		driver.get("http://automationbykrishna.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='basicelements']")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='basicelements']")).getText());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='javascriptConfirmBox']")).click();
		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println("Click On:-" + alert1.getText());
		alert1.accept();
		String str = driver.findElement(By.xpath("//*[@id='pgraphdemo']")).getText();
		System.out.println("Message:-" + str);

		/*
		 * 3. JavaScript Prompt 1. Navigate to automation by Krishna 2. Click on the
		 * Basic Elements tab 3. Click on the “Java Script prompt” tab under “DIFFERENT
		 * EXAMPLES OF ALERTS” 4. Set text “Your Name” and verify that your name should
		 * get displayed on UI in the below format “Hello Hey! How are you today?
		 */

		driver.get("http://automationbykrishna.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='basicelements']")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='basicelements']")).getText());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='javascriptPromp']")).click();
		Alert alert2 = driver.switchTo().alert();
		alert2.sendKeys("Hey");
		Thread.sleep(2000);
		System.out.println("Click On:-" + alert2.getText());
		alert2.accept();
		String str1 = driver.findElement(By.xpath("//*[@id='pgraphdemo']")).getText();
		System.out.println("Message:-" + str);
		driver.close();

	}
}