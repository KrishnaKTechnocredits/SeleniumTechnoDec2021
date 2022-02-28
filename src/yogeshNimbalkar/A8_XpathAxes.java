package yogeshNimbalkar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A8_XpathAxes {

	void getSibiling(WebDriver driver) {
		List<WebElement> siblingList = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[2]/following-sibling::tr/td[2]"));
		for(WebElement element : siblingList) {
			System.out.print(element.getText() + " ");
		}
	}
	
	void getChildOfRow(WebDriver driver, String id) {
		List<WebElement> childList = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[contains(text(),'"+ id +"')]/parent::tr/child::td"));
		for(WebElement element : childList) {
			System.out.print(element.getText() + " ");
		}
	}
	
	void getEmployeeNames(WebDriver driver, String name) {
		List<WebElement> employeeNameList = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[contains(text(),'"+ name +"')]/parent::tr/preceding-sibling::tr/td[3]"));
		for(WebElement element : employeeNameList) {
			String fullname = element.getText();
			String[] empName = fullname.split(" ");
			System.out.print(empName[0] + " ");
		}
	}
	
	int getAllRowsAfterEempId(WebDriver driver, String id) {
		List<WebElement> elementList = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[contains(text(),'" + id +"')]/parent::tr/following::tr"));
		return elementList.size();
	}
	
	int getAllRowsBeforeEmpId(WebDriver driver, String id) {
		List<WebElement> elementList = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[contains(text(),'" + id + "')]/parent::tr/preceding::tr"));
		return elementList.size();
	}
	
	int getCountOfEmpInTable(WebDriver driver) {
		String count = driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[last()]/td[1]")).getText();
		return Integer.parseInt(count);
	}
	
	int getPositionOfEmployee(WebDriver driver, String name) {
		String position = driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr/td[contains(text(),'" + name + "')]/parent::tr/td[1]")).getText();
		return Integer.parseInt(position);
	}
	
	String getNameFromId(WebDriver driver, String id, String name) {
		String empName = driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr/td[contains(text(),'" + id + "')]/ancestor::tr/preceding::tr/td[contains(text(),'" + name + "')]")).getText();
		return empName;
	}
	
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/");
		driver.findElement(By.id("demotable")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='table1']")));
		A8_XpathAxes xpathAxes = new A8_XpathAxes();
		
		//sibling of krishna
		System.out.println("\nSibling of Krishna are : ");
		xpathAxes.getSibiling(driver);
		
		//all the child of row where employee ID is 75589
		String id = "75589";
		System.out.println("\nChild elements of row where emp id 75589 :");
		xpathAxes.getChildOfRow(driver, id);
		
		//all the employee name whoes names comes before Nikhil Patne
		String name = "Nikhil Patne";
		System.out.println("\nEmployee name whoes names comes before Nikhil Patne : ");
		xpathAxes.getEmployeeNames(driver, name);
		
		//all the rows which come after employee id 76113
		id="76113";
		System.out.println("\nAll the rows after id " + id + ": " + xpathAxes.getAllRowsAfterEempId(driver, id));
		
		//all the rows which comes before employee id 76113
		System.out.println("\nAll the rows before id " + id + ": " + xpathAxes.getAllRowsBeforeEmpId(driver, id));
		
		//get count of total employees in teable2
		System.out.println("\nTotal employees in table : " + xpathAxes.getCountOfEmpInTable(driver));
		
		//position of employee 'Chetan Shewale' from table 2
		name = "Chetan Shewale";
		System.out.println("\nPosition of employee " + id + " : " + xpathAxes.getPositionOfEmployee(driver, name));
		
		//using empid 76993 find the reference of Maulik in table1
		id="76993";
		name = "Maulik";
		System.out.println("\nReference Name : " + xpathAxes.getNameFromId(driver, id, name));
		driver.quit();
	}
}
