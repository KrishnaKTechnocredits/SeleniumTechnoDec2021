package yogeshNagar;

import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1. Visit “https://demos.telerik.com/kendo-ui/dropdownlist/index”
2. Select category as “Dairy Products”
3. Collect all the value from the drop down value under “Products” using findElements method
4. Once you get the list try to print only those elements which value 13 characters
*/

public class A4_SelectWithOutSelectTag {
	static void selectCategory() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@aria-owns='categories_listbox']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//h3[contains(text(),'Dairy Products')]")).click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.xpath("//span[@aria-owns='products_listbox']")).click();
		Thread.sleep(1000);
		List<WebElement> list = driver.findElements(By.xpath("//ul[@id='products_listbox']/li/span"));
		for (int index = 0; index < list.size(); index++) {
			String productName = list.get(index).getText().replaceAll(" ", "");
			if(productName.length()==13) {
				System.out.println(productName);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		selectCategory();
	}
}
