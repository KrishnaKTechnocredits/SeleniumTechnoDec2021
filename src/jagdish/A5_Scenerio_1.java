package jagdish;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A5_Scenerio_1 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id ='table1']")));

		System.out.println("######### Program-1 #############");
		List<WebElement> NoofEmpinTable = driver.findElements(By.xpath("//table[@id ='table1']/tbody/tr"));
		System.out.println("Total employee are there in table:- " + NoofEmpinTable.size());
		System.out.println();

		System.out.println("######### Program-2 #############");
		List<WebElement> joinafter = driver.findElements(
				By.xpath("//table[@id='table1']/tbody/tr/td[text()='Dhara']//parent::tr//following-sibling::tr"));
		System.out.println("Total employee joins company after dhara-->:- " + joinafter.size());
		System.out.println();

		System.out.println("######### Program-3 #############");
		String firstname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr/td[text()='ppatro']//parent::tr/td[2]")).getText();
		System.out.println("First name of user whoes username is 'ppatro' is:- " + firstname);
		System.out.println();
		
		System.out.println("######### Program-4 #############");
		List<WebElement> list = driver.findElements(By.xpath("//table[@id ='table1']/thead/tr"));
		for (WebElement ele : list)
			System.out.println(ele.getText());
		System.out.println();
		
		System.out.println("######### Program-5 #############");
		List<WebElement> Templist = driver.findElements(By.xpath("//table[@id ='table1']//tr"));
		for (int index = 1; index <= Templist.size(); index++) {
			List<WebElement> eachrow = driver.findElements(By.xpath("//table[@id='table1']//tr[" + index + "]"));
			for (WebElement ele : eachrow) {
				System.out.println(ele.getText());
			}
		}
		
		driver.close();
	}
}
