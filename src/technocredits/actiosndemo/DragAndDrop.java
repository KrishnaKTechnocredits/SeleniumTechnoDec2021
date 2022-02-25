package technocredits.actiosndemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import technocredits.base.PredefinedActions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.openBrowser("https://demos.telerik.com/kendo-ui/dragdrop/index");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement draggable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggable")));
		WebElement targetLocation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("droptarget")));
		
		// build -> convert multiple actions into single action
		// perform -> execute the build

		// mouse & keyboard actions

		Actions action = new Actions(driver);
		action.clickAndHold(draggable).dragAndDrop(draggable, targetLocation).release(draggable).build().perform();

	}
}
