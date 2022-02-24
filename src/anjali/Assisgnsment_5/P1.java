//1. how many employee are there in table1? --> 5

package anjali.Assisgnsment_5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import anjali.base.PredefinedActions;

public class P1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']/tbody/tr")));
	    List<WebElement> list = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		System.out.println(list.size() + " employee are there in table1");
		driver.close();

	}
}

