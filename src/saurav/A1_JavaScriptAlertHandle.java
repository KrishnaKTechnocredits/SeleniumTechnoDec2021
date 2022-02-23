package saurav;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A1_JavaScriptAlertHandle {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");

		driver.findElement(By.partialLinkText("Basic ")).click();
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		driver.findElement(By.xpath("//button[@class='btn btn-warning']")).click();
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();
		String message = driver.switchTo().alert().getText();
		alert.dismiss();
		System.out.println("Message = "+driver.findElement(By.xpath("//p[text()='You pressed Cancel!']")).getText());
		driver.quit();
	}
}
