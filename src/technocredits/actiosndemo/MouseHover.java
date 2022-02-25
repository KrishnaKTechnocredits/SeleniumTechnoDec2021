package technocredits.actiosndemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import technocredits.base.PredefinedActions;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.openBrowser("https://www.flipkart.com/");
		WebElement fashion = driver
				.findElement(By.xpath("//div[@class='_37M3Pb']/div[position()=4]//div[position()=2]"));

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='_2KpZ6l _2doB4z']")))
				.click();
		/**
		 * 1. Select -> webelement 2. WebDriverWait -> driver, 10 sec 3. Actions ->
		 * driver
		 */
		/**
		 * 1. moveToElement
		 * 
		 */
		Actions actions = new Actions(driver);
		actions.moveToElement(fashion).build().perform();

		List<WebElement> list = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']/child::a"));
		System.out.println("Size : " + list.size());

		for (WebElement element : list) {
			driver.findElements(
					By.xpath("//span[contains(text(),\"more in " + element.getText() + "\")]/following-sibling::a"));
			System.out.println(element.getText());
		}
	}

}
