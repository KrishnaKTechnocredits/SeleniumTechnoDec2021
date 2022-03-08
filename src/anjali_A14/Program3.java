/*Assignment -14: 1st March'2022
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

package anjali_A14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Program3 {

	WebDriver driver;
	WebElement empElement;
	int age;
	String ageStr;

	@BeforeClass
	void alaunchBrowser() {
		 driver = anjali.base.PredefinedActions.openBrowser("https://datatables.net/examples/styling/bootstrap4");
	}

	@Test(dataProvider = "data")
	void bfindOutAge(String name) throws InterruptedException {
		// String name = "Cara Stevens";
		//String name = "Howard Hatfield";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");

		try {
			//Thread.sleep(2000);
			empElement = driver.findElement(
					By.xpath("//table[@id='example']//tr/td[text()='" + name + "']/following-sibling::td[3]"));
		} catch (NoSuchElementException nsee) {
			WebElement searchEle = driver.findElement(By.xpath("//input[@type='search']"));
			searchEle.sendKeys(name);
			//Thread.sleep(2000);
			empElement = driver.findElement(
					By.xpath("//table[@id='example']//tr/td[text()='" + name + "']/following-sibling::td[3]"));
		}
		ageStr = empElement.getText();
		age = Integer.parseInt(ageStr);

		System.out.println("Age of " + name + " is : " + age);
		System.out.println();
	}

	@DataProvider(name = "data")
	public Object[][] getEmpDataFromDataProvider() {

		Object[][] dataArray = new Object[2][1];

		dataArray[0][0] = "Cara Stevens";
		dataArray[1][0] = "Howard Hatfield";

		return dataArray;
	}

	@AfterClass
	void tearDown() {
		driver.quit();
	}

}