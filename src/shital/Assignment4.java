package shital;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {
	char ch=' ';

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Shital Kadam/Techno Credits Dec 2021/Selenium Setup/ChromeDriver_Folder/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js =(JavascriptExecutor)driver;
		driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,250)","");
		driver.findElement(By.xpath("//span[contains(@aria-owns,'categories_listbox')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='k-state-default']/h3[text()='Dairy Products']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(@aria-owns,'products_listbox')]")).click();
		Thread.sleep(3000);
		List<WebElement> product=driver.findElements(By.xpath("//ul[@id='products_listbox']/li"));
		System.out.println("all the value from the drop down");
		for(WebElement ele:product) {
			String eleList=ele.getText();
			System.out.println(eleList);
		}
		System.out.println("\n***********************");
		System.out.println("Only those elements which value 13 characters");
		for(WebElement ele:product) {
			String eleList=ele.getText();
			int nameLength=eleList.length();
				if(nameLength>13) {
					System.out.println(eleList);
				}
		}
		driver.close();
	}
}
