package technocredits.missingLinks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import technocredits.base.PredefinedActions;

public class IFrameHadnle2 {

	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/#");
		driver.findElement(By.id("iframes")).click();
		Thread.sleep(4000);
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@title='site3']"));
		driver.switchTo().frame(frameElement);
		String text = driver.findElement(By.xpath("//h1[contains(text(),'Selenium automates browsers.')]")).getText();
		System.out.println(text);
	}
}
