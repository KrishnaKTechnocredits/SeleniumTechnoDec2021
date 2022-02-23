package megha;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Megha_Assignment6 {

	public static void main(String[] args) {

		Megha_Assignment6 megha_Assignment = new Megha_Assignment6();
		PredefinedActions predefinedActions = new PredefinedActions();
		WebDriver driver = predefinedActions.openBrowser("http://automationbykrishna.com");

		driver.findElement(By.linkText("Demo Tables")).click();

		System.out.println("Firstname of all employee from the first table : ");
		System.out.println(megha_Assignment.getAllTheEmployeeFirstName(driver));
		System.out.println();

		System.out.println("Name of all Unique Lastname from the first table : ");
		System.out.println(megha_Assignment.getAllUniqueLastName(driver));
		System.out.println();

		System.out.println("Firstname of Username greater than Six : ");
		System.out.println(megha_Assignment.getAllFirstNameWithUsernameGreaterThanSix(driver));
		System.out.println();

		System.out.println("All Unique Manager IDs from second table : ");
		System.out.println(megha_Assignment.getAllUniqueManagerIds(driver));
		System.out.println();

		System.out.println("All Unique Departments from second table : ");
		System.out.println(megha_Assignment.getAllUniqueDept(driver));

		driver.close();

	}

	List<String> getAllTheEmployeeFirstName(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id ='table1']/tbody/tr/td[2]")));

		List<WebElement> list = driver.findElements(By.xpath("//table[@id ='table1']/tbody/tr/td[2]"));
		List<String> allTheEmployeeFirstName = new ArrayList<String>();
		for (WebElement element : list)
			allTheEmployeeFirstName.add(element.getText());

		return allTheEmployeeFirstName;
	}

	LinkedHashSet<String> getAllUniqueLastName(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id ='table1']/tbody/tr/td[3]")));

		List<WebElement> list = driver.findElements(By.xpath("//table[@id ='table1']/tbody/tr/td[3]"));
		LinkedHashSet<String> allUniqueLastName = new LinkedHashSet<String>();
		for (WebElement element : list)
			allUniqueLastName.add(element.getText());

		return allUniqueLastName;
	}

	List<String> getAllFirstNameWithUsernameGreaterThanSix(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id ='table1']/tbody/tr/td[4]")));

		List<WebElement> list = driver.findElements(By.xpath("//table[@id ='table1']/tbody/tr/td[4]"));
		List<String> allFirstName = new ArrayList<String>();
		for (WebElement element : list)
			if (element.getText().length() > 6)
				allFirstName.add(element.getText());

		return allFirstName;
	}

	LinkedHashSet<String> getAllUniqueManagerIds(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]")));

		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]"));
		LinkedHashSet<String> allUniqueManagerIds = new LinkedHashSet<String>();
		for (WebElement element : list)
			allUniqueManagerIds.add(element.getText());

		return allUniqueManagerIds;
	}

	LinkedHashSet<String> getAllUniqueDept(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]")));

		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]"));
		LinkedHashSet<String> allUniqueDept = new LinkedHashSet<String>();
		for (WebElement element : list)
			allUniqueDept.add(element.getText());

		return allUniqueDept;
	}
}
