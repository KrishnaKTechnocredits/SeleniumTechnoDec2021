package yogiraj;

import java.awt.Window;
import java.util.ArrayList;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Assignment3  extends PreDefinedAction 
{
	public void dropdownHandleTwitter() throws InterruptedException
	{
		
		By e= By.xpath("//*[text()= 'Sign up with phone or email']");
				
		WebElement el =PreDefinedAction.waitForElement(e);
		
		el.click();
		
		Thread.sleep(3000);
				
		Select select = new Select(driver.findElement(By.xpath("//*[@class='css-1dbjc4n']//select[1]")));
		
		Thread.sleep(2000);

		select.selectByVisibleText("July");
		
		Select selectDay = new Select(driver.findElement(By.xpath("//*[@class='css-1dbjc4n']/div/div[2]/select")));
		
		selectDay.selectByVisibleText("26");
		
		Select selectYear = new Select(driver.findElement(By.xpath("//*[@class='css-1dbjc4n']/div/div[3]/select")));

		selectYear.selectByVisibleText("1991");
		
		Thread.sleep(5000);
		
	}
	
	public void multipleDropDown() throws InterruptedException
	{
		driver.get("http://automationbykrishna.com");
		
		//driver.get("https://www.guru99.com/scroll-up-down-selenium-webdriver.html");
		
		//driver.navigate().refresh();
		
		By by = By.id("basicelements");
		
		WebElement basicElements = PreDefinedAction.waitForElement(by);
		
		basicElements.click();
		
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver ; 
		
        js.executeScript("window.scrollBy(0,1200)","");
        
        Thread.sleep(2000);
        
        Select multipleSelect = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
        
        multipleSelect.isMultiple();
        
        multipleSelect.selectByIndex(0);
        
        multipleSelect.selectByVisibleText("3");
        
        multipleSelect.selectByVisibleText("4");
        
        Thread.sleep(5000);
        
        multipleSelect.deselectAll();
        
        Thread.sleep(2000);
        
        driver.close();

	}
	
	public void handleGuru99DropDown() throws InterruptedException
	{
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
        js.executeScript("window.scrollBy(0,1200)","");
        
        Thread.sleep(2000);
        
        Select selectCountry = new Select(driver.findElement(By.xpath("//*[@name = 'country']")));
        
        List<WebElement>countryName = selectCountry.getOptions(); 
        
        for(WebElement e : countryName)
        {
        	String s = e.getText();
        	
        	if(s.length()>10)
        	{
        		System.out.println(s);
        	}
        		
        }
	}
	public static void main(String[] args) throws InterruptedException
	{
		PreDefinedAction.openBrowser();
		
		Assignment3 a = new Assignment3();
		
		//a.dropdownHandleTwitter();
		
		//a.multipleDropDown();
		
		a.handleGuru99DropDown();
	}

}
