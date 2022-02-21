package pradeep.A3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Scenario2 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(2000);
		WebElement multi = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select select = new Select(multi);
		System.out.println(select.isMultiple());

		// First Select multiple values
		select.selectByIndex(0);
		Thread.sleep(2000);
		select.selectByIndex(1);
		// selectByValue will not work for Multi DropDown because value attribute is not
		// available
		// select.selectByValue(5);
		select.selectByVisibleText("4");
		Thread.sleep(2000);
		select.selectByVisibleText("5");
		Thread.sleep(2000);
		// Now deselect visible text
		select.deselectByIndex(1);
		Thread.sleep(2000);
		select.deselectByVisibleText("5");
		Thread.sleep(2000);
		select.deselectAll();

	}

}
