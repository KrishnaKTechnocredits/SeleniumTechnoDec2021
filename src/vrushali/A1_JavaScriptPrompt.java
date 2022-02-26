/* JavaScript Prompt 
    1. Navigate to automation by Krishna
    2. Click on the Basic Elements tab
    3. Click on the “Java Script prompt” tab under “DIFFERENT EXAMPLES OF ALERTS”
    4. Set text “Your Name” and verify that your name should get displayed on UI in the below format
        “Hello harsh! How are you today?*/

package vrushali;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A1_JavaScriptPrompt {

	void javaScriptPrompt() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[contains(text(), 'Javascript Prompt')]")).click();
		driver.switchTo().alert().sendKeys("Vrushali");
		driver.switchTo().alert().accept();
		System.out.println("JavaScript promp alert accepted");
		String actualText = "Hello Vrushali! How are you today?";

		WebElement element = driver.findElement(By.xpath("//p[@class='help-block'][@id='pgraphdemo']"));
		String expectedText = element.getText();

		if(expectedText.equals(actualText))
			System.out.println("TC passed - String name Vrushali displayed on the UI");
		else
			System.out.println("TC Failed - User entered string does not match with UI text");
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		A1_JavaScriptPrompt javaScriptPropmt = new A1_JavaScriptPrompt();
		javaScriptPropmt.javaScriptPrompt();
	}
}
