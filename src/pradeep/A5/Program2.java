//2. how many employee joins company after dhara? --> 2
package pradeep.A5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pradeep.base.PredefinedActions;

public class Program2 {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/index.html");
		driver.findElement(By.linkText("Demo Tables")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		List<WebElement> element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='table1']/tbody/tr[3]/following-sibling::tr")));
		//Thread.sleep(2000);
		//List<WebElement> element = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[3]/following-sibling::tr"));
		System.out.println("Employee joins company after dhara: "+ element.size());
	}

}
