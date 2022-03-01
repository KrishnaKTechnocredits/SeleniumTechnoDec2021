package tanu;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

/*
1. find all sibling of 'Krishna' from the table 1 --> 3(Dhara, Abhishek & Priya)////table[@id='table1']/tbody/tr[2]/following-sibling::tr
2. find all the child of row where employee ID is 75589 in table 2 -> 5(7,75589,Nikhil Patne,20205,7013-IT)
3. find all the employee name whose comes before 'Nikhil Patne' from table 2 -> (Pawan,Sumit,Prayag,Sumit, Sumit,Abhijit)
4. find all the rows which comes after employee id '76113' from table 2 --> 15
5. find all the rows which comes before employee id '76113' from table 2 --> 10
6. return count total employee in table 2 without using findElements method --> 9 count
7. find the position of employee 'Chetan Shewale' from table 2 -> 8
8. can we find 'Maulik' from table 1 using reference of '76993' employee id
	Hint: yes, we have to use ancestor and preceding-sibling (think on this)*/

class Assignment7 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\java-selenium\\Eclipse\\SeleniumBasics\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		System.out.println("Browser Launched");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' Maulik Kanani ']")));
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.findElement(By.xpath("//a[@id='demotable']")).getText();
		System.out.println("Select DemoTable1");
		driver.findElement(By.xpath("//table[@id='table1']")).click();
		System.out.println("Programe 1");
		List<WebElement> followingsibling = driver
				.findElements(By.xpath("//table[@id='table1']/tbody/tr[2]/following-sibling::tr"));
		System.out.println("Below Following-Sibling of Krishna");
		for (WebElement Afterkrishna : followingsibling) {
			System.out.println(Afterkrishna.getText());
		}
		System.out.println("Programe 2");
		List<WebElement> childfromtable2 = driver
				.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr[7]/child::td"));
		System.out.println("Below are the childs with Employee ID is 75589 from Table 2 ");
		for (WebElement child : childfromtable2) {
			System.out.println(child.getText());
		}
		System.out.println("Programe 3");
		List<WebElement> procedingemp = driver
				.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr[7]//preceding-sibling::tr"));
		System.out.println("Below employee names who comes before 'Nikhil Patne' from table 2");

		for (WebElement emp : procedingemp) {
			System.out.println(emp.getText());
		}
		System.out.println("Programe 4");
		System.out.println("Below row count which comes after employee id '76113' from Table 2");
		System.out.println(driver
				.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr[4]//following::tr")).size());

		System.out.println("Programe 5");
		System.out.println("Below row count which comes before employee id '76113' from Table 2 ");
		System.out.println(driver
				.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr[4]//preceding::tr")).size());
		System.out.println("Programe 6");
		List<WebElement> position = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[3]"));
		int count = 1;
		for (WebElement emp : position) {
			if (emp.getText().equals("Chetan Shewale"))
				break;
			else
				count++;
		}
		System.out.println("Position of employee 'Chetan Shewale' from table 2 is " + count);
			
		System.out.println("Programe 8");
		List<WebElement> ancestor = driver.findElements(
				By.xpath("//div[@id='empmanager']//ancestor::section//preceding-sibling::tr//td[text()='Maulik']"));
		for (WebElement emp : ancestor) {
			System.out.println(emp.getText());
		}

	}
}
