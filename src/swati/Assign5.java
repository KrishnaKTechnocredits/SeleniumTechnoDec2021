package swati;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assign5 {
	WebDriver driver;

	@BeforeMethod
	public void initialize() {
		driver = InitializeDriver.initialize("http://automationbykrishna.com/index.html#");
	}

	@Test
	public void employee() {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='demotable']")));
		ele.click();
		List<WebElement> li = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='table1']//tbody//following-sibling::tr")));
		System.out.println(li.size());
		for (WebElement s : li) {
			System.out.println(s.getText());
		}

		// list of employee after dhara
		System.out.println("----------------");
		System.out.println("Employee after Dhara");
		li = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='table1']//tr[3]//following-sibling::tr")));
		for (WebElement emp : li) {
			System.out.println(emp.getText());
		}

		// first name
		System.out.println("----------------");
		System.out.println("Username with Patro");
		WebElement uname = driver
				.findElement(By.xpath("//table[@id='table1']//tr//td[text()='ppatro']//parent::tr//td[2]"));
		System.out.println(uname.getText());

		// first name
		System.out.println("----------------");
		System.out.println("Heaader");
		List<WebElement> header = driver.findElements(By.xpath("//table[@id='table1']//thead"));
		for (WebElement head : header) {
			System.out.println(head.getText());
		}
	}

	@AfterMethod
	public void close() {
		driver.close();
	}
}
