package monikaArkade;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment5_P5 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");

		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//a[@id='demotable']")))).click();

		List<WebElement> ele = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td"));
		List<String> output = new ArrayList<String>();

		for (WebElement element : ele) {
			output.add(element.getText());
		}
		System.out.println(output);
	}
}
