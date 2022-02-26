package saurav;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A11_doubleClick {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");

		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("UserFirstName")));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		Actions action = new Actions(driver);
		// driver.findElement(By.xpath("//div[@class='form-group']//child::a")).doubleClick();
		// WebElement web=driver.findElement(By.xpath("//a[text()='Double-click on
		// me']"));
		action.doubleClick(driver.findElement(By.xpath("//a[text()='Double-click on me']"))).build().perform();
		// action.sendKeys(Keys.PAGE_DOWN);
		// Thread.sleep(3000);

		Thread.sleep(3000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.quit();
	}
}
