/*
    Scenario : 2
    1. Visit "http://automationbykrishna.com/"
    2. Navigate to "Basic element tab"
    3. Perform multi drop down methods(deselect by index/value/text, deselectAll)
*/
package anjali.Assignment_3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class A3_program2_1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		System.out.println("Browser launched");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		
		Thread.sleep(5000);
		
	    /*script to find
		 1 print total Elements present in Dropdown
		 2 print selected Elements
		 3 print non selected elements
		  */
		
		WebElement multidropdown=driver.findElement(By.xpath("//select[@class='form-control']"));
		Select select = new Select(multidropdown);
		
		select.selectByIndex(0);
		select.selectByVisibleText("2");
		select.selectByVisibleText("3");
		
		
		List<WebElement> totaElementInDropDown=select.getOptions(); //we get total Elements present in Dropdown using this method
		for(WebElement AllElement : totaElementInDropDown)
			System.out.println("element in dropdown "+AllElement.getText());
		
		
	    List<WebElement> listofSelectedElement=select.getAllSelectedOptions();//we get selected Elements present in Dropdown using this method
		for(WebElement element : listofSelectedElement)
			System.out.println("selected element"+element.getText());
		
	    totaElementInDropDown.removeAll(listofSelectedElement);//we get Nonselected Elements present in Dropdown using this method
		for(WebElement nonSelectedElement : totaElementInDropDown)
			System.out.println("Nonselected element"+nonSelectedElement.getText());
		
		
	   Thread.sleep(5000);
		
		driver.close();
		

	}

}

