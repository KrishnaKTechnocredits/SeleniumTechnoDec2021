/* 9. write a method which return unique manager ids from table 2 --> 3
10. write a method which return unique Department from table 2 --> 4 
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

public class A6_P4_and_P5_WebTable {

	Set<String> getUniqueManagerIds(WebDriver driver){
		List<WebElement> ls = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr/td[4]"));
		Set<String> hs= new HashSet<String>();
		for(WebElement element:ls)
			hs.add(element.getText());
		return hs;
	}
	
	Set<String> getUniqueDepartmentIds(WebDriver driver){
		List<WebElement> ls = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr/td[5]"));
		Set<String> hs= new HashSet<String>();
		for(WebElement element:ls)
			hs.add(element.getText());
		return hs;
	}
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"I:\\Learning\\Eclipse\\Basic Selenium\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "http://automationbykrishna.com/";
		A6_P4_and_P5_WebTable a6p45 = new A6_P4_and_P5_WebTable();
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.id("demotable")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='empmanager']")));
		
		System.out.println("############## Program 4 ###############");
		System.out.println("Unique Manager IDs from table2 " + a6p45.getUniqueManagerIds(driver));
		
		System.out.println("############## Program 5 ###############");
		System.out.println("Unique Department IDs from table2 " + a6p45.getUniqueDepartmentIds(driver));
		
		driver.quit();
	}
}
