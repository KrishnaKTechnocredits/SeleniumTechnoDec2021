package saurav;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A6_FirstNameOfEmployeesFromTable {

	List<String> firstNameOfEmployee(WebDriver driver) {
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td[2]"));
		List<String> fName = new ArrayList<String>();
		for (WebElement firstName : list)
			fName.add(firstName.getText());
		return fName;
	}

	Set<String> uniqueSurnameEmployee(WebDriver driver) {
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td[3]"));
		Set<String> unique = new HashSet<String>();
		for (WebElement lName : list)
			unique.add(lName.getText());
		return unique;
	}

	List<String> usernameMoreThan6(WebDriver driver) {
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td[4]"));
		List<String> userName = new ArrayList<String>();
		for (WebElement uName : list) {
			if (uName.getText().length() > 6)
				userName.add(uName.getText());
		}
		return userName;
	}

	Set<String> uniqueManagerId(WebDriver driver) {
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]"));
		Set<String> set = new HashSet<String>();
		for (WebElement managerId : list)
			set.add(managerId.getText());
		return set;
	}

	Set<String> uniqueDept(WebDriver driver) {
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]"));
		Set<String> set = new HashSet<String>();
		for (WebElement managerId : list)
			set.add(managerId.getText());
		return set;
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		A6_FirstNameOfEmployeesFromTable ass6 = new A6_FirstNameOfEmployeesFromTable();
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		driver.findElement(By.id("demotable")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']")));

		System.out.println(ass6.firstNameOfEmployee(driver) + " -- size = " + ass6.firstNameOfEmployee(driver).size());
		System.out.println(
				ass6.uniqueSurnameEmployee(driver) + " -- size = " + ass6.uniqueSurnameEmployee(driver).size());
		System.out.println(ass6.usernameMoreThan6(driver) + " -- size = " + ass6.usernameMoreThan6(driver).size());
		System.out.println(ass6.uniqueManagerId(driver) + " -- size = " + ass6.uniqueManagerId(driver).size());
		System.out.println(ass6.uniqueDept(driver) + " -- size = " + ass6.uniqueDept(driver).size());
	}
}
