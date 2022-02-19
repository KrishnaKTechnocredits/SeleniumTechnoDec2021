package megha;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Megha_Assignment4 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"E:\\QA\\Automation\\SeleniumTechnoDec2021//drivers//chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");
		Thread.sleep(10000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		driver.findElement(By.xpath("//span/*[text() = 'Select category...']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()= 'Dairy Products']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text() = 'Select product...']")).click();
		List<WebElement> products = driver.findElements(By.xpath("//span[@class= 'k-list-item-text']"));
		Thread.sleep(3000);

		for (WebElement element : products) {
			if (element.getText().length() > 13)
				System.out.println(element.getText());
		}
	}
}
