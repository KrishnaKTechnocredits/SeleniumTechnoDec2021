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

*/

package vaibhav.Assignment_14;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import vaibhav.base.PredefinedActions;

public class Scenario1 {

	static String URL = "https://datatables.net/examples/styling/bootstrap4";
	static int totalPages;
	List<WebElement> pageElements;
	static int totalEntriesOnPage;
	static WebDriver driver;
	int startNum;
	int endNum;

	@BeforeClass
	void alaunchBrowser() {
		// String URL = "https://datatables.net/examples/styling/bootstrap4";
		driver = PredefinedActions.launchBrowser(URL);
	}

	@Test
	void bgetNumberOfPages() {
		pageElements = driver.findElements(By.xpath(
				"//ul[@class='pagination']/li[@class='paginate_button page-item active' or @class='paginate_button page-item ']"));

		totalPages = pageElements.size();
		System.out.println("Total number of pages : " + totalPages);
	}

	@Test
	void cgetTotalEntriesOnPage() {
		String pageinitionText = driver.findElement(By.xpath("//div[@id='example_info']")).getText();
		String[] arrString = pageinitionText.split(" ");
		totalEntriesOnPage = Integer.parseInt(arrString[5]);
		System.out.println("Total number of entries on the page : " + totalEntriesOnPage);
	}

	@Test
	void dverifyPaginationFormat() {
		String[] expectedPagination = new String[6];
		expectedPagination[0] = "Showing 1 to 10 of 57 entries";
		expectedPagination[1] = "Showing 11 to 20 of 57 entries";
		expectedPagination[2] = "Showing 21 to 30 of 57 entries";
		expectedPagination[3] = "Showing 31 to 40 of 57 entries";
		expectedPagination[4] = "Showing 41 to 50 of 57 entries";
		expectedPagination[5] = "Showing 51 to 57 of 57 entries";

		boolean testStatus = true;
		for (int index = 0; index < totalPages; index++) {
			// String expectedPaginationStr = expectedPagination[index];

			setStartNumAndEndNum(pageElements.get(index));
			String actualPagination = "Showing " + startNum + " to " + endNum + " of " + totalEntriesOnPage
					+ " entries";

			if (actualPagination.equals(expectedPagination[index])) {
				System.out.println("Page " + (index + 1) + " pagination test PASS");
				System.out.println("Actual and Expected Pagination value is matched");
				System.out.println("Actual Pagiantion : " + actualPagination);
				System.out.println("Expected Pagianation : " + expectedPagination[index]);
				System.out.println();
			} else {
				testStatus = false;
				System.out.println("Page " + (index + 1) + " pagination test FAILED");
				System.out.println("Actual and Expected Pagination value is NOT matched");
				System.out.println("Actual Pagiantion : " + actualPagination);
				System.out.println("Expected Pagianation : " + expectedPagination[index]);
				System.out.println();
			}
		}

		if (testStatus) {
			System.out.println("Pagination Test ==> PASS");
		} else {
			System.out.println("Pagination Test ==> FAILED");
		}

	}

	@Test
	void everifyNumberOfRowsOnPage() {
		int expectedNumberOfRows = 0;
		boolean testStatus = true;
		int pageCount = 1;

		for (int index = 1; index <= 6; index++) {
			WebElement element = null;
			int currentPageNumber = 0;
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)", "");

			element = driver
					.findElement(By.xpath("//li[@id='example_previous']/following-sibling::li[" + index + "]/a"));

			// Try catch used due to Stale Element Reference Exception

			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//li[@id='example_previous']/following-sibling::li[" + index + "]/a")));
				currentPageNumber = Integer.parseInt(element.getText());
				element.click();
			} catch (StaleElementReferenceException sere) {
				element = driver
						.findElement(By.xpath("//li[@id='example_previous']/following-sibling::li[" + index + "]/a"));
				currentPageNumber = Integer.parseInt(element.getText());
				element.click();
			}

			List<WebElement> rowElement = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
			int actualNumberOfRows = rowElement.size();

			if (index < totalPages) {
				expectedNumberOfRows = 10;
			} else {
				expectedNumberOfRows = totalEntriesOnPage%10;
			}

			if (actualNumberOfRows == expectedNumberOfRows) {
				System.out.println("Test for page " + pageCount + " is PASS");
				pageCount++;

			} else {
				System.out.println("Test for page " + pageCount + " is FAIL");
				testStatus = false;
				pageCount++;

			}

		}

		if (testStatus) {
			System.out.println("Verification of number of Rows on Page Test ==> PASS");
		} else {
			System.out.println("Verification of number of Rows on Page Test ==> FAILED");
		}

	}

	void setStartNumAndEndNum(WebElement element) {
		int temp = Integer.parseInt(element.getText());
		if (temp > 0 && temp < totalPages) {
			endNum = temp * 10;
			startNum = endNum - 9;
		} else if (temp == totalPages) {
			endNum = totalEntriesOnPage;
			startNum = (totalEntriesOnPage / 10) * 10 + 1;
		}
	}

	@AfterClass
	void zteardown() {
		driver.quit();
		System.out.println("Browser closed successfully");
	}

	public static void main(String[] args) {
		Scenario1 scenario1 = new Scenario1();
		scenario1.alaunchBrowser();
		scenario1.bgetNumberOfPages();
		scenario1.cgetTotalEntriesOnPage();
		scenario1.dverifyPaginationFormat();
		scenario1.everifyNumberOfRowsOnPage();
		scenario1.zteardown();
	}

}
