package yogeshNagar;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
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

public class A8_XPathAxis {
	static WebDriver driver = BaseClass.launchBrowser("http://automationbykrishna.com/");

	void getAllSibling() {
		List<WebElement> sibling = driver.findElements(
				By.xpath("//table[@id='table1']/tbody/tr/td[contains(text(),'Krishna')]/following-sibling::td"));
		System.out.println("----Programme 1----");
		System.out.println("Sibling of Krishna are " + sibling.size());
	}

	void getAllChild() {
		List<WebElement> child = driver.findElements(
				By.xpath("//table[contains(@class,'table-striped')]/tbody//td[text()='75589']/parent::tr/child::td"));
		ArrayList<String> childList = new ArrayList<String>();
		for (WebElement allChild : child)
			childList.add(allChild.getText());

		System.out.println();
		System.out.println("----Programme 2----");
		System.out.println("All childs as per Employee ID 75589");
		System.out.println(childList);
	}

	void getNameBeforeDefinedName() {
		List<WebElement> names = driver.findElements(By.xpath(
				"//table[contains(@class,'table-striped')]/tbody/tr/td[text()='Nikhil Patne']/parent::tr/preceding-sibling::tr/td[3]"));
		ArrayList<String> nameList = new ArrayList<String>();
		for (WebElement list : names)
			nameList.add(list.getText());
		System.out.println();
		System.out.println("----Programme 3----");
		System.out.println("All names before Employee name Nikhil Patne");
		System.out.println(nameList);
	}

	void getAllRowAfterEmployeeID() {
		List<WebElement> allRow = driver.findElements(
				By.xpath("//table[contains(@class,'table-striped')]//td[text()='76113']/parent::tr/following::tr"));
		System.out.println();
		System.out.println("----Programme 4----");
		System.out.println("All Rows after Employee ID 76113");
		System.out.println(allRow.size());
	}

	void getAllRowBeforeEmployeeID() {
		List<WebElement> allRow = driver.findElements(
				By.xpath("//table[contains(@class,'table-striped')]//td[text()='76113']/parent::tr/preceding::tr"));
		System.out.println();
		System.out.println("----Programme 5----");
		System.out.println("All Rows before Employee ID 761133");
		System.out.println(allRow.size());
	}

	void getRowCountWithOutFindElements() {
		int count = 1;
		boolean flag = true;
		while (flag) {
			try {
				driver.findElement(By.xpath("//table[contains(@class,'table-striped')]/tbody/tr[" + count + "]"));
				count++;
			} catch (Exception e) {
				flag = false;
			}
		}
		System.out.println();
		System.out.println("----Programme 6----");
		System.out.println("Row count without using findElements");
		System.out.println(count - 1);
	}

	void getPositionOfElement() {
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[3]"));
		int count = 1;
		for (WebElement row : rows) {
			if (row.getText().equals("Chetan Shewale"))
				break;
			else
				count++;
		}
		System.out.println();
		System.out.println("----Programme 7----");
		System.out.println("Position of employee 'Chetan Shewale' from table 2 is " + count);
	}

	void getElementInTableRefrenceTable() {
		String Name = driver
				.findElement(By.xpath("//td[text()='76993']/ancestor::table/preceding::table//td[text()='Maulik']"))
				.getText();
		System.out.println();
		System.out.println("----Programme 8----");
		System.out.println(Name);
	}

	public static void main(String[] args) throws InterruptedException {
		driver.findElement(By.id("demotable")).click();
		Thread.sleep(1000);
		A8_XPathAxis xpath = new A8_XPathAxis();
		xpath.getAllSibling();
		xpath.getAllChild();
		xpath.getNameBeforeDefinedName();
		xpath.getAllRowAfterEmployeeID();
		xpath.getAllRowBeforeEmployeeID();
		xpath.getRowCountWithOutFindElements();
		xpath.getPositionOfElement();
		xpath.getElementInTableRefrenceTable();
		driver.quit();
	}
}