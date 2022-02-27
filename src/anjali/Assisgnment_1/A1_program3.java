/*3. JavaScript Prompt 
    1. Navigate to automation by Krishna
    2. Click on the Basic Elements tab
    3. Click on the “Java Script prompt” tab under “DIFFERENT EXAMPLES OF ALERTS”
    4. Set text “Your Name” and verify that your name should get displayed on UI in the below format
        “Hello harsh! How are you today?
 */
package anjali.Assisgnment_1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A1_program3 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		Thread.sleep(2000);
		
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		driver.switchTo().alert().sendKeys("Hello Anjali");
		driver.switchTo().alert().accept();
		if(driver.findElement(By.xpath("//p[@id='pgraphdemo']")).isDisplayed())
			System.out.println("text displayed: Hello anjali! How are you today?");
		else
			System.out.println("test case failed");
		
		driver.close();
		
	}
	

}
