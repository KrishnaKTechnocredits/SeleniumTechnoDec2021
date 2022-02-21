package swati;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Assign4_dropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = InitializeDriver.initialize();
		driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='k-input-value-text' and contains(text(),'Select category...')]"))
				.click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//h3[text()='Dairy Products']")).click();
		Thread.sleep(3000);
//		List<WebElement> products=driver.findElements(By.xpath("//span[@class='k-input-value-text' and contains(text(),'Select product...')]"));
		driver.findElement(By.xpath("//span[@class='k-input-value-text' and contains(text(),'Select product...')]"))
				.click();
		List<WebElement> products = driver.findElements(By.xpath("//ul[@id='products_listbox']/li/span"));
		Thread.sleep(3000);
		System.out.println("size is " + products.size());
		/*
		 * String name=products.get(0).getText(); System.out.println(name);
		 */

		for (int i = 0; i < products.size(); i++) {
			String name = products.get(i).getText();
			if (name.length() > 13) {
				System.out.println(name);
			}

		}
		driver.close();
	}

}
