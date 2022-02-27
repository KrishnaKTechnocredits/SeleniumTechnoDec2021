package tanu;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/*. Drag & Drop 
a. Visit "https://demos.telerik.com/kendo-ui/dragdrop/index"
b. verify before move to the big circle text shows as "Drag the small circle here."
c. drag small circle to the big circle
d. once you drag and drop text getting change to "You did great!"
*/

class Assignment11_prog_2 {
	static void progDragDropFunction(WebDriver driver, WebDriverWait wait) {

		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='droptarget']"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(drag).dragAndDrop(drag, drop).build().perform();
		System.out.println("You did Great!!");

	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\java-selenium\\Eclipse\\SeleniumBasics\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[@class='kd-title']")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		progDragDropFunction(driver, wait);

	}
}
