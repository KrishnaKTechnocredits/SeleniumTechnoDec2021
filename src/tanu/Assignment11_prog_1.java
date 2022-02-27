package tanu;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

/*1. Double Click
a. visit "http://automationbykrishna.com/#"
b. click on "Basic Elements"
c. scroll down till the element
d. peform double click on it
e. validate popup shows message as "You successfully double clicked it".

*/

class Assignment11_prog_1 {

	static void progForDoubleClick(WebDriver driver, WebDriverWait wait) {
		WebElement doubleclick = driver.findElement(By.xpath("//a[text()='Double-click on me']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(doubleclick).doubleClick().build().perform();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.close();
	}

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\java-selenium\\Eclipse\\SeleniumBasics\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//*[@id='basicelements']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[text()='Double-click on me']")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		progForDoubleClick(driver, wait);

	}
}
