package monikaArkade;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment9_SongTitleAndViews {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://youtube.com/");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='search']")));

		driver.findElement(By.xpath("//input[@id='search']")).clear();
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("song");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='search-icon-legacy']")));
		driver.findElement(By.xpath("//*[@id='search-icon-legacy']/yt-icon")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='video-title']/yt-formatted-string[1]")));
		List<WebElement> ls = driver.findElements(By.xpath("//*[@id='video-title']/yt-formatted-string"));
		List<WebElement> views = driver.findElements(By.xpath(
				"//*[@id='video-title']/yt-formatted-string//ancestor::div[@id='title-wrapper']//following-sibling::ytd-video-meta-block/div/div[@id='metadata-line']/span[1]"));

		Map<String, String> hs = new LinkedHashMap<String, String>();
		for (int i = 0; i < ls.size(); i++) {
			System.out.println(ls.get(i).getText() + ":" + views.get(i).getText());
			hs.put(ls.get(i).getText(), views.get(i).getText());
		}
		System.out.println(hs);
	}

}
