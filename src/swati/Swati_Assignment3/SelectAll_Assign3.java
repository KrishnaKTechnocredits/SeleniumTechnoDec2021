package swati.Swati_Assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectAll_Assign3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@id,'basicelements')]")).click();
		Thread.sleep(3000);
		WebElement multi=driver.findElement(By.xpath("//select[@class='form-control']"));
		Thread.sleep(3000);
		Select select=new Select(multi);
		System.out.println(select.isMultiple());
		//select.selectByValue("1");
		select.selectByVisibleText("2");
		select.selectByIndex(0);
		select.deselectAll();
	}

}
