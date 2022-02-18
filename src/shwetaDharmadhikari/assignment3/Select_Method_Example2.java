/*
Scenario : 2
1. Visit "http://automationbykrishna.com/"
2. Navigate to "Basic element tab"
3. Perform multi drop down methods(deselect by index/value/text, deselectAll)
 */
package shwetaDharmadhikari.assignment3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Select_Method_Example2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@id='basicelements']")).click();;
		Thread.sleep(5000);
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		Thread.sleep(5000);
		
		je.executeScript("window.scrollBy(0,1000)", "");
		Select select = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		
		select.selectByIndex(2);
		select.selectByVisibleText("5");
		select.selectByIndex(3);
		System.out.println("All Selected values : ");
		List<WebElement> ls = select.getAllSelectedOptions();
		for(WebElement ele2 : ls)
			System.out.print(ele2.getText()+"  ");
		Thread.sleep(3000);
		
		select.deselectByIndex(2);
		System.out.println("");
		System.out.println("After removing Index 2 value: ");
		ls=select.getAllSelectedOptions();
		for(WebElement ele2 : ls)
			System.out.print(ele2.getText()+"  ");
		
		select.deselectAll();
		System.out.println();
		System.out.println("After deslectAll: ");
		ls=select.getAllSelectedOptions();
		for(WebElement ele2 : ls)
			System.out.print(ele2.getText()+"  ");
		driver.close();
	}

}
