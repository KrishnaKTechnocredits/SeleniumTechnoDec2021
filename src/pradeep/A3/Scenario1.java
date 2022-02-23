package pradeep.A3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Scenario1 {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.drive", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// For Twitter.com
		driver.get("https://twitter.com/i/flow/signup");
		//If below line is commented then this program will not work
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@name = 'name']")).sendKeys("Pradeep Singh Jhala");
		driver.findElement(By.xpath("//input[@name = 'phone_number']")).sendKeys("8885552221");
		
		WebElement dayElement = driver.findElement(By.xpath("//select[@id='SELECTOR_2']"));
		Select daySelect = new Select(dayElement);
		daySelect.selectByIndex(9);
		
		WebElement monthElement = driver.findElement(By.xpath("//select[@id='SELECTOR_1']"));
		Select monthSelect = new Select(monthElement);
		monthSelect.selectByValue("5");
		
		WebElement yearElement = driver.findElement(By.xpath("//select[@id='SELECTOR_3']"));
		Select yearSelect = new Select(yearElement);
		yearSelect.selectByVisibleText("1987");		
		
		//www.facebook.com is also working fine!
		/*driver.get("https://www.facebook.com/");
		driver.findElement(By.linkText("Create New Account")).click();
		Thread.sleep(2000);
		WebElement dayElement = driver.findElement(By.xpath("//select[@title='Day']"));
		Select daySelect = new Select(dayElement);
		daySelect.selectByIndex(0);
		
		WebElement monthElement = driver.findElement(By.xpath("//select[@title='Month']"));
		Select monthSelect = new Select(monthElement);
		monthSelect.selectByValue("5");
		
		WebElement yearElement = driver.findElement(By.xpath("//select[@title='Year']"));
		Select yearSelect = new Select(yearElement);
		yearSelect.selectByVisibleText("2000");*/		
	}
}
