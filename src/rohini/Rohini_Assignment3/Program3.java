package rohini.Rohini_Assignment3;
/*Scenario : 3
1. Visit "https://demo.guru99.com/test/newtours/register.php"
2. Pritn the only those country name which has length more than 10*/

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Program3 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		
		WebElement cname = driver.findElement(By.xpath("//select[@name='country']"));
		Select select=new Select(cname);
		List<WebElement> list  =select.getOptions();
		int count=0;
		for(WebElement webele:list) {
			if(webele.getText().length()>10) {
				count++;
				System.out.println("Size having greater than 10 "+webele.getText());}
		}
		System.out.println(count);
	}

}
