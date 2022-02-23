package sandip.Assignment_03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Scenario_1 {

	public static void main(String[] args) throws InterruptedException {
		System.getProperty("chromedriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://mobile.twitter.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		System.out.println("URL launched");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Sign up with phone or email']")).click();

		Thread.sleep(2000);
		System.out.println("Switched to signup window");

		Thread.sleep(2000);
		WebElement month = driver.findElement(By.xpath("//select[@id='SELECTOR_1']"));
		Select selectmonth = new Select(month);
		selectmonth.selectByIndex(3);
		System.out.println("Method completed by index");

		WebElement day = driver.findElement(By.xpath("//select[@id='SELECTOR_2']"));
		Select selectday = new Select(day);
		selectday.selectByValue("4");
		System.out.println("Method completed by value");

		WebElement year = driver.findElement(By.xpath("//select[@id='SELECTOR_3']"));
		Select selectyear = new Select(year);
		selectyear.selectByVisibleText("2002");
		System.out.println("method completed by visible text");
		System.out.println("Execution complete");

	}
}
