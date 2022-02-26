package monikaArkade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment5_P3 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");

		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//a[@id='demotable']")))).click();
		System.out.println("The name of user having username is ppatro : " + driver
				.findElement(By.xpath("//table[@id='table1']//tbody/tr[5]//td[4]/preceding-sibling::td[2]")).getText());
	}
}
