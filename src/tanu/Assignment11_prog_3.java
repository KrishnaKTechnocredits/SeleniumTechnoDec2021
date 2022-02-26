package tanu;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*3. Right Click
a. visit "https://demos.telerik.com/kendo-ui/menu/context-menu"
b. right click on first Web Mail
c. validate that "replay", "forward" & "label" is getting display*/

class Assignment11_prog_3 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\java-selenium\\Eclipse\\SeleniumBasics\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demos.telerik.com/kendo-ui/menu/context-menu");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		WebElement webmail = driver.findElement(By.xpath("//div[@class='product k-listview-item'][1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(webmail).contextClick().build().perform();
		System.out.println("Right Clicked Action perform");

	}
}