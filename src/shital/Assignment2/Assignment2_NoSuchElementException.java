package shital.Assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2_NoSuchElementException {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:/Shital Kadam/Techno Credits Dec 2021/Selenium Setup/ChromeDriver_Folder/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Registration']")).click();
		driver.findElement(By.xpath("//h1[text()='Login']")).getText();
		driver.close();
		driver.close();
	}


}
