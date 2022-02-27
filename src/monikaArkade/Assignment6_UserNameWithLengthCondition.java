package monikaArkade;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment6_UserNameWithLengthCondition {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("demotable")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id ='table1']")));

		List<WebElement> element = driver.findElements(By.xpath("//table[@id ='table1']/tbody/tr/td[4]"));
		List<String> output = new ArrayList<String>();
		for (WebElement ele : element) {
			if (ele.getText().length() > 6)
				output.add(ele.getText());
		}
		System.out.println(output);
	}
}
