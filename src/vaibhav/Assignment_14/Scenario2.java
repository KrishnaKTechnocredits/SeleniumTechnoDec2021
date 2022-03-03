/*Assignment -14: 1st March'2022

Scenario 2: 
Find the age of employee whos name is 'Caesar Vance' on the 1st page
Output: 21

*/
package vaibhav.Assignment_14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import vaibhav.base.PredefinedActions;

public class Scenario2 {

	WebDriver driver;
	String URL = "https://datatables.net/examples/styling/bootstrap4";
	String empName = "Caesar Vance";

	@BeforeClass
	void alaunchBrowser() {
		// System.setProperty("webdriver.chrome.driver",
		// "./drivers/chromedriver_98Version.exe");
		// driver = new ChromeDriver();
		// driver.get(URL);

		driver = PredefinedActions.launchBrowser(URL);
	}

	@Test
	void getAgeofCaesarVance() {
		WebElement ele = driver
				.findElement(By.xpath("//table[@id='example']//tr/td[text()='Caesar Vance']/following-sibling::td[3]"));
		String age = ele.getText();
		System.out.println("Age of Caesar Vance : " + Integer.parseInt(age));
	}
	
	@AfterClass
	void tearDown() {
		driver.quit();
	}
	
}
