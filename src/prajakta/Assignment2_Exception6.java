package prajakta;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2_Exception6 {

	// ElementNotInteractableException
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("http://automationbykrishna.com/");
		System.out.println("Browser is launched");
		driver.findElement(By.id("basicelements")).click();
		WebElement element = driver.findElement(By.xpath("//input[@id='UserFirstName']"));
		element.sendKeys("Ahmed");
		driver.close();
		System.out.println("Browser is Closed");

	}
}