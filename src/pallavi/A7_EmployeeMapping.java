/*Assignment - 7: 20th Feb'2022

11. write a method which returns map of department name & employee count
12. write a method which returns map of manager id & employee count
13. write a method to find manager id has max reporting employee from table 2
14. write a method to find duplicate employee id and name
	-> map
	-> set
	-> list
*/
package pallavi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A7_EmployeeMapping {

	// write a method which returns map of department name & employee count
	static HashMap getDeptEmpMap(WebDriver driver) {
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr"));
		HashMap<String, Integer> deptEmpMap = new HashMap<String, Integer>();
		for (int i = 1; i < rows.size(); i++) {
			String dept = driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + i + "]/td[5]")).getText();
			if (deptEmpMap.containsKey(dept)) {
				int count = deptEmpMap.get(dept);
				deptEmpMap.put(dept, count + 1);
			} else
				deptEmpMap.put(dept, 1);
		}
		return deptEmpMap;
	}

	// write a method which returns map of manager id & employee count
	static HashMap getManagerEmpMap(WebDriver driver) {
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr"));
		HashMap<Integer, Integer> managerEmpMap = new HashMap<Integer, Integer>();
		for (int i = 1; i < rows.size(); i++) {
			int managerID = Integer.parseInt(
					driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + i + "]/td[4]")).getText());
			if (managerEmpMap.containsKey(managerID)) {
				int count = managerEmpMap.get(managerID);
				managerEmpMap.put(managerID, count + 1);
			} else
				managerEmpMap.put(managerID, 1);
		}
		return managerEmpMap;
	}

	// write a method to find manager id has max reporting employee from table 2
	static void getManagerIDWithMaxEmp(WebDriver driver) {
		Set<Map.Entry<Integer, Integer>> setOfEntry = getManagerEmpMap(driver).entrySet();
		int maxVal = 0;
		int empid = 0;
		for (Entry<Integer, Integer> entry : setOfEntry) {
			if (entry.getValue() > maxVal) {
				maxVal = entry.getValue();
				empid = entry.getKey();
			}
		}
		System.out.println(empid + "--" + maxVal);
	}

	// write a method to find duplicate employee id and name--Map
	static void getDuplicateEmpMap(WebDriver driver) {
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr"));
		HashMap<Integer, String> DuplicateEmpMap = new HashMap<Integer, String>();
		for (int i = 1; i < rows.size(); i++) {
			String empName = driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + i + "]/td[3]"))
					.getText();
			int empID = Integer.parseInt(
					driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + i + "]/td[2]")).getText());
			if (DuplicateEmpMap.containsKey(empID)) {
				System.out.println(empID + "--->" + empName);
			} else
				DuplicateEmpMap.put(empID, empName);
		}
	}

	// write a method to find duplicate employee id and name--Set
	static void getDuplicateEmpSet(WebDriver driver) {
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr"));
		HashSet<Integer> DuplicateEmpSet = new HashSet<Integer>();
		for (int i = 1; i < rows.size(); i++) {
			String empName = driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + i + "]/td[3]"))
					.getText();
			int empID = Integer.parseInt(
					driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + i + "]/td[2]")).getText());
			if (!DuplicateEmpSet.add(empID)) {
				System.out.println(empID + "--->" + empName);
			}
		}
	}

	// write a method to find duplicate employee id and name--Set
	static void getDuplicateEmpList(WebDriver driver) {
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr"));
		ArrayList<Integer> DuplicateEmpList = new ArrayList<Integer>();
		for (int i = 1; i < rows.size(); i++) {
			String empName = driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + i + "]/td[3]"))
					.getText();
			int empID = Integer.parseInt(
					driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + i + "]/td[2]")).getText());
			if (DuplicateEmpList.contains(empID)) {
				System.out.println(empID + "--->" + empName);
			} else
				DuplicateEmpList.add(empID);
		}
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("demotable")).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@id='empmanager']//tbody/tr"), 1));

		System.out.println("Map of department name & employee count");
		System.out.println(getDeptEmpMap(driver));
		System.out.println();

		System.out.println("Map of manager id & employee count");
		System.out.println(getManagerEmpMap(driver));
		System.out.println();

		System.out.println("Manager id with max reporting employee from table 2 : ");
		getManagerIDWithMaxEmp(driver);
		System.out.println();

		System.out.println("Duplicate employee id and name with map : ");
		getDuplicateEmpMap(driver);
		System.out.println();

		System.out.println("Duplicate employee id and name with set : ");
		getDuplicateEmpSet(driver);
		System.out.println();

		System.out.println("duplicate employee id and name with list : ");
		getDuplicateEmpList(driver);
		System.out.println();

		driver.close();

	}

}
