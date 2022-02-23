package tanu;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

/* 1.Visit “https://demos.telerik.com/kendo-ui/dropdownlist/index”
2. Select category as “Dairy Products”
3. Collect all the value from the drop down value under “Products” using findElements method
4. Once you get the list try to print only those elements which value 13 characters*/

class Assignment4 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\java-selenium\\Eclipse\\SeleniumBasics\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@role=\"listbox\"][1]")).click();
		Thread.sleep(5000);
		System.out.println("Select category as Dairy Products");
		driver.findElement(By.xpath("//h3[text()=\"Dairy Products\"]")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		System.out.println("Select Products");
		driver.findElement(By.xpath("//span[@role=\"listbox\"][2]")).click();
		Thread.sleep(2000);
		List<WebElement> listofelement = driver.findElements(By.xpath("//span[@class= 'k-list-item-text']"));
		Thread.sleep(3000);
		for (WebElement we : listofelement) {
			if (we.getText().length() > 13)
				System.out.println(we.getText());
		}
		driver.close();
	}
}