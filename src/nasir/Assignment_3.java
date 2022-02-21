package nasir;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_3 {
	
	void twitter() throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.get("https://twitter.com/i/flow/signup");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000);
		WebElement value=driver.findElement(By.xpath("//select[@id='SELECTOR_1']"));
		Select select =new Select(value);
		Thread.sleep(2000);
		select.selectByValue("3");
		System.out.println("Selected Month is "+select.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		WebElement day=driver.findElement(By.xpath("//select[@id='SELECTOR_2']"));
		Select selectDay = new Select(day);
		selectDay.selectByIndex(1);
		System.out.println("Selected Date is "+selectDay.getFirstSelectedOption().getText());
		Thread.sleep(3000);
		WebElement year=driver.findElement(By.xpath("//select[@id='SELECTOR_3']"));
		Select selectYear =new Select(year);
		selectYear.selectByValue("2021");
		System.out.println("Selected Year is "+selectYear.getFirstSelectedOption().getText());		
	}	
	void automationByKrishna() throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		WebElement multiple=driver.findElement(By.xpath("//select[@class='form-control']")); 
		Select selectMultiple=new Select(multiple);
		System.out.println("This is multiple value selection "+selectMultiple.isMultiple());
		selectMultiple.selectByIndex(0);
		Thread.sleep(1000);
		selectMultiple.selectByVisibleText("4");
		Thread.sleep(1000);
		selectMultiple.selectByVisibleText("5");
		Thread.sleep(1000);
		selectMultiple.deselectByVisibleText("5");
		List<WebElement>list=selectMultiple.getAllSelectedOptions();
		for(WebElement ele:list) {
			System.out.println("Selected Value is "+ele.getText());
		}	
	}
	
	void guru99() {
		int count=0;
		WebDriver driver =new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		WebElement country=driver.findElement(By.xpath("//select[@name='country']"));
		Select selectCountry=new Select(country);
		List<WebElement>list=selectCountry.getOptions();
		for(WebElement ele:list) {			
			String countryName=ele.getText();
			if(countryName.length()>10)
				System.out.println(countryName);
				count++;
		}
		System.out.println("Total no. of Country which length more than 10 :- "+count);
	}
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver_98Version.exe");		
		Assignment_3 assignment_3 = new Assignment_3();
		assignment_3.twitter();
		assignment_3.automationByKrishna();
		assignment_3.guru99();
	
		
		
		
		
	}
}
