package rohini.Rohini_Assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*Scenario : 1
1. Visit "https://twitter.com/i/flow/signup"
2. Try to select value from drop down using different method (index, value, visible text)
*/
public class Program1 {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("https://twitter.com/i/flow/signup");
		System.out.println("Browser launched");
		
		Thread.sleep(9000);
		WebElement month = driver.findElement(By.xpath("//select[@id='SELECTOR_1']"));
		Select selectmonth=new Select(month);
		selectmonth.selectByIndex(0);
		
		Thread.sleep(2000);
		WebElement day = driver.findElement(By.xpath("//select[@id='SELECTOR_2']"));
		Select selectday=new Select(day);
		selectday.selectByValue("13");;
		
		Thread.sleep(2000);
		WebElement year = driver.findElement(By.xpath("//select[@id='SELECTOR_3']"));
		Select selectyear=new Select(year);
		selectyear.selectByVisibleText("1994");;
		
		
	}

}
