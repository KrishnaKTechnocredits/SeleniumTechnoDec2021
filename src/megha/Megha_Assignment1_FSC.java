package megha;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Megha_Assignment1_FSC {

	public static void clickOk() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\QA\\Automation\\SeleniumTechnoDec2021\\drivers\\chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Browser is maximised");
		driver.get("http://automationbykrishna.com/");
		System.out.println("Browser launched");
		WebElement element = driver.findElement(By.id("basicelements")); 
		if (element.isEnabled())
			element.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.id("javascriptConfirmBox")).click();
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.id("pgraphdemo")).getText());
		driver.quit();
	}
	
	public static void clickCancel() throws InterruptedException{
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
		driver.findElement(By.id("javascriptConfirmBox")).click();
		driver.switchTo().alert().dismiss();
		System.out.println(driver.findElement(By.id("pgraphdemo")).getText());
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		clickOk();
		clickCancel();
	}
}
