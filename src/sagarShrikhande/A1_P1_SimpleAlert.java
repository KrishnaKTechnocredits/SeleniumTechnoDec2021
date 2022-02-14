package sagarShrikhande;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A1_P1_SimpleAlert {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"I:\\Learning\\Eclipse\\Selenium\\SeleniumTechnoDec2021\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("http://automationbykrishna.com/");
		System.out.println("Browser launched");
		Thread.sleep(1500);
		WebElement basicElements = driver.findElement(By.xpath("//a[text() ='Basic Elements']"));
		if (basicElements.isEnabled())
			basicElements.click();
		System.out.println("Clicked on Basic Elements link");
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.id("javascriptAlert")).click();
		System.out.println("Clicked on Alert Button");
		String str = driver.switchTo().alert().getText();
		if (str.equals("You must be TechnoCredits student!!"))
			System.out.println("Alert pop up has correct message");
		else
			System.out.println("Alert pop up has incorrect message");
		driver.quit();
	}
}

/*
 * 1. Simple Alert 1. Navigate to automation by Krishna 2. Click on the Basic
 * Elements tab 3. Click on the “Alert” tab under “DIFFERENT EXAMPLES OF ALERTS”
 * 4. Verify Alert has “You must be TechnoCredits student!!” Text as a message.
 */