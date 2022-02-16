package archana;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Ass3_P2_MultiDropDown {

	static void selectDropDownMultipleValue() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Archana\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		System.out.println("Welcome to browser");
		driver.findElement(By.xpath("//a[text() ='Basic Elements']")).click();
		System.out.println("Clicked on Basic Elements");
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		WebElement multiDrop = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select select = new Select(multiDrop);
		System.out.println(select.isMultiple());
		// Select
		select.selectByIndex(0);
		// select.selectByValue("2");no such element exception
		select.selectByVisibleText("3");
		Thread.sleep(500);
		select.selectByVisibleText("2");
		System.out.println(select.isMultiple());
		// DEselect
		Thread.sleep(500);
		select.deselectByIndex(0);
		Thread.sleep(500);
		select.deselectByVisibleText("2");
		Thread.sleep(500);
		select.deselectByVisibleText("3");
		driver.quit();

	}

	public static void main(String[] args) {
		try {
			selectDropDownMultipleValue();
		} catch (InterruptedException e) {
		}
	}

}
