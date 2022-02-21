/*
1. how many employee are there in table1? --> 5
2. how many employee joins company after dhara? --> 2
3. find the first name of user whose username is 'ppatro' --> priya
4. print all the header of first table -- > # first name last name username
5. print content of all the rows of first table
*/

package sagarShrikhande;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A5_WebTableOps {

	/* ######################## PROGRAM_1 ############################### */
	int countNoOfRowsInTable(WebDriver driver) { // prog#1
		List<WebElement> ls = driver.findElements(By.xpath("//table[@id ='table1']/tbody/tr"));
		return ls.size();
	}

	/* ######################## PROGRAM_2 ############################### */
	int countFollowingNodes(WebDriver driver) {
		List<WebElement> ls = driver.findElements(
				By.xpath("//table[@id ='table1']/tbody/tr/td[text()='Dhara']//parent::tr//following-sibling::tr"));
		return ls.size();
	}

	/* ######################## PROGRAM_3 ############################### */
	String getNameFromTable(WebDriver driver) {
		String str = driver
				.findElement(By.xpath("//table[@id ='table1']/tbody/tr/td[text()='ppatro']//parent::tr/td[2]"))
				.getText();
		return str;
	}

	/* ######################## PROGRAM_4 ############################### */
	List<String> printHeader(WebDriver driver) {
		List<WebElement> ls = driver.findElements(By.xpath("//table[@id ='table1']/thead/tr"));
		List<String> finalList = new ArrayList<String>();
		for (WebElement ele : ls)
			finalList.add(ele.getText());
		return finalList;
	}

	/* ######################## PROGRAM_5 ############################### */
	String printDataOfWebTable(WebDriver driver) {
		String str = driver.findElement(By.xpath("//table[@id ='table1']/tbody")).getText();
		return str;
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"I:\\Learning\\Eclipse\\Basic Selenium\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "http://automationbykrishna.com/";
		A5_WebTableOps a5p1 = new A5_WebTableOps();
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.id("demotable")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id ='table1']")));
		
		System.out.println("############## Program 1 ###############");
		System.out.println("Total Number of Employees are: " + a5p1.countNoOfRowsInTable(driver));
		
		System.out.println("############## Program 2 ###############");
		System.out.println("Number of Employees joined after Dhara is: " + a5p1.countFollowingNodes(driver));
		
		System.out.println("############## Program 3 ###############");
		System.out.println("Name of Employee whose username ppatro is:" + a5p1.getNameFromTable(driver));
		
		System.out.println("############## Program 4 ###############");
		System.out.println("Column Headers are: " + a5p1.printHeader(driver));
		
		System.out.println("############## Program 5 ###############");
		System.out.println("Table1 data is : " + a5p1.printDataOfWebTable(driver));
		driver.quit();
	}
}
