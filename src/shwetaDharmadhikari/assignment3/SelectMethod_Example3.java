/*Scenario : 3
1. Visit "https://demo.guru99.com/test/newtours/register.php"
2. Pritn the only those country name which has length more than 10
 */
package shwetaDharmadhikari.assignment3;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectMethod_Example3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		driver.manage().window().maximize();
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//select[@name='country']"));
		je.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(2000);
		
		List<WebElement> ls = (List<WebElement>) driver.findElements(By.xpath("//select/option"));
		List<String> outputList = new ArrayList();
		for(WebElement element1: ls) {
			if(element1.getText().length()>=10)
				outputList.add(element1.getText());
		}
		System.out.println("country name which has length more than 10 : "+outputList);
		System.out.println("Count of countries: "+outputList.size());
		driver.close();
	}
}
