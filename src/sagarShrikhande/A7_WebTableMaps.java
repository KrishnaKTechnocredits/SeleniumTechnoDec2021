package sagarShrikhande;

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

public class A7_WebTableMaps {

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

	List<String> getEmployeeIDAndEmployeeNameDuplicates(WebDriver driver) {
		Map<String, String> hs = new HashMap<String, String>();
		List<WebElement> ls = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr/td[2]"));
		List<String> dupEmpList = new ArrayList<String>();
		for (int i = 1; i <= ls.size(); i++) {
			String empId = driver.findElement(By.xpath("//div[@id='empmanager']//table/tbody/tr[" + i + "]/td[2]"))
					.getText();
			String empName = driver.findElement(By.xpath("//div[@id='empmanager']//table/tbody/tr[" + i + "]/td[3]"))
					.getText();
			if (hs.containsKey(empId))
				dupEmpList.add(empId + "-->" + hs.get(empId));

			else
				hs.put(empId, empName);
		}
		return dupEmpList;
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"I:\\Learning\\Eclipse\\Basic Selenium\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "http://automationbykrishna.com/";
		A7_WebTableMaps a7 = new A7_WebTableMaps();
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.id("demotable")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='empmanager']")));

		System.out.println("############## Program 1 ###############");
		System.out.println("DeptId and count is:aa " + a7.getDeptAndEmployeeCount(driver));

		System.out.println("############## Program 2 ###############");
		System.out.println("Unique Department IDs from table2 " + a7.getManagerIDAndEmployeeCount(driver));

		System.out.println("############## Program 3 ###############");
		System.out.println("Manager ID having max employees " + a7.getManagerIDWithMaxEmployeeCount(driver));

		System.out.println("############## Program 4 ###############");
		System.out
				.println("List of employees with Duplicate entry" + a7.getEmployeeIDAndEmployeeNameDuplicates(driver));

		driver.quit();
	}

}
