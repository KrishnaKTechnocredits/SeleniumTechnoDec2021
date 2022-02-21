package monikaArkade;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1_JavascriptPrompt {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");

		driver.findElement(By.id("basicelements")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(1000);

		driver.findElement(By.id("javascriptPromp")).click();
		Thread.sleep(1000);
		Alert al = driver.switchTo().alert();
		al.sendKeys("Monika");
		Thread.sleep(1000);
		al.accept();
		Thread.sleep(1000);
		WebElement ele = driver.findElement(By.id("pgraphdemo"));
		if (ele.getText().equals("Hello Monika! How are you today?"))
			System.out.println("Alert Have text message as " + "\"Hello Monika! How are you today?\"");
		driver.quit();
		System.out.println("Browser Closed");

	}
}
