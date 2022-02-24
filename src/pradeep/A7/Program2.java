//12. write a method which returns map of manager id & employee count
package pradeep.A7;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pradeep.base.PredefinedActions;

public class Program2 {
	public static void main(String[] args) {
		HashMap<String, Integer> hmap = new HashMap<>();

		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/index.html");
		driver.findElement(By.linkText("Demo Tables")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		List<WebElement> rowElement = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='table table-striped']/tbody/tr")));

		for (int i = 1; i <= rowElement.size(); i++) {
			WebElement managerIdElement = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[4]"));

			String managerIdKey = managerIdElement.getText();
			if (hmap.containsKey(managerIdKey)) {
				int cnt = hmap.get(managerIdKey);
				hmap.put(managerIdKey, cnt + 1);

			} else {
				hmap.put(managerIdKey, 1);
			}
		}
		System.out.println(hmap);
	}
}
