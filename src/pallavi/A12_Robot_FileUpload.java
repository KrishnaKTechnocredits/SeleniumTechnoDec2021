/*Assignment - 12: 25th Feb'2022

Note: Request to use Xpath-Axes & explicit  Wait

1. File Upload
	a. visit "http://automationbykrishna.com/#"
	b. click on "Basic Elements"
	c. scroll to the "Form in modal" button
	d. click on first modal button
	e. fill the form & upload any file & submit it.
	*/

package pallavi;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import technocredits.base.PredefinedActions;

public class A12_Robot_FileUpload {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void openBrowser() {
		driver = PredefinedActions.openBrowser("http://automationbykrishna.com/#");
	}

	@Test
	public void uploadFile() throws InterruptedException, AWTException {
		wait = new WebDriverWait(driver, 10);
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("UserFirstName")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		driver.findElement(By.xpath("//a[@class='btn btn-xs btn-info']")).click();
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='exampleInputFile3']"))).click();

		js.executeScript("arguments[0].click()", wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='exampleInputFile3']"))));
		Thread.sleep(1000);

		StringSelection clipboard = new StringSelection(
				"C:\\JavaTution\\GitProjectSelenium\\SeleniumTechnoDec2021\\src\\pallavi\\resources\\Test.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipboard, null);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@aria-hidden='false']//button[@class='close']"))).click();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
