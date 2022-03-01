package tanu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class Assignment7_prog_3 {
	
	
	
	/*13. write a method to find manager id has max reporting employee from table 2*/
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\java-selenium\\Eclipse\\SeleniumBasics\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		System.out.println("Browser Launched");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table']")));
		driver.findElement(By.xpath("//a[@id='demotable']")).getText();
		System.out.println("Select Table2");
		driver.findElement(By.xpath("//div[@id='empmanager']")).click();
		Map<String, Integer> hs = new HashMap<String, Integer>();
		List<WebElement> we = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr/td[4]"));
		for (int index = 1; index < we.size(); index++) {
			String emp = driver.findElement(By.xpath("//div[@id='empmanager']//table/tbody/tr[" + index + "]/td[4]"))
					.getText();
			if (hs.containsKey(emp))
				hs.put(emp, hs.get(emp) + 1);
			else
				hs.put(emp, 1);
		}
		Set<String> empcount = hs.keySet();/// Set<String> e = hs.KeySet();
		int maxvalue = 0;//
		String mgrid = "";//
		for (String emp : empcount) {///
			if (maxvalue < hs.get(emp)) {//
				maxvalue = hs.get(emp);//
				mgrid = emp; //
			}
		}
		System.out.println("Manager Id has max reporting employee :" + mgrid);
	}
}
