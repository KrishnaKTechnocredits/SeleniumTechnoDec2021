package technocredits.missingLinks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import technocredits.base.PredefinedActions;

public class IFrameHadnle3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/#");
		driver.findElement(By.id("iframes")).click();
		Thread.sleep(4000);
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@title='site3']"));
		driver.switchTo().frame(frameElement);

		List<WebElement> list = driver.findElements(By.xpath("//li[@class='menuheader'][1]//li"));

		for (WebElement ele : list) {
			System.out.println(ele.getText());
		}

		driver.switchTo().defaultContent(); //main browser
		driver.switchTo().parentFrame();//immediate parent frame
		
		String automationText = driver.findElement(By.xpath("//*[text()='Automation By Krishna']")).getText();
		System.out.println(automationText);

//		driver.close();
//		driver.close();
//
//		driver.quit();
//		driver.close();
	}
}
