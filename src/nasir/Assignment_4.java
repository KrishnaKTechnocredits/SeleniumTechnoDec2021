package nasir;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_4 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Select category...']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h3[text()='Dairy Products']")).click();
		driver.findElement(By.xpath("//span[text()='Select product...']")).click();
		List <WebElement> listOfEle=driver.findElements(By.xpath("//*[@id='products_listbox']/li/span"));
		System.out.println("List of products which are having more than 13 characters");
		for(WebElement ele:listOfEle) {
			if(ele.getText().length()>13)
				System.out.println(ele.getText());
		}
			
		
		
		
		
	}
}
