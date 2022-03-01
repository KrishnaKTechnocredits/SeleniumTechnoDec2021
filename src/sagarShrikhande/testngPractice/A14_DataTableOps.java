package sagarShrikhande.testngPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import technocredits.base.PredefinedActions;

public class A14_DataTableOps {

	@Test(priority = 1)
	void scenario1() {
		WebDriver driver = PredefinedActions.openBrowser("https://datatables.net/examples/styling/bootstrap4");
		Select select = new Select(driver.findElement(By.xpath("//select[@name='example_length']")));
		int filterCount = Integer.parseInt(select.getFirstSelectedOption().getText());
		String temp = driver.findElement(By.xpath("//div[@id='example_info']")).getText().split("of ")[1];
		int totalEntries = Integer.parseInt(temp.split(" ")[0]);

		int numOfPages;
		if (totalEntries % filterCount == 0)
			numOfPages = totalEntries / filterCount;
		else
			numOfPages = (totalEntries / filterCount) + 1;
		System.out.println("Total number of pages is: " + numOfPages);
		System.out.println("Total entries are: " + totalEntries);

		for (int index = 1; index <= numOfPages; index++) {
			if (index < numOfPages) {
				filterCount = Integer.parseInt(select.getFirstSelectedOption().getText());
				driver.findElement(By.xpath("//a[@data-dt-idx='" + index + "']")).click();
				int startRange = Integer
						.parseInt(driver.findElement(By.xpath("//div[@id='example_info']")).getText().split(" ")[1]);
				int endPageRange = Integer
						.parseInt(driver.findElement(By.xpath("//div[@id='example_info']")).getText().split(" ")[3]);
				int pageEntryCount = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
				if ((pageEntryCount == filterCount) && (startRange == (index - 1) * filterCount + 1)
						&& (endPageRange == index * filterCount))
					System.out.println("Page is showing correct range: Showing " + startRange + " to " + endPageRange
							+ " of " + totalEntries + " entries as per filter selected for page no: " + index);
			} else if (index == numOfPages) {
				filterCount = Integer.parseInt(select.getFirstSelectedOption().getText());
				driver.findElement(By.xpath("//a[@data-dt-idx='" + index + "']")).click();
				int startRange = Integer
						.parseInt(driver.findElement(By.xpath("//div[@id='example_info']")).getText().split(" ")[1]);
				int endPageRange = Integer
						.parseInt(driver.findElement(By.xpath("//div[@id='example_info']")).getText().split(" ")[3]);
				int pageEntryCount = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
				if (pageEntryCount == (totalEntries % filterCount) && (startRange == (index - 1) * filterCount + 1)
						&& (endPageRange == totalEntries))
					System.out.println("Page is showing correct range: Showing " + startRange + " to " + endPageRange
							+ " of " + totalEntries + " entries as per filter selected for page no: " + index);
			} else
				System.out.println("Incorrect entries are being displayed on page");
		}
		driver.quit();
	}

	@Test(priority = 2)
	void scenario2() {
		WebDriver driver = PredefinedActions.openBrowser("https://datatables.net/examples/styling/bootstrap4");
		driver.findElement(By.xpath("//a[@data-dt-idx='1']")).click();
		String name = "Caesar Vance";
		System.out.println("Age of " + name + " is: " + driver.findElement(By
				.xpath("//table[@id='example']/tbody/tr/td[contains(text(),'" + name + "')]//following-sibling::td[3]"))
				.getText());
		driver.quit();
	}

	@DataProvider(name = "List")
	public String[] getData() {
		String[] data = new String[2];
		data[0] = "Cara Stevens";
		data[1] = "Howard Hatfield";
		return data;
	}

	@Test(dataProvider = "List", priority = 3)
	void scenario3(String name) {
		WebDriver driver = PredefinedActions.openBrowser("https://datatables.net/examples/styling/bootstrap4");

		Select select = new Select(driver.findElement(By.xpath("//select[@name='example_length']")));
		int filterCount = Integer.parseInt(select.getFirstSelectedOption().getText());
		String temp = driver.findElement(By.xpath("//div[@id='example_info']")).getText().split("of ")[1];
		int totalEntries = Integer.parseInt(temp.split(" ")[0]);
		int numOfPages;
		if (totalEntries % filterCount == 0)
			numOfPages = totalEntries / filterCount;
		else
			numOfPages = (totalEntries / filterCount) + 1;
		int index = 1;
		while (index <= numOfPages) {
			driver.findElement(By.xpath("//a[@data-dt-idx='" + index + "']")).click();
			if (driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[contains(text(),'" + name + "')]"))
					.size() == 0)
				index++;
			else {
				System.out.println("Age of employee " + name + " is: "
						+ driver.findElement(By.xpath("//table[@id='example']/tbody/tr/td[contains(text(),'" + name
								+ "')]//following-sibling::td[3]")).getText());
				break;
			}
		}
		driver.quit();
	}
}

/*
 * Assignment -14: 1st March'2022
 * 
 * Use below URL for this assignment:
 * https://datatables.net/examples/styling/bootstrap4
 * 
 * Scenario 1: - Find out number of pages (Expected Output --> 6) - Find out
 * total entries present on the page (Expected Output --> 57) - Verify the
 * pagination with respect to page number i.e. for page 1 --> Showing 1 to 10 of
 * 57 entries page 2 --> Showing 11 to 20 of 57 entries page 6 --> Showing 51 to
 * 57 of 57 entries - Verify Number of rows present on the screen with respect
 * to page number (Hint - you can calculate and verify the row count by using
 * pagination text value)
 * 
 * Scenario 2: Find the age of employee whos name is 'Caesar Vance' on the 1st
 * page Output: 21
 * 
 * Scenario 3: Find out age of the employee whos name is given. If the employee
 * name is present on 1st page then find out age directly and if employee name
 * is not present on the first page then use the search operation. Input values
 * : Cara Stevens Howard Hatfield
 * 
 * Expected Output: Cara Stevens : 46 Howard Hatfield : 51
 */