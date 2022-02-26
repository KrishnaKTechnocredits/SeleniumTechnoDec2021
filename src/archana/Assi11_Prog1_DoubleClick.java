package archana;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assi11_Prog1_DoubleClick {
	static void Prog2_DoubleClick(WebDriver driver) throws InterruptedException {

		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)", "");
		WebElement ele = driver.findElement(By.xpath("//a[text()='Double-click on me']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).doubleClick(ele).build().perform();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Archana\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='basicelements']")));
		// Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		try {

			Prog2_DoubleClick(driver);
		} catch (InterruptedException b) {

		}
	}
}
