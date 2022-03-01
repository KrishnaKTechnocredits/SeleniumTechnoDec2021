package rohini;

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


public class Rohini_Assignment7 {

//	11. write a method which returns map of department name & employee count




	Map<String, Integer> getDeptAndEmployeeCount(WebDriver driver) {
		Map<String, Integer> hs = new HashMap<String, Integer>();
		List<WebElement> ls = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr/td[5]"));
		for (int i = 1; i <= ls.size(); i++) {
			String deptId = driver.findElement(By.xpath("//div[@id='empmanager']//table/tbody/tr[" + i + "]/td[5]"))
					.getText();
			if (hs.containsKey(deptId))
				hs.put(deptId, hs.get(deptId) + 1);
			else
				hs.put(deptId, 1);
		}
		return hs;
	}
	
//	12. write a method which returns map of manager id & employee count

	Map<String, Integer> getManagerIDAndEmployeeCount(WebDriver driver) {
		Map<String, Integer> hs = new HashMap<String, Integer>();
		List<WebElement> ls = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr/td[4]"));
		for (int i = 1; i <= ls.size(); i++) {
			String managerId = driver.findElement(By.xpath("//div[@id='empmanager']//table/tbody/tr[" + i + "]/td[4]"))
					.getText();
			if (hs.containsKey(managerId))
				hs.put(managerId, hs.get(managerId) + 1);
			else
				hs.put(managerId, 1);
		}
		return hs;
	}

//	13. write a method to find manager id has max reporting employee from table 2
	String getManagerIDWithMaxEmployeeCount(WebDriver driver) {
		Map<String, Integer> hs = new HashMap<String, Integer>();
		List<WebElement> ls = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr/td[4]"));
		for (int i = 1; i <= ls.size(); i++) {
			String deptId = driver.findElement(By.xpath("//div[@id='empmanager']//table/tbody/tr[" + i + "]/td[4]"))
					.getText();
			if (hs.containsKey(deptId))
				hs.put(deptId, hs.get(deptId) + 1);
			else
				hs.put(deptId, 1);
		}
		String managerWithMaxEmployees = "";
		int maxCount = 0;
		for (int i = 1; i <= ls.size() - 1; i++) {
			String managerId = driver.findElement(By.xpath("//div[@id='empmanager']//table/tbody/tr[" + i + "]/td[4]"))
					.getText();
			if (hs.get(managerId) > maxCount) {
				managerWithMaxEmployees = managerId;
				maxCount = hs.get(managerId);
			}
		}
		return managerWithMaxEmployees + "--->" + maxCount;
	}

	

//	14. write a method to find duplicate employee id and name

	List<String> getEmployeeIDAndEmployeeNameDuplicates(WebDriver driver) {
		Map<String, String> hs = new HashMap<String, String>();
		List<WebElement> ls = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr/td[2]"));
		List<String> dEmpList = new ArrayList<String>();
		for (int i = 1; i <= ls.size(); i++) {
			String empId = driver.findElement(By.xpath("//div[@id='empmanager']//table/tbody/tr[" + i + "]/td[2]"))
					.getText();
			String empName = driver.findElement(By.xpath("//div[@id='empmanager']//table/tbody/tr[" + i + "]/td[3]"))
					.getText();
			if (hs.containsKey(empId))
				dEmpList.add(empId + "-->" + hs.get(empId));

			else
				hs.put(empId, empName);
		}
		return dEmpList;
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		String url = "http://automationbykrishna.com/";
		Rohini_Assignment7 Ass7 = new Rohini_Assignment7();
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.id("demotable")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='empmanager']")));


		System.out.println("DepartmentId and count is: " + Ass7.getDeptAndEmployeeCount(driver));


		System.out.println("Unique Department ID from 2nd table " + Ass7.getManagerIDAndEmployeeCount(driver));


		System.out.println("ManagerID having max employees " + Ass7.getManagerIDWithMaxEmployeeCount(driver));


		System.out.println("List of employees having Duplicate entry" + Ass7.getEmployeeIDAndEmployeeNameDuplicates(driver));

		driver.quit();
	}
}

