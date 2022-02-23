package tanu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
/*Scenario : 1
1. Visit "https://twitter.com/i/flow/signup"
2. Try to select value from drop down using different method (index, value, visible text)
Scenario : 2
1. Visit "http://automationbykrishna.com/"
2. Navigate to "Basic element tab"
3. Perform multi drop down methods(deselect by index/value/text, deselectAll)
Scenario : 3
1. Visit "https://demo.guru99.com/test/newtours/register.php"
2. Pritn the only those country name which has length more than 10*/

class Assignment3 {
	static void caseFirst() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\java-selenium\\Eclipse\\SeleniumBasics\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("https://twitter.com/i/flow/signup");
		Thread.sleep(2000);
		System.out.println("Launched browser");
		driver.findElement(By.xpath("//input[@name=\"name\"]")).sendKeys("Tanu");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name=\"phone_number\"]")).sendKeys("9751234874");
		Thread.sleep(2000);
		WebElement month = driver.findElement(By.xpath("//select[@id='SELECTOR_1']"));
		Select selectmonth = new Select(month);
		selectmonth.selectByValue("8");
		Thread.sleep(2000);
		WebElement day = driver.findElement(By.xpath("//select[@id='SELECTOR_2']"));
		Select selectday = new Select(day);
		selectday.selectByIndex(30);
		Thread.sleep(2000);
		WebElement year = driver.findElement(By.xpath("//select[@id='SELECTOR_3']"));
		Select selectyear = new Select(year);
		selectyear.selectByVisibleText("1990");
		driver.close();
	}

	static void caseSecond() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\java-selenium\\Eclipse\\SeleniumBasics\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		System.out.println("Launched browser");
		driver.findElement(By.xpath("//select[@name='country']")).click();
		Thread.sleep(2000);
		WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
		Select selectcountry = new Select(country);
		System.out.println(selectcountry.isMultiple());
		selectcountry.selectByValue("ARMENIA");
		List<WebElement> countrylist = selectcountry.getOptions();
		for (WebElement we : countrylist) {
			if (we.getText().length() > 10) {
				System.out.println(we.getText());
			}
		}
		driver.close();
	}

	static void caseThird() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\java-selenium\\Eclipse\\SeleniumBasics\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("http://automationbykrishna.com/");
		System.out.println("Launched browser");
		driver.findElement(By.xpath("//*[@id='basicelements']")).click();
		System.out.println("Navigate to Basic Element Tab");
		driver.findElement(By.xpath("//*[@id='basicelements']")).getText();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1150)", "");
		WebElement multiple = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select selectMultiple = new Select(multiple);
		System.out.println("Multiple value selection" + selectMultiple.isMultiple());
		Thread.sleep(2000);
		selectMultiple.selectByIndex(0);
		Thread.sleep(2000);
		selectMultiple.selectByVisibleText("2");
		Thread.sleep(2000);
		selectMultiple.selectByVisibleText("3");
		Thread.sleep(2000);
		selectMultiple.deselectByIndex(0);
		List<WebElement> we = selectMultiple.getAllSelectedOptions();
		for (WebElement el : we) {
			System.out.println(el.getText());
		}
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		caseFirst();
		caseSecond();
		caseThird();
	}
}