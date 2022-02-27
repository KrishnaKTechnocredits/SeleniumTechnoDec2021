package sagarShrikhande;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import technocredits.base.PredefinedActions;

public class A9_P2_Youtube {

	Map<String, String> getTitleAndViewsFromYoutubeSong(WebDriver driver, WebDriverWait wait) {
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
		for (int index = 0; index < ls.size(); index++) {
			System.out.println(ls.get(index).getText() + "-->" + views.get(index).getText());
			hs.put(ls.get(index).getText(), views.get(index).getText());
		}
		return hs;
	}

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.openBrowser("http://youtube.com/");
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='search']")));
		A9_P2_Youtube a9p2 = new A9_P2_Youtube();
		System.out.println(a9p2.getTitleAndViewsFromYoutubeSong(driver, wait));
	}
}
/*
 * 2. goto to youttube.com search song and print the song title & views against
 * it.
 */