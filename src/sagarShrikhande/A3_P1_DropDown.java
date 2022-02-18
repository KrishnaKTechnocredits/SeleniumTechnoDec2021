package sagarShrikhande;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class A3_P1_DropDown {
	
	void handleDropDownUsingIndex(WebDriver driver) throws InterruptedException {
		String url= "https://twitter.com/i/flow/signup";
		int index= 4;
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		Select select = new Select(driver.findElement(By.xpath("//*[@id=\'SELECTOR_1\']")));
		select.selectByIndex(index);
		System.out.println("Selected value of Month by"+ index +" is: "+select.getFirstSelectedOption().getText());
	}
	
	void handleDropDownUsingValue(WebDriver driver) throws InterruptedException {
		String url= "https://twitter.com/i/flow/signup";
		String value= "29";
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		Select select = new Select(driver.findElement(By.xpath("//span[text()='Day']")));
		select.selectByValue(value);;
		System.out.println("Selected value of Day by value "+ value +" is: "+select.getFirstSelectedOption().getText());
	}
	
	void handleDropDownUsingVisibleText(WebDriver driver) throws InterruptedException {
		String url= "https://twitter.com/i/flow/signup";
		String visibleText= "2020";
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		Select select = new Select(driver.findElement(By.xpath("//span[text()='Year']")));
		select.selectByValue(visibleText);;
		System.out.println("Selected value of Year by visibleText '"+ visibleText +"' is: "+select.getFirstSelectedOption().getText());
	}
	
	public static void main(String[] args) throws InterruptedException {
		A3_P1_DropDown a3 = new A3_P1_DropDown();
		System.setProperty("webdriver.chrome.driver",  "I:\\Learning\\Eclipse\\Basic Selenium\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		a3.handleDropDownUsingIndex(driver);
		driver.close();
		a3.handleDropDownUsingValue(driver);
		driver.close();
		a3.handleDropDownUsingVisibleText(driver);
		driver.quit();
	}
}
