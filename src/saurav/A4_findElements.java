package saurav;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Assignment - 4: 17th Feb’2022
//
//1. Visit “https://demos.telerik.com/kendo-ui/dropdownlist/index”
//2. Select category as “Dairy Products”
//3. Collect all the value from the drop down value under “Products” using findElements method
//4. Once you get the list try to print only those elements which value 13 characters

public class A4_findElements {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		WebElement ele = driver.findElement(By.xpath("//span[@class='k-input-value-text']"));
		ele.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Dairy Products']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Select product...']")).click();
		List<WebElement> list = driver.findElements(By.xpath("//span[@class='k-list-item-text']"));
		System.out.println("elements having length more than 13 = ");

		for (WebElement itemsLength : list) {
			if (itemsLength.getText().length() > 13)

				System.out.println(itemsLength.getText());
		}
		driver.quit();
	}
}
