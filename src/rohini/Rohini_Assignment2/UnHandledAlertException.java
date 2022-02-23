package rohini.Rohini_Assignment2;

//import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UnHandledAlertException {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("http://automationbykrishna.com/");
		
		
		
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='Alert']")).click();
		//uncomment Alert to generate exception
		//Alert alert=driver.switchTo().alert();
		//alert.accept();

	}

}
