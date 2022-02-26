package monikaArkade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment7_P3 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("demotable")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='empmanager']")));
		
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
		System.out.println(managerWithMaxEmployees + "--->" + maxCount);
	}
}
