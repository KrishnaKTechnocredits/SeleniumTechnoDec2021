package naquibalam;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A1_JavaScriptPrompt {

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
		
		driver.findElement(By.id("javascriptPromp")).click();;
		Thread.sleep(2000);
		
		driver.switchTo().alert().sendKeys("Naquib");
		driver.switchTo().alert().accept();
		
		if (driver.findElement(By.xpath("//*[text()='Hello Naquib! How are you today?']")).isDisplayed()) {
			System.out.println("TC Passed - 'Hello Naquib! How are you today?' is displayed");
		} else {
			System.out.println("TC Failed");
		}
				
		driver.close();
		System.out.println("Browser Closed");
	}

}
