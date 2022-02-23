package krishna.Assignment_02_Exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_02_03_ElementClickInterceptException {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize(); //If we comment this line then alert will not appear and exception occurs.
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//*[@id=\"basicelements\"]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"javascriptAlert\"]")).click();	
		
	}

}
