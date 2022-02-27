/*Assignment - 6: 17th Feb'2022

6. write a method which returns first name of all employee from the first table
	List<String> getAllTheEmployeeFirstName(){
		//code
	}
7. write a method which return unique last name form the table 1
	LinkedHashSet<String> getAllUniqueLastName(){
		//code
	}
8. write a methods which returns firstname having username length is more than 6 characters

9. write a method which return unique manager ids from table 2 --> 3
10. write a method which returs unique Department from table 2 --> 4
 */
package shwetaDharmadhikari.assignment6;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import shwetaDharmadhikari.base.PredefinedActions;

public class WebTable_Example2 {
	
	List<String> getAllTheEmployeeFirstName(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//a[@id='demotable']")))).click();
		List<WebElement> empFirstName=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
		List<String> employeeNames=new ArrayList<String>();
		for(WebElement element : empFirstName) {
			employeeNames.add(element.getText());
		}
		return employeeNames;
	}
	
	LinkedHashSet<String> getAllUniqueLastName(WebDriver driver){
		List<WebElement> empLastName=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		LinkedHashSet<String> employeeNames=new LinkedHashSet<String>();
		for(WebElement element : empLastName) {
			employeeNames.add(element.getText());
		}
		return employeeNames;
	}
	
	List<String> getFirstNameOfEmployees(WebDriver driver) {
			List<WebElement> allEmployeeFirstName = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
			List<String> allFirstName = new ArrayList<String>();
			int totalFirstName = allEmployeeFirstName.size();
			for (int i = 1; i <= totalFirstName; i++) {
				if (driver.findElement(By.xpath("(//table[@id='table1']/tbody/tr/td[4])[" + i + "]")).getText().length() > 6) {
					allFirstName.add(driver.findElement(By.xpath("(//table[@id='table1']/tbody/tr/td[2])[" + i + "]")).getText());
				}
			}
			return allFirstName;
	}
	
	LinkedHashSet<String> getAllUniqueManagerIds(WebDriver driver){
		List<WebElement> managerIds=driver.findElements(By.xpath("//div[@id='empmanager']/section/div/table/tbody/tr/following-sibling::tr/td[4]"));
		LinkedHashSet<String> ids=new LinkedHashSet<String>();
		for(WebElement element : managerIds) {
			ids.add(element.getText());
		}
		System.out.println("4. Count of unique manager ids are : "+ids.size());
		return ids;
	}
	
	LinkedHashSet<String> getAllUniqueEmpDepartment(WebDriver driver){
		List<WebElement> empDepartments=driver.findElements(By.xpath("//div[@id='empmanager']/section/div/table/tbody/tr/following-sibling::tr/td[5]"));
		LinkedHashSet<String> departmentNames = new LinkedHashSet<String>();
		for(WebElement element : empDepartments) {
			departmentNames.add(element.getText());
		}
		System.out.println("5. Count of unique departments are : "+departmentNames.size());
		return departmentNames;
	}
	
	public static void main(String[] args) {
		WebTable_Example2 webTable_Example2 = new WebTable_Example2();
		WebDriver driver = PredefinedActions.start();
		System.out.println("1. FirstName Of all Employee : "+webTable_Example2.getAllTheEmployeeFirstName(driver));
		System.out.println("2. Unique Last Name Of Employee : "+webTable_Example2.getAllUniqueLastName(driver));
		System.out.println("3. First Name of Employee's whose username length is more than 6 characters : "+webTable_Example2.getFirstNameOfEmployees(driver));
		System.out.println("Unique Manager ID's : "+webTable_Example2.getAllUniqueManagerIds(driver));
		System.out.println("Unique departments are : "+webTable_Example2.getAllUniqueEmpDepartment(driver));
		driver.close();
	}
	
}
