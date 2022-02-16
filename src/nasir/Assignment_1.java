package nasir;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_1 {
	void navigation() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver_98Version.exe" );
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://automationbykrishna.com/");
			driver.findElement(By.id("basicelements")).click();
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(2000);
			driver.findElement(By.id("javascriptAlert")).click();
			String expectedText = "You must be TechnoCredits student!!";
			Alert alert = driver.switchTo().alert();
			String actual = alert.getText();
			if (actual.equals(expectedText))
				System.out.println("Actul and expected text are same : " + actual);
			else
				System.out.println("Actual and Expected are not same");
			alert.accept();
			System.out.println("2nd Program - Confirmation Alert..........");
			driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
			Thread.sleep(2000);
			String expectedText1 = "Are you are doing your homework regularly, Press Okay  Cancel!!";
			Alert alert1 = driver.switchTo().alert();
			String actualText1 = alert1.getText();
			System.out.println("Pop up window message " + actualText1);
			if (actualText1.equals(expectedText1)) {
				System.out.println("Actual and Expected get matched, Hence...");
				alert.accept();
				WebElement text = driver.findElement(By.xpath("//p[@id='pgraphdemo']"));
				System.out.println(text.getText());
			} else {
				System.out.println("Text of Pop window does not match, Hence");
				alert.dismiss();
				WebElement text1 = driver.findElement(By.xpath("//p[@id='pgraphdemo']"));
				System.out.println(text1.getText());
			}
	
			System.out.println("3rd Program - JavaScript Prompt ..........");
			driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
			Thread.sleep(2000);
			Alert alert3 = driver.switchTo().alert();
			Thread.sleep(2000);
			alert3.sendKeys("Nasir");
			alert3.accept();
			WebElement text3 = driver.findElement(By.xpath("//p[@id='pgraphdemo']"));
			System.out.println(text3.getText());
		}
	
		public static void main(String[] args) throws InterruptedException {
			Assignment_1 assignment1 = new Assignment_1();
			assignment1.navigation();
	
		}
	}
	


