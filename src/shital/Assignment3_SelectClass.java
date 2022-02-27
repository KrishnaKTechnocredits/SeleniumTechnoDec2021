package shital;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3_SelectClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Shital Kadam/Techno Credits Dec 2021/Selenium Setup/ChromeDriver_Folder/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js =(JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		js.executeScript("window.scrollBy(0,250)","");
		driver.findElement(By.xpath("//select[contains(@name,'country')]")).click();
		Thread.sleep(3000);
		WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
		Select selectCountry = new Select(country);
		List<WebElement> countryName = selectCountry.getOptions();
		for(WebElement cnt:countryName) {
				if(cnt.getText().length()>10) {
					System.out.println(cnt.getText());
				}
		}
		driver.close();
	}
	
}
