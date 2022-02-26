//9. write a method which return unique manager ids from table 2 --> 3
package pradeep.A6;

import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pradeep.base.PredefinedActions;

public class Program9 {

	static LinkedHashSet<String> getUniqueManagerId() {
		LinkedHashSet<String> managerIdList = new LinkedHashSet<>();

		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/index.html");
		driver.findElement(By.linkText("Demo Tables")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		List<WebElement> rowElement = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='table table-striped']/tbody/tr")));

		for (int i = 1; i <= rowElement.size(); i++) {
			WebElement manageIdElement = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[4]"));
			managerIdList.add(manageIdElement.getText());
		}
		return managerIdList;

	}

	public static void main(String[] args) {
		LinkedHashSet<String>  managerIdList = getUniqueManagerId();
		System.out.println("Total Unique Manager ID: "+ managerIdList.size());
	}
}
