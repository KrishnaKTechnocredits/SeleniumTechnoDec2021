package yogeshNimbalkar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A7_EmployeeTable2 {

	Map<String, Integer> getDeptNameAndEmpCount (WebDriver driver){
		Map<String, Integer> deptEmpMap = new HashMap<String, Integer>();
		List<WebElement> departmentList = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr/td[5]"));
		for(int index=1; index<=departmentList.size(); index++) {
			String departmentName = driver.findElement(By.xpath("//div[@id='empmanager']//table/tbody/tr[" + index + "]/td[5]")).getText();
//			int empCount = deptEmpMap.get(departmentName);
			if(deptEmpMap.containsKey(departmentName)) {
				deptEmpMap.put(departmentName, deptEmpMap.get(departmentName) + 1);
			}else {
				deptEmpMap.put(departmentName, 1);
			}
		}
		return deptEmpMap;
	}
	
	Map<String, Integer> getManagerIdAndEmpCount (WebDriver driver){
		Map<String, Integer> managerEmpMap = new HashMap<>();
		List<WebElement> managerList = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr/td[4]"));
		for(int index=1; index<=managerList.size(); index++) {
			String managerId = driver.findElement(By.xpath("//div[@id='empmanager']//table/tbody/tr[" + index + "]/td[4]")).getText();
			if(managerEmpMap.containsKey(managerId)) {
				managerEmpMap.put(managerId, managerEmpMap.get(managerId) + 1);
			}else {
				managerEmpMap.put(managerId, 1);
			}
		}
		return managerEmpMap;
	}
	
	String getManagerWithMaxEmpCount(WebDriver driver) {
		Map<String, Integer> managerMap = new HashMap<>();
		List<WebElement> managerList = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr/td[4]"));
		for(int index=1; index<=managerList.size(); index++) {
			String managerId = driver.findElement(By.xpath("//div[@id='empmanager']//table/tbody/tr[" + index + "]/td[4]")).getText();
			if(managerMap.containsKey(managerId)) {
				managerMap.put(managerId, managerMap.get(managerId) + 1);
			}else {
				managerMap.put(managerId, 1);
			}
		}
		String managerWithMaxEmployee ="";
		int maxCount =0;
		for (int index=1; index<=managerList.size(); index++) {
			String managerId = driver.findElement(By.xpath("//div[@id='empmanager']//table/tbody/tr[" + index + "]/td[4]")).getText();
			if (managerMap.get(managerId) > maxCount) {
				managerWithMaxEmployee = managerId;
				maxCount = managerMap.get(managerId);
			}
		}
		return managerWithMaxEmployee + " -> " + maxCount;
	}
	
	List<String> getDuplicateEmpId (WebDriver driver){
		Map<String, String> empIdMap = new HashMap<>();
		List<WebElement> empidList = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr/td[2]"));
		List<String> duplicateList = new ArrayList<String>();
		for(int index=1; index<=empidList.size(); index++) {
			String empId = driver.findElement(By.xpath("//div[@id='empmanager']//table/tbody/tr[" + index + "]/td[2]")).getText();
			String empName = driver.findElement(By.xpath("//div[@id='empmanager']//table/tbody/tr[" + index + "]/td[3]")).getText();
			if(empIdMap.containsKey(empId)) {
				duplicateList.add(empId + " -> " + empName);
			}else {
				empIdMap.put(empId, empName);
			}
		}
		return duplicateList;
	}
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "http://automationbykrishna.com/";
		driver.get(url);
		A7_EmployeeTable2 employeeTable2 = new A7_EmployeeTable2();
		driver.findElement(By.id("demotable")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='empmanager']")));
		
		//map of department name and employee count
		System.out.println("Department name with Employee count : " + employeeTable2.getDeptNameAndEmpCount(driver));
		
		//map of manager id and employee count
		System.out.println("Manager id with Employee count : " + employeeTable2.getManagerIdAndEmpCount(driver));
		
		//find manager id has max number of reporting employee
		System.out.println("Manager ID with max number of employee : " + employeeTable2.getManagerWithMaxEmpCount(driver));
		
		//find duplicate employee id and name
		System.out.println("Duplicate emp Id with Name : " + employeeTable2.getDuplicateEmpId(driver));
		
		driver.quit();
	}
}
