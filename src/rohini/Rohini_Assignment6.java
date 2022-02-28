package rohini;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Rohini_Assignment6 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("http://automationbykrishna.com/");

		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		/*6. write a method which returns first name of all employee from the first table*/

		driver.findElement(By.xpath("//a[@id='demotable']"));
		List<WebElement> list=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		System.out.println(list.size());

		for(int i=1;i<=list.size();i++) {
			String names=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println("First Name is:"+names);

		}

		/*7. write a method which return unique last name form the table 1*/
		driver.findElement(By.xpath("//a[@id='demotable']"));
		List<WebElement> hmp=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		System.out.println(hmp.size());

		Set<String> hs=new LinkedHashSet<String>();

		for(WebElement ele:hmp) {
			hs.add(ele.getText());

		}System.out.println("Lst Name: "+hs);


		//8. write a methods which returns firstname having username length is more than 6 characters
		driver.findElement(By.xpath("//a[@id='demotable']"));

		List<WebElement> list2=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));

		for(WebElement ele:list2) {
			if(ele.getText().length()>6) {
				List<WebElement> list1=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
				System.out.println(ele.getText());
			}
		}

		//9. write a method which return unique manager ids from table 2 --> 3

		List<WebElement> ls = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr/td[4]"));
		Set<String> hs1= new HashSet<String>();
		for(WebElement ele2:ls) {
			hs1.add(ele2.getText());

		}	System.out.println(hs1);


		//10. write a method which returns unique Department from table 2 --> 4

		List<WebElement> ls1 = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr/td[5]"));
		Set<String> hs2= new HashSet<String>();
		for(WebElement ele3:ls1) {
			hs2.add(ele3.getText());}
		System.out.println(hs2);


		driver.close();

	}

}
