package technocredits.screenshotcode;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import technocredits.base.PredefinedActions;

public class ScreenShotForBrowser {

	@Test
	public void testOne() throws Exception {
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/#");
		driver.findElement(By.id("registration2")).click();
		Thread.sleep(2000);

		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
//		String base64 = ts.getScreenshotAs(OutputType.BASE64);
		FileUtils.copyFile(file, new File(
				"D:\\TechnoCredits\\Batches\\Dec21\\SeleniumTechnoDec2021\\" + System.currentTimeMillis() + ".jpeg"));
	
	
		
	
	}
}
