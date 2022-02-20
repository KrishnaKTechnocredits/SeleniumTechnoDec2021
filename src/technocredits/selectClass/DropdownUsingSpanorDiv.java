package technocredits.selectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownUsingSpanorDiv {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");
		
		driver.findElement(By.xpath("//span[@role='listbox'][1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//h3[text()='Seafood']")).click();
	}
}
