package archana;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment8 {
	void prog1_FindSubling(WebDriver driver) {
		List<WebElement> siblings = driver
				.findElements(By.xpath("//table[@id ='table1']/tbody/tr[2]//following-sibling::tr/td[2]"));
		System.out.println("Sibling of 'Krishna': ");
		for (WebElement sibLing : siblings) {
			System.out.println(sibLing.getText());
		}
	}

	void prog2_ChildRow(WebDriver driver) {
		WebElement ele = driver.findElement(By.xpath("//table[@class ='table table-striped']/tbody/tr[7]"));
		System.out.println("Child of row where employee ID is 75589 in table 2 :");
		System.out.println(ele.getText());

	}

	List<String> prog3_FindEmployeeName(WebDriver driver) {
		List<WebElement> preciding = driver
				.findElements(By.xpath("//table[@class ='table table-striped']//tr[7]//preceding-sibling::tr//td[3]"));
		System.out.println("find all the employee name whose comes before 'Nikhil Patne':");
		List<String> finalList = new ArrayList<String>();
		for (WebElement ele : preciding)
			finalList.add(ele.getText());
		return finalList;

	}

	int prog4_FindRowsAfter(WebDriver driver) {

		List<WebElement> rows = driver
				.findElements(By.xpath("//table[@class ='table table-striped']//tr[4]//following::tr"));
		System.out.println("rows which comes after employee id '76113' from table 2 :");
		return rows.size();

	}

	int prog5_FindRowsBefore(WebDriver driver) {

		List<WebElement> rows = driver
				.findElements(By.xpath("//table[@class ='table table-striped']//tr[4]//preceding::tr"));
		System.out.println("rows which comes before employee id '76113' from table 2 :");
		return rows.size();

	}

	int prog6_TotalEmployee(WebDriver driver) {

		List<WebElement> employee = driver.findElements(By.xpath("//table[@class ='table table-striped']//tr/td[3]"));
		System.out.println("Total employee table 2 :");
		return employee.size();

	}

	int prog7_GetPosition(WebDriver driver) {

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
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Archana\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		Assignment8 ass8 = new Assignment8();

		driver.findElement(By.id("demotable")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id ='table1']")));
		System.out.println("---------------------1----------------------");
		ass8.prog1_FindSubling(driver);
		System.out.println("---------------------2----------------------");
		ass8.prog2_ChildRow(driver);
		System.out.println("---------------------3----------------------");
		System.out.println(ass8.prog3_FindEmployeeName(driver));
		System.out.println("---------------------4----------------------");
		System.out.println(ass8.prog4_FindRowsAfter(driver));
		System.out.println("---------------------5----------------------");
		System.out.println(ass8.prog5_FindRowsBefore(driver));
		System.out.println("---------------------6----------------------");
		System.out.println(ass8.prog6_TotalEmployee(driver));
		System.out.println("---------------------7----------------------");
		System.out.println(ass8.prog7_GetPosition(driver));
		System.out.println("----------------------8----------------------");
		System.out.println(ass8.prog8_GetAncestor(driver));

	}

}
