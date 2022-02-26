//3. find the first name of user whoes username is 'ppatro' --> priya 
package pradeep.A5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pradeep.base.PredefinedActions;

public class Program3 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/index.html");
		driver.findElement(By.linkText("Demo Tables")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']/tbody/tr/td[text()='ppatro']/preceding-sibling::td[2]")));
		System.out.println("first name of user whoes username is 'ppatro' : "+ element.getText());
	}
}
