/*Assignment - 3: 16th Feb’2022

Scenario : 1
1. Visit "https://twitter.com/i/flow/signup"
2. Try to select value from drop down using different method (index, value, visible text)
*/
package shwetaDharmadhikari.assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectMethods {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://twitter.com/i/flow/signup");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		WebElement element = driver.findElement(By.xpath("//select[@id='SELECTOR_2']"));
		
		Select select = new Select(element);
		select.selectByIndex(2);
		WebElement element1 = driver.findElement(By.xpath("//select[@id='SELECTOR_1']"));
		Select select1 = new Select(element1);
		select1.selectByValue("5");
		WebElement element2 = driver.findElement(By.xpath("//select[@id='SELECTOR_3']"));
		Select select2 = new Select(element2);
		select2.selectByVisibleText("1997");
		Thread.sleep(2000);
		driver.close();
	}

}
