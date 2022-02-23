/*Assignment - 4: 17th Feb’2022

1. Visit “https://demos.telerik.com/kendo-ui/dropdownlist/index”
2. Select category as “Dairy Products”
3. Collect all the value from the drop down value under “Products” using findElements method
4. Once you get the list try to print only those elements which value 13 characters*/


package pallavi;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A4_DropDown_WithoutSelect {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		
		driver.findElement(By.xpath("//span[text()='Select category...']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h3[text()='Dairy Products']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[text()='Select product...']")).click();
		List<WebElement>products=driver.findElements(By.xpath("//*[@id='products_listbox']/li/span"));
		
		System.out.println("List of Products with name having more than 13 letters:");
		for(WebElement product:products)
			if(product.getText().length()>13)
				System.out.println(product.getText());
		driver.close();
	}
	
	

}
