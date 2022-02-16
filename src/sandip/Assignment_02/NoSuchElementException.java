package sandip.Assignment_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NoSuchElementException {

	public static void main(String[] args) {
		System.getProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Open URL");
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.linkText("Basic Elements")).click();
		System.out.println("Clicked basic elements");
		driver.findElement(By.xpath("//input[@id='wrongUserName']"));
	}
}
