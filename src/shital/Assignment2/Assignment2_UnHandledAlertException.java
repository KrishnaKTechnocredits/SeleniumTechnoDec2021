package shital.Assignment2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2_UnHandledAlertException {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:/Shital Kadam/Techno Credits Dec 2021/Selenium Setup/ChromeDriver_Folder/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js =(JavascriptExecutor)driver;
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		//Thread.sleep(2000);	
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		//Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,250)","");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='javascriptAlert']")).click();
		Alert alert =driver.switchTo().alert();
		//Thread.sleep(2000);
		alert.sendKeys("hi");
		//String alertMessage =alert.getText();
		//System.out.println(alert);
		//Thread.sleep(2000);
		//alert.sendKeys("Hello");
		driver.close();
	}

}
