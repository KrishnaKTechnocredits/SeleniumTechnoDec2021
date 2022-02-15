package archana;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ass1_Prog1_SimpleAlert {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Archana\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("http://automationbykrishna.com/");
		System.out.println("Welcome to browser");
		Thread.sleep(3000);
		WebElement basicElements = driver.findElement(By.xpath("//a[text() ='Basic Elements']"));
		basicElements.click();
		System.out.println("Clicked on Basic Elements");
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.id("javascriptAlert")).click();
		String str = driver.switchTo().alert().getText();
		if (str.equals("You must be TechnoCredits student!!"))
			System.out.println("Correct Message");
		else
			System.out.println("Incorrect message");
		driver.quit();
	}

}
