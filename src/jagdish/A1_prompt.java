package jagdish;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A1_prompt {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.get("http://automationbykrishna.com/");
		System.out.println("Browser launched");
		webdriver.findElement(By.xpath("//a[text() ='Basic Elements']")).click();
		Thread.sleep(3000);
		webdriver.findElement(By.id("javascriptPromp")).click();
		webdriver.switchTo().alert().sendKeys("Jagdish");
		webdriver.switchTo().alert().accept();
		Thread.sleep(2000);
		System.out.println(webdriver.findElement(By.id("pgraphdemo")).getText());
		webdriver.close();
	}
}