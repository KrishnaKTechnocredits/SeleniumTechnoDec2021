package sagarShrikhande;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import technocredits.base.PredefinedActions;

public class A11_P2_DragNDrop {
	
	void performDragNDrop(WebDriver driver, WebDriverWait wait) {
		Actions action = new Actions(driver);
		WebElement source= driver.findElement(By.id("draggable"));
		WebElement target= driver.findElement(By.id("droptarget"));
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		action.dragAndDrop(source, target).build().perform();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='You did great!']"))));
		System.out.println("Output message is : "+ driver.findElement(By.xpath("//div[text()='You did great!']")).getText());
	}

	public static void main(String[] args)  {
		WebDriver driver = PredefinedActions.openBrowser("https://demos.telerik.com/kendo-ui/dragdrop/index");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("droptarget")));
		A11_P2_DragNDrop a11_p2 = new A11_P2_DragNDrop();
		a11_p2.performDragNDrop(driver, wait);
	}
}
