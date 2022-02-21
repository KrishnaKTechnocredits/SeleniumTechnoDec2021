/*Assignment - 5: 17th Feb'2022

1. how many employee are there in table1? --> 5
2. how many employee joins company after dhara? --> 2
3. find the first name of user whoes username is 'ppatro' --> priya
4. print all the header of first table -- > # first name last name username
5. print content of all the rows of first table
*/

package pallavi;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A5_TableContent {

	// how many employee are there in tabe1
	int totalEmployee(WebDriver driver) {

		List<WebElement> employeeList = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		return employeeList.size();
	}

	// how many employee joins company after dhara?
	int numberOfFollowingRows(WebDriver driver) {
		List<WebElement> followingRowsList = driver.findElements(
				By.xpath("//table[@id='table1']/tbody/tr/td[text()='Dhara']/parent::tr/following-sibling::tr"));
		return followingRowsList.size();
	}

	// find the first name of user whoes username is 'ppatro'
	String precedingText(WebDriver driver) {
		String firstName = driver
				.findElement(By.xpath("//table[@id='table1']/tbody/tr/td[text()='ppatro']/preceding-sibling::td[2]"))
				.getText();
		return firstName;

	}

	// print all the header of first table -- > # first name last name username
	String printHeaders(WebDriver driver) {
		String headers = driver.findElement(By.xpath("//table[@id='table1']//thead/tr")).getText();
		return headers;

	}

	// print content of all the rows of first table

	String printTable(WebDriver driver) {
		String content = driver.findElement(By.xpath("//table[@id='table1']//tbody")).getText();
		return content;

	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("demotable")).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']")));
		A5_TableContent tableContent = new A5_TableContent();

		System.out.println("Total number of employees in Table1= " + tableContent.totalEmployee(driver));
		System.out.println("Number of employees joined after Dhara = " + tableContent.numberOfFollowingRows(driver));
		System.out.println("First name of user whoes username is 'ppatro' = " + tableContent.precedingText(driver));
		System.out.println("All the header of first table = " + tableContent.printHeaders(driver));
		System.out.println("Content of first table : ");
		System.out.println(tableContent.printTable(driver));
		driver.close();

	}

}
