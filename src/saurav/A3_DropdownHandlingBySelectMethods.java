package saurav;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class A3_DropdownHandlingBySelectMethods {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://twitter.com/i/flow/signup");
		System.out.println("browser launched");
		Thread.sleep(2000);
		
		
		WebElement month = driver.findElement(By.xpath("//select[@aria-labelledby='SELECTOR_1_LABEL']"));
		Select getMonth = new Select(month);
		getMonth.selectByValue("10");
		
		WebElement day = driver.findElement(By.xpath("//select[@aria-labelledby='SELECTOR_2_LABEL']"));
		Select getDay = new Select(day);
		getDay.selectByIndex(4);
		getMonth.selectByValue("10");

		WebElement year = driver.findElement(By.xpath("//select[@aria-labelledby='SELECTOR_3_LABEL']"));
		Select getYear = new Select(year);
		getYear.selectByVisibleText("1998");
		
		//ALL ABOVE SELECT METHODS ARE REPRESENT SAME FUNCTION BUT THEIR FUNCTIONALITY TO GETTING ELEMENT IS DIFFERENT
		
		driver.quit();
//		List<WebElement>months = getMonth.getOptions();
//		for(WebElement ele: months) {
//			System.out.println(ele.getText());
//		}
//		
		
		
}
}
