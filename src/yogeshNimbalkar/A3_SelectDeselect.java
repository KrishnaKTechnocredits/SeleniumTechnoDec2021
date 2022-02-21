package yogeshNimbalkar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class A3_SelectDeselect {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Browser maximized");
		
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("basicelements")).click();
		System.out.println("Browser Launched");
		
//		to scroll the window
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,950)");
		
		WebElement multidropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select selectdropdown = new Select(multidropdown);
		System.out.println("Is selected drop down multi select : " + selectdropdown.isMultiple());
		
		//select the values/options
		selectdropdown.selectByIndex(0);
		Thread.sleep(1000);
		selectdropdown.selectByVisibleText("3");
		Thread.sleep(1000);
		selectdropdown.selectByVisibleText("5");
		Thread.sleep(2000);

		// Print the selected options		
		System.out.println("Below are the selected options");
		List<WebElement> selectedList = selectdropdown.getAllSelectedOptions();
		for(WebElement element : selectedList) {
			System.out.println(element.getText());
		}
		
		//de-select all options
		Thread.sleep(2000);
		selectdropdown.deselectByIndex(0);
		Thread .sleep(1000);
		selectdropdown.deselectByVisibleText("3");
		Thread.sleep(1000);
		selectdropdown.selectByIndex(1);
		Thread.sleep(1000);
		selectdropdown.deselectAll();
		System.out.println("De select all the options");
		
		Thread.sleep(3000);
		driver.close();
	}
}
