package rohini;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* Assignment - 5: 20th Feb'2022 */

public class Rohini_Assignment5 {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		//1. how many employee are there in table1? --> 5
		
		List<WebElement> list= driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		System.out.println(list.size());
//		for(WebElement ele:list) {
//			System.out.println(ele.getText());
//		}
//		//2. how many employee joins company after dhara? --> 2
		List<WebElement> list1= driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[text()='Dhara']/parent::tr/following-sibling::tr"));
		System.out.println(list1.size());
		
		//3. find the first name of user whoes username is 'ppatro' --> priya
		WebElement name= driver.findElement(By.xpath("//table[@id='table1']/tbody/tr/td[text()='ppatro']/preceding-sibling::td[2]"));
				//driver.findElement(By.xpath("//table[@id='table1']/tbody/tr/td[text()='ppatro']/parent::tr/td[2]"));
		System.out.println(name.getText());
		
		//4. print all the header of first table -- > # first name last name username
		
		List<WebElement> list2= driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		System.out.println(list2.size());
		
		for(int i=1;i<=list2.size();i++) {
			String str=driver.findElement(By.xpath("//table[@id='table1']/thead/tr/th["+i+"]")).getText();
			System.out.println(str);
		}
		
		//5. print content of all the rows of first table
		List<WebElement> row= driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		List<WebElement> col= driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));
		
		
		for(int i=1;i<=row.size();i++) {
			for(int j=1;j<=col.size();j++) {
			String str1=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]")).getText();
			System.out.println(str1);
			}
		}
	
		
	}

}
