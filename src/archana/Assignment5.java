package archana;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment5 {

	int countNoOfRowsInTable(WebDriver driver) { // prog#1
		List<WebElement> ls = driver.findElements(By.xpath("//table[@id ='table1']/tbody/tr"));
		return ls.size();
	}

	int countFollowingNodes(WebDriver driver) {
		List<WebElement> ls = driver.findElements(
				By.xpath("//table[@id ='table1']/tbody/tr/td[text()='Dhara']//parent::tr//following-sibling::tr"));
		return ls.size();
	}

	String getNameFromTable(WebDriver driver) {
		String str = driver
				.findElement(By.xpath("//table[@id ='table1']/tbody/tr/td[text()='ppatro']//parent::tr/td[2]"))
				.getText();
		return str;
	}

	List<String> printHeader(WebDriver driver) {
		List<WebElement> ls = driver.findElements(By.xpath("//table[@id ='table1']/thead/tr"));
		List<String> finalList = new ArrayList<String>();
		for (WebElement ele : ls)
			finalList.add(ele.getText());
		return finalList;
	}

	String printDataOfWebTable(WebDriver driver) {
		String str = driver.findElement(By.xpath("//table[@id ='table1']/tbody")).getText();
		return str;
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Archana\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		Assignment5 ass5 = new Assignment5();

		driver.findElement(By.id("demotable")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id ='table1']")));

		System.out.println("----------1--------------");
		System.out.println("Total Employees are: " + ass5.countNoOfRowsInTable(driver));

		System.out.println("----------2--------------");
		System.out.println("Employees joined after Dhara is: " + ass5.countFollowingNodes(driver));

		System.out.println("----------3--------------");
		System.out.println("Name ppatro is:" + ass5.getNameFromTable(driver));

		System.out.println("------------4--------------");
		System.out.println("Headers : " + ass5.printHeader(driver));

		System.out.println("----------5--------------");
		System.out.println("Table1 data : " + ass5.printDataOfWebTable(driver));
		driver.quit();
	}

}
