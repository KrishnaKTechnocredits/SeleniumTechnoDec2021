/*Assignment - 3: 16th Feb’2022

Scenario : 1
1. Visit "https://twitter.com/i/flow/signup"
2. Try to select value from drop down using different method (index, value, visible text)


Scenario : 2
1. Visit "http://automationbykrishna.com/"
2. Navigate to "Basic element tab"
3. Perform multi drop down methods(deselect by index/value/text, deselectAll)

Scenario : 3
1. Visit "https://demo.guru99.com/test/newtours/register.php"
2. Pritn the only those country name which has length more than 10
*/

package pallavi;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownSelect {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://twitter.com/i/flow/signup");
		Thread.sleep(2000);

		Select dropdown = new Select(driver.findElement(By.id("SELECTOR_1")));
		dropdown.selectByValue("4");

		dropdown = new Select(driver.findElement(By.id("SELECTOR_2")));
		dropdown.selectByIndex(16);

		dropdown = new Select(driver.findElement(By.id("SELECTOR_3")));
		dropdown.selectByVisibleText("1986");

		driver.get("http://automationbykrishna.com/");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		Select multiDropDown = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		multiDropDown.selectByIndex(3);
		// multiDropDown.selectByValue("1");
		multiDropDown.selectByVisibleText("2");
		Thread.sleep(1000);
		multiDropDown.deselectAll();

		driver.get("https://demo.guru99.com/test/newtours/register.php");
		dropdown = new Select(driver.findElement(By.xpath("//select[@name='country']")));
		dropdown.getOptions();
		List<WebElement> countieslist = dropdown.getOptions();
		System.out.println("Counties with more than 10 letters in name:");
		for (WebElement country : countieslist) {
			if (country.getText().length() > 10)
				System.out.println(country.getText());
		}
		driver.close();
	}
}
