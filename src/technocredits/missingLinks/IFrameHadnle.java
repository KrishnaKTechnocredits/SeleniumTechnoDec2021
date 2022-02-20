package technocredits.missingLinks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import technocredits.base.PredefinedActions;

public class IFrameHadnle {

	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/#");
		driver.findElement(By.id("iframes")).click();
		Thread.sleep(4000);
		driver.switchTo().frame(0);
		String text = driver.findElement(By.xpath("//h1[contains(text(),'Selenium automates browsers.')]")).getText();
		System.out.println(text);
	}
}
