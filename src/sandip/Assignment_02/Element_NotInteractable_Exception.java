package sandip.Assignment_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Element_NotInteractable_Exception {

	public static void main(String[] args) {
		System.getProperty("chromedriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/PATIL/Downloads/Enable_And_Disable_&_Display_&_Hide.html");
		System.out.println("URL launched");
		driver.findElement(By.xpath("//button[text()='Enable & Disable Button']")).click();
		System.out.println("Text are disabled");
		driver.findElement(By.xpath("//input[@id='myText']")).sendKeys("Sandip");
	}
}
