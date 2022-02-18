package sagarShrikhande;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class A3_P3_PrintDropDownValue {
	
	void printCountryNames(WebDriver driver, String url) throws InterruptedException {
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Select select = new Select(driver.findElement(By.xpath("//select[@name='country']")));
		List<WebElement> ls = (List<WebElement>) driver.findElements(By.xpath("//select/option"));
		List<String> finalList = new ArrayList();
		for(WebElement ele: ls) {
			if(ele.getText().length()>=10)
				finalList.add(ele.getText());
		}
		System.out.println("Total Number of Countries having name length >=10: "+finalList.size());
		System.out.println("Country Name List:  "+finalList);
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "I:\\Learning\\Eclipse\\Basic Selenium\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://demo.guru99.com/test/newtours/register.php";
		A3_P3_PrintDropDownValue a3_p3 = new A3_P3_PrintDropDownValue();
		a3_p3.printCountryNames(driver, url);
	}
}