package archana;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Ass3_P3_PrintCountryNameByLength {
	static void PrintCountryNameByLength() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Archana\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
		Select selectCountry = new Select(country);
		List<WebElement> listCountry = selectCountry.getOptions();
		for (WebElement countryName : listCountry)
			if (countryName.getText().length() > 10)
				System.out.println(countryName.getText());
	}

	public static void main(String[] args) {
		try {
			PrintCountryNameByLength();
		} catch (InterruptedException e) {

		}
	}

}
