package naquibalam;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A5_WebtableXpath {
	
	static WebDriver openBrowser(String pathToDriver, String url) {
		System.setProperty("webdriver.chrome.driver", pathToDriver);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	static void closeDriver(WebDriver driver) {
		Set<String> driverList = driver.getWindowHandles();
		for (String allWebdriverOpen : driverList) {
			if (!(allWebdriverOpen.equals(null))) {
				driver.close();
			}
		}
	}
	
	int getAllEmployeeCount(WebDriver driver) {
		List<WebElement> allEmployee = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		return allEmployee.size();
	}
	
	int getAllEmployeeAfterCount(WebDriver driver, String afterEmployee) {
		List<WebElement> allEmployeeAfter = driver.findElements(By.xpath("//td[text()='" + afterEmployee + "']//parent::tr//following-sibling::tr"));
		return allEmployeeAfter.size();
	}
	
	String getFirstNameFromUserName(WebDriver driver, String userName) {
		return driver.findElement(By.xpath("(//td[text()='ppatro']//preceding-sibling::td)[2]")).getText();
	}
	
	
	void printAllHeaderValueFirstTable(WebDriver driver){
		List<WebElement> allHeaderValue = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));		
		for (WebElement allHeader : allHeaderValue) {
			System.out.print("[" + allHeader.getText() + "] ");
		}
	}
	
	void printAllRowContent(WebDriver driver) {
		List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));
		int rowsCount = allRows.size();
		printAllHeaderValueFirstTable(driver);
		for (int i = 1; i <= allRows.size(); i++) {
			List<WebElement> eachRowEachElement = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[" + i + "]//td"));
			System.out.println();
			for (WebElement eachElement : eachRowEachElement) {
				System.out.print("[" + eachElement.getText() + "] ");
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		A5_WebtableXpath a5_WebtableXpath = new A5_WebtableXpath();
		String driverPath = "./drivers/chromedriver_98Version.exe";
		String url = "http://automationbykrishna.com/";
		WebDriver driver = openBrowser(driverPath, url);
		driver.findElement(By.id("demotable")).click();
		Thread.sleep(2000);
		try {
			System.out.println("********************************************************************************************************");
			System.out.println("Total Employees in the table are : " + a5_WebtableXpath.getAllEmployeeCount(driver));
			System.out.println("********************************************************************************************************");
			String employeesAfter = "Dhara";
			System.out.println("All Employees after " + employeesAfter + " are : " + a5_WebtableXpath.getAllEmployeeAfterCount(driver, employeesAfter));
			System.out.println("********************************************************************************************************");
			String userName = "ppatro";
			System.out.println("Employees first name from user name '" + userName + "' is : " + a5_WebtableXpath.getFirstNameFromUserName(driver, userName));
			System.out.println("********************************************************************************************************");
			System.out.println("All header values from table are  : ");
			a5_WebtableXpath.printAllHeaderValueFirstTable(driver);
			System.out.println("\n********************************************************************************************************");
			System.out.println("All values from table are  : ");
			a5_WebtableXpath.printAllRowContent(driver);
			System.out.println("\n********************************************************************************************************");
		}finally {
			closeDriver(driver);
		}		
	}

}
