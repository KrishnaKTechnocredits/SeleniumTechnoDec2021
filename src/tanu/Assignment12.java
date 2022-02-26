package tanu;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

class Assignment12{	
/*
Note: Request to use Xpath-Axes & explicit  Wait

1. File Upload
	a. visit "http://automationbykrishna.com/#"
	b. click on "Basic Elements"
	c. scroll to the "Form in modal" button////////    //div[@class='panel-body']/a[1]
	d. click on first modal button
	e. fill the form & upload any file & submit it*/
	public static void main(String[] args) throws AWTException, InterruptedException{

		System.setProperty("webdriver.chrome.driver","C:\\java-selenium\\Eclipse\\SeleniumBasics\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//*[@id='basicelements']")).click();
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@name='emailId']")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(5000);
		driver.findElement(By.xpath(" //div[@class='panel-body']/a[1]")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='exampleInputEmail3']")));
		driver.findElement(By.xpath("//input[@id='exampleInputEmail3']")).sendKeys("tanuraj.chouhan@gmail.com");
		driver.findElement(By.xpath("//input[@id='exampleInputPassword3']")).sendKeys("********");
		WebElement upload=driver.findElement(By.xpath("//input[@id='exampleInputFile3']"));
        JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",upload );
		Thread.sleep(5000);
		StringSelection clipboard = new StringSelection("C:\\Users\\rasig\\OneDrive\\Documents\\home.xlsx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipboard, null);
		Robot robot= new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(5000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		System.out.println("File uploded");
		
	
	}
}