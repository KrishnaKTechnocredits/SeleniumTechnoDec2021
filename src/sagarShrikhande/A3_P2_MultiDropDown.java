package sagarShrikhande;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class A3_P2_MultiDropDown {
 
	void handleMultiDropDown(WebDriver driver, String url) throws InterruptedException {
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		Select select = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		select.selectByIndex(1);
		select.selectByVisibleText("3");
		select.selectByIndex(3);
		System.out.println("All Selement values are: ");
		List<WebElement> ls = select.getAllSelectedOptions();
		for(WebElement ele : ls)
			System.out.print(ele.getText()+"  ");
		Thread.sleep(3000);
		select.deselectByIndex(1);
		System.out.println("");
		System.out.println("Current selection after removing Index 1 value: ");
		ls = select.getAllSelectedOptions();
		for(WebElement ele : ls)
			System.out.print(ele.getText()+"  ");
		Thread.sleep(3000);
		select.deselectAll();
		ls = select.getAllSelectedOptions();
		System.out.println();
		System.out.println("no of elements selected after deselect all: "+ls.size());
		for(WebElement ele : ls)
			System.out.print(ele.getText()+"  ");
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",  "I:\\Learning\\Eclipse\\Basic Selenium\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "http://automationbykrishna.com";
		A3_P2_MultiDropDown a3_p2 = new A3_P2_MultiDropDown();
		a3_p2.handleMultiDropDown(driver, url);
	}
}
