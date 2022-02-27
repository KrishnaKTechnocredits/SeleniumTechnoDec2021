package sandip.Assignment_03;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Scenario_2 {

	public static void main(String[] args) throws InterruptedException {
		System.getProperty("chromedriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://automationbykrishna.com/");
		System.out.println("URL opened");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Basic Elements")).click();
		System.out.println("Basic Element Clicked");
		JavascriptExecutor js = (JavascriptExecutor) driver; // line1
		js.executeScript("window.scrollBy(0,550)", ""); // line2
		Thread.sleep(2000);

		WebElement multy = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select select = new Select(multy);
		System.out.println("Switched to select mode");
		System.out.println("Multiple Dropdown :" + select.isMultiple());
		select.selectByIndex(0);
		select.selectByVisibleText("3");
		select.selectByVisibleText("5");
		System.out.println("Options selected");

		Thread.sleep(2000);
		select.deselectAll();
		System.out.println("All options deselected");
		System.out.println("Execution Complete");
	}
}
