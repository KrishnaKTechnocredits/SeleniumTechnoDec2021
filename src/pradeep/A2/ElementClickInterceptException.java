package pradeep.A2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementClickInterceptException {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// If driver.manage().window().maximize(); commented then
		// ElementClickInterceptException occurs
		// when element is not in view port due to small screen and we click on element then this happens
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		// Click on Basic Elements
		driver.findElement(By.xpath("//*[@id=\"basicelements\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"javascriptAlert\"]")).click();
	}
}
