package naquibalam;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class A8_XpathPrograms {
	
	void getAllSibling(String input, WebDriver driver) {
		List<WebElement> allSibling = driver.findElements(By.xpath("//td[text()='" + input + "']//parent::tr//following-sibling::tr//td[2]"));
		for(WebElement out : allSibling) {
			System.out.print("[" + out.getText() + "]");
		}
	}
	
	void getAllValueFromID(String input, WebDriver driver) {
		List<WebElement> allValue = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody//td[text()='" + input + "']//parent::tr//td"));
		for(WebElement out : allValue) {
			System.out.print("[" + out.getText() + "]");
		}
	}
	
	void getAllNamesBefore(String input, WebDriver driver) {
		List<WebElement> allNamesBefore = driver.findElements(By.xpath("//td[text()='" + input + "']//parent::tr//preceding-sibling::tr/td[3]"));
		for(WebElement out : allNamesBefore) {
			System.out.print("[" + out.getText() + "]");
		}
	}
	
	int getAllRowsAfter(String input, WebDriver driver) {
		List<WebElement> allRowsAfter = driver.findElements(By.xpath("//td[text()='" + input + "']//following::tr"));
		return allRowsAfter.size();
	}
	
	int getAllRowsBefore(String input, WebDriver driver) {
		List<WebElement> allRowsBefore = driver.findElements(By.xpath("//td[text()='" + input + "']//preceding::tr"));
		return allRowsBefore.size();
	}
	
	int getCountOfEmployee(WebDriver driver) {
		String lastEmployeeID = driver.findElement(By.xpath("(//div[@id='empmanager']//table//tbody/tr/td[2])[last()]")).getText();
		String allEmployee = "";
		int count = 1;
		while(!(allEmployee.equals(lastEmployeeID))) {
			allEmployee = driver.findElement(By.xpath("(//div[@id='empmanager']//table//tbody/tr/td[2])[position()=" + count + "]")).getText();
			count++;
		}			
		return count - 1;
	}
	
	int getPositionOfEmployee(String input, WebDriver driver) {
		List<WebElement> allEmployee = driver.findElements(By.xpath("(//div[@id='empmanager']//table//tbody/tr/td[2])"));
		int position = 1;
		for (int i = 1; i <= allEmployee.size(); i++) {
			String employee = driver.findElement(By.xpath("(//div[@id='empmanager']//table//tbody/tr/td[2])[position()=" + i + "]")).getText();
			position = i;
			if (employee.equals(input)) {
				break;
			}
		}		
		return position - 1;
	}	
	
	public static void main(String[] args) throws InterruptedException {
		PredefinedActions predifinedActions = new PredefinedActions();
		A8_XpathPrograms a8_XpathPrograms = new A8_XpathPrograms();
		WebDriver driver = predifinedActions.openBrowser("./drivers/chromedriver_98Version.exe", "http://automationbykrishna.com/");
		driver.findElement(By.id("demotable")).click();
		Thread.sleep(2000);
		try {
			System.out.println("***************************************************************************************");
			String input = "Krishna";
			System.out.println("All the siblings of '" + input + "' : ");
			a8_XpathPrograms.getAllSibling(input, driver);
			System.out.println("\n***************************************************************************************");
			String input2 = "75589";
			System.out.println("All the value in row with ID '" + input2 + "' : ");
			a8_XpathPrograms.getAllValueFromID(input2, driver);
			System.out.println("\n***************************************************************************************");
			String input3 = "Nikhil Patne";
			System.out.println("All the names before '" + input3 + "' : ");
			a8_XpathPrograms.getAllNamesBefore(input3, driver);
			System.out.println("\n***************************************************************************************");
			String input4 = "76113";
			System.out.println("Count of rows after '" + input4 + "' : ");
			System.out.println(a8_XpathPrograms.getAllRowsAfter(input4, driver));
			System.out.println("***************************************************************************************");
			String input5 = "76113";
			System.out.println("Count of rows before '" + input5 + "' : ");
			System.out.println(a8_XpathPrograms.getAllRowsBefore(input5, driver));
			System.out.println("***************************************************************************************");
			System.out.println("Total employees are : ");
			System.out.println(a8_XpathPrograms.getCountOfEmployee(driver));
			System.out.println("***************************************************************************************");
			String input6 = "Chetan Shewale";
			System.out.println("Poisition of employee '" + input6 + "' in the table is : ");
			System.out.println(a8_XpathPrograms.getPositionOfEmployee(input6, driver));
			System.out.println("***************************************************************************************");
			String input7 = "76993";
			System.out.println("Find Maulik in first table using '" + input7 + "' in the second table : ");
			System.out.println(driver.findElement(By.xpath("(//td[text()='" + input7 + "']//preceding::table//child::tbody/tr/td[2])[position()=1]")).getText());
			System.out.println("***************************************************************************************");
		} finally {
			predifinedActions.closeDriver(driver);
		}

	}

}
