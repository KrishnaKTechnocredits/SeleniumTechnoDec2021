/*Web Tables Question
Assignment - 5: 17th Feb'2022
1. how many employee are there in table1? --> 5
2. how many employee joins company after dhara? --> 2
3. find the first name of user whoes username is 'ppatro' --> priya
4. print all the header of first table -- > # first name last name username
5. print content of all the rows of first table
 */
package shwetaDharmadhikari.assignment5;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import shwetaDharmadhikari.base.PredefinedActions;

public class WebTable_Examples {
	WebDriver driver = PredefinedActions.start();

	void countOfEmployees() {
		// 1. how many employee are there in table1? --> 5
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//a[@id='demotable']")))).click();
		System.out.println("1. Employee Count is : " + driver.findElements(By.xpath("//div[@id='empbasic']//tbody/tr")).size());
	}

	void empCount() {
		// 2. how many employee joins company after dhara? --> 2
		System.out.println("2. Count of employee joins company after dhara is : " + driver.findElements(By.xpath("//table[@id='table1']//tbody/tr[3]//following-sibling::tr/td[2]")).size());
	}

	void printFirstName() {
		// 3. find the first name of user whose username is 'ppatro' --> priya
		System.out.println("3. First name of user whose username is 'ppatro' : "+ driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[5]//td[4]//preceding-sibling::td[2]")).getText());
	}

	List<String> printHeader() {
		// 4. print all the header of first table -- > # first name last name username
		List<WebElement> header = driver.findElements(By.xpath("//table[@id='table1']/thead/tr[1]/th"));
		List<String> output = new ArrayList<String>();
		for (WebElement element : header) {
			output.add(element.getText());
		}
		return output;
	}

	List<String> printContent() {
		// 5. print content of all the rows of first table
		List<WebElement> contentOfRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td"));
		List<String> output = new ArrayList<String>();
		for (WebElement element : contentOfRow) {
			output.add(element.getText());
		}
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebTable_Examples webTable_Examples = new WebTable_Examples();
		webTable_Examples.countOfEmployees();
		webTable_Examples.empCount();
		webTable_Examples.printFirstName();
		System.out.println("4. Header of first table :" + webTable_Examples.printHeader());
		System.out.println("5. Content of all the rows of first table :" + webTable_Examples.printContent());
	}
}
