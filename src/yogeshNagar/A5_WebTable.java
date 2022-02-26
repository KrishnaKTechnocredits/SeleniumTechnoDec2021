package yogeshNagar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
1. how many employee are there in table1? --> 5
2. how many employee joins company after dhara? --> 2
3. find the first name of user whoes username is 'ppatro' --> priya
4. print all the header of first table -- > # first name last name username
5. print content of all the rows of first table
*/

public class A5_WebTable {
	static WebDriver driver = BaseClass.launchBrowser("http://automationbykrishna.com/");

	void getBrowserInstance() throws InterruptedException {
		driver.findElement(By.id("demotable")).click();
		Thread.sleep(1000);
	}

	void getNumberOfEmployee() throws InterruptedException {
		getBrowserInstance();
		List<WebElement> numberOfEmployee = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		System.out.println("----Programme 1----");
		System.out.println("Number of Employee in Table1 are " + numberOfEmployee.size());
	}

	void getNumberOfEmployeeJoinedAfterDhara() {
		List<WebElement> empCount = driver
				.findElements(By.xpath("//td[text()='Dhara']/parent::tr/following-sibling::tr"));
		System.out.println("----Programme 2----");
		System.out.println("employee joins company after Dhara are " + empCount.size());
	}

	void getEmployeeFirstNameByUserName(String userName) {
		String firstName = driver
				.findElement(By.xpath("//td[text()='" + userName + "']/preceding-sibling::td[position()='2']"))
				.getText();
		System.out.println("----Programme 3----");
		System.out.println("First Name of user on the basis of User Name is " + firstName);
	}

	void getTableHeader() {
		String tableHeader = driver.findElement(By.xpath("//table[@id='table1']/thead")).getText();
		System.out.println("----Programme 4----");
		System.out.println("Table headers are \n" + tableHeader);
	}

	void getContentOfTable() {
		String tableContent = driver.findElement(By.xpath("//table[@id='table1']")).getText();
		System.out.println("----Programme 5----");
		System.out.println("Table content is \n" + tableContent);
	}

	public static void main(String[] args) throws InterruptedException {
		A5_WebTable wbTable = new A5_WebTable();
		wbTable.getNumberOfEmployee();
		wbTable.getNumberOfEmployeeJoinedAfterDhara();
		wbTable.getEmployeeFirstNameByUserName("ppatro");
		wbTable.getTableHeader();
		wbTable.getContentOfTable();
		driver.quit();
	}
}