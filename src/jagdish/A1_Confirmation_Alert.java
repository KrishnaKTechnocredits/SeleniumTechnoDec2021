package jagdish;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A1_Confirmation_Alert {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("http://automationbykrishna.com/");
		System.out.println("Browser launched");
		driver.findElement(By.id("basicelements")).click();
		driver.findElement(By.id("javascriptConfirmBox")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(5000);
		String aleartPopup = driver.switchTo().alert().getText();
		if (aleartPopup.equals("Are you are doing your homework regularly, Press Okay else Cancel!!")) {
			driver.switchTo().alert().accept();
			System.out.println("You pressed OK");
		} else {
			System.out.println("You pressed Cancel");
			driver.switchTo().alert().dismiss();
		}
	}
}