package yogeshNimbalkar.exceptions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A2_ElementNotInteractableExp1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Browser maximized");
		
		driver.get("d:\\HtmlForms\\Harsh_Enable_&_Disable.html");
		System.out.println("Browser Launched");
		
		Thread.sleep(2000);
//		on disable element we try to execute sendkeys()
		driver.findElement(By.xpath("//input[@id='myText']")).sendKeys("TestData");
		driver.close();
	}
}
