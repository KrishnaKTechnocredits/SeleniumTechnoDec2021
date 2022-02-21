package sandip.Assignment_02;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UnHandledAlertException {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Open URL");
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Basic Elements")).click();
		System.out.println("Basic elements executed");
		
		JavascriptExecutor js = (JavascriptExecutor) driver; //line1
		js.executeScript("window.scrollBy(0,250)", ""); // line2 
		
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
		element.click();
		driver.close();
	}
}
