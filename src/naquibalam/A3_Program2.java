package naquibalam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class A3_Program2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("http://automationbykrishna.com/");
		System.out.println("Browser launched");
		Thread.sleep(2000);
		try {
			driver.findElement(By.id("basicelements")).click();
			Thread.sleep(2000);
			Select multiSelectDropDown = new Select(driver.findElement(By.xpath("//select[@multiple]")));
			multiSelectDropDown.selectByVisibleText("1");
			multiSelectDropDown.selectByVisibleText("2");
			multiSelectDropDown.selectByVisibleText("3");
			multiSelectDropDown.selectByVisibleText("4");
			multiSelectDropDown.selectByVisibleText("5");
			Thread.sleep(2000);
			multiSelectDropDown.deselectByIndex(0);
			multiSelectDropDown.deselectByVisibleText("2");
			multiSelectDropDown.deselectAll();
			Thread.sleep(5000);
		}finally {
			driver.close();
			System.out.println("Browser Closed");
		}	
	}
}
