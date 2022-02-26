package tanu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/*6. write a method which returns first name of all employee from the first table
	List<String> getAllTheEmployeeFirstName(){
		//code
	}
7. write a method which return unique last name form the table 1
	LinkedHashSet<String> getAllUniqueLastName(){
		//code
	}
8. write a methods which returns firstname having username length is more than 6 characters

9. write a method which return unique manager ids from table 2 --> 3
10. write a method which returs unique Department from table 2 --> 4
*/
class Assignment6 {

	List<String>getAllTheEmployeeFirstName(WebDriver driver) {
		List<WebElement> table1row = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		List<String> firstName = new ArrayList<String>();
		for (int index = 1; index <= table1row.size(); index++) {
			String table1rowname = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[" + index + "]/td[2]"))
					.getText();
			firstName.add(table1rowname);
		}
		return firstName;
	}
	LinkedHashSet <String> getAllUniqueLastName(WebDriver driver) {
		List<WebElement>Lastname = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		LinkedHashSet<String> UniqueName = new LinkedHashSet<String>();
		for(int index=1; index<=Lastname.size(); index++) {
			 String lastUniqueName= driver.findElement(By.xpath("//table[@id='table1']//tbody/tr["+ index +"]/td[3]")).getText();
			 UniqueName.add(lastUniqueName);
		}
	
     return UniqueName;
	}
	List<String>fistNameHavingLengthmorethansixchar(WebDriver driver){
		List<WebElement>firstname=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		List<String>Maxlenght=new ArrayList<String>();
		for(int index=1; index<=firstname.size();index++) {
			String name = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+ index +"]/td[2]")).getText();
			 if(name.length()>6) {
				 Maxlenght.add(name);
			 }	 	
		}
		return Maxlenght;
	}
	LinkedHashSet <String> getUniqueManagerId(WebDriver driver){
		List<WebElement>uniqueid=driver.findElements(By.xpath("//div[@id='empmanager']//table//tbody//tr/td[4]"));
		LinkedHashSet<String> uniquemanagerid=new LinkedHashSet<String>();
		for(int index=1; index<=uniqueid.size();index++) {
			String id=driver.findElement(By.xpath("//div[@id='empmanager']//table//tbody//tr["+ index+"]/td[4]")).getText();
			uniquemanagerid.add(id);		
		}
		return uniquemanagerid;
	}

	LinkedHashSet <String> getUniqueDepartment(WebDriver driver){
		List<WebElement>Deptid=driver.findElements(By.xpath("//div[@id='empmanager']//table//tbody//tr"));
		LinkedHashSet<String> uniqueDept=new LinkedHashSet<String>();
		for(int index=1; index<=Deptid.size();index++) {
			String id=driver.findElement(By.xpath("//div[@id='empmanager']//table//tbody//tr["+index+"]/td[5]")).getText();
			uniqueDept.add(id);		
		}
		return uniqueDept;
		}
	
	public static void main(String[] args) throws InterruptedException {
		Assignment6 Assignment = new Assignment6();
		System.setProperty("webdriver.chrome.driver", "C:\\java-selenium\\Eclipse\\SeleniumBasics\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		System.out.println("Browser Launched");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.findElement(By.xpath("//a[@id='demotable']")).getText();
		System.out.println("Select DemoTable1");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id ='table1']")));
		driver.findElement(By.xpath("//table[@id='table1']")).click();
		System.out.println("first name of all Employees from the DemoTable");
		System.out.println(Assignment.getAllTheEmployeeFirstName(driver));
	    System.out.println("Employees unique last name from the DemoTable"); 
		System.out.println(Assignment.getAllUniqueLastName(driver));
		System.out.println("Below Employees firstname having username length is more than 6 Characters");
		System.out.println(Assignment.fistNameHavingLengthmorethansixchar(driver));
		System.out.println("Below count of Unique Manager Id from Table 2");
		System.out.println(Assignment.getUniqueManagerId(driver));
		System.out.println("Below count of Unique Department from Table 2");
		System.out.println(Assignment.getUniqueDepartment(driver));

	}
}