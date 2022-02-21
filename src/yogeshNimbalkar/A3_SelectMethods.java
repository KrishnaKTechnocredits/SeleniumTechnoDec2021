package yogeshNimbalkar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class A3_SelectMethods {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Browser maximized");
		driver.get("https://twitter.com/i/flow/signup");
		System.out.println("Browser Launched");
		
		Thread.sleep(5000);
		WebElement month = driver.findElement(By.xpath("//select[@id='SELECTOR_1']"));
		Select selectMonth = new Select(month);
		selectMonth.selectByValue("7");
		System.out.println("Month selected");
		
		Thread.sleep(2000);
		WebElement day = driver.findElement(By.xpath("//select[@id='SELECTOR_2']"));
		Select selectDay = 	new Select(day);
		selectDay.selectByIndex(15);
		System.out.println("Date selected");
		
		Thread.sleep(2000);
		WebElement year = driver.findElement(By.xpath("//select[@id='SELECTOR_3']"));
		Select selectYear = new Select(year);
		selectYear.selectByVisibleText("2003");
		System.out.println("Year selected");
		
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Browser closed");
	}
}
