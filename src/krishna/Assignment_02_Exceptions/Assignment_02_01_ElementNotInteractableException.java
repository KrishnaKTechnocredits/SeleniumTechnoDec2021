package krishna.Assignment_02_Exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_02_01_ElementNotInteractableException {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/11332/OneDrive/Desktop/AUTOMATION/SELENIUM/Enable_And_Disable_&_Display_&_Hide.html");
		System.out.println("URL launched");
		driver.findElement(By.xpath("//button[text()='Enable & Disable Button']")).click();
		System.out.println("Text are disabled");
		driver.findElement(By.xpath("//input[@id='myText']")).sendKeys("Krishna");
		driver.close();
	}

}
