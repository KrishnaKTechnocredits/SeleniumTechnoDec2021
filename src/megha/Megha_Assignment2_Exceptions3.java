package megha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Megha_Assignment2_Exceptions3 {
	
	//NoSuchSessionException
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\QA\\Automation\\SeleniumTechnoDec2021//drivers//chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("http://automationbykrishna.com/");
		System.out.println("Browser is launched");
		driver.findElement(By.id("basicelements")).click();
		driver.close();
		System.out.println("Browser is closed");
		driver.switchTo().alert();
	}
}
