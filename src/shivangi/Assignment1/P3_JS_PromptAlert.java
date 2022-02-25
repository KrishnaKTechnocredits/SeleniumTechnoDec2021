/*3. JavaScript Prompt 
    1. Navigate to automation by Krishna
    2. Click on the Basic Elements tab
    3. Click on the “Java Script prompt” tab under “DIFFERENT EXAMPLES OF ALERTS”
    4. Set text “Your Name” and verify that your name should get displayed on UI in the below format
        “Hello harsh! How are you today?
*/
package shivangi.Assignment1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_JS_PromptAlert {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.partialLinkText("Basic")).click();
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 250)", "");
		Thread.sleep(2000);
		
		driver.findElement(By.id("javascriptPromp")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Shivangi");
		alert.accept();
		WebElement ele = driver.findElement(By.id("pgraphdemo"));
		if(ele.isDisplayed()) {
			System.out.println(ele.getText());
		}
		driver.quit();
	}
}
