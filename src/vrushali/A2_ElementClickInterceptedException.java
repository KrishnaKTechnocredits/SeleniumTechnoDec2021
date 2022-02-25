package vrushali;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A2_ElementClickInterceptedException {
	public static void main(String[] args) throws InterruptedException {
		

	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	System.out.println("Maximized browser");
	driver.get("file:///C:/Users/Sagar/Downloads/htmlForms/Harsh_Enable_&_Disable.html");
	System.out.println("Browser launched");
	driver.findElement(By.id("myText")).sendKeys("Vrushali"); // it will generate A2_ElementClickInterceptedException
	
	driver.close();
	System.out.println("Browser Closed");
	
}
}
