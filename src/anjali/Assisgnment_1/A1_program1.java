package anjali.A1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A1_program1 {
	static void SimpleAlert() throws InterruptedException
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
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Alert alert= driver.switchTo().alert();
		String ExpectedResult=alert.getText();
		String ActualResult="You must be TechnoCredits student!!";
		if(ActualResult.equals(ExpectedResult))
		{
			System.out.println("Test case passed");
			alert.accept();
		}
		else
			System.out.println("Test case failed");
		
		driver.close();
	}

	public static void main(String[] args) {
		try {
			SimpleAlert();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
