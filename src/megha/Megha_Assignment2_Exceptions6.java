package megha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Megha_Assignment2_Exceptions6 {

	// ElementNotInteractableException
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"E:\\QA\\Automation\\SeleniumTechnoDec2021//drivers//chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("E:\\QA\\Selenium forms\\\\Harsh_Enable_&_Disable.html");
		System.out.println("Browser is launched");
		WebElement element = driver.findElement(By.xpath("//input[@id='myText']"));
		element.sendKeys("Megha");
		driver.close();
		System.out.println("Browser is Closed");

	}
}
