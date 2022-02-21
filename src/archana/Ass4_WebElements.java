package archana;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Ass4_WebElements {
	static void WebElements() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Archana\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.xpath("//span[@role='listbox'][1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h3[text()='Dairy Products']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@role='listbox'][2]")).click();
		List<WebElement> products = driver.findElements(By.xpath("//ul[@id='products_listbox']/li/span"));
		Thread.sleep(4000);

		for (WebElement s : products) {
			// System.out.println(s.getText());
			String pname = s.getText();
			if (pname.length() <= 13)
				System.out.println(pname);
		}
	}
	public static void main(String[] args) {
		try {
			WebElements();
		} catch (InterruptedException e) {

		}
	}

}
