package monikaArkade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment5_TotalEmployeesInWebTable {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("http://automationbykrishna.com/");
		System.out.println("Browser is launched");
		
//		  driver.findElement(By.xpath("//a[@id='demotable']")).click();
//		  driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		

		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//a[@id='demotable']")))).click();
		System.out.println("Total Employees in Table 1 is : "
				+ driver.findElements(By.xpath("//div[@id='empbasic']//tbody/tr")).size());
	}
}
