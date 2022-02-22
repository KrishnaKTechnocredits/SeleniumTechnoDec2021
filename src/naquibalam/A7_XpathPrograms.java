package naquibalam;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class A7_XpathPrograms {
	
	Map<String, Integer> employeeDeptMapping(WebDriver driver) {
		List<WebElement> allEmpDepts = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr/td[5]"));
		Map<String,Integer> empDeptMapped = new LinkedHashMap<>();
		int count = 0;
		for (WebElement eachEmp : allEmpDepts) {
			if(empDeptMapped.containsKey(eachEmp.getText())) {
				count = empDeptMapped.get(eachEmp.getText());
				empDeptMapped.put(eachEmp.getText(), count+1);
			}
			else {
				empDeptMapped.put(eachEmp.getText(), 1);
			}
		}
		return empDeptMapped;
	}

	Map<String, Integer> employeeManagerIDMapping(WebDriver driver) {
		List<WebElement> allManagerIDs = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr/td[4]"));
		Map<String,Integer> empManagerIDMapped = new LinkedHashMap<>();
		int count = 0;
		for (WebElement eachEmp : allManagerIDs) {
			if(empManagerIDMapped.containsKey(eachEmp.getText())) {
				count = empManagerIDMapped.get(eachEmp.getText());
				empManagerIDMapped.put(eachEmp.getText(), count+1);
			}
			else {
				empManagerIDMapped.put(eachEmp.getText(), 1);
			}
		}
		return empManagerIDMapped;
	}
	
	String managerWithMaxEmp(WebDriver driver) {
		Map<String, Integer> input = employeeManagerIDMapping(driver);
		int max = 0;
		String MaxKey = null;
		for (String in : input.keySet()) {
			if (input.get(in) > max) {
				max = input.get(in);
				MaxKey = in;
			}
		}
		return MaxKey;
	}
	
	List<String> duplicateEmp(WebDriver driver) {
		Map<String,String> empIDEmpNameMappedUnique = new LinkedHashMap<>();
		List<WebElement> allEmpIds = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr/td[2]"));
		List<String> duplicateList = new ArrayList<>();
		for(int i = 1; i <= allEmpIds.size(); i++) {
			String empId = driver.findElement(By.xpath("(//div[@id='empmanager']//table/tbody/tr/td[2])[" + i + "]")).getText();
			String empName = driver.findElement(By.xpath("(//div[@id='empmanager']//table/tbody/tr/td[3])[" + i + "]")).getText();
			if (empIDEmpNameMappedUnique.containsKey(empId)) {
				duplicateList.add(empId + " - " + empName);
			}else {
				empIDEmpNameMappedUnique.put(empId, empName);
			}
		}
		return duplicateList;
	}
	
	public static void main(String[] args) throws InterruptedException {
		PredefinedActions predifinedActions = new PredefinedActions();
		A7_XpathPrograms a7_XpathPrograms = new A7_XpathPrograms();
		WebDriver driver = predifinedActions.openBrowser("./drivers/chromedriver_98Version.exe", "http://automationbykrishna.com/");
		driver.findElement(By.id("demotable")).click();
		Thread.sleep(2000);
		try {
			System.out.println("***************************************************************************************");
			System.out.println("Map of department name & employee count : \n" + a7_XpathPrograms.employeeDeptMapping(driver));
			System.out.println("***************************************************************************************");
			System.out.println("Map of Manager ID & employee count : \n" + a7_XpathPrograms.employeeManagerIDMapping(driver));
			System.out.println("***************************************************************************************");
			System.out.println("Manager ID with max reporting employees : \n" + a7_XpathPrograms.managerWithMaxEmp(driver));
			System.out.println("***************************************************************************************");
			System.out.println("Duplicate ID and name are : \n" + a7_XpathPrograms.duplicateEmp(driver));
			System.out.println("***************************************************************************************");
		} finally {
			predifinedActions.closeDriver(driver);
		}
	}

}
