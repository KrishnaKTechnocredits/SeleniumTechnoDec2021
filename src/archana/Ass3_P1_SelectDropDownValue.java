package archana;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Ass3_P1_SelectDropDownValue {
	static void selectDropDownValue() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Archana\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://twitter.com/i/flow/signup");
		System.out.println("Welcome to browser");
		Thread.sleep(3000);
		WebElement month = driver.findElement(By.xpath("//*[@id='SELECTOR_1']"));
		Select selectMonth = new Select(month);
		selectMonth.selectByIndex(3);
		Thread.sleep(2000);
		WebElement day = driver.findElement(By.xpath("//*[@id='SELECTOR_2']"));
		Select selectDay = new Select(day);
		selectDay.selectByValue("11");
		Thread.sleep(2000);
		WebElement year = driver.findElement(By.xpath("//*[@id='SELECTOR_3']"));
		Select selectyear = new Select(year);
		selectyear.selectByVisibleText("1996");
		//driver.quit();
	}

	public static void main(String[] args) {
		try {
			selectDropDownValue();
		} catch (InterruptedException th) {

		}

	}
}
