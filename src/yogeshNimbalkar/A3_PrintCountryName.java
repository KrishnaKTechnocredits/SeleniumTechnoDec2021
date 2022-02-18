package yogeshNimbalkar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class A3_PrintCountryName {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Browser maximized");
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		System.out.println("Browser Launched");
		
		Thread.sleep(3000);
		WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
		Select selectCountry = new Select(country);
		
		List<WebElement> countryList = selectCountry.getOptions();
		System.out.println("Country Names with length more than 10 :");
		for(WebElement element : countryList) {
			String countryName = element.getText();
			if(countryName.length()>10) {
				System.out.println(countryName);
			}
		}
		Thread.sleep(2000);
		driver.quit();
	}
}
