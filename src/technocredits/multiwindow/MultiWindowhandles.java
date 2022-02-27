package technocredits.multiwindow;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import technocredits.base.PredefinedActions;

public class MultiWindowhandles {

	@Test
	public void multiWindowHandle() throws InterruptedException {
		WebDriver driver = PredefinedActions.openBrowser("https://www.flipkart.com/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("mobile");

		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath(
				"//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[1]/div[1]/div/div/img"))
				.click();

		String mainWindow = driver.getWindowHandle(); // flipkart.com
		Set<String> multipleWindow = driver.getWindowHandles();// total tab we open from automation

		System.out.println("Main wind: " + mainWindow);
//		for(String cWin : multipleWindow) {
//			
//		}

		Iterator<String> itr = multipleWindow.iterator();
		while (itr.hasNext()) {
			String currentWindow = itr.next();
			if (!mainWindow.equals(currentWindow)) {
				driver.switchTo().window(currentWindow);
				Thread.sleep(2000);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		System.out.println(driver.getTitle());
	}
}
