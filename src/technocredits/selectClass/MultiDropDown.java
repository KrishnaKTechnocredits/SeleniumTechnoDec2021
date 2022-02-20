package technocredits.selectClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiDropDown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("http://automationbykrishna.com/#");
		System.out.println("Browser launched");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);

		WebElement multi = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select select = new Select(multi);
		System.out.println(select.isMultiple());
		select.selectByIndex(0);
		select.selectByVisibleText("2");
//		select.selectByVisibleText("5");
//		select.deselectByVisibleText("5");
//		select.deselectByIndex(2);
		Thread.sleep(2000);
		select.deselectAll();

//		List<WebElement> alloptions = select.getOptions();
//		List<WebElement> list = select.getAllSelectedOptions();
//		
//		alloptions.removeAll(list);
//		
//		for(WebElement ele: list) {
//			System.out.println(ele.getText());
//		}
	}

}
