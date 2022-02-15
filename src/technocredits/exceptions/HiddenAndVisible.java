package technocredits.exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenAndVisible {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("file:///D:/TechnoCredits/Batches/Dec21/HTML_Forms/Hidden_&_Visible.html");
		System.out.println("Browser launched");
		WebElement text = driver.findElement(By.xpath("//a[@id='myP']//i"));

		WebElement hideBtn = driver.findElement(By.xpath("//button[text()='Hide Text field']"));
		WebElement showBtn = driver.findElement(By.xpath("//button[text()='Visiable Text field']"));

		hideBtn.click();
		System.out.println("Is element is displayed : " + text.isDisplayed());
//		showBtn.click();
		String s = "";
		System.out.println("Element text: " + text.getText().length());

		Thread.sleep(3000);
		driver.quit();
		System.out.println("Browser Closed");
	}
}
