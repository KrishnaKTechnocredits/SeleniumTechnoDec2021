package sandip.Assignment_02;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert_not_present {

	public static void main(String[] args) throws InterruptedException {
		System.getProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		System.out.println("URL Opened");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Basic Elements")).click();
		System.out.println("Basic Element clicked");

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		driver.findElement(By.xpath("//button[@id='javascriptAlert']"));
		System.out.println("Alert has been clicked");
		Alert alert = driver.switchTo().alert();
		System.out.println("Switched to alert");
		alert.accept();
		alert.getText();
	}
}
