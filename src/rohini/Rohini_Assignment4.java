package rohini;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*Assignment - 4: 17th Feb’2022

1. Visit “https://demos.telerik.com/kendo-ui/dropdownlist/index”
2. Select category as “Dairy Products”
3. Collect all the value from the drop down value under “Products” using findElements method
4. Once you get the list try to print only those elements which value 13 characters
*/

public class Rohini_Assignment4 {

	public static void main(String[] args) throws InterruptedException {
		
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("Maximized browser");

			driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");
			Thread.sleep(10000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div/span/span/span[text()='Select category...']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div/ul/li/span/span/h3[text()='Dairy Products']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//span[text()='Select product...']")).click();
			List<WebElement> list= driver.findElements(By.xpath("//div[@id='products-list']/div/ul/li/span"));
		    
			
			for(WebElement ele : list ) {
				if(ele.getText().length()>13)
				System.out.println(ele.getText());
			}
			
		
			driver.close();
			System.out.println("Browser Closed");

	}

}
