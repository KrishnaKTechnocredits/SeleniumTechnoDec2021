package sagarShrikhande;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A4_FindElementsOp {
	
	void findElementsmethod(WebDriver driver, String url) throws InterruptedException {
		driver.get(url);
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.xpath("//span/*[text() = 'Select category...']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()= 'Dairy Products']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text() = 'Select product...']")).click();
		List<WebElement> ls = driver.findElements(By.xpath("//span[@class= 'k-list-item-text']"));
		for(WebElement ele : ls) {
			if(ele.getText().length() > 13)
				System.out.println(ele.getText());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "I:\\Learning\\Eclipse\\Basic Selenium\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://demos.telerik.com/kendo-ui/dropdownlist/index";
		A4_FindElementsOp a4 = new A4_FindElementsOp();
		a4.findElementsmethod(driver, url);
	}
}

/* 
1. Visit “https://demos.telerik.com/kendo-ui/dropdownlist/index”
2. Select category as “Dairy Products”
3. Collect all the value from the drop down value under “Products” using findElements method
4. Once you get the list try to print only those elements which value 13 characters
*/