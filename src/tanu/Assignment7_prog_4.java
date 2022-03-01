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

class Assignment7_prog_4 {
	/*
	14. write a method to find duplicate employee id and name
		-> map
		-> set
		-> list*/
	
	public static void main(String[] args) throws InterruptedException {
		
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

		Map<String, String> hs = new HashMap<String, String>();
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr/td[2]"));
		List<String> duplilist = new ArrayList<String>();
		for (int i = 1; i <= list.size(); i++) {
			String empId = driver.findElement(By.xpath("//div[@id='empmanager']//table/tbody/tr[" + i + "]/td[2]"))
					.getText();
			String empName = driver.findElement(By.xpath("//div[@id='empmanager']//table/tbody/tr[" + i + "]/td[3]"))
					.getText();
			if (hs.containsKey(empId))
				duplilist.add(empId + "-->" + hs.get(empId));/// empname
			else
				hs.put(empId, empName);
		}

		System.out.println(duplilist);
	}

}