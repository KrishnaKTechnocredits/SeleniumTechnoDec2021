package jagdish;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class A3_DropDown_2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Browser Maximised");
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("Succesfully Clicked on Basic Element");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		Select select = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		select.selectByIndex(0); //Select 1st index
		Thread.sleep(3000);
		select.selectByIndex(1); //Select 2st index
		Thread.sleep(3000);
		select.selectByIndex(2); //Select 3st index
		Thread.sleep(3000);
		select.deselectByVisibleText("2"); //deselect 2nd index
		Thread.sleep(3000);
		select.deselectByIndex(0);//deselect 1st index
		Thread.sleep(3000);
		select.deselectByVisibleText("3");
		Thread.sleep(3000);
		select.selectByIndex(3);
		select.selectByIndex(4);
		Thread.sleep(3000);
		select.deselectAll();
		System.out.println("Succesfully Task Completed");
	}
}
