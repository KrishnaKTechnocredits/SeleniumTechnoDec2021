package technocredits.missingLinks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MissingLink {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///D:/TechnoCredits/Batches/Dec21/HTML_Forms/BlankLinkPractice.html");

		List<WebElement> links = driver.findElements(By.xpath("//a"));
		for (WebElement link : links) {
			String aValue = link.getAttribute("href");
//			System.out.println(link.getText() + " : " + aValue.length());
			if (aValue == null || aValue.equals("")) {
				System.out.println("Missing Link : " + link.getText() + " : " + aValue);
			}

//			link.click();
//			driver.getTitle();
//			driver.navigate().back();
		}
	}
}
