package yogeshNimbalkar.exceptions;

import java.io.ObjectInputStream.GetField;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A2_ElementClickInterceptedExp {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Browser maximized");
		
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.partialLinkText("Basic ")).click();
		System.out.println("Browser Launched");
// 		element present in DOM but not present in View port		
		driver.findElement(By.xpath("//a[@class='btn btn-xs btn-info']")).click();
		driver.close();
	}
}
