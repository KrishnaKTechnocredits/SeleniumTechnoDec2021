//4. print all the header of first table -- > # first name last name username

package anjali.Assisgnsment_5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import anjali.base.PredefinedActions;

public class P4 {
	
	//we can do above program using 2 ways
	
	
	//First way
	static void firstWayVeryImp() throws InterruptedException 
	{
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='panel-body']/table[@id='table1']/thead")));

		List<WebElement> listOfElement = driver.findElements(By.xpath("//div[@class='panel-body']/table[@id='table1']/thead"));
		for (WebElement element : listOfElement) {
			System.out.println(element.getText());
		}

		driver.close();

	}
	
	
	//Second way
	static void seondWayVeryImp() throws InterruptedException 
	{
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']/thead/tr/th")));

		List<WebElement> listOfElement = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		for (WebElement element : listOfElement) {
			System.out.println(element.getText());
		}

		driver.close();

	}

	public static void main(String[] args) throws InterruptedException {
	
		 firstWayVeryImp();
		 seondWayVeryImp();

	}

}

