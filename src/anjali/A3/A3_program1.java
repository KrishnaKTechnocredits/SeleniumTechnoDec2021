/*

  Scenario : 1
  1. Visit "https://twitter.com/i/flow/signup"
  2. Try to select value from drop down using different method (index, value, visible text)
  
*/

package anjali.A3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class A3_program1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://twitter.com/i/flow/signup");
		System.out.println("Browser launched");
		Thread.sleep(5000);
		
		
		WebElement monthDropdown=driver.findElement(By.xpath("//select[@id='SELECTOR_1']"));
		Select select= new Select(monthDropdown);
		select.selectByVisibleText("April");
		
		WebElement DayDropdown=driver.findElement(By.xpath("//select[@id='SELECTOR_2']"));
	    select= new Select(DayDropdown);
		select.selectByVisibleText("25");
		
		WebElement yearDropdown=driver.findElement(By.xpath("//select[@id='SELECTOR_3']"));
	    select= new Select(yearDropdown);
		select.selectByVisibleText("2018");
		
		Thread.sleep(5000);
		
		driver.close();
	}
     

}

