package sandip.Assignment_04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment04 {

	public static void main(String[] args) throws InterruptedException {
		System.getProperty("chromedriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");
		driver.manage().window().maximize();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='k-input-value-text'][text()='Select category...']")).click();
		System.out.println("Execution 1");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//h3[text()='Dairy Products']")).click();
		System.out.println("Execution 2");

		JavascriptExecutor js = (JavascriptExecutor) driver; // line1
		js.executeScript("window.scrollBy(0,250)", ""); // line2

		driver.findElement(By.xpath("//span[text()='Select product...']")).click();
		List<WebElement> l1 = driver.findElements(By.xpath("//ul[@id='products_listbox']/li/following-sibling::li"));
		System.out.println("Execution 3");
		System.out.println();
		for (WebElement e1 : l1) {
			String s1 = e1.getText();
			if (s1.length() > 13) {
				System.out.println(s1);
			}
		}
	}
}
