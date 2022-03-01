package pradeep.A8;

import java.sql.Driver;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pradeep.base.PredefinedActions;

public class Assignment8 {

	// 1. find all sibling of 'Krishna' from the table 1 --> 3(Dhara, Abhishek &
	// Priya)
	static void findSiblingsOfKrishna(WebDriver driver) {
		List<WebElement> krishnaSiblingName = driver
				.findElements(By.xpath("//table[@id='table1']/tbody/tr[2]/following-sibling::tr/td[2]"));
		for (WebElement ele : krishnaSiblingName) {
			System.out.println(ele.getText());
		}
	}

	// 2. find all the child of row where employee ID is 75589 in table 2 ->
	// 5(7,75589,Nikhil Patne,20205,7013-IT)
	static void findChildOfRow(WebDriver driver) {
		List<WebElement> rowChild = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr[7]/child::td"));
		for (WebElement ele : rowChild) {
			System.out.print("\t" + ele.getText());
		}
	}

	// 3. find all the employee name whose comes before 'Nikhil Patne' from table 2 (Pawan,Sumit,Prayag,Sumit, Sumit,Abhijit)
	static void findAllEmployeeNameBeforeNikhil(WebDriver driver) {
		List<WebElement> elements = driver.findElements(
				By.xpath("//table[@class='table table-striped']/tbody/tr[7]/preceding-sibling::tr/td[3]"));
		for (WebElement ele : elements) {
			System.out.print("\t" + ele.getText());
		}
	}

	// 4. find all the rows which comes after employee id '76113' from table 2 -->
	// 15
	static void findAllRowAfterGivenId(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[text()='76113']/following::tr"));
		System.out.println("\n\nthe rows which comes after employee id '76113' from table 2 are:\n  " + elements.size());
	}

	// 5. find all the rows which comes before employee id '76113' from table 2 -->	// 10
	static void findAllRowBeforeGivenId(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[text()='76113']/preceding::tr"));
		System.out.println("\n\nthe rows which comes before employee id '76113' from table 2 are:\n  " + elements.size());
	}
	
	//6. return count total employee in table 2 without using findElements method --> 9 count
	static void findTotalEmployeeWithoutfindElements(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[last()]/td[1]"));
		System.out.println("\n\n Total no of Employee are:\n " + element.getText());
	}
	
	//7. find the position of employee 'Chetan Shewale' from table 2 -> 8
	static void findPositionOfEmployee(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr/td[text()='Chetan Shewale']/preceding-sibling::td[position()=2]"));
		System.out.println("\n\n the position of employee 'Chetan Shewale' from table 2 is:\n " + element.getText());
	}
	
	//8. can we find 'Maulik' from table 1 using reference of '76993' employee id
	static void findMaulikUsingReference(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr/td[text()='76993']/preceding::tr[6]/td[2]"));
		System.out.println("\n\n we can find 'Maulik' from table 1 using reference of '76993' employee id\n "+ element.getText());
	}
	

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/index.html");
		driver.findElement(By.linkText("Demo Tables")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		List<WebElement> rowElement = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='table1']/tbody/tr")));

		// print all siblings of krishna
		System.out.println("All Siblings of Krishna in Table-1 are:");
		findSiblingsOfKrishna(driver);
		// print the child of row where employee ID is 75589
		System.out.println("\n\nthe child of row where employee ID is 75589 in table 2 are:");
		findChildOfRow(driver);
		// print the employee name whose comes before 'Nikhil Patne' from table 2
		System.out.println("\n\nthe employee name whose comes before 'Nikhil Patne' from table 2 are: ");
		findAllEmployeeNameBeforeNikhil(driver);
		// find all the rows which comes after employee id '76113' from table 2
		findAllRowAfterGivenId(driver);
		// find all the rows which comes before employee id '76113' from table 2
		findAllRowBeforeGivenId(driver);
		//return count total employee in table 2 without using findElements method 
		findTotalEmployeeWithoutfindElements(driver);
		// find the position of employee 'Chetan Shewale' from table 2 
		findPositionOfEmployee(driver);
		// we can find 'Maulik' from table 1 using reference of '76993' employee id
		findMaulikUsingReference(driver);
	}
}
