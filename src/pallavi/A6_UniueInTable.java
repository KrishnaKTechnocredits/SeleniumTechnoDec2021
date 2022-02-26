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

package pallavi;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A6_UniueInTable {

	// write a method which returns first name of all employee from the first table
	List getAllTheEmployeeFirstName(WebDriver driver) {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr"));
		List<String> firstName = new ArrayList<String>();
		for (int i = 1; i <= rows.size(); i++) {
			String str = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[" + i + "]/td[2]")).getText();
			firstName.add(str);
		}
		return firstName;
	}

	// write a method which return unique last name form the table 1
	LinkedHashSet<String> getAllUniqueLastName(WebDriver driver) {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr"));
		LinkedHashSet<String> lastName = new LinkedHashSet<String>();
		for (int i = 1; i <= rows.size(); i++) {
			String str = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[" + i + "]/td[3]")).getText();
			lastName.add(str);
		}
		return lastName;
	}

	// write a methods which returns firstname having username length is more than 6
	// characters

	List getEmployeeFirstNameByUserName(WebDriver driver) {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr"));
		List<String> firstName = new ArrayList<String>();
		for (int i = 1; i <= rows.size(); i++) {
			String userName = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[" + i + "]/td[4]"))
					.getText();
			if (userName.length() > 6) {
				String str = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[" + i + "]/td[2]")).getText();
				firstName.add(str);
			}
		}
		return firstName;
	}

	// write a method which return unique manager ids from table 2
	LinkedHashSet getManagerID(WebDriver driver) {
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr"));
		LinkedHashSet<Integer> managerID = new LinkedHashSet<Integer>();
		for (int i = 1; i <= rows.size(); i++) {
			String mngrID = driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + i + "]/td[4]"))
					.getText();
			managerID.add(Integer.parseInt(mngrID));
		}
		return managerID;
	}

	// write a method which returs unique Department from table 2
	LinkedHashSet getUniqueDeptID(WebDriver driver) {
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr"));
		LinkedHashSet<String> deptID = new LinkedHashSet<String>();
		for (int i = 1; i <= rows.size(); i++) {
			String departmentID = driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + i + "]/td[5]"))
					.getText();
			deptID.add(departmentID);
		}
		return deptID;
	}

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("demotable")).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//table[@id='table1']//tbody/tr"), 1));

		A6_UniueInTable uniqueInTable = new A6_UniueInTable();
		System.out.println("First name of all employee from the first table:");
		System.out.println(uniqueInTable.getAllTheEmployeeFirstName(driver));
		System.out.println();

		System.out.println("Unique last names of employees from the first table:");
		System.out.println(uniqueInTable.getAllUniqueLastName(driver));
		System.out.println();

		System.out.println("First name of all employee having username > 6 charaters:");
		System.out.println(uniqueInTable.getEmployeeFirstNameByUserName(driver));
		System.out.println();

		System.out.println("Unique manager ids from table 2:");
		System.out.println(uniqueInTable.getManagerID(driver));
		System.out.println();

		System.out.println("Unique department ids from table 2:");
		System.out.println(uniqueInTable.getUniqueDeptID(driver));
		driver.close();
	}
}
