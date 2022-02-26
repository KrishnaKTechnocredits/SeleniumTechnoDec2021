package sagarShrikhande;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import technocredits.base.PredefinedActions;

public class A11_P3_RightClickAction {
	void performRightClickAction(WebDriver driver) {
		Actions action = new Actions(driver);
		WebElement target = driver.findElement(By.xpath("//div[@class='product k-listview-item'][1]"));
		action.moveToElement(target).contextClick(target).build().perform();
		if(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='menu']")) != null)
			System.out.println("Successfully perform Right Click Operation");
	}

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.openBrowser("https://demos.telerik.com/kendo-ui/menu/context-menu");
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product k-listview-item'][1]")));
		A11_P3_RightClickAction a11p3 = new A11_P3_RightClickAction();
		a11p3.performRightClickAction(driver);
	}
}
