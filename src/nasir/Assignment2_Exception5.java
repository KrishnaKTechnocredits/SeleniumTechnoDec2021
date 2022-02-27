package nasir;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2_Exception5 {
	
	// NoAlertPresentException
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("http://automationbykrishna.com/");
		System.out.println("Browser is launched");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(1500);
		driver.switchTo().alert();
		driver.close();
		System.out.println("Browser is closed");
	}
}
