//6. write a method which returns first name of all employee from the first table
package pradeep.A6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pradeep.base.PredefinedActions;

public class Program6 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/index.html");
		driver.findElement(By.linkText("Demo Tables")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		List<WebElement> list = wait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='table1']//tbody/tr")));

		for (int i = 1; i <= list.size(); i++) {
			WebElement element = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td[2]"));
			System.out.println(element.getText());
		}
	}
}
