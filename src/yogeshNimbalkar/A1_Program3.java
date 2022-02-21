package yogeshNimbalkar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A1_Program3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
//		Open Basic Elements tab
		driver.findElement(By.linkText("Basic Elements")).click();
//		Click JavaSCriptPrompt button
		driver.findElement(By.xpath("//*[@id='javascriptPromp']")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		alert.sendKeys("Yogesh");
		alert.accept();
		Thread.sleep(2000);
		String message = driver.findElement(By.xpath("//*[@id='pgraphdemo']")).getText();
		System.out.println(message);
		driver.quit();
	}
}
