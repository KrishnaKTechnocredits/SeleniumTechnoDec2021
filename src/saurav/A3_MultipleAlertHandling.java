package saurav;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class A3_MultipleAlertHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/#");
		System.out.println();
		Thread.sleep(2000);

		System.out.println("browser launched");

		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);

		WebElement multiDropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Thread.sleep(2000);
		Select select = new Select(multiDropdown);
		System.out.println(select.isMultiple());
		Thread.sleep(2000);

		select.selectByIndex(0);
		Thread.sleep(2000);

		select.selectByVisibleText("3");
		Thread.sleep(2000);

		select.selectByVisibleText("5");
		Thread.sleep(2000);

		List<WebElement> list = select.getAllSelectedOptions();
		for(WebElement ele: list) {
			System.out.println(ele.getText());
		}
		
		select.deselectByIndex(0);
		Thread.sleep(1000);

		select.deselectByVisibleText("5");
		Thread.sleep(1000);

		select.deselectAll();
		Thread.sleep(1000);

		driver.quit();
		System.out.println("end");

	}

}
