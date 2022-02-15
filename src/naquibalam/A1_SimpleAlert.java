package naquibalam;


import java.awt.Point;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class A1_SimpleAlert {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("http://automationbykrishna.com/");
		System.out.println("Browser launched");
		Thread.sleep(5000);
		
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		
		driver.findElement(By.id("javascriptAlert")).click();;
		Thread.sleep(2000);
		
		String verifyText = driver.switchTo().alert().getText();
		if (verifyText.equals("You must be TechnoCredits student!!")) {
			System.out.println("TC Passed");
			driver.switchTo().alert().accept();
		} else {
			System.out.println("TC Failed");
		}
		driver.close();
		System.out.println("Browser Closed");
	}
}
