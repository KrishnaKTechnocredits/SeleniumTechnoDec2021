package archana;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ass12_UploadFile {
	static void Prog1_UploadFile(WebDriver driver) throws AWTException, InterruptedException {

		driver.findElement(By.xpath("//section[@class='panel']//div[@class='panel-body']//a[@href='#myModal']"))
				.click();
		
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='exampleInputEmail3']")).sendKeys("archananpawar11@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='exampleInputPassword3']")).sendKeys("@@@@");
		WebElement upload= driver.findElement(By.xpath("//input[@id='exampleInputFile']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",upload );
		
		Thread.sleep(3000);
		StringSelection clipboard = new StringSelection("C:\\customer.txt");
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipboard, null);
		Thread.sleep(4000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(4000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(4000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(6000);
		//driver.findElement(By.xpath("//form[@role='form']//button[text()='Submit']")).click();
		System.out.println("File Upload Successfuly");
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Archana\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='basicelements']")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		try {
			Prog1_UploadFile(driver);
		} catch (AWTException e) {
		}

	}
}
