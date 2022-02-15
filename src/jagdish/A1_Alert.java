package jagdish;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A1_Alert {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("http://automationbykrishna.com/");
		System.out.println("Browser launched");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("javascriptAlert")).click();
		String verifyAlertPopup = driver.switchTo().alert().getText();
		if (verifyAlertPopup.equals("You must be TechnoCredits student!!")) {
			System.out.println("You have Accepted the Alert");
			driver.switchTo().alert().accept();
		} else {
			System.out.println("You have Dismiss the Alert");
			driver.switchTo().alert().dismiss();
		}
		driver.close();
		System.out.println("Browser Closed");
	}
}