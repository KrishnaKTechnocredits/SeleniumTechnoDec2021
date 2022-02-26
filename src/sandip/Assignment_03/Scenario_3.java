package sandip.Assignment_03;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario_3 {

	public static void main(String[] args) {
		System.getProperty("chromedriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.guru99.com/test/newtours/register.php");
		System.out.println("URL opened");
		driver.manage().window().maximize();

		List<WebElement> list1 = driver.findElements(By.xpath("//select[@name='country']/option"));
		int count = 0;
		for (int index = 1; index <= list1.size(); index++) {
			WebElement element = driver.findElement(By.xpath("//select[@name='country']/option[" + index + "]"));
			String s1 = element.getText();
			if (s1.length() >= 10) {
				System.out.println(s1);
				count++;
			}
		}
		System.out.println("No. of countries :" + count);
	}
}
