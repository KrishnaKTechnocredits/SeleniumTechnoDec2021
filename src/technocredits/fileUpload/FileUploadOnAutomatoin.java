package technocredits.fileUpload;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import technocredits.base.PredefinedActions;

public class FileUploadOnAutomatoin extends PredefinedActions {

	public static void main(String[] args) throws AWTException, InterruptedException {
		openBrowser("http://automationbykrishna.com/#");
		waitForElementToVisible(By.id("basicelements")).click();
//		waitForElementToVisible(By.xpath("//input[@id='exampleInputFile']")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", waitForElementToBeClick(By.id("exampleInputFile")));

		Thread.sleep(2000);
		
		// Control+C  -> This will copy to System clipboard
		StringSelection clipbboard = new StringSelection("D:\\Cucumber Run from cmd.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipbboard, null);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
