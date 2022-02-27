package shital;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3_UsingSelectMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Shital Kadam/Techno Credits Dec 2021/Selenium Setup/ChromeDriver_Folder/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js =(JavascriptExecutor)driver;
		driver.get("https://twitter.com/i/flow/signup");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[text()='Sign up with phone or email']")).click();
		driver.findElement(By.xpath("//input[contains(@autocomplete,'name')]")).sendKeys("shital");
		driver.findElement(By.xpath("//input[contains(@autocomplete,'tel')]")).sendKeys("9730261077");
		//js.executeScript("window.scrollBy(0,250)","");
		WebElement month=driver.findElement(By.xpath("//select[contains(@aria-labelledby,'SELECTOR_1_LABEL')]"));
		Select selectedmonth =new Select(month);
		selectedmonth.selectByVisibleText("May");
		
		WebElement day= driver.findElement(By.xpath("//select[contains(@aria-labelledby,'SELECTOR_2_LABEL')]"));
		Select selectedday =new Select(day);
		selectedday.selectByIndex(15);
		
		WebElement year= driver.findElement(By.xpath("//select[contains(@aria-labelledby,'SELECTOR_3_LABEL')]"));
		Select selectedyear =new Select(year);
		selectedyear.selectByValue("2022");
		Thread.sleep(3000);
		
		driver.close();
	}

}
