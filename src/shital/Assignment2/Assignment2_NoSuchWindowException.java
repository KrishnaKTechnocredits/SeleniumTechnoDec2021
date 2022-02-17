package shital.Assignment2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2_NoSuchWindowException {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Shital Kadam/Techno Credits Dec 2021/Selenium Setup/ChromeDriver_Folder/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js =(JavascriptExecutor)driver;
		driver.get("https://www.booking.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//*[contains(@data-tooltip-text,'Choose your language')]")).click();
		Thread.sleep(2000);	
		//driver.findElement(By.xpath("//span[text()='Sign in']")).click();
		//driver.findElement(By.xpath("//img[contains(@alt,'Beauty')]")).click();
		//Alert alert =driver.switchTo().alert();
		
		driver.close();
		//driver.findElement(By.xpath("//span[@class='hm-icon-label']")).click();
		//driver.quit();
		
		
	}

}
