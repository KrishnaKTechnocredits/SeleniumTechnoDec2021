package yogeshNagar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*Assignment - 7: 20th Feb'2022

11. write a method which returns map of department name & employee count
12. write a method which returns map of manager id & employee count
13. write a method to find manager id has max reporting employee from table 2
14. write a method to find duplicate employee id and name
	-> map
	-> set
	-> list
*/

public class A7_WebTable {
	static WebDriver driver = BaseClass.launchBrowser("http://automationbykrishna.com");

	void getDepartmentNameEmployeeCount() throws InterruptedException {
		LinkedHashMap<String, Integer> EmployeeDeaprtmentCount = new LinkedHashMap<String, Integer>();
		List<WebElement> departmentName = driver
				.findElements(By.xpath("//table[contains(@class,'table-striped')]/tbody/tr/td[5]"));
		for (WebElement department : departmentName) {
			if (EmployeeDeaprtmentCount.containsKey(department.getText())) {
				EmployeeDeaprtmentCount.put(department.getText(),
						EmployeeDeaprtmentCount.get(department.getText()) + 1);
			} else
				EmployeeDeaprtmentCount.put(department.getText(), 1);
		}
		System.out.println("----Programme 11----");
		System.out.println("Map of department name & employee count");
		System.out.println(EmployeeDeaprtmentCount);
	}

	void getManagerIDEmployeeCount() throws InterruptedException {
		LinkedHashMap<String, Integer> employeeManagerCount = new LinkedHashMap<String, Integer>();
		List<WebElement> tableRecordCount = driver
				.findElements(By.xpath("//table[contains(@class,'table-striped')]/tbody/tr/td[4]"));
		for (WebElement managerID : tableRecordCount) {
			if (employeeManagerCount.containsKey(managerID.getText())) {
				employeeManagerCount.put(managerID.getText(), employeeManagerCount.get(managerID.getText()) + 1);
			} else
				employeeManagerCount.put(managerID.getText(), 1);
		}
		System.out.println();
		System.out.println("----Programme 12----");
		System.out.println("Map of manager id & employee count");
		System.out.println(employeeManagerCount);
	}

	void getManagerIDMaxEmployeeCount() throws InterruptedException {
		TreeMap<String, Integer> employeeManagerCount = new TreeMap<String, Integer>();
		List<WebElement> tableRecordCount = driver
				.findElements(By.xpath("//table[contains(@class,'table-striped')]/tbody/tr/td[4]"));
		for (WebElement managerID : tableRecordCount) {
			if (employeeManagerCount.containsKey(managerID.getText())) {
				employeeManagerCount.put(managerID.getText(), employeeManagerCount.get(managerID.getText()) + 1);
			} else
				employeeManagerCount.put(managerID.getText(), 1);
		}
		int maxEmpCount = 0;
		String mngID = "";
		for (Entry<String, Integer> empDet : employeeManagerCount.entrySet()) {
			if (empDet.getValue() > maxEmpCount) {
				maxEmpCount = empDet.getValue();
				mngID = empDet.getKey();
			}
		}
		System.out.println();
		System.out.println("----Programme 13----");
		System.out.println("Manager ID with Max employee count");
		System.out.println(mngID + " --> " + maxEmpCount);
	}

	void getDuplicateEmpIDName() {
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]"));
		HashMap<String, String> empIDMap = new HashMap<String, String>();
		ArrayList<String> duplicateEmp = new ArrayList<String>();
		for (int index = 1; index < list.size(); index++) {
			String empID = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			String empName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[3]"))
					.getText();
			if (empIDMap.containsKey(empID)) {
				duplicateEmp.add(empID + " --> " + empName);
			} else
				empIDMap.put(empID, empName);
		}
		System.out.println();
		System.out.println("----Programme 14----");
		System.out.println("Duplicate employee id and name");
		System.out.println(duplicateEmp);

	}

	public static void main(String[] args) throws InterruptedException {
		A7_WebTable webTable = new A7_WebTable();
		driver.findElement(By.id("demotable")).click();
		Thread.sleep(1000);
		webTable.getDepartmentNameEmployeeCount();
		webTable.getManagerIDEmployeeCount();
		webTable.getManagerIDMaxEmployeeCount();
		webTable.getDuplicateEmpIDName();
		driver.quit();
	}
}