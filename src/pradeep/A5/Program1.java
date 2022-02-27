//1. how many employee are there in table1? --> 5
package pradeep.A5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pradeep.base.PredefinedActions;

public class Program1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/index.html");
		driver.findElement(By.linkText("Demo Tables")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']/tbody/tr[last()]/td[1]")));
		//Thread.sleep(2000);
		//WebElement ele = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[last()]/td[1]"));
		System.out.println("Total Employee "+ ele.getText());
	}

}
