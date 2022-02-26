package yogeshNagar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
1. Double Click
	a. visit "http://automationbykrishna.com/#"
	b. click on "Basic Elements"
	c. scroll down till the element
	d. peform double click on it
	e. validate popup shows message as "You successfully double clicked it".
	
2. Drag & Drop 
	a. Visit "https://demos.telerik.com/kendo-ui/dragdrop/index"
	b. verify before move to the big circle text shows as "Drag the small circle here."
	c. drag small circle to the big circle
	d. once you drag and drop text getting change to "You did great!"
	
3. Right Click
	a. visit "https://demos.telerik.com/kendo-ui/menu/context-menu"
	b. right click on first Web Mail
	c. validate that "replay", "forward" & "label" is getting display
	*/

public class A11_ActionClassMethods {
	void checkdoubleClick() throws InterruptedException {
		WebDriver driver = BaseClass.launchBrowser("http://automationbykrishna.com/#");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(1000);
		action.doubleClick(driver.findElement(By.xpath("//a[contains(text(),'Double-click on me')]"))).build()
				.perform();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		driver.quit();
	}

	void deagAndDrop() {
		WebDriver driver = BaseClass.launchBrowser("https://demos.telerik.com/kendo-ui/dragdrop/index");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='kd-title']")));
		Actions action = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='droptarget']")));
		driver.findElement(By.xpath("//button[text()='Accept Cookies']")).click();
		WebElement sorceElement = driver.findElement(By.xpath("//div[@data-role='draggable']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@data-role='droptarget']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		action.dragAndDrop(sorceElement, targetElement).build().perform();
		System.out.println(targetElement.getText());
		driver.quit();
	}

	void rightClick() {
		WebDriver driver = BaseClass.launchBrowser("https://demos.telerik.com/kendo-ui/menu/context-menu");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='WebMail']")));
		WebElement rightClick = driver.findElement(By.xpath("//div[@class='k-listview-content']/child::div"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Actions action = new Actions(driver);
		action.contextClick(rightClick).build().perform();
		if (driver.findElement(By.xpath("//span[contains(text(),'Reply')]")).isDisplayed() == true
				&& driver.findElement(By.xpath("//span[contains(text(),'Forward')]")).isDisplayed() == true
				&& driver.findElement(By.xpath("//span[contains(text(),'Label')]")).isDisplayed() == true)
			System.out.println("Element Displayed");
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		A11_ActionClassMethods actionMethod = new A11_ActionClassMethods();
		System.out.println("----Programe 1----");
		actionMethod.checkdoubleClick();
		System.out.println();
		System.out.println("----Programe 2----");
		actionMethod.deagAndDrop();
		System.out.println();
		System.out.println("----Programe 3----");
		actionMethod.rightClick();
	}
}
