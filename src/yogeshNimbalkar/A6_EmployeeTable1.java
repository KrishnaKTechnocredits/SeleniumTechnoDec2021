package yogeshNimbalkar;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A6_EmployeeTable1 {

	List<String> getAllEmployeeFirstName(WebDriver driver){
		List<WebElement> employeeList = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
		List<String> firstNames = new ArrayList<String>();
		for(WebElement element : employeeList) {
			firstNames.add(element.getText());
		}
		return firstNames;
	}
	
	LinkedHashSet<String> getAllEmployeeUniqueLastName(WebDriver driver){
		List<WebElement> employeeList = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		LinkedHashSet<String> lastName = new LinkedHashSet<String>();
		for(WebElement element : employeeList) {
			lastName.add(element.getText());
		}
		return lastName;
	}
	
	List<String> GetAllFirstName_UNameLenthMoreThan6Char(WebDriver driver){
		List<WebElement> employeeList = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		List<String> firstNames = new ArrayList<String>();
		for(int index=1; index<=employeeList.size(); index++) {
			int usernameLength = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]")).getText().length();  
			if(usernameLength > 6) {
				firstNames.add(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]")).getText());
			}
		}
		return firstNames;
	}
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.linkText("Demo Tables")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='table1']")));
		A6_EmployeeTable1 employeeTable1 = new A6_EmployeeTable1();
		
		//first name of all employee in first table
		System.out.println("First name of all the employees : " + employeeTable1.getAllEmployeeFirstName(driver));
		
		//Get Unique last names from table.
		System.out.println("Unique last naems in table : " + employeeTable1.getAllEmployeeUniqueLastName(driver));
		
		//first name having username length is more than 6 characters
		System.out.println("List of first name having username length more than 6 characters : " + employeeTable1.GetAllFirstName_UNameLenthMoreThan6Char(driver));
		
		driver.quit();
	}
}
