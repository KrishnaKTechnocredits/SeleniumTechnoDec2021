package sagarShrikhande;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import technocredits.base.PredefinedActions;

public class A11_MouseActionsOps {

	void mouseSendDoubleClickAction(WebDriver driver, WebDriverWait wait) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1600)", "");
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(By.xpath("//a[text()='Double-click on me']"))).build().perform();
		Thread.sleep(1000);
		System.out.println("Message on popup is: " + driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("UserFirstName")));
		A11_MouseActionsOps a11 = new A11_MouseActionsOps();
		a11.mouseSendDoubleClickAction(driver, wait);
	}
}

/*
 * Assignment - 11: 24th Feb'2022
 * 
 * Note: Request to use Xpath-Axes & explicit Wait
 * 
 * 1. Double Click a. visit "http://automationbykrishna.com/#" b. click on
 * "Basic Elements" c. scroll down till the element d. peform double click on it
 * e. validate popup shows message as "You successfully double clicked it".
 * 
 * 2. Drag & Drop a. Visit "https://demos.telerik.com/kendo-ui/dragdrop/index"
 * b. verify before move to the big circle text shows as
 * "Drag the small circle here." c. drag small circle to the big circle d. once
 * you drag and drop text getting change to "You did great!"
 * 
 * 3. Right Click a. visit
 * "https://demos.telerik.com/kendo-ui/menu/context-menu" b. right click on
 * first Web Mail c. validate that "replay", "forward" & "label" is getting
 * display
 * 
 */