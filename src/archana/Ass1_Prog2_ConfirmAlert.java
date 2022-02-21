package archana;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ass1_Prog2_ConfirmAlert {
	static void ClickOnOKCancel() throws InterruptedException {		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Archana\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//a[text() ='Basic Elements']")).click();
		System.out.println("Clicked on Basic Elements");
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.id("javascriptConfirmBox")).click();
		Thread.sleep(3000);
		System.out.println("Clicked on Javascript Confirmation");
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.id("pgraphdemo")).getText());

		// Cancel
		driver.findElement(By.xpath("//a[text() ='Basic Elements']")).click();
		System.out.println("Clicked on Basic Elements");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.id("javascriptConfirmBox")).click();
		Thread.sleep(3000);
		System.out.println("Clicked on Javascript Confirmation");
		driver.switchTo().alert().dismiss();
		System.out.println(driver.findElement(By.id("pgraphdemo")).getText());
		driver.quit();

	}

	public static void main(String[] args) throws InterruptedException {
		ClickOnOKCancel();

	}
}
