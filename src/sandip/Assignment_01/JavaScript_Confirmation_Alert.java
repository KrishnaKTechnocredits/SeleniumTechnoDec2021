package sandip.Assignment_01;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript_Confirmation_Alert {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Open URL");
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		System.out.println("Navigate to Baisc ELements");
		driver.findElement(By.linkText("Basic Elements")).click();
		System.out.println("Basic Element executed");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//button[text()='Javascript Confirmation']"));
		element.click();
		System.out.println("xpath found");
		Alert alert = driver.switchTo().alert();
		System.out.println("Switched to Alert");
		System.out.println("Alert Message :" + alert.getText());

		Thread.sleep(2000);
		alert.accept();
		String message = driver.findElement(By.xpath("//p[text()='You pressed OK!']")).getText();
		System.out.println("MESSAGE :" + message);
		System.out.println("Execution Complete");
	}
}