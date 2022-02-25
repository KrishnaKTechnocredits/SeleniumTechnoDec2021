package saurav;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A11_validateRightClick {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demos.telerik.com/kendo-ui/menu/context-menu");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='kd-title']")));

		Actions action = new Actions(driver);
		WebElement web = driver.findElement(By.xpath("//div[@class='product k-listview-item'][1]"));
		action.moveToElement(web).contextClick(web).build().perform();
		System.out.println(
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='menu']"))).getText());
		System.out.println("All elements are visible");
		driver.quit();
	}
}