package technocredits.actiosndemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import technocredits.base.PredefinedActions;

public class RightClickOnElement {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.openBrowser("https://demos.telerik.com/kendo-ui/menu/context-menu");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement rightClickElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='listview-context-menu']/div[1]/div[1]")));

		// build -> convert multiple actions into single action
		// perform -> execute the build

		// mouse & keyboard actions

		Actions action = new Actions(driver);
		action.contextClick(rightClickElement).build().perform();
		List<WebElement> list = driver
				.findElements(By.xpath("//*[@id='menu']/li[contains(@class,'k-item k-menu')]/span"));
		for (WebElement ele : list) {
			System.out.println(ele.getText());
		}
	}
}
