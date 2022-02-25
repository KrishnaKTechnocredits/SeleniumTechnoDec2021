package vrushali;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A2_NoSuchSessionException {
	public static void main(String[] args) {
		

	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	System.out.println("Maximized browser");
	driver.get("http://automationbykrishna.com/");
	System.out.println("Browser launched");
	driver.findElement(By.id("basicelements")).click(); 
	driver.close();
	System.out.println("Browser Closed");
	driver.close(); // it will generate NoSuchSessionException
}
}
