package vrushali;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A2_UnHandledAlertException {
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
		driver.findElement(By.xpath("//header[text()=' Different Examples of Alerts ']")).click(); // This line will generate UnHandledAlertException  
		Alert alert = driver.switchTo().alert();
		System.out.println("Switch to alert");
		alert.accept();
	}
}
