// 5. print content of all the rows of first table

package anjali.Assisgnsment_5;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import anjali.base.PredefinedActions;

public class P5 {

	void usingNormalWay() throws InterruptedException {
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']//tr")));

		List<WebElement> listOfElement = driver.findElements(By.xpath("//table[@id='table1']//tr"));
		for (WebElement element : listOfElement) {
			System.out.println(element.getText());
		}

		driver.close();
	}

	// usingDynamicXpath
	void usingDynamicXpath() throws InterruptedException {
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']//tr")));

		List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']//tr"));

		for (int i = 1; i <= allRows.size(); i++) {
			List<WebElement> eachRowEachElement = driver.findElements(By.xpath("//table[@id='table1']//tr[" + i + "]"));
			for (WebElement eachElement : eachRowEachElement) {
				System.out.println(eachElement.getText());
			}
		}

		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		P5 p5 = new P5();
		p5.usingNormalWay();
		p5.usingDynamicXpath();
	}

}
