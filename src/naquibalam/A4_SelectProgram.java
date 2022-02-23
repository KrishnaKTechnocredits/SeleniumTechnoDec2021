package naquibalam;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A4_SelectProgram {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");
		Thread.sleep(2000);
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", "");
			driver.findElement(By.xpath("//h4[text()='Categories:']//following-sibling::span//child::button")).click();
			Thread.sleep(2000);
			WebElement selectValue = driver.findElement(By.xpath("//h3[text()='Dairy Products']"));
			if (selectValue.isDisplayed()) {
				selectValue.click();
				Thread.sleep(5000);
			}
			WebElement productDropdown = driver.findElement(By.xpath("//h4[text()='Products:']//following-sibling::span//child::button"));
			if (productDropdown.isEnabled()) {
				productDropdown.click();
				Thread.sleep(2000);
				List<WebElement> allSelectValue = driver.findElements(By.xpath("//ul[@id='products_listbox']//child::li//span"));
				System.out.println("All values present in Product dropdown");
				for (WebElement we : allSelectValue) {
					System.out.println(we.getText() + " - " + we.getText().length());
				}
				System.out.println("**********************************************************************");
				System.out.println("Value with more then 13 characters");
				for (WebElement we : allSelectValue) {
					if (we.getText().length() > 13) {
						System.out.println(we.getText());
					}
				}
			} else {
				System.out.println("Products dropdown is disabled even after 5 sec wait after selection of Category");
			}
		}finally {
			driver.close();
		}	
	}
}
