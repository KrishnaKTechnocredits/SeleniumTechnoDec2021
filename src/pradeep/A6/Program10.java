//10. write a method which returs unique Department from table 2 --> 4
package pradeep.A6;

import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pradeep.base.PredefinedActions;

public class Program10 {
	static LinkedHashSet<String> getUniqueDepartmentId() {
		LinkedHashSet<String> departmentIdList = new LinkedHashSet<>();

		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/index.html");
		driver.findElement(By.linkText("Demo Tables")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		List<WebElement> rowElement = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='table table-striped']/tbody/tr")));

		for (int i = 1; i <= rowElement.size(); i++) {
			WebElement departmentIdElement = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[5]"));
			departmentIdList.add(departmentIdElement.getText());
		}
		return departmentIdList;
	}

	public static void main(String[] args) {
		LinkedHashSet<String> departmentIdList = getUniqueDepartmentId();
		System.out.println("Total Unique Department ID: " + departmentIdList.size());
	}
}
