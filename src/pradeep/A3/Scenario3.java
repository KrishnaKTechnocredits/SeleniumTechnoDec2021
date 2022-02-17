package pradeep.A3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Scenario3 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://demo.guru99.com/test/newtours/register.php");
		WebElement countryElement = driver.findElement(By.xpath("//select[@name='country']"));
		Select selectCountryName = new Select(countryElement);
		List<WebElement> countryName = selectCountryName.getOptions();

		for (WebElement ele : countryName) {
			if (ele.getText().length() > 10) {
				System.out.println(ele.getText());
			}
		}
	}
}
