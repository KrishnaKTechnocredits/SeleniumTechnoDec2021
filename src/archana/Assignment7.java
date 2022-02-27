package archana;

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

public class Assignment7 {
	Map<String, Integer> getCountDeptEmp(WebDriver driver) {
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

	Map<String, Integer> getCountOfManagerEmp(WebDriver driver) {
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

	String getCountOfManagerMaxEmp(WebDriver driver) {
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

	List<String> getDuplicatesEmpIDName(WebDriver driver) {
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
				"C:\\Users\\Archana\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "http://automationbykrishna.com/";
		Assignment7 ass7 = new Assignment7();
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.id("demotable")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='empmanager']")));
		System.out.println("-------------------1---------------------");
		System.out.println("DeptId and count is:aa " + ass7.getCountDeptEmp(driver));
		System.out.println("-------------------2---------------------");
		System.out.println("Unique Department IDs from table2 " + ass7.getCountOfManagerEmp(driver));
		System.out.println("-------------------3---------------------");
		System.out.println("Manager ID having max employees " + ass7.getCountOfManagerMaxEmp(driver));
		System.out.println("-------------------4---------------------");
		System.out.println("List of employees with Duplicate entry" + ass7.getDuplicatesEmpIDName(driver));
		driver.quit();
	}
}
