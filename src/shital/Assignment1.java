package shital;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
	
	void simpleAlert()throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:/Shital Kadam/Techno Credits Dec 2021/Selenium Setup/ChromeDriver_Folder/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js =(JavascriptExecutor)driver;
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,250)","");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='javascriptAlert']")).click();
		Alert alert =driver.switchTo().alert();
		Thread.sleep(2000);
		String alertMessage =alert.getText();
		System.out.println(alertMessage);
		Thread.sleep(2000);
		alert.accept();
		driver.close();
	}
		
	void confirmationAlert() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:/Shital Kadam/Techno Credits Dec 2021/Selenium Setup/ChromeDriver_Folder/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js =(JavascriptExecutor)driver;
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,250)","");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Javascript Confirmation']")).click();
		Alert alert =driver.switchTo().alert();
		Thread.sleep(2000);
		String alertMessage =alert.getText();
		System.out.println(alertMessage);
		Thread.sleep(2000);
		alert.accept();
		String ExpectedMsg="You pressed OK!";
		String originalMsg=driver.findElement(By.xpath("//p[text()='You pressed OK!']")).getText();
		System.out.println("Expected Message is : "+ExpectedMsg);
		System.out.println("original Message is : "+originalMsg);
		Boolean result;
		if(result=originalMsg.contentEquals(ExpectedMsg))
			System.out.println("Both are match");
		else
			System.out.println("Both are not match");		
		driver.close();
	}
	
	void PromptAlert() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:/Shital Kadam/Techno Credits Dec 2021/Selenium Setup/ChromeDriver_Folder/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js =(JavascriptExecutor)driver;
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,250)","");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Javascript Prompt']")).click();
		Alert alert =driver.switchTo().alert();
		alert.sendKeys("Shital");
		Thread.sleep(2000);
		alert.accept();
		String OriginalMsg=driver.findElement(By.xpath("//p[@class='help-block'][@id='pgraphdemo']")).getText();
		System.out.println("Message showing as :"+OriginalMsg);
		driver.close();
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Assignment1 assignment1 =new Assignment1();
		assignment1.simpleAlert();
		assignment1.confirmationAlert();
		assignment1.PromptAlert();
	}
}
