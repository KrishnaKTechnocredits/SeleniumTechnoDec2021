package yogeshNimbalkar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A6_EmployeeTable2 {

	Set<String> getUniqueManagerId(WebDriver driver){
		List<WebElement> managerList = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[4]"));
		Set<String> uniqueManagerSet = new HashSet<String>();
		for(WebElement element : managerList) {
			uniqueManagerSet.add(element.getText());
		}
		return uniqueManagerSet;
	}
	
	Set<String> getUniqueDepartmentId(WebDriver driver){
		List<WebElement> departmentList = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[5]"));
		Set<String> uniqueDepartmentSet = new HashSet<>();
		for(WebElement element : departmentList) {
			uniqueDepartmentSet.add(element.getText());
		}
		return uniqueDepartmentSet;
	}
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.linkText("Demo Tables")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='empmanager']")));
		A6_EmployeeTable2 employeeTable2 = new A6_EmployeeTable2();
		
		//find unique manager id from table
		System.out.println("Unique manager ids are : " + employeeTable2.getUniqueManagerId(driver));
		
		//unique department id from table
		System.out.println("Unique department ids are :" + employeeTable2.getUniqueDepartmentId(driver));
		
		driver.quit();
	}
}
