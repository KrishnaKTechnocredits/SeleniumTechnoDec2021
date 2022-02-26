//write a method which return unique last name form the table 1
package pradeep.A6;

import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pradeep.base.PredefinedActions;

public class Program7 {

	static LinkedHashSet<String> getAllUniqueLastName() {
		LinkedHashSet<String> lastNameList = new LinkedHashSet<>();
		
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/index.html");
		driver.findElement(By.linkText("Demo Tables")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		List<WebElement> list = wait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='table1']//tbody/tr")));
		
		for (int i = 1; i <= list.size(); i++) {
			WebElement element = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[3]"));
			lastNameList.add(element.getText());
		}
		return lastNameList;
	}

	public static void main(String[] args) {
		LinkedHashSet<String> lastNameList = getAllUniqueLastName();
		System.out.println(lastNameList);
	}
}
