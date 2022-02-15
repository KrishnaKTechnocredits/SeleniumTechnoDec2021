package technocredits.exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NoSuchSessionException {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("https://demo.seleniumeasy.com/window-popup-modal-demo.html");
		System.out.println("Browser launched");
		driver.findElement(By.xpath("//a[@class='btn btn-primary followeasy'][text()='  Follow On Twitter ']")).click();
		Thread.sleep(3000);
		driver.close();
		driver.quit();
		System.out.println("Browser Closed");
	}
}
