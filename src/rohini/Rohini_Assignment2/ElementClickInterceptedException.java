package rohini.Rohini_Assignment2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementClickInterceptedException {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("http://automationbykrishna.com/");
		
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		driver.findElement(By.xpath("//button[text()='Alert']")).click();
		
		Alert alert=driver.switchTo().alert();
		alert.accept();

	}

}
