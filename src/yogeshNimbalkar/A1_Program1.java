package yogeshNimbalkar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A1_Program1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("http://automationbykrishna.com/");
//		Open Basic Elements tab 
		driver.findElement(By.partialLinkText("Basic ")).click();
//		Click Alert button
		driver.findElement(By.id("javascriptAlert")).click();
//		Switch to alert window and capture text
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		String actual = alert.getText();
		System.out.println(actual);
		String expected = "You must be TechnoCredits student!!";
		System.out.println("Result = " + expected.equals(actual));
		Thread.sleep(3000);
		alert.accept();
		driver.close();
	}
}
