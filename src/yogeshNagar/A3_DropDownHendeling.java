package yogeshNagar;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*Scenario : 1
1. Visit "https://twitter.com/i/flow/signup"
2. Try to select value from drop down using different method (index, value, visible text)


Scenario : 2
1. Visit "http://automationbykrishna.com/"
2. Navigate to "Basic element tab"
3. Perform multi drop down methods(deselect by index/value/text, deselectAll)

Scenario : 3
1. Visit "https://demo.guru99.com/test/newtours/register.php"
2. Print the only those country name which has length more than 10
*/

public class A3_DropDownHendeling {

	static void scenario1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://twitter.com/i/flow/signup");
		Thread.sleep(2000);

		WebElement month = driver.findElement(By.xpath(("//select[@aria-labelledby='SELECTOR_1_LABEL']")));
		Select monthDropDown = new Select(month);
		monthDropDown.selectByIndex(2);

		WebElement day = driver.findElement(By.xpath(("//select[@aria-labelledby='SELECTOR_2_LABEL']")));
		Select dayDropDown = new Select(day);
		dayDropDown.selectByValue("2");

		WebElement year = driver.findElement(By.xpath(("//select[@aria-labelledby='SELECTOR_3_LABEL']")));
		Select yearDropDown = new Select(year);
		yearDropDown.selectByVisibleText("2022");

		driver.quit();
	}

	static void scenario2() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(1000);
		WebElement ele = driver.findElement(By.xpath(("//select[@class='form-control']")));
		Select multipleSelect = new Select(ele);
		if (multipleSelect.isMultiple()) {
			multipleSelect.selectByIndex(0);
			multipleSelect.selectByVisibleText("2");
			Thread.sleep(2000);
			multipleSelect.deselectAll();
		}
		driver.quit();
	}

	static void scenario3() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		Thread.sleep(2000);
		WebElement wbCountry = driver.findElement(By.name("country"));
		Select country = new Select(wbCountry);
		ArrayList<WebElement> listCountry = new ArrayList<>(country.getOptions());
		for (int index = 0; index < listCountry.size(); index++) {
			if (listCountry.get(index).getText().length() > 10)
				System.out.println(listCountry.get(index).getText());
		}
		driver.quit();

	}

	public static void main(String[] args) throws InterruptedException {
		scenario1();
		scenario2();
		scenario3();
	}
}
