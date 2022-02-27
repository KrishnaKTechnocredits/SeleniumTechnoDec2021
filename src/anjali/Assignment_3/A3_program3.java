/*
     Scenario : 3
     1. Visit "https://demo.guru99.com/test/newtours/register.php"
     2. Pritn the only those country name which has length more than 10
 */
package anjali.Assignment_3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class A3_program3 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		System.out.println("Browser launched");
		Thread.sleep(5000);
		
		WebElement dropdown=driver.findElement(By.xpath("//select[@name='country']"));
		Select select= new Select(dropdown);
		
		List<WebElement> listOfelement=select.getOptions();
		for(WebElement element :listOfelement) 
		{
			if (element.getText().length() >= 10) 
				System.out.println(element.getText());
		}
		
		

		
	}

}
