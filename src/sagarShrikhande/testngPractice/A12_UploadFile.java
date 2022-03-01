package sagarShrikhande.testngPractice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import technocredits.base.PredefinedActions;

public class A12_UploadFile {
	static WebDriver driver;
	static WebDriverWait wait;
	static JavascriptExecutor js;

	@Test
	void fileUploadPractice() throws AWTException, InterruptedException {
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='panel-body']")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#myModal']")));
		driver.findElement(By.xpath("//a[@href='#myModal']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='exampleInputEmail3']")));
		driver.findElement(By.xpath("//input[@id='exampleInputEmail3']")).sendKeys("shrikhandesagar@gmail.com");
		driver.findElement(By.xpath("//input[@id='exampleInputPassword3']")).sendKeys("sagar@1234");
		WebElement chooseFile = driver.findElement(By.xpath("//input[@id='exampleInputFile']"));
		js.executeScript("arguments[0].click()", chooseFile);

		Thread.sleep(4000);
		StringSelection stringSelection = new StringSelection("I:\\Learning\\Notepad\\Assignment3.java");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"myModal\"]//form/button")).click();
		System.out.println("File upload successful");
	}
}

/*
 * 1. File upload : a.*visit "http://automationbykrishna.com/#" b.click on basic
 * elements c.scroll to the "Form in modal" button d. click on first modal
 * button e. fill the form & upload any file & submit it
 */
