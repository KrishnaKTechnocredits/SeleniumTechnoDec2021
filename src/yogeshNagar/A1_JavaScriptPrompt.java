package yogeshNagar;

import javax.xml.transform.Source;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/* Assignment - 1: 14th Feb’2022
3. JavaScript Prompt 
    1. Navigate to automation by Krishna
    2. Click on the Basic Elements tab
    3. Click on the “Java Script prompt” tab under “DIFFERENT EXAMPLES OF ALERTS”
    4. Set text “Your Name” and verify that your name should get displayed on UI in the below format
        “Hello harsh! How are you today?
*/


public class A1_JavaScriptPrompt {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("javascriptPromp")).click();
		Thread.sleep(1000);
		Alert al = driver.switchTo().alert();
		al.sendKeys("Yogesh");
		Thread.sleep(1000);
		al.accept();
		Thread.sleep(1000);
		WebElement ele = driver.findElement(By.id("pgraphdemo"));
		if(ele.getText().equals("Hello yogesh! How are you today?"))
			System.out.println("Alert Have text message as "+ "\"Hello yogesh! How are you today?\"");
		driver.quit();
		System.out.println("Browser Closed");
		
	}

}
