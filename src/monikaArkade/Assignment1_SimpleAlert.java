package monikaArkade;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1_SimpleAlert {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");

		driver.findElement(By.id("basicelements")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(1000);
		driver.findElement(By.id("javascriptAlert")).click();
		Thread.sleep(1000);
		Alert al = driver.switchTo().alert();
		if (al.getText().equals("You must be TechnoCredits student!!"))
			System.out.println("Alert Have text message as " + "\"You must be TechnoCredits student!!\"");
		else
			System.out.println(false);
		al.accept();
		driver.quit();
		System.out.println("Browser Closed");

	}
}
