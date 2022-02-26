package yogeshNimbalkar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A5_EmployeeTable {

	int numberOfEmployees(WebDriver driver) {
		List<WebElement> employeeList = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		return employeeList.size();
	}
	
	int numberOfEmpAfterDhara(WebDriver driver) {
		List<WebElement> employeeList = driver.findElements(By.xpath("//table[@id='table1']//td[text()='Dhara']/parent::tr/following-sibling::tr"));
		return employeeList.size();
	}
	
	String getFirstName (WebDriver driver) {
		String firstName = driver.findElement(By.xpath("//table[@id='table1']//td[text()='ppatro']/preceding-sibling::td[2]")).getText();
		return firstName;
	}
	
	void printHeaderOfTable (WebDriver driver) {
		List<WebElement> headerList = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		for(WebElement element : headerList) {
			System.out.print(element.getText() + " ");
		}
	}
	
	String employeeRecords (WebDriver driver) {
		String records = driver.findElement(By.xpath("//table[@id='table1']/tbody")).getText();
		return records;
	}
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		A5_EmployeeTable employeeTable = new A5_EmployeeTable();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.linkText("Demo Tables")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='table1']")));
		
		//Number of employees in table1
		System.out.println("Total number of employees in Table are : " + employeeTable.numberOfEmployees(driver));
		
		//Number of employees join after Dhara
		System.out.println("Total number of employees join after Dhara : " + employeeTable.numberOfEmpAfterDhara(driver));
		
		//first name of user whose username = ppatro
		System.out.println("First name of user whose username = ppatro : " + employeeTable.getFirstName(driver));
		
		//header of first table
		System.out.println("Table headers are : ");
		employeeTable.printHeaderOfTable(driver);
		
		//print content/ all rows of table
		System.out.println("\nContent of Tables are: \n" + employeeTable.employeeRecords(driver));
		
		driver.quit();
	}
}
