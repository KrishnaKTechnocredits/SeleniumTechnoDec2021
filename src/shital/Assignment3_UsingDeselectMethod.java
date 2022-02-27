package shital;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3_UsingDeselectMethod {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:/Shital Kadam/Techno Credits Dec 2021/Selenium Setup/ChromeDriver_Folder/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js =(JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,1200)","");
		Thread.sleep(3000);
		
		WebElement multiOption=driver.findElement(By.xpath("//select[@class='form-control']"));
		Select select=new Select(multiOption);
		System.out.println(select.isMultiple());
		select.selectByIndex(0);
		select.selectByIndex(4);
		select.selectByVisibleText("3");
		Thread.sleep(3000);
		select.deselectAll();
		Thread.sleep(3000);
		select.selectByIndex(0);
		select.selectByIndex(2);
		select.selectByVisibleText("5");
		select.selectByIndex(4);
		Thread.sleep(1000);
		select.deselectByIndex(0);
		select.deselectByVisibleText("5");
		Thread.sleep(3000);
		driver.close();
	}

}
