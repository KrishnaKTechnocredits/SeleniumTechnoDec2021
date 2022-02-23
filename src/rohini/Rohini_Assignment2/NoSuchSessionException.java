package rohini.Rohini_Assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NoSuchSessionException {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.seleniumeasy.com/window-popup-modal-demo.html");
		driver.findElement(By.xpath("//a[text()='  Follow On Twitter ']")).click();
		driver.quit();
		driver.close();

	}

}
