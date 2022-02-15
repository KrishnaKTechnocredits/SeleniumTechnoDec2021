package sagarShrikhande;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A1_P3_Prompt {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"I:\\Learning\\Eclipse\\Selenium\\SeleniumTechnoDec2021\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//a[text() ='Basic Elements']")).click();
		System.out.println("Clicked on Basic Elements link");
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.id("javascriptPromp")).click();
		driver.switchTo().alert().sendKeys("Sagar");
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.id("pgraphdemo")).getText());
		driver.quit();
	}

}

/*
 * 3. JavaScript Prompt 1. Navigate to automation by Krishna 2. Click on the
 * Basic Elements tab 3. Click on the “Java Script prompt” tab under “DIFFERENT
 * EXAMPLES OF ALERTS” 4. Set text “Your Name” and verify that your name should
 * get displayed on UI in the below format “Hello harsh! How are you today?
 */