package shital.Assignment2_Exceptions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2_ElementClickInterceptedException {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:/Shital Kadam/Techno Credits Dec 2021/Selenium Setup/ChromeDriver_Folder/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js =(JavascriptExecutor)driver;
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		js.executeScript("window.scrollBy(0,250)","");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Alert']")).click();
		Alert alert =driver.switchTo().alert();
		alert.accept();
		alert.getText();
	}
}
