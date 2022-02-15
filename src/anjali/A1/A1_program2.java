package anjali.A1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A1_program2 {
	static void ConfirmationAlert() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000);
		driver.findElement(By.id("javascriptConfirmBox")).click();
		Alert alert= driver.switchTo().alert();
		String ExpectedResult=alert.getText();
		String ActualResult="Are you are doing your homework regularly, Press Okay else Cancel!!";
		if(ActualResult.equals(ExpectedResult)) {
			alert.accept();
			if(driver.findElement(By.xpath("//p[@id='pgraphdemo']")).isDisplayed())
				System.out.println("'You pressed OK!' is displayed Hence test case is passed");
			else
				System.out.println("Test case failed");
		}
		else
			System.out.println("Test case failed");
		
		
		
     /**********************************************************************************************************/
		
		
		driver.findElement(By.id("javascriptConfirmBox")).click();
		ActualResult=driver.switchTo().alert().getText();
		if(ActualResult.equals(ExpectedResult)) {
			driver.switchTo().alert().dismiss();
			if(driver.findElement(By.xpath("//p[@id='pgraphdemo']")).isDisplayed())
				System.out.println("'You pressed cancel!' Hence test case is passed");
			else
				System.out.println("Test case failed");
		}
		else
			System.out.println("Test case failed");
		
		driver.close();
		
			   
	
	}

	public static void main(String[] args) {
		try {
			ConfirmationAlert();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}

}
