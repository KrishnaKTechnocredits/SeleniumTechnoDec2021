package megha;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Megha_Assignment1_SimpleAlert {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\QA\\Automation\\SeleniumTechnoDec2021\\drivers\\chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("http://automationbykrishna.com/");
		System.out.println("Browser is launched");
		WebElement element = driver.findElement(By.id("basicelements")); 
		if (element.isEnabled())
			element.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.id("javascriptAlert")).click();
		System.out.println("Clicked on Simple Alert");
		String str = driver.switchTo().alert().getText();
		if (str.equals("You must be TechnoCredits student!!"))
			System.out.println("Pop up message is correct");
		else
			System.out.println("Pop up message is incorrect");
		driver.quit();
	}
}
