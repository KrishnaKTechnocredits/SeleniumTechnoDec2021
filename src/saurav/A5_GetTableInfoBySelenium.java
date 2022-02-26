/**
 * 
 */
package saurav;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author hp
 *
 */
public class A5_GetTableInfoBySelenium {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver assi5Program1 = new ChromeDriver();
		assi5Program1.manage().window().maximize();
		assi5Program1.get("http://automationbykrishna.com/");

		assi5Program1.findElement(By.xpath("//*[@id=\"demotable\"]")).click();

		WebDriverWait wait = new WebDriverWait(assi5Program1, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table']")));
		System.out.println("total Employees in Table = "
				+ assi5Program1.findElements(By.xpath("//div[@id='empbasic']//tbody/tr")).size());

	}
}