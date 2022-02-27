package monikaArkade;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment8 {
	void FindSubling(WebDriver driver) {
		List<WebElement> siblings = driver
				.findElements(By.xpath("//table[@id ='table1']/tbody/tr[2]//following-sibling::tr/td[2]"));
		System.out.println("Sibling of 'Krishna': ");
		for (WebElement sibLing : siblings) {
			System.out.println(sibLing.getText());
		}
	}

	void ChildRow(WebDriver driver) {
		WebElement ele = driver.findElement(By.xpath("//table[@class ='table table-striped']/tbody/tr[7]"));
		System.out.println("Child of row where employee ID is 75589 in table 2 :");
		System.out.println(ele.getText());
	}

	List<String> FindEmployeeName(WebDriver driver) {
		List<WebElement> preciding = driver
				.findElements(By.xpath("//table[@class ='table table-striped']//tr[7]//preceding-sibling::tr//td[3]"));
		System.out.println("find all the employee name whose comes before 'Nikhil Patne':");
		List<String> finalList = new ArrayList<String>();
		for (WebElement ele : preciding)
			finalList.add(ele.getText());
		return finalList;
	}

	int FindRowsAfter(WebDriver driver) {
		List<WebElement> rows = driver
				.findElements(By.xpath("//table[@class ='table table-striped']//tr[4]//following::tr"));
		System.out.println("rows which comes after employee id '76113' from table 2 :");
		return rows.size();
	}

	int FindRowsBefore(WebDriver driver) {
		List<WebElement> rows = driver
				.findElements(By.xpath("//table[@class ='table table-striped']//tr[4]//preceding::tr"));
		System.out.println("rows which comes before employee id '76113' from table 2 :");
		return rows.size();
	}

	int TotalEmployee(WebDriver driver) {
		List<WebElement> employee = driver.findElements(By.xpath("//table[@class ='table table-striped']//tr/td[3]"));
		System.out.println("Total employee table 2 :");
		return employee.size();
	}

	int GetPosition(WebDriver driver) {
		int count = 0;
		List<WebElement> position = driver.findElements(By.xpath("//table[@class ='table table-striped']//tr//td[3]"));
		System.out.println("Get position of 'Chetan Shewale' :");
		List<String> finalList = new ArrayList<String>();
		for (WebElement ele : position)
			if (ele.getText().equals("Chetan Shewale")) {
				count++;
				break;
			} else {
				count++;
			}
		return count;
	}

	String prog8_GetAncestor(WebDriver driver) {
		WebElement name = driver.findElement(By.xpath(
				"//table[@class ='table table-striped']//tr[1]//td[2]//ancestor::div[@id='indexBody']//table[@id ='table1']//preceding-sibling::tr[1]//td[2]"));
		System.out.println("can we find 'Maulik' from table 1 using reference of '76993' employee id ? :");
		return name.getText();
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		Assignment8 ass8 = new Assignment8();

		driver.findElement(By.id("demotable")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id ='table1']")));
		System.out.println("*************-CASE1-*************");
		ass8.FindSubling(driver);
		System.out.println("*************-CASE2-*************");
		ass8.ChildRow(driver);
		System.out.println("*************-CASE3-*************");
		System.out.println(ass8.FindEmployeeName(driver));
		System.out.println("*************-CASE4-*************");
		System.out.println(ass8.FindRowsAfter(driver));
		System.out.println("*************-CASE5-*************");
		System.out.println(ass8.FindRowsBefore(driver));
		System.out.println("*************-CASE6-*************");
		System.out.println(ass8.TotalEmployee(driver));
		System.out.println("*************-CASE7-*************");
		System.out.println(ass8.GetPosition(driver));
		System.out.println("*************CASE8*************");
		System.out.println(ass8.prog8_GetAncestor(driver));

	}
}
