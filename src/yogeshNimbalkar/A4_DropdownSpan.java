package yogeshNimbalkar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class A4_DropdownSpan {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Browser maximized");
		driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");
		System.out.println("Browser Launched");
		
//		scroll the page		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@role='listbox'][1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h3[text()='Dairy Products']")).click();
		System.out.println("Dairy product selected");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@role='listbox'][2]")).click();
		Thread.sleep(2000);
		List <WebElement> products = driver.findElements(By.xpath("//ul[@id='products_listbox']/li/span"));
		Thread.sleep(3000);
		
		for(WebElement element : products) {
			String productName = element.getText();
			if(productName.length() <= 13) {
				System.out.println(productName);
			}
		}
		
		driver.quit();
	}
}
