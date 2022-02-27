package technocredits.missingLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import technocredits.base.PredefinedActions;

public class BrokenLinkCheck {

	@Test
	public void checkBrokenLinks() throws IOException {
		WebDriver driver = PredefinedActions
				.openBrowser("file:///D:/TechnoCredits/Batches/Dec21/SeleniumTechnoDec2021/forms/BrokenLink.html");

		List<WebElement> links = driver.findElements(By.xpath("//body/child::a"));

		for (WebElement ele : links) {
			String link = ele.getAttribute("href");
			URL url = new URL(link);
			URLConnection urlConnection = url.openConnection();
			HttpURLConnection httpConnection = (HttpURLConnection) urlConnection;
			httpConnection.connect();
			if (httpConnection.getResponseCode() >= 400) {
				System.out.println(ele.getText() + " : " + link + " : " + httpConnection.getResponseCode());
			} else {
				System.out.println(ele.getText() + " : Status code : " + httpConnection.getResponseCode());
			}
		}
	}

}
