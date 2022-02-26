/*
Assignment - 6: 20th Feb'2022

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
package anjali.assignment6;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import anjali.base.PredefinedActions;

public class A6_P1 {

	// 6 write a method which returns first name of all employee from the first table

	static List<String> getAllTheEmployeeFirstName() {
		
		List<String> list = new ArrayList<String>();
		
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		List<WebElement> allemployeeWithfirstName = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='table1']/tbody/tr/td[2]")));
	    for (WebElement element : allemployeeWithfirstName)
			list.add(element.getText());

		driver.close();
		
		return list;
	}

	// 7 write a method which return unique last name form the table 1

	static LinkedHashSet<String> getAllUniqueLastName() {
		
		LinkedHashSet<String> linkhashset = new LinkedHashSet<String>();
		
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		
        WebDriverWait wait = new WebDriverWait(driver, 10);
		List<WebElement> eachRowEachElement = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='table1']/tbody/tr/td[3]")));
		for (WebElement element : eachRowEachElement)
			linkhashset.add(element.getText());

		driver.close();
		
		return linkhashset;
	}

	// write a methods which returns firstname having username length is more than 6 characters

	static List<String> getAllTheEmployeeFirstNameWithLengthGreaterThan6() {

		List<String> firstName = new ArrayList<String>();

		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/#");

		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr"));

		for (int i = 1; i <= rows.size(); i++) {
			String userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']//tbody/tr[" + i + "]/td[4]"))).getText();
			if (userName.length() > 6) {
				String str = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']//tbody/tr[" + i + "]/td[2]"))).getText();
				firstName.add(str);
			}
		}

		driver.close();
		return firstName;
	}

	// 9 write a method which return unique manager ids from table 2 --> 3

	static LinkedHashSet<String> getAllUniqueManegerId() {
		
		LinkedHashSet<String> linkhashset = new LinkedHashSet<String>();
		
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		List<WebElement> eachRowEachElement = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]")));
		for (WebElement element : eachRowEachElement)
			linkhashset.add(element.getText());

		driver.close();
		
		return linkhashset;
	}

	// 10. write a method which returns unique Department from table 2 --> 4

	static LinkedHashSet<String> getAllUniqueDepartment() {
		
		LinkedHashSet<String> linkhashset = new LinkedHashSet<String>();
		
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		
        WebDriverWait wait = new WebDriverWait(driver, 10);
		List<WebElement> eachRowEachElement = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]")));
		for (WebElement element : eachRowEachElement)
			linkhashset.add(element.getText());

		driver.close();
		
		return linkhashset;
	}

	public static void main(String[] args) {
		
		List<String> firstName = getAllTheEmployeeFirstName();
		System.out.println(firstName);
		  
		LinkedHashSet<String> uniqueLastName = getAllUniqueLastName();
		System.out.println(uniqueLastName);
		 

		List<String> NameWithlastnameLengthGreaterThan6 = getAllTheEmployeeFirstNameWithLengthGreaterThan6();
		System.out.println(NameWithlastnameLengthGreaterThan6);

		LinkedHashSet<String> uniqueManagerId = getAllUniqueManegerId();
		System.out.println(uniqueManagerId);
		  
		LinkedHashSet<String> uniqueDepartment = getAllUniqueDepartment();
		System.out.println(uniqueDepartment);
		 

	}

}
