package naquibalam;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class A3_Program3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		System.out.println("Browser launched");
		Thread.sleep(2000);
		try {
			Select countryDropDown = new Select(driver.findElement(By.xpath("//select[@name='country']")));
			Thread.sleep(2000);
			List<WebElement> countryDropdownValues = countryDropDown.getOptions();
			for (WebElement we : countryDropdownValues) {
				if (we.getText().length() > 10) {
					System.out.println(we.getText());
				}
			}
		}finally {
			driver.close();
			System.out.println("Browser Closed");
		}	
	}
}
