//14. write a method to find duplicate employee id and name
package pradeep.A7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pradeep.base.PredefinedActions;

public class Program4 {

	public static void main(String[] args) {
		HashMap<String, Integer> hmap = new HashMap<>();

		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/index.html");
		driver.findElement(By.linkText("Demo Tables")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		List<WebElement> rowElement = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='table table-striped']/tbody/tr")));

		//using hashMap store EmployeeId as Key
		for (int i = 1; i <= rowElement.size(); i++) {
			WebElement employeeIdElement = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[2]"));
			String employeeIDKey = employeeIdElement.getText();

			if (hmap.containsKey(employeeIDKey)) {
				int cnt = hmap.get(employeeIDKey);
				hmap.put(employeeIDKey, cnt + 1);

			} else {
				hmap.put(employeeIDKey, 1);
			}
		}
		System.out.println(hmap);

		// Make set of all keys
		List<String> duplicateNameOfEmployee = new ArrayList<String>();
		Set<String> keys = hmap.keySet();
		for(String key : keys) {
			if(hmap.get(key)>1) {
				WebElement empElement = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr/td[text()='"+key+"']/following-sibling::td[1]"));
				duplicateNameOfEmployee.add(empElement.getText());		
			}
		}
		System.out.println(duplicateNameOfEmployee);

	
	}
}
