package yogeshNagar;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*Assignment - 6: 20th Feb'2022

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

public class A6_WebTable {
	static WebDriver driver = BaseClass.launchBrowser("http://automationbykrishna.com/");

	List<String> getAllTheEmployeeFirstName() throws InterruptedException {
		driver.findElement(By.id("demotable")).click();
		Thread.sleep(1000);
		List<WebElement> employeeName = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		List<String> employeeFirstNameList = new ArrayList<String>();
		for (int index = 1; index <= employeeName.size(); index++) {
			String listEmployeeFirstName = driver
					.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]")).getText();
			employeeFirstNameList.add(listEmployeeFirstName);
		}
		System.out.println("----Programme 6 ----");
		System.out.println("All Employe First Name in Table1 are");
		return employeeFirstNameList;
	}

	LinkedHashSet<String> getAllUniqueLastName() {
		List<WebElement> employeeLastName = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		LinkedHashSet<String> employeeLastNameList = new LinkedHashSet<String>();
		for (int index = 1; index <= employeeLastName.size(); index++) {
			String listEmployeeFirstName = driver
					.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]")).getText();
			employeeLastNameList.add(listEmployeeFirstName);
		}
		System.out.println("----Programme 7 ----");
		System.out.println("All Employe Last Name in Table1 are");
		return employeeLastNameList;
	}

	List<String> getUserNameGraterThen6() throws InterruptedException {
		List<WebElement> employeeUserName = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		List<String> employeeFirstNameList = new ArrayList<String>();
		for (int index = 1; index <= employeeUserName.size(); index++) {
			String listEmployeeUserName = driver
					.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]")).getText();
			if (listEmployeeUserName.length() > 6) {
				String listEmployeefirstName = driver
						.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]")).getText();
				employeeFirstNameList.add(listEmployeefirstName);
			}
		}
		System.out.println("----Programme 8 ----");
		System.out.println("All Employe First Name in Table1 whose User Name grater then 6 are");
		return employeeFirstNameList;
	}

	LinkedHashSet<String> getUniqueManagerID() {
		List<WebElement> managerId = driver
				.findElements(By.xpath("//table[contains(@class,'table-striped')]/tbody/tr"));
		LinkedHashSet<String> uniqueManagerID = new LinkedHashSet<String>();
		for (int index = 0; index < managerId.size(); index++) {
			String employeeManagerID = driver
					.findElement(
							By.xpath("//table[contains(@class,'table-striped')]/tbody/tr[" + (index + 1) + "]/td[4]"))
					.getText();
			uniqueManagerID.add(employeeManagerID);
		}
		System.out.println("----Programme 9 ----");
		System.out.println("Unique Manager ID in Table2 are");
		return uniqueManagerID;
	}

	LinkedHashSet<String> getUniqueDepartmentName() {
		List<WebElement> departmentName = driver
				.findElements(By.xpath("//table[contains(@class,'table-striped')]/tbody/tr"));
		LinkedHashSet<String> uniqueDepartmentID = new LinkedHashSet<String>();
		for (int index = 0; index < departmentName.size(); index++) {
			String employeeDepartmentName = driver
					.findElement(
							By.xpath("//table[contains(@class,'table-striped')]/tbody/tr[" + (index + 1) + "]/td[5]"))
					.getText();
			uniqueDepartmentID.add(employeeDepartmentName);
		}
		System.out.println("----Programme 10 ----");
		System.out.println("Unique Department ID in Table2 are");
		return uniqueDepartmentID;
	}

	public static void main(String[] args) throws InterruptedException {
		A6_WebTable wbTable = new A6_WebTable();
		System.out.println(wbTable.getAllTheEmployeeFirstName());
		System.out.println(wbTable.getAllUniqueLastName());
		System.out.println(wbTable.getUserNameGraterThen6());
		System.out.println(wbTable.getUniqueManagerID());
		System.out.println(wbTable.getUniqueDepartmentName());
		driver.quit();
	}
}
