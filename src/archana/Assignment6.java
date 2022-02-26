package archana;

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

public class Assignment6 {
	List<String> getEmployeeFirstName(WebDriver driver) {
		List<WebElement> ls = driver.findElements(By.xpath("//table[@id ='table1']/tbody/tr/td[2]"));
		List<String> finalList = new ArrayList<String>();
		for (WebElement ele : ls)
			finalList.add(ele.getText());
		return finalList;
	}

	Set<String> getEmployeeUniqueLastName(WebDriver driver) {
		List<WebElement> ls = driver.findElements(By.xpath("//table[@id ='table1']/tbody/tr/td[3]"));
		Set<String> hs = new HashSet<String>();
		for (WebElement ele : ls)
			hs.add(ele.getText());
		return hs;
	}

	List<String> getEmployeeUserNameWithLengthCondition(WebDriver driver) {
		List<WebElement> ls = driver.findElements(By.xpath("//table[@id ='table1']/tbody/tr/td[4]"));
		List<String> finalList = new ArrayList<String>();
		List<String> finalList1 = new ArrayList<String>();
		for (WebElement ele : ls) {
			if (ele.getText().length() > 6)
				finalList.add(ele.getText());
			finalList1.add(ele.getText());
		}
		return finalList;

	}

	Set<String> getUniqueManager(WebDriver driver) {
		List<WebElement> ls = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr/td[4]"));
		Set<String> hs = new HashSet<String>();
		for (WebElement ele : ls)
			hs.add(ele.getText());
		for (WebElement element : ls)
			hs.add(element.getText());
		return hs;
	}

	Set<String> getUniqueDepartment(WebDriver driver) {
		List<WebElement> ls = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr/td[5]"));
		Set<String> hs = new HashSet<String>();
		for (WebElement ele : ls)
			hs.add(ele.getText());
		for (WebElement element : ls)
			hs.add(element.getText());
		return hs;
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Archana\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "http://automationbykrishna.com/";
		Assignment6 ass6 = new Assignment6();
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.id("demotable")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id ='table1']")));

		System.out.println("-----------------1------------------");
		System.out.println("First Names of all Employess in Table1: " + ass6.getEmployeeFirstName(driver));

		System.out.println("-----------------2-------------------");
		System.out.println("unique Last Names of Employess in Table1" + ass6.getEmployeeUniqueLastName(driver));

		System.out.println("-----------------3-------------------");
		System.out.println("Names of  Employess with Length >6" + ass6.getEmployeeUserNameWithLengthCondition(driver));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='empmanager']")));

		System.out.println("------------------4--------------------");
		System.out.println("Unique Manager table2 :" + ass6.getUniqueManager(driver));

		System.out.println("-------------------5---------------------");
		System.out.println("Unique Department from table2 :" + ass6.getUniqueDepartment(driver));

		driver.quit();

	}

}
