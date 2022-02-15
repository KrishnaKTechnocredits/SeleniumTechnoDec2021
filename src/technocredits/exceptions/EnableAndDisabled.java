package technocredits.exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnableAndDisabled {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("file:///D:/TechnoCredits/Batches/Dec21/HTML_Forms/Harsh_Enable_&_Disable.html");
		System.out.println("Browser launched");
//		if (driver.findElement(By.id("myText")).isEnabled())
			driver.findElement(By.id("myText")).sendKeys("Harsh");
//		else {
//			System.out.println("Text Area is not enabled");
//		}
		Thread.sleep(3000);
		driver.quit();
		System.out.println("Browser Closed");
	}
}
