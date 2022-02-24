package pradeep.A4;

import java.util.List;

import javax.sound.midi.Soundbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment4 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");
		
		driver.findElement(By.xpath("//span[@role='listbox'][1]")).click();
		Thread.sleep(5000);
		// Note: Dairy Product is not visible in DropDown still we can inspect with "//h3[text()='Dairy Products']"
		//means autoscroll on element but this behaviour is not fixed very page to page
		driver.findElement(By.xpath("//h3[text()='Dairy Products']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text() = 'Select product...']")).click();
		Thread.sleep(4000);
		List<WebElement> productlist = driver.findElements(By.xpath("//span[@class= 'k-list-item-text']"));
		Thread.sleep(3000);

		for (WebElement element : productlist) {
			if (element.getText().length() > 13)
				System.out.println(element.getText());
		}
	}
}