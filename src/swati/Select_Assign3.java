package swati;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Select_Assign3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://twitter.com/i/flow/signup");
		Thread.sleep(3000);
		WebElement month = driver.findElement(By.xpath("//select[@id=\"SELECTOR_1\"]"));
		Thread.sleep(3000);
		Select select = new Select(month);
		List<WebElement> ls = select.getOptions();
		for (WebElement lsitem : ls)
			System.out.println(lsitem.getText());
		System.out.println(ls.size());
		WebElement day = driver.findElement(By.xpath("//select[@id=\"SELECTOR_2\"]"));
		Thread.sleep(3000);
		select=new Select(day);
		select.selectByValue("2");
		WebElement year=driver.findElement(By.xpath("//select[@id=\"SELECTOR_3\"]"));
		Thread.sleep(3000);
		select=new Select(year);
		select.selectByVisibleText("1973");
		select.deselectByValue("1973");

	}

}
