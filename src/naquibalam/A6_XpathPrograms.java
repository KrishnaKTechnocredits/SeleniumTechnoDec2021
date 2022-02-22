package naquibalam;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class A6_XpathPrograms {

	List<String> getAllTheEmployeeFirstName(WebDriver driver) {
		List<WebElement> allEmployeeFirstName = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
		List<String> allFirstNameString = new ArrayList<String>();
		for (WebElement firstName : allEmployeeFirstName) {
			allFirstNameString.add(firstName.getText());
		}
		return allFirstNameString;
	}
	
	LinkedHashSet<String> getAllUniqueLastName(WebDriver driver){
		List<WebElement> allEmployeeFirstName = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		LinkedHashSet<String> uniqueLastName = new LinkedHashSet<String>();
		for (WebElement firstName : allEmployeeFirstName) {
			uniqueLastName.add(firstName.getText());
		}
		return uniqueLastName;
	}
	
	List<String> getFirstNameSpecific(WebDriver driver) {
		List<WebElement> allEmployeeFirstName = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
		List<String> allFirstNameSpecific = new ArrayList<String>();
		int totalFirstName = allEmployeeFirstName.size();
		for (int i = 1; i <= totalFirstName; i++) {
			if (driver.findElement(By.xpath("(//table[@id='table1']/tbody/tr/td[4])[" + i + "]")).getText().length() > 6) {
				allFirstNameSpecific.add(driver.findElement(By.xpath("(//table[@id='table1']/tbody/tr/td[2])[" + i + "]")).getText());
			}
		}
		return allFirstNameSpecific;
	}
	
	LinkedHashSet<String> getAllUniqueManagerID(WebDriver driver){
		List<WebElement> allManagerIDs = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr/td[4]"));
		LinkedHashSet<String> uniqueManagerIDs = new LinkedHashSet<String>();
		for (WebElement managerIDs : allManagerIDs) {
			uniqueManagerIDs.add(managerIDs.getText());
		}
		return uniqueManagerIDs;
	}
	
	LinkedHashSet<String> getAllUniqueEmpDept(WebDriver driver){
		List<WebElement> allEmpDepts = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr/td[5]"));
		LinkedHashSet<String> uniqueEmpIDs = new LinkedHashSet<String>();
		for (WebElement EmpIDs : allEmpDepts) {
			uniqueEmpIDs.add(EmpIDs.getText());
		}
		return uniqueEmpIDs;
	}
	
	public static void main(String[] args) throws InterruptedException {
		PredefinedActions predifinedActions = new PredefinedActions();
		A6_XpathPrograms a6_XpathPrograms = new A6_XpathPrograms();
		WebDriver driver = predifinedActions.openBrowser("./drivers/chromedriver_98Version.exe", "http://automationbykrishna.com/");
		driver.findElement(By.id("demotable")).click();
		Thread.sleep(2000);
		try {
			System.out.println("***************************************************************************************");
			System.out.println("First name of all the employees : \n" + a6_XpathPrograms.getAllTheEmployeeFirstName(driver));
			System.out.println("***************************************************************************************");
			System.out.println("Unique last name of all the employees : \n" + a6_XpathPrograms.getAllUniqueLastName(driver));
			System.out.println("***************************************************************************************");
			System.out.println("First name having username length more than 6 characters : \n" + a6_XpathPrograms.getFirstNameSpecific(driver));
			System.out.println("***************************************************************************************");
			System.out.println("All unique manager IDs : \n" + a6_XpathPrograms.getAllUniqueManagerID(driver));
			System.out.println("***************************************************************************************");
			System.out.println("All unique employee department : \n" + a6_XpathPrograms.getAllUniqueEmpDept(driver));
			System.out.println("***************************************************************************************");
		} finally {
			predifinedActions.closeDriver(driver);
		}
	}
}
