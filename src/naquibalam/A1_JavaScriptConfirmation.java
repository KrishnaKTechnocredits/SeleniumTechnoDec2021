package naquibalam;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A1_JavaScriptConfirmation {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("http://automationbykrishna.com/");
		System.out.println("Browser launched");
		Thread.sleep(5000);
		
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		
		driver.findElement(By.id("javascriptConfirmBox")).click();;
		Thread.sleep(2000);
		
		String verifyText = driver.switchTo().alert().getText();
		if (verifyText.equals("Are you are doing your homework regularly, Press Okay else Cancel!!")) {
			driver.switchTo().alert().accept();
			if (driver.findElement(By.xpath("//*[text()='You pressed OK!']")).isDisplayed()) {
				System.out.println("TC Passed - 'You pressed OK!' is displayed");
			} else {
				System.out.println("TC Failed");
			}
		} else {
			System.out.println("TC Failed");
		}
		Thread.sleep(2000);
		
		driver.findElement(By.id("javascriptConfirmBox")).click();;
		Thread.sleep(2000);
		
		verifyText = driver.switchTo().alert().getText();
		if (verifyText.equals("Are you are doing your homework regularly, Press Okay else Cancel!!")) {
			driver.switchTo().alert().dismiss();;
			if (driver.findElement(By.xpath("//*[text()='You pressed Cancel!']")).isDisplayed()) {
				System.out.println("TC Passed - 'You pressed Cancel!' is displayed");;
			} else {
				System.out.println("TC Failed");
			}
		} else {
			System.out.println("TC Failed");
		}
		
		
		driver.close();
		System.out.println("Browser Closed");
	}
}
