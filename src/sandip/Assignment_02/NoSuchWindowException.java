package sandip.Assignment_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NoSuchWindowException {

	public static void main(String[] args) {
		System.getProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/mnjuser/homepage");
		System.out.println("URL Opened");
		driver.findElement(By.xpath("//div[text()='Recruiters']")).click();
		driver.close();
		System.out.println("Window Closed");
		driver.findElement(By.xpath("//a[text()='All Recruiters']")).click();
	}
}
