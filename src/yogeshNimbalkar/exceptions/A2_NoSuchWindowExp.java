package yogeshNimbalkar.exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A2_NoSuchWindowExp {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Browser maximized");
		
		driver.get("https://demo.seleniumeasy.com/window-popup-modal-demo.html");
		System.out.println("Browser Launched");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='btn btn-primary followeasy'][text()='  Follow On Twitter ']")).click();		
		System.out.println("Another window opened");
		
		Thread.sleep(5000);
		driver.close();
		System.out.println("Browser closed");
		
		driver.close();
	}
}
