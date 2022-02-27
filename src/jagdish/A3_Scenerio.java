package jagdish;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class A3_Scenerio {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		Thread.sleep(2000);

		Select select = new Select(driver.findElement(By.xpath("//select[@name='country']")));
		List<WebElement> countryName = select.getOptions();

		for (int index = 1; index < countryName.size(); index++) {
			if (countryName.get(index).getText().length() > 10) {
				System.out.println(countryName.get(index).getText());
			}
		}
	}
}
