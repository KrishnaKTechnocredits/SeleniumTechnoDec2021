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

class Assignment7_prog_2 {
	
	
	
	/* write a method which returns map of manager id & employee count*/
	
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
		Map<String, Integer> getMangrIdEmpCount = new HashMap<String, Integer>();
		List<WebElement> managerids = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr/td[4]"));
		for (int index = 1; index < managerids.size(); index++) {
			String Managerid = driver
					.findElement(By.xpath("//div[@id='empmanager']//table/tbody/tr[" + index + "]/td[4]")).getText();
			if (getMangrIdEmpCount.containsKey(Managerid))
				getMangrIdEmpCount.put(Managerid, getMangrIdEmpCount.get(Managerid) + 1);
			else

				getMangrIdEmpCount.put(Managerid, 1);

		}
		System.out.println(getMangrIdEmpCount);
	}

}
