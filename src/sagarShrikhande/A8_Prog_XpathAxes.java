/* Assignment - 8: 21th Feb'2022
Xpath-Axes assignment for tmrw

1. find all sibling of 'Krishna' from the table 1 --> 3(Dhara, Abhishek & Priya)
2. find all the child of row where employee ID is 75589 in table 2 -> 5(7,75589,Nikhil Patne,20205,7013-IT)
3. find all the employee name whose comes before 'Nikhil Patne' from table 2 -> (Pawan,Sumit,Prayag,Sumit, Sumit,Abhijit)
4. find all the rows which comes after employee id '76113' from table 2 --> 15
5. find all the rows which comes before employee id '76113' from table 2 --> 10
6. return count total employee in table 2 without using findElements method --> 9 count
7. find the position of employee 'Chetan Shewale' from table 2 -> 8+
8. can we find 'Maulik' from table 1 using reference of '76993' employee id
	Hint: yes, we have to use ancestor and preceding-sibling (think on this)
*/

package sagarShrikhande;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import technocredits.base.PredefinedActions;

public class A8_Prog_XpathAxes {
	
	List<String> findFollowingSibling(WebDriver driver) {
		List<WebElement> ls = driver
				.findElements(By.xpath("//table[@id='table1']/tbody/tr[2]//parent::tr//following-sibling::tr/td[2]"));
		List<String> list = new ArrayList<String>();
		for (WebElement ele : ls) {
			list.add(ele.getText());
		}
		return list;
	}

	List<String> findChildFromWebElement(WebDriver driver, String id) {
		List<WebElement> ls = driver.findElements(
				By.xpath("//div[@id='empmanager']//table/tbody/tr/td[contains(text(),'"+id+"')]/parent::tr/child::td"));
		List<String> list = new ArrayList<String>();
		for (WebElement ele : ls) {
			list.add(ele.getText());
		}
		return list;
	}
	
	List<String> findEmployeeNamesBeforeGivenEmployeeName(WebDriver driver, String name){
		List<WebElement> ls = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr/td[contains(text(),"+name+"]//parent::tr//preceding-sibling::tr/td[3]"));
		List<String> names= new ArrayList<String>();
		for(WebElement ele:ls)
			names.add(ele.getText());
		return names;	
	}
	
	int getRowCountAfterElement(WebDriver driver, String id) {
		List<WebElement> ls = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr/td[contains(text(),'"+id+"')]//parent::tr//following::tr"));
		return ls.size();
	}
	
	int getRowCountBeforeElement(WebDriver driver, String id) {
		List<WebElement> ls = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr/td[contains(text(),'"+id+"')]//parent::tr//preceding::tr"));
		return ls.size();
	}
	
	int getCountInTable(WebDriver driver) {
		String num = driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[last()]/td[1]")).getText();
		int count = Integer.parseInt(num);
		return count;
	}
	
	int getPositionOfParticularelement(WebDriver driver, String name) {
		List<WebElement> ls = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr/td[3]"));
		List<String> nameList = new ArrayList<String>(); 
		for(WebElement el:ls)
			nameList.add(el.getText());
		int index = nameList.indexOf(name)+1;
		return index;
	}
	
	String getElementUsingReferenceOfAnother(WebDriver driver, String refId, String element) {
		String name =driver.findElement(By.xpath("//div[@id='empmanager']//table/tbody/tr/td[contains(text(),'"+refId+"')]//ancestor::tr/preceding::tr/td[contains(text(),'"+element+"')]")).getText();
		return name;
	}

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/");
		driver.findElement(By.id("demotable")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='empmanager']")));
		A8_Prog_XpathAxes a8p = new A8_Prog_XpathAxes();
		
		System.out.println("############## Program 1 ###############");
		System.out.println("List of Following Sibling of Eement: "+a8p.findFollowingSibling(driver)); 
		
		String id = "75589";
	    System.out.println("############## Program 2 ###############");
		System.out.println(a8p.findChildFromWebElement(driver,id).size()+" "+a8p.findChildFromWebElement(driver,id));
		
		System.out.println("############## Program 3 ###############");
		String name = "Nikhil Patne";
		System.out.println("All Employee names before "+name+" is: "+a8p.findChildFromWebElement(driver,name));
		
		System.out.println("############## Program 4 ###############");
		id = "76113";
		System.out.println("Number of elements after "+id+" is: "+a8p.getRowCountAfterElement(driver,id));
		
		System.out.println("############## Program 5 ###############");
		id = "76113";
		System.out.println("Number of elements before "+id+" is: "+a8p.getRowCountBeforeElement(driver,id));
		
		System.out.println("############## Program 6 ###############");
		System.out.println("Count of employees in Table2 is: "+a8p.getCountInTable(driver));
		
		System.out.println("############## Program 7 ###############");
		name = "Chetan Shewale";
		System.out.println("Get Position of Employee "+name+" in table: "+a8p.getPositionOfParticularelement(driver,name));
		
		System.out.println("############## Program 8 ###############");
		id = "76113";
		name ="Maulik";
		System.out.println("Elment identified: "+a8p.getElementUsingReferenceOfAnother(driver,id, name));
		
		driver.quit();
	}
}
