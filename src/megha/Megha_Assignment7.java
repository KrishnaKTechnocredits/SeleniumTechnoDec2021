package megha;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;

public class Megha_Assignment7 {

	public static void main(String[] args) {
		Megha_Assignment7 megha_Assignment7 = new Megha_Assignment7();
		PredefinedActions predefinedActions = new PredefinedActions();
		WebDriver driver = predefinedActions.openBrowser("http://automationbykrishna.com");

		driver.findElement(By.linkText("Demo Tables")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));

		System.out.println("Map of Department Name & employee count : ");
		System.out.println(megha_Assignment7.deptNameAndCount(driver));
		System.out.println();

		System.out.println("Map of Manager ID & employee count : ");
		System.out.println(megha_Assignment7.managerIdAndCount(driver));
		System.out.println();

		System.out.println("Map of Manager ID & employee count : ");
		megha_Assignment7.maxReportingEmployee(driver);
		System.out.println();

		System.out.println("Duplicate Employee ID & Name : ");
		System.out.println(megha_Assignment7.duplicateEmpId(driver));
		System.out.println();

		driver.close();

	}

	Map<String, Integer> deptNameAndCount(WebDriver driver) {
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]"));
		Map<String, Integer> deptNameAndCount = new LinkedHashMap();
		int count = 0;
		for (WebElement element : list) {
			if (deptNameAndCount.containsKey(element.getText())) {
				count = deptNameAndCount.get(element.getText());
				deptNameAndCount.put(element.getText(), count + 1);
			} else
				deptNameAndCount.put(element.getText(), 1);
		}

		return deptNameAndCount;
	}

	Map<String, Integer> managerIdAndCount(WebDriver driver) {
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]"));
		Map<String, Integer> managerIdAndCount = new LinkedHashMap();
		int count = 0;
		for (WebElement element : list) {
			if (managerIdAndCount.containsKey(element.getText())) {
				count = managerIdAndCount.get(element.getText());
				managerIdAndCount.put(element.getText(), count + 1);
			} else
				managerIdAndCount.put(element.getText(), 1);
		}

		return managerIdAndCount;
	}

	void maxReportingEmployee(WebDriver driver) {
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]"));
		Map<String, Integer> managerIdAndCount = new LinkedHashMap();
		int count = 0;
		for (WebElement element : list) {
			if (managerIdAndCount.containsKey(element.getText())) {
				count = managerIdAndCount.get(element.getText());
				managerIdAndCount.put(element.getText(), count + 1);
			} else
				managerIdAndCount.put(element.getText(), 1);
		}

		int maxEmpCount = 0;
		String mngId = "";
		for (Entry<String, Integer> empDet : managerIdAndCount.entrySet()) {
			if (empDet.getValue() > maxEmpCount) {
				maxEmpCount = empDet.getValue();
				mngId = empDet.getKey();
			}
		}

		System.out.println(mngId + " => " + maxEmpCount);
	}

	List<String> duplicateEmpId(WebDriver driver) {
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]"));
		List<String> duplicateList = new ArrayList<>();
		Map<String, String> uniqueEmpIDEmpName = new LinkedHashMap<>();
		for (int index = 1; index <= list.size(); index++) {
			String empId = driver
					.findElement(By.xpath("(//table[@class='table table-striped']/tbody/tr/td[2])[" + index + "]"))
					.getText();
			String empName = driver
					.findElement(By.xpath("(//table[@class='table table-striped']/tbody/tr/td[3])[" + index + "]"))
					.getText();
			if (uniqueEmpIDEmpName.containsKey(empId)) {
				duplicateList.add(empId + " - " + empName);
			} else {
				uniqueEmpIDEmpName.put(empId, empName);
			}
		}
		return duplicateList;
	}
}
