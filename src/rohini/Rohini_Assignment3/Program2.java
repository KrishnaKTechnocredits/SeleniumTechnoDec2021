package rohini.Rohini_Assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*Scenario : 2
1. Visit "http://automationbykrishna.com/"
2. Navigate to "Basic element tab"
3. Perform multi drop down methods(deselect by index/value/text, deselectAll)
*/

public class Program2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("http://automationbykrishna.com/");
		
		System.out.println("Browser launched");
		driver.findElement(By.partialLinkText("Basic")).click();
		
		Thread.sleep(2000);
		WebElement selct1 = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select select=new Select(selct1);
		Thread.sleep(2000);
		//select.selectByValue("1");
		Thread.sleep(2000);
		select.selectByVisibleText("4");
		select.selectByVisibleText("5");
		Thread.sleep(2000);
		select.deselectByIndex(3);
		Thread.sleep(2000);
		//select.deselectByValue("1");
		Thread.sleep(2000);
		select.deselectAll();
		
		
		//driver.close();
		//System.out.println("Browser Closed");
	}
}
