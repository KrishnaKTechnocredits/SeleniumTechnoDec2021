/* 6. write a method which returns first name of all employee from the first table
	List<String> getAllTheEmployeeFirstName(){
		//code
	}
	
	
7. write a method which return unique last name form the table 1
	LinkedHashSet<String> getAllUniqueLastName(){
		//code
	}
	//table[@id ='table1']/tbody/tr/td[3]
	
	
8. write a methods which returns firstname having username length is more than 6 characters

//table[@id ='table1']/tbody/tr/td[4]
 */
package sagarShrikhande;

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

public class A6_P1_to_3_WebTable {

	List<String> getAllTheEmployeeFirstName(WebDriver driver){
		List<WebElement> ls = driver.findElements(By.xpath("//table[@id ='table1']/tbody/tr/td[2]"));
		List<String> finalList= new ArrayList<String>();
		for(WebElement ele:ls)
			finalList.add(ele.getText());
		return finalList;
	}
	
	Set<String> getAllTheEmployeeUniqueLastName(WebDriver driver){
		List<WebElement> ls = driver.findElements(By.xpath("//table[@id ='table1']/tbody/tr/td[3]"));
		Set<String> hs= new HashSet<String>();
		for(WebElement ele:ls)
			hs.add(ele.getText());
		return hs;
	}
	
	List<String> getAllTheEmployeeUserNameWithLengthCondition(WebDriver driver){
		List<WebElement> ls = driver.findElements(By.xpath("//table[@id ='table1']/tbody/tr/td[4]"));
		List<String> finalList1= new ArrayList<String>();
		for(WebElement ele:ls) {
			if(ele.getText().length() >6)
				finalList1.add(ele.getText());
		}
		return finalList1;
	}
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"I:\\Learning\\Eclipse\\Basic Selenium\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "http://automationbykrishna.com/";
		A6_P1_to_3_WebTable a6p13 = new A6_P1_to_3_WebTable();
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.id("demotable")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id ='table1']")));
		
		System.out.println("############## Program 1 ###############");
		System.out.println("List of First Names of all Employess in Table1: " + a6p13.getAllTheEmployeeFirstName(driver));
		
		System.out.println("############## Program 2 ###############");
		System.out.println("List of unique Last Names of Employess in Table1"+ a6p13.getAllTheEmployeeUniqueLastName(driver));
		
		System.out.println("############## Program 3 ###############");
		System.out.println("List of User Names of  Employess with Length >6" + a6p13.getAllTheEmployeeUserNameWithLengthCondition(driver));
		
		driver.quit();
	}
}
