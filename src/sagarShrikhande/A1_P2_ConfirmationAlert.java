package sagarShrikhande;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A1_P2_ConfirmationAlert {

	void ClickOnOK() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"I:\\Learning\\Eclipse\\Selenium\\SeleniumTechnoDec2021\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//a[text() ='Basic Elements']")).click();
		System.out.println("Clicked on Basic Elements link");
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.id("javascriptConfirmBox")).click();
		System.out.println("Clicked on Javascript Confirmation");
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.id("pgraphdemo")).getText());
		driver.quit();
	}

	void ClickOnCancel() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"I:\\Learning\\Eclipse\\Selenium\\SeleniumTechnoDec2021\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//a[text() ='Basic Elements']")).click();
		System.out.println("Clicked on Basic Elements link");
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.id("javascriptConfirmBox")).click();
		System.out.println("Clicked on Javascript Confirmation");
		driver.switchTo().alert().dismiss();
		System.out.println(driver.findElement(By.id("pgraphdemo")).getText());
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		A1_P2_ConfirmationAlert a1p2 = new A1_P2_ConfirmationAlert();
		a1p2.ClickOnOK();
		a1p2.ClickOnCancel();
	}
}

/*
 * 2. Java Script Confirmation Alert 1. Navigate to automation by Krishna 2.
 * Click on the Basic Elements tab 3. Click on the "JavaScriptript Confirmation”
 * tab under “DIFFERENT EXAMPLES OF ALERTS” 4. Verify Alert has “Are you are
 * doing your homework regularly, Press Okay else Cancel!!” Text as a message.
 * 1. Press “OK” or “Cancel” and based on that verify the appropriate message on
 * UI. 1. For OK button -> “You pressed OK!” 2. For the cancel button -> “You
 * pressed Cancel!”
 */