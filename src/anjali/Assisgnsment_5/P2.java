//2. how many employee joins company after dhara? --> 2

package anjali.Assisgnsment_5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import anjali.base.PredefinedActions;

public class P2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']/tbody/tr/td[text()='Dhara']/parent::tr/following-sibling::tr")));
		List<WebElement> listOfElement = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[text()='Dhara']/parent::tr/following-sibling::tr"));
	    {
			System.out.println(listOfElement.size()+ " employee joins company after dhara");listOfElement.size();
		}
		driver.close();

	}

}
