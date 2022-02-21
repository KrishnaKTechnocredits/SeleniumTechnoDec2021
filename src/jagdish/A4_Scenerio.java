package jagdish;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class A4_Scenerio {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		driver.findElement(By.xpath("//span[text()='Select category...']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h3[text()='Dairy Products']")).click();
		driver.findElement(By.xpath("//span[text()='Select product...']")).click();

		List<WebElement> listofProduct = driver.findElements(By.xpath("//ul[@id='products_listbox']/li/span"));

		for (int index = 1; index < listofProduct.size(); index++) {
			if (listofProduct.get(index).getText().length() > 13) {
				System.out.println(listofProduct.get(index).getText());
			}
		}
	}
}
