package swati.Swati_Assignment3;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Select_country {

	public static void main(String[] args) throws InterruptedException {
		int counter=0;
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		Thread.sleep(3000);
		WebElement country=driver.findElement(By.xpath("//select[@name='country']"));
		Thread.sleep(3000);
		Select select=new Select(country);
		List<WebElement> ls=select.getOptions();
		List<WebElement> newlist=new ArrayList<WebElement>();
		System.out.println(ls.size());
		for(int i=0;i<ls.size();i++) {
			String count=ls.get(i).getText();
			if(count.length()>10) {
				counter++;
				System.out.println(count);
				newlist.add(ls.get(i));
			}
		}
		System.out.println(newlist.size());
		ls.removeAll(newlist);
		System.out.println("new size "+ls.size());
		System.out.println("-----");
		for(WebElement li:ls) {
			System.out.println(li.getText());
		}
		System.out.println("Total Country with length greater than " +counter);
	}

}
