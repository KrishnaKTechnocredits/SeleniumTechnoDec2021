package monikaArkade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2_NoSuchElementException {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized window");
		driver.get("http://automationbykrishna.com/");
		System.out.println("Browser is launched");
		driver.findElement(By.id("Basic Elements")).click();
		driver.close();
		System.out.println("Broswer is closed");
	}
}
