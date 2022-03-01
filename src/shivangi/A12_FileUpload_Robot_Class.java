package shivangi;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A12_FileUpload_Robot_Class {
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("basicelements"))).click();
		
		//To click on input file button
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		js.executeScript("arguments[0].click()", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='exampleInputFile']"))));
		
		Thread.sleep(2000);
	
		//ctrl+c --> these two line will copy path to System clipboard 
		StringSelection clipboard = new StringSelection("E:\\Technocredit\\Dec21\\Image\\Session52\\Screenshot_26.png");	// virtually ctrl + c
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipboard, null);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		System.out.println("file successfully uploaded");
		Thread.sleep(2000);
		driver.quit();
	}
}
