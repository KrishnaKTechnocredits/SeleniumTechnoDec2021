/*Assignment - 8: 21th Feb'2022
Xpath-Axes assignment for tmrw

1. find all sibling of 'Krishna' from the table 1 --> 3(Dhara, Abhishek & Priya)
2. find all the child of row where employee ID is 75589 in table 2 -> 5(7,75589,Nikhil Patne,20205,7013-IT)
3. find all the employee name whose comes before 'Nikhil Patne' from table 2 -> (Pawan,Sumit,Prayag,Sumit, Sumit,Abhijit)
4. find all the rows which comes after employee id '76113' from table 2 --> 15
5. find all the rows which comes before employee id '76113' from table 2 --> 10
6. return count total employee in table 2 without using findElements method --> 9 count
7. find the position of employee 'Chetan Shewale' from table 2 -> 8
8. can we find 'Maulik' from table 1 using reference of '76993' employee id
	Hint: yes, we have to use ancestor and preceding-sibling (think on this)

*/

package pallavi;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A8_XpathAxes {

	// find all sibling of 'Krishna' from the table 1 --> 3(Dhara, Abhishek & Priya)
	void findSiblings(WebDriver driver) {
		List<WebElement> rows = driver.findElements(
				By.xpath("//table[@id='table1']//tbody//td[text()='Krishna']/parent::tr/following-sibling::tr/td[2]"));
		for (WebElement record : rows) {
			System.out.println(record.getText());
		}
	}

	// find all the child of row where employee ID is 75589 in table 2 ->
	// 5(7,75589,Nikhil Patne,20205,7013-IT)
	void findchild(WebDriver driver) {
		String rowContent = driver.findElement(By.xpath("//div[@id='empmanager']//td[text()='75589']/parent::tr"))
				.getText();
		System.out.println("Row content with id 75589 : " + rowContent);
	}

	// find all the employee name whose comes before 'Nikhil Patne' from table 2 ->
	// (Pawan,Sumit,Prayag,Sumit, Sumit,Abhijit)
	void findPrecedingRecords(WebDriver driver) {
		List<WebElement> rows = driver.findElements(
				By.xpath("//div[@id='empmanager']//td[text()='Nikhil Patne']/parent::tr/preceding-sibling::tr/td[3]"));
		System.out.println("Employee name whose comes before 'Nikhil Patne' from table 2 : ");
		for (WebElement row : rows) {
			String[] temp = row.getText().split(" ");
			System.out.println(temp[0]);
		}
		System.out.println("Employee name whose comes before 'Nikhil Patne' from table 2 (reverse order): ");
		for (int i = 1; i <= rows.size(); i++) {
			String fullName = driver.findElement(
					By.xpath("//div[@id='empmanager']//td[text()='Nikhil Patne']/parent::tr/preceding-sibling::tr[" + i
							+ "]/td[3]"))
					.getText();
			String[] temp = fullName.split(" ");
			System.out.println(temp[0]);
		}
	}

	// find all the rows which comes after employee id '76113' from table 2-->15
	void findNoOfRowsFollowing(WebDriver driver) {
		List<WebElement> rows = driver
				.findElements(By.xpath("//div[@id='empmanager']//td[text()='76113']/parent::tr/following::tr"));
		System.out.println("Number of rows after employee id 76113 are: " + rows.size());
	}

	// find all the rows which comes before employee id '76113' from table 2 --> 10
	void findNoOfRowsPreceding(WebDriver driver) {
		List<WebElement> rows = driver
				.findElements(By.xpath("//div[@id='empmanager']//td[text()='76113']/parent::tr/preceding::tr"));
		System.out.println("Number of rows beforr employee id 76113 are: " + rows.size());
	}

	// return count total employee in table 2 without using findElements method -->
	// 9 count
	int getNumberOfRows(WebDriver driver) {
		boolean isPresent = true;
		int count = 1;
		while (isPresent) {
			try {
				WebElement row = driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + count + "]"));
				count++;
			} catch (Exception e) {
				isPresent = false;
			}
		}
		return count - 1;
	}

	// find the position of employee 'Chetan Shewale' from table 2 -> 8
	void findPosition(WebDriver driver) {
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[3]"));
		int count = 1;
		for (WebElement row : rows) {
			if (row.getText().equals("Chetan Shewale"))
				break;
			else
				count++;
		}
		System.out.println("Position of employee 'Chetan Shewale' from table 2 =" + count);
	}

	// can we find 'Maulik' from table 1 using reference of '76993' employee id
	void findRecordWithAncestor(WebDriver driver) {
		String name = driver.findElement(By.xpath(
				"//div[@id='empmanager']//td[text()='76993']//ancestor::div//descendant::div[@id='empbasic']//tbody/tr[1]/td[2]"))
				.getText();
		System.out.println("First name from table 1 with referace of first name from table2 : " + name);
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("demotable")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='empmanager']//tbody")));

		A8_XpathAxes xpathAxes = new A8_XpathAxes();
		System.out.println("Following sibling of 'Krishna' from the table 1: ");
		xpathAxes.findSiblings(driver);

		System.out.println();
		xpathAxes.findchild(driver);

		System.out.println();
		xpathAxes.findPrecedingRecords(driver);

		System.out.println();
		xpathAxes.findNoOfRowsFollowing(driver);

		System.out.println();
		xpathAxes.findNoOfRowsPreceding(driver);

		System.out.println();
		System.out.println("Count total employee in table 2 = " + xpathAxes.getNumberOfRows(driver));

		System.out.println();
		xpathAxes.findPosition(driver);

		System.out.println();
		xpathAxes.findRecordWithAncestor(driver);

		driver.close();
	}

}
