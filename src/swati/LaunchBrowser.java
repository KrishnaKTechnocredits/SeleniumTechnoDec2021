package swati;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("http://automationbykrishna.com/");
		System.out.println("Browser launched");
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='col-lg-6']//div[4]//button[@type='submit']")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();

		// Alert

		driver.findElement(By.xpath("//button[contains(@id,'javascriptAlert')]")).click();
		Thread.sleep(3000);
		alert = driver.switchTo().alert();
		String str = alert.getText();
		System.out.println(str);
		alert.accept();

		// Javascript Confirmation Alert on Ok
		driver.findElement(By.xpath("//button[contains(@id,'javascriptConfirmBox')]")).click();
		alert = driver.switchTo().alert();
		alert.accept();
		str = driver.findElement(By.xpath("//p[contains(text(),\"You\")]")).getText();
		System.out.println(str);

		// Javascript Confirmation on Cancel
		driver.findElement(By.xpath("//button[contains(@id,'javascriptConfirmBox')]")).click();
		alert = driver.switchTo().alert();
		alert.dismiss();
		str = driver.findElement(By.xpath("//p[contains(text(),\"You\")]")).getText();
		System.out.println(str);

		// Javascript Prompt on Cancel
		driver.findElement(By.xpath("//button[contains(@id,'javascriptPromp')]")).click();
		alert = driver.switchTo().alert();
		alert.sendKeys("Swati");
		alert.accept();
		str = driver.findElement(By.xpath("//p[contains(text(),\"Hello\")]")).getText();
		System.out.println(str);
		driver.close();
		System.out.println("Browser Closed");
	}
}
