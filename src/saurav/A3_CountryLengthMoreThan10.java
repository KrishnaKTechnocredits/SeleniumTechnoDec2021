package saurav;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class A3_CountryLengthMoreThan10 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		System.out.println();
		Thread.sleep(2000);
		System.out.println("browser launched");

		WebElement element = driver.findElement(By.xpath("//select[@name='country']"));
		Thread.sleep(2000);

		Select select = new Select(element);
		List<WebElement> list = select.getOptions();
		for (WebElement ele : list) {
			String countries = ele.getText();
			if (countries.length() > 10)
				System.out.println(countries);
		}
	}
}