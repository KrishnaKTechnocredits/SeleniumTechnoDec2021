/*Assignment -14: 1st March'2022

Use below URL for this assignment:
https://datatables.net/examples/styling/bootstrap4

Scenario 1: 
- Find out number of pages (Expected Output --> 6)
- Find out total entries present on the page (Expected Output --> 57)
- Verify the pagination with respect to page number i.e. for
page 1 --> Showing 1 to 10 of 57 entries
page 2 --> Showing 11 to 20 of 57 entries
page 6 --> Showing 51 to 57 of 57 entries
- Verify Number of rows present on the screen with respect to page number
(Hint - you can calculate and verify the row count by using pagination text value)

Scenario 2: 
Find the age of employee whos name is 'Caesar Vance' on the 1st page
Output: 21

Scenario 3: 
Find out age of the employee whos name is given.
If the employee name is present on 1st page then find out age directly and if employee name is not present on the first page then use the search operation.
Input values :
Cara Stevens
Howard Hatfield

Expected Output:
Cara Stevens : 46
Howard Hatfield : 51
*/

package pallavi;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import technocredits.base.PredefinedActions;

public class A14_DataTable {

	WebDriver driver;

	@BeforeMethod()
	public void openBrowser() {
		driver = PredefinedActions.openBrowser("https://datatables.net/examples/styling/bootstrap4");
	}

	int getTotalRecords() {
		String[] temp = driver.findElement(By.xpath("//div[@id='example_info']")).getText().split("of ");
		int num = Integer.parseInt(temp[1].split(" ")[0]);
		System.out.println(("Total Record= " + num));
		return num;
	}

	@Test(priority = 2)
	public void rows_count() {
		int totalRecords = getTotalRecords();
		Select select = new Select(driver.findElement(By.xpath("//select[@name='example_length']")));
		List<WebElement> selectOpt = driver.findElements(By.xpath("//select[@name='example_length']/option"));

		for (int index = 0; index < selectOpt.size(); index++) {

			select.selectByIndex(index);
			int recordPerPage = Integer.parseInt(select.getFirstSelectedOption().getText());
			System.out.println("For option = " + recordPerPage);
			List<WebElement> pages = driver.findElements(
					By.xpath("//li[@class='paginate_button page-item active' or @class='paginate_button page-item ']"));

			int pageCnt = 0;
			if (totalRecords % recordPerPage == 0)
				pageCnt = totalRecords / recordPerPage;
			else
				pageCnt = totalRecords / recordPerPage + 1;

			if (pageCnt == pages.size()) {
				System.out.println("Showing number of Pages are correct = " + pageCnt);
				int pageNo = 0;
				boolean rowcorrect = true;
				for (int i = 1; i <= pages.size(); i++) {
					try {
						driver.findElement(By.xpath("//a[@data-dt-idx='" + i + "']")).click();
						pageNo = Integer
								.parseInt(driver.findElement(By.xpath("//a[@data-dt-idx='" + i + "']")).getText());

					} catch (StaleElementReferenceException sere) {
						driver.findElement(By.xpath("//a[@data-dt-idx='" + i + "']")).click();
						pageNo = Integer
								.parseInt(driver.findElement(By.xpath("//a[@data-dt-idx='" + i + "']")).getText());
					}

					List<WebElement> rows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
					System.out.println("page no. : " + pageNo + " Total rows:" + rows.size());

					if (pageNo != pages.size() && recordPerPage == rows.size())
						rowcorrect = true;
					else if (pageNo == pages.size()) {
						int record = totalRecords - ((pageNo - 1) * recordPerPage);
						if (record == rows.size())
							rowcorrect = true;
						else
							rowcorrect = false;
					} else
						rowcorrect = false;
				}

				if (!rowcorrect)
					System.out.println("Number of records per page are not correct");
				else
					System.out.println("Number of records per page are correct");
			}
		}
	}

	@Test(priority = 1)
	public void checkPagination() {
		System.out.println("----------------Scenario1---------------");
		List<WebElement> pages = driver.findElements(
				By.xpath("//li[@class='paginate_button page-item active' or @class='paginate_button page-item ']"));
		System.out.println("Number of pages : " + pages.size());

		int totalRecords = getTotalRecords();
		int pageNo = 0;
		for (int i = 1; i <= pages.size(); i++) {
			try {
				driver.findElement(By.xpath("//a[@data-dt-idx='" + i + "']")).click();
				pageNo = Integer.parseInt(driver.findElement(By.xpath("//a[@data-dt-idx='" + i + "']")).getText());
				System.out.println("pageno" + pageNo);
			} catch (StaleElementReferenceException sere) {
				driver.findElement(By.xpath("//a[@data-dt-idx='" + i + "']")).click();
				pageNo = Integer.parseInt(driver.findElement(By.xpath("//a[@data-dt-idx='" + i + "']")).getText());
			}

			int startRange = (pageNo - 1) * 10 + 1;
			int endRange = pageNo * 10;
			String actualPaginationText = driver.findElement(By.xpath("//div[@id='example_info']")).getText();
			String expectedPaginationText;
			if (i != pages.size())
				expectedPaginationText = "Showing " + startRange + " to " + endRange + " of " + totalRecords
						+ " entries";
			else
				expectedPaginationText = "Showing " + startRange + " to " + totalRecords + " of " + totalRecords
						+ " entries";

			if (expectedPaginationText.equals(actualPaginationText))
				System.out.println("Page" + pageNo + "-->" + actualPaginationText);
			else
				System.out.println("Pagination text is not correct. Expected= " + expectedPaginationText + " Actual= "
						+ actualPaginationText);
		}
	}

	@Test(dataProvider = "empNames", priority = 4)
	public void getAgeWithSearch(String name) {
		System.out.println("----------Scenario3------------");
		WebElement searchBox = driver.findElement(By.xpath("//div[@id='example_filter']//input"));
		List<WebElement> age = driver
				.findElements(By.xpath("//table//td[text()='" + name + "']//following-sibling::td[3]"));
		if (age.size() > 0)
			System.out.println(name + " : " + age.get(0).getText());
		else {
			searchBox.clear();
			searchBox.sendKeys(name);
			PredefinedActions.waitForElementToVisible(By.xpath("//table//td"));
			System.out.println(name + " : " + driver
					.findElement(By.xpath("//table//td[text()='" + name + "']//following-sibling::td[3]")).getText());
		}
	}

	@DataProvider(name = "empNames")
	public Object[][] getEmpNames() {
		Object[][] data = new Object[2][1];
		data[0][0] = "Cara Stevens";
		data[1][0] = "Howard Hatfield";
		return data;
	}

	@Test(priority = 3)
	public void getAgeOnFirstPage() {
		System.out.println("------------------Scenario2-------------------------------");
		System.out.println("Age of employee whose name is 'Caesar Vance': " + driver
				.findElement(By.xpath("//table//td[text()='Caesar Vance']//following-sibling::td[3]")).getText());

	}

	@AfterMethod()
	public void closeBrowser() {
		driver.close();
	}
}
