package megha;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Megha_Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		scenario1();
		scenario2();
		scenario3();

	}

	static void scenario1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"E:\\QA\\Automation\\SeleniumTechnoDec2021\\drivers\\chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");

		driver.get("https://twitter.com/i/flow/signup");
		Thread.sleep(6000);
		System.out.println("Browser is Launched");

		Select dropDownList = new Select(driver.findElement(By.id("SELECTOR_1")));
		dropDownList.selectByValue("6");

		dropDownList = new Select(driver.findElement(By.id("SELECTOR_2")));
		dropDownList.selectByIndex(13);

		dropDownList = new Select(driver.findElement(By.id("SELECTOR_3")));
		dropDownList.selectByVisibleText("1990");

	}

	static void scenario2() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"E:\\QA\\Automation\\SeleniumTechnoDec2021\\drivers\\chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");

		driver.get("http://automationbykrishna.com/");
		Thread.sleep(2000);

		driver.findElement(By.partialLinkText("Basic ")).click();
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		WebElement element = driver.findElement(By.xpath("//select[@class = 'form-control']"));
		Select dropDown = new Select(element);
		/*
		 * Cannot select by Value dropDown.selectByValue("1");
		 */
		dropDown.selectByIndex(4);
		dropDown.selectByVisibleText("3");
		if (dropDown.isMultiple())
			System.out.println("Multiple options selected");
		dropDown.deselectAll();

		dropDown.selectByIndex(1);
		dropDown.deselectByIndex(1);
		dropDown.selectByVisibleText("2");
		dropDown.deselectByVisibleText("2");
	}

	static void scenario3() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"E:\\QA\\Automation\\SeleniumTechnoDec2021\\drivers\\chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");

		driver.get("https://demo.guru99.com/test/newtours/register.php");
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		WebElement countryName = driver.findElement(By.xpath("//select[@name='country']"));
		Select select = new Select(countryName);
		List<WebElement> listOfCountry = select.getOptions();
		for (WebElement countryName1 : listOfCountry) {
			if (countryName1.getText().length() > 10)
				System.out.println(countryName1.getText());
		}
	}

}
