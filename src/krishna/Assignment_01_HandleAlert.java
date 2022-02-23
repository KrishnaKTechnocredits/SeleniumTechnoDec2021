package krishna;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_01_HandleAlert {
	static void checkMessage(String aMessage, String exMessage, String perform) {
		if (exMessage.equals(aMessage))
			System.out.println("Message --> " + perform);
		else
			System.out.println("Incorrect Message --> " + perform);

	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		Thread.sleep(4000);

		System.out.println("------------>Simple Alert<----------");
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("javascriptAlert")).click();
		Alert simpleAlert = driver.switchTo().alert();
		Thread.sleep(3000);
		String exMessage = "You must be TechnoCredits student!!";
		String aMessage = simpleAlert.getText();
		checkMessage(aMessage, exMessage, "accept");
		simpleAlert.accept();

		System.out.println("---------->Confirming Alert<----------");
		WebElement btnAlert = driver.findElement(By.xpath("//*[@id='javascriptConfirmBox']"));
		btnAlert.click();
		Alert confirmAlert1 = driver.switchTo().alert();
		Thread.sleep(4000);
		exMessage = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		aMessage = confirmAlert1.getText();
		checkMessage(aMessage, exMessage, "alert window");
		confirmAlert1.accept();
		Thread.sleep(2000);
		WebElement message = driver.findElement(By.xpath("//*[@id='pgraphdemo']"));
		exMessage = "You pressed OK!";
		checkMessage(message.getText(), exMessage, "accept");

		btnAlert.click();
		Thread.sleep(3000);
		Alert confirmAlert2 = driver.switchTo().alert();
		confirmAlert2.dismiss();
		Thread.sleep(2000);
		exMessage = "You pressed Cancel!";
		checkMessage(message.getText(), exMessage, "dismiss");

		System.out.println("------------>Prompt alert<-------------");
		btnAlert = driver.findElement(By.id("javascriptPromp"));
		btnAlert.click();
		Alert promptAlert1 = driver.switchTo().alert();
		promptAlert1.sendKeys("Krishna");
		Thread.sleep(2000);
		promptAlert1.accept();
		exMessage = "Hello Krishna! How are you today?";
		aMessage = message.getText();
		checkMessage(aMessage, exMessage, "accept");
		Thread.sleep(2000);

		btnAlert.click();
		Alert promptAlert2 = driver.switchTo().alert();
		promptAlert2.sendKeys("Krishna");
		Thread.sleep(3000);
		promptAlert2.dismiss();
		Thread.sleep(2000);
		exMessage = "User cancelled the prompt.";
		aMessage = message.getText();
		checkMessage(aMessage, exMessage, "dismiss");
		driver.close();

	}
}
