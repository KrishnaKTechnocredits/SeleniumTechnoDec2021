package jagdish;

import java.awt.Window;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import shwetaDharmadhikari.base.PredefinedActions;

public class A3_DropDown_1 {

	static void handleDropDownUsingIndex_Value_Text() throws InterruptedException {		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		System.out.println("browser launched");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Create New Account')]")).click();
		Thread.sleep(2000);
		WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
		Select selectDay = new Select(day);
		selectDay.selectByIndex(19);
		System.out.println("The Date is: " + selectDay.getFirstSelectedOption().getText());

		Thread.sleep(2000);
		WebElement selectM = driver.findElement(By.xpath("//select[@id='month']"));
		Select selectMonth = new Select(selectM);
		selectMonth.selectByValue("7");
		System.out.println("The Month is: " + selectMonth.getFirstSelectedOption().getText());

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement slectY = driver.findElement(By.xpath("//select[@id='year']"));
		Select selectYear = new Select(slectY);
		selectYear.selectByVisibleText("2000");
		System.out.println("The Year is: " + selectYear.getFirstSelectedOption().getText());
		Thread.sleep(2000);

		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		handleDropDownUsingIndex_Value_Text();
	}

}
