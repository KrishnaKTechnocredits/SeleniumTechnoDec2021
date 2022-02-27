
/*Assignment - 11: 24th Feb'2022

Note: Request to use Xpath-Axes & explicit Wait

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

package pallavi;

import java.util.List;

import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import technocredits.base.PredefinedActions;

public class A11_Actions2 {
	
//	1. Double Click
	@Test
	public void doubleClick() {
		System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver_98Version.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait= new WebDriverWait(driver,5);
		
		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.linkText("Basic Elements")).click();;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("UserFirstName")));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1600)","");
		
		Actions action=new Actions(driver);
		action.doubleClick(driver.findElement(By.xpath("//div[@class='form-group']/a[text()='Double-click on me']"))).build().perform();
		
		Alert alert=driver.switchTo().alert();
		System.out.println("Text on Alert after double click : "+alert.getText());
		alert.accept();
		
		driver.close();
	}
	
	//2. Drag & Drop 
	@Test
	public void dragDrop() {
		System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver_98Version.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait= new WebDriverWait(driver, 5);
					
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)","");
		WebElement bigCircle=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("droptarget")));
		
		String actualText=bigCircle.getText();
		String expectedText="Drag the small circle here.";
		if(actualText.equals(expectedText))
			System.out.println("Showing text before drag and drop: "+actualText);
		else
			System.out.println("Text is not showing correctly before drag and drop");
		
		WebElement smallCircle=driver.findElement(By.id("draggable"));
		Actions action= new Actions(driver);
		action.dragAndDrop(smallCircle, bigCircle).build().perform();
		//action.clickAndHold(smallCircle).dragAndDrop(smallCircle, bigCircle).release(smallCircle).build().perform();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='You did great!']"))));
		actualText=bigCircle.getText();
		expectedText="You did great!";
			if(actualText.equals(expectedText))
				System.out.println("Showing text after drag and drop: "+actualText);
			else
				System.out.println("Text is not showing correctly after drag and drop");
		
		driver.close();	
	}
	
	//3. Right Click
	@Test
	public void rightClick() {
		WebDriver driver=PredefinedActions.openBrowser("https://demos.telerik.com/kendo-ui/menu/context-menu");
		WebDriverWait wait=new WebDriverWait(driver, 5);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)", "");
		WebElement webmail=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product k-listview-item'][1]")));
		
		Actions action=new Actions(driver);
		action.contextClick(webmail).build().perform();
		
		
		System.out.println("List of Menu items on right click:");
		List<WebElement>menu=driver.findElements(By.xpath("//ul[@class='k-widget k-reset k-menu k-menu-vertical k-context-menu k-popup k-group k-state-border-up']/li[contains(@class,'k-item k-menu-item')]/span/span[@class='k-menu-link-text']"));
		for(WebElement menuItem:menu) {
			System.out.println(menuItem.getText());
		}
		driver.close();
	}
}

