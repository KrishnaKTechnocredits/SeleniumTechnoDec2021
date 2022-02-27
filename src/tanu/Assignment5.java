package tanu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1. how many employee are there in table1? --> 5
2. how many employee joins company after dhara? --> 2
3. find the first name of user whoes username is 'ppatro' --> priya
4. print all the header of first table -- > # first name last name username
5. print content of all the rows of first table
*/

class Assignment5 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\java-selenium\\Eclipse\\SeleniumBasics\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		Thread.sleep(3000);
		System.out.println("Browser Launched");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		System.out.println(driver.findElement(By.xpath("//a[@id='demotable']")).getText());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@id='table1']")).click();
		System.out.println(driver.findElement(By.xpath("//header[@class='panel-heading'][1]")).getText());
		Thread.sleep(3000);
		System.out.println("Programe 1");
		System.out.println("Total Employee count from DemoTable 1 is:---"
				+ driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size());
		System.out.println("Programe 2");
		System.out.println("Total Employee count joins company after Dhara is:---"
				+ driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[3]/following-sibling::tr")).size());
		System.out.println("Programe 3");
		System.out.println("Name of employee whose user name is ppatro:---"
				+ driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[5]/td[2]")).getText());
		System.out.println("Programe 4");
		List<WebElement> tableheader = driver.findElements(By.xpath("//table[@id='table1']/thead/tr[1]/th"));
		for (WebElement content : tableheader) {
			System.out.println(content.getText());
		}
		System.out.println("Programe 5");
		List<WebElement> tablecontent = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		for (WebElement content : tablecontent) {
			System.out.println(content.getText());
		}
	}
}
