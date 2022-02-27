package monikaArkade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment5_TotalEmployeesAfterSpecificEmployee {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");

		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//a[@id='demotable']")))).click();
		System.out.println("Employees after Dhara: " + driver
				.findElements(
						By.xpath("//table[@id='table1']/tbody//td[text()='Dhara']/parent::tr/following-sibling::tr")).size());
	}
}
