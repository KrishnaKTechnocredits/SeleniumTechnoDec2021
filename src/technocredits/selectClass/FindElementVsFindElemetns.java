package technocredits.selectClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementVsFindElemetns {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.id("registration2")).click();
		Thread.sleep(2000);
//		WebElement ele = driver.findElement(By.id("harshlksd"));
		List<WebElement> listOfEle = driver.findElements(By.id("jhzvlcak"));
		System.out.println(listOfEle.get(1));
	}

}