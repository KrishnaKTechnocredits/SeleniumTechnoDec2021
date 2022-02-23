package naquibalam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class A3_Program1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("https://twitter.com/i/flow/signup");
		System.out.println("Browser launched");
		Thread.sleep(2000);
		try {
			Select month = new Select(driver.findElement(By.id("SELECTOR_1")));
			month.selectByIndex(8);
			Thread.sleep(2000);
			Select day = new Select(driver.findElement(By.id("SELECTOR_2")));
			day.selectByValue("3");
			Thread.sleep(2000);
			Select year = new Select(driver.findElement(By.id("SELECTOR_3")));
			year.selectByVisibleText("1991");
			Thread.sleep(2000);
		}finally {
			driver.close();
			System.out.println("Browser Closed");
		}	
	}
}
