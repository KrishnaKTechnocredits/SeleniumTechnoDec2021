package deepak;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A1_Alerts {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");

		driver.findElement(By.xpath("//a[@id = 'basicelements']")).click();
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000);

		System.out.println("1. Simple Alert");
		driver.findElement(By.xpath("//button[@id = 'javascriptAlert']")).click();
		String expectedText = "You must be TechnoCredits student!!";
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		if (actualText.equals(expectedText)) {
			System.out.println("Actual Text and Expected Text are same, i.e. " + actualText);
		}
		alert.accept();
		System.out.println("=======================================================================================");

		System.out.println("2. Java Script Confirmation Alert");
		driver.findElement(By.xpath("//button[@id = 'javascriptConfirmBox']")).click();
		alert = driver.switchTo().alert();
		System.out.println("Text on the alert is: " + alert.getText());
		alert.accept();
		String strOK = driver.findElement(By.xpath("//p[@id = 'pgraphdemo']")).getText();
		System.out.println("Text on click of OK button: " + strOK);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id = 'javascriptConfirmBox']")).click();
		alert = driver.switchTo().alert();
		alert.dismiss();
		String strCANCEL = driver.findElement(By.xpath("//p[@id = 'pgraphdemo']")).getText();
		System.out.println("Text on click of Cancel button: " + strCANCEL);
		System.out.println("=======================================================================================");

		System.out.println("3. Java Script Prompt");
		driver.findElement(By.xpath("//button[@id = 'javascriptPromp']")).click();
		alert = driver.switchTo().alert();
		alert.sendKeys("Deepak");
		alert.accept();
		String strOK1 = driver.findElement(By.xpath("//p[@id = 'pgraphdemo']")).getText();
		System.out.println("Text after sending name to the Alert is: " + strOK1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id = 'javascriptPromp']")).click();
		alert = driver.switchTo().alert();
		alert.dismiss();
		String strCANCEL1 = driver.findElement(By.xpath("//p[@id = 'pgraphdemo']")).getText();
		System.out.println("Text on click of Cancel button: " + strCANCEL1);

	}

}
