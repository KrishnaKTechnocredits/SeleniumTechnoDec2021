package swati.Swati_Exception_Assign2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NoSuchSession {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("http://automationbykrishna.com/");
		System.out.println("Browser launched");
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(3000);
		driver.close();
		driver.findElement(By.xpath("//button[contains(@id,'javascriptAlert')]")).click();
		driver.close();

	}

}
