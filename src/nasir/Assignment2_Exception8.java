package nasir;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2_Exception8 {
	
	// UnHandledAlertException
		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver_98Version.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("Maximized browser");
			driver.get("http://automationbykrishna.com/");
			driver.findElement(By.partialLinkText("Basic ")).click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(2000);
			WebElement element=driver.findElement(By.xpath("//button[@class='btn btn-success']"));
			element.click();
			//Alert alert=driver.switchTo().alert();
			//alert.accept();
			driver.close();
		}
}
