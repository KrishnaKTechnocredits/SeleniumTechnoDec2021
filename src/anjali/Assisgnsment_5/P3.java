//3. find the first name of user whoes username is 'ppatro' --> priya

package anjali.Assisgnsment_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import anjali.base.PredefinedActions;

public class P3 {
	String program3() throws InterruptedException {
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']/tbody/tr/td[text()='ppatro']/preceding-sibling::td[2]")));
		WebElement element = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr/td[text()='ppatro']/preceding-sibling::td[2]"));
		String output = element.getText();
		driver.close();
		return output;
	}

	public static void main(String[] args) throws InterruptedException {
		P3 p3 = new P3();
		String firstName = p3.program3();
		System.out.println(firstName);
	}

}

