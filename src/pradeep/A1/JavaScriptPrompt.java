package pradeep.A1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptPrompt {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// 1. Navigate to automation by Krishna
		driver.get("http://automationbykrishna.com/");
		// 2. Click on the Basic Elements tab
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"javascriptPromp\"]")).click();

		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Pradeep");
		alert.accept();
		System.out.println(driver.findElement(By.id("pgraphdemo")).getText());
	}
}
