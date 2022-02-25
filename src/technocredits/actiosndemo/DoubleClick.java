package technocredits.actiosndemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import technocredits.base.PredefinedActions;

public class DoubleClick {

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("basicelements"))).click();
		WebElement doubleElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Double-click on me']")));

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		Actions action = new Actions(driver);
		action.doubleClick(doubleElement).build().perform();
//		action.sendKeys(Keys.PAGE_DOWN);

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("Text On alert : " + alert.getText());
		alert.accept();
	}
}
