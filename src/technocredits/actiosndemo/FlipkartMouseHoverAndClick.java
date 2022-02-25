package technocredits.actiosndemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import technocredits.base.PredefinedActions;

public class FlipkartMouseHoverAndClick{

	
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.openBrowser("https://www.flipkart.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='_2KpZ6l _2doB4z']")))
				.click();
		WebElement fashion = driver
				.findElement(By.xpath("//img[@alt='Fashion']"));

		//build -> convert multiple actions into single action
		//perform -> execute the build
		Actions action = new Actions(driver);
		action.moveToElement(fashion).build().perform();
		action.click(driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']/child::a")).get(1)).build().perform();
		
	}
}
