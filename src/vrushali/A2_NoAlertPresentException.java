package vrushali;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A2_NoAlertPresentException {
	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("http://automationbykrishna.com/");
		System.out.println("Browser launched");
		driver.findElement(By.id("basicelements")).click(); 
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Switch to alert");
		alert.accept();
		System.out.println("Alert accepted");
		alert.getText(); // it will generate org.openqa.selenium.NoAlertPresentException
		System.out.println("trying to get alert text post alert is accepted");
		driver.close();
		System.out.println("Browser Closed");

	}
}
