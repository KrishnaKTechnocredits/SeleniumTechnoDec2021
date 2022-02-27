package anjali.Assignment_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class A3_Program2_2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		System.out.println("Browser launched");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		
		Thread.sleep(5000);
		
		WebElement multidropdown=driver.findElement(By.xpath("//select[@class='form-control']"));
		Select select = new Select(multidropdown);
		
		select.deselectByIndex(0);// No exception came when use deselect method even though element is not selected
		
		select.selectByIndex(0);
		select.selectByVisibleText("2");
		select.selectByVisibleText("3");
		select.selectByVisibleText("4");
		select.selectByVisibleText("5");
		
		Thread.sleep(5000);
	
	    select.deselectByIndex(0);
		select.deselectByIndex(1);
		
		Thread.sleep(5000);
		
	  
		select.deselectAll();
	
	
		Thread.sleep(5000);
		
		driver.close();
		 
	}
				
		
	
		

	}


