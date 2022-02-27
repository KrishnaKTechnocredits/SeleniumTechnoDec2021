package monikaArkade;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4_findElements {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,250)", "");
		WebElement element = driver.findElement(By.xpath("//span/*[text() = 'Select category...']"));
		element.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[text()= 'Dairy Products']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text() = 'Select product...']")).click();
		List<WebElement> list = driver.findElements(By.xpath("//span[@class= 'k-list-item-text']"));
		for (WebElement element1 : list) {
			if (element1.getText().length() > 13)
				System.out.println(element1.getText());
		}
		Thread.sleep(2000);
		driver.close();
	}
}
