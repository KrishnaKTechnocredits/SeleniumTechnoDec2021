/*Simple Alert
    1. Navigate to automation by Krishna
    2. Click on the Basic Elements tab
    3. Click on the “Alert” tab under “DIFFERENT EXAMPLES OF ALERTS”
    4. Verify Alert has “You must be TechnoCredits student!!” Text as a message.*/

package vrushali;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A1_SimpleAlert {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		System.out.println("Browser launched");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("Basic element tab is opened");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[@type='submit' and @id='javascriptAlert']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		System.out.println("clicked on alert");

		Alert alert = driver.switchTo().alert();
		String actualTextOnAlert = "You must be TechnoCredits student!!";
		String expectedTextOnAlert = alert.getText();
		System.out.println(expectedTextOnAlert);
		if(actualTextOnAlert.equals(expectedTextOnAlert)) {
			System.out.println("Alert text is match. Test Case Pass");
			alert.accept();
			driver.close();
		}
		else
			driver.quit();
	}
}
