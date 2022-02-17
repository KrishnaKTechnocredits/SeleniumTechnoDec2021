package pradeep.A2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementNotInteractableException {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(
				"file:///D:/Tech%20Boss%20PJ/JAVA%20Selenium/Selenium%20All%20Material/Notes/htmlFormsHarsh/Harsh_Enable_&_Disable.html");
		WebElement disableElement = driver.findElement(By.xpath("//*[@id=\"myText\"]"));
		// There is no Exception on clicking disable element....
		disableElement.click();
		// If we send text on disable element then ElementNotInteractableException To
		// handle this first check it is enabled or not
		if (disableElement.isEnabled())
			disableElement.sendKeys("pradeep");
	}
}
